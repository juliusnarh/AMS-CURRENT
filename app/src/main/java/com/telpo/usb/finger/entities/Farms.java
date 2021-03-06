package com.telpo.usb.finger.entities;
// Generated Dec 14, 2017 8:28:43 PM by Hibernate Tools 4.3.1


import com.orm.SugarRecord;

import java.util.Date;

/**
 * Farms generated by hbm2java
 */
public class Farms extends SugarRecord {
    public String farmid;
    public String farmerid;
    public String location;
    public String district;
    public String region;
    public String community;
    public String yearofestablishment;
    public String totalarea;
    public String cultivatedarea;
    public String shadetrees;
    public String ownership;
    public String typeoffarm;
    public String plantingmaterial;
    public String othersource;
    public String labour;
    public String qextension;
    public String extension;
    public String organisation;
    public String qactivities;
    public String activities;
    public String farmimage;
    public String geocord;
    public String long_;
    public String uniqueuid;
    public String synstatus;
    public Date   datecreated;
    public int    serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;
    public String cropvariety;
    public String fertilizerused;
    public String farmyield;
    public String cropprotection;
    public String chemicalused;


//    public int id;


    public Farms(String farmid, String farmerid, String location, String district, String region, String community, String yearofestablishment, String totalarea, String cultivatedarea, String shadetrees, String ownership, String typeoffarm, String plantingmaterial, String othersource, String labour, String qextension, String extension, String organisation, String qactivities, String activities, String farmimage, String geocord, String long_, String uniqueuid, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid, String cropvariety, String fertilizerused, String farmyield, String cropprotection, String chemicalused) {
        this.farmid = farmid;
        this.farmerid = farmerid;
        this.location = location;
        this.district = district;
        this.region = region;
        this.community = community;
        this.yearofestablishment = yearofestablishment;
        this.totalarea = totalarea;
        this.cultivatedarea = cultivatedarea;
        this.shadetrees = shadetrees;
        this.ownership = ownership;
        this.typeoffarm = typeoffarm;
        this.plantingmaterial = plantingmaterial;
        this.othersource = othersource;
        this.labour = labour;
        this.qextension = qextension;
        this.extension = extension;
        this.organisation = organisation;
        this.qactivities = qactivities;
        this.activities = activities;
        this.farmimage = farmimage;
        this.geocord = geocord;
        this.long_ = long_;
        this.uniqueuid = uniqueuid;
        this.synstatus = synstatus;
        this.datecreated = datecreated;
        this.serverid = serverid;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
        this.cropvariety = cropvariety;
        this.fertilizerused = fertilizerused;
        this.farmyield = farmyield;
        this.cropprotection = cropprotection;
        this.chemicalused = chemicalused;
    }

    public Farms() {

    }

    public Farms(String farmid, String farmerid, String location, String district, String region, String community, String yearofestablishment, String totalarea, String cultivatedarea, String shadetrees, String ownership, String typeoffarm, String plantingmaterial, String othersource, String labour, String qextension, String extension, String organisation, String qactivities, String activities, String farmimage, String geocord, String long_) {
        this.farmid = farmid;
        this.farmerid = farmerid;
        this.location = location;
        this.district = district;
        this.region = region;
        this.community = community;
        this.yearofestablishment = yearofestablishment;
        this.totalarea = totalarea;
        this.cultivatedarea = cultivatedarea;
        this.shadetrees = shadetrees;
        this.ownership = ownership;
        this.typeoffarm = typeoffarm;
        this.plantingmaterial = plantingmaterial;
        this.othersource = othersource;
        this.labour = labour;
        this.qextension = qextension;
        this.extension = extension;
        this.organisation = organisation;
        this.qactivities = qactivities;
        this.activities = activities;
        this.farmimage = farmimage;
        this.geocord = geocord;
        this.long_ = long_;
    }
    public String aggregatorid;

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }
    public String getFarmyield() {
        return farmyield;
    }

    public void setFarmyield(String farmyield) {
        this.farmyield = farmyield;
    }

    public String getCropprotection() {
        return cropprotection;
    }

    public void setCropprotection(String cropprotection) {
        this.cropprotection = cropprotection;
    }

    public String getChemicalused() {
        return chemicalused;
    }

    public void setChemicalused(String chemicalused) {
        this.chemicalused = chemicalused;
    }

    public String getFertilizerused() {
        return fertilizerused;
    }

    public void setFertilizerused(String fertilizerused) {
        this.fertilizerused = fertilizerused;
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

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getSynstatus() {
        return synstatus;
    }

    public void setSynstatus(String synstatus) {
        this.synstatus = synstatus;
    }

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }

    public String getFarmid() {
        return this.farmid;
    }

    public void setFarmid(String farmid) {
        this.farmid = farmid;
    }

    public String getFarmerid() {
        return this.farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCommunity() {
        return this.community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getYearofestablishment() {
        return this.yearofestablishment;
    }

    public void setYearofestablishment(String yearofestablishment) {
        this.yearofestablishment = yearofestablishment;
    }

    public String getTotalarea() {
        return this.totalarea;
    }

    public void setTotalarea(String totalarea) {
        this.totalarea = totalarea;
    }

    public String getCultivatedarea() {
        return this.cultivatedarea;
    }

    public void setCultivatedarea(String cultivatedarea) {
        this.cultivatedarea = cultivatedarea;
    }

    public String getShadetrees() {
        return this.shadetrees;
    }

    public void setShadetrees(String shadetrees) {
        this.shadetrees = shadetrees;
    }

    public String getOwnership() {
        return this.ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getTypeoffarm() {
        return this.typeoffarm;
    }

    public void setTypeoffarm(String typeoffarm) {
        this.typeoffarm = typeoffarm;
    }

    public String getPlantingmaterial() {
        return this.plantingmaterial;
    }

    public void setPlantingmaterial(String plantingmaterial) {
        this.plantingmaterial = plantingmaterial;
    }

    public String getOthersource() {
        return this.othersource;
    }

    public void setOthersource(String othersource) {
        this.othersource = othersource;
    }

    public String getLabour() {
        return this.labour;
    }

    public void setLabour(String labour) {
        this.labour = labour;
    }

    public String getQextension() {
        return this.qextension;
    }

    public void setQextension(String qextension) {
        this.qextension = qextension;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getOrganisation() {
        return this.organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getQactivities() {
        return this.qactivities;
    }

    public void setQactivities(String qactivities) {
        this.qactivities = qactivities;
    }

    public String getActivities() {
        return this.activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getFarmimage() {
        return this.farmimage;
    }

    public void setFarmimage(String farmimage) {
        this.farmimage = farmimage;
    }

    public String getGeocord() {
        return this.geocord;
    }

    public void setGeocord(String geocord) {
        this.geocord = geocord;
    }

    public String getLong_() {
        return this.long_;
    }

    public void setLong_(String long_) {
        this.long_ = long_;
    }

    public String getCropvariety() {
        return cropvariety;
    }

    public void setCropvariety(String cropvariety) {
        this.cropvariety = cropvariety;
    }
}


