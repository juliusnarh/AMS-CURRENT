package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentActionsBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout addproduct;

  @NonNull
  public final LinearLayout addservice;

  @NonNull
  public final LinearLayout addserviceprovider;

  @NonNull
  public final LinearLayout addservicetype;

  @NonNull
  public final LinearLayout backupdata;

  @NonNull
  public final FrameLayout container;

  @NonNull
  public final View forservice;

  @NonNull
  public final View forservice2;

  @NonNull
  public final LinearLayout manageserviceproviders;

  @NonNull
  public final LinearLayout manageservicetype;

  @NonNull
  public final LinearLayout searchfarmer;

  @NonNull
  public final TextView synced;

  @NonNull
  public final LinearLayout syncfiles;

  @NonNull
  public final LinearLayout viewEditServiceprovider;

  @NonNull
  public final LinearLayout viewEditServicetype;

  protected FragmentActionsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout addproduct, LinearLayout addservice,
      LinearLayout addserviceprovider, LinearLayout addservicetype, LinearLayout backupdata,
      FrameLayout container, View forservice, View forservice2, LinearLayout manageserviceproviders,
      LinearLayout manageservicetype, LinearLayout searchfarmer, TextView synced,
      LinearLayout syncfiles, LinearLayout viewEditServiceprovider,
      LinearLayout viewEditServicetype) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addproduct = addproduct;
    this.addservice = addservice;
    this.addserviceprovider = addserviceprovider;
    this.addservicetype = addservicetype;
    this.backupdata = backupdata;
    this.container = container;
    this.forservice = forservice;
    this.forservice2 = forservice2;
    this.manageserviceproviders = manageserviceproviders;
    this.manageservicetype = manageservicetype;
    this.searchfarmer = searchfarmer;
    this.synced = synced;
    this.syncfiles = syncfiles;
    this.viewEditServiceprovider = viewEditServiceprovider;
    this.viewEditServicetype = viewEditServicetype;
  }

  @NonNull
  public static FragmentActionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentActionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentActionsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_actions, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentActionsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentActionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentActionsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_actions, null, false, component);
  }

  public static FragmentActionsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentActionsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentActionsBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_actions);
  }
}
