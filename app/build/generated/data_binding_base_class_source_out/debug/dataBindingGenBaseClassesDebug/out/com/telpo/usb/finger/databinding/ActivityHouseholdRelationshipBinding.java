package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityHouseholdRelationshipBinding extends ViewDataBinding {
  @NonNull
  public final Button btncancel;

  @NonNull
  public final Button btnsave;

  @NonNull
  public final ImageView pic;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView txtfullname;

  @NonNull
  public final TextView txtidcard;

  @NonNull
  public final TextView txtmobile;

  @NonNull
  public final EditText txtrelationship;

  protected ActivityHouseholdRelationshipBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btncancel, Button btnsave, ImageView pic, TextView textView7,
      TextView txtfullname, TextView txtidcard, TextView txtmobile, EditText txtrelationship) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btncancel = btncancel;
    this.btnsave = btnsave;
    this.pic = pic;
    this.textView7 = textView7;
    this.txtfullname = txtfullname;
    this.txtidcard = txtidcard;
    this.txtmobile = txtmobile;
    this.txtrelationship = txtrelationship;
  }

  @NonNull
  public static ActivityHouseholdRelationshipBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityHouseholdRelationshipBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityHouseholdRelationshipBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_household_relationship, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityHouseholdRelationshipBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityHouseholdRelationshipBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityHouseholdRelationshipBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_household_relationship, null, false, component);
  }

  public static ActivityHouseholdRelationshipBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityHouseholdRelationshipBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityHouseholdRelationshipBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_household_relationship);
  }
}
