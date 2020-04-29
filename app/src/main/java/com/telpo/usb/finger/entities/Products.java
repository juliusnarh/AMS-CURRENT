package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class Products extends SugarRecord {

    public String category;
    public String pname;
    public String pdesc;
    public String pid;
    public String quantity;
    public String price;
    public String supplier;
    public String unitm;
    public String subprice;
    public byte[] item_img;
    public String uniqueuid;
    public String synstatus;
    public Date datecreated;
    public int serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;

    public Products() {
    }

    public Products(String category, String pname, String pdesc, String pid, String quantity, String price, String supplier, String unitm, String subprice, byte[] item_img, String uniqueuid, String synstatus, Date datecreated, String macaddress, String imei, String agentname, String agentid) {
        this.category = category;
        this.pname = pname;
        this.pdesc = pdesc;
        this.pid = pid;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
        this.unitm = unitm;
        this.subprice = subprice;
        this.item_img = item_img;
        this.uniqueuid = uniqueuid;
        this.synstatus = synstatus;
        this.datecreated = datecreated;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
    }

    public String getUnitm() {
        return unitm;
    }

    public void setUnitm(String unitm) {
        this.unitm = unitm;
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

    public String getSubprice() {
        return subprice;
    }

    public void setSubprice(String subprice) {
        this.subprice = subprice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public byte[] getItem_img() {
        return item_img;
    }

    public void setItem_img(byte[] item_img) {
        this.item_img = item_img;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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
