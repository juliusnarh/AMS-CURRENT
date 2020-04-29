package com.telpo.usb.finger.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.activities.registration.HouseholdRelationshipActivity;
import com.telpo.usb.finger.activities.registration.HouseholdSearchActivity;
import com.telpo.usb.finger.databinding.HouseholdDatabinding;
import com.telpo.usb.finger.pojo.FarmerRegisty;

import java.util.List;


public class HouseholdSearchAdapter extends RecyclerView.Adapter<HouseholdSearchAdapter.MyViewHolder> {
    HouseholdDatabinding databinding;
    private List<FarmerRegisty> searchlist;
    private Context context;
    private LayoutInflater inflater;
    private FragmentManager fragmentManager;


    public HouseholdSearchAdapter(List<FarmerRegisty> searchList, Context context) {
        this.context = context;
        this.searchlist = searchList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        databinding = HouseholdDatabinding.inflate(inflater, parent, false);
        return new MyViewHolder(databinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final FarmerRegisty registry = searchlist.get(position);
        holder.bind(registry);
        databinding.hsecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HouseholdRelationshipActivity.class);
                intent.putExtra("householdid", registry.getFarmerid());
                intent.putExtra("farmerid", HouseholdSearchActivity.householdSearchView.farmerid);
                context.startActivity(intent);
                HouseholdSearchActivity.householdSearchView.finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchlist.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private HouseholdDatabinding databinding;

        MyViewHolder(HouseholdDatabinding databinding) {
            super(databinding.getRoot());
            this.databinding = databinding;
        }

        public void bind(FarmerRegisty registy) {
            this.databinding.setSearch(registy);
        }

        public HouseholdDatabinding getDatabinding() {
            return databinding;
        }
    }
}