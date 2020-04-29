package com.telpo.usb.finger.interfaces;

import com.telpo.usb.finger.entities.Farmers;

import java.util.List;

public interface SaveSelectedFarmersClickListener {
    void onSaveSelectedFarmersClickListener(List<Farmers> farmersList);
}