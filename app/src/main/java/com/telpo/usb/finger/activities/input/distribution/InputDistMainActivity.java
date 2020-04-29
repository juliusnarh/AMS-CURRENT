package com.telpo.usb.finger.activities.input.distribution;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import androidx.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.InputType;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.input.distribution.search.SearchActivity;
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.ItemAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.OrderItemAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.PackagelistAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.PaymentMethodAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.PaymentStyleAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.ServiceAdapter;
import com.telpo.usb.finger.databinding.ActivityInputdistMainBinding;
import com.telpo.usb.finger.entities.AvailablePackages;
import com.telpo.usb.finger.entities.OrderCart;
import com.telpo.usb.finger.entities.OrderItem;
import com.telpo.usb.finger.entities.Products;
import com.telpo.usb.finger.entities.ProductsFromDealer;
import com.telpo.usb.finger.interfaces.CouponClickListener;
import com.telpo.usb.finger.interfaces.ItemClickListener;
import com.telpo.usb.finger.interfaces.PaymentMethodClickListener;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.service.AmsService;
import com.telpo.usb.finger.transition.FadeInTransition;
import com.telpo.usb.finger.transition.FadeOutTransition;
import com.telpo.usb.finger.transition.SimpleTransitionListener;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.BoilerplateActivity;
import com.telpo.usb.finger.utils.Converter;
import com.telpo.usb.finger.utils.GridSpacingItemDecoration;
import com.telpo.usb.finger.utils.RecyclerTouchListener;
import com.telpo.usb.finger.utils.SimpleToolbar;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class InputDistMainActivity extends BoilerplateActivity implements PaymentMethodClickListener, ItemClickListener, CouponClickListener, ListDialogFragment.OnListDialogItemSelect {

    public static final String PREF = "prepare_inputs";
    public static String EXTRA_FARMER_ID = "farmerid";
    int cart_count = 0, acreage = 0, oldacreage = 0, itemPostion, serviceSize, servPostion, itemSize, orderSize, totalQuantity = 0, quantityTemp = 0;
    double tempTotal = 0.0, totaled = 0.0;
    BottomSheetBehavior sheetBehavior;
    Intent intent, amsIntent;
    String farmerId;
    Resources res;
    MaterialDialog addItemDialog;
    EditText service_name, service_desc, service_cost, serviceprovider, servicetype;
    List<OrderCart> orderCartList;
    ActivityInputdistMainBinding binding;
    String acreageservice;
    ListDialogFragment dialogFragment;
    FragmentManager fm;
    String[] listitems;
    List<Products> inventoryList = new ArrayList<>();
    List<AvailablePackages> availablePackagesList = new ArrayList<>();
    MaterialDialog progDialog;
    private ItemAdapter itemadapter;
    private OrderItemAdapter orderItemAdapter;
    private ServiceAdapter serviceadapter;
    private List<Products> serviceList;
    private List<OrderItem> orderItemList;
    private SimpleToolbar toolbar;
    private int toolbarMargin;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateUI(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_inputdist_main);
        AndroidUtils.hideKeyboard(this);
        res = getResources();
        Intent farmerIntent = getIntent();
        farmerId = farmerIntent.getStringExtra("farmerid");
        String type = farmerIntent.getStringExtra("type");
        AndroidUtils.savePreferenceData(InputDistMainActivity.this, AndroidUtils.FAFFARMERID_PREF, farmerId);
        amsIntent = new Intent(this, AmsService.class);
        orderCartList = OrderCart.find(OrderCart.class, "farmerid = ?", farmerId);
        inventoryList = new ArrayList<>();
        serviceList = new ArrayList<>();

        ////
        orderItemList = new ArrayList<>();
        orderItemAdapter = new OrderItemAdapter(orderItemList);
        binding.bottomsheetIncluded.recyclerCart.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.bottomsheetIncluded.recyclerCart.setItemAnimator(new DefaultItemAnimator());
        binding.bottomsheetIncluded.recyclerCart.setAdapter(orderItemAdapter);
        /////
        availablePackagesList = AvailablePackages.listAll(AvailablePackages.class);

        toggleEmptyRecord(binding.bottomsheetIncluded.noOrder);

        getPendingOrder();

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        toolbarMargin = getResources().getDimensionPixelSize(R.dimen.toolbarMargin);

        ///
        if (type.equalsIgnoreCase("0")) {
            binding.serviceIncluded.serviceRecycler.setVisibility(View.GONE);
            binding.serviceIncluded.noService.setVisibility(View.GONE);
            binding.services.setVisibility(View.GONE);
            List<Products> llll = Products.listAll(Products.class);
            for (Products inventory : llll) {
                if (!inventory.getPid().startsWith(AndroidUtils.SERVICETRANSID) && inventory.getPid().endsWith(AndroidUtils.CONTRACTID)) {
//                    if (inventory.getSupplier().equalsIgnoreCase("agra"))
//                        govcouponList.add(inventory);
//                    else
//                        rmgranscouponList.add(inventory);
                } else if (!inventory.getPid().startsWith(AndroidUtils.SERVICETRANSID)) {
                    inventoryList.add(inventory);
                }
            }
        } else {
            binding.itemsIncluded.itemsRecycler.setVisibility(View.GONE);
            binding.itemsIncluded.noItem.setVisibility(View.GONE);
            binding.products.setVisibility(View.GONE);
            binding.subsidizedBtn.setVisibility(View.GONE);
            List<Products> llll = Products.listAll(Products.class);
            for (Products inventory : llll) {
                if (inventory.getPid().startsWith("SV")) {
                    serviceList.add(inventory);
                }
            }
        }

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Prepare the keyboard as soon as the user touches the Toolbar
                // This will make the transition look faster
                showKeyboard();
                transitionToSearch();
            }
        });


