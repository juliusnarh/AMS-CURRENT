package com.telpo.usb.finger.editfragments;

import android.app.DatePickerDialog;
import androidx.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.google.gson.Gson;
import com.orm.SugarRecord;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentEditPersonalProfileBinding;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.pojo.BasicRegistration;
import com.telpo.usb.finger.pojo.MessageEvent;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import br.com.ilhasoft.support.validation.Validator;
import es.dmoral.toasty.Toasty;

public class EditPersonalProfileFragment extends DialogFragment implements ListDialogFragment.OnListDialogItemSelect {
    private static final String ARG_PARAM1 = "param1";
    Farmers farmers;
    FragmentEditPersonalProfileBinding binding;
    BasicRegistration basicreg;
    EventBus bus = EventBus.getDefault();
    Calendar cal = Calendar.getInstance();
    DatePickerDialog datePickerDialog;
    ListDialogFragment dialogFragment;
    FragmentManager fm;
    String[] listitems;
    String[] popupcomponent = {"maritalstatus", "region", "gender", "idcard", "nationality", "district"};
    String[] popuptitle = {"Select Marital Status", "Select Region", "Select Gender", "Select ID Type", "Select Country", "Select District"};
    Validator validator;
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, monthOfYear);
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "dd-MMM-yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            binding.bdate.setText(sdf.format(cal.getTime()));
            try {
                binding.age.setText("" + AndroidUtils.age(year, monthOfYear, dayOfMonth));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private String farmerid;


    public EditPersonalProfileFragment() {
        // Required empty public constructor
    }

    public static EditPersonalProfileFragment newInstance(String param1) {
        EditPersonalProfileFragment fragment = new EditPersonalProfileFragment();
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
        getDialog().setTitle("Edit Personal Information");
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_personal_profile,
                container, false);
        validator = new Validator(binding);
        View view = binding.getRoot();
        basicreg = new BasicRegistration();
        binding.setBasicreg(basicreg);
        loadFarmerInformation(farmerid);
        binding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        binding.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validator.validate()) {
                    savePersonalInfo();
                }
            }
        });
        binding.bdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        binding.edu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listitems = getResources().getStringArray(R.array.edulevel);
                showOptionDialog(listitems, "Level of Education", "edulevel");
            }
        });

        binding.gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listitems = getResources().getStringArray(R.array.genderitems);
                showOptionDialog(listitems, popuptitle[2], popupcomponent[2]);
            }
        });
        binding.idtype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listitems = getResources().getStringArray(R.array.idtypes);
                showOptionDialog(listitems, popuptitle[3], popupcomponent[3]);
            }
        });
        binding.country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listitems = getResources().getStringArray(R.array.countries);
                showOptionDialog(listitems, popuptitle[4], popupcomponent[4]);
            }
        });
        binding.region.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listitems = getResources().getStringArray(R.array.regionlist);
                showOptionDialog(listitems, popuptitle[1], popupcomponent[1]);
            }
        });
        binding.maritalstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listitems = getResources().getStringArray(R.array.maritalstatuss);
                showOptionDialog(listitems, popuptitle[0], popupcomponent[0]);
            }
        });
        binding.district.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listitems = getResources().getStringArray(R.array.district);
                showOptionDialog(listitems, popuptitle[5], popupcomponent[5]);
            }
        });
        return view;
    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        fm = getChildFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    public void showDatePicker() {
        datePickerDialog = new DatePickerDialog(getActivity(), date,
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    //method to load farmer information
    public void loadFarmerInformation(String farmerid) {
        try {
            farmers = Farmers.find(Farmers.class, "farmerid = ?", farmerid).get(0);
            basicreg.surname.set(farmers.surname);
            basicreg.age.set(String.valueOf(farmers.age));
            basicreg.firstname.set(farmers.othername);
            basicreg.placeofbirth.set(farmers.placeofbirth);
            basicreg.dateofbirth.set(AndroidUtils.dateToFormattedString(farmers.dateofbirth, "dd-MMM-yyyy"));
            basicreg.gender.set(farmers.gender);
            basicreg.hometown.set(farmers.hometown);
            basicreg.residentialaddr.set(farmers.address);
            basicreg.district.set(farmers.district);
            basicreg.region.set(farmers.region);
            basicreg.farmcommunity.set(farmers.community);
            basicreg.telephone.set(farmers.getTel());
            basicreg.nationality.set(farmers.country);
            basicreg.idtype.set(farmers.idcardtype);
            basicreg.idnumber.set(farmers.idcardno);
            basicreg.levelofeducation.set(farmers.levelofeducation);
            basicreg.religion.set(farmers.religion);
            basicreg.maritalstatus.set(farmers.maritalstatus);
            basicreg.email.set(farmers.email);
            basicreg.postofficebox.set(farmers.postbox);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to edit personal information
    public void savePersonalInfo() {
        AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
                AndroidUtils.showProgressDialog(getContext(), "Saving...");
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    farmers.surname = basicreg.surname.get();
                    farmers.age = Integer.valueOf(basicreg.age.get());
                    farmers.othername = basicreg.firstname.get();
                    farmers.placeofbirth = basicreg.placeofbirth.get();
                    farmers.dateofbirth = AndroidUtils.dateStringToDate(basicreg.dateofbirth.get());
                    farmers.gender = basicreg.gender.get();
                    farmers.hometown = basicreg.hometown.get();
                    farmers.address = basicreg.residentialaddr.get();
                    farmers.district = basicreg.district.get();
                    farmers.region = basicreg.region.get();
                    farmers.community = basicreg.farmcommunity.get();
                    farmers.country = basicreg.nationality.get();
                    farmers.idcardtype = basicreg.idtype.get();
                    farmers.idcardno = basicreg.idnumber.get();
                    farmers.levelofeducation = basicreg.levelofeducation.get();
                    farmers.religion = basicreg.religion.get();
                    farmers.maritalstatus = basicreg.maritalstatus.get();
                    farmers.email = basicreg.email.get();
                    farmers.tel = basicreg.telephone.get();
                    farmers.postbox = basicreg.postofficebox.get();
                    farmers.agentid = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTID, "");
                    farmers.agentname = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTNAME, "");
                    farmers.macaddress = AndroidUtils.getMacAddress(getContext());
                    farmers.imei = AndroidUtils.getIMEI(getContext());
                    SugarRecord.save(farmers);


                    ServerTransfer transfer = new ServerTransfer();
                    transfer.setFarmers(farmers);
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
                    bus.post(new MessageEvent("reload", "profile"));
                    Toasty.success(getContext(), "Record was successfully saved!!!").show();
                    EditPersonalProfileFragment.this.dismiss();
                }
            }
        };
        asyncTask.execute();

    }


    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("gender")) {
            binding.gender.setText(selection);
        } else if (componentname.equalsIgnoreCase("nationality")) {
            binding.country.setText(selection);
        } else if (componentname.equalsIgnoreCase("idcard")) {
            binding.idtype.setText(selection);
        } else if (componentname.equalsIgnoreCase("region")) {
            binding.region.setText(selection);
        } else if (componentname.equalsIgnoreCase("maritalstatus")) {
            binding.maritalstatus.setText(selection);
        } else if (componentname.equalsIgnoreCase("district")) {
            binding.district.setText(selection);
        } else if (componentname.equalsIgnoreCase("edulevel")) {
            binding.edu.setText(selection);
        }
    }
}
