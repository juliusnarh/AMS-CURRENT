package com.telpo.usb.finger.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.telpo.usb.finger.Finger;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.utils.DataProcessUtil;
import com.telpo.usb.finger.utils.RawToBitMap;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {
    ImageView fp_image;
    Button init, clear_all_tmpl, enroll1, enroll2, enroll3, identify, get_img, read_template, write_template, store_ram,
            read_ram, convert_ISO_to_FPT, convert_FPT_to_ISO, verify_ISO_tmpl, update_tmpl, generate_ram, convert_IMG_to_WSQ, convert_WSQ_to_IMG;

    ProgressDialog progressDialog;
    int rets, bytelength;

    byte[] ISOTmpl = new byte[810];
    byte[] FPTAddr;
    byte[] img_data = new byte[250 * 360];
    int[] TMPL_No = new int[1];
    int[] pnDuplNo = new int[1];
    byte[] wsq_data = new byte[250 * 360];

    byte[] ISOAddrs = new byte[820];

    String tmplstr = "9C7B63ECA1C1C011C6FACAA9FCD448DF587DC637D3550CC74186A2EBDB91D9DFA58365E057E6265895F1F9C6B5C38914ABF4B096016035255F730F014395051D9537AE792E60AA61A4E34729B5A65EE20B02A0DFF6C03429C7DBE74C79AF59F12C231BA04F0C72AF37198C8DB689FDCEA36A515A6E8BA350CAAEC2F74EC75C44326237822DDE7C49645CF2D8969834AD5212855ABD13AB6A1391EACA0A3805C0C0B4B35AEFDFF079733FA9F462CDCB73CF5249D6C39682095F2E5EB10753E0A4A112B1CE8A2E8860E9E207B34D35819F6C4D91C30775E6FC213874A414556B280B554AD4F7E53048A5490AAEE971311CB09A0083D9BF38E10904B9BC5A05E0B9D44B71D44C91271D4EF71CE17B39815B555B83B7FFE1271098191A6BDDDCDBFCD42EEDFBE353D2F0F0C2E0BCE3E773D2956CEAEDF1E4A24E668DBD76030AAA9E8643C45D36EA8DA41C7B0E78B50E9FB949AFCDB8DCCCA9C1A48BA82607504C9E00DD243EA0A2205D1BE966FFAE65DF7DABF99B0B38B63CCA9E3BA4CBDF90FAED78A7B657DA4DD0F69FC9BEB170F99B5AD8D3205596ADB55FA10F9B27A95F3FC645D7BE1EDCA924603C18BF68933E9A2B3B497C946BCB9DF634E6FABF790B573392183C2FB240E3C8E057DA9FA2529924394CADD567C02444FA947249096A72F99CCF21AE6796E07C5E6FD85279756DED42513A8C5468909CC6C6A8091036EBA5";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fp_image = (ImageView) findViewById(R.id.fp_image);
//        //upgradeRootPermission(getPackageCodePath());
//
//		rets = Finger.initialize();
//		if (rets == 0) {
//			System.out.println("Initialization Success");
//			Toast.makeText(this, "Initialize success: "+ String.format("0x%02x", rets), Toast.LENGTH_SHORT).show();
//		} else {
//			System.out.println("Initialization Failed!!!");
//			Toast.makeText(this, "Initialize failed: " + String.format("0x%02x", rets), Toast.LENGTH_SHORT).show();
//		}

//        try
//        {
//            PosUtil.setFingerPrintPower(PosUtil.FINGERPRINT_POWER_ON);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }

        Intent intent = new Intent(this, LoginActivityAlt.class);
        startActivity(intent);
        finish();
    }

    public void onClick(View view) {
        int ret = -1, en_Step;
        switch (view.getId()) {
            case R.id.clear_all_tmpl:
                ret = Finger.clear_alltemplate();
                if (ret == 0) {
                    Toast.makeText(this, "clear_all_tmpl" + String.format("0x%02x", ret) + "Clear success", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "clear_all_tmpl" + String.format("0x%02x", ret) + "Clear failed", Toast.LENGTH_SHORT).show();

                }

                break;
            case R.id.enroll1:
                ret = Finger.get_empty_id(TMPL_No);
                if (ret == 0) {
                    en_Step = 0;
                    ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
                    if (ret == 0) {
                        ret = Finger.get_image(img_data);
                        if (ret == 0) {
                            en_Step = 1;
                            ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
                            if (ret == 0) {
                                Toast.makeText(this, "enroll:" + String.format("0x%02x", ret) + "enroll success", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    }
                }
                Toast.makeText(this, "get_empty_id" + String.format("0x%02x", ret) + ",enroll failed", Toast.LENGTH_SHORT).show();

                break;
            case R.id.enroll2:
                ret = Finger.get_image(img_data);
                if (ret == 0) {
                    en_Step = 2;
                    ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
                    if (ret == 0) {
                        Toast.makeText(this, "enroll:" + String.format("0x%02x", ret) + "enroll success", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(this, "get_image:" + String.format("0x%02x", ret) + "enroll failed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.enroll3:
                ret = Finger.get_image(img_data);
                if (ret == 0) {
                    en_Step = 3;
                    ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
                    if (ret == 0) {
                        en_Step = 4;
                        pnDuplNo[0] = 3;
                        ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
                        if (ret == 0) {
                            Toast.makeText(this, "enroll:" + String.format("0x%02x", ret) + "nroll success", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
                Toast.makeText(this, String.format("0x%02x", ret) + "enroll failed", Toast.LENGTH_SHORT).show();

                break;
            case R.id.identify:
                int[] TMPL_id = new int[1];
                ret = Finger.get_image(img_data);
                if (ret == 0) {
                    ret = Finger.identify(TMPL_id);
                    if (ret == 0) {
                        Toast.makeText(this, String.format("0x%02x", ret) + "success，ID:" + TMPL_id[0], Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(this, String.format("0x%02x", ret) + "failed", Toast.LENGTH_SHORT).show();

                break;
            case R.id.get_img:
                ret = Finger.get_image(img_data);
                if (ret == 0) {
                    Bitmap bmp = RawToBitMap.convert8bit(img_data, 242, 266);
                    saveImage(bmp);
                    if (bmp != null) {
                        fp_image.setImageBitmap(bmp);
                    }
                    return;
                }
                Toast.makeText(this, String.format("0x%02x", ret), Toast.LENGTH_SHORT).show();

                break;
            case R.id.read_template:
                byte[] ppBff = new byte[512];
                int fingerNoId = 1;
                ret = Finger.read_template(fingerNoId, ppBff);
                if (ret == 0) {
                    FPTAddr = ppBff;
                    Log.e("read_template", DataProcessUtil.bytesToHexString(ppBff));
                    Toast.makeText(this, String.format("0x%02x", ret) + "success:" + DataProcessUtil.bytesToHexString(ppBff)
                            , Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(this, String.format("0x%02x", ret) + "fail", Toast.LENGTH_SHORT).show();

                break;
            case R.id.write_template:
                byte[] tmpldata = DataProcessUtil.hexStringToByte(tmplstr);
                int[] dup_ID = new int[1];
                int fingerId = 1;
                ret = Finger.write_template(fingerId, tmpldata, dup_ID);
                if (ret == 0) {
                    Toast.makeText(this, String.format("0x%02x", ret) + "success,ID:" + dup_ID[0], Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(this, String.format("0x%02x", ret) + "fail", Toast.LENGTH_SHORT).show();

                break;
            case R.id.store_ram:
                ret = Finger.get_image(img_data);
                int RamAddr = 0;
                if (ret == 0) {
                    Bitmap bmp = RawToBitMap.convert8bit(img_data, 242, 266);
                    saveImage(bmp);
                    ret = Finger.store_ram(RamAddr, 0);
                    if (ret == 0) {
                        Toast.makeText(this, String.format("0x%02x", ret) + "success", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(this, String.format("0x%02x", ret) + "failed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.read_ram:
                byte[] p_nTmplAddr = new byte[512];
                int RamAddrs = 0;
                ret = Finger.read_ram(RamAddrs, p_nTmplAddr);
                if (ret == 0) {
                    FPTAddr = p_nTmplAddr;
                    saveFile(FPTAddr, "unknow");
                    Log.e("read_ram", DataProcessUtil.bytesToHexString(p_nTmplAddr));
                    Toast.makeText(this, String.format("0x%02x", ret) + " Success:" + DataProcessUtil.bytesToHexString(p_nTmplAddr), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(this, String.format("0x%02x", ret) + "fail", Toast.LENGTH_SHORT).show();
                break;
//			case R.id.convert_ISO_to_FPT:
//				byte[] fptAddr = new byte[810];
//
//				try{
//				//	ISOAddrs = InputStream2ByteArray("lin");
//					ISOAddrs = readFile("bb");
//					int length = readFile("bb").length;
//					Log.e("convert_ISO_to_FPT-", "length:"+length+" \nisoaddr:"+DataProcessUtil.bytesToHexString(ISOAddrs));
//					ret = Finger.convert_ISO_to_FPT_local(fptAddr , ISOAddrs ,length);
//					if (ret == 0) {
//						Log.e("convert_ISO_to_FPT,fpt:", DataProcessUtil.bytesToHexString(fptAddr));
//						Toast.makeText(this, String.format("0x%02x", ret) +" ,Success:" + DataProcessUtil.bytesToHexString(fptAddr), Toast.LENGTH_SHORT).show();
//						byte[] tdata = fptAddr;
//						int[] finger_ID = new int[1];
//						int fId = 1;
//						ret = Finger.write_template(fId, tdata, finger_ID);
//						if (ret == 0) {
//							Toast.makeText(this, String.format("0x%02x", ret) + "ID:"+finger_ID[0] + " ,Success" , Toast.LENGTH_SHORT).show();
//							return;
//						}
//					}
//					Toast.makeText(this, String.format("0x%02x", ret)+"fail" ,Toast.LENGTH_SHORT).show();
//				}catch (Exception e){
//
//				}
//				break;
            case R.id.convert_FPT_to_ISO:
                byte[] ISOAddr = new byte[810];
                try {

                    int[] length = new int[1];
                    ret = Finger.convert_FPT_to_ISO(FPTAddr, ISOAddr, length);
                    if (ret == 0) {
                        ISOTmpl = ISOAddr;
                        saveFile(ISOTmpl, "fingera");
                        Log.e("convert_FPT_to_ISO", DataProcessUtil.bytesToHexString(ISOAddr));
                        Toast.makeText(this, String.format("0x%02x", ret) + ",length: " + length[0] + " Success:" + DataProcessUtil.bytesToHexString(ISOAddr)
                                , Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(this, String.format("0x%02x", ret) + "fail", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {

                }
                break;
            case R.id.verify_ISO_tmpl:
                try {

                    byte[] ISO1 = readFile("bb");
                    //byte[] ISO2 = readFile("fingera");

                    Log.e("verify_ISO_tmpl", "ISO1: " + DataProcessUtil.bytesToHexString(ISO1) + "\nISO2: " + DataProcessUtil.bytesToHexString(ISOTmpl));

                    // ret = Finger.verify_ISO_tmpl(ISO1, ISOTmpl); //ISOTmpl

                    if (ret == 0) {
                        Toast.makeText(this, String.format("0x%02x", ret) + " Success", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(this, String.format("0x%02x", ret) + "fail", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("verify_ISO_tmpl", "ISO2: " + DataProcessUtil.bytesToHexString(ISOTmpl));
                }
                break;
            case R.id.update_tmpl:
                int[] id = new int[1];
                int[] result = new int[1];
                ret = Finger.get_image(img_data);
                if (ret == 0) {
                    ret = Finger.identify(id);
                    if (ret == 0) {
                        ret = Finger.update_tmpl(result);
                        if (ret == 0) {
                            if (result[0] == 1) {
                                Toast.makeText(this, String.format("0x%02x", ret) + "update success", Toast.LENGTH_SHORT).show();
                                return;
                            } else if (result[0] == 0) {
                                Toast.makeText(this, String.format("0x%02x", ret) + "update fail", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    }
                }
                Toast.makeText(this, String.format("0x%02x", ret) + "failed", Toast.LENGTH_SHORT).show();
                break;
//			case R.id.generate_ram:
//				int ramaddr = 2;
//				int count =2;
//				ret = Finger.generate_ram(ramaddr, count);
//				if (ret == 0) {
//					Toast.makeText(this, String.format("0x%02x", ret) + "success:", Toast.LENGTH_SHORT).show();
//					return;
//				}
//				Toast.makeText(this, String.format("0x%02x", ret)+ "fail", Toast.LENGTH_SHORT).show();
//				break;
//			case R.id.convert_IMG_to_WSQ:
//				byte[] img = new byte[250 * 360];
//				int[] wsqlength = new int[252*358];
//				ret = Finger.get_image(img);
//				if (ret == 0) {
//					Log.e("img_data:",DataProcessUtil.bytesToHexString(img));
//					ret = Finger.convert_IMG_to_WSQ(img, wsq_data, wsqlength);
//					if (ret == 0) {
////						Bitmap bmp = RawToBitMap.convert8bit(wsq_data, 242, 266);
////						if (bmp != null) {
////							fp_image.setImageBitmap(bmp);
////						}
//						Log.e("convert_IMG_to_WSQ", DataProcessUtil.bytesToHexString(wsq_data));
//						Toast.makeText(this, String.format("0x%02x", ret) + ",length: " + wsqlength[0] + " Success:" + DataProcessUtil.bytesToHexString(wsq_data)
//								, Toast.LENGTH_SHORT).show();
//						return;
//					}
//				}
//				Toast.makeText(this, String.format("0x%02x", ret)+"fail" ,Toast.LENGTH_SHORT).show();
//
//				break;
//			case R.id.convert_WSQ_to_IMG:
//				int[] imglength = new int[1];
//
//				ret = Finger.convert_WSQ_to_IMG(img_data, wsq_data, imglength);
//				if (ret == 0) {
//					Bitmap bmp = RawToBitMap.convert8bit(img_data, 242, 266);
//					if (bmp != null) {
//						fp_image.setImageBitmap(bmp);
//					}
//					Log.e("convert_WSQ_to_IMG", DataProcessUtil.bytesToHexString(img_data));
//					Toast.makeText(this, String.format("0x%02x", ret) + ",length: " + imglength[0] + " Success:" + DataProcessUtil.bytesToHexString(img_data)
//								, Toast.LENGTH_SHORT).show();
//					return;
//				}
//
//				Toast.makeText(this, String.format("0x%02x", ret)+"fail" ,Toast.LENGTH_SHORT).show();
//				break;
        }
    }

    private byte[] InputStream2ByteArray(String filename) throws IOException {

        InputStream in = getApplicationContext().getAssets().open(filename);
        byte[] data = toByteArray(in);
        in.close();

        return data;
    }

    private byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[810];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }

    /**
     * 从字节数组中获取字节长度
     *
     * @param b
     * @return
     */
    public int getLenFromByte(byte[] b) {
        InputStream in = null;
        in = new ByteArrayInputStream(b);
        int len = 0;
        try {
            len = in.available();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return len;
    }

    private int saveFile(byte[] out, String fileName) {
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + fileName);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(out);
            bufferedOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    private byte[] readFile(String fileName) {
        byte[] buffer = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + fileName);
            if (!(file.exists())) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return buffer;
    }


    /**
     * 显示加载对话框
     *
     * @param message
     */
    public void showLoadingDialog(String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
        }
        progressDialog.setMessage(message);
        progressDialog.show();

    }

    /**
     * 隐藏加载对话框
     */
    public void dismissLoadingDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private void saveImage(Bitmap bmp) {
        File appDir = new File(Environment.getExternalStorageDirectory(), "Boohee");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
