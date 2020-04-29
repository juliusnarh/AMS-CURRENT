package com.telpo.usb.finger.activities.registration;

import android.content.Intent;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.core.view.MenuItemCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.FingerpirntVerificationActivity;
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.adapters.HouseholdSearchAdapter;
import com.telpo.usb.finger.databinding.HouseholdSearchActivityBinding;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.pojo.FarmerRegisty;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

//import com.android.volley.NetworkResponse;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.HttpHeaderParser;

public class HouseholdSearchActivity extends AppCompatActivity implements SearchView
        .OnQueryTextListener, View.OnClickListener {
    public static HouseholdSearchActivity householdSearchView;
    public String farmerid;
    HouseholdSearchActivityBinding binding;
    List<Farmers> farmers;
    FarmerRegisty info;
    List<Userbiometrics> userbio;
    List<Farmers> farmerlist;
    String query;
    SearchView searchView;
    MenuItem menuItem;
    private boolean isSearch = false;
    private List<FarmerRegisty> registyList;
    private int page = 0;
    private HouseholdSearchAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    //method to load biometric info
    public static Userbiometrics bio(String farmerid) {
        try {
            List<Userbiometrics> biolist = Userbiometrics.find(Userbiometrics.class, "farmerid = ?", farmerid);
            if (!biolist.isEmpty()) {
                return biolist.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Userbiometrics();
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, byte[] bytearr) {
        Glide.with(imageView.getContext())
                .load(bytearr) // byte[] of the picture
                .into(imageView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.household_search_activity);
        Intent idintent = getIntent();
        farmerid = idintent.getStringExtra("farmerid");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        householdSearchView = this;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Household Search");

        registyList = new ArrayList<>();
        binding.hseholdrecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.hseholdrecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new HouseholdSearchAdapter(registyList, this);
        binding.hseholdrecycler.setAdapter(adapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void fetch_data(final String input) {
        AsyncTask<String, String, String> asyncTask = new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {
                try {
                    if (farmerlist == null)
                        farmerlist = new ArrayList<>();

                    registyList.clear();
                    farmerlist.clear();

                    query = "SELECT " +
                            "  farmers.surname as surname," +
                            "  farmers.othername as othername," +
                            "  userbiometrics.Picture as photo" +
                            "  FROM" +
                            "  userbiometrics" +
                            "  INNER JOIN farmers ON farmers.farmerid = userbiometrics.farmerid " +
                            "  where farmers.surname like '%" + input + "%'";

                    farmerlist = Farmers.find(Farmers.class, "(surname like ? or othername like ? or tel like ?) and farmerid <> ? ",
                            "%" + input + "%", "%" + input + "%", "%" + input + "%", farmerid);

                    System.out.println("Farmer Size: " + farmerlist.size());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (!farmerlist.isEmpty()) {
                                binding.hseholdrecycler.setVisibility(View.VISIBLE);
                                for (Farmers farmer : farmerlist) {
                                    info = new FarmerRegisty();
                                    info.setFullname(farmer.getOthername() + " " + farmer.getSurname());//, searchInfo.getString("img"));
                                    info.setId(farmer.idcardno);
                                    info.setTelephone(farmer.getTel());
                                    info.setFarmerid(farmer.getFarmerid());
                                    info.setPhoto(bio(farmer.getFarmerid()).getPicture());
                                    registyList.add(info);
                                }
                            } else {
                                binding.hseholdrecycler.setVisibility(View.GONE);
                                Toasty.info(getBaseContext(), "Search Not Found!...").show();
                            }
                        }
                    });

                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                adapter.notifyDataSetChanged();
                super.onPostExecute(s);
            }
        };
        asyncTask.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.registry_menu, menu);
        menuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.home:
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

    public void navigation() {
        Intent nav = new Intent(this, RegistrationActivity.class);
        this.startActivity(nav);
    }

    @Override
    public boolean onQueryTextSubmit(String search) {
        search = search.toLowerCase();
        if (!search.isEmpty()) {
            fetch_data(search);
        } else {
            binding.hseholdrecycler.setVisibility(View.GONE);

        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String search) {
        search = search.toLowerCase();

        if (!search.isEmpty()) {

            fetch_data(search);
        } else {
            binding.hseholdrecycler.setVisibility(View.GONE);

        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnverify:
                Intent nav = new Intent(this, FingerpirntVerificationActivity.class);
                this.startActivity(nav);
                break;
            case R.id.btnsearch:
                //loadProfilePage("");
                menuItem.expandActionView();
                break;
            case R.id.btnregister:
                new LoadFragmentTask().execute();
                break;
        }
    }

    //method to load profile page
    public void loadProfilePage(String farmerid) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("farmerid", farmerid);
        this.startActivity(intent);
//        finish();
    }

    private class LoadFragmentTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            AndroidUtils.showProgressDialog(HouseholdSearchActivity.this, "Loading...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Intent intent = new Intent(getBaseContext(), RegistrationActivity.class);
            intent.putExtra("household", true);
            intent.putExtra("farmerid", farmerid);
            startActivity(intent);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            AndroidUtils.dismissProgressDialog();
            super.onPostExecute(result);
        }
    }
}

