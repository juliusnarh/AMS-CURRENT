package com.telpo.usb.finger.pojo;

/**
 * Created by Junior on 12/14/2017.
 */

public class FarmerRegisty {
    private String farmerid;
    private String uniqueuid;
    private String firstname;
    private String surname;
    private String fullname;
    private String telephone;
    private String id;
    private String nationality;
    private byte[] photo;
    private String relationship;

    public FarmerRegisty(String uniqueuid, String firstname, String surname,
                         String telephone, String id, String nationality, byte[] photo) {
        this.uniqueuid = uniqueuid;
        this.firstname = firstname;
        this.surname = surname;
        this.fullname = firstname + " " + surname;
        this.telephone = telephone;
        this.id = id;
        this.nationality = nationality;

    }

    public FarmerRegisty() {

    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
