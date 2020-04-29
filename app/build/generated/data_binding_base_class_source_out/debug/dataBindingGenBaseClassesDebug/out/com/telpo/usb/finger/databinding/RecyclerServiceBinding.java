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
import androidx.recyclerview.widget.RecyclerView;

public abstract class RecyclerServiceBinding extends ViewDataBinding {
  @NonNull
  public final TextView noService;

  @NonNull
  public final RecyclerView serviceRecycler;

  protected RecyclerServiceBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView noService, RecyclerView serviceRecycler) {
    super(_bindingComponent, _root, _localFieldCount);
    this.noService = noService;
    this.serviceRecycler = serviceRecycler;
  }

  @NonNull
  public static RecyclerServiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static RecyclerServiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<RecyclerServiceBinding>inflate(inflater, com.telpo.usb.finger.R.layout.recycler_service, root, attachToRoot, component);
  }

  @NonNull
  public static RecyclerServiceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static RecyclerServiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<RecyclerServiceBinding>inflate(inflater, com.telpo.usb.finger.R.layout.recycler_service, null, false, component);
  }

  public static RecyclerServiceBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static RecyclerServiceBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (RecyclerServiceBinding)bind(component, view, com.telpo.usb.finger.R.layout.recycler_service);
  }
}
