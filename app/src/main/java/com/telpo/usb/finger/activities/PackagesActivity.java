package com.telpo.usb.finger.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.PackageAdapter;
import com.telpo.usb.finger.adapters.PackageSelectAdapter;
import com.telpo.usb.finger.databinding.ActivityPackagesBinding;
import com.telpo.usb.finger.dialogforms.AddPackageDialog;
import com.telpo.usb.finger.dialogforms.PackageDetailsDialog;
import com.telpo.usb.finger.entities.AggregatorInputs;
import com.telpo.usb.finger.entities.AvailablePackages;
import com.telpo.usb.finger.entities.Packages;
import com.telpo.usb.finger.interfaces.PackageClickListener;
import com.telpo.usb.finger.interfaces.PackageSelectClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.GridSpacingItemDecoration;
import com.telpo.usb.finger.utils.RecyclerTouchListener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;
import jp.wasabeef.recyclerview.animators.LandingAnimator;

public class PackagesActivity extends AppCompatActivity implements PackageClickListener, PackageSelectClickListener, PackageSelectAdapter.PackageSelectClickListener {
    ActivityPackagesBinding binding;
    List<Packages> packagesList;
    PackageAdapter adapter;
    ProgressDialog pDialog;
    List<AggregatorInputs> productsList;
    List<AvailablePackages> availablePackagesList = new ArrayList<>();
    String packagegname = "";
    MaterialDialog optionsDialog;
    int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_packages);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        packagesList = Packages.listAll(Packages.class);
        setuprecycler();
        builddialog();

        binding.content.recycler.addOnItemTouchListener(new RecyclerTouchListener(this, binding.content.recycler, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                optionsDialog.show();
                pos = position;
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddPackageDialog.newInstance("", PackagesActivity.this).show(getSupportFragmentManager(), AddPackageDialog.TAG);
            }
        });
    }

    @Override
    public void onPackageClickListener(Packages packages) {
        adapter.additem(packages, 0);
    }

    private void setuprecycler() {
        adapter = new PackageAdapter(getApplicationContext(), packagesList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        binding.content.recycler.setLayoutManager(mLayoutManager);
        binding.content.recycler.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        binding.content.recycler.setItemAnimator(new LandingAnimator());
        binding.content.recycler.setAdapter(adapter);
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, Charset.defaultCharset());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void onPackageSelectClickListener(String selpackages) {
        optionsDialog.dismiss();
        if (selpackages.contains("Edit")){
            Toasty.normal(getApplicationContext(), "coming soon").show();
        } else
            PackageDetailsDialog.newInstance(packagesList.get(pos)).show(getSupportFragmentManager(), PackageDetailsDialog.TAG);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void builddialog() {
        String[] pkglist = {"Edit Package", "View Package"};

        PackageSelectAdapter adapter = new PackageSelectAdapter(this, pkglist, this);
        optionsDialog = new MaterialDialog.Builder(this)
                .title("Select Package")
                .titleColorRes(R.color.grey_600)
                .adapter(adapter, null)
                .backgroundColorRes(R.color.viewBg)
                .build();
    }
}
