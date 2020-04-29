package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;

public abstract class ContentReceiveInputsBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout accept;

  @NonNull
  public final Button acceptbtn;

  @NonNull
  public final LottieAnimationView animationView;

  @NonNull
  public final Button declinebtn;

  @NonNull
  public final RecyclerView recycler;

  @NonNull
  public final TextView text;

  protected ContentReceiveInputsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout accept, Button acceptbtn,
      LottieAnimationView animationView, Button declinebtn, RecyclerView recycler, TextView text) {
    super(_bindingComponent, _root, _localFieldCount);
    this.accept = accept;
    this.acceptbtn = acceptbtn;
    this.animationView = animationView;
    this.declinebtn = declinebtn;
    this.recycler = recycler;
    this.text = text;
  }

  @NonNull
  public static ContentReceiveInputsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentReceiveInputsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentReceiveInputsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.content_receive_inputs, root, attachToRoot, component);
  }

  @NonNull
  public static ContentReceiveInputsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentReceiveInputsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentReceiveInputsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.content_receive_inputs, null, false, component);
  }

  public static ContentReceiveInputsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentReceiveInputsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentReceiveInputsBinding)bind(component, view, com.telpo.usb.finger.R.layout.content_receive_inputs);
  }
}
