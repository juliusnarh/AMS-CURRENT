package com.telpo.usb.finger.editfragments;

import androidx.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentEditFarminfoBinding;
import com.telpo.usb.finger.entities.Districts;
import com.telpo.usb.finger.entities.Farms;
import com.telpo.usb.finger.entities.Regions;
import com.telpo.usb.finger.pojo.FarmRegistrationPojo;
import com.telpo.usb.finger.pojo.MessageEvent;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class EditFarminfo extends DialogFragment implements ListDialogFragment.OnListDialogItemSelect {
    private static final String ARG_PARAM1 = "param1";
    EventBus bus = EventBus.getDefault();
    FarmRegistrationPojo farmRegistrationPojo;
    Farms farms;
    ListDialogFragment dialogFragment;
    String[] array;
    String[] listitems;
    FragmentManager fm;

    FragmentEditFarminfoBinding binding;
    String[] arrayy;
    List<Regions> regions;
    String[] districtArray;
    private String uniqueuid;

    public EditFarminfo() {
    }

    public static EditFarminfo newInstance(String param1) {
        EditFarminfo fragment = new EditFarminfo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            uniqueuid = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_farminfo, container, false);
        View view = binding.getRoot();

        farmRegistrationPojo = new FarmRegistrationPojo();
        binding.setFarmreg(farmRegistrationPojo);
        loadFarmInformation(uniqueuid);
        getDialog().setTitle("Edit Farm Information");
        binding.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveFarmInformation();
            }
        });

        binding.btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        binding.txtregion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listitems = loadRegions();
                showOptionDialog(listitems, "Select Region", "region");
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
                showOptionDialog(R.array.cocoatype, "Select Crop Type", "cocoatype");
            }
        });
        binding.materialsource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.plantingmaterialsource, "Select Material Source", "materialsource");
            }
        });
        binding.laborsource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.laboursource, "Select Labour Source", "laboursource");
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
                listitems = loadDistricts(getRegionCode(binding.txtregion.getText().toString().trim()));
                showOptionDialog(listitems, "Select District", "district");
            }
        });
        return view;
    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        fm = getChildFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    private void showOptionDialog(int id, String title, String componentname) {
        array = getResources().getStringArray(id);
        fm = getChildFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
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


    public void loadFarmInformation(String uniqueuid) {
        try {
            farms = new Farms();
            List<Farms> farmsList = Farms.find(Farms.class, "uniqueuid = ?", uniqueuid);
            if (!farmsList.isEmpty()) {
                farms = farmsList.get(0);
                farmRegistrationPojo.location.set(farms.location);
                farmRegistrationPojo.district.set(farms.district);
                farmRegistrationPojo.region.set(farms.region);
                farmRegistrationPojo.community.set(farms.community);
                farmRegistrationPojo.establishedyear.set(farms.yearofestablishment);
                farmRegistrationPojo.landarea.set(farms.totalarea);
                farmRegistrationPojo.cultarea.set(farms.cultivatedarea);
                farmRegistrationPojo.shadetreeno.set(farms.shadetrees);
                farmRegistrationPojo.sourceofownership.set(farms.ownership);
                farmRegistrationPojo.typeoffarm.set(farms.typeoffarm);
                farmRegistrationPojo.plantmaterialsrc.set(farms.plantingmaterial);
                farmRegistrationPojo.otherplantmatsrc.set(farms.othersource);
                farmRegistrationPojo.laboursource.set(farms.labour);
                farmRegistrationPojo.extensionorg.set(farms.extension);
                farmRegistrationPojo.privateextentionorg.set(farms.organisation);
                farmRegistrationPojo.agroactivity.set(farms.activities);
                farmRegistrationPojo.cropvariety.set(farms.cropvariety);
                farmRegistrationPojo.fertilizerused.set(farms.fertilizerused);
                farmRegistrationPojo.farmyield.set(farms.farmyield);
                farmRegistrationPojo.cropprotection.set(farms.cropprotection);
                farmRegistrationPojo.chemicalused.set(farms.chemicalused);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveFarmInformation() {
        AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
                AndroidUtils.showProgressDialog(getContext(), "Saving...");
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    farms.location = farmRegistrationPojo.location.get();
                    farms.district = farmRegistrationPojo.district.get();
                    farms.region = farmRegistrationPojo.region.get();
                    farms.community = farmRegistrationPojo.community.get();
                    farms.yearofestablishment = farmRegistrationPojo.establishedyear.get();
                    farms.totalarea = farmRegistrationPojo.landarea.get();
                    farms.cultivatedarea = farmRegistrationPojo.cultarea.get();
                    farms.shadetrees = farmRegistrationPojo.shadetreeno.get();
                    farms.ownership = farmRegistrationPojo.sourceofownership.get();
                    farms.typeoffarm = farmRegistrationPojo.typeoffarm.get();
                    farms.plantingmaterial = farmRegistrationPojo.plantmaterialsrc.get();
                    farms.othersource = farmRegistrationPojo.otherplantmatsrc.get();
                    farms.labour = farmRegistrationPojo.laboursource.get();
                    farms.extension = farmRegistrationPojo.extensionorg.get();
                    farms.organisation = farmRegistrationPojo.privateextentionorg.get();
                    farms.activities = farmRegistrationPojo.agroactivity.get();
                    farms.cropvariety = farmRegistrationPojo.cropvariety.get();
                    farms.fertilizerused = farmRegistrationPojo.fertilizerused.get();
                    farms.farmyield = farmRegistrationPojo.farmyield.get();
                    farms.cropprotection = farmRegistrationPojo.cropprotection.get();
                    farms.chemicalused = farmRegistrationPojo.chemicalused.get();
                    farms.agentid = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTID, "");
                    farms.agentname = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTNAME, "");
                    farms.macaddress = AndroidUtils.getMacAddress(getContext());
                    farms.imei = AndroidUtils.getIMEI(getContext());

                    if (farms.getId() == null) {
                        farms.uniqueuid = AndroidUtils.getUUID();
                        farms.farmid = "UCL-FM-001-" + AndroidUtils.getUUID();
                    }
                    farms.save();

                    ServerTransfer transfer = new ServerTransfer();
                    transfer.setFarms(farms);
                    String jsonstring = new Gson().toJson(transfer);

                    String uploadId = AndroidUtils.getUUID();
                    String uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
                    AndroidUtils.uploadFileToServer(getContext());

                    // AndroidUtils.syncUnsentFiles(getContext());

                    outcome = true;
                } catch (Exception e) {
                    bus.post(new MessageEvent("reload", "farm"));
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {
                AndroidUtils.dismissProgressDialog();
                if (outcome) {
                    Toasty.success(getContext(), "Record was successfully saved").show();
                    dismiss();
                }
            }
        };
        asyncTask.execute();
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
            binding.district.setText("");
        }
    }
}