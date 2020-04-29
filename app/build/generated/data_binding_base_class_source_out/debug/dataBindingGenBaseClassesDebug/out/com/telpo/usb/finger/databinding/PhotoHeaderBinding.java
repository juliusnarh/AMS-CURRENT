package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import de.hdodenhof.circleimageview.CircleImageView;

public abstract class PhotoHeaderBinding extends ViewDataBinding {
  @NonNull
  public final TextView assignToAggregator;

  @NonNull
  public final CircleImageView profilePic;

  @NonNull
  public final TextView summaryfullname;

  @NonNull
  public final TextView summarymobile;

  protected PhotoHeaderBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView assignToAggregator, CircleImageView profilePic,
      TextView summaryfullname, TextView summarymobile) {
    super(_bindingComponent, _root, _localFieldCount);
    this.assignToAggregator = assignToAggregator;
    this.profilePic = profilePic;
    this.summaryfullname = summaryfullname;
    this.summarymobile = summarymobile;
  }

  @NonNull
  public static PhotoHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PhotoHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PhotoHeaderBinding>inflate(inflater, com.telpo.usb.finger.R.layout.photo_header, root, attachToRoot, component);
  }

  @NonNull
  public static PhotoHeaderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PhotoHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PhotoHeaderBinding>inflate(inflater, com.telpo.usb.finger.R.layout.photo_header, null, false, component);
  }

  public static PhotoHeaderBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PhotoHeaderBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PhotoHeaderBinding)bind(component, view, com.telpo.usb.finger.R.layout.photo_header);
  }
}
