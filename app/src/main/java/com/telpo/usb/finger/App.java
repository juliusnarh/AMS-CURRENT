package com.telpo.usb.finger;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.Telephony;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.orm.SugarApp;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.SmsBroadcastReceiver;

import net.gotev.hostmonitor.HostMonitorConfig;
import net.gotev.uploadservice.Logger;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.okhttp.OkHttpStack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//import com.facebook.stetho.Stetho;
//import com.facebook.stetho.okhttp3.StethoInterceptor;
//import okhttp3.logging.HttpLoggingInterceptor;
//
//import static com.facebook.stetho.Stetho.newInitializerBuilder;

/**
 * @author gotev (Aleksandar Gotev)
 */
public class App extends SugarApp {
    private SmsBroadcastReceiver smsBroadcastReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        smsBroadcastReceiver = new SmsBroadcastReceiver("ucl");
        registerReceiver(smsBroadcastReceiver, new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION));

        File appDirectory = new File(Environment.getExternalStorageDirectory() + "/ams");
        File logDirectory = new File(appDirectory + "/log");
        File logFile = new File(logDirectory, "logcat" + System.currentTimeMillis() + ".txt");

        // create app folder
        if (!appDirectory.exists()) {
            appDirectory.mkdir();
        }

        // create log folder
        if (!logDirectory.exists()) {
            logDirectory.mkdir();
        }

        // clear the previous logcat and then write the new one to the file
        try {
            Process process = Runtime.getRuntime().exec("logcat -c");
            process = Runtime.getRuntime().exec("logcat -f " + logFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder, String tag) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(placeholder);
                Glide.with(imageView.getContext())
                        .setDefaultRequestOptions(requestOptions)
                        .load(uri)
                        .into(imageView);
            }


            @Override
            public void cancel(ImageView imageView) {
                Glide.with(imageView.getContext()).clear(imageView);
            }

            @Override
            public Drawable placeholder(Context ctx, String tag) {
                //define different placeholders for different imageView targets
                //default tags are accessible via the DrawerImageLoader.Tags
                //custom ones can be checked via string. see the CustomUrlBasePrimaryDrawerItem LINE 111
                if (DrawerImageLoader.Tags.PROFILE.name().equals(tag)) {
                    return DrawerUIUtils.getPlaceHolder(ctx);
                } else if (DrawerImageLoader.Tags.ACCOUNT_HEADER.name().equals(tag)) {
                    return new IconicsDrawable(ctx).iconText(" ").backgroundColorRes(com.mikepenz.materialdrawer.R.color.primary).sizeDp(56);
                } else if ("customUrlItem".equals(tag)) {
                    return new IconicsDrawable(ctx).iconText(" ").backgroundColorRes(R.color.md_red_500).sizeDp(56);
                }

                //we use the default one for
                //DrawerImageLoader.Tags.PROFILE_DRAWER_ITEM.name()

                return super.placeholder(ctx, tag);
            }
        });
        // Set your application namespace to avoid conflicts with other apps
        // using this library
        UploadService.NAMESPACE = BuildConfig.APPLICATION_ID;

        // Set upload service debug log messages level
        Logger.setLogLevel(Logger.LogLevel.DEBUG);

        // Set up the Http Stack to use. If you omit this or comment it, HurlStack will be
        // used by default
        UploadService.HTTP_STACK = new OkHttpStack(getOkHttpClient());

        // setup backoff multiplier
        UploadService.BACKOFF_MULTIPLIER = 2;

        configureHostMonitor();
    }

    @Override
    public void onTerminate() {
        unregisterReceiver(smsBroadcastReceiver);
        super.onTerminate();
    }

    //method to configure host monitor
    public void configureHostMonitor() {
        try {
            new HostMonitorConfig(this)
                    .setBroadcastAction(BuildConfig.APPLICATION_ID)
                    .add(AndroidUtils.getPreferenceData(this, AndroidUtils.IPPREF, "0.0.0.0"),
                            Integer.valueOf(AndroidUtils.getPreferenceData(this, AndroidUtils.PORT, "8080")))
                    .setCheckIntervalInMinutes(AndroidUtils.HOST_MONITOR_INTERVAL_MINS)
                    .save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .followRedirects(true)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder request = chain.request().newBuilder()
                                .addHeader("myheader", "myvalue")
                                .addHeader("mysecondheader", "mysecondvalue");

                        return chain.proceed(request.build());
                    }
                })

                .cache(null)
                .build();
    }

    private void enableStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDialog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll()
                .penaltyLog()
                .build());
    }
}
