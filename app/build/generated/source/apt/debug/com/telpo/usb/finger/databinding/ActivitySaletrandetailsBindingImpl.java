package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySaletrandetailsBindingImpl extends ActivitySaletrandetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.back, 1);
        sViewsWithIds.put(R.id.farmerimg, 2);
        sViewsWithIds.put(R.id.farmername, 3);
        sViewsWithIds.put(R.id.farmcount, 4);
        sViewsWithIds.put(R.id.farmerid, 5);
        sViewsWithIds.put(R.id.community, 6);
        sViewsWithIds.put(R.id.summary, 7);
        sViewsWithIds.put(R.id.tooltip1, 8);
        sViewsWithIds.put(R.id.transid, 9);
        sViewsWithIds.put(R.id.cost_layout, 10);
        sViewsWithIds.put(R.id.cost, 11);
        sViewsWithIds.put(R.id.sub_layout, 12);
        sViewsWithIds.put(R.id.sub, 13);
        sViewsWithIds.put(R.id.pmethod_layout, 14);
        sViewsWithIds.put(R.id.pmethod, 15);
        sViewsWithIds.put(R.id.agent_layout, 16);
        sViewsWithIds.put(R.id.agent, 17);
        sViewsWithIds.put(R.id.tendered_layout, 18);
        sViewsWithIds.put(R.id.tendered, 19);
        sViewsWithIds.put(R.id.change_layout, 20);
        sViewsWithIds.put(R.id.bagspayable, 21);
        sViewsWithIds.put(R.id.acreage_layout, 22);
        sViewsWithIds.put(R.id.acreage, 23);
        sViewsWithIds.put(R.id.date_layout, 24);
        sViewsWithIds.put(R.id.date, 25);
        sViewsWithIds.put(R.id.declaration_label, 26);
        sViewsWithIds.put(R.id.recycler, 27);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySaletrandetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 28, sIncludes, sViewsWithIds));
    }
    private ActivitySaletrandetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[16]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[14]
            , (androidx.recyclerview.widget.RecyclerView) bindings[27]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[12]
            , (androidx.cardview.widget.CardView) bindings[7]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[18]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.TextView) bindings[9]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
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