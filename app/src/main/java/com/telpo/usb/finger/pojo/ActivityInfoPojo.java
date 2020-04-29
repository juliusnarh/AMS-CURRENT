package com.telpo.usb.finger.pojo;

import androidx.databinding.ObservableField;

/**
 * Created by Junior on 12/3/2017.
 */

public class ActivityInfoPojo {
    public final ObservableField<String> farmerid = new ObservableField<>();
    public final ObservableField<Boolean> boolgroupmember = new ObservableField<>(false);
    public final ObservableField<String> groupname = new ObservableField<>("");
    public final ObservableField<Boolean> boolcoopmember = new ObservableField<>(false);
    public final ObservableField<String> coopname = new ObservableField<>("");
    public final ObservableField<Boolean> boolcocoaincome = new ObservableField<>(false);
    public final ObservableField<String> incomesource = new ObservableField<>("");
    public final ObservableField<Boolean> boolspecialty = new ObservableField<>(false);
    public final ObservableField<String> specialtycocoa = new ObservableField<>("");
    public final ObservableField<Boolean> boolcertified = new ObservableField<>(false);
    public final ObservableField<String> certified = new ObservableField<>("");
    public final ObservableField<String> fundingsource = new ObservableField<>("");
}
