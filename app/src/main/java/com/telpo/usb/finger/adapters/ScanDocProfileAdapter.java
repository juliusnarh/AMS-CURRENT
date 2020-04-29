package com.telpo.usb.finger.adapters;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.databinding.ScandocProfileItemLayoutBinding;
import com.telpo.usb.finger.entities.SupportDocs;

import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * Created by Junior on 1/11/2018.
 */

public class ScanDocProfileAdapter extends RecyclerView.Adapter<ScanDocProfileAdapter.MyViewHolder> {
    ScandocProfileItemLayoutBinding databinding;
    private List<SupportDocs> docsList;
    private Context context;
    private LayoutInflater inflater;
    private FragmentManager fragmentManager;


    public ScanDocProfileAdapter(List<SupportDocs> docsList, Context context) {
        this.context = context;
        this.docsList = docsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        databinding = ScandocProfileItemLayoutBinding.inflate(inflater, parent, false);
        return new MyViewHolder(databinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final SupportDocs docs = docsList.get(position);
        holder.bind(docs);

        databinding.btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                docsList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, docsList.size());

                Toasty.success(context, "Inventory successfully removed").show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return docsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ScandocProfileItemLayoutBinding databinding;

        MyViewHolder(ScandocProfileItemLayoutBinding databinding) {
            super(databinding.getRoot());
            this.databinding = databinding;
            databinding.executePendingBindings();
        }

        public void bind(SupportDocs registy) {
            this.databinding.setScan(registy);
        }

        public ScandocProfileItemLayoutBinding getDatabinding() {
            return databinding;
        }
    }
}
