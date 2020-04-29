package com.telpo.usb.finger.profile.fragments;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import androidx.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.FarmerSearchView;
import com.telpo.usb.finger.databinding.FarmerProfileFragmentBinding;
import com.telpo.usb.finger.dialogforms.AssignFarmerToAggregatorDialog;
import com.telpo.usb.finger.dialogforms.TemplateDialog;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.pojo.MessageEvent;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.yalantis.ucrop.UCrop;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;

import static android.app.Activity.RESULT_OK;
import static android.os.Environment.getExternalStoragePublicDirectory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FarmerProfileMainFragment extends Fragment implements AssignFarmerToAggregatorDialog.AssignToAggClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int CAMERA_RQ = 6969;
    public static String fileName;
    final int CROP_IMAGE = 5;
    FarmerProfileFragmentBinding binding;
    String farmerid;
    int tabindex;
    EventBus bus = EventBus.getDefault();
    String imageFilePath;
    private Uri imageUri;
    private int ASPECT_RATIO_X = 1, ASPECT_RATIO_Y = 1, bitmapMaxWidth = 1000, bitmapMaxHeight = 1000;
    private int IMAGE_COMPRESSION = 80;
    private boolean lockAspectRatio = true, setBitmapMaxWidthHeight = true;
    AssignFarmerToAggregatorDialog dialog = null;
    public FarmerProfileMainFragment() {
        // Required empty public constructor
    }

    public static FarmerProfileMainFragment newInstance(String farmerid, int tabindex) {
        FarmerProfileMainFragment fragment = new FarmerProfileMainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, farmerid);
        args.putInt(ARG_PARAM2, tabindex);
        fragment.setArguments(args);
        return fragment;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            farmerid = getArguments().getString(ARG_PARAM1);
            tabindex = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.farmer_profile_fragment, container, false);
        View view = binding.getRoot();
        bus.register(this);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(FarmerProfileInformation.newInstance(farmerid), "Personal Profile");
        adapter.addFragment(FarmerProfileServices.newInstance(farmerid), "Services");

        binding.viewpager.setAdapter(adapter);

        binding.home.setOnClickListener(view1 -> {
            Intent nav = new Intent(getContext(), FarmerSearchView.class);
            getContext().startActivity(nav);
            getActivity().finish();
        });

        binding.photoHeader.profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    openCamera();
                    takeCameraImage();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        binding.photoHeader.assignToAggregator.setOnClickListener(v -> {
            dialog = AssignFarmerToAggregatorDialog.newInstance(this, farmerid);
            dialog.show(getActivity().getSupportFragmentManager(), TemplateDialog.TAG);

        });
//        binding.tabs.setSelectedTabIndicatorColor(Color.parseColor("#EF5350"));
        binding.tabs.setSelectedTabIndicatorHeight((int) (1 * getResources().getDisplayMetrics()
                .density));
        binding.tabs.setTabTextColors(Color.WHITE, Color.WHITE);
        binding.tabs.setupWithViewPager(binding.viewpager);
        selectTab(tabindex);
        View photoHeader = view.findViewById(R.id.photoHeader);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            /* For devices equal or higher than lollipop set the translation above everything else */
            photoHeader.setTranslationZ(6);
            /* Redraw the view to show the translation */
            photoHeader.invalidate();
        }

        loadProfileSummary(farmerid);
        loadBiometrics(farmerid);
        return view;
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

    //method to switch the tabs
    public void selectTab(int pageIndex) {
        binding.tabs.setScrollPosition(pageIndex, 0f, true);
        binding.viewpager.setCurrentItem(pageIndex);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Bitmap thePic = null;
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CAMERA_RQ:
                    cropImage(getCacheImagePath(fileName));

                    break;
                case CROP_IMAGE:
                    Bundle extras = intent.getExtras();
                    thePic = extras.getParcelable("data");

                    if (thePic != null) {
                        byte[] croppedbytes = AndroidUtils.bitmapToByteArray(thePic);
                        saveBiometrics(croppedbytes);
                        AndroidUtils.setImageViewResource(binding.photoHeader.profilePic, croppedbytes);
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
                    if (thePic != null) {
                        byte[] croppedbytes = AndroidUtils.bitmapToByteArray(thePic);
                        saveBiometrics(croppedbytes);
                        AndroidUtils.setImageViewResource(binding.photoHeader.profilePic, croppedbytes);
                        Toasty.success(getContext(), "Successfully Cropped Image").show();
                    }
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

    //method to update userbiometrics
    public void saveBiometrics(final byte[] imagebytes) {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
                AndroidUtils.showProgressDialog(getContext(), "Saving...");
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    List<Userbiometrics> biolist = Userbiometrics.find(Userbiometrics.class, "farmerid = " +
                            "?", farmerid);
                    if (!biolist.isEmpty()) {
                        Userbiometrics bio = biolist.get(0);
                        bio.setPicture(imagebytes);
                        bio.save();
                        bus.post(new MessageEvent("reload", "photo"));


                        ServerTransfer transfer = new ServerTransfer();
                        transfer.setUserbiometrics(bio);
                        String jsonstring = new Gson().toJson(transfer);

                        String uploadId = AndroidUtils.getUUID();
                        String uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + "" +
                                ".txt");
                        AndroidUtils.uploadFileToServer(getContext());

                        outcome = true;
                    }
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
                    Toasty.success(getContext(), "Picture saved successfully").show();
                }
            }
        };
        asyncTask.execute();
    }

    public void openCamera() throws IOException {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            imageUri = FileProvider.getUriForFile(getContext(), getContext().getPackageName() + ".provider", createImageFile());
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        } else {
            imageUri = Uri.fromFile(createImageFile());
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        }
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            // Start the image capture intent to take photo
            startActivityForResult(intent, CAMERA_RQ);
        }

