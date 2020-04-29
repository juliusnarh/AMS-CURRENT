package com.telpo.usb.finger.entities;
// Generated Dec 14, 2017 8:28:43 PM by Hibernate Tools 4.3.1


import com.orm.SugarRecord;

import java.util.Date;

/**
 * Farmers generated by hbm2java
 */
public class Farmers extends SugarRecord {
    public String farmerid;
    public String surname;
    public String othername;
    public String placeofbirth;
    public Date dateofbirth;
    public Integer age;
    public String gender;
    public String hometown;
    public String address;
    public String district;
    public String region;
    public String country;
    public String idcardtype;
    public String idcardno;
    public String levelofeducation;
    public String religion;
    public String maritalstatus;
    public String nextofkin;
    public String relation;
    public String qfarmergroup;
    public String farmergroup;
    public String qcooperative;
    public String cooperative;
    public String qincomesource;
    public String incomesource;
    public String qspecialty;
    public String specialty;
    public String certification;
    public String funding;
    public String imagelink;
    public String community;
    public String tel;
    public String email;
    public String uniqueuid;
    public String postbox;
    public String synstatus;
    public Date datecreated;
    public int serverid;
    public String macaddress;
    public String imei;
    public String agentname;
    public String agentid;
    public boolean isSelected = false;


    public Farmers() {
    }

    public Farmers(String farmerid, String surname, String othername, String placeofbirth, Date dateofbirth, Integer age, String gender, String hometown, String address, String district, String region, String country, String idcardtype, String idcardno, String levelofeducation, String religion, String maritalstatus, String nextofkin, String relation, String qfarmergroup, String farmergroup, String qcooperative, String cooperative, String qincomesource, String incomesource, String qspecialty, String specialty, String certification, String funding, String imagelink, String community, String tel, String email, String uniqueuid, String postbox, String synstatus, Date datecreated, int serverid, String macaddress, String imei, String agentname, String agentid) {
        this.farmerid = farmerid;
        this.surname = surname;
        this.othername = othername;
        this.placeofbirth = placeofbirth;
        this.dateofbirth = dateofbirth;
        this.age = age;
        this.gender = gender;
        this.hometown = hometown;
        this.address = address;
        this.district = district;
        this.region = region;
        this.country = country;
        this.idcardtype = idcardtype;
        this.idcardno = idcardno;
        this.levelofeducation = levelofeducation;
        this.religion = religion;
        this.maritalstatus = maritalstatus;
        this.nextofkin = nextofkin;
        this.relation = relation;
        this.qfarmergroup = qfarmergroup;
        this.farmergroup = farmergroup;
        this.qcooperative = qcooperative;
        this.cooperative = cooperative;
        this.qincomesource = qincomesource;
        this.incomesource = incomesource;
        this.qspecialty = qspecialty;
        this.specialty = specialty;
        this.certification = certification;
        this.funding = funding;
        this.imagelink = imagelink;
        this.community = community;
        this.tel = tel;
        this.email = email;
        this.uniqueuid = uniqueuid;
        this.postbox = postbox;
        this.synstatus = synstatus;
        this.datecreated = datecreated;
        this.serverid = serverid;
        this.macaddress = macaddress;
        this.imei = imei;
        this.agentname = agentname;
        this.agentid = agentid;
    }


    public Farmers(String farmerid, String surname, String placeofbirth, Date dateofbirth, String gender, String district, String region, String country, String idcardtype, String idcardno, String levelofeducation, String maritalstatus, String qfarmergroup, String qcooperative, String cooperative, String qincomesource, String qspecialty, String certification, String funding, String imagelink, String community) {
        this.farmerid = farmerid;
        this.surname = surname;
        this.placeofbirth = placeofbirth;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.district = district;
        this.region = region;
        this.country = country;
        this.idcardtype = idcardtype;
        this.idcardno = idcardno;
        this.levelofeducation = levelofeducation;
        this.maritalstatus = maritalstatus;
        this.qfarmergroup = qfarmergroup;
        this.qcooperative = qcooperative;
        this.cooperative = cooperative;
        this.qincomesource = qincomesource;
        this.qspecialty = qspecialty;
        this.certification = certification;
        this.funding = funding;
        this.imagelink = imagelink;
        this.community = community;
    }

