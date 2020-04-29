package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

/**
 * Created by Rebekkah_Boamah on 10/26/2017.
 */

public class GetSearchFarmerInfo extends SugarRecord {
    public String farm_id;
    public String farmer_id;
    public String loc;
    public String img;
    public String name;
    public String surname;
    public String othername;
    public byte[] photo;
    public String telephone;
    public String community;

    public GetSearchFarmerInfo() {
    }

    public GetSearchFarmerInfo(String farm_id, String farmer_id, String loc, String img, String community) {

        this.farm_id = farm_id;
        this.farmer_id = farmer_id;
        this.loc = loc;
        this.img = img;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFarm_id() {
        return farm_id;
    }

    public void setFarm_id(String farm_id) {
        this.farm_id = farm_id;
    }

    public String getFarmer_id() {
        return farmer_id;
    }

    public void setFarmer_id(String farmer_id) {
        this.farmer_id = farmer_id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
