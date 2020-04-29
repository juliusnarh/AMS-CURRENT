package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public abstract class ActivityFarmMapPolygonBinding extends ViewDataBinding {
  @NonNull
  public final TextView addresssResults;

  @NonNull
  public final FloatingActionButton btnaddcoord;

  @NonNull
  public final TextView coords;

  @NonNull
  public final FloatingActionMenu menu;

  @NonNull
  public final FloatingActionButton menuGeocode;

  @NonNull
  public final FloatingActionButton menuPlot;

  @NonNull
  public final FloatingActionButton menuSave;

  protected ActivityFarmMapPolygonBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView addresssResults, FloatingActionButton btnaddcoord,
      TextView coords, FloatingActionMenu menu, FloatingActionButton menuGeocode,
      FloatingActionButton menuPlot, FloatingActionButton menuSave) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addresssResults = addresssResults;
    this.btnaddcoord = btnaddcoord;
    this.coords = coords;
    this.menu = menu;
    this.menuGeocode = menuGeocode;
    this.menuPlot = menuPlot;
    this.menuSave = menuSave;
  }

  @NonNull
  public static ActivityFarmMapPolygonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmMapPolygonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmMapPolygonBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farm_map_polygon, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFarmMapPolygonBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFarmMapPolygonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFarmMapPolygonBinding>inflate(inflater, com.telpo.usb.finger.R.layout.activity_farm_map_polygon, null, false, component);
  }

  public static ActivityFarmMapPolygonBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFarmMapPolygonBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFarmMapPolygonBinding)bind(component, view, com.telpo.usb.finger.R.layout.activity_farm_map_polygon);
  }
}
