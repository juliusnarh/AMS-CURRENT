package com.telpo.usb.finger.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.common.pos.api.util.posutil.PosUtil;
import com.google.gson.Gson;
import com.orm.SugarRecord;
import com.telpo.usb.finger.Finger;
import com.telpo.usb.finger.Fingerh;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.databinding.ActivityFingerVerifyBinding;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.entities.Userfingerprint;
import com.telpo.usb.finger.pojo.BasicRegistration;
import com.telpo.usb.finger.pojo.BiometricsTaken;
import com.telpo.usb.finger.pojo.FingerprintPojo;
import com.telpo.usb.finger.upload.PostData;
import com.telpo.usb.finger.upload.Uploader;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.DataProcessUtil;
import com.telpo.usb.finger.utils.RawToBitMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.ilhasoft.support.validation.Validator;
import es.dmoral.toasty.Toasty;

public class FingerpirntVerificationActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    int rets, bytelength;
    List<FingerprintPojo> fprints = new ArrayList<>();
    FingerprintPojo fpojo;
    byte[] ISOTmpl = new byte[810];
    byte[] FPTAddr;
    byte[] img_data = new byte[250 * 360];
    byte[] ISO1 = new byte[890];
    byte[] ISO2 = new byte[890];
    Boolean ISSoft;


    int[] TMPL_No = new int[1];
    int[] pnDuplNo = new int[1];
    byte[] wsq_data = new byte[250 * 360];
    byte[] ISOAddrs = new byte[820];

    HashMap<String, FingerprintPojo> hash = new HashMap<>();
    String currentFingerType = "";

    int count = 1;
    boolean enrollstatus = false;

    String tmplstr =
            "9C7B63ECA1C1C011C6FACAA9FCD448DF587DC637D3550CC74186A2EBDB91D9DFA58365E057E6265895F1F9C6B5C38914ABF4B096016035255F730F014395051D9537AE792E60AA61A4E34729B5A65EE20B02A0DFF6C03429C7DBE74C79AF59F12C231BA04F0C72AF37198C8DB689FDCEA36A515A6E8BA350CAAEC2F74EC75C44326237822DDE7C49645CF2D8969834AD5212855ABD13AB6A1391EACA0A3805C0C0B4B35AEFDFF079733FA9F462CDCB73CF5249D6C39682095F2E5EB10753E0A4A112B1CE8A2E8860E9E207B34D35819F6C4D91C30775E6FC213874A414556B280B554AD4F7E53048A5490AAEE971311CB09A0083D9BF38E10904B9BC5A05E0B9D44B71D44C91271D4EF71CE17B39815B555B83B7FFE1271098191A6BDDDCDBFCD42EEDFBE353D2F0F0C2E0BCE3E773D2956CEAEDF1E4A24E668DBD76030AAA9E8643C45D36EA8DA41C7B0E78B50E9FB949AFCDB8DCCCA9C1A48BA82607504C9E00DD243EA0A2205D1BE966FFAE65DF7DABF99B0B38B63CCA9E3BA4CBDF90FAED78A7B657DA4DD0F69FC9BEB170F99B5AD8D3205596ADB55FA10F9B27A95F3FC645D7BE1EDCA924603C18BF68933E9A2B3B497C946BCB9DF634E6FABF790B573392183C2FB240E3C8E057DA9FA2529924394CADD567C02444FA947249096A72F99CCF21AE6796E07C5E6FD85279756DED42513A8C5468909CC6C6A8091036EBA5";


    ActivityFingerVerifyBinding binding;
    byte[] verify;
    String farmerid;
    Validator validator;
    BasicRegistration basicreg;
    BiometricsTaken bio;
    private Uploader uploader;
    private PostData postData;
    private Gson gson;
    private String uploadstring;
    private String jsonstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_finger_verify);
        basicreg = new BasicRegistration();
        binding.setBasicinfo(basicreg);
        bio = new BiometricsTaken();
        binding.setBioinfo(bio);
        validator = new Validator(binding);

        binding.loadrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadProfilePage(farmerid);
            }
        });
        initializeFingerprintDevice();

