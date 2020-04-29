package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ActivityAggregatorTestBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView recycler;

  protected ActivityAggregatorTestBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView recycler) {
    super(_bindingComponent, _root, _localFieldCount);
    this.recycler = recycler;
  }

  @NonNull
  public static ActivityAggregatorTestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAggregatorTestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAggregatorTestBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_aggregator_test, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAggregatorTestBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAggregatorTestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAggregatorTestBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_aggregator_test, null, false, component);
  }

  public static ActivityAggregatorTestBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityAggregatorTestBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityAggregatorTestBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_aggregator_test);
  }
}
