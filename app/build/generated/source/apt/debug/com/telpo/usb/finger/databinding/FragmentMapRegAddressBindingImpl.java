package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMapRegAddressBindingImpl extends FragmentMapRegAddressBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.mapaddrlayout, 7);
        sViewsWithIds.put(R.id.maprefresh, 8);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.EditText mboundView1;
    @NonNull
    private final android.widget.EditText mboundView2;
    @NonNull
    private final android.widget.EditText mboundView3;
    @NonNull
    private final android.widget.EditText mboundView4;
    @NonNull
    private final android.widget.EditText mboundView5;
    @NonNull
    private final android.widget.EditText mboundView6;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.latitude.get()
            //         is resaddr.latitude.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView1);
            // localize variables for thread safety
            // resaddr.latitude != null
            boolean resaddrLatitudeJavaLangObjectNull = false;
            // resaddr != null
            boolean resaddrJavaLangObjectNull = false;
            // resaddr
            com.telpo.usb.finger.pojo.ResidentialAddress resaddr = mResaddr;
            // resaddr.latitude
            androidx.databinding.ObservableField<java.lang.String> resaddrLatitude = null;
            // resaddr.latitude.get()
            java.lang.String resaddrLatitudeGet = null;



            resaddrJavaLangObjectNull = (resaddr) != (null);
            if (resaddrJavaLangObjectNull) {


                resaddrLatitude = resaddr.latitude;

                resaddrLatitudeJavaLangObjectNull = (resaddrLatitude) != (null);
                if (resaddrLatitudeJavaLangObjectNull) {




                    resaddrLatitude.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.longitude.get()
            //         is resaddr.longitude.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // resaddr != null
            boolean resaddrJavaLangObjectNull = false;
            // resaddr.longitude
            androidx.databinding.ObservableField<java.lang.String> resaddrLongitude = null;
            // resaddr
            com.telpo.usb.finger.pojo.ResidentialAddress resaddr = mResaddr;
            // resaddr.longitude != null
            boolean resaddrLongitudeJavaLangObjectNull = false;
            // resaddr.longitude.get()
            java.lang.String resaddrLongitudeGet = null;



            resaddrJavaLangObjectNull = (resaddr) != (null);
            if (resaddrJavaLangObjectNull) {


                resaddrLongitude = resaddr.longitude;

                resaddrLongitudeJavaLangObjectNull = (resaddrLongitude) != (null);
                if (resaddrLongitudeJavaLangObjectNull) {




                    resaddrLongitude.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.streetname.get()
            //         is resaddr.streetname.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // resaddr != null
            boolean resaddrJavaLangObjectNull = false;
            // resaddr.streetname.get()
            java.lang.String resaddrStreetnameGet = null;
            // resaddr.streetname != null
            boolean resaddrStreetnameJavaLangObjectNull = false;
            // resaddr
            com.telpo.usb.finger.pojo.ResidentialAddress resaddr = mResaddr;
            // resaddr.streetname
            androidx.databinding.ObservableField<java.lang.String> resaddrStreetname = null;



            resaddrJavaLangObjectNull = (resaddr) != (null);
            if (resaddrJavaLangObjectNull) {


                resaddrStreetname = resaddr.streetname;

                resaddrStreetnameJavaLangObjectNull = (resaddrStreetname) != (null);
                if (resaddrStreetnameJavaLangObjectNull) {




                    resaddrStreetname.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.city.get()
            //         is resaddr.city.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // resaddr != null
            boolean resaddrJavaLangObjectNull = false;
            // resaddr
            com.telpo.usb.finger.pojo.ResidentialAddress resaddr = mResaddr;
            // resaddr.city
            androidx.databinding.ObservableField<java.lang.String> resaddrCity = null;
            // resaddr.city != null
            boolean resaddrCityJavaLangObjectNull = false;
            // resaddr.city.get()
            java.lang.String resaddrCityGet = null;



            resaddrJavaLangObjectNull = (resaddr) != (null);
            if (resaddrJavaLangObjectNull) {


                resaddrCity = resaddr.city;

                resaddrCityJavaLangObjectNull = (resaddrCity) != (null);
                if (resaddrCityJavaLangObjectNull) {




                    resaddrCity.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView5androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.region.get()
            //         is resaddr.region.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView5);
            // localize variables for thread safety
            // resaddr.region
            androidx.databinding.ObservableField<java.lang.String> resaddrRegion = null;
            // resaddr.region != null
            boolean resaddrRegionJavaLangObjectNull = false;
            // resaddr != null
            boolean resaddrJavaLangObjectNull = false;
            // resaddr.region.get()
            java.lang.String resaddrRegionGet = null;
            // resaddr
            com.telpo.usb.finger.pojo.ResidentialAddress resaddr = mResaddr;



            resaddrJavaLangObjectNull = (resaddr) != (null);
            if (resaddrJavaLangObjectNull) {


                resaddrRegion = resaddr.region;

                resaddrRegionJavaLangObjectNull = (resaddrRegion) != (null);
                if (resaddrRegionJavaLangObjectNull) {




                    resaddrRegion.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView6androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.assembly.get()
            //         is resaddr.assembly.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView6);
            // localize variables for thread safety
            // resaddr.assembly
            androidx.databinding.ObservableField<java.lang.String> resaddrAssembly = null;
            // resaddr.assembly != null
            boolean resaddrAssemblyJavaLangObjectNull = false;
            // resaddr != null
            boolean resaddrJavaLangObjectNull = false;
            // resaddr
            com.telpo.usb.finger.pojo.ResidentialAddress resaddr = mResaddr;
            // resaddr.assembly.get()
            java.lang.String resaddrAssemblyGet = null;



            resaddrJavaLangObjectNull = (resaddr) != (null);
            if (resaddrJavaLangObjectNull) {


                resaddrAssembly = resaddr.assembly;

                resaddrAssemblyJavaLangObjectNull = (resaddrAssembly) != (null);
                if (resaddrAssemblyJavaLangObjectNull) {




                    resaddrAssembly.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentMapRegAddressBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentMapRegAddressBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.Button) bindings[8]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.EditText) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.EditText) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.EditText) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.EditText) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.EditText) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.EditText) bindings[6];
        this.mboundView6.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80L;
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
        if (BR.resaddr == variableId) {
            setResaddr((com.telpo.usb.finger.pojo.ResidentialAddress) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setResaddr(@Nullable com.telpo.usb.finger.pojo.ResidentialAddress Resaddr) {
        this.mResaddr = Resaddr;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.resaddr);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeResaddrStreetname((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeResaddrLongitude((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeResaddrAssembly((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeResaddrCity((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeResaddrRegion((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeResaddrLatitude((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeResaddrStreetname(androidx.databinding.ObservableField<java.lang.String> ResaddrStreetname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResaddrLongitude(androidx.databinding.ObservableField<java.lang.String> ResaddrLongitude, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResaddrAssembly(androidx.databinding.ObservableField<java.lang.String> ResaddrAssembly, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResaddrCity(androidx.databinding.ObservableField<java.lang.String> ResaddrCity, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResaddrRegion(androidx.databinding.ObservableField<java.lang.String> ResaddrRegion, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResaddrLatitude(androidx.databinding.ObservableField<java.lang.String> ResaddrLatitude, int fieldId) {
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
        java.lang.String resaddrStreetnameGet = null;
        com.telpo.usb.finger.pojo.ResidentialAddress resaddr = mResaddr;
        java.lang.String resaddrLatitudeGet = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrStreetname = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrLongitude = null;
        java.lang.String resaddrRegionGet = null;
        java.lang.String resaddrCityGet = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrAssembly = null;
        java.lang.String resaddrLongitudeGet = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrCity = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrRegion = null;
        java.lang.String resaddrAssemblyGet = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrLatitude = null;

        if ((dirtyFlags & 0xffL) != 0) {


            if ((dirtyFlags & 0xc1L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.streetname
                        resaddrStreetname = resaddr.streetname;
                    }
                    updateRegistration(0, resaddrStreetname);


                    if (resaddrStreetname != null) {
                        // read resaddr.streetname.get()
                        resaddrStreetnameGet = resaddrStreetname.get();
                    }
            }
            if ((dirtyFlags & 0xc2L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.longitude
                        resaddrLongitude = resaddr.longitude;
                    }
                    updateRegistration(1, resaddrLongitude);


                    if (resaddrLongitude != null) {
                        // read resaddr.longitude.get()
                        resaddrLongitudeGet = resaddrLongitude.get();
                    }
            }
            if ((dirtyFlags & 0xc4L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.assembly
                        resaddrAssembly = resaddr.assembly;
                    }
                    updateRegistration(2, resaddrAssembly);


                    if (resaddrAssembly != null) {
                        // read resaddr.assembly.get()
                        resaddrAssemblyGet = resaddrAssembly.get();
                    }
            }
            if ((dirtyFlags & 0xc8L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.city
                        resaddrCity = resaddr.city;
                    }
                    updateRegistration(3, resaddrCity);


                    if (resaddrCity != null) {
                        // read resaddr.city.get()
                        resaddrCityGet = resaddrCity.get();
                    }
            }
            if ((dirtyFlags & 0xd0L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.region
                        resaddrRegion = resaddr.region;
                    }
                    updateRegistration(4, resaddrRegion);


                    if (resaddrRegion != null) {
                        // read resaddr.region.get()
                        resaddrRegionGet = resaddrRegion.get();
                    }
            }
            if ((dirtyFlags & 0xe0L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.latitude
                        resaddrLatitude = resaddr.latitude;
                    }
                    updateRegistration(5, resaddrLatitude);


                    if (resaddrLatitude != null) {
                        // read resaddr.latitude.get()
                        resaddrLatitudeGet = resaddrLatitude.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xe0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, resaddrLatitudeGet);
        }
        if ((dirtyFlags & 0x80L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView5, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView5androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView6, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView6androidTextAttrChanged);
        }
        if ((dirtyFlags & 0xc2L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, resaddrLongitudeGet);
        }
        if ((dirtyFlags & 0xc1L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, resaddrStreetnameGet);
        }
        if ((dirtyFlags & 0xc8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, resaddrCityGet);
        }
        if ((dirtyFlags & 0xd0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, resaddrRegionGet);
        }
        if ((dirtyFlags & 0xc4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, resaddrAssemblyGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): resaddr.streetname
        flag 1 (0x2L): resaddr.longitude
        flag 2 (0x3L): resaddr.assembly
        flag 3 (0x4L): resaddr.city
        flag 4 (0x5L): resaddr.region
        flag 5 (0x6L): resaddr.latitude
        flag 6 (0x7L): resaddr
        flag 7 (0x8L): null
    flag mapping end*/
    //end
}