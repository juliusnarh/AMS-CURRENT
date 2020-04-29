package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_3_Pojo;

public abstract class FragmentFaf3Binding extends ViewDataBinding {
  @NonNull
  public final EditText comments;

  @NonNull
  public final TextView txtpinfo;

  @Bindable
  protected FAF_3_Pojo mFaf3;

  protected FragmentFaf3Binding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText comments, TextView txtpinfo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.comments = comments;
    this.txtpinfo = txtpinfo;
  }

  public abstract void setFaf3(@Nullable FAF_3_Pojo faf3);

  @Nullable
  public FAF_3_Pojo getFaf3() {
    return mFaf3;
  }

  @NonNull
  public static FragmentFaf3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFaf3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFaf3Binding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_faf_3, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFaf3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFaf3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFaf3Binding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_faf_3, null, false, component);
  }

  public static FragmentFaf3Binding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentFaf3Binding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentFaf3Binding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_faf_3);
  }
}
