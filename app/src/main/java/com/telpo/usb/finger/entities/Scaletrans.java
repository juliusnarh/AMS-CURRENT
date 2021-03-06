package com.telpo.usb.finger.entities;
// Generated Dec 14, 2017 8:28:43 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Scaletrans generated by hbm2java
 */
public class Scaletrans implements java.io.Serializable {


    public int id;
    public String scaleid;
    public String imei;
    public String rfid;
    public String farmerid;
    public String name;
    public Date date;
    public Date time;
    public Integer counts;
    public Double weight;
    public Double total;
    public String bcid;
    public String pcid;

    public Scaletrans() {
    }


    public Scaletrans(int id, String scaleid, String farmerid) {
        this.id = id;
        this.scaleid = scaleid;
        this.farmerid = farmerid;
    }

    public Scaletrans(int id, String scaleid, String imei, String rfid, String farmerid, String name, Date date, Date time, Integer counts, Double weight, Double total, String bcid, String pcid) {
        this.id = id;
        this.scaleid = scaleid;
        this.imei = imei;
        this.rfid = rfid;
        this.farmerid = farmerid;
        this.name = name;
        this.date = date;
        this.time = time;
        this.counts = counts;
        this.weight = weight;
        this.total = total;
        this.bcid = bcid;
        this.pcid = pcid;
    }
    public String aggregatorid;

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScaleid() {
        return this.scaleid;
    }

    public void setScaleid(String scaleid) {
        this.scaleid = scaleid;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getRfid() {
        return this.rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getFarmerid() {
        return this.farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getCounts() {
        return this.counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getBcid() {
        return this.bcid;
    }

    public void setBcid(String bcid) {
        this.bcid = bcid;
    }

    public String getPcid() {
        return this.pcid;
    }

    public void setPcid(String pcid) {
        this.pcid = pcid;
    }


}


