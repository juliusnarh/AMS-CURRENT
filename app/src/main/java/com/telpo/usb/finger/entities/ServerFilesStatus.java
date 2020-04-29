package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class ServerFilesStatus extends SugarRecord {
    public String url;
    public boolean status;

    public ServerFilesStatus() {
    }

    public ServerFilesStatus(String url, boolean status) {
        this.url = url;
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
