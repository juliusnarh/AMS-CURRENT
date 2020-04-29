package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.telpo.usb.finger.pojo.FarmRegistrationPojo;

public abstract class FragmentFarmInfoBinding extends ViewDataBinding {
  @NonNull
  public final TextInputEditText agricactive;

  @NonNull
  public final TextInputLayout agricactiveLayout;

  @NonNull
  public final TextInputEditText cocoatype;

  @NonNull
  public final TextInputLayout cocoatypeLayout;

  @NonNull
  public final TextInputLayout communityLayout;

  @NonNull
  public final TextInputEditText cultarea;

  @NonNull
  public final TextInputLayout cultareaLayout;

  @NonNull
  public final TextInputEditText district;

  @NonNull
  public final TextInputLayout districtLayout;

  @NonNull
  public final TextInputLayout estabyearLayout;

  @NonNull
  public final Switch extentoinservice;

  @NonNull
  public final TextInputEditText laborsource;

  @NonNull
  public final TextInputLayout laborsourceLayout;

  @NonNull
  public final TextInputEditText landarea;

  @NonNull
  public final TextInputLayout landareaLayout;

  @NonNull
  public final TextInputEditText materialothersource;

  @NonNull
  public final TextInputLayout materialothersourceLayout;

  @NonNull
  public final TextInputEditText materialsource;

  @NonNull
  public final TextInputLayout materialsourceLayout;

  @NonNull
  public final TextInputEditText ownership;

  @NonNull
  public final TextInputLayout ownershipLayout;

  @NonNull
  public final TextInputEditText privorg;

  @NonNull
  public final TextInputLayout privorgLayout;

  @NonNull
  public final TextInputEditText provideorg;

  @NonNull
  public final TextInputLayout provideorgLayout;

  @NonNull
  public final TextInputLayout regionLayout;

  @NonNull
  public final TextInputEditText shadetreeno;

  @NonNull
  public final TextInputLayout shadetreenoLayout;

  @NonNull
  public final Switch swagroactive;

  @NonNull
  public final TextInputEditText txtestabyear;

  @NonNull
  public final TextInputEditText txtregion;

  @Bindable
  protected FarmRegistrationPojo mFarmreg;

  protected FragmentFarmInfoBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextInputEditText agricactive, TextInputLayout agricactiveLayout,
      TextInputEditText cocoatype, TextInputLayout cocoatypeLayout, TextInputLayout communityLayout,
      TextInputEditText cultarea, TextInputLayout cultareaLayout, TextInputEditText district,
      TextInputLayout districtLayout, TextInputLayout estabyearLayout, Switch extentoinservice,
      TextInputEditText laborsource, TextInputLayout laborsourceLayout, TextInputEditText landarea,
      TextInputLayout landareaLayout, TextInputEditText materialothersource,
      TextInputLayout materialothersourceLayout, TextInputEditText materialsource,
      TextInputLayout materialsourceLayout, TextInputEditText ownership,
      TextInputLayout ownershipLayout, TextInputEditText privorg, TextInputLayout privorgLayout,
      TextInputEditText provideorg, TextInputLayout provideorgLayout, TextInputLayout regionLayout,
      TextInputEditText shadetreeno, TextInputLayout shadetreenoLayout, Switch swagroactive,
      TextInputEditText txtestabyear, TextInputEditText txtregion) {
    super(_bindingComponent, _root, _localFieldCount);
    this.agricactive = agricactive;
    this.agricactiveLayout = agricactiveLayout;
    this.cocoatype = cocoatype;
    this.cocoatypeLayout = cocoatypeLayout;
    this.communityLayout = communityLayout;
    this.cultarea = cultarea;
    this.cultareaLayout = cultareaLayout;
    this.district = district;
    this.districtLayout = districtLayout;
    this.estabyearLayout = estabyearLayout;
    this.extentoinservice = extentoinservice;
    this.laborsource = laborsource;
    this.laborsourceLayout = laborsourceLayout;
    this.landarea = landarea;
    this.landareaLayout = landareaLayout;
    this.materialothersource = materialothersource;
    this.materialothersourceLayout = materialothersourceLayout;
    this.materialsource = materialsource;
    this.materialsourceLayout = materialsourceLayout;
    this.ownership = ownership;
    this.ownershipLayout = ownershipLayout;
    this.privorg = privorg;
    this.privorgLayout = privorgLayout;
    this.provideorg = provideorg;
    this.provideorgLayout = provideorgLayout;
    this.regionLayout = regionLayout;
    this.shadetreeno = shadetreeno;
    this.shadetreenoLayout = shadetreenoLayout;
    this.swagroactive = swagroactive;
    this.txtestabyear = txtestabyear;
    this.txtregion = txtregion;
  }

  public abstract void setFarmreg(@Nullable FarmRegistrationPojo farmreg);

  @Nullable
  public FarmRegistrationPojo getFarmreg() {
    return mFarmreg;
  }

  @NonNull
  public static FragmentFarmInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFarmInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFarmInfoBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_farm_info, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFarmInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFarmInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFarmInfoBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_farm_info, null, false, component);
  }

  public static FragmentFarmInfoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentFarmInfoBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentFarmInfoBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_farm_info);
  }
}
