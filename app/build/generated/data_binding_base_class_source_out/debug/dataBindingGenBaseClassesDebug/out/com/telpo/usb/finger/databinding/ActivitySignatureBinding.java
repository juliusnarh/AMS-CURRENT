package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.gcacace.signaturepad.views.SignaturePad;

public abstract class ActivitySignatureBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout buttonsContainer;

  @NonNull
  public final Button clearButton;

  @NonNull
  public final Button saveButton;

  @NonNull
  public final SignaturePad signaturePad;

  @NonNull
  public final RelativeLayout signaturePadContainer;

  @NonNull
  public final TextView signaturePadDescription;

  protected ActivitySignatureBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout buttonsContainer, Button clearButton, Button saveButton,
      SignaturePad signaturePad, RelativeLayout signaturePadContainer,
      TextView signaturePadDescription) {
    super(_bindingComponent, _root, _localFieldCount);
    this.buttonsContainer = buttonsContainer;
    this.clearButton = clearButton;
    this.saveButton = saveButton;
    this.signaturePad = signaturePad;
    this.signaturePadContainer = signaturePadContainer;
    this.signaturePadDescription = signaturePadDescription;
  }

  @NonNull
  public static ActivitySignatureBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySignatureBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySignatureBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_signature, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySignatureBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySignatureBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySignatureBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_signature, null, false, component);
  }

  public static ActivitySignatureBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySignatureBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySignatureBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_signature);
  }
}
