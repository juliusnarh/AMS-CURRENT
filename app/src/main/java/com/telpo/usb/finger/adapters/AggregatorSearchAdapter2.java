package com.telpo.usb.finger.adapters;

/**
 * Created by ravi on 31/01/18.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Aggregator;

import java.util.List;

public class AggregatorSearchAdapter2 extends RecyclerView.Adapter<AggregatorSearchAdapter2.MyViewHolder> {
    private Context context;
    private List<Aggregator> aggregatorList;
    private AggregatorSearchAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone, aggregatorid;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            phone = view.findViewById(R.id.phone);
            thumbnail = view.findViewById(R.id.thumbnail);
            aggregatorid = view.findViewById(R.id.aggregatorid);
        }
    }


    public AggregatorSearchAdapter2(Context context, List<Aggregator> aggregatorList, AggregatorSearchAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.aggregatorList = aggregatorList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_aggregator_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Aggregator aggregator = aggregatorList.get(position);
        holder.aggregatorid.setText(aggregator.getAggregatorid());
        holder.name.setText(aggregator.getAggregatorname());
        holder.phone.setText(aggregator.getTel());
            Glide.with(context)
                    .load(aggregator.getImage())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .apply(RequestOptions.circleCropTransform())
                    .placeholder(R.drawable.ic_circular_placeholder)
                    .into(holder.thumbnail);
        holder.itemView.setOnClickListener(v -> listener.onAggregatorSelected(aggregator.aggregatorid));
    }

    @Override
    public int getItemCount() {
        return aggregatorList.size();
    }

    public interface AggregatorSearchAdapterListener {
        void onAggregatorSelected(String aggregatorid);
    }
}
