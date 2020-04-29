package com.telpo.usb.finger.pojo;

public class Aggregator {
    private String aggregatorid;
    private String aggregatorname;
    private String tel;
    private String address;
    private String contactperson;
    private String cpersontel;
    private String role;
    private String region;
    private String district;
    private String cropspeciality;

    public Aggregator() {
    }

    public Aggregator(String aggregatorid, String aggregatorname, String tel, String address, String contactperson, String cpersontel, String role, String region, String district, String cropspeciality) {
        this.aggregatorid = aggregatorid;
        this.aggregatorname = aggregatorname;
        this.tel = tel;
        this.address = address;
        this.contactperson = contactperson;
        this.cpersontel = cpersontel;
        this.role = role;
        this.region = region;
        this.district = district;
        this.cropspeciality = cropspeciality;
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

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getCpersontel() {
        return cpersontel;
    }

    public void setCpersontel(String cpersontel) {
        this.cpersontel = cpersontel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getCropspeciality() {
        return cropspeciality;
    }

    public void setCropspeciality(String cropspeciality) {
        this.cropspeciality = cropspeciality;
    }
}
