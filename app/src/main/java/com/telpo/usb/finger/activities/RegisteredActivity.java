package com.telpo.usb.finger.activities;

import android.os.Bundle;
import androidx.core.view.MenuItemCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.RegisteredAdapter;
import com.telpo.usb.finger.pojo.FarmerRegisty;

import java.util.ArrayList;
import java.util.List;

public class RegisteredActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RegisteredAdapter registeredAdapter;
    List<FarmerRegisty> farmerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        farmerlist = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        String uniqueuid, String firstname, String surname, String fullname,
//            String telephone, String id, String nationality, byte[] photo
        //adding some items to our list

        farmerlist.add(
                new FarmerRegisty(
                        "000001",
                        "Joseph",
                        "Appiah",
                        "0244546776",
                        "00123",
                        "Ghanaian",
                        null));

        farmerlist.add(
                new FarmerRegisty(
                        "000001",
                        "Ofori Maanu",
                        "Appiah",
                        "05678654",
                        "00123",
                        "Ghanaian",
                        null));

        farmerlist.add(
                new FarmerRegisty(
                        "000001",
                        "Antwi",
                        "Kojo",
                        "0254866655",
                        "00123",
                        "Ghanaian",
                        null));

        farmerlist.add(
                new FarmerRegisty(
                        "000001",
                        "Joseph",
                        "Appiah",
                        "0244546776",
                        "00123",
                        "Ghanaian",
                        null));

        farmerlist.add(
                new FarmerRegisty(
                        "000001",
                        "Joseph",
                        "Appiah",
                        "0244546776",
                        "00123",
                        "Ghanaian",
                        null));

        farmerlist.add(
                new FarmerRegisty(
                        "000001",
                        "Joseph",
                        "Appiah",
                        "0244546776",
                        "00123",
                        "Ghanaian",
                        null));

        farmerlist.add(
                new FarmerRegisty(
                        "000001",
                        "Joseph",
                        "Appiah",
                        "0244546776",
                        "00123",
                        "Ghanaian",
                        null));

        registeredAdapter = new RegisteredAdapter(this, farmerlist);
        recyclerView.setAdapter(registeredAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.registry_menu, menu);

        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (registeredAdapter != null) registeredAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }


}
