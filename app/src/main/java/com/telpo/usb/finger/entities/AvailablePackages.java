package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class AvailablePackages extends SugarRecord {
    public String packagename;
    public String recoverybagsperacre;
    public String contract;
    public Date datecreated;

    public AvailablePackages() {
    }

    public AvailablePackages(String packagename, Date datecreated, String recoverybagsperacre, String contract) {
        this.packagename = packagename;
        this.contract = contract;
        this.datecreated = datecreated;
        this.recoverybagsperacre = recoverybagsperacre;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
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
}
