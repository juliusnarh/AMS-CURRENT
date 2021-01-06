package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class Packages extends SugarRecord {
    public String packageid;
    public String packagename;
    public String acreage;
    public String packageitemdetailsids;
    public String numberofitems;
    public Date datecrated;

    public Packages() {
    }

    public Packages(String packageid, String packagename, String packageitemdetailsids, Date datecrated, String acreage, String numberofitems) {
        this.packageid = packageid;
        this.packagename = packagename;
        this.acreage = acreage;
        this.numberofitems = numberofitems;
        this.packageitemdetailsids = packageitemdetailsids;
        this.datecrated = datecrated;
    }

    public String getNumberofitems() {
        return numberofitems;
    }

    public void setNumberofitems(String numberofitems) {
        this.numberofitems = numberofitems;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getPackageid() {
        return packageid;
    }

    public void setPackageid(String packageid) {
        this.packageid = packageid;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getPackageitemdetailsids() {
        return packageitemdetailsids;
    }

    public void setPackageitemdetailsids(String packageitemdetailsids) {
        this.packageitemdetailsids = packageitemdetailsids;
    }

    public Date getDatecrated() {
        return datecrated;
    }

    public void setDatecrated(Date datecrated) {
        this.datecrated = datecrated;
    }
}
