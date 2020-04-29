package com.telpo.usb.finger.serverentities;

import java.util.Date;

public class Declarationinfo implements java.io.Serializable {
    private Integer id;
    private String farmerid;
    private String transid;
    private String couponcode;
    private String paymentmethod;
    private Double totalcost;
    private Double totalCost;
    private Double appliedsub;
    private Double norecoverybags;
    private String declaration;
    private String status;
    private String community;
    private String district;
    private String region;
    private String acreage;
    private Date dates;
    private Date times;
    private String uniqueuid;
    private Date datecreated;
    private String macaddress;
    private String imei;
    private String agentname;
    private String agentid;
    private Integer serverid;
    private String aggregatorid;
    public Declarationinfo() {
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

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
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

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getCouponcode() {
        return couponcode;
    }

    public void setCouponcode(String couponcode) {
        this.couponcode = couponcode;
    }

    public Double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(Double totalcost) {
        this.totalcost = totalcost;
    }

    public Double getAppliedsub() {
        return appliedsub;
    }

    public void setAppliedsub(Double appliedsub) {
        this.appliedsub = appliedsub;
    }

    public Double getNorecoverybags() {
        return norecoverybags;
    }

    public void setNorecoverybags(Double norecoverybags) {
        this.norecoverybags = norecoverybags;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

