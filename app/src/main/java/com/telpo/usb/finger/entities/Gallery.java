package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Junior on 12/15/2017.
 */

public class Gallery extends SugarRecord {
    public String farmerid;
    public String imagetype;
    public String description;
    public byte[] galleryimage;
    public Date datecreated;
    public String uniqueuid;
    public String synstatus;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;
    public String aggregatorid;

    public Gallery(String farmerid, String imagetype, String description, byte[] galleryimage, Date datecreated, String uniqueuid, String synstatus, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.imagetype = imagetype;
        this.description = description;
        this.galleryimage = galleryimage;
        this.datecreated = datecreated;
        this.uniqueuid = uniqueuid;
        this.synstatus = synstatus;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
    }

    public Gallery() {
    }

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

    public String getSynstatus() {
        return synstatus;
    }

    public void setSynstatus(String synstatus) {
        this.synstatus = synstatus;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getImagetype() {
        return imagetype;
    }

    public void setImagetype(String imagetype) {
        this.imagetype = imagetype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getGalleryimage() {
        return galleryimage;
    }

    public void setGalleryimage(byte[] galleryimage) {
        this.galleryimage = galleryimage;
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
