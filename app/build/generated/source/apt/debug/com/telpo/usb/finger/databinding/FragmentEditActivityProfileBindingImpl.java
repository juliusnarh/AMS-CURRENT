package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentEditActivityProfileBindingImpl extends FragmentEditActivityProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.farminggroup_layout, 11);
        sViewsWithIds.put(R.id.cooperativegroup_layout, 12);
        sViewsWithIds.put(R.id.cocoaincom_layout, 13);
        sViewsWithIds.put(R.id.specialtycocoa_layout, 14);
        sViewsWithIds.put(R.id.certification_layout, 15);
        sViewsWithIds.put(R.id.fundingsource_layout, 16);
        sViewsWithIds.put(R.id.close, 17);
        sViewsWithIds.put(R.id.btnsave, 18);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener boolcincomeandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of activity.boolcocoaincome.get()
            //         is activity.boolcocoaincome.set((java.lang.Boolean) callbackArg_0)
            boolean callbackArg_0 = boolcincome.isChecked();
            // localize variables for thread safety
            // activity.boolcocoaincome
            androidx.databinding.ObservableField<java.lang.Boolean> activityBoolcocoaincome = null;
            // activity != null
            boolean activityJavaLangObjectNull = false;
            // activity.boolcocoaincome != null
            boolean activityBoolcocoaincomeJavaLangObjectNull = false;
            // activity
            com.telpo.usb.finger.pojo.ActivityInfoPojo activity = mActivity;
            // activity.boolcocoaincome.get()
            java.lang.Boolean activityBoolcocoaincomeGet = null;



            activityJavaLangObjectNull = (activity) != (null);
            if (activityJavaLangObjectNull) {


                activityBoolcocoaincome = activity.boolcocoaincome;

                activityBoolcocoaincomeJavaLangObjectNull = (activityBoolcocoaincome) != (null);
                if (activityBoolcocoaincomeJavaLangObjectNull) {




                    activityBoolcocoaincome.set(((java.lang.Boolean) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener boolcopgrpandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of activity.boolcoopmember.get()
            //         is activity.boolcoopmember.set((java.lang.Boolean) callbackArg_0)
            boolean callbackArg_0 = boolcopgrp.isChecked();
            // localize variables for thread safety
            // activity != null
            boolean activityJavaLangObjectNull = false;
            // activity.boolcoopmember != null
            boolean activityBoolcoopmemberJavaLangObjectNull = false;
            // activity.boolcoopmember
            androidx.databinding.ObservableField<java.lang.Boolean> activityBoolcoopmember = null;
            // activity
            com.telpo.usb.finger.pojo.ActivityInfoPojo activity = mActivity;
            // activity.boolcoopmember.get()
            java.lang.Boolean activityBoolcoopmemberGet = null;



            activityJavaLangObjectNull = (activity) != (null);
            if (activityJavaLangObjectNull) {


                activityBoolcoopmember = activity.boolcoopmember;

                activityBoolcoopmemberJavaLangObjectNull = (activityBoolcoopmember) != (null);
                if (activityBoolcoopmemberJavaLangObjectNull) {




                    activityBoolcoopmember.set(((java.lang.Boolean) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener boolgrpmandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of activity.boolgroupmember.get()
            //         is activity.boolgroupmember.set((java.lang.Boolean) callbackArg_0)
            boolean callbackArg_0 = boolgrpm.isChecked();
            // localize variables for thread safety
            // activity.boolgroupmember != null
            boolean activityBoolgroupmemberJavaLangObjectNull = false;
            // activity != null
            boolean activityJavaLangObjectNull = false;
            // activity
            com.telpo.usb.finger.pojo.ActivityInfoPojo activity = mActivity;
            // activity.boolgroupmember.get()
            java.lang.Boolean activityBoolgroupmemberGet = null;
            // activity.boolgroupmember
            androidx.databinding.ObservableField<java.lang.Boolean> activityBoolgroupmember = null;



            activityJavaLangObjectNull = (activity) != (null);
            if (activityJavaLangObjectNull) {


                activityBoolgroupmember = activity.boolgroupmember;

                activityBoolgroupmemberJavaLangObjectNull = (activityBoolgroupmember) != (null);
                if (activityBoolgroupmemberJavaLangObjectNull) {




                    activityBoolgroupmember.set(((java.lang.Boolean) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener boolspeandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of activity.boolspecialty.get()
            //         is activity.boolspecialty.set((java.lang.Boolean) callbackArg_0)
            boolean callbackArg_0 = boolspe.isChecked();
            // localize variables for thread safety
            // activity != null
            boolean activityJavaLangObjectNull = false;
            // activity.boolspecialty
            androidx.databinding.ObservableField<java.lang.Boolean> activityBoolspecialty = null;
            // activity
            com.telpo.usb.finger.pojo.ActivityInfoPojo activity = mActivity;
            // activity.boolspecialty.get()
            java.lang.Boolean activityBoolspecialtyGet = null;
            // activity.boolspecialty != null
            boolean activityBoolspecialtyJavaLangObjectNull = false;



            activityJavaLangObjectNull = (activity) != (null);
            if (activityJavaLangObjectNull) {


                activityBoolspecialty = activity.boolspecialty;

                activityBoolspecialtyJavaLangObjectNull = (activityBoolspecialty) != (null);
                if (activityBoolspecialtyJavaLangObjectNull) {




                    activityBoolspecialty.set(((java.lang.Boolean) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener certificationandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of activity.certified.get()
            //         is activity.certified.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(certification);
            // localize variables for thread safety
            // activity.certified.get()
            java.lang.String activityCertifiedGet = null;
            // activity != null
            boolean activityJavaLangObjectNull = false;
            // activity
            com.telpo.usb.finger.pojo.ActivityInfoPojo activity = mActivity;
            // activity.certified
            androidx.databinding.ObservableField<java.lang.String> activityCertified = null;
            // activity.certified != null
            boolean activityCertifiedJavaLangObjectNull = false;



            activityJavaLangObjectNull = (activity) != (null);
            if (activityJavaLangObjectNull) {


                activityCertified = activity.certified;

                activityCertifiedJavaLangObjectNull = (activityCertified) != (null);
                if (activityCertifiedJavaLangObjectNull) {




                    activityCertified.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener cocoaincomeandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of activity.incomesource.get()
            //         is activity.incomesource.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(cocoaincome);
            // localize variables for thread safety
            // activity.incomesource != null
            boolean activityIncomesourceJavaLangObjectNull = false;
            // activity != null
            boolean activityJavaLangObjectNull = false;
            // activity.incomesource
            androidx.databinding.ObservableField<java.lang.String> activityIncomesource = null;
            // activity
            com.telpo.usb.finger.pojo.ActivityInfoPojo activity = mActivity;
            // activity.incomesource.get()
            java.lang.String activityIncomesourceGet = null;



            activityJavaLangObjectNull = (activity) != (null);
            if (activityJavaLangObjectNull) {


                activityIncomesource = activity.incomesource;

                activityIncomesourceJavaLangObjectNull = (activityIncomesource) != (null);
                if (activityIncomesourceJavaLangObjectNull) {




                    activityIncomesource.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener cooperativegroupandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of activity.coopname.get()
            //         is activity.coopname.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(cooperativegroup);
            // localize variables for thread safety
            // activity != null
            boolean activityJavaLangObjectNull = false;
            // activity.coopname.get()
            java.lang.String activityCoopnameGet = null;
            // activity.coopname != null
            boolean activityCoopnameJavaLangObjectNull = false;
            // activity.coopname
            androidx.databinding.ObservableField<java.lang.String> activityCoopname = null;
            // activity
            com.telpo.usb.finger.pojo.ActivityInfoPojo activity = mActivity;



            activityJavaLangObjectNull = (activity) != (null);
            if (activityJavaLangObjectNull) {


                activityCoopname = activity.coopname;

                activityCoopnameJavaLangObjectNull = (activityCoopname) != (null);
                if (activityCoopnameJavaLangObjectNull) {




                    activityCoopname.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener farminggroupandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of activity.groupname.get()
            //         is activity.groupname.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(farminggroup);
            // localize variables for thread safety
            // activity != null
            boolean activityJavaLangObjectNull = false;
            // activity.groupname
            androidx.databinding.ObservableField<java.lang.String> activityGroupname = null;
            // activity.groupname.get()
            java.lang.String activityGroupnameGet = null;
            // activity
            com.telpo.usb.finger.pojo.ActivityInfoPojo activity = mActivity;
            // activity.groupname != null
            boolean activityGroupnameJavaLangObjectNull = false;



            activityJavaLangObjectNull = (activity) != (null);
            if (activityJavaLangObjectNull) {


                activityGroupname = activity.groupname;

                activityGroupnameJavaLangObjectNull = (activityGroupname) != (null);
                if (activityGroupnameJavaLangObjectNull) {




                    activityGroupname.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener fundingsourceandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of activity.fundingsource.get()
            //         is activity.fundingsource.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(fundingsource);
            // localize variables for thread safety
            // activity != null
            boolean activityJavaLangObjectNull = false;
            // activity.fundingsource != null
            boolean activityFundingsourceJavaLangObjectNull = false;
            // activity.fundingsource
            androidx.databinding.ObservableField<java.lang.String> activityFundingsource = null;
            // activity.fundingsource.get()
            java.lang.String activityFundingsourceGet = null;
            // activity
            com.telpo.usb.finger.pojo.ActivityInfoPojo activity = mActivity;



            activityJavaLangObjectNull = (activity) != (null);
            if (activityJavaLangObjectNull) {


                activityFundingsource = activity.fundingsource;

                activityFundingsourceJavaLangObjectNull = (activityFundingsource) != (null);
                if (activityFundingsourceJavaLangObjectNull) {




                    activityFundingsource.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener specialtycocoaandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of activity.specialtycocoa.get()
            //         is activity.specialtycocoa.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(specialtycocoa);
            // localize variables for thread safety
            // activity != null
            boolean activityJavaLangObjectNull = false;
            // activity.specialtycocoa != null
            boolean activitySpecialtycocoaJavaLangObjectNull = false;
            // activity.specialtycocoa.get()
            java.lang.String activitySpecialtycocoaGet = null;
            // activity
            com.telpo.usb.finger.pojo.ActivityInfoPojo activity = mActivity;
            // activity.specialtycocoa
            androidx.databinding.ObservableField<java.lang.String> activitySpecialtycocoa = null;



            activityJavaLangObjectNull = (activity) != (null);
            if (activityJavaLangObjectNull) {


                activitySpecialtycocoa = activity.specialtycocoa;

                activitySpecialtycocoaJavaLangObjectNull = (activitySpecialtycocoa) != (null);
                if (activitySpecialtycocoaJavaLangObjectNull) {




                    activitySpecialtycocoa.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentEditActivityProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private FragmentEditActivityProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 10
            , (androidx.appcompat.widget.SwitchCompat) bindings[5]
            , (androidx.appcompat.widget.SwitchCompat) bindings[3]
            , (androidx.appcompat.widget.SwitchCompat) bindings[1]
            , (androidx.appcompat.widget.SwitchCompat) bindings[7]
            , (android.widget.Button) bindings[18]
            , (com.google.android.material.textfield.TextInputEditText) bindings[9]
            , (com.google.android.material.textfield.TextInputLayout) bindings[15]
            , (android.widget.Button) bindings[17]
            , (com.google.android.material.textfield.TextInputLayout) bindings[13]
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputLayout) bindings[12]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[11]
            , (com.google.android.material.textfield.TextInputEditText) bindings[10]
            , (com.google.android.material.textfield.TextInputLayout) bindings[16]
            , (com.google.android.material.textfield.TextInputEditText) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[14]
            );
        this.boolcincome.setTag(null);
        this.boolcopgrp.setTag(null);
        this.boolgrpm.setTag(null);
        this.boolspe.setTag(null);
        this.certification.setTag(null);
        this.cocoaincome.setTag(null);
        this.cooperativegroup.setTag(null);
        this.farminggroup.setTag(null);
        this.fundingsource.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.specialtycocoa.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x800L;
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
        if (BR.activity == variableId) {
            setActivity((com.telpo.usb.finger.pojo.ActivityInfoPojo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setActivity(@Nullable com.telpo.usb.finger.pojo.ActivityInfoPojo Activity) {
        this.mActivity = Activity;
        synchronized(this) {
            mDirtyFlags |= 0x400L;
        }
        notifyPropertyChanged(BR.activity);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeActivityBoolcocoaincome((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 1 :
                return onChangeActivityBoolspecialty((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 2 :
                return onChangeActivityBoolcoopmember((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 3 :
                return onChangeActivityCertified((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeActivityCoopname((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeActivityBoolgroupmember((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 6 :
                return onChangeActivityFundingsource((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 7 :
                return onChangeActivityGroupname((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 8 :
                return onChangeActivityIncomesource((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 9 :
                return onChangeActivitySpecialtycocoa((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeActivityBoolcocoaincome(androidx.databinding.ObservableField<java.lang.Boolean> ActivityBoolcocoaincome, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeActivityBoolspecialty(androidx.databinding.ObservableField<java.lang.Boolean> ActivityBoolspecialty, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeActivityBoolcoopmember(androidx.databinding.ObservableField<java.lang.Boolean> ActivityBoolcoopmember, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeActivityCertified(androidx.databinding.ObservableField<java.lang.String> ActivityCertified, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeActivityCoopname(androidx.databinding.ObservableField<java.lang.String> ActivityCoopname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeActivityBoolgroupmember(androidx.databinding.ObservableField<java.lang.Boolean> ActivityBoolgroupmember, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeActivityFundingsource(androidx.databinding.ObservableField<java.lang.String> ActivityFundingsource, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeActivityGroupname(androidx.databinding.ObservableField<java.lang.String> ActivityGroupname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeActivityIncomesource(androidx.databinding.ObservableField<java.lang.String> ActivityIncomesource, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeActivitySpecialtycocoa(androidx.databinding.ObservableField<java.lang.String> ActivitySpecialtycocoa, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
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
        androidx.databinding.ObservableField<java.lang.Boolean> activityBoolcocoaincome = null;
        boolean activitySpecialtycocoaEqualsJavaLangStringCertifiedBooleanTrueBooleanFalse = false;
        androidx.databinding.ObservableField<java.lang.Boolean> activityBoolspecialty = null;
        java.lang.String activityFundingsourceGet = null;
        boolean activitySpecialtycocoaEqualsJavaLangStringCertified = false;
        boolean activityBoolcocoaincomeBooleanFalseBooleanTrue = false;
        boolean androidxDatabindingViewDataBindingSafeUnboxActivityBoolcocoaincomeGet = false;
        com.telpo.usb.finger.pojo.ActivityInfoPojo activity = mActivity;
        androidx.databinding.ObservableField<java.lang.Boolean> activityBoolcoopmember = null;
        java.lang.Boolean activityBoolgroupmemberGet = null;
        androidx.databinding.ObservableField<java.lang.String> activityCertified = null;
        java.lang.Boolean activityBoolcocoaincomeGet = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxActivityBoolspecialtyGet = false;
        java.lang.String activitySpecialtycocoaGet = null;
        java.lang.String activityGroupnameGet = null;
        androidx.databinding.ObservableField<java.lang.String> activityCoopname = null;
        java.lang.String activityCertifiedGet = null;
        java.lang.String activityCoopnameGet = null;
        androidx.databinding.ObservableField<java.lang.Boolean> activityBoolgroupmember = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxActivityBoolgroupmemberGet = false;
        java.lang.String activityIncomesourceGet = null;
        java.lang.Boolean activityBoolspecialtyGet = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxActivityBoolcoopmemberGet = false;
        androidx.databinding.ObservableField<java.lang.String> activityFundingsource = null;
        androidx.databinding.ObservableField<java.lang.String> activityGroupname = null;
        androidx.databinding.ObservableField<java.lang.String> activityIncomesource = null;
        androidx.databinding.ObservableField<java.lang.String> activitySpecialtycocoa = null;
        java.lang.Boolean activityBoolcoopmemberGet = null;

        if ((dirtyFlags & 0xfffL) != 0) {


            if ((dirtyFlags & 0xc01L) != 0) {

                    if (activity != null) {
                        // read activity.boolcocoaincome
                        activityBoolcocoaincome = activity.boolcocoaincome;
                    }
                    updateRegistration(0, activityBoolcocoaincome);


                    if (activityBoolcocoaincome != null) {
                        // read activity.boolcocoaincome.get()
                        activityBoolcocoaincomeGet = activityBoolcocoaincome.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(activity.boolcocoaincome.get())
                    androidxDatabindingViewDataBindingSafeUnboxActivityBoolcocoaincomeGet = androidx.databinding.ViewDataBinding.safeUnbox(activityBoolcocoaincomeGet);
                if((dirtyFlags & 0xc01L) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxActivityBoolcocoaincomeGet) {
                            dirtyFlags |= 0x8000L;
                    }
                    else {
                            dirtyFlags |= 0x4000L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(activity.boolcocoaincome.get()) ? false : true
                    activityBoolcocoaincomeBooleanFalseBooleanTrue = ((androidxDatabindingViewDataBindingSafeUnboxActivityBoolcocoaincomeGet) ? (false) : (true));
            }
            if ((dirtyFlags & 0xc02L) != 0) {

                    if (activity != null) {
                        // read activity.boolspecialty
                        activityBoolspecialty = activity.boolspecialty;
                    }
                    updateRegistration(1, activityBoolspecialty);


                    if (activityBoolspecialty != null) {
                        // read activity.boolspecialty.get()
                        activityBoolspecialtyGet = activityBoolspecialty.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(activity.boolspecialty.get())
                    androidxDatabindingViewDataBindingSafeUnboxActivityBoolspecialtyGet = androidx.databinding.ViewDataBinding.safeUnbox(activityBoolspecialtyGet);
            }
            if ((dirtyFlags & 0xc04L) != 0) {

                    if (activity != null) {
                        // read activity.boolcoopmember
                        activityBoolcoopmember = activity.boolcoopmember;
                    }
                    updateRegistration(2, activityBoolcoopmember);


                    if (activityBoolcoopmember != null) {
                        // read activity.boolcoopmember.get()
                        activityBoolcoopmemberGet = activityBoolcoopmember.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(activity.boolcoopmember.get())
                    androidxDatabindingViewDataBindingSafeUnboxActivityBoolcoopmemberGet = androidx.databinding.ViewDataBinding.safeUnbox(activityBoolcoopmemberGet);
            }
            if ((dirtyFlags & 0xc08L) != 0) {

                    if (activity != null) {
                        // read activity.certified
                        activityCertified = activity.certified;
                    }
                    updateRegistration(3, activityCertified);


                    if (activityCertified != null) {
                        // read activity.certified.get()
                        activityCertifiedGet = activityCertified.get();
                    }
            }
            if ((dirtyFlags & 0xc10L) != 0) {

                    if (activity != null) {
                        // read activity.coopname
                        activityCoopname = activity.coopname;
                    }
                    updateRegistration(4, activityCoopname);


                    if (activityCoopname != null) {
                        // read activity.coopname.get()
                        activityCoopnameGet = activityCoopname.get();
                    }
            }
            if ((dirtyFlags & 0xc20L) != 0) {

                    if (activity != null) {
                        // read activity.boolgroupmember
                        activityBoolgroupmember = activity.boolgroupmember;
                    }
                    updateRegistration(5, activityBoolgroupmember);


                    if (activityBoolgroupmember != null) {
                        // read activity.boolgroupmember.get()
                        activityBoolgroupmemberGet = activityBoolgroupmember.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(activity.boolgroupmember.get())
                    androidxDatabindingViewDataBindingSafeUnboxActivityBoolgroupmemberGet = androidx.databinding.ViewDataBinding.safeUnbox(activityBoolgroupmemberGet);
            }
            if ((dirtyFlags & 0xc40L) != 0) {

                    if (activity != null) {
                        // read activity.fundingsource
                        activityFundingsource = activity.fundingsource;
                    }
                    updateRegistration(6, activityFundingsource);


                    if (activityFundingsource != null) {
                        // read activity.fundingsource.get()
                        activityFundingsourceGet = activityFundingsource.get();
                    }
            }
            if ((dirtyFlags & 0xc80L) != 0) {

                    if (activity != null) {
                        // read activity.groupname
                        activityGroupname = activity.groupname;
                    }
                    updateRegistration(7, activityGroupname);


                    if (activityGroupname != null) {
                        // read activity.groupname.get()
                        activityGroupnameGet = activityGroupname.get();
                    }
            }
            if ((dirtyFlags & 0xd00L) != 0) {

                    if (activity != null) {
                        // read activity.incomesource
                        activityIncomesource = activity.incomesource;
                    }
                    updateRegistration(8, activityIncomesource);


                    if (activityIncomesource != null) {
                        // read activity.incomesource.get()
                        activityIncomesourceGet = activityIncomesource.get();
                    }
            }
            if ((dirtyFlags & 0xe00L) != 0) {

                    if (activity != null) {
                        // read activity.specialtycocoa
                        activitySpecialtycocoa = activity.specialtycocoa;
                    }
                    updateRegistration(9, activitySpecialtycocoa);


                    if (activitySpecialtycocoa != null) {
                        // read activity.specialtycocoa.get()
                        activitySpecialtycocoaGet = activitySpecialtycocoa.get();
                    }


                    if (activitySpecialtycocoaGet != null) {
                        // read activity.specialtycocoa.get().equals("Certified")
                        activitySpecialtycocoaEqualsJavaLangStringCertified = activitySpecialtycocoaGet.equals("Certified");
                    }
                if((dirtyFlags & 0xe00L) != 0) {
                    if(activitySpecialtycocoaEqualsJavaLangStringCertified) {
                            dirtyFlags |= 0x2000L;
                    }
                    else {
                            dirtyFlags |= 0x1000L;
                    }
                }


                    // read activity.specialtycocoa.get().equals("Certified") ? true : false
                    activitySpecialtycocoaEqualsJavaLangStringCertifiedBooleanTrueBooleanFalse = ((activitySpecialtycocoaEqualsJavaLangStringCertified) ? (true) : (false));
            }
        }
        // batch finished
        if ((dirtyFlags & 0xc01L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.boolcincome, androidxDatabindingViewDataBindingSafeUnboxActivityBoolcocoaincomeGet);
            this.cocoaincome.setEnabled(activityBoolcocoaincomeBooleanFalseBooleanTrue);
        }
        if ((dirtyFlags & 0x800L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.boolcincome, (android.widget.CompoundButton.OnCheckedChangeListener)null, boolcincomeandroidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.boolcopgrp, (android.widget.CompoundButton.OnCheckedChangeListener)null, boolcopgrpandroidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.boolgrpm, (android.widget.CompoundButton.OnCheckedChangeListener)null, boolgrpmandroidCheckedAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.boolspe, (android.widget.CompoundButton.OnCheckedChangeListener)null, boolspeandroidCheckedAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.certification, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, certificationandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.cocoaincome, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, cocoaincomeandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.cooperativegroup, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, cooperativegroupandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.farminggroup, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, farminggroupandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.fundingsource, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, fundingsourceandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.specialtycocoa, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, specialtycocoaandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xc04L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.boolcopgrp, androidxDatabindingViewDataBindingSafeUnboxActivityBoolcoopmemberGet);
            this.cooperativegroup.setEnabled(androidxDatabindingViewDataBindingSafeUnboxActivityBoolcoopmemberGet);
        }
        if ((dirtyFlags & 0xc20L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.boolgrpm, androidxDatabindingViewDataBindingSafeUnboxActivityBoolgroupmemberGet);
            this.farminggroup.setEnabled(androidxDatabindingViewDataBindingSafeUnboxActivityBoolgroupmemberGet);
        }
        if ((dirtyFlags & 0xc02L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.boolspe, androidxDatabindingViewDataBindingSafeUnboxActivityBoolspecialtyGet);
            this.specialtycocoa.setEnabled(androidxDatabindingViewDataBindingSafeUnboxActivityBoolspecialtyGet);
        }
        if ((dirtyFlags & 0xe00L) != 0) {
            // api target 1

            this.certification.setEnabled(activitySpecialtycocoaEqualsJavaLangStringCertifiedBooleanTrueBooleanFalse);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.specialtycocoa, activitySpecialtycocoaGet);
        }
        if ((dirtyFlags & 0xc08L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.certification, activityCertifiedGet);
        }
        if ((dirtyFlags & 0xd00L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cocoaincome, activityIncomesourceGet);
        }
        if ((dirtyFlags & 0xc10L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cooperativegroup, activityCoopnameGet);
        }
        if ((dirtyFlags & 0xc80L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.farminggroup, activityGroupnameGet);
        }
        if ((dirtyFlags & 0xc40L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.fundingsource, activityFundingsourceGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): activity.boolcocoaincome
        flag 1 (0x2L): activity.boolspecialty
        flag 2 (0x3L): activity.boolcoopmember
        flag 3 (0x4L): activity.certified
        flag 4 (0x5L): activity.coopname
        flag 5 (0x6L): activity.boolgroupmember
        flag 6 (0x7L): activity.fundingsource
        flag 7 (0x8L): activity.groupname
        flag 8 (0x9L): activity.incomesource
        flag 9 (0xaL): activity.specialtycocoa
        flag 10 (0xbL): activity
        flag 11 (0xcL): null
        flag 12 (0xdL): activity.specialtycocoa.get().equals("Certified") ? true : false
        flag 13 (0xeL): activity.specialtycocoa.get().equals("Certified") ? true : false
        flag 14 (0xfL): androidx.databinding.ViewDataBinding.safeUnbox(activity.boolcocoaincome.get()) ? false : true
        flag 15 (0x10L): androidx.databinding.ViewDataBinding.safeUnbox(activity.boolcocoaincome.get()) ? false : true
    flag mapping end*/
    //end
}