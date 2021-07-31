package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mikhaellopez.circularimageview.CircularImageView;

public abstract class DialogAddinputBinding extends ViewDataBinding {
  @NonNull
  public final EditText category;

  @NonNull
  public final ImageView close;

  @NonNull
  public final EditText costPrice;

  @NonNull
  public final EditText inputdealer;

  @NonNull
  public final AppCompatEditText inputdescription;

  @NonNull
  public final CircularImageView inputimage;

  @NonNull
  public final EditText inputname;

  @NonNull
  public final EditText measurement;

  @NonNull
  public final EditText quantity;

  @NonNull
  public final EditText salePrice;

  @NonNull
  public final FloatingActionButton save;

  protected DialogAddinputBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText category, ImageView close, EditText costPrice,
      EditText inputdealer, AppCompatEditText inputdescription, CircularImageView inputimage,
      EditText inputname, EditText measurement, EditText quantity, EditText salePrice,
      FloatingActionButton save) {
    super(_bindingComponent, _root, _localFieldCount);
    this.category = category;
    this.close = close;
    this.costPrice = costPrice;
    this.inputdealer = inputdealer;
    this.inputdescription = inputdescription;
    this.inputimage = inputimage;
    this.inputname = inputname;
    this.measurement = measurement;
    this.quantity = quantity;
    this.salePrice = salePrice;
    this.save = save;
  }

  @NonNull
  public static DialogAddinputBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogAddinputBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogAddinputBinding>inflate(inflater, com.telpo.usb.finger.R.layout.dialog_addinput, root, attachToRoot, component);
  }

  @NonNull
  public static DialogAddinputBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogAddinputBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogAddinputBinding>inflate(inflater, com.telpo.usb.finger.R.layout.dialog_addinput, null, false, component);
  }

  public static DialogAddinputBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogAddinputBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogAddinputBinding)bind(component, view, com.telpo.usb.finger.R.layout.dialog_addinput);
  }
}
