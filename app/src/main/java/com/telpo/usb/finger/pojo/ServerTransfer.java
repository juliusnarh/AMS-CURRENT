package com.telpo.usb.finger.pojo;


import com.telpo.usb.finger.entities.ActivityInfo;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.FarmAssessment;
import com.telpo.usb.finger.entities.Farmeridcard;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Farms;
import com.telpo.usb.finger.entities.Household;
import com.telpo.usb.finger.entities.LocationCoordinates;
import com.telpo.usb.finger.entities.Products;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.entities.SupportDocs;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.entities.Userfingerprint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior on 12/15/2017.
 */

public class ServerTransfer {
    private FarmAssessment assessment;
    private Household household;
    private Farmers farmers;
    private ActivityInfo activityInfo;
    private Farms farms;
    private Userbiometrics userbiometrics;
    private Farmeridcard farmeridcard;
    private LocationCoordinates locationCoordinates;
    private List<Userfingerprint> fingerlist;
    private List<SupportDocs> supportdocs;
    private Declaration declaration;
    private SupportDocs docs;
    private Products products;
    private Sales sales;
    private Salestran salestran;
    private Scaletran scaletran;
    private List<FarmAssessment> assessmentList;
    private List<Household> householdList;
    private List<Farmers> farmersList;
    private List<ActivityInfo> activityInfoList;
    private List<Farms> farmsList;
    private List<Userbiometrics> userbiometricsList;
    private List<Farmeridcard> farmeridcardList;
    private List<LocationCoordinates> locationCoordinatesList;
    private List<Declaration> declarationList;
    private List<Products> productsList;
    private List<Sales> salesList;
    private List<Salestran> salestranList;
    private List<Scaletran> scaletranList;

    public ServerTransfer() {
    }

    public SupportDocs getDocs() {
        return docs;
    }

    public void setDocs(SupportDocs docs) {
        this.docs = docs;
    }

    public FarmAssessment getAssessment() {
        return assessment;
    }

    public void setAssessment(FarmAssessment assessment) {
        this.assessment = assessment;
    }

    public List<FarmAssessment> getAssessmentList() {
        return assessmentList;
    }

    public void setAssessmentList(List<FarmAssessment> assessmentList) {
        this.assessmentList = assessmentList;
    }

    public List<Household> getHouseholdList() {
        return householdList;
    }

    public void setHouseholdList(List<Household> householdList) {
        this.householdList = householdList;
    }

    public List<Farmers> getFarmersList() {
        return farmersList;
    }

    public void setFarmersList(List<Farmers> farmersList) {
        this.farmersList = farmersList;
    }

    public List<ActivityInfo> getActivityInfoList() {
        return activityInfoList;
    }

    public void setActivityInfoList(List<ActivityInfo> activityInfoList) {
        this.activityInfoList = activityInfoList;
    }

    public List<Farms> getFarmsList() {
        return farmsList;
    }

    public void setFarmsList(List<Farms> farmsList) {
        this.farmsList = farmsList;
    }

    public List<Userbiometrics> getUserbiometricsList() {
        return userbiometricsList;
    }

    public void setUserbiometricsList(List<Userbiometrics> userbiometricsList) {
        this.userbiometricsList = userbiometricsList;
    }

    public List<Farmeridcard> getFarmeridcardList() {
        return farmeridcardList;
    }

    public void setFarmeridcardList(List<Farmeridcard> farmeridcardList) {
        this.farmeridcardList = farmeridcardList;
    }

    public List<LocationCoordinates> getLocationCoordinatesList() {
        return locationCoordinatesList;
    }

    public void setLocationCoordinatesList(List<LocationCoordinates> locationCoordinatesList) {
        this.locationCoordinatesList = locationCoordinatesList;
    }

    public List<Declaration> getDeclarationList() {
        return declarationList;
    }

    public void setDeclarationList(List<Declaration> declarationList) {
        this.declarationList = declarationList;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
    }

    public List<Salestran> getSalestranList() {
        return salestranList;
    }

    public void setSalestranList(List<Salestran> salestranList) {
        this.salestranList = salestranList;
    }

    public List<Scaletran> getScaletranList() {
        return scaletranList;
    }

    public void setScaletranList(List<Scaletran> scaletranList) {
        this.scaletranList = scaletranList;
    }

    public List<SupportDocs> getSupportdocs() {
        if (supportdocs == null)
            supportdocs = new ArrayList<>();
        return supportdocs;
    }

    public void setSupportdocs(List<SupportDocs> supportdocs) {
        this.supportdocs = supportdocs;
    }

    public FarmAssessment getassessment() {
        if (assessment == null)
            assessment = new FarmAssessment();
        return assessment;
    }

    public void setassessment(FarmAssessment assessment) {
        this.assessment = assessment;
    }

    public List<Userfingerprint> getFingerlist() {
        if (fingerlist == null)
            fingerlist = new ArrayList<>();
        return fingerlist;
    }

    public void setFingerlist(List<Userfingerprint> fingerlist) {
        this.fingerlist = fingerlist;
    }

    public Household getHousehold() {
        if (household == null)
            household = new Household();
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public Farmers getFarmers() {
        if (farmers == null)
            farmers = new Farmers();
        return farmers;
    }

    public void setFarmers(Farmers farmers) {
        this.farmers = farmers;
    }

    public ActivityInfo getActivityInfo() {
        if (activityInfo == null)
            activityInfo = new ActivityInfo();
        return activityInfo;
    }

    public void setActivityInfo(ActivityInfo activityInfo) {
        this.activityInfo = activityInfo;
    }

    public Farms getFarms() {
        if (farms == null)
            farms = new Farms();
        return farms;
    }

    public void setFarms(Farms farms) {
        this.farms = farms;
    }

    public Userbiometrics getUserbiometrics() {
        if (userbiometrics == null)
            userbiometrics = new Userbiometrics();
        return userbiometrics;
    }

    public void setUserbiometrics(Userbiometrics userbiometrics) {
        this.userbiometrics = userbiometrics;
    }

    public Farmeridcard getFarmeridcard() {
        if (farmeridcard == null)
            farmeridcard = new Farmeridcard();
        return farmeridcard;
    }

    public void setFarmeridcard(Farmeridcard farmeridcard) {
        this.farmeridcard = farmeridcard;
    }

    public LocationCoordinates getLocationCoordinates() {
        if (locationCoordinates == null)
            locationCoordinates = new LocationCoordinates();
        return locationCoordinates;
    }

    public void setLocationCoordinates(LocationCoordinates locationCoordinates) {
        this.locationCoordinates = locationCoordinates;
    }

    /**
     * @return the declaration
     */
    public Declaration getDeclaration() {
        return declaration;
    }

    /**
     * @param declaration the declaration to set
     */
    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    /**
     * @return the products
     */
    public Products getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(Products products) {
        this.products = products;
    }

    /**
     * @return the sales
     */
    public Sales getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(Sales sales) {
        this.sales = sales;
    }

    /**
     * @return the salestran
     */
    public Salestran getSalestran() {
        return salestran;
    }

    /**
     * @param salestran the salestran to set
     */
    public void setSalestran(Salestran salestran) {
        this.salestran = salestran;
    }

    /**
     * @return the scaletran
     */
    public Scaletran getScaletran() {
        return scaletran;
    }

    /**
     * @param scaletran the scaletran to set
     */
    public void setScaletran(Scaletran scaletran) {
        this.scaletran = scaletran;
    }
}





