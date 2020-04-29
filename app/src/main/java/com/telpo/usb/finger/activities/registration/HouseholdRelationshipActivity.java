package com.telpo.usb.finger.activities.registration;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.databinding.ActivityHouseholdRelationshipBinding;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Household;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.pojo.MessageEvent;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.Date;

import es.dmoral.toasty.Toasty;

public class HouseholdRelationshipActivity extends AppCompatActivity implements ListDialogFragment.OnListDialogItemSelect {
    String householdid, farmerid;
    String[] listitems;
    ListDialogFragment dialogFragment;
    FragmentManager fm;
    ActivityHouseholdRelationshipBinding binding;
    EventBus bus = EventBus.getDefault();
    Farmers farmers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_household_relationship);

        Intent idintent = getIntent();
        householdid = idintent.getStringExtra("householdid");
        farmerid = idintent.getStringExtra("farmerid");

        loadFarmerInformation();
        loadBiometricInformation();

        binding.txtrelationship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listitems = getResources().getStringArray(R.array.relationship);
                showOptionDialog(listitems, "Select Relationship Type", "relationtype");
            }
        });

        binding.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        binding.btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HouseholdRelationshipActivity.this, HouseholdSearchActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HouseholdRelationshipActivity.this.startActivity(intent);
                finish();
            }
        });
    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        fm = this.getSupportFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    //method to load biometric information
    public void loadBiometricInformation() {
        try {
            Userbiometrics bio = Userbiometrics.find(Userbiometrics.class, "farmerid=?", householdid).get(0);
            binding.pic.setImageBitmap(AndroidUtils.byteArrayToBitmap(bio.getPicture()));
            AndroidUtils.setImageViewResource(binding.pic, bio.getPicture());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to load farmer information
    public void loadFarmerInformation() {
        try {
            farmers = Farmers.find(Farmers.class, "farmerid = ?", householdid).get(0);
            binding.txtfullname.setText(farmers.othername + " " + farmers.surname);
            binding.txtidcard.setText(farmers.idcardno);
            binding.txtmobile.setText(farmers.tel);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //method to save relationship information
    public void save() {
        try {
            Household household = new Household();
            household.farmerid = farmerid;
            household.householdid = householdid;
            household.relationship = binding.txtrelationship.getText().toString();
            household.syncstatus = "0";
            household.datecreated = new Date();
            household.uniqueuid = AndroidUtils.getUUID();
            household.save();

            ServerTransfer serverTransfer = new ServerTransfer();
            serverTransfer.setHousehold(household);

            String uploadId = AndroidUtils.getUUID();
            String uploadfilepath = AndroidUtils.writeToFile(new Gson().toJson(serverTransfer), uploadId + ".txt");

            try {
                AndroidUtils.uploadFileToServer(this);
            } catch (Exception exc) {
                exc.printStackTrace();
            }

            bus.postSticky(new MessageEvent("reload", "household"));
            Toasty.success(this, "Record saved successfully").show();

            Intent intent = new Intent(HouseholdRelationshipActivity.this, ProfileActivity.class);
            intent.putExtra("farmerid", farmerid);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            HouseholdRelationshipActivity.this.startActivity(intent);
            finish();
        } catch (Exception e) {
            Toasty.error(this, "Error saving record").show();
            e.printStackTrace();
        }

    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("relationtype")) {
            binding.txtrelationship.setText(selection);
        }
    }
}
