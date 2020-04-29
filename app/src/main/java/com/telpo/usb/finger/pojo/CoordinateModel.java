package com.telpo.usb.finger.pojo;

/**
 * Created by Junior on 12/11/2017.
 */

public class CoordinateModel {
    String lat;
    String longt;


    public CoordinateModel(String lat, String longt) {
        this.lat = lat;
        this.longt = longt;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongt() {
        return longt;
    }

    public void setLongt(String longt) {
        this.longt = longt;
    }
}