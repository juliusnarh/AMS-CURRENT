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
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Products;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.MyViewHolder> implements Filterable {
    private Context mContext;
    private List<Products> serviceList;
    private List<Products> serviceListFiltered;

    public ServiceAdapter(Context mContext, List<Products> serviceList) {
        this.mContext = mContext;
        this.serviceList = serviceList;
        this.serviceListFiltered = serviceList;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    serviceListFiltered = serviceList;
                } else {
                    List<Products> filteredList = new ArrayList<>();
                    for (Products row : serviceList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (
                                row.getPname().toLowerCase().contains(charString.toLowerCase()) ||
                                        row.getCategory().toLowerCase().contains(charString.toLowerCase()) ||
                                        row.getPid().toLowerCase().contains(charString.toLowerCase()) ||
                                        row.getSupplier().toLowerCase().contains(charString.toLowerCase()) ||
                                        row.getPdesc().toLowerCase().contains(charString.toLowerCase())
                        ) {
                            filteredList.add(row);
                        }
                    }

                    serviceListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = serviceListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                serviceListFiltered = (ArrayList<Products>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Resources resources = holder.itemView.getContext().getResources();
        Products inventory = serviceListFiltered.get(position);
        holder.service_desc.setText(inventory.getPdesc());
        holder.service_type.setText(inventory.getPname());
        holder.service_provider.setText(inventory.getSupplier());
        holder.service_cost.setText(String.format(resources.getString(R.string.price_item), Double.parseDouble(inventory.getPrice())));
        holder.date_created.setText(AndroidUtils.formatDate2(inventory.getDatecreated().toString()));
    }

    @Override
    public int getItemCount() {
        return serviceListFiltered.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView service_type, service_desc, service_provider, service_cost, date_created;

        public MyViewHolder(View view) {
            super(view);
            service_desc = view.findViewById(R.id.s_desc);
            service_type = view.findViewById(R.id.s_type);
            service_provider = view.findViewById(R.id.s_provider);
            service_cost = view.findViewById(R.id.s_cost);
            date_created = view.findViewById(R.id.date_created);
        }
    }

}
