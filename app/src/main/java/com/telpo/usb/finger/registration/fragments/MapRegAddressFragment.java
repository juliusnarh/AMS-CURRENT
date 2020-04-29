package com.telpo.usb.finger.registration.fragments;


import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentMapRegAddressBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapRegAddressFragment extends Fragment {

    FragmentMapRegAddressBinding binding;

    public MapRegAddressFragment() {
        // Required empty public constructor
    }

    public static MapRegAddressFragment newInstance(String text) {
        MapRegAddressFragment f = new MapRegAddressFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map_reg_address, container, false);
        View view = binding.getRoot();


        return view;
    }

//    @Override
//    public boolean onNextButtonHandler() {
//        return true;
//    }
}
