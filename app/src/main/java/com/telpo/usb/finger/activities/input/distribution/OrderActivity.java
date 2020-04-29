package com.telpo.usb.finger.activities.input.distribution;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.google.gson.Gson;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.CouponAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.OrderAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.PaymentMethodAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.PaymentStyleAdapter;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.OrderCart;
import com.telpo.usb.finger.entities.ProductsFromDealer;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.inputdistributions_fragment.ReviewOrderDialogFragment;
import com.telpo.usb.finger.interfaces.CouponClickListener;
import com.telpo.usb.finger.interfaces.ItemClickListener;
import com.telpo.usb.finger.interfaces.PaymentMethodClickListener;
import com.telpo.usb.finger.interfaces.ReviewClicklistener;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.RecyclerItemTouchHelper;
import com.telpo.usb.finger.utils.SmsBroadcastReceiver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;

public class OrderActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener, DatePickerDialog.OnDateSetListener, ItemClickListener, CouponClickListener, ReviewClicklistener, PaymentMethodClickListener {

    public List<OrderCart> orderList, fullcostList, subsidizedList;
    public List<Sales> salesList = new ArrayList<>();
    public Double totaled = 0.00, markettotal = 0.00, appliedsub = 0.00, payableamt = 0.00, tendered = 0.00, norecoverybags = 0.00, tempTotal = 0.00, mobileMoney;
    String farmer_id;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.no_order_record)
    TextView no_order;
    @BindView(R.id.coord)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.order_recycler)
    RecyclerView orderRecycler;
    @BindView(R.id.total_Order)
    TextView orderTotal;
    @BindView(R.id.checkout_btn)
    Button checkoutBtn;
    @BindView(R.id.bottomfab_order)
    FloatingActionButton fab;
    @BindView(R.id.bottom_sheet)
    LinearLayout layoutBottomSheet;
    BottomSheetBehavior sheetBehavior;
    Resources res;
    StringBuilder orderDetails = new StringBuilder(), totalQuantity = new StringBuilder(), orderCost = new StringBuilder();
    EditText agreedItems, agreedDate;
    TextView declaration;
    String paymentStyle, subsidy, agentname, agentid, couponcode, transactionId, recoverybagsperacre = null, paymentMethod, mmTransactionID, status = "owing";
    List<String> iname, iquantity, icat, icost;
    String[] farmerInfo;
    SmsBroadcastReceiver smsBroadcastReceiver;
    int acreage = 0;
    private final TextWatcher agreedItemsWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            declaration.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {
                declaration.setVisibility(View.GONE);
            } else {
                declaration.setText(String.format(res.getString(R.string.sms_declaration_alt), farmerInfo[0], agreedItems.getText().toString().trim(), totaled, String.valueOf(acreage)));
            }
        }
    };

    MaterialDialog styleDialog, methodDialog;
    int _year, _month, _day;
    private OrderAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(1000);
        filter.addAction(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        registerReceiver(smsBroadcastReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(smsBroadcastReceiver);
        OrderCart.deleteAll(OrderCart.class);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        res = getResources();
        setUpToolbar();
        toggleEmptyRecord();
        orderList = new ArrayList<>();
        icat = new ArrayList<>();
        icost = new ArrayList<>();
        iquantity = new ArrayList<>();
        iname = new ArrayList<>();
        getIntentData();
        orderList = OrderCart.find(OrderCart.class, "farmerid = ?", farmer_id);
        farmerInfo = AndroidUtils.loadFarmerInformation(farmer_id);
        agentid = AndroidUtils.getPreferenceData(OrderActivity.this, AndroidUtils.AGENTID, "");
        agentname = AndroidUtils.getPreferenceData(OrderActivity.this, AndroidUtils.AGENTNAME, "");

        subsidizedList = new ArrayList<>();
        fullcostList = new ArrayList<>();
        smsBroadcastReceiver = new SmsBroadcastReceiver("MobileMoney", "payment received");

        if (orderList.size() > 0) {

            adapter = new OrderAdapter(this, orderList, orderTotal, OrderActivity.this);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            orderRecycler.setLayoutManager(mLayoutManager);
            orderRecycler.setItemAnimator(new FadeInAnimator());
            orderRecycler.getItemAnimator().setAddDuration(1200);
            orderRecycler.setAdapter(adapter);
            DividerItemDecoration itemDecorator = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
            itemDecorator.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.divider));
            orderRecycler.addItemDecoration(itemDecorator);
            ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
            new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(orderRecycler);

            //CALCULATING FOR TOTAL OF ITEMS IN ORDER
            recalculatetotal(orderList, 1);

        } else {
            orderTotal.setText(res.getString(R.string.price_item, 0.00));
            no_order.setVisibility(View.VISIBLE);
        }


        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setHideable(true);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN: {
                        fab.setImageResource(R.drawable.up_chevron);
                    }
                    break;
                    case BottomSheetBehavior.STATE_EXPANDED: {

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
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    fab.setImageResource(R.drawable.down_chevron);
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                if (sheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    fab.setImageResource(R.drawable.up_chevron);
                    sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
                if (sheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    fab.setImageResource(R.drawable.down_chevron);
                }
            }
        });

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ////////////////////////////////////////////////
                if (orderList.size() > 0) {
                    for (int i = 0; i < orderList.size(); i++) {
                        OrderCart order = orderList.get(i);
                        if (order != null) {
                            String cost;
                            if (order.getOrderid().startsWith(AndroidUtils.COUPOUNORDERID)) {
                                cost = order.getSprice();
                            } else cost = order.getPrice();

                            if (order.getOrderid().startsWith(AndroidUtils.SERVICETRANSID)) {
                                transactionId = genID(AndroidUtils.SERVICETRANSID);
                            } else {
                                transactionId = genID(AndroidUtils.INPUTSALESID);
                            }
                            String iName = order.getInputName();
                            String quantity = order.getQuantity();
                            String category = order.getInputCategory();

//                            transactionId = genID();
                            iname.add(iName);
                            icat.add(category);
                            iquantity.add(quantity);
                            icost.add(cost);

                            orderCost.append(cost);
                            orderCost.append(",");

                            totalQuantity.append(quantity);
                            totalQuantity.append(",");

                            orderDetails.append(iName);
                            orderDetails.append(",");
                        }

                    }
                    totalQuantity.append("~");
                    orderDetails.append("~");
                    orderCost.append("~");
                    couponcode = "12345678";


                    if (subsidizedList.size() > 0) {
                        final MaterialDialog progDialog = new MaterialDialog.Builder(OrderActivity.this)
                                .content(R.string.please_wait)
                                .progress(true, 0)
                                .cancelable(false)
                                .build();
                        progDialog.show();

                        new Handler().postDelayed(() -> {
                            progDialog.dismiss();

                            tempTotal = 0.00;
                            totaled = 0.00;
                            for (OrderCart cart : subsidizedList) {
                                if (cart != null) {
                                    String amount = cart.getSprice();
                                    String quantity = cart.getQuantity();
                                    totaled = Double.parseDouble(amount) * Integer.parseInt(quantity);
                                    totaled += tempTotal;
                                    tempTotal = totaled;
                                }
                            }

                            final MaterialDialog progDialog12 = new MaterialDialog.Builder(OrderActivity.this)
                                    .title(R.string.please_wait)
                                    .content(R.string.almost_there)
                                    .progress(true, 0)
                                    .cancelable(false)
                                    .build();
                            progDialog12.show();

                            new Handler().postDelayed(() -> {
                                progDialog12.dismiss();
                                final MaterialDialog barterForm = new MaterialDialog.Builder(OrderActivity.this)
                                        .title(R.string.barter)
                                        .titleColor(getResources().getColor(R.color.grey_600))
                                        .autoDismiss(true)
                                        .customView(R.layout.custom_barter_agreement_form, true)
                                        .positiveText(R.string.agree)
                                        .onPositive((dialog12, which12) -> {

                                            payableamt = totaled;
                                            norecoverybags = Double.parseDouble(agreedItems.getText().toString().trim());
                                            paymentMethod = "Barter";
                                            subsidy = "subsidized";
                                            showBottomSheetDialog(paymentMethod);

                                        })
                                        .negativeText(R.string.negative)
                                        .show();

                                assert barterForm.getCustomView() != null;
                                agreedItems = barterForm.getCustomView().findViewById(R.id.custom_terms);
                                declaration = barterForm.getCustomView().findViewById(R.id.custom_declaration);

                                //TODO
                                //TODO
                                //TODO
                                //TODO
                                //TODO
                                if (recoverybagsperacre != null) {

                                    agreedItems.setText(String.valueOf(acreage * Integer.parseInt(recoverybagsperacre)));
                                }

                                if (!agreedItems.getText().toString().isEmpty() || !agreedItems.getText().toString().equals("0")) {
                                    declaration.setVisibility(View.VISIBLE);
                                    declaration.setText(String.format(res.getString(R.string.sms_declaration_alt), farmerInfo[0], agreedItems.getText().toString().trim(), totaled, String.valueOf(acreage)));
                                } else declaration.setVisibility(View.GONE);

                                agreedItems.addTextChangedListener(agreedItemsWatcher);
                            }, 1000);


                            final CouponAdapter adapter = new CouponAdapter(OrderActivity.this, R.array.subsidized, OrderActivity.this);

//                            methodDialog = new MaterialDialog.Builder(OrderActivity.this)
//                                    .title("Checkout for which items?")
//                                    .titleColor(getResources().getColor(R.color.grey_600))
//                                    .adapter(adapter, null)
//                                    .autoDismiss(true)
//                                    .backgroundColor(getResources().getColor(R.color.viewBg))
//                                    .build();
//                            methodDialog.show();
                        }, 1000);
                    } else {
                        subsidy = "non-subsidized";
                        final MaterialDialog progDialog = new MaterialDialog.Builder(OrderActivity.this)
                                .content(R.string.please_wait)
                                .progress(true, 0)
                                .cancelable(false)
                                .build();
                        progDialog.show();
                        payableamt = totaled;
                        new Handler().postDelayed(() -> {
                            progDialog.dismiss();
                            final PaymentStyleAdapter adapter = new PaymentStyleAdapter(OrderActivity.this, R.array.payment_style, OrderActivity.this);

                            styleDialog = new MaterialDialog.Builder(OrderActivity.this)
                                    .title(R.string.payment_style)
                                    .titleColor(getResources().getColor(R.color.grey_600))
                                    .adapter(adapter, null)
                                    .backgroundColor(getResources().getColor(R.color.viewBg))
                                    .build();
                            styleDialog.show();
                        }, 1000);
                    }

                } else
                    Toasty.error(getApplicationContext(), "No Pending OrderCart", Toast.LENGTH_SHORT).show();
            }
        });////////////END OF PROCEED TO CHECKOUT
        //////////////////////////////////////////////////

    }//END onCreate

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof OrderAdapter.MyViewHolder) {
            String name = orderList.get(viewHolder.getAdapterPosition()).getInputName();
            final OrderCart deletedItem = orderList.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();
            new MaterialDialog.Builder(OrderActivity.this)
                    .title(name)
                    .content("Do you want to remove item from cart?")
                    .titleColorRes(R.color.grey_600)
                    .backgroundColorRes(R.color.viewBg)
                    .positiveText("Yes")
                    .negativeText("No")
                    .cancelable(false)
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            boolean found = false;
                            adapter.removeItem(viewHolder.getAdapterPosition());

                            for (int i = 0; i < fullcostList.size(); i++) {
                                if (fullcostList.get(i) == deletedItem) {
                                    fullcostList.remove(i);
                                    found = true;
                                    break;
                                } else found = false;
                            }

                            if (!found) {
                                for (int i = 0; i < subsidizedList.size(); i++) {
                                    if (subsidizedList.get(i) == deletedItem) {
                                        subsidizedList.remove(i);
                                        break;
                                    }
                                }
                            }

                            recalculatetotal(orderList, 0);

                            deletedItem.delete();
                            orderTotal.setText(res.getString(R.string.price_item, totaled));
                            toggleEmptyRecord();
                            Snackbar snackbar = Snackbar.make(coordinatorLayout, name + " removed from cart!", Snackbar.LENGTH_LONG);
                            snackbar.setAction("UNDO", view -> {
                                adapter.restoreItem(deletedItem, deletedIndex);
                                deletedItem.save();

                                recalculatetotal(orderList, 0);
                                orderTotal.setText(res.getString(R.string.price_item, totaled));
                                toggleEmptyRecord();
                            });
                            snackbar.setActionTextColor(Color.rgb(57, 121, 107));
                            snackbar.show();
                        }
                    })
                    .show();

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }

    @Override
    public void onCouponClickListener(String coupon) {
        methodDialog.dismiss();
        tempTotal = 0.00;
        totaled = 0.00;
        subsidy = coupon;
        if (coupon.equalsIgnoreCase("subsidized")) {
            for (OrderCart cart : subsidizedList) {
                if (cart != null) {
                    String amount = cart.getSprice();
                    String quantity = cart.getQuantity();
                    totaled = Double.parseDouble(amount) * Integer.parseInt(quantity);
                    totaled += tempTotal;
                    tempTotal = totaled;
                }
            }

            final MaterialDialog progDialog12 = new MaterialDialog.Builder(OrderActivity.this)
                    .title(R.string.please_wait)
                    .content(R.string.almost_there)
                    .progress(true, 0)
                    .cancelable(false)
                    .build();
            progDialog12.show();

            new Handler().postDelayed(() -> {
                progDialog12.dismiss();
                final MaterialDialog barterForm = new MaterialDialog.Builder(OrderActivity.this)
                        .title(R.string.barter)
                        .titleColor(getResources().getColor(R.color.grey_600))
                        .autoDismiss(true)
                        .customView(R.layout.custom_barter_agreement_form, true)
                        .positiveText(R.string.agree)
                        .onPositive((dialog12, which12) -> {

                            payableamt = totaled;
                            norecoverybags = Double.parseDouble(agreedItems.getText().toString().trim());
                            paymentMethod = "Barter";

                            showBottomSheetDialog(paymentMethod);

                        })
                        .negativeText(R.string.negative)
                        .show();

                assert barterForm.getCustomView() != null;
                agreedItems = barterForm.getCustomView().findViewById(R.id.custom_terms);
                declaration = barterForm.getCustomView().findViewById(R.id.custom_declaration);
                agreedItems.setText(String.valueOf(acreage * 14));

                if (!agreedItems.getText().toString().isEmpty() || !agreedItems.getText().toString().equals("0")) {
                    declaration.setVisibility(View.VISIBLE);
                    declaration.setText(String.format(res.getString(R.string.sms_declaration_alt), farmerInfo[0], agreedItems.getText().toString().trim(), totaled, String.valueOf(acreage)));
                } else declaration.setVisibility(View.GONE);

                agreedItems.addTextChangedListener(agreedItemsWatcher);
            }, 1000);
        } else if (coupon.equalsIgnoreCase("non-subsidized")) {

            if (fullcostList.size() > 0) {
                for (OrderCart cart : fullcostList) {
                    if (cart != null) {
                        String amount = cart.getPrice();
                        String quantity = cart.getQuantity();
                        totaled = Double.parseDouble(amount) * Integer.parseInt(quantity);
                        totaled += tempTotal;
                        tempTotal = totaled;
                    }
                    payableamt = totaled;
                }

                final PaymentStyleAdapter adapter = new PaymentStyleAdapter(OrderActivity.this, R.array.payment_style, OrderActivity.this);

                styleDialog = new MaterialDialog.Builder(OrderActivity.this)
                        .title(R.string.payment_style)
                        .titleColorRes(R.color.grey_600)
                        .adapter(adapter, null)
                        .backgroundColorRes(R.color.viewBg)
                        .build();
                styleDialog.show();
            } else Toasty.error(getApplicationContext(), "No products available").show();
        }
    }

    @Override
    public void onItemClick(String paymentStyle) {
        styleDialog.dismiss();

        this.paymentStyle = paymentStyle;
        final MaterialDialog progDialog = new MaterialDialog.Builder(OrderActivity.this)
                .title(R.string.please_wait)
                .content(R.string.almost_there)
                .progress(true, 0)
                .cancelable(false)
                .build();
        progDialog.show();

        new Handler().postDelayed(() -> {
            progDialog.dismiss();
            final PaymentMethodAdapter adapter = new PaymentMethodAdapter(this, R.array.payment_method, this);

            methodDialog = new MaterialDialog.Builder(OrderActivity.this)
                    .title(R.string.payment_method)
                    .titleColor(getResources().getColor(R.color.grey_600))
                    .adapter(adapter, null)
                    .autoDismiss(true)
                    .backgroundColor(getResources().getColor(R.color.viewBg))
                    .build();
            methodDialog.show();
        }, 1000);

    }

    @Override
    public void onPaymentMethodClickListener(String paymentMethod) {
        methodDialog.dismiss();
        //CASH
        if (paymentMethod.equalsIgnoreCase("cash")) {
            afterCash(totaled, paymentMethod);
        }

        //MOBILE MONEY
        else if (paymentMethod.equalsIgnoreCase("mobile money")) {
            afterMobileMoney(paymentMethod);
        }

        //BARTER
        else if (paymentMethod.equalsIgnoreCase("barter")) {
            final MaterialDialog progDialog12 = new MaterialDialog.Builder(OrderActivity.this)
                    .title(R.string.please_wait)
                    .content(R.string.almost_there)
                    .progress(true, 0)
                    .cancelable(false)
                    .build();
            progDialog12.show();

            new Handler().postDelayed(() -> {
                progDialog12.dismiss();
                final MaterialDialog barterForm = new MaterialDialog.Builder(OrderActivity.this)
                        .title(R.string.barter)
                        .titleColor(getResources().getColor(R.color.grey_600))
                        .autoDismiss(true)
                        .customView(R.layout.custom_barter_agreement_form, true)
                        .positiveText(R.string.agree)
                        .onPositive((dialog12, which12) -> {

                            payableamt = totaled;
                            norecoverybags = Double.parseDouble(agreedItems.getText().toString().trim());
                            showBottomSheetDialog(paymentMethod);
                        })
                        .negativeText(R.string.negative)
                        .show();

                assert barterForm.getCustomView() != null;
                agreedItems = barterForm.getCustomView().findViewById(R.id.custom_terms);
                declaration = barterForm.getCustomView().findViewById(R.id.custom_declaration);
                agreedItems.setText(String.valueOf(acreage * 14));

                if (!agreedItems.getText().toString().isEmpty() || !agreedItems.getText().toString().equals("0")) {
                    declaration.setVisibility(View.VISIBLE);
                    declaration.setText(String.format(res.getString(R.string.sms_declaration_alt), farmerInfo[0], agreedItems.getText().toString().trim(), totaled, String.valueOf(acreage)));
                } else declaration.setVisibility(View.GONE);

                agreedItems.addTextChangedListener(agreedItemsWatcher);
            }, 1000);
        }
    }

    @Override
    public void onReviewClicklistener(String paymentMethod, String subsid) {
        final MaterialDialog progDialog12 = new MaterialDialog.Builder(OrderActivity.this)
                .title(R.string.please_wait)
                .content("Checking Out")
                .progress(true, 0)
                .cancelable(false)
                .build();
        progDialog12.show();
        //CASH

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progDialog12.dismiss();
                checkinventory();

                if (paymentMethod.equalsIgnoreCase("cash")) {
                    finalCheckoutProcessCASH("cash");
                }

                //MOBILE MONEY
                else if (paymentMethod.equalsIgnoreCase("mobile money")) {
                    finalCheckoutProcessMM("mobile money");
                }

                //BARTER
                else if (paymentMethod.equalsIgnoreCase("barter")) {
                    finalCheckoutProcessBarter("barter");

                } else if (paymentMethod.equalsIgnoreCase("close")) {
                    new MaterialDialog.Builder(OrderActivity.this)
                            .title("Cancel Order?")
                            .content("Do you want to cancel transaction?")
                            .titleColorRes(R.color.grey_600)
                            .positiveText("Yes")
                            .negativeText("No")
                            .positiveColorRes(R.color.teal_800)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    try {
                                        List<Sales> sales = Sales.find(Sales.class, "transactionid = ?", transactionId);

                                        for (Sales sales1 : sales) {
                                            sales1.delete();
                                            sales1.save();
                                        }
                                        List<Declaration> declarationList = Declaration.find(Declaration.class, "transactionid = ?", transactionId);

                                        for (Declaration declaration : declarationList) {
                                            declaration.delete();
                                            declaration.save();
                                        }

                                        List<Salestran> salestranList = Salestran.find(Salestran.class, "transactionid = ?", transactionId);

                                        for (Salestran salestran : salestranList) {
                                            salestran.delete();
                                            salestran.save();
                                        }

                                        resetCart(subsid);

                                        finish();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                }
                            })
                            .show();
                }
            }
        }, 1000);


    }

    private void checkinventory() {

        for (int i = 0; i < orderList.size(); i++) {
            List<ProductsFromDealer> fromDealer = ProductsFromDealer.find(ProductsFromDealer.class, "pid = ?", orderList.get(i).getPid());
            if (!fromDealer.isEmpty()) {
                ProductsFromDealer product = fromDealer.get(0);
                int left = Integer.parseInt(product.getQuantity()) - Integer.parseInt(orderList.get(i).getQuantity());
                product.quantity = String.valueOf(left);
            }
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        _year = year;
        _month = month;
        _day = dayOfMonth;
        updateDisplay();
    }

    //NON OVERRIDE METHODS
    ///////////////////////////////////////////////////////////////////////
    private void getIntentData() {
        Intent intent = getIntent();
        if (intent.getStringExtra(InputDistMainActivity.EXTRA_FARMER_ID) != null) {
            farmer_id = intent.getStringExtra(InputDistMainActivity.EXTRA_FARMER_ID);
        }
        if (intent.getStringExtra("recoverybagsperacre") != null) {
            recoverybagsperacre = intent.getStringExtra("recoverybagsperacre");
        }
        if (intent.getStringExtra("acreage") != null) {
            acreage = Integer.parseInt(intent.getStringExtra("acreage"));
        } else if (intent.getStringExtra("acreage") == null || intent.getStringExtra("acreage").equals("0")) {
            if (orderList.size() > 0) {
                for (OrderCart cart : orderList) {
                    if (cart.getOrderid().startsWith(AndroidUtils.COUPOUNORDERID)) {
                        if (cart.getInputName().toLowerCase().startsWith("lum")) {
                            acreage = Integer.parseInt(cart.getQuantity());
                            break;
                        } else if (cart.getOrderid().startsWith(AndroidUtils.SERVICETRANSID)) {
                            acreage = Integer.parseInt(cart.getQuantity());
                        }
                    }
                }
            }
        }
    }

    public void showBottomSheetDialog(String paymentMethod) {
        if (!paymentMethod.equalsIgnoreCase("barter")) {

            ReviewOrderDialogFragment.newInstance(fullcostList, "***", paymentMethod, String.valueOf(totaled), OrderActivity.this, subsidy).show(getSupportFragmentManager(), "dialog");

        } else {
            if (subsidy.equalsIgnoreCase("non-subsidized")) {
                ReviewOrderDialogFragment.newInstance(fullcostList, declaration.getText().toString(), paymentMethod, String.valueOf(totaled), OrderActivity.this, subsidy).show(getSupportFragmentManager(), "dialog");

            } else if (subsidy.equalsIgnoreCase("subsidized")) {

                ReviewOrderDialogFragment.newInstance(subsidizedList, declaration.getText().toString(), paymentMethod, String.valueOf(totaled), OrderActivity.this, subsidy).show(getSupportFragmentManager(), "dialog");
            }
        }
    }

    private void setSales(String pid, String iName, int quantity, double cost, String category, String synctatus) {
        double totalcost = cost * quantity;

        AndroidUtils.insertSales(
                farmer_id,
                transactionId,
                pid,
                iName,
                category,
                cost,
                quantity,
                totalcost,
                synctatus,
                AndroidUtils.getPreferenceData(OrderActivity.this, AndroidUtils.AGENTID, ""),
                new Date(),
                new Date(),
                AndroidUtils.getUUID(),
                new Date(),
                AndroidUtils.getMacAddress(OrderActivity.this),
                AndroidUtils.getIMEI(OrderActivity.this),
                agentname,
                agentid
        );
    }

    private String formatedItems(StringBuilder orderDetails, StringBuilder totalQuantity) {

        StringBuilder newOrderDetails = new StringBuilder();
        String itemsPurchased = orderDetails.toString();
        String quantity = totalQuantity.toString();

        if (!itemsPurchased.isEmpty()) {
            if (itemsPurchased.contains(",")) {
                String[] partsItems = itemsPurchased.split(",");
                String[] partsQuantity = quantity.split(",");

                for (int i = 0; i < partsItems.length; i++) {
                    if (!partsItems[i].contains("~")) {
                        String temp = res.getString(R.string.actual_order_detail, partsItems[i], partsQuantity[i]);
                        newOrderDetails.append(temp);
                        newOrderDetails.append(",");
                    }
                }
            } else {
                if (!itemsPurchased.contains("~")) {
                    String temp = res.getString(R.string.actual_order_detail, itemsPurchased, quantity);
                    newOrderDetails.append(temp);
                } else {
                    String[] partsItems = itemsPurchased.split("~");
                    String[] partsQuantity = quantity.split("~");
                    String temp = res.getString(R.string.actual_order_detail, partsItems[0], partsQuantity[0]);
                    newOrderDetails.append(temp);
                }
            }
        }

        String temp = newOrderDetails.toString();
        if (newOrderDetails.charAt(newOrderDetails.length() - 1) == ',') {
            temp = newOrderDetails.toString().substring(0, newOrderDetails.length() - 1);
        }
        return temp;
    }

    public String genID(String indicator) {
        return indicator + AndroidUtils.getIMEI(OrderActivity.this) + AndroidUtils.dateToFormattedString(new Date(), "yyyyMMddHHmmss");
    }

    public void uploadDistributionToServer() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
                //some logic logic logic
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {

                    prepareUploadfiles();

                    AndroidUtils.uploadFileToServer(OrderActivity.this);

                    for (OrderCart cart : orderList) {
                        List<ProductsFromDealer> fromDealer = ProductsFromDealer.find(ProductsFromDealer.class, "pid = ?", cart.getPid());
                        if (fromDealer.size() > 0) {
                            ProductsFromDealer product = fromDealer.get(0);
                            int left = Integer.parseInt(product.getQuantity()) - Integer.parseInt(cart.getQuantity());

                            product.quantity = String.valueOf(left);
                            product.save();
                            return true;
                        }
                    }

                    outcome = true;
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {
                //some logic logic logic
                if (outcome) {
                    resetCart(subsidy);
                    if (orderList.size() > 0) {
                        recalculatetotal(orderList, 1);
                        adapter.notifyDataSetChanged();
                    } else {
                        finish();
                    }
                    Toasty.success(getApplicationContext(), "Transaction Successful", Toast.LENGTH_SHORT).show();
                }
            }
        };
        asyncTask.execute();
    }

    private void recalculatetotal(List<OrderCart> orderList, int type) {
        tempTotal = 0.0;
        totaled = 0.0;
        markettotal = 0.0;
        for (int i = 0; i < orderList.size(); i++) {
            OrderCart order = orderList.get(i);
            if (order != null) {
                String amount;
                if (order.getOrderid().startsWith(AndroidUtils.COUPOUNORDERID)) {
                    amount = order.getSprice();
                    if (type == 1)
                        subsidizedList.add(order);
                } else {
                    amount = order.getPrice();
                    if (type == 1)
                        fullcostList.add(order);
                }

                String quantity = order.getQuantity();
                totaled = Double.parseDouble(amount) * Integer.parseInt(quantity);
                totaled += tempTotal;
                tempTotal = totaled;
                markettotal += Double.parseDouble(order.getPrice()) * Integer.parseInt(quantity);
            }
        }
        orderTotal.setText(res.getString(R.string.price_item, totaled));
    }

    private void prepareUploadfiles() {
        String jsonstring, uploadId, uploadfilepath;
        ServerTransfer transfer = new ServerTransfer();

        List<Salestran> salestransList = Salestran.find(Salestran.class, "transactionid = ?", transactionId);
        if (salestransList.size() > 0) {

            for (Salestran salestran : salestransList) {
                if (salestran != null) {
                    transfer = new ServerTransfer();
                    transfer.setSalestran(salestran);
                    jsonstring = new Gson().toJson(transfer);
                    uploadId = AndroidUtils.getUUID();
                    uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
                }

            }
        }

        List<Declaration> declarationsList = Declaration.find(Declaration.class, "transactionid = ?", transactionId);

        if (declarationsList.size() > 0) {
            for (Declaration declaration : declarationsList) {

                if (declaration != null) {
                    transfer = new ServerTransfer();
                    transfer.setDeclaration(declaration);
                    jsonstring = new Gson().toJson(transfer);
                    uploadId = AndroidUtils.getUUID();
                    uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
                }
            }

        }

        List<Sales> salesList = Sales.find(Sales.class, "transactionid = ?", transactionId);

        if (salesList.size() > 0) {
            for (Sales sales : salesList) {

                if (sales != null) {
                    transfer = new ServerTransfer();
                    transfer.setSales(sales);
                    jsonstring = new Gson().toJson(transfer);
                    uploadId = AndroidUtils.getUUID();
                    uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
                }
            }
        }
    }

    private void setUpToolbar() {
        int primary = getResources().getColor(R.color.colorPrimaryDark);
        int secondary = getResources().getColor(R.color.grey_300);
        SlidrConfig mConfig = new SlidrConfig.Builder()
                .primaryColor(primary)
                .secondaryColor(secondary)
                .position(SlidrPosition.LEFT)
                .velocityThreshold(2400)
                .build();
        Slidr.attach(this, mConfig);

        setSupportActionBar(mToolbar);
        TextView mTitle = mToolbar.findViewById(R.id.toolbar_title);
        getSupportActionBar().setTitle("");
        mTitle.setText(R.string.my_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void toggleEmptyRecord() {
        if (AndroidUtils.getOrderCount() != 0) {
            no_order.setVisibility(View.GONE);
        } else {
            no_order.setVisibility(View.VISIBLE);
        }
    }

    public void resetCart(String subsid) {
        final int size = orderList.size();

        if (subsid.equalsIgnoreCase("subsidized")) {
            if (size > 0) {
                for (OrderCart cart : subsidizedList) {
                    OrderCart cart1 = OrderCart.findById(OrderCart.class, cart.getId());
                    if (cart.getOrderid().startsWith(AndroidUtils.COUPOUNORDERID)) {
                        cart1.delete();
                        orderList.remove(cart);
                    }
                }
                subsidizedList.clear();
                adapter.notifyItemRangeChanged(0, AndroidUtils.getOrderCount());
            }
        } else if (subsid.equalsIgnoreCase("non-subsidized")) {
            if (size > 0) {
                for (OrderCart cart : fullcostList) {
                    OrderCart cart1 = OrderCart.findById(OrderCart.class, cart.getId());
                    cart1.delete();
                    orderList.remove(cart);

                }
                fullcostList.clear();
                adapter.notifyItemRangeChanged(0, AndroidUtils.getOrderCount());
            }
        }

        orderTotal.setText(res.getString(R.string.price_item, 0.00));
        toggleEmptyRecord();
    }

    private void updateDisplay() {
        agreedDate.setText(new StringBuilder()
                .append(_day).append("/").append(_month + 1).append("/").append(_year).append(" "));
    }

    @SuppressLint("InvalidWakeLockTag")
    private void afterMobileMoney(String paymentMethod) {

        this.paymentMethod = paymentMethod;
        methodDialog = new MaterialDialog.Builder(OrderActivity.this)
                .title(R.string.please_wait)
                .content(R.string.waiting)
                .progress(true, 0)
                .cancelable(false)
                .build();
        methodDialog.show();
        messageReceived();
    }

    private void messageReceived() {
        smsBroadcastReceiver.setListener((text, senderaddress) -> {

            int start = 0, end = 1;
            StringBuilder originatorName = new StringBuilder();
            String[] mobileMoneyMsg = text.split(" ");
            for (int i = 0; i < mobileMoneyMsg.length; i++) {

                if (mobileMoneyMsg[i + 1].toLowerCase().equals("from") && Pattern.matches(AndroidUtils.fpRegex, mobileMoneyMsg[i])) {

                    mobileMoney = Double.parseDouble(mobileMoneyMsg[i]);
                    start = i + 2;
                    break;
                }
            }

            for (int i = 0; i < mobileMoneyMsg.length; i++) {
                if (mobileMoneyMsg[i].toLowerCase().equals("id:")) {
                    mmTransactionID = mobileMoneyMsg[i + 1];

                }
            }

            for (int i = 0; i < mobileMoneyMsg.length; i++) {
                if (mobileMoneyMsg[i].toLowerCase().trim().contains("current")) {
                    end = i;
                    break;
                }
            }

            for (int i = start; i < end; i++) {
                originatorName.append(mobileMoneyMsg[i]).append(" ");
            }


            new MaterialDialog.Builder(OrderActivity.this)
                    .title(R.string.mobile_money)
                    .content(res.getString(R.string.mm, String.valueOf(mobileMoney), originatorName.toString(), mmTransactionID))
                    .positiveText("ok")
                    .cancelable(false)
                    .show();

            showBottomSheetDialog(paymentMethod);

            methodDialog.dismiss();
        });
    }

    private void afterCash(double totaled, String paymentMethod) {
        String content = res.getString(R.string.enter_amount, totaled);
        if (paymentStyle.equalsIgnoreCase("postpaid")) {
            new MaterialDialog.Builder(OrderActivity.this)
                    .title(R.string.payment)
                    .content(content)
                    .theme(Theme.LIGHT)
                    .positiveColorRes(R.color.text_color)
                    .inputType(InputType.TYPE_NUMBER_FLAG_DECIMAL)
                    .input("Amount", null, false, new MaterialDialog.InputCallback() {
                        @Override
                        public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                            // Do something
                            String val = input.toString().trim();
                            if (!val.equals("0")) {
                                val = res.getString(R.string.price, Double.parseDouble(val));
                                String totaltemp = res.getString(R.string.price, totaled);
                                if (val.equals(totaltemp)) {

                                    tendered = Double.parseDouble(val);

                                    showBottomSheetDialog(paymentMethod);

                                } else {
                                    new MaterialDialog.Builder(OrderActivity.this)
                                            .title(R.string.payment)
                                            .content(R.string.snuffoo)
                                            .theme(Theme.LIGHT)
                                            .positiveText("OK")
                                            .negativeText("CANCEL")
                                            .positiveColorRes(R.color.secondary_light)
                                            .negativeColorRes(R.color.grey_600)
                                            .cancelable(false)
                                            .show();
                                }
                            } else
                                Toasty.error(getApplicationContext(), "Invalid input").show();
                        }
                    }).show();
        } else {
            new MaterialDialog.Builder(OrderActivity.this)
                    .title(R.string.payment)
                    .content(content)
                    .theme(Theme.LIGHT)
                    .positiveColorRes(R.color.text_color)
                    .inputType(InputType.TYPE_NUMBER_FLAG_DECIMAL)
                    .input("Amount", null, false, new MaterialDialog.InputCallback() {
                        @Override
                        public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                            // Do something
                            String val = input.toString().trim();
                            if (!val.equals("0")) {
                                val = res.getString(R.string.price, Double.parseDouble(val));

                                tendered = Double.parseDouble(val);
                            } else
                                Toasty.error(getApplicationContext(), "Invalid input").show();
                        }
                    }).show();
        }

    }

    private void finalCheckoutProcessMM(String paymentMethod) {
        if (markettotal > payableamt) {
            appliedsub = markettotal - payableamt;
        } else appliedsub = 0.00;

        couponcode = "non-subsidized";

        payableamt = AndroidUtils.doubleto2places(res, payableamt);
        tendered = AndroidUtils.doubleto2places(res, tendered);
        norecoverybags = AndroidUtils.doubleto2places(res, norecoverybags);
        appliedsub = AndroidUtils.doubleto2places(res, appliedsub);

        if (subsidy.equalsIgnoreCase("subsidized")) {
            for (OrderCart cart : subsidizedList) {
                setSales(cart.getPid(), cart.getInputName(), Integer.parseInt(cart.getQuantity()), Double.parseDouble(cart.getSprice()), cart.getInputCategory(), "1");
            }
        } else if (subsidy.equalsIgnoreCase("non-subsidized")) {
            for (OrderCart cart : fullcostList) {
                setSales(cart.getPid(), cart.getInputName(), Integer.parseInt(cart.getQuantity()), Double.parseDouble(cart.getPrice()), cart.getInputCategory(), "1");
            }
        }

        AndroidUtils.sendMessage(this,
                farmerInfo[5],
                res.getString(
                        R.string.sms_trans,
                        farmerInfo[0],
                        totaled,
                        formatedItems(orderDetails, totalQuantity),
                        paymentMethod,
                        transactionId)
        );

        AndroidUtils.insertSalesTran(
                farmer_id,
                transactionId,
                markettotal,
                couponcode,
                appliedsub,
                payableamt,
                paymentMethod,
                tendered,
                norecoverybags,
                "1",
                farmerInfo[4],
                farmerInfo[3],
                farmerInfo[2],
                "0",
                new Date(),
                new Date(),
                AndroidUtils.getUUID(),
                new Date(),
                AndroidUtils.getMacAddress(OrderActivity.this),
                AndroidUtils.getIMEI(OrderActivity.this),
                agentname,
                agentid
        );


        uploadDistributionToServer();
    }

    private void finalCheckoutProcessCASH(String paymentMethod) {
        if (markettotal > payableamt) {
            appliedsub = markettotal - payableamt;
        } else appliedsub = 0.00;

        couponcode = "non-subsidized";

        payableamt = AndroidUtils.doubleto2places(res, payableamt);
        totaled = AndroidUtils.doubleto2places(res, totaled);
        tendered = AndroidUtils.doubleto2places(res, tendered);
        norecoverybags = AndroidUtils.doubleto2places(res, norecoverybags);
        appliedsub = AndroidUtils.doubleto2places(res, appliedsub);

        if (subsidy.equalsIgnoreCase("subsidized")) {
            for (OrderCart cart : subsidizedList) {
                setSales(cart.getPid(), cart.getInputName(), Integer.parseInt(cart.getQuantity()), Double.parseDouble(cart.getSprice()), cart.getInputCategory(), "1");
            }
        } else if (subsidy.equalsIgnoreCase("non-subsidized")) {
            for (OrderCart cart : fullcostList) {
                setSales(cart.getPid(), cart.getInputName(), Integer.parseInt(cart.getQuantity()), Double.parseDouble(cart.getPrice()), cart.getInputCategory(), "1");
            }
        }

        AndroidUtils.sendMessage(this,
                farmerInfo[5],
                res.getString(
                        R.string.sms_trans,
                        farmerInfo[0],
                        totaled,
                        formatedItems(orderDetails, totalQuantity),
                        paymentMethod,
                        transactionId)
        );

        AndroidUtils.insertSalesTran(
                farmer_id,
                transactionId,
                markettotal,
                couponcode,
                appliedsub,
                payableamt,
                paymentMethod,
                tendered,
                norecoverybags,
                "1",
                farmerInfo[4],
                farmerInfo[3],
                farmerInfo[2],
                "0",
                new Date(),
                new Date(),
                AndroidUtils.getUUID(),
                new Date(),
                AndroidUtils.getMacAddress(OrderActivity.this),
                AndroidUtils.getIMEI(OrderActivity.this),
                agentname,
                agentid
        );

        if (paymentStyle.equalsIgnoreCase("credit")) {
            status = "owing";
            AndroidUtils.insertDeclaration(
                    farmer_id,
                    transactionId,
                    markettotal,
                    couponcode,
                    appliedsub,
                    tendered,
                    paymentMethod,
                    "declaration",
                    status,
                    farmerInfo[4],
                    farmerInfo[3],
                    farmerInfo[2],
                    String.valueOf(acreage),
                    new Date(),
                    new Date(),
                    AndroidUtils.getUUID(),
                    new Date(),
                    AndroidUtils.getMacAddress(OrderActivity.this),
                    AndroidUtils.getIMEI(OrderActivity.this),
                    agentname,
                    agentid
            );
        }

        uploadDistributionToServer();
    }

    private void finalCheckoutProcessBarter(String paymentMethod) {
        if (markettotal > payableamt) {
            appliedsub = markettotal - payableamt;
        } else appliedsub = 0.00;

        if (subsidy.equalsIgnoreCase("subsidized")) {
            for (OrderCart cart : subsidizedList) {
                setSales(cart.getPid(), cart.getInputName(), Integer.parseInt(cart.getQuantity()), Double.parseDouble(cart.getSprice()), cart.getInputCategory(), "0");
            }
        } else if (subsidy.equalsIgnoreCase("non-subsidized")) {
            for (OrderCart cart : fullcostList) {
                setSales(cart.getPid(), cart.getInputName(), Integer.parseInt(cart.getQuantity()), Double.parseDouble(cart.getPrice()), cart.getInputCategory(), "0");
            }
        }

        couponcode = "subsidized";

//        AndroidUtils.sendMessage(this,
//                farmerInfo[5],
//                res.getString(
//                        R.string.sms_transaction_credit,
//                        farmerInfo[0],
//                        totaled,
//                        formatedItems(orderDetails, totalQuantity),
//                        transactionId));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AndroidUtils.sendMessage(OrderActivity.this,
                        farmerInfo[5],
                        declaration.getText().toString()
                );
            }
        }, 1500);

        payableamt = AndroidUtils.doubleto2places(res, totaled);
        totaled = AndroidUtils.doubleto2places(res, totaled);
        norecoverybags = AndroidUtils.doubleto2places(res, norecoverybags);
        tendered = AndroidUtils.doubleto2places(res, 0.00);
        appliedsub = AndroidUtils.doubleto2places(res, appliedsub);
        if (subsidy.equalsIgnoreCase("subsidized")) {
            markettotal = totaled;
        }
        AndroidUtils.insertSalesTran(
                farmer_id,
                transactionId,
                markettotal,
                couponcode,
                appliedsub,
                payableamt,
                paymentMethod,
                tendered,
                norecoverybags,
                "0",
                farmerInfo[4],
                farmerInfo[3],
                farmerInfo[2],
                String.valueOf(acreage),
                new Date(),
                new Date(),
                AndroidUtils.getUUID(),
                new Date(),
                AndroidUtils.getMacAddress(OrderActivity.this),
                AndroidUtils.getIMEI(OrderActivity.this),
                agentname,
                agentid
        );

        AndroidUtils.insertDeclaration(
                farmer_id,
                transactionId,
                markettotal,
                couponcode,
                appliedsub,
                norecoverybags,
                paymentMethod,
                declaration.getText().toString().trim(),
                status,
                farmerInfo[4],
                farmerInfo[3],
                farmerInfo[2],
                String.valueOf(acreage),
                new Date(),
                new Date(),
                AndroidUtils.getUUID(),
                new Date(),
                AndroidUtils.getMacAddress(OrderActivity.this),
                AndroidUtils.getIMEI(OrderActivity.this),
                agentname,
                agentid
        );

        uploadDistributionToServer();
    }


}
