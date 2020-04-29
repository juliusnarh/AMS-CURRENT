package com.telpo.usb.finger.dialogforms;


import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadChartValuesDialog extends DialogFragment {
    private static final String ARG_PARAM1 = "param1";
    public static String TAG = "FullScreenDialog";
    static ChartPojo chartPojo;
    private String mParam1;

    public static ReadChartValuesDialog newInstance(String type, ChartPojo pojo) {
        ReadChartValuesDialog readmoreDialog = new ReadChartValuesDialog();
        chartPojo = pojo;
        Bundle args = new Bundle();
        if (type != null)
            args.putString(ARG_PARAM1, type);
        readmoreDialog.setArguments(args);
        return readmoreDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chart_values_dialog, container, false);

        LinearLayout type1 = view.findViewById(R.id.type1);
        LinearLayout type2 = view.findViewById(R.id.type2);
        TextView registered = view.findViewById(R.id.registered);
        TextView male = view.findViewById(R.id.males);
        TextView female = view.findViewById(R.id.females);
        TextView sub = view.findViewById(R.id.subsidized);
        TextView nonsub = view.findViewById(R.id.nonsub);
        TextView cash = view.findViewById(R.id.cash);
        TextView barter = view.findViewById(R.id.barter);
        TextView mm = view.findViewById(R.id.mm);

        if (mParam1.equals("0")) {
            type2.setVisibility(View.GONE);
            registered.setText(chartPojo.regfarmers.get());
            male.setText(chartPojo.male.get());
            female.setText(chartPojo.female.get());
        } else if (mParam1.equals("1")) {
            type1.setVisibility(View.GONE);
            sub.setText(chartPojo.subsidized.get());
            nonsub.setText(chartPojo.nonsubsidized.get());
            cash.setText(chartPojo.cash.get());
            barter.setText(chartPojo.ba.get());
            mm.setText(chartPojo.mm.get());

        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().getAttributes().windowAnimations = R.style.traininganimate;
            dialog.getWindow().setLayout(width, height);
        }
    }
}
