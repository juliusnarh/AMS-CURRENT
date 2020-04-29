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

public abstract class ActivityReceiveInputsBinding extends ViewDataBinding {
  @NonNull
  public final ContentReceiveInputsBinding content;

  @NonNull
  public final Toolbar toolbar;

  protected ActivityReceiveInputsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ContentReceiveInputsBinding content, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    setContainedBinding(this.content);;
    this.toolbar = toolbar;
  }

  @NonNull
  public static ActivityReceiveInputsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityReceiveInputsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityReceiveInputsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_receive_inputs, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityReceiveInputsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityReceiveInputsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityReceiveInputsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_receive_inputs, null, false, component);
  }

  public static ActivityReceiveInputsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityReceiveInputsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityReceiveInputsBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_receive_inputs);
  }
}
