package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class HouseholdSearchActivityBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView hseholdrecycler;

  @NonNull
  public final Toolbar toolbar;

  protected HouseholdSearchActivityBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView hseholdrecycler, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.hseholdrecycler = hseholdrecycler;
    this.toolbar = toolbar;
  }

  @NonNull
  public static HouseholdSearchActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static HouseholdSearchActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<HouseholdSearchActivityBinding>inflate(inflater, com.telpo.usb.finger.R.layout.household_search_activity, root, attachToRoot, component);
  }

  @NonNull
  public static HouseholdSearchActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static HouseholdSearchActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<HouseholdSearchActivityBinding>inflate(inflater, com.telpo.usb.finger.R.layout.household_search_activity, null, false, component);
  }

  public static HouseholdSearchActivityBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static HouseholdSearchActivityBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (HouseholdSearchActivityBinding)bind(component, view, com.telpo.usb.finger.R.layout.household_search_activity);
  }
}
