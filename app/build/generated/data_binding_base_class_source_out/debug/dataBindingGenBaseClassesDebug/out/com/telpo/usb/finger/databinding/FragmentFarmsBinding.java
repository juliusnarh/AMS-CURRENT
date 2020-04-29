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

public abstract class FragmentFarmsBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView recycler;

  protected FragmentFarmsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView recycler) {
    super(_bindingComponent, _root, _localFieldCount);
    this.recycler = recycler;
  }

  @NonNull
  public static FragmentFarmsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFarmsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFarmsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_farms, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFarmsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFarmsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFarmsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_farms, null, false, component);
  }

  public static FragmentFarmsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentFarmsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentFarmsBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_farms);
  }
}
