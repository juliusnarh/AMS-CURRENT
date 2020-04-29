package com.telpo.usb.finger.registration.fragments;


import android.Manifest;
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
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.registration.FingerEnrollActivity;
import com.telpo.usb.finger.activities.registration.ScanDocsActivity;
import com.telpo.usb.finger.activities.registration.SignatureActivity;
import com.telpo.usb.finger.databinding.FragmentBiometricsBinding;
import com.telpo.usb.finger.pojo.BiometricsTaken;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.io.IOException;
import java.util.List;

import es.dmoral.toasty.Toasty;
import ivb.com.materialstepper.stepperFragment;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class BiometricsFragment extends stepperFragment {

    public static final String INTENT_IMAGE_PICKER_OPTION = "image_picker_option";
    public static final String INTENT_ASPECT_RATIO_X = "aspect_ratio_x";
    public static final String INTENT_ASPECT_RATIO_Y = "aspect_ratio_Y";
    public static final String INTENT_LOCK_ASPECT_RATIO = "lock_aspect_ratio";
    public static final String INTENT_IMAGE_COMPRESSION_QUALITY = "compression_quality";
    public static final String INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT = "set_bitmap_max_width_height";
    public static final String INTENT_BITMAP_MAX_WIDTH = "max_width";
    public static final String INTENT_BITMAP_MAX_HEIGHT = "max_height";
    private static final int CAMERA_RQ = 6969;
    private static final int PERMISSION_RQ = 84;
    private static final String TAG = BiometricsFragment.class.getSimpleName();
    public static String fileName;
    final int CAMERA_REQUEST_CODE = 1;
    final int FINGER_REQUEST_CODE = 2;
    final int DOCS_REQUEST_CODE = 3;
    final int SIGN_REQUEST_CODE = 4;
    final int CROP_IMAGE = 5;
    final int DOC_REQUEST_CODE = 6;
    FragmentBiometricsBinding binding;
    BiometricsTaken takenbio;
    String imageFilePath;
    private int ASPECT_RATIO_X = 1, ASPECT_RATIO_Y = 1, bitmapMaxWidth = 1000, bitmapMaxHeight = 1000;
    private int IMAGE_COMPRESSION = 100;
    private boolean lockAspectRatio = true, setBitmapMaxWidthHeight = true;
    private Uri imageUri;


    public BiometricsFragment() {
        // Required empty public constructor
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_biometrics, container, false);
        View view = binding.getRoot();

        takenbio = new BiometricsTaken();
        binding.setBio(takenbio);

        binding.camera.setOnClickListener(v -> {
            try {
//                openCamera();
                takeCameraImage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        binding.fingerprint.setOnClickListener(v -> openFingerPrint());
        binding.signature.setOnClickListener(v -> openSignaturePad());
        binding.supportdocs.setOnClickListener(v -> openSupportDocs());
        return view;
    }

    private void takeCameraImage() {
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

    private void openSupportDocs() {
        Intent intent = new Intent(getContext(), ScanDocsActivity.class);
        startActivityForResult(intent, DOC_REQUEST_CODE);
    }

    private void openSignaturePad() {
        Intent intent = new Intent(getContext(), SignatureActivity.class);
        startActivityForResult(intent, SIGN_REQUEST_CODE);
    }

    private void openFingerPrint() {
        Intent intent = new Intent(getContext(), FingerEnrollActivity.class);
        startActivityForResult(intent, FINGER_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Uri destination;
        Bundle extras = null;
        Bitmap thePic = null;
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
//            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
//                performCrop(imageUri);
//            }
            switch (requestCode) {
                case CAMERA_REQUEST_CODE:

                    //takenbio.photo.set(intent.getBooleanExtra("photo", false));
                    break;
                case FINGER_REQUEST_CODE:
                    takenbio.fingerprint.set(intent.getBooleanExtra("fingerprint", false));
                    break;
                case DOC_REQUEST_CODE:
                    takenbio.supportdocs.set(intent.getBooleanExtra("docs", false));
                    break;
                case SIGN_REQUEST_CODE:
                    takenbio.signature.set(intent.getBooleanExtra("signature", false));
                    break;
                case CAMERA_RQ:
                    cropImage(getCacheImagePath(fileName));
//                    Uri selectedImage = imageUri;
//                    getContext().getContentResolver().notifyChange(selectedImage, null);
//                    performCrop(selectedImage);
                    break;
                case CROP_IMAGE:
                    extras = intent.getExtras();
                    // get the cropped bitmap
                    if (extras != null)
                        thePic = extras.getParcelable("data");
                    takenbio.photo.set(thePic != null);
                    if (thePic != null) {
                        String base64String = AndroidUtils.byteArrayToBase64(AndroidUtils.bitmapToByteArray(thePic));
                        AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.PHOTOPREF, base64String);
                        Toasty.success(getContext(), "Successfully Cropped Image").show();
                    }
                    break;
                case UCrop.REQUEST_CROP:
                    final Uri resultUri = UCrop.getOutput(intent);
                    // get the cropped bitmap
                    try {
                        thePic = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), resultUri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    takenbio.photo.set(thePic != null);
                    if (thePic != null) {
                        String base64String = AndroidUtils.byteArrayToBase64(AndroidUtils.bitmapToByteArray(thePic));
                        AndroidUtils.savePreferenceData(getActivity(), AndroidUtils.PHOTOPREF, base64String);
                        clearCache(getContext());
                        Toasty.success(getContext(), "Successfully Cropped Image").show();
                    }
                    break;


            }
        } else {
            if (intent != null) {
                final Throwable cropError = UCrop.getError(intent);
                Toasty.error(getContext(), "" + cropError).show();
            } else {
//                try {
//                    takeCameraImage();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }

        }
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


    @Override
    public boolean onNextButtonHandler() {
        AndroidUtils.hideKeyboard(getActivity());
        return true;
    }
}
