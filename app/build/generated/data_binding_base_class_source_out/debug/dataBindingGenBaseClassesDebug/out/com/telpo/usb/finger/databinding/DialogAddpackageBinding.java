package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class DialogAddpackageBinding extends ViewDataBinding {
  @NonNull
  public final ImageView close;

  @NonNull
  public final TextView noitem;

  @NonNull
  public final TextView noitemdetails;

  @NonNull
  public final EditText packname;

  @NonNull
  public final EditText recoverybags;

  @NonNull
  public final RecyclerView recycler;

  @NonNull
  public final FloatingActionButton save;

  @NonNull
  public final TextView selectedInputs;

  @NonNull
  public final RecyclerView selectedrecycler;

  protected DialogAddpackageBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView close, TextView noitem, TextView noitemdetails,
      EditText packname, EditText recoverybags, RecyclerView recycler, FloatingActionButton save,
      TextView selectedInputs, RecyclerView selectedrecycler) {
    super(_bindingComponent, _root, _localFieldCount);
    this.close = close;
    this.noitem = noitem;
    this.noitemdetails = noitemdetails;
    this.packname = packname;
    this.recoverybags = recoverybags;
    this.recycler = recycler;
    this.save = save;
    this.selectedInputs = selectedInputs;
    this.selectedrecycler = selectedrecycler;
  }

  @NonNull
  public static DialogAddpackageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogAddpackageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogAddpackageBinding>inflate(inflater, com.telpo.usb.finger.R.layout.dialog_addpackage, root, attachToRoot, component);
  }

  @NonNull
  public static DialogAddpackageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogAddpackageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogAddpackageBinding>inflate(inflater, com.telpo.usb.finger.R.layout.dialog_addpackage, null, false, component);
  }

  public static DialogAddpackageBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogAddpackageBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogAddpackageBinding)bind(component, view, com.telpo.usb.finger.R.layout.dialog_addpackage);
  }
}
