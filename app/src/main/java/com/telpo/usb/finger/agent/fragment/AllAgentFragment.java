package com.telpo.usb.finger.agent.fragment;


import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.airbnb.lottie.LottieAnimationView;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.AgentActivity;
import com.telpo.usb.finger.activities.FarmerSearchView;
import com.telpo.usb.finger.activities.input.distribution.DetailsActivity;
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.DeclarationAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.FarmAssessmentAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.HomeAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.PaymentStyleAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.ProdFromDealerAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.SalestranAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.ScaletranAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.ServiceSummaryAdapter;
import com.telpo.usb.finger.databinding.FragmentActionsBinding;
import com.telpo.usb.finger.databinding.FragmentChartBinding;
import com.telpo.usb.finger.databinding.FragmentHomeBinding;
import com.telpo.usb.finger.databinding.FragmentReportBinding;
import com.telpo.usb.finger.dialogforms.ReadChartValuesDialog;
import com.telpo.usb.finger.dialogforms.ReadmoreDialog;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.FarmAssessment;
import com.telpo.usb.finger.entities.Products;
import com.telpo.usb.finger.entities.ProductsFromDealer;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.entities.ServiceProviders;
import com.telpo.usb.finger.entities.ServiceType;
import com.telpo.usb.finger.inputdistributions_fragment.ServiceProvidersDialogFragment;
import com.telpo.usb.finger.interfaces.ItemClickListener;
import com.telpo.usb.finger.interfaces.ScaletranClickListener;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo;
import com.telpo.usb.finger.utils.AgeFormatter;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.BackupData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;
import jp.wasabeef.recyclerview.animators.FadeInDownAnimator;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllAgentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllAgentFragment extends Fragment implements BackupData.OnBackupListener, ScaletranClickListener, ItemClickListener, View.OnClickListener {
    private static final String ARG_PARAM1 = "index";
    static List<Sales> serviceList;
    static List<Scaletran> purchaseList, recoveryList;
    static ReportPojo reportPojo;
    static HomePojo homePojo;
    static ChartPojo chartPojo;
    static Object somepojo;
    static ArrayList<Entry> linechartvalues;
    AgentActivity activity;
    MaterialDialog dialog;
    FragmentHomeBinding homeBinding;
    FragmentReportBinding reportBinding;
    FragmentChartBinding chartBinding;
    FragmentActionsBinding actionsBinding;
    String topid = "n/a";
    Handler handler;
    ScaletranAdapter recocvadapter, purchaseadapter;
    SalestranAdapter salestranadap;
    Intent intent;
    BackupData backupData;
    MaterialDialog loading;
    LottieAnimationView animationView;
    EditText providername, contact, desc, name;
    private FrameLayout container;
    private String[] inputnames;

    // TODO: Rename and change types of parameters
    private int mParam1;


    public AllAgentFragment() {
        // Required empty public constructor
    }

    public static AllAgentFragment newInstance(int index, Object o, List<Sales> service, List<Scaletran> purchase, List<Scaletran> recovery, ArrayList<Entry> linechart) {
        AllAgentFragment fragment = new AllAgentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, index);
        if (service != null)
            serviceList = service;

        if (index == 0) homePojo = (HomePojo) o;
        else if (index == 1) {
            reportPojo = (ReportPojo) o;
            purchaseList = purchase;
            recoveryList = recovery;
        } else if (index == 2) {
            linechartvalues = linechart;
            chartPojo = (ChartPojo) o;
        }

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1, 0);
        }
        handler = new Handler();
        activity = (AgentActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (getArguments().getInt("index", 0) == 0) {
            homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
            View view = homeBinding.getRoot();
            homeBinding.setHome(homePojo);
            initHomeScreen(view);
            return view;
        } else if (getArguments().getInt("index", 0) == 1) {
            reportBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_report, container, false);
            View view = reportBinding.getRoot();
            reportBinding.setReport(reportPojo);
            initReportScreen(view);
            return view;
        } else if (getArguments().getInt("index", 0) == 2) {
            chartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_chart, container, false);
            View view = chartBinding.getRoot();
            chartBinding.setChart(chartPojo);
            initChartScreen(view);
            return view;
        } else {
            actionsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_actions, container, false);
            View view = actionsBinding.getRoot();
            backupData = new BackupData(getContext());
            backupData.setOnBackupListener(this);
            initActionScreen(view);
            return view;
        }

    }

    //    HOME FRAGEMENT
    private void initHomeScreen(View view) {
        container = view.findViewById(R.id.container);
        inputnames = getResources().getStringArray(R.array.servicetype);

        if (serviceList.size() > 0) {
            ServiceSummaryAdapter summaryAdapter = new ServiceSummaryAdapter(getActivity(), serviceList);
            homeBinding.servicesummaryRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            homeBinding.servicesummaryRecycler.setItemAnimator(new DefaultItemAnimator());
            homeBinding.servicesummaryRecycler.setAdapter(summaryAdapter);
        } else homeBinding.servicenorecord.setVisibility(View.VISIBLE);

        List<Products> productsList = Products.listAll(Products.class);
        List<ProductsFromDealer> productsFromDealersList = ProductsFromDealer.listAll(ProductsFromDealer.class);
        if (productsList.size() > 0) {
            homeBinding.norecord2.setVisibility(View.GONE);
            SnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(homeBinding.personalRecycler);
            HomeAdapter adapter = new HomeAdapter(getActivity(), productsList);
            homeBinding.personalRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            homeBinding.personalRecycler.setItemAnimator(new DefaultItemAnimator());
            homeBinding.personalRecycler.setAdapter(adapter);
        } else homeBinding.norecord2.setVisibility(View.VISIBLE);

        if (productsFromDealersList.size() > 0) {
            homeBinding.norecord.setVisibility(View.GONE);
            SnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(homeBinding.inputdealerRecycler);
            ProdFromDealerAdapter adapter = new ProdFromDealerAdapter(getActivity(), productsFromDealersList);
            homeBinding.inputdealerRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            homeBinding.inputdealerRecycler.setItemAnimator(new DefaultItemAnimator());
            homeBinding.inputdealerRecycler.setAdapter(adapter);
        } else homeBinding.norecord.setVisibility(View.VISIBLE);

        homeBinding.yield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (topid != null && !topid.isEmpty()) {
                    Intent intent = new Intent(getContext(), ProfileActivity.class);
                    intent.putExtra("farmerid", homePojo.topid.get());
                    startActivity(intent);
                }
            }
        });
    }
