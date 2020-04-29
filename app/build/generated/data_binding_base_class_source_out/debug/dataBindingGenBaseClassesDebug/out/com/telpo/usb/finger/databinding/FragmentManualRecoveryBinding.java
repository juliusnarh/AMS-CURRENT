package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.RecoveryPojo;

public abstract class FragmentManualRecoveryBinding extends ViewDataBinding {
  @NonNull
  public final Button addBtn;

  @NonNull
  public final TextInputEditText amount;

  @NonNull
  public final TextInputLayout amountLayout;

  @NonNull
  public final LinearLayout cardTitle;

  @NonNull
  public final NestedScrollView container;

  @NonNull
  public final TextInputEditText count;

  @NonNull
  public final TextInputLayout countLayout;

  @NonNull
  public final LinearLayout form;

  @NonNull
  public final LinearLayout forrecovery;

  @NonNull
  public final TextView header;

  @NonNull
  public final TextInputEditText moisture;

  @NonNull
  public final TextInputLayout moistureLayout;

  @NonNull
  public final TextView noowe;

  @NonNull
  public final TextView paidBags;

  @NonNull
  public final TextInputEditText payable;

  @NonNull
  public final TextInputLayout payableLayout;

  @NonNull
  public final TextView remainingBags;

  @NonNull
  public final Button submitBtn;

  @NonNull
  public final TextView totalamount;

  @NonNull
  public final TextView totalweight;

  @NonNull
  public final TextInputEditText weight;

  @NonNull
  public final TextInputLayout weightLayout;

  @Bindable
  protected RecoveryPojo mRecov;

  protected FragmentManualRecoveryBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button addBtn, TextInputEditText amount, TextInputLayout amountLayout,
      LinearLayout cardTitle, NestedScrollView container, TextInputEditText count,
      TextInputLayout countLayout, LinearLayout form, LinearLayout forrecovery, TextView header,
      TextInputEditText moisture, TextInputLayout moistureLayout, TextView noowe, TextView paidBags,
      TextInputEditText payable, TextInputLayout payableLayout, TextView remainingBags,
      Button submitBtn, TextView totalamount, TextView totalweight, TextInputEditText weight,
      TextInputLayout weightLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addBtn = addBtn;
    this.amount = amount;
    this.amountLayout = amountLayout;
    this.cardTitle = cardTitle;
    this.container = container;
    this.count = count;
    this.countLayout = countLayout;
    this.form = form;
    this.forrecovery = forrecovery;
    this.header = header;
    this.moisture = moisture;
    this.moistureLayout = moistureLayout;
    this.noowe = noowe;
    this.paidBags = paidBags;
    this.payable = payable;
    this.payableLayout = payableLayout;
    this.remainingBags = remainingBags;
    this.submitBtn = submitBtn;
    this.totalamount = totalamount;
    this.totalweight = totalweight;
    this.weight = weight;
    this.weightLayout = weightLayout;
  }

  public abstract void setRecov(@Nullable RecoveryPojo recov);

  @Nullable
  public RecoveryPojo getRecov() {
    return mRecov;
  }

  @NonNull
  public static FragmentManualRecoveryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentManualRecoveryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentManualRecoveryBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_manual_recovery, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentManualRecoveryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentManualRecoveryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentManualRecoveryBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_manual_recovery, null, false, component);
  }

  public static FragmentManualRecoveryBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentManualRecoveryBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentManualRecoveryBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_manual_recovery);
  }
}
