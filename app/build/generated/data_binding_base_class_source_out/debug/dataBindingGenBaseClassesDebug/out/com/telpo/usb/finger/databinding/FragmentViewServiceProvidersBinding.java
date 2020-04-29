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

public abstract class FragmentViewServiceProvidersBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView recycler;

  protected FragmentViewServiceProvidersBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView recycler) {
    super(_bindingComponent, _root, _localFieldCount);
    this.recycler = recycler;
  }

  @NonNull
  public static FragmentViewServiceProvidersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentViewServiceProvidersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentViewServiceProvidersBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_view_service_providers, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentViewServiceProvidersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentViewServiceProvidersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentViewServiceProvidersBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_view_service_providers, null, false, component);
  }

  public static FragmentViewServiceProvidersBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentViewServiceProvidersBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentViewServiceProvidersBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_view_service_providers);
  }
}
