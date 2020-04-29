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
import com.telpo.usb.finger.entities.Sales;

import java.util.List;

public class ServiceSummaryAdapter extends RecyclerView.Adapter<ServiceSummaryAdapter.MyViewHolder> {
    Resources res;
    private Context mContext;
    private List<Sales> serviceList;

    public ServiceSummaryAdapter(Context mContext, List<Sales> serviceList) {
        this.mContext = mContext;
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public ServiceSummaryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.servicesummary_item, parent, false);
        return new ServiceSummaryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ServiceSummaryAdapter.MyViewHolder holder, final int position) {
        res = holder.itemView.getContext().getResources();
        Sales service = serviceList.get(position);
        holder.serviceytype.setText(service.getPname());
        holder.servicecost.setText(holder.itemView.getResources().getString(R.string.price_item, service.getTotalcost()));
        holder.acreage.setText(String.valueOf(service.getQuantity()));
        holder.farmersserved.setText(service.getSynstatus());
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView serviceytype, farmersserved, servicecost, acreage;

        public MyViewHolder(View view) {
            super(view);
            serviceytype = view.findViewById(R.id.servicetype);
            farmersserved = view.findViewById(R.id.farmersserved);
            servicecost = view.findViewById(R.id.totalcost);
            acreage = view.findViewById(R.id.acreage);
        }
    }

}
