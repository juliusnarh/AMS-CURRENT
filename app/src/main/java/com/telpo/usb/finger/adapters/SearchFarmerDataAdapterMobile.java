package com.telpo.usb.finger.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.FarmerSearchView;
import com.telpo.usb.finger.entities.GetSearchFarmerInfo;
import com.telpo.usb.finger.interfaces.ItemClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;

/**
 * Created by Rebekkah_Boamah on 10/26/2017.
 */

public class SearchFarmerDataAdapterMobile extends RecyclerView.Adapter<SearchFarmerDataAdapterMobile.MyViewHolder> {
    Context context;
    ItemClickListener clicklistener;
    private ArrayList<GetSearchFarmerInfo> searchInfo = new ArrayList<>();
    private String package_name = "com.telpo.usb.finger";
    private String Class_name = "com.telpo.usb.finger.activities.MainActivity";
    private FarmerSearchView activity;

    public SearchFarmerDataAdapterMobile(ArrayList<GetSearchFarmerInfo> searchList, Context context, ItemClickListener clicklistener, FarmerSearchView activity) {
        this.context = context;
        this.searchInfo = searchList;
        this.clicklistener = clicklistener;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.farmer_search_item_mobile_layout, parent, false);
        return new SearchFarmerDataAdapterMobile.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.farmer_name.setText(searchInfo.get(position).getName());
        holder.farmer_id.setText(searchInfo.get(position).getFarmer_id());
        holder.tel.setText(searchInfo.get(position).getTelephone());
        holder.cart.setText(holder.itemView.getResources().getString(R.string.cartitem, String.valueOf(AndroidUtils.loadFarmerCart(searchInfo.get(position).getFarmer_id()))));
//        Log.d("PHOTO:", "" + searchInfo.get(position).photo.length);
        if (searchInfo.get(position).photo != null)
            AndroidUtils.setImageViewResource(holder.imageView, searchInfo.get(position).photo);
        else
            AndroidUtils.setImageViewResource(holder.imageView, AndroidUtils.drawableToArray(R.drawable.placeholder, holder.itemView.getResources()));
        holder.cardCover.setOnClickListener(v -> clicklistener.onItemClick(searchInfo.get(position).getFarmer_id()));

    }


    @Override
    public int getItemCount() {
        return searchInfo.size();
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