package com.telpo.usb.finger.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Packages;

import java.util.List;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.MyViewHolder> {
    Resources res;
    private Context mContext;
    private List<Packages> packagesList;

    public PackageAdapter(Context mContext, List<Packages> packagesList) {
        this.mContext = mContext;
        this.packagesList = packagesList;
    }

    @NonNull
    @Override
    public PackageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_package, parent, false);
        return new PackageAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final PackageAdapter.MyViewHolder holder, int position) {

        res = holder.itemView.getContext().getResources();
        Packages packages = packagesList.get(position);
        holder.packagename.setText(packages.getPackagename());
        holder.packagesize.setText(res.getString(R.string.noofitems, packages.getNumberofitems()));
    }

    @Override
    public int getItemCount() {
        return packagesList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView packagename, packagesize;

        public MyViewHolder(View view) {
            super(view);
            packagename = view.findViewById(R.id.packname);
            packagesize = view.findViewById(R.id.packagesize);
        }
    }

    public void additem(Packages packages, int position) {
        packagesList.add(position, packages);
        notifyItemInserted(position);
    }
}