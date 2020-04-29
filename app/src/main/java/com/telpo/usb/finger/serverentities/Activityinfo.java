package com.telpo.usb.finger.serverentities;
// Generated Jun 30, 2018 8:14:16 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Activityinfo generated by hbm2java
 */

public class Activityinfo implements java.io.Serializable {


    private Integer id;
    private String farmerid;
    private String uniqueuid;
    private String groupname;
    private String cooperative;
    private String specialtycrop;
    private String incomesource;
    private Date createddate;
    private String agentid;
    private String agentname;
    private String imei;
    private String macaddress;
    private String fundingsource;
    private Integer serverid;
    private String aggregatorid;

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }

    public Activityinfo() {
    }

    public Integer getServerid() {
        return serverid;
    }

    public void setServerid(Integer serverid) {
        this.serverid = serverid;
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

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getCooperative() {
        return cooperative;
    }

    public void setCooperative(String cooperative) {
        this.cooperative = cooperative;
    }

    public String getSpecialtycrop() {
        return specialtycrop;
    }

    public void setSpecialtycrop(String specialtycrop) {
        this.specialtycrop = specialtycrop;
    }

    public String getIncomesource() {
        return incomesource;
    }

    public void setIncomesource(String incomesource) {
        this.incomesource = incomesource;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getFundingsource() {
        return fundingsource;
    }

    public void setFundingsource(String fundingsource) {
        this.fundingsource = fundingsource;
    }

    @Override
    public String toString() {
        return "Activityinfo{" +
                "id=" + id +
                ", farmerid='" + farmerid + '\'' +
                ", uniqueuid='" + uniqueuid + '\'' +
                ", groupname='" + groupname + '\'' +
                ", cooperative='" + cooperative + '\'' +
                ", specialtycrop='" + specialtycrop + '\'' +
                ", incomesource='" + incomesource + '\'' +
                ", createddate=" + createddate +
                ", agentid='" + agentid + '\'' +
                ", agentname='" + agentname + '\'' +
                ", imei='" + imei + '\'' +
                ", macaddress='" + macaddress + '\'' +
                ", fundingsource='" + fundingsource + '\'' +
                '}';
    }
}

