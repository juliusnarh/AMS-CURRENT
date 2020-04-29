package com.telpo.usb.finger.registration.fragments;


import android.app.DatePickerDialog;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentBasicInfoBinding;
import com.telpo.usb.finger.entities.Districts;
import com.telpo.usb.finger.entities.Regions;
import com.telpo.usb.finger.pojo.BasicRegistration;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import br.com.ilhasoft.support.validation.Validator;
import ivb.com.materialstepper.stepperFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicInfoFragment extends stepperFragment implements ListDialogFragment.OnListDialogItemSelect {

    FragmentBasicInfoBinding binding;
    BasicRegistration basicreg;
    Calendar cal = Calendar.getInstance();
    DatePickerDialog datePickerDialog;
    ListDialogFragment dialogFragment;
    FragmentManager fm;
    String[] listitems;
    String[] popupcomponent = {"maritalstatus", "region", "gender", "idcard", "nationality", "district"};
    String[] popuptitle = {"Select Marital Status", "Select Region", "Select Gender", "Select ID Type", "Select Country", "Select District"};
    Validator validator;
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, monthOfYear);
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "dd-MMM-yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            binding.bdate.setText(sdf.format(cal.getTime()));
            try {
                binding.age.setText("" + AndroidUtils.age(year, monthOfYear, dayOfMonth));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    String[] array;
    List<Regions> regions;
    String[] districtArray;

    public BasicInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // view = container;
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_basic_info, container, false);
        validator = new Validator(binding);

        basicreg = new BasicRegistration();
        binding.setBasicreg(basicreg);
        View view = binding.getRoot();
        binding.bdate.setOnClickListener(v -> showDatePicker());

        binding.edu.setOnClickListener(v -> {
            listitems = getResources().getStringArray(R.array.edulevel);
            showOptionDialog(listitems, "Level of Education", "edulevel");
        });
        binding.gender.setOnClickListener(v -> {
            listitems = getResources().getStringArray(R.array.genderitems);
            showOptionDialog(listitems, popuptitle[2], popupcomponent[2]);
        });
        binding.idtype.setOnClickListener(v -> {
            listitems = getResources().getStringArray(R.array.idtypes);
            showOptionDialog(listitems, popuptitle[3], popupcomponent[3]);
        });
        binding.country.setOnClickListener(v -> {
            listitems = getResources().getStringArray(R.array.countries);
            showOptionDialog(listitems, popuptitle[4], popupcomponent[4]);
        });
        binding.region.setOnClickListener(v -> {
            listitems = loadRegions();//getResources().getStringArray(R.array.regionlist);
            showOptionDialog(listitems, popuptitle[1], popupcomponent[1]);
        });
        binding.maritalstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listitems = getResources().getStringArray(R.array.maritalstatuss);
                showOptionDialog(listitems, popuptitle[0], popupcomponent[0]);
            }
        });
        binding.district.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listitems = loadDistricts(getRegionCode(binding.region.getText().toString().trim()));//getResources().getStringArray(R.array.district);
                showOptionDialog(listitems, popuptitle[5], popupcomponent[5]);
            }
        });
        return view;
    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
        }
    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        fm = getChildFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    public void showDatePicker() {
        datePickerDialog = new DatePickerDialog(getActivity(), date,
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    //method to retrieve region from the database
    public String[] loadRegions() {
        try {
            regions = Regions.listAll(Regions.class);
            array = new String[regions.size()];
            for (int i = 0; i < regions.size(); i++) {
                array[i] = regions.get(i).getRegion();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public String getRegionCode(String region) {
        try {
            regions = Regions.find(Regions.class, "region=?", region);
            if (regions.size() > 0) {
                return regions.get(0).getRegioncode();
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //method to select district based on region's selection
    public String[] loadDistricts(String regioncode) {
        try {
            List<Districts> districts = Districts.find(Districts.class, "regioncode=?", regioncode);
            districtArray = new String[districts.size()];
            for (int i = 0; i < districts.size(); i++) {
                districtArray[i] = districts.get(i).getDistrict();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return districtArray;
    }

    @Override
    public boolean onNextButtonHandler() {
        if (validator.validate()) {
            AndroidUtils.hideKeyboard(getActivity());
            AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.BASICINFOPREF, new Gson().toJson(binding.getBasicreg()));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("gender")) {
            binding.gender.setText(selection);
        } else if (componentname.equalsIgnoreCase("nationality")) {
            binding.country.setText(selection);
        } else if (componentname.equalsIgnoreCase("idcard")) {
            binding.idtype.setText(selection);
        } else if (componentname.equalsIgnoreCase("region")) {
            binding.region.setText(selection);
            binding.district.setText("");
        } else if (componentname.equalsIgnoreCase("maritalstatus")) {
            binding.maritalstatus.setText(selection);
        } else if (componentname.equalsIgnoreCase("district")) {
            binding.district.setText(selection);
        } else if (componentname.equalsIgnoreCase("edulevel")) {
            binding.edu.setText(selection);
        }
    }
}
