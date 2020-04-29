package com.telpo.usb.finger.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.input.distribution.DetailsActivity;
import com.telpo.usb.finger.activities.input.distribution.SaletranDetailsActivity;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.DeclarationAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.PaymentStyleAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.SalestranAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.ScaletranAdapter;
import com.telpo.usb.finger.databinding.ActivityFarmerTransactionBinding;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.interfaces.ItemClickListener;
import com.telpo.usb.finger.interfaces.SaletranClickListener;
import com.telpo.usb.finger.interfaces.ScaletranClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.recyclerview.animators.FadeInDownAnimator;

public class FarmerTransaction extends AppCompatActivity implements ScaletranClickListener, SaletranClickListener, ItemClickListener {
    String farmerid;
    ActivityFarmerTransactionBinding binding;
    MaterialDialog loading;
    List<Salestran> salestranList;
    List<Declaration> declarationList;
    List<Scaletran> scaletranList, purchaselist, recoverylist;
    ScaletranAdapter recocveryadapter, purchaseadapter;
    SalestranAdapter salestranAdapter;
    DeclarationAdapter declarationAdapter;
    MaterialDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_farmer_transaction);
        getfarmerid();
        setuprecyclers();
        loadfarmertransactions();
        Drawable drawable = AndroidUtils.arraytodrawable(AndroidUtils.loadFarmerImg(farmerid, getResources()), this);
        binding.farmerimg.setImageDrawable(drawable);


        String[] farmerinfo = AndroidUtils.loadFarmerInformation(farmerid);
        binding.community.setText(farmerinfo[4]);
        binding.farmerid.setText(farmerid);
        binding.farmcount.setText(String.valueOf(AndroidUtils.loadFarms(farmerid).length));
        binding.farmername.setText(farmerinfo[0]);

        binding.cardTitle.setOnClickListener(v -> {
            PaymentStyleAdapter optadapter = new PaymentStyleAdapter(this, R.array.scaletran, this);
            if (binding.header.getText().toString().trim().equalsIgnoreCase("purchase transactions") || binding.header.getText().toString().trim().equalsIgnoreCase("recovery transactions")) {
                dialog = new MaterialDialog.Builder(this)
                        .title("Choose Action")
                        .titleColor(getResources().getColor(R.color.grey_600))
                        .adapter(optadapter, null)
                        .backgroundColor(getResources().getColor(R.color.viewBg))
                        .build();
                dialog.show();
            }
        });
    }

    private void setuprecyclers() {
        salestranList = new ArrayList<>();
        declarationList = new ArrayList<>();
        scaletranList = new ArrayList<>();
        purchaselist = new ArrayList<>();
        recoverylist = new ArrayList<>();
        recocveryadapter = new ScaletranAdapter(this, recoverylist, this);
        purchaseadapter = new ScaletranAdapter(this, purchaselist, this);
        salestranAdapter = new SalestranAdapter(this, salestranList, this);
        declarationAdapter = new DeclarationAdapter(this, declarationList);
        binding.declarationrecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.declarationrecycler.setItemAnimator(new FadeInDownAnimator());
        binding.salestranrecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.salestranrecycler.setItemAnimator(new FadeInDownAnimator());
        binding.scaletranrecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.scaletranrecycler.setItemAnimator(new FadeInDownAnimator());

        binding.scaletranrecycler.setAdapter(recocveryadapter);
        binding.salestranrecycler.setAdapter(salestranAdapter);
        binding.declarationrecycler.setAdapter(declarationAdapter);
    }

    public void getfarmerid() {
        Intent intent = getIntent();
        farmerid = intent.getStringExtra("farmerid");
    }

    private void startloadingdialog() {
        loading = new MaterialDialog.Builder(FarmerTransaction.this)
                .content("Loading Data. Please wait...")
                .progress(true, 0)
                .autoDismiss(true)
                .cancelable(false)
                .build();
        loading.show();
    }

    public void loadfarmertransactions() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
