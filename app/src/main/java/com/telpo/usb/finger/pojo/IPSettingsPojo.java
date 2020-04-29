package com.telpo.usb.finger.pojo;

import androidx.databinding.ObservableField;

/**
 * Created by Junior on 12/22/2017.
 */

public class IPSettingsPojo {
    public final ObservableField<String> ipaddress = new ObservableField<>();
    public final ObservableField<String> port = new ObservableField<>();
    public final ObservableField<String> context = new ObservableField<>();
    public final ObservableField<String> protocol = new ObservableField<>();
}