    public Farmers(String farmerid, String surname, String othername, String placeofbirth, Date dateofbirth, String gender, String hometown, String address, String district, String region, String country, String idcardtype, String idcardno, String levelofeducation, String religion, String maritalstatus, String nextofkin, String relation, String qfarmergroup, String farmergroup, String qcooperative, String cooperative, String qincomesource, String incomesource, String qspecialty, String specialty, String certification, String funding, String imagelink, String community, String tel) {
        this.farmerid = farmerid;
        this.surname = surname;
        this.othername = othername;
        this.placeofbirth = placeofbirth;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.hometown = hometown;
        this.address = address;
        this.district = district;
        this.region = region;
        this.country = country;
        this.idcardtype = idcardtype;
        this.idcardno = idcardno;
        this.levelofeducation = levelofeducation;
        this.religion = religion;
        this.maritalstatus = maritalstatus;
        this.nextofkin = nextofkin;
        this.relation = relation;
        this.qfarmergroup = qfarmergroup;
        this.farmergroup = farmergroup;
        this.qcooperative = qcooperative;
        this.cooperative = cooperative;
        this.qincomesource = qincomesource;
        this.incomesource = incomesource;
        this.qspecialty = qspecialty;
        this.specialty = specialty;
        this.certification = certification;
        this.funding = funding;
        this.imagelink = imagelink;
        this.community = community;
        this.tel = tel;
    }
    public String aggregatorid;

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
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

    public int getServerid() {
        return serverid;
    }

    public void setServerid(int serverid) {
        this.serverid = serverid;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getSynstatus() {
        return synstatus;
    }

    public void setSynstatus(String synstatus) {
        this.synstatus = synstatus;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPostbox() {
        return postbox;
    }

    public void setPostbox(String postbox) {
        this.postbox = postbox;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }

    public String getFarmerid() {
        return this.farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOthername() {
        return this.othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public String getPlaceofbirth() {
        return this.placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public Date getDateofbirth() {
        return this.dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHometown() {
        return this.hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdcardtype() {
        return this.idcardtype;
    }

    public void setIdcardtype(String idcardtype) {
        this.idcardtype = idcardtype;
    }

    public String getIdcardno() {
        return this.idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
    }

    public String getLevelofeducation() {
        return this.levelofeducation;
    }

    public void setLevelofeducation(String levelofeducation) {
        this.levelofeducation = levelofeducation;
    }

    public String getReligion() {
        return this.religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getMaritalstatus() {
        return this.maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getNextofkin() {
        return this.nextofkin;
    }

    public void setNextofkin(String nextofkin) {
        this.nextofkin = nextofkin;
    }

    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getQfarmergroup() {
        return this.qfarmergroup;
    }

    public void setQfarmergroup(String qfarmergroup) {
        this.qfarmergroup = qfarmergroup;
    }

    public String getFarmergroup() {
        return this.farmergroup;
    }

    public void setFarmergroup(String farmergroup) {
        this.farmergroup = farmergroup;
    }

    public String getQcooperative() {
        return this.qcooperative;
    }

    public void setQcooperative(String qcooperative) {
        this.qcooperative = qcooperative;
    }

    public String getCooperative() {
        return this.cooperative;
    }

    public void setCooperative(String cooperative) {
        this.cooperative = cooperative;
    }

    public String getQincomesource() {
        return this.qincomesource;
    }

    public void setQincomesource(String qincomesource) {
        this.qincomesource = qincomesource;
    }

    public String getIncomesource() {
        return this.incomesource;
    }

    public void setIncomesource(String incomesource) {
        this.incomesource = incomesource;
    }

    public String getQspecialty() {
        return this.qspecialty;
    }

    public void setQspecialty(String qspecialty) {
        this.qspecialty = qspecialty;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCertification() {
        return this.certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getFunding() {
        return this.funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getImagelink() {
        return this.imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getCommunity() {
        return this.community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}

