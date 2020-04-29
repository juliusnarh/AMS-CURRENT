package com.telpo.usb.finger.utils;

import java.util.List;

/**
 * Created by philipp on 02/06/16.
 */
public class ProductsValueFormatter extends ValueFormatter {
    List<String> inputnames;

    public ProductsValueFormatter(List<String> inputnames) {
        this.inputnames = inputnames;
    }

    @Override
    public String getFormattedValue(float value) {

        int index = (int) value;

        if (inputnames.get(index).toLowerCase().startsWith("lum")) {
            return inputnames.get(index);
        } else if (inputnames.get(index).length() > 5 && inputnames.get(index).length() < 10) {
            return inputnames.get(index).substring(0, inputnames.get(index).length() - 4) + "...";
        } else if (inputnames.get(index).length() > 10) {
            return inputnames.get(index).substring(0, 5) + "...";
        } else {
            return inputnames.get(index);
        }

    }

}
