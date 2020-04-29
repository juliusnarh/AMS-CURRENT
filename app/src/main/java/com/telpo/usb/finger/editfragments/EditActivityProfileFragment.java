package com.telpo.usb.finger.editfragments;


import androidx.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentEditActivityProfileBinding;
import com.telpo.usb.finger.entities.ActivityInfo;
import com.telpo.usb.finger.pojo.ActivityInfoPojo;
import com.telpo.usb.finger.pojo.MessageEvent;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditActivityProfileFragment extends DialogFragment implements ListDialogFragment.OnListDialogItemSelect {

    private static final String ARG_PARAM1 = "param1";
    EventBus bus = EventBus.getDefault();
    ListDialogFragment dialogFragment;
    FragmentManager fm;
    String[] array;
    FragmentEditActivityProfileBinding binding;
    ActivityInfoPojo activityInfo;
    ActivityInfo activity;
    private String uniqueuid;

    public EditActivityProfileFragment() {
        // Required empty public constructor
    }

    public static EditActivityProfileFragment newInstance(String param1) {
        EditActivityProfileFragment fragment = new EditActivityProfileFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_activity_profile,
                container, false);
        activityInfo = new ActivityInfoPojo();
        binding.setActivity(activityInfo);
        getDialog().setTitle("Edit Activity");
        loadActivityInfo(uniqueuid);
        View view = binding.getRoot();
        binding.specialtycocoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.cocoaspecialtylist, "Select Specialty Crop", "specialty");
            }
        });
        binding.certification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.certificationlist, "Select Certification Type", "certification");
            }
        });
        binding.fundingsource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDialog(R.array.sourceoffunds, "Select Funding Source", "fundingsource");
            }
        });

        binding.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveActivityInfo();
            }
        });
        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return view;
    }

    private void showOptionDialog(int id, String title, String componentname) {
        array = getResources().getStringArray(id);
        fm = getChildFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    //method to load activity information from the database
    public void loadActivityInfo(String uniqueuid) {
        try {
            activity = new ActivityInfo();
            List<ActivityInfo> activitylist = ActivityInfo.find(ActivityInfo.class, "uniqueuid = ?",
                    uniqueuid);
            if (!activitylist.isEmpty()) {
                activity = activitylist.get(0);
                activityInfo.groupname.set(activity.groupname);
                activityInfo.boolgroupmember.set(activity.boolgroupname);
                activityInfo.coopname.set(activity.coopname);
                activityInfo.boolcoopmember.set(activity.boolcoopname);
                activityInfo.incomesource.set(activity.incomesource);
                activityInfo.boolcocoaincome.set(activity.boolincomesource);
                activityInfo.specialtycocoa.set(activity.specialtycocoa);
                activityInfo.boolspecialty.set(activity.boolspecialtycocoa);
                activityInfo.certified.set(activity.certified);
                activityInfo.boolcertified.set(activity.boolcertified);
                activityInfo.fundingsource.set(activity.fundingsource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to save activity information
    public void saveActivityInfo() {
        AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
                AndroidUtils.showProgressDialog(getContext(), "Saving...");
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    activity.uniqueuid = uniqueuid;
                    activity.groupname = activityInfo.groupname.get();
                    activity.boolgroupname = activityInfo.boolgroupmember.get();
                    activity.coopname = activityInfo.coopname.get();
                    activity.boolcoopname = activityInfo.boolcoopmember.get();
                    activity.incomesource = activityInfo.incomesource.get();
                    activity.boolincomesource = activityInfo.boolcocoaincome.get();
                    activity.specialtycocoa = activityInfo.specialtycocoa.get();
                    activity.boolspecialtycocoa = activityInfo.boolspecialty.get();
                    activity.certified = activityInfo.certified.get();
                    activity.boolcertified = activityInfo.boolcertified.get();
                    activity.fundingsource = activityInfo.fundingsource.get();
                    activity.agentid = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTID, "");
                    activity.agentname = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTNAME, "");
                    activity.macaddress = AndroidUtils.getMacAddress(getContext());
                    activity.imei = AndroidUtils.getIMEI(getContext());
                    if (activity.getId() == null) {
                        activity.uniqueuid = AndroidUtils.getUUID();
                    }
                    activity.save();

                    ServerTransfer transfer = new ServerTransfer();
                    transfer.setActivityInfo(activity);
                    String jsonstring = new Gson().toJson(transfer);

                    String uploadId = AndroidUtils.getUUID();
                    String uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
                    AndroidUtils.uploadFileToServer(getContext());

                    outcome = true;
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {
                AndroidUtils.dismissProgressDialog();
                if (outcome) {
                    bus.post(new MessageEvent("reload", "activity"));
                    Toasty.success(getContext(), "Record saved successfully").show();
                    dismiss();
                }
            }
        };
        asyncTask.execute();
    }


    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("fundingsource")) {
            binding.fundingsource.setText(selection);
        } else if (componentname.equalsIgnoreCase("certification")) {
            binding.certification.setText(selection);
        } else if (componentname.equalsIgnoreCase("specialty")) {
            binding.specialtycocoa.setText(selection);
        }
    }
}
