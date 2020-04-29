package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

public class GetSearchFarmInfo extends SugarRecord {

    public String farmerid;
    public String surname;
    public String othername;
    public String farms;
    public String community;

    public GetSearchFarmInfo() {
    }

    public GetSearchFarmInfo(String farmerid, String surname, String othername, String farms, String community) {
        this.farmerid = farmerid;
        this.surname = surname;
        this.othername = othername;
        this.farms = farms;
        this.community = community;
    }

    public String aggregatorid;

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }
    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getFarms() {
        return farms;
    }

    public void setFarms(String farms) {
        this.farms = farms;
    }
}
