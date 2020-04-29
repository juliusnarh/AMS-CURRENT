package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentFarmerProfileServicesBindingImpl extends FragmentFarmerProfileServicesBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.expandable_layout1, 1);
        sViewsWithIds.put(R.id.firstLayer1, 2);
        sViewsWithIds.put(R.id.activityheader, 3);
        sViewsWithIds.put(R.id.addactivity, 4);
        sViewsWithIds.put(R.id.activitystats, 5);
        sViewsWithIds.put(R.id.activityarrow, 6);
        sViewsWithIds.put(R.id.activity_recyclerview, 7);
        sViewsWithIds.put(R.id.expandable_layout2, 8);
        sViewsWithIds.put(R.id.firstLayer2, 9);
        sViewsWithIds.put(R.id.farmheader, 10);
        sViewsWithIds.put(R.id.addfarm, 11);
        sViewsWithIds.put(R.id.farmstats, 12);
        sViewsWithIds.put(R.id.farmarrow, 13);
        sViewsWithIds.put(R.id.farm_recyclerview, 14);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentFarmerProfileServicesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private FragmentFarmerProfileServicesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.Button) bindings[4]
            , (android.widget.Button) bindings[11]
            , (com.silencedut.expandablelayout.ExpandableLayout) bindings[1]
            , (com.silencedut.expandablelayout.ExpandableLayout) bindings[8]
            , (androidx.recyclerview.widget.RecyclerView) bindings[14]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.TextView) bindings[12]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.RelativeLayout) bindings[9]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}