//        Intent intent = new Intent(getContext(), CameraActivity.class);
//        startActivityForResult(intent, CAMERA_RQ);
    }

    private File createImageFile() throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        imageFilePath = image.getAbsolutePath();
//        imageFilePath = "file:" + image.getAbsolutePath();
        return image;
    }


    /**
     * this function does the crop operation.
     */
    private void performCrop(Uri picUri) {
        // take care of exceptions
        try {
            // call the standard crop action intent (the user device may not
            // support it)
            Intent cropIntent = new Intent("com.android.camera.action.CROP");


            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                cropIntent.setDataAndType(picUri, "image/*");

                getContext().grantUriPermission("com.android.camera",
                        picUri,
                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);

                cropIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                cropIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }
            // indicate image type and Uri

            cropIntent.setDataAndType(picUri, "image/*");

            // set crop properties
            cropIntent.putExtra("crop", "true");
            // indicate aspect of desired crop
            cropIntent.putExtra("aspectX", 1);
            cropIntent.putExtra("aspectY", 1);
            // indicate output X and Y
            cropIntent.putExtra("outputX", 256);
            cropIntent.putExtra("outputY", 256);
            // retrieve data on return
            cropIntent.putExtra("return-data", true);
            // start the activity - we handle returning in onActivityResult
            startActivityForResult(cropIntent, CROP_IMAGE);
        }
        // respond to users whose devices do not support the crop action
        catch (ActivityNotFoundException anfe) {
            Toast toast = Toast
                    .makeText(getContext(), "This device doesn't support the crop action!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Subscribe
    public void onEvent(MessageEvent event) {
        System.out.println("Event Received: " + event.getMessage() + " Action: " + event
                .getAction());
        if (event.getAction().equalsIgnoreCase("reload")) {
            if (event.getMessage().equalsIgnoreCase("profile")) {
                loadProfileSummary(farmerid);
            } else if (event.getMessage().equalsIgnoreCase("photo")) {
                loadBiometrics(farmerid);
            }

        }
    }

    public void loadBiometrics(String farmerid) {
        try {
            Userbiometrics bio = Userbiometrics.find(Userbiometrics.class, "farmerid = ?",
                    farmerid).get(0);
            AndroidUtils.setImageViewResource(binding.photoHeader.profilePic, bio.getPicture());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to load profile picture, fullname and telephone
    public void loadProfileSummary(String farmerid) {
        try {
            Farmers farmer = Farmers.find(Farmers.class, "farmerid = ?", farmerid).get(0);
            binding.photoHeader.summaryfullname.setText(getString(R.string.full_name, farmer.getOthername(), farmer.getSurname()));
            binding.photoHeader.summarymobile.setText(farmer.tel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAssignToAggClickListener(String aggregatorid) {
        binding.photoHeader.assignToAggregator.setText(aggregatorid);
        if (dialog != null)
            dialog.dismiss();
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> titleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            titleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }


}
