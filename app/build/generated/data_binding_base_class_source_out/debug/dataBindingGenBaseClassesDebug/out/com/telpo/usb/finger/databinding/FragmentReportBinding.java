package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo;

public abstract class FragmentReportBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout cardTitle;

  @NonNull
  public final FrameLayout container;

  @NonNull
  public final TextView farmersserved;

  @NonNull
  public final TextView farmersservedLabel;

  @NonNull
  public final TextView header;

  @NonNull
  public final LinearLayout ll1;

  @NonNull
  public final LinearLayout ll2;

  @NonNull
  public final LinearLayout ll3;

  @NonNull
  public final LinearLayout ll4;

  @NonNull
  public final LinearLayout ll5;

  @NonNull
  public final LinearLayout ll6;

  @NonNull
  public final ImageView more;

  @NonNull
  public final TextView norecord;

  @NonNull
  public final TextView recoverypercent;

  @NonNull
  public final TextView remainingBags;

  @NonNull
  public final RecyclerView reportRecycler;

  @NonNull
  public final CardView summary;

  @NonNull
  public final TextView totalpayable;

  @NonNull
  public final TextView totalpayableLabel;

  @NonNull
  public final TextView totalpurchases;

  @NonNull
  public final TextView totalrecovery;

  @NonNull
  public final TextView totalrecoveryLabel;

  @NonNull
  public final AppCompatButton viewall;

  @NonNull
  public final LinearLayout viewforsaletransactions;

  @NonNull
  public final AppCompatButton viewinput;

  @NonNull
  public final AppCompatButton viewservices;

  @Bindable
  protected ReportPojo mReport;

  protected FragmentReportBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout cardTitle, FrameLayout container, TextView farmersserved,
      TextView farmersservedLabel, TextView header, LinearLayout ll1, LinearLayout ll2,
      LinearLayout ll3, LinearLayout ll4, LinearLayout ll5, LinearLayout ll6, ImageView more,
      TextView norecord, TextView recoverypercent, TextView remainingBags,
      RecyclerView reportRecycler, CardView summary, TextView totalpayable,
      TextView totalpayableLabel, TextView totalpurchases, TextView totalrecovery,
      TextView totalrecoveryLabel, AppCompatButton viewall, LinearLayout viewforsaletransactions,
      AppCompatButton viewinput, AppCompatButton viewservices) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cardTitle = cardTitle;
    this.container = container;
    this.farmersserved = farmersserved;
    this.farmersservedLabel = farmersservedLabel;
    this.header = header;
    this.ll1 = ll1;
    this.ll2 = ll2;
    this.ll3 = ll3;
    this.ll4 = ll4;
    this.ll5 = ll5;
    this.ll6 = ll6;
    this.more = more;
    this.norecord = norecord;
    this.recoverypercent = recoverypercent;
    this.remainingBags = remainingBags;
    this.reportRecycler = reportRecycler;
    this.summary = summary;
    this.totalpayable = totalpayable;
    this.totalpayableLabel = totalpayableLabel;
    this.totalpurchases = totalpurchases;
    this.totalrecovery = totalrecovery;
    this.totalrecoveryLabel = totalrecoveryLabel;
    this.viewall = viewall;
    this.viewforsaletransactions = viewforsaletransactions;
    this.viewinput = viewinput;
    this.viewservices = viewservices;
  }

  public abstract void setReport(@Nullable ReportPojo report);

  @Nullable
  public ReportPojo getReport() {
    return mReport;
  }

  @NonNull
  public static FragmentReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentReportBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_report, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentReportBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentReportBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_report, null, false, component);
  }

  public static FragmentReportBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentReportBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentReportBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_report);
  }
}