//        binding.info.setText("Place finger on sensor to verify");
////        new OpenTask().execute();
//
//        rets = Finger.initialize();
//
//        if (rets == 0)
//        {
//            Toasty.success(this, "Device Initialized Successfully", Toast.LENGTH_SHORT, true)
//                  .show();
//        } else
//        {
//            Toasty.error(this, "Error Initializing Device", Toast.LENGTH_SHORT, true).show();
//        }
    }

    public void initializeFingerprintDevice() {
        rets = Fingerh.initialize();

        if (rets == 0) {
            Log.e("yw", "NOT SOFT");
            ISSoft = false;
            Toasty.success(this, "Device Initialized Successfully", Toast.LENGTH_SHORT, true)
                    .show();
        } else {
            byte[] init = new byte[250 * 360];
            rets = Finger.initialize(init);
            if (rets == 0) {
                Log.e("yw", "SOFT");
                ISSoft = true;
                Toasty.success(this, "Device Initialized Successfully", Toast.LENGTH_SHORT, true)
                        .show();
            } else {
                Toasty.error(this, "Error Initializing Device", Toast.LENGTH_SHORT, true).show();
            }

        }

    }

    //method to load profile page
    public void loadProfilePage(String farmerid) {
        Intent intent = new Intent(getBaseContext(), ProfileActivity.class);
        intent.putExtra("farmerid", farmerid);
        startActivity(intent);
        finish();
    }

    public void onBackClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("fingerprint", true);
        setResult(RESULT_OK, intent);
        finish();
    }

    //method to get fingertemplate byte
    public byte[] getFingerTemplate(String fingertype) {
        for (Iterator<Map.Entry<String, FingerprintPojo>> it = hash.entrySet().iterator(); it
                .hasNext(); ) {
            Map.Entry<String, FingerprintPojo> entry = it.next();
            if (entry.getKey().equals(fingertype)) {
                return entry.getValue().getFingertemplate();
            }
        }
        return null;
    }

    public void onVerify(View view) {
        //enroll fingerprint first, get the template and use the template for verification
        //verification task is called from fingerprint enrollment task
        if (validator.validate()) {
            new FingerprintEnrollmentTaskNew().execute();
        }
    }

    //    //method to save enrolled fingerprints to preferencefile
//    public void onSave(View view)
//    {
//        try
//        {
//            verifyFingerprints(getFingerTemplate("RIGHT THUMB"), getFingerTemplate("LEFT THUMB"));
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            Toasty.error(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
//        }
//
//    }
//
    //method to verify two fingerprints
    public int verifyFingerprints(byte[] ISO1, byte[] ISO2) {
        final int ret;
        if (ISSoft) {
            int[] isoresult = new int[1];
            ret = Finger.verify_ISO_tmpl(ISO1, ISO2, isoresult); //ISOTmpl
            if (ret == 0) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toasty.success(FingerpirntVerificationActivity.this, "Verified Successfully", Toast.LENGTH_SHORT).show();
                    }
                });
                return 0;
            } else {
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toasty.error(FingerpirntVerificationActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } else {
            ret = Fingerh.verify_ISO_tmpl(ISO1, ISO2); //ISOTmpl
            if (ret == 0) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toasty.success(FingerpirntVerificationActivity.this, "Verified Successfully", Toast.LENGTH_SHORT).show();
                    }
                });

                return 0;
            } else {
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toasty.error(FingerpirntVerificationActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }
//        int ret;
//        try
//        {
//            ret = Finger.verify_ISO_tmpl(ISO1, ISO2); //ISOTmpl
//
//            if (ret == 0)
//            {
////                Toast.makeText(this, String.format("0x%02x", ret) + " Success", Toast
////                        .LENGTH_SHORT).show();
//                return 0;
//            }
////            Toast.makeText(this, String.format("0x%02x", ret) + "fail", Toast.LENGTH_SHORT).show();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            Log.e("verify_ISO_tmpl", "ISO2: " + DataProcessUtil.bytesToHexString(ISO2));
//        }
        return -1;
    }

