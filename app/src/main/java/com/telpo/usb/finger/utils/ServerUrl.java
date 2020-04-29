package com.telpo.usb.finger.utils;

/**
 * Created by Rebekkah_Boamah on 10/25/2017.
 */

public class ServerUrl {
    public static String BASEURL = "http://u-clinks.com/UCLCocoa/cocoa/android/";
    // String BASEURL = "http://10.106.7.212/UCLCocoa/cocoa/android/";
    public static String uploadUrl = BASEURL + "farmerregister.php";

    public static String searchFarm() {
        return BASEURL + "function/Farmer.php";
    }

    public static String readProfile() {
        return BASEURL + "function/farmerProfile.php";
    }

    public static String getFarm() {
        return BASEURL + "function/farm.php";
    }

    public static String readFarm() {
        return BASEURL + "function/readFarm.php";
    }

    public static String getHseHold() {
        return BASEURL + "function/readHouseHold.php";
    }

    public static String addFarmer() {
        return BASEURL + "function/addFarmer.php";
    }

    public static String addFarm() {
        return BASEURL + "function/addFarm.php";
    }

    public static String addHouseHold() {
        return BASEURL + "function/addHouseHold.php";
    }

    public static String lgoi() {
        return BASEURL + "function/Loggin.php";
    }

    public static String logout() {
        return BASEURL + "function/Logout.php";
    }

    public static String addLBC() {
        return BASEURL + "function/lbc.php";
    }

    public static String loadlbc() {
        return BASEURL + "function/getlbc.php";
    }
}
