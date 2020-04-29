package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Junior on 12/3/2017.
 */

public class ActivityInfo extends SugarRecord {
    public String farmerid;
    public String groupname;
    public boolean boolgroupname;
    public String coopname;
    public boolean boolcoopname;
    public String incomesource;
    public boolean boolincomesource;
    public String specialtycocoa;
    public boolean boolspecialtycocoa;
    public String certified;
    public boolean boolcertified;
    public String fundingsource;
    public String uniqueuid;
    public String synstatus;
    public Date datecreated;
    public int serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;
    public String aggregatorid;

    public ActivityInfo() {
    }

    public ActivityInfo(String farmerid, String groupname, String coopname, String incomesource,
                        String specialtycocoa, String certified, String fundingsource) {
        this.farmerid = farmerid;
        this.groupname = groupname;
        this.coopname = coopname;
        this.incomesource = incomesource;
        this.specialtycocoa = specialtycocoa;
        this.certified = certified;
        this.fundingsource = fundingsource;
    }

    public ActivityInfo(String farmerid, String groupname, boolean boolgroupname, String coopname, boolean boolcoopname, String incomesource, boolean boolincomesource, String specialtycocoa, boolean boolspecialtycocoa, String certified, boolean boolcertified, String fundingsource, String uniqueuid, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.groupname = groupname;
        this.boolgroupname = boolgroupname;
        this.coopname = coopname;
        this.boolcoopname = boolcoopname;
        this.incomesource = incomesource;
        this.boolincomesource = boolincomesource;
        this.specialtycocoa = specialtycocoa;
        this.boolspecialtycocoa = boolspecialtycocoa;
        this.certified = certified;
        this.boolcertified = boolcertified;
        this.fundingsource = fundingsource;
        this.uniqueuid = uniqueuid;
        this.synstatus = synstatus;
        this.datecreated = datecreated;
        this.serverid = serverid;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
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

    public boolean isBoolgroupname() {
        return boolgroupname;
    }

    public void setBoolgroupname(boolean boolgroupname) {
        this.boolgroupname = boolgroupname;
    }

    public boolean isBoolcoopname() {
        return boolcoopname;
    }

    public void setBoolcoopname(boolean boolcoopname) {
        this.boolcoopname = boolcoopname;
    }

    public boolean isBoolincomesource() {
        return boolincomesource;
    }

    public void setBoolincomesource(boolean boolincomesource) {
        this.boolincomesource = boolincomesource;
    }

    public boolean isBoolspecialtycocoa() {
        return boolspecialtycocoa;
    }

    public void setBoolspecialtycocoa(boolean boolspecialtycocoa) {
        this.boolspecialtycocoa = boolspecialtycocoa;
    }

    public boolean isBoolcertified() {
        return boolcertified;
    }

    public void setBoolcertified(boolean boolcertified) {
        this.boolcertified = boolcertified;
    }

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getCoopname() {
        return coopname;
    }

    public void setCoopname(String coopname) {
        this.coopname = coopname;
    }

    public String getIncomesource() {
        return incomesource;
    }

    public void setIncomesource(String incomesource) {
        this.incomesource = incomesource;
    }

    public String getSpecialtycocoa() {
        return specialtycocoa;
    }

    public void setSpecialtycocoa(String specialtycocoa) {
        this.specialtycocoa = specialtycocoa;
    }

    public String getCertified() {
        return certified;
    }

    public void setCertified(String certified) {
        this.certified = certified;
    }

    public String getFundingsource() {
        return fundingsource;
    }

    public void setFundingsource(String fundingsource) {
        this.fundingsource = fundingsource;
    }
}
