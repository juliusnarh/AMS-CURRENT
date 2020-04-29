package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityFarmer2BindingImpl extends ActivityFarmer2Binding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.floating_search_view, 1);
        sViewsWithIds.put(R.id.recycler_layout, 2);
        sViewsWithIds.put(R.id.search_server_layout, 3);
        sViewsWithIds.put(R.id.recycler, 4);
        sViewsWithIds.put(R.id.nsv, 5);
        sViewsWithIds.put(R.id.lay1, 6);
        sViewsWithIds.put(R.id.amsimg, 7);
        sViewsWithIds.put(R.id.btnverify, 8);
        sViewsWithIds.put(R.id.btnregister, 9);
        sViewsWithIds.put(R.id.btnsearchserver, 10);
        sViewsWithIds.put(R.id.btnsearch, 11);
        sViewsWithIds.put(R.id.btn_search_aggregator, 12);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityFarmer2BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityFarmer2BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[7]
            , (android.widget.Button) bindings[12]
            , (android.widget.Button) bindings[9]
            , (android.widget.Button) bindings[11]
            , (android.widget.Button) bindings[10]
            , (android.widget.Button) bindings[8]
            , (com.arlib.floatingsearchview.FloatingSearchView) bindings[1]
            , (android.widget.LinearLayout) bindings[6]
            , (androidx.core.widget.NestedScrollView) bindings[5]
            , (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (androidx.core.widget.NestedScrollView) bindings[2]
            , (android.widget.RelativeLayout) bindings[3]
            );
        this.parentView.setTag(null);
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