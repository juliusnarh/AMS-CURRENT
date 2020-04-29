package com.telpo.usb.finger.inputdistributions_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.FarmerSearchAggregatorActivity;
import com.telpo.usb.finger.activities.FarmerTransaction;
import com.telpo.usb.finger.activities.input.distribution.FarmAssessmentForm;
import com.telpo.usb.finger.activities.input.distribution.InputDistMainActivity;
import com.telpo.usb.finger.activities.input.distribution.RecoveryActivity;
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.adapters.AggregatorSearchAdapter;
import com.telpo.usb.finger.databinding.FarmerBottomsheetBinding;
import com.telpo.usb.finger.databinding.FarmerSearchAggBottomsheetBinding;
import com.telpo.usb.finger.entities.Aggregator;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchByAggBottomsheet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchByAggBottomsheet extends BottomSheetDialogFragment implements AggregatorSearchAdapter.AggregatorSearchAdapterListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String AGGREGATOR_ID = "aggregatorid";
    FarmerSearchAggBottomsheetBinding binding;
    AggregatorSearchAdapter mAdapter;
    List<Aggregator> aggregatorList = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String farmerid;

    public SearchByAggBottomsheet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchByAggBottomsheet newInstance(String param1) {
        SearchByAggBottomsheet fragment = new SearchByAggBottomsheet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            farmerid = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public int getTheme() {
        return R.style.BaseBottomSheetDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.farmer_search_agg_bottomsheet, container, false);

        aggregatorList = Aggregator.listAll(Aggregator.class);
        mAdapter = new AggregatorSearchAdapter(getContext(), aggregatorList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(mLayoutManager);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        binding.recyclerView.setAdapter(mAdapter);

        return binding.getRoot();
    }

    @Override
    public void onAggregatorSelected(String aggregatorid) {
        Intent intent = new Intent(getActivity(), FarmerSearchAggregatorActivity.class);
        intent.putExtra(AGGREGATOR_ID, aggregatorid);
        startActivity(intent);
        dismiss();
    }
}
