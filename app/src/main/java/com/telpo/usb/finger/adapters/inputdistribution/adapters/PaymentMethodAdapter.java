package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.ArrayRes;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.interfaces.PaymentMethodClickListener;

/**
 * Simple adapter example for custom items in the dialog
 */
public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.ButtonVH> {

    private final CharSequence[] items;
    private Context mContext;
    private PaymentMethodClickListener paymentMethodClickListener;

    public PaymentMethodAdapter(Context context, @ArrayRes int arrayResId, PaymentMethodClickListener paymentMethodClickListener) {
        this(context.getResources().getTextArray(arrayResId));
        this.mContext = context;
        this.paymentMethodClickListener = paymentMethodClickListener;
    }

    public PaymentMethodAdapter(CharSequence[] items) {
        this.items = items;
    }


    @Override
    public ButtonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.dialog_customlistitem, parent, false);
        return new ButtonVH(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ButtonVH holder, int position) {
        holder.title.setText(items[position]);
        holder.card.setOnClickListener(view -> paymentMethodClickListener.onPaymentMethodClickListener(items[position].toString()));
    }

    @Override
    public int getItemCount() {
        return items.length;
    }


    public static class ButtonVH extends RecyclerView.ViewHolder {

        final TextView title;
        final CardView card;

        ButtonVH(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.md_title);
            card = itemView.findViewById(R.id.card);
        }

    }
}
