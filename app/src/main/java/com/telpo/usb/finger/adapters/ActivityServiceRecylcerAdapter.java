package com.telpo.usb.finger.adapters;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.databinding.ActivityDataBinding;
import com.telpo.usb.finger.editfragments.EditActivityProfileFragment;
import com.telpo.usb.finger.entities.ActivityInfo;

import java.util.List;

/**
 * Created by Junior on 12/24/2017.
 */

public class ActivityServiceRecylcerAdapter extends RecyclerView.Adapter<ActivityServiceRecylcerAdapter.RecyclerViewHolder> {
    FragmentManager fragmentManager;
    private Context context;
    private List<ActivityInfo> activitylist;
    private LayoutInflater inflater;

    public ActivityServiceRecylcerAdapter(Context context, List<ActivityInfo> activitylist, FragmentManager fragmentManager) {
        this.context = context;
        this.activitylist = activitylist;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ActivityDataBinding binding = ActivityDataBinding.inflate(inflater, parent, false);
        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final ActivityInfo activityInfo = activitylist.get(position);
        holder.bind(activityInfo);

        final ActivityDataBinding binding = holder.getDataBinding();
        binding.activityedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    EditActivityProfileFragment.newInstance(activityInfo.getUniqueuid()).show(fragmentManager, "Dialog Fragment");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return activitylist.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ActivityDataBinding dataBinding;

        public RecyclerViewHolder(ActivityDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        public void bind(ActivityInfo activityInfo) {
            this.dataBinding.setActivity(activityInfo);
        }

        public ActivityDataBinding getDataBinding() {
            return dataBinding;
        }
    }
}
