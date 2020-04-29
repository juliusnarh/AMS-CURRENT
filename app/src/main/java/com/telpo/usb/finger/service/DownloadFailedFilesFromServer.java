package com.telpo.usb.finger.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.telpo.usb.finger.activities.ExportFarmersAssignedAggActivity;
import com.telpo.usb.finger.entities.OrderCart;
import com.telpo.usb.finger.entities.ServerFilesStatus;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.ApiClient;
import com.telpo.usb.finger.utils.ApiService;
import com.telpo.usb.finger.utils.LoadFiles;
import com.telpo.usb.finger.utils.WriteResponseBodyToDisk;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownloadFailedFilesFromServer extends Service {
    public static final String BROADCAST_ACTION = "com.telpo.usb.finger.service";
    private static final String TAG = "DOWNLOADFAILEDFILES";
    private final Handler handler = new Handler();
    Intent intent;
    private ApiService apiService;
    private Runnable sendUpdatesToUI = new Runnable() {
        public void run() {
            DisplayLoggingInfo();
            handler.postDelayed(this, 500);
        }
    };

    public DownloadFailedFilesFromServer() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        intent = new Intent(BROADCAST_ACTION);
        apiService = ApiClient.getClient().create(ApiService.class);
        Log.d(TAG, "SERVICE CREATED");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "SERVICE STARTED");
        handler.removeCallbacks(sendUpdatesToUI);
        handler.postDelayed(sendUpdatesToUI, 60000);
        return START_NOT_STICKY;
    }

    private void DisplayLoggingInfo() {
        Log.d(TAG, "entered DisplayLoggingInfo");

        List<ServerFilesStatus> serverFilesStatusList = ServerFilesStatus.listAll(ServerFilesStatus.class);
        Log.d(TAG, "DOWNLOAD FAILED SIZE: "+serverFilesStatusList.size());

//        if (serverFilesStatusList.size() > 0){
//            for (ServerFilesStatus filesStatus: serverFilesStatusList ){
//                Call<ResponseBody> call = apiService.downloadFarmerJsonFiles(filesStatus.getUrl());
//                makeHttpCall(call, filesStatus.getUrl());
//            }
//        }

        sendBroadcast(intent);
    }

    private void makeHttpCall(Call<ResponseBody> callX, String url) {
        List<ServerFilesStatus> filesStatus = ServerFilesStatus.find(ServerFilesStatus.class, "url = ?", url);
        try {
            Response<ResponseBody> response = callX.execute();
            if (response.isSuccessful())
                new WriteResponseBodyToDisk(response.body(), url);

        } catch (IOException e) {
            e.printStackTrace();
        }
        callX.enqueue(new Callback<ResponseBody>() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "server contacted and has file");
                    new WriteResponseBodyToDisk(response.body(), url);
                } else {
                    Log.d(TAG, "server contact failed");

                    if (filesStatus.size() == 0) {
                        ServerFilesStatus status = new ServerFilesStatus(url, false);
                        status.save();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "error");
                if (filesStatus.size() == 0) {
                    ServerFilesStatus status = new ServerFilesStatus(url, false);
                    status.save();
                }
            }
        });
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
