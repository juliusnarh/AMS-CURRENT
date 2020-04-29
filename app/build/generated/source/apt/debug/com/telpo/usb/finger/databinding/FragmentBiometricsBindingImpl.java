package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentBiometricsBindingImpl extends FragmentBiometricsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.camera, 5);
        sViewsWithIds.put(R.id.fingerprint, 6);
        sViewsWithIds.put(R.id.supportdocs, 7);
        sViewsWithIds.put(R.id.signature, 8);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.CheckBox mboundView1;
    @NonNull
    private final android.widget.CheckBox mboundView2;
    @NonNull
    private final android.widget.CheckBox mboundView3;
    @NonNull
    private final android.widget.CheckBox mboundView4;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentBiometricsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentBiometricsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (androidx.cardview.widget.CardView) bindings[5]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (androidx.cardview.widget.CardView) bindings[8]
            , (androidx.cardview.widget.CardView) bindings[7]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.CheckBox) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.CheckBox) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.CheckBox) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.CheckBox) bindings[4];
        this.mboundView4.setTag(null);
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
        if (BR.bio == variableId) {
            setBio((com.telpo.usb.finger.pojo.BiometricsTaken) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setBio(@Nullable com.telpo.usb.finger.pojo.BiometricsTaken Bio) {
        this.mBio = Bio;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.bio);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeBioSignature((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 1 :
                return onChangeBioPhoto((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 2 :
                return onChangeBioFingerprint((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 3 :
                return onChangeBioSupportdocs((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeBioSignature(androidx.databinding.ObservableField<java.lang.Boolean> BioSignature, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBioPhoto(androidx.databinding.ObservableField<java.lang.Boolean> BioPhoto, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBioFingerprint(androidx.databinding.ObservableField<java.lang.Boolean> BioFingerprint, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBioSupportdocs(androidx.databinding.ObservableField<java.lang.Boolean> BioSupportdocs, int fieldId) {
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
        boolean androidxDatabindingViewDataBindingSafeUnboxBioPhotoGet = false;
        androidx.databinding.ObservableField<java.lang.Boolean> bioSignature = null;
        androidx.databinding.ObservableField<java.lang.Boolean> bioPhoto = null;
        java.lang.Boolean bioSupportdocsGet = null;
        androidx.databinding.ObservableField<java.lang.Boolean> bioFingerprint = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxBioFingerprintGet = false;
        boolean androidxDatabindingViewDataBindingSafeUnboxBioSupportdocsGet = false;
        java.lang.Boolean bioFingerprintGet = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxBioSignatureGet = false;
        java.lang.Boolean bioPhotoGet = null;
        androidx.databinding.ObservableField<java.lang.Boolean> bioSupportdocs = null;
        com.telpo.usb.finger.pojo.BiometricsTaken bio = mBio;
        java.lang.Boolean bioSignatureGet = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (bio != null) {
                        // read bio.signature
                        bioSignature = bio.signature;
                    }
                    updateRegistration(0, bioSignature);


                    if (bioSignature != null) {
                        // read bio.signature.get()
                        bioSignatureGet = bioSignature.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(bio.signature.get())
                    androidxDatabindingViewDataBindingSafeUnboxBioSignatureGet = androidx.databinding.ViewDataBinding.safeUnbox(bioSignatureGet);
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (bio != null) {
                        // read bio.photo
                        bioPhoto = bio.photo;
                    }
                    updateRegistration(1, bioPhoto);


                    if (bioPhoto != null) {
                        // read bio.photo.get()
                        bioPhotoGet = bioPhoto.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(bio.photo.get())
                    androidxDatabindingViewDataBindingSafeUnboxBioPhotoGet = androidx.databinding.ViewDataBinding.safeUnbox(bioPhotoGet);
            }
            if ((dirtyFlags & 0x34L) != 0) {

                    if (bio != null) {
                        // read bio.fingerprint
                        bioFingerprint = bio.fingerprint;
                    }
                    updateRegistration(2, bioFingerprint);


                    if (bioFingerprint != null) {
                        // read bio.fingerprint.get()
                        bioFingerprintGet = bioFingerprint.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(bio.fingerprint.get())
                    androidxDatabindingViewDataBindingSafeUnboxBioFingerprintGet = androidx.databinding.ViewDataBinding.safeUnbox(bioFingerprintGet);
            }
            if ((dirtyFlags & 0x38L) != 0) {

                    if (bio != null) {
                        // read bio.supportdocs
                        bioSupportdocs = bio.supportdocs;
                    }
                    updateRegistration(3, bioSupportdocs);


                    if (bioSupportdocs != null) {
                        // read bio.supportdocs.get()
                        bioSupportdocsGet = bioSupportdocs.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(bio.supportdocs.get())
                    androidxDatabindingViewDataBindingSafeUnboxBioSupportdocsGet = androidx.databinding.ViewDataBinding.safeUnbox(bioSupportdocsGet);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView1, androidxDatabindingViewDataBindingSafeUnboxBioPhotoGet);
        }
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView2, androidxDatabindingViewDataBindingSafeUnboxBioFingerprintGet);
        }
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView3, androidxDatabindingViewDataBindingSafeUnboxBioSupportdocsGet);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.mboundView4, androidxDatabindingViewDataBindingSafeUnboxBioSignatureGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): bio.signature
        flag 1 (0x2L): bio.photo
        flag 2 (0x3L): bio.fingerprint
        flag 3 (0x4L): bio.supportdocs
        flag 4 (0x5L): bio
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}