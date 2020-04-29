package com.telpo.usb.finger.utils;

public class MonthValueFormatter extends ValueFormatter {
    private final String[] mMonths = new String[]{
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public MonthValueFormatter() {
    }

    @Override
    public String getFormattedValue(float value) {

        int index = (int) value;


        if (index == 12) {
            return mMonths[index - 1];
        } else
            return mMonths[index];

    }
}
