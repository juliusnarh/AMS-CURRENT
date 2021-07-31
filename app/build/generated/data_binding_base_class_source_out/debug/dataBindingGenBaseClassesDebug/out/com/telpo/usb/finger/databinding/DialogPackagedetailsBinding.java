package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class DialogPackagedetailsBinding extends ViewDataBinding {
  @NonNull
  public final ImageView close;

  @NonNull
  public final TextView noofitems;

  @NonNull
  public final TextView packageid;

  @NonNull
  public final TextView packname;

  @NonNull
  public final RecyclerView recycler;

  protected DialogPackagedetailsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView close, TextView noofitems, TextView packageid,
      TextView packname, RecyclerView recycler) {
    super(_bindingComponent, _root, _localFieldCount);
    this.close = close;
    this.noofitems = noofitems;
    this.packageid = packageid;
    this.packname = packname;
    this.recycler = recycler;
  }

  @NonNull
  public static DialogPackagedetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogPackagedetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogPackagedetailsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.dialog_packagedetails, root, attachToRoot, component);
  }

  @NonNull
  public static DialogPackagedetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogPackagedetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogPackagedetailsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.dialog_packagedetails, null, false, component);
  }

  public static DialogPackagedetailsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogPackagedetailsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogPackagedetailsBinding)bind(component, view, com.telpo.usb.finger.R.layout.dialog_packagedetails);
  }
}
