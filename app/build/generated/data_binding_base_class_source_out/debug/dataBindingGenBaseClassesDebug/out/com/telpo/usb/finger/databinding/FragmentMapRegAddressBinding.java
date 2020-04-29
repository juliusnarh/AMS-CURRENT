package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.telpo.usb.finger.pojo.ResidentialAddress;

public abstract class FragmentMapRegAddressBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout mapaddrlayout;

  @NonNull
  public final Button maprefresh;

  @Bindable
  protected ResidentialAddress mResaddr;

  protected FragmentMapRegAddressBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout mapaddrlayout, Button maprefresh) {
    super(_bindingComponent, _root, _localFieldCount);
    this.mapaddrlayout = mapaddrlayout;
    this.maprefresh = maprefresh;
  }

  public abstract void setResaddr(@Nullable ResidentialAddress resaddr);

  @Nullable
  public ResidentialAddress getResaddr() {
    return mResaddr;
  }

  @NonNull
  public static FragmentMapRegAddressBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMapRegAddressBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMapRegAddressBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_map_reg_address, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMapRegAddressBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMapRegAddressBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMapRegAddressBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_map_reg_address, null, false, component);
  }

  public static FragmentMapRegAddressBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMapRegAddressBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMapRegAddressBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_map_reg_address);
  }
}
