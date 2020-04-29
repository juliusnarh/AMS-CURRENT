package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public abstract class FarmerProfileFragmentBinding extends ViewDataBinding {
  @NonNull
  public final ImageView home;

  @NonNull
  public final PhotoHeaderBinding photoHeader;

  @NonNull
  public final TabLayout tabs;

  @NonNull
  public final ViewPager viewpager;

  protected FarmerProfileFragmentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView home, PhotoHeaderBinding photoHeader, TabLayout tabs,
      ViewPager viewpager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.home = home;
    this.photoHeader = photoHeader;
    setContainedBinding(this.photoHeader);;
    this.tabs = tabs;
    this.viewpager = viewpager;
  }

  @NonNull
  public static FarmerProfileFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FarmerProfileFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FarmerProfileFragmentBinding>inflate(inflater, com.telpo.usb.finger.R.layout.farmer_profile_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static FarmerProfileFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FarmerProfileFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FarmerProfileFragmentBinding>inflate(inflater, com.telpo.usb.finger.R.layout.farmer_profile_fragment, null, false, component);
  }

  public static FarmerProfileFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FarmerProfileFragmentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FarmerProfileFragmentBinding)bind(component, view, com.telpo.usb.finger.R.layout.farmer_profile_fragment);
  }
}
