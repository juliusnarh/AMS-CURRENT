package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo;

public abstract class FragmentChartbackupBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout container;

  @NonNull
  public final PieChart declaration1;

  @NonNull
  public final PieChart demo1;

  @NonNull
  public final BarChart demo2;

  @NonNull
  public final BarChart inventory1;

  @NonNull
  public final PieChart salestran1;

  @NonNull
  public final BarChart salestran2;

  @NonNull
  public final PieChart scaletran2;

  @NonNull
  public final LineChart scaletran3;

  @Bindable
  protected ChartPojo mChart;

  protected FragmentChartbackupBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FrameLayout container, PieChart declaration1, PieChart demo1,
      BarChart demo2, BarChart inventory1, PieChart salestran1, BarChart salestran2,
      PieChart scaletran2, LineChart scaletran3) {
    super(_bindingComponent, _root, _localFieldCount);
    this.container = container;
    this.declaration1 = declaration1;
    this.demo1 = demo1;
    this.demo2 = demo2;
    this.inventory1 = inventory1;
    this.salestran1 = salestran1;
    this.salestran2 = salestran2;
    this.scaletran2 = scaletran2;
    this.scaletran3 = scaletran3;
  }

  public abstract void setChart(@Nullable ChartPojo chart);

  @Nullable
  public ChartPojo getChart() {
    return mChart;
  }

  @NonNull
  public static FragmentChartbackupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentChartbackupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentChartbackupBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_chartbackup, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentChartbackupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentChartbackupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentChartbackupBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_chartbackup, null, false, component);
  }

  public static FragmentChartbackupBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentChartbackupBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentChartbackupBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_chartbackup);
  }
}
