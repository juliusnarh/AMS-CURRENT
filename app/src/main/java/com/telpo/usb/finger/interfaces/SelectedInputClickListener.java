package com.telpo.usb.finger.interfaces;

import com.telpo.usb.finger.entities.AggregatorInputs;

public interface SelectedInputClickListener {
    void onSelectedInputClickListener(AggregatorInputs inputs, int quantity, int action);
}