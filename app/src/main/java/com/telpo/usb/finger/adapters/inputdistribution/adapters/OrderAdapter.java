package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.bumptech.glide.Glide;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.input.distribution.OrderActivity;
import com.telpo.usb.finger.entities.OrderCart;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;
import com.transitionseverywhere.extra.Scale;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    Resources res;
    OrderActivity activity;
    private Context mContext;
    private List<OrderCart> orderList;
    private TextView totaled;

    public OrderAdapter(Context mContext, List<OrderCart> orderList, TextView totaled, AppCompatActivity activity) {
        this.mContext = mContext;
        this.orderList = orderList;
        this.totaled = totaled;
        if (activity instanceof OrderActivity) {
            this.activity = (OrderActivity) activity;
        }
    }

    @NonNull
    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new OrderAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderAdapter.MyViewHolder holder, final int position) {
        res = holder.itemView.getContext().getResources();
        final OrderCart order = orderList.get(position);
        String amount;
        if (order.getOrderid().startsWith(AndroidUtils.COUPOUNORDERID)) {
            amount = order.getSprice();

        } else amount = order.getPrice();

        String orderName = order.getInputName();
        String quantity = order.getQuantity();
        String category = order.getInputCategory();
        byte[] orderImgByte = order.getInputImg();
        Glide.with(mContext).load(orderImgByte).into(holder.orderImg);


        if (orderName.toLowerCase().contains("lum") || orderName.toLowerCase().contains("land") || orderName.toLowerCase().contains("glyp")) {
            holder.ordername.setText(orderName);
            holder.quantity.setText(res.getString(R.string.xquantity, quantity));
            holder.unitm.setText("(1l)");
        } else if (orderName.toLowerCase().contains("bel")) {
            holder.ordername.setText(orderName);
            holder.quantity.setText(res.getString(R.string.xquantity, quantity));
            holder.unitm.setText("(100ml)");
        } else if (category.toLowerCase().contains("fertilizer")) {
            holder.ordername.setText(orderName);
            holder.quantity.setText(res.getString(R.string.xquantity, quantity));
            holder.unitm.setText("(50kg)");
        } else if (category.toLowerCase().contains("seed")) {
            holder.ordername.setText(orderName);
            holder.quantity.setText(res.getString(R.string.xquantity, quantity));
            holder.unitm.setText("(10kg)");
        } else {
            holder.ordername.setText(orderName);
            holder.quantity.setText(res.getString(R.string.xquantity, quantity));
        }

        holder.order_amount.setText(res.getString(R.string.price_item, Double.parseDouble(amount)));

        holder.orderCategory.setText(category.toUpperCase());

        holder.editBtn.setOnClickListener(view -> {
            new MaterialDialog.Builder(mContext)
                    .title(R.string.edit_quantity)
                    .content("Please enter quantity")
                    .theme(Theme.LIGHT)
                    .widgetColorRes(R.color.secondary_light)
                    .positiveColorRes(R.color.secondary_light)
                    .inputType(InputType.TYPE_CLASS_NUMBER)
                    .input("new quantity", null, new MaterialDialog.InputCallback() {
                        @Override
                        public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                            String nquantity = input.toString().trim();
                            if (!nquantity.isEmpty()) {
                                if (!nquantity.equals("0")) {
                                    final MaterialDialog progDialog = new MaterialDialog.Builder(mContext)
                                            .title(R.string.please_wait)
                                            .content(R.string.update_order)
                                            .progress(true, 0)
                                            .cancelable(false)
                                            .build();
                                    progDialog.show();

                                    new Handler().postDelayed(() -> {
                                        boolean result = updateOrder(
                                                nquantity,
                                                position
                                        );

                                        progDialog.dismiss();
                                    }, 1000);

                                } else Toasty.error(mContext, "invalid input").show();
                            } else Toasty.error(mContext, "invalid input").show();
                        }
                    }).
                    show();
        });

        holder.innerContainer.setOnClickListener(new View.OnClickListener() {
            boolean visible;

            @Override
            public void onClick(View view) {

                TransitionSet set = new TransitionSet()
                        .addTransition(new Scale(0.7f))
                        .addTransition(new Fade())
                        .setInterpolator(visible ? new LinearOutSlowInInterpolator() :
                                new FastOutLinearInInterpolator());

                TransitionManager.beginDelayedTransition(holder.linearViewGroup, set);
                visible = !visible;
                holder.buttonLayout.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    private boolean updateOrder(String quantity, int position) {
        OrderCart order = orderList.get(position);

        order.quantity = quantity;
        order.save();
        orderList.set(position, order);
        notifyItemChanged(position);

        Double total = 0.0, tempTotal = 0.0;
        for (int i = 0; i < orderList.size(); i++) {
            order = orderList.get(i);
            if (order != null) {
                String amount;
                if (order.getOrderid().startsWith(AndroidUtils.COUPOUNORDERID)) {
                    amount = order.getSprice();

                } else amount = order.getPrice();

                String squantity = order.getQuantity();
                total = Double.parseDouble(amount) * Integer.parseInt(squantity);
                total += tempTotal;
                tempTotal = total;
            }
        }

        totaled.setText(res.getString(R.string.price_item, total));
        activity.totaled = total;
        return true;
    }

    public void removeItem(int position) {
        orderList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(OrderCart order, int position) {
        orderList.add(position, order);
        notifyItemInserted(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout innerContainer, viewBackground;
        TextView quantity, unitm, ordername, orderCategory, order_amount;
        LinearLayout buttonLayout;
        ImageView orderImg;
        Button editBtn;
        ViewGroup linearViewGroup;

        public MyViewHolder(View view) {
            super(view);
            orderImg = view.findViewById(R.id.order_img);
            ordername = view.findViewById(R.id.order_item_et_quantity);
            quantity = view.findViewById(R.id.quantity);
            unitm = view.findViewById(R.id.unitm);
            orderCategory = view.findViewById(R.id.order_category);
            order_amount = view.findViewById(R.id.order_amount);
            buttonLayout = view.findViewById(R.id.button_layout);
            editBtn = view.findViewById(R.id.order_change_btn);
            linearViewGroup = view.findViewById(R.id.card_view_animator);
            innerContainer = view.findViewById(R.id.inner_order_container);
            viewBackground = view.findViewById(R.id.view_background);
        }
    }
}
