package com.telpo.usb.finger.activities;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.SearchFarmerAdapter;
import com.telpo.usb.finger.databinding.ActivityFarmerSearchAggregatorBinding;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.GetSearchFarmerInfo;
import com.telpo.usb.finger.inputdistributions_fragment.FarmeroptionBottomsheet;
import com.telpo.usb.finger.interfaces.ItemClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.GridSpacingItemDecoration;
import com.telpo.usb.finger.utils.RecyclerWrapper;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class FarmerSearchAggregatorActivity extends AppCompatActivity implements ItemClickListener {
    ActivityFarmerSearchAggregatorBinding binding;
    String aggregatorid;
    SearchFarmerAdapter adapter;
    List<Farmers> farmerList = new ArrayList<>();
    List<GetSearchFarmerInfo> farmerInfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_farmer_search_aggregator);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        aggregatorid = getIntent().getStringExtra("aggregatorid");
        binding.content.recyclerView.setLayoutManager(new RecyclerWrapper(this, 2));
        binding.content.recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(5), true));
        adapter = new SearchFarmerAdapter(farmerInfoList, this, this, this);
        binding.content.recyclerView.setAdapter(adapter);
        binding.floatingSearchView.setOnQueryChangeListener((oldQuery, newQuery) -> adapter.getFilter().filter(newQuery.toLowerCase()));
        whiteNotificationBar(binding.content.recyclerView);
        binding.content.progressBar.setVisibility(View.VISIBLE);
        new LoadDataTask().execute();
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @Override
    public void onItemClick(String paymentStyle) {
        AndroidUtils.hideKeyboard(this);
        FarmeroptionBottomsheet bottomsheet = FarmeroptionBottomsheet.newInstance(paymentStyle);
        bottomsheet.show(getSupportFragmentManager(), bottomsheet.getTag());
    }

    public void runLayoutAnimation() {
        final Context context = binding.content.recyclerView.getContext();
        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        binding.content.recyclerView.setLayoutAnimation(controller);
        binding.content.recyclerView.getAdapter().notifyDataSetChanged();
        binding.content.recyclerView.scheduleLayoutAnimation();

    }
    private class LoadDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
//            AndroidUtils.showProgressDialog(FarmerActivity.this, "Loading Farmers. Please wait...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            farmerList = Farmers.find(Farmers.class, "aggregatorid = ?", aggregatorid);
            for (Farmers farmer : farmerList) {
                GetSearchFarmerInfo info = new GetSearchFarmerInfo();
                info.setName(farmer.getOthername() + " " + farmer.getSurname());
                info.setSurname(farmer.getSurname());
                info.setOthername(farmer.getOthername());
                info.setFarmer_id(farmer.getFarmerid());
                info.setTelephone(farmer.getTel());
                info.setPhoto(AndroidUtils.loadFarmerImg(farmer.getFarmerid(), getResources()));
                info.setCommunity(farmer.getCommunity());
                info.setAggregatorid(farmer.getAggregatorid());
                farmerInfoList.add(info);

                runOnUiThread(() -> {
                    binding.content.progressBar.setVisibility(View.GONE);
                    binding.content.searchCount.setText(getString(R.string.search_count, farmerList.size()));
                    runLayoutAnimation();
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            AndroidUtils.dismissProgressDialog();
            super.onPostExecute(result);
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
    @Override
    public void onBackPressed() {
        if (binding.floatingSearchView.isSearchBarFocused()) {
            binding.floatingSearchView.setSearchFocused(false);
        } else
            super.onBackPressed();
    }
}
