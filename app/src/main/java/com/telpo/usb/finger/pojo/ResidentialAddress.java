package com.telpo.usb.finger.pojo;

import androidx.databinding.ObservableField;

/**
 * Created by Junior on 12/3/2017.
 */

public class ResidentialAddress {
    public final ObservableField<String> latitude = new ObservableField<>();
    public final ObservableField<String> longitude = new ObservableField<>();
    public final ObservableField<String> streetname = new ObservableField<>();
    public final ObservableField<String> city = new ObservableField<>();
    public final ObservableField<String> region = new ObservableField<>();
    public final ObservableField<String> assembly = new ObservableField<>();
}
