package com.telpo.usb.finger.pojo;

import androidx.databinding.ObservableField;

/**
 * Created by Junior on 12/3/2017.
 */

public class BiometricsTaken {
    public final ObservableField<Boolean> photo = new ObservableField<>();
    public final ObservableField<String> photourl = new ObservableField<>();
    public final ObservableField<Boolean> fingerprint = new ObservableField<>();
    public final ObservableField<Boolean> signature = new ObservableField<>();
    public final ObservableField<String> signatureurl = new ObservableField<>();
    public final ObservableField<Boolean> supportdocs = new ObservableField<>();
}
