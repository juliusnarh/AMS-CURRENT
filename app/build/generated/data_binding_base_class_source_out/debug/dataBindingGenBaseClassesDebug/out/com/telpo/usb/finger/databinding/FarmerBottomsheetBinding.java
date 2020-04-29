package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FarmerBottomsheetBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout alltransactions;

  @NonNull
  public final LinearLayout assignToAggregator;

  @NonNull
  public final TextView content;

  @NonNull
  public final LinearLayout distribution;

  @NonNull
  public final LinearLayout extservices;

  @NonNull
  public final LinearLayout farmassessment;

  @NonNull
  public final LinearLayout farmerBs;

  @NonNull
  public final LinearLayout profile;

  @NonNull
  public final LinearLayout purchases;

  @NonNull
  public final LinearLayout recovery;

  protected FarmerBottomsheetBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout alltransactions, LinearLayout assignToAggregator,
      TextView content, LinearLayout distribution, LinearLayout extservices,
      LinearLayout farmassessment, LinearLayout farmerBs, LinearLayout profile,
      LinearLayout purchases, LinearLayout recovery) {
    super(_bindingComponent, _root, _localFieldCount);
    this.alltransactions = alltransactions;
    this.assignToAggregator = assignToAggregator;
    this.content = content;
    this.distribution = distribution;
    this.extservices = extservices;
    this.farmassessment = farmassessment;
    this.farmerBs = farmerBs;
    this.profile = profile;
    this.purchases = purchases;
    this.recovery = recovery;
  }

  @NonNull
  public static FarmerBottomsheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FarmerBottomsheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FarmerBottomsheetBinding>inflate(inflater, com.telpo.usb.finger.R.layout.farmer_bottomsheet, root, attachToRoot, component);
  }

  @NonNull
  public static FarmerBottomsheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FarmerBottomsheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FarmerBottomsheetBinding>inflate(inflater, com.telpo.usb.finger.R.layout.farmer_bottomsheet, null, false, component);
  }

  public static FarmerBottomsheetBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FarmerBottomsheetBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FarmerBottomsheetBinding)bind(component, view, com.telpo.usb.finger.R.layout.farmer_bottomsheet);
  }
}
