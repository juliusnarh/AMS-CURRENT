package com.telpo.usb.finger.adapters;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.interfaces.SelectedFarmerClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.List;

public class SelectFarmerAdapter extends RecyclerView.Adapter<SelectFarmerAdapter.MyViewHolder> {
    public List<Farmers> farmersList;
    Resources res;
    SelectedFarmerClickListener listener;
    private Context mContext;

    public SelectFarmerAdapter(Context mContext, List<Farmers> farmersList, SelectedFarmerClickListener listener) {
        this.mContext = mContext;
        this.farmersList = farmersList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SelectFarmerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farmer, parent, false);
        return new SelectFarmerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final SelectFarmerAdapter.MyViewHolder holder, int position) {

        res = holder.itemView.getContext().getResources();
        Farmers farmers = farmersList.get(position);
        byte[] bbb = AndroidUtils.loadFarmerImg(farmers.getFarmerid(), res);
        holder.aggregatorid.setText(farmers.getFarmerid());
        holder.aggregatorname.setText(farmers.getSurname() + " " + farmers.getOthername());
        holder.tel.setText(farmers.getTel());
        holder.regiondistrict.setText(farmers.getRegion() + ", " + farmers.getDistrict());
        holder.cropspeciality.setText(farmers.getSpecialty());
        holder.backg.setForeground(farmers.isSelected() ? ContextCompat.getDrawable(mContext, R.drawable.background_multiple_select) : ContextCompat.getDrawable(mContext, R.drawable.background_multiple_select_default));
        Glide.with(mContext)
                .load(bbb)
                .into(holder.aggimg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                farmers.setSelected(!farmers.isSelected());

                if (farmers.isSelected)
                    listener.onSelectedFarmerClickListener(farmers, 1);
                else
                    listener.onSelectedFarmerClickListener(farmers, 0);

                holder.backg.setForeground(farmers.isSelected() ? ContextCompat.getDrawable(mContext, R.drawable.background_multiple_select) : ContextCompat.getDrawable(mContext, R.drawable.background_multiple_select_default));
            }
        });

    }

    @Override
    public int getItemCount() {
        return farmersList.size();
    }

    public void addaggregator(Farmers farmers) {
        farmersList.add(farmers);
        notifyItemChanged(farmersList.size() - 1, farmers);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView aggregatorid, aggregatorname, tel, regiondistrict, cropspeciality;
        CircularImageView aggimg;
        FrameLayout backg;

        public MyViewHolder(View view) {
            super(view);
            aggimg = view.findViewById(R.id.aggimg);
            aggregatorid = view.findViewById(R.id.aggregatorid);
            regiondistrict = view.findViewById(R.id.region_district);
            aggregatorname = view.findViewById(R.id.name);
            backg = view.findViewById(R.id.backg);
            tel = view.findViewById(R.id.tel);
            cropspeciality = view.findViewById(R.id.cropspeciality);
        }
    }

}