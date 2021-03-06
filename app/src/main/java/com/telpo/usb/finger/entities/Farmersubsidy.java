package com.telpo.usb.finger.entities;
// Generated Dec 14, 2017 8:28:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Farmersubsidy generated by hbm2java
 */
public class Farmersubsidy implements java.io.Serializable {


    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;
    private Integer id;
    private String farmerid;
    private BigDecimal totalsubsidy;
    private BigDecimal appliedsubsidy;
    private BigDecimal balance;
    private Date dates;

    public Farmersubsidy() {
    }

    public Farmersubsidy(String farmerid, BigDecimal totalsubsidy, BigDecimal appliedsubsidy, BigDecimal balance, Date dates) {
        this.farmerid = farmerid;
        this.totalsubsidy = totalsubsidy;
        this.appliedsubsidy = appliedsubsidy;
        this.balance = balance;
        this.dates = dates;
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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFarmerid() {
        return this.farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public BigDecimal getTotalsubsidy() {
        return this.totalsubsidy;
    }

    public void setTotalsubsidy(BigDecimal totalsubsidy) {
        this.totalsubsidy = totalsubsidy;
    }

    public BigDecimal getAppliedsubsidy() {
        return this.appliedsubsidy;
    }

    public void setAppliedsubsidy(BigDecimal appliedsubsidy) {
        this.appliedsubsidy = appliedsubsidy;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getDates() {
        return this.dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }


}


