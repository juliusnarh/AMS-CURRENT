package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentFarmerProfileSummaryBindingImpl extends FragmentFarmerProfileSummaryBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.expandable_personalinfo_layout, 25);
        sViewsWithIds.put(R.id.personalheader, 26);
        sViewsWithIds.put(R.id.personalarrow, 27);
        sViewsWithIds.put(R.id.editpersonalinfo, 28);
        sViewsWithIds.put(R.id.editgeoaddr, 29);
        sViewsWithIds.put(R.id.expandable_biometric_layout, 30);
        sViewsWithIds.put(R.id.bioheader, 31);
        sViewsWithIds.put(R.id.bioarrow, 32);
        sViewsWithIds.put(R.id.editbio, 33);
        sViewsWithIds.put(R.id.pic, 34);
        sViewsWithIds.put(R.id.sig, 35);
        sViewsWithIds.put(R.id.expandable_docs_layout, 36);
        sViewsWithIds.put(R.id.docsheader, 37);
        sViewsWithIds.put(R.id.docsarrow, 38);
        sViewsWithIds.put(R.id.editdocs, 39);
        sViewsWithIds.put(R.id.scandocrecycler, 40);
        sViewsWithIds.put(R.id.expandable_household_layout, 41);
        sViewsWithIds.put(R.id.hseholdheader, 42);
        sViewsWithIds.put(R.id.addhousehold, 43);
        sViewsWithIds.put(R.id.householdstats, 44);
        sViewsWithIds.put(R.id.hseholdarrow, 45);
        sViewsWithIds.put(R.id.household_recyclerview, 46);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView10;
    @NonNull
    private final android.widget.TextView mboundView11;
    @NonNull
    private final android.widget.TextView mboundView12;
    @NonNull
    private final android.widget.TextView mboundView13;
    @NonNull
    private final android.widget.TextView mboundView14;
    @NonNull
    private final android.widget.TextView mboundView15;
    @NonNull
    private final android.widget.TextView mboundView16;
    @NonNull
    private final android.widget.TextView mboundView17;
    @NonNull
    private final android.widget.TextView mboundView18;
    @NonNull
    private final android.widget.TextView mboundView19;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView20;
    @NonNull
    private final android.widget.TextView mboundView21;
    @NonNull
    private final android.widget.TextView mboundView22;
    @NonNull
    private final android.widget.TextView mboundView23;
    @NonNull
    private final android.widget.TextView mboundView24;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    @NonNull
    private final android.widget.TextView mboundView7;
    @NonNull
    private final android.widget.TextView mboundView8;
    @NonNull
    private final android.widget.TextView mboundView9;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView19androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.latitude.get()
            //         is resaddr.latitude.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView19);
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
    private androidx.databinding.InverseBindingListener mboundView20androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.longitude.get()
            //         is resaddr.longitude.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView20);
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
    private androidx.databinding.InverseBindingListener mboundView21androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.streetname.get()
            //         is resaddr.streetname.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView21);
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
    private androidx.databinding.InverseBindingListener mboundView22androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.city.get()
            //         is resaddr.city.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView22);
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
    private androidx.databinding.InverseBindingListener mboundView23androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.region.get()
            //         is resaddr.region.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView23);
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
    private androidx.databinding.InverseBindingListener mboundView24androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of resaddr.assembly.get()
            //         is resaddr.assembly.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView24);
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

    public FragmentFarmerProfileSummaryBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 47, sIncludes, sViewsWithIds));
    }
    private FragmentFarmerProfileSummaryBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 25
            , (android.widget.Button) bindings[43]
            , (android.widget.ImageView) bindings[32]
            , (android.widget.TextView) bindings[31]
            , (android.widget.ImageView) bindings[38]
            , (android.widget.TextView) bindings[37]
            , (android.widget.Button) bindings[33]
            , (android.widget.Button) bindings[39]
            , (android.widget.Button) bindings[29]
            , (android.widget.Button) bindings[28]
            , (com.silencedut.expandablelayout.ExpandableLayout) bindings[30]
            , (com.silencedut.expandablelayout.ExpandableLayout) bindings[36]
            , (com.silencedut.expandablelayout.ExpandableLayout) bindings[41]
            , (com.silencedut.expandablelayout.ExpandableLayout) bindings[25]
            , (androidx.recyclerview.widget.RecyclerView) bindings[46]
            , (android.widget.TextView) bindings[44]
            , (android.widget.ImageView) bindings[45]
            , (android.widget.TextView) bindings[42]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.TextView) bindings[26]
            , (android.widget.ImageView) bindings[34]
            , (androidx.recyclerview.widget.RecyclerView) bindings[40]
            , (android.widget.ImageView) bindings[35]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView10 = (android.widget.TextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView11 = (android.widget.TextView) bindings[11];
        this.mboundView11.setTag(null);
        this.mboundView12 = (android.widget.TextView) bindings[12];
        this.mboundView12.setTag(null);
        this.mboundView13 = (android.widget.TextView) bindings[13];
        this.mboundView13.setTag(null);
        this.mboundView14 = (android.widget.TextView) bindings[14];
        this.mboundView14.setTag(null);
        this.mboundView15 = (android.widget.TextView) bindings[15];
        this.mboundView15.setTag(null);
        this.mboundView16 = (android.widget.TextView) bindings[16];
        this.mboundView16.setTag(null);
        this.mboundView17 = (android.widget.TextView) bindings[17];
        this.mboundView17.setTag(null);
        this.mboundView18 = (android.widget.TextView) bindings[18];
        this.mboundView18.setTag(null);
        this.mboundView19 = (android.widget.TextView) bindings[19];
        this.mboundView19.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView20 = (android.widget.TextView) bindings[20];
        this.mboundView20.setTag(null);
        this.mboundView21 = (android.widget.TextView) bindings[21];
        this.mboundView21.setTag(null);
        this.mboundView22 = (android.widget.TextView) bindings[22];
        this.mboundView22.setTag(null);
        this.mboundView23 = (android.widget.TextView) bindings[23];
        this.mboundView23.setTag(null);
        this.mboundView24 = (android.widget.TextView) bindings[24];
        this.mboundView24.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (android.widget.TextView) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.TextView) bindings[9];
        this.mboundView9.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10000000L;
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
        else if (BR.basicreg == variableId) {
            setBasicreg((com.telpo.usb.finger.pojo.BasicRegistration) variable);
        }
        else if (BR.bio == variableId) {
            setBio((com.telpo.usb.finger.pojo.BiometricsTaken) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setResaddr(@Nullable com.telpo.usb.finger.pojo.ResidentialAddress Resaddr) {
        this.mResaddr = Resaddr;
        synchronized(this) {
            mDirtyFlags |= 0x2000000L;
        }
        notifyPropertyChanged(BR.resaddr);
        super.requestRebind();
    }
    public void setBasicreg(@Nullable com.telpo.usb.finger.pojo.BasicRegistration Basicreg) {
        this.mBasicreg = Basicreg;
        synchronized(this) {
            mDirtyFlags |= 0x4000000L;
        }
        notifyPropertyChanged(BR.basicreg);
        super.requestRebind();
    }
    public void setBio(@Nullable com.telpo.usb.finger.pojo.BiometricsTaken Bio) {
        this.mBio = Bio;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeBasicregSurname((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeBasicregIdnumber((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeBasicregResidentialaddr((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeBasicregPlaceofbirth((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeBasicregRegion((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeBasicregFarmcommunity((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeResaddrStreetname((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 7 :
                return onChangeResaddrLongitude((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 8 :
                return onChangeBasicregDateofbirth((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 9 :
                return onChangeBasicregGender((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 10 :
                return onChangeBasicregMaritalstatus((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 11 :
                return onChangeResaddrAssembly((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 12 :
                return onChangeBasicregEmail((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 13 :
                return onChangeBasicregLevelofeducation((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 14 :
                return onChangeBasicregDistrict((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 15 :
                return onChangeBasicregHometown((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 16 :
                return onChangeResaddrCity((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 17 :
                return onChangeResaddrRegion((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 18 :
                return onChangeBasicregFirstname((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 19 :
                return onChangeBasicregIdtype((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 20 :
                return onChangeBasicregPostofficebox((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 21 :
                return onChangeBasicregNationality((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 22 :
                return onChangeResaddrLatitude((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 23 :
                return onChangeBasicregAge((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 24 :
                return onChangeBasicregTelephone((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeBasicregSurname(androidx.databinding.ObservableField<java.lang.String> BasicregSurname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregIdnumber(androidx.databinding.ObservableField<java.lang.String> BasicregIdnumber, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregResidentialaddr(androidx.databinding.ObservableField<java.lang.String> BasicregResidentialaddr, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregPlaceofbirth(androidx.databinding.ObservableField<java.lang.String> BasicregPlaceofbirth, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregRegion(androidx.databinding.ObservableField<java.lang.String> BasicregRegion, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregFarmcommunity(androidx.databinding.ObservableField<java.lang.String> BasicregFarmcommunity, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResaddrStreetname(androidx.databinding.ObservableField<java.lang.String> ResaddrStreetname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResaddrLongitude(androidx.databinding.ObservableField<java.lang.String> ResaddrLongitude, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregDateofbirth(androidx.databinding.ObservableField<java.lang.String> BasicregDateofbirth, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregGender(androidx.databinding.ObservableField<java.lang.String> BasicregGender, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregMaritalstatus(androidx.databinding.ObservableField<java.lang.String> BasicregMaritalstatus, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x400L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResaddrAssembly(androidx.databinding.ObservableField<java.lang.String> ResaddrAssembly, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x800L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregEmail(androidx.databinding.ObservableField<java.lang.String> BasicregEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregLevelofeducation(androidx.databinding.ObservableField<java.lang.String> BasicregLevelofeducation, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregDistrict(androidx.databinding.ObservableField<java.lang.String> BasicregDistrict, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregHometown(androidx.databinding.ObservableField<java.lang.String> BasicregHometown, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResaddrCity(androidx.databinding.ObservableField<java.lang.String> ResaddrCity, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResaddrRegion(androidx.databinding.ObservableField<java.lang.String> ResaddrRegion, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregFirstname(androidx.databinding.ObservableField<java.lang.String> BasicregFirstname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregIdtype(androidx.databinding.ObservableField<java.lang.String> BasicregIdtype, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregPostofficebox(androidx.databinding.ObservableField<java.lang.String> BasicregPostofficebox, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregNationality(androidx.databinding.ObservableField<java.lang.String> BasicregNationality, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeResaddrLatitude(androidx.databinding.ObservableField<java.lang.String> ResaddrLatitude, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x400000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregAge(androidx.databinding.ObservableField<java.lang.String> BasicregAge, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x800000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregTelephone(androidx.databinding.ObservableField<java.lang.String> BasicregTelephone, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000000L;
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
        androidx.databinding.ObservableField<java.lang.String> basicregSurname = null;
        java.lang.String resaddrStreetnameGet = null;
        com.telpo.usb.finger.pojo.ResidentialAddress resaddr = mResaddr;
        androidx.databinding.ObservableField<java.lang.String> basicregIdnumber = null;
        androidx.databinding.ObservableField<java.lang.String> basicregResidentialaddr = null;
        androidx.databinding.ObservableField<java.lang.String> basicregPlaceofbirth = null;
        java.lang.String resaddrLatitudeGet = null;
        java.lang.String basicregSurnameGet = null;
        java.lang.String basicregFarmcommunityGet = null;
        java.lang.String basicregIdnumberGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregRegion = null;
        androidx.databinding.ObservableField<java.lang.String> basicregFarmcommunity = null;
        java.lang.String basicregResidentialaddrGet = null;
        java.lang.String basicregEmailGet = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrStreetname = null;
        java.lang.String basicregPostofficeboxGet = null;
        java.lang.String basicregNationalityGet = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrLongitude = null;
        java.lang.String basicregMaritalstatusGet = null;
        java.lang.String basicregSurnameCharBasicregFirstname = null;
        androidx.databinding.ObservableField<java.lang.String> basicregDateofbirth = null;
        java.lang.String resaddrRegionGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregGender = null;
        androidx.databinding.ObservableField<java.lang.String> basicregMaritalstatus = null;
        java.lang.String basicregHometownGet = null;
        java.lang.String basicregIdtypeGet = null;
        java.lang.String resaddrCityGet = null;
        java.lang.String basicregTelephoneGet = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrAssembly = null;
        androidx.databinding.ObservableField<java.lang.String> basicregEmail = null;
        androidx.databinding.ObservableField<java.lang.String> basicregLevelofeducation = null;
        java.lang.String basicregSurnameChar = null;
        java.lang.String basicregAgeGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregDistrict = null;
        java.lang.String basicregFirstnameGet = null;
        java.lang.String resaddrLongitudeGet = null;
        java.lang.String basicregDateofbirthGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregHometown = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrCity = null;
        java.lang.String basicregLevelofeducationGet = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrRegion = null;
        java.lang.String basicregDistrictGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregFirstname = null;
        java.lang.String basicregGenderGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregIdtype = null;
        java.lang.String basicregRegionGet = null;
        java.lang.String basicregPlaceofbirthGet = null;
        java.lang.String resaddrAssemblyGet = null;
        com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;
        androidx.databinding.ObservableField<java.lang.String> basicregPostofficebox = null;
        androidx.databinding.ObservableField<java.lang.String> basicregNationality = null;
        androidx.databinding.ObservableField<java.lang.String> resaddrLatitude = null;
        androidx.databinding.ObservableField<java.lang.String> basicregAge = null;
        androidx.databinding.ObservableField<java.lang.String> basicregTelephone = null;

        if ((dirtyFlags & 0x124308c0L) != 0) {


            if ((dirtyFlags & 0x12000040L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.streetname
                        resaddrStreetname = resaddr.streetname;
                    }
                    updateRegistration(6, resaddrStreetname);


                    if (resaddrStreetname != null) {
                        // read resaddr.streetname.get()
                        resaddrStreetnameGet = resaddrStreetname.get();
                    }
            }
            if ((dirtyFlags & 0x12000080L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.longitude
                        resaddrLongitude = resaddr.longitude;
                    }
                    updateRegistration(7, resaddrLongitude);


                    if (resaddrLongitude != null) {
                        // read resaddr.longitude.get()
                        resaddrLongitudeGet = resaddrLongitude.get();
                    }
            }
            if ((dirtyFlags & 0x12000800L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.assembly
                        resaddrAssembly = resaddr.assembly;
                    }
                    updateRegistration(11, resaddrAssembly);


                    if (resaddrAssembly != null) {
                        // read resaddr.assembly.get()
                        resaddrAssemblyGet = resaddrAssembly.get();
                    }
            }
            if ((dirtyFlags & 0x12010000L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.city
                        resaddrCity = resaddr.city;
                    }
                    updateRegistration(16, resaddrCity);


                    if (resaddrCity != null) {
                        // read resaddr.city.get()
                        resaddrCityGet = resaddrCity.get();
                    }
            }
            if ((dirtyFlags & 0x12020000L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.region
                        resaddrRegion = resaddr.region;
                    }
                    updateRegistration(17, resaddrRegion);


                    if (resaddrRegion != null) {
                        // read resaddr.region.get()
                        resaddrRegionGet = resaddrRegion.get();
                    }
            }
            if ((dirtyFlags & 0x12400000L) != 0) {

                    if (resaddr != null) {
                        // read resaddr.latitude
                        resaddrLatitude = resaddr.latitude;
                    }
                    updateRegistration(22, resaddrLatitude);


                    if (resaddrLatitude != null) {
                        // read resaddr.latitude.get()
                        resaddrLatitudeGet = resaddrLatitude.get();
                    }
            }
        }
        if ((dirtyFlags & 0x15bcf73fL) != 0) {


            if ((dirtyFlags & 0x14040001L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.surname
                        basicregSurname = basicreg.surname;
                        // read basicreg.firstname
                        basicregFirstname = basicreg.firstname;
                    }
                    updateRegistration(0, basicregSurname);
                    updateRegistration(18, basicregFirstname);


                    if (basicregSurname != null) {
                        // read basicreg.surname.get()
                        basicregSurnameGet = basicregSurname.get();
                    }
                    if (basicregFirstname != null) {
                        // read basicreg.firstname.get()
                        basicregFirstnameGet = basicregFirstname.get();
                    }


                    // read (basicreg.surname.get()) + (' ')
                    basicregSurnameChar = (basicregSurnameGet) + (' ');


                    // read ((basicreg.surname.get()) + (' ')) + (basicreg.firstname.get())
                    basicregSurnameCharBasicregFirstname = (basicregSurnameChar) + (basicregFirstnameGet);
            }
            if ((dirtyFlags & 0x14000002L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.idnumber
                        basicregIdnumber = basicreg.idnumber;
                    }
                    updateRegistration(1, basicregIdnumber);


                    if (basicregIdnumber != null) {
                        // read basicreg.idnumber.get()
                        basicregIdnumberGet = basicregIdnumber.get();
                    }
            }
            if ((dirtyFlags & 0x14000004L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.residentialaddr
                        basicregResidentialaddr = basicreg.residentialaddr;
                    }
                    updateRegistration(2, basicregResidentialaddr);


                    if (basicregResidentialaddr != null) {
                        // read basicreg.residentialaddr.get()
                        basicregResidentialaddrGet = basicregResidentialaddr.get();
                    }
            }
            if ((dirtyFlags & 0x14000008L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.placeofbirth
                        basicregPlaceofbirth = basicreg.placeofbirth;
                    }
                    updateRegistration(3, basicregPlaceofbirth);


                    if (basicregPlaceofbirth != null) {
                        // read basicreg.placeofbirth.get()
                        basicregPlaceofbirthGet = basicregPlaceofbirth.get();
                    }
            }
            if ((dirtyFlags & 0x14000010L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.region
                        basicregRegion = basicreg.region;
                    }
                    updateRegistration(4, basicregRegion);


                    if (basicregRegion != null) {
                        // read basicreg.region.get()
                        basicregRegionGet = basicregRegion.get();
                    }
            }
            if ((dirtyFlags & 0x14000020L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.farmcommunity
                        basicregFarmcommunity = basicreg.farmcommunity;
                    }
                    updateRegistration(5, basicregFarmcommunity);


                    if (basicregFarmcommunity != null) {
                        // read basicreg.farmcommunity.get()
                        basicregFarmcommunityGet = basicregFarmcommunity.get();
                    }
            }
            if ((dirtyFlags & 0x14000100L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.dateofbirth
                        basicregDateofbirth = basicreg.dateofbirth;
                    }
                    updateRegistration(8, basicregDateofbirth);


                    if (basicregDateofbirth != null) {
                        // read basicreg.dateofbirth.get()
                        basicregDateofbirthGet = basicregDateofbirth.get();
                    }
            }
            if ((dirtyFlags & 0x14000200L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.gender
                        basicregGender = basicreg.gender;
                    }
                    updateRegistration(9, basicregGender);


                    if (basicregGender != null) {
                        // read basicreg.gender.get()
                        basicregGenderGet = basicregGender.get();
                    }
            }
            if ((dirtyFlags & 0x14000400L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.maritalstatus
                        basicregMaritalstatus = basicreg.maritalstatus;
                    }
                    updateRegistration(10, basicregMaritalstatus);


                    if (basicregMaritalstatus != null) {
                        // read basicreg.maritalstatus.get()
                        basicregMaritalstatusGet = basicregMaritalstatus.get();
                    }
            }
            if ((dirtyFlags & 0x14001000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.email
                        basicregEmail = basicreg.email;
                    }
                    updateRegistration(12, basicregEmail);


                    if (basicregEmail != null) {
                        // read basicreg.email.get()
                        basicregEmailGet = basicregEmail.get();
                    }
            }
            if ((dirtyFlags & 0x14002000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.levelofeducation
                        basicregLevelofeducation = basicreg.levelofeducation;
                    }
                    updateRegistration(13, basicregLevelofeducation);


                    if (basicregLevelofeducation != null) {
                        // read basicreg.levelofeducation.get()
                        basicregLevelofeducationGet = basicregLevelofeducation.get();
                    }
            }
            if ((dirtyFlags & 0x14004000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.district
                        basicregDistrict = basicreg.district;
                    }
                    updateRegistration(14, basicregDistrict);


                    if (basicregDistrict != null) {
                        // read basicreg.district.get()
                        basicregDistrictGet = basicregDistrict.get();
                    }
            }
            if ((dirtyFlags & 0x14008000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.hometown
                        basicregHometown = basicreg.hometown;
                    }
                    updateRegistration(15, basicregHometown);


                    if (basicregHometown != null) {
                        // read basicreg.hometown.get()
                        basicregHometownGet = basicregHometown.get();
                    }
            }
            if ((dirtyFlags & 0x14080000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.idtype
                        basicregIdtype = basicreg.idtype;
                    }
                    updateRegistration(19, basicregIdtype);


                    if (basicregIdtype != null) {
                        // read basicreg.idtype.get()
                        basicregIdtypeGet = basicregIdtype.get();
                    }
            }
            if ((dirtyFlags & 0x14100000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.postofficebox
                        basicregPostofficebox = basicreg.postofficebox;
                    }
                    updateRegistration(20, basicregPostofficebox);


                    if (basicregPostofficebox != null) {
                        // read basicreg.postofficebox.get()
                        basicregPostofficeboxGet = basicregPostofficebox.get();
                    }
            }
            if ((dirtyFlags & 0x14200000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.nationality
                        basicregNationality = basicreg.nationality;
                    }
                    updateRegistration(21, basicregNationality);


                    if (basicregNationality != null) {
                        // read basicreg.nationality.get()
                        basicregNationalityGet = basicregNationality.get();
                    }
            }
            if ((dirtyFlags & 0x14800000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.age
                        basicregAge = basicreg.age;
                    }
                    updateRegistration(23, basicregAge);


                    if (basicregAge != null) {
                        // read basicreg.age.get()
                        basicregAgeGet = basicregAge.get();
                    }
            }
            if ((dirtyFlags & 0x15000000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.telephone
                        basicregTelephone = basicreg.telephone;
                    }
                    updateRegistration(24, basicregTelephone);


                    if (basicregTelephone != null) {
                        // read basicreg.telephone.get()
                        basicregTelephoneGet = basicregTelephone.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x14040001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, basicregSurnameCharBasicregFirstname);
        }
        if ((dirtyFlags & 0x14004000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView10, basicregDistrictGet);
        }
        if ((dirtyFlags & 0x14000400L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView11, basicregMaritalstatusGet);
        }
        if ((dirtyFlags & 0x14002000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView12, basicregLevelofeducationGet);
        }
        if ((dirtyFlags & 0x14080000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView13, basicregIdtypeGet);
        }
        if ((dirtyFlags & 0x14000002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView14, basicregIdnumberGet);
        }
        if ((dirtyFlags & 0x15000000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView15, basicregTelephoneGet);
        }
        if ((dirtyFlags & 0x14001000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView16, basicregEmailGet);
        }
        if ((dirtyFlags & 0x14000004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView17, basicregResidentialaddrGet);
        }
        if ((dirtyFlags & 0x14100000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView18, basicregPostofficeboxGet);
        }
        if ((dirtyFlags & 0x12400000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView19, resaddrLatitudeGet);
        }
        if ((dirtyFlags & 0x10000000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView19, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView19androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView20, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView20androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView21, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView21androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView22, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView22androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView23, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView23androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView24, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView24androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x14200000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, basicregNationalityGet);
        }
        if ((dirtyFlags & 0x12000080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView20, resaddrLongitudeGet);
        }
        if ((dirtyFlags & 0x12000040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView21, resaddrStreetnameGet);
        }
        if ((dirtyFlags & 0x12010000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView22, resaddrCityGet);
        }
        if ((dirtyFlags & 0x12020000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView23, resaddrRegionGet);
        }
        if ((dirtyFlags & 0x12000800L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView24, resaddrAssemblyGet);
        }
        if ((dirtyFlags & 0x14000200L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, basicregGenderGet);
        }
        if ((dirtyFlags & 0x14000100L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, basicregDateofbirthGet);
        }
        if ((dirtyFlags & 0x14800000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, basicregAgeGet);
        }
        if ((dirtyFlags & 0x14000008L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, basicregPlaceofbirthGet);
        }
        if ((dirtyFlags & 0x14008000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, basicregHometownGet);
        }
        if ((dirtyFlags & 0x14000020L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, basicregFarmcommunityGet);
        }
        if ((dirtyFlags & 0x14000010L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, basicregRegionGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): basicreg.surname
        flag 1 (0x2L): basicreg.idnumber
        flag 2 (0x3L): basicreg.residentialaddr
        flag 3 (0x4L): basicreg.placeofbirth
        flag 4 (0x5L): basicreg.region
        flag 5 (0x6L): basicreg.farmcommunity
        flag 6 (0x7L): resaddr.streetname
        flag 7 (0x8L): resaddr.longitude
        flag 8 (0x9L): basicreg.dateofbirth
        flag 9 (0xaL): basicreg.gender
        flag 10 (0xbL): basicreg.maritalstatus
        flag 11 (0xcL): resaddr.assembly
        flag 12 (0xdL): basicreg.email
        flag 13 (0xeL): basicreg.levelofeducation
        flag 14 (0xfL): basicreg.district
        flag 15 (0x10L): basicreg.hometown
        flag 16 (0x11L): resaddr.city
        flag 17 (0x12L): resaddr.region
        flag 18 (0x13L): basicreg.firstname
        flag 19 (0x14L): basicreg.idtype
        flag 20 (0x15L): basicreg.postofficebox
        flag 21 (0x16L): basicreg.nationality
        flag 22 (0x17L): resaddr.latitude
        flag 23 (0x18L): basicreg.age
        flag 24 (0x19L): basicreg.telephone
        flag 25 (0x1aL): resaddr
        flag 26 (0x1bL): basicreg
        flag 27 (0x1cL): bio
        flag 28 (0x1dL): null
    flag mapping end*/
    //end
}