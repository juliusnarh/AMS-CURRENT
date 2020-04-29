package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

public class InputTransaction extends SugarRecord {

    public String farmer_id;
    public String items_purchased;
    public String items_quantity;
    public String transaction_id;
    public String items_total;
    public String payment_style;
    public String payment_method;
    public String debtor_status;
    public String date_created;


    public InputTransaction() {
    }

    public InputTransaction
            (String transaction_id, String farmer_id, String items_purchased,
             String items_quantity, String items_total,
             String payment_style, String payment_method,
             String debtor_status, String date_created
            ) {
        this.transaction_id = transaction_id;
        this.farmer_id = farmer_id;
        this.items_purchased = items_purchased.toUpperCase();
        this.items_quantity = items_quantity;
        this.items_total = items_total;
        this.payment_style = payment_style.toUpperCase();
        this.payment_method = payment_method.toUpperCase();
        this.debtor_status = debtor_status.toUpperCase();
        this.date_created = date_created;
    }

    public String aggregatorid;

    public String getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(String aggregatorid) {
        this.aggregatorid = aggregatorid;
    }
    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getFarmer_id() {
        return farmer_id;
    }

    public void setFarmer_id(String farmer_id) {
        this.farmer_id = farmer_id;
    }

    public String getItems_purchased() {
        return items_purchased;
    }

    public void setItems_purchased(String items_purchased) {
        this.items_purchased = items_purchased;
    }

    public String getItems_quantity() {
        return items_quantity;
    }

    public void setItems_quantity(String items_quantity) {
        this.items_quantity = items_quantity;
    }

    public String getItems_total() {
        return items_total;
    }

    public void setItems_total(String items_total) {
        this.items_total = items_total;
    }

    public String getPayment_style() {
        return payment_style;
    }

    public void setPayment_style(String payment_style) {
        this.payment_style = payment_style;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getDebtor_status() {
        return debtor_status;
    }

    public void setDebtor_status(String debtor_status) {
        this.debtor_status = debtor_status;
    }
}