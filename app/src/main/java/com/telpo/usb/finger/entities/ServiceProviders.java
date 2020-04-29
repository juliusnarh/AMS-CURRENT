package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

/**
 * Created by Junior on 12/3/2017.
 */

public class ServiceProviders extends SugarRecord {
    public String providerid;
    public String provider;
    public String servicedesc;
    public String contact;


    public ServiceProviders() {
    }

    public ServiceProviders(String providerid, String provider, String servicedesc, String contact) {
        this.providerid = providerid;
        this.provider = provider;
        this.servicedesc = servicedesc;
        this.contact = contact;
    }

    public String getProviderid() {
        return providerid;
    }

    public void setProviderid(String providerid) {
        this.providerid = providerid;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getServicedesc() {
        return servicedesc;
    }

    public void setServicedesc(String servicedesc) {
        this.servicedesc = servicedesc;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
