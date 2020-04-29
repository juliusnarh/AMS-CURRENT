package com.telpo.usb.finger.adapters;

/**
 * Created by ravi on 31/01/18.
 */

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Aggregator;
import com.telpo.usb.finger.entities.GetServerSearchFarmerInfo;

import java.util.List;

public class AggregatorSearchAdapter extends RecyclerView.Adapter<AggregatorSearchAdapter.MyViewHolder> {
    private Context context;
    private List<Aggregator> aggregatorList;
    private AggregatorSearchAdapterListener listener;

    public void addAll(List<Aggregator> aggregatorList) {
        this.aggregatorList.addAll(aggregatorList);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView aggregatorid, index;
        public MyViewHolder(View view) {
            super(view);
            aggregatorid = view.findViewById(R.id.aggregatorid);
            index = view.findViewById(R.id.index);
        }
    }


    public AggregatorSearchAdapter(Context context, List<Aggregator> aggregatorList, AggregatorSearchAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.aggregatorList = aggregatorList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_aggregator_search, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Aggregator aggregator = aggregatorList.get(position);
        holder.index.setText(String.format("%s.", String.valueOf(holder.getAdapterPosition()+1)));
        holder.aggregatorid.setText(aggregator.getAggregatorid());

        holder.itemView.setOnClickListener(v -> listener.onAggregatorSelected(aggregator.getAggregatorid()));
    }

    @Override
    public int getItemCount() {
        return aggregatorList.size();
    }

    public interface AggregatorSearchAdapterListener {
        void onAggregatorSelected(String aggregatorid);
    }
}
