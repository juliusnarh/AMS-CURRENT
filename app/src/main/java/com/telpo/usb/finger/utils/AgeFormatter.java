package com.telpo.usb.finger.utils;

import java.util.ArrayList;

/**
 * Created by philipp on 02/06/16.
 */
public class AgeFormatter extends ValueFormatter {
    ArrayList<String> inputnames;

    public AgeFormatter(ArrayList<String> inputnames) {
        this.inputnames = inputnames;
    }

    @Override
    public String getFormattedValue(float value) {

        int index = (int) value;

        return inputnames.get(index);


    }

}
