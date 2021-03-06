package com.telpo.usb.finger.entities;
// Generated Dec 14, 2017 8:28:43 PM by Hibernate Tools 4.3.1


import com.orm.SugarRecord;

/**
 * Users generated by hbm2java
 */
public class Users extends SugarRecord {
    public String username;
    public String password;
    public String iv;
    public String key;
    public String firstname;
    public String lastname;
    public String userrole;
    public int tel;
    public String staffid;
    public String email;
    public String address;
    public String community;
    public String district;
    public String region;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;

    public Users() {
    }

    public Users(String username, String password, String firstname, String lastname, String
            userrole, int tel, String email, String address, String community, String district,
                 String region) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userrole = userrole;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.community = community;
        this.district = district;
        this.region = region;
    }

    public Users(String username, String password, String firstname, String lastname, String
            userrole, int tel, String staffid, String email, String address, String community,
                 String district, String region) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userrole = userrole;
        this.tel = tel;
        this.staffid = staffid;
        this.email = email;
        this.address = address;
        this.community = community;
        this.district = district;
        this.region = region;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserrole() {
        return this.userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public int getTel() {
        return this.tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getStaffid() {
        return this.staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommunity() {
        return this.community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


}


