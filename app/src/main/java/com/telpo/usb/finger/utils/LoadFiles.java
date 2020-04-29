package com.telpo.usb.finger.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.telpo.usb.finger.entities.ActivityInfo;
import com.telpo.usb.finger.entities.Aggregator;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.FarmAssessment;
import com.telpo.usb.finger.entities.Farmeridcard;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Farms;
import com.telpo.usb.finger.entities.Gallery;
import com.telpo.usb.finger.entities.Household;
import com.telpo.usb.finger.entities.LocationCoordinates;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.entities.SupportDocs;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.entities.Userfingerprint;
import com.telpo.usb.finger.serverentities.Activityinfo;
import com.telpo.usb.finger.serverentities.Basicfarmerinfo;
import com.telpo.usb.finger.serverentities.Declarationinfo;
import com.telpo.usb.finger.serverentities.FarmAssessmentinfo;
import com.telpo.usb.finger.serverentities.Farmerbiometrics;
import com.telpo.usb.finger.serverentities.FarmerbiometricsExport;
import com.telpo.usb.finger.serverentities.Farmerfingers;
import com.telpo.usb.finger.serverentities.Farminfo;
import com.telpo.usb.finger.serverentities.FarminfoForBackup;
import com.telpo.usb.finger.serverentities.Locationinfo;
import com.telpo.usb.finger.serverentities.Salesinfo;
import com.telpo.usb.finger.serverentities.Salestraninfo;
import com.telpo.usb.finger.serverentities.Scaletraninfo;
import com.telpo.usb.finger.serverentities.Supportdocs;
import com.telpo.usb.finger.serverentities.SupportdocsExport;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LoadFiles {
    public Context context;
    ProgressDialog pDialog;
    Activity activity;
    Salesinfo[] saleslist = null;
    Salestraninfo[] salestranlist = null;
    Declarationinfo[] declarationlist = null;
    Scaletraninfo[] scaletranlist = null;
    FarmAssessmentinfo[] farmAssessmentlist = null;
    Supportdocs[] doclist = null;
    SupportdocsExport[] doclistexport = null;
    Farmerbiometrics[] biolist = null;
    FarmerbiometricsExport[] biolistexport = null;
    Farmerfingers[] fingerprintList = null;
    Locationinfo[] loclist = null;
    Farminfo[] farmlist = null;
    FarminfoForBackup[] farmForBackupList = null;
    com.telpo.usb.finger.serverentities.Household[] hselist = null;
    Basicfarmerinfo[] basiclist = null;
    com.telpo.usb.finger.serverentities.Farmeridcard[] idcardlist = null;
    Activityinfo[] actlist = null;
    Gson gson = null;
    String basefilename = "", aggregatorid;
    private static final String[] DATE_FORMATS = new String[]{"MMM dd, yyyy HH:mm:ss a", "MMM dd, yyyy HH:mm:ss", "MMM dd, yyyy", "MMM d, yyyy", "HH:mm:ss a", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"};
    public static String TAG = "FARMERDOWNLOAD";

    public LoadFiles(Context context, Activity activity, String aggregatorid) {
        this.context = context;
        this.activity = activity;
        this.aggregatorid = aggregatorid;
        Log.d(TAG, "LOADING FILES");
        new LoadFileFromFolder().execute();
    }

    class LoadFileFromFolder extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(activity);
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
                List<File> files = AndroidUtils.getListOfJsonFiles(new File(AndroidUtils.downloadDirectoryPath()));

                int lenghtOfFile = files.size();
                long total = 0;

                for (final File filename : files) {
                    total++;

                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pDialog.setMessage("Loading data from " + FilenameUtils.getBaseName(filename.getAbsolutePath()));
                        }
                    });

                    Log.d(TAG, "Loading file::: " + filename.getName());
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

            if (pDialog != null) {
                pDialog.setMessage("All Done");
                pDialog.dismiss();
            }
        }
    }

    public void readJSONFromDirectory(File filename) {
        System.out.println("File name: " + filename);
        basefilename = FilenameUtils.getBaseName(filename.getAbsolutePath());

        if (basefilename.startsWith("activity")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();

                try {
                    actlist = gson.fromJson(jsonReader, Activityinfo[].class);
                    System.out.println(actlist.toString());
                    for (Activityinfo act : actlist) {
                        saveActivityInfo(
                                aggregatorid,
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

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //}
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.startsWith("sales_")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29

                try {
                    saleslist = gson.fromJson(jsonReader, Salesinfo[].class);
                    for (Salesinfo salesinfo : saleslist) {
                        saveSales(
                                aggregatorid,
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

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.startsWith("salestran")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29

                try {
                    salestranlist = gson.fromJson(jsonReader, Salestraninfo[].class);
                    for (Salestraninfo salestraninfo : salestranlist) {
                         saveSalestran(
                                    aggregatorid,
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

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.startsWith("scaletran")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29

                try {
                    scaletranlist = gson.fromJson(jsonReader, Scaletraninfo[].class);
                    for (Scaletraninfo scaletraninfo : scaletranlist) {
                        saveScaletran(
                                aggregatorid,
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
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.startsWith("declaration")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29

                try {
                    declarationlist = gson.fromJson(jsonReader, Declarationinfo[].class);
                    for (Declarationinfo declarationinfo : declarationlist) {
                            saveDeclaration(
                                    aggregatorid,
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
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.startsWith("farmassessment")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29

                try {
                    farmAssessmentlist = gson.fromJson(jsonReader, FarmAssessmentinfo[].class);

                    for (FarmAssessmentinfo assessmentinfo : farmAssessmentlist) {
                        saveFarmassessment(
                                aggregatorid,
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
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.startsWith("idcard")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();
//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    idcardlist = gson.fromJson(jsonReader, com.telpo.usb.finger.serverentities.Farmeridcard[].class);

                    for (com.telpo.usb.finger.serverentities.Farmeridcard idcard : idcardlist) {
                        saveFarmeridcard(
                                aggregatorid,
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
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.startsWith("farmers")) {
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
                        if (aggregatorList.size() > 0) {
                            for (Aggregator agg : aggregatorList) {
                                if (agg.getAggregatorid().equalsIgnoreCase(aggregatorid)) {
                                    found = true;
                                    break;
                                } else {
                                    found = false;
                                    aggregator.setAggregatorid(aggregatorid);
                                }
                            }
                        } else {
                            aggregator.setAggregatorid(aggregatorid);
                            aggregator.save();
                            aggregatorList.add(aggregator);
                            found = true;
                        }

                        if (!found) {
                            aggregator.save();
                            aggregatorList.add(aggregator);
                        }

                            saveFarmers(
                                    aggregatorid, //basic.getAggregatorid(),
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


                        }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }

//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }


        } else if (basefilename.equalsIgnoreCase("farms")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();

//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    farmlist = gson.fromJson(jsonReader, Farminfo[].class);
                    for (Farminfo farm : farmlist) {
                        saveFarms(
                                aggregatorid,
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

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.startsWith("farms_")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();

//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {

                    farmlist = gson.fromJson(jsonReader, Farminfo[].class);
                    for (Farminfo farm : farmlist) {
                        saveFarms(
                                aggregatorid,
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
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.equalsIgnoreCase("gallery")) {

        } else if (basefilename.startsWith("household")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();

//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    hselist = gson.fromJson(jsonReader, com.telpo.usb.finger.serverentities.Household[].class);

                    for (com.telpo.usb.finger.serverentities.Household hse : hselist) {
                        saveHousehold(
                                aggregatorid,
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


                } catch (Exception ex) {
                    ex.printStackTrace();
                }

//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.startsWith("locationinfo")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();


//                            jsonReader.beginArray();
//                            while (jsonReader.hasNext())
//                            {
                try {
                    loclist = gson.fromJson(jsonReader, Locationinfo[].class);
                    for (Locationinfo loc : loclist) {
                        saveLocationCoordinates(
                                aggregatorid,
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


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                        }


            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (basefilename.startsWith("supportdocs")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();//new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss a").create();//Mar 13, 2018 12:28:38 AM --May 19, 2018 17:08:29

                try {
                    doclistexport = gson.fromJson(jsonReader, SupportdocsExport[].class);

                    for (SupportdocsExport doc : doclistexport) {
                        saveSupportDocs(
                                aggregatorid,
                                doc.getFarmerid(),
                                doc.getDoctype(),
                                AndroidUtils.base64ToByteArray(doc.getDocfile()),
                                doc.getUniqueuid(),
                                doc.getDatecreated(),
                                "0",
                                doc.getId(),
                                doc.getMacaddress(),
                                doc.getImei(),
                                doc.getAgentname(),
                                doc.getAgentid());

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.startsWith("userbiometrics")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();

//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    biolistexport = gson.fromJson(jsonReader, FarmerbiometricsExport[].class);

                    for (FarmerbiometricsExport bio : biolistexport) {
                        if (bio.getPicture().length() != 0)
                            saveUserbiometrics(
                                    aggregatorid,
                                    bio.getFarmerid(),
                                    AndroidUtils.base64ToByteArray(bio.getPicture()),
                                    AndroidUtils.base64ToByteArray(bio.getSignature()),
                                    null,
                                    null,
                                    bio.getDatecreated(),
                                    bio.getPlaceofregistered(),
                                    null,
                                    bio.getUniqueuid(),
                                    "0",
                                    bio.getDatecreated(),
                                    bio.getId(),
                                    bio.getMacaddress(),
                                    bio.getImei(),
                                    bio.getAgentname(),
                                    bio.getAgentid());
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (basefilename.startsWith("userfingerprint")) {
            try (JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();

//                        jsonReader.beginArray();
//                        while (jsonReader.hasNext())
//                        {
                try {
                    fingerprintList = gson.fromJson(jsonReader, Farmerfingers[].class);
                    for (Farmerfingers fingerprint : fingerprintList) {
                        saveUserfingerprint(
                                aggregatorid,
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


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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

            Log.d(TAG, "Saving farmer::: SUCCESS");
        } catch (Exception e) {
            Log.d(TAG, "Saving farmer::: ERROR:: " + e.getMessage());
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

}
