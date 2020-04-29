package com.telpo.usb.finger.registration.fragments;


import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentFarmerActivityInfoBinding;
import com.telpo.usb.finger.pojo.ActivityInfoPojo;
import com.telpo.usb.finger.utils.AndroidUtils;

import ivb.com.materialstepper.stepperFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FarmerActivityInfoFragment extends stepperFragment implements ListDialogFragment.OnListDialogItemSelect {

    FragmentFarmerActivityInfoBinding binding;
    ActivityInfoPojo activityInfoPojo;
    ListDialogFragment dialogFragment;
    FragmentManager fm;
    String[] array;

    public FarmerActivityInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_farmer_activity_info, container, false);
        View view = binding.getRoot();
        activityInfoPojo = new ActivityInfoPojo();
        binding.setActivity(activityInfoPojo);
        binding.specialtycocoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.cocoaspecialtylist, "Select Specialty Crop", "specialty");
            }
        });
        binding.certification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.certificationlist, "Select Certification Type", "certification");
            }
        });
        binding.fundingsource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.sourceoffunds, "Select Funding Source", "fundingsource");
            }
        });
        return view;
    }


    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            try {
                binding.boolcincome.setChecked(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showOptionDialog(int id, String title, String componentname) {
        array = getResources().getStringArray(id);
        fm = getChildFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    @Override
    public boolean onNextButtonHandler() {
        AndroidUtils.hideKeyboard(getActivity());
        AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.ACTIVITYINFOPREF, new Gson().toJson(binding.getActivity()));
        return true;
    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("fundingsource")) {
            binding.fundingsource.setText(selection);
        } else if (componentname.equalsIgnoreCase("certification")) {
            binding.certification.setText(selection);
        } else if (componentname.equalsIgnoreCase("specialty")) {
            binding.specialtycocoa.setText(selection);
        }
    }
}
