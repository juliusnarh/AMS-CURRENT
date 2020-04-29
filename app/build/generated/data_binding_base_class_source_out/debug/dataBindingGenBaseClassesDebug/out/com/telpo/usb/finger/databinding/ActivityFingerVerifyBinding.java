package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.telpo.usb.finger.pojo.BasicRegistration;
import com.telpo.usb.finger.pojo.BiometricsTaken;

public abstract class ActivityFingerVerifyBinding extends ViewDataBinding {
  @NonNull
  public final Button clearall;

  @NonNull
  public final ImageView fpImage;

  @NonNull
  public final TextView fullname;

  @NonNull
  public final TextView idnumber;

  @NonNull
  public final TextView info;

  @NonNull
  public final Button loadrecord;

  @NonNull
  public final TextView nationality;

  @NonNull
  public final ImageView photo;

  @NonNull
  public final TextView telephone;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final Button verify;

  @NonNull
  public final TextInputEditText verifyid;

  @Bindable
  protected BasicRegistration mBasicinfo;

  @Bindable
  protected BiometricsTaken mBioinfo;

  protected ActivityFingerVerifyBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button clearall, ImageView fpImage, TextView fullname,
      TextView idnumber, TextView info, Button loadrecord, TextView nationality, ImageView photo,
      TextView telephone, Toolbar toolbar, Button verify, TextInputEditText verifyid) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clearall = clearall;
    this.fpImage = fpImage;
    this.fullname = fullname;
    this.idnumber = idnumber;
    this.info = info;
    this.loadrecord = loadrecord;
    this.nationality = nationality;
    this.photo = photo;
    this.telephone = telephone;
    this.toolbar = toolbar;
    this.verify = verify;
    this.verifyid = verifyid;
  }

  public abstract void setBasicinfo(@Nullable BasicRegistration basicinfo);

  @Nullable
  public BasicRegistration getBasicinfo() {
    return mBasicinfo;
  }

  public abstract void setBioinfo(@Nullable BiometricsTaken bioinfo);

  @Nullable
  public BiometricsTaken getBioinfo() {
    return mBioinfo;
  }

  @NonNull
  public static ActivityFingerVerifyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFingerVerifyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFingerVerifyBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_finger_verify, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFingerVerifyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFingerVerifyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFingerVerifyBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_finger_verify, null, false, component);
  }

  public static ActivityFingerVerifyBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFingerVerifyBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFingerVerifyBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_finger_verify);
  }
}
