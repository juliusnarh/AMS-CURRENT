package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.telpo.usb.finger.pojo.FarmGeoInfo;

public abstract class FarmDataBinding extends ViewDataBinding {
  @NonNull
  public final Button editfarmgeoaddr;

  @NonNull
  public final ImageView farmedit;

  @Bindable
  protected FarmGeoInfo mFarmgeo;

  protected FarmDataBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button editfarmgeoaddr, ImageView farmedit) {
    super(_bindingComponent, _root, _localFieldCount);
    this.editfarmgeoaddr = editfarmgeoaddr;
    this.farmedit = farmedit;
  }

  public abstract void setFarmgeo(@Nullable FarmGeoInfo farmgeo);

  @Nullable
  public FarmGeoInfo getFarmgeo() {
    return mFarmgeo;
  }

  @NonNull
  public static FarmDataBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FarmDataBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FarmDataBinding>inflate(inflater, com.telpo.usb.finger.R.layout.farm_item_layout, root, attachToRoot, component);
  }

  @NonNull
  public static FarmDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FarmDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FarmDataBinding>inflate(inflater, com.telpo.usb.finger.R.layout.farm_item_layout, null, false, component);
  }

  public static FarmDataBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FarmDataBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (FarmDataBinding)bind(component, view, com.telpo.usb.finger.R.layout.farm_item_layout);
  }
}
