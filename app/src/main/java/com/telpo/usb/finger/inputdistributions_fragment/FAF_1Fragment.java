package com.telpo.usb.finger.inputdistributions_fragment;

import android.app.DatePickerDialog;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.DatePicker;

import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentFaf1Binding;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_1_Pojo;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import br.com.ilhasoft.support.validation.Validator;
import ivb.com.materialstepper.stepperFragment;

public class FAF_1Fragment extends stepperFragment implements ListDialogFragment.OnListDialogItemSelect {
    static String farmer_id;
    Calendar cal = Calendar.getInstance();
    DatePickerDialog datePickerDialog;
    FragmentFaf1Binding binding;
    FAF_1_Pojo faf_1_pojo;
    Validator validator;
    String[] farmList;
    ListDialogFragment dialogFragment;
    String farm_id;
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, monthOfYear);
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "dd-MMM-yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            binding.datePlanted.setText(sdf.format(cal.getTime()));
        }
    };

    public FAF_1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_faf_1, container, false);
        View view = binding.getRoot();
        validator = new Validator(binding);
        faf_1_pojo = new FAF_1_Pojo();
        binding.setFaf1(faf_1_pojo);
        farmer_id = AndroidUtils.getPreferenceData(getActivity(), AndroidUtils.FAFFARMERID_PREF, "");
        Log.d("FARMERID: ", farmer_id);

        farmList = AndroidUtils.loadFarms(farmer_id);
        binding.selectFarm.setOnClickListener(v -> showOptionDialog(farmList, "Select Farm", "selectFarm"));
        binding.datePlanted.setOnClickListener(v -> showDatePicker());


        return view;
    }

    public void showDatePicker() {
        datePickerDialog = new DatePickerDialog(getActivity(), date,
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    @Override
    public boolean onNextButtonHandler() {
        if (validator.validate()) {
            AndroidUtils.hideKeyboard(getActivity());
            AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.FAFCROPINFO_PREF, new Gson().toJson(binding.getFaf1()));
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("selectFarm")) {
            binding.selectFarm.setText(selection);
            farm_id = selection;
            String[] farminfo = AndroidUtils.loadSingleFarm(farm_id);
            if (farminfo[0] != null && farminfo[1] != null)
                binding.maincropValue.setText(getString(R.string.actual_crop_name, farminfo[0], farminfo[1]));
            else if (farminfo[0] == null && farminfo[1] != null)
                binding.maincropValue.setText(getString(R.string.actual_crop_name, "", farminfo[1]));
            else if (farminfo[0] != null && farminfo[1] == null)
                binding.maincropValue.setText(getString(R.string.actual_crop_name, farminfo[0], ""));

        }
    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        FragmentManager fm = getChildFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }
}
