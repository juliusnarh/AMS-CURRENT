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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.interfaces.SaletranClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SalestranAdapter extends RecyclerView.Adapter<SalestranAdapter.MyViewHolder> implements Filterable {
    Resources res;
    SaletranClickListener listener;
    private Context mContext;
    private List<Salestran> salestranList;
    private List<Salestran> salestranListFiltered;

    public SalestranAdapter(Context mContext, List<Salestran> salestranList, SaletranClickListener listener) {
        this.mContext = mContext;
        this.salestranList = salestranList;
        this.salestranListFiltered = salestranList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SalestranAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.saletran_list_layout, parent, false);
        return new SalestranAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final SalestranAdapter.MyViewHolder holder, final int position) {
        res = holder.itemView.getContext().getResources();
        Salestran salestran = salestranListFiltered.get(position);
        List<Sales> salesList = new ArrayList<>();
        if (salestran.getFarmerid() != null) {
            salesList = Sales.find(Sales.class, "transactionid = ?", salestran.getTransactionid());
            StringBuilder orderdetails = new StringBuilder(), quantities = new StringBuilder();
            for (Sales sales : salesList) {
                orderdetails.append(sales.getPname()).append(",");
                quantities.append(sales.getQuantity()).append(",");
            }

            orderdetails.append("~");
            quantities.append("~");

            holder.farmerimg.setImageDrawable(AndroidUtils.arraytodrawable(AndroidUtils.loadFarmerImg(salestran.getFarmerid(), res), mContext));
            holder.transid.setText(salestran.getTransactionid());
            holder.totalcost.setText(res.getString(R.string.price_item, (salestran.getTotalCost() - salestran.getAppliedsub())));
            holder.pmethod.setText(salestran.getPaymentmethod());
            holder.agentid.setText(salestran.getAgentname());
            if (salestran.getDatecreated() != null)
                holder.datecreated.setText(AndroidUtils.dateToFormattedString(salestran.getDatecreated(), "dd MMM, yyyy"));
            else
                holder.datecreated.setText(AndroidUtils.dateToFormattedString(salestran.getDates(), "dd MMM, yyyy"));

            holder.acreage.setText(res.getString(R.string.acre, salestran.getAcreage()));
            holder.bagspayable.setText(res.getString(R.string.expected, salestran.getNorecoverybags()));


            if (salestran.getCouponcode().equalsIgnoreCase("subsidized")) {
                holder.subsidized.setText("Yes");
            } else holder.subsidized.setText("No");

            if (salestran.getTransactionid().charAt(0) != 'R') {
                holder.purchases.setText(AndroidUtils.formatedItems(orderdetails, quantities, res));
                holder.tendered.setText(res.getString(R.string.price_item, salestran.getTendered()));
            } else if (salestran.getTransactionid().charAt(0) != 'P') {
                holder.purchases.setText("no purchases available");
                holder.tendered.setText(res.getString(R.string.expected, salestran.getTendered()));
            } else {
                holder.purchases.setText("no purchases available");
                holder.tendered.setText(res.getString(R.string.expected, salestran.getTendered()));
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.onSaletranClickListener(holder.getAdapterPosition(), salestran, holder.farmerimg);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return salestranListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    salestranListFiltered = salestranList;
                } else {
                    List<Salestran> filteredList = new ArrayList<>();
                    for (Salestran row : salestranList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getTransactionid().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    salestranListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = salestranListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                salestranListFiltered = (ArrayList<Salestran>) filterResults.values;

            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView transid, purchases, totalcost, subsidized, pmethod, agentid, bagspayable, tendered, acreage, datecreated;
        RelativeLayout tooltiplayout;
        LinearLayout tooltip1;
        CircleImageView farmerimg;

        public MyViewHolder(View view) {
            super(view);
            farmerimg = view.findViewById(R.id.farmerimg);
            transid = view.findViewById(R.id.transid);
            purchases = view.findViewById(R.id.purchases);
            totalcost = view.findViewById(R.id.cost);
            subsidized = view.findViewById(R.id.sub);
            pmethod = view.findViewById(R.id.pmethod);
            agentid = view.findViewById(R.id.agent);
            bagspayable = view.findViewById(R.id.bagspayable);
            tendered = view.findViewById(R.id.tendered);
            acreage = view.findViewById(R.id.acreage);
            datecreated = view.findViewById(R.id.date);
            tooltiplayout = view.findViewById(R.id.tooltiplayout);
            tooltip1 = view.findViewById(R.id.tooltip1);
        }
    }

}
