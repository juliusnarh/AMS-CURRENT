package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class ActivityResidentialMapBinding extends ViewDataBinding {
  @NonNull
  public final TextView addresssResults;

  @NonNull
  public final FloatingActionButton btndirection;

  @NonNull
  public final FloatingActionButton btngeocode;

  @NonNull
  public final FloatingActionButton btnmylocation;

  @NonNull
  public final FloatingActionButton btnsave;

  @NonNull
  public final TextView coords;

  protected ActivityResidentialMapBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView addresssResults, FloatingActionButton btndirection,
      FloatingActionButton btngeocode, FloatingActionButton btnmylocation,
      FloatingActionButton btnsave, TextView coords) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addresssResults = addresssResults;
    this.btndirection = btndirection;
    this.btngeocode = btngeocode;
    this.btnmylocation = btnmylocation;
    this.btnsave = btnsave;
    this.coords = coords;
  }

  @NonNull
  public static ActivityResidentialMapBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityResidentialMapBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityResidentialMapBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_residential_map, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityResidentialMapBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityResidentialMapBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityResidentialMapBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_residential_map, null, false, component);
  }

  public static ActivityResidentialMapBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityResidentialMapBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityResidentialMapBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_residential_map);
  }
}
