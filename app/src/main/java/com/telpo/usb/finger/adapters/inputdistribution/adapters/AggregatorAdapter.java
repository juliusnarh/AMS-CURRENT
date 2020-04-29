package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.pojo.Aggregator;

import java.util.List;

public class AggregatorAdapter extends RecyclerView.Adapter<AggregatorAdapter.MyViewHolder> {
    Resources res;
    private Context mContext;
    private List<Aggregator> aggregatorList;

    public AggregatorAdapter(Context mContext, List<Aggregator> aggregatorList) {
        this.mContext = mContext;
        this.aggregatorList = aggregatorList;
    }

    @NonNull
    @Override
    public AggregatorAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aggregator, parent, false);
        return new AggregatorAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final AggregatorAdapter.MyViewHolder holder, int position) {

        res = holder.itemView.getContext().getResources();
        Aggregator aggregator = aggregatorList.get(position);

        holder.aggregatorid.setText(aggregator.getAggregatorid());
        holder.aggregatorid.setText(aggregator.getAggregatorid());
        holder.aggregatorname.setText(aggregator.getAggregatorname());
        holder.tel.setText(aggregator.getTel());
        holder.address.setText(aggregator.getAddress());
        holder.contactperson.setText(aggregator.getContactperson());
        holder.cpersontel.setText(aggregator.getCpersontel());
        holder.role.setText(aggregator.getRole());
        holder.region.setText(aggregator.getRegion());
        holder.district.setText(aggregator.getDistrict());
        holder.cropspeciality.setText(aggregator.getCropspeciality());

    }

    @Override
    public int getItemCount() {
        return aggregatorList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView aggregatorid, aggregatorname, tel, address, contactperson, cpersontel, role, region, district, cropspeciality;

        public MyViewHolder(View view) {
            super(view);
            aggregatorid = view.findViewById(R.id.aggregatorid);
            aggregatorname = view.findViewById(R.id.name);
            tel = view.findViewById(R.id.tel);
            address = view.findViewById(R.id.address);
            contactperson = view.findViewById(R.id.contactname);
            cpersontel = view.findViewById(R.id.cpersontel);
            role = view.findViewById(R.id.role);
            region = view.findViewById(R.id.region);
            district = view.findViewById(R.id.district);
            cropspeciality = view.findViewById(R.id.cropspeciality);

        }
    }

}