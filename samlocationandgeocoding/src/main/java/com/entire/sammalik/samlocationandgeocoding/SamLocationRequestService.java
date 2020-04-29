package com.entire.sammalik.samlocationandgeocoding;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class SamLocationRequestService implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private static final long INTERVAL = 1000 * 10;
    private static final long FASTEST_INTERVAL = 1000 * 5;
    static OkHttpClient client = new OkHttpClient();
    public boolean locationupdateson;
    Context context;
    AddressPojo geolocation;
    SamLocationListener samLocationListener;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;

    public SamLocationRequestService(Context context) {
        this.context = context;
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


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

    public void executeService(final SamLocationListener samLocationListener) {
        this.samLocationListener = samLocationListener;
        mGoogleApiClient.connect();
        if (mGoogleApiClient.isConnected()) {
            startLocationUpdates();
            Log.d("", "Location update resumed .....................");
        }
    }

    public void getsamlocationlistener(final SamLocationListener samLocationListener) {
        this.samLocationListener = samLocationListener;
    }

    @Override
    public void onConnected(Bundle bundle) {
        startLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(final Location location) {
        Log.e("Lat", " " + String.valueOf(location.getLatitude()));
        Log.e("Long", " " + String.valueOf(location.getLongitude()));
        if ((String.valueOf(location.getLatitude())).equals(null)) {
        } else {
//            AsyncTask<AddressPojo, String, AddressPojo> asyncTask = new AsyncTask<AddressPojo,
//                    String, AddressPojo>()
//            {
//                AddressPojo addressPojo;
//
//                @Override
//                protected AddressPojo doInBackground(AddressPojo... params)
//                {
//                    try
//                    {
////                        addressPojo = getCurrentLocationViaJSON(location.getLatitude(), location
////                                .getLongitude());
//                    }
//                    catch (Exception e)
//                    {
//                        System.out.println("Exception" + e.getMessage());
//                        e.printStackTrace();
//                    }
//                    return addressPojo;
//                }
//
//                @Override
//                protected void onPostExecute(AddressPojo s)
//                {
//                    geolocation = s;
//                    super.onPostExecute(s);
//                }
//            };
//            asyncTask.execute();
//
//
//            //stopLocationUpdates();
////            try
////            {
////                //LocationAddress locationAddress = new LocationAddress();
////
////                geolocation = locationAddress.getAddressFromLocation(location.getLatitude(),
//// location
////                                .getLongitude(),
////                        context);
////            }
////            catch (Exception e)
////            {
////                //System.out.println(e.getMessage());
////            }
//            Log.e("geolocation", " " + geolocation);

        }
        samLocationListener.onLocationUpdate(location, geolocation);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission
                (context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager
                .PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        PendingResult<Status> pendingResult = LocationServices.FusedLocationApi
                .requestLocationUpdates(
                        mGoogleApiClient, mLocationRequest, this);
        locationupdateson = true;
        Log.d("LocationRequestService", "Location update started ..............: ");
    }

    public void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
        locationupdateson = false;
        Log.d("LocationRequestService", "Location update stopped .......................");
    }


    public interface SamLocationListener {

        void onLocationUpdate(Location location, AddressPojo address);

    }

}