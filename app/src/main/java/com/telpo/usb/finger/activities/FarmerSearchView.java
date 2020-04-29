package com.telpo.usb.finger.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.registration.RegistrationActivity;
import com.telpo.usb.finger.adapters.SearchFarmerDataAdapterMobile;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.GetSearchFarmerInfo;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.inputdistributions_fragment.FarmeroptionBottomsheet;
import com.telpo.usb.finger.interfaces.ItemClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.AsyncRequest;
import com.telpo.usb.finger.utils.BoilerplateActivity;
import com.telpo.usb.finger.utils.GridSpacingItemDecoration;
import com.telpo.usb.finger.utils.RecyclerWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//import com.android.volley.NetworkResponse;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.HttpHeaderParser;

public class FarmerSearchView extends BoilerplateActivity implements SearchView.OnQueryTextListener, View.OnClickListener, ItemClickListener {
    public static FarmerSearchView farmerSearchView;
    ProgressBar prog;
    LinearLayout len1;
    List<Farmers> farmers;
    GetSearchFarmerInfo info;
    List<Userbiometrics> userbio;
    List<Farmers> farmerlist;
    SearchView searchView;
    MenuItem menuItem;
    Button verify, search, addfarmer;
    OkHttpClient client = new OkHttpClient();
    Request request;
    Response response;
    //    List<FarmerSearch> searchlista;
    String farmerid = "";
    LinearLayout summarylayout;
    Map<String, String> params;
    private boolean isSearch = false;
    private ArrayList<GetSearchFarmerInfo> searchList;
    private int page = 0;
    private RecyclerView recyclerView;
    private SearchFarmerDataAdapterMobile adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            //getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        summarylayout = findViewById(R.id.summary_layout);
        summarylayout.setVisibility(View.GONE);

        farmerSearchView = this;
        verify = findViewById(R.id.btnverify);
        verify.setOnClickListener(this);
        search = findViewById(R.id.btnsearch);
        search.setOnClickListener(this);
        addfarmer = findViewById(R.id.btnregister);
        addfarmer.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Farmer Search");
        recyclerView = findViewById(R.id.recycler);

        len1 = findViewById(R.id.len1);
        prog = findViewById(R.id.prog);

//        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(new RecyclerWrapper(this, 2));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(5), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        searchList = new ArrayList<>();
        adapter = new SearchFarmerDataAdapterMobile(searchList, this, this, FarmerSearchView.this);
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //method to load biometric info
    public Userbiometrics bio(String farmerid) {
        try {
            List<Userbiometrics> biolist = Userbiometrics.find(Userbiometrics.class, "farmerid = " + "?", farmerid);
            if (!biolist.isEmpty()) {
                return biolist.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Userbiometrics();
    }

    public void searchTraderOnline(String search) {
        params = new HashMap<>();
        params.put("search", search);
        AsyncRequest getPosts = new AsyncRequest(FarmerSearchView.this, "GET", params);
        getPosts.execute(AndroidUtils.SERVER_URL + "/search");
    }


    public void fetch_data(final String input) {
        prog.setVisibility(View.VISIBLE);
        @SuppressLint("StaticFieldLeak") AsyncTask<String, String, String> asyncTask = new
                AsyncTask<String, String, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        try {
                            searchList.clear();
                            farmerlist = new ArrayList<>();
//                            farmerlist = Farmers.find(Farmers.class, "surname like ? or othername" +
//                                            " like ? " +
//                                            "or tel like ? or  farmerid like ? ",
//                                    new String[]{"%" + input + "%", "%" + input + "%", "%" + input + "%, %"+input+"%"},null,null,"10");

                            farmerlist = Farmers.findWithQuery(Farmers.class, "select * from farmers where surname like '%" + input + "%' or othername like '%" + input + "%'" +
                                    " or tel like '%" + input + "%' or  farmerid like '%" + input + "%' or  community like '%" + input + "%' limit 20 ");

                            System.out.println("Farmer Size: " + farmerlist.size());

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (!farmerlist.isEmpty()) {
                                        prog.setVisibility(View.GONE);
                                        len1.setVisibility(View.GONE);
                                        recyclerView.setVisibility(View.VISIBLE);
                                        for (Farmers farmer : farmerlist) {
                                            info = new GetSearchFarmerInfo();
                                            info.setName(farmer.getOthername() + " " + farmer
                                                    .getSurname());//, searchInfo.getString("img"));
                                            info.setFarmer_id(farmer.getFarmerid());
                                            info.setTelephone(farmer.getTel());
                                            info.setPhoto(bio(farmer.getFarmerid()).getPicture());
                                            info.setCommunity(farmer.getCommunity());
                                            searchList.add(info);
                                        }
                                    } else {
//                                        searchTraderOnline(input);

                                        prog.setVisibility(View.GONE);
                                        len1.setVisibility(View.VISIBLE);
                                        recyclerView.setVisibility(View.GONE);
                                        Toast.makeText(getApplicationContext(),
                                                "Search Not " +
                                                        "Found!...", Toast
                                                        .LENGTH_LONG).show();
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
        getMenuInflater().inflate(R.menu.farmer_menu, menu);
        Intent intent = getIntent();
        menuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        if (intent.getStringArrayExtra("action") != null) {
            menuItem.expandActionView();
        }
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
        if (!search.isEmpty()) {
            prog.setVisibility(View.VISIBLE);
            len1.setVisibility(View.GONE);
            fetch_data(search);
        } else {
            prog.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            len1.setVisibility(View.VISIBLE);
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String search) {
        search = search.toLowerCase();
        prog.setVisibility(View.VISIBLE);
        if (!search.isEmpty()) {
            len1.setVisibility(View.GONE);
            fetch_data(search);
        } else {
            prog.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            len1.setVisibility(View.VISIBLE);
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

    @Override
    public void onItemClick(String paymentStyle) {
        farmerid = paymentStyle;
        FarmeroptionBottomsheet bottomsheet = FarmeroptionBottomsheet.newInstance(farmerid);
        bottomsheet.show(getSupportFragmentManager(), bottomsheet.getTag());
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private class LoadFragmentTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            AndroidUtils.showProgressDialog(FarmerSearchView.this, "Loading...");
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

}

