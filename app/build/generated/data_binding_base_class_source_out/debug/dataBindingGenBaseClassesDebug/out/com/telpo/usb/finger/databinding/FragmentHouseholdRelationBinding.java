package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentHouseholdRelationBinding extends ViewDataBinding {
  @NonNull
  public final TextView textView3;

  @NonNull
  public final EditText txtrelation;

  protected FragmentHouseholdRelationBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView textView3, EditText txtrelation) {
    super(_bindingComponent, _root, _localFieldCount);
    this.textView3 = textView3;
    this.txtrelation = txtrelation;
  }

  @NonNull
  public static FragmentHouseholdRelationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentHouseholdRelationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentHouseholdRelationBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_household_relation, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHouseholdRelationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentHouseholdRelationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentHouseholdRelationBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_household_relation, null, false, component);
  }

  public static FragmentHouseholdRelationBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentHouseholdRelationBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentHouseholdRelationBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_household_relation);
  }
}
