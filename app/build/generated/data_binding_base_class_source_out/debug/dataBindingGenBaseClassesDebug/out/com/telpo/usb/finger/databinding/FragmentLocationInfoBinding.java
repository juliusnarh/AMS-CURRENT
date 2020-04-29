package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public abstract class FragmentLocationInfoBinding extends ViewDataBinding {
  @NonNull
  public final TabLayout tabs;

  @NonNull
  public final ViewPager viewpager;

  protected FragmentLocationInfoBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TabLayout tabs, ViewPager viewpager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tabs = tabs;
    this.viewpager = viewpager;
  }

  @NonNull
  public static FragmentLocationInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentLocationInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentLocationInfoBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_location_info, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentLocationInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentLocationInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentLocationInfoBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_location_info, null, false, component);
  }

  public static FragmentLocationInfoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentLocationInfoBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentLocationInfoBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_location_info);
  }
}
