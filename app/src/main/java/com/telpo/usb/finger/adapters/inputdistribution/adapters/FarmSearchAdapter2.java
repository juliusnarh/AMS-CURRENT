package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.entities.GetSearchFarmInfo;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FarmSearchAdapter2 extends RecyclerView.Adapter implements Filterable {
    private final int VIEW_ITEM = 0;
    private final int VIEW_PROG = 1;
    Resources res;
    private List<GetSearchFarmInfo> farmInfoList;
    private List<GetSearchFarmInfo> farmInfoListFiltered;
    private Context context;

    public FarmSearchAdapter2(Context context, List<GetSearchFarmInfo> farmInfoList) {
        this.context = context;
        this.farmInfoList = farmInfoList;
        this.farmInfoListFiltered = farmInfoList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == VIEW_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.farmsearch_item, parent, false);

            viewHolder = new MyViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.progressbar, parent, false);

            viewHolder = new ProgressViewHolder(v);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHolder) {
            res = holder.itemView.getContext().getResources();
            GetSearchFarmInfo searchFarmInfo = farmInfoListFiltered.get(position);
            String farmername = searchFarmInfo.getSurname().toUpperCase() + ", " + searchFarmInfo.getOthername();
            ((MyViewHolder) holder).farmerid.setText(searchFarmInfo.getFarmerid());
            ((MyViewHolder) holder).farmername.setText(farmername);
            ((MyViewHolder) holder).farms.setText(searchFarmInfo.getFarms().replaceAll(",", "\n"));
            ((MyViewHolder) holder).farmno.setText(res.getString(R.string.farm_no, AndroidUtils.loadfarmCount(searchFarmInfo.getFarmerid())));
            try {
                ((MyViewHolder) holder).farmerimg.setImageDrawable(AndroidUtils.arraytodrawable(AndroidUtils.loadFarmerImg(searchFarmInfo.getFarmerid(), res), context));
            } catch (Exception e) {
                e.printStackTrace();
            }

            ((MyViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ProfileActivity.class);
                    intent.putExtra("farmerid", searchFarmInfo.getFarmerid());
                    context.startActivity(intent);
                }
            });

        } else ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
    }

    @Override
    public int getItemCount() {
        return farmInfoListFiltered == null ? 0 : farmInfoListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    farmInfoListFiltered = farmInfoList;
                } else {
                    List<GetSearchFarmInfo> filteredList = new ArrayList<>();
                    for (GetSearchFarmInfo row : farmInfoList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (
                                row.getFarmerid().toLowerCase().contains(charString.toLowerCase()) ||
                                        row.getSurname().toLowerCase().contains(charString.toLowerCase()) ||
                                        row.getOthername().toLowerCase().contains(charString.toLowerCase())

                        ) {
                            filteredList.add(row);
                        }
                    }

                    farmInfoListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = farmInfoListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                farmInfoListFiltered = (ArrayList<GetSearchFarmInfo>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemViewType(int position) {
        return farmInfoListFiltered.get(position) == null ? VIEW_PROG : VIEW_ITEM;
    }

    public void add(GetSearchFarmInfo info, int position) {
        farmInfoListFiltered.add(info);
        notifyItemInserted(position);
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressViewHolder(View v) {
            super(v);
            progressBar = v.findViewById(R.id.progressBar1);
        }
    }

    /////////////////////VIEW HOLDERS
    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView farmerimg;
        TextView farmername, farmerid, farms, farmno;

        public MyViewHolder(View view) {
            super(view);
            farmerimg = view.findViewById(R.id.farmerimg);
            farmername = view.findViewById(R.id.farmername);
            farmerid = view.findViewById(R.id.farmerid);
            farms = view.findViewById(R.id.farms);
            farmno = view.findViewById(R.id.farmno);
        }
    }
}
