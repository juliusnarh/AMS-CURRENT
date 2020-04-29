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
import androidx.recyclerview.widget.RecyclerView;

public abstract class FarmerSearchAggBottomsheetBinding extends ViewDataBinding {
  @NonNull
  public final TextView content;

  @NonNull
  public final LinearLayout farmerBs;

  @NonNull
  public final TextView noRecord;

  @NonNull
  public final RecyclerView recyclerView;

  protected FarmerSearchAggBottomsheetBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView content, LinearLayout farmerBs, TextView noRecord,
      RecyclerView recyclerView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    this.farmerBs = farmerBs;
    this.noRecord = noRecord;
    this.recyclerView = recyclerView;
  }

  @NonNull
  public static FarmerSearchAggBottomsheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FarmerSearchAggBottomsheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FarmerSearchAggBottomsheetBinding>inflate(inflater, com.telpo.usb.finger.R.layout.farmer_search_agg_bottomsheet, root, attachToRoot, component);
  }

  @NonNull
  public static FarmerSearchAggBottomsheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FarmerSearchAggBottomsheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FarmerSearchAggBottomsheetBinding>inflate(inflater, com.telpo.usb.finger.R.layout.farmer_search_agg_bottomsheet, null, false, component);
  }

  public static FarmerSearchAggBottomsheetBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FarmerSearchAggBottomsheetBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FarmerSearchAggBottomsheetBinding)bind(component, view, com.telpo.usb.finger.R.layout.farmer_search_agg_bottomsheet);
  }
}
