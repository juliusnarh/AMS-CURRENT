package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentManualRecoveryBindingImpl extends FragmentManualRecoveryBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.noowe, 6);
        sViewsWithIds.put(R.id.form, 7);
        sViewsWithIds.put(R.id.card_title, 8);
        sViewsWithIds.put(R.id.header, 9);
        sViewsWithIds.put(R.id.forrecovery, 10);
        sViewsWithIds.put(R.id.payable_layout, 11);
        sViewsWithIds.put(R.id.count_layout, 12);
        sViewsWithIds.put(R.id.weight_layout, 13);
        sViewsWithIds.put(R.id.totalweight, 14);
        sViewsWithIds.put(R.id.moisture_layout, 15);
        sViewsWithIds.put(R.id.amount_layout, 16);
        sViewsWithIds.put(R.id.totalamount, 17);
        sViewsWithIds.put(R.id.remaining_bags, 18);
        sViewsWithIds.put(R.id.paid_bags, 19);
        sViewsWithIds.put(R.id.add_btn, 20);
        sViewsWithIds.put(R.id.submit_btn, 21);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener amountandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of recov.amount.get()
            //         is recov.amount.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(amount);
            // localize variables for thread safety
            // recov.amount != null
            boolean recovAmountJavaLangObjectNull = false;
            // recov != null
            boolean recovJavaLangObjectNull = false;
            // recov.amount
            androidx.databinding.ObservableField<java.lang.String> recovAmount = null;
            // recov
            com.telpo.usb.finger.pojo.inputdistribution.pojo.RecoveryPojo recov = mRecov;
            // recov.amount.get()
            java.lang.String recovAmountGet = null;



            recovJavaLangObjectNull = (recov) != (null);
            if (recovJavaLangObjectNull) {


                recovAmount = recov.amount;

                recovAmountJavaLangObjectNull = (recovAmount) != (null);
                if (recovAmountJavaLangObjectNull) {




                    recovAmount.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener countandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of recov.count.get()
            //         is recov.count.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(count);
            // localize variables for thread safety
            // recov != null
            boolean recovJavaLangObjectNull = false;
            // recov.count
            androidx.databinding.ObservableField<java.lang.String> recovCount = null;
            // recov.count.get()
            java.lang.String recovCountGet = null;
            // recov
            com.telpo.usb.finger.pojo.inputdistribution.pojo.RecoveryPojo recov = mRecov;
            // recov.count != null
            boolean recovCountJavaLangObjectNull = false;



            recovJavaLangObjectNull = (recov) != (null);
            if (recovJavaLangObjectNull) {


                recovCount = recov.count;

                recovCountJavaLangObjectNull = (recovCount) != (null);
                if (recovCountJavaLangObjectNull) {




                    recovCount.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener moistureandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of recov.moisturecontent.get()
            //         is recov.moisturecontent.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(moisture);
            // localize variables for thread safety
            // recov != null
            boolean recovJavaLangObjectNull = false;
            // recov.moisturecontent.get()
            java.lang.String recovMoisturecontentGet = null;
            // recov
            com.telpo.usb.finger.pojo.inputdistribution.pojo.RecoveryPojo recov = mRecov;
            // recov.moisturecontent
            androidx.databinding.ObservableField<java.lang.String> recovMoisturecontent = null;
            // recov.moisturecontent != null
            boolean recovMoisturecontentJavaLangObjectNull = false;



            recovJavaLangObjectNull = (recov) != (null);
            if (recovJavaLangObjectNull) {


                recovMoisturecontent = recov.moisturecontent;

                recovMoisturecontentJavaLangObjectNull = (recovMoisturecontent) != (null);
                if (recovMoisturecontentJavaLangObjectNull) {




                    recovMoisturecontent.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener payableandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of recov.payable.get()
            //         is recov.payable.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(payable);
            // localize variables for thread safety
            // recov != null
            boolean recovJavaLangObjectNull = false;
            // recov.payable
            androidx.databinding.ObservableField<java.lang.String> recovPayable = null;
            // recov
            com.telpo.usb.finger.pojo.inputdistribution.pojo.RecoveryPojo recov = mRecov;
            // recov.payable.get()
            java.lang.String recovPayableGet = null;
            // recov.payable != null
            boolean recovPayableJavaLangObjectNull = false;



            recovJavaLangObjectNull = (recov) != (null);
            if (recovJavaLangObjectNull) {


                recovPayable = recov.payable;

                recovPayableJavaLangObjectNull = (recovPayable) != (null);
                if (recovPayableJavaLangObjectNull) {




                    recovPayable.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener weightandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of recov.weight.get()
            //         is recov.weight.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(weight);
            // localize variables for thread safety
            // recov.weight
            androidx.databinding.ObservableField<java.lang.String> recovWeight = null;
            // recov != null
            boolean recovJavaLangObjectNull = false;
            // recov.weight != null
            boolean recovWeightJavaLangObjectNull = false;
            // recov
            com.telpo.usb.finger.pojo.inputdistribution.pojo.RecoveryPojo recov = mRecov;
            // recov.weight.get()
            java.lang.String recovWeightGet = null;



            recovJavaLangObjectNull = (recov) != (null);
            if (recovJavaLangObjectNull) {


                recovWeight = recov.weight;

                recovWeightJavaLangObjectNull = (recovWeight) != (null);
                if (recovWeightJavaLangObjectNull) {




                    recovWeight.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentManualRecoveryBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private FragmentManualRecoveryBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5
            , (android.widget.Button) bindings[20]
            , (com.google.android.material.textfield.TextInputEditText) bindings[5]
            , (com.google.android.material.textfield.TextInputLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[8]
            , (androidx.core.widget.NestedScrollView) bindings[0]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputLayout) bindings[15]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[19]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            , (com.google.android.material.textfield.TextInputLayout) bindings[11]
            , (android.widget.TextView) bindings[18]
            , (android.widget.Button) bindings[21]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[14]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            , (com.google.android.material.textfield.TextInputLayout) bindings[13]
            );
        this.amount.setTag(null);
        this.container.setTag(null);
        this.count.setTag(null);
        this.moisture.setTag(null);
        this.payable.setTag(null);
        this.weight.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
        if (BR.recov == variableId) {
            setRecov((com.telpo.usb.finger.pojo.inputdistribution.pojo.RecoveryPojo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRecov(@Nullable com.telpo.usb.finger.pojo.inputdistribution.pojo.RecoveryPojo Recov) {
        this.mRecov = Recov;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.recov);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeRecovCount((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeRecovWeight((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeRecovAmount((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeRecovPayable((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeRecovMoisturecontent((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeRecovCount(androidx.databinding.ObservableField<java.lang.String> RecovCount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRecovWeight(androidx.databinding.ObservableField<java.lang.String> RecovWeight, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRecovAmount(androidx.databinding.ObservableField<java.lang.String> RecovAmount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRecovPayable(androidx.databinding.ObservableField<java.lang.String> RecovPayable, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRecovMoisturecontent(androidx.databinding.ObservableField<java.lang.String> RecovMoisturecontent, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
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
        androidx.databinding.ObservableField<java.lang.String> recovCount = null;
        java.lang.String recovCountGet = null;
        com.telpo.usb.finger.pojo.inputdistribution.pojo.RecoveryPojo recov = mRecov;
        java.lang.String recovAmountGet = null;
        java.lang.String recovWeightGet = null;
        androidx.databinding.ObservableField<java.lang.String> recovWeight = null;
        androidx.databinding.ObservableField<java.lang.String> recovAmount = null;
        androidx.databinding.ObservableField<java.lang.String> recovPayable = null;
        java.lang.String recovPayableGet = null;
        java.lang.String recovMoisturecontentGet = null;
        androidx.databinding.ObservableField<java.lang.String> recovMoisturecontent = null;

        if ((dirtyFlags & 0x7fL) != 0) {


            if ((dirtyFlags & 0x61L) != 0) {

                    if (recov != null) {
                        // read recov.count
                        recovCount = recov.count;
                    }
                    updateRegistration(0, recovCount);


                    if (recovCount != null) {
                        // read recov.count.get()
                        recovCountGet = recovCount.get();
                    }
            }
            if ((dirtyFlags & 0x62L) != 0) {

                    if (recov != null) {
                        // read recov.weight
                        recovWeight = recov.weight;
                    }
                    updateRegistration(1, recovWeight);


                    if (recovWeight != null) {
                        // read recov.weight.get()
                        recovWeightGet = recovWeight.get();
                    }
            }
            if ((dirtyFlags & 0x64L) != 0) {

                    if (recov != null) {
                        // read recov.amount
                        recovAmount = recov.amount;
                    }
                    updateRegistration(2, recovAmount);


                    if (recovAmount != null) {
                        // read recov.amount.get()
                        recovAmountGet = recovAmount.get();
                    }
            }
            if ((dirtyFlags & 0x68L) != 0) {

                    if (recov != null) {
                        // read recov.payable
                        recovPayable = recov.payable;
                    }
                    updateRegistration(3, recovPayable);


                    if (recovPayable != null) {
                        // read recov.payable.get()
                        recovPayableGet = recovPayable.get();
                    }
            }
            if ((dirtyFlags & 0x70L) != 0) {

                    if (recov != null) {
                        // read recov.moisturecontent
                        recovMoisturecontent = recov.moisturecontent;
                    }
                    updateRegistration(4, recovMoisturecontent);


                    if (recovMoisturecontent != null) {
                        // read recov.moisturecontent.get()
                        recovMoisturecontentGet = recovMoisturecontent.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x64L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.amount, recovAmountGet);
        }
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.amount, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, amountandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.amount, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.count, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, countandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.count, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.moisture, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, moistureandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.moisture, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.payable, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, payableandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.weight, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, weightandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.weight, true, (java.lang.String)null, (boolean)false);
        }
        if ((dirtyFlags & 0x61L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.count, recovCountGet);
        }
        if ((dirtyFlags & 0x70L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.moisture, recovMoisturecontentGet);
        }
        if ((dirtyFlags & 0x68L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.payable, recovPayableGet);
        }
        if ((dirtyFlags & 0x62L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.weight, recovWeightGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): recov.count
        flag 1 (0x2L): recov.weight
        flag 2 (0x3L): recov.amount
        flag 3 (0x4L): recov.payable
        flag 4 (0x5L): recov.moisturecontent
        flag 5 (0x6L): recov
        flag 6 (0x7L): null
    flag mapping end*/
    //end
}