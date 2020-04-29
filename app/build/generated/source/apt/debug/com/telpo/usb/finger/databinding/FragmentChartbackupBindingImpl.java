package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentChartbackupBindingImpl extends FragmentChartbackupBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.demo_1, 12);
        sViewsWithIds.put(R.id.demo_2, 13);
        sViewsWithIds.put(R.id.inventory_1, 14);
        sViewsWithIds.put(R.id.salestran_1, 15);
        sViewsWithIds.put(R.id.salestran_2, 16);
        sViewsWithIds.put(R.id.declaration_1, 17);
        sViewsWithIds.put(R.id.scaletran_2, 18);
        sViewsWithIds.put(R.id.scaletran_3, 19);
    }
    // views
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView10;
    @NonNull
    private final android.widget.TextView mboundView11;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    @NonNull
    private final android.widget.TextView mboundView7;
    @NonNull
    private final android.widget.TextView mboundView8;
    @NonNull
    private final android.widget.TextView mboundView9;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of chart.regfarmers.get()
            //         is chart.regfarmers.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView1);
            // localize variables for thread safety
            // chart
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
            // chart.regfarmers.get()
            java.lang.String chartRegfarmersGet = null;
            // chart.regfarmers != null
            boolean chartRegfarmersJavaLangObjectNull = false;
            // chart.regfarmers
            androidx.databinding.ObservableField<java.lang.String> chartRegfarmers = null;
            // chart != null
            boolean chartJavaLangObjectNull = false;



            chartJavaLangObjectNull = (chart) != (null);
            if (chartJavaLangObjectNull) {


                chartRegfarmers = chart.regfarmers;

                chartRegfarmersJavaLangObjectNull = (chartRegfarmers) != (null);
                if (chartRegfarmersJavaLangObjectNull) {




                    chartRegfarmers.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView10androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of chart.totalpurchase.get()
            //         is chart.totalpurchase.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView10);
            // localize variables for thread safety
            // chart
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
            // chart.totalpurchase != null
            boolean chartTotalpurchaseJavaLangObjectNull = false;
            // chart != null
            boolean chartJavaLangObjectNull = false;
            // chart.totalpurchase
            androidx.databinding.ObservableField<java.lang.String> chartTotalpurchase = null;
            // chart.totalpurchase.get()
            java.lang.String chartTotalpurchaseGet = null;



            chartJavaLangObjectNull = (chart) != (null);
            if (chartJavaLangObjectNull) {


                chartTotalpurchase = chart.totalpurchase;

                chartTotalpurchaseJavaLangObjectNull = (chartTotalpurchase) != (null);
                if (chartTotalpurchaseJavaLangObjectNull) {




                    chartTotalpurchase.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView11androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of chart.recov.get()
            //         is chart.recov.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView11);
            // localize variables for thread safety
            // chart
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
            // chart.recov
            androidx.databinding.ObservableField<java.lang.String> chartRecov = null;
            // chart != null
            boolean chartJavaLangObjectNull = false;
            // chart.recov.get()
            java.lang.String chartRecovGet = null;
            // chart.recov != null
            boolean chartRecovJavaLangObjectNull = false;



            chartJavaLangObjectNull = (chart) != (null);
            if (chartJavaLangObjectNull) {


                chartRecov = chart.recov;

                chartRecovJavaLangObjectNull = (chartRecov) != (null);
                if (chartRecovJavaLangObjectNull) {




                    chartRecov.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of chart.male.get()
            //         is chart.male.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // chart
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
            // chart.male
            androidx.databinding.ObservableField<java.lang.String> chartMale = null;
            // chart.male.get()
            java.lang.String chartMaleGet = null;
            // chart != null
            boolean chartJavaLangObjectNull = false;
            // chart.male != null
            boolean chartMaleJavaLangObjectNull = false;



            chartJavaLangObjectNull = (chart) != (null);
            if (chartJavaLangObjectNull) {


                chartMale = chart.male;

                chartMaleJavaLangObjectNull = (chartMale) != (null);
                if (chartMaleJavaLangObjectNull) {




                    chartMale.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of chart.female.get()
            //         is chart.female.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // chart
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
            // chart.female
            androidx.databinding.ObservableField<java.lang.String> chartFemale = null;
            // chart.female.get()
            java.lang.String chartFemaleGet = null;
            // chart != null
            boolean chartJavaLangObjectNull = false;
            // chart.female != null
            boolean chartFemaleJavaLangObjectNull = false;



            chartJavaLangObjectNull = (chart) != (null);
            if (chartJavaLangObjectNull) {


                chartFemale = chart.female;

                chartFemaleJavaLangObjectNull = (chartFemale) != (null);
                if (chartFemaleJavaLangObjectNull) {




                    chartFemale.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of chart.subsidized.get()
            //         is chart.subsidized.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // chart
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
            // chart.subsidized
            androidx.databinding.ObservableField<java.lang.String> chartSubsidized = null;
            // chart.subsidized != null
            boolean chartSubsidizedJavaLangObjectNull = false;
            // chart != null
            boolean chartJavaLangObjectNull = false;
            // chart.subsidized.get()
            java.lang.String chartSubsidizedGet = null;



            chartJavaLangObjectNull = (chart) != (null);
            if (chartJavaLangObjectNull) {


                chartSubsidized = chart.subsidized;

                chartSubsidizedJavaLangObjectNull = (chartSubsidized) != (null);
                if (chartSubsidizedJavaLangObjectNull) {




                    chartSubsidized.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView5androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of chart.nonsubsidized.get()
            //         is chart.nonsubsidized.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView5);
            // localize variables for thread safety
            // chart
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
            // chart.nonsubsidized.get()
            java.lang.String chartNonsubsidizedGet = null;
            // chart != null
            boolean chartJavaLangObjectNull = false;
            // chart.nonsubsidized
            androidx.databinding.ObservableField<java.lang.String> chartNonsubsidized = null;
            // chart.nonsubsidized != null
            boolean chartNonsubsidizedJavaLangObjectNull = false;



            chartJavaLangObjectNull = (chart) != (null);
            if (chartJavaLangObjectNull) {


                chartNonsubsidized = chart.nonsubsidized;

                chartNonsubsidizedJavaLangObjectNull = (chartNonsubsidized) != (null);
                if (chartNonsubsidizedJavaLangObjectNull) {




                    chartNonsubsidized.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView6androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of chart.cash.get()
            //         is chart.cash.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView6);
            // localize variables for thread safety
            // chart
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
            // chart.cash.get()
            java.lang.String chartCashGet = null;
            // chart.cash != null
            boolean chartCashJavaLangObjectNull = false;
            // chart.cash
            androidx.databinding.ObservableField<java.lang.String> chartCash = null;
            // chart != null
            boolean chartJavaLangObjectNull = false;



            chartJavaLangObjectNull = (chart) != (null);
            if (chartJavaLangObjectNull) {


                chartCash = chart.cash;

                chartCashJavaLangObjectNull = (chartCash) != (null);
                if (chartCashJavaLangObjectNull) {




                    chartCash.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView7androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of chart.mm.get()
            //         is chart.mm.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView7);
            // localize variables for thread safety
            // chart
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
            // chart.mm != null
            boolean chartMmJavaLangObjectNull = false;
            // chart.mm.get()
            java.lang.String chartMmGet = null;
            // chart.mm
            androidx.databinding.ObservableField<java.lang.String> chartMm = null;
            // chart != null
            boolean chartJavaLangObjectNull = false;



            chartJavaLangObjectNull = (chart) != (null);
            if (chartJavaLangObjectNull) {


                chartMm = chart.mm;

                chartMmJavaLangObjectNull = (chartMm) != (null);
                if (chartMmJavaLangObjectNull) {




                    chartMm.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView8androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of chart.ba.get()
            //         is chart.ba.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView8);
            // localize variables for thread safety
            // chart
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
            // chart.ba
            androidx.databinding.ObservableField<java.lang.String> chartBa = null;
            // chart != null
            boolean chartJavaLangObjectNull = false;
            // chart.ba.get()
            java.lang.String chartBaGet = null;
            // chart.ba != null
            boolean chartBaJavaLangObjectNull = false;



            chartJavaLangObjectNull = (chart) != (null);
            if (chartJavaLangObjectNull) {


                chartBa = chart.ba;

                chartBaJavaLangObjectNull = (chartBa) != (null);
                if (chartBaJavaLangObjectNull) {




                    chartBa.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView9androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of chart.scaleserved.get()
            //         is chart.scaleserved.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView9);
            // localize variables for thread safety
            // chart
            com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
            // chart.scaleserved != null
            boolean chartScaleservedJavaLangObjectNull = false;
            // chart.scaleserved
            androidx.databinding.ObservableField<java.lang.String> chartScaleserved = null;
            // chart.scaleserved.get()
            java.lang.String chartScaleservedGet = null;
            // chart != null
            boolean chartJavaLangObjectNull = false;



            chartJavaLangObjectNull = (chart) != (null);
            if (chartJavaLangObjectNull) {


                chartScaleserved = chart.scaleserved;

                chartScaleservedJavaLangObjectNull = (chartScaleserved) != (null);
                if (chartScaleservedJavaLangObjectNull) {




                    chartScaleserved.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentChartbackupBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private FragmentChartbackupBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 11
            , (android.widget.FrameLayout) bindings[0]
            , (com.github.mikephil.charting.charts.PieChart) bindings[17]
            , (com.github.mikephil.charting.charts.PieChart) bindings[12]
            , (com.github.mikephil.charting.charts.BarChart) bindings[13]
            , (com.github.mikephil.charting.charts.BarChart) bindings[14]
            , (com.github.mikephil.charting.charts.PieChart) bindings[15]
            , (com.github.mikephil.charting.charts.BarChart) bindings[16]
            , (com.github.mikephil.charting.charts.PieChart) bindings[18]
            , (com.github.mikephil.charting.charts.LineChart) bindings[19]
            );
        this.container.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView10 = (android.widget.TextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView11 = (android.widget.TextView) bindings[11];
        this.mboundView11.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (android.widget.TextView) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.TextView) bindings[9];
        this.mboundView9.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1000L;
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
        if (BR.chart == variableId) {
            setChart((com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setChart(@Nullable com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo Chart) {
        this.mChart = Chart;
        synchronized(this) {
            mDirtyFlags |= 0x800L;
        }
        notifyPropertyChanged(BR.chart);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeChartSubsidized((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeChartFemale((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeChartMale((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeChartRecov((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeChartTotalpurchase((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeChartRegfarmers((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeChartNonsubsidized((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 7 :
                return onChangeChartCash((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 8 :
                return onChangeChartBa((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 9 :
                return onChangeChartScaleserved((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 10 :
                return onChangeChartMm((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeChartSubsidized(androidx.databinding.ObservableField<java.lang.String> ChartSubsidized, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChartFemale(androidx.databinding.ObservableField<java.lang.String> ChartFemale, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChartMale(androidx.databinding.ObservableField<java.lang.String> ChartMale, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChartRecov(androidx.databinding.ObservableField<java.lang.String> ChartRecov, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChartTotalpurchase(androidx.databinding.ObservableField<java.lang.String> ChartTotalpurchase, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChartRegfarmers(androidx.databinding.ObservableField<java.lang.String> ChartRegfarmers, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChartNonsubsidized(androidx.databinding.ObservableField<java.lang.String> ChartNonsubsidized, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChartCash(androidx.databinding.ObservableField<java.lang.String> ChartCash, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChartBa(androidx.databinding.ObservableField<java.lang.String> ChartBa, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChartScaleserved(androidx.databinding.ObservableField<java.lang.String> ChartScaleserved, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChartMm(androidx.databinding.ObservableField<java.lang.String> ChartMm, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x400L;
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
        androidx.databinding.ObservableField<java.lang.String> chartSubsidized = null;
        java.lang.String chartRecovGet = null;
        com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo chart = mChart;
        java.lang.String chartFemaleGet = null;
        java.lang.String chartMaleGet = null;
        java.lang.String chartScaleservedGet = null;
        androidx.databinding.ObservableField<java.lang.String> chartFemale = null;
        androidx.databinding.ObservableField<java.lang.String> chartMale = null;
        androidx.databinding.ObservableField<java.lang.String> chartRecov = null;
        androidx.databinding.ObservableField<java.lang.String> chartTotalpurchase = null;
        androidx.databinding.ObservableField<java.lang.String> chartRegfarmers = null;
        androidx.databinding.ObservableField<java.lang.String> chartNonsubsidized = null;
        java.lang.String chartSubsidizedGet = null;
        androidx.databinding.ObservableField<java.lang.String> chartCash = null;
        java.lang.String chartRegfarmersGet = null;
        androidx.databinding.ObservableField<java.lang.String> chartBa = null;
        androidx.databinding.ObservableField<java.lang.String> chartScaleserved = null;
        java.lang.String chartCashGet = null;
        java.lang.String chartNonsubsidizedGet = null;
        androidx.databinding.ObservableField<java.lang.String> chartMm = null;
        java.lang.String chartBaGet = null;
        java.lang.String chartMmGet = null;
        java.lang.String chartTotalpurchaseGet = null;

        if ((dirtyFlags & 0x1fffL) != 0) {


            if ((dirtyFlags & 0x1801L) != 0) {

                    if (chart != null) {
                        // read chart.subsidized
                        chartSubsidized = chart.subsidized;
                    }
                    updateRegistration(0, chartSubsidized);


                    if (chartSubsidized != null) {
                        // read chart.subsidized.get()
                        chartSubsidizedGet = chartSubsidized.get();
                    }
            }
            if ((dirtyFlags & 0x1802L) != 0) {

                    if (chart != null) {
                        // read chart.female
                        chartFemale = chart.female;
                    }
                    updateRegistration(1, chartFemale);


                    if (chartFemale != null) {
                        // read chart.female.get()
                        chartFemaleGet = chartFemale.get();
                    }
            }
            if ((dirtyFlags & 0x1804L) != 0) {

                    if (chart != null) {
                        // read chart.male
                        chartMale = chart.male;
                    }
                    updateRegistration(2, chartMale);


                    if (chartMale != null) {
                        // read chart.male.get()
                        chartMaleGet = chartMale.get();
                    }
            }
            if ((dirtyFlags & 0x1808L) != 0) {

                    if (chart != null) {
                        // read chart.recov
                        chartRecov = chart.recov;
                    }
                    updateRegistration(3, chartRecov);


                    if (chartRecov != null) {
                        // read chart.recov.get()
                        chartRecovGet = chartRecov.get();
                    }
            }
            if ((dirtyFlags & 0x1810L) != 0) {

                    if (chart != null) {
                        // read chart.totalpurchase
                        chartTotalpurchase = chart.totalpurchase;
                    }
                    updateRegistration(4, chartTotalpurchase);


                    if (chartTotalpurchase != null) {
                        // read chart.totalpurchase.get()
                        chartTotalpurchaseGet = chartTotalpurchase.get();
                    }
            }
            if ((dirtyFlags & 0x1820L) != 0) {

                    if (chart != null) {
                        // read chart.regfarmers
                        chartRegfarmers = chart.regfarmers;
                    }
                    updateRegistration(5, chartRegfarmers);


                    if (chartRegfarmers != null) {
                        // read chart.regfarmers.get()
                        chartRegfarmersGet = chartRegfarmers.get();
                    }
            }
            if ((dirtyFlags & 0x1840L) != 0) {

                    if (chart != null) {
                        // read chart.nonsubsidized
                        chartNonsubsidized = chart.nonsubsidized;
                    }
                    updateRegistration(6, chartNonsubsidized);


                    if (chartNonsubsidized != null) {
                        // read chart.nonsubsidized.get()
                        chartNonsubsidizedGet = chartNonsubsidized.get();
                    }
            }
            if ((dirtyFlags & 0x1880L) != 0) {

                    if (chart != null) {
                        // read chart.cash
                        chartCash = chart.cash;
                    }
                    updateRegistration(7, chartCash);


                    if (chartCash != null) {
                        // read chart.cash.get()
                        chartCashGet = chartCash.get();
                    }
            }
            if ((dirtyFlags & 0x1900L) != 0) {

                    if (chart != null) {
                        // read chart.ba
                        chartBa = chart.ba;
                    }
                    updateRegistration(8, chartBa);


                    if (chartBa != null) {
                        // read chart.ba.get()
                        chartBaGet = chartBa.get();
                    }
            }
            if ((dirtyFlags & 0x1a00L) != 0) {

                    if (chart != null) {
                        // read chart.scaleserved
                        chartScaleserved = chart.scaleserved;
                    }
                    updateRegistration(9, chartScaleserved);


                    if (chartScaleserved != null) {
                        // read chart.scaleserved.get()
                        chartScaleservedGet = chartScaleserved.get();
                    }
            }
            if ((dirtyFlags & 0x1c00L) != 0) {

                    if (chart != null) {
                        // read chart.mm
                        chartMm = chart.mm;
                    }
                    updateRegistration(10, chartMm);


                    if (chartMm != null) {
                        // read chart.mm.get()
                        chartMmGet = chartMm.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1820L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, chartRegfarmersGet);
        }
        if ((dirtyFlags & 0x1000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView10, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView10androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView11, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView11androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView5, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView5androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView6, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView6androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView7, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView7androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView8, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView8androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView9, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView9androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x1810L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView10, chartTotalpurchaseGet);
        }
        if ((dirtyFlags & 0x1808L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView11, chartRecovGet);
        }
        if ((dirtyFlags & 0x1804L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, chartMaleGet);
        }
        if ((dirtyFlags & 0x1802L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, chartFemaleGet);
        }
        if ((dirtyFlags & 0x1801L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, chartSubsidizedGet);
        }
        if ((dirtyFlags & 0x1840L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, chartNonsubsidizedGet);
        }
        if ((dirtyFlags & 0x1880L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, chartCashGet);
        }
        if ((dirtyFlags & 0x1c00L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, chartMmGet);
        }
        if ((dirtyFlags & 0x1900L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, chartBaGet);
        }
        if ((dirtyFlags & 0x1a00L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, chartScaleservedGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): chart.subsidized
        flag 1 (0x2L): chart.female
        flag 2 (0x3L): chart.male
        flag 3 (0x4L): chart.recov
        flag 4 (0x5L): chart.totalpurchase
        flag 5 (0x6L): chart.regfarmers
        flag 6 (0x7L): chart.nonsubsidized
        flag 7 (0x8L): chart.cash
        flag 8 (0x9L): chart.ba
        flag 9 (0xaL): chart.scaleserved
        flag 10 (0xbL): chart.mm
        flag 11 (0xcL): chart
        flag 12 (0xdL): null
    flag mapping end*/
    //end
}