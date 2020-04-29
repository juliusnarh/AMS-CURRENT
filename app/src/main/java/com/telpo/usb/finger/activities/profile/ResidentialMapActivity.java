package com.telpo.usb.finger.activities.profile;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.cs.googlemaproute.DrawRoute;
import com.entire.sammalik.samlocationandgeocoding.AddressPojo;
import com.entire.sammalik.samlocationandgeocoding.SamLocationRequestService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.ActivityResidentialMapBinding;
import com.telpo.usb.finger.entities.LocationCoordinates;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.utils.AndroidUtils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

public class ResidentialMapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener, SensorEventListener, DrawRoute.onDrawRoute, GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener {
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    static final int TWO_MINUTES = 1000 * 60 * 2;
    ActivityResidentialMapBinding binding;
    AddressPojo addr = new AddressPojo();
    Location loc;
    LocationCoordinates loccoords;
    AddressPojo geolocation;
    float zoom = 18f, accuracy = 20f;
    boolean bzoom = false;
    String farmerid;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    SupportMapFragment mapFragment;
    FusedLocationProviderClient fusedLocationProviderClient;
    MaterialDialog prog;
    int count = 0;
    private SamLocationRequestService locationRequestService;
    private LocationManager mLocationManager;
    private Location currentBestLocation = null;
    private GoogleMap mMap;
    private View locationButton;
    Bitmap currentMarker, searchMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_residential_map);
        geolocation = new AddressPojo();
        loccoords = new LocationCoordinates();
        Intent intent = getIntent();
        farmerid = intent.getStringExtra("farmerid");
        if (!checkLocation()) {
            turnonLocation();
        }
        loadCustomMarkers();
        loadAddressLocation();
        showActionButtons(View.INVISIBLE);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        binding.btnmylocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toasty.info(getApplicationContext(), "Select Save Button").show();
            }
        });

        binding.btngeocode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getGeocodingInfo();
            }
        });

        binding.btndirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (accuracy < 25f)
                    saveLocation();
                else
                    Toasty.error(getApplicationContext(), "Location accuracy is more than 15meters").show();
            }
        });

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.resmap);

        mapFragment.getMapAsync(this);

        if (isGooglePlayServicesAvailable(this)) {
            mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (!mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                buildAlertMessageNoGps();
        }
    }

    private void loadCustomMarkers() {
        int height = 35;
        int width = 35;
        BitmapDrawable bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.location);
        Bitmap b = bitmapdraw.getBitmap();
        currentMarker = Bitmap.createScaledBitmap(b, width, height, false);

        bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.search_marker);
        b = bitmapdraw.getBitmap();
        searchMarker = Bitmap.createScaledBitmap(b, width, height, false);
    }

    private boolean checkLocation() {
        LocationManager lm = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }

        return gps_enabled && network_enabled;
    }

    private void turnonLocation() {
        prog = new MaterialDialog.Builder(ResidentialMapActivity.this)
                .content("Location services turned off.\nPlease turn on location services to proceed")
                .positiveText("Ok")
                .onPositive((dialog, which) -> {
                    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(myIntent);
                    prog.dismiss();
                })
                .cancelable(false)
                .build();
        prog.show();
    }

    private Location getLastBestLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        }

        Location locationGPS = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        Location locationNet = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        long GPSLocationTime = 0;
        if (null != locationGPS) {
            GPSLocationTime = locationGPS.getTime();
        }

        long NetLocationTime = 0;

        if (null != locationNet) {
            NetLocationTime = locationNet.getTime();
        }

        if (0 < GPSLocationTime - NetLocationTime) {
            return locationGPS;
        } else {
            return locationNet;
        }
    }

    //method to obtain google geocoding information
    public void getGeocodingInfo() {
        @SuppressLint("StaticFieldLeak") AsyncTask<AddressPojo, String, AddressPojo> asyncTask = new AsyncTask<AddressPojo, String, AddressPojo>() {
            AddressPojo addressPojo;

            @Override
            protected void onPreExecute() {
                AndroidUtils.showProgressDialog(ResidentialMapActivity.this, "Loading....");
                super.onPreExecute();
            }

            @Override
            protected AddressPojo doInBackground(AddressPojo... params) {
                try {
                    addressPojo = AndroidUtils.getCurrentLocationViaJSON(Double.valueOf(loccoords.getLatitude()), Double.valueOf(loccoords.getLongitude()));
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return addressPojo;
            }

            @SuppressLint("SetTextI18n")
            @Override
            protected void onPostExecute(AddressPojo s) {
                geolocation = s;
                if (s != null) {
                    addr = s;
                    binding.addresssResults.setText(checkForNull(s.getRegion()) + ", " + checkForNull(s.getCity()) + ", " + checkForNull(s.getStreetaddress()));
                } else
                    binding.addresssResults.setText("");

                AndroidUtils.dismissProgressDialog();
                super.onPostExecute(s);
            }
        };
        asyncTask.execute();
        Log.e("geolocation", " " + geolocation);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Click [YES] to Exit")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ResidentialMapActivity.super.onBackPressed();
//                        locationRequestService.stopLocationUpdates();
                        if (mGoogleApiClient != null) {
//                            fusedLocationProviderClient.removeLocationUpdates(mGoogleApiClient, ResidentialMapActivity.this);
                            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, ResidentialMapActivity.this);
                        }
                        finish();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .show();
    }

    //method to load location information if present in the database
    public void loadAddressLocation() {
        try {
            loccoords = new LocationCoordinates();
            List<LocationCoordinates> loccoordlist = LocationCoordinates.find(LocationCoordinates.class, "farmerid = ? and locationtype = ?",
                    farmerid, "Residential Address");

            if (!loccoordlist.isEmpty()) {
                loccoords = loccoordlist.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save location residential location coords
    public void saveLocation() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
                AndroidUtils.showProgressDialog(ResidentialMapActivity.this, "Saving...");
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    LocationCoordinates locds = new LocationCoordinates();
                    locds.setStreetname(checkForNull(addr.getStreetaddress()));
                    locds.setCity(checkForNull(addr.getCity()));
                    locds.setRegion(checkForNull(addr.getRegion()));
                    locds.setAssembly(checkForNull(addr.getAssembly()));
                    locds.setLocationtype("Residential Address");
                    locds.setJsoncoord("");
                    locds.setArea(0.0D);
                    locds.setFarmerid(farmerid);
                    locds.setFarmid("");
                    locds.setLatitude(loccoords.getLatitude());//String.valueOf(loc.getLatitude()));
                    locds.setLongitude(loccoords.getLongitude());//String.valueOf(loc.getLongitude()));
                    locds.setSyncstatus("0");
                    locds.setDatecreated(new Date());
                    locds.setUniqueuid(AndroidUtils.getUUID());
                    locds.agentid = AndroidUtils.getPreferenceData(ResidentialMapActivity.this, AndroidUtils.AGENTID, "");
                    locds.agentname = AndroidUtils.getPreferenceData(ResidentialMapActivity.this, AndroidUtils.AGENTNAME, "");
                    locds.macaddress = AndroidUtils.getMacAddress(ResidentialMapActivity.this);
                    locds.imei = AndroidUtils.getIMEI(ResidentialMapActivity.this);
                    locds.save();

                    ServerTransfer transfer = new ServerTransfer();
                    transfer.setLocationCoordinates(locds);
                    String jsonstring = new Gson().toJson(transfer);

                    String uploadId = AndroidUtils.getUUID();
                    String uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
                    AndroidUtils.uploadFileToServer(ResidentialMapActivity.this);

                    outcome = true;
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {
                AndroidUtils.dismissProgressDialog();
                if (outcome) {
                    Toasty.success(ResidentialMapActivity.this, "Coordinate saved successfully").show();
                    Intent intent = new Intent(ResidentialMapActivity.this, ProfileActivity.class);
                    intent.putExtra("farmerid", farmerid);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        };
        asyncTask.execute();
    }

    //method to update ui with coordinates
    public void updateUI(final Location location, final AddressPojo address) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (bzoom) {
                    zoom = mMap.getCameraPosition().zoom;
                    zoom = 15f;
                }

                if (StringUtils.isEmpty(loccoords.getLatitude())) {
//                    locationRequestService.startLocationUpdates();
                    binding.btnsave.setEnabled(true);
                    binding.btnsave.setClickable(true);
                    loc = location;

                    loccoords.setLatitude("" + location.getLatitude());
                    loccoords.setLongitude("" + location.getLongitude());
                    String temp = "Lat., Long.: " + location.getLatitude() + ", " + location.getLongitude() + " Accu.(" + location.getAccuracy() + "m)";
                    binding.coords.setText(temp);

                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position((new LatLng(location.getLatitude(), location.getLongitude()))).icon(BitmapDescriptorFactory.fromBitmap(searchMarker)));
//                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), zoom));
//                    bzoom = true;
                    Toasty.normal(getApplicationContext(), "New Coordinates: Lat, Long:" + loccoords.getLatitude() + ", " + loccoords.getLongitude()).show();
                    showActionButtons(View.VISIBLE);
                } else {
                    locationRequestService.stopLocationUpdates();
                    String temp = "Lat,Long: " + loccoords.getLatitude() + ", " + loccoords.getLongitude();
                    binding.coords.setText(temp);
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position((new LatLng(Double.valueOf(loccoords.getLatitude()), Double.valueOf(loccoords.getLongitude())))).icon(BitmapDescriptorFactory.fromBitmap(searchMarker)));
//                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Double.valueOf(loccoords.getLatitude()), Double.valueOf(loccoords.getLongitude())), zoom));
//                    bzoom = true;
                    Toasty.normal(getApplicationContext(), "New Coordinates: Lat, Long:" + loccoords.getLatitude() + ", " + loccoords.getLongitude()).show();
                }

            }
        });
    }

    public void showActionButtons(int visible) {
        binding.btnsave.show();
        binding.btndirection.hide();
        binding.btnmylocation.show();
        binding.btngeocode.hide();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        mMap.getUiSettings().setCompassEnabled(false);

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.mapstyle));

            if (!success) {
                Log.e("MAPTEST", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MAPTEST", "Can't find style. Error: ", e);
        }

        if (StringUtils.isNotEmpty(loccoords.getLatitude())) {
            String temp = "Lat,Long: " + loccoords.getLatitude() + ", " + loccoords.getLongitude();
            binding.coords.setText(temp);

            mMap.clear();
            mMap.addMarker(new MarkerOptions()
                    .position((new LatLng(Double.valueOf(loccoords.getLatitude()), Double.valueOf(loccoords.getLongitude()))))
                    .title("Farmer location")
                    .icon(BitmapDescriptorFactory.fromBitmap(currentMarker))
            );
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Double.valueOf(loccoords.getLatitude()), Double.valueOf(loccoords.getLongitude())), 12f));
            bzoom = true;
            showActionButtons(View.VISIBLE);
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);

        } else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
            LatLng accra = new LatLng(5.6028522, -0.2181337);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(accra, 15f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(accra));
        }
    }

    public String checkForNull(String testString) {
        return StringUtils.isBlank(testString) ? "" : testString;
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, final int id) {
                        dialog.dismiss();
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.dismiss();
                        // spinner.setVisibility(View.GONE);
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    public boolean isGooglePlayServicesAvailable(Activity activity) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int status = googleApiAvailability.isGooglePlayServicesAvailable(activity);
        if (status != ConnectionResult.SUCCESS) {
            if (googleApiAvailability.isUserResolvableError(status)) {
                Toasty.error(getApplicationContext(), "This device is not supported.").show();
//                googleApiAvailability.getErrorDialog(activity, status, 2404).show();
            }
            return false;
        }
        return true;
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void afterDraw(String result) {
//        locationRequestService.stopLocationUpdates();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(2000 * 10);
        mLocationRequest.setFastestInterval(2000 * 5);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {


        if (location.getAccuracy() <= 25f) {
            count++;
            mLastLocation = location;
            if (mCurrLocationMarker != null) {
                mCurrLocationMarker.remove();
            }
            currentBestLocation = getLastBestLocation();
            makeUseOfNewLocation(location);
            Log.d("Here", "Here " + count);
            if (currentBestLocation == null) {
                currentBestLocation = location;
            } else {
                location = currentBestLocation;
            }
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            String provider = locationManager.getBestProvider(new Criteria(), true);
            loccoords.setLatitude(String.valueOf(location.getLatitude()));
            loccoords.setLongitude(String.valueOf(location.getLongitude()));
            String temp = "Lat., Long.: " + location.getLatitude() + ", " + location.getLongitude() + " Accu.(" + location.getAccuracy() + "m)";
            accuracy = location.getAccuracy();
            binding.coords.setText(temp);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                return;
            }

            Location locations = locationManager.getLastKnownLocation(provider);
            List<String> providerList = locationManager.getAllProviders();
            if (null != locations && null != providerList && providerList.size() > 0) {
                double longitude = locations.getLongitude();
                double latitude = locations.getLatitude();

                loccoords.setLatitude(String.valueOf(latitude));
                loccoords.setLongitude(String.valueOf(longitude));
                temp = "Lat., Long.: " + location.getLatitude() + ", " + location.getLongitude() + " Accu.(" + location.getAccuracy() + "m)";
                binding.coords.setText(temp);
                Geocoder geocoder = new Geocoder(getApplicationContext(),
                        Locale.getDefault());
                try {
                    List<Address> listAddresses = geocoder.getFromLocation(latitude,
                            longitude, 1);
                    if (null != listAddresses && listAddresses.size() > 0) {
                        String state = listAddresses.get(0).getAdminArea();
                        String country = listAddresses.get(0).getCountryName();
                        String subLocality = listAddresses.get(0).getSubLocality();
                        markerOptions.title("" + latLng + "," + subLocality + "," + state
                                + "," + country);
                        binding.addresssResults.setText(getResources().getString(R.string.geocoord, checkForNull(country), checkForNull(state), checkForNull(subLocality), checkForNull(listAddresses.get(0).getLocality())));
                        addr.setAssembly(listAddresses.get(0).getLocality());
                        addr.setCity(subLocality);
                        addr.setCountry(country);
                        addr.setRegion(state);
                        addr.setStreetaddress(listAddresses.get(0).getAddressLine(0));
                    } else
                        binding.addresssResults.setText("");
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(searchMarker));
            mCurrLocationMarker = mMap.addMarker(markerOptions);

            if (location.getAccuracy() < 10f) {
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(13f));
            }
            Toasty.normal(getApplicationContext(), "New Coordinates: Lat, Long:" + loccoords.getLatitude() + ", " + loccoords.getLongitude()).show();
        }
    }


    /**
     * This method modify the last know good location according to the arguments.
     *
     * @param location The possible new location.
     */
    void makeUseOfNewLocation(Location location) {
        if (isBetterLocation(location, currentBestLocation)) {
            currentBestLocation = location;
        }
    }


    /**
     * Determines whether one location reading is better than the current location fix
     *
     * @param location            The new location that you want to evaluate
     * @param currentBestLocation The current location fix, to which you want to compare the new one.
     */
    protected boolean isBetterLocation(Location location, Location currentBestLocation) {
        if (currentBestLocation == null) {
            // A new location is always better than no location
            return true;
        }

        // Check whether the new location fix is newer or older
        long timeDelta = location.getTime() - currentBestLocation.getTime();
        boolean isSignificantlyNewer = timeDelta > TWO_MINUTES;
        boolean isSignificantlyOlder = timeDelta < -TWO_MINUTES;
        boolean isNewer = timeDelta > 0;

        // If it's been more than two minutes since the current location, use the new location,
        // because the user has likely moved.
        if (isSignificantlyNewer) {
            return true;
            // If the new location is more than two minutes older, it must be worse.
        } else if (isSignificantlyOlder) {
            return false;
        }

        // Check whether the new location fix is more or less accurate
        int accuracyDelta = (int) (location.getAccuracy() - currentBestLocation.getAccuracy());
        boolean isLessAccurate = accuracyDelta > 0;
        boolean isMoreAccurate = accuracyDelta < 0;
        boolean isSignificantlyLessAccurate = accuracyDelta > 200;

        // Check if the old and new location are from the same provider
        boolean isFromSameProvider = isSameProvider(location.getProvider(),
                currentBestLocation.getProvider());

        // Determine location quality using a combination of timeliness and accuracy
        if (isMoreAccurate) {
            return true;
        } else if (isNewer && !isLessAccurate) {
            return true;
        } else return isNewer && !isSignificantlyLessAccurate && isFromSameProvider;
    }

    // Checks whether two providers are the same
    private boolean isSameProvider(String provider1, String provider2) {
        if (provider1 == null) {
            return provider2 == null;
        }
        return provider1.equals(provider2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient,
                    this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!checkLocation()) {
            turnonLocation();
        }
        if (mGoogleApiClient != null) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
            }
        }
    }


}
