package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class FarmAssessment extends SugarRecord {
    public String farmerid;
    public String farmid;
    public Date dateplanted;
    public String cropvariety;
    public String stageofcrop;
    public String fertilizername;
    public Date fertilizerdate;
    public String cropprotection;
    public Date cropprotectiondate;
    public byte[] farmimg;
    public String farmlong;
    public String farmlat;
    public String comments;
    public String uniqueuid;
    public String synstatus;
    public Date datecreated;
    public int serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;

    public FarmAssessment() {
    }

    public FarmAssessment(String farmerid, String farmid, Date dateplanted, String cropvariety, String stageofcrop, String fertilizername, Date fertilizerdate, String cropprotection, Date cropprotectiondate, byte[] farmimg, String farmlong, String farmlat, String comments, String uniqueuid, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.farmid = farmid;
        this.dateplanted = dateplanted;
        this.cropvariety = cropvariety;
        this.stageofcrop = stageofcrop;
        this.fertilizername = fertilizername;
        this.fertilizerdate = fertilizerdate;
        this.cropprotection = cropprotection;
        this.cropprotectiondate = cropprotectiondate;
        this.farmimg = farmimg;
        this.farmlong = farmlong;
        this.farmlat = farmlat;
        this.comments = comments;
        this.uniqueuid = uniqueuid;
        this.synstatus = synstatus;
        this.datecreated = datecreated;
        this.serverid = serverid;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
    }
    public String aggregatorid;

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
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

    public Date getDateplanted() {
        return dateplanted;
    }

    public void setDateplanted(Date dateplanted) {
        this.dateplanted = dateplanted;
    }

    public String getCropvariety() {
        return cropvariety;
    }

    public void setCropvariety(String cropvariety) {
        this.cropvariety = cropvariety;
    }

    public String getStageofcrop() {
        return stageofcrop;
    }

    public void setStageofcrop(String stageofcrop) {
        this.stageofcrop = stageofcrop;
    }

    public String getFertilizername() {
        return fertilizername;
    }

    public void setFertilizername(String fertilizername) {
        this.fertilizername = fertilizername;
    }

    public Date getFertilizerdate() {
        return fertilizerdate;
    }

    public void setFertilizerdate(Date fertilizerdate) {
        this.fertilizerdate = fertilizerdate;
    }

    public String getCropprotection() {
        return cropprotection;
    }

    public void setCropprotection(String cropprotection) {
        this.cropprotection = cropprotection;
    }

    public Date getCropprotectiondate() {
        return cropprotectiondate;
    }

    public void setCropprotectiondate(Date cropprotectiondate) {
        this.cropprotectiondate = cropprotectiondate;
    }

    public byte[] getFarmimg() {
        return farmimg;
    }

    public void setFarmimg(byte[] farmimg) {
        this.farmimg = farmimg;
    }

    public String getFarmlong() {
        return farmlong;
    }

    public void setFarmlong(String farmlong) {
        this.farmlong = farmlong;
    }

    public String getFarmlat() {
        return farmlat;
    }

    public void setFarmlat(String farmlat) {
        this.farmlat = farmlat;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }

    public String getSynstatus() {
        return synstatus;
    }

    public void setSynstatus(String synstatus) {
        this.synstatus = synstatus;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public int getServerid() {
        return serverid;
    }

    public void setServerid(int serverid) {
        this.serverid = serverid;
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
}
