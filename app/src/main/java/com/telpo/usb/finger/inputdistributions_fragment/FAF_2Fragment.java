package com.telpo.usb.finger.inputdistributions_fragment;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import androidx.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.soundcloud.android.crop.Crop;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentFaf2Binding;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_2_Pojo;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import br.com.ilhasoft.support.validation.Validator;
import es.dmoral.toasty.Toasty;
import ivb.com.materialstepper.stepperFragment;

import static android.app.Activity.RESULT_OK;

public class FAF_2Fragment extends stepperFragment {
    private static final int CAMERA_RQ = 6969;
    final int CROP_IMAGE = 5;
    Calendar cal = Calendar.getInstance();
    DatePickerDialog datePickerDialog;
    FragmentFaf2Binding binding;
    FAF_2_Pojo pojo;
    Validator validator;
    public static String fileName;
    private int ASPECT_RATIO_X = 1, ASPECT_RATIO_Y = 1, bitmapMaxWidth = 1000, bitmapMaxHeight = 1000;
    private int IMAGE_COMPRESSION = 80;
    private boolean lockAspectRatio = true, setBitmapMaxWidthHeight = true;
    private Uri imageUri;
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, monthOfYear);
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "dd-MMM-yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            binding.dateChemApp.setText(sdf.format(cal.getTime()));
        }
    };
    DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, monthOfYear);
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "dd-MMM-yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            binding.dateFertApp.setText(sdf.format(cal.getTime()));
        }
    };


    public FAF_2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_faf_2, container, false);
        View view = binding.getRoot();
        validator = new Validator(binding);
        pojo = new FAF_2_Pojo();
        binding.setFaf2(pojo);

        binding.dateChemApp.setOnClickListener(v -> showDatePicker());
        binding.dateFertApp.setOnClickListener(v -> showDatePicker2());

        binding.camera.setOnClickListener(v -> openCamera());
        binding.fertLayout.setOnClickListener(v -> {
            if (binding.fertilizerCheck.isChecked()) {
                pojo.fertCheck.set(false);
            } else pojo.fertCheck.set(true);
        });
        binding.cropprotectionLayout.setOnClickListener(v -> {

            if (binding.chemicalCheck.isChecked()) {
                pojo.chemCheck.set(false);
            } else pojo.chemCheck.set(true);
        });
        pojo.farmLong.set(AndroidUtils.getPreferenceData(getActivity(), AndroidUtils.FAFLONG_PREF, ""));
        pojo.farmLat.set(AndroidUtils.getPreferenceData(getActivity(), AndroidUtils.FAFLAT_PREF, ""));
        return view;
    }

    @Override
    public boolean onNextButtonHandler() {
        boolean photo = false;
        if (binding.chemicalCheck.isChecked() || binding.fertilizerCheck.isChecked()) {
            if (validator.validate()) {

                try {
                    photo = pojo.farmPhoto.get();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                if (photo) {
                    pojo.farmLong.set(AndroidUtils.getPreferenceData(getActivity(), AndroidUtils.FAFLONG_PREF, ""));
                    pojo.farmLat.set(AndroidUtils.getPreferenceData(getActivity(), AndroidUtils.FAFLAT_PREF, ""));
                    AndroidUtils.hideKeyboard(getActivity());
                    AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.FAFCROPPROT_PREF, new Gson().toJson(binding.getFaf2()));
                    return true;
                } else {
                    Toasty.error(getContext(), "Take Farm Image").show();
                    return false;
                }
            } else {
                return false;
            }
        } else {
            try {
                photo = pojo.farmPhoto.get();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            if (photo) {
                AndroidUtils.hideKeyboard(getActivity());
                AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.FAFCROPPROT_PREF, new Gson().toJson(binding.getFaf2()));
                return true;
            } else {
                return false;
            }
        }
    }

    public void openCamera() {
        Dexter.withActivity(getActivity())
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            fileName = System.currentTimeMillis() + ".jpg";
                            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, getCacheImagePath(fileName));
                            if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                                startActivityForResult(takePictureIntent, CAMERA_RQ);
                            }
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }


    private Uri getCacheImagePath(String fileName) {
        File path = new File(getActivity().getExternalCacheDir(), "camera");
        if (!path.exists()) path.mkdirs();
        File image = new File(path, fileName);
        return FileProvider.getUriForFile(getContext(), "com.telpo.usb.finger.utils.CropImageFileProvider", image);
    }

    private void cropImage(Uri sourceUri) {
        Uri destinationUri = Uri.fromFile(new File(getActivity().getCacheDir(), queryName(getContext().getContentResolver(), sourceUri)));
        UCrop.Options options = new UCrop.Options();
        options.setCompressionQuality(IMAGE_COMPRESSION);
        options.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        options.setStatusBarColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        options.setActiveWidgetColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));

        if (lockAspectRatio)
            options.withAspectRatio(ASPECT_RATIO_X, ASPECT_RATIO_Y);

        if (setBitmapMaxWidthHeight)
            options.withMaxResultSize(bitmapMaxWidth, bitmapMaxHeight);

        UCrop.of(sourceUri, destinationUri)
                .withOptions(options)
                .start(getActivity(), this);
    }

    private static String queryName(ContentResolver resolver, Uri uri) {
        Cursor returnCursor =
                resolver.query(uri, null, null, null, null);
        assert returnCursor != null;
        int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
        returnCursor.moveToFirst();
        String name = returnCursor.getString(nameIndex);
        returnCursor.close();
        return name;
    }


    /**
     * Calling this will delete the images from cache directory
     * useful to clear some memory
     */
    public static void clearCache(Context context) {
        File path = new File(context.getExternalCacheDir(), "camera");
        if (path.exists() && path.isDirectory()) {
            for (File child : path.listFiles()) {
                child.delete();
            }
        }
    }

    public void showDatePicker() {
        datePickerDialog = new DatePickerDialog(getActivity(), date,
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    public void showDatePicker2() {
        datePickerDialog = new DatePickerDialog(getActivity(), date2,
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK) {
            Bitmap thePic = null;
            String base64String = "";
            switch (requestCode) {
                case CAMERA_RQ:
                    try {
                        cropImage(getCacheImagePath(fileName));

//                        String ulcphotourl = intent.getStringExtra("photopath");
//                        Uri photoURI = FileProvider.getUriForFile(getActivity(),
//                                BuildConfig.APPLICATION_ID + ".provider",
//                                new File(ulcphotourl));
//                        //CropImage(photoURI);
//                        Uri destination = Uri.fromFile(new File(AndroidUtils.cropDirectoryPath(), "cropped.jpg"));
//                        Crop.of(photoURI, destination).asSquare().withMaxSize(256, 256).start(getContext(), this, CROP_IMAGE);
                    } catch (Exception e) {
                        System.out.println("UCL Photo Exception: " + e);
                        e.printStackTrace();
                    }
                    break;
                case CROP_IMAGE:
                    //get the cropped bitmap
                    byte[] croppedbytes = AndroidUtils.uriToByteArray(Crop.getOutput(intent), getContext());
                    thePic = AndroidUtils.byteArrayToBitmap(croppedbytes);
                    pojo.farmPhoto.set(thePic != null);
                    base64String = AndroidUtils.byteArrayToBase64(croppedbytes);
                    pojo.photoString.set(base64String);
                    AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.PHOTOPREF, base64String);
                    Toasty.success(getContext(), "Successfully Cropped Image").show();
                    break;
                case UCrop.REQUEST_CROP:
                    final Uri resultUri = UCrop.getOutput(intent);
                    // get the cropped bitmap
                    try {
                        thePic = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), resultUri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    pojo.farmPhoto.set(thePic != null);
                    if (thePic != null) {
                        base64String = AndroidUtils.byteArrayToBase64(AndroidUtils.bitmapToByteArray(thePic));
                        pojo.photoString.set(base64String);
                        AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.PHOTOPREF, base64String);
                        clearCache(getContext());
                        Toasty.success(getContext(), "Successfully Cropped Image").show();
                    }
                    break;
            }
        }
    }


}
