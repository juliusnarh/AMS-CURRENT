package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.ProductsFromDealer;

import java.util.List;

public class ProdFromDealerAdapter extends RecyclerView.Adapter<ProdFromDealerAdapter.MyViewHolder> {
    private Context mContext;
    private List<ProductsFromDealer> fromDealerList;

    public ProdFromDealerAdapter(Context mContext, List<ProductsFromDealer> fromDealerList) {
        this.mContext = mContext;
        this.fromDealerList = fromDealerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Resources resources = holder.itemView.getContext().getResources();
        ProductsFromDealer inventory = fromDealerList.get(position);
        holder.item_name.setText(inventory.getPname());
        if (inventory.getPdesc() == null)
            holder.item_desc.setVisibility(View.GONE);
        else
            holder.item_desc.setText(inventory.getPdesc());

        holder.item_price.setText(resources.getString(R.string.pricealt, inventory.getSubprice(), inventory.getQuantity()));

        holder.item_aid.setText(inventory.getSupplier());
        Glide.with(mContext).load(inventory.getItem_img()).transition(DrawableTransitionOptions.withCrossFade()).into(holder.item_img);
    }

    @Override
    public int getItemCount() {
        return fromDealerList.size();
    }

    public void additems() {
//        fromDealerList.addAll(newlist);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView item_name, item_desc, item_aid, item_price;
        public ImageView item_img;

        public MyViewHolder(View view) {
            super(view);
            item_name = view.findViewById(R.id.item_name);
            item_desc = view.findViewById(R.id.item_desc);
            item_aid = view.findViewById(R.id.item_aid);
            item_price = view.findViewById(R.id.item_price);
            item_img = view.findViewById(R.id.item_img);
        }
    }
}
