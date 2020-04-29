package com.telpo.usb.finger.dialogforms;


import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.telpo.usb.finger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadmoreDialog extends DialogFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static String TAG = "FullScreenDialog";
    private String mParam1;
    private String mParam2;

    public static ReadmoreDialog newInstance(String amountowing, String amountpaid) {
        ReadmoreDialog readmoreDialog = new ReadmoreDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, amountowing);
        args.putString(ARG_PARAM2, amountpaid);
        readmoreDialog.setArguments(args);
        return readmoreDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_readmore_dialog, container, false);

        ImageView close = view.findViewById(R.id.close);
        TextView amowing = view.findViewById(R.id.amountowing_cash);
        TextView ampaid = view.findViewById(R.id.amountpaid_cash);

        close.setOnClickListener(v -> dismiss());
        amowing.setText(mParam1);
        ampaid.setText(mParam2);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        dialog.setCancelable(false);
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().getAttributes().windowAnimations = R.style.traininganimate;
            dialog.getWindow().setLayout(width, height);
        }
    }
}
