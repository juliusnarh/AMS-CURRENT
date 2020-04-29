package com.telpo.usb.finger.registration.fragments;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.orm.SugarRecord;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.databinding.FragmentRegPreviewBinding;
import com.telpo.usb.finger.entities.ActivityInfo;
import com.telpo.usb.finger.entities.Districts;
import com.telpo.usb.finger.entities.Farmeridcard;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Farms;
import com.telpo.usb.finger.entities.Household;
import com.telpo.usb.finger.entities.LocationCoordinates;
import com.telpo.usb.finger.entities.Regions;
import com.telpo.usb.finger.entities.SupportDocs;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.entities.Userfingerprint;
import com.telpo.usb.finger.pojo.ActivityInfoPojo;
import com.telpo.usb.finger.pojo.BasicRegistration;
import com.telpo.usb.finger.pojo.BiometricsTaken;
import com.telpo.usb.finger.pojo.FarmRegistrationPojo;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.utils.AndroidUtils;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegPreviewFragment extends DialogFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FragmentRegPreviewBinding binding;
    BasicRegistration basicRegistration;
    ActivityInfoPojo activityInfoPojo;
    FarmRegistrationPojo farmRegistrationPojo;
    BiometricsTaken biometricsTaken;
    Gson gson;
    boolean household, checked;
    String currentfarmerid;
    String farmerid, uniqueuid, jsonstring;


    public RegPreviewFragment() {
    }

    public static RegPreviewFragment newInstance(String param1, boolean household) {
        RegPreviewFragment fragment = new RegPreviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putBoolean(ARG_PARAM2, household);
        fragment.setArguments(args);
        return fragment;
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, Uri imagepath) {
        Glide.with(imageView.getContext())
                .load(new File(imagepath.getPath())) // Uri of the picture
                .into(imageView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reg_preview, container,
                false);
        View view = binding.getRoot();

        if (getArguments() != null) {
            currentfarmerid = getArguments().getString(ARG_PARAM1);
            household = getArguments().getBoolean(ARG_PARAM2);
        }

        if (household) {
            binding.relact.setVisibility(View.GONE);
            binding.reltable.setVisibility(View.GONE);
        }

        binding.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    onSave();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    RegPreviewFragment.this.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        getDialog().setTitle("Registration Preview");
        try {
            basicRegistration = new BasicRegistration();
            String basicinfo = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.BASICINFOPREF, "");
            basicRegistration = new Gson().fromJson(basicinfo, BasicRegistration.class);
            binding.setBasicreg(basicRegistration);

            if (!household) {
                activityInfoPojo = new ActivityInfoPojo();
                String activityinfo = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.ACTIVITYINFOPREF, "");
                activityInfoPojo = new Gson().fromJson(activityinfo, ActivityInfoPojo.class);
                binding.setActivity(activityInfoPojo);
            }


            farmRegistrationPojo = new FarmRegistrationPojo();
            String farminfo = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.FARMREGPREF, "");
            farmRegistrationPojo = new Gson().fromJson(farminfo, FarmRegistrationPojo.class);
            binding.setFarmreg(farmRegistrationPojo);

            biometricsTaken = new BiometricsTaken();
            String photostring = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.PHOTOPREF, "");
            String sigstring = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.SIGPREF, "");

            AndroidUtils.setImageViewResource(binding.pic, AndroidUtils.base64ToByteArray(photostring));
            AndroidUtils.setImageViewResource(binding.sig, AndroidUtils.base64ToByteArray(sigstring));

            binding.setBio(biometricsTaken);
            biometricsTaken.photourl.set(photostring);
            biometricsTaken.signatureurl.set(sigstring);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public void onSave() {
        generatefarmerid();
        new BackgroundFileTask().execute();
//        checkDuplicateOnServer(farmerid, uniqueuid);

//        SugarTransactionHelper.doInTransaction(new SugarTransactionHelper.Callback() {
//            @Override
//            public void manipulateInTransaction() {
//                //saveFarmerInfo().save();
//            }
//        });
    }

    public void generatefarmerid() {
        String rc = getRegionCode(basicRegistration.region.get()).toUpperCase();
        String dc = getDistrictCode(basicRegistration.district.get(), rc).toUpperCase();
        String timestamp = String.valueOf(System.currentTimeMillis());
        farmerid = "UCL-" +
                basicRegistration.firstname.get().toUpperCase().charAt(0) +
                basicRegistration.surname.get().toUpperCase().charAt(0) + "-" +
                timestamp.substring(0, 3) + "-" +
                timestamp.substring(3, 7) + "-" +
                timestamp.substring(7, 11) + "-" +
                timestamp.substring(11) + "-" +
                rc + "-" +
                dc;
        Log.d("FARMERID", timestamp);
        Log.d("FARMERID", farmerid);

        uniqueuid = AndroidUtils.getUUID();
    }

    //method to convert pojos to json
    public String convertPojoToJson() {
        try {
            ServerTransfer transfer = new ServerTransfer();
            String agentid = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTID, "");
            String agentname = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTNAME, "");
            transfer.setFarmers(saveFarmerInfo(farmerid, agentname, agentid, uniqueuid));
            if (household) {
                transfer.setHousehold(saveHousehold(currentfarmerid, farmerid, agentname, agentid));
            } else {
                transfer.setActivityInfo(saveActivityInfo(farmerid, agentname, agentid));
            }
            transfer.setUserbiometrics(saveUserbiometrics(farmerid, agentname, agentid));
            transfer.setFarmeridcard(saveFarmeridcard(farmerid, agentname, agentid));
            transfer.setFingerlist(saveUserfingerprints(farmerid, agentname, agentid));
            transfer.setSupportdocs(saveSupportDocs(farmerid, agentname, agentid));
            String jsonstring = new Gson().toJson(transfer);
            return jsonstring;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

