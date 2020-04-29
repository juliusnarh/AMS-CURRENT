package com.telpo.usb.finger.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.databinding.HouseholdsDataBinding;
import com.telpo.usb.finger.pojo.FarmerRegisty;

import java.util.List;

/**
 * Created by Junior on 12/24/2017.
 */

public class HouseholdProfileRecylcerAdapter extends RecyclerView.Adapter<HouseholdProfileRecylcerAdapter.RecyclerViewHolder> {
    FragmentManager fragmentManager;
    private Context context;
    private List<FarmerRegisty> registyList;
    private LayoutInflater inflater;

    public HouseholdProfileRecylcerAdapter(Context context, List<FarmerRegisty> registyList, FragmentManager fragmentManager) {
        this.context = context;
        this.registyList = registyList;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        HouseholdsDataBinding binding = HouseholdsDataBinding.inflate(inflater, parent, false);
        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final FarmerRegisty registy = registyList.get(position);
        holder.bind(registy);

        final HouseholdsDataBinding binding = holder.getDataBinding();
        binding.householdedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(context, ProfileActivity.class);
                    intent.putExtra("farmerid", registy.getFarmerid());
                    context.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return registyList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private HouseholdsDataBinding dataBinding;

        public RecyclerViewHolder(HouseholdsDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        public void bind(FarmerRegisty household) {
            this.dataBinding.setHousehold(household);
        }

        public HouseholdsDataBinding getDataBinding() {
            return dataBinding;
        }
    }
}
