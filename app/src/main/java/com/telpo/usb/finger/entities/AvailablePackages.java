package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class AvailablePackages extends SugarRecord {
    public String packagename;
    public String recoverybagsperacre;
    public String contract;
    public Date datecreated;
    public String packageid;

    public AvailablePackages() {
    }

    public AvailablePackages(String packagename, String recoverybagsperacre, String contract, Date datecreated, String packageid) {
        this.packagename = packagename;
        this.recoverybagsperacre = recoverybagsperacre;
        this.contract = contract;
        this.datecreated = datecreated;
        this.packageid = packageid;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getRecoverybagsperacre() {
        return recoverybagsperacre;
    }

    public void setRecoverybagsperacre(String recoverybagsperacre) {
        this.recoverybagsperacre = recoverybagsperacre;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getPackageid() {
        return packageid;
    }

    public void setPackageid(String packageid) {
        this.packageid = packageid;
    }
}
