package com.telpo.usb.finger.adapters;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.FarmerSearchView;
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.entities.GetSearchFarmerInfo;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;

/**
 * Created by Rebekkah_Boamah on 10/26/2017.
 */

class SearchFarmerDataAdapterServer extends RecyclerView.Adapter<SearchFarmerDataAdapterServer.MyViewHolder> {
    Context context;
    String getFarmer_id, image, farmer_name;
    private ArrayList<GetSearchFarmerInfo> searchInfo = new ArrayList<>();
    private String package_name = "com.telpo.usb.finger";
    private String Class_name = "com.telpo.usb.finger.activities.MainActivity";

    SearchFarmerDataAdapterServer(ArrayList<GetSearchFarmerInfo> searchList, Context context) {
        this.context = context;
        this.searchInfo = searchList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.farmer_search_item_server_layout, parent, false);
        return new SearchFarmerDataAdapterServer.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.farmer_name.setText(searchInfo.get(position).getName());
        holder.farmer_id.setText(searchInfo.get(position).getFarmer_id());
        holder.tel.setText(searchInfo.get(position).getTelephone());
        AndroidUtils.setImageViewResource(holder.imageView, searchInfo.get(position).getPhoto());
        holder.cardCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(context)
                        //  .setIcon(android.R.drawable.alert_ligh)
                        .setMessage("What do you want to do with " + searchInfo.get(position).getFarmer_id())  //then need to set a onclick listener with our positive button
                        .setPositiveButton("View Profile", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                // navagition(searchInfo.get(position).getFarmer_id(), searchInfo.get(position).getFarmerid(), searchInfo.get(position).getImg());
                                loadProfilePage(searchInfo.get(position).getFarmer_id());
                            }
                        })

                        .setNegativeButton("Input Distribution", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                launch_call(searchInfo.get(position).getFarmer_id(), searchInfo.get(position).getFarm_id());
                            }
                        })
                        .show();
            }
        });
    }

    private void launch_call(String farmer_id, String farmer_name) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.putExtra("farmer_id", farmer_id);
        intent.putExtra("farmer_name", farmer_name);
        intent.putExtra("option", true);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setComponent(new ComponentName(package_name, Class_name));
        try {
            context.startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void al(String message, final boolean getOption) {

    }

    private void navagition(String farmer_id, String name, String image) {
        loadProfilePage(farmer_id);
    }

    //method to load profile page
    public void loadProfilePage(String farmerid) {
        Intent intent = new Intent(context, ProfileActivity.class);
        intent.putExtra("farmerid", farmerid);
        context.startActivity(intent);
        FarmerSearchView.farmerSearchView.finish();
    }

    @Override
    public int getItemCount() {
        return searchInfo.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView farmer_id, farmer_name, tel;
        LinearLayout cardCover;
        ImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            farmer_name = itemView.findViewById(R.id.farmer_name);
            farmer_id = itemView.findViewById(R.id.farmer_id);
            tel = itemView.findViewById(R.id.telephone);
            cardCover = itemView.findViewById(R.id.cardCover);
            imageView = itemView.findViewById(R.id.img);
        }
    }
}