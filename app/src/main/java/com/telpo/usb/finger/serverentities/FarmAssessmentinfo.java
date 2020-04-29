package com.telpo.usb.finger.serverentities;


import java.util.Date;

public class FarmAssessmentinfo implements java.io.Serializable {
    private Integer id;
    private String farmerid;
    private String farmid;
    private Date dateplanted;
    private String cropvariety;
    private String stageofcrop;
    private String fertilizername;
    private Date fertilizerdate;
    private String cropprotection;
    private Date cropprotectiondate;
    private byte[] farmimg;
    private String farmlong;
    private String farmlat;
    private String comments;
    private String uniqueuid;
    private String synstatus;
    private Date datecreated;
    private String macaddress;
    private String imei;
    private String agentname;
    private String agentid;
    private Integer serverid;
    private String aggregatorid;
    public FarmAssessmentinfo() {

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
