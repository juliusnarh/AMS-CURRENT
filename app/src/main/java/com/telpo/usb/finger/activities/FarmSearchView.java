package com.telpo.usb.finger.activities;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.core.view.MenuItemCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.registration.RegistrationActivity;
import com.telpo.usb.finger.databinding.ActivityFarmSearchViewBinding;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.GetSearchFarmInfo;
import com.telpo.usb.finger.farm.fragment.FarmsFragment;
import com.telpo.usb.finger.farm.fragment.NoFarmFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

public class FarmSearchView extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchView;
    MenuItem menuItem;
    List<Farmers> farmers;
    List<GetSearchFarmInfo> templist;
    List<GetSearchFarmInfo> searchFarmInfoList;
    List<GetSearchFarmInfo> noFarmInfoList;
    List<GetSearchFarmInfo> noFarmTempList;
    ActivityFarmSearchViewBinding binding;
    ViewPagerAdapter vadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_farm_search_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            //getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Farm Search");


        searchFarmInfoList = new ArrayList<>();
        templist = new ArrayList<>();
        noFarmInfoList = new ArrayList<>();
        noFarmTempList = new ArrayList<>();

        new LoadDataTask().execute();

        binding.search.setOnClickListener(v -> menuItem.expandActionView());
    }

    private void setupviewpager() {

        FarmsFragment mrf = FarmsFragment.newInstance(templist, searchFarmInfoList, FarmSearchView.this);
        NoFarmFragment arf = NoFarmFragment.newInstance(noFarmTempList, noFarmInfoList, FarmSearchView.this);

        vadapter = new ViewPagerAdapter(getSupportFragmentManager());
        vadapter.addFragment(mrf, "Farms");
        vadapter.addFragment(arf, "No Farms");
        binding.viewpager.setAdapter(vadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.farmer_menu, menu);

        menuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();

                break;
            case R.id.action_add:
                new LoadFragmentTask().execute();
                break;
            case R.id.verify_fingerprint:
                Intent nav = new Intent(this, FingerpirntVerificationActivity.class);
                this.startActivity(nav);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String search) {
        search = search.toLowerCase();

        if (binding.viewpager.getCurrentItem() == 0)
            ((FarmsFragment) vadapter.getItem(0)).adapter.getFilter().filter(search);
        else ((NoFarmFragment) vadapter.getItem(0)).adapter.getFilter().filter(search);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String search) {
        search = search.toLowerCase();

        if (binding.viewpager.getCurrentItem() == 0)
            ((FarmsFragment) vadapter.getItem(0)).adapter.getFilter().filter(search);
        else ((NoFarmFragment) vadapter.getItem(1)).adapter.getFilter().filter(search);


        return false;
    }


    private class LoadFragmentTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            AndroidUtils.showProgressDialog(FarmSearchView.this, "Loading...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Intent intent = new Intent(getBaseContext(), RegistrationActivity.class);
            startActivity(intent);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            AndroidUtils.dismissProgressDialog();
            super.onPostExecute(result);
        }
    }

    private class LoadDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            AndroidUtils.showProgressDialog(FarmSearchView.this, "Loading Farms...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            farmers = Farmers.listAll(Farmers.class);

            for (int i = 0; i < farmers.size(); i++) {
                GetSearchFarmInfo info = new GetSearchFarmInfo();
                info.farmerid = farmers.get(i).getFarmerid();
                info.surname = farmers.get(i).getSurname();
                info.othername = farmers.get(i).getOthername();
                info.community = farmers.get(i).getCommunity();
                info.farms = TextUtils.join(",", AndroidUtils.loadFarms(farmers.get(i).getFarmerid()));
                if (!info.farms.isEmpty()) {
                    templist.add(info);
                } else noFarmTempList.add(info);
            }

            for (int i = 0; i < templist.size(); i++) {
                if (i < 15) {
                    searchFarmInfoList.add(templist.get(i));
                } else break;
            }

            for (int i = 0; i < noFarmTempList.size(); i++) {
                if (i < 15) {
                    try {
                        noFarmInfoList.add(noFarmTempList.get(i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else break;
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            AndroidUtils.dismissProgressDialog();
            setupviewpager();
            binding.ntsBottom.setViewPager(binding.viewpager);
            super.onPostExecute(result);
        }
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
