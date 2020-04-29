package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.arlib.floatingsearchview.FloatingSearchView;

public abstract class ActivityFarmer2Binding extends ViewDataBinding {
  @NonNull
  public final ImageView amsimg;

  @NonNull
  public final Button btnSearchAggregator;

  @NonNull
  public final Button btnregister;

  @NonNull
  public final Button btnsearch;

  @NonNull
  public final Button btnsearchserver;

  @NonNull
  public final Button btnverify;

  @NonNull
  public final FloatingSearchView floatingSearchView;

  @NonNull
  public final LinearLayout lay1;

  @NonNull
  public final NestedScrollView nsv;

  @NonNull
  public final CoordinatorLayout parentView;

  @NonNull
  public final RecyclerView recycler;

  @NonNull
  public final NestedScrollView recyclerLayout;

  @NonNull
  public final RelativeLayout searchServerLayout;

  protected ActivityFarmer2Binding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView amsimg, Button btnSearchAggregator, Button btnregister,
      Button btnsearch, Button btnsearchserver, Button btnverify,
      FloatingSearchView floatingSearchView, LinearLayout lay1, NestedScrollView nsv,
      CoordinatorLayout parentView, RecyclerView recycler, NestedScrollView recyclerLayout,
      RelativeLayout searchServerLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.amsimg = amsimg;
    this.btnSearchAggregator = btnSearchAggregator;
    this.btnregister = btnregister;
    this.btnsearch = btnsearch;
    this.btnsearchserver = btnsearchserver;
    this.btnverify = btnverify;
    this.floatingSearchView = floatingSearchView;
    this.lay1 = lay1;
    this.nsv = nsv;
    this.parentView = parentView;
    this.recycler = recycler;
    this.recyclerLayout = recyclerLayout;
    this.searchServerLayout = searchServerLayout;
  }

  @NonNull
  public static ActivityFarmer2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmer2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmer2Binding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farmer2, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFarmer2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmer2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmer2Binding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farmer2, null, false, component);
  }

  public static ActivityFarmer2Binding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFarmer2Binding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFarmer2Binding)bind(component, view, com.telpo.usb.finger.R.layout.activity_farmer2);
  }
}
