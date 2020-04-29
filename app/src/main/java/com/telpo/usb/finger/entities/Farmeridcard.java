package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Junior on 12/15/2017.
 */

public class Farmeridcard extends SugarRecord {

    public String farmerid;
    public String idtype;
    public String idnumber;
    public byte[] idimage;
    public String uniqueuid;
    public Date datecreated;
    public String synstatus;
    public int serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;

    public Farmeridcard(String farmerid, String idtype, String idnumber, byte[] idimage, String uniqueuid, Date datecreated, String synstatus, int serverid, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.idtype = idtype;
        this.idnumber = idnumber;
        this.idimage = idimage;
        this.uniqueuid = uniqueuid;
        this.datecreated = datecreated;
        this.synstatus = synstatus;
        this.serverid = serverid;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
    }

    public Farmeridcard() {
    }

    public Farmeridcard(String farmerid, String idtype, String idnumber, byte[] idimage, String
            uniqueuid) {
        this.farmerid = farmerid;
        this.idtype = idtype;
        this.idnumber = idnumber;
        this.idimage = idimage;
        this.uniqueuid = uniqueuid;
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

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public byte[] getIdimage() {
        return idimage;
    }

    public void setIdimage(byte[] idimage) {
        this.idimage = idimage;
    }

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }
}
