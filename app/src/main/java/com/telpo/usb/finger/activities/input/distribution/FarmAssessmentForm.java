package com.telpo.usb.finger.activities.input.distribution;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.provider.Settings;
import androidx.appcompat.app.AlertDialog;
import android.view.WindowManager;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.FarmAssessment;
import com.telpo.usb.finger.inputdistributions_fragment.FAF_1Fragment;
import com.telpo.usb.finger.inputdistributions_fragment.FAF_2Fragment;
import com.telpo.usb.finger.inputdistributions_fragment.FAF_3Fragment;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_1_Pojo;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_3_Pojo;
import com.telpo.usb.finger.service.AmsService;
import com.telpo.usb.finger.service.LocationService;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;
import ivb.com.materialstepper.progressMobileStepper;

public class FarmAssessmentForm extends progressMobileStepper {
    List<Class> fraglist = new ArrayList<>();
    String farmerid;
    MaterialDialog prog;
    Intent locintent;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateLoc(intent);
        }
    };

    @Override
    public void onStepperCompleted() {
        new LoadFragmentTask().execute();
    }

    @Override
    public List<Class> init() {

        Intent intent = getIntent();
        farmerid = intent.getStringExtra("farmerid");
        AndroidUtils.savePreferenceData(FarmAssessmentForm.this, AndroidUtils.FAFFARMERID_PREF, farmerid);
        fraglist.add(FAF_1Fragment.class);
        fraglist.add(FAF_2Fragment.class);
        fraglist.add(FAF_3Fragment.class);
        return fraglist;
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        if (checkLocation()) {
            locintent = new Intent(this, LocationService.class);
            startService(locintent);
            registerReceiver(broadcastReceiver, new IntentFilter(AmsService.BROADCAST_ACTION));
        } else {
            turnonLocation();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(broadcastReceiver);
            stopService(locintent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Click [YES] to exit Assessment")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> FarmAssessmentForm.super.onBackPressed())
                .setNegativeButton("No", (dialog, id) -> {

                })
                .show();
    }

    private void updateLoc(Intent intent) {
        AndroidUtils.savePreferenceData(FarmAssessmentForm.this, AndroidUtils.FAFLAT_PREF, intent.getStringExtra(AndroidUtils.FAFLAT_PREF));
        AndroidUtils.savePreferenceData(FarmAssessmentForm.this, AndroidUtils.FAFLONG_PREF, intent.getStringExtra(AndroidUtils.FAFLONG_PREF));
    }

    private void turnonLocation() {
        prog = new MaterialDialog.Builder(FarmAssessmentForm.this)
                .content("Location services turned off.\nPlease turn on location services to proceed")
                .positiveText("Ok")
                .onPositive((dialog, which) -> {
                    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(myIntent);
                    prog.dismiss();
                })
                .cancelable(false)
                .build();
        prog.show();
    }

    private boolean checkLocation() {
        LocationManager lm = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }

        return gps_enabled || network_enabled;
    }

    private class LoadFragmentTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            prog = new MaterialDialog.Builder(FarmAssessmentForm.this)
                    .title(R.string.please_wait)
                    .content(R.string.uploading)
                    .progress(true, 0)
                    .cancelable(false)
                    .build();
            prog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... arg0) {
            FarmAssessment assessment = new FarmAssessment();
            //GET STORED INFORMATION
            String _1 = AndroidUtils.getPreferenceData(FarmAssessmentForm.this, AndroidUtils.FAFCROPINFO_PREF, ""),
                    _2 = AndroidUtils.getPreferenceData(FarmAssessmentForm.this, AndroidUtils.FAFCROPPROT_PREF, ""),
                    _3 = AndroidUtils.getPreferenceData(FarmAssessmentForm.this, AndroidUtils.FAFCOMMENT_PREF, "");
            //CONVERT JSON TO POJO
            FAF_1_Pojo cropInfo = new Gson().fromJson(_1, FAF_1_Pojo.class);
            FAF_2_Pojo cropProt = new Gson().fromJson(_2, FAF_2_Pojo.class);
            FAF_3_Pojo comment = new Gson().fromJson(_3, FAF_3_Pojo.class);
            String uuid = AndroidUtils.getUUID();
            //ADDING INFORMATION TO ASSESSMENT OBJECT
            assessment.setFarmerid(AndroidUtils.getPreferenceData(FarmAssessmentForm.this, AndroidUtils.FAFFARMERID_PREF, ""));
            assessment.setFarmid(cropInfo.farmId.get());
            assessment.setAgentid(AndroidUtils.getPreferenceData(getApplicationContext(), AndroidUtils.AGENTID, ""));
            assessment.setAgentname(AndroidUtils.getPreferenceData(getApplicationContext(), AndroidUtils.AGENTNAME, ""));
            assessment.setCropvariety(cropInfo.variety.get());
            assessment.setCropprotection(cropProt.nameChem.get());
            assessment.setComments(comment.commentSss.get());
            assessment.setCropprotectiondate(AndroidUtils.dateStringToDate(cropProt.dateAppliedChem.get()));
            assessment.setFertilizerdate(AndroidUtils.dateStringToDate(cropProt.dateAppliedFert.get()));
            assessment.setDateplanted(AndroidUtils.dateStringToDate(cropInfo.datePlanted.get()));
            assessment.setFertilizername(cropProt.nameFert.get());
            assessment.setFarmimg(AndroidUtils.base64ToByteArray(cropProt.photoString.get()));
            assessment.setFarmlat(cropProt.farmLat.get());
            assessment.setFarmlong(cropProt.farmLong.get());
            assessment.setStageofcrop(cropInfo.stagePlanted.get());
            assessment.setImei(AndroidUtils.getIMEI(FarmAssessmentForm.this));
            assessment.setMacaddress(AndroidUtils.getMacAddress(FarmAssessmentForm.this));
            assessment.setUniqueuid(uuid);
            assessment.setDatecreated(new Date());
            assessment.save();

            List<FarmAssessment> farmAssessment = FarmAssessment.find(FarmAssessment.class, "uniqueuid = ?", uuid);
            String jsonstring = "error";
            //START ASSESSMENT UPLOAD
            if (farmAssessment.size() > 0) {
                ServerTransfer transfer = new ServerTransfer();
                transfer.setassessment(farmAssessment.get(0));
                jsonstring = new Gson().toJson(transfer);
                String uploadId = AndroidUtils.getUUID();
                String uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
                try {
                    AndroidUtils.uploadFileToServer(getApplicationContext());
                } catch (Exception exc) {
                    Toast.makeText(getApplicationContext(), exc.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            if (!jsonstring.equalsIgnoreCase("error")) {
                return "done";
            } else {
                return "error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            prog.dismiss();
            if (result.equalsIgnoreCase("done")) {
                Toasty.success(getApplicationContext(), "Assessment Saved Successfully").show();
                finish();
            }
            super.onPostExecute(result);
        }
    }
}
