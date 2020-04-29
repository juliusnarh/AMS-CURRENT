package com.telpo.usb.finger.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.entire.sammalik.samlocationandgeocoding.AddressPojo;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.ActivityInfo;
import com.telpo.usb.finger.entities.Debtor;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.FarmAssessment;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Farms;
import com.telpo.usb.finger.entities.InputTransaction;
import com.telpo.usb.finger.entities.LocationCoordinates;
import com.telpo.usb.finger.entities.OrderCart;
import com.telpo.usb.finger.entities.Products;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.entities.ServiceProviders;
import com.telpo.usb.finger.entities.SupportDocs;
import com.telpo.usb.finger.entities.Userbiometrics;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.NetworkInterface;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//import com.entire.sammalik.samlocationandgeocoding.AddressPojo;

/**
 * Created by Junior on 11/24/2017.
 */

public class AndroidUtils {
    public static final String Digits = "(\\p{Digit}+)";
    public static final String HexDigits = "(\\p{XDigit}+)";
    public static final String Exp = "[eE][+-]?" + Digits;
    public static final String fpRegex =
            (
                    "[\\x00-\\x20]*" + "[+-]?(" + "NaN|" + "Infinity|" + "(((" + Digits + "(\\.)?(" + Digits + "?)(" + Exp + ")?)|" + "(\\.(" + Digits + ")(" + Exp + ")?)|" +
                            "((" + "(0[xX]" + HexDigits + "(\\.)?)|" + "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" + ")[pP][+-]?" + Digits + "))" + "[fFdD]?))" + "[\\x00-\\x20]*"
            );
    public static final String mypreference = "farmer_registration";
    public static final String CONTRACTPREF = "contract_pref";
    public static final String CONTRACTPREFTEMP = "contract_pref_temp";
    public static final String WEEDICIDE = "WD";
    public static final String COUPOUNORDERID = "CC";
    public static final String CONTRACTID = "CN";
    public static final String INPUTSALESID = "IN";
    public static final String SERVICETRANSID = "SV";
    public static final String PESTICIDE = "PD";
    public static final String FERTILIZER = "FT";
    public static final String INSECTICIDE = "SE";
    public static final String SEED = "SD";
    public static final String FUGAR = "FG";
    public static final String HERBICIDE = "HB";
    public static final String SERVICES = "SV";
    public static final String RECOVERY = "RC";
    public static final String PURCHASE = "PC";
    public static final String MECHANICALTOOL = "MT";
    public static final String BASICINFOPREF = "basicpref";
    public static final String ACTIVITYINFOPREF = "activitypref";
    public static final String FARMREGPREF = "farmregpref";
    public static final String PHOTOPREF = "photopref";
    public static final String SIGPREF = "sigpref";
    public static final String AGENTID = "agentid";
    public static final String AGENTNAME = "agentname";
    public static final String PASSWORD = "password";
    public static final String DOCREF = "docref";
    public static final String FINGERREF = "fingerref";
    public static final String IPPREF = "ipaddress";
    public static final String PORT = "port";
    public static final String SCALEIP = "ip";
    public static final String SCALEPORT = "port";
    public static final String PROTOCOLPREF = "protocol";
    public static final String ENDPOINTPREF = "endpoint";
    public static final String IPCOMPLETEPREF = "ipcomplete";
    public static final String RELATEPREF = "relationpref";
    public static final String FAFFARMERID_PREF = "faffarmerid";
    public static final String FAFCROPINFO_PREF = "fafcropinfo";
    public static final String FAFCROPPROT_PREF = "fafcropprot";
    public static final String FAFCOMMENT_PREF = "fafcomment";
    public static final String FAFLONG_PREF = "faffarmlong";
    public static final String FAFLAT_PREF = "faffarmlat";
    public static final String SERVER_URL = "http://webservice.uclgroupgh.com:8080/uclservice";
    public static final String SERVER_HOST = "192.168.43.194";
    public static final String CHECK_DUPLICATE_URL = "https://uclgroupgh.com/UCLAMS/main/Registration/farmeridcheck.php";

    public static final int SERVER_PORT = 8080;
    public static final int HOST_MONITOR_INTERVAL_MINS = 15;
    static ProgressDialog progressDialog;
    static SpannableString ss2;
    static OkHttpClient client = new OkHttpClient();
    static List<File> fileList;
    static String uploadid;

    public static void savePreferenceData(Activity activity, String key, String value) {
        SharedPreferences prefs = activity.getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        prefs.edit().putString(key, value).apply();
    }

    public static String getPreferenceData(Context con, String variable, String defaultValue) {
        SharedPreferences prefs = con.getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(con);
        return prefs.getString(variable, defaultValue);
    }

