package com.telpo.usb.finger.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rebekkah_Boamah on 10/26/2017.
 */

public class GetServerSearchFarmerInfo {
//    public String farm_id;
//    public String farmer_id;
//    public String loc;

    @SerializedName("image")
    String img;

    String name;
//    public String surname;
//    public String othername;
//
//    public byte[] photo;

    @SerializedName("tel")
    String telephone;

    String community;
    String farmerid;

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCommunity() {
        return community;
    }

    public String getFarmerid() {
        return farmerid;
    }
}
