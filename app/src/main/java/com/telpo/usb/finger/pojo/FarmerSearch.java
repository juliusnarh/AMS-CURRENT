/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telpo.usb.finger.pojo;

import java.io.Serializable;

/**
 * @author Junior
 */
public class FarmerSearch implements Serializable {
    private String farmerid;
    private String surname;
    private String othernames;
    private String picturename;
    private String tel;

    /**
     * @return the farmerid
     */
    public String getFarmerid() {
        return farmerid;
    }

    /**
     * @param farmerid the farmerid to set
     */
    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the othernames
     */
    public String getOthernames() {
        return othernames;
    }

    /**
     * @param othernames the othernames to set
     */
    public void setOthernames(String othernames) {
        this.othernames = othernames;
    }

    /**
     * @return the picturename
     */
    public String getPicturename() {
        return picturename;
    }

    /**
     * @param picturename the picturename to set
     */
    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

}
