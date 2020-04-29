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
import com.telpo.usb.finger.databinding.FragmentFarmInfoBinding;
import com.telpo.usb.finger.pojo.FarmRegistrationPojo;
import com.telpo.usb.finger.utils.AndroidUtils;

import ivb.com.materialstepper.stepperFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FarmInfoFragment extends stepperFragment implements ListDialogFragment.OnListDialogItemSelect {

    FragmentFarmInfoBinding binding;
    FarmRegistrationPojo farmpojo;
    ListDialogFragment dialogFragment;
    String[] array;
    FragmentManager fm;

    public FarmInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_farm_info, container, false);
        farmpojo = new FarmRegistrationPojo();
        binding.setFarmreg(farmpojo);

        View view = binding.getRoot();

        binding.txtregion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.regionlist, "Select Region", "region");
            }
        });
        binding.ownership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.ownershipsource, "Select Ownership Source", "ownershipsource");
            }
        });
        binding.cocoatype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.cocoatype, "Select Cocoa Type", "cocoatype");
            }
        });
        binding.materialsource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.plantingmaterialsource, "Select Labour Source", "materialsource");
            }
        });
        binding.laborsource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.laboursource, "Select Material Source", "laboursource");
            }
        });
        binding.provideorg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.provideingorg, "Select Providing Organization", "provorg");

            }
        });
        binding.district.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.district, "Select District", "district");
            }
        });


        return view;
    }

    private void showOptionDialog(int id, String title, String componentname) {
        array = getResources().getStringArray(id);
        fm = getChildFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }


    @Override
    public boolean onNextButtonHandler() {
        AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.FARMREGPREF, new Gson().toJson(binding.getFarmreg()));
        return true;
    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("ownershipsource")) {
            binding.ownership.setText(selection);
        } else if (componentname.equalsIgnoreCase("cocoatype")) {
            binding.cocoatype.setText(selection);
        } else if (componentname.equalsIgnoreCase("materialsource")) {
            binding.materialsource.setText(selection);
        } else if (componentname.equalsIgnoreCase("laboursource")) {
            binding.laborsource.setText(selection);
        } else if (componentname.equalsIgnoreCase("provorg")) {
            binding.provideorg.setText(selection);
        } else if (componentname.equalsIgnoreCase("district")) {
            binding.district.setText(selection);
        } else if (componentname.equalsIgnoreCase("region")) {
            binding.txtregion.setText(selection);
        }
    }
}
