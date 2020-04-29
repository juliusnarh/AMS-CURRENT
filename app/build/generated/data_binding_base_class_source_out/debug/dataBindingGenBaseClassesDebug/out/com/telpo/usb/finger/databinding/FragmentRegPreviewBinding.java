package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.telpo.usb.finger.pojo.ActivityInfoPojo;
import com.telpo.usb.finger.pojo.BasicRegistration;
import com.telpo.usb.finger.pojo.BiometricsTaken;
import com.telpo.usb.finger.pojo.FarmRegistrationPojo;
import com.telpo.usb.finger.pojo.ResidentialAddress;

public abstract class FragmentRegPreviewBinding extends ViewDataBinding {
  @NonNull
  public final Button btnback;

  @NonNull
  public final Button btnsave;

  @NonNull
  public final ImageView pic;

  @NonNull
  public final RelativeLayout relact;

  @NonNull
  public final TableLayout reltable;

  @NonNull
  public final ImageView sig;

  @NonNull
  public final TextView txtbioinfo;

  @NonNull
  public final TextView txtfactinfo;

  @NonNull
  public final TextView txtfarminfo;

  @NonNull
  public final TextView txtpinfo;

  @Bindable
  protected BasicRegistration mBasicreg;

  @Bindable
  protected FarmRegistrationPojo mFarmreg;

  @Bindable
  protected ActivityInfoPojo mActivity;

  @Bindable
  protected BiometricsTaken mBio;

  @Bindable
  protected ResidentialAddress mResaddr;

  protected FragmentRegPreviewBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnback, Button btnsave, ImageView pic, RelativeLayout relact,
      TableLayout reltable, ImageView sig, TextView txtbioinfo, TextView txtfactinfo,
      TextView txtfarminfo, TextView txtpinfo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnback = btnback;
    this.btnsave = btnsave;
    this.pic = pic;
    this.relact = relact;
    this.reltable = reltable;
    this.sig = sig;
    this.txtbioinfo = txtbioinfo;
    this.txtfactinfo = txtfactinfo;
    this.txtfarminfo = txtfarminfo;
    this.txtpinfo = txtpinfo;
  }

  public abstract void setBasicreg(@Nullable BasicRegistration basicreg);

  @Nullable
  public BasicRegistration getBasicreg() {
    return mBasicreg;
  }

  public abstract void setFarmreg(@Nullable FarmRegistrationPojo farmreg);

  @Nullable
  public FarmRegistrationPojo getFarmreg() {
    return mFarmreg;
  }

  public abstract void setActivity(@Nullable ActivityInfoPojo activity);

  @Nullable
  public ActivityInfoPojo getActivity() {
    return mActivity;
  }

  public abstract void setBio(@Nullable BiometricsTaken bio);

  @Nullable
  public BiometricsTaken getBio() {
    return mBio;
  }

  public abstract void setResaddr(@Nullable ResidentialAddress resaddr);

  @Nullable
  public ResidentialAddress getResaddr() {
    return mResaddr;
  }

  @NonNull
  public static FragmentRegPreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentRegPreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentRegPreviewBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_reg_preview, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentRegPreviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentRegPreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentRegPreviewBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_reg_preview, null, false, component);
  }

  public static FragmentRegPreviewBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentRegPreviewBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentRegPreviewBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_reg_preview);
  }
}
