package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ContentExportFarmersAssignedAggBinding extends ViewDataBinding {
  @NonNull
  public final TextView headerText;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final LinearLayout progressContainer;

  @NonNull
  public final TextView progressText;

  @NonNull
  public final RecyclerView recyclerView;

  protected ContentExportFarmersAssignedAggBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, TextView headerText, ProgressBar progressBar,
      LinearLayout progressContainer, TextView progressText, RecyclerView recyclerView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.headerText = headerText;
    this.progressBar = progressBar;
    this.progressContainer = progressContainer;
    this.progressText = progressText;
    this.recyclerView = recyclerView;
  }

  @NonNull
  public static ContentExportFarmersAssignedAggBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentExportFarmersAssignedAggBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentExportFarmersAssignedAggBinding>inflate(inflater, com.telpo.usb.finger.R.layout.content_export_farmers_assigned_agg, root, attachToRoot, component);
  }

  @NonNull
  public static ContentExportFarmersAssignedAggBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentExportFarmersAssignedAggBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentExportFarmersAssignedAggBinding>inflate(inflater, com.telpo.usb.finger.R.layout.content_export_farmers_assigned_agg, null, false, component);
  }

  public static ContentExportFarmersAssignedAggBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentExportFarmersAssignedAggBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentExportFarmersAssignedAggBinding)bind(component, view, com.telpo.usb.finger.R.layout.content_export_farmers_assigned_agg);
  }
}
