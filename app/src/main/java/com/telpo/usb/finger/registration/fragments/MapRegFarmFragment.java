package com.telpo.usb.finger.registration.fragments;


import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentMapRegFarmBinding;
import com.telpo.usb.finger.pojo.CoordinateModel;
import com.telpo.usb.finger.pojo.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapRegFarmFragment extends Fragment {

    ArrayList<CoordinateModel> itemCoordinateModelList;
    CustomAdapter customAdapter;
    FragmentMapRegFarmBinding binding;
    CoordinateModel md;
    EventBus bus = EventBus.getDefault();


    public MapRegFarmFragment() {
        // Required empty public constructor
    }

    public static MapRegFarmFragment newInstance(String text) {
        MapRegFarmFragment f = new MapRegFarmFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map_reg_farm, container, false);
        View v = binding.getRoot();

        itemCoordinateModelList = new ArrayList<>();
        customAdapter = new CustomAdapter(getContext(), itemCoordinateModelList);
        binding.listview.setAdapter(customAdapter);
        binding.btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String lat = binding.latupdate.getText().toString();
                    String longt = binding.longupdate.getText().toString();
                    if (!lat.isEmpty() || !longt.isEmpty()) {
                        md = new CoordinateModel(lat, longt);
                        itemCoordinateModelList.add(md);
                        customAdapter.notifyDataSetChanged();
                        bus.post(new MessageEvent("addmarker", lat + "#" + longt));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        binding.btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(new MessageEvent("clearmarkers", ""));
                itemCoordinateModelList.clear();
                customAdapter.notifyDataSetChanged();
            }
        });

        binding.btnplot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(new MessageEvent("plotpolygon", ""));
            }
        });


        return v;
    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {

        }
    }
}
