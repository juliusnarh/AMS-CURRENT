package com.telpo.usb.finger.entities;
// Generated Dec 14, 2017 8:28:43 PM by Hibernate Tools 4.3.1


import com.orm.SugarRecord;

import java.util.Date;

/**
 * Userfingerprint generated by hbm2java
 */
public class Userfingerprint extends SugarRecord {
    public String farmerid;
    public byte[] fingerprint;
    public String fingertype;
    public Date entrydate;
    public byte[] fingerprinttemplate;
    public String duplicatestatus;
    public String uniqueuid;
    public String synstatus;
    public Date datecreated;
    public int serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;

    public Userfingerprint(String farmerid, byte[] fingerprint, String fingertype, Date entrydate, byte[] fingerprinttemplate, String duplicatestatus, String uniqueuid, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.fingerprint = fingerprint;
        this.fingertype = fingertype;
        this.entrydate = entrydate;
        this.fingerprinttemplate = fingerprinttemplate;
        this.duplicatestatus = duplicatestatus;
        this.uniqueuid = uniqueuid;
        this.synstatus = synstatus;
        this.datecreated = datecreated;
        this.serverid = serverid;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
    }

    public Userfingerprint() {
    }
    public String aggregatorid;

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }
    public Userfingerprint(String farmerid, byte[] fingerprint, String fingertype, Date entrydate, byte[] fingerprinttemplate, String duplicatestatus, String uniqueuid) {
        this.farmerid = farmerid;
        this.fingerprint = fingerprint;
        this.fingertype = fingertype;
        this.entrydate = entrydate;
        this.fingerprinttemplate = fingerprinttemplate;
        this.duplicatestatus = duplicatestatus;
        this.uniqueuid = uniqueuid;
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

    public String getFarmerid() {
        return this.farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public byte[] getFingerprint() {
        return this.fingerprint;
    }

    public void setFingerprint(byte[] fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getFingertype() {
        return this.fingertype;
    }

    public void setFingertype(String fingertype) {
        this.fingertype = fingertype;
    }

    public Date getEntrydate() {
        return this.entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public byte[] getFingerprinttemplate() {
        return this.fingerprinttemplate;
    }

    public void setFingerprinttemplate(byte[] fingerprinttemplate) {
        this.fingerprinttemplate = fingerprinttemplate;
    }

    public String getDuplicatestatus() {
        return this.duplicatestatus;
    }

    public void setDuplicatestatus(String duplicatestatus) {
        this.duplicatestatus = duplicatestatus;
    }

    public String getUniqueuid() {
        return this.uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }


}


