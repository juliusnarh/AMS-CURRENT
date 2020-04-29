package com.telpo.usb.finger.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
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

public abstract class FragmentChartBinding extends ViewDataBinding {
  @NonNull
  public final BarChart agebarchart;

  @NonNull
  public final FrameLayout container;

  @NonNull
  public final TextView declarationLabel;

  @NonNull
  public final PieChart genderpiechart;

  @NonNull
  public final ImageView imore;

  @NonNull
  public final LineChart recoverytransactionlinechart;

  @NonNull
  public final PieChart recoverytransactionpiechart;

  @NonNull
  public final BarChart salestrantotalrevenue;

  @NonNull
  public final PieChart saletransaction;

  @NonNull
  public final ImageView vmore;

  @Bindable
  protected ChartPojo mChart;

  protected FragmentChartBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, BarChart agebarchart, FrameLayout container, TextView declarationLabel,
      PieChart genderpiechart, ImageView imore, LineChart recoverytransactionlinechart,
      PieChart recoverytransactionpiechart, BarChart salestrantotalrevenue,
      PieChart saletransaction, ImageView vmore) {
    super(_bindingComponent, _root, _localFieldCount);
    this.agebarchart = agebarchart;
    this.container = container;
    this.declarationLabel = declarationLabel;
    this.genderpiechart = genderpiechart;
    this.imore = imore;
    this.recoverytransactionlinechart = recoverytransactionlinechart;
    this.recoverytransactionpiechart = recoverytransactionpiechart;
    this.salestrantotalrevenue = salestrantotalrevenue;
    this.saletransaction = saletransaction;
    this.vmore = vmore;
  }

  public abstract void setChart(@Nullable ChartPojo chart);

  @Nullable
  public ChartPojo getChart() {
    return mChart;
  }

  @NonNull
  public static FragmentChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentChartBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_chart, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentChartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentChartBinding>inflate(inflater, com.telpo.usb.finger.R.layout.fragment_chart, null, false, component);
  }

  public static FragmentChartBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentChartBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentChartBinding)bind(component, view, com.telpo.usb.finger.R.layout.fragment_chart);
  }
}
