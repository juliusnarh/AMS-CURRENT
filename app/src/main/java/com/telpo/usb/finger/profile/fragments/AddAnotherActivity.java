package com.telpo.usb.finger.profile.fragments;

import android.content.Intent;
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
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.databinding.FragmentAddAnotherActivityBinding;
import com.telpo.usb.finger.entities.ActivityInfo;
import com.telpo.usb.finger.pojo.ActivityInfoPojo;
import com.telpo.usb.finger.pojo.MessageEvent;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import org.greenrobot.eventbus.EventBus;

import es.dmoral.toasty.Toasty;

public class AddAnotherActivity extends DialogFragment implements ListDialogFragment.OnListDialogItemSelect {
    private static final String ARG_PARAM1 = "param1";
    ActivityInfoPojo activityInfo;
    ListDialogFragment dialogFragment;
    FragmentManager fm;
    String[] array;
    EventBus bus = EventBus.getDefault();
    FragmentAddAnotherActivityBinding binding;
    private String farmerid;

    public AddAnotherActivity() {
        // Required empty public constructor
    }

    public static AddAnotherActivity newInstance(String param1) {
        AddAnotherActivity fragment = new AddAnotherActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_another_activity, container, false);
        View view = binding.getRoot();
        activityInfo = new ActivityInfoPojo();
        binding.setActivity(activityInfo);
        getDialog().setTitle("Add Another Activity");
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
                    ActivityInfo activity = new ActivityInfo();
                    activity.farmerid = farmerid;
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
                    activity.uniqueuid = AndroidUtils.getUUID();
                    activity.agentid = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTID, "");
                    activity.agentname = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTNAME, "");
                    activity.macaddress = AndroidUtils.getMacAddress(getContext());
                    activity.imei = AndroidUtils.getIMEI(getContext());
                    activity.save();
                    bus.post(new MessageEvent("reload", "activity"));

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
                    Toasty.success(getContext(), "Record saved successfully").show();
                    Intent intent = new Intent(getActivity(), ProfileActivity.class);
                    intent.putExtra("farmerid", farmerid);
                    intent.putExtra("tabindex", 1);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    getActivity().startActivity(intent);
                    dismiss();
                }
            }
        };
        asyncTask.execute();
    }
}
