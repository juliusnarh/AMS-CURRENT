package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentReportBindingImpl extends FragmentReportBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.summary, 8);
        sViewsWithIds.put(R.id.more, 9);
        sViewsWithIds.put(R.id.ll1, 10);
        sViewsWithIds.put(R.id.farmersserved_label, 11);
        sViewsWithIds.put(R.id.ll2, 12);
        sViewsWithIds.put(R.id.totalpayable_label, 13);
        sViewsWithIds.put(R.id.ll3, 14);
        sViewsWithIds.put(R.id.totalrecovery_label, 15);
        sViewsWithIds.put(R.id.ll5, 16);
        sViewsWithIds.put(R.id.ll6, 17);
        sViewsWithIds.put(R.id.ll4, 18);
        sViewsWithIds.put(R.id.card_title, 19);
        sViewsWithIds.put(R.id.viewforsaletransactions, 20);
        sViewsWithIds.put(R.id.viewall, 21);
        sViewsWithIds.put(R.id.viewinput, 22);
        sViewsWithIds.put(R.id.viewservices, 23);
        sViewsWithIds.put(R.id.norecord, 24);
        sViewsWithIds.put(R.id.report_recycler, 25);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener farmersservedandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of report.farmersserved.get()
            //         is report.farmersserved.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(farmersserved);
            // localize variables for thread safety
            // report != null
            boolean reportJavaLangObjectNull = false;
            // report.farmersserved.get()
            java.lang.String reportFarmersservedGet = null;
            // report
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo report = mReport;
            // report.farmersserved
            androidx.databinding.ObservableField<java.lang.String> reportFarmersserved = null;
            // report.farmersserved != null
            boolean reportFarmersservedJavaLangObjectNull = false;



            reportJavaLangObjectNull = (report) != (null);
            if (reportJavaLangObjectNull) {


                reportFarmersserved = report.farmersserved;

                reportFarmersservedJavaLangObjectNull = (reportFarmersserved) != (null);
                if (reportFarmersservedJavaLangObjectNull) {




                    reportFarmersserved.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener headerandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of report.header.get()
            //         is report.header.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(header);
            // localize variables for thread safety
            // report != null
            boolean reportJavaLangObjectNull = false;
            // report.header != null
            boolean reportHeaderJavaLangObjectNull = false;
            // report
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo report = mReport;
            // report.header
            androidx.databinding.ObservableField<java.lang.String> reportHeader = null;
            // report.header.get()
            java.lang.String reportHeaderGet = null;



            reportJavaLangObjectNull = (report) != (null);
            if (reportJavaLangObjectNull) {


                reportHeader = report.header;

                reportHeaderJavaLangObjectNull = (reportHeader) != (null);
                if (reportHeaderJavaLangObjectNull) {




                    reportHeader.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener recoverypercentandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of report.recoverypercent.get()
            //         is report.recoverypercent.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(recoverypercent);
            // localize variables for thread safety
            // report != null
            boolean reportJavaLangObjectNull = false;
            // report
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo report = mReport;
            // report.recoverypercent.get()
            java.lang.String reportRecoverypercentGet = null;
            // report.recoverypercent
            androidx.databinding.ObservableField<java.lang.String> reportRecoverypercent = null;
            // report.recoverypercent != null
            boolean reportRecoverypercentJavaLangObjectNull = false;



            reportJavaLangObjectNull = (report) != (null);
            if (reportJavaLangObjectNull) {


                reportRecoverypercent = report.recoverypercent;

                reportRecoverypercentJavaLangObjectNull = (reportRecoverypercent) != (null);
                if (reportRecoverypercentJavaLangObjectNull) {




                    reportRecoverypercent.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener remainingBagsandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of report.remaining.get()
            //         is report.remaining.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(remainingBags);
            // localize variables for thread safety
            // report != null
            boolean reportJavaLangObjectNull = false;
            // report.remaining
            androidx.databinding.ObservableField<java.lang.String> reportRemaining = null;
            // report
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo report = mReport;
            // report.remaining.get()
            java.lang.String reportRemainingGet = null;
            // report.remaining != null
            boolean reportRemainingJavaLangObjectNull = false;



            reportJavaLangObjectNull = (report) != (null);
            if (reportJavaLangObjectNull) {


                reportRemaining = report.remaining;

                reportRemainingJavaLangObjectNull = (reportRemaining) != (null);
                if (reportRemainingJavaLangObjectNull) {




                    reportRemaining.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener totalpayableandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of report.totalpayable.get()
            //         is report.totalpayable.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(totalpayable);
            // localize variables for thread safety
            // report != null
            boolean reportJavaLangObjectNull = false;
            // report.totalpayable
            androidx.databinding.ObservableField<java.lang.String> reportTotalpayable = null;
            // report
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo report = mReport;
            // report.totalpayable.get()
            java.lang.String reportTotalpayableGet = null;
            // report.totalpayable != null
            boolean reportTotalpayableJavaLangObjectNull = false;



            reportJavaLangObjectNull = (report) != (null);
            if (reportJavaLangObjectNull) {


                reportTotalpayable = report.totalpayable;

                reportTotalpayableJavaLangObjectNull = (reportTotalpayable) != (null);
                if (reportTotalpayableJavaLangObjectNull) {




                    reportTotalpayable.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener totalpurchasesandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of report.totalpurchases.get()
            //         is report.totalpurchases.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(totalpurchases);
            // localize variables for thread safety
            // report.totalpurchases.get()
            java.lang.String reportTotalpurchasesGet = null;
            // report != null
            boolean reportJavaLangObjectNull = false;
            // report.totalpurchases != null
            boolean reportTotalpurchasesJavaLangObjectNull = false;
            // report
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo report = mReport;
            // report.totalpurchases
            androidx.databinding.ObservableField<java.lang.String> reportTotalpurchases = null;



            reportJavaLangObjectNull = (report) != (null);
            if (reportJavaLangObjectNull) {


                reportTotalpurchases = report.totalpurchases;

                reportTotalpurchasesJavaLangObjectNull = (reportTotalpurchases) != (null);
                if (reportTotalpurchasesJavaLangObjectNull) {




                    reportTotalpurchases.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener totalrecoveryandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of report.totalrecovery.get()
            //         is report.totalrecovery.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(totalrecovery);
            // localize variables for thread safety
            // report != null
            boolean reportJavaLangObjectNull = false;
            // report.totalrecovery
            androidx.databinding.ObservableField<java.lang.String> reportTotalrecovery = null;
            // report
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo report = mReport;
            // report.totalrecovery != null
            boolean reportTotalrecoveryJavaLangObjectNull = false;
            // report.totalrecovery.get()
            java.lang.String reportTotalrecoveryGet = null;



            reportJavaLangObjectNull = (report) != (null);
            if (reportJavaLangObjectNull) {


                reportTotalrecovery = report.totalrecovery;

                reportTotalrecoveryJavaLangObjectNull = (reportTotalrecovery) != (null);
                if (reportTotalrecoveryJavaLangObjectNull) {




                    reportTotalrecovery.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentReportBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }
    private FragmentReportBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 7
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.FrameLayout) bindings[0]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[7]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[25]
            , (androidx.cardview.widget.CardView) bindings[8]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[15]
            , (androidx.appcompat.widget.AppCompatButton) bindings[21]
            , (android.widget.LinearLayout) bindings[20]
            , (androidx.appcompat.widget.AppCompatButton) bindings[22]
            , (androidx.appcompat.widget.AppCompatButton) bindings[23]
            );
        this.container.setTag(null);
        this.farmersserved.setTag(null);
        this.header.setTag(null);
        this.recoverypercent.setTag(null);
        this.remainingBags.setTag(null);
        this.totalpayable.setTag(null);
        this.totalpurchases.setTag(null);
        this.totalrecovery.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x100L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.report == variableId) {
            setReport((com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setReport(@Nullable com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo Report) {
        this.mReport = Report;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.report);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeReportRemaining((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeReportRecoverypercent((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeReportTotalpayable((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeReportFarmersserved((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeReportTotalrecovery((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeReportTotalpurchases((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeReportHeader((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeReportRemaining(androidx.databinding.ObservableField<java.lang.String> ReportRemaining, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeReportRecoverypercent(androidx.databinding.ObservableField<java.lang.String> ReportRecoverypercent, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeReportTotalpayable(androidx.databinding.ObservableField<java.lang.String> ReportTotalpayable, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeReportFarmersserved(androidx.databinding.ObservableField<java.lang.String> ReportFarmersserved, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeReportTotalrecovery(androidx.databinding.ObservableField<java.lang.String> ReportTotalrecovery, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeReportTotalpurchases(androidx.databinding.ObservableField<java.lang.String> ReportTotalpurchases, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeReportHeader(androidx.databinding.ObservableField<java.lang.String> ReportHeader, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        androidx.databinding.ObservableField<java.lang.String> reportRemaining = null;
        androidx.databinding.ObservableField<java.lang.String> reportRecoverypercent = null;
        java.lang.String reportTotalrecoveryGet = null;
        androidx.databinding.ObservableField<java.lang.String> reportTotalpayable = null;
        androidx.databinding.ObservableField<java.lang.String> reportFarmersserved = null;
        java.lang.String reportHeaderGet = null;
        androidx.databinding.ObservableField<java.lang.String> reportTotalrecovery = null;
        androidx.databinding.ObservableField<java.lang.String> reportTotalpurchases = null;
        java.lang.String reportFarmersservedGet = null;
        java.lang.String reportTotalpayableGet = null;
        androidx.databinding.ObservableField<java.lang.String> reportHeader = null;
        java.lang.String reportRemainingGet = null;
        com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo report = mReport;
        java.lang.String reportTotalpurchasesGet = null;
        java.lang.String reportRecoverypercentGet = null;

        if ((dirtyFlags & 0x1ffL) != 0) {


            if ((dirtyFlags & 0x181L) != 0) {

                    if (report != null) {
                        // read report.remaining
                        reportRemaining = report.remaining;
                    }
                    updateRegistration(0, reportRemaining);


                    if (reportRemaining != null) {
                        // read report.remaining.get()
                        reportRemainingGet = reportRemaining.get();
                    }
            }
            if ((dirtyFlags & 0x182L) != 0) {

                    if (report != null) {
                        // read report.recoverypercent
                        reportRecoverypercent = report.recoverypercent;
                    }
                    updateRegistration(1, reportRecoverypercent);


                    if (reportRecoverypercent != null) {
                        // read report.recoverypercent.get()
                        reportRecoverypercentGet = reportRecoverypercent.get();
                    }
            }
            if ((dirtyFlags & 0x184L) != 0) {

                    if (report != null) {
                        // read report.totalpayable
                        reportTotalpayable = report.totalpayable;
                    }
                    updateRegistration(2, reportTotalpayable);


                    if (reportTotalpayable != null) {
                        // read report.totalpayable.get()
                        reportTotalpayableGet = reportTotalpayable.get();
                    }
            }
            if ((dirtyFlags & 0x188L) != 0) {

                    if (report != null) {
                        // read report.farmersserved
                        reportFarmersserved = report.farmersserved;
                    }
                    updateRegistration(3, reportFarmersserved);


                    if (reportFarmersserved != null) {
                        // read report.farmersserved.get()
                        reportFarmersservedGet = reportFarmersserved.get();
                    }
            }
            if ((dirtyFlags & 0x190L) != 0) {

                    if (report != null) {
                        // read report.totalrecovery
                        reportTotalrecovery = report.totalrecovery;
                    }
                    updateRegistration(4, reportTotalrecovery);


                    if (reportTotalrecovery != null) {
                        // read report.totalrecovery.get()
                        reportTotalrecoveryGet = reportTotalrecovery.get();
                    }
            }
            if ((dirtyFlags & 0x1a0L) != 0) {

                    if (report != null) {
                        // read report.totalpurchases
                        reportTotalpurchases = report.totalpurchases;
                    }
                    updateRegistration(5, reportTotalpurchases);


                    if (reportTotalpurchases != null) {
                        // read report.totalpurchases.get()
                        reportTotalpurchasesGet = reportTotalpurchases.get();
                    }
            }
            if ((dirtyFlags & 0x1c0L) != 0) {

                    if (report != null) {
                        // read report.header
                        reportHeader = report.header;
                    }
                    updateRegistration(6, reportHeader);


                    if (reportHeader != null) {
                        // read report.header.get()
                        reportHeaderGet = reportHeader.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x188L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.farmersserved, reportFarmersservedGet);
        }
        if ((dirtyFlags & 0x100L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.farmersserved, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, farmersservedandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.header, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, headerandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.recoverypercent, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, recoverypercentandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.remainingBags, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, remainingBagsandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.totalpayable, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, totalpayableandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.totalpurchases, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, totalpurchasesandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.totalrecovery, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, totalrecoveryandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x1c0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.header, reportHeaderGet);
        }
        if ((dirtyFlags & 0x182L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.recoverypercent, reportRecoverypercentGet);
        }
        if ((dirtyFlags & 0x181L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.remainingBags, reportRemainingGet);
        }
        if ((dirtyFlags & 0x184L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.totalpayable, reportTotalpayableGet);
        }
        if ((dirtyFlags & 0x1a0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.totalpurchases, reportTotalpurchasesGet);
        }
        if ((dirtyFlags & 0x190L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.totalrecovery, reportTotalrecoveryGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): report.remaining
        flag 1 (0x2L): report.recoverypercent
        flag 2 (0x3L): report.totalpayable
        flag 3 (0x4L): report.farmersserved
        flag 4 (0x5L): report.totalrecovery
        flag 5 (0x6L): report.totalpurchases
        flag 6 (0x7L): report.header
        flag 7 (0x8L): report
        flag 8 (0x9L): null
    flag mapping end*/
    //end
}