package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.telpo.usb.finger.entities.ActivityInfo;

public abstract class ActivityDataBinding extends ViewDataBinding {
  @NonNull
  public final ImageView activityedit;

  @Bindable
  protected ActivityInfo mActivity;

  protected ActivityDataBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView activityedit) {
    super(_bindingComponent, _root, _localFieldCount);
    this.activityedit = activityedit;
  }

  public abstract void setActivity(@Nullable ActivityInfo activity);

  @Nullable
  public ActivityInfo getActivity() {
    return mActivity;
  }

  @NonNull
  public static ActivityDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDataBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_item_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDataBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_item_layout, null, false, component);
  }

  public static ActivityDataBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityDataBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityDataBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_item_layout);
  }
}
