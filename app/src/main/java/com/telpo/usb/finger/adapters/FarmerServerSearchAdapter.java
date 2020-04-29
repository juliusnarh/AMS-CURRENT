package com.telpo.usb.finger.adapters;

/**
 * Created by ravi on 31/01/18.
 */

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.GetServerSearchFarmerInfo;

import java.util.List;

public class FarmerServerSearchAdapter extends RecyclerView.Adapter<FarmerServerSearchAdapter.MyViewHolder> {
    private Context context;
    private List<GetServerSearchFarmerInfo> farmerInfoList;
    private FarmerSearchAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone, community, farmerid;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            phone = view.findViewById(R.id.phone);
            thumbnail = view.findViewById(R.id.thumbnail);
            community = view.findViewById(R.id.community);
            farmerid = view.findViewById(R.id.farmerid);
        }
    }


    public FarmerServerSearchAdapter(Context context, List<GetServerSearchFarmerInfo> farmerInfoList, FarmerSearchAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.farmerInfoList = farmerInfoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_farmer_search_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final GetServerSearchFarmerInfo farmerInfo = farmerInfoList.get(position);
        holder.name.setText(farmerInfo.getName());
        holder.phone.setText(farmerInfo.getTelephone());
        holder.community.setText(farmerInfo.getCommunity());
        holder.farmerid.setText(farmerInfo.getFarmerid());
        if (farmerInfo.getImg() != null)
            Glide.with(context)
                    .load(convertToDrawable(farmerInfo.getImg()))
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.thumbnail);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFarmerSelected(farmerInfoList.get(holder.getAdapterPosition()), holder.thumbnail, farmerInfo.getImg());
            }
        });

    }

    private Drawable convertToDrawable(String img) {
        byte[] imgbyte = Base64.decode(img.getBytes(), Base64.DEFAULT);
        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray(imgbyte, 0, imgbyte.length));
    }

    @Override
    public int getItemCount() {
        return farmerInfoList.size();
    }

    public interface FarmerSearchAdapterListener {
        void onFarmerSelected(GetServerSearchFarmerInfo searchFarmerInfo, ImageView imageView, String imageValue);
    }
}
