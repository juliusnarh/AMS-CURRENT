package com.telpo.usb.finger.inputdistributions_fragment;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentFaf3Binding;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_3_Pojo;
import com.telpo.usb.finger.utils.AndroidUtils;

import ivb.com.materialstepper.stepperFragment;

public class FAF_3Fragment extends stepperFragment {

    FragmentFaf3Binding binding;
    private final TextWatcher textWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {
            AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.FAFCOMMENT_PREF, new Gson().toJson(binding.getFaf3()));
        }
    };
    FAF_3_Pojo pojo;

    public FAF_3Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_faf_3, container, false);
        View view = binding.getRoot();
        pojo = new FAF_3_Pojo();
        binding.setFaf3(pojo);

        binding.comments.addTextChangedListener(textWatcher);
        return view;
    }

    @Override
    public boolean onNextButtonHandler() {

        return true;
    }

}
