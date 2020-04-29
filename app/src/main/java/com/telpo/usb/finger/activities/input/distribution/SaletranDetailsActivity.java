package com.telpo.usb.finger.activities.input.distribution;

import android.content.Intent;
import android.content.res.Resources;
import androidx.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.SalesAdapter;
import com.telpo.usb.finger.databinding.ActivitySaletrandetailsBinding;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;

public class SaletranDetailsActivity extends AppCompatActivity {
    String farmerid, transid;

    ActivitySaletrandetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_saletrandetails);
        Resources res = getResources();
        Intent intent = getIntent();
        farmerid = intent.getStringExtra("farmerid");
        transid = intent.getStringExtra("transid");
        List<Salestran> salestrans = Salestran.find(Salestran.class, "transactionid = ?", transid);

        setuprecycler();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String imageTransitionName = intent.getStringExtra("transname");
            binding.farmerimg.setTransitionName(imageTransitionName);
            binding.farmerimg.setImageDrawable(AndroidUtils.arraytodrawable(AndroidUtils.loadFarmerImg(farmerid, getResources()), this));
        }
        binding.back.setOnClickListener(v -> onBackPressed());

        String[] farmerinfo = AndroidUtils.loadFarmerInformation(farmerid);
        binding.community.setText(farmerinfo[4]);
        binding.farmerid.setText(farmerid);
        binding.farmcount.setText(String.valueOf(AndroidUtils.loadFarms(farmerid).length));
        binding.farmername.setText(farmerinfo[0]);

        if (salestrans.size() > 0) {
            Salestran salestran = salestrans.get(0);
            if (salestran.getTransactionid().startsWith(AndroidUtils.SERVICETRANSID)) {
                binding.declarationLabel.setText("SERVICE SALES");
            }
            binding.transid.setText(salestran.getTransactionid());
            binding.cost.setText(res.getString(R.string.price_item, (salestran.getTotalCost() - salestran.getAppliedsub())));
            binding.pmethod.setText(salestran.getPaymentmethod());
            binding.agent.setText(salestran.getAgentname());
            binding.date.setText(AndroidUtils.dateToFormattedString(salestran.getDatecreated(), "dd MMM, yyyy"));
            binding.acreage.setText(res.getString(R.string.acre, salestran.getAcreage()));
            binding.bagspayable.setText(res.getString(R.string.expected, salestran.getNorecoverybags()));


            if (salestran.getCouponcode().equalsIgnoreCase("subsidized")) {
                binding.sub.setText("Yes");
            } else binding.sub.setText("No");

            if (salestran.getTransactionid().charAt(0) != 'R') {

                binding.tendered.setText(res.getString(R.string.price_item, salestran.getTendered()));
            } else if (salestran.getTransactionid().charAt(0) != 'P') {

                binding.tendered.setText(res.getString(R.string.expected, salestran.getTendered()));
            } else {

                binding.tendered.setText(res.getString(R.string.expected, salestran.getTendered()));
            }
        }
    }

    private void setuprecycler() {
        List<Sales> salesList = new ArrayList<>();
        SalesAdapter adapter = new SalesAdapter(salesList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        binding.recycler.setLayoutManager(manager);
        binding.recycler.setItemAnimator(new FadeInLeftAnimator());
        binding.recycler.getItemAnimator().setAddDuration(800);
        binding.recycler.setDrawingCacheEnabled(true);
        binding.recycler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        binding.recycler.setAdapter(adapter);

        salesList = Sales.find(Sales.class, "transactionid = ?", transid);
        adapter.addnewitem(salesList, binding.recycler);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
}
