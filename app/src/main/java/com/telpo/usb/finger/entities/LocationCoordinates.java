package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Junior on 12/15/2017.
 */

public class LocationCoordinates extends SugarRecord {
    public String farmerid;
    public String locationtype;
    public String farmid;
    public String latitude;
    public String longitude;
    public String streetname;
    public String city;
    public String region;
    public String assembly;
    public String jsoncoord;
    public double area;
    public double length;
    public Date   datecreated;
    public String syncstatus;
    public String uniqueuid;
    public int    serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;

    public LocationCoordinates(String farmerid, String locationtype, String farmid, String latitude, String longitude, String streetname, String city, String region, String assembly, String jsoncoord, double area, double length, Date datecreated, String syncstatus, String uniqueuid, int serverid, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.locationtype = locationtype;
        this.farmid = farmid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.streetname = streetname;
        this.city = city;
        this.region = region;
        this.assembly = assembly;
        this.jsoncoord = jsoncoord;
        this.area = area;
        this.length = length;
        this.datecreated = datecreated;
        this.syncstatus = syncstatus;
        this.uniqueuid = uniqueuid;
        this.serverid = serverid;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
    }

    public LocationCoordinates() {
    }

    public String aggregatorid;

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }
    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public int getServerid() {
        return serverid;
    }

    public void setServerid(int serverid) {
        this.serverid = serverid;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSyncstatus() {
        return syncstatus;
    }

    public void setSyncstatus(String syncstatus) {
        this.syncstatus = syncstatus;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAssembly() {
        return assembly;
    }

    public void setAssembly(String assembly) {
        this.assembly = assembly;
    }

    public String getLocationtype() {
        return locationtype;
    }

    public void setLocationtype(String locationtype) {
        this.locationtype = locationtype;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getFarmid() {
        return farmid;
    }

    public void setFarmid(String farmid) {
        this.farmid = farmid;
    }


    public String getJsoncoord() {
        return jsoncoord;
    }

    public void setJsoncoord(String jsoncoord) {
        this.jsoncoord = jsoncoord;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }
}
