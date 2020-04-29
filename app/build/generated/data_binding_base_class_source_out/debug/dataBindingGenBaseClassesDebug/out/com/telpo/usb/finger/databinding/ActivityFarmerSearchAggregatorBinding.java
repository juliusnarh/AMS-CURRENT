package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.arlib.floatingsearchview.FloatingSearchView;

public abstract class ActivityFarmerSearchAggregatorBinding extends ViewDataBinding {
  @NonNull
  public final ContentFarmerSearchAggregatorBinding content;

  @NonNull
  public final FloatingSearchView floatingSearchView;

  @NonNull
  public final CoordinatorLayout parentView;

  protected ActivityFarmerSearchAggregatorBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, ContentFarmerSearchAggregatorBinding content,
      FloatingSearchView floatingSearchView, CoordinatorLayout parentView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    setContainedBinding(this.content);;
    this.floatingSearchView = floatingSearchView;
    this.parentView = parentView;
  }

  @NonNull
  public static ActivityFarmerSearchAggregatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmerSearchAggregatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmerSearchAggregatorBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farmer_search_aggregator, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFarmerSearchAggregatorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmerSearchAggregatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmerSearchAggregatorBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farmer_search_aggregator, null, false, component);
  }

  public static ActivityFarmerSearchAggregatorBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFarmerSearchAggregatorBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFarmerSearchAggregatorBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_farmer_search_aggregator);
  }
}
