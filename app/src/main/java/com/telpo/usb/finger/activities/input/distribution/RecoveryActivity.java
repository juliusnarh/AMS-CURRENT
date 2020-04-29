package com.telpo.usb.finger.activities.input.distribution;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.ActivityRecoveryBinding;
import com.telpo.usb.finger.inputdistributions_fragment.AutomaticRecoveryFragment;
import com.telpo.usb.finger.inputdistributions_fragment.ManualRecoveryFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

public class RecoveryActivity extends AppCompatActivity {


    ActivityRecoveryBinding binding;
    String farmerId, type;
    MaterialDialog prog;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recovery);
        setUpToolbar();
        setupFarmercard();
        setupviewpager();

        binding.ntsBottom.setViewPager(binding.viewpager);

        binding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                if (position == 1) {

                    if (!checkwifistate()) {
                        new MaterialDialog.Builder(RecoveryActivity.this)
                                .title("WiFi")
                                .content("Do you want to turn on WiFi?")
                                .positiveText("Yes")
                                .negativeText("No")
                                .onPositive((dialog, which) -> {

                                    MaterialDialog prog = new MaterialDialog.Builder(RecoveryActivity.this)
                                            .title(R.string.please_wait)
                                            .content("Turning on wifi...")
                                            .progress(true, 0)
                                            .cancelable(false)
                                            .build();
                                    prog.show();


                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            wifiManager.setWifiEnabled(true);
                                            prog.dismiss();
                                        }
                                    }, 1500);
                                })
                                .show();


                    }
                }
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });
    }

    private boolean checkwifistate() {

        try {
            wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            return wifiManager.isWifiEnabled();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void setupFarmercard() {
        Intent farmerIntent = getIntent();
        farmerId = farmerIntent.getStringExtra("farmerid");
        type = farmerIntent.getStringExtra("type");
        if (farmerId != null) {
            String[] farmerInfo = AndroidUtils.loadFarmerInformation(farmerId);
            binding.farmerCode.setText(farmerId);
            binding.farmerName.setText(farmerInfo[0]);
            binding.farmerNumber.setText(farmerInfo[5]);
            AndroidUtils.setImageViewResource(binding.farmerImg, AndroidUtils.loadFarmerImg(farmerId, getResources()));
        }
    }

    private void setupviewpager() {

        ManualRecoveryFragment mrf = ManualRecoveryFragment.newInstance(farmerId, type);
        AutomaticRecoveryFragment arf = AutomaticRecoveryFragment.newInstance(farmerId, type);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(mrf, "Manual");
        adapter.addFragment(arf, "Automatic");
        binding.viewpager.setAdapter(adapter);
    }


    private void setUpToolbar() {
        int primary = getResources().getColor(R.color.colorPrimaryDark);
        int secondary = getResources().getColor(R.color.colorPrimary);
        SlidrConfig mConfig = new SlidrConfig.Builder()
                .primaryColor(primary)
                .secondaryColor(secondary)
                .position(SlidrPosition.LEFT)
                .velocityThreshold(2400)
                .build();
        Slidr.attach(this, mConfig);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}