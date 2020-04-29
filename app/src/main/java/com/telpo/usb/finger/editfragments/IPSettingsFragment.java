package com.telpo.usb.finger.editfragments;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentIpsettingsBinding;
import com.telpo.usb.finger.pojo.IPSettingsPojo;
import com.telpo.usb.finger.utils.AndroidUtils;

import es.dmoral.toasty.Toasty;

public class IPSettingsFragment extends DialogFragment {
    private static final String ARG_PARAM1 = "param1";
    FragmentIpsettingsBinding binding;
    IPSettingsPojo ip;
    private String mParam1;

    public IPSettingsFragment() {
    }

    public static IPSettingsFragment newInstance(String param1) {
        IPSettingsFragment fragment = new IPSettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ipsettings, container, false);
        View view = binding.getRoot();
        getDialog().setTitle("IP Settings");
        ip = new IPSettingsPojo();
        binding.setIp(ip);

        loadDialogInfo();
        binding.btnsave.setOnClickListener(view1 -> {
            AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.IPPREF, AndroidUtils.tolower(ip.ipaddress.get()));
            AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.PROTOCOLPREF, AndroidUtils.tolower(ip.protocol.get()));
            AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.ENDPOINTPREF, AndroidUtils.tolower(ip.context.get()));
            AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.PORT, ip.port.get());
            AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.IPCOMPLETEPREF, binding.txtcomplete.getText().toString());
            Toasty.success(getActivity(), "IP Address Saved Successfully").show();

            AndroidUtils.uploadFileToServer(getContext());
            dismiss();
        });
        return view;
    }

    //method to load dialog info
    public void loadDialogInfo() {
        ip.ipaddress.set(AndroidUtils.getPreferenceData(getActivity(), AndroidUtils.IPPREF, "webservice.uclgroupgh.com"));
        ip.port.set(AndroidUtils.getPreferenceData(getActivity(), AndroidUtils.PORT, "8080"));
        ip.protocol.set(AndroidUtils.getPreferenceData(getActivity(), AndroidUtils.PROTOCOLPREF, "http"));
        ip.context.set(AndroidUtils.getPreferenceData(getActivity(), AndroidUtils.ENDPOINTPREF, "uclservice/uclservice"));
    }

}
