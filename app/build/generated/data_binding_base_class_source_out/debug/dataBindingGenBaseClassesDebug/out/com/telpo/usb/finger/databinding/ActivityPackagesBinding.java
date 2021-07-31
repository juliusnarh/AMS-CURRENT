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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class ActivityPackagesBinding extends ViewDataBinding {
  @NonNull
  public final ContentPackagesBinding content;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final Toolbar toolbar;

  protected ActivityPackagesBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ContentPackagesBinding content, FloatingActionButton fab,
      Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    setContainedBinding(this.content);;
    this.fab = fab;
    this.toolbar = toolbar;
  }

  @NonNull
  public static ActivityPackagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPackagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPackagesBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_packages, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPackagesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityPackagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityPackagesBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_packages, null, false, component);
  }

  public static ActivityPackagesBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityPackagesBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityPackagesBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_packages);
  }
}
