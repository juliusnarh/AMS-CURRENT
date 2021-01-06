package com.telpo.usb.finger.dialogforms;


import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.DialogPackagedetailsBinding;
import com.telpo.usb.finger.entities.PackageItemDetail;
import com.telpo.usb.finger.entities.Packages;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PackageDetailsDialog extends DialogFragment {

    DialogPackagedetailsBinding binding;

    public static String TAG = "FullScreenDialog";
    static Packages packages;

    public static PackageDetailsDialog newInstance(Packages pack) {
        PackageDetailsDialog dialog = new PackageDetailsDialog();
        packages = pack;
        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new Dialog(requireActivity(), getTheme()) {
            @Override
            public void onBackPressed() {
                dismiss();
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_packagedetails, container, false);
        View view = binding.getRoot();
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.packageid.setText(packages.getPackageid());
        binding.packname.setText(packages.getPackagename().toUpperCase());
        binding.noofitems.setText(packages.getNumberofitems());
        binding.close.setOnClickListener(v->dismiss());

        List<PackageItemDetail> detailList = PackageItemDetail.find(PackageItemDetail.class, "packageid = ?", packages.getPackageid());
        binding.recycler.setAdapter(new PackageDetailsAdapter(detailList));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().getAttributes().windowAnimations = R.style.traininganimate;
            dialog.getWindow().setLayout(width, height);
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView ordername;
        TextView quantity;
        TextView orderamount;
        TextView number;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.item_details_list, parent, false));
            ordername = itemView.findViewById(R.id.order_name);
            quantity = itemView.findViewById(R.id.quantity);
            orderamount = itemView.findViewById(R.id.order_amount);
            number = itemView.findViewById(R.id.number);
        }

    }

    private class PackageDetailsAdapter extends RecyclerView.Adapter<ViewHolder> {

        List<PackageItemDetail> detailList;

        PackageDetailsAdapter(List<PackageItemDetail> itemDetails) {
            detailList = itemDetails;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            PackageItemDetail detail = detailList.get(position);
            Resources res = holder.itemView.getResources();
            String temp = (position + 1) + ".";
            holder.number.setText(temp);
            holder.ordername.setText(detail.getInputname());
            holder.quantity.setText(res.getString(R.string.xquantity, detail.getQuantity()));
            holder.orderamount.setText(res.getString(R.string.price_item, detail.getPrice()));
        }

        @Override
        public int getItemCount() {
            return detailList.size();
        }

    }
}
