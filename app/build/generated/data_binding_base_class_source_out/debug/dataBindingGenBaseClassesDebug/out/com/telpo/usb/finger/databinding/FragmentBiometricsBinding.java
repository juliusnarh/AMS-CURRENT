package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.telpo.usb.finger.pojo.BiometricsTaken;

public abstract class FragmentBiometricsBinding extends ViewDataBinding {
  @NonNull
  public final CardView camera;

  @NonNull
  public final CardView fingerprint;

  @NonNull
  public final CardView signature;

  @NonNull
  public final CardView supportdocs;

  @Bindable
  protected BiometricsTaken mBio;

  protected FragmentBiometricsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CardView camera, CardView fingerprint, CardView signature,
      CardView supportdocs) {
    super(_bindingComponent, _root, _localFieldCount);
    this.camera = camera;
    this.fingerprint = fingerprint;
    this.signature = signature;
    this.supportdocs = supportdocs;
  }

  public abstract void setBio(@Nullable BiometricsTaken bio);

  @Nullable
  public BiometricsTaken getBio() {
    return mBio;
  }

  @NonNull
  public static FragmentBiometricsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentBiometricsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentBiometricsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_biometrics, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentBiometricsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentBiometricsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentBiometricsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_biometrics, null, false, component);
  }

  public static FragmentBiometricsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentBiometricsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentBiometricsBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_biometrics);
  }
}
