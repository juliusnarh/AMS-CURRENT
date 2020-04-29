package com.telpo.usb.finger.registration.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.R;

import ivb.com.materialstepper.stepperFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactInfoFragment extends stepperFragment {


    public ContactInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_info, container, false);
    }

    //method to hide softkeyboard


    @Override
    public boolean onNextButtonHandler() {
        return true;
    }
}
