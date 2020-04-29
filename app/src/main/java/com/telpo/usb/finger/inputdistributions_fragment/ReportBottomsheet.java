package com.telpo.usb.finger.inputdistributions_fragment;


import android.os.Bundle;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.interfaces.ItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReportBottomsheet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReportBottomsheet extends BottomSheetDialogFragment implements View.OnClickListener {
    private static ItemClickListener clickListener;
    LinearLayout debtors, salestran, scaletrans, assessments;

    public ReportBottomsheet() {
        // Required empty public constructor
    }


    public static ReportBottomsheet newInstance(ItemClickListener listener) {
        ReportBottomsheet fragment = new ReportBottomsheet();
        clickListener = listener;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getTheme() {
        return R.style.BaseBottomSheetDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.report_bottomsheet, container, false);

        debtors = view.findViewById(R.id.debtors);
        debtors.setOnClickListener(this);

        salestran = view.findViewById(R.id.saletrans);
        salestran.setOnClickListener(this);

        scaletrans = view.findViewById(R.id.scaletrans);
        scaletrans.setOnClickListener(this);

        assessments = view.findViewById(R.id.assessments);
        assessments.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.debtors:
                clickListener.onItemClick("debtors");
                dismiss();
                break;
            case R.id.saletrans:
                clickListener.onItemClick("saletran");
                dismiss();
                break;
            case R.id.scaletrans:
                clickListener.onItemClick("scaletran");
                dismiss();
                break;
            case R.id.assessments:
                clickListener.onItemClick("assessment");
                dismiss();
                break;
        }
    }
}
