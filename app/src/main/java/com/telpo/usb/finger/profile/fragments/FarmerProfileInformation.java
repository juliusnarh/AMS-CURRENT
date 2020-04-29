package com.telpo.usb.finger.profile.fragments;

import android.content.Context;
import android.content.Intent;
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
import com.telpo.usb.finger.activities.profile.ResidentialMapActivity;
import com.telpo.usb.finger.activities.registration.HouseholdSearchActivity;
import com.telpo.usb.finger.adapters.HouseholdProfileRecylcerAdapter;
import com.telpo.usb.finger.adapters.ScanDocProfileAdapter;
import com.telpo.usb.finger.databinding.FragmentFarmerProfileSummaryBinding;
import com.telpo.usb.finger.editfragments.EditPersonalProfileFragment;
import com.telpo.usb.finger.editfragments.EditSupportDocs;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Household;
import com.telpo.usb.finger.entities.LocationCoordinates;
import com.telpo.usb.finger.entities.SupportDocs;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.pojo.BasicRegistration;
import com.telpo.usb.finger.pojo.BiometricsTaken;
import com.telpo.usb.finger.pojo.FarmerRegisty;
import com.telpo.usb.finger.pojo.MessageEvent;
import com.telpo.usb.finger.pojo.ResidentialAddress;
import com.telpo.usb.finger.utils.AndroidUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class FarmerProfileInformation extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    static Context context;
    EventBus bus = EventBus.getDefault();
    FragmentFarmerProfileSummaryBinding binding;
    BasicRegistration basicreg;
    BiometricsTaken bio;
    ResidentialAddress resaddr;
    HouseholdProfileRecylcerAdapter adapter;
    List<FarmerRegisty> householdlist;
    List<SupportDocs> docsList;
    ScanDocProfileAdapter scandocadapter;
    boolean reload = false;
    List<SupportDocs> doclist;
    List<FarmerRegisty> farmerlist;
    List<Household> households;
    FarmerRegisty registry;
    Farmers farmer;
    // TODO: Rename and change types of parameters
    private String farmerid;

    public FarmerProfileInformation() {
        // Required empty public constructor
    }

    public static FarmerProfileInformation newInstance(String farmerid) {
        FarmerProfileInformation fragment = new FarmerProfileInformation();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_farmer_profile_summary, container, false);
        View view = binding.getRoot();
        bus.register(this);
        context = getContext();
        householdlist = loadAllHouseholds();
        binding.householdstats.setText(householdlist.size() + " Registered");
        binding.householdRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.householdRecyclerview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        adapter = new HouseholdProfileRecylcerAdapter(getContext(), householdlist, getChildFragmentManager());
        binding.householdRecyclerview.setAdapter(adapter);

        docsList = loadSupportDocs();
        setupScanDocRecyclerView(docsList);

        basicreg = new BasicRegistration();
        binding.setBasicreg(basicreg);

        bio = new BiometricsTaken();
        binding.setBio(bio);

        resaddr = new ResidentialAddress();
        binding.setResaddr(resaddr);

        loadFarmerInformation(farmerid);
        loadBiometricInformation(farmerid);
        loadResidentialGeo();

        binding.editdocs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    EditSupportDocs.newInstance(farmerid).show(getFragmentManager(), "Dialog Fragment");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        binding.editgeoaddr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(getContext(), ResidentialMapActivity.class);
                    intent.putExtra("farmerid", farmerid);
                    //intent.putExtra()
                    getContext().startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        binding.addhousehold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(getContext(), HouseholdSearchActivity.class);
                    intent.putExtra("farmerid", farmerid);
                    getContext().startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        binding.editpersonalinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getChildFragmentManager();
                EditPersonalProfileFragment.newInstance(farmerid).show(fm, "Dialog Fragment");
            }
        });

        binding.expandablePersonalinfoLayout.setOnExpandListener(new ExpandableLayout.OnExpandListener() {
            @Override
            public void onExpand(boolean expanded) {
                if (expanded)
                    binding.personalarrow.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_up));
                else
                    binding.personalarrow.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_down));
            }
        });

        binding.expandableBiometricLayout.setOnExpandListener(new ExpandableLayout.OnExpandListener() {
            @Override
            public void onExpand(boolean expanded) {
                if (expanded)
                    binding.bioarrow.setImageDrawable(getResources().getDrawable(R.drawable
                            .ic_arrow_up));
                else
                    binding.bioarrow.setImageDrawable(getResources().getDrawable(R.drawable
                            .ic_arrow_down));

            }
        });

        binding.expandableHouseholdLayout.setOnExpandListener(new ExpandableLayout.OnExpandListener() {
            @Override
            public void onExpand(boolean expanded) {
                if (expanded)
                    binding.hseholdarrow.setImageDrawable(getResources().getDrawable(R.drawable
                            .ic_arrow_up));
                else
                    binding.hseholdarrow.setImageDrawable(getResources().getDrawable(R.drawable
                            .ic_arrow_down));
            }
        });
        return view;
    }

    //catch Event from Farm Address Fragment
    @Subscribe(sticky = true)
    public void onEvent(MessageEvent event) {
        if (event.getAction().equalsIgnoreCase("reload")) {
            if (event.getMessage().equalsIgnoreCase("profile"))
                loadFarmerInformation(farmerid);
            else if (event.getMessage().equalsIgnoreCase("photo"))
                loadBiometricInformation(farmerid);
            else if (event.getMessage().equalsIgnoreCase("household"))
                reloadHouseholds();
            else if (event.getMessage().equalsIgnoreCase("docs"))
                setupScanDocRecyclerView(loadSupportDocs());
        }
    }

    //method to setup scandocrecycler view
    public void setupScanDocRecyclerView(List<SupportDocs> list) {
        binding.scandocrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.scandocrecycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        scandocadapter = new ScanDocProfileAdapter(list, getContext());
        binding.scandocrecycler.setAdapter(scandocadapter);
        scandocadapter.notifyDataSetChanged();
    }

    //method to load support docs information
    public List<SupportDocs> loadSupportDocs() {
        doclist = new ArrayList<>();
        try {
            doclist = SupportDocs.find(SupportDocs.class, "farmerid = ?", farmerid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return doclist;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    //method to reload households
    public void reloadHouseholds() {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                //householdlist.clear();
                householdlist = new ArrayList<>();
                adapter = new HouseholdProfileRecylcerAdapter(getContext(), householdlist, getChildFragmentManager());
                householdlist = loadAllHouseholds();
                binding.householdstats.setText(householdlist.size() + " Registered");
                adapter = new HouseholdProfileRecylcerAdapter(getContext(), householdlist, getChildFragmentManager());
                binding.householdRecyclerview.setAdapter(adapter);
            }
        });
    }

    //method to load household information
    public List<FarmerRegisty> loadAllHouseholds() {
        farmerlist = new ArrayList<>();
        households = new ArrayList<>();
        try {
            households = Household.find(Household.class, "farmerid = ? or householdid = ?", farmerid);
            if (!households.isEmpty()) {
                for (Household household : households) {
                    registry = new FarmerRegisty();
                    farmer = Farmers.find(Farmers.class, "farmerid = ?", household.getHouseholdid()).get(0);
                    registry.setFullname(farmer.getOthername() + " " + farmer.getSurname());
                    registry.setFarmerid(farmer.getFarmerid());
                    registry.setTelephone(farmer.getTel());
                    registry.setRelationship(household.relationship);
                    registry.setPhoto(bio(farmer.getFarmerid()).getPicture());
                    farmerlist.add(registry);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return farmerlist;
    }

    //method to load biometric info
    public Userbiometrics bio(String farmerid) {
        try {
            List<Userbiometrics> biolist = Userbiometrics.find(Userbiometrics.class, "farmerid = ?", farmerid);
            if (!biolist.isEmpty()) {
                return biolist.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Userbiometrics();
    }

    //method to load biometric information
    public void loadBiometricInformation(String farmerid) {
        try {
            Userbiometrics bio = Userbiometrics.find(Userbiometrics.class, "farmerid=?", farmerid).get(0);
            binding.pic.setImageBitmap(AndroidUtils.byteArrayToBitmap(bio.getPicture()));
            //AndroidUtils.setImageViewResource(binding.pic, bio.getPicture(), getContext());
            AndroidUtils.setImageViewResource(binding.sig, bio.getSignature());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to load farmer residential geographic information
    public void loadResidentialGeo() {

        try {
            List<LocationCoordinates> loclist = LocationCoordinates.find(LocationCoordinates.class, "farmerid = ? and locationtype = ?",
                    farmerid, "Residential Address");
            if (!loclist.isEmpty()) {
                LocationCoordinates loc = loclist.get(0);
                resaddr.assembly.set(loc.getAssembly());
                resaddr.city.set(loc.getCity());
                resaddr.region.set(loc.getRegion());
                resaddr.latitude.set("" + loc.getLatitude());
                resaddr.longitude.set("" + loc.getLongitude());
                resaddr.streetname.set(loc.getStreetname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to load farmer information
    public void loadFarmerInformation(String farmerid) {
        try {
            List<Farmers> farmerslist = Farmers.find(Farmers.class, "farmerid = ?", farmerid);
            if (!farmerslist.isEmpty()) {
                Farmers farmers = farmerslist.get(0);
                basicreg.surname.set(farmers.surname);
                basicreg.firstname.set(farmers.othername);
                basicreg.placeofbirth.set(farmers.placeofbirth);
                basicreg.dateofbirth.set(AndroidUtils.dateToFormattedString(farmers.dateofbirth, "dd-MMM-yyyy"));
                basicreg.gender.set(farmers.gender);
                basicreg.age.set(String.valueOf(farmers.age));
                basicreg.hometown.set(farmers.hometown);
                basicreg.residentialaddr.set(farmers.address);
                basicreg.district.set(farmers.district);
                basicreg.region.set(farmers.region);
                basicreg.farmcommunity.set(farmers.community);
                basicreg.nationality.set(farmers.country);
                basicreg.idtype.set(farmers.idcardtype);
                basicreg.idnumber.set(farmers.idcardno);
                basicreg.levelofeducation.set(farmers.levelofeducation);
                basicreg.religion.set(farmers.religion);
                basicreg.maritalstatus.set(farmers.maritalstatus);
                basicreg.email.set(farmers.email);
                basicreg.telephone.set(farmers.getTel());
                basicreg.postofficebox.set(farmers.postbox);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