//    private void checkDuplicateOnServer(String mFarmerid, String mUniqueuid) {
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, AndroidUtils.CHECK_DUPLICATE_URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.e("Volley Response", "" + response);
//                if (response.equals("\"not duplicate\"")) {
//                    checked = true;
//                    jsonstring = convertPojoToJson();
//                    new BackgroundFileTask().execute();
//                } else if (response.equals("\"duplicate\"")) {
//                    checked = false;
//                    generatefarmerid();
//                    checkDuplicateOnServer(farmerid, uniqueuid);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> postMap = new HashMap<>();
//                postMap.put("farmerid", mFarmerid);
//                postMap.put("uniqueuid", mUniqueuid);
//                return postMap;
//            }
//        };
//
//        Volley.newRequestQueue(getContext()).add(stringRequest);
//    }

    public void loadProfilePage(String farmerid) {
        Intent intent = new Intent(getContext(), ProfileActivity.class);
        intent.putExtra("farmerid", farmerid);
        getContext().startActivity(intent);
//        finish();
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

    public Farmers saveFarmerInfo(String farmerid, String agentname, String agentid, String uniqueuid) {
        Farmers farmers = new Farmers();
        farmers.farmerid = farmerid;
        farmers.surname = basicRegistration.surname.get();
        farmers.othername = basicRegistration.firstname.get();
        farmers.placeofbirth = basicRegistration.placeofbirth.get();
        farmers.dateofbirth = AndroidUtils.dateStringToDate(basicRegistration.dateofbirth.get());
        farmers.age = Integer.valueOf(basicRegistration.age.get());
        farmers.gender = basicRegistration.gender.get();
        farmers.hometown = basicRegistration.hometown.get();
        farmers.address = basicRegistration.residentialaddr.get();
        farmers.district = basicRegistration.district.get();
        farmers.region = basicRegistration.region.get();
        farmers.country = basicRegistration.nationality.get();
        farmers.idcardtype = basicRegistration.idtype.get();
        farmers.idcardno = basicRegistration.idnumber.get();
        farmers.community = basicRegistration.farmcommunity.get();
        farmers.levelofeducation = basicRegistration.levelofeducation.get();
        farmers.religion = basicRegistration.religion.get();
        farmers.maritalstatus = basicRegistration.maritalstatus.get();
        farmers.email = basicRegistration.email.get();
        farmers.levelofeducation = basicRegistration.levelofeducation.get();
        farmers.postbox = basicRegistration.postofficebox.get();
        farmers.religion = basicRegistration.religion.get();
        farmers.tel = basicRegistration.telephone.get();
        farmers.macaddress = AndroidUtils.getMacAddress(getContext());
        farmers.imei = AndroidUtils.getIMEI(getContext());
        farmers.uniqueuid = uniqueuid;
        farmers.agentname = agentname;
        farmers.agentid = agentid;
        farmers.save();
        return farmers;
    }

    public ActivityInfo saveActivityInfo(String farmerid, String agentname, String agentid) {
        ActivityInfo info = new ActivityInfo();
        info.farmerid = farmerid;
        info.groupname = activityInfoPojo.groupname.get();
        info.boolgroupname = activityInfoPojo.boolgroupmember.get();
        info.coopname = activityInfoPojo.coopname.get();
        info.boolcoopname = activityInfoPojo.boolcoopmember.get();
        info.incomesource = activityInfoPojo.incomesource.get();
        info.boolincomesource = activityInfoPojo.boolcocoaincome.get();
        info.specialtycocoa = activityInfoPojo.specialtycocoa.get();
        info.boolspecialtycocoa = activityInfoPojo.boolspecialty.get();
        info.certified = activityInfoPojo.certified.get();
        info.boolcertified = activityInfoPojo.boolcertified.get();
        info.fundingsource = activityInfoPojo.fundingsource.get();
        info.macaddress = AndroidUtils.getMacAddress(getContext());
        info.imei = AndroidUtils.getIMEI(getContext());
        info.uniqueuid = uniqueuid;
        info.agentname = agentname;
        info.agentid = agentid;
        info.save();
        return info;
    }

    public Farms saveFarms(String farmerid, String farmid) {
        Farms farms = new Farms();
        farms.farmid = farmid;
        farms.farmerid = farmerid;
        farms.location = farmRegistrationPojo.location.get();
        farms.district = farmRegistrationPojo.district.get();
        farms.region = farmRegistrationPojo.region.get();
        farms.community = farmRegistrationPojo.community.get();
        farms.yearofestablishment = farmRegistrationPojo.establishedyear.get();
        farms.totalarea = farmRegistrationPojo.landarea.get();
        farms.cultivatedarea = farmRegistrationPojo.cultarea.get();
        farms.shadetrees = farmRegistrationPojo.shadetreeno.get();
        farms.ownership = farmRegistrationPojo.sourceofownership.get();
        farms.typeoffarm = farmRegistrationPojo.typeoffarm.get();
        farms.plantingmaterial = farmRegistrationPojo.plantmaterialsrc.get();
        farms.othersource = farmRegistrationPojo.otherplantmatsrc.get();
        farms.labour = farmRegistrationPojo.laboursource.get();
        farms.extension = farmRegistrationPojo.extensionorg.get();
        farms.organisation = farmRegistrationPojo.privateextentionorg.get();
        farms.activities = farmRegistrationPojo.agroactivity.get();
        farms.uniqueuid = uniqueuid;
        //farms.farmimage = farmRegistrationPojo.farmimage;
        //farms.geocord = farmRegistrationPojo.geocord;
        //farms.long_ = farmRegistrationPojo.long_;
        farms.save();
        return farms;
    }

    public Userbiometrics saveUserbiometrics(String farmerid, String agentname, String agentid) throws IOException {
        Userbiometrics bio = new Userbiometrics();
        bio.farmerid = farmerid;
        bio.picture = AndroidUtils.base64ToByteArray(biometricsTaken.photourl.get());
        bio.signature = AndroidUtils.base64ToByteArray(biometricsTaken.signatureurl.get());
        bio.createdDate = new Date();
        bio.placeOfRegistered = "";
        bio.macaddress = AndroidUtils.getMacAddress(getContext());
        bio.imei = AndroidUtils.getIMEI(getContext());
        bio.uniqueuid = uniqueuid;
        bio.agentname = agentname;
        bio.agentid = agentid;
        bio.save();
        return bio;
    }

    public List<SupportDocs> saveSupportDocs(String farmerid, String agentname, String agentid) {
        String docsjson = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.DOCREF, "");
        System.out.println("Doc : " + docsjson);
        List<SupportDocs> docsList = AndroidUtils.getGsonList(docsjson, SupportDocs.class);

        try {
            if (!docsList.isEmpty()) {
                for (SupportDocs docs : docsList) {
                    docs.setFarmerid(farmerid);
                    docs.macaddress = AndroidUtils.getMacAddress(getContext());
                    docs.imei = AndroidUtils.getIMEI(getContext());
                    docs.uniqueuid = uniqueuid;
                    docs.agentname = agentname;
                    docs.agentid = agentid;
                    SugarRecord.save(docs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docsList;
    }

    public List<Userfingerprint> saveUserfingerprints(String farmerid, String agentname, String agentid) {
        String fingerjson = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.FINGERREF, "");
        List<Userfingerprint> userfingerprints = AndroidUtils.getGsonList(fingerjson,
                Userfingerprint.class);

        try {
            if (!userfingerprints.isEmpty()) {
                for (Userfingerprint finger : userfingerprints) {
                    finger.setFarmerid(farmerid);
                    finger.macaddress = AndroidUtils.getMacAddress(getContext());
                    finger.imei = AndroidUtils.getIMEI(getContext());
                    finger.uniqueuid = uniqueuid;
                    finger.agentname = agentname;
                    finger.agentid = agentid;
                    finger.save();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userfingerprints;
    }

    public Farmeridcard saveFarmeridcard(String farmerid, String agentname, String agentid) {
        Farmeridcard fid = new Farmeridcard();
        fid.farmerid = farmerid;
        fid.idtype = basicRegistration.idtype.get();
        fid.idnumber = basicRegistration.idnumber.get();
        fid.idimage = null;
        fid.datecreated = new Date();
        fid.uniqueuid = uniqueuid;
        fid.macaddress = AndroidUtils.getMacAddress(getContext());
        fid.imei = AndroidUtils.getIMEI(getContext());
        fid.agentname = agentname;
        fid.agentid = agentid;
        fid.save();
        return fid;
    }

    public LocationCoordinates saveLocationCoordinates(String farmerid, String farmid) {
        LocationCoordinates loc = new LocationCoordinates();
        loc.farmerid = farmerid;
        loc.farmid = farmid;
        loc.latitude = "";
        loc.longitude = "";
        loc.jsoncoord = "";
        loc.area = 0.0;
        loc.datecreated = new Date();
        loc.uniqueuid = uniqueuid;
        return loc;
    }

    //method to save relationship information
    public Household saveHousehold(String farmerid, String householdid, String agentname, String agentid) {
        Household household = new Household();
        household.farmerid = farmerid;
        household.householdid = householdid;
        household.relationship = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.RELATEPREF, "");
        household.syncstatus = "0";
        household.datecreated = new Date();
        household.macaddress = AndroidUtils.getMacAddress(getContext());
        household.imei = AndroidUtils.getIMEI(getContext());
        household.uniqueuid = uniqueuid;
        household.agentname = agentname;
        household.agentid = agentid;
        household.save();
        return household;
    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
        }
    }

    private class BackgroundFileTask extends AsyncTask<String, Void, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Saving please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... filepath) {
            try {


                jsonstring = convertPojoToJson();
                String uploadId = AndroidUtils.getUUID();
                String uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
//                try {
//                    if (checked)
//                        AndroidUtils.uploadFileToServer(getContext());
//                } catch (Exception exc) {
//                    Toast.makeText(getContext(), exc.getMessage(), Toast.LENGTH_SHORT).show();
//                }

                if (!jsonstring.equalsIgnoreCase("error")) {
                    return "done";
                } else {
                    return "error";
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            if (result.equalsIgnoreCase("done")) {
                Toasty.success(getContext(), "Registration Saved Successfully").show();


                if (household) {
                    Intent intent = new Intent(getActivity(), ProfileActivity.class);
                    intent.putExtra("farmerid", currentfarmerid);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    getActivity().startActivity(intent);
                } else {
                    loadProfilePage(farmerid);
                }

                getActivity().finish();
//                new BackgroundUploader(AndroidUtils.getPreferenceData(getActivity(), AndroidUtils
//                        .IPCOMPLETEPREF, "http://10.0.0.6:8080/fprintverification/fingerprint"),
//                        jsonstring).execute();
            }
        }
    }

    class BackgroundUploader extends AsyncTask<String, Integer, String> implements DialogInterface.OnCancelListener {
        private ProgressDialog progressDialog;
        private String url;
        private File file;
        private String pstring;


        public BackgroundUploader(String url, String pstring) {
            this.url = url;
            //this.file = file;
            this.pstring = pstring;
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMessage("Uploading File...");
            progressDialog.setCancelable(false);
            progressDialog.setMax(pstring.length());
            progressDialog.show();
        }

        protected String doInBackground(String... v) {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection connection = null;
            String fileName = "Data.gz";
            StringBuilder builder = new StringBuilder();
            try {
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("POST");
                String boundary = "---------------------------boundary";
                String tail = "\r\n--" + boundary + "--\r\n";
                connection.setRequestProperty("Content-Type",
                        "multipart/form-data; boundary=" + boundary);
                connection.setDoOutput(true);

                String metadataPart = "--"
                        + boundary
                        + "\r\n"
                        + "Content-Disposition: form-data; name=\"metadata\"\r\n\r\n"
                        + "" + "\r\n";

                String fileHeader1 = "--"
                        + boundary
                        + "\r\n"
                        + "Content-Disposition: form-data; name=\"uploadfile\"; filename=\""
                        + fileName + "\"\r\n"
                        + "Content-Type: application/octet-stream\r\n"
                        + "Content-Transfer-Encoding: binary\r\n";

                long fileLength = pstring.length() + tail.length();
                String fileHeader2 = "Content-length: " + fileLength + "\r\n";
                String fileHeader = fileHeader1 + fileHeader2 + "\r\n";
                String stringData = metadataPart + fileHeader;

                long requestLength = stringData.length() + fileLength;
                connection.setRequestProperty("Content-length", "" + requestLength);
                connection.setFixedLengthStreamingMode((int) requestLength);
                connection.connect();

                DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                out.writeBytes(stringData);
                out.flush();

                int progress = 0;
                int bytesRead = 0;
                byte buf[] = new byte[1024];
                BufferedInputStream bufInput = new BufferedInputStream(IOUtils.toInputStream
                        (pstring));
                while ((bytesRead = bufInput.read(buf)) != -1) {
                    // write output
                    out.write(buf, 0, bytesRead);
                    out.flush();
                    progress += bytesRead;
                    // update progress bar
                    publishProgress(progress);
                }
                // Write closing boundary and close stream
                out.writeBytes(tail);
                out.flush();
                out.close();

                // Get server response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection
                        .getInputStream()));
                String line = "";

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

            } catch (Exception e) {
                // Exception
            } finally {
                if (connection != null)
                    connection.disconnect();
            }
            return builder.toString();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            progressDialog.setProgress((progress[0]));
        }

        @Override
        protected void onPostExecute(String v) {
            progressDialog.dismiss();
            Toast.makeText(getContext(), "Message from server: " + v, Toast.LENGTH_LONG).show();
            if (household) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                intent.putExtra("farmerid", currentfarmerid);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                getActivity().startActivity(intent);
            } else {
                loadProfilePage(farmerid);
            }

            getActivity().finish();
//            if(v.equalsIgnoreCase("success"))
//            {
//                loadProfilePage(farmerid);
//                getActivity().finish();
//            }
        }

        @Override
        public void onCancel(DialogInterface dialog) {
            cancel(true);
            dialog.dismiss();
        }
    }
}
