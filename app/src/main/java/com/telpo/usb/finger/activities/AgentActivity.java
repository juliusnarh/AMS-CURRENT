package com.telpo.usb.finger.activities;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.ImageView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.github.mikephil.charting.data.Entry;
import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.input.distribution.SaletranDetailsActivity;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.DeclarationAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.FarmAssessmentAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.SalestranAdapter;
import com.telpo.usb.finger.agent.fragment.AllAgentFragment;
import com.telpo.usb.finger.databinding.ActivityAgentBinding;
import com.telpo.usb.finger.dialogforms.SearchTimelineDialog;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.FarmAssessment;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Products;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.entities.ServiceProviders;
import com.telpo.usb.finger.entities.ServiceType;
import com.telpo.usb.finger.inputdistributions_fragment.ReportBottomsheet;
import com.telpo.usb.finger.interfaces.ItemClickListener;
import com.telpo.usb.finger.interfaces.SaletranClickListener;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.BottomBarAdapter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;

public class AgentActivity extends AppCompatActivity implements ListDialogFragment.OnListDialogItemSelect, AHBottomNavigation.OnTabSelectedListener, ItemClickListener, SaletranClickListener, View.OnClickListener {
    EditText inputname, inputdesc, inputprice, inputquantity,
            serviceprovider, servicetype, servicecost, servicedesc, inputcategory, inputaid, unitm, inputsubsidy, inputsubprice;
    ImageView input_img;
    Integer REQUEST_CAMERA = 1;
    String agentname, agentid;
    BottomBarAdapter adapter;
    ReportPojo reportPojo;
    HomePojo homePojo;
    ChartPojo chartPojo;
    MaterialDialog loading;
    ListDialogFragment dialogFragment;
    FragmentManager fm;
    String[] listitems;
    List<Salestran> list, forcustomdateList;
    List<Declaration> decList;
    List<Scaletran> scaleList;
    List<FarmAssessment> assessList;
    ActivityAgentBinding binding;
    SalestranAdapter salestranAdapter;
    DeclarationAdapter declarationAdapter;
    FarmAssessmentAdapter farmAssessmentAdapter;
    ArrayList<Entry> linechartvalues;
    int curr = 0;
    String topid = null;
    SearchTimelineDialog timelineDialog;
    String[] array;
    List<ServiceType> type;
    List<ServiceProviders> providers;
    private AllAgentFragment currentFragment;
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private byte[] inputImgByte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_agent);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Hub");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        agentid = AndroidUtils.getPreferenceData(AgentActivity.this, AndroidUtils.AGENTID, "");
        agentname = AndroidUtils.getPreferenceData(AgentActivity.this, AndroidUtils.AGENTNAME, "");
        homePojo = new HomePojo();
        reportPojo = new ReportPojo();
        chartPojo = new ChartPojo();
        list = new ArrayList<>();
        forcustomdateList = new ArrayList<>();
        initUI();
        timelineDialog = SearchTimelineDialog.newInstance();
        timelineDialog.setListener(((from, to) -> {
            loadpojodata("", "");
        }));
    }

    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    private void initUI() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }


        binding.bottomNavigation.manageFloatingActionButtonBehavior(binding.floatingActionButton);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Home", R.drawable.twotone_business_24);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Report", R.drawable.twotone_receipt_24);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Chart", R.drawable.twotone_equalizer_24);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Action", R.drawable.twotone_build_24);

        bottomNavigationItems.add(item1);
        bottomNavigationItems.add(item2);
        bottomNavigationItems.add(item3);
        bottomNavigationItems.add(item4);

        binding.bottomNavigation.addItems(bottomNavigationItems);
        binding.bottomNavigation.setAccentColor(Color.parseColor("#2b542c"));
        binding.bottomNavigation.setTranslucentNavigationEnabled(true);


        // Set listeners
        binding.bottomNavigation.setOnTabSelectedListener(this);
        binding.floatingActionButton.setOnClickListener(this);

        loadpojodata("", "");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.agent_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_input:
                addnewproduct();
                return true;
            case R.id.action_search:
                curr = binding.viewPager.getCurrentItem();
                timelineDialog.show(getSupportFragmentManager(), SearchTimelineDialog.TAG);
                return true;
            case R.id.action_service:
                addnewservice();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void selectImage() {

        final CharSequence[] options = {"Camera", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(AgentActivity.this);
        builder.setTitle("Add Image");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (options[i].equals("Camera")) {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);

                } else if (options[i].equals("Cancel")) {
                    dialogInterface.dismiss();
                }
            }
        });
        builder.show();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                Bundle bundle = data.getExtras();
                final Bitmap bmp = (Bitmap) bundle.get("data");
                ByteArrayOutputStream agentbmp = new ByteArrayOutputStream();
                assert bmp != null;
                bmp.compress(Bitmap.CompressFormat.JPEG, 100, agentbmp);
                inputImgByte = agentbmp.toByteArray();
                input_img.setImageBitmap(bmp);
                input_img.setDrawingCacheEnabled(true);
            }
        }
    }

    @Override
    public void onItemClick(String paymentStyle) {
        currentFragment = adapter.getCurrentFragment();
        if (paymentStyle.equalsIgnoreCase("debtors")) {
            if (currentFragment != null) currentFragment.declarationReport(declarationAdapter);
        }
        if (paymentStyle.equalsIgnoreCase("scaletran")) {
            if (currentFragment != null) currentFragment.scaletranReport();
        }
        if (paymentStyle.equalsIgnoreCase("saletran")) {
            if (currentFragment != null) currentFragment.saletranReport(salestranAdapter);
        }
        if (paymentStyle.equalsIgnoreCase("assessment")) {
            if (currentFragment != null)
                currentFragment.farmassessmentReport(farmAssessmentAdapter);
        }
    }

    @Override
    public void onSaletranClickListener(int pos, Salestran salestran, CircleImageView imageView) {

        Intent intent = new Intent(this, SaletranDetailsActivity.class);
        intent.putExtra("farmerid", salestran.getFarmerid());
        intent.putExtra("transid", salestran.getTransactionid());
        intent.putExtra("transname", ViewCompat.getTransitionName(imageView));
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageView,
                ViewCompat.getTransitionName(imageView));

        startActivity(intent, options.toBundle());
    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("category")) {
            inputcategory.setText(selection);
        }
        if (componentname.equalsIgnoreCase("aid")) {
            inputaid.setText(selection);
        }
        if (componentname.equalsIgnoreCase("subsidy")) {
            inputsubsidy.setText(selection);
            if (inputsubsidy.getText().toString().equals("Subsidized")) {
                inputsubprice.setVisibility(View.VISIBLE);
            } else inputsubprice.setVisibility(View.GONE);
        }
        if (componentname.equalsIgnoreCase("serviceprovider")) {
            serviceprovider.setText(selection);
        }
        if (componentname.equalsIgnoreCase("servicetype")) {
            servicetype.setText(selection);
        }
        if (componentname.equalsIgnoreCase("timeline")) {
//            binding.timeline.setText(selection);

        }
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        if (currentFragment == null) {
            currentFragment = adapter.getCurrentFragment();
        }

        if (currentFragment != null) {
            currentFragment.willBeHidden();
        }

        binding.viewPager.setCurrentItem(position, false);

        if (currentFragment == null) {
            return true;
        }

        currentFragment = adapter.getCurrentFragment();
        currentFragment.willBeDisplayed();

        if (position == 2) {
            currentFragment.animatecharts();
        }
        if (position == 1) {

            binding.floatingActionButton.setVisibility(View.VISIBLE);
            binding.floatingActionButton.setAlpha(0f);
            binding.floatingActionButton.setScaleX(0f);
            binding.floatingActionButton.setScaleY(0f);
            binding.floatingActionButton.animate()
                    .alpha(1)
                    .scaleX(1)
                    .scaleY(1)
                    .setDuration(300)
                    .setInterpolator(new OvershootInterpolator())
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            binding.floatingActionButton.animate()
                                    .setInterpolator(new LinearOutSlowInInterpolator())
                                    .setListener(new Animator.AnimatorListener() {
                                        @Override
                                        public void onAnimationStart(Animator animation) {
//                                                    floatingActionButton.clearAnimation();


                                        }

                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            binding.floatingActionButton.clearAnimation();
                                        }

                                        @Override
                                        public void onAnimationCancel(Animator animation) {

                                        }

                                        @Override
                                        public void onAnimationRepeat(Animator animation) {

                                        }
                                    })
                                    .start();
                            binding.floatingActionButton.clearAnimation();

                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    })
                    .start();
            binding.floatingActionButton.clearAnimation();

        } else {
            if (binding.floatingActionButton.getVisibility() == View.VISIBLE) {
                binding.floatingActionButton.animate()
                        .alpha(0)
                        .scaleX(0)
                        .scaleY(0)
                        .setDuration(300)
                        .setInterpolator(new LinearOutSlowInInterpolator())
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                binding.floatingActionButton.setVisibility(View.GONE);
                                binding.floatingActionButton.clearAnimation();

                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {
                                binding.floatingActionButton.setVisibility(View.GONE);
                                binding.floatingActionButton.clearAnimation();

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        })
                        .start();
                binding.floatingActionButton.clearAnimation();
            }
        }


        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.floating_action_button:
                ReportBottomsheet bottomsheet = ReportBottomsheet.newInstance(AgentActivity.this);
                bottomsheet.show(getSupportFragmentManager(), bottomsheet.getTag());
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void loadpojodata(String startdate, String enddate) {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;
            Double pay = 0.00, totalrecovlessnoofrecovery = 0.00, totalrecovery = 0.00, recoverypercent = 0.00, amountowing = 0.00, totalpurchase = 0.00, totalrev = 0.00, topyeild = 0.00, totalexpectedweight = 0.00, moisturec = 0.00, totalweight = 0.00, unrecoveredbags = 0.00;
            int nsub = 0, totalrecovloc = 0, totalpurchaseloc = 0, sub = 0, cash = 0, mm = 0, ba = 0, redeemed = 0, owing = 0, male = 0, female = 0;
            Float _01 = 0f, _02 = 0f, _03 = 0f, _04 = 0f, _05 = 0f, _06 = 0f, _07 = 0f, _08 = 0f, _09 = 0f, _10 = 0f, _11 = 0f, _12 = 0f, below18 = 0f, above60 = 0f, b18_30 = 0f, b31_45 = 0f, b46_60 = 0f;

            List<Salestran> salestranList;
            List<Declaration> declarationList;
            List<Scaletran> scaletranList, purchaselist, recoverylist;
            List<Farmers> farmersList;
            List<Sales> serviceListTemp, serviceList;
            List<FarmAssessment> assessmentList;
            private String[] inputnames;

            @Override
            protected void onPreExecute() {
                loading = new MaterialDialog.Builder(AgentActivity.this)
                        .content("Loading Data. Please wait...")
                        .progress(true, 0)
                        .autoDismiss(true)
                        .cancelable(false)
                        .build();
                loading.show();
                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... params) {

                farmersList = Farmers.listAll(Farmers.class);
                forcustomdateList = Salestran.listAll(Salestran.class, "dates");
                Log.d("LOGDATA:", "entered DisplayLoggingInfo");
                if (startdate.isEmpty() && enddate.isEmpty()) {
                    salestranList = Salestran.listAll(Salestran.class, "dates");
                    declarationList = Declaration.listAll(Declaration.class, "datecreated");
                    scaletranList = Scaletran.listAll(Scaletran.class, "datecreated");
                    assessmentList = FarmAssessment.listAll(FarmAssessment.class, "datecreated");
                } else if (!startdate.isEmpty() && !enddate.isEmpty()) {

                    salestranList = new ArrayList<>();
                    declarationList = new ArrayList<>();
                    scaletranList = new ArrayList<>();
                    assessmentList = new ArrayList<>();

                    List<Salestran> temp = Salestran.listAll(Salestran.class, "dates");
                    List<Declaration> tempDeclaration = Declaration.listAll(Declaration.class, "datecreated");
                    List<Scaletran> tempScaletran = Scaletran.listAll(Scaletran.class, "datecreated");
                    List<FarmAssessment> tempFarmAssessment = FarmAssessment.listAll(FarmAssessment.class, "datecreated");

                    for (Salestran salestran : temp) {
                        if (AndroidUtils.dateStringToDate(startdate, "dd-MMM-yyyy").getTime() >= salestran.getDates().getTime() && AndroidUtils.dateStringToDate(enddate, "dd-MMM-yyyy").getTime() >= salestran.getDates().getTime()) {
                            salestranList.add(salestran);
                        }
                    }
                    for (Declaration declaration : tempDeclaration) {
                        if (AndroidUtils.dateStringToDate(startdate, "dd-MMM-yyyy").getTime() >= declaration.getDatecreated().getTime() && AndroidUtils.dateStringToDate(enddate, "dd-MMM-yyyy").getTime() >= declaration.getDatecreated().getTime()) {
                            declarationList.add(declaration);
                        }
                    }
                    for (Scaletran scaletran : tempScaletran) {
                        if (AndroidUtils.dateStringToDate(startdate, "dd-MMM-yyyy").getTime() >= scaletran.getDatecreated().getTime() && AndroidUtils.dateStringToDate(enddate, "dd-MMM-yyyy").getTime() >= scaletran.getDatecreated().getTime()) {
                            scaletranList.add(scaletran);
                        }
                    }
                    for (FarmAssessment assessment : tempFarmAssessment) {
                        if (AndroidUtils.dateStringToDate(startdate, "dd-MMM-yyyy").getTime() >= assessment.getDatecreated().getTime() && AndroidUtils.dateStringToDate(enddate, "dd-MMM-yyyy").getTime() >= assessment.getDatecreated().getTime()) {
                            assessmentList.add(assessment);
                        }
                    }
                }

                serviceListTemp = Sales.find(Sales.class, "category = ?", "services");
                purchaselist = new ArrayList<>();
                recoverylist = new ArrayList<>();

                list = salestranList;
                decList = declarationList;
                scaleList = scaletranList;
                assessList = assessmentList;
                serviceList = new ArrayList<>();
                inputnames = getResources().getStringArray(R.array.servicetype);

                for (int i = 0; i < inputnames.length; i++) {
                    int firstindex = 0;
                    boolean first = false;
                    int[] repeatindex = new int[serviceListTemp.size()];

                    for (int x = 0; x < serviceListTemp.size(); x++) {

                        if (inputnames[i].equalsIgnoreCase(serviceListTemp.get(x).getPname())) {
                            repeatindex[x] = x;
                            if (!first) {
                                first = true;
                                firstindex = x;
                            }
                        }
                    }

                    //DO THE UPDATE OF THE QUANTITY AND CO HERE.......................
                    if (first) {
                        if (serviceListTemp.size() > 0) {
                            Sales current = serviceListTemp.get(firstindex);

                            int quantity = current.getQuantity();
                            int farmersserved = 1;
                            Double total = current.getTotalcost();

                            for (int y = 0; y < repeatindex.length; y++) {
                                if (repeatindex[y] != 0) {
                                    if (repeatindex[y] != firstindex) {
                                        Sales temp = serviceListTemp.get(repeatindex[y]);

                                        if (temp != null) {
                                            quantity += temp.getQuantity();
                                            farmersserved += 1;
                                            total += temp.getTotalcost();

                                            current.quantity = quantity;
                                            current.synstatus = String.valueOf(farmersserved);
                                            current.totalcost = total;
                                        }
                                    }
                                }
                            }
                            serviceList.add(current);
                        }
                    }
                }


                for (Farmers farmers : farmersList) {
                    if (farmers.getGender().toLowerCase().startsWith("m")) {
                        male += 1;
                    } else female += 1;

                    if (farmers.getDateofbirth() != null) {
                        int age = AndroidUtils.datetoage(farmers.getDateofbirth());
                        if (age < 18) {
                            below18 += 1f;
                        } else if (age > 60) {
                            above60 += 1f;
                        } else if (age > 18 && age < 30) {
                            b18_30 += 1f;
                        } else if (age > 31 && age < 45) {
                            b31_45 += 1f;
                        } else if (age > 46 && age < 60) {
                            b46_60 += 1f;
                        }
                    }

                }


                String[] mMonths = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

                for (int i = 0; i < salestranList.size(); i++) {

                    String month = AndroidUtils.dateToFormattedStringmonth(salestranList.get(i).getDates());

                    if (month.equals(mMonths[0])) {
                        Double temp = salestranList.get(i).getTotalCost();
                        _01 += temp.floatValue();
                    }
                    if (month.equals(mMonths[1])) {
                        Double temp = salestranList.get(i).getTotalCost();
                        _02 += temp.floatValue();
                    }
                    if (month.equals(mMonths[2])) {
                        Double temp = salestranList.get(i).getTotalCost();
                        _03 += temp.floatValue();
                    }
                    if (month.equals(mMonths[3])) {
                        Double temp = salestranList.get(i).getTotalCost();
                        _04 += temp.floatValue();
                    }
                    if (month.equals(mMonths[4])) {
                        Double temp = salestranList.get(i).getTotalCost();
                        _05 += temp.floatValue();
                    }
                    if (month.equals(mMonths[5])) {
                        Double temp = salestranList.get(i).getTotalCost();
                        _06 += temp.floatValue();
                    }
                    if (month.equals(mMonths[6])) {
                        Double temp = salestranList.get(i).getTotalCost();
                        _07 += temp.floatValue();
                    }
                    if (month.equals(mMonths[7])) {
                        Double temp = salestranList.get(i).getTotalCost();
                        _08 += temp.floatValue();
                    }
                    if (month.equals(mMonths[8])) {
                        Double temp = salestranList.get(i).getTotalCost();
                        _09 += temp.floatValue();
                    }
                    if (month.equals(mMonths[9])) {
                        Double temp = salestranList.get(i).getTotalCost();
                        _10 += temp.floatValue();
                    }
                    if (month.equals(mMonths[10])) {
                        Double temp = salestranList.get(i).getTotalCost();
                        _11 += temp.floatValue();
                    }
                    if (month.equals(mMonths[11])) {
                        double temp = salestranList.get(i).getTotalCost();
                        _12 += (float) temp;
                    }

                    if (salestranList.get(i).getPaymentmethod().toLowerCase().startsWith("bar")) {
                        sub += 1;
                        ba += 1;
                    } else {
                        nsub += 1;

                        if (salestranList.get(i).getPaymentmethod().toLowerCase().startsWith("cas")) {
                            cash += 1;
                        } else if (salestranList.get(i).getPaymentmethod().toLowerCase().startsWith("mobil")) {
                            mm += 1;
                        }
                    }


                    totalrev += salestranList.get(i).getPayableamt();

                }

                for (Declaration declaration : declarationList) {
                    if (declaration.getStatus().equalsIgnoreCase("owing")) {
                        owing += 1;
                        unrecoveredbags += declaration.getNorecoverybags();

                        totalexpectedweight += 50 * declaration.getNorecoverybags();
                    } else if (declaration.getStatus().equalsIgnoreCase("redeemed")) {
                        redeemed += 1;
                    }

                    amountowing += declaration.getTotalCost() - declaration.getAppliedsub();

                    String declarationparts[] = declaration.getDeclaration().split(" ");
                    for (int x = 0; x < declarationparts.length; x++) {
                        if (declarationparts[x].equals("exchange")) {
                            totalrecovlessnoofrecovery += Double.parseDouble(declarationparts[x + 1]) - declaration.getNorecoverybags();
                            totalrecovery += Double.parseDouble(declarationparts[x + 1]);
                            pay += Double.parseDouble(declarationparts[x + 1]);
                            break;
                        }
                    }
                }

                if (unrecoveredbags != 0.00 || totalrecovery != 0.00)
                    recoverypercent = (unrecoveredbags / totalrecovery) * 100;

                linechartvalues = new ArrayList<>();
                String todaysdate = AndroidUtils.dateToFormattedString(new Date(), "dd/MM/yyyy");

                for (int i = 0; i < scaletranList.size(); i++) {
                    Scaletran scaletran = scaletranList.get(i);
                    if (scaletran.getTransid().startsWith(AndroidUtils.RECOVERY)) {
                        recoverylist.add(scaletran);
                        totalrecovloc += 1;
                        try {
                            String recorddate = AndroidUtils.dateToFormattedString(scaletran.getDatecreated(), "dd/MM/yyyy");
                            if (todaysdate.equals(recorddate))
                                linechartvalues.add(new Entry(i, Float.parseFloat(scaletran.getTendered())));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (scaletran.getTransid().startsWith(AndroidUtils.PURCHASE)) {
                        totalpurchase += Double.parseDouble(scaletran.getTendered());
                        totalpurchaseloc += 1;
                        purchaselist.add(scaletran);
                    }

                    moisturec += scaletran.getMoisturecontent();

                    topid = scaletran.getFarmerid();
                    try {
                        if (topyeild < Double.parseDouble(scaletran.getTendered())) {
                            topyeild = Double.parseDouble(scaletran.getTendered());
                            topid = scaletran.getFarmerid();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                moisturec = moisturec / scaletranList.size();

                if (moisturec.isNaN()) {
                    moisturec = 0.00;
                }
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {

                Double result = pay - totalrecovlessnoofrecovery;
                homePojo.salesserved.set(String.valueOf(salestranList.size()));
                homePojo.salessub.set(String.valueOf(sub));
                homePojo.salesnsub.set(String.valueOf(nsub));
                homePojo.cash.set(String.valueOf(cash));
                homePojo.mm.set(String.valueOf(mm));
                homePojo.ba.set(String.valueOf(ba));
                homePojo.revenue.set(getResources().getString(R.string.price_item, totalrev));
                homePojo.decserved.set(String.valueOf(declarationList.size()));
                homePojo.owing.set(String.valueOf(owing));
                homePojo.fullrecov.set(String.valueOf(redeemed));
                homePojo.pay.set(getResources().getString(R.string.expected, pay));
                homePojo.scaleserved.set(String.valueOf(scaletranList.size()));
                homePojo.recov.set(getResources().getString(R.string.expected, totalrecovlessnoofrecovery));
                homePojo.exrecov.set(getResources().getString(R.string.weight, totalexpectedweight));
                homePojo.totalpurchase.set(getResources().getString(R.string.expected, totalpurchase));
                homePojo.avemoist.set(getResources().getString(R.string.price, moisturec));
                homePojo.topid.set(topid);
                homePojo.remaining.set(getResources().getString(R.string.expected, result));


                reportPojo.header.set("Recovery Transactions");
                reportPojo.farmersserved.set(String.valueOf(recoverylist.size()));
                reportPojo.totalpayable.set(getResources().getString(R.string.expected, pay));
                reportPojo.totalpurchases.set(getResources().getString(R.string.expected, totalpurchase));
                reportPojo.totalrecovery.set(getResources().getString(R.string.expected, totalrecovlessnoofrecovery));
                reportPojo.recoverypercent.set(getResources().getString(R.string.recoverypercent, recoverypercent, "%"));
                reportPojo.amountowing.set(getResources().getString(R.string.price_item, amountowing));
                reportPojo.remaining.set(getResources().getString(R.string.expected, result));

                chartPojo.totalpurchaseloc.set(String.valueOf(totalpurchaseloc));
                chartPojo.totalrecovloc.set(String.valueOf(totalrecovloc));
                chartPojo.totalpurchase.set(getResources().getString(R.string.expected, totalpurchase));
                chartPojo.scaleserved.set(String.valueOf(scaletranList.size()));
                chartPojo.recov.set(String.valueOf(totalrecovlessnoofrecovery));
                chartPojo.saletran.set(String.valueOf(salestranList.size()));
                chartPojo.expected.set(String.valueOf(pay));
                chartPojo.regfarmers.set(String.valueOf(farmersList.size()));
                chartPojo.cash.set(String.valueOf(cash));
                chartPojo.mm.set(String.valueOf(mm));
                chartPojo.ba.set(String.valueOf(ba));
                chartPojo.subsidized.set(String.valueOf(sub));
                chartPojo.nonsubsidized.set(String.valueOf(nsub));
                chartPojo.regfarmers.set(String.valueOf(farmersList.size()));
                chartPojo.male.set(String.valueOf(male));
                chartPojo.female.set(String.valueOf(female));
                chartPojo.decserved.set(String.valueOf(declarationList.size()));
                chartPojo.owing.set(String.valueOf(owing));
                chartPojo.redeemed.set(String.valueOf(redeemed));
                chartPojo.remaining.set(String.valueOf(result));
                chartPojo._01.set(_01);
                chartPojo._02.set(_02);
                chartPojo._03.set(_03);
                chartPojo._04.set(_04);
                chartPojo._05.set(_05);
                chartPojo._06.set(_06);
                chartPojo._07.set(_07);
                chartPojo._08.set(_08);
                chartPojo._09.set(_09);
                chartPojo._10.set(_10);
                chartPojo._11.set(_11);
                chartPojo._12.set(_12);
                chartPojo.below18.set(below18);
                chartPojo.b18_30.set(b18_30);
                chartPojo.b31_45.set(b31_45);
                chartPojo.b46_60.set(b46_60);
                chartPojo.above60.set(above60);

                setupviewpager(serviceList, purchaselist, recoverylist);
            }
        };
        asyncTask.execute();
    }

    public void setupviewpager(List<Sales> serviceList, List<Scaletran> purchaselist, List<Scaletran> recoverylist) {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {

                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... params) {


                Log.d("LOGDATA", "entered SETTING UP VIEWPAGER");

                try {
                    adapter = new BottomBarAdapter(getSupportFragmentManager(), homePojo, reportPojo, chartPojo, serviceList, purchaselist, recoverylist, linechartvalues);
                    currentFragment = adapter.getCurrentFragment();
//                    currentFragment.willBeDisplayed();
                    outcome = true;
                } catch (Exception e) {
                    loading.dismiss();
                    e.printStackTrace();
                }
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {

                if (outcome) {
                    binding.viewPager.setAdapter(adapter);
                    salestranAdapter = new SalestranAdapter(AgentActivity.this, list, AgentActivity.this);
                    declarationAdapter = new DeclarationAdapter(AgentActivity.this, decList);
                    farmAssessmentAdapter = new FarmAssessmentAdapter(AgentActivity.this, assessList);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.viewPager.setCurrentItem(curr, false);
                        }
                    });
                    loading.dismiss();
                }
            }
        };
        asyncTask.execute();
    }

    private String[] loadServicetype() {
        try {
            type = ServiceType.listAll(ServiceType.class);
            array = new String[type.size()];
            for (int i = 0; i < type.size(); i++) {
                array[i] = type.get(i).getServicetype();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    private String[] loadServiceprovider() {
        try {
            providers = ServiceProviders.listAll(ServiceProviders.class);
            array = new String[providers.size()];
            for (int i = 0; i < providers.size(); i++) {
                array[i] = providers.get(i).getProvider();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public void addnewservice() {
        MaterialDialog serviceForm = new MaterialDialog.Builder(AgentActivity.this)
                .title(R.string.add_service)
                .customView(R.layout.custom_service_form, true)
                .positiveText("Ok")
                .negativeText(R.string.negative)
                .cancelable(false)
                .onPositive((dialog, which) -> {
                    if (!servicetype.getText().toString().isEmpty()
                            && !servicedesc.getText().toString().isEmpty()
                            && !servicecost.getText().toString().isEmpty()
                            && !serviceprovider.getText().toString().isEmpty()) {

                        String inputname, desc, category, pid, price, serviceProvider;
                        serviceProvider = serviceprovider.getText().toString();
                        inputname = servicetype.getText().toString().trim();
                        desc = servicedesc.getText().toString().trim();
                        category = "services";
                        pid = AndroidUtils.genPid(category);
                        price = getResources().getString(R.string.price, Double.parseDouble(servicecost.getText().toString().trim()));
                        Products products = new Products();
                        products.category = category;
                        products.pname = inputname;
                        products.pdesc = desc;
                        products.pid = pid;
                        products.quantity = "1";
                        products.price = price;
                        products.supplier = serviceProvider;
                        products.subprice = price;
                        products.item_img = AndroidUtils.drawableToArray(R.drawable.services, getResources());
                        products.unitm = "unit";
                        products.uniqueuid = AndroidUtils.getUUID();
                        products.datecreated = new Date();
                        products.macaddress = AndroidUtils.getMacAddress(AgentActivity.this);
                        products.imei = AndroidUtils.getIMEI(AgentActivity.this);
                        products.agentid = agentid;
                        products.agentname = agentname;
                        products.save();

                        prepareuploadfiles(products);
                        uploadproduct();
                        Toasty.success(getApplicationContext(), "New service added!").show();
                    } else {
                        Toasty.error(getApplicationContext(), "Error").show();
                    }
                })
                .show();
        assert serviceForm.getCustomView() != null;
        servicecost = serviceForm.getCustomView().findViewById(R.id.et_service_cost);
        servicedesc = serviceForm.getCustomView().findViewById(R.id.et_service_desc);
        servicetype = serviceForm.getCustomView().findViewById(R.id.et_service_type);
        serviceprovider = serviceForm.getCustomView().findViewById(R.id.service_provider);

        servicetype.setOnClickListener(v -> {
            listitems = loadServicetype();
            showOptionDialog(listitems, "Select Service Type", "servicetype");
        });
        serviceprovider.setOnClickListener(v -> {
            listitems = loadServiceprovider();
            showOptionDialog(listitems, "Select Service Provider", "serviceprovider");
        });
    }

    public void addnewproduct() {
        MaterialDialog inputForm_1 = new MaterialDialog.Builder(AgentActivity.this)
                .title(R.string.new_input)
                .customView(R.layout.custom_input_form, true)
                .positiveText(R.string.next)
                .negativeText(R.string.negative)
                .cancelable(false)
                .onPositive((materialDialog, dialogAction) -> {
                    MaterialDialog inputForm_2 = new MaterialDialog.Builder(AgentActivity.this)
                            .title(R.string.almost_done)
                            .customView(R.layout.custom_input_form2, true)
                            .positiveText(R.string.complete)
                            .negativeText(R.string.negative)
                            .onPositive((materialDialog1, dialogAction1) -> {
                                String category, supplier, subprice, inputname, desc, unit, quantity, price;
                                inputname = this.inputname.getText().toString().trim();
                                desc = inputdesc.getText().toString().trim();
                                quantity = inputquantity.getText().toString().trim();
                                price = inputprice.getText().toString().trim();
                                category = inputcategory.getText().toString().trim();
                                supplier = inputaid.getText().toString().trim();
                                if (inputsubprice.getVisibility() == View.VISIBLE)
                                    subprice = inputsubprice.getText().toString().trim();
                                else subprice = "0";
                                unit = unitm.getText().toString().trim();
                                if (!category.isEmpty() && !supplier.isEmpty()) {

                                    Products products = new Products();
                                    products.category = category;
                                    products.pname = inputname;
                                    products.pdesc = desc;
                                    products.pid = AndroidUtils.genPid(category);
                                    products.quantity = quantity;
                                    products.price = price;
                                    products.supplier = supplier;
                                    products.subprice = subprice;
                                    products.item_img = inputImgByte;
                                    products.unitm = unit;
                                    products.uniqueuid = AndroidUtils.getUUID();
                                    products.datecreated = new Date();
                                    products.macaddress = AndroidUtils.getMacAddress(AgentActivity.this);
                                    products.imei = AndroidUtils.getIMEI(AgentActivity.this);
                                    products.agentid = agentid;
                                    products.agentname = agentname;
                                    products.save();

                                    prepareuploadfiles(products);
                                    uploadproduct();
                                    Toasty.success(getApplicationContext(), "New input added!").show();
                                } else
                                    Toasty.error(getApplicationContext(), "Error").show();
                            })
                            .show();
                    assert inputForm_2.getCustomView() != null;
                    inputdesc = inputForm_2.getCustomView().findViewById(R.id.et_input_desc);
                    input_img = inputForm_2.getCustomView().findViewById(R.id.custom_input_img);
                    input_img.setOnClickListener(view -> selectImage());

                })
                .show();
        assert inputForm_1.getCustomView() != null;
        inputname = inputForm_1.getCustomView().findViewById(R.id.et_input_name);
        inputcategory = inputForm_1.getCustomView().findViewById(R.id.input_category);
        inputprice = inputForm_1.getCustomView().findViewById(R.id.et_input_price);
        inputquantity = inputForm_1.getCustomView().findViewById(R.id.et_input_quantity);
        inputaid = inputForm_1.getCustomView().findViewById(R.id.input_aid);
        inputsubsidy = inputForm_1.getCustomView().findViewById(R.id.input_subsidy);
        unitm = inputForm_1.getCustomView().findViewById(R.id.et_unitm);
        inputsubprice = inputForm_1.getCustomView().findViewById(R.id.input_subprice);
        inputcategory.setOnClickListener(v -> {
            listitems = getResources().getStringArray(R.array.categories);
            showOptionDialog(listitems, "Select Product Category", "category");
        });
        inputaid.setOnClickListener(v -> {
            listitems = getResources().getStringArray(R.array.aid);
            showOptionDialog(listitems, "Select Input Dealer", "aid");
        });
        inputsubsidy.setOnClickListener(v -> {
            listitems = getResources().getStringArray(R.array.subsidized);
            showOptionDialog(listitems, "Select Input Dealer", "subsidy");
        });

    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        fm = getSupportFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    public void uploadproduct() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {

                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    AndroidUtils.uploadFileToServer(AgentActivity.this);
                    outcome = true;
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {

            }
        };
        asyncTask.execute();
    }

    private void prepareuploadfiles(Products products) {
        String jsonstring, uploadId, uploadfilepath;
        ServerTransfer transfer;
        transfer = new ServerTransfer();
        transfer.setProducts(products);
        jsonstring = new Gson().toJson(transfer);
        uploadId = AndroidUtils.getUUID();
        uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
    }
}
