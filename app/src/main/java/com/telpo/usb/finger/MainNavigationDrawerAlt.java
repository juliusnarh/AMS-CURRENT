package com.telpo.usb.finger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.FragmentManager;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.github.clans.fab.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.itemanimators.AlphaCrossFadeAnimator;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.telpo.usb.finger.activities.AgentActivity;
import com.telpo.usb.finger.activities.ExportFarmersAssignedAggActivity;
import com.telpo.usb.finger.activities.FarmSearchView;
import com.telpo.usb.finger.activities.FarmerActivity;
import com.telpo.usb.finger.activities.LoginActivityAlt;
import com.telpo.usb.finger.activities.ReceiveInputsActivity;
import com.telpo.usb.finger.activities.SendBulkSmsActivity;
import com.telpo.usb.finger.editfragments.IPSettingsFragment;
import com.telpo.usb.finger.entities.ActivityInfo;
import com.telpo.usb.finger.entities.Aggregator;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.Districts;
import com.telpo.usb.finger.entities.FarmAssessment;
import com.telpo.usb.finger.entities.Farmeridcard;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Farms;
import com.telpo.usb.finger.entities.Gallery;
import com.telpo.usb.finger.entities.Household;
import com.telpo.usb.finger.entities.LocationCoordinates;
import com.telpo.usb.finger.entities.Regions;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.entities.SupportDocs;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.entities.Userfingerprint;
import com.telpo.usb.finger.hostmonitor.HostMonitorService;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.serverentities.Activityinfo;
import com.telpo.usb.finger.serverentities.Basicfarmerinfo;
import com.telpo.usb.finger.serverentities.Declarationinfo;
import com.telpo.usb.finger.serverentities.FarmAssessmentinfo;
import com.telpo.usb.finger.serverentities.Farmerbiometrics;
import com.telpo.usb.finger.serverentities.Farmerfingers;
import com.telpo.usb.finger.serverentities.Farminfo;
import com.telpo.usb.finger.serverentities.FarminfoForBackup;
import com.telpo.usb.finger.serverentities.Locationinfo;
import com.telpo.usb.finger.serverentities.Salesinfo;
import com.telpo.usb.finger.serverentities.Salestraninfo;
import com.telpo.usb.finger.serverentities.Scaletraninfo;
import com.telpo.usb.finger.serverentities.Supportdocs;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.BackupData;
import com.telpo.usb.finger.utils.Constants;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class MainNavigationDrawerAlt extends AppCompatActivity implements BackupData.OnBackupListener, ListDialogFragment.OnListDialogItemSelect {
    private static final int PROFILE_SETTING = 100000;
    //Mar 13, 2018 12:28:38 AM --May 19 ,2018 17:08:29
    private static final String[] DATE_FORMATS = new String[]{"MMM dd, yyyy HH:mm:ss a", "MMM dd, yyyy HH:mm:ss", "MMM dd, yyyy", "MMM d, yyyy", "HH:mm:ss a"};
    protected ProgressDialog progressdiag;
    TextView txtfarmercount, txtfarmcount;
    LinearLayout summarylayout;
    StringBuilder contract = new StringBuilder();
    BackupData backupData;
    MaterialDialog progDialog;
    FragmentManager fm;
    ListDialogFragment dialogFragment;
    String[] listitems, jsonContentsList;
    String populationpath = "", farmerid, uniqueuid, jsonstring;
    Salesinfo[] saleslist = null;
    Salestraninfo[] salestranlist = null;
    Declarationinfo[] declarationlist = null;
    Scaletraninfo[] scaletranlist = null;
    FarmAssessmentinfo[] farmAssessmentlist = null;
    Supportdocs[] doclist = null;
    Farmerbiometrics[] biolist = null;
    Farmerfingers[] fingerprintList = null;
    Locationinfo[] loclist = null;
    Farminfo[] farmlist = null;
    FarminfoForBackup[] farmForBackupList = null;
    com.telpo.usb.finger.serverentities.Household[] hselist = null;
    Basicfarmerinfo[] basiclist = null;
    com.telpo.usb.finger.serverentities.Farmeridcard[] idcardlist = null;
    Activityinfo[] actlist = null;
    com.telpo.usb.finger.serverentities.Regions[] regionlist = null;
    com.telpo.usb.finger.serverentities.Districts[] districtlist = null;
    Gson gson = null;
    String basefilename = "";
    List<String> stringRequestTags = new ArrayList<>();
    CoordinatorLayout cL;
    private int numberOfRequestsToMake = 0;
    private int[] filesIndexList;
    boolean checked, stillRunning = true, hasRequestFailed = false;
    private static final String TAG_ACTIVITY_INFO = "activityInfo";
    private static final String TAG_FARMS = "farms";
    private static final String TAG_LOCATION = "locationCoordinates";
    private static final String TAG_FARMERID_CARD = "farmeridcard";
    private static final String TAG_SUPPORT_DOCS = "supportdocs";
    private static final String TAG_FARMERS = "farmers";
    private static final String TAG_USER_BIOMETRICS = "userbiometrics";
    private static final String TAG = "FARMERIDCHECK";
    ProgressDialog pDialog;
    //save our header or result
    private AccountHeader headerResult = null;
    private Drawer result = null;
    private FloatingActionButton menufarmer;
    private FloatingActionButton menufarm;
    private FloatingActionButton menuaggregator;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation_alt);
        setupWindowAnimations();
        Toolbar toolbar = findViewById(R.id.toolbar);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        setupToolbar(toolbar);
        new DeleteFarmers().execute();
        setupLayoutViews();
        setupBackupClass();
        setupClickListeners();
        setupNavigationDrawer(savedInstanceState, toolbar);
        farmersCount();
        farmsCount();

        startHostMonitor();
    }

    private void setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("WELCOME");
    }

    private void setupNavigationDrawer(Bundle savedInstanceState, Toolbar toolbar) {
        final IProfile profile = new ProfileDrawerItem()
                .withName(AndroidUtils.getPreferenceData(getApplicationContext(), AndroidUtils.AGENTNAME, ""))
                .withEmail(AndroidUtils.getPreferenceData(getApplicationContext(), AndroidUtils.AGENTID, ""))
                .withIcon("https://avatars2.githubusercontent.com/u/3597376?v=3&s=460").withIdentifier(100);


        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withHeaderBackground(R.drawable.ulc_logo)
                .addProfiles(profile)
                .withSavedInstance(savedInstanceState)
                .build();

        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withItemAnimator(new AlphaCrossFadeAnimator())
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.farmer).withIcon(FontAwesome.Icon.faw_user).withIdentifier(1).withSelectable(false),
                        new PrimaryDrawerItem().withName(R.string.aggregator).withIcon(FontAwesome.Icon.faw_user_secret).withIdentifier(2).withSelectable(false),
                        new PrimaryDrawerItem().withName("Receive Inputs").withIcon(FontAwesome.Icon.faw_cart_arrow_down).withIdentifier(8).withSelectable(false),
                        new PrimaryDrawerItem().withName("Send Message To Farmers").withIcon(FontAwesome.Icon.faw_comment_dots).withIdentifier(6).withSelectable(false),
//                        new PrimaryDrawerItem().withName(R.string.lbc).withIcon(FontAwesome.Icon.faw_landmark).withIdentifier(3).withSelectable(false),
//                        new PrimaryDrawerItem().withName(R.string.buying_centers).withIcon(FontAwesome.Icon.faw_eye).withIdentifier(4).withSelectable(false),
//                        new PrimaryDrawerItem().withName(R.string.accredited).withIcon(FontAwesome.Icon.faw_clipboard_list).withIdentifier(5).withSelectable(false),
//                        new PrimaryDrawerItem().withName(R.string.purchasing).withIcon(FontAwesome.Icon.faw_clipboard_check).withIdentifier(7).withSelectable(false),
                        new PrimaryDrawerItem().withName(R.string.settings).withIcon(FontAwesome.Icon.faw_cog).withIdentifier(9).withSelectable(false),
                        new PrimaryDrawerItem().withName(R.string.readcsv).withIcon(FontAwesome.Icon.faw_database).withIdentifier(10).withSelectable(false),
                        new PrimaryDrawerItem().withName(R.string.sync).withIcon(FontAwesome.Icon.faw_sync).withIdentifier(11).withSelectable(false).withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.secondary_light)),
                        new PrimaryDrawerItem().withName(R.string.logout).withIcon(FontAwesome.Icon.faw_sign_out_alt).withIdentifier(12).withSelectable(false),
                        new PrimaryDrawerItem().withName(R.string.export_farmers).withIcon(FontAwesome.Icon.faw_file_export).withIdentifier(13).withSelectable(false),
//                        new PrimaryDrawerItem().withName("Update Server").withIcon(FontAwesome.Icon.faw_upload).withIdentifier(13).withSelectable(false),
                        new PrimaryDrawerItem().withName("Backup Data").withIcon(FontAwesome.Icon.faw_file_export).withIdentifier(14).withSelectable(false),
                        new SectionDrawerItem().withName("Send us you feedbacks"),
                        new SecondaryDrawerItem().withName("E-mail").withIcon(FontAwesome.Icon.faw_envelope).withIdentifier(20).withSelectable(false),
                        new SecondaryDrawerItem().withName("Visit Our Website").withIcon(GoogleMaterial.Icon.gmd_web).withIdentifier(21).withTag("Bullhorn")

                ) // add the items we want to use with our Drawer
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 1) {
//                                navigation();
                                intent = new Intent(MainNavigationDrawerAlt.this, FarmerActivity.class);

                            }
                            else if (drawerItem.getIdentifier() == 2) {
                                intent = new Intent(MainNavigationDrawerAlt.this, AgentActivity.class);

                            } else if (drawerItem.getIdentifier() == 3) {

                            } else if (drawerItem.getIdentifier() == 4) {

                            } else if (drawerItem.getIdentifier() == 5) {

                            } else if (drawerItem.getIdentifier() == 6) {
                                intent = new Intent(MainNavigationDrawerAlt.this, SendBulkSmsActivity.class);

                            }
                            else if (drawerItem.getIdentifier() == 8) {
                                intent = new Intent(MainNavigationDrawerAlt.this, ReceiveInputsActivity.class);
                            }
                            else if (drawerItem.getIdentifier() == 9) {

                                FragmentManager fm = getSupportFragmentManager();
                                IPSettingsFragment ipSettingsFragment = new IPSettingsFragment();
                                ipSettingsFragment.show(fm, "Dialog Fragment");

                            }
                            else if (drawerItem.getIdentifier() == 10) {
                                listitems = getResources().getStringArray(R.array.populatepath);
                                showOptionDialog(listitems, "Population Path", "path");


                            }
                            else if (drawerItem.getIdentifier() == 11) {

                                if (checkInternetConnectivity()) {
                                    pDialog = new ProgressDialog(MainNavigationDrawerAlt.this);
                                    pDialog.setMessage("Working. Please wait...");
                                    pDialog.setIndeterminate(true);
                                    pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                    pDialog.setCancelable(false);
                                    pDialog.show();
                                    Handler mHandler = new Handler();
                                    Runnable runnable = new Runnable() {
                                        @Override
                                        public void run() {
                                            Log.e("runnable", "still running");
                                            if (!stillRunning) {
                                                if (pDialog.isShowing())
                                                    pDialog.dismiss();
                                                mHandler.removeCallbacks(this);
                                            }
                                        }
                                    };

                                    mHandler.postDelayed(runnable, 500);

                                    try {
                                        String jsoncontents = null;
                                        List<File> files = AndroidUtils.getListOfFiles(new File(AndroidUtils.uploadDirectoryPath()));
                                        File folder = new File(AndroidUtils.uploadTempDirectoryPath());

                                        if (!folder.exists()) {
                                            folder.mkdirs();
                                        }
                                        List<File> theTempFiles = AndroidUtils.getListOfFiles(new File(AndroidUtils.uploadTempDirectoryPath()));

                                        if (theTempFiles.size() > 0) {
                                            AndroidUtils.uploadFileToServerFromTempFolder(getApplicationContext());
                                        }

                                        if (files.size() > 0) {
                                            jsonContentsList = new String[files.size()];
                                            filesIndexList = new int[files.size()];
                                            for (int i = 0; i < files.size(); i++) {
                                                try {
                                                    InputStream is = new FileInputStream(files.get(i));
                                                    int size = is.available();
                                                    byte[] buffer = new byte[size];
                                                    is.read(buffer);
                                                    is.close();
                                                    jsoncontents = new String(buffer, StandardCharsets.UTF_8);

                                                    if (jsoncontents.equalsIgnoreCase("error") || jsoncontents == null) {
                                                        FileUtils.deleteQuietly(new File(AndroidUtils.uploadDirectoryPath() + File.separator + files.get(i).getName()));
                                                    } else {
                                                        jsonContentsList[i] = new String(buffer, StandardCharsets.UTF_8);
                                                        stringRequestTags.add(files.get(i).getName());
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                    break;
                                                }
                                            }

                                            numberOfRequestsToMake = stringRequestTags.size();

                                            if (jsonContentsList.length > 0) {
                                                for (int x = 0; x <= jsonContentsList.length; x++) {
                                                    JSONObject xxx = new JSONObject(jsonContentsList[x]);
                                                    if (xxx.has(TAG_FARMERS)) {
                                                        JSONObject farmersObject = xxx.getJSONObject(TAG_FARMERS);
                                                        List<Farmers> farmerList = Farmers.find(Farmers.class, "farmerid = ?", farmersObject.getString("farmerid"));

                                                        if (farmerList.size() > 0) {
                                                            Farmers farmers = farmerList.get(0);
                                                            checkDuplicateOnServer(farmers, xxx, files.get(x));
                                                        } else {
                                                            Farmers farmers = new Farmers();
                                                            farmers.farmerid = farmersObject.getString("farmerid");
                                                            farmers.uniqueuid = farmersObject.getString("uniqueuid");
                                                            farmers.othername = farmersObject.getString("othername");
                                                            farmers.surname = farmersObject.getString("surname");
                                                            farmers.region = farmersObject.getString("region");
                                                            farmers.district = farmersObject.getString("district");

                                                            checkDuplicateOnServer(farmers, xxx, files.get(x));

                                                        }

                                                    }
                                                    else {
                                                        if (files.get(x).renameTo(new File(AndroidUtils.tempSyncFileDirectoryPath() + File.separator + files.get(x).getName()))) {
//                                                            AndroidUtils.uploadFileToServerFromTempFolder(getApplicationContext());
                                                            Log.e(TAG, "TO TEMP SYNC DIRECRTORY");

                                                        } else
                                                            Toasty.error(getApplicationContext(), "Error").show();
                                                    }

                                                }
                                            }
                                        } else {
                                            if (pDialog.isShowing()) {
                                                pDialog.dismiss();
                                                mHandler.removeCallbacks(runnable);
                                            }
                                        }

                                    } catch (Exception e) {
                                        Log.e("Error: ", e.getMessage());
                                    }

                                } else {
                                    Snackbar snackbar = Snackbar.make(cL, "No internet connection!", Snackbar.LENGTH_LONG);
                                    View sbView = snackbar.getView();
                                    sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.md_red_500));
                                    TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
                                    textView.setTextColor(getResources().getColor(R.color.white));
                                    snackbar.show();
                                }

