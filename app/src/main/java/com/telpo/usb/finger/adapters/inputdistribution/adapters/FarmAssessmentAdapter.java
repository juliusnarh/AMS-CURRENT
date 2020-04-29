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
import com.telpo.usb.finger.entities.FarmAssessment;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FarmAssessmentAdapter extends RecyclerView.Adapter<FarmAssessmentAdapter.MyViewHolder> {
    Resources res;
    private Context mContext;
    private List<FarmAssessment> assessmentList;

    public FarmAssessmentAdapter(Context mContext, List<FarmAssessment> assessmentList) {
        this.mContext = mContext;
        this.assessmentList = assessmentList;
    }

    @NonNull
    @Override
    public FarmAssessmentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.farmassessment_list_layout, parent, false);
        return new FarmAssessmentAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final FarmAssessmentAdapter.MyViewHolder holder, final int position) {
        res = mContext.getResources();
        FarmAssessment assessment = assessmentList.get(position);

        if (assessment != null) {
            holder.farmerimg.setImageDrawable(AndroidUtils.arraytodrawable(AndroidUtils.loadFarmerImg(assessment.getFarmerid(), res), mContext));
            holder.farmimg.setImageDrawable(AndroidUtils.arraytodrawable(assessment.getFarmimg(), mContext));
            holder.farmerid.setText(assessment.getFarmerid());
            holder.farmid.setText(assessment.getFarmid());
            holder.dop.setText(AndroidUtils.dateToFormattedString(assessment.getDateplanted(), "dd-MM-yyyy"));

            if (assessment.getComments().isEmpty()) {
                holder.comments.setText("N/A");
            } else holder.comments.setText(assessment.getComments());

            holder.cropvariety.setText(assessment.getCropvariety());

            if (assessment.getFertilizername().isEmpty() || assessment.getFertilizername() == null) {
                holder.fertilizer.setText("N/A");
                holder.fertilizerdate.setText("N/A");
            } else {
                holder.fertilizer.setText(assessment.getFertilizername());
                holder.fertilizerdate.setText(AndroidUtils.dateToFormattedString(assessment.getFertilizerdate(), "dd-MM-yyyy"));
            }

            if (assessment.getCropprotection().isEmpty() || assessment.getCropprotection() == null) {
                holder.cropprotection.setText("N/A");
                holder.cropprotectiondate.setText("N/A");
            } else {
                holder.cropprotection.setText(assessment.getCropprotection());
                holder.cropprotectiondate.setText(AndroidUtils.dateToFormattedString(assessment.getCropprotectiondate(), "dd-MM-yyyy"));
            }

            holder.cropstage.setText(assessment.getStageofcrop());
            holder.longitude.setText(assessment.getFarmlong());
            holder.latitude.setText(assessment.getFarmlat());
        }

    }

    @Override
    public int getItemCount() {
        return assessmentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView farmerid, farmid, comments, dop, cropvariety, fertilizer, fertilizerdate, cropprotection, cropprotectiondate, cropstage, longitude, latitude;

        CircleImageView farmerimg, farmimg;

        public MyViewHolder(View view) {
            super(view);
            farmerimg = view.findViewById(R.id.farmerimg);
            farmimg = view.findViewById(R.id.farmimg);
            farmerid = view.findViewById(R.id.farmerid);
            farmid = view.findViewById(R.id.farmid);
            comments = view.findViewById(R.id.comments);
            dop = view.findViewById(R.id.dop);
            cropvariety = view.findViewById(R.id.cropvariety);
            fertilizer = view.findViewById(R.id.fertilizer);
            fertilizerdate = view.findViewById(R.id.fertilizerdate);
            cropprotection = view.findViewById(R.id.cropprotection);
            cropprotectiondate = view.findViewById(R.id.cropprotectiondate);
            cropstage = view.findViewById(R.id.cropstage);
            longitude = view.findViewById(R.id.longitude);
            latitude = view.findViewById(R.id.latitude);
        }
    }
}
