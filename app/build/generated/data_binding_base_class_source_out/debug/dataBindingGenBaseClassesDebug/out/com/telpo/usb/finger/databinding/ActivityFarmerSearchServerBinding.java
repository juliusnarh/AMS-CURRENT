package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.arlib.floatingsearchview.FloatingSearchView;

public abstract class ActivityFarmerSearchServerBinding extends ViewDataBinding {
  @NonNull
  public final ContentRemoteSearchBinding content;

  @NonNull
  public final FloatingSearchView floatingSearchView;

  @NonNull
  public final CoordinatorLayout parentView;

  protected ActivityFarmerSearchServerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ContentRemoteSearchBinding content,
      FloatingSearchView floatingSearchView, CoordinatorLayout parentView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    setContainedBinding(this.content);;
    this.floatingSearchView = floatingSearchView;
    this.parentView = parentView;
  }

  @NonNull
  public static ActivityFarmerSearchServerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmerSearchServerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmerSearchServerBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farmer_search_server, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFarmerSearchServerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmerSearchServerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmerSearchServerBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farmer_search_server, null, false, component);
  }

  public static ActivityFarmerSearchServerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFarmerSearchServerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFarmerSearchServerBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_farmer_search_server);
  }
}
