package com.telpo.usb.finger.entities;

import com.orm.SugarRecord;

import java.util.Date;

public class AggregatorInputs extends SugarRecord {

    public String category;
    public String inputName;
    public String inputDescription;
    public String inputId;
    public int quantity;
    public int costPrice;
    public int salePrice;
    public String inputDealer;
    public String unitMeasurement;
    public byte[] inputImage;
    public String uuid;
    public Date dateCreated;
    public int serverId;
    public String macAddress;
    public String imei;
    public String agentName;
    public String agentId;
    public boolean isSelected = false;

    public AggregatorInputs() {
    }

    public AggregatorInputs(String category, String inputName, String inputDescription, String inputId, int quantity, int costPrice, int salePrice, String inputDealer, String unitMeasurement, byte[] inputImage, String uuid, Date dateCreated, int serverId, String macAddress, String imei, String agentName, String agentId, boolean isSelected) {
        this.category = category;
        this.inputName = inputName;
        this.inputDescription = inputDescription;
        this.inputId = inputId;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.inputDealer = inputDealer;
        this.unitMeasurement = unitMeasurement;
        this.inputImage = inputImage;
        this.uuid = uuid;
        this.dateCreated = dateCreated;
        this.serverId = serverId;
        this.macAddress = macAddress;
        this.imei = imei;
        this.agentName = agentName;
        this.agentId = agentId;
        this.isSelected = isSelected;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputDescription() {
        return inputDescription;
    }

    public void setInputDescription(String inputDescription) {
        this.inputDescription = inputDescription;
    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getInputDealer() {
        return inputDealer;
    }

    public void setInputDealer(String inputDealer) {
        this.inputDealer = inputDealer;
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    public byte[] getInputImage() {
        return inputImage;
    }

    public void setInputImage(byte[] inputImage) {
        this.inputImage = inputImage;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