//                                new CheckFilesBeforeUploads().execute();

                            }
                            else if (drawerItem.getIdentifier() == 12) {

                                new AlertDialog.Builder(MainNavigationDrawerAlt.this)
                                        .setMessage("Click [YES] to logout!!!")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                logout();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                            }
                                        })
                                        .show();
                            }
                            else if (drawerItem.getIdentifier() == 13) {
                                intent = new Intent(MainNavigationDrawerAlt.this, ExportFarmersAssignedAggActivity.class);
                            } else if (drawerItem.getIdentifier() == 14) {

                                new BackupDatabaseRecords().execute();

                            } else if (drawerItem.getIdentifier() == 20) {
                                intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("text/email");
                                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@uclghana.com"});
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
//                                Intent.createChooser(intent, "Send Feedback:");

                            } else if (drawerItem.getIdentifier() == 21) {
                                String url = "http://uclgroupgh.com/UCLAMS/";
                                intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(url));
                            }

                            if (intent != null) {
                                MainNavigationDrawerAlt.this.startActivity(intent);
                                Animatoo.animateSlideLeft(MainNavigationDrawerAlt.this);
                            }
                        }

                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();

        //only set the active selection or active profile if we do not recreate the activity
        if (savedInstanceState == null) {
            // set the selection to the item with the identifier 11
            result.setSelection(21, false);

            //set the active profile
            headerResult.setActiveProfile(profile);
        }

        result.updateBadge(11, new StringHolder(unsyncedFiles() + " File(s)"));
    }

    private void setupClickListeners() {

        menufarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationToFarmSearchActivity();
            }
        });

        menufarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationToFarmerActivity();
            }
        });
    }

    private void setupBackupClass() {
        backupData = new BackupData(MainNavigationDrawerAlt.this);
        backupData.setOnBackupListener(this);
    }

    private void setupLayoutViews() {
        menufarmer = findViewById(R.id.menu_farmer);
        progressdiag = new ProgressDialog(this);
        menufarm = findViewById(R.id.menu_farm);
        summarylayout = findViewById(R.id.summary_layout);
        cL = findViewById(R.id.cl);
        txtfarmercount = findViewById(R.id.farmers_count);
        txtfarmcount = findViewById(R.id.farms_count);
    }

    private void startHostMonitor() {
        Intent intent = new Intent(this, HostMonitorService.class);
        startService(intent);
    }

    //method to find count of farmers
    public void farmersCount() {
        try {
            txtfarmercount.setText(String.valueOf(Farmers.count(Farmers.class)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void farmsCount() {
        try {
            txtfarmcount.setText(String.valueOf(Farms.count(Farms.class)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        fm = getSupportFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(1000);
        getWindow().setExitTransition(slide);
    }

    public String getRegionCode(String region) {
        List<Regions> regions;
        try {
            regions = Regions.find(Regions.class, "region=?", region);
            if (regions.size() > 0) {
                return regions.get(0).getRegioncode();
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getDistrictCode(String district, String regioncode) {
        List<Districts> districts;
        try {
            districts = Districts.find(Districts.class, "district=? and regioncode=?", district, regioncode);
            if (districts.size() > 0) {
                return districts.get(0).getDistrictcode();
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //method to save userfingerprints
    public static void saveUserfingerprint(String aggregatorid, String farmerid, byte[] fingerprint, String fingertype, Date entrydate, byte[] fingerprinttemplate, String duplicatestatus, String uniqueuid, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid) {
        Userfingerprint finger = null;
        try {

            List<Userfingerprint> list = Userfingerprint.find(Userfingerprint.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                finger = list.get(0);
            else
                finger = new Userfingerprint();

            finger.setAggregatorid(aggregatorid);
            finger.setMacaddress(macaddress);
            finger.setImei(imei);
            finger.setAgentname(agentname);
            finger.setAgentid(agentid);
            finger.setServerid(serverid);
            finger.setDatecreated(datecreated);
            finger.setSynstatus("");
            finger.setFarmerid(farmerid);
            finger.setFingerprint(fingerprint);
            finger.setFingertype(fingertype);
            finger.setEntrydate(entrydate);
            finger.setFingerprinttemplate(fingerprinttemplate);
            finger.setDuplicatestatus(duplicatestatus);
            finger.setUniqueuid(uniqueuid);
            finger.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save userbiometrics
    public static void saveUserbiometrics(String aggregatorid, String farmerid, byte[] picture, byte[] signature, String height, String eyecolor, Date createdDate, String placeOfRegistered, Date datecreatedserver, String uniqueuid, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid) {
        try {
            if (uniqueuid != null) {
                Userbiometrics bio = null;

                List<Userbiometrics> list = Userbiometrics.find(Userbiometrics.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

                if (list != null && list.size() > 0)
                    bio = list.get(0);
                else
                    bio = new Userbiometrics();

                bio.setAggregatorid(aggregatorid);
                bio.setMacaddress(macaddress);
                bio.setImei(imei);
                bio.setAgentname(agentname);
                bio.setAgentid(agentid);
                bio.setServerid(serverid);
                bio.setDatecreated(datecreated);
                bio.setSynstatus("");
                bio.setDatecreatedserver(datecreatedserver);
                bio.setUniqueuid(uniqueuid);
                bio.setFarmerid(farmerid);
                bio.setPicture(picture);
                bio.setSignature(signature);
                bio.setHeight(height);
                bio.setEyecolor(eyecolor);
                bio.setCreatedDate(createdDate);
                bio.setPlaceOfRegistered(placeOfRegistered);
                bio.save();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save supportdocs
    public static void saveSupportDocs(String aggregatorid, String farmerid, String documenttype, byte[] document, String uniqueuid, Date datecreated, String synstatus, int serverid, String macaddress, String imei, String agentname, String agentid) {
        SupportDocs supportDocs = null;
        if (uniqueuid != null) {

            List<SupportDocs> list = SupportDocs.find(SupportDocs.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                supportDocs = list.get(0);
            else
                supportDocs = new SupportDocs();

            try {
                supportDocs.setAggregatorid(aggregatorid);
                supportDocs.setMacaddress(macaddress);
                supportDocs.setImei(imei);
                supportDocs.setAgentname(agentname);
                supportDocs.setAgentid(agentid);
                supportDocs.setServerid(serverid);
                supportDocs.setSynstatus("");
                supportDocs.setFarmerid(farmerid);
                supportDocs.setDocumenttype(documenttype);
                supportDocs.setDocument(document);
                supportDocs.setUniqueuid(uniqueuid);
                supportDocs.setDatecreated(datecreated);
                supportDocs.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //method to save household
    public static void saveHousehold(String aggregatorid, String farmerid, String householdid, String relationship, String syncstatus, Date datecreated, String uniqueuid, int serverid, String macaddress, String imei, String agentname, String agentid) {
        try {
            Household household = null;

            List<Household> list = Household.find(Household.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                household = list.get(0);
            else
                household = new Household();

            household.setAggregatorid(aggregatorid);
            household.setMacaddress(macaddress);
            household.setImei(imei);
            household.setAgentname(agentname);
            household.setAgentid(agentid);
            household.setServerid(serverid);
            household.setFarmerid(farmerid);
            household.setHouseholdid(householdid);
            household.setRelationship(relationship);
            household.setSyncstatus("");
            household.setDatecreated(datecreated);
            household.setUniqueuid(uniqueuid);
            household.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save location coordinates
    public static void saveLocationCoordinates(String aggregatorid, String farmerid, String locationtype, String farmid, String latitude, String longitude, String streetname, String city, String region, String assembly, String jsoncoord, double area, double length, Date datecreated, String syncstatus, String uniqueuid, int serverid, String macaddress, String imei, String agentname, String agentid) {
        try {
            LocationCoordinates loc = null;

            List<LocationCoordinates> list = LocationCoordinates.find(LocationCoordinates.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                loc = list.get(0);
            else
                loc = new LocationCoordinates();

            loc.setAggregatorid(aggregatorid);
            loc.setMacaddress(macaddress);
            loc.setImei(imei);
            loc.setAgentname(agentname);
            loc.setAgentid(agentid);
            loc.setServerid(serverid);
            loc.setLength(length);
            loc.setLatitude(latitude);
            loc.setLongitude(longitude);
            loc.setSyncstatus("");
            loc.setStreetname(streetname);
            loc.setCity(city);
            loc.setRegion(region);
            loc.setAssembly(assembly);
            loc.setLocationtype(locationtype);
            loc.setFarmerid(farmerid);
            loc.setFarmid(farmid);
            loc.setJsoncoord(jsoncoord);
            loc.setArea(area);
            loc.setDatecreated(datecreated);
            loc.setUniqueuid(uniqueuid);
            loc.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save gallery
    public static void saveGallery(String aggregatorid, String farmerid, String imagetype, String description, byte[] galleryimage, Date datecreated, String uniqueuid, String synstatus, String macaddress, String imei, String agentname, String agentid) {

        Gallery gallery = null;
        try {

            List<Gallery> list = Gallery.find(Gallery.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null)
                gallery = list.get(0);
            else
                gallery = new Gallery();

            gallery.setAggregatorid(aggregatorid);
            gallery.setMacaddress(macaddress);
            gallery.setImei(imei);
            gallery.setAgentname(agentname);
            gallery.setAgentid(agentid);
            gallery.setSynstatus("");
            gallery.setFarmerid(farmerid);
            gallery.setImagetype(imagetype);
            gallery.setDescription(description);
            gallery.setGalleryimage(galleryimage);
            gallery.setDatecreated(datecreated);
            gallery.setUniqueuid(uniqueuid);
            gallery.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save Sales
    public static void saveSales(String aggregatorid, String farmerid, String transactionid, String pid, String pname, String category, double uprice, int quantity, double totalcost, String acreage, Date dates, Date times, int serverid, String syncstatus, String uniqueuid, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        Sales sales = null;
        try {
            List<Sales> list = Sales.find(Sales.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                sales = list.get(0);
            else
                sales = new Sales();

            sales.setAggregatorid(aggregatorid);
            sales.setFarmerid(farmerid);
            sales.setTransactionid(transactionid);
            sales.setPid(pid);
            sales.setPname(pname);
            sales.setCategory(category);
            sales.setUprice(uprice);
            sales.setQuantity(quantity);
            sales.setTotalcost(totalcost);
            sales.setUsers(acreage);
            sales.setDates(dates);
            sales.setTimes(times);
            sales.setUniqueuid(uniqueuid);
            sales.setDatecreated(datecreated);
            sales.setImei(imei);
            sales.setMacaddress(macaddress);
            sales.setAgentid(agentid);
            sales.setAgentname(agentname);
            sales.setServerid(serverid);
            sales.setSynstatus(syncstatus);
            sales.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save Salestran
    public static void saveSalestran(String aggregatorid, String farmerid, String transactionid, double totalCost, String couponcode, double appliedsub, double payableamt, String paymentmethod, double tendered, double norecoverybags, String community, String district, String region, String acreage, Date dates, Date times, String uniqueuid, int serverid, String syncstatus, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        Salestran salestran = null;
        try {
            List<Salestran> list = Salestran.find(Salestran.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                salestran = list.get(0);
            else
                salestran = new Salestran();

            salestran.setAggregatorid(aggregatorid);
            salestran.setFarmerid(farmerid);
            salestran.setTransactionid(transactionid);
            salestran.setTotalCost(totalCost);
            salestran.setCouponcode(couponcode);
            salestran.setAppliedsub(appliedsub);
            salestran.setPayableamt(payableamt);
            salestran.setPaymentmethod(paymentmethod);
            salestran.setTendered(tendered);
            salestran.setNorecoverybags(norecoverybags);
            salestran.setCommunity(community);
            salestran.setDistrict(district);
            salestran.setRegion(region);
            salestran.setAcreage(acreage);
            salestran.setDates(dates);
            salestran.setTimes(times);
            salestran.setUniqueuid(uniqueuid);
            salestran.setDatecreated(datecreated);
            salestran.setImei(imei);
            salestran.setMacaddress(macaddress);
            salestran.setServerid(serverid);
            salestran.setSynstatus(syncstatus);
            salestran.setAgentid(agentid);
            salestran.setAgentname(agentname);


            salestran.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save Declaration
    public static void saveDeclaration(String aggregatorid, String farmerid, String transactionid, double totalCost, String couponcode, double appliedsub, double norecoverybags, String paymentmethod, String dec, String status, String community, String district, String region, String acreage, Date dates, Date times, int serverid, String uniqueuid, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        Declaration declaration = null;
        try {
            List<Declaration> list = Declaration.find(Declaration.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                declaration = list.get(0);
            else
                declaration = new Declaration();


            declaration.setAggregatorid(aggregatorid);
            declaration.setFarmerid(farmerid);
            declaration.setTransactionid(transactionid);
            declaration.setTotalCost(totalCost);
            declaration.setCouponcode(couponcode);
            declaration.setAppliedsub(appliedsub);
            declaration.setNorecoverybags(norecoverybags);
            declaration.setPaymentmethod(paymentmethod);
            declaration.setDeclaration(dec);
            declaration.setStatus(status);
            declaration.setCommunity(community);
            declaration.setDistrict(district);
            declaration.setRegion(region);
            declaration.setAcreage(acreage);
            declaration.setDates(dates);
            declaration.setTimes(times);
            declaration.setServerid(serverid);
            declaration.setDatecreated(datecreated);
            declaration.setImei(imei);
            declaration.setMacaddress(macaddress);
            declaration.setUniqueuid(uniqueuid);
            declaration.setAgentid(agentid);
            declaration.setAgentname(agentname);

            declaration.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save Scaletran
    public static void saveScaletran(String aggregatorid, String transid, String farmerid, String scaleid, String pcid, String bcid, String name, String phone, String payable, String tendered, double count, double weight, double moisturecontent, double amount, Date time, Date date, String uniqueuid, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid) {
        Scaletran scaletran = null;
        try {
            List<Scaletran> list = Scaletran.find(Scaletran.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                scaletran = list.get(0);
            else
                scaletran = new Scaletran();

            scaletran.setAggregatorid(aggregatorid);
            scaletran.setTransid(transid);
            scaletran.setFarmerid(farmerid);
            scaletran.setScaleid(scaleid);
            scaletran.setPcid(pcid);
            scaletran.setBcid(bcid);
            scaletran.setName(name);
            scaletran.setPhone(phone);
            scaletran.setPayable(payable);
            scaletran.setTendered(tendered);
            scaletran.setCount(count);
            scaletran.setWeight(weight);
            scaletran.setMoisturecontent(moisturecontent);
            scaletran.setAmount(amount);
            scaletran.setTime(time);
            scaletran.setDate(date);
            scaletran.setUniqueuid(uniqueuid);
            scaletran.setServerid(serverid);
            scaletran.setSynstatus(synstatus);
            scaletran.setMacaddress(macaddress);
            scaletran.setDatecreated(datecreated);
            scaletran.setImei(imei);
            scaletran.setAgentid(agentid);
            scaletran.setAgentname(agentname);
            scaletran.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save Farm Assessment
    public static void saveFarmassessment(String aggregatorid, String farmerid, String farmid, Date dateplanted, String cropvariety, String stageofcrop, String fertilizername, Date fertilizerdate, String cropprotection, Date cropprotectiondate, byte[] farmimg, String farmlong, String farmlat, String comments, String uniqueuid, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid) {
        FarmAssessment assessment = null;
        try {
            List<FarmAssessment> list = FarmAssessment.find(FarmAssessment.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                assessment = list.get(0);
            else
                assessment = new FarmAssessment();

            assessment.setAggregatorid(aggregatorid);
            assessment.setFarmerid(farmerid);
            assessment.setFarmid(farmid);
            assessment.setDateplanted(dateplanted);
            assessment.setCropvariety(cropvariety);
            assessment.setStageofcrop(stageofcrop);
            assessment.setFertilizername(fertilizername);
            assessment.setFertilizerdate(fertilizerdate);
            assessment.setCropprotection(cropprotection);
            assessment.setCropprotectiondate(cropprotectiondate);
            assessment.setFarmimg(farmimg);
            assessment.setFarmlong(farmlong);
            assessment.setFarmlat(farmlat);
            assessment.setComments(comments);
            assessment.setUniqueuid(uniqueuid);
            assessment.setSynstatus(synstatus);
            assessment.setDatecreated(datecreated);
            assessment.setServerid(serverid);
            assessment.setMacaddress(macaddress);
            assessment.setImei(imei);
            assessment.setAgentid(agentid);
            assessment.setAgentname(agentname);

            assessment.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save farms
    public static void saveFarms(String aggregatorid, String farmid, String farmerid, String location, String district, String region, String community, String yearofestablishment, String totalarea, String cultivatedarea, String shadetrees, String ownership, String typeoffarm, String plantingmaterial, String othersource, String labour, String qextension, String extension, String organisation, String qactivities, String activities, String farmimage, String geocord, String long_, String uniqueuid, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid, String cropvariety, String fertilizerused, String farmyield, String cropprotection, String chemicalused) {
        Farms farms = null;
        try {
            List<Farms> list = Farms.find(Farms.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                farms = list.get(0);
            else
                farms = new Farms();

            farms.setAggregatorid(aggregatorid);
            farms.setFarmyield(farmyield);
            farms.setCropprotection(cropprotection);
            farms.setChemicalused(chemicalused);
            farms.setFertilizerused(fertilizerused);
            farms.setMacaddress(macaddress);
            farms.setImei(imei);
            farms.setAgentname(agentname);
            farms.setAgentid(agentid);
            farms.setServerid(serverid);
            farms.setDatecreated(datecreated);
            farms.setSynstatus("");
            farms.setUniqueuid(uniqueuid);
            farms.setFarmid(farmid);
            farms.setFarmerid(farmerid);
            farms.setLocation(location);
            farms.setDistrict(district);
            farms.setRegion(region);
            farms.setCommunity(community);
            farms.setYearofestablishment(yearofestablishment);
            farms.setTotalarea(totalarea);
            farms.setCultivatedarea(cultivatedarea);
            farms.setShadetrees(shadetrees);
            farms.setOwnership(ownership);
            farms.setTypeoffarm(typeoffarm);
            farms.setPlantingmaterial(plantingmaterial);
            farms.setOthersource(othersource);
            farms.setLabour(labour);
            farms.setQextension(qextension);
            farms.setExtension(extension);
            farms.setOrganisation(organisation);
            farms.setQactivities(qactivities);
            farms.setActivities(activities);
            farms.setFarmimage(farmimage);
            farms.setGeocord(geocord);
            farms.setLong_(long_);
            farms.setCropvariety(cropvariety);
            farms.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save farmers information
    public static void saveFarmers(String aggregatorid, String farmerid, String surname, String othername, String placeofbirth, Date dateofbirth, Integer age, String gender, String hometown, String address, String district, String region, String country, String idcardtype, String idcardno, String levelofeducation, String religion, String maritalstatus, String nextofkin, String relation, String qfarmergroup, String farmergroup, String qcooperative, String cooperative, String qincomesource, String incomesource, String qspecialty, String specialty, String certification, String funding, String imagelink, String community, String tel, String email, String uniqueuid, String postbox, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid) {

        try {
            Farmers farmers = null;

            List<Farmers> list = Farmers.find(Farmers.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                farmers = list.get(0);
            else
                farmers = new Farmers();

            farmers.setAggregatorid(aggregatorid);
            farmers.setMacaddress(macaddress);
            farmers.setImei(imei);
            farmers.setAgentname(agentname);
            farmers.setAgentid(agentid);
            farmers.setServerid(serverid);
            farmers.setDatecreated(datecreated);
            farmers.setSynstatus("");
            farmers.setAge(age);
            farmers.setPostbox(postbox);
            farmers.setEmail(email);
            farmers.setUniqueuid(uniqueuid);
            farmers.setFarmerid(farmerid);
            farmers.setSurname(surname);
            farmers.setOthername(othername);
            farmers.setPlaceofbirth(placeofbirth);
            farmers.setDateofbirth(dateofbirth);
            farmers.setGender(gender);
            farmers.setHometown(hometown);
            farmers.setAddress(address);
            farmers.setDistrict(district);
            farmers.setRegion(region);
            farmers.setCountry(country);
            farmers.setIdcardtype(idcardtype);
            farmers.setIdcardno(idcardno);
            farmers.setLevelofeducation(levelofeducation);
            farmers.setReligion(religion);
            farmers.setMaritalstatus(maritalstatus);
            farmers.setNextofkin(nextofkin);
            farmers.setRelation(relation);
            farmers.setQfarmergroup(qfarmergroup);
            farmers.setFarmergroup(farmergroup);
            farmers.setQcooperative(qcooperative);
            farmers.setCooperative(cooperative);
            farmers.setQincomesource(qincomesource);
            farmers.setIncomesource(incomesource);
            farmers.setQspecialty(qspecialty);
            farmers.setSpecialty(specialty);
            farmers.setCertification(certification);
            farmers.setFunding(funding);
            farmers.setImagelink(imagelink);
            farmers.setCommunity(community);
            farmers.setTel(tel);
            farmers.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save farmerid
    public static void saveFarmeridcard(String aggregatorid, String farmerid, String idtype, String idnumber, byte[] idimage, String uniqueuid, Date datecreated, String synstatus, int serverid, String macaddress, String imei, String agentname, String agentid) {
        try {
            Farmeridcard idcard = null;
            List<Farmeridcard> list = Farmeridcard.find(Farmeridcard.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                idcard = list.get(0);
            else
                idcard = new Farmeridcard();

            idcard.setAggregatorid(aggregatorid);
            idcard.setMacaddress(macaddress);
            idcard.setImei(imei);
            idcard.setAgentname(agentname);
            idcard.setAgentid(agentid);
            idcard.setServerid(serverid);
//            idcard.setSynstatus("");
            idcard.setDatecreated(datecreated);
            idcard.setFarmerid(farmerid);
            idcard.setIdtype(idtype);
            idcard.setIdnumber(idnumber);
            idcard.setIdimage(idimage);
            idcard.setUniqueuid(uniqueuid);
            idcard.save();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save activity info
    public static void saveActivityInfo(String aggregatorid, String farmerid, String groupname, boolean boolgroupname, String coopname, boolean boolcoopname, String incomesource, boolean boolincomesource, String specialtycocoa, boolean boolspecialtycocoa, String certified, boolean boolcertified, String fundingsource, String uniqueuid, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid) {
        try {
            ActivityInfo info = null;
            List<ActivityInfo> list = ActivityInfo.find(ActivityInfo.class, "uniqueuid=?", new String[]{uniqueuid}, null, null, "1");

            if (list != null && list.size() > 0)
                info = list.get(0);
            else
                info = new ActivityInfo();

            info.setMacaddress(macaddress);
            info.setImei(imei);
            info.setAgentname(agentname);
            info.setAgentid(agentid);
            info.setServerid(serverid);
            info.setDatecreated(datecreated);
            info.setSynstatus(synstatus);
            info.setBoolgroupname(boolgroupname);
            info.setBoolcoopname(boolcoopname);
            info.setBoolincomesource(boolincomesource);
            info.setBoolspecialtycocoa(boolspecialtycocoa);
            info.setBoolcertified(boolcertified);
            info.setUniqueuid(uniqueuid);
            info.setFarmerid(farmerid);
            info.setGroupname(groupname);
            info.setCoopname(coopname);
            info.setIncomesource(incomesource);
            info.setSpecialtycocoa(specialtycocoa);
            info.setCertified(certified);
            info.setFundingsource(fundingsource);
            info.setAggregatorid(aggregatorid);
            info.save();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //method to save into district entity
    public void saveDistricts(String district, String districtcode, String targets, String regioncode, String region) {
        try {
            new Districts(district, districtcode, targets, regioncode, region).save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save regions
    public void saveRegions(String region, String regioncode) {
        try {
            new Regions(region, regioncode).save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readJSONFromDirectory(File filename) {
        System.out.println("File name: " + filename);
        basefilename = FilenameUtils.getBaseName(filename.getAbsolutePath());

        if (basefilename.startsWith("districts")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new Gson();

                try {
                    districtlist = gson.fromJson(jsonReader, com.telpo.usb.finger.serverentities.Districts[].class);
                    for (com.telpo.usb.finger.serverentities.Districts districts : districtlist) {
                        saveDistricts(districts.getDistrict(), districts.getDistrictcode(), "" + districts.getTargets(), districts.getRegioncode(), districts.getRegion());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if (basefilename.startsWith("region")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new Gson();

                try {
                    regionlist = gson.fromJson(jsonReader, com.telpo.usb.finger.serverentities.Regions[].class);
                    for (com.telpo.usb.finger.serverentities.Regions region : regionlist) {
                        saveRegions(region.getRegion(), region.getRegioncode());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("activity")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new Gson();

                try {
                    actlist = gson.fromJson(jsonReader, Activityinfo[].class);
                    System.out.println(actlist.toString());
                    if (populationpath.toLowerCase().contains("backup")) {
                        for (Activityinfo act : actlist) {
                            saveActivityInfo(
                                    act.getAggregatorid(),
                                    act.getFarmerid(),
                                    act.getGroupname(),
                                    false,
                                    act.getCooperative(),
                                    false,
                                    act.getIncomesource(),
                                    false,
                                    act.getSpecialtycrop(),
                                    false,
                                    null,
                                    false,
                                    act.getFundingsource(),
                                    act.getUniqueuid(),
                                    "0",
                                    act.getCreateddate(),//.parse(tokens[7].replace("\"", "")),
                                    act.getServerid(),
                                    act.getMacaddress(),
                                    act.getImei(),
                                    act.getAgentname(),
                                    act.getAgentid());
                        }
                    } else {
                        for (Activityinfo act : actlist) {
                            saveActivityInfo(
                                    act.getAggregatorid(),
                                    act.getFarmerid(),
                                    act.getGroupname(),
                                    false,
                                    act.getCooperative(),
                                    false,
                                    act.getIncomesource(),
                                    false,
                                    act.getSpecialtycrop(),
                                    false,
                                    null,
                                    false,
                                    act.getFundingsource(),
                                    act.getUniqueuid(),
                                    "0",
                                    act.getCreateddate(),//.parse(tokens[7].replace("\"", "")),
                                    act.getId(),
                                    act.getMacaddress(),
                                    act.getImei(),
                                    act.getAgentname(),
                                    act.getAgentid());
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("sales_")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29

                try {
                    saleslist = gson.fromJson(jsonReader, Salesinfo[].class);
                    if (populationpath.toLowerCase().contains("backup")) {
                        for (Salesinfo salesinfo : saleslist) {
                            saveSales(
                                    salesinfo.getAggregatorid(),
                                    salesinfo.getFarmerid(),
                                    salesinfo.getTransid(),
                                    salesinfo.getPid(),
                                    salesinfo.getPname(),
                                    salesinfo.getCategory(),
                                    salesinfo.getUprice(),
                                    salesinfo.getQuantity(),
                                    salesinfo.getTotalcost(),
                                    salesinfo.getUsers(),
                                    salesinfo.getDates(),
                                    salesinfo.getTimes(),
                                    salesinfo.getServerid(),
                                    "0",
                                    salesinfo.getUniqueuid(),
                                    salesinfo.getDatecreated(),
                                    salesinfo.getMacaddress(),
                                    salesinfo.getImei(),
                                    salesinfo.getAgentname(),
                                    salesinfo.getAgentid()
                            );
                        }
                    } else {
                        for (Salesinfo salesinfo : saleslist) {
                            saveSales(
                                    salesinfo.getAggregatorid(),
                                    salesinfo.getFarmerid(),
                                    salesinfo.getTransid(),
                                    salesinfo.getPid(),
                                    salesinfo.getPname(),
                                    salesinfo.getCategory(),
                                    salesinfo.getUprice(),
                                    salesinfo.getQuantity(),
                                    salesinfo.getTotalcost(),
                                    salesinfo.getUsers(),
                                    salesinfo.getDates(),
                                    salesinfo.getTimes(),
                                    salesinfo.getId(),
                                    "0",
                                    salesinfo.getUniqueuid(),
                                    salesinfo.getDatecreated(),
                                    salesinfo.getMacaddress(),
                                    salesinfo.getImei(),
                                    salesinfo.getAgentname(),
                                    salesinfo.getAgentid()
                            );
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("salestran")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29

                try {
                    salestranlist = gson.fromJson(jsonReader, Salestraninfo[].class);
                    for (Salestraninfo salestraninfo : salestranlist) {

                        if (salestraninfo.getTotalCost() == null) {
                            saveSalestran(
                                    salestraninfo.getAggregatorid(),
                                    salestraninfo.getFarmerid(),
                                    salestraninfo.getTransid(),
                                    salestraninfo.getTotalcost(),
                                    salestraninfo.getCouponcode(),
                                    salestraninfo.getAppliedsub(),
                                    salestraninfo.getPayableamt(),
                                    salestraninfo.getPaymentmethod(),
                                    salestraninfo.getTendered(),
                                    salestraninfo.getNorecoverybags(),
                                    salestraninfo.getCommunity(),
                                    salestraninfo.getDistrict(),
                                    salestraninfo.getRegion(),
                                    salestraninfo.getAcreage(),
                                    salestraninfo.getDates(),
                                    salestraninfo.getTimes(),
                                    salestraninfo.getUniqueuid(),
                                    salestraninfo.getId(),
                                    "0",
                                    salestraninfo.getDatecreated(),
                                    salestraninfo.getMacaddress(),
                                    salestraninfo.getImei(),
                                    salestraninfo.getAgentname(),
                                    salestraninfo.getAgentid()
                            );
                        } else {
                            saveSalestran(
                                    salestraninfo.getAggregatorid(),
                                    salestraninfo.getFarmerid(),
                                    salestraninfo.getTransid(),
                                    salestraninfo.getTotalCost(),
                                    salestraninfo.getCouponcode(),
                                    salestraninfo.getAppliedsub(),
                                    salestraninfo.getPayableamt(),
                                    salestraninfo.getPaymentmethod(),
                                    salestraninfo.getTendered(),
                                    salestraninfo.getNorecoverybags(),
                                    salestraninfo.getCommunity(),
                                    salestraninfo.getDistrict(),
                                    salestraninfo.getRegion(),
                                    salestraninfo.getAcreage(),
                                    salestraninfo.getDates(),
                                    salestraninfo.getTimes(),
                                    salestraninfo.getUniqueuid(),
                                    salestraninfo.getServerid(),
                                    "0",
                                    salestraninfo.getDatecreated(),
                                    salestraninfo.getMacaddress(),
                                    salestraninfo.getImei(),
                                    salestraninfo.getAgentname(),
                                    salestraninfo.getAgentid()
                            );
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("scaletran")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29

                try {
                    scaletranlist = gson.fromJson(jsonReader, Scaletraninfo[].class);
                    if (populationpath.toLowerCase().contains("backup")) {
                        for (Scaletraninfo scaletraninfo : scaletranlist) {
                            saveScaletran(
                                    scaletraninfo.getAggregatorid(),
                                    scaletraninfo.getTransid(),
                                    scaletraninfo.getFarmerid(),
                                    scaletraninfo.getScaleid(),
                                    scaletraninfo.getPcid(),
                                    scaletraninfo.getBcid(),
                                    scaletraninfo.getName(),
                                    scaletraninfo.getPhone(),
                                    scaletraninfo.getPayable(),
                                    scaletraninfo.getTendered(),
                                    scaletraninfo.getCount(),
                                    scaletraninfo.getWeight(),
                                    scaletraninfo.getMoisturecontent(),
                                    scaletraninfo.getAmount(),
                                    scaletraninfo.getTime(),
                                    scaletraninfo.getDate(),
                                    scaletraninfo.getUniqueuid(),
                                    "0",
                                    scaletraninfo.getDatecreated(),
                                    scaletraninfo.getServerid(),
                                    scaletraninfo.getMacaddress(),
                                    scaletraninfo.getImei(),
                                    scaletraninfo.getAgentname(),
                                    scaletraninfo.getAgentid()
                            );
                        }
                    } else {
                        for (Scaletraninfo scaletraninfo : scaletranlist) {
                            saveScaletran(
                                    scaletraninfo.getAggregatorid(),
                                    scaletraninfo.getTransid(),
                                    scaletraninfo.getFarmerid(),
                                    scaletraninfo.getScaleid(),
                                    scaletraninfo.getPcid(),
                                    scaletraninfo.getBcid(),
                                    scaletraninfo.getName(),
                                    scaletraninfo.getPhone(),
                                    scaletraninfo.getPayable(),
                                    scaletraninfo.getTendered(),
                                    scaletraninfo.getCount(),
                                    scaletraninfo.getWeight(),
                                    scaletraninfo.getMoisturecontent(),
                                    scaletraninfo.getAmount(),
                                    scaletraninfo.getTime(),
                                    scaletraninfo.getDate(),
                                    scaletraninfo.getUniqueuid(),
                                    "0",
                                    scaletraninfo.getDatecreated(),
                                    scaletraninfo.getId(),
                                    scaletraninfo.getMacaddress(),
                                    scaletraninfo.getImei(),
                                    scaletraninfo.getAgentname(),
                                    scaletraninfo.getAgentid()
                            );
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("declaration")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29

                try {
                    declarationlist = gson.fromJson(jsonReader, Declarationinfo[].class);
                    for (Declarationinfo declarationinfo : declarationlist) {
                        if (declarationinfo.getTotalCost() == null) {
                            saveDeclaration(
                                    declarationinfo.getAggregatorid(),
                                    declarationinfo.getFarmerid(),
                                    declarationinfo.getTransid(),
                                    declarationinfo.getTotalcost(),
                                    declarationinfo.getCouponcode(),
                                    declarationinfo.getAppliedsub(),
                                    declarationinfo.getNorecoverybags(),
                                    declarationinfo.getPaymentmethod(),
                                    declarationinfo.getDeclaration(),
                                    declarationinfo.getStatus(),
                                    declarationinfo.getCommunity(),
                                    declarationinfo.getDistrict(),
                                    declarationinfo.getRegion(),
                                    declarationinfo.getAcreage(),
                                    declarationinfo.getDates(),
                                    declarationinfo.getTimes(),
                                    declarationinfo.getId(),
                                    declarationinfo.getUniqueuid(),
                                    declarationinfo.getDatecreated(),
                                    declarationinfo.getMacaddress(),
                                    declarationinfo.getImei(),
                                    declarationinfo.getAgentname(),
                                    declarationinfo.getAgentid()
                            );
                        } else {
                            saveDeclaration(
                                    declarationinfo.getAggregatorid(),
                                    declarationinfo.getFarmerid(),
                                    declarationinfo.getTransid(),
                                    declarationinfo.getTotalCost(),
                                    declarationinfo.getCouponcode(),
                                    declarationinfo.getAppliedsub(),
                                    declarationinfo.getNorecoverybags(),
                                    declarationinfo.getPaymentmethod(),
                                    declarationinfo.getDeclaration(),
                                    declarationinfo.getStatus(),
                                    declarationinfo.getCommunity(),
                                    declarationinfo.getDistrict(),
                                    declarationinfo.getRegion(),
                                    declarationinfo.getAcreage(),
                                    declarationinfo.getDates(),
                                    declarationinfo.getTimes(),
                                    declarationinfo.getServerid(),
                                    declarationinfo.getUniqueuid(),
                                    declarationinfo.getDatecreated(),
                                    declarationinfo.getMacaddress(),
                                    declarationinfo.getImei(),
                                    declarationinfo.getAgentname(),
                                    declarationinfo.getAgentid()
                            );
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("farmassessment")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29

                try {
                    farmAssessmentlist = gson.fromJson(jsonReader, FarmAssessmentinfo[].class);
                    if (populationpath.toLowerCase().contains("backup")) {
                        for (FarmAssessmentinfo assessmentinfo : farmAssessmentlist) {
                            saveFarmassessment(
                                    assessmentinfo.getAggregatorid(),
                                    assessmentinfo.getFarmerid(),
                                    assessmentinfo.getFarmid(),
                                    assessmentinfo.getDateplanted(),
                                    assessmentinfo.getCropvariety(),
                                    assessmentinfo.getStageofcrop(),
                                    assessmentinfo.getFertilizername(),
                                    assessmentinfo.getFertilizerdate(),
                                    assessmentinfo.getCropprotection(),
                                    assessmentinfo.getCropprotectiondate(),
                                    assessmentinfo.getFarmimg(),
                                    assessmentinfo.getFarmlong(),
                                    assessmentinfo.getFarmlat(),
                                    assessmentinfo.getComments(),
                                    assessmentinfo.getUniqueuid(),
                                    "0",
                                    assessmentinfo.getDatecreated(),
                                    assessmentinfo.getServerid(),
                                    assessmentinfo.getMacaddress(),
                                    assessmentinfo.getImei(),
                                    assessmentinfo.getAgentname(),
                                    assessmentinfo.getAgentid()
                            );
                        }
                    } else {
                        for (FarmAssessmentinfo assessmentinfo : farmAssessmentlist) {
                            saveFarmassessment(
                                    assessmentinfo.getAggregatorid(),
                                    assessmentinfo.getFarmerid(),
                                    assessmentinfo.getFarmid(),
                                    assessmentinfo.getDateplanted(),
                                    assessmentinfo.getCropvariety(),
                                    assessmentinfo.getStageofcrop(),
                                    assessmentinfo.getFertilizername(),
                                    assessmentinfo.getFertilizerdate(),
                                    assessmentinfo.getCropprotection(),
                                    assessmentinfo.getCropprotectiondate(),
                                    assessmentinfo.getFarmimg(),
                                    assessmentinfo.getFarmlong(),
                                    assessmentinfo.getFarmlat(),
                                    assessmentinfo.getComments(),
                                    assessmentinfo.getUniqueuid(),
                                    "0",
                                    assessmentinfo.getDatecreated(),
                                    assessmentinfo.getId(),
                                    assessmentinfo.getMacaddress(),
                                    assessmentinfo.getImei(),
                                    assessmentinfo.getAgentname(),
                                    assessmentinfo.getAgentid()
                            );
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("idcard")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new Gson();
//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    idcardlist = gson.fromJson(jsonReader, com.telpo.usb.finger.serverentities.Farmeridcard[].class);
                    if (populationpath.toLowerCase().contains("backup")) {
                        for (com.telpo.usb.finger.serverentities.Farmeridcard idcard : idcardlist) {
                            saveFarmeridcard(
                                    idcard.getAggregatorid(),
                                    idcard.getFarmerid(),
                                    idcard.getIdcardtype(),
                                    idcard.getIdcardnumber(),
                                    idcard.getIdimage(),
                                    idcard.getUniqueuid(),
                                    idcard.getDatecreated(),//.parse(tokens[5].replace("\"","")),
                                    "0",
                                    idcard.getServerid(),
                                    idcard.getMacaddress(),
                                    idcard.getImei(),
                                    idcard.getAgentname(),
                                    idcard.getAgentid());
                        }
                    } else {
                        for (com.telpo.usb.finger.serverentities.Farmeridcard idcard : idcardlist) {
                            saveFarmeridcard(
                                    idcard.getAggregatorid(),
                                    idcard.getFarmerid(),
                                    idcard.getIdcardtype(),
                                    idcard.getIdcardnumber(),
                                    idcard.getIdimage(),
                                    idcard.getUniqueuid(),
                                    idcard.getDatecreated(),//.parse(tokens[5].replace("\"","")),
                                    "0",
                                    idcard.getId(),
                                    idcard.getMacaddress(),
                                    idcard.getImei(),
                                    idcard.getAgentname(),
                                    idcard.getAgentid());
                        }
                    }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }

//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("farmers")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();
                try {
                    basiclist = gson.fromJson(jsonReader, Basicfarmerinfo[].class);
                    List<Aggregator> aggregatorList = Aggregator.listAll(Aggregator.class);
                    boolean found = false;
                    Aggregator aggregator;
                    for (Basicfarmerinfo basic : basiclist) {
                        // UPDATING AGGREGATOR TABLE LIST
                        aggregator = new Aggregator();
                        if (aggregatorList.size() > 0){
                            for (Aggregator agg: aggregatorList) {
                                if (basic.getAggregatorid() != null){
                                    if (agg.getAggregatorid().equalsIgnoreCase(basic.getAggregatorid())){
                                        found = true;
                                        break;
                                    } else {
                                        found = false;
                                        aggregator.setAggregatorid(basic.getAggregatorid());
                                    }
                                }
                            }
                        }
                        else {
                            aggregator.setAggregatorid(basic.getAggregatorid());
                            aggregator.save();
                            aggregatorList.add(aggregator);
                            found = true;
                        }

                        if (!found) {
                            aggregator.save();
                            aggregatorList.add(aggregator);
                        }

                        if (basic.getOthername() == null) {
                            saveFarmers(
                                    basic.getAggregatorid(),
                                    basic.getFarmerid(),//1
                                    basic.getSurname(),//2
                                    basic.getOthernames(),//3
                                    basic.getPlaceofbirth(),//4
                                    basic.getDateofbirth(),//.parse(tokens[6].replace("\"","")),//5
                                    0,//6
                                    basic.getGender(),//7
                                    basic.getHometown(),//8
                                    basic.getAddress(),//9
                                    basic.getDistrict(),//10
                                    basic.getRegion(),//11
                                    basic.getCountry(),//12
                                    null,//13
                                    null,//14
                                    basic.getLevelofeducation(),//15
                                    basic.getReligion(),//16
                                    basic.getMaritalstatus(),//17
                                    null,//18
                                    null,//19
                                    null,//20
                                    null,//21
                                    null,//22
                                    null,//23
                                    null,//24
                                    null,//25
                                    null,//26
                                    null,//27
                                    null,//28
                                    null,//29
                                    null,//30
                                    basic.getCommunity(),//31
                                    basic.getTel(),//32
                                    basic.getEmail(),//33
                                    basic.getUniqueuid(),//34
                                    basic.getPostbox(),//35
                                    "0",//36
                                    basic.getDatecreated(),//.parse(tokens[19].replace("\"","")),//37
                                    basic.getId(),//38
                                    basic.getMacaddress(),//39
                                    basic.getImei(),//40
                                    basic.getAgentname(),//41
                                    basic.getAgentid());//42);tokens[].replace("\"","")
                        } else {
                            saveFarmers(
                                    basic.getAggregatorid(),
                                    basic.getFarmerid(),//1
                                    basic.getSurname(),//2
                                    basic.getOthername(),//3
                                    basic.getPlaceofbirth(),//4
                                    basic.getDateofbirth(),//.parse(tokens[6].replace("\"","")),//5
                                    0,//6
                                    basic.getGender(),//7
                                    basic.getHometown(),//8
                                    basic.getAddress(),//9
                                    basic.getDistrict(),//10
                                    basic.getRegion(),//11
                                    basic.getCountry(),//12
                                    null,//13
                                    null,//14
                                    basic.getLevelofeducation(),//15
                                    basic.getReligion(),//16
                                    basic.getMaritalstatus(),//17
                                    null,//18
                                    null,//19
                                    null,//20
                                    null,//21
                                    null,//22
                                    null,//23
                                    null,//24
                                    null,//25
                                    null,//26
                                    null,//27
                                    null,//28
                                    null,//29
                                    null,//30
                                    basic.getCommunity(),//31
                                    basic.getTel(),//32
                                    basic.getEmail(),//33
                                    basic.getUniqueuid(),//34
                                    basic.getPostbox(),//35
                                    "0",//36
                                    basic.getDatecreated(),//.parse(tokens[19].replace("\"","")),//37
                                    basic.getServerid(),//38
                                    basic.getMacaddress(),//39
                                    basic.getImei(),//40
                                    basic.getAgentname(),//41
                                    basic.getAgentid());//42);tokens[].replace("\"","")
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        else if (basefilename.equalsIgnoreCase("farms")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new Gson();

//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    if (populationpath.toLowerCase().contains("backup")) {
                        farmForBackupList = gson.fromJson(jsonReader, FarminfoForBackup[].class);
                        for (FarminfoForBackup farm : farmForBackupList) {
                            saveFarms(
                                    farm.getAggregatorid(),
                                    farm.getFarmid(), farm.getFarmerid(), null, farm.getDistrict(), farm.getRegion(),
                                    farm.getCommunity(),
                                    farm.getYearofestablishment(),
                                    farm.getTotalarea(),
                                    farm.getCultivatedarea(),
                                    farm.getShadetrees(),
                                    farm.getOwnership(),
                                    farm.getTypeoffarm(),
                                    farm.getPlantingmaterial(),
                                    farm.getOthersource(),
                                    farm.getLabour(),
                                    null,
                                    farm.getExtension(),
                                    farm.getOrganisation(),
                                    null,
                                    farm.getActivities(),
                                    null,
                                    null,
                                    null,
                                    farm.getUniqueuid(),
                                    "0",
                                    farm.getDateregistered(),//.parse(tokens[19].replace("\"","")),
                                    farm.getServerid(),
                                    farm.getMacaddress(),
                                    farm.getImei(),
                                    farm.getAgentname(),
                                    farm.getAgentid(),
                                    farm.getCropvariety(),
                                    farm.getFertilizerused(),
                                    farm.getFarmyield(),
                                    farm.getCropprotection(),
                                    farm.getChemicalused());
                        }
                    } else {
                        farmlist = gson.fromJson(jsonReader, Farminfo[].class);
                        for (Farminfo farm : farmlist) {
                            saveFarms(
                                    farm.getAggregatorid(),
                                    farm.getFarmid(), farm.getFarmerid(), null, farm.getDistrict(), farm.getRegion(),
                                    farm.getCommunity(),
                                    farm.getYearofestablishment(),
                                    "" + farm.getTotalarea(),
                                    "" + farm.getCultivatedarea(),
                                    "" + farm.getShadetrees(),
                                    farm.getOwnershipmethod(),
                                    farm.getTypeoffarm(),
                                    farm.getMaterialsource(),
                                    farm.getOthersource(),
                                    farm.getLaboursource(),
                                    null,
                                    farm.getExtension(),
                                    farm.getOrganisation(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    farm.getUniqueuid(),
                                    "0",
                                    farm.getDateregistered(),//.parse(tokens[19].replace("\"","")),
                                    farm.getId(),
                                    farm.getMacaddress(),
                                    farm.getImei(),
                                    farm.getAgentname(),
                                    farm.getAgentid(),
                                    farm.getCropvariety(),
                                    farm.getFertilizerused(),
                                    farm.getFarmyield(),
                                    farm.getCropprotection(),
                                    farm.getChemicalused());
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("farms_")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new Gson();

//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    if (populationpath.toLowerCase().contains("backup")) {
                        farmForBackupList = gson.fromJson(jsonReader, FarminfoForBackup[].class);
                        for (FarminfoForBackup farm : farmForBackupList) {
                            saveFarms(
                                    farm.getAggregatorid(),
                                    farm.getFarmid(), farm.getFarmerid(), null, farm.getDistrict(), farm.getRegion(),
                                    farm.getCommunity(),
                                    farm.getYearofestablishment(),
                                    farm.getTotalarea(),
                                    farm.getCultivatedarea(),
                                    farm.getShadetrees(),
                                    farm.getOwnership(),
                                    farm.getTypeoffarm(),
                                    farm.getPlantingmaterial(),
                                    farm.getOthersource(),
                                    farm.getLabour(),
                                    null,
                                    farm.getExtension(),
                                    farm.getOrganisation(),
                                    null,
                                    farm.getActivities(),
                                    null,
                                    null,
                                    null,
                                    farm.getUniqueuid(),
                                    "0",
                                    farm.getDateregistered(),//.parse(tokens[19].replace("\"","")),
                                    farm.getServerid(),
                                    farm.getMacaddress(),
                                    farm.getImei(),
                                    farm.getAgentname(),
                                    farm.getAgentid(),
                                    farm.getCropvariety(),
                                    farm.getFertilizerused(),
                                    farm.getFarmyield(),
                                    farm.getCropprotection(),
                                    farm.getChemicalused());
                        }
                    } else {
                        farmlist = gson.fromJson(jsonReader, Farminfo[].class);
                        for (Farminfo farm : farmlist) {
                            saveFarms(
                                    farm.getAggregatorid(),
                                    farm.getFarmid(), farm.getFarmerid(), null, farm.getDistrict(), farm.getRegion(),
                                    farm.getCommunity(),
                                    farm.getYearofestablishment(),
                                    "" + farm.getTotalarea(),
                                    "" + farm.getCultivatedarea(),
                                    "" + farm.getShadetrees(),
                                    farm.getOwnershipmethod(),
                                    farm.getTypeoffarm(),
                                    farm.getMaterialsource(),
                                    farm.getOthersource(),
                                    farm.getLaboursource(),
                                    null,
                                    farm.getExtension(),
                                    farm.getOrganisation(),
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    farm.getUniqueuid(),
                                    "0",
                                    farm.getDateregistered(),//.parse(tokens[19].replace("\"","")),
                                    farm.getId(),
                                    farm.getMacaddress(),
                                    farm.getImei(),
                                    farm.getAgentname(),
                                    farm.getAgentid(),
                                    farm.getCropvariety(),
                                    farm.getFertilizerused(),
                                    farm.getFarmyield(),
                                    farm.getCropprotection(),
                                    farm.getChemicalused());
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.equalsIgnoreCase("gallery")) {

        }
        else if (basefilename.startsWith("household")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new Gson();

//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    hselist = gson.fromJson(jsonReader, com.telpo.usb.finger.serverentities.Household[].class);
                    if (populationpath.toLowerCase().contains("backup")) {
                        for (com.telpo.usb.finger.serverentities.Household hse : hselist) {
                            saveHousehold(
                                    hse.getAggregatorid(),
                                    hse.getFarmerid(),
                                    hse.getHouseholdid(),
                                    hse.getRelationship(),
                                    "0",
                                    hse.getDatecreated(),//.parse(tokens[7].replace("\"","")),
                                    hse.getUniqueuid(),
                                    hse.getServerid(),
                                    hse.getMacaddress(),
                                    hse.getImei(),
                                    hse.getAgentname(),
                                    hse.getAgentid());
                        }
                    } else {
                        for (com.telpo.usb.finger.serverentities.Household hse : hselist) {
                            saveHousehold(
                                    hse.getAggregatorid(),
                                    hse.getFarmerid(),
                                    hse.getHouseholdid(),
                                    hse.getRelationship(),
                                    "0",
                                    hse.getDatecreated(),//.parse(tokens[7].replace("\"","")),
                                    hse.getUniqueuid(),
                                    hse.getId(),
                                    hse.getMacaddress(),
                                    hse.getImei(),
                                    hse.getAgentname(),
                                    hse.getAgentid());
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("locationinfo")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new Gson();


//                            jsonReader.beginArray();
//                            while (jsonReader.hasNext())
//                            {
                try {
                    loclist = gson.fromJson(jsonReader, Locationinfo[].class);
                    if (populationpath.toLowerCase().contains("backup")) {
                        for (Locationinfo loc : loclist) {
                            saveLocationCoordinates(
                                    loc.getAggregatorid(),
                                    loc.getFarmerid(),
                                    loc.getLocationtype(),
                                    loc.getFarmid(),
                                    "" + loc.getLatitude(),
                                    "" + loc.getLongitude(),
                                    loc.getStreetname(),
                                    loc.getCity(),
                                    loc.getRegion(),
                                    loc.getAssembly(),
                                    loc.getJsoncoord(),
                                    loc.getArea(),
                                    loc.getLength(),
                                    loc.getDatecrceated(),//AndroidUtils.dateStringToDate(tokens[11].replace("\"","")),//.parse(tokens[11].replace("\"","")),
                                    "0",
                                    loc.getUniqueuid(),
                                    loc.getServerid(),
                                    loc.getMacaddress(),
                                    loc.getImei(),
                                    loc.getAgentname(),
                                    loc.getAgentid());
                        }
                    } else {
                        for (Locationinfo loc : loclist) {
                            saveLocationCoordinates(
                                    loc.getAggregatorid(),
                                    loc.getFarmerid(),
                                    loc.getLocationtype(),
                                    loc.getFarmid(),
                                    "" + loc.getLatitude(),
                                    "" + loc.getLongitude(),
                                    loc.getStreetname(),
                                    loc.getCity(),
                                    loc.getRegion(),
                                    loc.getAssembly(),
                                    loc.getJsoncoord(),
                                    loc.getArea(),
                                    loc.getLength(),
                                    loc.getDatecrceated(),//AndroidUtils.dateStringToDate(tokens[11].replace("\"","")),//.parse(tokens[11].replace("\"","")),
                                    "0",
                                    loc.getUniqueuid(),
                                    loc.getId(),
                                    loc.getMacaddress(),
                                    loc.getImei(),
                                    loc.getAgentname(),
                                    loc.getAgentid());
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                        }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if (basefilename.startsWith("supportdocs")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29


//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    doclist = gson.fromJson(jsonReader, Supportdocs[].class);
                    if (populationpath.toLowerCase().contains("backup")) {
                        for (Supportdocs doc : doclist) {
                            saveSupportDocs(
                                    doc.getAggregatorid(),
                                    doc.getFarmerid(),
                                    doc.getDoctype(),
                                    doc.getDocfile(),
                                    doc.getUniqueuid(),
                                    doc.getDatecreated(),
                                    "0",
                                    doc.getServerid(),
                                    doc.getMacaddress(),
                                    doc.getImei(),
                                    doc.getAgentname(),
                                    doc.getAgentid());
                        }
                    } else {
                        for (Supportdocs doc : doclist) {
                            saveSupportDocs(
                                    doc.getAggregatorid(),
                                    doc.getFarmerid(),
                                    doc.getDoctype(),
                                    doc.getDocfile(),
                                    doc.getUniqueuid(),
                                    doc.getDatecreated(),
                                    "0",
                                    doc.getId(),
                                    doc.getMacaddress(),
                                    doc.getImei(),
                                    doc.getAgentname(),
                                    doc.getAgentid());
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("userbiometrics")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new Gson();

//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    biolist = gson.fromJson(jsonReader, Farmerbiometrics[].class);
                    if (populationpath.toLowerCase().contains("backup")) {
                        for (Farmerbiometrics bio : biolist) {
                            if (bio.getPicture().length != 0)
                                saveUserbiometrics(bio.getAggregatorid(), bio.getFarmerid(), bio.getPicture(), bio.getSignature(),
                                        null, null, bio.getDatecreated(), bio.getPlaceofregistered(),
                                        null, bio.getUniqueuid(), "0", bio.getDatecreated(), bio.getServerid(),
                                        bio.getMacaddress(), bio.getImei(), bio.getAgentname(), bio.getAgentid());
                        }
                    } else {
                        for (Farmerbiometrics bio : biolist) {
                            if (bio.getPicture().length != 0)
                                saveUserbiometrics(bio.getAggregatorid(), bio.getFarmerid(), bio.getPicture(), bio.getSignature(),
                                        null, null, bio.getDatecreated(), bio.getPlaceofregistered(),
                                        null, bio.getUniqueuid(), "0", bio.getDatecreated(), bio.getId(),
                                        bio.getMacaddress(), bio.getImei(), bio.getAgentname(), bio.getAgentid());
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (basefilename.startsWith("userfingerprint")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new Gson();

//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    fingerprintList = gson.fromJson(jsonReader, Farmerfingers[].class);
                    if (populationpath.toLowerCase().contains("backup")) {
                        for (Farmerfingers fingerprint : fingerprintList) {
                            saveUserfingerprint(
                                    fingerprint.getAggregatorid(),
                                    fingerprint.getFarmerid(),
                                    fingerprint.getFingerprint(),
                                    fingerprint.getFingertype(),
                                    fingerprint.getDatecreated(),
                                    fingerprint.getFingerprinttemplate(),//AndroidUtils.base64ToByteArray(tokens[5].replace("\"","")),
                                    null,
                                    fingerprint.getUniqueuid(),
                                    "0",
                                    fingerprint.getDatecreated(),//AndroidUtils.dateStringToDate(tokens[6].replace("\"","")),//new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tokens[6].replace("\"","")),
                                    fingerprint.getServerid(),
                                    fingerprint.getMacaddress(),
                                    fingerprint.getImei(),
                                    fingerprint.getAgentname(),
                                    fingerprint.getAgentid());
                        }
                    } else {
                        for (Farmerfingers fingerprint : fingerprintList) {
                            saveUserfingerprint(
                                    fingerprint.getAggregatorid(),
                                    fingerprint.getFarmerid(),
                                    fingerprint.getFingerprint(),
                                    fingerprint.getFingertype(),
                                    fingerprint.getDatecreated(),
                                    fingerprint.getFingerprinttemplate(),//AndroidUtils.base64ToByteArray(tokens[5].replace("\"","")),
                                    null,
                                    fingerprint.getUniqueuid(),
                                    "0",
                                    fingerprint.getDatecreated(),//AndroidUtils.dateStringToDate(tokens[6].replace("\"","")),//new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tokens[6].replace("\"","")),
                                    fingerprint.getId(),
                                    fingerprint.getMacaddress(),
                                    fingerprint.getImei(),
                                    fingerprint.getAgentname(),
                                    fingerprint.getAgentid());
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void logout() {
        progressdiag.setMessage("Logging out.....");
        progressdiag.setCancelable(false);
        progressdiag.show();
        sendLogout();
        progressdiag.dismiss();
    }

    private void sendLogout() {
        System.out.println("Just logged out!!");
        AndroidUtils.removePreferenceValue(MainNavigationDrawerAlt.this, AndroidUtils.AGENTID);
        AndroidUtils.removePreferenceValue(MainNavigationDrawerAlt.this, AndroidUtils.AGENTNAME);
        AndroidUtils.removePreferenceValue(MainNavigationDrawerAlt.this, AndroidUtils.PASSWORD);
        Intent intent = new Intent(getBaseContext(), LoginActivityAlt.class);
        startActivity(intent);
        finish();
    }

    public void navigationToFarmerActivity() {
        Intent nav = new Intent(this, FarmerActivity.class);
        this.startActivity(nav);
    }

    public void navigationToFarmSearchActivity() {
        Intent nav = new Intent(this, FarmSearchView.class);
        this.startActivity(nav);
    }

    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    class BackupDatabaseRecords extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainNavigationDrawerAlt.this);
            pDialog.setMessage("Backing up data. Please wait...");
            pDialog.setIndeterminate(true);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            try {
                String jsonstring, uploadId, uploadfilepath;
                ServerTransfer transfer;
                List<Farmers> farmersList = Farmers.listAll(Farmers.class);
                List<Userbiometrics> bio = Userbiometrics.listAll(Userbiometrics.class);
                List<Household> households = Household.listAll(Household.class);
                List<ActivityInfo> activityInfos = ActivityInfo.listAll(ActivityInfo.class);
                List<Farms> farms = Farms.listAll(Farms.class);
                List<Farmeridcard> farmeridcards = Farmeridcard.listAll(Farmeridcard.class);
                List<Userfingerprint> userfingerprints = Userfingerprint.listAll(Userfingerprint.class);
                List<SupportDocs> docs = SupportDocs.listAll(SupportDocs.class);
                List<LocationCoordinates> locationCoordinates = LocationCoordinates.listAll(LocationCoordinates.class);
                List<Declaration> declarationsList = Declaration.listAll(Declaration.class);
                List<Sales> salesList = Sales.listAll(Sales.class);
                List<Scaletran> scaletranList = Scaletran.listAll(Scaletran.class);
                List<Salestran> salestranList = Salestran.listAll(Salestran.class);
                List<FarmAssessment> farmAssessmentList = FarmAssessment.listAll(FarmAssessment.class);

                if (farmersList.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setFarmersList(farmersList);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"farmersList\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "farmers";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (households.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setHouseholdList(households);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"householdList\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "households";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (farms.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setFarmsList(farms);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"farmsList\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "farms";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (userfingerprints.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setFingerlist(userfingerprints);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"fingerlist\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "userfingerprints";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (activityInfos.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setActivityInfoList(activityInfos);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"activityInfoList\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "activity";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (farmeridcards.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setFarmeridcardList(farmeridcards);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"farmeridcardList\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "idcard";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (locationCoordinates.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setLocationCoordinatesList(locationCoordinates);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"locationCoordinatesList\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "locationinfo";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (declarationsList.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setDeclarationList(declarationsList);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"declarationList\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "declaration";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (salesList.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setSalesList(salesList);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"salesList\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "sales_1";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (scaletranList.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setScaletranList(scaletranList);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"scaletranList\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "scaletran";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (salestranList.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setSalestranList(salestranList);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"salestranList\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "salestran";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (farmAssessmentList.size() > 0) {
                    transfer = new ServerTransfer();
                    transfer.setAssessmentList(farmAssessmentList);
                    jsonstring = new Gson().toJson(transfer);
                    jsonstring = jsonstring.replace("{\"assessmentList\":", "");
                    jsonstring = jsonstring.substring(0, jsonstring.length() - 1).trim();
                    uploadId = "farmassessment";
                    uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                }
                if (docs.size() > 0) {

                    for (int i = 0; i < docs.size(); i++) {

                        transfer = new ServerTransfer();
                        transfer.setDocs(docs.get(i));
                        jsonstring = new Gson().toJson(transfer);
                        jsonstring = jsonstring.replace("{\"docs\":", "");
                        jsonstring = jsonstring.substring(0, jsonstring.length() - 1);
                        jsonstring = "[" + jsonstring.trim() + "]";
                        jsonstring = jsonstring.trim();
                        uploadId = "supportdocs" + i;
                        uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                    }
                }
                if (bio.size() > 0) {

                    for (int i = 0; i < bio.size(); i++) {

                        transfer = new ServerTransfer();
                        transfer.setUserbiometrics(bio.get(i));
                        jsonstring = new Gson().toJson(transfer);
                        jsonstring = jsonstring.replace("{\"userbiometrics\":", "");
                        jsonstring = jsonstring.substring(0, jsonstring.length() - 1);
                        jsonstring = "[" + jsonstring.trim() + "]";
                        jsonstring = jsonstring.trim();
                        uploadId = "userbiometrics" + i;
                        uploadfilepath = AndroidUtils.writeToBackuppath(jsonstring, uploadId + ".json");
                    }
                }
            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return "";
        }


        /**
         * After completing background task
         * Dismiss the progress dialog
         **/
        @Override
        protected void onPostExecute(String file_url) {
            if (pDialog != null) {
                pDialog.setMessage("All Done");
                pDialog.dismiss();
            }
        }
    }

    class UpdateServerRecords extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainNavigationDrawerAlt.this);
            pDialog.setMessage("Working. Please wait...");
            pDialog.setIndeterminate(true);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            try {
                String farmerid, jsonstring, uploadId, uploadfilepath, dup = "duplicate", nondup = "not-duplicate";
                ServerTransfer transfer = new ServerTransfer();
                List<Farmers> farmersList = Farmers.listAll(Farmers.class);

                //                for (int i = 0; i < farmersList.size(); i++){
//                    Farmers farmer = farmersList.get(i);
//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, AndroidUtils.CHECK_DUPLICATE_URL, new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            Log.e("Volley Response", "" + response);
//                            if (response.equals("\"not duplicate\"")) {
//                                AndroidUtils.writeToFile(farmer.getFarmerid(), nondup+" "+farmer.getFarmerid()+ "__" + farmer.getId() + ".txt");
//                            } else if (response.equals("\"duplicate\"")) {
//                                AndroidUtils.writeToFile(farmer.getFarmerid(), dup+ " "+farmer.getFarmerid()+ "__" + farmer.getId()  + ".txt");
//                            }
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            error.printStackTrace();
//                        }
//                    }) {
//                        @Override
//                        protected Map<String, String> getParams() throws AuthFailureError {
//                            Map<String, String> postMap = new HashMap<>();
//                            postMap.put("farmerid", farmer.getFarmerid());
//                            postMap.put("uniqueuid", farmer.getUniqueuid());
//                            return postMap;
//                        }
//                    };
//
//                    Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
//                }

                String changed[] = {
                        "UCL-AS-156-3421-4183-87-BR-BR22",
                        "UCL-MM-156-3421-4376-27-BR-BR22",
                        "UCL-MM-156-3421-4314-09-BR-BR22",
                        "UCL-AA-156-3421-4252-74-BR-BR18",
                        "UCL-PT-156-3421-4356-11-BR-BR22",
                        "UCL-FO-156-3421-4335-88-BR-BR22",
                        "UCL-KB-156-3421-4417-75-BR-BR22",
                        "UCL-CB-156-3421-4449-17-BR-BR22",
                        "UCL-FA-156-3421-4213-05-BR-BR22",
                        "UCL-RB-156-3422-4490-85-BR-BR22",
                        "UCL-AA-156-3421-4485-04-BR-BR22",
                        "UCL-SA-156-3421-4274-74-BR-BR22",
                        "UCL-SA-156-3421-4467-09-BR-BR22",
                };
                for (String aChanged : changed) {
                    for (Farmers farmer : farmersList) {
                        if (farmer.getFarmerid().equals(aChanged)) {
//                            tring rc = getRegionCode(farmer.getRegion()).toUpperCase();
//                            String dc = getDistrictCode(farmer.getDistrict(), rc).toUpperCase();
//                            String timestamp = String.valueOf(System.currentTimeMillis());
//                            farmerid = "UCL-" +
//                                    farmer.getOthername().toUpperCase().charAt(0) +
//                                    farmer.getSurname().toUpperCase().charAt(0) + "-" +
//                                    timestamp.substring(0, 3) + "-" +
//                                    timestamp.substring(3, 7) + "-" +
//                                    timestamp.substring(7, 11) + "-" +
//                                    timestamp.substring(11) + "-" +
//                                    rc + "-" +
//                                    dc;S

//                            Log.d("FARMERID", timestamp);
//                            Log.d("FARMERID", farmerid);
                            Log.d("FARMERIDOLD", farmer.getFarmerid());

                            List<Userbiometrics> bio = Userbiometrics.find(Userbiometrics.class, "farmerid=?", farmer.getFarmerid());
                            List<Household> households = Household.find(Household.class, "farmerid=?", farmer.getFarmerid());
                            List<ActivityInfo> activityInfos = ActivityInfo.find(ActivityInfo.class, "farmerid=?", farmer.getFarmerid());
                            List<Farms> farms = Farms.find(Farms.class, "farmerid=?", farmer.getFarmerid());
                            List<Farmeridcard> farmeridcards = Farmeridcard.find(Farmeridcard.class, "farmerid=?", farmer.getFarmerid());
                            List<Userfingerprint> userfingerprints = Userfingerprint.find(Userfingerprint.class, "farmerid=?", farmer.getFarmerid());
                            List<SupportDocs> docs = SupportDocs.find(SupportDocs.class, "farmerid=?", farmer.getFarmerid());
                            List<LocationCoordinates> locationCoordinates = LocationCoordinates.find(LocationCoordinates.class, "farmerid=?", farmer.getFarmerid());

                            if (bio.size() > 0) {
                                for (Userbiometrics userbiometrics : bio) {
//                                    userbiometrics.farmerid = farmerid;
//                                    userbiometrics.save();
                                    transfer = new ServerTransfer();
                                    transfer.setUserbiometrics(userbiometrics);
                                    jsonstring = new Gson().toJson(transfer);
                                    uploadId = AndroidUtils.getUUID();
                                    uploadfilepath = AndroidUtils.writeToFileUploadTemp(jsonstring, uploadId + ".txt");
                                }
                            }
                            if (households.size() > 0) {
                                for (Household household : households) {
//                                    household.farmerid = farmerid;
//                                    household.save();
                                    transfer.setHousehold(household);
                                    transfer = new ServerTransfer();
                                    jsonstring = new Gson().toJson(transfer);
                                    uploadId = AndroidUtils.getUUID();
                                    uploadfilepath = AndroidUtils.writeToFileUploadTemp(jsonstring, uploadId + ".txt");
                                }
                            }
                            if (activityInfos.size() > 0) {
                                for (ActivityInfo activityInfo : activityInfos) {
//                                    activityInfo.farmerid = farmerid;
//                                    activityInfo.save();
                                    transfer.setActivityInfo(activityInfo);
                                    transfer = new ServerTransfer();
                                    jsonstring = new Gson().toJson(transfer);
                                    uploadId = AndroidUtils.getUUID();
                                    uploadfilepath = AndroidUtils.writeToFileUploadTemp(jsonstring, uploadId + ".txt");
                                }
                            }
                            if (farms.size() > 0) {
                                for (Farms farm : farms) {
//                                    farm.farmerid = farmerid;
//                                    farm.save();
                                    transfer = new ServerTransfer();
                                    transfer.setFarms(farm);
                                    jsonstring = new Gson().toJson(transfer);
                                    uploadId = AndroidUtils.getUUID();
                                    uploadfilepath = AndroidUtils.writeToFileUploadTemp(jsonstring, uploadId + ".txt");
                                }
                            }
                            if (farmeridcards.size() > 0) {
                                for (Farmeridcard farmeridcard : farmeridcards) {
//                                    farmeridcard.farmerid = farmerid;
//                                    farmeridcard.save();
                                    transfer = new ServerTransfer();
                                    transfer.setFarmeridcard(farmeridcard);
                                    jsonstring = new Gson().toJson(transfer);
                                    uploadId = AndroidUtils.getUUID();
                                    uploadfilepath = AndroidUtils.writeToFileUploadTemp(jsonstring, uploadId + ".txt");
                                }
                            }
                            if (userfingerprints.size() > 0) {
                                for (Userfingerprint userfingerprint : userfingerprints) {
//                                    userfingerprint.farmerid = farmerid;
//                                    userfingerprint.save();
                                }
                                transfer = new ServerTransfer();
                                transfer.setFingerlist(userfingerprints);
                                jsonstring = new Gson().toJson(transfer);
                                uploadId = AndroidUtils.getUUID();
                                uploadfilepath = AndroidUtils.writeToFileUploadTemp(jsonstring, uploadId + ".txt");
                            }
                            if (docs.size() > 0) {
//                                for (SupportDocs supportDocs : docs) {
//                                    supportDocs.farmerid = farmerid;
//                                    supportDocs.save();
//                                }
                                transfer = new ServerTransfer();
                                transfer.setSupportdocs(docs);
                                jsonstring = new Gson().toJson(transfer);
                                uploadId = AndroidUtils.getUUID();
                                uploadfilepath = AndroidUtils.writeToFileUploadTemp(jsonstring, uploadId + ".txt");
                            }
                            if (locationCoordinates.size() > 0) {
                                for (LocationCoordinates coordinates : locationCoordinates) {
//                                    coordinates.farmerid = farmerid;
//                                    coordinates.save();
                                    transfer = new ServerTransfer();
                                    transfer.setLocationCoordinates(coordinates);
                                    jsonstring = new Gson().toJson(transfer);
                                    uploadId = AndroidUtils.getUUID();
                                    uploadfilepath = AndroidUtils.writeToFileUploadTemp(jsonstring, uploadId + ".txt");
                                }
                            }
//                            farmer.farmerid = farmerid;
//                            farmer.save();
                            transfer = new ServerTransfer();
                            transfer.setFarmers(farmer);
                            jsonstring = new Gson().toJson(transfer);
                            uploadId = AndroidUtils.getUUID();
                            uploadfilepath = AndroidUtils.writeToFileUploadTemp(jsonstring, uploadId + ".txt");
                        }
                    }
                }

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return "";
        }


        /**
         * After completing background task
         * Dismiss the progress dialog
         **/
        @Override
        protected void onPostExecute(String file_url) {
            if (pDialog != null) {
                pDialog.setMessage("All Done");
//                AndroidUtils.uploadFileToServer(getApplicationContext());
                pDialog.dismiss();
            }
        }
    }

    class DeleteFarmers extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            try {

                String farmersSaved = AndroidUtils.getPreferenceData(MainNavigationDrawerAlt.this, Constants.SAVED_SERVER_FARMER, "");
                if (farmersSaved.length() > 0) {
                    if (farmersSaved.contains(",")) {
                        String[] parts = farmersSaved.split(",");
                        for (String x : parts) {
                            if (!x.isEmpty())
                                AndroidUtils.deleteAllFarmerAndAssociatedData(x);
                        }
                    } else {
                        if (!farmersSaved.isEmpty())
                            AndroidUtils.deleteAllFarmerAndAssociatedData(farmersSaved);
                    }
                }

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return "";
        }


        /**
         * After completing background task
         * Dismiss the progress dialog
         **/
        @Override
        protected void onPostExecute(String file_url) {

        }
    }

    class CheckFilesBeforeUploads extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainNavigationDrawerAlt.this);
            pDialog.setMessage("Working. Please wait...");
            pDialog.setIndeterminate(true);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            try {

//                String farmerid, jsonstring, uploadId, uploadfilepath, jsoncontentsDuplicate, jsoncontentsCorrected;
//                ServerTransfer transfer;
//                List<File> duplicateFiles = AndroidUtils.getListOfFiles(new File(AndroidUtils.tempSyncFileDirectoryPath()));
//                List<File> correctedFiles = AndroidUtils.getListOfFiles(new File(AndroidUtils.uploadTempDirectoryPath()));
//                JSONObject newfile = new JSONObject();
//                int count = 0;
//                if (duplicateFiles.size() > 0) {
//
//                    for (File aFile : duplicateFiles) {
//                        try {
//                            InputStream is = new FileInputStream(aFile);
//                            int size = is.available();
//                            byte[] buffer = new byte[size];
//                            is.read(buffer);
//                            is.close();
//                            jsoncontentsDuplicate = new String(buffer, StandardCharsets.UTF_8);
//                        } catch (Exception e) {
//                            jsoncontentsDuplicate = null;
//                            e.printStackTrace();
//                            return null;
//                        }
//
//                        for (File cFile : correctedFiles) {
//                            try {
//                                InputStream is = new FileInputStream(cFile);
//                                int size = is.available();
//                                byte[] buffer = new byte[size];
//                                is.read(buffer);
//                                is.close();
//                                jsoncontentsCorrected = new String(buffer, StandardCharsets.UTF_8);
//                            } catch (Exception e) {
//                                jsoncontentsCorrected = null;
//                                e.printStackTrace();
//                                return null;
//                            }
//
//                            if (jsoncontentsDuplicate.length() > 0 && jsoncontentsCorrected.length() > 0) {
//                                try {
//                                    JSONObject objDuplicate = new JSONObject(jsoncontentsDuplicate);
//                                    JSONObject objCorrected = new JSONObject(jsoncontentsCorrected);
//                                    JSONObject uniqueDup = objDuplicate.getJSONObject(TAG_FARMERID_CARD);
//                                    JSONObject uniqueCor = objCorrected.getJSONObject(TAG_FARMERID_CARD);
//
//                                    if (uniqueDup.getString("uniqueuid").equalsIgnoreCase(uniqueCor.getString("uniqueuid"))) {
//                                        JSONObject objFarmers = objDuplicate.getJSONObject(TAG_FARMERS);
//                                        objFarmers.put("farmerid", uniqueCor.getString("farmerid"));
//                                        objFarmers.put("uniqueuid", AndroidUtils.getUUID());
//
//                                        newfile.put(TAG_FARMERS, objFarmers);
//                                        jsonstring = newfile.toString();
//                                        uploadId = AndroidUtils.getUUID();
//                                        uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
//                                        count++;
//                                        Log.e(TAG, "::::::"+count+" farmers");
//                                    }
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//                        }
//                    }
//                }
                String farmerid, jsonstring, uploadId, uploadfilepath, jsoncontents;
                ServerTransfer transfer;
                List<File> files = AndroidUtils.getListOfFiles(new File(AndroidUtils.uploadDirectoryPath()));

                if (files.size() > 0) {

                    for (File aFile : files) {
                        try {
                            InputStream is = new FileInputStream(aFile);
                            int size = is.available();
                            byte[] buffer = new byte[size];
                            is.read(buffer);
                            is.close();
                            jsoncontents = new String(buffer, StandardCharsets.UTF_8);
                        } catch (Exception e) {
                            jsoncontents = null;
                            e.printStackTrace();
                            return null;
                        }

                        if (jsoncontents.length() > 0) {
                            JSONObject xxx = new JSONObject(jsoncontents);
                            JSONObject farmersObject = xxx.getJSONObject(TAG_FARMERS);
                            List<Farmers> farmerList = Farmers.find(Farmers.class, "uniqueuid = ?", farmersObject.getString("uniqueuid"));

                            if (farmerList.size() > 0) {
                                Farmers farmers = farmerList.get(0);
                                checkDuplicateOnServer(farmers, xxx, aFile);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return "";
        }


        /**
         * After completing background task
         * Dismiss the progress dialog
         **/
        @Override
        protected void onPostExecute(String file_url) {
            if (pDialog != null) {
                pDialog.setMessage("All Done");
//                AndroidUtils.uploadFileToServer(getBaseContext());
                result.updateBadge(11, new StringHolder(unsyncedFiles() + " File(s)"));
                pDialog.dismiss();
            }
        }
    }

    private class DateDeserializer implements JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonElement jsonElement, Type typeOF, JsonDeserializationContext context) throws JsonParseException {
            for (String format : DATE_FORMATS) {
                try {
                    return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
                } catch (ParseException e) {
                }
            }
            throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
                    + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
        }
    }

    class LoadFileFromFolder extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainNavigationDrawerAlt.this);
            pDialog.setMessage("Loading data. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setMax(100);
            pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pDialog.setCancelable(false);
            pDialog.show();

        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                Districts.deleteAll(Districts.class);
                Regions.deleteAll(Regions.class);
                List<File> files;
                if (populationpath.toLowerCase().contains("csvdata")) {

                    files = AndroidUtils.getListOfJsonFiles(new File(AndroidUtils.csvDirectoryPath()));

                } else {
                    files = AndroidUtils.getListOfJsonFiles(new File(AndroidUtils.backupDirectoryPath()));
                }
                int lenghtOfFile = files.size();
                long total = 0;

                for (final File filename : files) {
                    total++;
//                    loadCouponitems();

                    if (AndroidUtils.getPreferenceData(MainNavigationDrawerAlt.this, AndroidUtils.CONTRACTPREF, "false").equals("false")) {
//                        loadCouponitems();
                    }

                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pDialog.setMessage("Loading data from " + FilenameUtils.getBaseName(filename.getAbsolutePath()));
                        }
                    });


                    readJSONFromDirectory(filename);
                }
            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        /**
         * After completing background task
         * Dismiss the progress dialog
         **/
        @Override
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after the file was downloaded
            farmersCount();
            farmsCount();
            if (pDialog != null) {
                pDialog.setMessage("All Done");
                pDialog.dismiss();
            }
        }
    }

    private void checkDuplicateOnServer(Farmers farmer, JSONObject xxx, File aFile) {
        Log.e(TAG, "IN CHECKDUPLICATE\n" + xxx.toString());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AndroidUtils.CHECK_DUPLICATE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Volley Response", "" + response);
                if (response.equals("\"not duplicate\"")) {
                    if (checked) {
                        AndroidUtils.uploadFileToServerFromTempFolder(getApplicationContext());
                        checked = false;
                    } else {
                        if (aFile.renameTo(new File(AndroidUtils.uploadTempDirectoryPath() + File.separator + aFile.getName()))) {
                            AndroidUtils.uploadFileToServerFromTempFolder(getApplicationContext());

                        } else Toasty.error(getApplicationContext(), "Error").show();
                    }

                    numberOfRequestsToMake--;

                    if (numberOfRequestsToMake == 0) {
                        stillRunning = false;
                    }
                } else if (response.equals("\"duplicate\"")) {
                    Log.e(TAG, "generating new farmerid");
                    boolean delmsg = FileUtils.deleteQuietly(new File(AndroidUtils.uploadDirectoryPath() + File.separator + aFile.getName()));

                    if (delmsg) {
                        Toasty.success(getApplicationContext(), "Deleted").show();

                    } else Toasty.error(getApplicationContext(), "Not deleted").show();
                    checked = true;
                    generatefarmerid(farmer);
                    ServerTransfer transfer = new ServerTransfer();
                    try {
                        JSONObject newfile = new JSONObject();
                        JSONObject activityInfo = xxx.getJSONObject(TAG_ACTIVITY_INFO);
                        JSONArray supportdocs = xxx.getJSONArray(TAG_SUPPORT_DOCS);
                        JSONObject farmercardid = xxx.getJSONObject(TAG_FARMERID_CARD);
                        JSONObject userbiometrics = xxx.getJSONObject(TAG_USER_BIOMETRICS);

//                        activityInfo.put("farmerid", farmerid);
//
//                        for (int i = 0; i < supportdocs.length(); i++) {
//                            supportdocs.getJSONObject(i).put("farmerid", farmerid);
//                        }
//
//                        farmercardid.put("farmerid", farmerid);
//
//                        userbiometrics.put("farmerid", farmerid);
//
//                        newfile.put(TAG_ACTIVITY_INFO, activityInfo);
//                        newfile.put(TAG_FARMERID_CARD, farmercardid);
//                        newfile.put(TAG_USER_BIOMETRICS, userbiometrics);
//                        newfile.put(TAG_SUPPORT_DOCS, supportdocs);

                        List<ActivityInfo> activityInfoList = ActivityInfo.find(ActivityInfo.class, "farmerid = ?", activityInfo.getString("farmerid"));
                        List<Farmeridcard> farmeridcardList = Farmeridcard.find(Farmeridcard.class, "farmerid = ?", farmercardid.getString("farmerid"));
                        List<Userbiometrics> userbiometricsList = Userbiometrics.find(Userbiometrics.class, "farmerid = ?", userbiometrics.getString("farmerid"));
                        List<LocationCoordinates> locationCoordinatesList = LocationCoordinates.find(LocationCoordinates.class, "farmerid = ?", farmer.getFarmerid());
                        List<Farms> farmsList = Farms.find(Farms.class, "farmerid = ?", farmer.getFarmerid());


                        if (activityInfoList.size() > 0) {
                            ActivityInfo info = activityInfoList.get(0);
                            info.farmerid = farmerid;
                            info.uniqueuid = uniqueuid;
                            info.save();
                            transfer.setActivityInfo(info);
                        }

                        if (farmsList.size() > 0) {
                            Farms farms = farmsList.get(0);
                            farms.farmerid = farmerid;
                            farms.uniqueuid = uniqueuid;
                            farms.save();
                            transfer.setFarms(farms);
//                            String jsonstring = new Gson().toJson(transfer);
//                            JSONObject x = new JSONObject(jsonstring);
//                            newfile.put(TAG_FARMS, x);
                        }

                        if (farmer != null) {
                            farmer.farmerid = farmerid;
                            farmer.uniqueuid = uniqueuid;
                            farmer.save();
                            transfer.setFarmers(farmer);
                        }

                        if (locationCoordinatesList.size() > 0) {
                            LocationCoordinates coordinates = locationCoordinatesList.get(0);
                            coordinates.farmerid = farmerid;
                            coordinates.uniqueuid = uniqueuid;
                            coordinates.save();
                            transfer.setLocationCoordinates(coordinates);
//                            String jsonstring = new Gson().toJson(transfer);
//                            JSONObject x = new JSONObject(jsonstring);
//                            newfile.put(TAG_LOCATION, x);

                        }

                        if (supportdocs.length() > 0) {
                            List<SupportDocs> supportDocsList = new ArrayList<>();
                            for (int i = 0; i < supportdocs.length(); i++) {
                                supportDocsList = SupportDocs.find(SupportDocs.class, "uniqueuid = ?", supportdocs.getJSONObject(i).getString("uniqueuid"));
                                if (supportDocsList.size() > 0) {
                                    for (SupportDocs aDocs : supportDocsList) {
                                        aDocs.farmerid = farmerid;
                                        aDocs.uniqueuid = uniqueuid;
                                        aDocs.save();
                                    }
                                }
                            }
                            transfer.setSupportdocs(supportDocsList);
                        }

                        if (farmeridcardList.size() > 0) {
                            Farmeridcard farmeridcard = farmeridcardList.get(0);
                            farmeridcard.farmerid = farmerid;
                            farmeridcard.uniqueuid = uniqueuid;
                            farmeridcard.save();
                            transfer.setFarmeridcard(farmeridcard);
                        }

                        if (userbiometricsList.size() > 0) {
                            Userbiometrics aUser = userbiometricsList.get(0);
                            aUser.farmerid = farmerid;
                            aUser.uniqueuid = uniqueuid;
                            aUser.save();
                            transfer.setUserbiometrics(aUser);
                        }

//                        String jsonstring = newfile.toString();
                        String jsonstring = new Gson().toJson(transfer);
                        String uploadId = AndroidUtils.getUUID();
                        String uploadfilepath = AndroidUtils.writeToFileUploadTemp(jsonstring, uploadId + ".txt");
//                        AndroidUtils.uploadFileToServerFromTempFolder(getApplicationContext());
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(TAG, "error whilst decoding duplicate farmer object");
                    }

//                    checkDuplicateOnServer(farmer, xxx, aFile);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> postMap = new HashMap<>();
                postMap.put("farmerid", farmer.getFarmerid());
                postMap.put("uniqueuid", farmer.getUniqueuid());
                return postMap;
            }
        };

        stringRequest.setTag(aFile.getName());
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }

    public void generatefarmerid(Farmers farmer) {
        String rc = getRegionCode(farmer.getRegion()).toUpperCase();
        String dc = getDistrictCode(farmer.getDistrict(), rc).toUpperCase();
        String timestamp = String.valueOf(System.currentTimeMillis());
        farmerid = "UCL-" +
                farmer.getOthername().toUpperCase().charAt(0) +
                farmer.getSurname().toUpperCase().charAt(0) + "-" +
                timestamp.substring(0, 3) + "-" +
                timestamp.substring(3, 7) + "-" +
                timestamp.substring(7, 11) + "-" +
                timestamp.substring(11) + "-" +
                rc + "-" +
                dc;
        Log.d(TAG, "NEW FARMER ID: " + timestamp);
        Log.d(TAG, "NEW FARMER ID: " + farmerid);

        uniqueuid = AndroidUtils.getUUID();
    }

    public boolean checkInternetConnectivity() {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("path")) {
            populationpath = selection;
            new LoadFileFromFolder().execute("");
        }
    }

    @Override
    public void onFinishExport(String error) {
        progDialog.dismiss();
        String notify = error;
        if (error == null) {
            notify = "Export success";
        }
        Toasty.success(getApplicationContext(), notify).show();
    }

    @Override
    public void onFinishImport(String error) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        result.updateBadge(11, new StringHolder(unsyncedFiles() + " File(s)"));
        farmersCount();
        farmsCount();
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public long unsyncedFiles() {
        try {
            return new File(AndroidUtils.uploadDirectoryPath()).listFiles().length;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
