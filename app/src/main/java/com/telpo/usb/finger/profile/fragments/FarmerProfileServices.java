package com.telpo.usb.finger.profile.fragments;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silencedut.expandablelayout.ExpandableLayout;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.ActivityServiceRecylcerAdapter;
import com.telpo.usb.finger.adapters.FarmServiceRecylcerAdapter;
import com.telpo.usb.finger.databinding.FragmentFarmerProfileServicesBinding;
import com.telpo.usb.finger.entities.ActivityInfo;
import com.telpo.usb.finger.entities.Farms;
import com.telpo.usb.finger.entities.LocationCoordinates;
import com.telpo.usb.finger.pojo.FarmGeoInfo;
import com.telpo.usb.finger.pojo.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class FarmerProfileServices extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EventBus bus = EventBus.getDefault();
    FragmentFarmerProfileServicesBinding binding;
    ActivityServiceRecylcerAdapter activityadapter;
    FarmServiceRecylcerAdapter farmadapter;
    List<ActivityInfo> activitylist;
    List<FarmGeoInfo> farmsList;
    FarmGeoInfo geoInfo;
    private String farmerid;
    private String mParam2;

    public FarmerProfileServices() {
    }

    public static FarmerProfileServices newInstance(String farmerid) {
        FarmerProfileServices fragment = new FarmerProfileServices();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, farmerid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            farmerid = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_farmer_profile_services, container, false);
        View view = binding.getRoot();
        bus.register(this);

        activitylist = loadAllFarmerActivities();
        binding.activitystats.setText(activitylist.size() + " Registered");
        binding.activityRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.activityRecyclerview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        activityadapter = new ActivityServiceRecylcerAdapter(getContext(), activitylist, getChildFragmentManager());
        binding.activityRecyclerview.setAdapter(activityadapter);

        farmsList = loadAllFarmInfo();
        binding.farmstats.setText(farmsList.size() + " Registered");
        binding.farmRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.farmRecyclerview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        farmadapter = new FarmServiceRecylcerAdapter(getContext(), farmsList, getChildFragmentManager());
        binding.farmRecyclerview.setAdapter(farmadapter);

        binding.addactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FragmentManager fm = getChildFragmentManager();
                    AddAnotherActivity.newInstance(farmerid).show(fm, "Dialog Fragment");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        binding.addfarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FragmentManager fm = getChildFragmentManager();
                    AddAnotherFarm.newInstance(farmerid).show(fm, "Dialog Fragment");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        binding.expandableLayout1.setOnExpandListener(new ExpandableLayout.OnExpandListener() {
            @Override
            public void onExpand(boolean expanded) {
                if (expanded) {
                    binding.activityarrow.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_up));
                } else {
                    binding.activityarrow.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_down));
                }
            }
        });

        binding.expandableLayout2.setOnExpandListener(new ExpandableLayout.OnExpandListener() {
            @Override
            public void onExpand(boolean expanded) {
                if (expanded) {
                    binding.farmarrow.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_up));
                } else {
                    binding.farmarrow.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_down));
                }

            }
        });

        return view;
    }

    @Subscribe
    public void onEvent(MessageEvent event) {
        System.out.println("Event Received: " + event.getMessage() + " Action: " + event.getAction());
        if (event.getAction().equalsIgnoreCase("reload")) {
            if (event.getMessage().equalsIgnoreCase("activity")) {
                activitylist.clear();
                activityadapter = new ActivityServiceRecylcerAdapter(getContext(), activitylist, getChildFragmentManager());
                activitylist = loadAllFarmerActivities();
                binding.activitystats.setText(activitylist.size() + " Registered");
                activityadapter = new ActivityServiceRecylcerAdapter(getContext(), activitylist, getChildFragmentManager());
                binding.activityRecyclerview.setAdapter(activityadapter);
            } else if (event.getMessage().equalsIgnoreCase("farm")) {
                farmsList.clear();
                farmadapter = new FarmServiceRecylcerAdapter(getContext(), farmsList, getChildFragmentManager());
                farmsList = loadAllFarmInfo();
                binding.farmstats.setText(farmsList.size() + " Registered");
                farmadapter = new FarmServiceRecylcerAdapter(getContext(), farmsList, getChildFragmentManager());
                binding.farmRecyclerview.setAdapter(farmadapter);
            }
        }
    }

    //method to load all activities for farmer
    public List<ActivityInfo> loadAllFarmerActivities() {
        try {
            return ActivityInfo.find(ActivityInfo.class, "farmerid = ?", farmerid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    //method to load farm information
    public List<FarmGeoInfo> loadAllFarmInfo() {
        farmsList = new ArrayList<>();
        try {
            List<Farms> farms = Farms.find(Farms.class, "farmerid = ?", farmerid);
            for (Farms farm : farms) {
                geoInfo = new FarmGeoInfo();
                geoInfo.setFarms(farm);
                geoInfo.setLoccords(getFarmCoords(farm.getFarmerid(), farm.getFarmid()));
                farmsList.add(geoInfo);
            }
            return farmsList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    //method to load farmgeographic information
    public LocationCoordinates getFarmCoords(String farmerid, String farmid) {
        List<LocationCoordinates> coords = LocationCoordinates.find(LocationCoordinates.class, "farmerid = ? and " +
                "locationtype=? and farmid=?", farmerid, "Farm Address", farmid);
        if (coords != null && !coords.isEmpty()) {
            return coords.get(0);
        }
        return new LocationCoordinates();
    }
}
