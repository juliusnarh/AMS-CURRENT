package com.telpo.usb.finger.activities;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.hootsuite.nachos.terminator.ChipTerminatorHandler;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.ActivitySendBulkSmsBinding;
import com.telpo.usb.finger.dialogforms.TemplateDialog;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.inputdistributions_fragment.SelectFarmerDialog;
import com.telpo.usb.finger.interfaces.GetTemplateClickListener;
import com.telpo.usb.finger.interfaces.SaveSelectedFarmersClickListener;

import java.util.List;
import java.util.StringTokenizer;

import es.dmoral.toasty.Toasty;

public class SendBulkSmsActivity extends AppCompatActivity implements SaveSelectedFarmersClickListener, GetTemplateClickListener {
    ActivitySendBulkSmsBinding binding;
    SelectFarmerDialog dialog = null;
    StringBuilder contactbuilder;
    TemplateDialog templateDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupWindowAnimations();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_send_bulk_sms);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        templateDialog = TemplateDialog.newInstance(this);
        contactbuilder = new StringBuilder();
        binding.addaggregators.setOnClickListener(v -> {
            dialog = SelectFarmerDialog.newInstance("", this);
            dialog.show(getSupportFragmentManager(), SelectFarmerDialog.TAG);
        });

        binding.to.addChipTerminator('*', ChipTerminatorHandler.BEHAVIOR_CHIPIFY_TO_TERMINATOR);

        binding.send.setOnClickListener(v -> {
            if (contactbuilder.toString().length() > 0 && binding.messagebody.getText().toString().length() > 0) {
                StringTokenizer st = new StringTokenizer(contactbuilder.toString(), ",");
                while (st.hasMoreElements()) {
                    String aggnumber = (String) st.nextElement();
                    if (aggnumber.length() > 0 && aggnumber.trim().length() > 0) {
                        sendSMS(aggnumber, binding.subject.getText().toString() + "\n" + binding.messagebody.getText().toString().trim());
                    }
                }

                binding.messagebody.setText("");
                binding.subject.setText("");
                binding.to.setText("");
                contactbuilder = new StringBuilder();
                Toasty.success(getApplicationContext(), "Message Sent!").show();
                finish();
            } else {
                Toasty.error(getApplicationContext(), "Error occurred").show();
            }

        });
    }

    private void sendSMS(String phoneNumber, String message) {
        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
                new Intent(SENT), 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
                new Intent(DELIVERED), 0);

        //---when the SMS has been sent---
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS sent",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generic failure",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "No service",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio off",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(SENT));

        //---when the SMS has been delivered---
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toasty.success(getApplicationContext(), "SMS delivered").show();

                        break;
                    case Activity.RESULT_CANCELED:
                        Toasty.error(getApplicationContext(), "SMS not delivered").show();

                        break;
                }
            }
        }, new IntentFilter(DELIVERED));

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
    }

    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);
    }

    @Override
    public void onSaveSelectedFarmersClickListener(List<Farmers> farmersList) {
        StringBuilder namebuilder = new StringBuilder();
        contactbuilder = new StringBuilder();
        for (Farmers farmers : farmersList) {
            namebuilder.append(farmers.getSurname() + " " + farmers.getOthername()).append('*');
            contactbuilder.append(farmers.getTel()).append(',');
        }

        dialog.dismiss();
        binding.to.setText(namebuilder.toString().trim());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_send_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.template: {
                templateDialog.show(getSupportFragmentManager(), TemplateDialog.TAG);
                return true;
            }
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void ongetTemplateClickListener(String template) {
        if (templateDialog != null)
            templateDialog.dismiss();
        binding.messagebody.setText(template);
        binding.messagebody.requestFocus();
    }
}
