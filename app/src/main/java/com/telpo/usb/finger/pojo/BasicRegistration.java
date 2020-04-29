package com.telpo.usb.finger.pojo;

import androidx.databinding.ObservableField;

/**
 * Created by Junior on 12/3/2017.
 */

public class BasicRegistration {

    public final ObservableField<String> firstname = new ObservableField<>("");
    public final ObservableField<String> surname = new ObservableField<>("");
    public final ObservableField<String> nationality = new ObservableField<>();
    public final ObservableField<String> placeofbirth = new ObservableField<>();
    public final ObservableField<String> age = new ObservableField<>("0");
    public final ObservableField<String> gender = new ObservableField<>();
    public final ObservableField<String> dateofbirth = new ObservableField<>();
    public final ObservableField<String> email = new ObservableField<>();
    public final ObservableField<String> telephone = new ObservableField<>();
    public final ObservableField<String> mobile = new ObservableField<>();
    public final ObservableField<String> postofficebox = new ObservableField<>();
    public final ObservableField<String> idtype = new ObservableField<>();
    public final ObservableField<String> idnumber = new ObservableField<>();
    //    public final ObservableField<byte[]> idimage  = new ObservableField<>();
    public final ObservableField<String> hometown = new ObservableField<>();
    public final ObservableField<String> region = new ObservableField<>();
    public final ObservableField<String> residentialaddr = new ObservableField<>();
    public final ObservableField<String> maritalstatus = new ObservableField<>();
    public final ObservableField<String> farmcommunity = new ObservableField<>();
    public final ObservableField<String> district = new ObservableField<>();
    public final ObservableField<String> levelofeducation = new ObservableField<>();
    public final ObservableField<String> religion = new ObservableField<>();

}
