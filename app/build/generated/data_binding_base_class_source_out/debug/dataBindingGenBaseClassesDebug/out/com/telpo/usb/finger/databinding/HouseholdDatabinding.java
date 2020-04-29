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

public abstract class HouseholdDatabinding extends ViewDataBinding {
  @NonNull
  public final TextView fullname;

  @NonNull
  public final CardView hsecard;

  @NonNull
  public final TextView idnumber;

  @NonNull
  public final ImageView photo;

  @NonNull
  public final TextView telephone;

  @Bindable
  protected FarmerRegisty mSearch;

  protected HouseholdDatabinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView fullname, CardView hsecard, TextView idnumber, ImageView photo,
      TextView telephone) {
    super(_bindingComponent, _root, _localFieldCount);
    this.fullname = fullname;
    this.hsecard = hsecard;
    this.idnumber = idnumber;
    this.photo = photo;
    this.telephone = telephone;
  }

  public abstract void setSearch(@Nullable FarmerRegisty search);

  @Nullable
  public FarmerRegisty getSearch() {
    return mSearch;
  }

  @NonNull
  public static HouseholdDatabinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static HouseholdDatabinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<HouseholdDatabinding>inflate(inflater, com.telpo.usb.finger.R.layout.household_search_item, root, attachToRoot, component);
  }

  @NonNull
  public static HouseholdDatabinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static HouseholdDatabinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<HouseholdDatabinding>inflate(inflater, com.telpo.usb.finger.R.layout.household_search_item, null, false, component);
  }

  public static HouseholdDatabinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static HouseholdDatabinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (HouseholdDatabinding)bind(component, view, com.telpo.usb.finger.R.layout.household_search_item);
  }
}