//    HOME FRAGEMENT


    //    REPORT FRAGMENT
    private void initReportScreen(View view) {
        container = view.findViewById(R.id.container);

        reportBinding.cardTitle.setOnClickListener(this);
        reportBinding.viewservices.setOnClickListener(this);
        reportBinding.viewinput.setOnClickListener(this);
        reportBinding.viewall.setOnClickListener(this);
        reportBinding.more.setOnClickListener(this);

        purchaseadapter = new ScaletranAdapter(getActivity(), purchaseList, this);
        recocvadapter = new ScaletranAdapter(getActivity(), recoveryList, this);

        reportBinding.reportRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        reportBinding.reportRecycler.setItemAnimator(new FadeInDownAnimator());

        if (recoveryList.size() > 0) {
            reportBinding.reportRecycler.setAdapter(recocvadapter);
            reportBinding.norecord.setVisibility(View.GONE);
        } else reportBinding.norecord.setVisibility(View.VISIBLE);

    }

    //    METHODS FOR REPORT FRAGMENT
    public void saletranReport(SalestranAdapter salestranAdapter) {
        salestranadap = salestranAdapter;
        if (!reportPojo.header.get().equals("Input Sale Transactions")) {
            reportPojo.header.set("Input Sale Transactions");
            reportBinding.reportRecycler.setAdapter(salestranAdapter);
            reportPojo.farmersserved.set(String.valueOf(Salestran.count(Salestran.class)));
            if (reportBinding.viewforsaletransactions.getVisibility() == View.GONE)
                reportBinding.viewforsaletransactions.setVisibility(View.VISIBLE);

            if (Salestran.count(Salestran.class) > 0) {
                reportBinding.norecord.setVisibility(View.GONE);
                runLayoutAnimation();

            } else {
                reportBinding.norecord.setVisibility(View.VISIBLE);
            }

            if (reportBinding.more.getVisibility() == View.VISIBLE)
                reportBinding.more.setVisibility(View.INVISIBLE);
            if (reportBinding.ll5.getVisibility() == View.VISIBLE)
                reportBinding.ll5.setVisibility(View.INVISIBLE);
            if (reportBinding.ll6.getVisibility() == View.VISIBLE)
                reportBinding.ll6.setVisibility(View.INVISIBLE);
            if (reportBinding.ll4.getVisibility() == View.VISIBLE)
                reportBinding.ll4.setVisibility(View.INVISIBLE);
            if (reportBinding.ll3.getVisibility() == View.VISIBLE)
                reportBinding.ll3.setVisibility(View.INVISIBLE);

        }
    }

    public void scaletranReport() {
        if (!reportPojo.header.get().equals("Recovery Transactions")) {
            reportPojo.header.set("Recovery Transactions");
            reportBinding.reportRecycler.setAdapter(recocvadapter);
            reportPojo.farmersserved.set(String.valueOf(recoveryList.size()));
            if (reportBinding.viewforsaletransactions.getVisibility() == View.VISIBLE)
                reportBinding.viewforsaletransactions.setVisibility(View.GONE);

            if (recoveryList.size() > 0) {
                reportBinding.norecord.setVisibility(View.INVISIBLE);
                runLayoutAnimation();
            } else {
                reportBinding.norecord.setVisibility(View.VISIBLE);
            }

            if (reportBinding.more.getVisibility() == View.VISIBLE)
                reportBinding.more.setVisibility(View.INVISIBLE);
            if (reportBinding.ll4.getVisibility() == View.VISIBLE)
                reportBinding.ll4.setVisibility(View.INVISIBLE);

            if (reportBinding.ll5.getVisibility() == View.INVISIBLE)
                reportBinding.ll5.setVisibility(View.VISIBLE);
            if (reportBinding.ll6.getVisibility() == View.INVISIBLE)
                reportBinding.ll6.setVisibility(View.VISIBLE);
            if (reportBinding.ll3.getVisibility() == View.INVISIBLE)
                reportBinding.ll3.setVisibility(View.VISIBLE);
            if (reportBinding.ll2.getVisibility() == View.INVISIBLE)
                reportBinding.ll2.setVisibility(View.VISIBLE);

        }
    }

    public void farmassessmentReport(FarmAssessmentAdapter assessmentAdapter) {
        if (!reportPojo.header.get().equals("Farm Assessments")) {
            reportPojo.header.set("Farm Assessments");
            reportBinding.reportRecycler.setAdapter(assessmentAdapter);
            reportPojo.farmersserved.set(String.valueOf(FarmAssessment.count(FarmAssessment.class)));

            if (reportBinding.viewforsaletransactions.getVisibility() == View.VISIBLE)
                reportBinding.viewforsaletransactions.setVisibility(View.GONE);

            if (FarmAssessment.count(FarmAssessment.class) > 0) {
                reportBinding.norecord.setVisibility(View.GONE);
                runLayoutAnimation();
            } else {
                reportBinding.norecord.setVisibility(View.VISIBLE);
            }


            if (reportBinding.more.getVisibility() == View.VISIBLE)
                reportBinding.more.setVisibility(View.INVISIBLE);
            if (reportBinding.ll5.getVisibility() == View.VISIBLE)
                reportBinding.ll5.setVisibility(View.INVISIBLE);
            if (reportBinding.ll6.getVisibility() == View.VISIBLE)
                reportBinding.ll6.setVisibility(View.INVISIBLE);
            if (reportBinding.ll4.getVisibility() == View.VISIBLE)
                reportBinding.ll4.setVisibility(View.INVISIBLE);
            if (reportBinding.ll3.getVisibility() == View.VISIBLE)
                reportBinding.ll3.setVisibility(View.INVISIBLE);
            if (reportBinding.ll2.getVisibility() == View.VISIBLE)
                reportBinding.ll2.setVisibility(View.INVISIBLE);

        }
    }

    public void declarationReport(DeclarationAdapter declarationAdapter) {
        if (!reportPojo.header.get().equals("Debtors")) {
            reportPojo.header.set("Debtors");
            reportPojo.farmersserved.set(String.valueOf(Declaration.count(Declaration.class)));
            reportBinding.reportRecycler.setAdapter(declarationAdapter);

            if (reportBinding.viewforsaletransactions.getVisibility() == View.VISIBLE)
                reportBinding.viewforsaletransactions.setVisibility(View.GONE);

            if (declarationAdapter.getItemCount() > 0) {
                reportBinding.norecord.setVisibility(View.GONE);
                runLayoutAnimation();
            } else {
                reportBinding.norecord.setVisibility(View.VISIBLE);
            }

            if (reportBinding.more.getVisibility() == View.INVISIBLE)
                reportBinding.more.setVisibility(View.VISIBLE);
            if (reportBinding.ll5.getVisibility() == View.VISIBLE)
                reportBinding.ll5.setVisibility(View.INVISIBLE);
            if (reportBinding.ll6.getVisibility() == View.VISIBLE)
                reportBinding.ll6.setVisibility(View.INVISIBLE);
            if (reportBinding.ll4.getVisibility() == View.VISIBLE)
                reportBinding.ll4.setVisibility(View.INVISIBLE);
            if (reportBinding.ll3.getVisibility() == View.INVISIBLE)
                reportBinding.ll3.setVisibility(View.VISIBLE);
            if (reportBinding.ll2.getVisibility() == View.INVISIBLE)
                reportBinding.ll2.setVisibility(View.VISIBLE);
        }
    }
