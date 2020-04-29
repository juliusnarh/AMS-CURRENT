package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;

public abstract class CartBottomSheetBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout itemBottomSheet;

  @NonNull
  public final TextView noOrder;

  @NonNull
  public final AppCompatButton proceedBtn;

  @NonNull
  public final RecyclerView recyclerCart;

  @NonNull
  public final Button resetBtn;

  @NonNull
  public final MaterialRippleLayout rippleButton;

  @NonNull
  public final TextView total;

  protected CartBottomSheetBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout itemBottomSheet, TextView noOrder,
      AppCompatButton proceedBtn, RecyclerView recyclerCart, Button resetBtn,
      MaterialRippleLayout rippleButton, TextView total) {
    super(_bindingComponent, _root, _localFieldCount);
    this.itemBottomSheet = itemBottomSheet;
    this.noOrder = noOrder;
    this.proceedBtn = proceedBtn;
    this.recyclerCart = recyclerCart;
    this.resetBtn = resetBtn;
    this.rippleButton = rippleButton;
    this.total = total;
  }

  @NonNull
  public static CartBottomSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static CartBottomSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<CartBottomSheetBinding>inflate(inflater, com.telpo.usb.finger.R.layout.cart_bottom_sheet, root, attachToRoot, component);
  }

  @NonNull
  public static CartBottomSheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static CartBottomSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<CartBottomSheetBinding>inflate(inflater, com.telpo.usb.finger.R.layout.cart_bottom_sheet, null, false, component);
  }

  public static CartBottomSheetBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static CartBottomSheetBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (CartBottomSheetBinding)bind(component, view, com.telpo.usb.finger.R.layout.cart_bottom_sheet);
  }
}
