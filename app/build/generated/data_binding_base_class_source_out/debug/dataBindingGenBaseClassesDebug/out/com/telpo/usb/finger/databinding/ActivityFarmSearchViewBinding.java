package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class ActivityFarmSearchViewBinding extends ViewDataBinding {
  @NonNull
  public final NavigationTabStrip ntsBottom;

  @NonNull
  public final FloatingActionButton search;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final ViewPager viewpager;

  protected ActivityFarmSearchViewBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, NavigationTabStrip ntsBottom, FloatingActionButton search,
      Toolbar toolbar, ViewPager viewpager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ntsBottom = ntsBottom;
    this.search = search;
    this.toolbar = toolbar;
    this.viewpager = viewpager;
  }

  @NonNull
  public static ActivityFarmSearchViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmSearchViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmSearchViewBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farm_search_view, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFarmSearchViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmSearchViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmSearchViewBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farm_search_view, null, false, component);
  }

  public static ActivityFarmSearchViewBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFarmSearchViewBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFarmSearchViewBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_farm_search_view);
  }
}
