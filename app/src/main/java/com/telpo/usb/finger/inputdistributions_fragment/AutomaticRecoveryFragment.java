package com.telpo.usb.finger.inputdistributions_fragment;

import android.annotation.SuppressLint;
import androidx.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.AutoScaletranAdapter;
import com.telpo.usb.finger.databinding.FragmentAutomaticRecoveryBinding;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.dmoral.toasty.Toasty;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;

public class AutomaticRecoveryFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String URL_POST = "https://uclgroupgh.com/UCLAMS/main/Purchasing/android/androidscaleinsert.php";
    final int handlerState = 0;                        //used to identify handler message
    FragmentAutomaticRecoveryBinding binding;
    EditText ip, port;
    Handler scaledata;
    List<Scaletran> autoscaleList;
    AutoScaletranAdapter autoScaletranAdapter;
    String log = "", logdatapath, type, farmerid;
    boolean reconnectonce = true;
    int count = 0;
    ScaleSockectConn scaleconn;
    private boolean stopThread, connected, logging;

    public AutomaticRecoveryFragment() {
        // Required empty public constructor
    }

    public static AutomaticRecoveryFragment newInstance(String farmerid, String type) {
        AutomaticRecoveryFragment fragment = new AutomaticRecoveryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, farmerid);
        args.putString(ARG_PARAM2, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        if (getArguments() != null) {
            farmerid = getArguments().getString(ARG_PARAM1);
            type = getArguments().getString(ARG_PARAM2);
            autoscaleList = new ArrayList<>();
        }
    }

    @SuppressLint("HandlerLeak")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_automatic_recovery, container, false);
        View view = binding.getRoot();
        stopThread = false;
        logging = false;
        SimpleDateFormat currentdate = new SimpleDateFormat("yyyyMMdd");
        logdatapath = currentdate.format(new Date()) + ".txt";
        logging = true;
        binding.emptyFolder.setColorFilter(getResources().getColor(R.color.colorPrimary));
        binding.emptyFolder.setAnimation("bot_typing.json");
        binding.emptyFolder.playAnimation();
        seteuprecycler();

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //you were working on the folder directory
                //ams/scalelogs....
                if (logging) {
                    logging = false;
                    binding.save.setBackground(getResources().getDrawable(R.drawable.background_autoscale_button));
                    binding.saveLabel.setTextColor(getResources().getColor(R.color.grey_600));
                    binding.img.setImageResource(R.drawable.twotone_save_24);
                    Toasty.error(getContext(), "Logging stopped").show();
                } else {
                    logging = true;
                    binding.save.setBackground(getResources().getDrawable(R.drawable.background_autoscale_button2));
                    binding.saveLabel.setTextColor(getResources().getColor(R.color.white));
                    binding.img.setImageResource(R.drawable.twotone_save_white_24);
                    Toasty.success(getContext(), "Logging started").show();
                }
            }
        });

        binding.connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleconn = new ScaleSockectConn();
                if (connected) {
                    scaleconn.closesocketandStreams();
                    if (!binding.wifiDisconnected.isAnimating()) {
                        binding.wifiDisconnected.playAnimation();
                    }
                    binding.wifiDisconnected.setVisibility(View.VISIBLE);
                    binding.wifiConnected.setVisibility(View.INVISIBLE);
                    binding.connectedlabel.setText("connect");
                } else {
                    final MaterialDialog ipport = new MaterialDialog.Builder(getActivity())
                            .title("Connect to Scale")
                            .titleColor(getResources().getColor(R.color.grey_600))
                            .autoDismiss(true)
                            .customView(R.layout.custom_ip_port, true)
                            .positiveText("Ok")
                            .onPositive((dialog, which) -> {

                                if (!port.getText().toString().trim().isEmpty() && !ip.getText().toString().trim().isEmpty()) {
                                    connected = false;
                                    AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.SCALEPORT, port.getText().toString().trim());
                                    AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.SCALEIP, ip.getText().toString().trim());

                                    Thread thread = new Thread(scaleconn);
                                    thread.start();

                                    while (!connected) {
                                        if (scaleconn.mysocket != null) {
                                            if (scaleconn.mysocket.isBound()) {
                                                binding.wifiDisconnected.setVisibility(View.INVISIBLE);
                                                binding.wifiDisconnected.pauseAnimation();
                                                binding.wifiConnected.setVisibility(View.VISIBLE);
                                                binding.connectedlabel.setText("connected");
                                            }
                                        }
                                    }
                                    Log.d("FROMSCALE", "THREAD: STARTING THREAD");

                                } else Toasty.error(getContext(), "Invalid values").show();

                            })
                            .negativeText(R.string.negative)
                            .show();

                    assert ipport.getCustomView() != null;
                    ip = ipport.getCustomView().findViewById(R.id.ip);
                    port = ipport.getCustomView().findViewById(R.id.port);
                    ip.setText(AndroidUtils.getPreferenceData(getContext(), AndroidUtils.SCALEIP, " "));
                    port.setText(AndroidUtils.getPreferenceData(getContext(), AndroidUtils.SCALEPORT, " "));
                }
            }
        });

        binding.verifyUpload.setOnClickListener(v -> {
            //            prepareuploadfiles(autoScaletranAdapter.scaletranList.get(autoScaletranAdapter.scaletranList.size()-1));
            //            uploadscaletran();
            for (Scaletran scaletran : autoScaletranAdapter.scaletranList) {
                postdatatoserver(scaletran);
            }
        });

        scaledata = new Handler() {

            public void handleMessage(android.os.Message msg) {
                Log.d("DEBUG", "handleMessage");

                if (msg != null) {
                    if (msg.what == handlerState) {
                        binding.emptyFolder.setVisibility(View.GONE);
                        binding.emptyFolder.pauseAnimation();
                        binding.waiting.setVisibility(View.GONE);
                        binding.autoscaleRecycler.setVisibility(View.VISIBLE);
                        String readMessage = (String) msg.obj;

                        Log.d("FROMSCALE", "IN SCALEDATA HANDLER: " + readMessage);

                        if (readMessage.trim().contains("WEIGHING START")) {
                            binding.weighingstart.setVisibility(View.VISIBLE);
                        } else if (readMessage.equals("error")) {
                            Log.d("FROMSCALE", "IN ERROR CONDITION: " + readMessage);

                            Toasty.error(getContext(), "Failed connection").show();
                            Toasty.error(getContext(), "Reconnecting...").show();
                            if (reconnectonce) {
                                restartconnection();
                                reconnectonce = false;
                            } else {
                                scaleconn.closesocketandStreams();
                            }
                        } else {
                            String[] messageparts = readMessage.split(",");
                            Log.d("FROMSCALE", "IN SCALEDATA HANDLER: " + readMessage);

                            Scaletran scaletran = new Scaletran();
                            scaletran.transid = gentransid();
                            scaletran.farmerid = messageparts[4];
                            scaletran.scaleid = messageparts[2];
                            scaletran.pcid = messageparts[12].replace("^", "");
                            scaletran.bcid = messageparts[11];
                            scaletran.name = messageparts[5];
                            scaletran.phone = "";
                            scaletran.payable = "";
                            scaletran.tendered = "";
                            scaletran.count = Double.parseDouble(messageparts[8]);
                            scaletran.weight = Double.parseDouble(messageparts[10]);
                            scaletran.moisturecontent = 0.00;
                            scaletran.amount = 0.00;
                            scaletran.time = AndroidUtils.dateStringToDate(messageparts[7], "hh:mm:ss");
                            scaletran.date = AndroidUtils.dateStringToDate(messageparts[6], "yyyy-MM-dd");
                            scaletran.uniqueuid = AndroidUtils.getUUID();
                            scaletran.synstatus = "";
                            scaletran.datecreated = new Date();
                            scaletran.macaddress = AndroidUtils.getMacAddress(getContext());
                            scaletran.imei = AndroidUtils.getIMEI(getContext());
                            scaletran.agentname = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTNAME, "");
                            scaletran.agentid = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTID, "");

                            autoScaletranAdapter.addtransaction(scaletran);
//                            autoscaleList.add(scaletran);
                            if (autoScaletranAdapter.getItemCount() > 0) {
                                binding.emptyFolder.setVisibility(View.GONE);
                                binding.waiting.setVisibility(View.GONE);
                                binding.autoscaleRecycler.setVisibility(View.VISIBLE);
                                binding.verifyUpload.setVisibility(View.VISIBLE);
                            } else binding.verifyUpload.setVisibility(View.GONE);
                        }
                    }
                }
            }
        };
        return view;
    }

    private void prepareuploadfiles(Scaletran scaletran) {
        scaletran.save();
        ServerTransfer transfer = new ServerTransfer();
        transfer.setScaletran(scaletran);
        String jsonstring = new Gson().toJson(transfer);
        String uploadId = AndroidUtils.getUUID();
        String uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
    }

    private void restartconnection() {
        Log.d("FROMSCALE", "IN RESTARTING CONNECTION: RESTARTING...");
        scaleconn = new ScaleSockectConn();
        Thread thread = new Thread(scaleconn);
        thread.start();
        Log.d("FROMSCALE", "IN RESTARTING CONNECTION: CONNECTION STARTED");
    }

    private void seteuprecycler() {
        binding.autoscaleRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.autoscaleRecycler.setItemAnimator(new FadeInAnimator());
        binding.autoscaleRecycler.getItemAnimator().setAddDuration(1200);
        autoScaletranAdapter = new AutoScaletranAdapter(getContext(), autoscaleList);
        binding.autoscaleRecycler.setAdapter(autoScaletranAdapter);
    }

    private void postdatatoserver(Scaletran scaletran) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_POST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Volley Response", "" + response);
                Toasty.normal(getContext(), response).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> postMap = new HashMap<>();
                postMap.put("scaleid", scaletran.getScaleid());
                postMap.put("IMEI", scaletran.getImei());
                postMap.put("rfid", "n/a");
                postMap.put("farmerid", scaletran.getFarmerid());
                postMap.put("name", scaletran.getName());
                postMap.put("date", AndroidUtils.dateToFormattedString(scaletran.getDate(), "yyyy-MM-dd"));
                postMap.put("time", AndroidUtils.dateToFormattedString(scaletran.getTime(), "hh:mm:ss"));
                postMap.put("counts", String.valueOf(scaletran.getCount()));
                postMap.put("weight", String.valueOf(scaletran.getWeight()));
                postMap.put("moisturecontent", String.valueOf(scaletran.getMoisturecontent()));
                postMap.put("total", String.valueOf(scaletran.getCount() * scaletran.getWeight()));
                postMap.put("bcid", scaletran.getBcid());
                postMap.put("pcid", scaletran.getPcid());
                return postMap;
            }
        };

        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }

    public void uploadscaletran() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, Void, Boolean> asyncTask = new AsyncTask<Void, Void, Boolean>() {
            boolean result = false;

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    AndroidUtils.uploadFileToServer(getContext());
                    result = true;

                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();

                }
                return result;
            }

            @Override
            protected void onPostExecute(Boolean result) {
                if (result) {

                    autoScaletranAdapter.scaletranList.clear();
                    autoScaletranAdapter.notifyDataSetChanged();

                    Toasty.success(getContext(), "Upload Successful").show();
                }
            }

        };
        asyncTask.execute();
    }

    public String gentransid() {
        return "SCL" + AndroidUtils.getIMEI(getContext()) + AndroidUtils.dateToFormattedString(new Date(), "yyyyMMddHHmmss");
    }

    public class ScaleSockectConn implements Runnable {

        Socket mysocket;
        InputStream inputStream = null;

        @Override
        public void run() {
            try {
                Log.d("FROMSCALE", "IN THREAD'S RUN: THREAD RUNNING");
                byte[] buffer = new byte[256];
                int bytes;

                while (!stopThread) {
                    Log.d("FROMSCALE", "IN THREAD'S RUN: WHILE LOOP");
                    try {
                        if (mysocket == null) {

                            mysocket = new Socket(ip.getText().toString().trim(), Integer.parseInt(port.getText().toString().trim()));
                            inputStream = mysocket.getInputStream();
                            if (mysocket.isBound()) {
                                Log.d("FROMSCALE", "IN THREAD'S RUN: WHILE LOOP: IS BOUND - 1");
                                connected = true;
                            }
                        } else {
                            if (mysocket.isBound()) {
                                inputStream = mysocket.getInputStream();
                                Log.d("FROMSCALE", "IN THREAD'S RUN: WHILE LOOP: IS BOUND - 2");
                                connected = true;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String oldlog = AndroidUtils.readfromscalelog(logdatapath, getContext());
                    if (!oldlog.isEmpty() || oldlog != null) {
                        log = oldlog;
                    }
                    if (inputStream != null) {

                        bytes = inputStream.read(buffer);
                        String readMessage = new String(buffer, 0, bytes);
                        readMessage = readMessage.replace("\n", "").replace("\r", "");

                        //add time transaction was received from scale
                        count++;
                        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss aaa");
                        String timestamp = count + "-" + formatTime.format(new Date());
                        String temp = log;
                        String newmessage = temp + "\n\n" + readMessage;
                        log = newmessage + "\n" + timestamp;

                        if (logging) {
                            AndroidUtils.writeToscalelog(log, logdatapath);
                        }

                        //ASK NANA IF LOGGING SHOULD BE AUTOMATIC OR BY USER PREFERENCE
//                        if (logging) {
//                            if (log.isEmpty()) {
//
//                                log = readMessage;
//                                //add time transaction was received from scale
//                                count++;
//                                SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss aaa");
//                                String timestamp = count + "-" + formatTime.format(new Date());
//                                log = log + timestamp + "\n";
//                                AndroidUtils.writeToscalelog(log, logdatapath);
//                            } else {
//
//                                //add time transaction was received from scale
//                                count++;
//                                SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss aaa");
//                                String timestamp = count + "-" + formatTime.format(new Date());
//                                String temp = log;
//                                String newmessage = temp + "\n" + readMessage;
//                                log = newmessage + timestamp + "\n";
//                                AndroidUtils.writeToscalelog(log, logdatapath);
//                            }
//                        }

                        Log.d("FROMSCALE", "IN THREAD'S RUN: DATA RECEIVED");
                        scaledata.obtainMessage(handlerState, bytes, -1, readMessage).sendToTarget();
                    }
                }

            } catch (Exception e) {
                Log.d("FROMSCALE", "IN THREAD: FAILED TO CREATE SERVER SOCKET " + e.toString());
                scaledata.obtainMessage(handlerState, "error").sendToTarget();
                e.printStackTrace();
                closesocketandStreams();
            }
        }

        public void closesocketandStreams() {
            Log.d("FROMSCALE", "IN CLOSING SOCKET AND STREAMS");

            try {
                if (mysocket != null) {

                    mysocket.close();
                    Log.d("FROMSCALE", "IN CLOSING SOCKET AND STREAMS: SOCKECT CLOSED");
                }

                if (inputStream != null) {

                    inputStream.close();
                    Log.d("FROMSCALE", "IN CLOSING SOCKET AND STREAMS: INPUT STREAM CLOSED");
                }
                connected = false;

            } catch (IOException e2) {

            }
        }

    }
}
