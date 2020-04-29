package com.telpo.usb.finger.pojo;

import com.telpo.usb.finger.entities.Farms;
import com.telpo.usb.finger.entities.LocationCoordinates;

/**
 * Created by Junior on 4/2/2018.
 */

public class FarmGeoInfo {
    private Farms farms;
    private LocationCoordinates loccords;

    public Farms getFarms() {
        if (farms == null)
            farms = new Farms();
        return farms;
    }

    public void setFarms(Farms farms) {
        this.farms = farms;
    }

    public LocationCoordinates getLoccords() {
        if (loccords == null)
            loccords = new LocationCoordinates();
        return loccords;
    }

    public void setLoccords(LocationCoordinates loccords) {
        this.loccords = loccords;
    }
}
