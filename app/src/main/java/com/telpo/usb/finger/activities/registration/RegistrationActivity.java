package com.telpo.usb.finger.activities.registration;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AlertDialog;

import com.telpo.usb.finger.registration.fragments.BasicInfoFragment;
import com.telpo.usb.finger.registration.fragments.BiometricsFragment;
import com.telpo.usb.finger.registration.fragments.FarmerActivityInfoFragment;
import com.telpo.usb.finger.registration.fragments.HouseholdRelationFragment;
import com.telpo.usb.finger.registration.fragments.RegPreviewFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

import ivb.com.materialstepper.progressMobileStepper;

public class RegistrationActivity extends progressMobileStepper {

    List<Class> fraglist = new ArrayList<>();
    FragmentManager fm;
    RegPreviewFragment dFragment;
    String farmerid;
    boolean hsehldstats;

    @Override
    public void onStepperCompleted() {
        new LoadFragmentTask().execute();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Click [YES] to exit Registration")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        RegistrationActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .show();
    }

    @Override
    public List<Class> init() {
        AndroidUtils.clearRegistrationPreference(this);
        Intent intent = getIntent();
        hsehldstats = intent.getBooleanExtra("household", false);
        farmerid = intent.getStringExtra("farmerid");
        fraglist.add(BasicInfoFragment.class);
        if (hsehldstats) {
            fraglist.add(HouseholdRelationFragment.class);
        } else {
            fraglist.add(FarmerActivityInfoFragment.class);
        }
        //fraglist.add(FarmInfoFragment.class);
        //fraglist.add(LocationInfoFragment.class);
        fraglist.add(BiometricsFragment.class);
        //fraglist.add(RegPreviewFragment.class);
        return fraglist;
    }

    private class LoadFragmentTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            AndroidUtils.showProgressDialog(RegistrationActivity.this, "Loading Preview...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            fm = getSupportFragmentManager();
            dFragment = new RegPreviewFragment();
            RegPreviewFragment.newInstance(farmerid, hsehldstats).show(fm, "Dialog Fragment");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            AndroidUtils.dismissProgressDialog();
            super.onPostExecute(result);
        }
    }

}
