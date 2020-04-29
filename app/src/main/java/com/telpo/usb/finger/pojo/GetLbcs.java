package com.telpo.usb.finger.pojo;

/**
 * Created by Rebekkah_Boamah on 11/17/2017.
 */

public class GetLbcs {

    String email, phone, district, region;
    private String name;
    private String location;
    private String address;
    private String lbcid;
    private String ini_string;

    GetLbcs(String name, String location, String address, String ini_string, String lbcid, String region, String district, String email, String phone) {
        this.name = name;
        this.location = location;
        this.address = address;
        this.ini_string = ini_string;
        this.lbcid = lbcid;
        this.region = region;
        this.district = district;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLbcid() {
        return lbcid;
    }

    public void setLbcid(String lbcid) {
        this.lbcid = lbcid;
    }

    public String getIni_string() {
        return ini_string;
    }

    public void setIni_string(String ini_string) {
        this.ini_string = ini_string;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
