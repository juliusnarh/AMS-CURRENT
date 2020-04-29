package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class Sales extends SugarRecord {
    public String farmerid;
    public String transactionid;
    public String pid;
    public String pname;
    public String category;
    public double uprice;
    public int quantity;
    public double totalcost;
    public String users;
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

    public Sales() {
    }

    public Sales(String farmerid, String transactionid, String pid, String pname, String category, double uprice, int quantity, double totalcost, String users, Date dates, Date times, String uniqueuid, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.transactionid = transactionid;
        this.pid = pid;
        this.pname = pname;
        this.category = category;
        this.uprice = uprice;
        this.quantity = quantity;
        this.totalcost = totalcost;
        this.users = users;
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
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getUprice() {
        return uprice;
    }

    public void setUprice(double uprice) {
        this.uprice = uprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(double totalcost) {
        this.totalcost = totalcost;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
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
