/*
 * Copyright (c) 2019. Product of Universal Consulting Links Ghana (UCL GH). Authored by Carl Julius Narh.
 * Contact Information: 0501346180
 */

package com.telpo.usb.finger.entities;

import java.io.Serializable;
import java.util.List;

public class GetSingleFarmerInfoServer implements Serializable {

    private String farmerid;
    private String name;
    private String tel;
    private String community;
    private DateofbirthBean dateofbirth;
    private String placeofbirth;
    private String gender;
    private String hometowm;
    private String address;
    private String levelofeducation;
    private String maritalstatus;
    private String district;
    private String region;
    private String othernames;
    private String surname;
    private String email;
    private String religion;
    private String postbox;
    private String country;
    private String macaddress;
    private String imei;
    private String agentname;
    private String agentid;
    private String aggregatorid;
    private DatecreatedBean datecreated;
    private String image;
    private String signature;
    private Object idcardnumber;
    private String idcardtype;
    private String specialtycrop;
    private String farmergroup;
    private String cooperative;
    private Object fundingsource;
    private String incomesource;
    private String uniqueuid;
    private List<FarmsBean> farms;
    private List<DeclarationsBean> declarations;
    private List<ScaletranBean> scaletran;
    private List<SalestranBean> salestran;
    private List<SupportDocsBean> supportdocs;
    private List<LocationsBean> locations;

    public String getOthernames() {
        return othernames;
    }

