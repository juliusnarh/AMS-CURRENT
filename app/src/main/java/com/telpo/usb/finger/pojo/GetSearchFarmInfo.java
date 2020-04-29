package com.telpo.usb.finger.pojo;

/**
 * Created by Rebekkah_Boamah on 10/26/2017.
 */

public class GetSearchFarmInfo {
    private String farm_id;
    private String loc;
    private String img;


    GetSearchFarmInfo(String farm_id, String loc, String img) {
        this.farm_id = farm_id;
        this.loc = loc;
        this.img = img;
    }

    public String getFarm_id() {
        return farm_id;
    }

    public void setFarm_id(String farm_id) {
        this.farm_id = farm_id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
