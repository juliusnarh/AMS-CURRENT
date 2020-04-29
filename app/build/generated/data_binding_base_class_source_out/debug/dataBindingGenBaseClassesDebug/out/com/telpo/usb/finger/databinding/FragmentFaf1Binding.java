package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_1_Pojo;

public abstract class FragmentFaf1Binding extends ViewDataBinding {
  @NonNull
  public final TextInputEditText datePlanted;

  @NonNull
  public final TextInputLayout datePlantedLayout;

  @NonNull
  public final TextView maincrop;

  @NonNull
  public final TextView maincropValue;

  @NonNull
  public final LinearLayout mcvContainer;

  @NonNull
  public final TextInputEditText selectFarm;

  @NonNull
  public final TextInputLayout selectFarmLayout;

  @NonNull
  public final TextInputEditText stage;

  @NonNull
  public final TextInputLayout stageLayout;

  @NonNull
  public final TextView txtpinfo;

  @NonNull
  public final TextInputEditText variety;

  @NonNull
  public final TextInputLayout varietyLayout;

  @Bindable
  protected FAF_1_Pojo mFaf1;

  protected FragmentFaf1Binding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextInputEditText datePlanted, TextInputLayout datePlantedLayout,
      TextView maincrop, TextView maincropValue, LinearLayout mcvContainer,
      TextInputEditText selectFarm, TextInputLayout selectFarmLayout, TextInputEditText stage,
      TextInputLayout stageLayout, TextView txtpinfo, TextInputEditText variety,
      TextInputLayout varietyLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.datePlanted = datePlanted;
    this.datePlantedLayout = datePlantedLayout;
    this.maincrop = maincrop;
    this.maincropValue = maincropValue;
    this.mcvContainer = mcvContainer;
    this.selectFarm = selectFarm;
    this.selectFarmLayout = selectFarmLayout;
    this.stage = stage;
    this.stageLayout = stageLayout;
    this.txtpinfo = txtpinfo;
    this.variety = variety;
    this.varietyLayout = varietyLayout;
  }

  public abstract void setFaf1(@Nullable FAF_1_Pojo faf1);

  @Nullable
  public FAF_1_Pojo getFaf1() {
    return mFaf1;
  }

  @NonNull
  public static FragmentFaf1Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFaf1Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFaf1Binding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_faf_1, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFaf1Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFaf1Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFaf1Binding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_faf_1, null, false, component);
  }

  public static FragmentFaf1Binding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentFaf1Binding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentFaf1Binding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_faf_1);
  }
}
