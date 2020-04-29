package com.telpo.usb.finger.activities.registration;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.common.pos.api.util.posutil.PosUtil;
import com.google.gson.Gson;
import com.telpo.usb.finger.Finger;
import com.telpo.usb.finger.Fingerh;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.ActivityFingerEnrollBinding;
import com.telpo.usb.finger.entities.Userfingerprint;
import com.telpo.usb.finger.pojo.FingerprintPojo;
import com.telpo.usb.finger.upload.PostData;
import com.telpo.usb.finger.upload.Uploader;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.DataProcessUtil;
import com.telpo.usb.finger.utils.RawToBitMap;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class FingerEnrollActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    int rets, bytelength;
    List<FingerprintPojo> fprint = new ArrayList<>();
    FingerprintPojo fpojo;
    byte[] ISOTmpl = new byte[810];
    byte[] FPTAddr;
    byte[] img_data = new byte[250 * 360];
    int[] TMPL_No = new int[1];
    int[] pnDuplNo = new int[1];
    byte[] wsq_data = new byte[250 * 360];
    byte[] ISOAddrs = new byte[820];

    HashMap<String, FingerprintPojo> hash = new HashMap<>();
    String currentFingerType = "";
    FingerprintPojo uncheckedpojo;
    boolean checkcomplete;
    boolean checkedstatus = false;
    //    boolean previouscheck;
    View checkboxview;
    int count = 1;
//    boolean enrollstatus = false;

    String tmplstr =
            "9C7B63ECA1C1C011C6FACAA9FCD448DF587DC637D3550CC74186A2EBDB91D9DFA58365E057E6265895F1F9C6B5C38914ABF4B096016035255F730F014395051D9537AE792E60AA61A4E34729B5A65EE20B02A0DFF6C03429C7DBE74C79AF59F12C231BA04F0C72AF37198C8DB689FDCEA36A515A6E8BA350CAAEC2F74EC75C44326237822DDE7C49645CF2D8969834AD5212855ABD13AB6A1391EACA0A3805C0C0B4B35AEFDFF079733FA9F462CDCB73CF5249D6C39682095F2E5EB10753E0A4A112B1CE8A2E8860E9E207B34D35819F6C4D91C30775E6FC213874A414556B280B554AD4F7E53048A5490AAEE971311CB09A0083D9BF38E10904B9BC5A05E0B9D44B71D44C91271D4EF71CE17B39815B555B83B7FFE1271098191A6BDDDCDBFCD42EEDFBE353D2F0F0C2E0BCE3E773D2956CEAEDF1E4A24E668DBD76030AAA9E8643C45D36EA8DA41C7B0E78B50E9FB949AFCDB8DCCCA9C1A48BA82607504C9E00DD243EA0A2205D1BE966FFAE65DF7DABF99B0B38B63CCA9E3BA4CBDF90FAED78A7B657DA4DD0F69FC9BEB170F99B5AD8D3205596ADB55FA10F9B27A95F3FC645D7BE1EDCA924603C18BF68933E9A2B3B497C946BCB9DF634E6FABF790B573392183C2FB240E3C8E057DA9FA2529924394CADD567C02444FA947249096A72F99CCF21AE6796E07C5E6FD85279756DED42513A8C5468909CC6C6A8091036EBA5";

    Boolean ISSoft;

    ActivityFingerEnrollBinding binding;
    byte[] verify;
    byte[] ISO1 = new byte[890];
    byte[] ISO2 = new byte[890];
    private Uploader uploader;
    private PostData postData;
    private Gson gson;
    private String uploadstring;
    private String jsonstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_finger_enroll);
        binding.info.setText("Please read instructions below");
        //initialize fingerprint
        initializeFingerprintDevice();
//        try
//        {
//            PosUtil.setFingerPrintPower(PosUtil.FINGERPRINT_POWER_ON);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }

