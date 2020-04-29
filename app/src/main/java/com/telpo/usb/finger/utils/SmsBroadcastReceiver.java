package com.telpo.usb.finger.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "SmsBroadcastReceiver";

    private String serviceProviderNumber;
    private String serviceProviderSmsCondition;

    private Listener listener;

    public SmsBroadcastReceiver(String serviceProviderNumber, String serviceProviderSmsCondition) {
        this.serviceProviderNumber = serviceProviderNumber;
        this.serviceProviderSmsCondition = serviceProviderSmsCondition;
    }

    public SmsBroadcastReceiver(String serviceProviderSmsCondition) {

        this.serviceProviderSmsCondition = serviceProviderSmsCondition;
    }

    public SmsBroadcastReceiver() {
        this.serviceProviderSmsCondition = "uclmsg";
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            String smsSender = "";
            String smsBody = "";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                    smsSender = smsMessage.getDisplayOriginatingAddress();
                    smsBody += smsMessage.getMessageBody();
                }
            } else {
                Bundle smsBundle = intent.getExtras();
                if (smsBundle != null) {
                    Object[] pdus = (Object[]) smsBundle.get("pdus");
                    if (pdus == null) {
                        // Display some error to the user
                        Log.e(TAG, "SmsBundle had no pdus key");
                        return;
                    }
                    SmsMessage[] messages = new SmsMessage[pdus.length];
                    for (int i = 0; i < messages.length; i++) {
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                        smsBody += messages[i].getMessageBody();
                    }
                    smsSender = messages[0].getOriginatingAddress();
                }
            }

            if (smsSender.equals(serviceProviderNumber) && smsBody.toLowerCase().contains(serviceProviderSmsCondition)) {
                if (listener != null) {
                    listener.onTextReceived(smsBody, smsSender);
                }
            } else if (smsSender.equals(serviceProviderNumber) && serviceProviderSmsCondition.equals("y")) {
                if (listener != null) {
                    listener.onTextReceived(smsBody, smsSender);
                }
            } else if (smsBody.toLowerCase().contains(serviceProviderSmsCondition)) {
                if (listener != null) {
                    if (smsBody.charAt(smsBody.length() - 1) == '\n')
                        smsBody = smsBody.substring(0, smsBody.length() - 1);
                    if (smsBody.charAt(smsBody.length() - 1) == '\n') {
                        smsBody = smsBody.substring(0, smsBody.length() - 1);
                    }
                    listener.onTextReceived(smsBody, smsSender);
                }
            } else if (smsBody.toLowerCase().contains("*")) {
                if (listener != null) {
                    if (smsBody.charAt(smsBody.length() - 1) == '\n')
                        smsBody = smsBody.substring(0, smsBody.length() - 1);
                    if (smsBody.charAt(smsBody.length() - 1) == '\n') {
                        smsBody = smsBody.substring(0, smsBody.length() - 1);
                    }
                    listener.onTextReceived(smsBody, smsSender);
                }
            }


        }
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void onTextReceived(String text, String senderaddress);
    }
}