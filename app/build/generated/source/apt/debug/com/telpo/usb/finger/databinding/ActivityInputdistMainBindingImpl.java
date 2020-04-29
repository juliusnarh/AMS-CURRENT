package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityInputdistMainBindingImpl extends ActivityInputdistMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(17);
        sIncludes.setIncludes(0, 
            new String[] {"cart_bottom_sheet"},
            new int[] {4},
            new int[] {com.telpo.usb.finger.R.layout.cart_bottom_sheet});
        sIncludes.setIncludes(1, 
            new String[] {"recycler_items", "recycler_service"},
            new int[] {2, 3},
            new int[] {com.telpo.usb.finger.R.layout.recycler_items,
                com.telpo.usb.finger.R.layout.recycler_service});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.snuffooo2, 5);
        sViewsWithIds.put(R.id.farmerCard, 6);
        sViewsWithIds.put(R.id.farmer_img, 7);
        sViewsWithIds.put(R.id.farmer_code, 8);
        sViewsWithIds.put(R.id.farmer_name, 9);
        sViewsWithIds.put(R.id.farmer_number, 10);
        sViewsWithIds.put(R.id.subsidized_btn, 11);
        sViewsWithIds.put(R.id.main_toolbar, 12);
        sViewsWithIds.put(R.id.snuffooo, 13);
        sViewsWithIds.put(R.id.products, 14);
        sViewsWithIds.put(R.id.services, 15);
        sViewsWithIds.put(R.id.bottomfab, 16);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityInputdistMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private ActivityInputdistMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[16]
            , (com.telpo.usb.finger.databinding.CartBottomSheetBinding) bindings[4]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (android.widget.TextView) bindings[8]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (com.telpo.usb.finger.databinding.RecyclerItemsBinding) bindings[2]
            , (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0]
            , (com.telpo.usb.finger.utils.SimpleToolbar) bindings[12]
            , (android.widget.TextView) bindings[14]
            , (com.telpo.usb.finger.databinding.RecyclerServiceBinding) bindings[3]
            , (android.widget.TextView) bindings[15]
            , (androidx.core.widget.NestedScrollView) bindings[13]
            , (android.widget.FrameLayout) bindings[5]
            , (android.widget.Button) bindings[11]
            );
        this.mainContent.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        itemsIncluded.invalidateAll();
        serviceIncluded.invalidateAll();
        bottomsheetIncluded.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (itemsIncluded.hasPendingBindings()) {
            return true;
        }
        if (serviceIncluded.hasPendingBindings()) {
            return true;
        }
        if (bottomsheetIncluded.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        itemsIncluded.setLifecycleOwner(lifecycleOwner);
        serviceIncluded.setLifecycleOwner(lifecycleOwner);
        bottomsheetIncluded.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeBottomsheetIncluded((com.telpo.usb.finger.databinding.CartBottomSheetBinding) object, fieldId);
            case 1 :
                return onChangeItemsIncluded((com.telpo.usb.finger.databinding.RecyclerItemsBinding) object, fieldId);
            case 2 :
                return onChangeServiceIncluded((com.telpo.usb.finger.databinding.RecyclerServiceBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeBottomsheetIncluded(com.telpo.usb.finger.databinding.CartBottomSheetBinding BottomsheetIncluded, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeItemsIncluded(com.telpo.usb.finger.databinding.RecyclerItemsBinding ItemsIncluded, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeServiceIncluded(com.telpo.usb.finger.databinding.RecyclerServiceBinding ServiceIncluded, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        // batch finished
        executeBindingsOn(itemsIncluded);
        executeBindingsOn(serviceIncluded);
        executeBindingsOn(bottomsheetIncluded);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): bottomsheetIncluded
        flag 1 (0x2L): itemsIncluded
        flag 2 (0x3L): serviceIncluded
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}