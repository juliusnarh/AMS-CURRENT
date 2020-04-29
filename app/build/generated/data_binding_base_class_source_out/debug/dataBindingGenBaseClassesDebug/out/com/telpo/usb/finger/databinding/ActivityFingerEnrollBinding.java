package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityFingerEnrollBinding extends ViewDataBinding {
  @NonNull
  public final Button clearall;

  @NonNull
  public final Button enrollfinger;

  @NonNull
  public final ImageView fpImage;

  @NonNull
  public final TextView info;

  @NonNull
  public final CheckBox lindex;

  @NonNull
  public final CheckBox lmiddle;

  @NonNull
  public final CheckBox lpinky;

  @NonNull
  public final CheckBox lring;

  @NonNull
  public final CheckBox lthumb;

  @NonNull
  public final CheckBox rindex;

  @NonNull
  public final CheckBox rmiddle;

  @NonNull
  public final CheckBox rpinky;

  @NonNull
  public final CheckBox rring;

  @NonNull
  public final CheckBox rthumb;

  @NonNull
  public final Button savefinger;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final Toolbar toolbar;

  protected ActivityFingerEnrollBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button clearall, Button enrollfinger, ImageView fpImage, TextView info,
      CheckBox lindex, CheckBox lmiddle, CheckBox lpinky, CheckBox lring, CheckBox lthumb,
      CheckBox rindex, CheckBox rmiddle, CheckBox rpinky, CheckBox rring, CheckBox rthumb,
      Button savefinger, TextView textView, TextView textView2, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clearall = clearall;
    this.enrollfinger = enrollfinger;
    this.fpImage = fpImage;
    this.info = info;
    this.lindex = lindex;
    this.lmiddle = lmiddle;
    this.lpinky = lpinky;
    this.lring = lring;
    this.lthumb = lthumb;
    this.rindex = rindex;
    this.rmiddle = rmiddle;
    this.rpinky = rpinky;
    this.rring = rring;
    this.rthumb = rthumb;
    this.savefinger = savefinger;
    this.textView = textView;
    this.textView2 = textView2;
    this.toolbar = toolbar;
  }

  @NonNull
  public static ActivityFingerEnrollBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFingerEnrollBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFingerEnrollBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_finger_enroll, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFingerEnrollBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFingerEnrollBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFingerEnrollBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_finger_enroll, null, false, component);
  }

  public static ActivityFingerEnrollBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFingerEnrollBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFingerEnrollBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_finger_enroll);
  }
}
