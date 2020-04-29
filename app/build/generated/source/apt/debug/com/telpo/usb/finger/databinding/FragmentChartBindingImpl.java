package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentChartBindingImpl extends FragmentChartBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.declaration_label, 1);
        sViewsWithIds.put(R.id.vmore, 2);
        sViewsWithIds.put(R.id.genderpiechart, 3);
        sViewsWithIds.put(R.id.agebarchart, 4);
        sViewsWithIds.put(R.id.imore, 5);
        sViewsWithIds.put(R.id.saletransaction, 6);
        sViewsWithIds.put(R.id.salestrantotalrevenue, 7);
        sViewsWithIds.put(R.id.recoverytransactionpiechart, 8);
        sViewsWithIds.put(R.id.recoverytransactionlinechart, 9);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentChartBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private FragmentChartBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.github.mikephil.charting.charts.BarChart) bindings[4]
            , (android.widget.FrameLayout) bindings[0]
            , (android.widget.TextView) bindings[1]
            , (com.github.mikephil.charting.charts.PieChart) bindings[3]
            , (android.widget.ImageView) bindings[5]
            , (com.github.mikephil.charting.charts.LineChart) bindings[9]
            , (com.github.mikephil.charting.charts.PieChart) bindings[8]
            , (com.github.mikephil.charting.charts.BarChart) bindings[7]
            , (com.github.mikephil.charting.charts.PieChart) bindings[6]
            , (android.widget.ImageView) bindings[2]
            );
        this.container.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): chart
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}