package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentActionsBindingImpl extends FragmentActionsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.searchfarmer, 1);
        sViewsWithIds.put(R.id.addproduct, 2);
        sViewsWithIds.put(R.id.addservice, 3);
        sViewsWithIds.put(R.id.backupdata, 4);
        sViewsWithIds.put(R.id.syncfiles, 5);
        sViewsWithIds.put(R.id.synced, 6);
        sViewsWithIds.put(R.id.manageserviceproviders, 7);
        sViewsWithIds.put(R.id.addserviceprovider, 8);
        sViewsWithIds.put(R.id.forservice, 9);
        sViewsWithIds.put(R.id.view_edit_serviceprovider, 10);
        sViewsWithIds.put(R.id.manageservicetype, 11);
        sViewsWithIds.put(R.id.addservicetype, 12);
        sViewsWithIds.put(R.id.forservice2, 13);
        sViewsWithIds.put(R.id.view_edit_servicetype, 14);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentActionsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private FragmentActionsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.FrameLayout) bindings[0]
            , (android.view.View) bindings[9]
            , (android.view.View) bindings[13]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.TextView) bindings[6]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[14]
            );
        this.container.setTag(null);
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