package com.telpo.usb.finger.inputdistributions_fragment;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.OrderCart;
import com.telpo.usb.finger.interfaces.ReviewClicklistener;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.List;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class ReviewOrderDialogFragment extends BottomSheetDialogFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    // TODO: Customize parameter argument names
    static List<OrderCart> list;
    private static ReviewClicklistener clicklistener;
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;

    // TODO: Customize parameters
    public static ReviewOrderDialogFragment newInstance(List<OrderCart> cart, String declaration, String paymentMethod, String total, ReviewClicklistener listener, String sub) {
        final ReviewOrderDialogFragment fragment = new ReviewOrderDialogFragment();
        list = cart;
        clicklistener = listener;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, declaration);
        args.putString(ARG_PARAM2, total);
        args.putString(ARG_PARAM3, paymentMethod);
        args.putString(ARG_PARAM4, sub);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getTheme() {
        return R.style.BaseBottomSheetDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = view.findViewById(R.id.list);

        TextView dec = view.findViewById(R.id.declaration);
        TextView total = view.findViewById(R.id.total);
        Button proceed = view.findViewById(R.id.proceed_btn);
        ImageView close = view.findViewById(R.id.close);

        close.setOnClickListener(v -> {

            clicklistener.onReviewClicklistener("close", mParam4);
            getDialog().dismiss();
        });

        proceed.setOnClickListener(v -> {
            clicklistener.onReviewClicklistener(mParam3, mParam4);
            getDialog().dismiss();
        });
        if (mParam1.contains("*")) {
            dec.setVisibility(View.GONE);
        } else {
            dec.setVisibility(View.VISIBLE);
            dec.setText(mParam1);
        }
        total.setText(mParam2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ItemAdapter(list));
    }


    private class ViewHolder extends RecyclerView.ViewHolder {

        final TextView ordername;
        final TextView quantity;
        final TextView orderamount;
        final TextView unitm;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.fragment_item_list_dialog_item, parent, false));
            ordername = itemView.findViewById(R.id.order_name);
            quantity = itemView.findViewById(R.id.quantity);
            orderamount = itemView.findViewById(R.id.order_amount);
            unitm = itemView.findViewById(R.id.unitm);
        }

    }

    private class ItemAdapter extends RecyclerView.Adapter<ViewHolder> {

        List<OrderCart> carts;
//        private final int mItemCount;

        ItemAdapter(List<OrderCart> itemCount) {
//            mItemCount = itemCount;
            carts = itemCount;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final OrderCart order = carts.get(position);
            Resources res = holder.itemView.getResources();
            String orderName = order.getInputName();
            String quantity = order.getQuantity();
            String category = order.getInputCategory();

            holder.ordername.setText(orderName);
            holder.quantity.setText(quantity);

            String amount;
            if (order.getOrderid().startsWith(AndroidUtils.COUPOUNORDERID)) {
                amount = order.getSprice();

            } else amount = order.getPrice();

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
            }

            holder.orderamount.setText(res.getString(R.string.price_item, Double.parseDouble(amount)));
        }

        @Override
        public int getItemCount() {
            return carts.size();
        }

    }
}
