package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogAddinputBindingImpl extends DialogAddinputBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.close, 8);
        sViewsWithIds.put(R.id.inputdescription, 9);
        sViewsWithIds.put(R.id.inputimage, 10);
        sViewsWithIds.put(R.id.save, 11);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogAddinputBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private DialogAddinputBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[2]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[7]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[9]
            , (com.mikhaellopez.circularimageview.CircularImageView) bindings[10]
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[4]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[11]
            );
        this.category.setTag(null);
        this.costPrice.setTag(null);
        this.inputdealer.setTag(null);
        this.inputname.setTag(null);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.measurement.setTag(null);
        this.quantity.setTag(null);
        this.salePrice.setTag(null);
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
        if ((dirtyFlags & 0x1L) != 0) {
            // api target 1

            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.category, true, (java.lang.String)null, (boolean)false);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.costPrice, true, (java.lang.String)null, (boolean)false);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.inputdealer, true, (java.lang.String)null, (boolean)false);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.inputname, true, (java.lang.String)null, (boolean)false);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.measurement, true, (java.lang.String)null, (boolean)false);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.quantity, true, (java.lang.String)null, (boolean)false);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.salePrice, true, (java.lang.String)null, (boolean)false);
        }
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