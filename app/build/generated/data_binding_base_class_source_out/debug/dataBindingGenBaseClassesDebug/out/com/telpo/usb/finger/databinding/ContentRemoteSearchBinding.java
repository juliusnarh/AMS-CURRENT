package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ContentRemoteSearchBinding extends ViewDataBinding {
  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final TextView searchCount;

  protected ContentRemoteSearchBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ProgressBar progressBar, RecyclerView recyclerView,
      TextView searchCount) {
    super(_bindingComponent, _root, _localFieldCount);
    this.progressBar = progressBar;
    this.recyclerView = recyclerView;
    this.searchCount = searchCount;
  }

  @NonNull
  public static ContentRemoteSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentRemoteSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentRemoteSearchBinding>inflate(inflater, com.telpo.usb.finger.R.layout.content_remote_search, root, attachToRoot, component);
  }

  @NonNull
  public static ContentRemoteSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentRemoteSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentRemoteSearchBinding>inflate(inflater, com.telpo.usb.finger.R.layout.content_remote_search, null, false, component);
  }

  public static ContentRemoteSearchBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentRemoteSearchBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentRemoteSearchBinding)bind(component, view, com.telpo.usb.finger.R.layout.content_remote_search);
  }
}