    public void setOthernames(String othernames) {
        this.othernames = othernames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPostbox() {
        return postbox;
    }

    public void setPostbox(String postbox) {
        this.postbox = postbox;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public DateofbirthBean getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(DateofbirthBean dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHometowm() {
        return hometowm;
    }

    public void setHometowm(String hometowm) {
        this.hometowm = hometowm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevelofeducation() {
        return levelofeducation;
    }

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }

    public void setLevelofeducation(String levelofeducation) {
        this.levelofeducation = levelofeducation;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public DatecreatedBean getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(DatecreatedBean datecreated) {
        this.datecreated = datecreated;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Object getIdcardnumber() {
        return idcardnumber;
    }

    public void setIdcardnumber(Object idcardnumber) {
        this.idcardnumber = idcardnumber;
    }

    public String getIdcardtype() {
        return idcardtype;
    }

    public void setIdcardtype(String idcardtype) {
        this.idcardtype = idcardtype;
    }

    public String getSpecialtycrop() {
        return specialtycrop;
    }

    public void setSpecialtycrop(String specialtycrop) {
        this.specialtycrop = specialtycrop;
    }

    public String getFarmergroup() {
        return farmergroup;
    }

    public void setFarmergroup(String farmergroup) {
        this.farmergroup = farmergroup;
    }

    public String getCooperative() {
        return cooperative;
    }

    public void setCooperative(String cooperative) {
        this.cooperative = cooperative;
    }

    public String getUniqueuid() {
        return uniqueuid;
    }

    public void setUniqueuid(String uniqueuid) {
        this.uniqueuid = uniqueuid;
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

    public Object getFundingsource() {
        return fundingsource;
    }

    public void setFundingsource(Object fundingsource) {
        this.fundingsource = fundingsource;
    }

    public String getIncomesource() {
        return incomesource;
    }

    public void setIncomesource(String incomesource) {
        this.incomesource = incomesource;
    }

    public List<FarmsBean> getFarms() {
        return farms;
    }

    public void setFarms(List<FarmsBean> farms) {
        this.farms = farms;
    }

    public List<DeclarationsBean> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(List<DeclarationsBean> declarations) {
        this.declarations = declarations;
    }

    public List<ScaletranBean> getScaletran() {
        return scaletran;
    }

    public List<SupportDocsBean> getSupportdocs() {
        return supportdocs;
    }

    public List<LocationsBean> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationsBean> locations) {
        this.locations = locations;
    }

    public void setSupportdocs(List<SupportDocsBean> supportdocs) {
        this.supportdocs = supportdocs;
    }

    public void setScaletran(List<ScaletranBean> scaletran) {
        this.scaletran = scaletran;
    }

    public List<SalestranBean> getSalestran() {
        return salestran;
    }

    public void setSalestran(List<SalestranBean> salestran) {
        this.salestran = salestran;
    }


    public static class DateofbirthBean implements Serializable {
        /**
         * date : 1975-06-14 00:00:00.000000
         * timezone_type : 3
         * timezone : UTC
         */

        private String date;
        private int timezone_type;
        private String timezone;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getTimezone_type() {
            return timezone_type;
        }

        public void setTimezone_type(int timezone_type) {
            this.timezone_type = timezone_type;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }

    public static class DatecreatedBean implements Serializable {
        /**
         * date : 2018-05-06 07:15:56.000000
         * timezone_type : 3
         * timezone : UTC
         */

        private String date;
        private int timezone_type;
        private String timezone;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getTimezone_type() {
            return timezone_type;
        }

        public void setTimezone_type(int timezone_type) {
            this.timezone_type = timezone_type;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }

    public static class FarmsBean implements Serializable {

        private String farmid;
        private String community;
        private String district;
        private String region;
        private int totalarea;
        private int cultivatedarea;
        private int shadetrees;
        private String materialsource;
        private String ownershipmethod;
        private Object extprovider;
        private String laboursource;
        private String typeoffarm;
        private Object farmspecialty;
        private Object otheractivities;
        private String yearofestablishment;
        private String chemicalused;
        private String cropprotection;
        private String cropvariety;
        private String farmyield;
        private String fertilizerused;
        private String extension;
        private String othersource;
        private String organization;
        private DatecreatedBeanX datecreated;
        private String uniqueuid;

        public String getUniqueuid() {
            return uniqueuid;
        }

        public void setUniqueuid(String uniqueuid) {
            this.uniqueuid = uniqueuid;
        }

        public String getFarmid() {
            return farmid;
        }

        public void setFarmid(String farmid) {
            this.farmid = farmid;
        }

        public String getCommunity() {
            return community;
        }

        public void setCommunity(String community) {
            this.community = community;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public int getTotalarea() {
            return totalarea;
        }

        public void setTotalarea(int totalarea) {
            this.totalarea = totalarea;
        }

        public int getCultivatedarea() {
            return cultivatedarea;
        }

        public void setCultivatedarea(int cultivatedarea) {
            this.cultivatedarea = cultivatedarea;
        }

        public int getShadetrees() {
            return shadetrees;
        }

        public void setShadetrees(int shadetrees) {
            this.shadetrees = shadetrees;
        }

        public String getMaterialsource() {
            return materialsource;
        }

        public void setMaterialsource(String materialsource) {
            this.materialsource = materialsource;
        }

        public String getOwnershipmethod() {
            return ownershipmethod;
        }

        public void setOwnershipmethod(String ownershipmethod) {
            this.ownershipmethod = ownershipmethod;
        }

        public Object getExtprovider() {
            return extprovider;
        }

        public void setExtprovider(Object extprovider) {
            this.extprovider = extprovider;
        }

        public String getLaboursource() {
            return laboursource;
        }

        public void setLaboursource(String laboursource) {
            this.laboursource = laboursource;
        }

        public String getTypeoffarm() {
            return typeoffarm;
        }

        public void setTypeoffarm(String typeoffarm) {
            this.typeoffarm = typeoffarm;
        }

        public Object getFarmspecialty() {
            return farmspecialty;
        }

        public void setFarmspecialty(Object farmspecialty) {
            this.farmspecialty = farmspecialty;
        }

        public Object getOtheractivities() {
            return otheractivities;
        }

        public void setOtheractivities(Object otheractivities) {
            this.otheractivities = otheractivities;
        }

        public String getYearofestablishment() {
            return yearofestablishment;
        }

        public void setYearofestablishment(String yearofestablishment) {
            this.yearofestablishment = yearofestablishment;
        }

        public String getChemicalused() {
            return chemicalused;
        }

        public void setChemicalused(String chemicalused) {
            this.chemicalused = chemicalused;
        }

        public String getCropprotection() {
            return cropprotection;
        }

        public void setCropprotection(String cropprotection) {
            this.cropprotection = cropprotection;
        }

        public String getCropvariety() {
            return cropvariety;
        }

        public void setCropvariety(String cropvariety) {
            this.cropvariety = cropvariety;
        }

        public String getFarmyield() {
            return farmyield;
        }

        public void setFarmyield(String farmyield) {
            this.farmyield = farmyield;
        }

        public String getFertilizerused() {
            return fertilizerused;
        }

        public void setFertilizerused(String fertilizerused) {
            this.fertilizerused = fertilizerused;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        public String getOthersource() {
            return othersource;
        }

        public void setOthersource(String othersource) {
            this.othersource = othersource;
        }

        public String getOrganization() {
            return organization;
        }

        public void setOrganization(String organization) {
            this.organization = organization;
        }

        public DatecreatedBeanX getDatecreated() {
            return datecreated;
        }

        public void setDatecreated(DatecreatedBeanX datecreated) {
            this.datecreated = datecreated;
        }

        public static class DatecreatedBeanX implements Serializable {

            private String date;
            private int timezone_type;
            private String timezone;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getTimezone_type() {
                return timezone_type;
            }

            public void setTimezone_type(int timezone_type) {
                this.timezone_type = timezone_type;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }
        }
    }

    public static class DeclarationsBean implements Serializable {

        private int totalcost;
        private String couponcode;
        private String transid;
        private int appliedsub;
        private int norecoverybags;
        private String paymentmethod;
        private String declaration;
        private String status;
        private String acreage;
        private String agentid;
        private DatecreatedBeanXX datecreated;
        private String uniqueuid;

        public String getTransid() {
            return transid;
        }

        public void setTransid(String transid) {
            this.transid = transid;
        }

        public String getUniqueuid() {
            return uniqueuid;
        }

        public void setUniqueuid(String uniqueuid) {
            this.uniqueuid = uniqueuid;
        }

        public int getTotalcost() {
            return totalcost;
        }

        public void setTotalcost(int totalcost) {
            this.totalcost = totalcost;
        }

        public String getCouponcode() {
            return couponcode;
        }

        public void setCouponcode(String couponcode) {
            this.couponcode = couponcode;
        }

        public int getAppliedsub() {
            return appliedsub;
        }

        public void setAppliedsub(int appliedsub) {
            this.appliedsub = appliedsub;
        }

        public int getNorecoverybags() {
            return norecoverybags;
        }

        public void setNorecoverybags(int norecoverybags) {
            this.norecoverybags = norecoverybags;
        }

        public String getPaymentmethod() {
            return paymentmethod;
        }

        public void setPaymentmethod(String paymentmethod) {
            this.paymentmethod = paymentmethod;
        }

        public String getDeclaration() {
            return declaration;
        }

        public void setDeclaration(String declaration) {
            this.declaration = declaration;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAcreage() {
            return acreage;
        }

        public void setAcreage(String acreage) {
            this.acreage = acreage;
        }

        public String getAgentid() {
            return agentid;
        }

        public void setAgentid(String agentid) {
            this.agentid = agentid;
        }

        public DatecreatedBeanXX getDatecreated() {
            return datecreated;
        }

        public void setDatecreated(DatecreatedBeanXX datecreated) {
            this.datecreated = datecreated;
        }

        public static class DatecreatedBeanXX implements Serializable {
            /**
             * date : 2019-02-19 08:15:53.000000
             * timezone_type : 3
             * timezone : UTC
             */

            private String date;
            private int timezone_type;
            private String timezone;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getTimezone_type() {
                return timezone_type;
            }

            public void setTimezone_type(int timezone_type) {
                this.timezone_type = timezone_type;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }
        }
    }

    public static class ScaletranBean implements Serializable {

        private String transid;
        private String scaleid;
        private int weight;
        private int moisturecontent;
        private int count;
        private String agentid;
        private int amount;
        private String payable;
        private String tendered;
        private String pcid;
        private String bcid;
        private DatecreatedBeanXXX datecreated;
        private String uniqueuid;


        public String getBcid() {
            return bcid;
        }

        public void setBcid(String bcid) {
            this.bcid = bcid;
        }

        public String getPcid() {
            return pcid;
        }

        public void setPcid(String pcid) {
            this.pcid = pcid;
        }

        public String getUniqueuid() {
            return uniqueuid;
        }

        public void setUniqueuid(String uniqueuid) {
            this.uniqueuid = uniqueuid;
        }

        public String getTransid() {
            return transid;
        }

        public void setTransid(String transid) {
            this.transid = transid;
        }

        public String getScaleid() {
            return scaleid;
        }

        public void setScaleid(String scaleid) {
            this.scaleid = scaleid;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getMoisturecontent() {
            return moisturecontent;
        }

        public void setMoisturecontent(int moisturecontent) {
            this.moisturecontent = moisturecontent;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getAgentid() {
            return agentid;
        }

        public void setAgentid(String agentid) {
            this.agentid = agentid;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getPayable() {
            return payable;
        }

        public void setPayable(String payable) {
            this.payable = payable;
        }

        public String getTendered() {
            return tendered;
        }

        public void setTendered(String tendered) {
            this.tendered = tendered;
        }

        public DatecreatedBeanXXX getDatecreated() {
            return datecreated;
        }

        public void setDatecreated(DatecreatedBeanXXX datecreated) {
            this.datecreated = datecreated;
        }

        public static class DatecreatedBeanXXX implements Serializable {
            /**
             * date : 2019-02-19 08:18:01.000000
             * timezone_type : 3
             * timezone : UTC
             */

            private String date;
            private int timezone_type;
            private String timezone;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getTimezone_type() {
                return timezone_type;
            }

            public void setTimezone_type(int timezone_type) {
                this.timezone_type = timezone_type;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }
        }
    }

    public static class SalestranBean implements Serializable {

        private String transid;
        private int totalcost;
        private String couponcode;
        private int appliedsub;
        private int norecoverybags;
        private String paymentmethod;
        private int payableamt;
        private int tendered;
        private String acreage;
        private String agentid;
        private DatecreatedBeanXXXX datecreated;
        private List<SalesBean> sales;
        private String uniqueuid;

        public String getUniqueuid() {
            return uniqueuid;
        }

        public void setUniqueuid(String uniqueuid) {
            this.uniqueuid = uniqueuid;
        }

        public String getTransid() {
            return transid;
        }

        public void setTransid(String transid) {
            this.transid = transid;
        }

        public int getTotalcost() {
            return totalcost;
        }

        public void setTotalcost(int totalcost) {
            this.totalcost = totalcost;
        }

        public String getCouponcode() {
            return couponcode;
        }

        public void setCouponcode(String couponcode) {
            this.couponcode = couponcode;
        }

        public int getAppliedsub() {
            return appliedsub;
        }

        public void setAppliedsub(int appliedsub) {
            this.appliedsub = appliedsub;
        }

        public int getNorecoverybags() {
            return norecoverybags;
        }

        public void setNorecoverybags(int norecoverybags) {
            this.norecoverybags = norecoverybags;
        }

        public String getPaymentmethod() {
            return paymentmethod;
        }

        public void setPaymentmethod(String paymentmethod) {
            this.paymentmethod = paymentmethod;
        }

        public int getPayableamt() {
            return payableamt;
        }

        public void setPayableamt(int payableamt) {
            this.payableamt = payableamt;
        }

        public int getTendered() {
            return tendered;
        }

        public void setTendered(int tendered) {
            this.tendered = tendered;
        }

        public String getAcreage() {
            return acreage;
        }

        public void setAcreage(String acreage) {
            this.acreage = acreage;
        }

        public String getAgentid() {
            return agentid;
        }

        public void setAgentid(String agentid) {
            this.agentid = agentid;
        }

        public DatecreatedBeanXXXX getDatecreated() {
            return datecreated;
        }

        public void setDatecreated(DatecreatedBeanXXXX datecreated) {
            this.datecreated = datecreated;
        }

        public List<SalesBean> getSales() {
            return sales;
        }

        public void setSales(List<SalesBean> sales) {
            this.sales = sales;
        }

        public static class DatecreatedBeanXXXX implements Serializable {
            /**
             * date : 2019-02-19 00:00:00.000000
             * timezone_type : 3
             * timezone : UTC
             */

            private String date;
            private int timezone_type;
            private String timezone;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getTimezone_type() {
                return timezone_type;
            }

            public void setTimezone_type(int timezone_type) {
                this.timezone_type = timezone_type;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }
        }

        public static class SalesBean implements Serializable {

            private String transid;
            private String pid;
            private String pname;
            private String category;
            private int uprice;
            private int quantity;
            private int totalcost;
            private String uniqueuid;


            public String getUniqueuid() {
                return uniqueuid;
            }

            public void setUniqueuid(String uniqueuid) {
                this.uniqueuid = uniqueuid;
            }

            public String getTransid() {
                return transid;
            }

            public void setTransid(String transid) {
                this.transid = transid;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getPname() {
                return pname;
            }

            public void setPname(String pname) {
                this.pname = pname;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public int getUprice() {
                return uprice;
            }

            public void setUprice(int uprice) {
                this.uprice = uprice;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getTotalcost() {
                return totalcost;
            }

            public void setTotalcost(int totalcost) {
                this.totalcost = totalcost;
            }
        }
    }

    public static class SupportDocsBean implements Serializable {
        private String doctype;
        private String docfile;
        private String uniqueuid;

        public String getUniqueuid() {
            return uniqueuid;
        }

        public void setUniqueuid(String uniqueuid) {
            this.uniqueuid = uniqueuid;
        }

        public String getDoctype() {
            return doctype;
        }

        public void setDoctype(String doctype) {
            this.doctype = doctype;
        }

        public String getDocfile() {
            return docfile;
        }

        public void setDocfile(String docfile) {
            this.docfile = docfile;
        }
    }

    public static class LocationsBean implements Serializable {
        private String locationtype;
        private String longitude;
        private String latitude;
        private String uniqueuid;
        private String streetname;
        private String farmid;
        private String city;
        private String region;
        private String assembly;
        private String jsoncoord;
        private double area;
        private double length;
        private DatecreatedBeanXXXXX datecreated;

        public String getLocationtype() {
            return locationtype;
        }

        public void setLocationtype(String locationtype) {
            this.locationtype = locationtype;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getUniqueuid() {
            return uniqueuid;
        }

        public void setUniqueuid(String uniqueuid) {
            this.uniqueuid = uniqueuid;
        }

        public String getStreetname() {
            return streetname;
        }

        public void setStreetname(String streetname) {
            this.streetname = streetname;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getAssembly() {
            return assembly;
        }

        public void setAssembly(String assembly) {
            this.assembly = assembly;
        }

        public String getJsoncoord() {
            return jsoncoord;
        }

        public void setJsoncoord(String jsoncoord) {
            this.jsoncoord = jsoncoord;
        }

        public double getArea() {
            return area;
        }

        public void setArea(double area) {
            this.area = area;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public DatecreatedBeanXXXXX getDatecreated() {
            return datecreated;
        }

        public void setDatecreated(DatecreatedBeanXXXXX datecreated) {
            this.datecreated = datecreated;
        }

        public String getFarmid() {
            return farmid;
        }

        public void setFarmid(String farmid) {
            this.farmid = farmid;
        }

        public static class DatecreatedBeanXXXXX implements Serializable {
            /**
             * date : 2019-02-19 08:18:01.000000
             * timezone_type : 3
             * timezone : UTC
             */

            private String date;
            private int timezone_type;
            private String timezone;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getTimezone_type() {
                return timezone_type;
            }

            public void setTimezone_type(int timezone_type) {
                this.timezone_type = timezone_type;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }
        }

    }
}

