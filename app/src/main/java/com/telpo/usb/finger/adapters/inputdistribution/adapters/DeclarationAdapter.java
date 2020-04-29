package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeclarationAdapter extends RecyclerView.Adapter<DeclarationAdapter.MyViewHolder> {
    Resources res;
    private Context mContext;
    private List<Declaration> declarationList;

    public DeclarationAdapter(Context mContext, List<Declaration> declarationList) {
        this.mContext = mContext;
        this.declarationList = declarationList;
    }

    @NonNull
    @Override
    public DeclarationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.declaration_list_layout, parent, false);
        return new DeclarationAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final DeclarationAdapter.MyViewHolder holder, int position) {

        res = holder.itemView.getContext().getResources();
        Declaration declaration = declarationList.get(position);
        if (declaration.getFarmerid() != null) {

            holder.farmerimg.setImageDrawable(AndroidUtils.arraytodrawable(AndroidUtils.loadFarmerImg(declaration.getFarmerid(), res), mContext));
            holder.transid.setText(declaration.getTransactionid());
            holder.totalcost.setText(res.getString(R.string.price_item, declaration.getTotalCost()));
            holder.agentid.setText(declaration.getAgentname());
            holder.bagspayable.setText(res.getString(R.string.expected, declaration.getNorecoverybags()));
            holder.datecreated.setText(AndroidUtils.dateToFormattedString(declaration.getDatecreated(), "dd MMM, yyyy"));
            holder.acreage.setText(res.getString(R.string.acre, declaration.getAcreage()));
            holder.status.setText(declaration.getStatus());
            holder.declaration.setText(declaration.getDeclaration());
            if (declaration.couponcode.equalsIgnoreCase("subsidized")) {
                holder.subsidized.setText("Yes");
            } else holder.subsidized.setText("No");
        }


    }

    @Override
    public int getItemCount() {
        return declarationList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView transid, totalcost, status, subsidized, declaration, agentid, acreage, bagspayable, datecreated;
        RelativeLayout tooltiplayout;
        LinearLayout tooltip1;

        CircleImageView farmerimg;

        public MyViewHolder(View view) {
            super(view);
            farmerimg = view.findViewById(R.id.farmerimg);
            declaration = view.findViewById(R.id.declaration);
            transid = view.findViewById(R.id.transid);
            farmerimg = view.findViewById(R.id.farmerimg);
            transid = view.findViewById(R.id.transid);
            totalcost = view.findViewById(R.id.cost);
            status = view.findViewById(R.id.status);
            subsidized = view.findViewById(R.id.sub);
            agentid = view.findViewById(R.id.agent);
            bagspayable = view.findViewById(R.id.bagspayable);
            acreage = view.findViewById(R.id.acreage);
            datecreated = view.findViewById(R.id.date);
            tooltiplayout = view.findViewById(R.id.tooltiplayout);
            tooltip1 = view.findViewById(R.id.tooltip1);
        }
    }

}