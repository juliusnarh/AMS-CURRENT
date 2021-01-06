package com.telpo.usb.finger.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.AggregatorInputs;
import com.telpo.usb.finger.interfaces.SelectedInputClickListener;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;

import java.util.List;

public class SelectInputAdapter extends RecyclerView.Adapter<SelectInputAdapter.MyViewHolder> {
    Resources res;
    private Context mContext;
    public List<AggregatorInputs> inputsList;
    SelectedInputClickListener listener;
    ListDialogFragment dialogFragment;
    int quantity = 0;

    public SelectInputAdapter(Context mContext, List<AggregatorInputs> inputsList, SelectedInputClickListener listener) {
        this.mContext = mContext;
        this.inputsList = inputsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SelectInputAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inputs, parent, false);
        return new SelectInputAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final SelectInputAdapter.MyViewHolder holder, int position) {

        res = holder.itemView.getContext().getResources();
        AggregatorInputs inputs = inputsList.get(position);
        holder.inputcost.setText(res.getString(R.string.price_quantity, inputs.getCostPrice(), inputs.getQuantity()));
        holder.subsidizedprice.setText(res.getString(R.string.price_item, inputs.getSalePrice()));
        holder.inputdealer.setText(inputs.getInputDealer());
        holder.inputname.setText(inputs.getInputName());
        Glide.with(mContext)
                .load(inputs.getInputImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.placeholder)
                .fitCenter()
                .into(holder.inputimage);
    }

    @Override
    public int getItemCount() {
        return inputsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView inputname, inputdealer, inputcost, subsidizedprice;
        ImageView inputimage;
        CardView backg;

        public MyViewHolder(View view) {
            super(view);
            inputname = view.findViewById(R.id.inputname);
            inputdealer = view.findViewById(R.id.inputdealer);
            inputcost = view.findViewById(R.id.inputcost);
            subsidizedprice = view.findViewById(R.id.subsidizedprice);
            backg = view.findViewById(R.id.backg);
            inputimage = view.findViewById(R.id.inputimage);
        }
    }
}