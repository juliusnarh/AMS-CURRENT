package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityDashBoardBinding extends ViewDataBinding {
  @NonNull
  public final CardView logoutcard;

  @NonNull
  public final CardView register;

  @NonNull
  public final CardView registered;

  protected ActivityDashBoardBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CardView logoutcard, CardView register, CardView registered) {
    super(_bindingComponent, _root, _localFieldCount);
    this.logoutcard = logoutcard;
    this.register = register;
    this.registered = registered;
  }

  @NonNull
  public static ActivityDashBoardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDashBoardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDashBoardBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_dash_board, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDashBoardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDashBoardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDashBoardBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_dash_board, null, false, component);
  }

  public static ActivityDashBoardBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityDashBoardBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityDashBoardBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_dash_board);
  }
}
