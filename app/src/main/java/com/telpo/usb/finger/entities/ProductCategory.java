package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

public class ProductCategory extends SugarRecord {
    public String category;
    public String categorycode;

    public ProductCategory() {
    }

    public ProductCategory(String category, String categorycode) {
        this.category = category;
        this.categorycode = categorycode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }
}
