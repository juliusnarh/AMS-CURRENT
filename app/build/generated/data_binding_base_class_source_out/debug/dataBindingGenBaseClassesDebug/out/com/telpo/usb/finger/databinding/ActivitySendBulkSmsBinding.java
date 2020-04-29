package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hootsuite.nachos.NachoTextView;

public abstract class ActivitySendBulkSmsBinding extends ViewDataBinding {
  @NonNull
  public final Button addaggregators;

  @NonNull
  public final EditText messagebody;

  @NonNull
  public final FloatingActionButton send;

  @NonNull
  public final EditText subject;

  @NonNull
  public final NachoTextView to;

  @NonNull
  public final Toolbar toolbar;

  protected ActivitySendBulkSmsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button addaggregators, EditText messagebody, FloatingActionButton send,
      EditText subject, NachoTextView to, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addaggregators = addaggregators;
    this.messagebody = messagebody;
    this.send = send;
    this.subject = subject;
    this.to = to;
    this.toolbar = toolbar;
  }

  @NonNull
  public static ActivitySendBulkSmsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySendBulkSmsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySendBulkSmsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_send_bulk_sms, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySendBulkSmsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySendBulkSmsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySendBulkSmsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_send_bulk_sms, null, false, component);
  }

  public static ActivitySendBulkSmsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySendBulkSmsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySendBulkSmsBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_send_bulk_sms);
  }
}
