package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

public class Debtor extends SugarRecord {

    public String farmer_id;
    public String debtor_id;
    public String amount_owing;
    public String barter_value;
    public String agreed_date;
    public String declaration;
    public String date_created;

    public Debtor() {
    }

    public Debtor(String debtor_id, String farmer_id, String amount_owing, String barter_value, String agreed_date, String declaration, String date_created) {
        this.debtor_id = debtor_id;
        this.farmer_id = farmer_id;
        this.amount_owing = amount_owing;
        this.barter_value = barter_value;
        this.agreed_date = agreed_date;
        this.declaration = declaration;
        this.date_created = date_created;
    }
    public String aggregatorid;

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }
    public String getFarmer_id() {
        return farmer_id;
    }

    public void setFarmer_id(String farmer_id) {
        this.farmer_id = farmer_id;
    }

    public String getBarter_value() {
        return barter_value;
    }

    public void setBarter_value(String barter_value) {
        this.barter_value = barter_value;
    }

    public String getAgreed_date() {
        return agreed_date;
    }

    public void setAgreed_date(String agreed_date) {
        this.agreed_date = agreed_date;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getDebtor_id() {
        return debtor_id;
    }

    public void setDebtor_id(String debtor_id) {
        this.debtor_id = debtor_id;
    }

    public String getAmount_owing() {
        return amount_owing;
    }

    public void setAmount_owing(String amount_owing) {
        this.amount_owing = amount_owing;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }
}
