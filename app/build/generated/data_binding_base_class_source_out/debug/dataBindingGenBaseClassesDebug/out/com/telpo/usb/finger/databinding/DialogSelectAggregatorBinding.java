package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class DialogSelectAggregatorBinding extends ViewDataBinding {
  @NonNull
  public final ImageView close;

  @NonNull
  public final TextView norecord;

  @NonNull
  public final TextView numberselected;

  @NonNull
  public final RecyclerView recycler;

  @NonNull
  public final FloatingActionButton save;

  protected DialogSelectAggregatorBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView close, TextView norecord, TextView numberselected,
      RecyclerView recycler, FloatingActionButton save) {
    super(_bindingComponent, _root, _localFieldCount);
    this.close = close;
    this.norecord = norecord;
    this.numberselected = numberselected;
    this.recycler = recycler;
    this.save = save;
  }

  @NonNull
  public static DialogSelectAggregatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogSelectAggregatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogSelectAggregatorBinding>inflate(inflater, com.telpo.usb.finger.R.layout.dialog_select_aggregator, root, attachToRoot, component);
  }

  @NonNull
  public static DialogSelectAggregatorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogSelectAggregatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogSelectAggregatorBinding>inflate(inflater, com.telpo.usb.finger.R.layout.dialog_select_aggregator, null, false, component);
  }

  public static DialogSelectAggregatorBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogSelectAggregatorBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogSelectAggregatorBinding)bind(component, view, com.telpo.usb.finger.R.layout.dialog_select_aggregator);
  }
}
