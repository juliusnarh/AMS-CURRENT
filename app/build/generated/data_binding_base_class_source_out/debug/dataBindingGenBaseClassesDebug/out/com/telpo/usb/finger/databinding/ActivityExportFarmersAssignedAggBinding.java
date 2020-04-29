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

public abstract class ActivityExportFarmersAssignedAggBinding extends ViewDataBinding {
  @NonNull
  public final ContentExportFarmersAssignedAggBinding content;

  @NonNull
  public final CoordinatorLayout parentView;

  @NonNull
  public final Toolbar toolbar;

  protected ActivityExportFarmersAssignedAggBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, ContentExportFarmersAssignedAggBinding content,
      CoordinatorLayout parentView, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    setContainedBinding(this.content);;
    this.parentView = parentView;
    this.toolbar = toolbar;
  }

  @NonNull
  public static ActivityExportFarmersAssignedAggBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityExportFarmersAssignedAggBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityExportFarmersAssignedAggBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_export_farmers_assigned_agg, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityExportFarmersAssignedAggBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityExportFarmersAssignedAggBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityExportFarmersAssignedAggBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_export_farmers_assigned_agg, null, false, component);
  }

  public static ActivityExportFarmersAssignedAggBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityExportFarmersAssignedAggBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityExportFarmersAssignedAggBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_export_farmers_assigned_agg);
  }
}