//                startloadingdialog();
                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... params) {


                Log.d("LOGDATA", "entered DisplayLoggingInfo");


                salestranList = Salestran.find(Salestran.class, "farmerid = ?", farmerid);
                declarationList = Declaration.find(Declaration.class, "farmerid = ?", farmerid);
                scaletranList = Scaletran.find(Scaletran.class, "farmerid = ?", farmerid);
                for (int i = 0; i < scaletranList.size(); i++) {
                    Scaletran scaletran = scaletranList.get(i);
                    if (scaletran.getTransid().startsWith(AndroidUtils.RECOVERY))
                        recoverylist.add(scaletran);
                    else if (scaletran.getTransid().startsWith(AndroidUtils.PURCHASE))
                        purchaselist.add(scaletran);
                }


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (salestranList.size() <= 0) {
                            binding.salestranrecycler.setVisibility(View.GONE);
                            binding.norecordsales.setVisibility(View.VISIBLE);
                        } else {
                            binding.salestranrecycler.setVisibility(View.VISIBLE);
                            binding.norecordsales.setVisibility(View.GONE);
                        }

                        if (declarationList.size() <= 0) {
                            binding.declarationrecycler.setVisibility(View.GONE);
                            binding.norecorddeclaration.setVisibility(View.VISIBLE);
                        } else {
                            binding.declarationrecycler.setVisibility(View.VISIBLE);
                            binding.norecorddeclaration.setVisibility(View.GONE);
                        }

                        if (recoverylist.size() <= 0) {
                            binding.scaletranrecycler.setVisibility(View.GONE);
                            binding.norecord.setVisibility(View.VISIBLE);
                        } else {
                            binding.scaletranrecycler.setVisibility(View.VISIBLE);
                            binding.norecord.setVisibility(View.GONE);
                        }
                        salestranAdapter = new SalestranAdapter(FarmerTransaction.this, salestranList, FarmerTransaction.this);
                        declarationAdapter = new DeclarationAdapter(FarmerTransaction.this, declarationList);
//                        binding.salestranrecycler.setNestedScrollingEnabled(true);
//                        binding.declarationrecycler.setNestedScrollingEnabled(true);
                        binding.salestranrecycler.setAdapter(salestranAdapter);
                        binding.declarationrecycler.setAdapter(declarationAdapter);
                        notifychanges();
                    }
                });
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {

//                loading.dismiss();
            }
        };
        asyncTask.execute();
    }

    private void notifychanges() {
        recocveryadapter.notifyDataSetChanged();
        purchaseadapter.notifyDataSetChanged();
        declarationAdapter.notifyDataSetChanged();
        salestranAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSaletranClickListener(int pos, Salestran salestran, CircleImageView imageView) {

        Intent intent = new Intent(this, SaletranDetailsActivity.class);
        intent.putExtra("farmerid", salestran.getFarmerid());
        intent.putExtra("transid", salestran.getTransactionid());
        intent.putExtra("transname", ViewCompat.getTransitionName(imageView));
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageView,
                ViewCompat.getTransitionName(imageView));

        startActivity(intent, options.toBundle());
    }

    @Override
    public void onScaletranClickListener(int pos, Scaletran scaletran, CircleImageView imageView) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("farmerid", scaletran.getFarmerid());
        intent.putExtra("transid", scaletran.getTransid());
        intent.putExtra("transname", ViewCompat.getTransitionName(imageView));
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, ViewCompat.getTransitionName(imageView));

        startActivity(intent, options.toBundle());
    }

    @Override
    public void onItemClick(String paymentStyle) {
        dialog.dismiss();
        if (paymentStyle.equalsIgnoreCase("recovery transactions")) {
            binding.header.setText(getResources().getString(R.string.recovery));


            binding.scaletranrecycler.setAdapter(recocveryadapter);
            if (recoverylist.size() > 0) {
                binding.norecord.setVisibility(View.GONE);
            } else {
                binding.norecord.setVisibility(View.VISIBLE);
            }

        } else {
            binding.header.setText(getResources().getString(R.string.purchase));

            binding.scaletranrecycler.setAdapter(purchaseadapter);
            if (purchaselist.size() > 0) {
                binding.norecord.setVisibility(View.GONE);
            } else binding.norecord.setVisibility(View.VISIBLE);
        }
    }

}
