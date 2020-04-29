package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo;

public abstract class FragmentFaf2Binding extends ViewDataBinding {
  @NonNull
  public final CardView camera;

  @NonNull
  public final CheckBox chemicalCheck;

  @NonNull
  public final RelativeLayout cropprotectionLayout;

  @NonNull
  public final TextInputEditText dateChemApp;

  @NonNull
  public final TextInputLayout dateChemAppLayout;

  @NonNull
  public final TextInputEditText dateFertApp;

  @NonNull
  public final TextInputLayout dateFertAppLayout;

  @NonNull
  public final RelativeLayout fertLayout;

  @NonNull
  public final CheckBox fertilizerCheck;

  @NonNull
  public final LinearLayout mainLinear;

  @NonNull
  public final TextInputEditText nameChem;

  @NonNull
  public final TextInputLayout nameChemLayout;

  @NonNull
  public final TextInputEditText nameFert;

  @NonNull
  public final TextInputLayout nameFertLayout;

  @NonNull
  public final RelativeLayout rrChemical;

  @NonNull
  public final RelativeLayout rrFertilizer;

  @NonNull
  public final TextView txtpinfo;

  @Bindable
  protected FAF_2_Pojo mFaf2;

  protected FragmentFaf2Binding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CardView camera, CheckBox chemicalCheck,
      RelativeLayout cropprotectionLayout, TextInputEditText dateChemApp,
      TextInputLayout dateChemAppLayout, TextInputEditText dateFertApp,
      TextInputLayout dateFertAppLayout, RelativeLayout fertLayout, CheckBox fertilizerCheck,
      LinearLayout mainLinear, TextInputEditText nameChem, TextInputLayout nameChemLayout,
      TextInputEditText nameFert, TextInputLayout nameFertLayout, RelativeLayout rrChemical,
      RelativeLayout rrFertilizer, TextView txtpinfo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.camera = camera;
    this.chemicalCheck = chemicalCheck;
    this.cropprotectionLayout = cropprotectionLayout;
    this.dateChemApp = dateChemApp;
    this.dateChemAppLayout = dateChemAppLayout;
    this.dateFertApp = dateFertApp;
    this.dateFertAppLayout = dateFertAppLayout;
    this.fertLayout = fertLayout;
    this.fertilizerCheck = fertilizerCheck;
    this.mainLinear = mainLinear;
    this.nameChem = nameChem;
    this.nameChemLayout = nameChemLayout;
    this.nameFert = nameFert;
    this.nameFertLayout = nameFertLayout;
    this.rrChemical = rrChemical;
    this.rrFertilizer = rrFertilizer;
    this.txtpinfo = txtpinfo;
  }

  public abstract void setFaf2(@Nullable FAF_2_Pojo faf2);

  @Nullable
  public FAF_2_Pojo getFaf2() {
    return mFaf2;
  }

  @NonNull
  public static FragmentFaf2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFaf2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFaf2Binding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_faf_2, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFaf2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFaf2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFaf2Binding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_faf_2, null, false, component);
  }

  public static FragmentFaf2Binding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentFaf2Binding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentFaf2Binding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_faf_2);
  }
}
