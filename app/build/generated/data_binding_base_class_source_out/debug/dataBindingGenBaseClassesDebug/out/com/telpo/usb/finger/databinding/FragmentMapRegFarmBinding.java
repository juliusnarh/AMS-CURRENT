package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentMapRegFarmBinding extends ViewDataBinding {
  @NonNull
  public final Button btnadd;

  @NonNull
  public final Button btnclear;

  @NonNull
  public final Button btnplot;

  @NonNull
  public final TextView latupdate;

  @NonNull
  public final ListView listview;

  @NonNull
  public final TextView longupdate;

  @NonNull
  public final LinearLayout mainlinearfarm;

  protected FragmentMapRegFarmBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnadd, Button btnclear, Button btnplot, TextView latupdate,
      ListView listview, TextView longupdate, LinearLayout mainlinearfarm) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnadd = btnadd;
    this.btnclear = btnclear;
    this.btnplot = btnplot;
    this.latupdate = latupdate;
    this.listview = listview;
    this.longupdate = longupdate;
    this.mainlinearfarm = mainlinearfarm;
  }

  @NonNull
  public static FragmentMapRegFarmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMapRegFarmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMapRegFarmBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_map_reg_farm, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMapRegFarmBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMapRegFarmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMapRegFarmBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_map_reg_farm, null, false, component);
  }

  public static FragmentMapRegFarmBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMapRegFarmBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMapRegFarmBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_map_reg_farm);
  }
}
