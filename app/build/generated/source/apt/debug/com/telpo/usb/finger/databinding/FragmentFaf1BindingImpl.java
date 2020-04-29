package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentFaf1BindingImpl extends FragmentFaf1Binding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.txtpinfo, 5);
        sViewsWithIds.put(R.id.select_farm_layout, 6);
        sViewsWithIds.put(R.id.mcv_container, 7);
        sViewsWithIds.put(R.id.maincrop, 8);
        sViewsWithIds.put(R.id.maincrop_value, 9);
        sViewsWithIds.put(R.id.date_planted_layout, 10);
        sViewsWithIds.put(R.id.variety_layout, 11);
        sViewsWithIds.put(R.id.stage_layout, 12);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener datePlantedandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of faf1.datePlanted.get()
            //         is faf1.datePlanted.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(datePlanted);
            // localize variables for thread safety
            // faf1.datePlanted.get()
            java.lang.String faf1DatePlantedGet = null;
            // faf1.datePlanted
            androidx.databinding.ObservableField<java.lang.String> faf1DatePlanted = null;
            // faf1 != null
            boolean faf1JavaLangObjectNull = false;
            // faf1.datePlanted != null
            boolean faf1DatePlantedJavaLangObjectNull = false;
            // faf1
            com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_1_Pojo faf1 = mFaf1;



            faf1JavaLangObjectNull = (faf1) != (null);
            if (faf1JavaLangObjectNull) {


                faf1DatePlanted = faf1.datePlanted;

                faf1DatePlantedJavaLangObjectNull = (faf1DatePlanted) != (null);
                if (faf1DatePlantedJavaLangObjectNull) {




                    faf1DatePlanted.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener selectFarmandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of faf1.farmId.get()
            //         is faf1.farmId.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(selectFarm);
            // localize variables for thread safety
            // faf1.farmId != null
            boolean faf1FarmIdJavaLangObjectNull = false;
            // faf1 != null
            boolean faf1JavaLangObjectNull = false;
            // faf1
            com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_1_Pojo faf1 = mFaf1;
            // faf1.farmId.get()
            java.lang.String faf1FarmIdGet = null;
            // faf1.farmId
            androidx.databinding.ObservableField<java.lang.String> faf1FarmId = null;



            faf1JavaLangObjectNull = (faf1) != (null);
            if (faf1JavaLangObjectNull) {


                faf1FarmId = faf1.farmId;

                faf1FarmIdJavaLangObjectNull = (faf1FarmId) != (null);
                if (faf1FarmIdJavaLangObjectNull) {




                    faf1FarmId.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener stageandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of faf1.stagePlanted.get()
            //         is faf1.stagePlanted.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(stage);
            // localize variables for thread safety
            // faf1 != null
            boolean faf1JavaLangObjectNull = false;
            // faf1.stagePlanted.get()
            java.lang.String faf1StagePlantedGet = null;
            // faf1.stagePlanted != null
            boolean faf1StagePlantedJavaLangObjectNull = false;
            // faf1
            com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_1_Pojo faf1 = mFaf1;
            // faf1.stagePlanted
            androidx.databinding.ObservableField<java.lang.String> faf1StagePlanted = null;



            faf1JavaLangObjectNull = (faf1) != (null);
            if (faf1JavaLangObjectNull) {


                faf1StagePlanted = faf1.stagePlanted;

                faf1StagePlantedJavaLangObjectNull = (faf1StagePlanted) != (null);
                if (faf1StagePlantedJavaLangObjectNull) {




                    faf1StagePlanted.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener varietyandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of faf1.variety.get()
            //         is faf1.variety.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(variety);
            // localize variables for thread safety
            // faf1 != null
            boolean faf1JavaLangObjectNull = false;
            // faf1.variety
            androidx.databinding.ObservableField<java.lang.String> faf1Variety = null;
            // faf1.variety.get()
            java.lang.String faf1VarietyGet = null;
            // faf1
            com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_1_Pojo faf1 = mFaf1;
            // faf1.variety != null
            boolean faf1VarietyJavaLangObjectNull = false;



            faf1JavaLangObjectNull = (faf1) != (null);
            if (faf1JavaLangObjectNull) {


                faf1Variety = faf1.variety;

                faf1VarietyJavaLangObjectNull = (faf1Variety) != (null);
                if (faf1VarietyJavaLangObjectNull) {




                    faf1Variety.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentFaf1BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private FragmentFaf1BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[10]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.LinearLayout) bindings[7]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            , (com.google.android.material.textfield.TextInputLayout) bindings[6]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputLayout) bindings[12]
            , (android.widget.TextView) bindings[5]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            , (com.google.android.material.textfield.TextInputLayout) bindings[11]
            );
        this.datePlanted.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.selectFarm.setTag(null);
        this.stage.setTag(null);
        this.variety.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
        if (BR.faf1 == variableId) {
            setFaf1((com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_1_Pojo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFaf1(@Nullable com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_1_Pojo Faf1) {
        this.mFaf1 = Faf1;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.faf1);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeFaf1FarmId((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeFaf1StagePlanted((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeFaf1DatePlanted((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeFaf1Variety((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeFaf1FarmId(androidx.databinding.ObservableField<java.lang.String> Faf1FarmId, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFaf1StagePlanted(androidx.databinding.ObservableField<java.lang.String> Faf1StagePlanted, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFaf1DatePlanted(androidx.databinding.ObservableField<java.lang.String> Faf1DatePlanted, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFaf1Variety(androidx.databinding.ObservableField<java.lang.String> Faf1Variety, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        java.lang.String faf1DatePlantedGet = null;
        com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_1_Pojo faf1 = mFaf1;
        androidx.databinding.ObservableField<java.lang.String> faf1FarmId = null;
        java.lang.String faf1VarietyGet = null;
        androidx.databinding.ObservableField<java.lang.String> faf1StagePlanted = null;
        androidx.databinding.ObservableField<java.lang.String> faf1DatePlanted = null;
        java.lang.String faf1StagePlantedGet = null;
        androidx.databinding.ObservableField<java.lang.String> faf1Variety = null;
        java.lang.String faf1FarmIdGet = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (faf1 != null) {
                        // read faf1.farmId
                        faf1FarmId = faf1.farmId;
                    }
                    updateRegistration(0, faf1FarmId);


                    if (faf1FarmId != null) {
                        // read faf1.farmId.get()
                        faf1FarmIdGet = faf1FarmId.get();
                    }
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (faf1 != null) {
                        // read faf1.stagePlanted
                        faf1StagePlanted = faf1.stagePlanted;
                    }
                    updateRegistration(1, faf1StagePlanted);


                    if (faf1StagePlanted != null) {
                        // read faf1.stagePlanted.get()
                        faf1StagePlantedGet = faf1StagePlanted.get();
                    }
            }
            if ((dirtyFlags & 0x34L) != 0) {

                    if (faf1 != null) {
                        // read faf1.datePlanted
                        faf1DatePlanted = faf1.datePlanted;
                    }
                    updateRegistration(2, faf1DatePlanted);


                    if (faf1DatePlanted != null) {
                        // read faf1.datePlanted.get()
                        faf1DatePlantedGet = faf1DatePlanted.get();
                    }
            }
            if ((dirtyFlags & 0x38L) != 0) {

                    if (faf1 != null) {
                        // read faf1.variety
                        faf1Variety = faf1.variety;
                    }
                    updateRegistration(3, faf1Variety);


                    if (faf1Variety != null) {
                        // read faf1.variety.get()
                        faf1VarietyGet = faf1Variety.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.datePlanted, faf1DatePlantedGet);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.datePlanted, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, datePlantedandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.DateBindings.bindingDate(this.datePlanted, "dd-MMM-yyyy", (java.lang.String)null, (boolean)false);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.datePlanted, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.selectFarm, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, selectFarmandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.selectFarm, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.stage, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, stageandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.stage, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.variety, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, varietyandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.variety, true, (java.lang.String)null, (boolean)false);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.selectFarm, faf1FarmIdGet);
        }
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.stage, faf1StagePlantedGet);
        }
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.variety, faf1VarietyGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): faf1.farmId
        flag 1 (0x2L): faf1.stagePlanted
        flag 2 (0x3L): faf1.datePlanted
        flag 3 (0x4L): faf1.variety
        flag 4 (0x5L): faf1
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}