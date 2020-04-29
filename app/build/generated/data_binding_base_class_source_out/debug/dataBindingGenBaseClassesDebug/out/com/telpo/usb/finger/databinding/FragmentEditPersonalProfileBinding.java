package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.telpo.usb.finger.pojo.BasicRegistration;

public abstract class FragmentEditPersonalProfileBinding extends ViewDataBinding {
  @NonNull
  public final TextInputEditText age;

  @NonNull
  public final TextInputLayout ageLayout;

  @NonNull
  public final TextInputEditText bdate;

  @NonNull
  public final TextInputLayout bdateLayout;

  @NonNull
  public final TextInputLayout bplaceLayout;

  @NonNull
  public final Button btnsave;

  @NonNull
  public final Button cancel;

  @NonNull
  public final TextInputEditText country;

  @NonNull
  public final TextInputEditText district;

  @NonNull
  public final TextInputLayout districtLayout;

  @NonNull
  public final TextInputEditText edu;

  @NonNull
  public final TextInputLayout eduLayout;

  @NonNull
  public final TextInputEditText email;

  @NonNull
  public final TextInputLayout emailLayout;

  @NonNull
  public final TextInputEditText farmcomm;

  @NonNull
  public final TextInputLayout farmcommLayout;

  @NonNull
  public final TextInputEditText gender;

  @NonNull
  public final TextInputLayout genderLayout;

  @NonNull
  public final TextInputEditText hometown;

  @NonNull
  public final TextInputLayout hometownLayout;

  @NonNull
  public final TextInputLayout idnumLayout;

  @NonNull
  public final TextInputEditText idtype;

  @NonNull
  public final TextInputLayout idtypeLayout;

  @NonNull
  public final TextInputLayout maritalstatLayout;

  @NonNull
  public final TextInputEditText maritalstatus;

  @NonNull
  public final TextInputLayout nationalityLayout;

  @NonNull
  public final TextInputLayout othernameLayout;

  @NonNull
  public final TextInputLayout postLayout;

  @NonNull
  public final TextInputEditText postbox;

  @NonNull
  public final TextInputEditText region;

  @NonNull
  public final TextInputLayout regionLayout;

  @NonNull
  public final TextInputEditText residence;

  @NonNull
  public final TextInputLayout residentialLayout;

  @NonNull
  public final TextInputLayout surnameLayout;

  @NonNull
  public final TextInputEditText telephone;

  @NonNull
  public final TextInputLayout telephoneLayout;

  @NonNull
  public final TextInputEditText txtbplace;

  @NonNull
  public final TextInputEditText txtfirstname;

  @NonNull
  public final TextInputEditText txtidnum;

  @NonNull
  public final TextInputEditText txtsurname;

  @Bindable
  protected BasicRegistration mBasicreg;

  protected FragmentEditPersonalProfileBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextInputEditText age, TextInputLayout ageLayout,
      TextInputEditText bdate, TextInputLayout bdateLayout, TextInputLayout bplaceLayout,
      Button btnsave, Button cancel, TextInputEditText country, TextInputEditText district,
      TextInputLayout districtLayout, TextInputEditText edu, TextInputLayout eduLayout,
      TextInputEditText email, TextInputLayout emailLayout, TextInputEditText farmcomm,
      TextInputLayout farmcommLayout, TextInputEditText gender, TextInputLayout genderLayout,
      TextInputEditText hometown, TextInputLayout hometownLayout, TextInputLayout idnumLayout,
      TextInputEditText idtype, TextInputLayout idtypeLayout, TextInputLayout maritalstatLayout,
      TextInputEditText maritalstatus, TextInputLayout nationalityLayout,
      TextInputLayout othernameLayout, TextInputLayout postLayout, TextInputEditText postbox,
      TextInputEditText region, TextInputLayout regionLayout, TextInputEditText residence,
      TextInputLayout residentialLayout, TextInputLayout surnameLayout, TextInputEditText telephone,
      TextInputLayout telephoneLayout, TextInputEditText txtbplace, TextInputEditText txtfirstname,
      TextInputEditText txtidnum, TextInputEditText txtsurname) {
    super(_bindingComponent, _root, _localFieldCount);
    this.age = age;
    this.ageLayout = ageLayout;
    this.bdate = bdate;
    this.bdateLayout = bdateLayout;
    this.bplaceLayout = bplaceLayout;
    this.btnsave = btnsave;
    this.cancel = cancel;
    this.country = country;
    this.district = district;
    this.districtLayout = districtLayout;
    this.edu = edu;
    this.eduLayout = eduLayout;
    this.email = email;
    this.emailLayout = emailLayout;
    this.farmcomm = farmcomm;
    this.farmcommLayout = farmcommLayout;
    this.gender = gender;
    this.genderLayout = genderLayout;
    this.hometown = hometown;
    this.hometownLayout = hometownLayout;
    this.idnumLayout = idnumLayout;
    this.idtype = idtype;
    this.idtypeLayout = idtypeLayout;
    this.maritalstatLayout = maritalstatLayout;
    this.maritalstatus = maritalstatus;
    this.nationalityLayout = nationalityLayout;
    this.othernameLayout = othernameLayout;
    this.postLayout = postLayout;
    this.postbox = postbox;
    this.region = region;
    this.regionLayout = regionLayout;
    this.residence = residence;
    this.residentialLayout = residentialLayout;
    this.surnameLayout = surnameLayout;
    this.telephone = telephone;
    this.telephoneLayout = telephoneLayout;
    this.txtbplace = txtbplace;
    this.txtfirstname = txtfirstname;
    this.txtidnum = txtidnum;
    this.txtsurname = txtsurname;
  }

  public abstract void setBasicreg(@Nullable BasicRegistration basicreg);

  @Nullable
  public BasicRegistration getBasicreg() {
    return mBasicreg;
  }

  @NonNull
  public static FragmentEditPersonalProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentEditPersonalProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentEditPersonalProfileBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_edit_personal_profile, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentEditPersonalProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentEditPersonalProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentEditPersonalProfileBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_edit_personal_profile, null, false, component);
  }

  public static FragmentEditPersonalProfileBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentEditPersonalProfileBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentEditPersonalProfileBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_edit_personal_profile);
  }
}
