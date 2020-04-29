package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentAddAnotherFarmBindingImpl extends FragmentAddAnotherFarmBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.region_layout, 23);
        sViewsWithIds.put(R.id.ownership_layout, 24);
        sViewsWithIds.put(R.id.community_layout, 25);
        sViewsWithIds.put(R.id.estabyear_layout, 26);
        sViewsWithIds.put(R.id.landarea_layout, 27);
        sViewsWithIds.put(R.id.cultarea_layout, 28);
        sViewsWithIds.put(R.id.shadetreeno_layout, 29);
        sViewsWithIds.put(R.id.district_layout, 30);
        sViewsWithIds.put(R.id.cocoatype_layout, 31);
        sViewsWithIds.put(R.id.crop_variety_layout, 32);
        sViewsWithIds.put(R.id.fertused_layout, 33);
        sViewsWithIds.put(R.id.farmyield_layout, 34);
        sViewsWithIds.put(R.id.cropprotection_layout, 35);
        sViewsWithIds.put(R.id.chemicalused_layout, 36);
        sViewsWithIds.put(R.id.materialsource_layout, 37);
        sViewsWithIds.put(R.id.materialothersource_layout, 38);
        sViewsWithIds.put(R.id.laborsource_layout, 39);
        sViewsWithIds.put(R.id.provideorg_layout, 40);
        sViewsWithIds.put(R.id.privorg_layout, 41);
        sViewsWithIds.put(R.id.agricactive_layout, 42);
        sViewsWithIds.put(R.id.btncancel, 43);
        sViewsWithIds.put(R.id.btnsave, 44);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
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
    private androidx.databinding.InverseBindingListener chemicalusedandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.chemicalused.get()
            //         is farmreg.chemicalused.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(chemicalused);
            // localize variables for thread safety
            // farmreg.chemicalused.get()
            java.lang.String farmregChemicalusedGet = null;
            // farmreg.chemicalused
            androidx.databinding.ObservableField<java.lang.String> farmregChemicalused = null;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;
            // farmreg.chemicalused != null
            boolean farmregChemicalusedJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregChemicalused = farmreg.chemicalused;

                farmregChemicalusedJavaLangObjectNull = (farmregChemicalused) != (null);
                if (farmregChemicalusedJavaLangObjectNull) {




                    farmregChemicalused.set(((java.lang.String) (callbackArg_0)));
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
    private androidx.databinding.InverseBindingListener cropVarietyandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.cropvariety.get()
            //         is farmreg.cropvariety.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(cropVariety);
            // localize variables for thread safety
            // farmreg.cropvariety
            androidx.databinding.ObservableField<java.lang.String> farmregCropvariety = null;
            // farmreg.cropvariety != null
            boolean farmregCropvarietyJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;
            // farmreg.cropvariety.get()
            java.lang.String farmregCropvarietyGet = null;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregCropvariety = farmreg.cropvariety;

                farmregCropvarietyJavaLangObjectNull = (farmregCropvariety) != (null);
                if (farmregCropvarietyJavaLangObjectNull) {




                    farmregCropvariety.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener cropprotectionandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.cropprotection.get()
            //         is farmreg.cropprotection.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(cropprotection);
            // localize variables for thread safety
            // farmreg.cropprotection.get()
            java.lang.String farmregCropprotectionGet = null;
            // farmreg.cropprotection != null
            boolean farmregCropprotectionJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg.cropprotection
            androidx.databinding.ObservableField<java.lang.String> farmregCropprotection = null;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregCropprotection = farmreg.cropprotection;

                farmregCropprotectionJavaLangObjectNull = (farmregCropprotection) != (null);
                if (farmregCropprotectionJavaLangObjectNull) {




                    farmregCropprotection.set(((java.lang.String) (callbackArg_0)));
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
    private androidx.databinding.InverseBindingListener farmyieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.farmyield.get()
            //         is farmreg.farmyield.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(farmyield);
            // localize variables for thread safety
            // farmreg.farmyield != null
            boolean farmregFarmyieldJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;
            // farmreg.farmyield.get()
            java.lang.String farmregFarmyieldGet = null;
            // farmreg.farmyield
            androidx.databinding.ObservableField<java.lang.String> farmregFarmyield = null;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregFarmyield = farmreg.farmyield;

                farmregFarmyieldJavaLangObjectNull = (farmregFarmyield) != (null);
                if (farmregFarmyieldJavaLangObjectNull) {




                    farmregFarmyield.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener fertusedandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of farmreg.fertilizerused.get()
            //         is farmreg.fertilizerused.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(fertused);
            // localize variables for thread safety
            // farmreg.fertilizerused
            androidx.databinding.ObservableField<java.lang.String> farmregFertilizerused = null;
            // farmreg.fertilizerused.get()
            java.lang.String farmregFertilizerusedGet = null;
            // farmreg.fertilizerused != null
            boolean farmregFertilizerusedJavaLangObjectNull = false;
            // farmreg
            com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
            // farmreg != null
            boolean farmregJavaLangObjectNull = false;



            farmregJavaLangObjectNull = (farmreg) != (null);
            if (farmregJavaLangObjectNull) {


                farmregFertilizerused = farmreg.fertilizerused;

                farmregFertilizerusedJavaLangObjectNull = (farmregFertilizerused) != (null);
                if (farmregFertilizerusedJavaLangObjectNull) {




                    farmregFertilizerused.set(((java.lang.String) (callbackArg_0)));
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

    public FragmentAddAnotherFarmBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 45, sIncludes, sViewsWithIds));
    }
    private FragmentAddAnotherFarmBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 22
            , (com.google.android.material.textfield.TextInputEditText) bindings[22]
            , (com.google.android.material.textfield.TextInputLayout) bindings[42]
            , (android.widget.Button) bindings[43]
            , (android.widget.Button) bindings[44]
            , (com.google.android.material.textfield.TextInputEditText) bindings[14]
            , (com.google.android.material.textfield.TextInputLayout) bindings[36]
            , (com.google.android.material.textfield.TextInputEditText) bindings[9]
            , (com.google.android.material.textfield.TextInputLayout) bindings[31]
            , (com.google.android.material.textfield.TextInputLayout) bindings[25]
            , (com.google.android.material.textfield.TextInputEditText) bindings[10]
            , (com.google.android.material.textfield.TextInputLayout) bindings[32]
            , (com.google.android.material.textfield.TextInputEditText) bindings[13]
            , (com.google.android.material.textfield.TextInputLayout) bindings[35]
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (com.google.android.material.textfield.TextInputLayout) bindings[28]
            , (com.google.android.material.textfield.TextInputEditText) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[30]
            , (com.google.android.material.textfield.TextInputLayout) bindings[26]
            , (android.widget.Switch) bindings[18]
            , (com.google.android.material.textfield.TextInputEditText) bindings[12]
            , (com.google.android.material.textfield.TextInputLayout) bindings[34]
            , (com.google.android.material.textfield.TextInputEditText) bindings[11]
            , (com.google.android.material.textfield.TextInputLayout) bindings[33]
            , (com.google.android.material.textfield.TextInputEditText) bindings[17]
            , (com.google.android.material.textfield.TextInputLayout) bindings[39]
            , (com.google.android.material.textfield.TextInputEditText) bindings[5]
            , (com.google.android.material.textfield.TextInputLayout) bindings[27]
            , (com.google.android.material.textfield.TextInputEditText) bindings[16]
            , (com.google.android.material.textfield.TextInputLayout) bindings[38]
            , (com.google.android.material.textfield.TextInputEditText) bindings[15]
            , (com.google.android.material.textfield.TextInputLayout) bindings[37]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[24]
            , (com.google.android.material.textfield.TextInputEditText) bindings[20]
            , (com.google.android.material.textfield.TextInputLayout) bindings[41]
            , (com.google.android.material.textfield.TextInputEditText) bindings[19]
            , (com.google.android.material.textfield.TextInputLayout) bindings[40]
            , (com.google.android.material.textfield.TextInputLayout) bindings[23]
            , (com.google.android.material.textfield.TextInputEditText) bindings[7]
            , (com.google.android.material.textfield.TextInputLayout) bindings[29]
            , (android.widget.Switch) bindings[21]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            );
        this.agricactive.setTag(null);
        this.chemicalused.setTag(null);
        this.cocoatype.setTag(null);
        this.cropVariety.setTag(null);
        this.cropprotection.setTag(null);
        this.cultarea.setTag(null);
        this.district.setTag(null);
        this.extentoinservice.setTag(null);
        this.farmyield.setTag(null);
        this.fertused.setTag(null);
        this.laborsource.setTag(null);
        this.landarea.setTag(null);
        this.materialothersource.setTag(null);
        this.materialsource.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
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
                mDirtyFlags = 0x800000L;
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
            mDirtyFlags |= 0x400000L;
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
                return onChangeFarmregCropprotection((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeFarmregCropvariety((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeFarmregPlantmaterialsrc((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeFarmregEstablishedyear((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 7 :
                return onChangeFarmregSourceofownership((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 8 :
                return onChangeFarmregExtension((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 9 :
                return onChangeFarmregChemicalused((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 10 :
                return onChangeFarmregOtherplantmatsrc((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 11 :
                return onChangeFarmregFarmyield((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 12 :
                return onChangeFarmregExtensionorg((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 13 :
                return onChangeFarmregLaboursource((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 14 :
                return onChangeFarmregCommunity((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 15 :
                return onChangeFarmregBoolagroactivity((androidx.databinding.ObservableField<java.lang.Boolean>) object, fieldId);
            case 16 :
                return onChangeFarmregRegion((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 17 :
                return onChangeFarmregDistrict((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 18 :
                return onChangeFarmregFertilizerused((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 19 :
                return onChangeFarmregAgroactivity((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 20 :
                return onChangeFarmregShadetreeno((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 21 :
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
    private boolean onChangeFarmregCropprotection(androidx.databinding.ObservableField<java.lang.String> FarmregCropprotection, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregCropvariety(androidx.databinding.ObservableField<java.lang.String> FarmregCropvariety, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregPlantmaterialsrc(androidx.databinding.ObservableField<java.lang.String> FarmregPlantmaterialsrc, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregEstablishedyear(androidx.databinding.ObservableField<java.lang.String> FarmregEstablishedyear, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregSourceofownership(androidx.databinding.ObservableField<java.lang.String> FarmregSourceofownership, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregExtension(androidx.databinding.ObservableField<java.lang.Boolean> FarmregExtension, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregChemicalused(androidx.databinding.ObservableField<java.lang.String> FarmregChemicalused, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregOtherplantmatsrc(androidx.databinding.ObservableField<java.lang.String> FarmregOtherplantmatsrc, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x400L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregFarmyield(androidx.databinding.ObservableField<java.lang.String> FarmregFarmyield, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x800L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregExtensionorg(androidx.databinding.ObservableField<java.lang.String> FarmregExtensionorg, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregLaboursource(androidx.databinding.ObservableField<java.lang.String> FarmregLaboursource, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregCommunity(androidx.databinding.ObservableField<java.lang.String> FarmregCommunity, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregBoolagroactivity(androidx.databinding.ObservableField<java.lang.Boolean> FarmregBoolagroactivity, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregRegion(androidx.databinding.ObservableField<java.lang.String> FarmregRegion, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregDistrict(androidx.databinding.ObservableField<java.lang.String> FarmregDistrict, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregFertilizerused(androidx.databinding.ObservableField<java.lang.String> FarmregFertilizerused, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregAgroactivity(androidx.databinding.ObservableField<java.lang.String> FarmregAgroactivity, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregShadetreeno(androidx.databinding.ObservableField<java.lang.String> FarmregShadetreeno, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFarmregCultarea(androidx.databinding.ObservableField<java.lang.String> FarmregCultarea, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200000L;
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
        androidx.databinding.ObservableField<java.lang.String> farmregCropprotection = null;
        androidx.databinding.ObservableField<java.lang.String> farmregCropvariety = null;
        androidx.databinding.ObservableField<java.lang.String> farmregPlantmaterialsrc = null;
        androidx.databinding.ObservableField<java.lang.String> farmregEstablishedyear = null;
        java.lang.String farmregRegionGet = null;
        java.lang.String farmregSourceofownershipGet = null;
        androidx.databinding.ObservableField<java.lang.String> farmregSourceofownership = null;
        java.lang.String farmregLandareaGet = null;
        androidx.databinding.ObservableField<java.lang.Boolean> farmregExtension = null;
        java.lang.String farmregPrivateextentionorgGet = null;
        androidx.databinding.ObservableField<java.lang.String> farmregChemicalused = null;
        androidx.databinding.ObservableField<java.lang.String> farmregOtherplantmatsrc = null;
        java.lang.String farmregCropprotectionGet = null;
        java.lang.String farmregExtensionorgGet = null;
        java.lang.String farmregChemicalusedGet = null;
        androidx.databinding.ObservableField<java.lang.String> farmregFarmyield = null;
        java.lang.String farmregLaboursourceGet = null;
        java.lang.String farmregShadetreenoGet = null;
        java.lang.String farmregOtherplantmatsrcGet = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxFarmregBoolagroactivityGet = false;
        java.lang.String farmregCropvarietyGet = null;
        androidx.databinding.ObservableField<java.lang.String> farmregExtensionorg = null;
        androidx.databinding.ObservableField<java.lang.String> farmregLaboursource = null;
        com.telpo.usb.finger.pojo.FarmRegistrationPojo farmreg = mFarmreg;
        androidx.databinding.ObservableField<java.lang.String> farmregCommunity = null;
        androidx.databinding.ObservableField<java.lang.Boolean> farmregBoolagroactivity = null;
        boolean farmregExtensionorgGetEqualsJavaLangStringPrivate = false;
        java.lang.String farmregFertilizerusedGet = null;
        androidx.databinding.ObservableField<java.lang.String> farmregRegion = null;
        androidx.databinding.ObservableField<java.lang.String> farmregDistrict = null;
        androidx.databinding.ObservableField<java.lang.String> farmregFertilizerused = null;
        java.lang.String farmregDistrictGet = null;
        boolean farmregExtensionorgGetEqualsJavaLangStringPrivateBooleanTrueBooleanFalse = false;
        java.lang.String farmregFarmyieldGet = null;
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

        if ((dirtyFlags & 0xffffffL) != 0) {


            if ((dirtyFlags & 0xc00001L) != 0) {

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
            if ((dirtyFlags & 0xc00002L) != 0) {

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
            if ((dirtyFlags & 0xc00004L) != 0) {

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
            if ((dirtyFlags & 0xc00008L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.cropprotection
                        farmregCropprotection = farmreg.cropprotection;
                    }
                    updateRegistration(3, farmregCropprotection);


                    if (farmregCropprotection != null) {
                        // read farmreg.cropprotection.get()
                        farmregCropprotectionGet = farmregCropprotection.get();
                    }
            }
            if ((dirtyFlags & 0xc00010L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.cropvariety
                        farmregCropvariety = farmreg.cropvariety;
                    }
                    updateRegistration(4, farmregCropvariety);


                    if (farmregCropvariety != null) {
                        // read farmreg.cropvariety.get()
                        farmregCropvarietyGet = farmregCropvariety.get();
                    }
            }
            if ((dirtyFlags & 0xc00020L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.plantmaterialsrc
                        farmregPlantmaterialsrc = farmreg.plantmaterialsrc;
                    }
                    updateRegistration(5, farmregPlantmaterialsrc);


                    if (farmregPlantmaterialsrc != null) {
                        // read farmreg.plantmaterialsrc.get()
                        farmregPlantmaterialsrcGet = farmregPlantmaterialsrc.get();
                    }
            }
            if ((dirtyFlags & 0xc00040L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.establishedyear
                        farmregEstablishedyear = farmreg.establishedyear;
                    }
                    updateRegistration(6, farmregEstablishedyear);


                    if (farmregEstablishedyear != null) {
                        // read farmreg.establishedyear.get()
                        farmregEstablishedyearGet = farmregEstablishedyear.get();
                    }
            }
            if ((dirtyFlags & 0xc00080L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.sourceofownership
                        farmregSourceofownership = farmreg.sourceofownership;
                    }
                    updateRegistration(7, farmregSourceofownership);


                    if (farmregSourceofownership != null) {
                        // read farmreg.sourceofownership.get()
                        farmregSourceofownershipGet = farmregSourceofownership.get();
                    }
            }
            if ((dirtyFlags & 0xc00100L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.extension
                        farmregExtension = farmreg.extension;
                    }
                    updateRegistration(8, farmregExtension);


                    if (farmregExtension != null) {
                        // read farmreg.extension.get()
                        farmregExtensionGet = farmregExtension.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(farmreg.extension.get())
                    androidxDatabindingViewDataBindingSafeUnboxFarmregExtensionGet = androidx.databinding.ViewDataBinding.safeUnbox(farmregExtensionGet);
            }
            if ((dirtyFlags & 0xc00200L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.chemicalused
                        farmregChemicalused = farmreg.chemicalused;
                    }
                    updateRegistration(9, farmregChemicalused);


                    if (farmregChemicalused != null) {
                        // read farmreg.chemicalused.get()
                        farmregChemicalusedGet = farmregChemicalused.get();
                    }
            }
            if ((dirtyFlags & 0xc00400L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.otherplantmatsrc
                        farmregOtherplantmatsrc = farmreg.otherplantmatsrc;
                    }
                    updateRegistration(10, farmregOtherplantmatsrc);


                    if (farmregOtherplantmatsrc != null) {
                        // read farmreg.otherplantmatsrc.get()
                        farmregOtherplantmatsrcGet = farmregOtherplantmatsrc.get();
                    }
            }
            if ((dirtyFlags & 0xc00800L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.farmyield
                        farmregFarmyield = farmreg.farmyield;
                    }
                    updateRegistration(11, farmregFarmyield);


                    if (farmregFarmyield != null) {
                        // read farmreg.farmyield.get()
                        farmregFarmyieldGet = farmregFarmyield.get();
                    }
            }
            if ((dirtyFlags & 0xc01000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.extensionorg
                        farmregExtensionorg = farmreg.extensionorg;
                    }
                    updateRegistration(12, farmregExtensionorg);


                    if (farmregExtensionorg != null) {
                        // read farmreg.extensionorg.get()
                        farmregExtensionorgGet = farmregExtensionorg.get();
                    }


                    if (farmregExtensionorgGet != null) {
                        // read farmreg.extensionorg.get().equals("Private")
                        farmregExtensionorgGetEqualsJavaLangStringPrivate = farmregExtensionorgGet.equals("Private");
                    }
                if((dirtyFlags & 0xc01000L) != 0) {
                    if(farmregExtensionorgGetEqualsJavaLangStringPrivate) {
                            dirtyFlags |= 0x2000000L;
                    }
                    else {
                            dirtyFlags |= 0x1000000L;
                    }
                }


                    // read farmreg.extensionorg.get().equals("Private") ? true : false
                    farmregExtensionorgGetEqualsJavaLangStringPrivateBooleanTrueBooleanFalse = ((farmregExtensionorgGetEqualsJavaLangStringPrivate) ? (true) : (false));
            }
            if ((dirtyFlags & 0xc02000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.laboursource
                        farmregLaboursource = farmreg.laboursource;
                    }
                    updateRegistration(13, farmregLaboursource);


                    if (farmregLaboursource != null) {
                        // read farmreg.laboursource.get()
                        farmregLaboursourceGet = farmregLaboursource.get();
                    }
            }
            if ((dirtyFlags & 0xc04000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.community
                        farmregCommunity = farmreg.community;
                    }
                    updateRegistration(14, farmregCommunity);


                    if (farmregCommunity != null) {
                        // read farmreg.community.get()
                        farmregCommunityGet = farmregCommunity.get();
                    }
            }
            if ((dirtyFlags & 0xc08000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.boolagroactivity
                        farmregBoolagroactivity = farmreg.boolagroactivity;
                    }
                    updateRegistration(15, farmregBoolagroactivity);


                    if (farmregBoolagroactivity != null) {
                        // read farmreg.boolagroactivity.get()
                        farmregBoolagroactivityGet = farmregBoolagroactivity.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(farmreg.boolagroactivity.get())
                    androidxDatabindingViewDataBindingSafeUnboxFarmregBoolagroactivityGet = androidx.databinding.ViewDataBinding.safeUnbox(farmregBoolagroactivityGet);
            }
            if ((dirtyFlags & 0xc10000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.region
                        farmregRegion = farmreg.region;
                    }
                    updateRegistration(16, farmregRegion);


                    if (farmregRegion != null) {
                        // read farmreg.region.get()
                        farmregRegionGet = farmregRegion.get();
                    }
            }
            if ((dirtyFlags & 0xc20000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.district
                        farmregDistrict = farmreg.district;
                    }
                    updateRegistration(17, farmregDistrict);


                    if (farmregDistrict != null) {
                        // read farmreg.district.get()
                        farmregDistrictGet = farmregDistrict.get();
                    }
            }
            if ((dirtyFlags & 0xc40000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.fertilizerused
                        farmregFertilizerused = farmreg.fertilizerused;
                    }
                    updateRegistration(18, farmregFertilizerused);


                    if (farmregFertilizerused != null) {
                        // read farmreg.fertilizerused.get()
                        farmregFertilizerusedGet = farmregFertilizerused.get();
                    }
            }
            if ((dirtyFlags & 0xc80000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.agroactivity
                        farmregAgroactivity = farmreg.agroactivity;
                    }
                    updateRegistration(19, farmregAgroactivity);


                    if (farmregAgroactivity != null) {
                        // read farmreg.agroactivity.get()
                        farmregAgroactivityGet = farmregAgroactivity.get();
                    }
            }
            if ((dirtyFlags & 0xd00000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.shadetreeno
                        farmregShadetreeno = farmreg.shadetreeno;
                    }
                    updateRegistration(20, farmregShadetreeno);


                    if (farmregShadetreeno != null) {
                        // read farmreg.shadetreeno.get()
                        farmregShadetreenoGet = farmregShadetreeno.get();
                    }
            }
            if ((dirtyFlags & 0xe00000L) != 0) {

                    if (farmreg != null) {
                        // read farmreg.cultarea
                        farmregCultarea = farmreg.cultarea;
                    }
                    updateRegistration(21, farmregCultarea);


                    if (farmregCultarea != null) {
                        // read farmreg.cultarea.get()
                        farmregCultareaGet = farmregCultarea.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xc08000L) != 0) {
            // api target 1

            this.agricactive.setEnabled(androidxDatabindingViewDataBindingSafeUnboxFarmregBoolagroactivityGet);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.swagroactive, androidxDatabindingViewDataBindingSafeUnboxFarmregBoolagroactivityGet);
        }
        if ((dirtyFlags & 0xc80000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.agricactive, farmregAgroactivityGet);
        }
        if ((dirtyFlags & 0x800000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.agricactive, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, agricactiveandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.chemicalused, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, chemicalusedandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.cocoatype, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, cocoatypeandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.cropVariety, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, cropVarietyandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.cropprotection, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, cropprotectionandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.cultarea, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, cultareaandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.district, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, districtandroidTextAttrChanged);
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.extentoinservice, (android.widget.CompoundButton.OnCheckedChangeListener)null, extentoinserviceandroidCheckedAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.farmyield, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, farmyieldandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.fertused, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, fertusedandroidTextAttrChanged);
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
        if ((dirtyFlags & 0xc00200L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.chemicalused, farmregChemicalusedGet);
        }
        if ((dirtyFlags & 0xc00001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cocoatype, farmregTypeoffarmGet);
        }
        if ((dirtyFlags & 0xc00010L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cropVariety, farmregCropvarietyGet);
        }
        if ((dirtyFlags & 0xc00008L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cropprotection, farmregCropprotectionGet);
        }
        if ((dirtyFlags & 0xe00000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cultarea, farmregCultareaGet);
        }
        if ((dirtyFlags & 0xc20000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.district, farmregDistrictGet);
        }
        if ((dirtyFlags & 0xc00100L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.extentoinservice, androidxDatabindingViewDataBindingSafeUnboxFarmregExtensionGet);
            this.provideorg.setEnabled(androidxDatabindingViewDataBindingSafeUnboxFarmregExtensionGet);
        }
        if ((dirtyFlags & 0xc00800L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.farmyield, farmregFarmyieldGet);
        }
        if ((dirtyFlags & 0xc40000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.fertused, farmregFertilizerusedGet);
        }
        if ((dirtyFlags & 0xc02000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.laborsource, farmregLaboursourceGet);
        }
        if ((dirtyFlags & 0xc00002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.landarea, farmregLandareaGet);
        }
        if ((dirtyFlags & 0xc00400L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.materialothersource, farmregOtherplantmatsrcGet);
        }
        if ((dirtyFlags & 0xc00020L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.materialsource, farmregPlantmaterialsrcGet);
        }
        if ((dirtyFlags & 0xc04000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, farmregCommunityGet);
        }
        if ((dirtyFlags & 0xc00080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.ownership, farmregSourceofownershipGet);
        }
        if ((dirtyFlags & 0xc01000L) != 0) {
            // api target 1

            this.privorg.setEnabled(farmregExtensionorgGetEqualsJavaLangStringPrivateBooleanTrueBooleanFalse);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.provideorg, farmregExtensionorgGet);
        }
        if ((dirtyFlags & 0xc00004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.privorg, farmregPrivateextentionorgGet);
        }
        if ((dirtyFlags & 0xd00000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.shadetreeno, farmregShadetreenoGet);
        }
        if ((dirtyFlags & 0xc00040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtestabyear, farmregEstablishedyearGet);
        }
        if ((dirtyFlags & 0xc10000L) != 0) {
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
        flag 3 (0x4L): farmreg.cropprotection
        flag 4 (0x5L): farmreg.cropvariety
        flag 5 (0x6L): farmreg.plantmaterialsrc
        flag 6 (0x7L): farmreg.establishedyear
        flag 7 (0x8L): farmreg.sourceofownership
        flag 8 (0x9L): farmreg.extension
        flag 9 (0xaL): farmreg.chemicalused
        flag 10 (0xbL): farmreg.otherplantmatsrc
        flag 11 (0xcL): farmreg.farmyield
        flag 12 (0xdL): farmreg.extensionorg
        flag 13 (0xeL): farmreg.laboursource
        flag 14 (0xfL): farmreg.community
        flag 15 (0x10L): farmreg.boolagroactivity
        flag 16 (0x11L): farmreg.region
        flag 17 (0x12L): farmreg.district
        flag 18 (0x13L): farmreg.fertilizerused
        flag 19 (0x14L): farmreg.agroactivity
        flag 20 (0x15L): farmreg.shadetreeno
        flag 21 (0x16L): farmreg.cultarea
        flag 22 (0x17L): farmreg
        flag 23 (0x18L): null
        flag 24 (0x19L): farmreg.extensionorg.get().equals("Private") ? true : false
        flag 25 (0x1aL): farmreg.extensionorg.get().equals("Private") ? true : false
    flag mapping end*/
    //end
}