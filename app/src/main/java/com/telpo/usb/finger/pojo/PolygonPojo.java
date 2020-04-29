package com.telpo.usb.finger.pojo;

import java.io.Serializable;

/**
 * Created by Junior on 1/2/2018.
 */

public class PolygonPojo implements Serializable {
    private double longitude;
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
