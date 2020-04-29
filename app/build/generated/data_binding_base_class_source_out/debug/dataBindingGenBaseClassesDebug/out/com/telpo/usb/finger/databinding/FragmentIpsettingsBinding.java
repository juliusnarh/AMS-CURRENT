package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.telpo.usb.finger.pojo.IPSettingsPojo;

public abstract class FragmentIpsettingsBinding extends ViewDataBinding {
  @NonNull
  public final Button btnsave;

  @NonNull
  public final TextView txtcomplete;

  @NonNull
  public final EditText txtcontext;

  @NonNull
  public final EditText txtip;

  @NonNull
  public final EditText txtport;

  @NonNull
  public final EditText txtprotocol;

  @Bindable
  protected IPSettingsPojo mIp;

  protected FragmentIpsettingsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnsave, TextView txtcomplete, EditText txtcontext,
      EditText txtip, EditText txtport, EditText txtprotocol) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnsave = btnsave;
    this.txtcomplete = txtcomplete;
    this.txtcontext = txtcontext;
    this.txtip = txtip;
    this.txtport = txtport;
    this.txtprotocol = txtprotocol;
  }

  public abstract void setIp(@Nullable IPSettingsPojo ip);

  @Nullable
  public IPSettingsPojo getIp() {
    return mIp;
  }

  @NonNull
  public static FragmentIpsettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentIpsettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentIpsettingsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_ipsettings, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentIpsettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentIpsettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentIpsettingsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_ipsettings, null, false, component);
  }

  public static FragmentIpsettingsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentIpsettingsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentIpsettingsBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_ipsettings);
  }
}