//    public void onEnroll(View view)
//    {
//        try
//        {
//            //enroll fingerprint first, get the template and use the template for verification
//            //verification task is called from fingerprint enrollment task
//            new FingerprintEnrollmentTask().execute();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//    }

    //method to write template to memory
    public int writeTemplate() {
        byte[] tmpldata = DataProcessUtil.hexStringToByte(tmplstr);
        int[] dup_ID = new int[1];
        int fingerId = 1;
        return Finger.write_template(fingerId, tmpldata, dup_ID);
    }

    //method to clear all fingerprint templates
    public void clearFingerTemplates() {
        int rest = Finger.clear_alltemplate();
        if (rest == 0) {
            ISOTmpl = new byte[810];
            FPTAddr = null;
            img_data = new byte[250 * 360];
            TMPL_No = new int[1];
            pnDuplNo = new int[1];
        } else {
            Toasty.error(this, "Error Clearing Fingerprints").show();

        }
    }

    //method to read fingerprint template after successfull enrollment
    public boolean readFingerTemplate() {
        int ret;
        byte[] ppBff = new byte[512];
        int fingerNoId = 1;
        ret = Finger.read_template(fingerNoId, ppBff);
        if (ret == 0) {
            FPTAddr = null;
            FPTAddr = ppBff;
            return true;
        }
        Toast.makeText(this, "Failed to read template", Toast.LENGTH_SHORT).show();
        return false;
    }

    //method to convert template to ISO
    public boolean convertTemplateToISO() {
        int ret;
        byte[] ISOAddr = new byte[810];
        try {
            int[] length = new int[1];
            ret = Finger.convert_FPT_to_ISO(FPTAddr, ISOAddr, length);
            if (ret == 0) {
                ISOTmpl = ISOAddr;
                //saveFile(ISOTmpl, "fingera");
                Log.e("convert_FPT_to_ISO", DataProcessUtil.bytesToHexString(ISOAddr));
                //Toasty.success(this, "FPT TO ISO Success", Toast.LENGTH_SHORT).show();
                return true;
            }
            Toast.makeText(this, "FPT TO ISO fail", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

        }
        return false;
    }

    //method to clear all templates
    public void onClearAll(View view) {
        int ret, en_Step;

        try {
            binding.fpImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_finger_ex));

            binding.info.setText("Place finger on sensor to verify");

            basicreg = new BasicRegistration();
            binding.setBasicinfo(basicreg);

            bio = new BiometricsTaken();
            bio.photourl.set("");
            binding.setBioinfo(bio);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ret = Finger.clear_alltemplate();
        if (ret == 0) {
            Toasty.success(this, "Templates Cleared Successfully").show();

        } else {
            Toasty.error(this, "Error Clearing Template(s)").show();

        }
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

    //method to load farmer information
    public void loadFarmerInformation(String farmerid) {
        List<Farmers> farmers = SugarRecord.find(Farmers.class, "farmerid=?", farmerid.trim());
        if (!farmers.isEmpty()) {
            Farmers farmer = farmers.get(0);
            basicreg.firstname.set(farmer.getOthername());
            basicreg.surname.set(farmer.getSurname());
            basicreg.nationality.set(farmer.getCountry());
            basicreg.telephone.set(farmer.getTel());
            basicreg.idnumber.set(farmer.getIdcardno());
            binding.info.setText("Verified Successfully");
        }

        List<Userbiometrics> userbiometrics = Userbiometrics.find(Userbiometrics.class, "farmerid = ?", farmerid);
        if (!userbiometrics.isEmpty()) {
            AndroidUtils.setImageViewResource(binding.photo, userbiometrics.get(0).getPicture());
        }
    }

    //method to load all fingerprints
    public List<Userfingerprint> loadAllFingerprints(String input) {
        try {
            List<Farmers> farmerlist = Farmers.findWithQuery(Farmers.class, "select * from farmers where tel like '%" + input + "%' or farmerid = '" + input + "' or idcardno = '" + input + "' limit 1");
            if (farmerlist.size() > 0)
                return Userfingerprint.findWithQuery(Userfingerprint.class, "select * from userfingerprint where farmerid = '" + farmerlist.get(0).getFarmerid() + "' ");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
//        runOnUiThread(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                Toasty.info(FingerpirntVerificationActivity.this, "No Fingerprints: ");
//            }
//        });
    }

    private class FingerprintVerificationTask extends AsyncTask<Void, Void, Void> {
        String status = "error";
        String fingerprint = currentFingerType;
        byte[] fingertemplate = fprints.get(0).getFingertemplate();
        int outcome = -1;
        int i = 0;
        Userfingerprint finger;

        //String farmerid = "";
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            AndroidUtils.showProgressDialog(FingerpirntVerificationActivity.this, "Verifying Finger...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Log.i("FingerPrint", "FingerPrint Verification!!!");
            final List<Userfingerprint> iterlist = loadAllFingerprints(binding.verifyid.getText().toString());

//                        runOnUiThread(new Runnable()
//            {
//                @Override
//                public void run()
//                {
//                    Toasty.info(FingerpirntVerificationActivity.this, "Size of Fingerprints: "+iterlist.size()).show();
//                }
//            });

            for (Userfingerprint finger : iterlist) {
                try {
                    outcome = verifyFingerprints(ISO1, finger.getFingerprinttemplate());
                    if (outcome == 0) {
                        farmerid = finger.getFarmerid();
                        break;
                    }
                } catch (Exception e) {
                    //Toasty.error(FingerpirntVerificationActivity.this, e.getMessage()).show();
                    e.printStackTrace();
                }
                i++;
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toasty.info(FingerpirntVerificationActivity.this, "Size of Fingerprints: " + i).show();
                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (outcome == 0) {
                //Toasty.success(FingerpirntVerificationActivity.this, "Farmer Verified "+farmerid, Toast.LENGTH_LONG).show();
                runOnUiThread(new Runnable() {
                    public void run() {
                        loadFarmerInformation(farmerid);
                    }
                });
            } else {
                Toasty.error(FingerpirntVerificationActivity.this, "Error Verifying Farmer " +
                        fingerprint).show();
                binding.info.setText("Error Verifying " + fingerprint);
            }
            AndroidUtils.dismissProgressDialog();
            super.onPostExecute(result);
        }
    }

    private class FingerprintEnrollmentTaskNew extends AsyncTask<Void, Void, Void> {
        String status = "error";
        String fingerprint = currentFingerType;
        Bitmap bmp;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            AndroidUtils.showProgressDialog(FingerpirntVerificationActivity.this, "Verifying " +
                    "Finger...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Log.i("FingerPrint", "FingerPrint Verification!!!");
            int ret, en_Step;

            fprints.clear();
            //fprints = new ArrayList<>();
            if (ISSoft) {
                ret = Finger.get_image(img_data);
                if (ret == 0) {
                    bmp = RawToBitMap.convert8bit(img_data, 242, 266);
                    if (bmp != null) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                binding.fpImage.setImageBitmap(bmp);
                            }
                        });
                        //ivFinger1.setImageBitmap(bmp);
                    }
                    int[] length = new int[1];
                    byte[] quality = new byte[1];
                    ret = Finger.get_ISO2005(ISO1, length, quality);
                    if (ret == 0) {
                        Log.i("FingerPrint", "Successfully Scanned Fingerprint!!!");
                        //Toast.makeText(this, "SUCCESS ", Toast.LENGTH_SHORT).show();
                        fpojo = new FingerprintPojo(AndroidUtils.bitmapToByteArray(bmp), ISO1, currentFingerType, true);
                        fprints.add(fpojo);
                        currentFingerType = "";
                        status = "success";

                    }
                }
            } else {
                ret = Fingerh.get_image(img_data);
                if (ret == 0) {
                    bmp = RawToBitMap.convert8bit(img_data, 242, 266);
                    if (bmp != null) {
                        runOnUiThread(new Runnable() {
                            public void run() {
//                                Bitmap bmp = RawToBitMap.convert8bit(img_data, 242, 266);
//                                if (bmp != null)
//                                {
                                binding.fpImage.setImageBitmap(bmp);
//                                }
                            }
                        });
                        //ivFinger1.setImageBitmap(bmp);
                    }
                    int RamAddr = 0;
                    ret = Fingerh.store_ram(RamAddr, 0);
                    if (ret == 0) {
                        byte[] p_nTmplAddr = new byte[512];
                        int RamAddrs = 0;
                        ret = Fingerh.read_ram(RamAddrs, p_nTmplAddr);
                        if (ret == 0) {
                            int[] length = new int[1];
                            ret = Fingerh.convert_FPT_to_ISO(p_nTmplAddr, ISO1, length);
                            if (ret == 0) {
                                Log.i("FingerPrint", "Successfully Scanned Fingerprint!!!");
                                fpojo = new FingerprintPojo(AndroidUtils.bitmapToByteArray(bmp), ISO1, currentFingerType, true);
                                fprints.add(fpojo);
                                currentFingerType = "";
                                status = "success";

                            }
                        }
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (status.equalsIgnoreCase("success")) {
                AndroidUtils.dismissProgressDialog();
                new FingerprintVerificationTask().execute();

            } else {
                Toasty.error(FingerpirntVerificationActivity.this, "Error Enrolling " + fingerprint).show();
                //clearFingerTemplates();
                //Finger.clear_alltemplate();
                //binding.info.setText("Error Enrolling " + fingerprint);
            }
            AndroidUtils.dismissProgressDialog();
            super.onPostExecute(result);
        }
    }


    private class FingerprintEnrollmentTask1 extends AsyncTask<Void, Void, Void> {
        String status = "error";
        String fingerprint = currentFingerType;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            AndroidUtils.showProgressDialog(FingerpirntVerificationActivity.this, "Verifying " +
                    "Finger...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Log.i("FingerPrint", "FingerPrint Verification!!!");
            int ret, en_Step;

            fprints.clear();
            //fprints = new ArrayList<>();

            for (int count = 1; count <= 3; count++) {
                switch (count) {
                    case 1:
//                        try
//                        {
                        Finger.clear_alltemplate();
                        //clearFingerTemplates();
//                        }
//                        catch (Exception e)
//                        {
//                            runOnUiThread(new Runnable()
//                            {
//                                @Override
//                                public void run()
//                                {
//                                    Toasty.error(FingerpirntVerificationActivity.this, "Error").show();
//                                }
//                            });
//                        }
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
                                        runOnUiThread(new Runnable() {
                                            public void run() {
                                                Bitmap bmp = RawToBitMap.convert8bit(img_data, 242, 266);
                                                if (bmp != null) {
                                                    binding.fpImage.setImageBitmap(bmp);
                                                }
                                            }
                                        });
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        ret = Finger.get_image(img_data);
                        if (ret == 0) {
                            en_Step = 2;
                            ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
                            if (ret == 0) {
                                break;
                            }
                        }
                        break;
                    case 3:
                        ret = Finger.get_image(img_data);
                        if (ret == 0) {
                            en_Step = 3;
                            ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
                            if (ret == 0) {
                                en_Step = 4;
                                pnDuplNo[0] = 3;
                                ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
                                if (ret == 0) {
                                    Bitmap bmp = RawToBitMap.convert8bit(img_data, 242, 266);

                                    //write template data
                                    if (readFingerTemplate()) {
                                        //read template data from memory
                                        if (writeTemplate() == 0) {
                                            //convert template data read from memory to ISO form
                                            if (convertTemplateToISO()) {
                                                fpojo = new FingerprintPojo(AndroidUtils.bitmapToByteArray(bmp), ISOTmpl, currentFingerType, true);
                                                fprints.add(fpojo);
                                                clearFingerTemplates();

//                                                runOnUiThread(new Runnable()
//                                                {
//                                                    public void run()
//                                                    {
//                                                        binding.info.setText(fingerprint + " Enrolled Successfully");
//                                                    }
//                                                });
                                                currentFingerType = "";
                                                status = "success";
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                    break;
                                }
                            }
                        }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (status.equalsIgnoreCase("success")) {
                //Toasty.success(FingerpirntVerificationActivity.this, "Finger Template Extracted Successfully")
                //    .show();
                AndroidUtils.dismissProgressDialog();
                new FingerprintVerificationTask().execute();

            } else {
                Toasty.error(FingerpirntVerificationActivity.this, "Error Enrolling " + fingerprint).show();
                //clearFingerTemplates();
                //Finger.clear_alltemplate();
                //binding.info.setText("Error Enrolling " + fingerprint);
            }
            AndroidUtils.dismissProgressDialog();
            super.onPostExecute(result);
        }
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        PosUtil.setFingerPrintPower(PosUtil.FINGERPRINT_POWER_OFF);
//    }

    private class OpenTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // TODO 自动生成的方法存根
            try {
                PosUtil.setFingerPrintPower(PosUtil.FINGERPRINT_POWER_ON);
            } catch (Exception e) {
                // TODO 自动生成的 catch 块
                Toast.makeText(FingerpirntVerificationActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //rets = Finger.initialize();

            if (rets == 0) {
                Toasty.success(FingerpirntVerificationActivity.this, "Device Initialized Successfully", Toast.LENGTH_SHORT, true)
                        .show();
            } else {
                Toasty.error(FingerpirntVerificationActivity.this, "Error Initializing Device", Toast.LENGTH_SHORT, true).show();
            }
            super.onPostExecute(aVoid);

        }
    }
}
