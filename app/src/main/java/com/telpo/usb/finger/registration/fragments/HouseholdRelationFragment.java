package com.telpo.usb.finger.registration.fragments;


import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentHouseholdRelationBinding;
import com.telpo.usb.finger.utils.AndroidUtils;

import org.apache.commons.lang3.StringUtils;

import ivb.com.materialstepper.stepperFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HouseholdRelationFragment extends stepperFragment implements ListDialogFragment.OnListDialogItemSelect {


    FragmentHouseholdRelationBinding binding;
    ListDialogFragment dialogFragment;
    FragmentManager fm;
    String[] listitems;

    public HouseholdRelationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_household_relation, container, false);
        View view = binding.getRoot();

        binding.txtrelation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listitems = getResources().getStringArray(R.array.relationship);
                showOptionDialog(listitems, "Select Relationship Type", "relation");
            }
        });

        return view;
    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        fm = getChildFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    @Override
    public boolean onNextButtonHandler() {
        if (StringUtils.isNotEmpty(binding.txtrelation.getText().toString())) {
            binding.txtrelation.setError(null);
            AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.RELATEPREF, binding.txtrelation.getText().toString());
            return true;
        } else {
            binding.txtrelation.setError("Please make a selection");
            return false;
        }
    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("relation")) {
            binding.txtrelation.setText(selection);
        }
    }
}
