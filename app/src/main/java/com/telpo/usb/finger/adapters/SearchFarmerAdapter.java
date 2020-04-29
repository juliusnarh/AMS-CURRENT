package com.telpo.usb.finger.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.FarmerActivity;
import com.telpo.usb.finger.activities.FarmerSearchAggregatorActivity;
import com.telpo.usb.finger.entities.GetSearchFarmerInfo;
import com.telpo.usb.finger.interfaces.ItemClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rebekkah_Boamah on 10/26/2017.
 */

public class SearchFarmerAdapter extends RecyclerView.Adapter<SearchFarmerAdapter.MyViewHolder> implements Filterable {
    Context context;
    private ItemClickListener clicklistener;
    private List<GetSearchFarmerInfo> searchInfo;
    private List<GetSearchFarmerInfo> searchInfoFiltered;
    private Activity activity;

    public SearchFarmerAdapter(List<GetSearchFarmerInfo> searchList, Context context, ItemClickListener clicklistener, Activity activity) {
        this.context = context;
        this.searchInfo = searchList;
        this.searchInfoFiltered = searchList;
        this.clicklistener = clicklistener;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.farmer_search_item_mobile_layout, parent, false);
        return new SearchFarmerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        GetSearchFarmerInfo info = searchInfoFiltered.get(position);
        holder.farmer_name.setText(info.getName());
        holder.farmer_id.setText(info.getFarmer_id());
        holder.tel.setText(info.getTelephone());
        holder.cart.setText(holder.itemView.getResources().getString(R.string.cartitem, String.valueOf(AndroidUtils.loadFarmerCart(info.getFarmer_id()))));
//        Log.d("PHOTO:", "" + info.photo.length);
        if (info.photo != null)
            AndroidUtils.setImageViewResource(holder.imageView, info.photo);
        else
            AndroidUtils.setImageViewResource(holder.imageView, AndroidUtils.drawableToArray(R.drawable.placeholder, holder.itemView.getResources()));
        holder.cardCover.setOnClickListener(v -> clicklistener.onItemClick(info.getFarmer_id()));

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    searchInfoFiltered = searchInfo;
                } else {
                    List<GetSearchFarmerInfo> filteredList = new ArrayList<>();
                    for (GetSearchFarmerInfo row : searchInfo) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getFarmer_id().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        } else if (row.getSurname().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        } else if (row.getOthername().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        } else if (row.getCommunity().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        } else if (row.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        } else if (row.getTelephone().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        } else if (row.getAggregatorid().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    searchInfoFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = searchInfoFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                searchInfoFiltered = (ArrayList<GetSearchFarmerInfo>) filterResults.values;
                if (activity instanceof FarmerActivity) {
                    FarmerActivity ac = (FarmerActivity) activity;
                    ac.runLayoutAnimation();
                } else if (activity instanceof FarmerSearchAggregatorActivity) {
                    FarmerSearchAggregatorActivity ac = (FarmerSearchAggregatorActivity) activity;
                    ac.runLayoutAnimation();
                }
            }
        };
    }

    @Override
    public int getItemCount() {
        return searchInfoFiltered == null ? 0 : searchInfoFiltered.size();
    }

    public void add(GetSearchFarmerInfo info, int position) {
        searchInfoFiltered.add(info);
        notifyItemInserted(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView farmer_id, farmer_name, tel, cart;
        LinearLayout cardCover;
        ImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            farmer_name = itemView.findViewById(R.id.farmer_name);
            farmer_id = itemView.findViewById(R.id.farmer_id);
            tel = itemView.findViewById(R.id.telephone);
            cart = itemView.findViewById(R.id.cart);
            cardCover = itemView.findViewById(R.id.cardCover);
            imageView = itemView.findViewById(R.id.img);
        }
    }
}