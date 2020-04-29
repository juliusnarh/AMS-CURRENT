package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.telpo.usb.finger.entities.SupportDocs;

public abstract class ScandocItemLayoutBinding extends ViewDataBinding {
  @NonNull
  public final ImageView btnremove;

  @NonNull
  public final ImageView btnrotate;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final ImageView doc;

  @NonNull
  public final TextView doctype;

  @Bindable
  protected SupportDocs mScan;

  protected ScandocItemLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView btnremove, ImageView btnrotate, CardView cardView,
      ImageView doc, TextView doctype) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnremove = btnremove;
    this.btnrotate = btnrotate;
    this.cardView = cardView;
    this.doc = doc;
    this.doctype = doctype;
  }

  public abstract void setScan(@Nullable SupportDocs scan);

  @Nullable
  public SupportDocs getScan() {
    return mScan;
  }

  @NonNull
  public static ScandocItemLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ScandocItemLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ScandocItemLayoutBinding>inflate(inflater, com.telpo.usb.finger.R.layout.scandoc_item_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ScandocItemLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ScandocItemLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ScandocItemLayoutBinding>inflate(inflater, com.telpo.usb.finger.R.layout.scandoc_item_layout, null, false, component);
  }

  public static ScandocItemLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ScandocItemLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ScandocItemLayoutBinding)bind(component, view, com.telpo.usb.finger.R.layout.scandoc_item_layout);
  }
}
