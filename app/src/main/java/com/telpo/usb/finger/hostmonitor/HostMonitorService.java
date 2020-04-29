package com.telpo.usb.finger.hostmonitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.telpo.usb.finger.utils.AndroidUtils;

import net.gotev.hostmonitor.HostMonitorBroadcastReceiver;
import net.gotev.hostmonitor.HostStatus;

import java.io.File;
import java.util.List;

/**
 * Created by Junior on 1/6/2018.
 */

public class HostMonitorService extends Service {
    private static final String TAG = "HostMonitorService";
    private final HostMonitorBroadcastReceiver receiver = new HostMonitorBroadcastReceiver() {
        @Override
        public void onHostStatusChanged(HostStatus status) {
            Log.i(TAG, status.toString());
            if (status.isReachable()) {
                AndroidUtils.uploadFileToServer(getBaseContext());
            }
        }
    };
    String dirpath;
    List<File> fileList;
    String uploadid;
    private boolean isRunning = false;

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");

        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "HostMonitor Service onStartCommand");
        receiver.register(this);
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {

        isRunning = false;
        receiver.unregister(this);
        Log.i(TAG, "Service onDestroy");
    }
}
