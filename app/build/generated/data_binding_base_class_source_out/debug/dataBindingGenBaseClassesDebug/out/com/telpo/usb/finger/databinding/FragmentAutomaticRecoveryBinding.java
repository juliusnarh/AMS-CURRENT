package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;

public abstract class FragmentAutomaticRecoveryBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView autoscaleRecycler;

  @NonNull
  public final RelativeLayout connect;

  @NonNull
  public final TextView connectedlabel;

  @NonNull
  public final NestedScrollView container;

  @NonNull
  public final LinearLayout datalayout;

  @NonNull
  public final LottieAnimationView emptyFolder;

  @NonNull
  public final ImageView img;

  @NonNull
  public final RelativeLayout save;

  @NonNull
  public final TextView saveLabel;

  @NonNull
  public final LinearLayout verifyUpload;

  @NonNull
  public final TextView waiting;

  @NonNull
  public final TextView weighingstart;

  @NonNull
  public final ImageView wifiConnected;

  @NonNull
  public final LottieAnimationView wifiDisconnected;

  protected FragmentAutomaticRecoveryBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView autoscaleRecycler, RelativeLayout connect,
      TextView connectedlabel, NestedScrollView container, LinearLayout datalayout,
      LottieAnimationView emptyFolder, ImageView img, RelativeLayout save, TextView saveLabel,
      LinearLayout verifyUpload, TextView waiting, TextView weighingstart, ImageView wifiConnected,
      LottieAnimationView wifiDisconnected) {
    super(_bindingComponent, _root, _localFieldCount);
    this.autoscaleRecycler = autoscaleRecycler;
    this.connect = connect;
    this.connectedlabel = connectedlabel;
    this.container = container;
    this.datalayout = datalayout;
    this.emptyFolder = emptyFolder;
    this.img = img;
    this.save = save;
    this.saveLabel = saveLabel;
    this.verifyUpload = verifyUpload;
    this.waiting = waiting;
    this.weighingstart = weighingstart;
    this.wifiConnected = wifiConnected;
    this.wifiDisconnected = wifiDisconnected;
  }

  @NonNull
  public static FragmentAutomaticRecoveryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAutomaticRecoveryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAutomaticRecoveryBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_automatic_recovery, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAutomaticRecoveryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAutomaticRecoveryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAutomaticRecoveryBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_automatic_recovery, null, false, component);
  }

  public static FragmentAutomaticRecoveryBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentAutomaticRecoveryBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentAutomaticRecoveryBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_automatic_recovery);
  }
}
