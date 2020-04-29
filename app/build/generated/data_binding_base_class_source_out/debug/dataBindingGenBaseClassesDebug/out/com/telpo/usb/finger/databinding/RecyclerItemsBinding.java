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

public abstract class RecyclerItemsBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView itemsRecycler;

  @NonNull
  public final TextView noItem;

  protected RecyclerItemsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView itemsRecycler, TextView noItem) {
    super(_bindingComponent, _root, _localFieldCount);
    this.itemsRecycler = itemsRecycler;
    this.noItem = noItem;
  }

  @NonNull
  public static RecyclerItemsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static RecyclerItemsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<RecyclerItemsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.recycler_items, root, attachToRoot, component);
  }

  @NonNull
  public static RecyclerItemsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static RecyclerItemsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<RecyclerItemsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.recycler_items, null, false, component);
  }

  public static RecyclerItemsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static RecyclerItemsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (RecyclerItemsBinding)bind(component, view, com.telpo.usb.finger.R.layout.recycler_items);
  }
}
