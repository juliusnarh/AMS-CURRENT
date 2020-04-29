package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentFaf2BindingImpl extends FragmentFaf2Binding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.mainLinear, 10);
        sViewsWithIds.put(R.id.txtpinfo, 11);
        sViewsWithIds.put(R.id.fert_layout, 12);
        sViewsWithIds.put(R.id.name_fert_layout, 13);
        sViewsWithIds.put(R.id.date_fert_app_layout, 14);
        sViewsWithIds.put(R.id.cropprotection_layout, 15);
        sViewsWithIds.put(R.id.name_chem_layout, 16);
        sViewsWithIds.put(R.id.date_chem_app_layout, 17);
        sViewsWithIds.put(R.id.camera, 18);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final android.widget.CheckBox mboundView9;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener chemicalCheckandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of faf2.chemCheck.get()
            //         is faf2.chemCheck.set((java.lang.Boolean) callbackArg_0)
            boolean callbackArg_0 = chemicalCheck.isChecked();
            // localize variables for thread safety
            // faf2 != null
            boolean faf2JavaLangObjectNull = false;
            // faf2.chemCheck.get()
            java.lang.Boolean faf2ChemCheckGet = null;
            // faf2.chemCheck
            androidx.databinding.ObservableField<java.lang.Boolean> faf2ChemCheck = null;
            // faf2.chemCheck != null
            boolean faf2ChemCheckJavaLangObjectNull = false;
            // faf2
            com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo faf2 = mFaf2;



            faf2JavaLangObjectNull = (faf2) != (null);
            if (faf2JavaLangObjectNull) {


                faf2ChemCheck = faf2.chemCheck;

                faf2ChemCheckJavaLangObjectNull = (faf2ChemCheck) != (null);
                if (faf2ChemCheckJavaLangObjectNull) {




                    faf2ChemCheck.set(((java.lang.Boolean) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener dateChemAppandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of faf2.dateAppliedChem.get()
            //         is faf2.dateAppliedChem.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(dateChemApp);
            // localize variables for thread safety
            // faf2.dateAppliedChem
            androidx.databinding.ObservableField<java.lang.String> faf2DateAppliedChem = null;
            // faf2.dateAppliedChem != null
            boolean faf2DateAppliedChemJavaLangObjectNull = false;
            // faf2 != null
            boolean faf2JavaLangObjectNull = false;
            // faf2.dateAppliedChem.get()
            java.lang.String faf2DateAppliedChemGet = null;
            // faf2
            com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo faf2 = mFaf2;



            faf2JavaLangObjectNull = (faf2) != (null);
            if (faf2JavaLangObjectNull) {


                faf2DateAppliedChem = faf2.dateAppliedChem;

                faf2DateAppliedChemJavaLangObjectNull = (faf2DateAppliedChem) != (null);
                if (faf2DateAppliedChemJavaLangObjectNull) {




                    faf2DateAppliedChem.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener dateFertAppandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of faf2.dateAppliedFert.get()
            //         is faf2.dateAppliedFert.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(dateFertApp);
            // localize variables for thread safety
            // faf2 != null
            boolean faf2JavaLangObjectNull = false;
            // faf2.dateAppliedFert
            androidx.databinding.ObservableField<java.lang.String> faf2DateAppliedFert = null;
            // faf2.dateAppliedFert != null
            boolean faf2DateAppliedFertJavaLangObjectNull = false;
            // faf2.dateAppliedFert.get()
            java.lang.String faf2DateAppliedFertGet = null;
            // faf2
            com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo faf2 = mFaf2;



            faf2JavaLangObjectNull = (faf2) != (null);
            if (faf2JavaLangObjectNull) {


                faf2DateAppliedFert = faf2.dateAppliedFert;

                faf2DateAppliedFertJavaLangObjectNull = (faf2DateAppliedFert) != (null);
                if (faf2DateAppliedFertJavaLangObjectNull) {




                    faf2DateAppliedFert.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener fertilizerCheckandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of faf2.fertCheck.get()
            //         is faf2.fertCheck.set((java.lang.Boolean) callbackArg_0)
            boolean callbackArg_0 = fertilizerCheck.isChecked();
            // localize variables for thread safety
            // faf2.fertCheck != null
            boolean faf2FertCheckJavaLangObjectNull = false;
            // faf2.fertCheck
            androidx.databinding.ObservableField<java.lang.Boolean> faf2FertCheck = null;
            // faf2 != null
            boolean faf2JavaLangObjectNull = false;
            // faf2
            com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo faf2 = mFaf2;
            // faf2.fertCheck.get()
            java.lang.Boolean faf2FertCheckGet = null;



            faf2JavaLangObjectNull = (faf2) != (null);
            if (faf2JavaLangObjectNull) {


                faf2FertCheck = faf2.fertCheck;

                faf2FertCheckJavaLangObjectNull = (faf2FertCheck) != (null);
                if (faf2FertCheckJavaLangObjectNull) {




                    faf2FertCheck.set(((java.lang.Boolean) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener nameChemandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of faf2.nameChem.get()
            //         is faf2.nameChem.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(nameChem);
            // localize variables for thread safety
            // faf2 != null
            boolean faf2JavaLangObjectNull = false;
            // faf2.nameChem.get()
            java.lang.String faf2NameChemGet = null;
            // faf2.nameChem != null
            boolean faf2NameChemJavaLangObjectNull = false;
            // faf2
            com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo faf2 = mFaf2;
            // faf2.nameChem
            androidx.databinding.ObservableField<java.lang.String> faf2NameChem = null;



            faf2JavaLangObjectNull = (faf2) != (null);
            if (faf2JavaLangObjectNull) {


                faf2NameChem = faf2.nameChem;

                faf2NameChemJavaLangObjectNull = (faf2NameChem) != (null);
                if (faf2NameChemJavaLangObjectNull) {




                    faf2NameChem.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener nameFertandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of faf2.nameFert.get()
            //         is faf2.nameFert.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(nameFert);
            // localize variables for thread safety
            // faf2.nameFert != null
            boolean faf2NameFertJavaLangObjectNull = false;
            // faf2 != null
            boolean faf2JavaLangObjectNull = false;
            // faf2.nameFert
            androidx.databinding.ObservableField<java.lang.String> faf2NameFert = null;
            // faf2
            com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo faf2 = mFaf2;
            // faf2.nameFert.get()
            java.lang.String faf2NameFertGet = null;



            faf2JavaLangObjectNull = (faf2) != (null);
            if (faf2JavaLangObjectNull) {


                faf2NameFert = faf2.nameFert;

                faf2NameFertJavaLangObjectNull = (faf2NameFert) != (null);
                if (faf2NameFertJavaLangObjectNull) {




                    faf2NameFert.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentFaf2BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private FragmentFaf2BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 7
            , (androidx.cardview.widget.CardView) bindings[18]
            , (android.widget.CheckBox) bindings[5]
            , (android.widget.RelativeLayout) bindings[15]
            , (com.google.android.material.textfield.TextInputEditText) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[17]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputLayout) bindings[14]
            , (android.widget.RelativeLayout) bindings[12]
            , (android.widget.CheckBox) bindings[1]
            , (android.widget.LinearLayout) bindings[10]
            , (com.google.android.material.textfield.TextInputEditText) bindings[7]
            , (com.google.android.material.textfield.TextInputLayout) bindings[16]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            , (com.google.android.material.textfield.TextInputLayout) bindings[13]
            , (android.widget.RelativeLayout) bindings[6]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.TextView) bindings[11]
            );
        this.chemicalCheck.setTag(null);
        this.dateChemApp.setTag(null);
        this.dateFertApp.setTag(null);
        this.fertilizerCheck.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView9 = (android.widget.CheckBox) bindings[9];
        this.mboundView9.setTag(null);
        this.nameChem.setTag(null);
        this.nameFert.setTag(null);
        this.rrChemical.setTag(null);
        this.rrFertilizer.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x100L;
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
        if (BR.faf2 == variableId) {
            setFaf2((com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFaf2(@Nullable com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo Faf2) {
        this.mFaf2 = Faf2;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.faf2);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeFaf2ChemCheck((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 1 :
                return onChangeFaf2NameFert((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeFaf2FarmPhoto((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 3 :
                return onChangeFaf2DateAppliedFert((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeFaf2FertCheck((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 5 :
                return onChangeFaf2NameChem((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeFaf2DateAppliedChem((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeFaf2ChemCheck(androidx.databinding.ObservableField<java.lang.Boolean> Faf2ChemCheck, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFaf2NameFert(androidx.databinding.ObservableField<java.lang.String> Faf2NameFert, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFaf2FarmPhoto(androidx.databinding.ObservableField<java.lang.Boolean> Faf2FarmPhoto, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFaf2DateAppliedFert(androidx.databinding.ObservableField<java.lang.String> Faf2DateAppliedFert, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFaf2FertCheck(androidx.databinding.ObservableField<java.lang.Boolean> Faf2FertCheck, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFaf2NameChem(androidx.databinding.ObservableField<java.lang.String> Faf2NameChem, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFaf2DateAppliedChem(androidx.databinding.ObservableField<java.lang.String> Faf2DateAppliedChem, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
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
        androidx.databinding.ObservableField<java.lang.Boolean> faf2ChemCheck = null;
        java.lang.Boolean faf2FertCheckGet = null;
        androidx.databinding.ObservableField<java.lang.String> faf2NameFert = null;
        com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo faf2 = mFaf2;
        androidx.databinding.ObservableField<java.lang.Boolean> faf2FarmPhoto = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxFaf2FarmPhotoGet = false;
        androidx.databinding.ObservableField<java.lang.String> faf2DateAppliedFert = null;
        java.lang.String faf2DateAppliedFertGet = null;
        int faf2FertCheckViewVISIBLEViewGONE = 0;
        int faf2ChemCheckViewVISIBLEViewGONE = 0;
        androidx.databinding.ObservableField<java.lang.Boolean> faf2FertCheck = null;
        androidx.databinding.ObservableField<java.lang.String> faf2NameChem = null;
        java.lang.String faf2NameFertGet = null;
        java.lang.Boolean faf2ChemCheckGet = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxFaf2FertCheckGet = false;
        java.lang.Boolean faf2FarmPhotoGet = null;
        androidx.databinding.ObservableField<java.lang.String> faf2DateAppliedChem = null;
        java.lang.String faf2NameChemGet = null;
        java.lang.String faf2DateAppliedChemGet = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxFaf2ChemCheckGet = false;

        if ((dirtyFlags & 0x1ffL) != 0) {


            if ((dirtyFlags & 0x181L) != 0) {

                    if (faf2 != null) {
                        // read faf2.chemCheck
                        faf2ChemCheck = faf2.chemCheck;
                    }
                    updateRegistration(0, faf2ChemCheck);


                    if (faf2ChemCheck != null) {
                        // read faf2.chemCheck.get()
                        faf2ChemCheckGet = faf2ChemCheck.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(faf2.chemCheck.get())
                    androidxDatabindingViewDataBindingSafeUnboxFaf2ChemCheckGet = androidx.databinding.ViewDataBinding.safeUnbox(faf2ChemCheckGet);
                if((dirtyFlags & 0x181L) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxFaf2ChemCheckGet) {
                            dirtyFlags |= 0x1000L;
                    }
                    else {
                            dirtyFlags |= 0x800L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(faf2.chemCheck.get()) ? View.VISIBLE : View.GONE
                    faf2ChemCheckViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxFaf2ChemCheckGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x182L) != 0) {

                    if (faf2 != null) {
                        // read faf2.nameFert
                        faf2NameFert = faf2.nameFert;
                    }
                    updateRegistration(1, faf2NameFert);


                    if (faf2NameFert != null) {
                        // read faf2.nameFert.get()
                        faf2NameFertGet = faf2NameFert.get();
                    }
            }
            if ((dirtyFlags & 0x184L) != 0) {

                    if (faf2 != null) {
                        // read faf2.farmPhoto
                        faf2FarmPhoto = faf2.farmPhoto;
                    }
                    updateRegistration(2, faf2FarmPhoto);


                    if (faf2FarmPhoto != null) {
                        // read faf2.farmPhoto.get()
                        faf2FarmPhotoGet = faf2FarmPhoto.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(faf2.farmPhoto.get())
                    androidxDatabindingViewDataBindingSafeUnboxFaf2FarmPhotoGet = androidx.databinding.ViewDataBinding.safeUnbox(faf2FarmPhotoGet);
            }
            if ((dirtyFlags & 0x188L) != 0) {

                    if (faf2 != null) {
                        // read faf2.dateAppliedFert
                        faf2DateAppliedFert = faf2.dateAppliedFert;
                    }
                    updateRegistration(3, faf2DateAppliedFert);


                    if (faf2DateAppliedFert != null) {
                        // read faf2.dateAppliedFert.get()
                        faf2DateAppliedFertGet = faf2DateAppliedFert.get();
                    }
            }
            if ((dirtyFlags & 0x190L) != 0) {

                    if (faf2 != null) {
                        // read faf2.fertCheck
                        faf2FertCheck = faf2.fertCheck;
                    }
                    updateRegistration(4, faf2FertCheck);


                    if (faf2FertCheck != null) {
                        // read faf2.fertCheck.get()
                        faf2FertCheckGet = faf2FertCheck.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(faf2.fertCheck.get())
                    androidxDatabindingViewDataBindingSafeUnboxFaf2FertCheckGet = androidx.databinding.ViewDataBinding.safeUnbox(faf2FertCheckGet);
                if((dirtyFlags & 0x190L) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxFaf2FertCheckGet) {
                            dirtyFlags |= 0x400L;
                    }
                    else {
                            dirtyFlags |= 0x200L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(faf2.fertCheck.get()) ? View.VISIBLE : View.GONE
                    faf2FertCheckViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxFaf2FertCheckGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x1a0L) != 0) {

                    if (faf2 != null) {
                        // read faf2.nameChem
                        faf2NameChem = faf2.nameChem;
                    }
                    updateRegistration(5, faf2NameChem);


                    if (faf2NameChem != null) {
                        // read faf2.nameChem.get()
                        faf2NameChemGet = faf2NameChem.get();
                    }
            }
            if ((dirtyFlags & 0x1c0L) != 0) {

                    if (faf2 != null) {
                        // read faf2.dateAppliedChem
                        faf2DateAppliedChem = faf2.dateAppliedChem;
                    }
                    updateRegistration(6, faf2DateAppliedChem);


                    if (faf2DateAppliedChem != null) {
                        // read faf2.dateAppliedChem.get()
                        faf2DateAppliedChemGet = faf2DateAppliedChem.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x181L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.chemicalCheck, androidxDatabindingViewDataBindingSafeUnboxFaf2ChemCheckGet);
            this.rrChemical.setVisibility(faf2ChemCheckViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x100L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.chemicalCheck, (android.widget.CompoundButton.OnCheckedChangeListener)null, chemicalCheckandroidCheckedAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.dateChemApp, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, dateChemAppandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.DateBindings.bindingDate(this.dateChemApp, "dd-MMM-yyyy", (java.lang.String)null, (boolean)false);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.dateChemApp, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.dateFertApp, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, dateFertAppandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.DateBindings.bindingDate(this.dateFertApp, "dd-MMM-yyyy", (java.lang.String)null, (boolean)false);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.dateFertApp, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.fertilizerCheck, (android.widget.CompoundButton.OnCheckedChangeListener)null, fertilizerCheckandroidCheckedAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.nameChem, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, nameChemandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.nameChem, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.nameFert, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, nameFertandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.nameFert, true, (java.lang.String)null, (boolean)false);
        }
        if ((dirtyFlags & 0x1c0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.dateChemApp, faf2DateAppliedChemGet);
        }
        if ((dirtyFlags & 0x188L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.dateFertApp, faf2DateAppliedFertGet);
        }
        if ((dirtyFlags & 0x190L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.fertilizerCheck, androidxDatabindingViewDataBindingSafeUnboxFaf2FertCheckGet);
            this.rrFertilizer.setVisibility(faf2FertCheckViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x184L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView9, androidxDatabindingViewDataBindingSafeUnboxFaf2FarmPhotoGet);
        }
        if ((dirtyFlags & 0x1a0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nameChem, faf2NameChemGet);
        }
        if ((dirtyFlags & 0x182L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nameFert, faf2NameFertGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): faf2.chemCheck
        flag 1 (0x2L): faf2.nameFert
        flag 2 (0x3L): faf2.farmPhoto
        flag 3 (0x4L): faf2.dateAppliedFert
        flag 4 (0x5L): faf2.fertCheck
        flag 5 (0x6L): faf2.nameChem
        flag 6 (0x7L): faf2.dateAppliedChem
        flag 7 (0x8L): faf2
        flag 8 (0x9L): null
        flag 9 (0xaL): androidx.databinding.ViewDataBinding.safeUnbox(faf2.fertCheck.get()) ? View.VISIBLE : View.GONE
        flag 10 (0xbL): androidx.databinding.ViewDataBinding.safeUnbox(faf2.fertCheck.get()) ? View.VISIBLE : View.GONE
        flag 11 (0xcL): androidx.databinding.ViewDataBinding.safeUnbox(faf2.chemCheck.get()) ? View.VISIBLE : View.GONE
        flag 12 (0xdL): androidx.databinding.ViewDataBinding.safeUnbox(faf2.chemCheck.get()) ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}