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
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import at.grabner.circleprogress.CircleProgressView;
import de.hdodenhof.circleimageview.CircleImageView;

public abstract class ActivityDetailsBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout L1;

  @NonNull
  public final LinearLayout L2;

  @NonNull
  public final TextView amount;

  @NonNull
  public final TextView amountLayout;

  @NonNull
  public final TextView amountowing;

  @NonNull
  public final TextView amountowingLayout;

  @NonNull
  public final ImageView back;

  @NonNull
  public final TextView community;

  @NonNull
  public final TextView count;

  @NonNull
  public final TextView countLayout;

  @NonNull
  public final TextView date;

  @NonNull
  public final TextView dateLayout;

  @NonNull
  public final TextView declaration;

  @NonNull
  public final TextView declarationLabel;

  @NonNull
  public final TextView farmcount;

  @NonNull
  public final TextView farmerid;

  @NonNull
  public final CircleImageView farmerimg;

  @NonNull
  public final TextView farmername;

  @NonNull
  public final CircleProgressView farmerprogress;

  @NonNull
  public final CircleImageView modifyRecovery;

  @NonNull
  public final TextView payable;

  @NonNull
  public final TextView payableLayout;

  @NonNull
  public final TextView pcid;

  @NonNull
  public final TextView pcidLayout;

  @NonNull
  public final TextView tendered;

  @NonNull
  public final TextView tenderedLayout;

  @NonNull
  public final TextView tenderedprogress;

  @NonNull
  public final TextView transactionDetails;

  @NonNull
  public final TextView transid;

  @NonNull
  public final TextView weight;

  @NonNull
  public final TextView weightLayout;

  protected ActivityDetailsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RelativeLayout L1, LinearLayout L2, TextView amount,
      TextView amountLayout, TextView amountowing, TextView amountowingLayout, ImageView back,
      TextView community, TextView count, TextView countLayout, TextView date, TextView dateLayout,
      TextView declaration, TextView declarationLabel, TextView farmcount, TextView farmerid,
      CircleImageView farmerimg, TextView farmername, CircleProgressView farmerprogress,
      CircleImageView modifyRecovery, TextView payable, TextView payableLayout, TextView pcid,
      TextView pcidLayout, TextView tendered, TextView tenderedLayout, TextView tenderedprogress,
      TextView transactionDetails, TextView transid, TextView weight, TextView weightLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.L1 = L1;
    this.L2 = L2;
    this.amount = amount;
    this.amountLayout = amountLayout;
    this.amountowing = amountowing;
    this.amountowingLayout = amountowingLayout;
    this.back = back;
    this.community = community;
    this.count = count;
    this.countLayout = countLayout;
    this.date = date;
    this.dateLayout = dateLayout;
    this.declaration = declaration;
    this.declarationLabel = declarationLabel;
    this.farmcount = farmcount;
    this.farmerid = farmerid;
    this.farmerimg = farmerimg;
    this.farmername = farmername;
    this.farmerprogress = farmerprogress;
    this.modifyRecovery = modifyRecovery;
    this.payable = payable;
    this.payableLayout = payableLayout;
    this.pcid = pcid;
    this.pcidLayout = pcidLayout;
    this.tendered = tendered;
    this.tenderedLayout = tenderedLayout;
    this.tenderedprogress = tenderedprogress;
    this.transactionDetails = transactionDetails;
    this.transid = transid;
    this.weight = weight;
    this.weightLayout = weightLayout;
  }

  @NonNull
  public static ActivityDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDetailsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_details, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDetailsBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_details, null, false, component);
  }

  public static ActivityDetailsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityDetailsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityDetailsBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_details);
  }
}
