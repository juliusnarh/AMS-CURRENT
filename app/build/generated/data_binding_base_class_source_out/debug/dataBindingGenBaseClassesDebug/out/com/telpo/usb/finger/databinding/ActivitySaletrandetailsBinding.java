package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public abstract class ActivitySaletrandetailsBinding extends ViewDataBinding {
  @NonNull
  public final TextView acreage;

  @NonNull
  public final TextView acreageLayout;

  @NonNull
  public final TextView agent;

  @NonNull
  public final TextView agentLayout;

  @NonNull
  public final ImageView back;

  @NonNull
  public final TextView bagspayable;

  @NonNull
  public final TextView changeLayout;

  @NonNull
  public final TextView community;

  @NonNull
  public final TextView cost;

  @NonNull
  public final TextView costLayout;

  @NonNull
  public final TextView date;

  @NonNull
  public final TextView dateLayout;

  @NonNull
  public final TextView declarationLabel;

  @NonNull
  public final TextView farmcount;

  @NonNull
  public final TextView farmerid;

  @NonNull
  public final CircleImageView farmerimg;

  @NonNull
  public final TextView farmername;

  @NonNull
  public final TextView pmethod;

  @NonNull
  public final TextView pmethodLayout;

  @NonNull
  public final RecyclerView recycler;

  @NonNull
  public final TextView sub;

  @NonNull
  public final TextView subLayout;

  @NonNull
  public final CardView summary;

  @NonNull
  public final TextView tendered;

  @NonNull
  public final TextView tenderedLayout;

  @NonNull
  public final LinearLayout tooltip1;

  @NonNull
  public final TextView transid;

  protected ActivitySaletrandetailsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView acreage, TextView acreageLayout, TextView agent,
      TextView agentLayout, ImageView back, TextView bagspayable, TextView changeLayout,
      TextView community, TextView cost, TextView costLayout, TextView date, TextView dateLayout,
      TextView declarationLabel, TextView farmcount, TextView farmerid, CircleImageView farmerimg,
      TextView farmername, TextView pmethod, TextView pmethodLayout, RecyclerView recycler,
      TextView sub, TextView subLayout, CardView summary, TextView tendered,
      TextView tenderedLayout, LinearLayout tooltip1, TextView transid) {
    super(_bindingComponent, _root, _localFieldCount);
    this.acreage = acreage;
    this.acreageLayout = acreageLayout;
    this.agent = agent;
    this.agentLayout = agentLayout;
    this.back = back;
    this.bagspayable = bagspayable;
    this.changeLayout = changeLayout;
    this.community = community;
    this.cost = cost;
    this.costLayout = costLayout;
    this.date = date;
    this.dateLayout = dateLayout;
    this.declarationLabel = declarationLabel;
    this.farmcount = farmcount;
    this.farmerid = farmerid;
    this.farmerimg = farmerimg;
    this.farmername = farmername;
    this.pmethod = pmethod;
    this.pmethodLayout = pmethodLayout;
    this.recycler = recycler;
    this.sub = sub;
    this.subLayout = subLayout;
    this.summary = summary;
    this.tendered = tendered;
    this.tenderedLayout = tenderedLayout;
    this.tooltip1 = tooltip1;
    this.transid = transid;
  }

  @NonNull
  public static ActivitySaletrandetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySaletrandetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySaletrandetailsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_saletrandetails, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySaletrandetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySaletrandetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySaletrandetailsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_saletrandetails, null, false, component);
  }

  public static ActivitySaletrandetailsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySaletrandetailsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySaletrandetailsBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_saletrandetails);
  }
}
