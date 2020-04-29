package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class Scaletran extends SugarRecord {
    public String transid;
    public String farmerid;
    public String scaleid;
    public String pcid;
    public String bcid;
    public String name;
    public String phone;
    public String payable;
    public String tendered;
    public double count;
    public double weight;
    public double moisturecontent;
    public double amount;
    public Date time;
    public Date date;
    public String uniqueuid;
    public String synstatus;
    public Date datecreated;
    public int serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;

    public Scaletran() {
    }

    public Scaletran(String transid, String farmerid, String scaleid, String pcid, String bcid, String name, String phone, String payable, String tendered, double count, double weight, double moisturecontent, double amount, Date time, Date date, String uniqueuid, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid) {
        this.transid = transid;
        this.farmerid = farmerid;
        this.scaleid = scaleid;
        this.pcid = pcid;
        this.bcid = bcid;
        this.name = name;
        this.phone = phone;
        this.payable = payable;
        this.tendered = tendered;
        this.count = count;
        this.weight = weight;
        this.moisturecontent = moisturecontent;
        this.amount = amount;
        this.time = time;
        this.date = date;
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
    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getScaleid() {
        return scaleid;
    }

    public void setScaleid(String scaleid) {
        this.scaleid = scaleid;
    }

    public String getPcid() {
        return pcid;
    }

    public void setPcid(String pcid) {
        this.pcid = pcid;
    }

    public String getBcid() {
        return bcid;
    }

    public void setBcid(String bcid) {
        this.bcid = bcid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPayable() {
        return payable;
    }

    public void setPayable(String payable) {
        this.payable = payable;
    }

    public String getTendered() {
        return tendered;
    }

    public void setTendered(String tendered) {
        this.tendered = tendered;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMoisturecontent() {
        return moisturecontent;
    }

    public void setMoisturecontent(double moisturecontent) {
        this.moisturecontent = moisturecontent;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

//    public double getSubsidy() {
//        return subsidy;
//    }
//
//    public void setSubsidy(double subsidy) {
//        this.subsidy = subsidy;
//    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
