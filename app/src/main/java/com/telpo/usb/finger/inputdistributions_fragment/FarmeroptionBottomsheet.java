package com.telpo.usb.finger.inputdistributions_fragment;


import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.FarmerTransaction;
import com.telpo.usb.finger.activities.input.distribution.FarmAssessmentForm;
import com.telpo.usb.finger.activities.input.distribution.InputDistMainActivity;
import com.telpo.usb.finger.activities.input.distribution.RecoveryActivity;
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.databinding.FarmerBottomsheetBinding;
import com.telpo.usb.finger.dialogforms.AssignFarmerToAggregatorDialog;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FarmeroptionBottomsheet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FarmeroptionBottomsheet extends BottomSheetDialogFragment implements View.OnClickListener, AssignFarmerToAggregatorDialog.AssignToAggClickListener {
    private static final String ARG_PARAM1 = "param1";
    FarmerBottomsheetBinding binding;
    // TODO: Rename and change types of parameters
    private String farmerid;

    public FarmeroptionBottomsheet() {
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
    public static FarmeroptionBottomsheet newInstance(String param1) {
        FarmeroptionBottomsheet fragment = new FarmeroptionBottomsheet();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.farmer_bottomsheet, container, false);
        View view = binding.getRoot();
        binding.content.setText(getResources().getString(R.string.farmeroptions, farmerid));

        binding.profile.setOnClickListener(this);

        binding.distribution.setOnClickListener(this);

        binding.recovery.setOnClickListener(this);

        binding.extservices.setOnClickListener(this);

        binding.purchases.setOnClickListener(this);

        binding.farmassessment.setOnClickListener(this);

        binding.alltransactions.setOnClickListener(this);

        binding.assignToAggregator.setOnClickListener(this);
        return view;
    }

    //method to load profile page
    public void loadFarmerProfile(String farmerid) {
        Intent intent = new Intent(getContext(), ProfileActivity.class);
        intent.putExtra("farmerid", farmerid);
        this.startActivity(intent);
//        finish();
    }

    private void loadInputDistribution(String farmer_id) {
        Intent intent = new Intent(getContext(), InputDistMainActivity.class);
        intent.putExtra("farmerid", farmer_id);
        intent.putExtra("type", "0");
        getContext().startActivity(intent);
    }

    private void loadRecovery(String farmer_id) {
        Intent intent = new Intent(getContext(), RecoveryActivity.class);
        intent.putExtra("farmerid", farmer_id);
        intent.putExtra("type", "0");
        getContext().startActivity(intent);
    }

    private void loadPurchases(String farmer_id) {
        Intent intent = new Intent(getContext(), RecoveryActivity.class);
        intent.putExtra("farmerid", farmer_id);
        intent.putExtra("type", "1");
        getContext().startActivity(intent);
    }

    private void loadFarmAssessment(String farmerid) {
        Intent intent = new Intent(getContext(), FarmAssessmentForm.class);
        intent.putExtra("farmerid", farmerid);
        getContext().startActivity(intent);
    }

    private void loadAllTransactions(String farmerid) {
        Intent intent = new Intent(getContext(), FarmerTransaction.class);
        intent.putExtra("farmerid", farmerid);
        getContext().startActivity(intent);
    }

    private void loadExtservices(String farmerid) {
        Intent intent = new Intent(getContext(), InputDistMainActivity.class);
        intent.putExtra("farmerid", farmerid);
        intent.putExtra("type", "1");
        getContext().startActivity(intent);
    }

    private void loadAssignFarmer(String farmerid) {
        AssignFarmerToAggregatorDialog bottomsheet = AssignFarmerToAggregatorDialog.newInstance(this, farmerid);
        bottomsheet.show(getFragmentManager(), bottomsheet.getTag());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profile:
                loadFarmerProfile(farmerid);
                break;
            case R.id.distribution:
                loadInputDistribution(farmerid);
                break;
            case R.id.recovery:
                loadRecovery(farmerid);
                break;
            case R.id.extservices:
                loadExtservices(farmerid);
                break;
            case R.id.purchases:
                loadPurchases(farmerid);
                break;
            case R.id.farmassessment:
                loadFarmAssessment(farmerid);
                break;
            case R.id.alltransactions:
                loadAllTransactions(farmerid);
                break;
            case R.id.assign_to_aggregator:
                loadAssignFarmer(farmerid);
                break;
        }
    }

    @Override
    public void onAssignToAggClickListener(String aggregatorid) {

    }
}