//    REPORT FRAGMENT


    //    CHART FRAGMENT
    private void initChartScreen(View view) {
        container = view.findViewById(R.id.container);
        chartBinding.vmore.setOnClickListener(v -> ReadChartValuesDialog.newInstance("0", chartPojo).show(getFragmentManager(), ReadChartValuesDialog.TAG));
        chartBinding.imore.setOnClickListener(v -> ReadChartValuesDialog.newInstance("1", chartPojo).show(getFragmentManager(), ReadChartValuesDialog.TAG));
        configuregenderpiechart();
        configureagebargraph();
        configuresaletransactionspiechart();
        configuresaletranrevenuebargraph();
        configurerecovertransactionpiechart();
        configurerecovertransactionlinechart();
    }

    //    METHODS FOR CHART FRAGMENT
    public void configuregenderpiechart() {

        chartBinding.genderpiechart.setUsePercentValues(true);
        chartBinding.genderpiechart.setExtraOffsets(5, 0, 5, 0);
        chartBinding.genderpiechart.setDrawHoleEnabled(true);
        chartBinding.genderpiechart.setHoleColor(Color.WHITE);
        chartBinding.genderpiechart.setTransparentCircleColor(Color.WHITE);
        chartBinding.genderpiechart.setTransparentCircleAlpha(110);
        chartBinding.genderpiechart.setHoleRadius(40f);
        chartBinding.genderpiechart.setTransparentCircleRadius(45f);
        chartBinding.genderpiechart.setDrawCenterText(true);
        chartBinding.genderpiechart.setRotationAngle(0);
        chartBinding.genderpiechart.setRotationEnabled(true);
        chartBinding.genderpiechart.setHighlightPerTapEnabled(true);
        chartBinding.genderpiechart.getDescription().setEnabled(false);
        chartBinding.genderpiechart.getLegend().setDrawInside(false);
        List<PieEntry> demopiechartentries = new ArrayList<>();

        demopiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.regfarmers.get()), "Registered Farmers"));

        if (!chartPojo.male.get().equals("0")) {
            demopiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.male.get()), "Males"));
        }
        if (!chartPojo.female.get().equals("0")) {
            demopiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.female.get()), "Females"));
        }

        PieDataSet demoset = new PieDataSet(demopiechartentries, "");
        demoset.setColors(new int[]{R.color.green8, R.color.green7, R.color.md_lime_500}, getContext());

        PieData pieData = new PieData(demoset);
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(13f);
        pieData.setValueTextColor(Color.WHITE);
        if (demopiechartentries.size() > 0) {
            chartBinding.genderpiechart.setData(pieData);
        }
    }

    public void configureagebargraph() {

        chartBinding.agebarchart.setDrawBarShadow(false);
        chartBinding.agebarchart.setDrawValueAboveBar(true);
        chartBinding.agebarchart.getDescription().setEnabled(false);
        chartBinding.agebarchart.setMaxVisibleValueCount(60);
        chartBinding.agebarchart.setPinchZoom(false);
        chartBinding.agebarchart.setDrawGridBackground(false);
        chartBinding.agebarchart.getAxisRight().setEnabled(false);
        chartBinding.agebarchart.getLegend().setEnabled(false);

        ArrayList<BarEntry> demobarentries = new ArrayList<>();
        ArrayList<String> demobarlabels = new ArrayList<>();

        demobarentries.add(new BarEntry(0, chartPojo.below18.get()));
        demobarentries.add(new BarEntry(1, chartPojo.b18_30.get()));
        demobarentries.add(new BarEntry(2, chartPojo.b31_45.get()));
        demobarentries.add(new BarEntry(3, chartPojo.b46_60.get()));
        demobarentries.add(new BarEntry(4, chartPojo.above60.get()));

        demobarlabels.add("below 18");
        demobarlabels.add("18-30");
        demobarlabels.add("31-45");
        demobarlabels.add("46-60");
        demobarlabels.add("above 60");

        BarDataSet demobarbarDataSet = new BarDataSet(demobarentries, "No# of Farmers per age group");
        demobarbarDataSet.setColor(getResources().getColor(R.color.bar));
        XAxis demobarxAxis = chartBinding.agebarchart.getXAxis();
        demobarxAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        demobarxAxis.setDrawGridLines(false);
        demobarxAxis.setLabelCount(demobarlabels.size());
        demobarxAxis.setValueFormatter(new AgeFormatter(demobarlabels));
//        demobarxAxis.setGranularity(1f); // only intervals of 1 day

        ArrayList<IBarDataSet> demobardataSets = new ArrayList<>();
        demobardataSets.add(demobarbarDataSet);
        BarData demobardata = new BarData(demobardataSets);

        demobardata.setValueTextSize(10f);
        demobardata.setBarWidth(0.7f);
        if (demobarentries.size() > 0)
            chartBinding.agebarchart.setData(demobardata);
    }

    public void configuresaletransactionspiechart() {
        chartBinding.saletransaction.setUsePercentValues(true);
        chartBinding.saletransaction.setExtraOffsets(5, 0, 5, 0);
        chartBinding.saletransaction.setDrawHoleEnabled(true);
        chartBinding.saletransaction.setHoleColor(Color.WHITE);
        chartBinding.saletransaction.setTransparentCircleColor(Color.WHITE);
        chartBinding.saletransaction.setTransparentCircleAlpha(110);
        chartBinding.saletransaction.setHoleRadius(40f);
        chartBinding.saletransaction.setTransparentCircleRadius(45f);
        chartBinding.saletransaction.setDrawCenterText(true);
        chartBinding.saletransaction.setRotationAngle(0);
        chartBinding.saletransaction.setRotationEnabled(true);
        chartBinding.saletransaction.setHighlightPerTapEnabled(true);
        chartBinding.saletransaction.getDescription().setEnabled(false);
        chartBinding.saletransaction.getLegend().setDrawInside(false);

        List<PieEntry> salestranpiechartentries = new ArrayList<>();

        if (!chartPojo.saletran.get().equals("0")) {
            salestranpiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.saletran.get()), "Farmers Served"));
        }
        if (!chartPojo.subsidized.get().equals("0")) {
            salestranpiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.subsidized.get()), "Subsidized"));
        }
        if (!chartPojo.nonsubsidized.get().equals("0")) {
            salestranpiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.nonsubsidized.get()), "Non-Subsidized"));
        }
        if (!chartPojo.cash.get().equals("0")) {
            salestranpiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.cash.get()), "Cash"));
        }
        if (!chartPojo.mm.get().equals("0")) {
            salestranpiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.mm.get()), "Mobilemoney"));
        }
        if (!chartPojo.ba.get().equals("0")) {
            salestranpiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.ba.get()), "Barter"));
        }

        PieDataSet salestranset = new PieDataSet(salestranpiechartentries, "Summary");
        salestranset.setColors(new int[]{R.color.green8, R.color.accent, R.color.md_lime_500, R.color.green5,
                R.color.acc, R.color.acc2, R.color.acc3, R.color.black}, getContext());

        PieData pieData = new PieData(salestranset);
        if (salestranpiechartentries.size() > 0)
            chartBinding.saletransaction.setData(pieData);

        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(13f);
        pieData.setValueTextColor(Color.WHITE);
        chartBinding.saletransaction.invalidate();
    }

    public void configuresaletranrevenuebargraph() {

        chartBinding.salestrantotalrevenue.setDrawBarShadow(false);
        chartBinding.salestrantotalrevenue.setDrawValueAboveBar(true);
        chartBinding.salestrantotalrevenue.getDescription().setEnabled(false);
        chartBinding.salestrantotalrevenue.setMaxVisibleValueCount(60);
        chartBinding.salestrantotalrevenue.setPinchZoom(false);
        chartBinding.salestrantotalrevenue.setDrawGridBackground(false);
        chartBinding.salestrantotalrevenue.getAxisRight().setEnabled(false);
        chartBinding.salestrantotalrevenue.getLegend().setEnabled(false);

        ArrayList<BarEntry> salestranbarEntries = new ArrayList<>();

        if (chartPojo._01.get() != 0f) {
            salestranbarEntries.add(new BarEntry(0, chartPojo._01.get()));
        }
        if (chartPojo._02.get() != 0f) {
            salestranbarEntries.add(new BarEntry(1, chartPojo._02.get()));
        }
        if (chartPojo._03.get() != 0f) {
            salestranbarEntries.add(new BarEntry(2, chartPojo._03.get()));
        }
        if (chartPojo._04.get() != 0f) {
            salestranbarEntries.add(new BarEntry(3, chartPojo._04.get()));
        }
        if (chartPojo._05.get() != 0f) {
            salestranbarEntries.add(new BarEntry(4, chartPojo._05.get()));
        }
        if (chartPojo._06.get() != 0f) {
            salestranbarEntries.add(new BarEntry(5, chartPojo._06.get()));
        }
        if (chartPojo._07.get() != 0f) {
            salestranbarEntries.add(new BarEntry(6, chartPojo._07.get()));
        }
        if (chartPojo._08.get() != 0f) {
            salestranbarEntries.add(new BarEntry(7, chartPojo._08.get()));
        }
        if (chartPojo._09.get() != 0f) {
            salestranbarEntries.add(new BarEntry(8, chartPojo._09.get()));
        }
        if (chartPojo._10.get() != 0f) {
            salestranbarEntries.add(new BarEntry(9, chartPojo._10.get()));
        }
        if (chartPojo._11.get() != 0f) {
            salestranbarEntries.add(new BarEntry(10, chartPojo._11.get()));
        }

        if (chartPojo._12.get() != 0f) {
            salestranbarEntries.add(new BarEntry(11, chartPojo._12.get()));
        }

        ArrayList<String> salestranbarlabels = new ArrayList<>();
        salestranbarlabels.add("Jan");
        salestranbarlabels.add("Feb");
        salestranbarlabels.add("Mar");
        salestranbarlabels.add("Apr");
        salestranbarlabels.add("May");
        salestranbarlabels.add("Jun");
        salestranbarlabels.add("Jul");
        salestranbarlabels.add("Aug");
        salestranbarlabels.add("Sep");
        salestranbarlabels.add("Oct");
        salestranbarlabels.add("Nov");
        salestranbarlabels.add("Dec");

        BarDataSet demobarbarDataSet = new BarDataSet(salestranbarEntries, "Sale Transaction summary");
        demobarbarDataSet.setColor(getResources().getColor(R.color.bar));
        XAxis demobarxAxis = chartBinding.salestrantotalrevenue.getXAxis();
        demobarxAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        demobarxAxis.setDrawGridLines(false);
        demobarxAxis.setLabelCount(salestranbarlabels.size());
        demobarxAxis.setValueFormatter(new AgeFormatter(salestranbarlabels));
        demobarxAxis.setGranularity(1f); // only intervals of 1 day

        ArrayList<IBarDataSet> demobardataSets = new ArrayList<>();
        demobardataSets.add(demobarbarDataSet);
        BarData demobardata = new BarData(demobardataSets);

        demobardata.setValueTextSize(10f);
        demobardata.setBarWidth(0.55f);
        if (salestranbarEntries.size() > 0)
            chartBinding.salestrantotalrevenue.setData(demobardata);
        chartBinding.salestrantotalrevenue.invalidate();
    }

    public void configurerecovertransactionpiechart() {

        chartBinding.recoverytransactionpiechart.setUsePercentValues(true);
        chartBinding.recoverytransactionpiechart.setExtraOffsets(5, 0, 5, 0);
        chartBinding.recoverytransactionpiechart.setDrawHoleEnabled(true);
        chartBinding.recoverytransactionpiechart.setHoleColor(Color.WHITE);
        chartBinding.recoverytransactionpiechart.setTransparentCircleColor(Color.WHITE);
        chartBinding.recoverytransactionpiechart.setTransparentCircleAlpha(110);
        chartBinding.recoverytransactionpiechart.setHoleRadius(40f);
        chartBinding.recoverytransactionpiechart.setTransparentCircleRadius(45f);
        chartBinding.recoverytransactionpiechart.setDrawCenterText(true);
        chartBinding.recoverytransactionpiechart.setRotationAngle(0);
        chartBinding.recoverytransactionpiechart.setRotationEnabled(true);
        chartBinding.recoverytransactionpiechart.setHighlightPerTapEnabled(true);
        chartBinding.recoverytransactionpiechart.getDescription().setEnabled(false);
        chartBinding.recoverytransactionpiechart.getLegend().setDrawInside(false);
        List<PieEntry> demopiechartentries = new ArrayList<>();

        demopiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.expected.get()), "Expected Recovery"));

        if (!chartPojo.recov.get().equals("0")) {
            demopiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.recov.get()), "Recovered"));
        }
        if (!chartPojo.remaining.get().equals("0")) {
            demopiechartentries.add(new PieEntry(Float.parseFloat(chartPojo.remaining.get()), "Remaining"));
        }

        PieDataSet demoset = new PieDataSet(demopiechartentries, "");
        demoset.setColors(new int[]{R.color.green8, R.color.green7, R.color.md_lime_500}, getContext());

        PieData pieData = new PieData(demoset);
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(13f);
        pieData.setValueTextColor(Color.WHITE);
        if (demopiechartentries.size() > 0) {
            chartBinding.recoverytransactionpiechart.setData(pieData);
        }
    }

    public void configurerecovertransactionlinechart() {
        LineDataSet set1;
        chartBinding.recoverytransactionlinechart.getAxisRight().setEnabled(false);
        if (chartBinding.recoverytransactionlinechart.getData() != null && chartBinding.recoverytransactionlinechart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) chartBinding.recoverytransactionlinechart.getData().getDataSetByIndex(0);
            set1.setValues(linechartvalues);
            set1.notifyDataSetChanged();
            chartBinding.recoverytransactionlinechart.getData().notifyDataChanged();
            chartBinding.recoverytransactionlinechart.notifyDataSetChanged();
        } else {
            set1 = new LineDataSet(linechartvalues, "Recoveries");
            set1.setDrawIcons(false);
            set1.enableDashedLine(10f, 5f, 0f);
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.BLACK);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(9f);
            set1.setValueTextSize(9f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setDrawFilled(true);
            set1.setFillFormatter((dataSet, dataProvider) -> chartBinding.recoverytransactionlinechart.getAxisLeft().getAxisMinimum());

            if (Utils.getSDKInt() >= 18) {
                // drawables only supported on api level 18 and above
                Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.gradient);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.BLACK);
            }
            ArrayList<ILineDataSet> ldataSets = new ArrayList<>();
            ldataSets.add(set1);
            LineData ldata = new LineData(ldataSets);
            if (linechartvalues.isEmpty()) {
                chartBinding.recoverytransactionlinechart.clear();
            } else {
                // set data
                chartBinding.recoverytransactionlinechart.setData(ldata);
            }
        }
    }

    public void animatecharts() {
        chartBinding.recoverytransactionpiechart.animateY(500, Easing.EasingOption.EaseInOutQuad);
        chartBinding.salestrantotalrevenue.animateX(500, Easing.EasingOption.EaseInOutQuad);
        chartBinding.agebarchart.animateY(500, Easing.EasingOption.EaseInOutQuad);
        chartBinding.genderpiechart.animateY(500, Easing.EasingOption.EaseInOutQuad);
    }