//        new OpenTask().execute();
//        rets = Finger.initialize();
//        if (rets == 0)
//        {
//            Toasty.success(this, "Device Initialized Successfully", Toast.LENGTH_SHORT, true)
//                  .show();
//        }
//        else
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


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        PosUtil.setFingerPrintPower(PosUtil.FINGERPRINT_POWER_OFF);
//    }

    public void onBackClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("fingerprint", false);
        setResult(RESULT_OK, intent);
        finish();
    }

    //method to retrieve, save new enrolled fingerprint and remove enrolled fingerprint from hashmap
    public FingerprintPojo retrieveSelectedFinger(String fingertype, int status, FingerprintPojo
            fpojo) {
        if (status == 0)//get an existing fingerprint object
        {
            return hash.get(fingertype);
        } else if (status == 1)//add fingerprint object to hashmap
        {
            hash.put(fingertype, fpojo);
            return fpojo;
        } else if (status == 2)//remove selected fingerprint object from hashmap
        {
            for (Iterator<Map.Entry<String, FingerprintPojo>> it = hash.entrySet().iterator(); it
                    .hasNext(); ) {
                Map.Entry<String, FingerprintPojo> entry = it.next();
                if (entry.getKey().equals(fingertype)) {
                    it.remove();
                    currentFingerType = "";
                    return new FingerprintPojo();
                }
            }
        }
        return new FingerprintPojo();
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

    public void fingerSelected(final String fingertype, final boolean checked) {
        if (checked) {
            checkedstatus = true;
            currentFingerType = fingertype;
            binding.info.setText("Place " + fingertype + " on Sensor to enroll");
        } else {
            try {
                currentFingerType = fingertype;
                checkedstatus = false;
                uncheckedpojo = retrieveSelectedFinger(fingertype, 0, null);
                checkcomplete = uncheckedpojo.isCompleted();
            } catch (Exception ex) {
                currentFingerType = "";
                checkedstatus = false;
                return;
            }
            if (checkcomplete) {
                new AlertDialog.Builder(this)
                        .setMessage("Click YES to remove " + fingertype)
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //assign status of two to remove deselected checkbox
                                try {
                                    retrieveSelectedFinger(fingertype, 2, fpojo);
                                } catch (Exception e) {
                                    //Toasty.error(FingerEnrollActivity.this, "Fingerprint not
                                    // enrolled yet").show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                ((CheckBox) checkboxview).setChecked(true);
                                currentFingerType = "";
                            }
                        })
                        .show();
            }
        }
    }

    public void onCheckboxClicked(View view) {
        checkboxview = view;
        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            binding.info.setText("Place " + currentFingerType + " on Sensor to enroll");
            binding.fpImage.setImageBitmap(null);
        } else {
            checkedstatus = false;
        }

        if (checkedstatus) {
            Toasty.info(this, "Please enroll " + currentFingerType + " first").show();
            ((CheckBox) checkboxview).setChecked(false);
            checkedstatus = true;
            return;
        }

        switch (view.getId()) {
            case R.id.lthumb:
                fingerSelected("LEFT THUMB", checked);
                break;
            case R.id.lindex:
                fingerSelected("LEFT INDEX", checked);
                break;
            case R.id.lmiddle:
                fingerSelected("LEFT MIDDLE", checked);
                break;
            case R.id.lring:
                fingerSelected("LEFT RING", checked);
                break;
            case R.id.lpinky:
                fingerSelected("LEFT PINKY", checked);
                break;
            case R.id.rthumb:
                fingerSelected("RIGHT THUMB", checked);
                break;
            case R.id.rindex:
                fingerSelected("RIGHT INDEX", checked);
                break;
            case R.id.rmiddle:
                fingerSelected("RIGHT MIDDLE", checked);
                break;
            case R.id.rring:
                fingerSelected("RIGHT RING", checked);
                break;
            case R.id.rpinky:
                fingerSelected("RIGHT PINKY", checked);
                break;
        }
    }

    //method to save enrolled fingerprints to preferencefile
    public void onSave(View view) {
        new BackgroundFileTask().execute();
//        BackgroundFileTask task = new BackgroundFileTask();
//        task.execute("");
        //new BackgroundUploader("http://10.0.0.6:8080/fprintverification/fingerprint",
        // jsonstring ).execute();
    }

    //method to verify two fingerprints
    public void verifyFingerprints(byte[] ISO1, byte[] ISO2) {
        int ret;
        System.out.println("Map Size: " + hash.size());
        try {

            Log.e("verify_ISO_tmpl", "ISO1: " + DataProcessUtil.bytesToHexString(ISO1) + "\nISO2:" +
                    " " + DataProcessUtil.bytesToHexString(ISO2));

            if (ISSoft) {
                int[] isoresult = new int[1];
                ret = Finger.verify_ISO_tmpl(ISO1, ISO2, isoresult); //ISOTmpl
                if (ret == 0) {
                    Toast.makeText(this, String.format("0x%02x", ret) + " , verify success", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(this, String.format("0x%02x", ret) + " , verify fail", Toast.LENGTH_SHORT).show();
                }
            } else {
                ret = Fingerh.verify_ISO_tmpl(ISO1, ISO2); //ISOTmpl
                if (ret == 0) {
                    Toast.makeText(this, String.format("0x%02x", ret) + " , verify success", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(this, String.format("0x%02x", ret) + " , verify fail", Toast.LENGTH_SHORT).show();
                }
            }

            //ret = Finger.verify_ISO_tmpl(ISO1, ISO2); //ISOTmpl

//            if (ret == 0)
//            {
//                Toast.makeText(this, String.format("0x%02x", ret) + " Success", Toast
//                        .LENGTH_SHORT).show();
//                return;
//            }
            Toast.makeText(this, String.format("0x%02x", ret) + "fail", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("verify_ISO_tmpl", "ISO2: " + DataProcessUtil.bytesToHexString(ISO2));
        }
    }

    //method to very fingerprint
    public byte[] verifyOneByN() {
        Log.i("FingerPrint", "FingerPrint Verification!!!");
        int ret, en_Step;

        int[] TMPL_id = new int[1];
        ret = Finger.get_image(img_data);
        if (ret == 0) {
            ret = Finger.identify(TMPL_id);
            if (ret == 0) {
                if (readFingerTemplate()) {
                    //read template data from memory
                    if (writeTemplate() == 0) {
                        //convert template data read from memory to ISO form
                        if (convertTemplateToISO()) {
                            Toasty.success(this, currentFingerType + " Verify Template Created " +
                                    "Successfully")
                                    .show();
                            return ISOTmpl;
                        }
                    } else {
                        Toasty.error(this, "Error Writing Template").show();

                    }
                } else {
                    Toasty.error(this, "Error reading Template").show();

                }
            } else {
                Toasty.error(this, "Error Identify").show();
            }

        } else {
            Toasty.error(this, "Error getting image").show();
        }


//        ret = Finger.get_image(img_data);
//        if (ret == 0)
//        {
//            en_Step = 3;
//            ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
//            if (ret == 0)
//            {
//                en_Step = 4;
//                pnDuplNo[0] = 3;
//                ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
//                if (ret == 0)
//                {
//
//                    Bitmap bmp = RawToBitMap.convert8bit(img_data, 242, 266);
//                    //saveImage(bmp);
//                    if (bmp != null)
//                    {
//                        binding.fpImage.setImageBitmap(bmp);
//                    }

        //write template data
//                        if (readFingerTemplate())
//                        {
        //read template data from memory
//                    if (writeTemplate() == 0)
//                    {
//                        //convert template data read from memory to ISO form
//                        if (convertTemplateToISO())
//                        {
//                            Toasty.success(this, currentFingerType + " Enrolled  Successfully")
//                                  .show();
//                            return ISOTmpl;
//                        }
//                    }
//                        }
//                        else
//                        {
//                            Toasty.error(this, "Error Writing Template").show();
//
////                        }
//
//                }
//            }
//        }
//
//        Toasty.error(this, "Error please try again").show();

        return null;
    }

    public void onEnroll(View view) {
        try {
            new FingerprintEnrollmentTask().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //method to write template to memory
    public int writeTemplate() {
        byte[] tmpldata = DataProcessUtil.hexStringToByte(tmplstr);
        int[] dup_ID = new int[1];
        int fingerId = 1;
        return Finger.write_template(fingerId, tmpldata, dup_ID);
    }

    //method to clear all fingerprint templates
    public void clearFingerTemplates() {
        if (Finger.clear_alltemplate() == 0) {
            //Toast.makeText(this, "clear_all_tmpl" + String.format("0x%02x", ret) + "Clear
            // success", Toast.LENGTH_SHORT).show();

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
//            Log.e("read_template", DataProcessUtil.bytesToHexString(ppBff));
//            Toast.makeText(this, String.format("0x%02x", ret) + "success:" + DataProcessUtil
// .bytesToHexString(ppBff), Toast.LENGTH_SHORT).show();
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

        ret = Finger.clear_alltemplate();
        if (ret == 0) {
            Toasty.success(this, "Templates Cleared Successfully").show();

        } else {
            Toasty.error(this, "Error Clearing Template(s)").show();

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
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +
                    "/" + fileName);
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
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +
                    "/" + fileName);
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

    private class OpenTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // TODO 自动生成的方法存根
            try {
                PosUtil.setFingerPrintPower(PosUtil.FINGERPRINT_POWER_ON);
            } catch (final Exception e) {
                // TODO 自动生成的 catch 块
//                runOnUiThread(new Runnable()
//                {
//                    public void run()
//                    {
//                        Toast.makeText(FingerEnrollActivity.this, e.toString(), Toast.LENGTH_LONG).show();
//                    }
//                });
                //Toast.makeText(FingerEnrollActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //rets = Finger.initialize();

            if (rets == 0) {
                Toasty.success(FingerEnrollActivity.this, "Device Initialized Successfully", Toast.LENGTH_SHORT, true)
                        .show();
            } else {
                Toasty.error(FingerEnrollActivity.this, "Error Initializing Device " + rets, Toast.LENGTH_SHORT, true).show();
            }
            super.onPostExecute(aVoid);

        }
    }

    class BackgroundUploader extends AsyncTask<String, Integer, String> implements
            DialogInterface.OnCancelListener {

        private ProgressDialog progressDialog;
        private String url;
        private File file;
        private String pstring;


        public BackgroundUploader(String url, String pstring) {
            this.url = url;
            //this.file = file;
            this.pstring = pstring;
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(FingerEnrollActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMessage("Uploading File...");
            progressDialog.setCancelable(false);
            progressDialog.setMax(pstring.length());
            progressDialog.show();
        }

        protected String doInBackground(String... v) {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection connection = null;
            String fileName = "Data.gz";
            StringBuilder builder = new StringBuilder();
            try {
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("POST");
                String boundary = "---------------------------boundary";
                String tail = "\r\n--" + boundary + "--\r\n";
                connection.setRequestProperty("Content-Type",
                        "multipart/form-data; boundary=" + boundary);
                connection.setDoOutput(true);

                String metadataPart = "--"
                        + boundary
                        + "\r\n"
                        + "Content-Disposition: form-data; name=\"metadata\"\r\n\r\n"
                        + "" + "\r\n";

                String fileHeader1 = "--"
                        + boundary
                        + "\r\n"
                        + "Content-Disposition: form-data; name=\"uploadfile\"; filename=\""
                        + fileName + "\"\r\n"
                        + "Content-Type: application/octet-stream\r\n"
                        + "Content-Transfer-Encoding: binary\r\n";

                long fileLength = pstring.length() + tail.length();
                String fileHeader2 = "Content-length: " + fileLength + "\r\n";
                String fileHeader = fileHeader1 + fileHeader2 + "\r\n";
                String stringData = metadataPart + fileHeader;

                long requestLength = stringData.length() + fileLength;
                connection.setRequestProperty("Content-length", "" + requestLength);
                connection.setFixedLengthStreamingMode((int) requestLength);
                connection.connect();

                DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                out.writeBytes(stringData);
                out.flush();

                int progress = 0;
                int bytesRead = 0;
                byte buf[] = new byte[1024];
                BufferedInputStream bufInput = new BufferedInputStream(IOUtils.toInputStream
                        (pstring));
                while ((bytesRead = bufInput.read(buf)) != -1) {
                    // write output
                    out.write(buf, 0, bytesRead);
                    out.flush();
                    progress += bytesRead;
                    // update progress bar
                    publishProgress(progress);
                }

                // Write closing boundary and close stream
                out.writeBytes(tail);
                out.flush();
                out.close();

                // Get server response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection
                        .getInputStream()));
                String line = "";

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

            } catch (Exception e) {
                // Exception
            } finally {
                if (connection != null)
                    connection.disconnect();
            }

            return builder.toString();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            progressDialog.setProgress((progress[0]));
        }

        @Override
        protected void onPostExecute(String v) {
            progressDialog.dismiss();
            Toast.makeText(FingerEnrollActivity.this, "Message from server: " + v, Toast
                    .LENGTH_LONG).show();
        }

        @Override
        public void onCancel(DialogInterface dialog) {
            cancel(true);
            dialog.dismiss();
        }
    }

    private class BackgroundFileTask extends AsyncTask<String, Void, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(FingerEnrollActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("Saving Fingerprints Please Wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... filepath) {
            try {
                List<Userfingerprint> prints = new ArrayList<>();
                Userfingerprint fprint = new Userfingerprint();
                Map.Entry<String, FingerprintPojo> entry;
                // verifyFingerprints(getFingerTemplate("RIGHT THUMB"), getFingerTemplate("LEFT
                // THUMB"));
                for (Iterator<Map.Entry<String, FingerprintPojo>> it = hash.entrySet().iterator()
                     ; it.hasNext(); ) {
                    entry = it.next();
                    fprint = new Userfingerprint();
                    fprint.setFingertype(entry.getValue().getFingertype());
                    fprint.setFingerprinttemplate(entry.getValue().getFingertemplate());
                    fprint.setFingerprint(entry.getValue().getFingerprint());
                    fprint.setEntrydate(new Date());
                    fprint.setUniqueuid(AndroidUtils.getUUID());
                    prints.add(fprint);
                }
                String fingerjson = new Gson().toJson(prints);
                AndroidUtils.savePreferenceData(FingerEnrollActivity.this, AndroidUtils
                        .FINGERREF, fingerjson);
                return "done";
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            if (result.equalsIgnoreCase("done")) {
                Toasty.info(getBaseContext(), "Fingerprints Saved Successfully").show();
                Intent intent = new Intent();
                intent.putExtra("fingerprint", true);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }

    private class FingerprintEnrollmentTask extends AsyncTask<Void, Void, Void> {
        String status = "error";
        String fingerprint = currentFingerType;
        Bitmap bmp;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            AndroidUtils.showProgressDialog(FingerEnrollActivity.this, "Enrolling Finger...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            Log.i("FingerPrint", "FingerPrint Enrollment!!!");
            int ret, en_Step;


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
                    }
                    int[] length = new int[1];
                    byte[] quality = new byte[1];
                    ret = Finger.get_ISO2005(ISO1, length, quality);
                    if (ret == 0) {
                        Log.i("FingerPrint", "Successfully Scanned Fingerprint!!!");
                        //Toast.makeText(this, "SUCCESS ", Toast.LENGTH_SHORT).show();
                        fpojo = new FingerprintPojo(AndroidUtils.bitmapToByteArray(bmp), ISO1, currentFingerType, true);
                        retrieveSelectedFinger(currentFingerType, 1,
                                fpojo);//

                        clearFingerTemplates();
                        checkedstatus = false;
                        ISOTmpl = new byte[810];
                        FPTAddr = null;
                        img_data = new byte[250 * 360];
                        TMPL_No = new int[1];
                        pnDuplNo = new int[1];

                        runOnUiThread(new Runnable() {
                            public void run() {
                                binding.info.setText(fingerprint + " " +
                                        "Enrolled " +
                                        "Successfully");
                            }
                        });
                        currentFingerType = "";
                        status = "success";
                        checkedstatus = false;
                    }
                }
            } else {
                ret = Fingerh.get_image(img_data);
                if (ret == 0) {
                    bmp = RawToBitMap.convert8bit(img_data, 242, 266);
                    if (bmp != null) {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                binding.fpImage.setImageBitmap(bmp);
                            }
                        });
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

                                retrieveSelectedFinger(currentFingerType, 1,
                                        fpojo);//
                                clearFingerTemplates();
                                checkedstatus = false;
                                ISOTmpl = new byte[810];
                                FPTAddr = null;
                                img_data = new byte[250 * 360];
                                TMPL_No = new int[1];
                                pnDuplNo = new int[1];

                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        binding.info.setText(fingerprint + " " +
                                                "Enrolled " +
                                                "Successfully");
                                    }
                                });
                                currentFingerType = "";
                                status = "success";

                            }
                        }
                    }
                }
            }

