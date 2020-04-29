package com.telpo.usb.finger.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.activities.profile.FarmMapPolygonActivity;
import com.telpo.usb.finger.databinding.FarmDataBinding;
import com.telpo.usb.finger.editfragments.EditFarminfo;
import com.telpo.usb.finger.pojo.FarmGeoInfo;

import java.util.List;

/**
 * Created by Junior on 12/24/2017.
 */

public class FarmServiceRecylcerAdapter extends RecyclerView.Adapter<FarmServiceRecylcerAdapter.RecyclerViewHolder> {
    FragmentManager fragmentManager;
    private Context context;
    private List<FarmGeoInfo> farmsList;
    private LayoutInflater inflater;

    public FarmServiceRecylcerAdapter(Context context, List<FarmGeoInfo> farmsList, FragmentManager fragmentManager) {
        this.context = context;
        this.farmsList = farmsList;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        FarmDataBinding binding = FarmDataBinding.inflate(inflater, parent, false);
        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final FarmGeoInfo farms = farmsList.get(position);
        holder.bind(farms);

        final FarmDataBinding binding = holder.getDataBinding();
        binding.farmedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    EditFarminfo.newInstance(farms.getFarms().getUniqueuid()).show(fragmentManager, "Dialog Fragment");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        binding.editfarmgeoaddr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(context, FarmMapPolygonActivity.class);
                    intent.putExtra("farmerid", farms.getFarms().getFarmerid());
                    intent.putExtra("farmid", farms.getFarms().getFarmid());
                    context.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return farmsList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private FarmDataBinding dataBinding;

        public RecyclerViewHolder(FarmDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        public void bind(FarmGeoInfo farmgeo) {
            this.dataBinding.setFarmgeo(farmgeo);
        }

        public FarmDataBinding getDataBinding() {
            return dataBinding;
        }
    }
}
