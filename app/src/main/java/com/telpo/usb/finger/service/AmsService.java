package com.telpo.usb.finger.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.util.Log;

import com.telpo.usb.finger.entities.OrderCart;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.List;

public class AmsService extends Service {
    public static final String BROADCAST_ACTION = "com.ams.inputdistribution_ams";
    private static final String TAG = "AMS SERVICE";
    private final Handler handler = new Handler();
    Intent intent;
    private Runnable sendUpdatesToUI = new Runnable() {
        public void run() {
            DisplayLoggingInfo();
            handler.postDelayed(this, 500);
        }
    };

    public AmsService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        intent = new Intent(BROADCAST_ACTION);
        Log.d(TAG, "SERVICE CREATED");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "SERVICE STARTED");
        handler.removeCallbacks(sendUpdatesToUI);
        handler.postDelayed(sendUpdatesToUI, 500);
        return START_NOT_STICKY;
    }

    private void DisplayLoggingInfo() {
        Log.d(TAG, "entered DisplayLoggingInfo");

        List<OrderCart> carts = OrderCart.find(OrderCart.class, "farmerid = ?", AndroidUtils.getPreferenceData(getApplicationContext(), AndroidUtils.FAFFARMERID_PREF, ""));
        intent.putExtra("cartCount", String.valueOf(carts.size()));

        Log.d(TAG, String.valueOf(OrderCart.count(OrderCart.class)));

        sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(sendUpdatesToUI);
        Log.d(TAG, "onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
