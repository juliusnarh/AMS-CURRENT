package com.telpo.usb.finger.activities.input.distribution.search;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.ItemAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.PaymentMethodAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.PaymentStyleAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.ServiceAdapter;
import com.telpo.usb.finger.entities.Products;
import com.telpo.usb.finger.interfaces.ItemClickListener;
import com.telpo.usb.finger.interfaces.PaymentMethodClickListener;
import com.telpo.usb.finger.transition.FadeInTransition;
import com.telpo.usb.finger.transition.FadeOutTransition;
import com.telpo.usb.finger.transition.SimpleTransitionListener;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.BoilerplateActivity;
import com.telpo.usb.finger.utils.GridSpacingItemDecoration;
import com.telpo.usb.finger.utils.RecyclerTouchListener;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class SearchActivity extends BoilerplateActivity implements PaymentMethodClickListener, ItemClickListener {
    public List<Products> inventoryList = new ArrayList<>();
    public BottomSheetBehavior sheetBehavior;
    public int itemSize, orderSize;
    public int totalQuantity = 0, quantityTemp = 0;
    Intent intent, amsIntent;
    String farmerId;
    Resources res;
    int cart_count = 0;
    @BindView(R.id.items_recycler)
    RecyclerView itemsRecycler;
    @BindView(R.id.no_item)
    TextView no_item;
    double tempTotal = 0.0, totaled = 0.0;
    int itemPostion;
    MaterialDialog addItemDialog;
    @BindView(R.id.service_recycler)
    RecyclerView serviceRecycler;
    @BindView(R.id.no_service)
    TextView noServiceRecord;
    EditText service_name, service_type, service_desc;
    Spinner service_provider;
    int serviceSize, servPostion;
    private ItemAdapter itemadapter;
    private ServiceAdapter serviceadapter;
    private final TextWatcher watcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            itemadapter.getFilter().filter(s);
            serviceadapter.getFilter().filter(s);
        }

        public void afterTextChanged(Editable s) {
        }
    };
    private List<Products> serviceList;

    private Searchbar searchbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        inventoryList = new ArrayList<>();
        serviceList = new ArrayList<>();
        searchbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(searchbar);
        searchbar.searchval.addTextChangedListener(watcher);

        if (isFirstTimeRunning(savedInstanceState)) {
            // Start with an empty looking Toolbar
            // We are going to fade its contents in, as long as the activity finishes rendering
            searchbar.hideContent();

            ViewTreeObserver viewTreeObserver = searchbar.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    searchbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                    // after the activity has finished drawing the initial layout, we are going to continue the animation
                    // that we left off from the MainActivity
                    showSearch();
                }

                private void showSearch() {
                    // use the TransitionManager to animate the changes of the Toolbar
                    TransitionManager.beginDelayedTransition(searchbar, FadeInTransition.createTransition());
                    // here we are just changing all children to VISIBLE
                    searchbar.showContent();
                }
            });
        }

        res = getResources();
        Intent farmerIntent = getIntent();
        farmerId = farmerIntent.getStringExtra("farmerid");
        // make sure to check if this is the first time running the activity
        // we don't want to play the enter animation on configuration changes (i.e. orientation)
        //SETTING UP ITEM RECYCLER
        List<Products> llll = Products.listAll(Products.class);
        for (Products inventory : llll) {
            if (inventory.getPid().startsWith("SV")) {
                serviceList.add(inventory);
            } else inventoryList.add(inventory);
        }

        itemadapter = new ItemAdapter(this, inventoryList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        itemsRecycler.setLayoutManager(mLayoutManager);
        itemsRecycler.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        itemsRecycler.setItemAnimator(new DefaultItemAnimator());
        itemsRecycler.setAdapter(itemadapter);
        itemsRecycler.addOnItemTouchListener(new RecyclerTouchListener(this,
                itemsRecycler, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                final PaymentMethodAdapter adapter = new PaymentMethodAdapter(SearchActivity.this, R.array.item_list, SearchActivity.this);
                itemPostion = position;
                addItemDialog = new MaterialDialog.Builder(SearchActivity.this)
                        .title("Choose Action")
                        .titleColor(getResources().getColor(R.color.grey_600))
                        .adapter(adapter, null)
                        .autoDismiss(true)
                        .backgroundColor(getResources().getColor(R.color.viewBg))
                        .build();
                addItemDialog.show();
            }

            @Override
            public void onLongClick(View view, final int position) {

            }
        }));
        //SETTING UP ITEM RECYCLER

        //SETTING UP SERVICE RECYCLER
        serviceadapter = new ServiceAdapter(this, serviceList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        serviceRecycler.setLayoutManager(manager);
        serviceRecycler.setItemAnimator(new DefaultItemAnimator());
        serviceRecycler.setAdapter(serviceadapter);
        serviceRecycler.addOnItemTouchListener(new RecyclerTouchListener(this, serviceRecycler, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {

                final PaymentStyleAdapter adapter = new PaymentStyleAdapter(SearchActivity.this, R.array.services_list, SearchActivity.this);
                servPostion = position;
                addItemDialog = new MaterialDialog.Builder(SearchActivity.this)
                        .title("Choose Action")
                        .titleColor(getResources().getColor(R.color.grey_600))
                        .adapter(adapter, null)
                        .autoDismiss(true)
                        .backgroundColor(getResources().getColor(R.color.viewBg))
                        .build();
                addItemDialog.show();

            }

            @Override
            public void onLongClick(View view, final int position) {
            }
        }));


        toggleEmptyRecord(no_item);
        toggleEmptyRecord(noServiceRecord);

    }

    private boolean isFirstTimeRunning(Bundle savedInstanceState) {
        return savedInstanceState == null;
    }

    @Override
    public void finish() {
        // when the user tries to finish the activity we have to animate the exit
        // let's start by hiding the keyboard so that the exit seems smooth
        hideKeyboard();

        // at the same time, start the exit transition
        exitTransitionWithAction(new Runnable() {
            @Override
            public void run() {
                // which finishes the activity (for real) when done
                SearchActivity.super.finish();

                // override the system pending transition as we are handling ourselves
                overridePendingTransition(0, 0);
            }
        });
    }

    private void exitTransitionWithAction(final Runnable endingAction) {

        Transition transition = FadeOutTransition.withAction(new SimpleTransitionListener() {
            @Override
            public void onTransitionEnd(Transition transition) {
                endingAction.run();
            }
        });

        TransitionManager.beginDelayedTransition(searchbar, transition);
        searchbar.hideContent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else if (item.getItemId() == R.id.action_clear) {
            searchbar.clearText();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(String paymentStyle) {
        addItemDialog.dismiss();
        if (paymentStyle.equalsIgnoreCase("add item to cart")) {
            final MaterialDialog progDialog = new MaterialDialog.Builder(SearchActivity.this)
                    .title(R.string.please_wait)
                    .content(R.string.adding_item)
                    .progress(true, 0)
                    .cancelable(false)
                    .build();
            progDialog.show();

            new Handler().postDelayed(() -> {
                Products service = serviceList.get(servPostion);
                String inputName = service.getPname();
                String pid = service.getPid();
                String quantity = "1";
                String inputCat = service.getCategory();
                String price = service.getPrice();
                String sprice = price;
                String uuid = AndroidUtils.getUUID();
                String orderid = AndroidUtils.INPUTSALESID + AndroidUtils.getUUID();

                AndroidUtils.insertOrder(
                        farmerId,
                        pid,
                        orderid,
                        inputName,
                        quantity,
                        price,
                        sprice,
                        inputCat,
                        drawableToArray(R.drawable.services),
                        uuid,
                        new Date(),
                        AndroidUtils.getMacAddress(SearchActivity.this),
                        AndroidUtils.getIMEI(SearchActivity.this),
                        AndroidUtils.getPreferenceData(SearchActivity.this, AndroidUtils.AGENTNAME, ""),
                        AndroidUtils.getPreferenceData(SearchActivity.this, AndroidUtils.AGENTID, "")
                );


                progDialog.dismiss();
                Toasty.success(getApplicationContext(), "Inventory Added!").show();
            }, 2000);
        } else if (paymentStyle.equalsIgnoreCase("edit")) {
            final MaterialDialog progDialog = new MaterialDialog.Builder(SearchActivity.this)
                    .title(R.string.please_wait)
                    .content(R.string.adding_item)
                    .progress(true, 0)
                    .cancelable(false)
                    .build();
            progDialog.show();

            new Handler().postDelayed(() -> {
                progDialog.dismiss();
                MaterialDialog updateForm = new MaterialDialog.Builder(SearchActivity.this)
                        .title(R.string.edit)
                        .customView(R.layout.custom_service_update_form, true)
                        .positiveText(R.string.update)
                        .negativeText(R.string.negative)
                        .onPositive((materialDialog, dialogAction) -> {
                            String serviceProvider = String.valueOf(service_provider.getSelectedItem());
                            updateService(
                                    service_desc.getText().toString().trim(),
                                    serviceProvider,
                                    servPostion);
                            Toasty.success(getApplicationContext(), "Update successful").show();

                        })
                        .show();
                assert updateForm.getCustomView() != null;
                service_desc = updateForm.getCustomView().findViewById(R.id.et_service_desc);
                service_type = updateForm.getCustomView().findViewById(R.id.et_service_type);
                service_provider = updateForm.getCustomView().findViewById(R.id.service_provider);
            }, 2000);
        }
    }

    @Override
    public void onPaymentMethodClickListener(String paymentMethod) {
        addItemDialog.dismiss();

        new MaterialDialog.Builder(SearchActivity.this)
                .title(inventoryList.get(itemPostion).getPname())
                .content(R.string.enter_quantity)
                .theme(Theme.LIGHT)
                .widgetColorRes(R.color.secondary_light)
                .positiveColorRes(R.color.secondary_light)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .input("Quantity", null, (dialog1, input) -> {
                    // Do something
                    if (!input.toString().isEmpty()) {
                        if (!input.toString().equals("0")) {
                            final MaterialDialog progDialog = new MaterialDialog.Builder(SearchActivity.this)
                                    .title(R.string.please_wait)
                                    .content(R.string.adding_item)
                                    .progress(true, 0)
                                    .cancelable(false)
                                    .build();
                            progDialog.show();

                            new Handler().postDelayed(() -> {
                                Products item = inventoryList.get(itemPostion);
                                byte[] inputImg = item.getItem_img();
                                String inputName = item.getPname();
                                String pid = item.getPid();
                                String inputCat = item.getCategory();
                                String inventory = item.getQuantity();
                                String price = item.getPrice();
                                String sprice = item.getPrice();
                                String uuid = AndroidUtils.getUUID();
                                String orderid = AndroidUtils.INPUTSALESID + uuid;
                                String quantity = input.toString().trim();
                                if (Integer.parseInt(inventory) > Integer.parseInt(quantity)) {
                                    AndroidUtils.insertOrder(
                                            farmerId,
                                            pid,
                                            orderid,
                                            inputName,
                                            quantity,
                                            price,
                                            sprice,
                                            inputCat,
                                            inputImg,
                                            uuid,
                                            new Date(),
                                            AndroidUtils.getMacAddress(SearchActivity.this),
                                            AndroidUtils.getIMEI(SearchActivity.this),
                                            AndroidUtils.getPreferenceData(SearchActivity.this, AndroidUtils.AGENTNAME, ""),
                                            AndroidUtils.getPreferenceData(SearchActivity.this, AndroidUtils.AGENTID, ""));
                                    String newQuantityAvailable = String.valueOf(Integer.parseInt(inventory) - Integer.parseInt(quantity));
                                    updateInputQuantity(newQuantityAvailable, itemPostion);

                                    Toasty.success(getApplicationContext(), "Inventory Added!").show();
                                } else if (inventory.equals(quantity)) {

                                    AndroidUtils.insertOrder(
                                            farmerId,
                                            pid,
                                            orderid,
                                            inputName,
                                            quantity,
                                            price,
                                            sprice,
                                            inputCat,
                                            inputImg,
                                            uuid,
                                            new Date(),
                                            AndroidUtils.getMacAddress(SearchActivity.this),
                                            AndroidUtils.getIMEI(SearchActivity.this),
                                            AndroidUtils.getPreferenceData(SearchActivity.this, AndroidUtils.AGENTNAME, ""),
                                            AndroidUtils.getPreferenceData(SearchActivity.this, AndroidUtils.AGENTID, ""));
                                    String newQuantityAvailable = String.valueOf(Integer.parseInt(inventory) - Integer.parseInt(quantity));
                                    updateInputQuantity(newQuantityAvailable, itemPostion);


                                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                                    Toasty.success(getApplicationContext(), "Inventory Added!").show();
                                } else Toasty.error(this, "Inventory not available").show();

                                progDialog.dismiss();
                            }, 2000);
                        } else {
                            Toasty.error(getApplicationContext(), "Invalid input!").show();
                        }
                    } else
                        Toasty.error(getApplicationContext(), "Invalid input!").show();
                }).

                show();
    }


    public void toggleEmptyRecord(TextView textView) {
        itemSize = inventoryList.size();
        orderSize = AndroidUtils.getOrderCount();
        serviceSize = serviceList.size();
        if (textView.getId() == R.id.no_service) {
            if (serviceSize > 0) {
                textView.setVisibility(View.GONE);
            } else {
                textView.setVisibility(View.VISIBLE);
            }
        } else if (textView.getId() == R.id.no_item) {
            if (itemSize > 0) {
                textView.setVisibility(View.GONE);
            } else {
                textView.setVisibility(View.VISIBLE);
            }
        } else if (textView.getId() == R.id.no_order) {
            if (orderSize > 0) {
                textView.setVisibility(View.GONE);
            } else {
                textView.setVisibility(View.VISIBLE);

            }
        }
    }

    private void updateInputQuantity(String newQuantityAvailable, int position) {
        Products inventory = inventoryList.get(position);
        if (newQuantityAvailable.equals("0")) {
            inventoryList.remove(position);
            Products.delete(inventory);
        } else {
            inventory.quantity = newQuantityAvailable;
            inventory.save();
            inventoryList.set(position, inventory);
        }
        itemadapter.notifyItemChanged(position);
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private byte[] drawableToArray(int drawable) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drawable);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, outputStream);

        return outputStream.toByteArray();
    }

    private void updateService(String service_desc, String service_provider, int position) {
        Products service = serviceList.get(position);
//        if (!service_name.isEmpty()) {
//            service.pname = service_name;
//        }
        if (!service_provider.isEmpty() && !service_provider.equals("Service Provider")) {
            service.supplier = service_provider;
        } else if (service_provider.equals("Service Provider")) {
            Toasty.error(getApplicationContext(), "Invalid Service Provider").show();
        }
        if (!service_desc.isEmpty()) {
            service.pdesc = service_desc;
        }
        service.save();
        serviceList.set(position, service);
        serviceadapter.notifyItemChanged(position);
    }

}
