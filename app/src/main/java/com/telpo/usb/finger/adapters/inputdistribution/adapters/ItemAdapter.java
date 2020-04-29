package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Products;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> implements Filterable {
    private Context mContext;
    private List<Products> inventoryList;
    private List<Products> inventoryListFiltered;

    public ItemAdapter(Context mContext, List<Products> inventoryList) {
        this.mContext = mContext;
        this.inventoryList = inventoryList;
        this.inventoryListFiltered = inventoryList;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    inventoryListFiltered = inventoryList;
                } else {
                    List<Products> filteredList = new ArrayList<>();
                    for (Products row : inventoryList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (
                                row.getPname().toLowerCase().contains(charString.toLowerCase()) ||
                                        row.getCategory().toLowerCase().contains(charString.toLowerCase()) ||
                                        row.getPid().toLowerCase().contains(charString.toLowerCase()) ||
                                        row.getSupplier().toLowerCase().contains(charString.toLowerCase()) ||
                                        row.getPdesc().toLowerCase().contains(charString.toLowerCase()) ||
                                        row.getSubprice().toLowerCase().contains(charString.toLowerCase())
                        ) {
                            filteredList.add(row);
                        }
                    }

                    inventoryListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = inventoryListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                inventoryListFiltered = (ArrayList<Products>) filterResults.values;
                notifyDataSetChanged();
            }
        };
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
        Products inventory = inventoryListFiltered.get(position);
        holder.item_name.setText(inventory.getPname());
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
        return inventoryListFiltered.size();
    }

    public interface ItemAdapterListener {
        void onItemSelected(Products inventory);
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
