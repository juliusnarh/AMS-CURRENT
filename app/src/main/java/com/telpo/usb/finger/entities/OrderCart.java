package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class OrderCart extends SugarRecord {

    public String farmerid;
    public String pid;
    public String orderid;
    public String inputName;
    public String quantity;
    public String price;
    public String sprice;
    public String inputCategory;
    public byte[] inputImg;
    public String uniqueuid;
    public Date datecreated;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;

    public OrderCart() {
    }

    public OrderCart(String farmerid, String pid, String orderid, String inputName, String quantity, String price, String sprice, String inputCategory, byte[] inputImg, String uniqueuid, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.pid = pid;
        this.orderid = orderid;
        this.inputName = inputName;
        this.quantity = quantity;
        this.price = price;
        this.sprice = sprice;
        this.inputCategory = inputCategory;
        this.inputImg = inputImg;
        this.uniqueuid = uniqueuid;
        this.datecreated = datecreated;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getSprice() {
        return sprice;
    }

    public void setSprice(String sprice) {
        this.sprice = sprice;
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

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public Date getDate_created() {
        return datecreated;
    }

    public void setDate_created(Date date_created) {
        this.datecreated = date_created;
    }

    public String getInputCategory() {
        return inputCategory;
    }

    public void setInputCategory(String inputCategory) {
        this.inputCategory = inputCategory;
    }

    public byte[] getInputImg() {
        return inputImg;
    }

    public void setInputImg(byte[] inputImg) {
        this.inputImg = inputImg;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
