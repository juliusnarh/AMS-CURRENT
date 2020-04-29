package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityDetailsBindingImpl extends ActivityDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id._l1, 1);
        sViewsWithIds.put(R.id.back, 2);
        sViewsWithIds.put(R.id.farmerimg, 3);
        sViewsWithIds.put(R.id.farmername, 4);
        sViewsWithIds.put(R.id.farmcount, 5);
        sViewsWithIds.put(R.id.farmerid, 6);
        sViewsWithIds.put(R.id.community, 7);
        sViewsWithIds.put(R.id._l2, 8);
        sViewsWithIds.put(R.id.declaration_label, 9);
        sViewsWithIds.put(R.id.modify_recovery, 10);
        sViewsWithIds.put(R.id.declaration, 11);
        sViewsWithIds.put(R.id.transaction_details, 12);
        sViewsWithIds.put(R.id.transid, 13);
        sViewsWithIds.put(R.id.weight_layout, 14);
        sViewsWithIds.put(R.id.weight, 15);
        sViewsWithIds.put(R.id.payable_layout, 16);
        sViewsWithIds.put(R.id.payable, 17);
        sViewsWithIds.put(R.id.amount_layout, 18);
        sViewsWithIds.put(R.id.amount, 19);
        sViewsWithIds.put(R.id.pcid_layout, 20);
        sViewsWithIds.put(R.id.pcid, 21);
        sViewsWithIds.put(R.id.count_layout, 22);
        sViewsWithIds.put(R.id.count, 23);
        sViewsWithIds.put(R.id.tendered_layout, 24);
        sViewsWithIds.put(R.id.tendered, 25);
        sViewsWithIds.put(R.id.amountowing_layout, 26);
        sViewsWithIds.put(R.id.amountowing, 27);
        sViewsWithIds.put(R.id.date_layout, 28);
        sViewsWithIds.put(R.id.date, 29);
        sViewsWithIds.put(R.id.farmerprogress, 30);
        sViewsWithIds.put(R.id.tenderedprogress, 31);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 32, sIncludes, sViewsWithIds));
    }
    private ActivityDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[26]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (at.grabner.circleprogress.CircleProgressView) bindings[30]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[10]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[14]
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