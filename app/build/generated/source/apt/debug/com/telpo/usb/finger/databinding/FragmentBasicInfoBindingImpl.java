package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentBasicInfoBindingImpl extends FragmentBasicInfoBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.txtpinfo, 20);
        sViewsWithIds.put(R.id.surname_layout, 21);
        sViewsWithIds.put(R.id.othername_layout, 22);
        sViewsWithIds.put(R.id.nationality_layout, 23);
        sViewsWithIds.put(R.id.gender_layout, 24);
        sViewsWithIds.put(R.id.bdate_layout, 25);
        sViewsWithIds.put(R.id.age_layout, 26);
        sViewsWithIds.put(R.id.bplace_layout, 27);
        sViewsWithIds.put(R.id.hometown_layout, 28);
        sViewsWithIds.put(R.id.farmcomm_layout, 29);
        sViewsWithIds.put(R.id.region_layout, 30);
        sViewsWithIds.put(R.id.district_layout, 31);
        sViewsWithIds.put(R.id.residential_layout, 32);
        sViewsWithIds.put(R.id.telephone_layout, 33);
        sViewsWithIds.put(R.id.maritalstat_layout, 34);
        sViewsWithIds.put(R.id.email_layout, 35);
        sViewsWithIds.put(R.id.edu_layout, 36);
        sViewsWithIds.put(R.id.post_layout, 37);
        sViewsWithIds.put(R.id.idtype_layout, 38);
        sViewsWithIds.put(R.id.idnum_layout, 39);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener ageandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.age.get()
            //         is basicreg.age.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(age);
            // localize variables for thread safety
            // basicreg.age != null
            boolean basicregAgeJavaLangObjectNull = false;
            // basicreg.age.get()
            java.lang.String basicregAgeGet = null;
            // basicreg.age
            androidx.databinding.ObservableField<java.lang.String> basicregAge = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregAge = basicreg.age;

                basicregAgeJavaLangObjectNull = (basicregAge) != (null);
                if (basicregAgeJavaLangObjectNull) {




                    basicregAge.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener bdateandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.dateofbirth.get()
            //         is basicreg.dateofbirth.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(bdate);
            // localize variables for thread safety
            // basicreg.dateofbirth != null
            boolean basicregDateofbirthJavaLangObjectNull = false;
            // basicreg.dateofbirth
            androidx.databinding.ObservableField<java.lang.String> basicregDateofbirth = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.dateofbirth.get()
            java.lang.String basicregDateofbirthGet = null;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregDateofbirth = basicreg.dateofbirth;

                basicregDateofbirthJavaLangObjectNull = (basicregDateofbirth) != (null);
                if (basicregDateofbirthJavaLangObjectNull) {




                    basicregDateofbirth.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener countryandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.nationality.get()
            //         is basicreg.nationality.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(country);
            // localize variables for thread safety
            // basicreg.nationality
            androidx.databinding.ObservableField<java.lang.String> basicregNationality = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.nationality != null
            boolean basicregNationalityJavaLangObjectNull = false;
            // basicreg.nationality.get()
            java.lang.String basicregNationalityGet = null;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregNationality = basicreg.nationality;

                basicregNationalityJavaLangObjectNull = (basicregNationality) != (null);
                if (basicregNationalityJavaLangObjectNull) {




                    basicregNationality.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener districtandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.district.get()
            //         is basicreg.district.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(district);
            // localize variables for thread safety
            // basicreg.district.get()
            java.lang.String basicregDistrictGet = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.district != null
            boolean basicregDistrictJavaLangObjectNull = false;
            // basicreg.district
            androidx.databinding.ObservableField<java.lang.String> basicregDistrict = null;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregDistrict = basicreg.district;

                basicregDistrictJavaLangObjectNull = (basicregDistrict) != (null);
                if (basicregDistrictJavaLangObjectNull) {




                    basicregDistrict.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener eduandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.levelofeducation.get()
            //         is basicreg.levelofeducation.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edu);
            // localize variables for thread safety
            // basicreg.levelofeducation != null
            boolean basicregLevelofeducationJavaLangObjectNull = false;
            // basicreg.levelofeducation
            androidx.databinding.ObservableField<java.lang.String> basicregLevelofeducation = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.levelofeducation.get()
            java.lang.String basicregLevelofeducationGet = null;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregLevelofeducation = basicreg.levelofeducation;

                basicregLevelofeducationJavaLangObjectNull = (basicregLevelofeducation) != (null);
                if (basicregLevelofeducationJavaLangObjectNull) {




                    basicregLevelofeducation.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener emailandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.email.get()
            //         is basicreg.email.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(email);
            // localize variables for thread safety
            // basicreg.email
            androidx.databinding.ObservableField<java.lang.String> basicregEmail = null;
            // basicreg.email.get()
            java.lang.String basicregEmailGet = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.email != null
            boolean basicregEmailJavaLangObjectNull = false;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregEmail = basicreg.email;

                basicregEmailJavaLangObjectNull = (basicregEmail) != (null);
                if (basicregEmailJavaLangObjectNull) {




                    basicregEmail.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener farmcommandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.farmcommunity.get()
            //         is basicreg.farmcommunity.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(farmcomm);
            // localize variables for thread safety
            // basicreg.farmcommunity
            androidx.databinding.ObservableField<java.lang.String> basicregFarmcommunity = null;
            // basicreg.farmcommunity.get()
            java.lang.String basicregFarmcommunityGet = null;
            // basicreg.farmcommunity != null
            boolean basicregFarmcommunityJavaLangObjectNull = false;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregFarmcommunity = basicreg.farmcommunity;

                basicregFarmcommunityJavaLangObjectNull = (basicregFarmcommunity) != (null);
                if (basicregFarmcommunityJavaLangObjectNull) {




                    basicregFarmcommunity.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener genderandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.gender.get()
            //         is basicreg.gender.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(gender);
            // localize variables for thread safety
            // basicreg.gender
            androidx.databinding.ObservableField<java.lang.String> basicregGender = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.gender.get()
            java.lang.String basicregGenderGet = null;
            // basicreg.gender != null
            boolean basicregGenderJavaLangObjectNull = false;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregGender = basicreg.gender;

                basicregGenderJavaLangObjectNull = (basicregGender) != (null);
                if (basicregGenderJavaLangObjectNull) {




                    basicregGender.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener hometownandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.hometown.get()
            //         is basicreg.hometown.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(hometown);
            // localize variables for thread safety
            // basicreg.hometown != null
            boolean basicregHometownJavaLangObjectNull = false;
            // basicreg.hometown
            androidx.databinding.ObservableField<java.lang.String> basicregHometown = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.hometown.get()
            java.lang.String basicregHometownGet = null;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregHometown = basicreg.hometown;

                basicregHometownJavaLangObjectNull = (basicregHometown) != (null);
                if (basicregHometownJavaLangObjectNull) {




                    basicregHometown.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener idtypeandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.idtype.get()
            //         is basicreg.idtype.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(idtype);
            // localize variables for thread safety
            // basicreg.idtype
            androidx.databinding.ObservableField<java.lang.String> basicregIdtype = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.idtype != null
            boolean basicregIdtypeJavaLangObjectNull = false;
            // basicreg.idtype.get()
            java.lang.String basicregIdtypeGet = null;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregIdtype = basicreg.idtype;

                basicregIdtypeJavaLangObjectNull = (basicregIdtype) != (null);
                if (basicregIdtypeJavaLangObjectNull) {




                    basicregIdtype.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener maritalstatusandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.maritalstatus.get()
            //         is basicreg.maritalstatus.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(maritalstatus);
            // localize variables for thread safety
            // basicreg.maritalstatus
            androidx.databinding.ObservableField<java.lang.String> basicregMaritalstatus = null;
            // basicreg.maritalstatus != null
            boolean basicregMaritalstatusJavaLangObjectNull = false;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;
            // basicreg.maritalstatus.get()
            java.lang.String basicregMaritalstatusGet = null;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregMaritalstatus = basicreg.maritalstatus;

                basicregMaritalstatusJavaLangObjectNull = (basicregMaritalstatus) != (null);
                if (basicregMaritalstatusJavaLangObjectNull) {




                    basicregMaritalstatus.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener postboxandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.postofficebox.get()
            //         is basicreg.postofficebox.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(postbox);
            // localize variables for thread safety
            // basicreg.postofficebox.get()
            java.lang.String basicregPostofficeboxGet = null;
            // basicreg.postofficebox
            androidx.databinding.ObservableField<java.lang.String> basicregPostofficebox = null;
            // basicreg.postofficebox != null
            boolean basicregPostofficeboxJavaLangObjectNull = false;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregPostofficebox = basicreg.postofficebox;

                basicregPostofficeboxJavaLangObjectNull = (basicregPostofficebox) != (null);
                if (basicregPostofficeboxJavaLangObjectNull) {




                    basicregPostofficebox.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener regionandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.region.get()
            //         is basicreg.region.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(region);
            // localize variables for thread safety
            // basicreg.region.get()
            java.lang.String basicregRegionGet = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.region
            androidx.databinding.ObservableField<java.lang.String> basicregRegion = null;
            // basicreg.region != null
            boolean basicregRegionJavaLangObjectNull = false;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregRegion = basicreg.region;

                basicregRegionJavaLangObjectNull = (basicregRegion) != (null);
                if (basicregRegionJavaLangObjectNull) {




                    basicregRegion.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener residenceandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.residentialaddr.get()
            //         is basicreg.residentialaddr.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(residence);
            // localize variables for thread safety
            // basicreg.residentialaddr != null
            boolean basicregResidentialaddrJavaLangObjectNull = false;
            // basicreg.residentialaddr.get()
            java.lang.String basicregResidentialaddrGet = null;
            // basicreg.residentialaddr
            androidx.databinding.ObservableField<java.lang.String> basicregResidentialaddr = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregResidentialaddr = basicreg.residentialaddr;

                basicregResidentialaddrJavaLangObjectNull = (basicregResidentialaddr) != (null);
                if (basicregResidentialaddrJavaLangObjectNull) {




                    basicregResidentialaddr.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener telephoneandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.telephone.get()
            //         is basicreg.telephone.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(telephone);
            // localize variables for thread safety
            // basicreg.telephone.get()
            java.lang.String basicregTelephoneGet = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.telephone != null
            boolean basicregTelephoneJavaLangObjectNull = false;
            // basicreg.telephone
            androidx.databinding.ObservableField<java.lang.String> basicregTelephone = null;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregTelephone = basicreg.telephone;

                basicregTelephoneJavaLangObjectNull = (basicregTelephone) != (null);
                if (basicregTelephoneJavaLangObjectNull) {




                    basicregTelephone.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener txtbplaceandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.placeofbirth.get()
            //         is basicreg.placeofbirth.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(txtbplace);
            // localize variables for thread safety
            // basicreg.placeofbirth
            androidx.databinding.ObservableField<java.lang.String> basicregPlaceofbirth = null;
            // basicreg.placeofbirth.get()
            java.lang.String basicregPlaceofbirthGet = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.placeofbirth != null
            boolean basicregPlaceofbirthJavaLangObjectNull = false;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregPlaceofbirth = basicreg.placeofbirth;

                basicregPlaceofbirthJavaLangObjectNull = (basicregPlaceofbirth) != (null);
                if (basicregPlaceofbirthJavaLangObjectNull) {




                    basicregPlaceofbirth.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener txtfirstnameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.firstname.get()
            //         is basicreg.firstname.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(txtfirstname);
            // localize variables for thread safety
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.firstname != null
            boolean basicregFirstnameJavaLangObjectNull = false;
            // basicreg.firstname
            androidx.databinding.ObservableField<java.lang.String> basicregFirstname = null;
            // basicreg.firstname.get()
            java.lang.String basicregFirstnameGet = null;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregFirstname = basicreg.firstname;

                basicregFirstnameJavaLangObjectNull = (basicregFirstname) != (null);
                if (basicregFirstnameJavaLangObjectNull) {




                    basicregFirstname.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener txtidnumandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.idnumber.get()
            //         is basicreg.idnumber.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(txtidnum);
            // localize variables for thread safety
            // basicreg.idnumber != null
            boolean basicregIdnumberJavaLangObjectNull = false;
            // basicreg.idnumber.get()
            java.lang.String basicregIdnumberGet = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg.idnumber
            androidx.databinding.ObservableField<java.lang.String> basicregIdnumber = null;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregIdnumber = basicreg.idnumber;

                basicregIdnumberJavaLangObjectNull = (basicregIdnumber) != (null);
                if (basicregIdnumberJavaLangObjectNull) {




                    basicregIdnumber.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener txtsurnameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of basicreg.surname.get()
            //         is basicreg.surname.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(txtsurname);
            // localize variables for thread safety
            // basicreg.surname != null
            boolean basicregSurnameJavaLangObjectNull = false;
            // basicreg.surname
            androidx.databinding.ObservableField<java.lang.String> basicregSurname = null;
            // basicreg != null
            boolean basicregJavaLangObjectNull = false;
            // basicreg
            com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;
            // basicreg.surname.get()
            java.lang.String basicregSurnameGet = null;



            basicregJavaLangObjectNull = (basicreg) != (null);
            if (basicregJavaLangObjectNull) {


                basicregSurname = basicreg.surname;

                basicregSurnameJavaLangObjectNull = (basicregSurname) != (null);
                if (basicregSurnameJavaLangObjectNull) {




                    basicregSurname.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentBasicInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 40, sIncludes, sViewsWithIds));
    }
    private FragmentBasicInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 19
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (com.google.android.material.textfield.TextInputLayout) bindings[26]
            , (com.google.android.material.textfield.TextInputEditText) bindings[5]
            , (com.google.android.material.textfield.TextInputLayout) bindings[25]
            , (com.google.android.material.textfield.TextInputLayout) bindings[27]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            , (com.google.android.material.textfield.TextInputEditText) bindings[11]
            , (com.google.android.material.textfield.TextInputLayout) bindings[31]
            , (com.google.android.material.textfield.TextInputEditText) bindings[16]
            , (com.google.android.material.textfield.TextInputLayout) bindings[36]
            , (com.google.android.material.textfield.TextInputEditText) bindings[15]
            , (com.google.android.material.textfield.TextInputLayout) bindings[35]
            , (com.google.android.material.textfield.TextInputEditText) bindings[9]
            , (com.google.android.material.textfield.TextInputLayout) bindings[29]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputLayout) bindings[24]
            , (com.google.android.material.textfield.TextInputEditText) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[28]
            , (com.google.android.material.textfield.TextInputLayout) bindings[39]
            , (com.google.android.material.textfield.TextInputEditText) bindings[18]
            , (com.google.android.material.textfield.TextInputLayout) bindings[38]
            , (com.google.android.material.textfield.TextInputLayout) bindings[34]
            , (com.google.android.material.textfield.TextInputEditText) bindings[14]
            , (com.google.android.material.textfield.TextInputLayout) bindings[23]
            , (com.google.android.material.textfield.TextInputLayout) bindings[22]
            , (com.google.android.material.textfield.TextInputLayout) bindings[37]
            , (com.google.android.material.textfield.TextInputEditText) bindings[17]
            , (com.google.android.material.textfield.TextInputEditText) bindings[10]
            , (com.google.android.material.textfield.TextInputLayout) bindings[30]
            , (com.google.android.material.textfield.TextInputEditText) bindings[12]
            , (com.google.android.material.textfield.TextInputLayout) bindings[32]
            , (com.google.android.material.textfield.TextInputLayout) bindings[21]
            , (com.google.android.material.textfield.TextInputEditText) bindings[13]
            , (com.google.android.material.textfield.TextInputLayout) bindings[33]
            , (com.google.android.material.textfield.TextInputEditText) bindings[7]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputEditText) bindings[19]
            , (android.widget.TextView) bindings[20]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            );
        this.age.setTag(null);
        this.bdate.setTag(null);
        this.country.setTag(null);
        this.district.setTag(null);
        this.edu.setTag(null);
        this.email.setTag(null);
        this.farmcomm.setTag(null);
        this.gender.setTag(null);
        this.hometown.setTag(null);
        this.idtype.setTag(null);
        this.maritalstatus.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.postbox.setTag(null);
        this.region.setTag(null);
        this.residence.setTag(null);
        this.telephone.setTag(null);
        this.txtbplace.setTag(null);
        this.txtfirstname.setTag(null);
        this.txtidnum.setTag(null);
        this.txtsurname.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x100000L;
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
        if (BR.basicreg == variableId) {
            setBasicreg((com.telpo.usb.finger.pojo.BasicRegistration) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setBasicreg(@Nullable com.telpo.usb.finger.pojo.BasicRegistration Basicreg) {
        this.mBasicreg = Basicreg;
        synchronized(this) {
            mDirtyFlags |= 0x80000L;
        }
        notifyPropertyChanged(BR.basicreg);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeBasicregSurname((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeBasicregIdnumber((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeBasicregRegion((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeBasicregMaritalstatus((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeBasicregEmail((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeBasicregFirstname((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeBasicregIdtype((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 7 :
                return onChangeBasicregResidentialaddr((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 8 :
                return onChangeBasicregPlaceofbirth((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 9 :
                return onChangeBasicregFarmcommunity((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 10 :
                return onChangeBasicregDateofbirth((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 11 :
                return onChangeBasicregGender((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 12 :
                return onChangeBasicregLevelofeducation((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 13 :
                return onChangeBasicregDistrict((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 14 :
                return onChangeBasicregHometown((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 15 :
                return onChangeBasicregPostofficebox((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 16 :
                return onChangeBasicregNationality((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 17 :
                return onChangeBasicregAge((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 18 :
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
    private boolean onChangeBasicregRegion(androidx.databinding.ObservableField<java.lang.String> BasicregRegion, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregMaritalstatus(androidx.databinding.ObservableField<java.lang.String> BasicregMaritalstatus, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregEmail(androidx.databinding.ObservableField<java.lang.String> BasicregEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregFirstname(androidx.databinding.ObservableField<java.lang.String> BasicregFirstname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregIdtype(androidx.databinding.ObservableField<java.lang.String> BasicregIdtype, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregResidentialaddr(androidx.databinding.ObservableField<java.lang.String> BasicregResidentialaddr, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregPlaceofbirth(androidx.databinding.ObservableField<java.lang.String> BasicregPlaceofbirth, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregFarmcommunity(androidx.databinding.ObservableField<java.lang.String> BasicregFarmcommunity, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregDateofbirth(androidx.databinding.ObservableField<java.lang.String> BasicregDateofbirth, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x400L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregGender(androidx.databinding.ObservableField<java.lang.String> BasicregGender, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x800L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregLevelofeducation(androidx.databinding.ObservableField<java.lang.String> BasicregLevelofeducation, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregDistrict(androidx.databinding.ObservableField<java.lang.String> BasicregDistrict, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregHometown(androidx.databinding.ObservableField<java.lang.String> BasicregHometown, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregPostofficebox(androidx.databinding.ObservableField<java.lang.String> BasicregPostofficebox, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregNationality(androidx.databinding.ObservableField<java.lang.String> BasicregNationality, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregAge(androidx.databinding.ObservableField<java.lang.String> BasicregAge, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeBasicregTelephone(androidx.databinding.ObservableField<java.lang.String> BasicregTelephone, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40000L;
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
        androidx.databinding.ObservableField<java.lang.String> basicregIdnumber = null;
        androidx.databinding.ObservableField<java.lang.String> basicregRegion = null;
        java.lang.String basicregResidentialaddrGet = null;
        java.lang.String basicregPostofficeboxGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregMaritalstatus = null;
        java.lang.String basicregIdtypeGet = null;
        java.lang.String basicregTelephoneGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregEmail = null;
        java.lang.String basicregFirstnameGet = null;
        java.lang.String basicregDistrictGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregFirstname = null;
        androidx.databinding.ObservableField<java.lang.String> basicregIdtype = null;
        androidx.databinding.ObservableField<java.lang.String> basicregResidentialaddr = null;
        androidx.databinding.ObservableField<java.lang.String> basicregPlaceofbirth = null;
        java.lang.String basicregSurnameGet = null;
        java.lang.String basicregFarmcommunityGet = null;
        java.lang.String basicregIdnumberGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregFarmcommunity = null;
        java.lang.String basicregEmailGet = null;
        java.lang.String basicregNationalityGet = null;
        java.lang.String basicregMaritalstatusGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregDateofbirth = null;
        androidx.databinding.ObservableField<java.lang.String> basicregGender = null;
        java.lang.String basicregHometownGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregLevelofeducation = null;
        java.lang.String basicregAgeGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregDistrict = null;
        java.lang.String basicregDateofbirthGet = null;
        androidx.databinding.ObservableField<java.lang.String> basicregHometown = null;
        java.lang.String basicregLevelofeducationGet = null;
        java.lang.String basicregGenderGet = null;
        java.lang.String basicregRegionGet = null;
        java.lang.String basicregPlaceofbirthGet = null;
        com.telpo.usb.finger.pojo.BasicRegistration basicreg = mBasicreg;
        androidx.databinding.ObservableField<java.lang.String> basicregPostofficebox = null;
        androidx.databinding.ObservableField<java.lang.String> basicregNationality = null;
        androidx.databinding.ObservableField<java.lang.String> basicregAge = null;
        androidx.databinding.ObservableField<java.lang.String> basicregTelephone = null;

        if ((dirtyFlags & 0x1fffffL) != 0) {


            if ((dirtyFlags & 0x180001L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.surname
                        basicregSurname = basicreg.surname;
                    }
                    updateRegistration(0, basicregSurname);


                    if (basicregSurname != null) {
                        // read basicreg.surname.get()
                        basicregSurnameGet = basicregSurname.get();
                    }
            }
            if ((dirtyFlags & 0x180002L) != 0) {

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
            if ((dirtyFlags & 0x180004L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.region
                        basicregRegion = basicreg.region;
                    }
                    updateRegistration(2, basicregRegion);


                    if (basicregRegion != null) {
                        // read basicreg.region.get()
                        basicregRegionGet = basicregRegion.get();
                    }
            }
            if ((dirtyFlags & 0x180008L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.maritalstatus
                        basicregMaritalstatus = basicreg.maritalstatus;
                    }
                    updateRegistration(3, basicregMaritalstatus);


                    if (basicregMaritalstatus != null) {
                        // read basicreg.maritalstatus.get()
                        basicregMaritalstatusGet = basicregMaritalstatus.get();
                    }
            }
            if ((dirtyFlags & 0x180010L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.email
                        basicregEmail = basicreg.email;
                    }
                    updateRegistration(4, basicregEmail);


                    if (basicregEmail != null) {
                        // read basicreg.email.get()
                        basicregEmailGet = basicregEmail.get();
                    }
            }
            if ((dirtyFlags & 0x180020L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.firstname
                        basicregFirstname = basicreg.firstname;
                    }
                    updateRegistration(5, basicregFirstname);


                    if (basicregFirstname != null) {
                        // read basicreg.firstname.get()
                        basicregFirstnameGet = basicregFirstname.get();
                    }
            }
            if ((dirtyFlags & 0x180040L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.idtype
                        basicregIdtype = basicreg.idtype;
                    }
                    updateRegistration(6, basicregIdtype);


                    if (basicregIdtype != null) {
                        // read basicreg.idtype.get()
                        basicregIdtypeGet = basicregIdtype.get();
                    }
            }
            if ((dirtyFlags & 0x180080L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.residentialaddr
                        basicregResidentialaddr = basicreg.residentialaddr;
                    }
                    updateRegistration(7, basicregResidentialaddr);


                    if (basicregResidentialaddr != null) {
                        // read basicreg.residentialaddr.get()
                        basicregResidentialaddrGet = basicregResidentialaddr.get();
                    }
            }
            if ((dirtyFlags & 0x180100L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.placeofbirth
                        basicregPlaceofbirth = basicreg.placeofbirth;
                    }
                    updateRegistration(8, basicregPlaceofbirth);


                    if (basicregPlaceofbirth != null) {
                        // read basicreg.placeofbirth.get()
                        basicregPlaceofbirthGet = basicregPlaceofbirth.get();
                    }
            }
            if ((dirtyFlags & 0x180200L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.farmcommunity
                        basicregFarmcommunity = basicreg.farmcommunity;
                    }
                    updateRegistration(9, basicregFarmcommunity);


                    if (basicregFarmcommunity != null) {
                        // read basicreg.farmcommunity.get()
                        basicregFarmcommunityGet = basicregFarmcommunity.get();
                    }
            }
            if ((dirtyFlags & 0x180400L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.dateofbirth
                        basicregDateofbirth = basicreg.dateofbirth;
                    }
                    updateRegistration(10, basicregDateofbirth);


                    if (basicregDateofbirth != null) {
                        // read basicreg.dateofbirth.get()
                        basicregDateofbirthGet = basicregDateofbirth.get();
                    }
            }
            if ((dirtyFlags & 0x180800L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.gender
                        basicregGender = basicreg.gender;
                    }
                    updateRegistration(11, basicregGender);


                    if (basicregGender != null) {
                        // read basicreg.gender.get()
                        basicregGenderGet = basicregGender.get();
                    }
            }
            if ((dirtyFlags & 0x181000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.levelofeducation
                        basicregLevelofeducation = basicreg.levelofeducation;
                    }
                    updateRegistration(12, basicregLevelofeducation);


                    if (basicregLevelofeducation != null) {
                        // read basicreg.levelofeducation.get()
                        basicregLevelofeducationGet = basicregLevelofeducation.get();
                    }
            }
            if ((dirtyFlags & 0x182000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.district
                        basicregDistrict = basicreg.district;
                    }
                    updateRegistration(13, basicregDistrict);


                    if (basicregDistrict != null) {
                        // read basicreg.district.get()
                        basicregDistrictGet = basicregDistrict.get();
                    }
            }
            if ((dirtyFlags & 0x184000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.hometown
                        basicregHometown = basicreg.hometown;
                    }
                    updateRegistration(14, basicregHometown);


                    if (basicregHometown != null) {
                        // read basicreg.hometown.get()
                        basicregHometownGet = basicregHometown.get();
                    }
            }
            if ((dirtyFlags & 0x188000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.postofficebox
                        basicregPostofficebox = basicreg.postofficebox;
                    }
                    updateRegistration(15, basicregPostofficebox);


                    if (basicregPostofficebox != null) {
                        // read basicreg.postofficebox.get()
                        basicregPostofficeboxGet = basicregPostofficebox.get();
                    }
            }
            if ((dirtyFlags & 0x190000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.nationality
                        basicregNationality = basicreg.nationality;
                    }
                    updateRegistration(16, basicregNationality);


                    if (basicregNationality != null) {
                        // read basicreg.nationality.get()
                        basicregNationalityGet = basicregNationality.get();
                    }
            }
            if ((dirtyFlags & 0x1a0000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.age
                        basicregAge = basicreg.age;
                    }
                    updateRegistration(17, basicregAge);


                    if (basicregAge != null) {
                        // read basicreg.age.get()
                        basicregAgeGet = basicregAge.get();
                    }
            }
            if ((dirtyFlags & 0x1c0000L) != 0) {

                    if (basicreg != null) {
                        // read basicreg.telephone
                        basicregTelephone = basicreg.telephone;
                    }
                    updateRegistration(18, basicregTelephone);


                    if (basicregTelephone != null) {
                        // read basicreg.telephone.get()
                        basicregTelephoneGet = basicregTelephone.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1a0000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.age, basicregAgeGet);
        }
        if ((dirtyFlags & 0x100000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.age, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, ageandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.bdate, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, bdateandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.bdate, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.country, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, countryandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.country, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.district, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, districtandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.district, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edu, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, eduandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.email, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, emailandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.farmcomm, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, farmcommandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.farmcomm, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.gender, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, genderandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.gender, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.hometown, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, hometownandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.idtype, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, idtypeandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.idtype, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.maritalstatus, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, maritalstatusandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.maritalstatus, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.postbox, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, postboxandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.region, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, regionandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.region, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.residence, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, residenceandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.telephone, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, telephoneandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.telephone, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.txtbplace, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, txtbplaceandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.txtfirstname, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, txtfirstnameandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.txtfirstname, true, (java.lang.String)null, (boolean)false);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.txtidnum, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, txtidnumandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.txtsurname, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, txtsurnameandroidTextAttrChanged);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.txtsurname, true, (java.lang.String)null, (boolean)false);
        }
        if ((dirtyFlags & 0x180400L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.bdate, basicregDateofbirthGet);
        }
        if ((dirtyFlags & 0x190000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.country, basicregNationalityGet);
        }
        if ((dirtyFlags & 0x182000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.district, basicregDistrictGet);
        }
        if ((dirtyFlags & 0x181000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edu, basicregLevelofeducationGet);
        }
        if ((dirtyFlags & 0x180010L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.email, basicregEmailGet);
        }
        if ((dirtyFlags & 0x180200L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.farmcomm, basicregFarmcommunityGet);
        }
        if ((dirtyFlags & 0x180800L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.gender, basicregGenderGet);
        }
        if ((dirtyFlags & 0x184000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.hometown, basicregHometownGet);
        }
        if ((dirtyFlags & 0x180040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.idtype, basicregIdtypeGet);
        }
        if ((dirtyFlags & 0x180008L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.maritalstatus, basicregMaritalstatusGet);
        }
        if ((dirtyFlags & 0x188000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.postbox, basicregPostofficeboxGet);
        }
        if ((dirtyFlags & 0x180004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.region, basicregRegionGet);
        }
        if ((dirtyFlags & 0x180080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.residence, basicregResidentialaddrGet);
        }
        if ((dirtyFlags & 0x1c0000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.telephone, basicregTelephoneGet);
        }
        if ((dirtyFlags & 0x180100L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtbplace, basicregPlaceofbirthGet);
        }
        if ((dirtyFlags & 0x180020L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtfirstname, basicregFirstnameGet);
        }
        if ((dirtyFlags & 0x180002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtidnum, basicregIdnumberGet);
        }
        if ((dirtyFlags & 0x180001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtsurname, basicregSurnameGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): basicreg.surname
        flag 1 (0x2L): basicreg.idnumber
        flag 2 (0x3L): basicreg.region
        flag 3 (0x4L): basicreg.maritalstatus
        flag 4 (0x5L): basicreg.email
        flag 5 (0x6L): basicreg.firstname
        flag 6 (0x7L): basicreg.idtype
        flag 7 (0x8L): basicreg.residentialaddr
        flag 8 (0x9L): basicreg.placeofbirth
        flag 9 (0xaL): basicreg.farmcommunity
        flag 10 (0xbL): basicreg.dateofbirth
        flag 11 (0xcL): basicreg.gender
        flag 12 (0xdL): basicreg.levelofeducation
        flag 13 (0xeL): basicreg.district
        flag 14 (0xfL): basicreg.hometown
        flag 15 (0x10L): basicreg.postofficebox
        flag 16 (0x11L): basicreg.nationality
        flag 17 (0x12L): basicreg.age
        flag 18 (0x13L): basicreg.telephone
        flag 19 (0x14L): basicreg
        flag 20 (0x15L): null
    flag mapping end*/
    //end
}