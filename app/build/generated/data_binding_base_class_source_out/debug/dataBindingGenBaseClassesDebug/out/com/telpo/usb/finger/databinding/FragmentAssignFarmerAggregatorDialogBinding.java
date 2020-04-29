package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;

public abstract class FragmentAssignFarmerAggregatorDialogBinding extends ViewDataBinding {
  @NonNull
  public final ImageView close;

  @NonNull
  public final MaterialRippleLayout closeContainer;

  @NonNull
  public final TextView loadMore;

  @NonNull
  public final MaterialRippleLayout loadMoreContainer;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RecyclerView recyclerView;

  protected FragmentAssignFarmerAggregatorDialogBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, ImageView close, MaterialRippleLayout closeContainer,
      TextView loadMore, MaterialRippleLayout loadMoreContainer, ProgressBar progressBar,
      RecyclerView recyclerView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.close = close;
    this.closeContainer = closeContainer;
    this.loadMore = loadMore;
    this.loadMoreContainer = loadMoreContainer;
    this.progressBar = progressBar;
    this.recyclerView = recyclerView;
  }

  @NonNull
  public static FragmentAssignFarmerAggregatorDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAssignFarmerAggregatorDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAssignFarmerAggregatorDialogBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_assign_farmer_aggregator_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAssignFarmerAggregatorDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAssignFarmerAggregatorDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAssignFarmerAggregatorDialogBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_assign_farmer_aggregator_dialog, null, false, component);
  }

  public static FragmentAssignFarmerAggregatorDialogBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentAssignFarmerAggregatorDialogBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentAssignFarmerAggregatorDialogBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_assign_farmer_aggregator_dialog);
  }
}
