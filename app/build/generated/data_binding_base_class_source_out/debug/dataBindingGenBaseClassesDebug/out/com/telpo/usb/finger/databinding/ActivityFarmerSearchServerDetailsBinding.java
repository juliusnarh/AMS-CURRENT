package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityFarmerSearchServerDetailsBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout L1;

  @NonNull
  public final LinearLayout L2;

  @NonNull
  public final ImageView back;

  @NonNull
  public final LinearLayout btnExtensionServices;

  @NonNull
  public final LinearLayout btnInputDistribution;

  @NonNull
  public final LinearLayout btnInputRecovery;

  @NonNull
  public final LinearLayout btnPurchases;

  @NonNull
  public final LinearLayout btnServices;

  @NonNull
  public final LinearLayout btnViewAll;

  @NonNull
  public final LinearLayout btnViewProfile;

  @NonNull
  public final TextView community;

  @NonNull
  public final TextView contact;

  @NonNull
  public final TextView farmcount;

  @NonNull
  public final TextView farmerid;

  @NonNull
  public final ImageView farmerimg;

  @NonNull
  public final TextView farmername;

  protected ActivityFarmerSearchServerDetailsBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, RelativeLayout L1, LinearLayout L2, ImageView back,
      LinearLayout btnExtensionServices, LinearLayout btnInputDistribution,
      LinearLayout btnInputRecovery, LinearLayout btnPurchases, LinearLayout btnServices,
      LinearLayout btnViewAll, LinearLayout btnViewProfile, TextView community, TextView contact,
      TextView farmcount, TextView farmerid, ImageView farmerimg, TextView farmername) {
    super(_bindingComponent, _root, _localFieldCount);
    this.L1 = L1;
    this.L2 = L2;
    this.back = back;
    this.btnExtensionServices = btnExtensionServices;
    this.btnInputDistribution = btnInputDistribution;
    this.btnInputRecovery = btnInputRecovery;
    this.btnPurchases = btnPurchases;
    this.btnServices = btnServices;
    this.btnViewAll = btnViewAll;
    this.btnViewProfile = btnViewProfile;
    this.community = community;
    this.contact = contact;
    this.farmcount = farmcount;
    this.farmerid = farmerid;
    this.farmerimg = farmerimg;
    this.farmername = farmername;
  }

  @NonNull
  public static ActivityFarmerSearchServerDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmerSearchServerDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmerSearchServerDetailsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farmer_search_server_details, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFarmerSearchServerDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmerSearchServerDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmerSearchServerDetailsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farmer_search_server_details, null, false, component);
  }

  public static ActivityFarmerSearchServerDetailsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFarmerSearchServerDetailsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFarmerSearchServerDetailsBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_farmer_search_server_details);
  }
}
