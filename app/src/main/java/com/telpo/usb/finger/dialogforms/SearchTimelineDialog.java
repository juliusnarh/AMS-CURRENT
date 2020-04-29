package com.telpo.usb.finger.dialogforms;


import android.app.DatePickerDialog;
import android.app.Dialog;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentSearchTimelineDialogBinding;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import br.com.ilhasoft.support.validation.Validator;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchTimelineDialog extends DialogFragment {
    private static final String ARG_PARAM1 = "param1";
    public static String TAG = "FullScreenDialog";
    Calendar cal = Calendar.getInstance();
    DatePickerDialog datePickerDialog;
    FragmentSearchTimelineDialogBinding binding;
    Validator validator;
    DatePickerDialog.OnDateSetListener startdate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, monthOfYear);
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "dd-MMM-yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            binding.timelinestart.setText(sdf.format(cal.getTime()));
        }
    };
    DatePickerDialog.OnDateSetListener enddate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, monthOfYear);
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "dd-MMM-yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            binding.timelineend.setText(sdf.format(cal.getTime()));
        }
    };
    private String mParam1;
    private Listener listener;

    public static SearchTimelineDialog newInstance() {
        SearchTimelineDialog readmoreDialog = new SearchTimelineDialog();
        Bundle args = new Bundle();
        readmoreDialog.setArguments(args);
        return readmoreDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_timeline_dialog, container, false);
        View view = binding.getRoot();
        validator = new Validator(binding);
        binding.timelinestart.setOnClickListener(v -> showDatePicker(new Date(), new Date()));
        binding.timelineend.setOnClickListener(v -> showDatePickerend(new Date(), new Date()));
        binding.close.setOnClickListener(v -> dismiss());
        binding.searchBtn.setOnClickListener(v -> {
            if (validator.validate()) {
                if (listener != null) {
                    listener.onSearchClickedListnener(AndroidUtils.dateStringToDate(binding.timelinestart.getText().toString(), "dd-MMM-yyyy"), AndroidUtils.dateStringToDate(binding.timelineend.getText().toString(), "dd-MMM-yyyy"));
                    dismiss();
                }
            }
        });

        return view;
    }

    public void showDatePicker(Date startdate, Date enddate) {
        datePickerDialog = new DatePickerDialog(getContext(), this.startdate,
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void showDatePickerend(Date startdate, Date enddate) {
        datePickerDialog = new DatePickerDialog(getContext(), this.enddate,
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
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

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void onSearchClickedListnener(Date from, Date to);
    }
}
