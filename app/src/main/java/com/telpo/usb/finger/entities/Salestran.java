package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class Salestran extends SugarRecord {
    public String farmerid;
    public String transactionid;
    public double totalCost;
    public String couponcode;
    public double appliedsub;
    public double payableamt;
    public String paymentmethod;
    public double tendered;
    public double norecoverybags;
    public String community;
    public String district;
    public String region;
    public String acreage;
    public Date dates;
    public Date times;
    public String uniqueuid;
    public String synstatus;
    public Date datecreated;
    public int serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;

    public Salestran() {
    }

    public Salestran(String farmerid, String transactionid, double totalCost, String couponcode, double appliedsub, double payableamt, String paymentmethod, double tendered, double norecoverybags, String community, String district, String region, String acreage, Date dates, Date times, String uniqueuid, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.transactionid = transactionid;
        this.totalCost = totalCost;
        this.couponcode = couponcode;
        this.appliedsub = appliedsub;
        this.payableamt = payableamt;
        this.paymentmethod = paymentmethod;
        this.tendered = tendered;
        this.norecoverybags = norecoverybags;
        this.community = community;
        this.district = district;
        this.region = region;
        this.acreage = acreage;
        this.dates = dates;
        this.times = times;
        this.uniqueuid = uniqueuid;
        this.datecreated = datecreated;
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

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getCouponcode() {
        return couponcode;
    }

    public void setCouponcode(String couponcode) {
        this.couponcode = couponcode;
    }

    public double getAppliedsub() {
        return appliedsub;
    }

    public void setAppliedsub(double appliedsub) {
        this.appliedsub = appliedsub;
    }

    public double getPayableamt() {
        return payableamt;
    }

    public void setPayableamt(double payableamt) {
        this.payableamt = payableamt;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public double getTendered() {
        return tendered;
    }

    public void setTendered(double tendered) {
        this.tendered = tendered;
    }

    public double getNorecoverybags() {
        return norecoverybags;
    }

    public void setNorecoverybags(double norecoverybags) {
        this.norecoverybags = norecoverybags;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }
}
