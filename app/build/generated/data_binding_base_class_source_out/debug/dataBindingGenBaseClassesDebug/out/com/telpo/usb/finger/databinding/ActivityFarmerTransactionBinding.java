package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public abstract class ActivityFarmerTransactionBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout L1;

  @NonNull
  public final ScrollView L2;

  @NonNull
  public final ImageView back;

  @NonNull
  public final LinearLayout cardTitle;

  @NonNull
  public final TextView community;

  @NonNull
  public final RecyclerView declarationrecycler;

  @NonNull
  public final TextView farmcount;

  @NonNull
  public final TextView farmerid;

  @NonNull
  public final CircleImageView farmerimg;

  @NonNull
  public final TextView farmername;

  @NonNull
  public final TextView header;

  @NonNull
  public final TextView norecord;

  @NonNull
  public final TextView norecorddeclaration;

  @NonNull
  public final TextView norecordsales;

  @NonNull
  public final RecyclerView salestranrecycler;

  @NonNull
  public final RecyclerView scaletranrecycler;

  @NonNull
  public final CircleImageView select;

  protected ActivityFarmerTransactionBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RelativeLayout L1, ScrollView L2, ImageView back,
      LinearLayout cardTitle, TextView community, RecyclerView declarationrecycler,
      TextView farmcount, TextView farmerid, CircleImageView farmerimg, TextView farmername,
      TextView header, TextView norecord, TextView norecorddeclaration, TextView norecordsales,
      RecyclerView salestranrecycler, RecyclerView scaletranrecycler, CircleImageView select) {
    super(_bindingComponent, _root, _localFieldCount);
    this.L1 = L1;
    this.L2 = L2;
    this.back = back;
    this.cardTitle = cardTitle;
    this.community = community;
    this.declarationrecycler = declarationrecycler;
    this.farmcount = farmcount;
    this.farmerid = farmerid;
    this.farmerimg = farmerimg;
    this.farmername = farmername;
    this.header = header;
    this.norecord = norecord;
    this.norecorddeclaration = norecorddeclaration;
    this.norecordsales = norecordsales;
    this.salestranrecycler = salestranrecycler;
    this.scaletranrecycler = scaletranrecycler;
    this.select = select;
  }

  @NonNull
  public static ActivityFarmerTransactionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmerTransactionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmerTransactionBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farmer_transaction, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFarmerTransactionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmerTransactionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmerTransactionBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farmer_transaction, null, false, component);
  }

  public static ActivityFarmerTransactionBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFarmerTransactionBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFarmerTransactionBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_farmer_transaction);
  }
}
