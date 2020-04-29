package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;

public abstract class ActivityLoginAltBinding extends ViewDataBinding {
  @NonNull
  public final LottieAnimationView animationView;

  @NonNull
  public final Button btnlogin;

  @NonNull
  public final ImageView cocoa;

  @NonNull
  public final FrameLayout container;

  @NonNull
  public final RelativeLayout cov;

  @NonNull
  public final LinearLayout cover;

  @NonNull
  public final RelativeLayout emailLoginForm;

  @NonNull
  public final LinearLayout form;

  @NonNull
  public final TextView linkSignup;

  @NonNull
  public final ScrollView loginForm;

  @NonNull
  public final LinearLayout loginProgress;

  @NonNull
  public final EditText password;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final EditText username;

  protected ActivityLoginAltBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LottieAnimationView animationView, Button btnlogin, ImageView cocoa,
      FrameLayout container, RelativeLayout cov, LinearLayout cover, RelativeLayout emailLoginForm,
      LinearLayout form, TextView linkSignup, ScrollView loginForm, LinearLayout loginProgress,
      EditText password, TextView textView2, TextView textView3, EditText username) {
    super(_bindingComponent, _root, _localFieldCount);
    this.animationView = animationView;
    this.btnlogin = btnlogin;
    this.cocoa = cocoa;
    this.container = container;
    this.cov = cov;
    this.cover = cover;
    this.emailLoginForm = emailLoginForm;
    this.form = form;
    this.linkSignup = linkSignup;
    this.loginForm = loginForm;
    this.loginProgress = loginProgress;
    this.password = password;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.username = username;
  }

  @NonNull
  public static ActivityLoginAltBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLoginAltBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLoginAltBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_login_alt, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLoginAltBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLoginAltBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLoginAltBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_login_alt, null, false, component);
  }

  public static ActivityLoginAltBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityLoginAltBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityLoginAltBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_login_alt);
  }
}
