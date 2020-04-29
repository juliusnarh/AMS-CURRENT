package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.telpo.usb.finger.pojo.ActivityInfoPojo;

public abstract class FragmentEditActivityProfileBinding extends ViewDataBinding {
  @NonNull
  public final SwitchCompat boolcincome;

  @NonNull
  public final SwitchCompat boolcopgrp;

  @NonNull
  public final SwitchCompat boolgrpm;

  @NonNull
  public final SwitchCompat boolspe;

  @NonNull
  public final Button btnsave;

  @NonNull
  public final TextInputEditText certification;

  @NonNull
  public final TextInputLayout certificationLayout;

  @NonNull
  public final Button close;

  @NonNull
  public final TextInputLayout cocoaincomLayout;

  @NonNull
  public final TextInputEditText cocoaincome;

  @NonNull
  public final TextInputEditText cooperativegroup;

  @NonNull
  public final TextInputLayout cooperativegroupLayout;

  @NonNull
  public final TextInputEditText farminggroup;

  @NonNull
  public final TextInputLayout farminggroupLayout;

  @NonNull
  public final TextInputEditText fundingsource;

  @NonNull
  public final TextInputLayout fundingsourceLayout;

  @NonNull
  public final TextInputEditText specialtycocoa;

  @NonNull
  public final TextInputLayout specialtycocoaLayout;

  @Bindable
  protected ActivityInfoPojo mActivity;

  protected FragmentEditActivityProfileBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, SwitchCompat boolcincome, SwitchCompat boolcopgrp,
      SwitchCompat boolgrpm, SwitchCompat boolspe, Button btnsave, TextInputEditText certification,
      TextInputLayout certificationLayout, Button close, TextInputLayout cocoaincomLayout,
      TextInputEditText cocoaincome, TextInputEditText cooperativegroup,
      TextInputLayout cooperativegroupLayout, TextInputEditText farminggroup,
      TextInputLayout farminggroupLayout, TextInputEditText fundingsource,
      TextInputLayout fundingsourceLayout, TextInputEditText specialtycocoa,
      TextInputLayout specialtycocoaLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.boolcincome = boolcincome;
    this.boolcopgrp = boolcopgrp;
    this.boolgrpm = boolgrpm;
    this.boolspe = boolspe;
    this.btnsave = btnsave;
    this.certification = certification;
    this.certificationLayout = certificationLayout;
    this.close = close;
    this.cocoaincomLayout = cocoaincomLayout;
    this.cocoaincome = cocoaincome;
    this.cooperativegroup = cooperativegroup;
    this.cooperativegroupLayout = cooperativegroupLayout;
    this.farminggroup = farminggroup;
    this.farminggroupLayout = farminggroupLayout;
    this.fundingsource = fundingsource;
    this.fundingsourceLayout = fundingsourceLayout;
    this.specialtycocoa = specialtycocoa;
    this.specialtycocoaLayout = specialtycocoaLayout;
  }

  public abstract void setActivity(@Nullable ActivityInfoPojo activity);

  @Nullable
  public ActivityInfoPojo getActivity() {
    return mActivity;
  }

  @NonNull
  public static FragmentEditActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentEditActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentEditActivityProfileBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_edit_activity_profile, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentEditActivityProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentEditActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentEditActivityProfileBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_edit_activity_profile, null, false, component);
  }

  public static FragmentEditActivityProfileBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentEditActivityProfileBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentEditActivityProfileBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_edit_activity_profile);
  }
}