////////////////////////////////////////////////////////////////////////////////////////////////////

        if (farmerId != null) {

            String[] farmerInfo = AndroidUtils.loadFarmerInformation(farmerId);
            binding.farmerCode.setText(farmerId);
            byte[] img = AndroidUtils.loadFarmerImg(farmerId, getResources());
            Glide.with(this).load(img).apply(RequestOptions.circleCropTransform()).into(binding.farmerImg);
            binding.farmerName.setText(farmerInfo[0]);
            binding.farmerNumber.setText(farmerInfo[5]);
        }

        sheetBehavior = BottomSheetBehavior.from(binding.bottomsheetIncluded.itemBottomSheet);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN: {
                        binding.bottomfab.setImageResource(R.drawable.up_chevron);
                    }
                    break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        binding.bottomfab.setImageResource(R.drawable.down_chevron);
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });

        //BUTTON CLICK LISTENER
        binding.bottomfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    binding.bottomfab.setImageResource(R.drawable.down_chevron);
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                if (sheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    binding.bottomfab.setImageResource(R.drawable.up_chevron);
                    sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
                if (sheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    binding.bottomfab.setImageResource(R.drawable.down_chevron);

                }
            }
        });

        binding.farmerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputDistMainActivity.this, ProfileActivity.class);
                intent.putExtra("farmerid", farmerId);
                startActivity(intent);
            }
        });

        binding.subsidizedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (availablePackagesList.size() > 0) {
                    String[] pkglist = new String[availablePackagesList.size()];
                    for (int i = 0; i < availablePackagesList.size(); i++) {
                        pkglist[i] = availablePackagesList.get(i).getPackagename();
                    }

                    new MaterialDialog.Builder(InputDistMainActivity.this)
                            .title("Acreage")
                            .content("Please enter farm acreage")
                            .theme(Theme.LIGHT)
                            .positiveColorRes(R.color.text_color)
                            .inputType(InputType.TYPE_CLASS_NUMBER)
                            .input("Acreage", null, false, new MaterialDialog.InputCallback() {
                                @Override
                                public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {

                                    acreage = Integer.parseInt(input.toString().trim());

                                    if (acreage != 0) {

                                        final PackagelistAdapter adapter = new PackagelistAdapter(InputDistMainActivity.this, pkglist, InputDistMainActivity.this);
                                        addItemDialog = new MaterialDialog.Builder(InputDistMainActivity.this)
                                                .title("Choose Package")
                                                .titleColor(getResources().getColor(R.color.grey_600))
                                                .adapter(adapter, null)
                                                .autoDismiss(true)
                                                .cancelable(false)
                                                .negativeText("Cancel")
                                                .onNegative((dialog1, which) -> addItemDialog.dismiss())
                                                .backgroundColor(getResources().getColor(R.color.viewBg))
                                                .build();
                                        addItemDialog.show();
                                    } else {
                                        if (orderCartList.size() > 0) {
                                            for (OrderCart order : orderCartList) {
                                                if (order.getInputName().toLowerCase().startsWith("lum")) {
                                                    oldacreage = Integer.parseInt(order.getQuantity());
                                                    break;
                                                }
                                            }
                                        } else
                                            Toasty.error(getApplicationContext(), "Invalid input").show();
                                    }
                                }
                            })
                            .show();

                } else
                    Toasty.error(getApplicationContext(), "No package available").show();
            }
        });


        if (type.equalsIgnoreCase("0")) {
            itemadapter = new ItemAdapter(this, inventoryList);
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
            binding.itemsIncluded.itemsRecycler.setLayoutManager(mLayoutManager);
            binding.itemsIncluded.itemsRecycler.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
            binding.itemsIncluded.itemsRecycler.setItemAnimator(new DefaultItemAnimator());
            binding.itemsIncluded.itemsRecycler.setAdapter(itemadapter);
            binding.itemsIncluded.itemsRecycler.addOnItemTouchListener(new RecyclerTouchListener(this,
                    binding.itemsIncluded.itemsRecycler, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, int position) {

                    final PaymentMethodAdapter adapter = new PaymentMethodAdapter(InputDistMainActivity.this, R.array.item_list, InputDistMainActivity.this);
                    itemPostion = position;
                    addItemDialog = new MaterialDialog.Builder(InputDistMainActivity.this)
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
            toggleEmptyRecord(binding.itemsIncluded.noItem);

        } else {
            serviceadapter = new ServiceAdapter(this, serviceList);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
            binding.serviceIncluded.serviceRecycler.setLayoutManager(manager);
            binding.serviceIncluded.serviceRecycler.setItemAnimator(new DefaultItemAnimator());
            binding.serviceIncluded.serviceRecycler.setAdapter(serviceadapter);
            binding.serviceIncluded.serviceRecycler.addOnItemTouchListener(new RecyclerTouchListener(this, binding.serviceIncluded.serviceRecycler, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, final int position) {

                    final PaymentStyleAdapter adapter = new PaymentStyleAdapter(InputDistMainActivity.this, R.array.services_list, InputDistMainActivity.this);
                    servPostion = position;
                    addItemDialog = new MaterialDialog.Builder(InputDistMainActivity.this)
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

            toggleEmptyRecord(binding.serviceIncluded.noService);
        }


        binding.bottomsheetIncluded.resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(InputDistMainActivity.this)
                        .title("Cancel Order?")
                        .titleColorRes(R.color.grey_600)
                        .content("Do you want to cancel transaction?")
                        .positiveText("Yes")
                        .negativeText("No")
                        .positiveColorRes(R.color.text_color)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                if (binding.bottomsheetIncluded.noOrder.getVisibility() == View.GONE) {

                                    resetAllOrders();

                                } else
                                    Toasty.error(getApplicationContext(), "No order available").show();
                            }
                        })
                        .show();
            }
        });

        binding.bottomsheetIncluded.proceedBtn.setOnClickListener(v -> {
            orderSize = AndroidUtils.getOrderCount();
            if (orderSize != 0) {
                intent = new Intent(InputDistMainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_FARMER_ID, farmerId);
                intent.putExtra("acreage", String.valueOf(acreage + oldacreage));
                startActivity(intent);

            } else {
                toggleEmptyRecord(binding.bottomsheetIncluded.noOrder);
                Toasty.error(getApplicationContext(), "Cart is empty", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void transitionToSearch() {
        // create a transition that navigates to search when complete
        Transition transition = FadeOutTransition.withAction(navigateToSearchWhenDone());
        binding.snuffooo.setVisibility(View.INVISIBLE);
        binding.snuffooo2.setVisibility(View.INVISIBLE);
        // let the TransitionManager do the heavy work for us!
        // all we have to do is change the attributes of the toolbar and the TransitionManager animates the changes
        // in this case I am removing the bounds of the toolbar (to hide the blue padding on the screen) and
        // I am hiding the contents of the Toolbar (Navigation icon, Title and Option Items)
        TransitionManager.beginDelayedTransition(toolbar, transition);
        FrameLayout.LayoutParams frameLP = (FrameLayout.LayoutParams) toolbar.getLayoutParams();
        frameLP.setMargins(0, 0, 0, 0);
        toolbar.setLayoutParams(frameLP);
        toolbar.hideContent();
    }

    private Transition.TransitionListener navigateToSearchWhenDone() {
        return new SimpleTransitionListener() {
            @Override
            public void onTransitionEnd(Transition transition) {
                Intent intent = new Intent(InputDistMainActivity.this, SearchActivity.class);
                intent.putExtra("farmerid", farmerId);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        };
    }

    private void fadeToolbarIn() {
        TransitionManager.beginDelayedTransition(toolbar, FadeInTransition.createTransition());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) toolbar.getLayoutParams();
        layoutParams.setMargins(toolbarMargin, toolbarMargin, toolbarMargin, toolbarMargin);
        toolbar.showContent();
        toolbar.setLayoutParams(layoutParams);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.inputdist_menu, menu);
        final MenuItem menuItem = menu.findItem(R.id.action_cart);
        menuItem.setIcon(Converter.convertLayoutToImage(InputDistMainActivity.this, cart_count, R.drawable.twotone_shopping_cart_24));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                hideKeyboard();
                transitionToSearch();
                return true;

            case R.id.action_cart:
                intent = new Intent(InputDistMainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_FARMER_ID, farmerId);
                intent.putExtra("acreage", String.valueOf(acreage + oldacreage));

                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private byte[] drawableToArray(int drawable) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drawable);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, outputStream);

        return outputStream.toByteArray();
    }

    private void updateService(String pname, String cost, String service_desc, String service_provider, int position) {
        Products service = serviceList.get(position);

        service.supplier = service_provider;
        service.pdesc = service_desc;
        service.price = cost;
        service.pname = pname;

        service.save();
        serviceList.set(position, service);
        serviceadapter.notifyItemChanged(position);
        prepareuploadfiles(service);
        uploadproduct();
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
                    AndroidUtils.uploadFileToServer(InputDistMainActivity.this);
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

    @Override
    protected void onResume() {
        super.onResume();
        fadeToolbarIn();
        reset();
        getPendingOrder();
        binding.snuffooo.setVisibility(View.VISIBLE);
        binding.snuffooo2.setVisibility(View.VISIBLE);
        startService(amsIntent);
        registerReceiver(broadcastReceiver, new IntentFilter(AmsService.BROADCAST_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
        stopService(amsIntent);
    }

    private void getPendingOrder() {
        orderCartList = OrderCart.find(OrderCart.class, "farmerid = ?", farmerId);
        oldacreage = 0;
        acreage = 0;
        OrderItem item;
        if (orderCartList.size() > 0) {
            String iName, quantity, price;
            totaled = 0.00;
            tempTotal = 0.00;
            item = new OrderItem();
            binding.bottomsheetIncluded.noOrder.setVisibility(View.GONE);
            for (int i = 0; i < orderCartList.size(); i++) {
                OrderCart order = orderCartList.get(i);
                if (order != null) {

                    if (order.getOrderid().startsWith(AndroidUtils.COUPOUNORDERID)) {
                        if (order.getInputName().toLowerCase().startsWith("lum")) {
                            oldacreage = Integer.parseInt(order.getQuantity());
                        }
                        price = order.getSprice();
                    } else if (order.getOrderid().startsWith(AndroidUtils.SERVICETRANSID)) {
                        oldacreage = Integer.parseInt(order.getQuantity());
                        price = order.getPrice();
                    } else
                        price = order.getPrice();


                    iName = order.getInputName();
                    quantity = order.getQuantity();

                    item.setQuantity(quantity);
                    item.setPname(iName);
                    item.setPrice(price);

                    orderItemAdapter.add(item, 0);

                    totaled = Double.parseDouble(price) * Integer.parseInt(quantity);
                    totaled += tempTotal;
                    tempTotal = totaled;
                } else {
                    totaled = 0.00;
                }
            }
        }
        binding.bottomsheetIncluded.total.setText(String.format(res.getString(R.string.price_item), totaled));
        binding.bottomsheetIncluded.noOrder.setVisibility(View.VISIBLE);
    }

    public void toggleEmptyRecord(TextView textView) {
        itemSize = inventoryList.size();
        orderSize = AndroidUtils.getOrderCount();
        serviceSize = serviceList.size();
        if (textView.getId() == R.id.no_service) {
            if (serviceSize > 0) {
                textView.setVisibility(View.GONE);
                binding.bottomsheetIncluded.recyclerCart.setVisibility(View.VISIBLE);
            } else {
                textView.setVisibility(View.VISIBLE);
                binding.bottomsheetIncluded.recyclerCart.setVisibility(View.GONE);
            }
        } else if (textView.getId() == R.id.no_item) {
            if (itemSize > 0) {
                textView.setVisibility(View.GONE);
                binding.bottomsheetIncluded.recyclerCart.setVisibility(View.VISIBLE);
            } else {
                textView.setVisibility(View.VISIBLE);
                binding.bottomsheetIncluded.recyclerCart.setVisibility(View.GONE);
            }
        } else if (textView.getId() == R.id.no_order) {
            if (orderSize > 0) {
                textView.setVisibility(View.GONE);
                binding.bottomsheetIncluded.recyclerCart.setVisibility(View.VISIBLE);
            } else {
                textView.setVisibility(View.VISIBLE);
                binding.bottomsheetIncluded.recyclerCart.setVisibility(View.GONE);
                binding.bottomsheetIncluded.total.setText(R.string.empty2);
                orderItemAdapter.removeAll();
            }
        }

    }

    public void resetAllOrders() {
        OrderCart.deleteAll(OrderCart.class);
        tempTotal = 0.00;
        totaled = 0.00;
        binding.bottomsheetIncluded.total.setText(R.string.empty2);
        orderItemAdapter.removeAll();

        totalQuantity = 0;
        quantityTemp = 0;
        orderCartList.clear();
        toggleEmptyRecord(binding.bottomsheetIncluded.noOrder);
    }

    public void reset() {
        tempTotal = 0.00;
        totaled = 0.00;
        orderItemAdapter.removeAll();
        binding.bottomsheetIncluded.total.setText(R.string.empty2);
        totalQuantity = 0;
        quantityTemp = 0;
        oldacreage = 0;
        toggleEmptyRecord(binding.bottomsheetIncluded.noOrder);
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

    private void updateUI(Intent intent) {
        if (intent.getStringExtra("cartCount") == null) {
            cart_count = 0;
        } else {
            cart_count = Integer.parseInt(intent.getStringExtra("cartCount"));
        }
        invalidateOptionsMenu();
    }

    //FOR ITEMS
    @Override
    public void onPaymentMethodClickListener(String paymentMethod) {
        addItemDialog.dismiss();

        new MaterialDialog.Builder(InputDistMainActivity.this)
                .title(inventoryList.get(itemPostion).getPname())
                .content(R.string.enter_quantity)
                .theme(Theme.LIGHT)
                .widgetColorRes(R.color.text_color)
                .positiveColorRes(R.color.text_color)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .input("Quantity", null, false, (dialog1, input) -> {
                    // Do something
                    if (!input.toString().isEmpty()) {
                        if (!input.toString().equals("0")) {
                            final MaterialDialog progDialog = new MaterialDialog.Builder(InputDistMainActivity.this)
                                    .title(R.string.please_wait)
                                    .content(R.string.adding_item)
                                    .progress(true, 0)
                                    .cancelable(false)
                                    .build();
                            progDialog.show();

                            new Handler().postDelayed(() -> {
                                Products item = inventoryList.get(itemPostion);
                                OrderItem singleItem = new OrderItem();
                                byte[] inputImg = item.getItem_img();
                                String pid = item.getPid();
                                String inputName = item.getPname();
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
                                            AndroidUtils.getMacAddress(InputDistMainActivity.this),
                                            AndroidUtils.getIMEI(InputDistMainActivity.this),
                                            AndroidUtils.getPreferenceData(InputDistMainActivity.this, AndroidUtils.AGENTNAME, ""),
                                            AndroidUtils.getPreferenceData(InputDistMainActivity.this, AndroidUtils.AGENTID, "")
                                    );
                                    String newQuantityAvailable = String.valueOf(Integer.parseInt(inventory) - Integer.parseInt(quantity));
                                    updateInputQuantity(newQuantityAvailable, itemPostion);

                                    Resources res = getResources();

                                    totalQuantity = Integer.parseInt(quantity);
                                    totalQuantity += quantityTemp;
                                    quantityTemp = totalQuantity;


                                    singleItem.setQuantity(quantity);
                                    singleItem.setPname(inputName);
                                    singleItem.setPrice(price);
                                    orderItemAdapter.add(singleItem, 0);


                                    totaled = Double.parseDouble(price) * Integer.parseInt(quantity);
                                    totaled += tempTotal;
                                    tempTotal = totaled;
                                    binding.bottomsheetIncluded.total.setText(String.format(res.getString(R.string.price_item), totaled));


                                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                                    Toasty.success(getApplicationContext(), "Item Added!", Toast.LENGTH_SHORT).show();
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
                                            AndroidUtils.getMacAddress(InputDistMainActivity.this),
                                            AndroidUtils.getIMEI(InputDistMainActivity.this),
                                            AndroidUtils.getPreferenceData(InputDistMainActivity.this, AndroidUtils.AGENTNAME, ""),
                                            AndroidUtils.getPreferenceData(InputDistMainActivity.this, AndroidUtils.AGENTID, "")
                                    );

                                    String newQuantityAvailable = String.valueOf(Integer.parseInt(inventory) - Integer.parseInt(quantity));
                                    updateInputQuantity(newQuantityAvailable, itemPostion);

                                    Resources res = getResources();

                                    totalQuantity = Integer.parseInt(quantity);
                                    totalQuantity += quantityTemp;
                                    quantityTemp = totalQuantity;



                                    singleItem.setQuantity(quantity);
                                    singleItem.setPname(inputName);
                                    singleItem.setPrice(price);
                                    orderItemAdapter.add(singleItem, 0);

                                    totaled = Double.parseDouble(price) * Integer.parseInt(quantity);
                                    totaled += tempTotal;
                                    tempTotal = totaled;
                                    binding.bottomsheetIncluded.total.setText(String.format(res.getString(R.string.price_item), totaled));

                                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                                    Toasty.success(getApplicationContext(), "Item Added!", Toast.LENGTH_SHORT).show();
                                } else Toasty.error(this, "Item not available").show();

                                progDialog.dismiss();
                                toggleEmptyRecord(binding.bottomsheetIncluded.noOrder);
                            }, 2000);
                        } else {
                            Toasty.error(getApplicationContext(), "Invalid input!", Toast.LENGTH_SHORT).show();
                        }
                    } else
                        Toasty.error(getApplicationContext(), "Invalid input!", Toast.LENGTH_SHORT).show();
                }).

                show();

    }
    ////////////////////////////

    //FOR SERVICES
    @Override
    public void onItemClick(String paymentStyle) {
        addItemDialog.dismiss();

        Products service = serviceList.get(servPostion);
        String pid = service.getPid();
        String inputName = service.getPname();
        String inputCat = service.getCategory();
        String price = service.getPrice();
        String sprice = price;
        String uuid = service.getUniqueuid();
        String orderid = AndroidUtils.SERVICETRANSID + AndroidUtils.getUUID();
        if (paymentStyle.equalsIgnoreCase("add item to cart")) {
            final MaterialDialog progDialog = new MaterialDialog.Builder(InputDistMainActivity.this)
                    .title(R.string.please_wait)
                    .content(R.string.adding_item)
                    .progress(true, 0)
                    .cancelable(false)
                    .build();
            progDialog.show();

            new Handler().postDelayed(() -> {
                progDialog.dismiss();
                OrderItem singleItem = new OrderItem();
//                Products service = serviceList.get(servPostion);
//                String pid = service.getPid();
//                String inputName = service.getPname();
//                String inputCat = service.getCategory();
//                String price = service.getPrice();
//                String sprice = price;
//                String uuid = service.getUniqueuid();
//                String orderid = AndroidUtils.SERVICETRANSID + AndroidUtils.getUUID();

                new MaterialDialog.Builder(InputDistMainActivity.this)
                        .title(serviceList.get(servPostion).getPname())
                        .content("Please enter acreage for service")
                        .theme(Theme.LIGHT)
                        .widgetColorRes(R.color.secondary_light)
                        .positiveColorRes(R.color.secondary_light)
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .input("acreage", null, new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                                if (!input.toString().isEmpty()) {
                                    if (!input.toString().equals("0")) {
                                        acreageservice = input.toString();
                                        AndroidUtils.insertOrder(
                                                farmerId,
                                                pid,
                                                orderid,
                                                inputName,
                                                acreageservice,
                                                price,
                                                sprice,
                                                inputCat,
                                                drawableToArray(R.drawable.services),
                                                uuid,
                                                new Date(),
                                                AndroidUtils.getMacAddress(InputDistMainActivity.this),
                                                AndroidUtils.getIMEI(InputDistMainActivity.this),
                                                AndroidUtils.getPreferenceData(InputDistMainActivity.this, AndroidUtils.AGENTNAME, ""),
                                                AndroidUtils.getPreferenceData(InputDistMainActivity.this, AndroidUtils.AGENTID, "")
                                        );

                                        toggleEmptyRecord(binding.bottomsheetIncluded.noOrder);
                                        acreage = Integer.parseInt(acreageservice);
                                        Resources res = getResources();

                                        singleItem.setQuantity(acreageservice);
                                        singleItem.setPname(inputName);
                                        singleItem.setPrice(price);
                                        orderItemAdapter.add(singleItem, 0);

                                        totaled = Double.parseDouble(price) * Integer.parseInt(acreageservice);
                                        totaled += tempTotal;
                                        tempTotal = totaled;
                                        binding.bottomsheetIncluded.total.setText(String.format(res.getString(R.string.price_item), totaled));

                                        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                                        Toasty.success(getApplicationContext(), "Item Added!").show();

                                    } else
                                        Toasty.error(getApplicationContext(), "Invalid input!").show();
                                } else
                                    Toasty.error(getApplicationContext(), "Invalid input!").show();
                            }
                        })
                        .show();

            }, 1000);
        }
        else if (paymentStyle.equalsIgnoreCase("edit")) {
            final MaterialDialog progDialog = new MaterialDialog.Builder(InputDistMainActivity.this)
                    .title(R.string.please_wait)
                    .content(R.string.adding_item)
                    .progress(true, 0)
                    .cancelable(false)
                    .build();
            progDialog.show();

            new Handler().postDelayed(() -> {
                progDialog.dismiss();
                MaterialDialog updateForm = new MaterialDialog.Builder(InputDistMainActivity.this)
                        .title(R.string.edit)
                        .customView(R.layout.custom_service_form, true)
                        .positiveText(R.string.update)
                        .negativeText(R.string.negative)
                        .cancelable(false)
                        .onPositive((materialDialog, dialogAction) -> {
                            String serviceProvider = serviceprovider.getText().toString();
                            updateService(
                                    service_name.getText().toString().trim(),
                                    service_cost.getText().toString().trim(),
                                    service_desc.getText().toString().trim(),
                                    serviceProvider,
                                    servPostion);
                            toggleEmptyRecord(binding.bottomsheetIncluded.noOrder);
                            Toasty.success(getApplicationContext(), "Update successful").show();

                        })
                        .show();
                assert updateForm.getCustomView() != null;
                service_desc = updateForm.getCustomView().findViewById(R.id.et_service_desc);
                serviceprovider = updateForm.getCustomView().findViewById(R.id.service_provider);
                service_cost = updateForm.getCustomView().findViewById(R.id.et_service_cost);
                service_name = updateForm.getCustomView().findViewById(R.id.et_service_type);
                serviceprovider.setOnClickListener(v -> {
                    listitems = getResources().getStringArray(R.array.serviceprovider);
                    showOptionDialog(listitems, "Select Service Provider", "serviceprovider");
                });

                service_cost.setText(service.getPrice());
                service_desc.setText(service.getPdesc());
                serviceprovider.setText(service.getSupplier());
                service_name.setText(service.getPname());
            }, 1000);
        }
    }

    @Override
    public void onCouponClickListener(String coupon) {
        addItemDialog.dismiss();
        savingorders(coupon);
    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("serviceprovider")) {
            serviceprovider.setText(selection);
        }

        if (componentname.equalsIgnoreCase("servicetype")) {
            servicetype.setText(selection);
        }
    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        fm = getSupportFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    public void savingorders(String packagename) {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
                progDialog = new MaterialDialog.Builder(InputDistMainActivity.this)
                        .title(R.string.please_wait)
                        .content("Loading inputs into cart")
                        .progress(true, 0)
                        .cancelable(false)
                        .build();
                progDialog.show();
                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                List<ProductsFromDealer> fromDealerList = ProductsFromDealer.find(ProductsFromDealer.class, "packagename = ?", packagename);
                List<AvailablePackages> availablePackages = AvailablePackages.find(AvailablePackages.class, "packagename = ?", packagename);
                char[] contractsplit = availablePackages.get(0).getContract().toCharArray();
                if (fromDealerList.size() > 0) {
                    for (int i = 0; i < fromDealerList.size(); i++) {
                        ProductsFromDealer products = fromDealerList.get(i);
                        String uuid = AndroidUtils.getUUID();
                        String orderid = AndroidUtils.COUPOUNORDERID + uuid;

                        int requestedquantity = acreage * Integer.parseInt(String.valueOf(contractsplit[i]));
                        int availablequantity = Integer.parseInt(products.getQuantity());

                        int resultquantity = availablequantity - requestedquantity;

                        if (resultquantity < 0) {
                            requestedquantity = availablequantity;
                        }
                        AndroidUtils.insertOrder(
                                farmerId,
                                products.getPid(),
                                orderid,
                                products.getPname(),
                                String.valueOf(requestedquantity),
                                products.getPrice(),
                                products.getSubprice(),
                                products.getCategory(),
                                products.getItem_img(),
                                uuid,
                                new Date(),
                                AndroidUtils.getMacAddress(InputDistMainActivity.this),
                                AndroidUtils.getIMEI(InputDistMainActivity.this),
                                AndroidUtils.getPreferenceData(InputDistMainActivity.this, AndroidUtils.AGENTNAME, ""),
                                AndroidUtils.getPreferenceData(InputDistMainActivity.this, AndroidUtils.AGENTID, "")
                        );
                    }
                } else {
                    List<Products> productsList = Products.find(Products.class, "supplier = ?", packagename);

                    for (int i = 0; i < productsList.size(); i++) {
                        Products products = productsList.get(i);
                        String uuid = AndroidUtils.getUUID();
                        String orderid = AndroidUtils.COUPOUNORDERID + uuid;
                        AndroidUtils.insertOrder(
                                farmerId,
                                products.getPid(),
                                orderid,
                                products.getPname(),
                                String.valueOf(acreage * Integer.parseInt(String.valueOf(contractsplit[i]))),
                                products.getPrice(),
                                products.getSubprice(),
                                products.getCategory(),
                                products.getItem_img(),
                                uuid,
                                new Date(),
                                AndroidUtils.getMacAddress(InputDistMainActivity.this),
                                AndroidUtils.getIMEI(InputDistMainActivity.this),
                                AndroidUtils.getPreferenceData(InputDistMainActivity.this, AndroidUtils.AGENTNAME, ""),
                                AndroidUtils.getPreferenceData(InputDistMainActivity.this, AndroidUtils.AGENTID, "")
                        );
                    }

                }
                Intent orderIntent = new Intent(InputDistMainActivity.this, OrderActivity.class);
                if (farmerId != null) {
                    orderIntent.putExtra(EXTRA_FARMER_ID, farmerId);
                }
                orderIntent.putExtra("acreage", String.valueOf(acreage + oldacreage));
                orderIntent.putExtra("recoverybagsperacre", availablePackages.get(0).getRecoverybagsperacre());
                startActivity(orderIntent);
                progDialog.dismiss();
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {
                if (outcome) {
                    progDialog.dismiss();
                }
            }
        };
        asyncTask.execute();
    }

}
