package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class PackageItemDetail extends SugarRecord {
    public String inputid;
    public String inputname;
    public int quantity;
    public int price;
    public String packageitemdetailid;
    public String packageid;
    public Date datecrated;

    public PackageItemDetail() {
    }

    public PackageItemDetail(String inputid, String inputname, int quantity, int price, String packageitemdetailid, String packageid, Date datecrated) {
        this.inputid = inputid;
        this.inputname = inputname;
        this.quantity = quantity;
        this.price = price;
        this.packageitemdetailid = packageitemdetailid;
        this.packageid = packageid;
        this.datecrated = datecrated;
    }

    public String getInputid() {
        return inputid;
    }

    public void setInputid(String inputid) {
        this.inputid = inputid;
    }

    public String getInputname() {
        return inputname;
    }

    public void setInputname(String inputname) {
        this.inputname = inputname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPackageitemdetailid() {
        return packageitemdetailid;
    }

    public void setPackageitemdetailid(String packageitemdetailid) {
        this.packageitemdetailid = packageitemdetailid;
    }

    public String getPackageid() {
        return packageid;
    }

    public void setPackageid(String packageid) {
        this.packageid = packageid;
    }

    public Date getDatecrated() {
        return datecrated;
    }

    public void setDatecrated(Date datecrated) {
        this.datecrated = datecrated;
    }
}
