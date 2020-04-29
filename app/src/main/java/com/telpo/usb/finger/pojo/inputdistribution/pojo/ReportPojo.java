package com.telpo.usb.finger.pojo.inputdistribution.pojo;

import androidx.databinding.ObservableField;

public class ReportPojo {
    public final ObservableField<String> header = new ObservableField<>("Recovery Transactions");
    public final ObservableField<String> farmersserved = new ObservableField<>();
    public final ObservableField<String> totalpayable = new ObservableField<>();
    public final ObservableField<String> totalrecovery = new ObservableField<>();
    public final ObservableField<String> totalpurchases = new ObservableField<>();
    public final ObservableField<String> remaining = new ObservableField<>();
    public final ObservableField<String> recoverypercent = new ObservableField<>();
    public final ObservableField<String> amountowing = new ObservableField<>();
}
