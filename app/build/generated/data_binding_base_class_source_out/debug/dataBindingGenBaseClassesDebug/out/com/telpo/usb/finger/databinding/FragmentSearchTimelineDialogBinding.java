package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentSearchTimelineDialogBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout Ll;

  @NonNull
  public final ImageView close;

  @NonNull
  public final TextView header;

  @NonNull
  public final Button searchBtn;

  @NonNull
  public final EditText timelineend;

  @NonNull
  public final EditText timelinestart;

  protected FragmentSearchTimelineDialogBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout Ll, ImageView close, TextView header, Button searchBtn,
      EditText timelineend, EditText timelinestart) {
    super(_bindingComponent, _root, _localFieldCount);
    this.Ll = Ll;
    this.close = close;
    this.header = header;
    this.searchBtn = searchBtn;
    this.timelineend = timelineend;
    this.timelinestart = timelinestart;
  }

  @NonNull
  public static FragmentSearchTimelineDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSearchTimelineDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSearchTimelineDialogBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_search_timeline_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSearchTimelineDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSearchTimelineDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSearchTimelineDialogBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_search_timeline_dialog, null, false, component);
  }

  public static FragmentSearchTimelineDialogBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentSearchTimelineDialogBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentSearchTimelineDialogBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_search_timeline_dialog);
  }
}