//            for (int count = 1; count <= 3; count++)
//            {
//                switch (count)
//                {
//                    case 1:
//                        try
//                        {
//                            Finger.clear_alltemplate();
//                        }
//                        catch (Exception e)
//                        {
//                        }
//                        ret = Finger.get_empty_id(TMPL_No);
//                        if (ret == 0)
//                        {
//                            en_Step = 0;
//                            ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
//                            if (ret == 0)
//                            {
//                                ret = Finger.get_image(img_data);
//                                if (ret == 0)
//                                {
//                                    en_Step = 1;
//                                    ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
//                                    if (ret == 0)
//                                    {
//                                        runOnUiThread(new Runnable()
//                                        {
//                                            public void run()
//                                            {
//                                                Bitmap bmp = RawToBitMap.convert8bit(img_data,
//                                                        242, 266);
//                                                if (bmp != null)
//                                                {
//                                                    binding.fpImage.setImageBitmap(bmp);
//                                                }
//                                            }
//                                        });
//                                        checkedstatus = false;
//                                        break;
//                                    }
//                                }
//                            }
//                        }
//                        break;
//                    case 2:
//                        ret = Finger.get_image(img_data);
//                        if (ret == 0)
//                        {
//                            en_Step = 2;
//                            ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
//                            if (ret == 0)
//                            {
//                                checkedstatus = false;
//                                break;
//                            }
//                        }
//                        break;
//                    case 3:
//                        ret = Finger.get_image(img_data);
//                        if (ret == 0)
//                        {
//                            en_Step = 3;
//                            ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
//                            if (ret == 0)
//                            {
//                                en_Step = 4;
//                                pnDuplNo[0] = 3;
//                                ret = Finger.enroll(en_Step, TMPL_No[0], pnDuplNo);
//                                if (ret == 0)
//                                {
//                                    Bitmap bmp = RawToBitMap.convert8bit(img_data, 242, 266);
//
//                                    //write template data
//                                    if (readFingerTemplate())
//                                    {
//                                        //read template data from memory
//                                        if (writeTemplate() == 0)
//                                        {
//                                            //convert template data read from memory to ISO form
//                                            if (convertTemplateToISO())
//                                            {
//                                                fpojo = new FingerprintPojo(AndroidUtils
//                                                        .bitmapToByteArray(bmp), ISOTmpl,
//                                                        currentFingerType, true);
//                                                retrieveSelectedFinger(currentFingerType, 1,
//                                                        fpojo);//
//                                                clearFingerTemplates();
//                                                checkedstatus = false;
//                                                ISOTmpl = new byte[810];
//                                                FPTAddr = null;
//                                                img_data = new byte[250 * 360];
//                                                TMPL_No = new int[1];
//                                                pnDuplNo = new int[1];
//
//                                                runOnUiThread(new Runnable()
//                                                {
//                                                    public void run()
//                                                    {
//                                                        binding.info.setText(fingerprint + " " +
//                                                                "Enrolled " +
//                                                                "Successfully");
//                                                    }
//                                                });
//                                                currentFingerType = "";
//                                                status = "success";
//                                            }
//                                        }
//                                        else
//                                        {
//                                        }
//                                    }
//                                    else
//                                    {
//                                    }
//                                    break;
//                                }
//                            }
//                        }
//                }
//            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (status.equalsIgnoreCase("success")) {
                Toasty.success(FingerEnrollActivity.this, "Enrolled Successfully").show();
            } else {
                Toasty.error(FingerEnrollActivity.this, "Error Enrolling " + fingerprint).show();
                binding.info.setText("Error Enrolling " + fingerprint);
            }
            AndroidUtils.dismissProgressDialog();
            super.onPostExecute(result);
        }
    }
}
