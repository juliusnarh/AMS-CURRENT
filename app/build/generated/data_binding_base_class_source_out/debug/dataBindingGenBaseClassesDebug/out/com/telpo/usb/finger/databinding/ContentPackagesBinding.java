package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ContentPackagesBinding extends ViewDataBinding {
  @NonNull
  public final Button addgovernmentpack;

  @NonNull
  public final ImageView hidegovpackage;

  @NonNull
  public final RelativeLayout ll;

  @NonNull
  public final RecyclerView recycler;

  protected ContentPackagesBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button addgovernmentpack, ImageView hidegovpackage, RelativeLayout ll,
      RecyclerView recycler) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addgovernmentpack = addgovernmentpack;
    this.hidegovpackage = hidegovpackage;
    this.ll = ll;
    this.recycler = recycler;
  }

  @NonNull
  public static ContentPackagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentPackagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentPackagesBinding>inflate(inflater, com.telpo.usb.finger.R.layout.content_packages, root, attachToRoot, component);
  }

  @NonNull
  public static ContentPackagesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentPackagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentPackagesBinding>inflate(inflater, com.telpo.usb.finger.R.layout.content_packages, null, false, component);
  }

  public static ContentPackagesBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentPackagesBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentPackagesBinding)bind(component, view, com.telpo.usb.finger.R.layout.content_packages);
  }
}
