package com.telpo.usb.finger.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.util.Log;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.List;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class Agentservice extends Service {
    public static final String BROADCAST_ACTION = "com.telpo.usb.finger.activities.AgentActivity";
    private static final String TAG = "AGENTSERVICE";
    private final Handler handler = new Handler();
    String topid = null;
    Intent intent;
    boolean onceago = true;
    Double pay = 0.00, totalrecov = 0.00, amountowing = 0.00, totalpurchase = 0.00, totalrev = 0.00, topyeild = 0.00, totalexpectedweight = 0.00, moisturec = 0.00, totalweight = 0.00, unrecoveredbags = 0.00;
    int nsub = 0, totalrecovloc = 0, totalpurchaseloc = 0, sub = 0, cash = 0, mm = 0, ba = 0, redeemed = 0, owing = 0, male = 0, female = 0;
    Float _01 = 0f, _02 = 0f, _03 = 0f, _04 = 0f, _05 = 0f, _06 = 0f, _07 = 0f, _08 = 0f, _09 = 0f, _10 = 0f, _11 = 0f, _12 = 0f;
    private Runnable sendUpdatesToUI = new Runnable() {
        public void run() {
            DisplayLoggingInfo();
            pay = 0.00;
            totalrecov = 0.00;
            totalpurchase = 0.00;
            totalrev = 0.00;
            topyeild = 0.00;
            totalexpectedweight = 0.00;
            moisturec = 0.00;
            totalweight = 0.00;
            unrecoveredbags = 0.00;
            nsub = 0;
            totalrecovloc = 0;
            totalpurchaseloc = 0;
            sub = 0;
            cash = 0;
            mm = 0;
            ba = 0;
            redeemed = 0;
            owing = 0;
            male = 0;
            female = 0;
            _01 = 0f;
            _02 = 0f;
            _03 = 0f;
            _04 = 0f;
            _05 = 0f;
            _06 = 0f;
            _07 = 0f;
            _08 = 0f;
            _09 = 0f;
            _10 = 0f;
            _11 = 0f;
            _12 = 0f;

//            handler.postDelayed(this, 10000); // 3 mins
            handler.postDelayed(this, 6000);
        }
    };

    public Agentservice() {
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
        handler.postDelayed(sendUpdatesToUI, 2000);
        return START_NOT_STICKY;
    }

    private void DisplayLoggingInfo() {
        if (onceago) {
            Log.d(TAG, "entered DisplayLoggingInfo");
            List<Salestran> salestranList = Salestran.listAll(Salestran.class);
            List<Declaration> declarationList = Declaration.listAll(Declaration.class);
            List<Scaletran> scaletranList = Scaletran.listAll(Scaletran.class);
            List<Farmers> farmersList = Farmers.listAll(Farmers.class);

            for (Farmers farmers : farmersList) {
                if (farmers.getGender().toLowerCase().startsWith("m")) {
                    male += 1;
                } else female += 1;
            }

            String[] mMonths = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

            for (int i = 0; i < salestranList.size(); i++) {

                String month = AndroidUtils.dateToFormattedStringmonth(salestranList.get(i).getDatecreated());

                if (month.equals(mMonths[0])) {
                    Double temp = salestranList.get(i).getTotalCost();
                    _01 += temp.floatValue();
                }
                if (month.equals(mMonths[1])) {
                    Double temp = salestranList.get(i).getTotalCost();
                    _02 += temp.floatValue();
                }
                if (month.equals(mMonths[2])) {
                    Double temp = salestranList.get(i).getTotalCost();
                    _03 += temp.floatValue();
                }
                if (month.equals(mMonths[3])) {
                    Double temp = salestranList.get(i).getTotalCost();
                    _04 += temp.floatValue();
                }
                if (month.equals(mMonths[4])) {
                    Double temp = salestranList.get(i).getTotalCost();
                    _05 += temp.floatValue();
                }
                if (month.equals(mMonths[5])) {
                    Double temp = salestranList.get(i).getTotalCost();
                    _06 += temp.floatValue();
                }
                if (month.equals(mMonths[6])) {
                    Double temp = salestranList.get(i).getTotalCost();
                    _07 += temp.floatValue();
                }
                if (month.equals(mMonths[7])) {
                    Double temp = salestranList.get(i).getTotalCost();
                    _08 += temp.floatValue();
                }
                if (month.equals(mMonths[8])) {
                    Double temp = salestranList.get(i).getTotalCost();
                    _09 += temp.floatValue();
                }
                if (month.equals(mMonths[9])) {
                    Double temp = salestranList.get(i).getTotalCost();
                    _10 += temp.floatValue();
                }
                if (month.equals(mMonths[10])) {
                    Double temp = salestranList.get(i).getTotalCost();
                    _11 += temp.floatValue();
                }
                if (month.equals(mMonths[11])) {
                    double temp = salestranList.get(i).getTotalCost();
                    _12 += (float) temp;
                }

                if (salestranList.get(i).getPaymentmethod().toLowerCase().startsWith("bar")) {
                    sub += 1;
                    ba += 1;
                } else {
                    nsub += 1;

                    if (salestranList.get(i).getPaymentmethod().toLowerCase().startsWith("cas")) {
                        cash += 1;
                    } else if (salestranList.get(i).getPaymentmethod().toLowerCase().startsWith("mobil")) {
                        mm += 1;
                    }
                }


                totalrev += salestranList.get(i).getPayableamt();

            }

            for (Declaration declaration : declarationList) {
                if (declaration.getStatus().equalsIgnoreCase("owing")) {
                    owing += 1;
                    unrecoveredbags += declaration.getNorecoverybags();
                    totalexpectedweight += 50 * declaration.getNorecoverybags();
//                try {
//                    totalrecov += ((14 * Integer.parseInt(declaration.getAcreage())) - declaration.getNorecoverybags());
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
                } else if (declaration.getStatus().equalsIgnoreCase("redeemed")) {
//                totalrecov += 14 * Integer.parseInt(declaration.getAcreage());
                    redeemed += 1;
                }

                amountowing += declaration.getTotalCost() - declaration.getAppliedsub();

                String declarationparts[] = declaration.getDeclaration().split(" ");
                for (int x = 0; x < declarationparts.length; x++) {
                    if (declarationparts[x].equals("exchange")) {
                        totalrecov += Double.parseDouble(declarationparts[x + 1]) - declaration.getNorecoverybags();
                        pay += Double.parseDouble(declarationparts[x + 1]);
                        break;
                    }
                }
            }

            for (Scaletran scaletran : scaletranList) {

                if (scaletran.getTransid().startsWith(AndroidUtils.RECOVERY)) {
                    totalrecovloc += 1;
                } else if (scaletran.getTransid().startsWith(AndroidUtils.PURCHASE)) {
                    totalpurchase += Double.parseDouble(scaletran.getTendered());
                    totalpurchaseloc += 1;
                }

                moisturec += scaletran.getMoisturecontent();

                topid = scaletran.getFarmerid();
                try {
                    if (topyeild < Double.parseDouble(scaletran.getTendered())) {
                        topyeild = Double.parseDouble(scaletran.getTendered());
                        topid = scaletran.getFarmerid();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            moisturec = moisturec / scaletranList.size();

            if (moisturec.isNaN()) {
                moisturec = 0.00;
            }
            intent.putExtra("salestran", String.valueOf(salestranList.size()));
            intent.putExtra("nsub", String.valueOf(nsub));
            intent.putExtra("sub", String.valueOf(sub));
            intent.putExtra("cash", String.valueOf(cash));
            intent.putExtra("mm", String.valueOf(mm));
            intent.putExtra("ba", String.valueOf(ba));
            intent.putExtra("declaration", String.valueOf(declarationList.size()));
            intent.putExtra("owing", String.valueOf(owing));
            intent.putExtra("redeemed", String.valueOf(redeemed));
            intent.putExtra("scaletran", String.valueOf(scaletranList.size()));
            intent.putExtra("decexpected", getResources().getString(R.string.weight, totalexpectedweight));
            intent.putExtra("totalpayable", getResources().getString(R.string.expected, pay));
            intent.putExtra("totalpayableraw", String.valueOf(pay));
            intent.putExtra("recovraw", String.valueOf(totalrecov));
            intent.putExtra("revenue", getResources().getString(R.string.price_item, totalrev));
            intent.putExtra("recov", getResources().getString(R.string.expected, totalrecov));
            intent.putExtra("unrecov", getResources().getString(R.string.expected, unrecoveredbags));
            intent.putExtra("purchases", getResources().getString(R.string.expected, totalpurchase));
            intent.putExtra("avemoist", getResources().getString(R.string.price, moisturec));
            intent.putExtra("farmers", String.valueOf(farmersList.size()));
            intent.putExtra("male", String.valueOf(male));
            intent.putExtra("female", String.valueOf(female));
            intent.putExtra("totalpurchaseloc", String.valueOf(totalpurchaseloc));
            intent.putExtra("totalrecovloc", String.valueOf(totalrecovloc));
            intent.putExtra("amountowing", getResources().getString(R.string.price_item, amountowing));
            if (topid != null && !topid.isEmpty()) {
                intent.putExtra("topid", topid);
            }
            intent.putExtra("_01", _01);
            intent.putExtra("_02", _02);
            intent.putExtra("_03", _03);
            intent.putExtra("_04", _04);
            intent.putExtra("_05", _05);
            intent.putExtra("_06", _06);
            intent.putExtra("_07", _07);
            intent.putExtra("_08", _08);
            intent.putExtra("_09", _09);
            intent.putExtra("_10", _10);
            intent.putExtra("_11", _11);
            intent.putExtra("_12", _12);

            sendBroadcast(intent);
            onceago = false;
        }
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
