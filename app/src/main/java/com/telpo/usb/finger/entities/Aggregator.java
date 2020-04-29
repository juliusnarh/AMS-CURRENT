package com.telpo.usb.finger.entities;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class Aggregator extends SugarRecord {

    public String aggregatorid;
    @SerializedName("names")
    public String aggregatorname;
    @SerializedName("telephone")
    public String tel;
    public String address;
    public String contactpersonname;
    public String contactpersontel;
    public String roles;
    public String region;
    public String district;
    @SerializedName("imagename")
    public String image;
    public String cropspeciality;
    @SerializedName("Lag")
    public String lag;
    @SerializedName("Lon")
    public String lon;

    public Aggregator() {
    }

    public Aggregator(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }

    public String getAggregatorname() {
        return aggregatorname;
    }

    public void setAggregatorname(String aggregatorname) {
        this.aggregatorname = aggregatorname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactpersonname() {
        return contactpersonname;
    }

    public void setContactpersonname(String contactpersonname) {
        this.contactpersonname = contactpersonname;
    }

    public String getContactpersontel() {
        return contactpersontel;
    }

    public void setContactpersontel(String contactpersontel) {
        this.contactpersontel = contactpersontel;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCropspeciality() {
        return cropspeciality;
    }

    public void setCropspeciality(String cropspeciality) {
        this.cropspeciality = cropspeciality;
    }

    public String getLag() {
        return lag;
    }

    public void setLag(String lag) {
        this.lag = lag;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
