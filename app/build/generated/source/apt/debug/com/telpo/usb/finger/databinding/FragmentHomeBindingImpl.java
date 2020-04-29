package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBindingImpl extends FragmentHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.norecord, 19);
        sViewsWithIds.put(R.id.inputdealer_recycler, 20);
        sViewsWithIds.put(R.id.norecord2, 21);
        sViewsWithIds.put(R.id.personal_recycler, 22);
        sViewsWithIds.put(R.id.salestran_card, 23);
        sViewsWithIds.put(R.id.declaration_card, 24);
        sViewsWithIds.put(R.id.scaletran_card, 25);
        sViewsWithIds.put(R.id.yield, 26);
        sViewsWithIds.put(R.id.service_card, 27);
        sViewsWithIds.put(R.id.servicenorecord, 28);
        sViewsWithIds.put(R.id.servicesummary_recycler, 29);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener declarationDebtorsandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.decserved.get()
            //         is home.decserved.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(declarationDebtors);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.decserved != null
            boolean homeDecservedJavaLangObjectNull = false;
            // home.decserved.get()
            java.lang.String homeDecservedGet = null;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.decserved
            androidx.databinding.ObservableField<java.lang.String> homeDecserved = null;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeDecserved = home.decserved;

                homeDecservedJavaLangObjectNull = (homeDecserved) != (null);
                if (homeDecservedJavaLangObjectNull) {




                    homeDecserved.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener declarationExpectedandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.pay.get()
            //         is home.pay.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(declarationExpected);
            // localize variables for thread safety
            // home.pay.get()
            java.lang.String homePayGet = null;
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.pay != null
            boolean homePayJavaLangObjectNull = false;
            // home.pay
            androidx.databinding.ObservableField<java.lang.String> homePay = null;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homePay = home.pay;

                homePayJavaLangObjectNull = (homePay) != (null);
                if (homePayJavaLangObjectNull) {




                    homePay.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener declarationOwingandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.owing.get()
            //         is home.owing.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(declarationOwing);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.owing
            androidx.databinding.ObservableField<java.lang.String> homeOwing = null;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.owing != null
            boolean homeOwingJavaLangObjectNull = false;
            // home.owing.get()
            java.lang.String homeOwingGet = null;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeOwing = home.owing;

                homeOwingJavaLangObjectNull = (homeOwing) != (null);
                if (homeOwingJavaLangObjectNull) {




                    homeOwing.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener declarationRedeemedandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.fullrecov.get()
            //         is home.fullrecov.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(declarationRedeemed);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.fullrecov.get()
            java.lang.String homeFullrecovGet = null;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.fullrecov != null
            boolean homeFullrecovJavaLangObjectNull = false;
            // home.fullrecov
            androidx.databinding.ObservableField<java.lang.String> homeFullrecov = null;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeFullrecov = home.fullrecov;

                homeFullrecovJavaLangObjectNull = (homeFullrecov) != (null);
                if (homeFullrecovJavaLangObjectNull) {




                    homeFullrecov.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener salestranBarterandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.ba.get()
            //         is home.ba.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(salestranBarter);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.ba.get()
            java.lang.String homeBaGet = null;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.ba != null
            boolean homeBaJavaLangObjectNull = false;
            // home.ba
            androidx.databinding.ObservableField<java.lang.String> homeBa = null;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeBa = home.ba;

                homeBaJavaLangObjectNull = (homeBa) != (null);
                if (homeBaJavaLangObjectNull) {




                    homeBa.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener salestranCashandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.cash.get()
            //         is home.cash.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(salestranCash);
            // localize variables for thread safety
            // home.cash.get()
            java.lang.String homeCashGet = null;
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.cash
            androidx.databinding.ObservableField<java.lang.String> homeCash = null;
            // home.cash != null
            boolean homeCashJavaLangObjectNull = false;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeCash = home.cash;

                homeCashJavaLangObjectNull = (homeCash) != (null);
                if (homeCashJavaLangObjectNull) {




                    homeCash.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener salestranFarmerservedandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.salesserved.get()
            //         is home.salesserved.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(salestranFarmerserved);
            // localize variables for thread safety
            // home.salesserved.get()
            java.lang.String homeSalesservedGet = null;
            // home.salesserved
            androidx.databinding.ObservableField<java.lang.String> homeSalesserved = null;
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.salesserved != null
            boolean homeSalesservedJavaLangObjectNull = false;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeSalesserved = home.salesserved;

                homeSalesservedJavaLangObjectNull = (homeSalesserved) != (null);
                if (homeSalesservedJavaLangObjectNull) {




                    homeSalesserved.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener salestranMmandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.mm.get()
            //         is home.mm.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(salestranMm);
            // localize variables for thread safety
            // home.mm.get()
            java.lang.String homeMmGet = null;
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.mm != null
            boolean homeMmJavaLangObjectNull = false;
            // home.mm
            androidx.databinding.ObservableField<java.lang.String> homeMm = null;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeMm = home.mm;

                homeMmJavaLangObjectNull = (homeMm) != (null);
                if (homeMmJavaLangObjectNull) {




                    homeMm.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener salestranNonsubsidizedandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.salesnsub.get()
            //         is home.salesnsub.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(salestranNonsubsidized);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.salesnsub != null
            boolean homeSalesnsubJavaLangObjectNull = false;
            // home.salesnsub.get()
            java.lang.String homeSalesnsubGet = null;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.salesnsub
            androidx.databinding.ObservableField<java.lang.String> homeSalesnsub = null;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeSalesnsub = home.salesnsub;

                homeSalesnsubJavaLangObjectNull = (homeSalesnsub) != (null);
                if (homeSalesnsubJavaLangObjectNull) {




                    homeSalesnsub.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener salestranRevenueandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.revenue.get()
            //         is home.revenue.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(salestranRevenue);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.revenue
            androidx.databinding.ObservableField<java.lang.String> homeRevenue = null;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.revenue.get()
            java.lang.String homeRevenueGet = null;
            // home.revenue != null
            boolean homeRevenueJavaLangObjectNull = false;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeRevenue = home.revenue;

                homeRevenueJavaLangObjectNull = (homeRevenue) != (null);
                if (homeRevenueJavaLangObjectNull) {




                    homeRevenue.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener salestranSubsidizedandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.salessub.get()
            //         is home.salessub.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(salestranSubsidized);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.salessub != null
            boolean homeSalessubJavaLangObjectNull = false;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.salessub
            androidx.databinding.ObservableField<java.lang.String> homeSalessub = null;
            // home.salessub.get()
            java.lang.String homeSalessubGet = null;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeSalessub = home.salessub;

                homeSalessubJavaLangObjectNull = (homeSalessub) != (null);
                if (homeSalessubJavaLangObjectNull) {




                    homeSalessub.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener scaletranBagsowingandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.remaining.get()
            //         is home.remaining.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(scaletranBagsowing);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.remaining
            androidx.databinding.ObservableField<java.lang.String> homeRemaining = null;
            // home.remaining.get()
            java.lang.String homeRemainingGet = null;
            // home.remaining != null
            boolean homeRemainingJavaLangObjectNull = false;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeRemaining = home.remaining;

                homeRemainingJavaLangObjectNull = (homeRemaining) != (null);
                if (homeRemainingJavaLangObjectNull) {




                    homeRemaining.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener scaletranFarmerservedandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.scaleserved.get()
            //         is home.scaleserved.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(scaletranFarmerserved);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.scaleserved.get()
            java.lang.String homeScaleservedGet = null;
            // home.scaleserved != null
            boolean homeScaleservedJavaLangObjectNull = false;
            // home.scaleserved
            androidx.databinding.ObservableField<java.lang.String> homeScaleserved = null;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeScaleserved = home.scaleserved;

                homeScaleservedJavaLangObjectNull = (homeScaleserved) != (null);
                if (homeScaleservedJavaLangObjectNull) {




                    homeScaleserved.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener scaletranMcandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.avemoist.get()
            //         is home.avemoist.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(scaletranMc);
            // localize variables for thread safety
            // home.avemoist
            androidx.databinding.ObservableField<java.lang.String> homeAvemoist = null;
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.avemoist.get()
            java.lang.String homeAvemoistGet = null;
            // home.avemoist != null
            boolean homeAvemoistJavaLangObjectNull = false;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeAvemoist = home.avemoist;

                homeAvemoistJavaLangObjectNull = (homeAvemoist) != (null);
                if (homeAvemoistJavaLangObjectNull) {




                    homeAvemoist.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener scaletranPurchaseandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.totalpurchase.get()
            //         is home.totalpurchase.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(scaletranPurchase);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.totalpurchase != null
            boolean homeTotalpurchaseJavaLangObjectNull = false;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.totalpurchase.get()
            java.lang.String homeTotalpurchaseGet = null;
            // home.totalpurchase
            androidx.databinding.ObservableField<java.lang.String> homeTotalpurchase = null;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeTotalpurchase = home.totalpurchase;

                homeTotalpurchaseJavaLangObjectNull = (homeTotalpurchase) != (null);
                if (homeTotalpurchaseJavaLangObjectNull) {




                    homeTotalpurchase.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener scaletranRecoveryandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.recov.get()
            //         is home.recov.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(scaletranRecovery);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home.recov
            androidx.databinding.ObservableField<java.lang.String> homeRecov = null;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.recov != null
            boolean homeRecovJavaLangObjectNull = false;
            // home.recov.get()
            java.lang.String homeRecovGet = null;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeRecov = home.recov;

                homeRecovJavaLangObjectNull = (homeRecov) != (null);
                if (homeRecovJavaLangObjectNull) {




                    homeRecov.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener scaletranWeightandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.exrecov.get()
            //         is home.exrecov.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(scaletranWeight);
            // localize variables for thread safety
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.exrecov != null
            boolean homeExrecovJavaLangObjectNull = false;
            // home.exrecov
            androidx.databinding.ObservableField<java.lang.String> homeExrecov = null;
            // home.exrecov.get()
            java.lang.String homeExrecovGet = null;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeExrecov = home.exrecov;

                homeExrecovJavaLangObjectNull = (homeExrecov) != (null);
                if (homeExrecovJavaLangObjectNull) {




                    homeExrecov.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener scaletranYieldandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of home.topid.get()
            //         is home.topid.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(scaletranYield);
            // localize variables for thread safety
            // home.topid
            androidx.databinding.ObservableField<java.lang.String> homeTopid = null;
            // home != null
            boolean homeJavaLangObjectNull = false;
            // home
            com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
            // home.topid.get()
            java.lang.String homeTopidGet = null;
            // home.topid != null
            boolean homeTopidJavaLangObjectNull = false;



            homeJavaLangObjectNull = (home) != (null);
            if (homeJavaLangObjectNull) {


                homeTopid = home.topid;

                homeTopidJavaLangObjectNull = (homeTopid) != (null);
                if (homeTopidJavaLangObjectNull) {




                    homeTopid.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 18
            , (android.widget.FrameLayout) bindings[0]
            , (androidx.cardview.widget.CardView) bindings[24]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (androidx.recyclerview.widget.RecyclerView) bindings[20]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[21]
            , (androidx.recyclerview.widget.RecyclerView) bindings[22]
            , (android.widget.TextView) bindings[6]
            , (androidx.cardview.widget.CardView) bindings[23]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[14]
            , (androidx.cardview.widget.CardView) bindings[25]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[18]
            , (androidx.cardview.widget.CardView) bindings[27]
            , (android.widget.TextView) bindings[28]
            , (androidx.recyclerview.widget.RecyclerView) bindings[29]
            , (android.widget.LinearLayout) bindings[26]
            );
        this.container.setTag(null);
        this.declarationDebtors.setTag(null);
        this.declarationExpected.setTag(null);
        this.declarationOwing.setTag(null);
        this.declarationRedeemed.setTag(null);
        this.salestranBarter.setTag(null);
        this.salestranCash.setTag(null);
        this.salestranFarmerserved.setTag(null);
        this.salestranMm.setTag(null);
        this.salestranNonsubsidized.setTag(null);
        this.salestranRevenue.setTag(null);
        this.salestranSubsidized.setTag(null);
        this.scaletranBagsowing.setTag(null);
        this.scaletranFarmerserved.setTag(null);
        this.scaletranMc.setTag(null);
        this.scaletranPurchase.setTag(null);
        this.scaletranRecovery.setTag(null);
        this.scaletranWeight.setTag(null);
        this.scaletranYield.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80000L;
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
        if (BR.home == variableId) {
            setHome((com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHome(@Nullable com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo Home) {
        this.mHome = Home;
        synchronized(this) {
            mDirtyFlags |= 0x40000L;
        }
        notifyPropertyChanged(BR.home);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeHomeTopid((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeHomeScaleserved((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeHomeDecserved((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeHomeExrecov((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeHomeTotalpurchase((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeHomeOwing((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeHomeSalesnsub((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 7 :
                return onChangeHomeAvemoist((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 8 :
                return onChangeHomeRevenue((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 9 :
                return onChangeHomeMm((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 10 :
                return onChangeHomePay((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 11 :
                return onChangeHomeRemaining((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 12 :
                return onChangeHomeCash((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 13 :
                return onChangeHomeFullrecov((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 14 :
                return onChangeHomeRecov((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 15 :
                return onChangeHomeSalessub((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 16 :
                return onChangeHomeSalesserved((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 17 :
                return onChangeHomeBa((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeHomeTopid(androidx.databinding.ObservableField<java.lang.String> HomeTopid, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeScaleserved(androidx.databinding.ObservableField<java.lang.String> HomeScaleserved, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeDecserved(androidx.databinding.ObservableField<java.lang.String> HomeDecserved, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeExrecov(androidx.databinding.ObservableField<java.lang.String> HomeExrecov, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeTotalpurchase(androidx.databinding.ObservableField<java.lang.String> HomeTotalpurchase, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeOwing(androidx.databinding.ObservableField<java.lang.String> HomeOwing, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeSalesnsub(androidx.databinding.ObservableField<java.lang.String> HomeSalesnsub, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeAvemoist(androidx.databinding.ObservableField<java.lang.String> HomeAvemoist, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeRevenue(androidx.databinding.ObservableField<java.lang.String> HomeRevenue, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeMm(androidx.databinding.ObservableField<java.lang.String> HomeMm, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomePay(androidx.databinding.ObservableField<java.lang.String> HomePay, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x400L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeRemaining(androidx.databinding.ObservableField<java.lang.String> HomeRemaining, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x800L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeCash(androidx.databinding.ObservableField<java.lang.String> HomeCash, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeFullrecov(androidx.databinding.ObservableField<java.lang.String> HomeFullrecov, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeRecov(androidx.databinding.ObservableField<java.lang.String> HomeRecov, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeSalessub(androidx.databinding.ObservableField<java.lang.String> HomeSalessub, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeSalesserved(androidx.databinding.ObservableField<java.lang.String> HomeSalesserved, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHomeBa(androidx.databinding.ObservableField<java.lang.String> HomeBa, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000L;
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
        androidx.databinding.ObservableField<java.lang.String> homeTopid = null;
        java.lang.String homeExrecovGet = null;
        java.lang.String homeFullrecovGet = null;
        androidx.databinding.ObservableField<java.lang.String> homeScaleserved = null;
        androidx.databinding.ObservableField<java.lang.String> homeDecserved = null;
        androidx.databinding.ObservableField<java.lang.String> homeExrecov = null;
        androidx.databinding.ObservableField<java.lang.String> homeTotalpurchase = null;
        java.lang.String homeRecovGet = null;
        androidx.databinding.ObservableField<java.lang.String> homeOwing = null;
        androidx.databinding.ObservableField<java.lang.String> homeSalesnsub = null;
        androidx.databinding.ObservableField<java.lang.String> homeAvemoist = null;
        java.lang.String homeOwingGet = null;
        java.lang.String homePayGet = null;
        java.lang.String homeRemainingGet = null;
        java.lang.String homeSalesnsubGet = null;
        java.lang.String homeAvemoistGet = null;
        java.lang.String homeCashGet = null;
        androidx.databinding.ObservableField<java.lang.String> homeRevenue = null;
        androidx.databinding.ObservableField<java.lang.String> homeMm = null;
        androidx.databinding.ObservableField<java.lang.String> homePay = null;
        androidx.databinding.ObservableField<java.lang.String> homeRemaining = null;
        androidx.databinding.ObservableField<java.lang.String> homeCash = null;
        androidx.databinding.ObservableField<java.lang.String> homeFullrecov = null;
        java.lang.String homeTopidGet = null;
        java.lang.String homeSalessubGet = null;
        java.lang.String homeSalesservedGet = null;
        androidx.databinding.ObservableField<java.lang.String> homeRecov = null;
        androidx.databinding.ObservableField<java.lang.String> homeSalessub = null;
        androidx.databinding.ObservableField<java.lang.String> homeSalesserved = null;
        java.lang.String homeRevenueGet = null;
        com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo home = mHome;
        java.lang.String homeTotalpurchaseGet = null;
        androidx.databinding.ObservableField<java.lang.String> homeBa = null;
        java.lang.String homeBaGet = null;
        java.lang.String homeDecservedGet = null;
        java.lang.String homeMmGet = null;
        java.lang.String homeScaleservedGet = null;

        if ((dirtyFlags & 0xfffffL) != 0) {


            if ((dirtyFlags & 0xc0001L) != 0) {

                    if (home != null) {
                        // read home.topid
                        homeTopid = home.topid;
                    }
                    updateRegistration(0, homeTopid);


                    if (homeTopid != null) {
                        // read home.topid.get()
                        homeTopidGet = homeTopid.get();
                    }
            }
            if ((dirtyFlags & 0xc0002L) != 0) {

                    if (home != null) {
                        // read home.scaleserved
                        homeScaleserved = home.scaleserved;
                    }
                    updateRegistration(1, homeScaleserved);


                    if (homeScaleserved != null) {
                        // read home.scaleserved.get()
                        homeScaleservedGet = homeScaleserved.get();
                    }
            }
            if ((dirtyFlags & 0xc0004L) != 0) {

                    if (home != null) {
                        // read home.decserved
                        homeDecserved = home.decserved;
                    }
                    updateRegistration(2, homeDecserved);


                    if (homeDecserved != null) {
                        // read home.decserved.get()
                        homeDecservedGet = homeDecserved.get();
                    }
            }
            if ((dirtyFlags & 0xc0008L) != 0) {

                    if (home != null) {
                        // read home.exrecov
                        homeExrecov = home.exrecov;
                    }
                    updateRegistration(3, homeExrecov);


                    if (homeExrecov != null) {
                        // read home.exrecov.get()
                        homeExrecovGet = homeExrecov.get();
                    }
            }
            if ((dirtyFlags & 0xc0010L) != 0) {

                    if (home != null) {
                        // read home.totalpurchase
                        homeTotalpurchase = home.totalpurchase;
                    }
                    updateRegistration(4, homeTotalpurchase);


                    if (homeTotalpurchase != null) {
                        // read home.totalpurchase.get()
                        homeTotalpurchaseGet = homeTotalpurchase.get();
                    }
            }
            if ((dirtyFlags & 0xc0020L) != 0) {

                    if (home != null) {
                        // read home.owing
                        homeOwing = home.owing;
                    }
                    updateRegistration(5, homeOwing);


                    if (homeOwing != null) {
                        // read home.owing.get()
                        homeOwingGet = homeOwing.get();
                    }
            }
            if ((dirtyFlags & 0xc0040L) != 0) {

                    if (home != null) {
                        // read home.salesnsub
                        homeSalesnsub = home.salesnsub;
                    }
                    updateRegistration(6, homeSalesnsub);


                    if (homeSalesnsub != null) {
                        // read home.salesnsub.get()
                        homeSalesnsubGet = homeSalesnsub.get();
                    }
            }
            if ((dirtyFlags & 0xc0080L) != 0) {

                    if (home != null) {
                        // read home.avemoist
                        homeAvemoist = home.avemoist;
                    }
                    updateRegistration(7, homeAvemoist);


                    if (homeAvemoist != null) {
                        // read home.avemoist.get()
                        homeAvemoistGet = homeAvemoist.get();
                    }
            }
            if ((dirtyFlags & 0xc0100L) != 0) {

                    if (home != null) {
                        // read home.revenue
                        homeRevenue = home.revenue;
                    }
                    updateRegistration(8, homeRevenue);


                    if (homeRevenue != null) {
                        // read home.revenue.get()
                        homeRevenueGet = homeRevenue.get();
                    }
            }
            if ((dirtyFlags & 0xc0200L) != 0) {

                    if (home != null) {
                        // read home.mm
                        homeMm = home.mm;
                    }
                    updateRegistration(9, homeMm);


                    if (homeMm != null) {
                        // read home.mm.get()
                        homeMmGet = homeMm.get();
                    }
            }
            if ((dirtyFlags & 0xc0400L) != 0) {

                    if (home != null) {
                        // read home.pay
                        homePay = home.pay;
                    }
                    updateRegistration(10, homePay);


                    if (homePay != null) {
                        // read home.pay.get()
                        homePayGet = homePay.get();
                    }
            }
            if ((dirtyFlags & 0xc0800L) != 0) {

                    if (home != null) {
                        // read home.remaining
                        homeRemaining = home.remaining;
                    }
                    updateRegistration(11, homeRemaining);


                    if (homeRemaining != null) {
                        // read home.remaining.get()
                        homeRemainingGet = homeRemaining.get();
                    }
            }
            if ((dirtyFlags & 0xc1000L) != 0) {

                    if (home != null) {
                        // read home.cash
                        homeCash = home.cash;
                    }
                    updateRegistration(12, homeCash);


                    if (homeCash != null) {
                        // read home.cash.get()
                        homeCashGet = homeCash.get();
                    }
            }
            if ((dirtyFlags & 0xc2000L) != 0) {

                    if (home != null) {
                        // read home.fullrecov
                        homeFullrecov = home.fullrecov;
                    }
                    updateRegistration(13, homeFullrecov);


                    if (homeFullrecov != null) {
                        // read home.fullrecov.get()
                        homeFullrecovGet = homeFullrecov.get();
                    }
            }
            if ((dirtyFlags & 0xc4000L) != 0) {

                    if (home != null) {
                        // read home.recov
                        homeRecov = home.recov;
                    }
                    updateRegistration(14, homeRecov);


                    if (homeRecov != null) {
                        // read home.recov.get()
                        homeRecovGet = homeRecov.get();
                    }
            }
            if ((dirtyFlags & 0xc8000L) != 0) {

                    if (home != null) {
                        // read home.salessub
                        homeSalessub = home.salessub;
                    }
                    updateRegistration(15, homeSalessub);


                    if (homeSalessub != null) {
                        // read home.salessub.get()
                        homeSalessubGet = homeSalessub.get();
                    }
            }
            if ((dirtyFlags & 0xd0000L) != 0) {

                    if (home != null) {
                        // read home.salesserved
                        homeSalesserved = home.salesserved;
                    }
                    updateRegistration(16, homeSalesserved);


                    if (homeSalesserved != null) {
                        // read home.salesserved.get()
                        homeSalesservedGet = homeSalesserved.get();
                    }
            }
            if ((dirtyFlags & 0xe0000L) != 0) {

                    if (home != null) {
                        // read home.ba
                        homeBa = home.ba;
                    }
                    updateRegistration(17, homeBa);


                    if (homeBa != null) {
                        // read home.ba.get()
                        homeBaGet = homeBa.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xc0004L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.declarationDebtors, homeDecservedGet);
        }
        if ((dirtyFlags & 0x80000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.declarationDebtors, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, declarationDebtorsandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.declarationExpected, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, declarationExpectedandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.declarationOwing, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, declarationOwingandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.declarationRedeemed, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, declarationRedeemedandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.salestranBarter, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, salestranBarterandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.salestranCash, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, salestranCashandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.salestranFarmerserved, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, salestranFarmerservedandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.salestranMm, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, salestranMmandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.salestranNonsubsidized, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, salestranNonsubsidizedandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.salestranRevenue, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, salestranRevenueandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.salestranSubsidized, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, salestranSubsidizedandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.scaletranBagsowing, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, scaletranBagsowingandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.scaletranFarmerserved, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, scaletranFarmerservedandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.scaletranMc, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, scaletranMcandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.scaletranPurchase, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, scaletranPurchaseandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.scaletranRecovery, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, scaletranRecoveryandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.scaletranWeight, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, scaletranWeightandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.scaletranYield, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, scaletranYieldandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xc0400L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.declarationExpected, homePayGet);
        }
        if ((dirtyFlags & 0xc0020L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.declarationOwing, homeOwingGet);
        }
        if ((dirtyFlags & 0xc2000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.declarationRedeemed, homeFullrecovGet);
        }
        if ((dirtyFlags & 0xe0000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.salestranBarter, homeBaGet);
        }
        if ((dirtyFlags & 0xc1000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.salestranCash, homeCashGet);
        }
        if ((dirtyFlags & 0xd0000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.salestranFarmerserved, homeSalesservedGet);
        }
        if ((dirtyFlags & 0xc0200L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.salestranMm, homeMmGet);
        }
        if ((dirtyFlags & 0xc0040L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.salestranNonsubsidized, homeSalesnsubGet);
        }
        if ((dirtyFlags & 0xc0100L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.salestranRevenue, homeRevenueGet);
        }
        if ((dirtyFlags & 0xc8000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.salestranSubsidized, homeSalessubGet);
        }
        if ((dirtyFlags & 0xc0800L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.scaletranBagsowing, homeRemainingGet);
        }
        if ((dirtyFlags & 0xc0002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.scaletranFarmerserved, homeScaleservedGet);
        }
        if ((dirtyFlags & 0xc0080L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.scaletranMc, homeAvemoistGet);
        }
        if ((dirtyFlags & 0xc0010L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.scaletranPurchase, homeTotalpurchaseGet);
        }
        if ((dirtyFlags & 0xc4000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.scaletranRecovery, homeRecovGet);
        }
        if ((dirtyFlags & 0xc0008L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.scaletranWeight, homeExrecovGet);
        }
        if ((dirtyFlags & 0xc0001L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.scaletranYield, homeTopidGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): home.topid
        flag 1 (0x2L): home.scaleserved
        flag 2 (0x3L): home.decserved
        flag 3 (0x4L): home.exrecov
        flag 4 (0x5L): home.totalpurchase
        flag 5 (0x6L): home.owing
        flag 6 (0x7L): home.salesnsub
        flag 7 (0x8L): home.avemoist
        flag 8 (0x9L): home.revenue
        flag 9 (0xaL): home.mm
        flag 10 (0xbL): home.pay
        flag 11 (0xcL): home.remaining
        flag 12 (0xdL): home.cash
        flag 13 (0xeL): home.fullrecov
        flag 14 (0xfL): home.recov
        flag 15 (0x10L): home.salessub
        flag 16 (0x11L): home.salesserved
        flag 17 (0x12L): home.ba
        flag 18 (0x13L): home
        flag 19 (0x14L): null
    flag mapping end*/
    //end
}