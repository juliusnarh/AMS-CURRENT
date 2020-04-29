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
import com.telpo.usb.finger.pojo.FarmerRegisty;

public abstract class HouseholdsDataBinding extends ViewDataBinding {
  @NonNull
  public final TextView fullname;

  @NonNull
  public final ImageView householdedit;

  @NonNull
  public final CardView hsecard;

  @NonNull
  public final ImageView photo;

  @NonNull
  public final TextView relationship;

  @NonNull
  public final TextView telephone;

  @Bindable
  protected FarmerRegisty mHousehold;

  protected HouseholdsDataBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView fullname, ImageView householdedit, CardView hsecard,
      ImageView photo, TextView relationship, TextView telephone) {
    super(_bindingComponent, _root, _localFieldCount);
    this.fullname = fullname;
    this.householdedit = householdedit;
    this.hsecard = hsecard;
    this.photo = photo;
    this.relationship = relationship;
    this.telephone = telephone;
  }

  public abstract void setHousehold(@Nullable FarmerRegisty household);

  @Nullable
  public FarmerRegisty getHousehold() {
    return mHousehold;
  }

  @NonNull
  public static HouseholdsDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static HouseholdsDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<HouseholdsDataBinding>inflate(inflater, com.telpo.usb.finger.R.layout.household_item_layout, root, attachToRoot, component);
  }

  @NonNull
  public static HouseholdsDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static HouseholdsDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<HouseholdsDataBinding>inflate(inflater, com.telpo.usb.finger.R.layout.household_item_layout, null, false, component);
  }

  public static HouseholdsDataBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static HouseholdsDataBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (HouseholdsDataBinding)bind(component, view, com.telpo.usb.finger.R.layout.household_item_layout);
  }
}
