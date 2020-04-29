package com.telpo.usb.finger.pojo;

import java.io.Serializable;

/**
 * Created by Junior on 12/5/2017.
 */

public class FingerprintPojo implements Serializable {
    private int fingerprintId;
    private byte[] fingerprint;
    private byte[] fingertemplate;
    private String fingertype;
    private boolean completed;

    public FingerprintPojo() {
    }

    /**
     * @param fingerprint    fingerprint image
     * @param fingertemplate fingerprint template data
     * @param fingertype     fingertype
     * @param completed      completed status
     */
    public FingerprintPojo(byte[] fingerprint, byte[] fingertemplate, String fingertype, boolean completed) {
        this.fingerprint = fingerprint;
        this.fingertemplate = fingertemplate;
        this.fingertype = fingertype;
        this.completed = completed;
    }

    public FingerprintPojo(byte[] fingerprint, String fingertype, boolean completed) {
        this.fingerprint = fingerprint;
        this.fingertype = fingertype;
        this.completed = completed;
    }

    public FingerprintPojo(int fingerprintId, byte[] fingerprint, byte[] fingertemplate, String fingertype) {
        this.fingerprintId = fingerprintId;
        this.fingerprint = fingerprint;
        this.fingertemplate = fingertemplate;
        this.fingertype = fingertype;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getFingerprintId() {
        return fingerprintId;
    }

    public void setFingerprintId(int fingerprintId) {
        this.fingerprintId = fingerprintId;
    }

    public byte[] getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(byte[] fingerprint) {
        this.fingerprint = fingerprint;
    }

    public byte[] getFingertemplate() {
        return fingertemplate;
    }

    public void setFingertemplate(byte[] fingertemplate) {
        this.fingertemplate = fingertemplate;
    }

    public String getFingertype() {
        return fingertype;
    }

    public void setFingertype(String fingertype) {
        this.fingertype = fingertype;
    }
}
