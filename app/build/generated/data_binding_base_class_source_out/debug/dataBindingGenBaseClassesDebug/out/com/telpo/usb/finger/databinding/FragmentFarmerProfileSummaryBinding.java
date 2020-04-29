package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.silencedut.expandablelayout.ExpandableLayout;
import com.telpo.usb.finger.pojo.BasicRegistration;
import com.telpo.usb.finger.pojo.BiometricsTaken;
import com.telpo.usb.finger.pojo.ResidentialAddress;

public abstract class FragmentFarmerProfileSummaryBinding extends ViewDataBinding {
  @NonNull
  public final Button addhousehold;

  @NonNull
  public final ImageView bioarrow;

  @NonNull
  public final TextView bioheader;

  @NonNull
  public final ImageView docsarrow;

  @NonNull
  public final TextView docsheader;

  @NonNull
  public final Button editbio;

  @NonNull
  public final Button editdocs;

  @NonNull
  public final Button editgeoaddr;

  @NonNull
  public final Button editpersonalinfo;

  @NonNull
  public final ExpandableLayout expandableBiometricLayout;

  @NonNull
  public final ExpandableLayout expandableDocsLayout;

  @NonNull
  public final ExpandableLayout expandableHouseholdLayout;

  @NonNull
  public final ExpandableLayout expandablePersonalinfoLayout;

  @NonNull
  public final RecyclerView householdRecyclerview;

  @NonNull
  public final TextView householdstats;

  @NonNull
  public final ImageView hseholdarrow;

  @NonNull
  public final TextView hseholdheader;

  @NonNull
  public final ImageView personalarrow;

  @NonNull
  public final TextView personalheader;

  @NonNull
  public final ImageView pic;

  @NonNull
  public final RecyclerView scandocrecycler;

  @NonNull
  public final ImageView sig;

  @Bindable
  protected BasicRegistration mBasicreg;

  @Bindable
  protected BiometricsTaken mBio;

  @Bindable
  protected ResidentialAddress mResaddr;

  protected FragmentFarmerProfileSummaryBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button addhousehold, ImageView bioarrow, TextView bioheader,
      ImageView docsarrow, TextView docsheader, Button editbio, Button editdocs, Button editgeoaddr,
      Button editpersonalinfo, ExpandableLayout expandableBiometricLayout,
      ExpandableLayout expandableDocsLayout, ExpandableLayout expandableHouseholdLayout,
      ExpandableLayout expandablePersonalinfoLayout, RecyclerView householdRecyclerview,
      TextView householdstats, ImageView hseholdarrow, TextView hseholdheader,
      ImageView personalarrow, TextView personalheader, ImageView pic, RecyclerView scandocrecycler,
      ImageView sig) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addhousehold = addhousehold;
    this.bioarrow = bioarrow;
    this.bioheader = bioheader;
    this.docsarrow = docsarrow;
    this.docsheader = docsheader;
    this.editbio = editbio;
    this.editdocs = editdocs;
    this.editgeoaddr = editgeoaddr;
    this.editpersonalinfo = editpersonalinfo;
    this.expandableBiometricLayout = expandableBiometricLayout;
    this.expandableDocsLayout = expandableDocsLayout;
    this.expandableHouseholdLayout = expandableHouseholdLayout;
    this.expandablePersonalinfoLayout = expandablePersonalinfoLayout;
    this.householdRecyclerview = householdRecyclerview;
    this.householdstats = householdstats;
    this.hseholdarrow = hseholdarrow;
    this.hseholdheader = hseholdheader;
    this.personalarrow = personalarrow;
    this.personalheader = personalheader;
    this.pic = pic;
    this.scandocrecycler = scandocrecycler;
    this.sig = sig;
  }

  public abstract void setBasicreg(@Nullable BasicRegistration basicreg);

  @Nullable
  public BasicRegistration getBasicreg() {
    return mBasicreg;
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
  public static FragmentFarmerProfileSummaryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFarmerProfileSummaryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFarmerProfileSummaryBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_farmer_profile_summary, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFarmerProfileSummaryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFarmerProfileSummaryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFarmerProfileSummaryBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_farmer_profile_summary, null, false, component);
  }

  public static FragmentFarmerProfileSummaryBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentFarmerProfileSummaryBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentFarmerProfileSummaryBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_farmer_profile_summary);
  }
}
