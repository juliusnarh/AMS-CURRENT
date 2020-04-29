package com.telpo.usb.finger;

import android.os.Bundle;
import androidx.core.view.MenuItemCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.JsonArrayRequest;
import com.telpo.usb.finger.pojo.GetLbcs;

import java.util.ArrayList;

//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonArrayRequest;

//import static com.example.rebekkah_boamah.tex.R.id.prog;

public class Lbc extends AppCompatActivity implements SearchView.OnQueryTextListener {
    ProgressBar prog;
    JsonArrayRequest req;
    //protected UserSession session;
    RecyclerView recyler;
    RelativeLayout relCov, error_cover;
    ArrayList<GetLbcs> getlbc;
    LbcAdapter adapter;
    TextView no_lbc;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lbc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LBC");


        relCov = findViewById(R.id.relatted);
        prog = findViewById(R.id.prog);
        recyler = findViewById(R.id.recyler);
        no_lbc = findViewById(R.id.no_lbc);
        error_cover = findViewById(R.id.error_cover);

        getlbc = new ArrayList<>();
//        session = new UserSession(this);


        layoutManager = new LinearLayoutManager(this);
        recyler.setLayoutManager(layoutManager);
        recyler.setHasFixedSize(true);
        adapter = new LbcAdapter(recyler, getlbc, this);
        recyler.setAdapter(adapter);
        recyler.setItemAnimator(new DefaultItemAnimator());
        loadLBCs(0);
    }

    private void loadLBCs(final int pos) {
//        AsyncTask<String,String,String> asyncTask = new AsyncTask<String, String, String>() {
//            @Override
//            protected String doInBackground(String... params) {
//                req = new JsonArrayRequest(Request.Method.POST, serverUrl.loadlbc() + "?pos="+pos, (String) null, new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        try {
//
//                            for(int i=0;i < response.length();i++) {
//                                final JSONObject lbc = response.getJSONObject(i);
//                                if (lbc.getBoolean("response")) {
//
//                                    GetLbcs data = new GetLbcs(lbc.getString("name"),lbc.getString("location"),lbc.getString("address"),lbc.getString("sub"),lbc.getString("lbcid"),lbc.getString("region"),lbc.getString("district"),lbc.getString("email"),lbc.getString("phone"));
//                                    getlbc.add(data);
//                                    adapter.notifyItemInserted(getlbc.size()-1);
//                                    relCov.setVisibility(View.GONE);
//                                    recyler.setVisibility(View.VISIBLE);
//                                } else {
//                                    prog.setVisibility(View.GONE);
//                                    error_cover.setVisibility(View.VISIBLE);
//                                }
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        prog.setVisibility(View.GONE);
//                        error_cover.setVisibility(View.VISIBLE);
//                        no_lbc.setText(R.string.unable);
//                    }
//                });
//                Connector.getInstance(getApplicationContext()).addToRequest(req);
//
//                return null;
//            }
//        };
//        asyncTask.execute();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        if (id == R.id.add_lbc) {
            //nav(AddLBC.class);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    private void nav(Class<AddLBC> addLBCClass) {
//        Intent n = new Intent(this,addLBCClass);
//        this.startActivity(n);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lbc, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
