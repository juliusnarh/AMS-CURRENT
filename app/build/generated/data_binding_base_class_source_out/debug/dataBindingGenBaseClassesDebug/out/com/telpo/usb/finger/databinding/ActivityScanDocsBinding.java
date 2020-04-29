package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ActivityScanDocsBinding extends ViewDataBinding {
  @NonNull
  public final Button btnsave;

  @NonNull
  public final EditText doctype;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final RelativeLayout rl;

  @NonNull
  public final RecyclerView scandocrecycler;

  protected ActivityScanDocsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnsave, EditText doctype, LinearLayout linearLayout,
      RelativeLayout rl, RecyclerView scandocrecycler) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnsave = btnsave;
    this.doctype = doctype;
    this.linearLayout = linearLayout;
    this.rl = rl;
    this.scandocrecycler = scandocrecycler;
  }

  @NonNull
  public static ActivityScanDocsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityScanDocsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityScanDocsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_scan_docs, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityScanDocsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityScanDocsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityScanDocsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_scan_docs, null, false, component);
  }

  public static ActivityScanDocsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityScanDocsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityScanDocsBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_scan_docs);
  }
}
