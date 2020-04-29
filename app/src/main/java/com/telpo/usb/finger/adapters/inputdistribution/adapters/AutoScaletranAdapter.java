package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.List;

public class AutoScaletranAdapter extends RecyclerView.Adapter<AutoScaletranAdapter.MyViewHolder> {
    public List<Scaletran> scaletranList;
    Resources res;
    private Context mContext;

    public AutoScaletranAdapter(Context mContext, List<Scaletran> scaletranList) {
        this.mContext = mContext;
        this.scaletranList = scaletranList;
    }

    @NonNull
    @Override
    public AutoScaletranAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.autoscale_item, parent, false);
        return new AutoScaletranAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final AutoScaletranAdapter.MyViewHolder holder, final int position) {
        res = holder.itemView.getContext().getResources();
        Scaletran scaletran = scaletranList.get(position);
        if (scaletran.getFarmerid() != null) {
            if (scaletran.getTransid().isEmpty()) {
                holder.transid.setText("n/a");
            } else {
                holder.transid.setText(scaletran.transid);
            }
            holder.tweight.setText(res.getString(R.string.weight, scaletran.getWeight()));
            holder.count.setText(res.getString(R.string.price, scaletran.getCount()));
            holder.time.setText(AndroidUtils.dateToFormattedString(scaletran.getTime(), "hh:mm:ss"));
            holder.pcid.setText(scaletran.getPcid());
            holder.aveweight.setText(res.getString(R.string.weight, (scaletran.getWeight() / scaletran.getCount())));
            holder.scaleid.setText(scaletran.getScaleid());
            holder.date.setText(AndroidUtils.dateToFormattedString(scaletran.getDate(), "yyyy-MM-dd"));
            holder.bcid.setText(scaletran.getBcid());
        }

    }

    @Override
    public int getItemCount() {
        return scaletranList.size();
    }

    public void addtransaction(Scaletran scaletran) {
        scaletranList.add(scaletran);
        notifyItemInserted(scaletranList.indexOf(scaletran));
//        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView transid, tweight, count, time, pcid, aveweight, scaleid, date, bcid;

        public MyViewHolder(View view) {
            super(view);
            transid = view.findViewById(R.id.transid);
            tweight = view.findViewById(R.id.tweight);
            count = view.findViewById(R.id.count);
            time = view.findViewById(R.id.time);
            pcid = view.findViewById(R.id.pcid);
            aveweight = view.findViewById(R.id.aveweight);
            scaleid = view.findViewById(R.id.scaleid);
            date = view.findViewById(R.id.date);
            bcid = view.findViewById(R.id.bcid);
        }
    }
}
