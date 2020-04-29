package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.silencedut.expandablelayout.ExpandableLayout;

public abstract class FragmentFarmerProfileServicesBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView activityRecyclerview;

  @NonNull
  public final ImageView activityarrow;

  @NonNull
  public final LinearLayout activityheader;

  @NonNull
  public final TextView activitystats;

  @NonNull
  public final Button addactivity;

  @NonNull
  public final Button addfarm;

  @NonNull
  public final ExpandableLayout expandableLayout1;

  @NonNull
  public final ExpandableLayout expandableLayout2;

  @NonNull
  public final RecyclerView farmRecyclerview;

  @NonNull
  public final ImageView farmarrow;

  @NonNull
  public final LinearLayout farmheader;

  @NonNull
  public final TextView farmstats;

  @NonNull
  public final RelativeLayout firstLayer1;

  @NonNull
  public final RelativeLayout firstLayer2;

  protected FragmentFarmerProfileServicesBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView activityRecyclerview, ImageView activityarrow,
      LinearLayout activityheader, TextView activitystats, Button addactivity, Button addfarm,
      ExpandableLayout expandableLayout1, ExpandableLayout expandableLayout2,
      RecyclerView farmRecyclerview, ImageView farmarrow, LinearLayout farmheader,
      TextView farmstats, RelativeLayout firstLayer1, RelativeLayout firstLayer2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.activityRecyclerview = activityRecyclerview;
    this.activityarrow = activityarrow;
    this.activityheader = activityheader;
    this.activitystats = activitystats;
    this.addactivity = addactivity;
    this.addfarm = addfarm;
    this.expandableLayout1 = expandableLayout1;
    this.expandableLayout2 = expandableLayout2;
    this.farmRecyclerview = farmRecyclerview;
    this.farmarrow = farmarrow;
    this.farmheader = farmheader;
    this.farmstats = farmstats;
    this.firstLayer1 = firstLayer1;
    this.firstLayer2 = firstLayer2;
  }

  @NonNull
  public static FragmentFarmerProfileServicesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFarmerProfileServicesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFarmerProfileServicesBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_farmer_profile_services, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFarmerProfileServicesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFarmerProfileServicesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFarmerProfileServicesBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_farmer_profile_services, null, false, component);
  }

  public static FragmentFarmerProfileServicesBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentFarmerProfileServicesBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentFarmerProfileServicesBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_farmer_profile_services);
  }
}
