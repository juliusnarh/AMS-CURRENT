package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ContentFarmerSearchAggregatorBinding extends ViewDataBinding {
  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final TextView searchCount;

  protected ContentFarmerSearchAggregatorBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ProgressBar progressBar, RecyclerView recyclerView,
      TextView searchCount) {
    super(_bindingComponent, _root, _localFieldCount);
    this.progressBar = progressBar;
    this.recyclerView = recyclerView;
    this.searchCount = searchCount;
  }

  @NonNull
  public static ContentFarmerSearchAggregatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentFarmerSearchAggregatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentFarmerSearchAggregatorBinding>inflate(inflater, com.telpo.usb.finger.R.layout.content_farmer_search_aggregator, root, attachToRoot, component);
  }

  @NonNull
  public static ContentFarmerSearchAggregatorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentFarmerSearchAggregatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentFarmerSearchAggregatorBinding>inflate(inflater, com.telpo.usb.finger.R.layout.content_farmer_search_aggregator, null, false, component);
  }

  public static ContentFarmerSearchAggregatorBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentFarmerSearchAggregatorBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentFarmerSearchAggregatorBinding)bind(component, view, com.telpo.usb.finger.R.layout.content_farmer_search_aggregator);
  }
}
