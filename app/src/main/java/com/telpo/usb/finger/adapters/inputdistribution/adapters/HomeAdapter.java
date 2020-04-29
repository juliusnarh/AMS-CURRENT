package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Products;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    Resources res;
    private Context mContext;
    private List<Products> inventoryList;

    public HomeAdapter(Context mContext, List<Products> inventoryList) {
        this.mContext = mContext;
        this.inventoryList = inventoryList;
    }

    @NonNull
    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_item, parent, false);
        return new HomeAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeAdapter.MyViewHolder holder, final int position) {
        res = holder.itemView.getContext().getResources();
        Products inventory = inventoryList.get(position);

        if (inventory != null) {
            if (inventory.getPid().startsWith(AndroidUtils.SERVICETRANSID)) {
                if (holder.inputlayout.getVisibility() == View.VISIBLE) {
                    holder.servicelayout.setVisibility(View.VISIBLE);
                    holder.inputlayout.setVisibility(View.INVISIBLE);
                }

                holder.service_desc.setText(inventory.getPdesc());
                holder.service_type.setText(inventory.getPname());
                holder.service_provider.setText(inventory.getSupplier());
                holder.service_cost.setText(String.format(res.getString(R.string.price_item), Double.parseDouble(inventory.getPrice())));
            } else {
                if (holder.servicelayout.getVisibility() == View.VISIBLE) {

                    holder.servicelayout.setVisibility(View.INVISIBLE);
                    holder.inputlayout.setVisibility(View.VISIBLE);
                }
                holder.item_name.setText(inventory.getPname());
                if (inventory.pdesc == null) {
                    holder.item_desc.setText(inventory.getPname());
                }
                holder.item_desc.setText(inventory.getPdesc());
                holder.item_aid.setText(inventory.getSupplier());

                holder.item_price.setText(res.getString(R.string.pricealt, inventory.getSubprice(), inventory.getQuantity()));
                holder.item_id.setText(inventory.getPid());
                Glide.with(mContext).load(inventory.getItem_img()).transition(DrawableTransitionOptions.withCrossFade()).into(holder.item_img);
            }
        }

    }

    @Override
    public int getItemCount() {
        return inventoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView item_name, service_type, service_desc, service_provider, service_cost, item_desc, item_aid, item_price, item_quantity, item_id;
        public ImageView item_img;
        public LinearLayout servicelayout;
        public RelativeLayout inputlayout;

        public MyViewHolder(View view) {
            super(view);
            item_name = view.findViewById(R.id.item_name);
            item_desc = view.findViewById(R.id.item_desc);
            item_aid = view.findViewById(R.id.item_aid);
            item_price = view.findViewById(R.id.item_price);
            item_id = view.findViewById(R.id.item_id);
            item_img = view.findViewById(R.id.item_img);
            servicelayout = view.findViewById(R.id.service_layout);
            inputlayout = view.findViewById(R.id.inputlayout);

            service_desc = view.findViewById(R.id.s_desc);
            service_type = view.findViewById(R.id.s_type);
            service_provider = view.findViewById(R.id.s_provider);
            service_cost = view.findViewById(R.id.s_cost);
        }
    }

}
