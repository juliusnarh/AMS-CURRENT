package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class Household extends SugarRecord {
    public String farmerid;
    public String householdid;
    public String relationship;
    public String syncstatus;
    public Date datecreated;
    public String uniqueuid;
    public int serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;

    public Household(String farmerid, String householdid, String relationship, String syncstatus, Date datecreated, String uniqueuid, int serverid, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.householdid = householdid;
        this.relationship = relationship;
        this.syncstatus = syncstatus;
        this.datecreated = datecreated;
        this.uniqueuid = uniqueuid;
        this.serverid = serverid;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
    }

    public Household() {
    }

    public String aggregatorid;

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

    public int getServerid() {
        return serverid;
    }

    public void setServerid(int serverid) {
        this.serverid = serverid;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getHouseholdid() {
        return householdid;
    }

    public void setHouseholdid(String householdid) {
        this.householdid = householdid;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getSyncstatus() {
        return syncstatus;
    }

    public void setSyncstatus(String syncstatus) {
        this.syncstatus = syncstatus;
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