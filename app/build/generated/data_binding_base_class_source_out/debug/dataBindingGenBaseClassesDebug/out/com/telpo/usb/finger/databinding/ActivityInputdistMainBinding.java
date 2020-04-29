package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.telpo.usb.finger.utils.SimpleToolbar;

public abstract class ActivityInputdistMainBinding extends ViewDataBinding {
  @NonNull
  public final FloatingActionButton bottomfab;

  @NonNull
  public final CartBottomSheetBinding bottomsheetIncluded;

  @NonNull
  public final CardView farmerCard;

  @NonNull
  public final TextView farmerCode;

  @NonNull
  public final ImageView farmerImg;

  @NonNull
  public final TextView farmerName;

  @NonNull
  public final TextView farmerNumber;

  @NonNull
  public final RecyclerItemsBinding itemsIncluded;

  @NonNull
  public final CoordinatorLayout mainContent;

  @NonNull
  public final SimpleToolbar mainToolbar;

  @NonNull
  public final TextView products;

  @NonNull
  public final RecyclerServiceBinding serviceIncluded;

  @NonNull
  public final TextView services;

  @NonNull
  public final NestedScrollView snuffooo;

  @NonNull
  public final FrameLayout snuffooo2;

  @NonNull
  public final Button subsidizedBtn;

  protected ActivityInputdistMainBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FloatingActionButton bottomfab,
      CartBottomSheetBinding bottomsheetIncluded, CardView farmerCard, TextView farmerCode,
      ImageView farmerImg, TextView farmerName, TextView farmerNumber,
      RecyclerItemsBinding itemsIncluded, CoordinatorLayout mainContent, SimpleToolbar mainToolbar,
      TextView products, RecyclerServiceBinding serviceIncluded, TextView services,
      NestedScrollView snuffooo, FrameLayout snuffooo2, Button subsidizedBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomfab = bottomfab;
    this.bottomsheetIncluded = bottomsheetIncluded;
    setContainedBinding(this.bottomsheetIncluded);;
    this.farmerCard = farmerCard;
    this.farmerCode = farmerCode;
    this.farmerImg = farmerImg;
    this.farmerName = farmerName;
    this.farmerNumber = farmerNumber;
    this.itemsIncluded = itemsIncluded;
    setContainedBinding(this.itemsIncluded);;
    this.mainContent = mainContent;
    this.mainToolbar = mainToolbar;
    this.products = products;
    this.serviceIncluded = serviceIncluded;
    setContainedBinding(this.serviceIncluded);;
    this.services = services;
    this.snuffooo = snuffooo;
    this.snuffooo2 = snuffooo2;
    this.subsidizedBtn = subsidizedBtn;
  }

  @NonNull
  public static ActivityInputdistMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityInputdistMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityInputdistMainBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_inputdist_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityInputdistMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityInputdistMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityInputdistMainBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_inputdist_main, null, false, component);
  }

  public static ActivityInputdistMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityInputdistMainBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityInputdistMainBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_inputdist_main);
  }
}
