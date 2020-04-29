package com.telpo.usb.finger.activities;

import  android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.registration.RegistrationActivity;
import com.telpo.usb.finger.adapters.SearchFarmerAdapter;
import com.telpo.usb.finger.databinding.ActivityFarmer2Binding;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.GetSearchFarmerInfo;
import com.telpo.usb.finger.inputdistributions_fragment.FarmeroptionBottomsheet;
import com.telpo.usb.finger.inputdistributions_fragment.SearchByAggBottomsheet;
import com.telpo.usb.finger.interfaces.ItemClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.GridSpacingItemDecoration;
import com.telpo.usb.finger.utils.RecyclerWrapper;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class FarmerActivity extends AppCompatActivity implements ItemClickListener {
    List<Farmers> farmerList;
    List<GetSearchFarmerInfo> farmerInfoList;
    ActivityFarmer2Binding binding;
    SearchFarmerAdapter adapter;
    String farmerid, notfound = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_farmer2);
        binding.recycler.setLayoutManager(new RecyclerWrapper(this, 2));
        binding.recycler.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(5), true));
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setItemViewCacheSize(20);
        whiteNotificationBar(binding.nsv);
        farmerInfoList = new ArrayList<>();
        adapter = new SearchFarmerAdapter(farmerInfoList, this, this, this);
        binding.recycler.setAdapter(adapter);
        new LoadDataTask().execute();

        binding.btnsearch.setOnClickListener(v -> {
            binding.nsv.setVisibility(View.GONE);
//            runLayoutAnimation();
            binding.recyclerLayout.setVisibility(View.VISIBLE);
            binding.floatingSearchView.setSearchFocused(true);
            whiteNotificationBar(binding.recyclerLayout);
        });

        binding.searchServerLayout.setOnClickListener(v -> startActivity(new Intent(this, FarmerSearchServerActivity.class).putExtra("search", notfound)));

        binding.btnregister.setOnClickListener(v -> new LoadFragmentTask().execute());

        binding.btnverify.setOnClickListener(v -> startActivity(new Intent(this, FingerpirntVerificationActivity.class)));

        binding.btnsearchserver.setOnClickListener(v -> startActivity(new Intent(this, FarmerSearchServerActivity.class).putExtra("search", "")));

        binding.btnSearchAggregator.setOnClickListener(v -> {
            SearchByAggBottomsheet bottomsheet = SearchByAggBottomsheet.newInstance("");
            bottomsheet.show(getSupportFragmentManager(), bottomsheet.getTag());
        });

        binding.floatingSearchView.setOnQueryChangeListener((oldQuery, newQuery) -> {
            adapter.getFilter().filter(newQuery.toLowerCase());
            notfound = newQuery;
        });



        binding.floatingSearchView.setOnFocusChangeListener(new FloatingSearchView.OnFocusChangeListener() {
            @Override
            public void onFocus() {
                binding.nsv.setVisibility(View.GONE);
                binding.recyclerLayout.setVisibility(View.VISIBLE);
                whiteNotificationBar(binding.recyclerLayout);
            }

            @Override
            public void onFocusCleared() {
                binding.nsv.setVisibility(View.VISIBLE);
                binding.recyclerLayout.setVisibility(View.GONE);
                whiteNotificationBar(binding.nsv);
            }
        });

        binding.floatingSearchView.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            switch (id) {
                case R.id.action_add:
                    new LoadFragmentTask().execute();
                    break;
                case R.id.verify_fingerprint:
                    startActivity(new Intent(this, FingerpirntVerificationActivity.class));
                    break;
            }
        });
    }

    private class LoadDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            AndroidUtils.showProgressDialog(FarmerActivity.this, "Loading Farmers. Please wait...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            farmerList = Farmers.listAll(Farmers.class);
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
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            AndroidUtils.dismissProgressDialog();
            super.onPostExecute(result);
        }
    }

    private class LoadFragmentTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            AndroidUtils.showProgressDialog(FarmerActivity.this, "Loading. Please wait...");
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

    @Override
    public void onItemClick(String paymentStyle) {
        AndroidUtils.hideKeyboard(this);
        farmerid = paymentStyle;
        FarmeroptionBottomsheet bottomsheet = FarmeroptionBottomsheet.newInstance(farmerid);
        bottomsheet.show(getSupportFragmentManager(), bottomsheet.getTag());
    }

    @Override
    public void onBackPressed() {
        if (binding.floatingSearchView.isSearchBarFocused()){
            binding.floatingSearchView.setSearchFocused(false);
        } else
            super.onBackPressed();
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public void runLayoutAnimation() {
        final Context context = binding.recycler.getContext();
        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        binding.recycler.setLayoutAnimation(controller);
        binding.recycler.getAdapter().notifyDataSetChanged();
        binding.recycler.scheduleLayoutAnimation();

        if (binding.recycler.getAdapter().getItemCount() == 0) {
            Toasty.error(context, "farmer not found").show();
            binding.searchServerLayout.setVisibility(View.VISIBLE);
        } else binding.searchServerLayout.setVisibility(View.GONE);
    }

    public void showSearchServerButton() {
        if (binding.recycler.getAdapter() != null && binding.recycler.getAdapter().getItemCount() == 0)
            binding.searchServerLayout.setVisibility(View.VISIBLE);
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }
}
