package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class ActivityAgentBinding extends ViewDataBinding {
  @NonNull
  public final AHBottomNavigation bottomNavigation;

  @NonNull
  public final CoordinatorLayout coordinator;

  @NonNull
  public final FloatingActionButton floatingActionButton;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final AHBottomNavigationViewPager viewPager;

  protected ActivityAgentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, AHBottomNavigation bottomNavigation, CoordinatorLayout coordinator,
      FloatingActionButton floatingActionButton, Toolbar toolbar,
      AHBottomNavigationViewPager viewPager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomNavigation = bottomNavigation;
    this.coordinator = coordinator;
    this.floatingActionButton = floatingActionButton;
    this.toolbar = toolbar;
    this.viewPager = viewPager;
  }

  @NonNull
  public static ActivityAgentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAgentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAgentBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_agent, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAgentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAgentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAgentBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_agent, null, false, component);
  }

  public static ActivityAgentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityAgentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityAgentBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_agent);
  }
}
