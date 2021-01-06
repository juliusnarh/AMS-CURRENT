package com.telpo.usb.finger.dialogforms;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.DialogAddinputBinding;
import com.telpo.usb.finger.entities.AggregatorInputs;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Date;

import br.com.ilhasoft.support.validation.Validator;
import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddInputDialog extends DialogFragment implements ListDialogFragment.OnListDialogItemSelect {

    private DialogAddinputBinding binding;
    private Validator validator;
    private ListDialogFragment dialogFragment;
    private Integer REQUEST_CAMERA = 101;
    private String[] listitems;
    private byte[] inputimg = null;
    private String mParam1;
    private static final String ARG_PARAM1 = "param1";
    public static String TAG = "ADDINPUTDIALOG";

    public static AddInputDialog newInstance(String eventtype) {
        AddInputDialog dialog = new AddInputDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, eventtype);
        dialog.setArguments(args);
        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new Dialog(requireActivity(), getTheme()) {
            @Override
            public void onBackPressed() {
                closeDialog();
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_addinput, container, false);
        View view = binding.getRoot();
        validator = new Validator(binding);
        AggregatorInputs inputs = new AggregatorInputs();

        binding.category.setOnClickListener(v -> {
            listitems = getResources().getStringArray(R.array.category);
            showOptionDialog(listitems, "Select Category", "category");
        });

        binding.inputimage.setOnClickListener(v -> {
                startCamera();
//            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            startActivityForResult(intent, REQUEST_CAMERA);

        });
        binding.close.setOnClickListener(v -> closeDialog());

        binding.save.setOnClickListener(v -> {
            if (validator.validate()) {
                if (inputimg != null) {
                    try {
                        inputs.category = binding.category.getText().toString().trim();
                        inputs.agentId = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTID, "");
                        inputs.agentName = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTNAME, "");
                        inputs.dateCreated = new Date();
                        inputs.uuid = AndroidUtils.getUUID();
                        inputs.macAddress = AndroidUtils.getMacAddress(getContext());
                        inputs.imei = AndroidUtils.getIMEI(getContext());
                        inputs.costPrice = Integer.parseInt(binding.costPrice.getText().toString().trim());
                        inputs.salePrice = Integer.parseInt(binding.salePrice.getText().toString().trim());
                        inputs.quantity = Integer.parseInt(binding.quantity.getText().toString().trim());
                        inputs.inputDealer = binding.inputdealer.getText().toString().trim();
                        inputs.inputDescription = binding.inputdescription.getText().toString().trim();
                        inputs.inputName = binding.inputname.getText().toString().trim();
                        inputs.inputImage = inputimg;
                        inputs.inputId = AndroidUtils.genPid(binding.category.getText().toString().trim());
                        inputs.unitMeasurement = binding.measurement.getText().toString().trim();
                        inputs.save();
                        Toasty.success(getContext(), "Input Saved").show();
                        dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        dialog.setCancelable(false);
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().getAttributes().windowAnimations = R.style.animate;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname != null && componentname.equalsIgnoreCase("category")) {
            binding.category.setText(selection);
        }
    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        FragmentManager fm = getChildFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    private void closeDialog() {
        new MaterialDialog.Builder(requireContext())
                .title("Cancel")
                .cancelable(false)
                .theme(Theme.LIGHT)
                .content("Do you want to close form?")
                .positiveText("yes")
                .negativeText("no")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dismiss();
                    }
                }).show();
    }

    private void startCamera() {
        ImagePicker.Companion.with(this)
                .cropSquare()
                .galleryMimeTypes(new String[]{
                        "image/png",
                        "image/jpg",
                        "image/jpeg"
                })
                .compress(1024)
                .maxResultSize(900, 900)
                .start(REQUEST_CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {

                Bitmap bitmap = BitmapFactory.decodeFile(ImagePicker.Companion.getFilePath(data));
                inputimg = AndroidUtils.bitmapToByteArray(bitmap);
                binding.inputimage.setImageURI(data.getData());

//                Bundle bundle = data.getExtras();
//                final Bitmap bmp = (Bitmap) bundle.get("data");
//                ByteArrayOutputStream agentbmp = new ByteArrayOutputStream();
//                assert bmp != null;
//                bmp.compress(Bitmap.CompressFormat.JPEG, 100, agentbmp);
//                inputimg = agentbmp.toByteArray();
//                binding.inputimage.setImageBitmap(bmp);
//                binding.inputimage.setDrawingCacheEnabled(true);
            }
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toasty.error(requireContext(), ImagePicker.Companion.getError(data)).show();
        } else {
            Toasty.error(requireContext(), "Task Cancelled").show();
        }
    }

}
