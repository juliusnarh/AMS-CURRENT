package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public abstract class ScandocProfileItemLayoutBinding extends ViewDataBinding {
  @NonNull
  public final Button btnremove;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final ImageView doc;

  @NonNull
  public final TextView doctype;

  @Bindable
  protected SupportDocs mScan;

  protected ScandocProfileItemLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnremove, CardView cardView, ImageView doc, TextView doctype) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnremove = btnremove;
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
  public static ScandocProfileItemLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ScandocProfileItemLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ScandocProfileItemLayoutBinding>inflate(inflater, com.telpo.usb.finger.R.layout.scandoc_profile_item_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ScandocProfileItemLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ScandocProfileItemLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ScandocProfileItemLayoutBinding>inflate(inflater, com.telpo.usb.finger.R.layout.scandoc_profile_item_layout, null, false, component);
  }

  public static ScandocProfileItemLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ScandocProfileItemLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ScandocProfileItemLayoutBinding)bind(component, view, com.telpo.usb.finger.R.layout.scandoc_profile_item_layout);
  }
}
