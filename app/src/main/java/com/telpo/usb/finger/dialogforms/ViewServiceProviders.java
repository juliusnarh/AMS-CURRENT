package com.telpo.usb.finger.dialogforms;


import android.app.Dialog;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentViewServiceProvidersBinding;

import br.com.ilhasoft.support.validation.Validator;


public class ViewServiceProviders extends DialogFragment {
    /**
     * FOR THE DISAGGREGATION FIELD USE THE MATERIAL DIALOG TO SHOW CHECK BOX OPTIONS THEN USE CHIPS TO SHOW SELECTED RESULTS ON MAIN FORM
     */
    public static String TAG = "FullScreenDialog";
    Validator validator;
    FragmentViewServiceProvidersBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_service_providers, container, false);
        View view = binding.getRoot();
        validator = new Validator(binding);


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
}