    public static void clearRegistrationPreference(Activity activity) {
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.BASICINFOPREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.ACTIVITYINFOPREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.SIGPREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.PHOTOPREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.FINGERREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.FARMREGPREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.RELATEPREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.DOCREF);
    }

    public static void clearFAFPreference(Activity activity) {
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.FAFFARMERID_PREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.FAFCROPINFO_PREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.FAFCROPPROT_PREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.FAFCOMMENT_PREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.FAFLAT_PREF);
        AndroidUtils.removePreferenceValue(activity, AndroidUtils.FAFLONG_PREF);
    }

    public static void removePreferenceValue(Activity activity, String key) {
        SharedPreferences prefs = activity.getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        prefs.edit().remove(key).apply();
    }

    public static boolean clearPreference(Context con) {
        return con.getSharedPreferences(AndroidUtils.mypreference, Context.MODE_PRIVATE).edit()
                .clear().commit();
    }


    public static String uploadDirectoryPath() {
        return Environment.getExternalStorageDirectory() + File.separator + "uploadfolder";
    }

    public static String downloadDirectoryPath() {
        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "csvdatafolder/serverfiles");
        if (!folder.exists()) {
            folder.mkdirs();
            return folder.getAbsolutePath();
        } else {
            return folder.getAbsolutePath();
        }
    }

    public static String uploadTempDirectoryPath() {
        return Environment.getExternalStorageDirectory() + File.separator + "uploadtempfolder";
    }

    public static String tempSyncFileDirectoryPath() {
        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "ams/tempsyncfolder");
        if (!folder.exists()) {
            folder.mkdirs();
            return folder.getAbsolutePath();
        } else {
            return folder.getAbsolutePath();
        }
    }

    public static String scansam() {
        return Environment.getExternalStorageDirectory() + File.separator + "scanSample";
    }

    public static String scansamplepath() {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "scanSample");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriSting = (file.getAbsolutePath() + "/" + "sample" + System.currentTimeMillis() + ".jpg");
        return uriSting;
    }

    public static String csvDirectoryPath() {
        //return Environment.getExternalStorageDirectory() + File.separator + "csvdatafolder";
        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "csvdatafolder");
        if (!folder.exists()) {
            folder.mkdirs();
            return folder.getAbsolutePath();
        } else {
            return folder.getAbsolutePath();
        }
    }

    public static String backupDirectoryPath() {
        //return Environment.getExternalStorageDirectory() + File.separator + "csvdatafolder";
        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "ams/dbbackup");
        if (!folder.exists()) {
            folder.mkdirs();
            return folder.getAbsolutePath();
        } else {
            return folder.getAbsolutePath();
        }
    }

    public static String cropDirectoryPath() {
        //return Environment.getExternalStorageDirectory() + File.separator + "csvdatafolder";
        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "cropped");
        if (!folder.exists()) {
            folder.mkdirs();
            return folder.getAbsolutePath();
        } else {
            return folder.getAbsolutePath();
        }
    }

    public static byte[] downloadUrl(URL toDownload) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            byte[] chunk = new byte[4096];
            int bytesRead;
            InputStream stream = toDownload.openStream();

            while ((bytesRead = stream.read(chunk)) > 0) {
                outputStream.write(chunk, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return outputStream.toByteArray();
    }

    /**
     * method to upload files to the server
     */
    public static void uploadFileToServer(Context context) {

        File folder = new File(AndroidUtils.uploadDirectoryPath());

        if (!folder.exists()) {
            folder.mkdirs();
            fileList = AndroidUtils.getListOfFiles(folder);
        } else {
            fileList = AndroidUtils.getListOfFiles(folder);
        }
        if (!fileList.isEmpty()) {
            for (File file : fileList) {
                try {
                    uploadid = FilenameUtils.getBaseName(file.getAbsolutePath());
                    //Creating a multi part request
                    new MultipartUploadRequest(context, uploadid, AndroidUtils.getPreferenceData(context, AndroidUtils.IPCOMPLETEPREF, AndroidUtils

                            .SERVER_URL))
                            .addFileToUpload(file.getAbsolutePath(), "file") //Adding file
                            //.addParameter("name", "filename") //Adding text parameter to the
                            // request
                            .setNotificationConfig(new UploadNotificationConfig()
                                            .setTitleForAllStatuses("CMS File Upload")
                                            .setIconForAllStatuses(R.drawable.cocoa)
//                            .setIconColorForAllStatuses(R.drawable.cocoa)
                                            .setIconColorForAllStatuses(R.color.text_color)
                            /*.setLargeIconForAllStatuses(BitmapFactory.decodeResource(context
                            .getResources(), R.drawable.cocoa))*/)
                            //.setMaxRetries(4)
                            .setAutoDeleteFilesAfterSuccessfulUpload(false)
                            .startUpload(); //Starting the upload

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void uploadFileToServerFromTempFolder(Context context) {

        File folder = new File(AndroidUtils.uploadTempDirectoryPath());

        if (!folder.exists()) {
            folder.mkdirs();
            fileList = AndroidUtils.getListOfFiles(folder);
        } else {
            fileList = AndroidUtils.getListOfFiles(folder);
        }
        if (!fileList.isEmpty()) {
            for (File file : fileList) {
                try {
                    uploadid = FilenameUtils.getBaseName(file.getAbsolutePath());
                    //Creating a multi part request
                    new MultipartUploadRequest(context, uploadid, AndroidUtils.getPreferenceData(context, AndroidUtils.IPCOMPLETEPREF, AndroidUtils

                            .SERVER_URL))
                            .addFileToUpload(file.getAbsolutePath(), "file") //Adding file
                            //.addParameter("name", "filename") //Adding text parameter to the
                            // request
                            .setNotificationConfig(new UploadNotificationConfig()
                                            .setTitleForAllStatuses("CMS File Upload")
                                            .setIconForAllStatuses(R.drawable.cocoa)
//                            .setIconColorForAllStatuses(R.drawable.cocoa)
                                            .setIconColorForAllStatuses(R.color.text_color)
                            /*.setLargeIconForAllStatuses(BitmapFactory.decodeResource(context
                            .getResources(), R.drawable.cocoa))*/)
                            //.setMaxRetries(4)
                            .setAutoDeleteFilesAfterSuccessfulUpload(false)
                            .startUpload(); //Starting the upload

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static JSONObject getLocationInfo(double lat, double lng) {
        Response response = null;
        try {
            Request request = new Request.Builder()
                    .url("http://maps.googleapis.com/maps/api/geocode/json?latlng="
                            + lat + "," + lng + "&sensor=true")
                    .build();
            response = client.newCall(request).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = new JSONObject(response.body().string());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return jsonObject;

    }

    public static AddressPojo getCurrentLocationViaJSON(double lat, double lng) {
        AddressPojo addressPojo = new AddressPojo();
        JSONObject jsonObj = getLocationInfo(lat, lng);
        //Log.i("JSON string =>", jsonObj.toString());
        try {
            String status = jsonObj.getString("status");
            Log.i("status", status);

            if (status.equalsIgnoreCase("OK")) {
                JSONArray Results = jsonObj.getJSONArray("results");
                JSONObject zero = Results.getJSONObject(0);
                JSONArray address_components = zero.getJSONArray("address_components");

                for (int i = 0; i < address_components.length(); i++) {
                    JSONObject zero2 = address_components.getJSONObject(i);
                    JSONArray typeObj = (JSONArray) zero2.get("types");
                    if (typeObj.get(0).equals("route")) {
                        addressPojo.setStreetaddress("" + zero2.get("long_name"));
                    } else if (typeObj.get(0).equals("locality")) {
                        addressPojo.setCity("" + zero2.get("long_name"));
                    } else if (typeObj.get(0).equals("administrative_area_level_2")) {
                        addressPojo.setAssembly("" + zero2.get("long_name"));
                    } else if (typeObj.get(0).equals("administrative_area_level_1")) {
                        addressPojo.setRegion("" + zero2.get("long_name"));
                    } else if (typeObj.get(0).equals("country")) {
                        addressPojo.setCountry("" + zero2.get("long_name"));
                    }


//                    String long_name = zero2.getString("long_name");
//                    System.out.println("Assembly: "+long_name);
//                    JSONArray mtypes = zero2.getJSONArray("types");
//                    String Type = mtypes.getString(0);
//
//                    if (Type.equalsIgnoreCase("street_number")) {
//                        Address1 = long_name + " ";
//                    } else if (Type.equalsIgnoreCase("route")) {
//                        Address1 = Address1 + long_name;
//                    } else if (Type.equalsIgnoreCase("sublocality")) {
//                        Address2 = long_name;
//                    } else if (Type.equalsIgnoreCase("locality")) {
//                        // Address2 = Address2 + long_name + ", ";
//                        City = long_name;
//                    } else if (Type
//                            .equalsIgnoreCase("administrative_area_level_2")) {
//                        County = long_name;
//                    } else if (Type
//                            .equalsIgnoreCase("administrative_area_level_1")) {
//                        State = long_name;
//                    } else if (Type.equalsIgnoreCase("country")) {
//                        Country = long_name;
//                    } else if (Type.equalsIgnoreCase("postal_code")) {
//                        PIN = long_name;
//                    }
                }
            }
        } catch (Exception e) {
        }
        return addressPojo;
    }


    /**
     * Convert Bitmap image to byte array
     *
     * @param bitmap
     * @return
     */
    public static byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public static Bitmap byteArrayToBitmap(byte[] data) {
        return BitmapFactory.decodeByteArray(data, 0, data.length);
    }

    public static String rotateimg(Bitmap thePic) {
        Matrix mat = new Matrix();
        mat.postRotate(90);
        thePic = Bitmap.createBitmap(thePic, 0, 0,
                thePic.getWidth(), thePic.getHeight(), mat, true);

        byte[] temp = bitmapToByteArray(thePic);
        return byteArrayToBase64(temp);
    }

    public static String saveImageToDirectory(byte[] data, String filename) {
        boolean result = false;
        String path = "";
        try {
            Bitmap pic = byteArrayToBitmap(data);
            File photo = new File(getAlbumStorageDir("ucl"), filename + ".jpg"  /*String.format
             (filename+"_%d.jpg", System.currentTimeMillis())*/);
            saveBitmapToJPG(pic, photo);
            //scanMediaFile(photo);
            path = photo.getAbsolutePath();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static String saveImageToDirectory(Bitmap pic, String filename) {
        boolean result = false;
        String path = "";
        try {
            File photo = new File(getAlbumStorageDir("ucl"), String.format(filename + "_%d.jpg",
                    System.currentTimeMillis()));
            saveBitmapToJPG(pic, photo);
            //scanMediaFile(photo);
            path = photo.getAbsolutePath();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment
                .DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("ucl", "Directory not created");
        }
        return file;
    }

    public static void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap
                .Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap, 0, 0, null);
        OutputStream stream = new FileOutputStream(photo);
        newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
        stream.close();
    }

//    Uri contentUri;
//    private void scanMediaFile(File photo) {
//        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//        contentUri = Uri.fromFile(photo);
//        mediaScanIntent.setData(contentUri);
//        this.sendBroadcast(mediaScanIntent);
//    }

    public static String byteArrayToBase64(byte[] barray) {
        return Base64.encodeToString(barray, Base64.DEFAULT);
    }

    public static byte[] base64ToByteArray(String base64string) {
        if (base64string != null){
            if (!base64string.isEmpty())
                return Base64.decode(base64string.getBytes(), Base64.DEFAULT);
        }
        return null;
    }

    /**
     * method to find the center of a polygon
     *
     * @param points
     * @return
     */
    public static double[] centroid(List<LatLng> points) {
        double[] centroid = {0.0, 0.0};

        for (int i = 0; i < points.size(); i++) {
            centroid[0] += points.get(i).latitude;
            centroid[1] += points.get(i).longitude;
        }

        int totalPoints = points.size();
        centroid[0] = centroid[0] / totalPoints;
        centroid[1] = centroid[1] / totalPoints;

        return centroid;
    }

    /**
     * method to calculate center of polygon
     *
     * @param polygonPointsList
     * @return
     */
    public static LatLng getPolygonCenterPoint(List<LatLng> polygonPointsList) {
        LatLng centerLatLng = null;
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (int i = 0; i < polygonPointsList.size(); i++) {
            builder.include(polygonPointsList.get(i));
        }
        LatLngBounds bounds = builder.build();
        centerLatLng = bounds.getCenter();

        return centerLatLng;
    }

    public static <T> List<T> getGsonList(String json, Class<T> typeClass) {
        return new Gson().fromJson(json, new ListOfGson<T>(typeClass));
    }

    /**
     * method to set image in imageview
     *
     * @param imageView
     * @param imagebyte
     */
    public static void setImageViewResource(ImageView imageView, byte[] imagebyte) {

        Glide.with(imageView.getContext())
                .asBitmap()
                .load(imagebyte)
                .into(imageView);
    }

    /**
     * method to convert drawable to bitmap
     */
    public static Bitmap drawableToBitmap(int drawable, Context context) {
        return BitmapFactory.decodeResource(context.getResources(), drawable);
    }

    /**
     * method to convert drawable to bitmap
     */
    public static Drawable arraytodrawable(byte[] imgbyte, Context context) {
        try {
            return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray(imgbyte, 0, imgbyte.length));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param imageView
     * @param imagename
     */
    public static void setImageViewResourceDrawable(ImageView imageView, String imagename) {
        Glide.with(imageView.getContext())
                .load(imageView.getContext().getResources().getDrawable(getGlideImage(imagename,
                        imageView.getContext()))) // Uri of the picture
                .into(imageView);
    }

    public static int getGlideImage(String imagename, Context context) {
        return context.getResources().getIdentifier(imagename, "drawable", context.getPackageName
                ());
    }

    /**
     * Convert Image URI to byte[]
     *
     * @param uri
     */
    public static byte[] uriToByteArray(Uri uri, Context context) {
        // this is storage overwritten on each iteration with bytes
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        ByteArrayOutputStream byteBuffer = null;
        // we need to know how may bytes were read to write them to the byteBuffer
        int len = 0;
        try {
            // this dynamically extends to take the bytes you read
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            byteBuffer = new ByteArrayOutputStream();

            while ((len = inputStream.read(buffer)) != -1) {
                byteBuffer.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // and then we can return your byte array.


        return byteBuffer.toByteArray();
    }

    /**
     * Generate uniqueuid random number
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * Convert date string into java.util.Date
     */
    public static Date dateStringToDate(String datestring) {
        Date date = null;
        try {
            date = new SimpleDateFormat("dd-MMM-yyyy").parse(datestring);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        return date;
    }

    public static Date dateStringToDate(String datestring, String pattern) {
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(datestring);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        return date;
    }

    public static String dateToFormattedString(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String datestring = "";
        try {
            datestring = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datestring;
    }

    public static String dateToFormattedStringmonth(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        String datestring = "";
        try {
            datestring = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datestring;
    }

    public static int dateToStringFormat(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        int datestring = 0;
        try {
            datestring = Integer.parseInt(formatter.format(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datestring;
    }

    public static int datetoage(Date date) {
        Calendar cal = new GregorianCalendar(dateToStringFormat(date, "yyyy"), dateToStringFormat(date, "MM"), dateToStringFormat(date, "dd"));
        Calendar now = new GregorianCalendar();
        int res = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        if ((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH)) || (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH)
                && cal.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH))) {
            res--;
        }
        return res;
    }

    public static String formatedItems(StringBuilder orderDetails, StringBuilder totalQuantity, Resources res) {

        StringBuilder newOrderDetails = new StringBuilder();
        String itemsPurchased = orderDetails.toString();
        String quantity = totalQuantity.toString();

        if (!itemsPurchased.isEmpty()) {
            if (itemsPurchased.contains(",")) {
                String[] partsItems = itemsPurchased.split(",");
                String[] partsQuantity = quantity.split(",");

                for (int i = 0; i < partsItems.length; i++) {
                    if (!partsItems[i].contains("~")) {
                        String temp = res.getString(R.string.actual_order_detail, partsItems[i], partsQuantity[i]);
                        newOrderDetails.append(temp);
                        newOrderDetails.append(",");
                    }
                }
            } else {
                if (!itemsPurchased.contains("~")) {
                    String temp = res.getString(R.string.actual_order_detail, itemsPurchased, quantity);
                    newOrderDetails.append(temp);
                } else {
                    String[] partsItems = itemsPurchased.split("~");
                    String[] partsQuantity = quantity.split("~");
                    if (partsItems.length > 0) {

                        String temp = res.getString(R.string.actual_order_detail, partsItems[0], partsQuantity[0]);
                        newOrderDetails.append(temp);
                    }
                }
            }
        }
        return newOrderDetails.toString();
    }


    public static void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.cancel();
            progressDialog.dismiss();
        }
    }

    public static void showProgressDialog(Context c, String msg) {
        progressDialog = new ProgressDialog(c);
        progressDialog.isIndeterminate();
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor
                ("#FFFFFF")));
        progressDialog.setIndeterminate(true);
        ss2 = new SpannableString(msg);
        ss2.setSpan(new RelativeSizeSpan(1.1f), 0, ss2.length(), 0);
        ss2.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, ss2.length(), 0);
        progressDialog.setMessage(ss2);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    public static int age(int y, int m, int d) {
        Calendar cal = new GregorianCalendar(y, m, d);
        Calendar now = new GregorianCalendar();
        int res = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        if ((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
                || (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH)
                && cal.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH))) {
            res--;
        }
        return res;
    }


    /**
     * method to get list of files
     *
     * @param parentDir
     * @return
     */
    public static List<File> getListOfFiles(File parentDir) {

        List<File> inFiles = new ArrayList<>();
        Queue<File> files = new LinkedList<>();

        files.addAll(Arrays.asList(parentDir.listFiles()));
        while (!files.isEmpty()) {
            File file = files.remove();
            if (file.isDirectory()) {
                files.addAll(Arrays.asList(file.listFiles()));
            } else if (file.getName().endsWith(".txt")) {
                inFiles.add(file);
            }
        }
        return inFiles;
    }

    public static List<File> getListOfCSVFiles(File parentDir) {
        List<File> inFiles = new ArrayList<>();
        Queue<File> files = new LinkedList<>();
        files.addAll(Arrays.asList(parentDir.listFiles()));
        while (!files.isEmpty()) {
            File file = files.remove();
            if (file.isDirectory()) {
                files.addAll(Arrays.asList(file.listFiles()));
            } else if (file.getName().endsWith(".csv")) {
                inFiles.add(file);
            }
        }
        return inFiles;
    }

    public static List<File> getListOfJsonFiles(File parentDir) {
        List<File> inFiles = new ArrayList<>();
        Queue<File> files = new LinkedList<>();
        files.addAll(Arrays.asList(parentDir.listFiles()));
        while (!files.isEmpty()) {
            File file = files.remove(); 
            if (file.isDirectory()) {
                files.addAll(Arrays.asList(file.listFiles()));
            } else if (file.getName().endsWith(".json")) {
                inFiles.add(file);
            }
        }
        return inFiles;
    }

    public static String writeToFile(String data, String filename) {
        String dirpath = Environment.getExternalStorageDirectory() + File.separator +
                "uploadfolder";
        final File dir = new File(dirpath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        final File file = new File(dir, filename);

        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.append(data);

            osw.close();
            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        return file.getAbsolutePath();
    }

    public static String writeToFileUploadTemp(String data, String filename) {
        String dirpath = Environment.getExternalStorageDirectory() + File.separator +
                "uploadtempfolder";
        final File dir = new File(dirpath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        final File file = new File(dir, filename);

        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.append(data);

            osw.close();
            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        return file.getAbsolutePath();
    }

    public static String writeToBackuppath(String data, String filename) {
        String dirpath = Environment.getExternalStorageDirectory() + File.separator +
                "ams/dbbackup";
        final File dir = new File(dirpath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        final File file = new File(dir, filename);

        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.append(data);

            osw.close();
            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        return file.getAbsolutePath();
    }

    public static String writeToscalelog(String data, String filename) {
        String dirpath = Environment.getExternalStorageDirectory() + File.separator +
                "ams/scalelogs";
        final File dir = new File(dirpath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        final File file = new File(dir, filename);

        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.append(data);

            osw.close();
            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        return file.getAbsolutePath();
    }

    public static String readfromscalelog(String filename, Context context) {
        String dirpath = Environment.getExternalStorageDirectory() + File.separator +
                "ams/scalelogs";

//        File folder = new File(dirpath);
//        Queue<File> files = new LinkedList<>();
//        files.addAll(Arrays.asList(new File(folder.getAbsolutePath())));
//
//        while (!files.isEmpty()) {
//            File file = files.remove();
//            if (file.isDirectory()) {
//                files.addAll(Arrays.asList(file.listFiles()));
//            } else if (file.getName().equalsIgnoreCase(filename) ) {
//            }

        StringBuilder builder = new StringBuilder();


        FileInputStream fis;
        try {
            fis = context.openFileInput(filename);
            InputStreamReader reader = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String s = bufferedReader.readLine();
            while (s != null) {
                builder.append(s);
                s = bufferedReader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return builder.toString();
    }

    @SuppressLint("MissingPermission")
    public static String getIMEI(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getMacAddress(Context context) {

        BufferedReader in = null;
        String macAddress = null;
        WifiManager wifiManager = null;
        WifiInfo wifiInfo = null;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                Process process = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address");
//                in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//                macAddress = in.readLine();
//                return macAddress;

                try {
                    List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
                    for (NetworkInterface nif : all) {
                        if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                        byte[] macBytes = nif.getHardwareAddress();
                        if (macBytes == null) {
                            return "";
                        }

                        StringBuilder res1 = new StringBuilder();
                        for (byte b : macBytes) {
                            res1.append(Integer.toHexString(b & 0xFF) + ":");
                        }

                        if (res1.length() > 0) {
                            res1.deleteCharAt(res1.length() - 1);
                        }
                        return res1.toString();
                    }
                } catch (Exception ex) {
                }
                return "02:00:00:00:00:00";

            } else {
                wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                wifiInfo = wifiManager.getConnectionInfo();
                macAddress = wifiInfo.getMacAddress();
                return macAddress;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    /**
     * method to request for permissions
     *
     * @param activity
     */
    public static void checkPermissions(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Dexter.withActivity(activity)
                    .withPermissions(
                            Manifest.permission.CAMERA,
                            Manifest.permission.READ_CONTACTS,
                            Manifest.permission.RECORD_AUDIO,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.INTERNET,
                            Manifest.permission.ACCESS_NETWORK_STATE,
                            Manifest.permission.ACCESS_WIFI_STATE,
                            Manifest.permission.CHANGE_WIFI_STATE,
                            Manifest.permission.RECEIVE_BOOT_COMPLETED,
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.SEND_SMS,
                            Manifest.permission.RECEIVE_SMS,
                            Manifest.permission.READ_SMS,
                            Manifest.permission.WAKE_LOCK,
                            Manifest.permission.FOREGROUND_SERVICE

                    ).withListener(new MultiplePermissionsListener() {
                @Override
                public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}

                @Override
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
            }).check();
        } else {
            Dexter.withActivity(activity)
                    .withPermissions(
                            Manifest.permission.CAMERA,
                            Manifest.permission.READ_CONTACTS,
                            Manifest.permission.RECORD_AUDIO,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.INTERNET,
                            Manifest.permission.ACCESS_NETWORK_STATE,
                            Manifest.permission.ACCESS_WIFI_STATE,
                            Manifest.permission.CHANGE_WIFI_STATE,
                            Manifest.permission.RECEIVE_BOOT_COMPLETED,
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.SEND_SMS,
                            Manifest.permission.RECEIVE_SMS,
                            Manifest.permission.READ_SMS,
                            Manifest.permission.WAKE_LOCK

                    ).withListener(new MultiplePermissionsListener() {
                @Override
                public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}

                @Override
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
            }).check();
        }
    }

    public static void hideKeyboard(Activity ctx) {
        try {
            InputMethodManager inputManager = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(ctx.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception ex) {
        }

    }

    public static Uri compressImage(Uri imageUri, Context context) {

        String filePath = getRealPathFromURI(imageUri, context);
        Bitmap scaledBitmap = null;

        BitmapFactory.Options options = new BitmapFactory.Options();

//      by setting this field as true, the actual bitmap pixels are not loaded in the memory. Just the bounds are loaded. If
//      you try the use the bitmap here, you will get null.
        options.inJustDecodeBounds = true;
        Bitmap bmp = BitmapFactory.decodeFile(filePath, options);

        int actualHeight = options.outHeight;
        int actualWidth = options.outWidth;

//      max Height and width values of the compressed image is taken as 816x612

        float maxHeight = 816.0f;
        float maxWidth = 612.0f;
        float imgRatio = actualWidth / actualHeight;
        float maxRatio = maxWidth / maxHeight;

//      width and height values are set maintaining the aspect ratio of the image

        if (actualHeight > maxHeight || actualWidth > maxWidth) {
            if (imgRatio < maxRatio) {
                imgRatio = maxHeight / actualHeight;
                actualWidth = (int) (imgRatio * actualWidth);
                actualHeight = (int) maxHeight;
            } else if (imgRatio > maxRatio) {
                imgRatio = maxWidth / actualWidth;
                actualHeight = (int) (imgRatio * actualHeight);
                actualWidth = (int) maxWidth;
            } else {
                actualHeight = (int) maxHeight;
                actualWidth = (int) maxWidth;

            }
        }

//      setting inSampleSize value allows to load a scaled down version of the original image

        options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight);

//      inJustDecodeBounds set to false to load the actual bitmap
        options.inJustDecodeBounds = false;

//      this options allow android to claim the bitmap memory if it runs low on memory
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16 * 1024];

        try {
//          load the bitmap from its path
            bmp = BitmapFactory.decodeFile(filePath, options);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();

        }
        try {
            scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }

        float ratioX = actualWidth / (float) options.outWidth;
        float ratioY = actualHeight / (float) options.outHeight;
        float middleX = actualWidth / 2.0f;
        float middleY = actualHeight / 2.0f;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

//      check the rotation of the image and display it properly
        ExifInterface exif;
        try {
            exif = new ExifInterface(filePath);

            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 0);
            Log.d("EXIF", "Exif: " + orientation);
            Matrix matrix = new Matrix();
            if (orientation == 6) {
                matrix.postRotate(90);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 3) {
                matrix.postRotate(180);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 8) {
                matrix.postRotate(270);
                Log.d("EXIF", "Exif: " + orientation);
            }
            scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix,
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream out = null;
        String filename = getFilename();
        try {
            out = new FileOutputStream(filename);

//          write the compressed bitmap at the destination specified by filename.
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return Uri.fromFile(new File(filename));

    }

    public static Uri compressImageSample(Uri imageUri, Context context) {

        String filePath = getRealPathFromURI(imageUri, context);
        Bitmap scaledBitmap = null;

        BitmapFactory.Options options = new BitmapFactory.Options();

//      by setting this field as true, the actual bitmap pixels are not loaded in the memory. Just the bounds are loaded. If
//      you try the use the bitmap here, you will get null.
        options.inJustDecodeBounds = true;
        Bitmap bmp = BitmapFactory.decodeFile(filePath, options);

        int actualHeight = options.outHeight;
        int actualWidth = options.outWidth;

//      max Height and width values of the compressed image is taken as 816x612

        float maxHeight = 816.0f;
        float maxWidth = 612.0f;
        float imgRatio = actualWidth / actualHeight;
        float maxRatio = maxWidth / maxHeight;

//      width and height values are set maintaining the aspect ratio of the image

        if (actualHeight > maxHeight || actualWidth > maxWidth) {
            if (imgRatio < maxRatio) {
                imgRatio = maxHeight / actualHeight;
                actualWidth = (int) (imgRatio * actualWidth);
                actualHeight = (int) maxHeight;
            } else if (imgRatio > maxRatio) {
                imgRatio = maxWidth / actualWidth;
                actualHeight = (int) (imgRatio * actualHeight);
                actualWidth = (int) maxWidth;
            } else {
                actualHeight = (int) maxHeight;
                actualWidth = (int) maxWidth;

            }
        }

//      setting inSampleSize value allows to load a scaled down version of the original image

        options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight);

//      inJustDecodeBounds set to false to load the actual bitmap
        options.inJustDecodeBounds = false;

//      this options allow android to claim the bitmap memory if it runs low on memory
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16 * 1024];

        try {
//          load the bitmap from its path
            bmp = BitmapFactory.decodeFile(filePath, options);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();

        }
        try {
            scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }

        float ratioX = actualWidth / (float) options.outWidth;
        float ratioY = actualHeight / (float) options.outHeight;
        float middleX = actualWidth / 2.0f;
        float middleY = actualHeight / 2.0f;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

//      check the rotation of the image and display it properly
        ExifInterface exif;
        try {
            exif = new ExifInterface(filePath);

            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 0);
            Log.d("EXIF", "Exif: " + orientation);
            Matrix matrix = new Matrix();
            if (orientation == 6) {
                matrix.postRotate(90);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 3) {
                matrix.postRotate(180);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 8) {
                matrix.postRotate(270);
                Log.d("EXIF", "Exif: " + orientation);
            }
            scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0,
                    scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix,
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream out = null;
        String filename = scansamplepath();
        try {
            out = new FileOutputStream(filename);

//          write the compressed bitmap at the destination specified by filename.
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return Uri.fromFile(new File(filename));
    }

    public static String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "MyFolder/Images");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriSting = (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
        return uriSting;

    }

    public static String getRealPathFromURI(Uri contentUri, Context context) {
        // Uri contentUri = Uri.parse(contentURI);
        Cursor cursor = context.getContentResolver().query(contentUri, null, null, null, null);
        if (cursor == null) {
            return contentUri.getPath();
        } else {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(index);
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        final float totalPixels = width * height;
        final float totalReqPixelsCap = reqWidth * reqHeight * 2;
        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
            inSampleSize++;
        }

        return inSampleSize;
    }

    public static Drawable resizeImage(Context mContext, byte[] imageResource) {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        assert wm != null;
        Display display = wm.getDefaultDisplay();
        double deviceWidth = display.getWidth();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageResource);
        Bitmap itemBitmap = BitmapFactory.decodeStream(inputStream);

        double imageHeight = itemBitmap.getHeight();
        double imageWidth = itemBitmap.getWidth();

        double ratio = deviceWidth / imageWidth;
        int newImageHeight = (int) (imageHeight * ratio);

        return new BitmapDrawable(mContext.getResources(),
                getResizedBitmap(itemBitmap, newImageHeight, (int) deviceWidth));
    }

    public static Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {

        int width = bm.getWidth();
        int height = bm.getHeight();

        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        // create a matrix for the manipulation
        Matrix matrix = new Matrix();

        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);

        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
                matrix, false);

        return resizedBitmap;
    }

    public static void sendMessage(Context mContext, String contact, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            PendingIntent sentPI, deliveredPI;
            String SENT = "SMS_SENT";
            String DELIVERED = "SMS_DELIVERED";

            sentPI = PendingIntent.getBroadcast(mContext, 0, new Intent(SENT), 0);
            deliveredPI = PendingIntent.getBroadcast(mContext, 0, new Intent(DELIVERED), 0);

            ArrayList<String> parts = smsManager.divideMessage(message);

            ArrayList<PendingIntent> sendList = new ArrayList<>();
            sendList.add(sentPI);

            ArrayList<PendingIntent> deliverList = new ArrayList<>();
            deliverList.add(deliveredPI);


            smsManager.sendMultipartTextMessage(contact, null, parts, sendList, deliverList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] loadFarmerInformation(String farmer_id) {
        String farmerInfo[] = new String[7];
        try {
            List<Farmers> farmersList = Farmers.find(Farmers.class, "farmerid = ?", farmer_id);
            if (!farmersList.isEmpty()) {
                Farmers farmers = farmersList.get(0);
                farmerInfo[0] = farmers.getSurname() + ", " + farmers.getOthername();
                farmerInfo[1] = farmers.getAgentid();
                farmerInfo[2] = farmers.getRegion();
                farmerInfo[3] = farmers.getDistrict();
                farmerInfo[4] = farmers.getCommunity();
                farmerInfo[5] = farmers.getTel();
                farmerInfo[6] = farmers.getSpecialty();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return farmerInfo;
    }

    public static String loadFarmerName(String farmer_id) {
        String farmerName = "";
        try {
            List<Farmers> farmersList = Farmers.find(Farmers.class, "farmerid = ?", farmer_id);
            if (!farmersList.isEmpty()) {
                Farmers farmers = farmersList.get(0);
                farmerName = farmers.getSurname() + ", " + farmers.getOthername();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return farmerName;
    }

    public static String loadFarmerContact(String farmer_id) {
        String contact = "";
        try {
            List<Farmers> farmersList = Farmers.find(Farmers.class, "farmerid = ?", farmer_id);
            if (!farmersList.isEmpty()) {
                Farmers farmers = farmersList.get(0);
                contact = "+233" + farmers.getTel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contact;
    }

    public static List<Farms> loadFarmInfo(String farmerid) {
        try {
            return Farms.find(Farms.class, "farmerid = ?", farmerid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static String loadfarmCount(String farmerid) {
        try {
            List<Farms> farms = Farms.find(Farms.class, "farmerid = ?", farmerid);
            return String.valueOf(farms.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String[] loadSingleFarm(String farmid) {
        String[] farminfo = new String[2];
        try {

            List<Farms> farms = Farms.find(Farms.class, "farmid = ?", farmid);
            farminfo[0] = farms.get(0).typeoffarm;
            farminfo[1] = farms.get(0).cropvariety;

            return farminfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return farminfo;
    }

    public static String[] loadFarms(String farmerid) {
        String[] farmList;
        try {
            List<Farms> farms = Farms.find(Farms.class, "farmerid = ?", farmerid);
            farmList = new String[farms.size()];

            for (int i = 0; i < farms.size(); i++) {
                farmList[i] = farms.get(i).getFarmid();
            }

            return farmList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String[0];
    }

    public static String[] loadTotals(String farmerid) {
        String[] totals = new String[5];
        int cultArea = 0, landArea = 0, farmyield = 0, farmCount;
        StringBuilder cropVarieties = new StringBuilder();
        try {
            List<Farms> farms = Farms.find(Farms.class, "farmerid = ?", farmerid);
            farmCount = (int) Farms.count(Farms.class);
            for (int i = 0; i < farms.size(); i++) {
                totals[i] = farms.get(i).getFarmid();
                cultArea += Integer.parseInt(farms.get(i).getCultivatedarea());
                landArea += Integer.parseInt(farms.get(i).getTotalarea());
                farmyield += Integer.parseInt(farms.get(i).getFarmyield());
                cropVarieties.append(farms.get(i).cropvariety);

                if ((farms.size() - i) != 1) {
                    cropVarieties.append(",");
                }
            }
            totals[0] = String.valueOf(farmCount);
            totals[1] = String.valueOf(cultArea);
            totals[2] = String.valueOf(landArea);
            totals[3] = String.valueOf(farmyield);
            totals[4] = String.valueOf(cropVarieties.toString());


            return totals;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String[0];
    }

    public static byte[] loadFarmerImg(String farmer_id, Resources resources) {
        Userbiometrics farmer;
        try {
            List<Userbiometrics> farmersList = Userbiometrics.find(Userbiometrics.class, "farmerid = ?", farmer_id);
            if (!farmersList.isEmpty()) {
                farmer = farmersList.get(0);

                if (farmer != null) {
                    if (farmer.getPicture().length != 0)
                        return farmer.getPicture();
                    else return drawableToArray(R.drawable.placeholder, resources);
                } else return drawableToArray(R.drawable.placeholder, resources);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return drawableToArray(R.drawable.placeholder, resources);
    }

    public static int loadFarmerCart(String farmer_id) {
        int count = 0;
        try {
            List<OrderCart> carts = OrderCart.find(OrderCart.class, "farmerid = ?", farmer_id);
            if (carts != null) {
                count = carts.size();
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int getOrderCount() {
        int count = 0;
        try {
            count = (int) OrderCart.count(OrderCart.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public static int getInputCount() {
        int count = 0;
        try {
            count = (int) Products.count(Products.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public static int getTransactionCount() {
        int count = 0;
        try {
            count = (int) InputTransaction.count(InputTransaction.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public static int getDebtorCount() {
        int count = 0;
        try {
            count = (int) Debtor.count(Debtor.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public static int getDeclarationCount() {
        int count = 0;
        try {
            count = (int) Declaration.count(Declaration.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public static int getCocoasaletranCount() {
        int count = 0;
        try {
            count = (int) Scaletran.count(Scaletran.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public static int getSalesCount() {
        int count = 0;
        try {
            count = (int) Sales.count(Sales.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public static int getSalesTranCount() {
        int count = 0;
        try {
            count = (int) Salestran.count(Salestran.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public static void insertService(String category, String inputName, String inputDesc, String pid, String price, String aid, String uniqueuid, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        try {
            Products inventory = new Products();
            inventory.category = category;
            inventory.pname = inputName;
            inventory.pdesc = inputDesc;
            inventory.pid = pid;
            inventory.price = price;
            inventory.supplier = aid;
            inventory.uniqueuid = uniqueuid;
            inventory.datecreated = datecreated;
            inventory.macaddress = macaddress;
            inventory.imei = imei;
            inventory.agentid = agentid;
            inventory.agentname = agentname;

            inventory.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertScaletran(String transid, String farmerid, String scaleid, String pcid, String bcid, String name, String phone, String payable, String tendered, double count, double weight, double moisturecontent, double amount, Date time, Date date, String uniqueuid, String synstatus, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        try {
            Scaletran scaletran = new Scaletran();
            scaletran.transid = transid;
            scaletran.farmerid = farmerid;
            scaletran.scaleid = scaleid;
            scaletran.pcid = pcid;
            scaletran.bcid = bcid;
            scaletran.name = name;
            scaletran.phone = phone;
            scaletran.payable = payable;
            scaletran.tendered = tendered;
            scaletran.count = count;
            scaletran.weight = weight;
            scaletran.moisturecontent = moisturecontent;
            scaletran.amount = amount;
            scaletran.time = time;
            scaletran.date = date;
            scaletran.uniqueuid = uniqueuid;
            scaletran.synstatus = synstatus;
            scaletran.datecreated = datecreated;
            scaletran.macaddress = macaddress;
            scaletran.imei = imei;
            scaletran.agentname = agentname;
            scaletran.agentid = agentid;

            scaletran.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertOrder(String farmerid, String pid, String orderid, String inputName, String quantity, String price, String sprice, String inputCategory, byte[] inputImg, String uniqueuid, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        try {
            OrderCart cart = new OrderCart();
            cart.farmerid = farmerid;
            cart.pid = pid;
            cart.orderid = orderid;
            cart.inputName = inputName;
            cart.quantity = quantity;
            cart.price = price;
            cart.sprice = sprice;
            cart.inputCategory = inputCategory;
            cart.inputImg = inputImg;
            cart.uniqueuid = uniqueuid;
            cart.datecreated = datecreated;
            cart.macaddress = macaddress;
            cart.imei = imei;
            cart.agentid = agentid;
            cart.agentname = agentname;
            cart.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertInput(String category, String inputName, String pdesc, String pid, String quantity, String price, String supplier, String subprice, byte[] item_img, String uniqueuid, Date datecreated, String macaddress, String imei, String agentname, String agentid, String unitm) {
        try {

//            new Inventory(category, pname, pdesc, pid, quantity, price, supplier, subsidy, item_img, uniqueuid, synstatus, datecreated, serverid, macaddress, imei, agentname, agentid).save();
            Products inventory = new Products();
            inventory.category = category;
            inventory.pname = inputName;
            inventory.pdesc = pdesc;
            inventory.pid = pid;
            inventory.quantity = quantity;
            inventory.price = price;
            inventory.supplier = supplier;
            inventory.subprice = subprice;
            inventory.item_img = item_img;
            inventory.unitm = unitm;
            inventory.uniqueuid = uniqueuid;
            inventory.datecreated = datecreated;
            inventory.macaddress = macaddress;
            inventory.imei = imei;
            inventory.agentid = agentid;
            inventory.agentname = agentname;

            inventory.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertSalesTran(String farmerid, String transactionid, double totalCost, String couponcode, double appliedsub, double payableamt, String paymentmethod, double tendered, double norecoverybags, String syncstatus, String community, String district, String region, String acreage, Date dates, Date times, String uniqueuid, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        try {
            Salestran salestran = new Salestran();
            salestran.farmerid = farmerid;
            salestran.transactionid = transactionid;
            salestran.totalCost = totalCost;
            salestran.couponcode = couponcode;
            salestran.appliedsub = appliedsub;
            salestran.payableamt = payableamt;
            salestran.paymentmethod = paymentmethod;
            salestran.tendered = tendered;
            salestran.norecoverybags = norecoverybags;
            salestran.synstatus = syncstatus;
            salestran.community = community;
            salestran.district = district;
            salestran.region = region;
            salestran.acreage = acreage;
            salestran.dates = dates;
            salestran.times = times;
            salestran.uniqueuid = uniqueuid;
            salestran.datecreated = datecreated;
            salestran.macaddress = macaddress;
            salestran.imei = imei;
            salestran.agentid = agentid;
            salestran.agentname = agentname;
            salestran.save();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertDeclaration(String farmerid, String transactionid, double totalCost, String couponcode, double appliedsub, double payableamt, String paymentmethod, String declaration, String status, String community, String district, String region, String acreage, Date dates, Date times, String uniqueuid, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        try {
            Declaration dec = new Declaration();
            dec.farmerid = farmerid;
            dec.transactionid = transactionid;
            dec.totalCost = totalCost;
            dec.couponcode = couponcode;
            dec.appliedsub = appliedsub;
            dec.norecoverybags = payableamt;
            dec.paymentmethod = paymentmethod;
            dec.declaration = declaration;
            dec.status = status;
            dec.community = community;
            dec.district = district;
            dec.region = region;
            dec.acreage = acreage;
            dec.times = times;
            dec.dates = dates;
            dec.uniqueuid = uniqueuid;
            dec.datecreated = datecreated;
            dec.macaddress = macaddress;
            dec.imei = imei;
            dec.agentname = agentname;
            dec.agentid = agentid;
            dec.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertSales(String farmerid, String transactionid, String pid, String pname, String category, double uprice, int quantity, double totalcost, String syncstatus, String users, Date dates, Date times, String uniqueuid, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        try {
            Sales sales = new Sales();
            sales.farmerid = farmerid;
            sales.transactionid = transactionid;
            sales.category = category;
            sales.pid = pid;
            sales.pname = pname;
            sales.uprice = uprice;
            sales.quantity = quantity;
            sales.totalcost = totalcost;
            sales.synstatus = syncstatus;
            sales.users = users;
            sales.dates = dates;
            sales.times = times;
            sales.uniqueuid = uniqueuid;
            sales.datecreated = datecreated;
            sales.macaddress = macaddress;
            sales.imei = imei;
            sales.agentid = agentid;
            sales.agentname = agentname;
            sales.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("dd MMM yyyy HH:mm:ss").format(new Date());
    }

    public static String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd/MM/yyyy");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }
        return "";
    }

    public static String formatDate2(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("EEE, MMM dd,yyyy 'at' hh:mm:ss");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }
        return "";
    }

    public static String formatDate3(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("EEE, MMM dd,yyyy 'at' hh:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd/MM/yyyy");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }
        return "";
    }


    public static String tolower(String str) {
        return str.toLowerCase().trim();
    }

    public static Boolean checkBarter(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("barter");
        }
        return false;
    }

    public static String[] LoadItemsList() {

        try {
            List<Products> inventories = Products.listAll(Products.class);
            String[] itemList = new String[inventories.size()];

            for (int i = 0; i < inventories.size(); i++) {
                itemList[i] = inventories.get(i).getPname();
            }

            for (int j = 0; j < itemList.length; j++) {
                for (int k = j + 1; k < itemList.length; k++) {
                    if (itemList[j].equals(itemList[k])) {
                        itemList[k] = "";
                    }
                }
            }

            return itemList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String[0];
    }

    public static String genPid(String cat) {
        if (cat.equalsIgnoreCase("weedicide")) {
            return AndroidUtils.INPUTSALESID + AndroidUtils.WEEDICIDE + AndroidUtils.getUUID();
        } else if (cat.equalsIgnoreCase("insecticide")) {
            return AndroidUtils.INPUTSALESID + AndroidUtils.INSECTICIDE + AndroidUtils.getUUID();
        } else if (cat.equalsIgnoreCase("herbicide")) {
            return AndroidUtils.INPUTSALESID + AndroidUtils.HERBICIDE + AndroidUtils.getUUID();
        } else if (cat.equalsIgnoreCase("seed")) {
            return AndroidUtils.INPUTSALESID + AndroidUtils.SEED + AndroidUtils.getUUID();
        } else if (cat.equalsIgnoreCase("fertilizer")) {
            return AndroidUtils.INPUTSALESID + AndroidUtils.FERTILIZER + AndroidUtils.getUUID();
        } else if (cat.equalsIgnoreCase("pesticide")) {
            return AndroidUtils.INPUTSALESID + AndroidUtils.PESTICIDE + AndroidUtils.getUUID();
        } else if (cat.equalsIgnoreCase("fugar")) {
            return AndroidUtils.INPUTSALESID + AndroidUtils.FUGAR + AndroidUtils.getUUID();
        } else if (cat.equalsIgnoreCase("services")) {
            return AndroidUtils.SERVICES + AndroidUtils.getUUID();
        } else if (cat.equalsIgnoreCase("Mechanical Tool")) {
            return AndroidUtils.INPUTSALESID + AndroidUtils.MECHANICALTOOL + AndroidUtils.getUUID();
        }
        return "pid";
    }

    public static Double doubleto2places(Resources res, Double value) {

        return Double.parseDouble(res.getString(R.string.price, value));
    }

    public static byte[] getimg(String inputname, Resources resources) {
        if (inputname.toLowerCase().contains("lake")) {
            return drawableToArray(R.drawable.lake, resources);
        } else if (inputname.toLowerCase().contains("luma")) {
            return drawableToArray(R.drawable.lumax, resources);

        } else if (inputname.toLowerCase().contains("landlord")) {
            return drawableToArray(R.drawable.landlord, resources);

        } else if (inputname.toLowerCase().contains("gly")) {
            return drawableToArray(R.drawable.landlord, resources);

        } else if (inputname.toLowerCase().contains("belt")) {
            return drawableToArray(R.drawable.belt, resources);

        } else if (inputname.toLowerCase().contains("npk")) {
            return drawableToArray(R.drawable.npk, resources);

        } else if (inputname.toLowerCase().contains("urea")) {
            return drawableToArray(R.drawable.urea, resources);
        }
        return null;
    }

    public static String getcategory(String inputname) {
        if (inputname.toLowerCase().contains("lake")) {
            return "seeds";
        } else if (inputname.toLowerCase().contains("luma") || inputname.toLowerCase().contains("gly")) {
            return "herbicide";

        } else if (inputname.toLowerCase().contains("landlord")) {
            return "weedicides";

        } else if (inputname.toLowerCase().contains("belt")) {
            return "insecticides";

        } else if (inputname.toLowerCase().contains("npk") || inputname.toLowerCase().contains("urea")) {
            return "fertilizers";
        }
        return null;
    }

    public static byte[] drawableToArray(int drawable, Resources resources) {
        Bitmap bitmap = BitmapFactory.decodeResource(resources, drawable);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream);

        return outputStream.toByteArray();
    }

    public static String genserviceproviderID() {
        int count = 0;
        try {
            count = (int) ServiceProviders.count(ServiceProviders.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (count > 0) {
            return "PROVIDER-" + String.format("%03d", count - 1);
        } else
            return "PROVIDER-" + String.format("%03d", count);
    }

    public static String genservicetypeID() {
        int count = 0;
        try {
            count = (int) ServiceProviders.count(ServiceProviders.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (count > 0) {
            return "ST" + String.format("%02d", count - 1);
        } else
            return "ST" + String.format("%02d", count);
    }

    public static void deleteAllFarmerAndAssociatedData(String farmerid) {
        Farmers.deleteAll(Farmers.class, "farmerid = ?", farmerid);
        Userbiometrics.deleteAll(Userbiometrics.class, "farmerid = ?", farmerid);
        Farms.deleteAll(Farms.class, "farmerid = ?", farmerid);
        FarmAssessment.deleteAll(FarmAssessment.class, "farmerid = ?", farmerid);
        Declaration.deleteAll(Declaration.class, "farmerid = ?", farmerid);
        Scaletran.deleteAll(Scaletran.class, "farmerid = ?", farmerid);
        Salestran.deleteAll(Salestran.class, "farmerid = ?", farmerid);
        Sales.deleteAll(Sales.class, "farmerid = ?", farmerid);
        LocationCoordinates.deleteAll(LocationCoordinates.class, "farmerid = ?", farmerid);
        SupportDocs.deleteAll(SupportDocs.class, "farmerid = ?", farmerid);
        ActivityInfo.deleteAll(ActivityInfo.class, "farmerid = ?", farmerid);
    }
}
