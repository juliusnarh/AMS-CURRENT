package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo;

public abstract class FragmentHomeBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout container;

  @NonNull
  public final CardView declarationCard;

  @NonNull
  public final TextView declarationDebtors;

  @NonNull
  public final TextView declarationExpected;

  @NonNull
  public final TextView declarationOwing;

  @NonNull
  public final TextView declarationRedeemed;

  @NonNull
  public final RecyclerView inputdealerRecycler;

  @NonNull
  public final TextView norecord;

  @NonNull
  public final TextView norecord2;

  @NonNull
  public final RecyclerView personalRecycler;

  @NonNull
  public final TextView salestranBarter;

  @NonNull
  public final CardView salestranCard;

  @NonNull
  public final TextView salestranCash;

  @NonNull
  public final TextView salestranFarmerserved;

  @NonNull
  public final TextView salestranMm;

  @NonNull
  public final TextView salestranNonsubsidized;

  @NonNull
  public final TextView salestranRevenue;

  @NonNull
  public final TextView salestranSubsidized;

  @NonNull
  public final TextView scaletranBagsowing;

  @NonNull
  public final CardView scaletranCard;

  @NonNull
  public final TextView scaletranFarmerserved;

  @NonNull
  public final TextView scaletranMc;

  @NonNull
  public final TextView scaletranPurchase;

  @NonNull
  public final TextView scaletranRecovery;

  @NonNull
  public final TextView scaletranWeight;

  @NonNull
  public final TextView scaletranYield;

  @NonNull
  public final CardView serviceCard;

  @NonNull
  public final TextView servicenorecord;

  @NonNull
  public final RecyclerView servicesummaryRecycler;

  @NonNull
  public final LinearLayout yield;

  @Bindable
  protected HomePojo mHome;

  protected FragmentHomeBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FrameLayout container, CardView declarationCard,
      TextView declarationDebtors, TextView declarationExpected, TextView declarationOwing,
      TextView declarationRedeemed, RecyclerView inputdealerRecycler, TextView norecord,
      TextView norecord2, RecyclerView personalRecycler, TextView salestranBarter,
      CardView salestranCard, TextView salestranCash, TextView salestranFarmerserved,
      TextView salestranMm, TextView salestranNonsubsidized, TextView salestranRevenue,
      TextView salestranSubsidized, TextView scaletranBagsowing, CardView scaletranCard,
      TextView scaletranFarmerserved, TextView scaletranMc, TextView scaletranPurchase,
      TextView scaletranRecovery, TextView scaletranWeight, TextView scaletranYield,
      CardView serviceCard, TextView servicenorecord, RecyclerView servicesummaryRecycler,
      LinearLayout yield) {
    super(_bindingComponent, _root, _localFieldCount);
    this.container = container;
    this.declarationCard = declarationCard;
    this.declarationDebtors = declarationDebtors;
    this.declarationExpected = declarationExpected;
    this.declarationOwing = declarationOwing;
    this.declarationRedeemed = declarationRedeemed;
    this.inputdealerRecycler = inputdealerRecycler;
    this.norecord = norecord;
    this.norecord2 = norecord2;
    this.personalRecycler = personalRecycler;
    this.salestranBarter = salestranBarter;
    this.salestranCard = salestranCard;
    this.salestranCash = salestranCash;
    this.salestranFarmerserved = salestranFarmerserved;
    this.salestranMm = salestranMm;
    this.salestranNonsubsidized = salestranNonsubsidized;
    this.salestranRevenue = salestranRevenue;
    this.salestranSubsidized = salestranSubsidized;
    this.scaletranBagsowing = scaletranBagsowing;
    this.scaletranCard = scaletranCard;
    this.scaletranFarmerserved = scaletranFarmerserved;
    this.scaletranMc = scaletranMc;
    this.scaletranPurchase = scaletranPurchase;
    this.scaletranRecovery = scaletranRecovery;
    this.scaletranWeight = scaletranWeight;
    this.scaletranYield = scaletranYield;
    this.serviceCard = serviceCard;
    this.servicenorecord = servicenorecord;
    this.servicesummaryRecycler = servicesummaryRecycler;
    this.yield = yield;
  }

  public abstract void setHome(@Nullable HomePojo home);

  @Nullable
  public HomePojo getHome() {
    return mHome;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentHomeBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_home, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentHomeBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_home, null, false, component);
  }

  public static FragmentHomeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentHomeBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentHomeBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_home);
  }
}
