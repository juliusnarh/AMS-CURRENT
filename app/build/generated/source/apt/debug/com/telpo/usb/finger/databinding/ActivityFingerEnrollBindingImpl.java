package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityFingerEnrollBindingImpl extends ActivityFingerEnrollBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 1);
        sViewsWithIds.put(R.id.info, 2);
        sViewsWithIds.put(R.id.fp_image, 3);
        sViewsWithIds.put(R.id.textView, 4);
        sViewsWithIds.put(R.id.lthumb, 5);
        sViewsWithIds.put(R.id.lindex, 6);
        sViewsWithIds.put(R.id.lmiddle, 7);
        sViewsWithIds.put(R.id.lring, 8);
        sViewsWithIds.put(R.id.lpinky, 9);
        sViewsWithIds.put(R.id.textView2, 10);
        sViewsWithIds.put(R.id.rthumb, 11);
        sViewsWithIds.put(R.id.rindex, 12);
        sViewsWithIds.put(R.id.rmiddle, 13);
        sViewsWithIds.put(R.id.rring, 14);
        sViewsWithIds.put(R.id.rpinky, 15);
        sViewsWithIds.put(R.id.enrollfinger, 16);
        sViewsWithIds.put(R.id.savefinger, 17);
        sViewsWithIds.put(R.id.clearall, 18);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityFingerEnrollBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private ActivityFingerEnrollBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[18]
            , (android.widget.Button) bindings[16]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.CheckBox) bindings[6]
            , (android.widget.CheckBox) bindings[7]
            , (android.widget.CheckBox) bindings[9]
            , (android.widget.CheckBox) bindings[8]
            , (android.widget.CheckBox) bindings[5]
            , (android.widget.CheckBox) bindings[12]
            , (android.widget.CheckBox) bindings[13]
            , (android.widget.CheckBox) bindings[15]
            , (android.widget.CheckBox) bindings[14]
            , (android.widget.CheckBox) bindings[11]
            , (android.widget.Button) bindings[17]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[10]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
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