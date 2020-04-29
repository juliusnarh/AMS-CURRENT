package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentFarmInfoBindingImpl extends FragmentFarmInfoBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.region_layout, 18);
        sViewsWithIds.put(R.id.ownership_layout, 19);
        sViewsWithIds.put(R.id.community_layout, 20);
        sViewsWithIds.put(R.id.estabyear_layout, 21);
        sViewsWithIds.put(R.id.landarea_layout, 22);
        sViewsWithIds.put(R.id.cultarea_layout, 23);
        sViewsWithIds.put(R.id.shadetreeno_layout, 24);
        sViewsWithIds.put(R.id.district_layout, 25);
        sViewsWithIds.put(R.id.cocoatype_layout, 26);
        sViewsWithIds.put(R.id.materialsource_layout, 27);
        sViewsWithIds.put(R.id.materialothersource_layout, 28);
        sViewsWithIds.put(R.id.laborsource_layout, 29);
        sViewsWithIds.put(R.id.provideorg_layout, 30);
        sViewsWithIds.put(R.id.privorg_layout, 31);
        sViewsWithIds.put(R.id.agricactive_layout, 32);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener agricactiveandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.agroactivity.get()
            //         is farmreg.agroactivity.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(agricactive);
            // localize variables for thread safety
            // farmreg.agroactivity != null
            boolean farmregAgroactivityJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg.agroactivity
            androidx.databinding.ObservableField<java.lang.String> farmregAgroactivity = null;
            // farmreg.agroactivity.get()
            java.lang.String farmregAgroactivityGet = null;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregAgroactivity = farmreg.agroactivity;

                farmregAgroactivityJavaLangObjectNull = (farmregAgroactivity) != (null);
                if (farmregAgroactivityJavaLangObjectNull) {




                    farmregAgroactivity.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener cocoatypeandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.typeoffarm.get()
            //         is farmreg.typeoffarm.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(cocoatype);
            // localize variables for thread safety
            // farmreg.typeoffarm.get()
            java.lang.String farmregTypeoffarmGet = null;
            // farmreg.typeoffarm
            androidx.databinding.ObservableField<java.lang.String> farmregTypeoffarm = null;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg.typeoffarm != null
            boolean farmregTypeoffarmJavaLangObjectNull = false;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregTypeoffarm = farmreg.typeoffarm;

                farmregTypeoffarmJavaLangObjectNull = (farmregTypeoffarm) != (null);
                if (farmregTypeoffarmJavaLangObjectNull) {




                    farmregTypeoffarm.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener cultareaandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.cultarea.get()
            //         is farmreg.cultarea.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(cultarea);
            // localize variables for thread safety
            // farmreg.cultarea
            androidx.databinding.ObservableField<java.lang.String> farmregCultarea = null;
            // farmreg.cultarea.get()
            java.lang.String farmregCultareaGet = null;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;
            // farmreg.cultarea != null
            boolean farmregCultareaJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregCultarea = farmreg.cultarea;

                farmregCultareaJavaLangObjectNull = (farmregCultarea) != (null);
                if (farmregCultareaJavaLangObjectNull) {




                    farmregCultarea.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener districtandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.district.get()
            //         is farmreg.district.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(district);
            // localize variables for thread safety
            // farmreg.district != null
            boolean farmregDistrictJavaLangObjectNull = false;
            // farmreg.district.get()
            java.lang.String farmregDistrictGet = null;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg.district
            androidx.databinding.ObservableField<java.lang.String> farmregDistrict = null;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregDistrict = farmreg.district;

                farmregDistrictJavaLangObjectNull = (farmregDistrict) != (null);
                if (farmregDistrictJavaLangObjectNull) {




                    farmregDistrict.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener extentoinserviceandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.extension.get()
            //         is farmreg.extension.set((java.lang.Boolean) callbackArg_0)
            boolean callbackArg_0 = extentoinservice.isChecked();
            // localize variables for thread safety
            // farmreg.extension
            androidx.databinding.ObservableField<java.lang.Boolean> farmregExtension = null;
            // farmreg.extension.get()
            java.lang.Boolean farmregExtensionGet = null;
            // farmreg.extension != null
            boolean farmregExtensionJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregExtension = farmreg.extension;

                farmregExtensionJavaLangObjectNull = (farmregExtension) != (null);
                if (farmregExtensionJavaLangObjectNull) {




                    farmregExtension.set(((java.lang.Boolean) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener laborsourceandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.laboursource.get()
            //         is farmreg.laboursource.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(laborsource);
            // localize variables for thread safety
            // farmreg.laboursource
            androidx.databinding.ObservableField<java.lang.String> farmregLaboursource = null;
            // farmreg.laboursource != null
            boolean farmregLaboursourceJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg.laboursource.get()
            java.lang.String farmregLaboursourceGet = null;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregLaboursource = farmreg.laboursource;

                farmregLaboursourceJavaLangObjectNull = (farmregLaboursource) != (null);
                if (farmregLaboursourceJavaLangObjectNull) {




                    farmregLaboursource.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener landareaandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.landarea.get()
            //         is farmreg.landarea.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(landarea);
            // localize variables for thread safety
            // farmreg.landarea.get()
            java.lang.String farmregLandareaGet = null;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;
            // farmreg.landarea != null
            boolean farmregLandareaJavaLangObjectNull = false;
            // farmreg.landarea
            androidx.databinding.ObservableField<java.lang.String> farmregLandarea = null;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregLandarea = farmreg.landarea;

                farmregLandareaJavaLangObjectNull = (farmregLandarea) != (null);
                if (farmregLandareaJavaLangObjectNull) {




                    farmregLandarea.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener materialothersourceandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.otherplantmatsrc.get()
            //         is farmreg.otherplantmatsrc.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(materialothersource);
            // localize variables for thread safety
            // farmreg.otherplantmatsrc != null
            boolean farmregOtherplantmatsrcJavaLangObjectNull = false;
            // farmreg.otherplantmatsrc.get()
            java.lang.String farmregOtherplantmatsrcGet = null;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg.otherplantmatsrc
            androidx.databinding.ObservableField<java.lang.String> farmregOtherplantmatsrc = null;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregOtherplantmatsrc = farmreg.otherplantmatsrc;

                farmregOtherplantmatsrcJavaLangObjectNull = (farmregOtherplantmatsrc) != (null);
                if (farmregOtherplantmatsrcJavaLangObjectNull) {




                    farmregOtherplantmatsrc.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener materialsourceandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.plantmaterialsrc.get()
            //         is farmreg.plantmaterialsrc.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(materialsource);
            // localize variables for thread safety
            // farmreg.plantmaterialsrc
            androidx.databinding.ObservableField<java.lang.String> farmregPlantmaterialsrc = null;
            // farmreg.plantmaterialsrc.get()
            java.lang.String farmregPlantmaterialsrcGet = null;
            // farmreg.plantmaterialsrc != null
            boolean farmregPlantmaterialsrcJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregPlantmaterialsrc = farmreg.plantmaterialsrc;

                farmregPlantmaterialsrcJavaLangObjectNull = (farmregPlantmaterialsrc) != (null);
                if (farmregPlantmaterialsrcJavaLangObjectNull) {




                    farmregPlantmaterialsrc.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.community.get()
            //         is farmreg.community.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // farmreg.community != null
            boolean farmregCommunityJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg.community
            androidx.databinding.ObservableField<java.lang.String> farmregCommunity = null;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;
            // farmreg.community.get()
            java.lang.String farmregCommunityGet = null;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregCommunity = farmreg.community;

                farmregCommunityJavaLangObjectNull = (farmregCommunity) != (null);
                if (farmregCommunityJavaLangObjectNull) {




                    farmregCommunity.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener ownershipandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.sourceofownership.get()
            //         is farmreg.sourceofownership.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(ownership);
            // localize variables for thread safety
            // farmreg.sourceofownership.get()
            java.lang.String farmregSourceofownershipGet = null;
            // farmreg.sourceofownership != null
            boolean farmregSourceofownershipJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;
            // farmreg.sourceofownership
            androidx.databinding.ObservableField<java.lang.String> farmregSourceofownership = null;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregSourceofownership = farmreg.sourceofownership;

                farmregSourceofownershipJavaLangObjectNull = (farmregSourceofownership) != (null);
                if (farmregSourceofownershipJavaLangObjectNull) {




                    farmregSourceofownership.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener privorgandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.privateextentionorg.get()
            //         is farmreg.privateextentionorg.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(privorg);
            // localize variables for thread safety
            // farmreg.privateextentionorg
            androidx.databinding.ObservableField<java.lang.String> farmregPrivateextentionorg = null;
            // farmreg.privateextentionorg.get()
            java.lang.String farmregPrivateextentionorgGet = null;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;
            // farmreg.privateextentionorg != null
            boolean farmregPrivateextentionorgJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregPrivateextentionorg = farmreg.privateextentionorg;

                farmregPrivateextentionorgJavaLangObjectNull = (farmregPrivateextentionorg) != (null);
                if (farmregPrivateextentionorgJavaLangObjectNull) {




                    farmregPrivateextentionorg.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener provideorgandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.extensionorg.get()
            //         is farmreg.extensionorg.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(provideorg);
            // localize variables for thread safety
            // farmreg.extensionorg.get()
            java.lang.String farmregExtensionorgGet = null;
            // farmreg.extensionorg != null
            boolean farmregExtensionorgJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg.extensionorg
            androidx.databinding.ObservableField<java.lang.String> farmregExtensionorg = null;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregExtensionorg = farmreg.extensionorg;

                farmregExtensionorgJavaLangObjectNull = (farmregExtensionorg) != (null);
                if (farmregExtensionorgJavaLangObjectNull) {




                    farmregExtensionorg.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener shadetreenoandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.shadetreeno.get()
            //         is farmreg.shadetreeno.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(shadetreeno);
            // localize variables for thread safety
            // farmreg.shadetreeno
            androidx.databinding.ObservableField<java.lang.String> farmregShadetreeno = null;
            // farmreg.shadetreeno.get()
            java.lang.String farmregShadetreenoGet = null;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;
            // farmreg.shadetreeno != null
            boolean farmregShadetreenoJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregShadetreeno = farmreg.shadetreeno;

                farmregShadetreenoJavaLangObjectNull = (farmregShadetreeno) != (null);
                if (farmregShadetreenoJavaLangObjectNull) {




                    farmregShadetreeno.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener swagroactiveandroidCheckedAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.boolagroactivity.get()
            //         is farmreg.boolagroactivity.set((java.lang.Boolean) callbackArg_0)
            boolean callbackArg_0 = swagroactive.isChecked();
            // localize variables for thread safety
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg.boolagroactivity
            androidx.databinding.ObservableField<java.lang.Boolean> farmregBoolagroactivity = null;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;
            // farmreg.boolagroactivity.get()
            java.lang.Boolean farmregBoolagroactivityGet = null;
            // farmreg.boolagroactivity != null
            boolean farmregBoolagroactivityJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregBoolagroactivity = farmreg.boolagroactivity;

                farmregBoolagroactivityJavaLangObjectNull = (farmregBoolagroactivity) != (null);
                if (farmregBoolagroactivityJavaLangObjectNull) {




                    farmregBoolagroactivity.set(((java.lang.Boolean) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener txtestabyearandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.establishedyear.get()
            //         is farmreg.establishedyear.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(txtestabyear);
            // localize variables for thread safety
            // farmreg.establishedyear.get()
            java.lang.String farmregEstablishedyearGet = null;
            // farmreg.establishedyear
            androidx.databinding.ObservableField<java.lang.String> farmregEstablishedyear = null;
            // farmreg.establishedyear != null
            boolean farmregEstablishedyearJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregEstablishedyear = farmreg.establishedyear;

                farmregEstablishedyearJavaLangObjectNull = (farmregEstablishedyear) != (null);
                if (farmregEstablishedyearJavaLangObjectNull) {




                    farmregEstablishedyear.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener txtregionandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.region.get()
            //         is farmreg.region.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(txtregion);
            // localize variables for thread safety
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg.region
            androidx.databinding.ObservableField<java.lang.String> farmregRegion = null;
            // farmreg.region.get()
            java.lang.String farmregRegionGet = null;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;
            // farmreg.region != null
            boolean farmregRegionJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregRegion = farmreg.region;

                farmregRegionJavaLangObjectNull = (farmregRegion) != (null);
                if (farmregRegionJavaLangObjectNull) {




                    farmregRegion.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentFarmInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 33, sIncludes, sViewsWithIds));
    }
    private FragmentFarmInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 17
            , (com.google.android.material.textfield.TextInputEditText) bindings[17]
            , (com.google.android.material.textfield.TextInputLayout) bindings[32]
            , (com.google.android.material.textfield.TextInputEditText) bindings[9]
            , (com.google.android.material.textfield.TextInputLayout) bindings[26]
            , (com.google.android.material.textfield.TextInputLayout) bindings[20]
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (com.google.android.material.textfield.TextInputLayout) bindings[23]
            , (com.google.android.material.textfield.TextInputEditText) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[25]
            , (com.google.android.material.textfield.TextInputLayout) bindings[21]
            , (android.widget.Switch) bindings[13]
            , (com.google.android.material.textfield.TextInputEditText) bindings[12]
            , (com.google.android.material.textfield.TextInputLayout) bindings[29]
            , (com.google.android.material.textfield.TextInputEditText) bindings[5]
            , (com.google.android.material.textfield.TextInputLayout) bindings[22]
            , (com.google.android.material.textfield.TextInputEditText) bindings[11]
            , (com.google.android.material.textfield.TextInputLayout) bindings[28]
            , (com.google.android.material.textfield.TextInputEditText) bindings[10]
            , (com.google.android.material.textfield.TextInputLayout) bindings[27]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[19]
            , (com.google.android.material.textfield.TextInputEditText) bindings[15]
            , (com.google.android.material.textfield.TextInputLayout) bindings[31]
            , (com.google.android.material.textfield.TextInputEditText) bindings[14]
            , (com.google.android.material.textfield.TextInputLayout) bindings[30]
            , (com.google.android.material.textfield.TextInputLayout) bindings[18]
            , (com.google.android.material.textfield.TextInputEditText) bindings[7]
            , (com.google.android.material.textfield.TextInputLayout) bindings[24]
            , (android.widget.Switch) bindings[16]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            );
        this.agricactive.setTag(null);
        this.cocoatype.setTag(null);
        this.cultarea.setTag(null);
        this.district.setTag(null);
        this.extentoinservice.setTag(null);
        this.laborsource.setTag(null);
        this.landarea.setTag(null);
        this.materialothersource.setTag(null);
        this.materialsource.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (com.google.android.material.textfield.TextInputEditText) bindings[3];
        this.mboundView3.setTag(null);
        this.ownership.setTag(null);
        this.privorg.setTag(null);
        this.provideorg.setTag(null);
        this.shadetreeno.setTag(null);
        this.swagroactive.setTag(null);
        this.txtestabyear.setTag(null);
        this.txtregion.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40000L;
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
        if (BR.farmreg == variableId) {
            setFarmreg((com.telpo.usb.finger.pojo.FarmRegistrationPojo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFarmreg(@Nullable com.telpo.usb.finger.pojo.FarmRegistrationPojo Farmreg) {
        this.mFarmreg = Farmreg;
        synchronized(this) {
            mDirtyFlags |= 0x20000L;
        }
        notifyPropertyChanged(BR.farmreg);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeFarmregTypeoffarm((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeFarmregLandarea((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeFarmregPrivateextentionorg((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeFarmregPlantmaterialsrc((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeFarmregEstablishedyear((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeFarmregSourceofownership((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeFarmregExtension((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 7 :
                return onChangeFarmregOtherplantmatsrc((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 8 :
                return onChangeFarmregExtensionorg((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 9 :
                return onChangeFarmregLaboursource((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 10 :
                return onChangeFarmregCommunity((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 11 :
                return onChangeFarmregBoolagroactivity((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 12 :
                return onChangeFarmregRegion((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 13 :
                return onChangeFarmregDistrict((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 14 :
                return onChangeFarmregAgroactivity((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 15 :
                return onChangeFarmregShadetreeno((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 16 :
                return onChangeFarmregCultarea((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeFarmregTypeoffarm(androidx.databinding.ObservableField<java.lang.String> FarmregTypeoffarm, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregLandarea(androidx.databinding.ObservableField<java.lang.String> FarmregLandarea, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregPrivateextentionorg(androidx.databinding.ObservableField<java.lang.String> FarmregPrivateextentionorg, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregPlantmaterialsrc(androidx.databinding.ObservableField<java.lang.String> FarmregPlantmaterialsrc, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregEstablishedyear(androidx.databinding.ObservableField<java.lang.String> FarmregEstablishedyear, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregSourceofownership(androidx.databinding.ObservableField<java.lang.String> FarmregSourceofownership, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregExtension(androidx.databinding.ObservableField<java.lang.Boolean> FarmregExtension, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregOtherplantmatsrc(androidx.databinding.ObservableField<java.lang.String> FarmregOtherplantmatsrc, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregExtensionorg(androidx.databinding.ObservableField<java.lang.String> FarmregExtensionorg, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregLaboursource(androidx.databinding.ObservableField<java.lang.String> FarmregLaboursource, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregCommunity(androidx.databinding.ObservableField<java.lang.String> FarmregCommunity, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x400L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregBoolagroactivity(androidx.databinding.ObservableField<java.lang.Boolean> FarmregBoolagroactivity, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x800L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregRegion(androidx.databinding.ObservableField<java.lang.String> FarmregRegion, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregDistrict(androidx.databinding.ObservableField<java.lang.String> FarmregDistrict, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregAgroactivity(androidx.databinding.ObservableField<java.lang.String> FarmregAgroactivity, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregShadetreeno(androidx.databinding.ObservableField<java.lang.String> FarmregShadetreeno, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregCultarea(androidx.databinding.ObservableField<java.lang.String> FarmregCultarea, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000L;
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
        boolean androidxDatabindingViewDataBindingSafeUnboxFarmregExtensionGet = false;
        androidx.databinding.ObservableField<java.lang.String> farmregTypeoffarm = null;
        androidx.databinding.ObservableField<java.lang.String> farmregLandarea = null;
        java.lang.String farmregPlantmaterialsrcGet = null;
        androidx.databinding.ObservableField<java.lang.String> farmregPrivateextentionorg = null;
        androidx.databinding.ObservableField<java.lang.String> farmregPlantmaterialsrc = null;
        androidx.databinding.ObservableField<java.lang.String> farmregEstablishedyear = null;
        java.lang.String farmregRegionGet = null;
        java.lang.String farmregSourceofownershipGet = null;
        androidx.databinding.ObservableField<java.lang.String> farmregSourceofownership = null;
        java.lang.String farmregLandareaGet = null;
        androidx.databinding.ObservableField<java.lang.Boolean> farmregExtension = null;
        java.lang.String farmregPrivateextentionorgGet = null;
        androidx.databinding.ObservableField<java.lang.String> farmregOtherplantmatsrc = null;
        java.lang.String farmregExtensionorgGet = null;
        java.lang.String farmregLaboursourceGet = null;
        java.lang.String farmregShadetreenoGet = null;
        java.lang.String farmregOtherplantmatsrcGet = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxFarmregBoolagroactivityGet = false;
        androidx.databinding.ObservableField<java.lang.String> farmregExtensionorg = null;
        androidx.databinding.ObservableField<java.lang.String> farmregLaboursource = null;
        com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
        androidx.databinding.ObservableField<java.lang.String> farmregCommunity = null;
        androidx.databinding.ObservableField<java.lang.Boolean> farmregBoolagroactivity = null;
        boolean farmregExtensionorgGetEqualsJavaLangStringPrivate = false;
        androidx.databinding.ObservableField<java.lang.String> farmregRegion = null;
        androidx.databinding.ObservableField<java.lang.String> farmregDistrict = null;
        java.lang.String farmregDistrictGet = null;
        boolean farmregExtensionorgGetEqualsJavaLangStringPrivateBooleanTrueBooleanFalse = false;
        androidx.databinding.ObservableField<java.lang.String> farmregAgroactivity = null;
        java.lang.String farmregEstablishedyearGet = null;
        androidx.databinding.ObservableField<java.lang.String> farmregShadetreeno = null;
        java.lang.String farmregCommunityGet = null;
        java.lang.String farmregTypeoffarmGet = null;
        java.lang.String farmregAgroactivityGet = null;
        androidx.databinding.ObservableField<java.lang.String> farmregCultarea = null;
        java.lang.String farmregCultareaGet = null;
        java.lang.Boolean farmregExtensionGet = null;
        java.lang.Boolean farmregBoolagroactivityGet = null;

        if ((dirtyFlags & 0x7ffffL) != 0) {


            if ((dirtyFlags & 0x60001L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.typeoffarm
                        farmregTypeoffarm = farmreg.typeoffarm;
                    }
                    updateRegistration(0, farmregTypeoffarm);


                    if (farmregTypeoffarm != null) {
                        // read farmreg.typeoffarm.get()
                        farmregTypeoffarmGet = farmregTypeoffarm.get();
                    }
            }
            if ((dirtyFlags & 0x60002L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.landarea
                        farmregLandarea = farmreg.landarea;
                    }
                    updateRegistration(1, farmregLandarea);


                    if (farmregLandarea != null) {
                        // read farmreg.landarea.get()
                        farmregLandareaGet = farmregLandarea.get();
                    }
            }
            if ((dirtyFlags & 0x60004L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.privateextentionorg
                        farmregPrivateextentionorg = farmreg.privateextentionorg;
                    }
                    updateRegistration(2, farmregPrivateextentionorg);


                    if (farmregPrivateextentionorg != null) {
                        // read farmreg.privateextentionorg.get()
                        farmregPrivateextentionorgGet = farmregPrivateextentionorg.get();
                    }
            }
            if ((dirtyFlags & 0x60008L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.plantmaterialsrc
                        farmregPlantmaterialsrc = farmreg.plantmaterialsrc;
                    }
                    updateRegistration(3, farmregPlantmaterialsrc);


                    if (farmregPlantmaterialsrc != null) {
                        // read farmreg.plantmaterialsrc.get()
                        farmregPlantmaterialsrcGet = farmregPlantmaterialsrc.get();
                    }
            }
            if ((dirtyFlags & 0x60010L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.establishedyear
                        farmregEstablishedyear = farmreg.establishedyear;
                    }
                    updateRegistration(4, farmregEstablishedyear);


                    if (farmregEstablishedyear != null) {
                        // read farmreg.establishedyear.get()
                        farmregEstablishedyearGet = farmregEstablishedyear.get();
                    }
            }
            if ((dirtyFlags & 0x60020L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.sourceofownership
                        farmregSourceofownership = farmreg.sourceofownership;
                    }
                    updateRegistration(5, farmregSourceofownership);


                    if (farmregSourceofownership != null) {
                        // read farmreg.sourceofownership.get()
                        farmregSourceofownershipGet = farmregSourceofownership.get();
                    }
            }
            if ((dirtyFlags & 0x60040L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.extension
                        farmregExtension = farmreg.extension;
                    }
                    updateRegistration(6, farmregExtension);


                    if (farmregExtension != null) {
                        // read farmreg.extension.get()
                        farmregExtensionGet = farmregExtension.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(farmreg.extension.get())
                    androidxDatabindingViewDataBindingSafeUnboxFarmregExtensionGet = androidx.databinding.ViewDataBinding.safeUnbox(farmregExtensionGet);
            }
            if ((dirtyFlags & 0x60080L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.otherplantmatsrc
                        farmregOtherplantmatsrc = farmreg.otherplantmatsrc;
                    }
                    updateRegistration(7, farmregOtherplantmatsrc);


                    if (farmregOtherplantmatsrc != null) {
                        // read farmreg.otherplantmatsrc.get()
                        farmregOtherplantmatsrcGet = farmregOtherplantmatsrc.get();
                    }
            }
            if ((dirtyFlags & 0x60100L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.extensionorg
                        farmregExtensionorg = farmreg.extensionorg;
                    }
                    updateRegistration(8, farmregExtensionorg);


                    if (farmregExtensionorg != null) {
                        // read farmreg.extensionorg.get()
                        farmregExtensionorgGet = farmregExtensionorg.get();
                    }


                    if (farmregExtensionorgGet != null) {
                        // read farmreg.extensionorg.get().equals("Private")
                        farmregExtensionorgGetEqualsJavaLangStringPrivate = farmregExtensionorgGet.equals("Private");
                    }
                if((dirtyFlags & 0x60100L) != 0) {
                    if(farmregExtensionorgGetEqualsJavaLangStringPrivate) {
                            dirtyFlags |= 0x100000L;
                    }
                    else {
                            dirtyFlags |= 0x80000L;
                    }
                }


                    // read farmreg.extensionorg.get().equals("Private") ? true : false
                    farmregExtensionorgGetEqualsJavaLangStringPrivateBooleanTrueBooleanFalse = ((farmregExtensionorgGetEqualsJavaLangStringPrivate) ? (true) : (false));
            }
            if ((dirtyFlags & 0x60200L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.laboursource
                        farmregLaboursource = farmreg.laboursource;
                    }
                    updateRegistration(9, farmregLaboursource);


                    if (farmregLaboursource != null) {
                        // read farmreg.laboursource.get()
                        farmregLaboursourceGet = farmregLaboursource.get();
                    }
            }
            if ((dirtyFlags & 0x60400L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.community
                        farmregCommunity = farmreg.community;
                    }
                    updateRegistration(10, farmregCommunity);


                    if (farmregCommunity != null) {
                        // read farmreg.community.get()
                        farmregCommunityGet = farmregCommunity.get();
                    }
            }
            if ((dirtyFlags & 0x60800L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.boolagroactivity
                        farmregBoolagroactivity = farmreg.boolagroactivity;
                    }
                    updateRegistration(11, farmregBoolagroactivity);


                    if (farmregBoolagroactivity != null) {
                        // read farmreg.boolagroactivity.get()
                        farmregBoolagroactivityGet = farmregBoolagroactivity.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(farmreg.boolagroactivity.get())
                    androidxDatabindingViewDataBindingSafeUnboxFarmregBoolagroactivityGet = androidx.databinding.ViewDataBinding.safeUnbox(farmregBoolagroactivityGet);
            }
            if ((dirtyFlags & 0x61000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.region
                        farmregRegion = farmreg.region;
                    }
                    updateRegistration(12, farmregRegion);


                    if (farmregRegion != null) {
                        // read farmreg.region.get()
                        farmregRegionGet = farmregRegion.get();
                    }
            }
            if ((dirtyFlags & 0x62000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.district
                        farmregDistrict = farmreg.district;
                    }
                    updateRegistration(13, farmregDistrict);


                    if (farmregDistrict != null) {
                        // read farmreg.district.get()
                        farmregDistrictGet = farmregDistrict.get();
                    }
            }
            if ((dirtyFlags & 0x64000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.agroactivity
                        farmregAgroactivity = farmreg.agroactivity;
                    }
                    updateRegistration(14, farmregAgroactivity);


                    if (farmregAgroactivity != null) {
                        // read farmreg.agroactivity.get()
                        farmregAgroactivityGet = farmregAgroactivity.get();
                    }
            }
            if ((dirtyFlags & 0x68000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.shadetreeno
                        farmregShadetreeno = farmreg.shadetreeno;
                    }
                    updateRegistration(15, farmregShadetreeno);


                    if (farmregShadetreeno != null) {
                        // read farmreg.shadetreeno.get()
                        farmregShadetreenoGet = farmregShadetreeno.get();
                    }
            }
            if ((dirtyFlags & 0x70000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.cultarea
                        farmregCultarea = farmreg.cultarea;
                    }
                    updateRegistration(16, farmregCultarea);


                    if (farmregCultarea != null) {
                        // read farmreg.cultarea.get()
                        farmregCultareaGet = farmregCultarea.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x60800L) != 0) {
            // api target 1

            this.agricactive.setEnabled(androidxDatabindingViewDataBindingSafeUnboxFarmregBoolagroactivityGet);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.swagroactive, androidxDatabindingViewDataBindingSafeUnboxFarmregBoolagroactivityGet);
        }
        if ((dirtyFlags & 0x64000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.agricactive, farmregAgroactivityGet);
        }
        if ((dirtyFlags & 0x40000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.agricactive, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, agricactiveandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.cocoatype, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, cocoatypeandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.cultarea, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, cultareaandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.district, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, districtandroidTextAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.extentoinservice, (android.widget.CompoundButton.OnCheckedChangeListener)null, extentoinserviceandroidCheckedAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.laborsource, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, laborsourceandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.landarea, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, landareaandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.materialothersource, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, materialothersourceandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.materialsource, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, materialsourceandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.ownership, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, ownershipandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.privorg, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, privorgandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.provideorg, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, provideorgandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.shadetreeno, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, shadetreenoandroidTextAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.swagroactive, (android.widget.CompoundButton.OnCheckedChangeListener)null, swagroactiveandroidCheckedAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.txtestabyear, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, txtestabyearandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.txtregion, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, txtregionandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x60001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cocoatype, farmregTypeoffarmGet);
        }
        if ((dirtyFlags & 0x70000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cultarea, farmregCultareaGet);
        }
        if ((dirtyFlags & 0x62000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.district, farmregDistrictGet);
        }
        if ((dirtyFlags & 0x60040L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.extentoinservice, androidxDatabindingViewDataBindingSafeUnboxFarmregExtensionGet);
            this.provideorg.setEnabled(androidxDatabindingViewDataBindingSafeUnboxFarmregExtensionGet);
        }
        if ((dirtyFlags & 0x60200L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.laborsource, farmregLaboursourceGet);
        }
        if ((dirtyFlags & 0x60002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.landarea, farmregLandareaGet);
        }
        if ((dirtyFlags & 0x60080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.materialothersource, farmregOtherplantmatsrcGet);
        }
        if ((dirtyFlags & 0x60008L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.materialsource, farmregPlantmaterialsrcGet);
        }
        if ((dirtyFlags & 0x60400L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, farmregCommunityGet);
        }
        if ((dirtyFlags & 0x60020L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.ownership, farmregSourceofownershipGet);
        }
        if ((dirtyFlags & 0x60100L) != 0) {
            // api target 1

            this.privorg.setEnabled(farmregExtensionorgGetEqualsJavaLangStringPrivateBooleanTrueBooleanFalse);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.provideorg, farmregExtensionorgGet);
        }
        if ((dirtyFlags & 0x60004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.privorg, farmregPrivateextentionorgGet);
        }
        if ((dirtyFlags & 0x68000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.shadetreeno, farmregShadetreenoGet);
        }
        if ((dirtyFlags & 0x60010L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtestabyear, farmregEstablishedyearGet);
        }
        if ((dirtyFlags & 0x61000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtregion, farmregRegionGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): farmreg.typeoffarm
        flag 1 (0x2L): farmreg.landarea
        flag 2 (0x3L): farmreg.privateextentionorg
        flag 3 (0x4L): farmreg.plantmaterialsrc
        flag 4 (0x5L): farmreg.establishedyear
        flag 5 (0x6L): farmreg.sourceofownership
        flag 6 (0x7L): farmreg.extension
        flag 7 (0x8L): farmreg.otherplantmatsrc
        flag 8 (0x9L): farmreg.extensionorg
        flag 9 (0xaL): farmreg.laboursource
        flag 10 (0xbL): farmreg.community
        flag 11 (0xcL): farmreg.boolagroactivity
        flag 12 (0xdL): farmreg.region
        flag 13 (0xeL): farmreg.district
        flag 14 (0xfL): farmreg.agroactivity
        flag 15 (0x10L): farmreg.shadetreeno
        flag 16 (0x11L): farmreg.cultarea
        flag 17 (0x12L): farmreg
        flag 18 (0x13L): null
        flag 19 (0x14L): farmreg.extensionorg.get().equals("Private") ? true : false
        flag 20 (0x15L): farmreg.extensionorg.get().equals("Private") ? true : false
    flag mapping end*/
    //end
}