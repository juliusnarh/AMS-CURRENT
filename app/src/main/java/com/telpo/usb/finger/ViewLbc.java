package com.telpo.usb.finger;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ViewLbc extends AppCompatActivity {
    String lbcid = null;
    String subname, phone, email, address, loc, district, region;
    TextView initialed, location, addresses, getdistrict, getregion, telephone, getemail,
            company_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_lbc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent getInfo = getIntent();
        lbcid = getInfo.getStringExtra("lbcid");
        subname = getInfo.getStringExtra("subname");
        address = getInfo.getStringExtra("address");
        loc = getInfo.getStringExtra("loc");
        phone = getInfo.getStringExtra("phone");
        region = getInfo.getStringExtra("region");
        district = getInfo.getStringExtra("district");
        email = getInfo.getStringExtra("email");

        try {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getInfo.getStringExtra("lbcnamme"));

            initialed = findViewById(R.id.initialed);
            company_id = findViewById(R.id.company_id);
            location = findViewById(R.id.location);
            addresses = findViewById(R.id.address);
            getdistrict = findViewById(R.id.district);
            getregion = findViewById(R.id.region);
            telephone = findViewById(R.id.telephone);
            getemail = findViewById(R.id.email);
            initialed.setText(subname);
            location.setText(loc);
            addresses.setText(address);
            getdistrict.setText(district);
            getregion.setText(region);
            telephone.setText(phone);
            getemail.setText(email);
            company_id.setText(lbcid);

            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
