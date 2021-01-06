package com.telpo.usb.finger.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.telpo.usb.finger.R;

/**
 * Simple adapter example for custom items in the dialog
 */
public class PackageSelectAdapter extends RecyclerView.Adapter<PackageSelectAdapter.ButtonVH> {

    private final CharSequence[] items;
    private Context mContext;
    private PackageSelectClickListener listener;
    public PackageSelectAdapter(Context context, CharSequence[] items, PackageSelectClickListener listener) {
        this.items = items;
        this.mContext = context;
        this.listener = listener;
    }

    public PackageSelectAdapter(CharSequence[] items) {
        this.items = items;
    }


    @Override
    public ButtonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customlist, parent, false);
        return new ButtonVH(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ButtonVH holder, int position) {
        holder.title.setText(items[position]);
        holder.card.setOnClickListener(view -> listener.onPackageSelectClickListener(items[position].toString()));
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

    public interface PackageSelectClickListener {
        void onPackageSelectClickListener(String selpackages);
    }
}
