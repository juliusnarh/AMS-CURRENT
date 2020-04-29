package com.telpo.usb.finger.activities.input.distribution;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import androidx.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.ActivityDetailsBinding;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.inputdistributions_fragment.ModifyRecoveryDialogFragment;
import com.telpo.usb.finger.interfaces.ModifyRecoveryClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.SmsBroadcastReceiver;

import java.util.List;

import at.grabner.circleprogress.ColorUtils;
import es.dmoral.toasty.Toasty;

public class DetailsActivity extends AppCompatActivity implements ModifyRecoveryClickListener {
    String farmerid, transid;
    StringBuilder dec = new StringBuilder();
    ActivityDetailsBinding binding;
    Double payable = 0.00, tendered = 0.00, totalamtowing = 0.00;
    List<Declaration> declarationList;
    SmsBroadcastReceiver smsBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        Resources res = getResources();
        Intent intent = getIntent();
        farmerid = intent.getStringExtra("farmerid");
        transid = intent.getStringExtra("transid");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String imageTransitionName = intent.getStringExtra("transname");
            binding.farmerimg.setTransitionName(imageTransitionName);
            binding.farmerimg.setImageDrawable(AndroidUtils.arraytodrawable(AndroidUtils.loadFarmerImg(farmerid, getResources()), this));
        }

        String[] farmerinfo = AndroidUtils.loadFarmerInformation(farmerid);

        String recieveraddress = "0546473945";

        binding.back.setOnClickListener(v -> onBackPressed());
        smsBroadcastReceiver = new SmsBroadcastReceiver("+233" + recieveraddress.substring(1), "y");

        List<Scaletran> scaletranList = Scaletran.find(Scaletran.class, "transid = ?", transid);
        List<Scaletran> allscaletranList = Scaletran.find(Scaletran.class, "farmerid = ?", farmerid);
        declarationList = Declaration.find(Declaration.class, "farmerid = ?", farmerid);
        binding.modifyRecovery.setOnClickListener(v -> showDeclarationbottomsheet());

        if (transid.startsWith(AndroidUtils.PURCHASE)) {
            binding.declaration.setVisibility(View.GONE);
            binding.declarationLabel.setVisibility(View.GONE);
        } else {
            if (declarationList.size() > 0) {

                for (int i = 0; i < declarationList.size(); i++) {

                    String[] declarationparts = declarationList.get(i).getDeclaration().split(" ");


                    for (int x = 0; x < declarationparts.length; x++) {
                        if (declarationparts[x].equals("exchange")) {
                            payable += Double.parseDouble(declarationparts[x + 1]);
                            break;
                        }
                    }

//                    payable += 14 * Integer.parseInt(declarationList.get(i).getAcreage());

                    dec.append(declarationList.get(i).getDeclaration());

                    if ((declarationList.size() - i) != 1) {
                        dec.append("\n\n");
                    }
                }

                binding.declaration.setText(dec.toString());
            } else {
                binding.declarationLabel.setVisibility(View.GONE);
                binding.declaration.setVisibility(View.GONE);
            }

        }

        if (allscaletranList.size() > 0) {
            for (int i = 0; i < allscaletranList.size(); i++) {
                if (allscaletranList.get(i).getTransid().equals(transid)) {
                    if (i > 0) {
                        for (int y = 0; y <= i; y++) {
                            if (allscaletranList.get(y).getTransid().startsWith(AndroidUtils.RECOVERY)) {
                                tendered += Double.parseDouble(allscaletranList.get(y).getTendered());
                            }
                        }
                    } else if (i == 0) {
                        tendered = Double.parseDouble(allscaletranList.get(i).getTendered());
                    }
                }
//                payable = Double.parseDouble(allscaletranList.get(i).getPayable());
            }
        }

        if (scaletranList.size() > 0) {
            Scaletran scaletran = scaletranList.get(0);


            if (scaletran.getTransid().startsWith(AndroidUtils.PURCHASE)) {
                payable = tendered;
            }

            binding.community.setText(farmerinfo[4]);
            binding.farmerid.setText(farmerid);
            binding.farmcount.setText(String.valueOf(AndroidUtils.loadFarms(farmerid).length));
            binding.farmername.setText(farmerinfo[0]);
            binding.farmerprogress.setBarColor(ColorUtils.getRGBGradient(res.getColor(R.color.bar1), res.getColor(R.color.bar4), 0.8f));
            binding.farmerprogress.setMaxValue(payable.floatValue());
            binding.farmerprogress.setValue(tendered.floatValue());
            binding.tendered.setText(String.valueOf(tendered));
            binding.payable.setText(String.valueOf(payable));
            binding.weight.setText(String.valueOf(scaletran.getWeight()));
            binding.count.setText(String.valueOf(scaletran.getCount()));
            binding.transid.setText(String.valueOf(scaletran.getTransid()));
            binding.amount.setText(String.valueOf(scaletran.getAmount()));
            binding.amountowing.setText(String.valueOf(payable - tendered));
            binding.pcid.setText(String.valueOf(scaletran.getPcid()));
            binding.date.setText(AndroidUtils.dateToFormattedString(scaletran.getDate(), "dd MMM, yyyy"));
            binding.tenderedprogress.setText(res.getString(R.string._s10_20, String.valueOf(tendered), String.valueOf(payable)));
        }
    }

    private void showDeclarationbottomsheet() {
        ModifyRecoveryDialogFragment.newInstance(declarationList, this).show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void OnModifyRecoveryClickListener(Declaration dec) {
        MaterialDialog methodDialog = new MaterialDialog.Builder(DetailsActivity.this)
                .title(R.string.please_wait)
                .content(R.string.waiting)
                .progress(true, 0)
                .cancelable(false)
                .build();
        methodDialog.show();


        smsBroadcastReceiver.setListener((text, senderaddress) -> {
            if (text.equalsIgnoreCase("yes")) {
                dec.save();
                Toasty.success(getApplicationContext(), "Update successful").show();
                methodDialog.dismiss();
            } else {
                Toasty.error(getApplicationContext(), "Not authorised").show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(1000);
        filter.addAction(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        registerReceiver(smsBroadcastReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(smsBroadcastReceiver);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
