package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class FragmentTemplateDialogBinding extends ViewDataBinding {
  @NonNull
  public final ImageView close;

  @NonNull
  public final RecyclerView templateRecycler;

  protected FragmentTemplateDialogBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView close, RecyclerView templateRecycler) {
    super(_bindingComponent, _root, _localFieldCount);
    this.close = close;
    this.templateRecycler = templateRecycler;
  }

  @NonNull
  public static FragmentTemplateDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTemplateDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTemplateDialogBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_template_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentTemplateDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTemplateDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTemplateDialogBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_template_dialog, null, false, component);
  }

  public static FragmentTemplateDialogBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentTemplateDialogBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentTemplateDialogBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_template_dialog);
  }
}
