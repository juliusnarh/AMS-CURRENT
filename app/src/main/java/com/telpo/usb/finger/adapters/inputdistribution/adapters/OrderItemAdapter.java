package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.OrderItem;

import java.util.List;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.MyViewHolder> {

    private List<OrderItem> orderItemList;

    public OrderItemAdapter(List<OrderItem> orderItemList) {

        this.orderItemList = orderItemList;
    }

    public void add(OrderItem item, int position) {
        orderItemList.add(item);
        notifyItemInserted(position);
    }
    public void remove(OrderItem item) {
        orderItemList.remove(item);
        notifyDataSetChanged();
    }
    public void removeAll() {
        orderItemList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Resources resources = holder.itemView.getContext().getResources();
        OrderItem inventory = orderItemList.get(position);

        holder.name.setText(resources.getString(R.string.temp_order, inventory.getPname(), inventory.getPrice()));
        holder.quantity.setText(resources.getString(R.string.temp_quantity, inventory.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return orderItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, quantity;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name_price);
            quantity = view.findViewById(R.id.quantity);
        }
    }
}
