package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

public abstract class ActivityRecoveryBinding extends ViewDataBinding {
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
  public final NavigationTabStrip ntsBottom;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final ViewPager viewpager;

  protected ActivityRecoveryBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CardView farmerCard, TextView farmerCode, ImageView farmerImg,
      TextView farmerName, TextView farmerNumber, NavigationTabStrip ntsBottom, Toolbar toolbar,
      ViewPager viewpager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.farmerCard = farmerCard;
    this.farmerCode = farmerCode;
    this.farmerImg = farmerImg;
    this.farmerName = farmerName;
    this.farmerNumber = farmerNumber;
    this.ntsBottom = ntsBottom;
    this.toolbar = toolbar;
    this.viewpager = viewpager;
  }

  @NonNull
  public static ActivityRecoveryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityRecoveryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityRecoveryBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_recovery, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityRecoveryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityRecoveryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityRecoveryBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_recovery, null, false, component);
  }

  public static ActivityRecoveryBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityRecoveryBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityRecoveryBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_recovery);
  }
}
