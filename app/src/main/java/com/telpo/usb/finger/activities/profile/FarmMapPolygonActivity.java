package com.telpo.usb.finger.activities.profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cs.googlemaproute.DrawRoute;
import com.entire.sammalik.samlocationandgeocoding.AddressPojo;
import com.entire.sammalik.samlocationandgeocoding.SamLocationRequestService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.gson.Gson;
import com.google.maps.android.SphericalUtil;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.ActivityFarmMapPolygonBinding;
import com.telpo.usb.finger.entities.LocationCoordinates;
import com.telpo.usb.finger.pojo.PolygonPojo;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.utils.AndroidUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class FarmMapPolygonActivity extends FragmentActivity implements OnMapReadyCallback, DrawRoute.onDrawRoute {
    ActivityFarmMapPolygonBinding binding;
    AddressPojo geolocation;
    Location loc;
    LocationCoordinates loccoords;
    float zoom = 18f;
    boolean bzoom = false;
    String farmerid;
    MarkerOptions markerOptions;
    List<LatLng> latlngarr = new ArrayList<>();
    List<LatLng> latlngpolyarr = new ArrayList<>();
    List<PolygonPojo> polylist;
    LatLng latLng;
    Polygon polygon;
    PolygonPojo polypojo;
    double area;
    double length_in_meters;
    double[] centroid;
    private SamLocationRequestService locationRequestService;
    private LocationManager mLocationManager;
    private GoogleMap mMap;
    private String farmid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_farm_map_polygon);
        geolocation = new AddressPojo();
        Intent idintent = getIntent();
        farmerid = idintent.getStringExtra("farmerid");
        farmid = idintent.getStringExtra("farmid");

        loccoords = new LocationCoordinates();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.resmap);
        mapFragment.getMapAsync(this);
        initPlayServices();
        loadFarmInformation();

        binding.menuPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plotPolygon();
            }
        });

        binding.btnaddcoord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCoordinate();
            }
        });

        binding.menuSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        binding.menuGeocode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getGeocodingInfo();
            }
        });

    }

    //method to init playservices and location updates
    public void initPlayServices() {
        if (checkPlayServices()) {
            mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (!mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                buildAlertMessageNoGps();

            locationRequestService = new SamLocationRequestService(FarmMapPolygonActivity.this);
            locationRequestService.executeService(new SamLocationRequestService.SamLocationListener() {
                @Override
                public void onLocationUpdate(final Location location, final AddressPojo address) {
                    updateUI(location, address);
                }
            });
        }
    }

    //method to load farm polygon record from the database
    public void loadFarmInformation() {
        try {
            List<LocationCoordinates> loclist = LocationCoordinates.find(LocationCoordinates.class, "farmerid = ?" +
                    " and farmid = ?", farmerid, farmid);
            if (!loclist.isEmpty()) {
                loccoords = loclist.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to add coordinate
    public void addCoordinate() {
        latLng = new LatLng(loc.getLatitude(), loc.getLongitude());
        latlngarr.add(latLng);

        mMap.clear();
        for (LatLng coord : latlngarr) {
            markerOptions = new MarkerOptions().position(coord).draggable(true);
            mMap.addMarker(markerOptions);
        }
    }

    //method to plot polygon
    public void plotPolygon() {
        try {
            mMap.clear();
            latlngpolyarr = new ArrayList<>();
            latlngpolyarr.addAll(latlngarr);
            latlngpolyarr.add(latlngpolyarr.get(0));
            polygon = mMap.addPolygon(new PolygonOptions().addAll(latlngpolyarr).strokeWidth(2f).strokeColor(Color.RED).fillColor(0x4500ff00));

            centroid = AndroidUtils.centroid(latlngpolyarr);
            markerOptions = new MarkerOptions().position(new LatLng(centroid[0], centroid[1])).draggable(true);
            mMap.addMarker(markerOptions);

            polylist = new ArrayList<>();
            polypojo = new PolygonPojo();

            for (LatLng latLng : latlngpolyarr) {
                polypojo = new PolygonPojo();
                polypojo.setLatitude(latLng.latitude);
                polypojo.setLongitude(latLng.longitude);
                polylist.add(polypojo);
            }
            area = SphericalUtil.computeArea(latlngpolyarr);
            length_in_meters = SphericalUtil.computeLength(latlngpolyarr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save farm coordinate information
    public void save() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
                AndroidUtils.showProgressDialog(FarmMapPolygonActivity.this, "Saving...");
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    LocationCoordinates loccoords = new LocationCoordinates();
                    loccoords.setLength(length_in_meters);
                    loccoords.setLatitude("" + centroid[0]);
                    loccoords.setLongitude("" + centroid[1]);
                    loccoords.setSyncstatus("0");
                    loccoords.setStreetname(StringUtils.isNotBlank(geolocation.getStreetaddress()) ?
                            geolocation.getStreetaddress() : "");
                    loccoords.setCity(StringUtils.isNotBlank(geolocation.getCity()) ? geolocation.getCity
                            () : "");
                    loccoords.setRegion(StringUtils.isNotBlank(geolocation.getRegion()) ? geolocation.getRegion() : "");
                    loccoords.setAssembly(StringUtils.isNotBlank(geolocation.getAssembly()) ? geolocation.getAssembly() : "");
                    loccoords.setLocationtype("Farm Address");
                    loccoords.setFarmerid(farmerid);
                    loccoords.setFarmid(farmid);
                    loccoords.setJsoncoord(new Gson().toJson(polylist));
                    loccoords.setArea(area);
                    loccoords.setDatecreated(new Date());
                    loccoords.agentid = AndroidUtils.getPreferenceData(FarmMapPolygonActivity.this, AndroidUtils.AGENTID, "");
                    loccoords.agentname = AndroidUtils.getPreferenceData(FarmMapPolygonActivity.this, AndroidUtils.AGENTNAME, "");
                    loccoords.macaddress = AndroidUtils.getMacAddress(FarmMapPolygonActivity.this);
                    loccoords.imei = AndroidUtils.getIMEI(FarmMapPolygonActivity.this);

                    if (StringUtils.isBlank(loccoords.getUniqueuid())) {
                        loccoords.setUniqueuid(AndroidUtils.getUUID());
                    }
                    loccoords.save();

                    ServerTransfer transfer = new ServerTransfer();
                    transfer.setLocationCoordinates(loccoords);
                    String jsonstring = new Gson().toJson(transfer);

                    String uploadId = AndroidUtils.getUUID();
                    String uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
                    AndroidUtils.uploadFileToServer(FarmMapPolygonActivity.this);

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
                    Toasty.success(FarmMapPolygonActivity.this, "Coordinates saved successfully").show();
                    try {
                        locationRequestService.stopLocationUpdates();
                    } catch (Exception e) {
                    }

                    Intent intent = new Intent(FarmMapPolygonActivity.this, ProfileActivity.class);
                    intent.putExtra("farmerid", farmerid);
                    intent.putExtra("tabindex", 1);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        };
        asyncTask.execute();
    }

    //method to zoom in to fit polygon on screen
    public void fitPolygonOnScreen(List<LatLng> list) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng latLng : list) {
            builder.include(latLng);
        }
        LatLngBounds bounds = builder.build();
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20));
    }

    //method to obtain google geocoding information
    public void getGeocodingInfo() {
        @SuppressLint("StaticFieldLeak") AsyncTask<AddressPojo, String, AddressPojo> asyncTask = new AsyncTask<AddressPojo, String, AddressPojo>() {
            AddressPojo addressPojo;

            @Override
            protected void onPreExecute() {
                AndroidUtils.showProgressDialog(FarmMapPolygonActivity.this, "Loading....");
                super.onPreExecute();
            }

            @Override
            protected AddressPojo doInBackground(AddressPojo... params) {
                try {
                    addressPojo = AndroidUtils.getCurrentLocationViaJSON(loc.getLatitude(), loc.getLongitude());
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return addressPojo;
            }

            @Override
            protected void onPostExecute(AddressPojo s) {
                geolocation = s;
                if (StringUtils.isNotEmpty(s.getRegion()))
                    binding.addresssResults.setText(s.getRegion() + ", " + s.getCity() + ", " + s.getStreetaddress());

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
                        FarmMapPolygonActivity.super.onBackPressed();
                        locationRequestService.stopLocationUpdates();
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .show();
    }

    @Override
    public void afterDraw(String result) {

    }

    //method to update ui with coordinates
    public void updateUI(final Location location, final AddressPojo address) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loc = location;
                if (bzoom) {
                    zoom = mMap.getCameraPosition().zoom;
                }

                if (StringUtils.isBlank(loccoords.getLatitude())) {
                    //locationRequestService.startLocationUpdates();
                    loc = location;
                    binding.coords.setText("Coordinate: " + location.getLatitude() + ", " + location.getLongitude() + " (Accu. " + location.getAccuracy() + "m)");
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), zoom));//

                    bzoom = true;
                } else {
                    locationRequestService.stopLocationUpdates();

                    binding.coords.setText("Lat,Long: " + loccoords.getLatitude() + ", " + loccoords.getLongitude());
                    binding.addresssResults.setText(checkForNull(loccoords.getRegion()) + "," + checkForNull(loccoords.getCity()) + ","
                            + checkForNull(loccoords.getAssembly()) + "," + checkForNull(loccoords.getStreetname()));

                }
            }
        });
    }

    //method to show polygon from database
    public void showPolygonFromDatabase() {
        mMap.clear();//clear the map of any markers
        latlngpolyarr = new ArrayList<>();
        polylist = new ArrayList<>();
        //convert latlng json array to list
        polylist = AndroidUtils.getGsonList(loccoords.getJsoncoord(), PolygonPojo.class);
        //iterate and add the LatLng to the polygon array
        for (PolygonPojo poly : polylist) {
            latlngpolyarr.add(new LatLng(poly.getLatitude(), poly.getLongitude()));
        }
        //plot the polygon array latlngpolyarr on the map
        polygon = mMap.addPolygon(new PolygonOptions().addAll(latlngpolyarr).strokeWidth(2f).strokeColor(Color.RED).fillColor(0x4500ff00));
        //get the centroid and place the marker on the polygon
        markerOptions = new MarkerOptions().position(new LatLng(Double.valueOf(loccoords.getLatitude()), Double.valueOf(loccoords.getLongitude())));
        mMap.addMarker(markerOptions);
        //move the camera to the center coordinate
        //fitPolygonOnScreen(latlngpolyarr);//not tested yet
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Double.valueOf(loccoords.getLatitude()), Double.valueOf(loccoords.getLongitude())), zoom));//
        bzoom = true;
    }

    //method to draw routes between two coordinates
    public void plotRoutes() {
        DrawRoute.getInstance(this, FarmMapPolygonActivity.this).setFromLatLong(24.905954, 67.0803505)
                .setToLatLong(24.9053485, 67.079119).setGmapAndKey(getResources().getString(R.string.google_maps_key), mMap).run();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);

        if (StringUtils.isNotEmpty(loccoords.getLatitude())) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showPolygonFromDatabase();
                }
            });
        } else {
            LatLng accra = new LatLng(5.6028522, -0.2181337);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(accra, 18f));
            mMap.addMarker(new MarkerOptions().position(accra).title("Softmasters"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(accra));
        }
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
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private boolean checkPlayServices() {

        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(this);
        if (result != ConnectionResult.SUCCESS) {
            if (googleAPI.isUserResolvableError(result)) {
                googleAPI.getErrorDialog(this, result,
                        1000).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }

        return true;

//        int resultCode = GooglePlayServicesUtil
//                .isGooglePlayServicesAvailable(this);
//        if (resultCode != ConnectionResult.SUCCESS) {
//            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
//                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
//                        1000).show();
//            } else {
//                Toast.makeText(getApplicationContext(),
//                        "This device is not supported.", Toast.LENGTH_LONG)
//                     .show();
//                finish();
//            }
//            return false;
//        }
//        return true;
    }

    public String checkForNull(String testString) {
        return StringUtils.isBlank(testString) ? "" : testString;
    }
}
