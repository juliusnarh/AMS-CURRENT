package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public abstract class FragmentAddAnotherFarmBinding extends ViewDataBinding {
  @NonNull
  public final TextInputEditText agricactive;

  @NonNull
  public final TextInputLayout agricactiveLayout;

  @NonNull
  public final Button btncancel;

  @NonNull
  public final Button btnsave;

  @NonNull
  public final TextInputEditText chemicalused;

  @NonNull
  public final TextInputLayout chemicalusedLayout;

  @NonNull
  public final TextInputEditText cocoatype;

  @NonNull
  public final TextInputLayout cocoatypeLayout;

  @NonNull
  public final TextInputLayout communityLayout;

  @NonNull
  public final TextInputEditText cropVariety;

  @NonNull
  public final TextInputLayout cropVarietyLayout;

  @NonNull
  public final TextInputEditText cropprotection;

  @NonNull
  public final TextInputLayout cropprotectionLayout;

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
  public final TextInputEditText farmyield;

  @NonNull
  public final TextInputLayout farmyieldLayout;

  @NonNull
  public final TextInputEditText fertused;

  @NonNull
  public final TextInputLayout fertusedLayout;

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

  protected FragmentAddAnotherFarmBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextInputEditText agricactive, TextInputLayout agricactiveLayout,
      Button btncancel, Button btnsave, TextInputEditText chemicalused,
      TextInputLayout chemicalusedLayout, TextInputEditText cocoatype,
      TextInputLayout cocoatypeLayout, TextInputLayout communityLayout,
      TextInputEditText cropVariety, TextInputLayout cropVarietyLayout,
      TextInputEditText cropprotection, TextInputLayout cropprotectionLayout,
      TextInputEditText cultarea, TextInputLayout cultareaLayout, TextInputEditText district,
      TextInputLayout districtLayout, TextInputLayout estabyearLayout, Switch extentoinservice,
      TextInputEditText farmyield, TextInputLayout farmyieldLayout, TextInputEditText fertused,
      TextInputLayout fertusedLayout, TextInputEditText laborsource,
      TextInputLayout laborsourceLayout, TextInputEditText landarea, TextInputLayout landareaLayout,
      TextInputEditText materialothersource, TextInputLayout materialothersourceLayout,
      TextInputEditText materialsource, TextInputLayout materialsourceLayout,
      TextInputEditText ownership, TextInputLayout ownershipLayout, TextInputEditText privorg,
      TextInputLayout privorgLayout, TextInputEditText provideorg, TextInputLayout provideorgLayout,
      TextInputLayout regionLayout, TextInputEditText shadetreeno,
      TextInputLayout shadetreenoLayout, Switch swagroactive, TextInputEditText txtestabyear,
      TextInputEditText txtregion) {
    super(_bindingComponent, _root, _localFieldCount);
    this.agricactive = agricactive;
    this.agricactiveLayout = agricactiveLayout;
    this.btncancel = btncancel;
    this.btnsave = btnsave;
    this.chemicalused = chemicalused;
    this.chemicalusedLayout = chemicalusedLayout;
    this.cocoatype = cocoatype;
    this.cocoatypeLayout = cocoatypeLayout;
    this.communityLayout = communityLayout;
    this.cropVariety = cropVariety;
    this.cropVarietyLayout = cropVarietyLayout;
    this.cropprotection = cropprotection;
    this.cropprotectionLayout = cropprotectionLayout;
    this.cultarea = cultarea;
    this.cultareaLayout = cultareaLayout;
    this.district = district;
    this.districtLayout = districtLayout;
    this.estabyearLayout = estabyearLayout;
    this.extentoinservice = extentoinservice;
    this.farmyield = farmyield;
    this.farmyieldLayout = farmyieldLayout;
    this.fertused = fertused;
    this.fertusedLayout = fertusedLayout;
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
  public static FragmentAddAnotherFarmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAddAnotherFarmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAddAnotherFarmBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_add_another_farm, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAddAnotherFarmBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAddAnotherFarmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAddAnotherFarmBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_add_another_farm, null, false, component);
  }

  public static FragmentAddAnotherFarmBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentAddAnotherFarmBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentAddAnotherFarmBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_add_another_farm);
  }
}
