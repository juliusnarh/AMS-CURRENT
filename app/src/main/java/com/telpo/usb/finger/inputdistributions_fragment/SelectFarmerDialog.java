package com.telpo.usb.finger.inputdistributions_fragment;


import android.app.Dialog;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.SelectFarmerAdapter;
import com.telpo.usb.finger.databinding.DialogSelectAggregatorBinding;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.interfaces.SaveSelectedFarmersClickListener;
import com.telpo.usb.finger.interfaces.SelectedFarmerClickListener;
import com.telpo.usb.finger.utils.MyDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFarmerDialog extends DialogFragment implements SelectedFarmerClickListener {

    private static final String ARG_PARAM1 = "param1";
    public static String TAG = "SelectAggregatorDialog";
    public static SaveSelectedFarmersClickListener listener;
    DialogSelectAggregatorBinding binding;
    List<Farmers> selectedFarmerList;
    private String mParam1;

    public static SelectFarmerDialog newInstance(String eventtype, SaveSelectedFarmersClickListener clickListener) {
        SelectFarmerDialog dialog = new SelectFarmerDialog();
        listener = clickListener;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, eventtype);
        dialog.setArguments(args);
        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new Dialog(getActivity(), getTheme()) {
            @Override
            public void onBackPressed() {
                dismiss();
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_select_aggregator, container, false);
        View view = binding.getRoot();
        selectedFarmerList = new ArrayList<>();
        List<Farmers> list = Farmers.listAll(Farmers.class);
        if (list.size() > 0)
            binding.norecord.setVisibility(View.GONE);
        else binding.norecord.setVisibility(View.VISIBLE);
        SelectFarmerAdapter adapter = new SelectFarmerAdapter(getContext(), list, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        binding.recycler.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        binding.recycler.setLayoutManager(mLayoutManager);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(adapter);
        binding.close.setOnClickListener(v -> dismiss());
        binding.save.setOnClickListener(v -> {
            if (selectedFarmerList.size() > 0)
                listener.onSaveSelectedFarmersClickListener(selectedFarmerList);
            else
                Toasty.warning(getContext(), "Please select an Aggregator").show();
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        dialog.setCancelable(false);
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().getAttributes().windowAnimations = R.style.animate;
            dialog.getWindow().setLayout(width, height);
        }
    }


    @Override
    public void onSelectedFarmerClickListener(Farmers farmers, int action) {
        if (action == 1) {
            selectedFarmerList.add(farmers);
            binding.numberselected.setText(getResources().getString(R.string.numberselected, selectedFarmerList.size()));
            binding.numberselected.setVisibility(View.VISIBLE);
        } else {
            try {
                selectedFarmerList.remove(farmers);
                binding.numberselected.setText(getResources().getString(R.string.numberselected, selectedFarmerList.size()));
                if (selectedFarmerList.size() > 0) {
                    binding.numberselected.setVisibility(View.VISIBLE);
                } else binding.numberselected.setVisibility(View.INVISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
