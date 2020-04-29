package com.telpo.usb.finger.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.pojo.FarmerRegisty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior on 12/14/2017.
 */

public class RegisteredAdapter extends RecyclerView.Adapter<RegisteredAdapter.FarmerRegistryViewHolder> implements Filterable {
    ArrayList<FarmerRegisty> filteredList;
    private Context mCtx;
    private List<FarmerRegisty> farmerlist;
    private List<FarmerRegisty> mFilteredList;

    public RegisteredAdapter(Context mCtx, List<FarmerRegisty> farmerlist) {
        this.mCtx = mCtx;
        this.farmerlist = farmerlist;
        this.mFilteredList = farmerlist;
    }

    @Override
    public FarmerRegistryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.household_search_item, null);
        return new FarmerRegistryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FarmerRegistryViewHolder holder, int position) {
        FarmerRegisty farmerRegisty = mFilteredList.get(position);
        holder.txtfullname.setText(farmerRegisty.getFullname());
        holder.txttelephone.setText(farmerRegisty.getTelephone());
        holder.txtidnumber.setText(String.valueOf(farmerRegisty.getId()));
        holder.txtnationality.setText(String.valueOf(farmerRegisty.getNationality()));
        holder.photo.setImageBitmap(null/*farmerRegisty.getPhoto()*/);
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    mFilteredList = farmerlist;
                } else {
                    filteredList = new ArrayList<>();

                    for (FarmerRegisty registy : farmerlist) {

                        if (registy.getFullname().toLowerCase().contains(charString) || registy.getTelephone().toLowerCase().contains(charString)) {

                            filteredList.add(registy);
                        }
                    }
                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<FarmerRegisty>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class FarmerRegistryViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView txtfullname, txttelephone, txtidnumber, txtnationality;

        public FarmerRegistryViewHolder(View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.photo);
            txtfullname = itemView.findViewById(R.id.fullname);
            txttelephone = itemView.findViewById(R.id.telephone);
            txtidnumber = itemView.findViewById(R.id.idnumber);
            txtnationality = itemView.findViewById(R.id.nationality);
        }
    }
}
