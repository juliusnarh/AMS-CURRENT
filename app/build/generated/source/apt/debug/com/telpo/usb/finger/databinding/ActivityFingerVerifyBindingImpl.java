package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityFingerVerifyBindingImpl extends ActivityFingerVerifyBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 7);
        sViewsWithIds.put(R.id.info, 8);
        sViewsWithIds.put(R.id.fp_image, 9);
        sViewsWithIds.put(R.id.verify, 10);
        sViewsWithIds.put(R.id.loadrecord, 11);
        sViewsWithIds.put(R.id.clearall, 12);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityFingerVerifyBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityFingerVerifyBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6
            , (android.widget.Button) bindings[12]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (android.widget.Button) bindings[11]
            , (android.widget.TextView) bindings[6]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (androidx.appcompat.widget.Toolbar) bindings[7]
            , (android.widget.Button) bindings[10]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            );
        this.fullname.setTag(null);
        this.idnumber.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.nationality.setTag(null);
        this.photo.setTag(null);
        this.telephone.setTag(null);
        this.verifyid.setTag(null);
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
        if (BR.bioinfo == variableId) {
            setBioinfo((com.telpo.usb.finger.pojo.BiometricsTaken) variable);
        }
        else if (BR.basicinfo == variableId) {
            setBasicinfo((com.telpo.usb.finger.pojo.BasicRegistration) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setBioinfo(@Nullable com.telpo.usb.finger.pojo.BiometricsTaken Bioinfo) {
        this.mBioinfo = Bioinfo;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.bioinfo);
        super.requestRebind();
    }
    public void setBasicinfo(@Nullable com.telpo.usb.finger.pojo.BasicRegistration Basicinfo) {
        this.mBasicinfo = Basicinfo;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.basicinfo);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeBasicinfoSurname((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeBasicinfoFirstname((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeBasicinfoTelephone((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeBioinfoPhotourl((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeBasicinfoIdnumber((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeBasicinfoNationality((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeBasicinfoSurname(androidx.databinding.ObservableField<java.lang.String> BasicinfoSurname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicinfoFirstname(androidx.databinding.ObservableField<java.lang.String> BasicinfoFirstname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicinfoTelephone(androidx.databinding.ObservableField<java.lang.String> BasicinfoTelephone, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBioinfoPhotourl(androidx.databinding.ObservableField<java.lang.String> BioinfoPhotourl, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicinfoIdnumber(androidx.databinding.ObservableField<java.lang.String> BasicinfoIdnumber, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicinfoNationality(androidx.databinding.ObservableField<java.lang.String> BasicinfoNationality, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
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
        java.lang.String bioinfoPhotourlGet = null;
        com.telpo.usb.finger.pojo.BiometricsTaken bioinfo = mBioinfo;
        androidx.databinding.ObservableField<java.lang.String> basicinfoSurname = null;
        java.lang.String basicinfoIdnumberGet = null;
        java.lang.String basicinfoFirstnameCharBasicinfoSurname = null;
        androidx.databinding.ObservableField<java.lang.String> basicinfoFirstname = null;
        androidx.databinding.ObservableField<java.lang.String> basicinfoTelephone = null;
        androidx.databinding.ObservableField<java.lang.String> bioinfoPhotourl = null;
        androidx.databinding.ObservableField<java.lang.String> basicinfoIdnumber = null;
        com.telpo.usb.finger.pojo.BasicRegistration basicinfo = mBasicinfo;
        java.lang.String basicinfoNationalityGet = null;
        java.lang.String basicinfoTelephoneGet = null;
        java.lang.String basicinfoSurnameGet = null;
        java.lang.String basicinfoFirstnameGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicinfoNationality = null;
        java.lang.String basicinfoFirstnameChar = null;

        if ((dirtyFlags & 0x148L) != 0) {



                if (bioinfo != null) {
                    // read bioinfo.photourl
                    bioinfoPhotourl = bioinfo.photourl;
                }
                updateRegistration(3, bioinfoPhotourl);


                if (bioinfoPhotourl != null) {
                    // read bioinfo.photourl.get()
                    bioinfoPhotourlGet = bioinfoPhotourl.get();
                }
        }
        if ((dirtyFlags & 0x1b7L) != 0) {


            if ((dirtyFlags & 0x183L) != 0) {

                    if (basicinfo != null) {
                        // read basicinfo.surname
                        basicinfoSurname = basicinfo.surname;
                        // read basicinfo.firstname
                        basicinfoFirstname = basicinfo.firstname;
                    }
                    updateRegistration(0, basicinfoSurname);
                    updateRegistration(1, basicinfoFirstname);


                    if (basicinfoSurname != null) {
                        // read basicinfo.surname.get()
                        basicinfoSurnameGet = basicinfoSurname.get();
                    }
                    if (basicinfoFirstname != null) {
                        // read basicinfo.firstname.get()
                        basicinfoFirstnameGet = basicinfoFirstname.get();
                    }


                    // read (basicinfo.firstname.get()) + (' ')
                    basicinfoFirstnameChar = (basicinfoFirstnameGet) + (' ');


                    // read ((basicinfo.firstname.get()) + (' ')) + (basicinfo.surname.get())
                    basicinfoFirstnameCharBasicinfoSurname = (basicinfoFirstnameChar) + (basicinfoSurnameGet);
            }
            if ((dirtyFlags & 0x184L) != 0) {

                    if (basicinfo != null) {
                        // read basicinfo.telephone
                        basicinfoTelephone = basicinfo.telephone;
                    }
                    updateRegistration(2, basicinfoTelephone);


                    if (basicinfoTelephone != null) {
                        // read basicinfo.telephone.get()
                        basicinfoTelephoneGet = basicinfoTelephone.get();
                    }
            }
            if ((dirtyFlags & 0x190L) != 0) {

                    if (basicinfo != null) {
                        // read basicinfo.idnumber
                        basicinfoIdnumber = basicinfo.idnumber;
                    }
                    updateRegistration(4, basicinfoIdnumber);


                    if (basicinfoIdnumber != null) {
                        // read basicinfo.idnumber.get()
                        basicinfoIdnumberGet = basicinfoIdnumber.get();
                    }
            }
            if ((dirtyFlags & 0x1a0L) != 0) {

                    if (basicinfo != null) {
                        // read basicinfo.nationality
                        basicinfoNationality = basicinfo.nationality;
                    }
                    updateRegistration(5, basicinfoNationality);


                    if (basicinfoNationality != null) {
                        // read basicinfo.nationality.get()
                        basicinfoNationalityGet = basicinfoNationality.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x183L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.fullname, basicinfoFirstnameCharBasicinfoSurname);
        }
        if ((dirtyFlags & 0x190L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.idnumber, basicinfoIdnumberGet);
        }
        if ((dirtyFlags & 0x1a0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nationality, basicinfoNationalityGet);
        }
        if ((dirtyFlags & 0x148L) != 0) {
            // api target 1

            androidx.databinding.adapters.ImageViewBindingAdapter.setImageUri(this.photo, bioinfoPhotourlGet);
        }
        if ((dirtyFlags & 0x184L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.telephone, basicinfoTelephoneGet);
        }
        if ((dirtyFlags & 0x100L) != 0) {
            // api target 1

            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.verifyid, true, (java.lang.String)null, (boolean)false);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): basicinfo.surname
        flag 1 (0x2L): basicinfo.firstname
        flag 2 (0x3L): basicinfo.telephone
        flag 3 (0x4L): bioinfo.photourl
        flag 4 (0x5L): basicinfo.idnumber
        flag 5 (0x6L): basicinfo.nationality
        flag 6 (0x7L): bioinfo
        flag 7 (0x8L): basicinfo
        flag 8 (0x9L): null
    flag mapping end*/
    //end
}