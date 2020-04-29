package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class HouseholdsDataBindingImpl extends HouseholdsDataBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.householdedit, 5);
        sViewsWithIds.put(R.id.hsecard, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public HouseholdsDataBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private HouseholdsDataBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[5]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            );
        this.fullname.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.photo.setTag(null);
        this.relationship.setTag(null);
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
        if (BR.household == variableId) {
            setHousehold((com.telpo.usb.finger.pojo.FarmerRegisty) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHousehold(@Nullable com.telpo.usb.finger.pojo.FarmerRegisty Household) {
        this.mHousehold = Household;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.household);
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
        java.lang.String householdRelationship = null;
        com.telpo.usb.finger.pojo.FarmerRegisty household = mHousehold;
        java.lang.String householdFullname = null;
        byte[] householdPhoto = null;
        java.lang.String householdTelephone = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (household != null) {
                    // read household.relationship
                    householdRelationship = household.getRelationship();
                    // read household.fullname
                    householdFullname = household.getFullname();
                    // read household.photo
                    householdPhoto = household.getPhoto();
                    // read household.telephone
                    householdTelephone = household.getTelephone();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.fullname, householdFullname);
            com.telpo.usb.finger.activities.registration.HouseholdSearchActivity.setImageViewResource(this.photo, householdPhoto);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.relationship, householdRelationship);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.telephone, householdTelephone);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): household
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}