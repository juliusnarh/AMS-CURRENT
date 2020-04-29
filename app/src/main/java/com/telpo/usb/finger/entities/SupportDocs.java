package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Junior on 12/15/2017.
 */

public class SupportDocs extends SugarRecord {
    public String farmerid;
    public String documenttype;
    public byte[] document;
    public String uniqueuid;
    public Date datecreated;
    public String synstatus;
    public int serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;

    public SupportDocs(String farmerid, String documenttype, byte[] document, String uniqueuid, Date datecreated, String synstatus, int serverid, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.documenttype = documenttype;
        this.document = document;
        this.uniqueuid = uniqueuid;
        this.datecreated = datecreated;
        this.synstatus = synstatus;
        this.serverid = serverid;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
    }

    public SupportDocs() {
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

    public String getDocumenttype() {
        return documenttype;
    }

    public void setDocumenttype(String documenttype) {
        this.documenttype = documenttype;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }
}
