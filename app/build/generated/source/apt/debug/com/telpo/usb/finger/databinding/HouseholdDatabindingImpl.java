package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class HouseholdDatabindingImpl extends HouseholdDatabinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.hsecard, 5);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public HouseholdDatabindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private HouseholdDatabindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (androidx.cardview.widget.CardView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[3]
            );
        this.fullname.setTag(null);
        this.idnumber.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.photo.setTag(null);
        this.telephone.setTag(null);
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
        if (BR.search == variableId) {
            setSearch((com.telpo.usb.finger.pojo.FarmerRegisty) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSearch(@Nullable com.telpo.usb.finger.pojo.FarmerRegisty Search) {
        this.mSearch = Search;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.search);
        super.requestRebind();
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
        byte[] searchPhoto = null;
        java.lang.String searchFullname = null;
        java.lang.String searchId = null;
        java.lang.String searchTelephone = null;
        com.telpo.usb.finger.pojo.FarmerRegisty search = mSearch;

        if ((dirtyFlags & 0x3L) != 0) {



                if (search != null) {
                    // read search.photo
                    searchPhoto = search.getPhoto();
                    // read search.fullname
                    searchFullname = search.getFullname();
                    // read search.id
                    searchId = search.getId();
                    // read search.telephone
                    searchTelephone = search.getTelephone();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.fullname, searchFullname);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.idnumber, searchId);
            com.telpo.usb.finger.activities.registration.HouseholdSearchActivity.setImageViewResource(this.photo, searchPhoto);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.telephone, searchTelephone);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): search
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}