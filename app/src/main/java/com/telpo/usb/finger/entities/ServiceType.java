package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

public class ServiceType extends SugarRecord {
    public String servicetype;
    public String servicetypecode;
    public String uniqueuid;

    public ServiceType() {
    }

    public ServiceType(String servicetype, String servicetypecode, String uniqueuid) {
        this.servicetype = servicetype;
        this.servicetypecode = servicetypecode;
        this.uniqueuid = uniqueuid;
    }

    public String getServicetypecode() {
        return servicetypecode;
    }

    public void setServicetypecode(String servicetypecode) {
        this.servicetypecode = servicetypecode;
    }

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }
}
