package com.telpo.usb.finger.activities.profile;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.profile.fragments.FarmerProfileMainFragment;

public class ProfileActivity extends AppCompatActivity {
    public static ProfileActivity profileActivity;
    String farmerid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileActivity = this;
        Intent intent = getIntent();
        farmerid = intent.getStringExtra("farmerid");
        int tabindex = intent.getIntExtra("tabindex", 0);

        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, FarmerProfileMainFragment.newInstance(farmerid, tabindex), "MainFragment");
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }
    }


}
