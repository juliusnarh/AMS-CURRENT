package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Products;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.MyViewHolder> {
    private Resources res;
    private List<Sales> salesList;

    public SalesAdapter(List<Sales> salesList) {
        this.salesList = salesList;
    }

    @NonNull
    @Override
    public SalesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.salepurchases_item, parent, false);
        return new SalesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SalesAdapter.MyViewHolder holder, int position) {
        res = holder.itemView.getContext().getResources();
        Sales sales = salesList.get(position);
        List<Products> products = null;
        try {
            products = Products.find(Products.class, "pid = ?", sales.getPid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sales.getFarmerid() != null) {
            String pos = (position + 1) + ".";
            holder.pos.setText(pos);
            holder.inputname.setText(sales.getPname());
            holder.quantity.setText(res.getString(R.string.xquantity, sales.getQuantity()));
            holder.cost.setText(res.getString(R.string.price_item, sales.getTotalcost()));


            if ((products != null ? products.size() : 0) > 0) {
                if (sales.getTransactionid().startsWith(AndroidUtils.SERVICETRANSID))
                    holder.unit.setVisibility(View.GONE);
                else
                    holder.unit.setText(res.getString(R.string.unit_m, products.get(0).getUnitm()));
            }
        }

    }

    @Override
    public int getItemCount() {
        return salesList.size();
    }

    public void addnewitem(List<Sales> salesList, RecyclerView recycler) {
        this.salesList = salesList;
        runLayoutAnimation(recycler);
    }

    private void runLayoutAnimation(RecyclerView recycler) {
        final Context context = recycler.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down2);

        recycler.setLayoutAnimation(controller);
        recycler.getAdapter().notifyDataSetChanged();
        recycler.scheduleLayoutAnimation();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView inputname, quantity, cost, unit, pos;


        public MyViewHolder(View view) {
            super(view);
            pos = view.findViewById(R.id.pos);
            inputname = view.findViewById(R.id.input_name);
            quantity = view.findViewById(R.id.quantity);
            cost = view.findViewById(R.id.price);
            unit = view.findViewById(R.id.unitm);
        }
    }

}
