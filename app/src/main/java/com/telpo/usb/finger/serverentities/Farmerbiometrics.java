package com.telpo.usb.finger.serverentities;
// Generated Jun 30, 2018 8:14:16 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Farmerbiometrics generated by hbm2java
 */

public class Farmerbiometrics implements java.io.Serializable {


    private Integer id;
    private String farmerid;
    private String uniqueuid;
    private String placeofregistered;
    private byte[] picture;
    private byte[] signature;
    private Date datecreated;
    private String picturename;
    private String agentid;
    private String agentname;
    private String imei;
    private String macaddress;
    private Integer serverid;
    private String aggregatorid;
    public Farmerbiometrics() {
    }

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }

    public Integer getServerid() {
        return serverid;
    }

    public void setServerid(Integer serverid) {
        this.serverid = serverid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }

    public String getPlaceofregistered() {
        return placeofregistered;
    }

    public void setPlaceofregistered(String placeofregistered) {
        this.placeofregistered = placeofregistered;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }
}