//    CHART FRAGMENT


    //    ACTIONS FRAGMENT
    private void initActionScreen(View view) {
        container = view.findViewById(R.id.container);
        actionsBinding.synced.setText(getResources().getString(R.string.synced, String.valueOf(unsyncedFiles())));
        actionsBinding.searchfarmer.setOnClickListener(v -> {
            intent = new Intent(getActivity(), FarmerSearchView.class);
            intent.putExtra("action", "search");
            startActivity(intent);
        });

        actionsBinding.addproduct.setOnClickListener(v -> activity.addnewproduct());

        actionsBinding.addservice.setOnClickListener(v -> activity.addnewservice());

        actionsBinding.manageserviceproviders.setOnClickListener(v -> {
            if (actionsBinding.forservice.getVisibility() == View.GONE) {
                actionsBinding.forservice.setVisibility(View.VISIBLE);
                actionsBinding.addserviceprovider.setVisibility(View.VISIBLE);
                actionsBinding.viewEditServiceprovider.setVisibility(View.VISIBLE);
            } else {
                actionsBinding.forservice.setVisibility(View.GONE);
                actionsBinding.addserviceprovider.setVisibility(View.GONE);
                actionsBinding.viewEditServiceprovider.setVisibility(View.GONE);
            }
        });

        actionsBinding.manageservicetype.setOnClickListener(v -> {
            if (actionsBinding.forservice2.getVisibility() == View.GONE) {
                actionsBinding.forservice2.setVisibility(View.VISIBLE);
                actionsBinding.addservicetype.setVisibility(View.VISIBLE);
                actionsBinding.viewEditServicetype.setVisibility(View.VISIBLE);
            } else {
                actionsBinding.forservice2.setVisibility(View.GONE);
                actionsBinding.addservicetype.setVisibility(View.GONE);
                actionsBinding.viewEditServicetype.setVisibility(View.GONE);
            }
        });

        actionsBinding.viewEditServiceprovider.setOnClickListener(v -> ServiceProvidersDialogFragment.newInstance(null, ServiceProviders.listAll(ServiceProviders.class), "").show(getFragmentManager(), "dialog"));

        actionsBinding.viewEditServicetype.setOnClickListener(v -> ServiceProvidersDialogFragment.newInstance(ServiceType.listAll(ServiceType.class), null, "").show(getFragmentManager(), "dialog"));

        actionsBinding.addserviceprovider.setOnClickListener(v -> addserviceprovider());

        actionsBinding.addservicetype.setOnClickListener(v -> addservicetype());

        actionsBinding.backupdata.setOnClickListener(v -> {
            loading = new MaterialDialog.Builder(activity)
                    .autoDismiss(true)
                    .customView(R.layout.custom_loadfinished, true)
                    .build();
            loading.show();
            assert loading.getCustomView() != null;
            animationView = loading.getCustomView().findViewById(R.id.animation_view);
            animationView.setScale(10f);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    loading.dismiss();
                    backupData.exportData();
                }
            }, 4000);
        });

        actionsBinding.syncfiles.setOnClickListener(v -> {
            long val = unsyncedFiles();
            if (val != 0) {
                AndroidUtils.uploadFileToServer(getContext());
            } else Toasty.error(getContext(), "No sync files").show();
            actionsBinding.synced.setText(getResources().getString(R.string.synced, String.valueOf(val)));
        });

    }

    //    METHODS FOR ACTIONS FRAGMENT
    public void addserviceprovider() {

        MaterialDialog serviceForm = new MaterialDialog.Builder(getContext())
                .title("Add Service Provider")
                .customView(R.layout.custom_service_provider_form, true)
                .positiveText(R.string.complete)
                .negativeText(R.string.negative)
                .onPositive((dialog, which) -> {
                    if (!providername.getText().toString().isEmpty() && !desc.getText().toString().isEmpty() && !contact.getText().toString().isEmpty()) {

                        ServiceProviders providers = new ServiceProviders();
                        providers.provider = providername.getText().toString();
                        providers.contact = contact.getText().toString();
                        providers.servicedesc = desc.getText().toString();
                        providers.providerid = AndroidUtils.genserviceproviderID();

                        providers.save();
                        Toasty.success(getContext(), "Service Provider added!").show();

                    } else {
                        Toasty.error(getContext(), "An error occurred").show();
                    }
                })
                .show();
        assert serviceForm.getCustomView() != null;
        providername = serviceForm.getCustomView().findViewById(R.id.provider_name);
        desc = serviceForm.getCustomView().findViewById(R.id.desc);
        contact = serviceForm.getCustomView().findViewById(R.id.contact);


    }

    public void addservicetype() {

        MaterialDialog serviceForm = new MaterialDialog.Builder(getContext())
                .title("Add Service Type")
                .customView(R.layout.custom_service_type_form, true)
                .positiveText(R.string.complete)
                .negativeText(R.string.negative)
                .onPositive((dialog, which) -> {
                    if (!name.getText().toString().isEmpty()) {

                        try {
                            new ServiceType(name.getText().toString().trim(), AndroidUtils.genservicetypeID(), AndroidUtils.getUUID()).save();
                            Toasty.success(getContext(), "Service Type added!").show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        Toasty.error(getContext(), "An error occurred").show();
                    }
                })
                .show();
        assert serviceForm.getCustomView() != null;
        name = serviceForm.getCustomView().findViewById(R.id.name);


    }

    public long unsyncedFiles() {
        try {
            return new File(AndroidUtils.uploadDirectoryPath()).listFiles().length;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
//    ACTIONS FRAGMENT

    //    GENERAL METHODS
    public void willBeDisplayed() {
        // Do what you want here, for example animate the content
        if (container != null) {
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
            container.startAnimation(fadeIn);
        }
    }

    public void willBeHidden() {
        if (container != null) {
            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
            container.startAnimation(fadeOut);
        }
    }

    private void runLayoutAnimation() {
        final Context context = reportBinding.reportRecycler.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);

        reportBinding.reportRecycler.setLayoutAnimation(controller);
        reportBinding.reportRecycler.getAdapter().notifyDataSetChanged();
        reportBinding.reportRecycler.scheduleLayoutAnimation();
    }


    //    OVERRIDES
    @Override
    public void onScaletranClickListener(int pos, Scaletran scaletran, CircleImageView imageView) {

        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra("farmerid", scaletran.getFarmerid());
        intent.putExtra("transid", scaletran.getTransid());
        intent.putExtra("transname", ViewCompat.getTransitionName(imageView));
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), imageView, ViewCompat.getTransitionName(imageView));

        getActivity().startActivity(intent, options.toBundle());

    }

    @Override
    public void onItemClick(String paymentStyle) {
        dialog.dismiss();
        if (paymentStyle.equalsIgnoreCase("recovery transactions")) {
            reportPojo.header.set("Recovery Transactions");
            reportPojo.farmersserved.set(String.valueOf(recoveryList.size()));

            reportBinding.reportRecycler.setAdapter(recocvadapter);
            if (recoveryList.size() > 0) {
                reportBinding.norecord.setVisibility(View.GONE);
            } else {
                reportBinding.norecord.setVisibility(View.VISIBLE);
            }


            if (reportBinding.more.getVisibility() == View.VISIBLE)
                reportBinding.more.setVisibility(View.INVISIBLE);
            if (reportBinding.ll4.getVisibility() == View.VISIBLE)
                reportBinding.ll4.setVisibility(View.GONE);
            if (reportBinding.ll5.getVisibility() == View.GONE)
                reportBinding.ll5.setVisibility(View.VISIBLE);
            if (reportBinding.ll3.getVisibility() == View.GONE)
                reportBinding.ll3.setVisibility(View.VISIBLE);
            if (reportBinding.ll2.getVisibility() == View.GONE)
                reportBinding.ll2.setVisibility(View.VISIBLE);

        } else {
            reportPojo.header.set("Purchase Transactions");
            reportPojo.farmersserved.set(String.valueOf(purchaseList.size()));
            if (reportBinding.viewforsaletransactions.getVisibility() == View.VISIBLE)
                reportBinding.viewforsaletransactions.setVisibility(View.GONE);
            reportBinding.reportRecycler.setAdapter(purchaseadapter);
            if (purchaseList.size() > 0) {
                reportBinding.norecord.setVisibility(View.GONE);
            } else reportBinding.norecord.setVisibility(View.VISIBLE);


            if (reportBinding.more.getVisibility() == View.INVISIBLE)
                reportBinding.more.setVisibility(View.INVISIBLE);
            if (reportBinding.ll4.getVisibility() == View.GONE)
                reportBinding.ll4.setVisibility(View.VISIBLE);
            if (reportBinding.ll5.getVisibility() == View.VISIBLE)
                reportBinding.ll5.setVisibility(View.GONE);
            if (reportBinding.ll3.getVisibility() == View.GONE)
                reportBinding.ll3.setVisibility(View.VISIBLE);
            if (reportBinding.ll2.getVisibility() == View.GONE)
                reportBinding.ll2.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_title:
                PaymentStyleAdapter optadapter = new PaymentStyleAdapter(getActivity(), R.array.scaletran, this);
                if (reportBinding.header.getText().toString().trim().equalsIgnoreCase("purchase transactions") || reportBinding.header.getText().toString().trim().equalsIgnoreCase("recovery transactions")) {
                    dialog = new MaterialDialog.Builder(getActivity())
                            .title("Choose Action")
                            .titleColor(getResources().getColor(R.color.grey_600))
                            .adapter(optadapter, null)
                            .backgroundColor(getResources().getColor(R.color.viewBg))
                            .build();
                    dialog.show();
                }
                break;

            case R.id.more:
                if (getFragmentManager() != null) {
                    ReadmoreDialog.newInstance(reportPojo.amountowing.get(), "GHS 0.00").show(getFragmentManager(), ReadmoreDialog.TAG);
                }
                break;

            case R.id.viewall:
                reportBinding.viewall.setBackground(getResources().getDrawable(R.drawable.round_pressed_btn));
                reportBinding.viewinput.setBackground(getResources().getDrawable(R.drawable.round_btn));
                reportBinding.viewservices.setBackground(getResources().getDrawable(R.drawable.round_btn));

                salestranadap.getFilter().filter("");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (salestranadap.getItemCount() > 0) {
                            if (reportBinding.norecord.getVisibility() == View.VISIBLE)
                                reportBinding.norecord.setVisibility(View.GONE);
                            runLayoutAnimation();

                        } else reportBinding.norecord.setVisibility(View.VISIBLE);
                    }
                }, 500);
                break;

            case R.id.viewinput:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        reportBinding.viewall.setBackground(getResources().getDrawable(R.drawable.round_btn));
                        reportBinding.viewinput.setBackground(getResources().getDrawable(R.drawable.round_pressed_btn));
                        reportBinding.viewservices.setBackground(getResources().getDrawable(R.drawable.round_btn));
                        salestranadap.getFilter().filter(AndroidUtils.INPUTSALESID);
                        if (salestranadap.getItemCount() > 0) {
                            if (reportBinding.norecord.getVisibility() == View.VISIBLE)
                                reportBinding.norecord.setVisibility(View.GONE);
                            runLayoutAnimation();
                        } else reportBinding.norecord.setVisibility(View.VISIBLE);
                    }
                }, 500);
                break;

            case R.id.viewservices:
                reportBinding.viewall.setBackground(getResources().getDrawable(R.drawable.round_btn));
                reportBinding.viewinput.setBackground(getResources().getDrawable(R.drawable.round_btn));
                reportBinding.viewservices.setBackground(getResources().getDrawable(R.drawable.round_pressed_btn));
                salestranadap.getFilter().filter(AndroidUtils.SERVICETRANSID);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (salestranadap.getItemCount() > 0) {
                            if (reportBinding.norecord.getVisibility() == View.VISIBLE)
                                reportBinding.norecord.setVisibility(View.GONE);
                            runLayoutAnimation();
                        } else reportBinding.norecord.setVisibility(View.VISIBLE);
                    }
                }, 500);
                break;
        }
    }

    @Override
    public void onFinishExport(String error) {
        String notify = error;
        if (error == null) {
            notify = "Export success";
        }
        Toasty.success(getContext(), notify).show();
    }

    @Override
    public void onFinishImport(String error) {

    }
}
