package com.telpo.usb.finger.activities.registration;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.scanlibrary.ScanActivity;
import com.scanlibrary.ScanConstants;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.ScanDocAdapter;
import com.telpo.usb.finger.databinding.ActivityScanDocsBinding;
import com.telpo.usb.finger.entities.SupportDocs;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

public class ScanDocsActivity extends AppCompatActivity implements ListDialogFragment
        .OnListDialogItemSelect {
    private static final int REQUEST_CAMERA = 99;
    private static final int REQUEST_GALLERY = 88;
    ActivityScanDocsBinding binding;
    List<SupportDocs> docsList;
    SupportDocs supportdoc;
    ScanDocAdapter adapter;
    FragmentManager fm;
    ListDialogFragment dialogFragment;
    String[] listitems;

    public static Bitmap rotateBitmap(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scan_docs);
        docsList = new ArrayList<>();
        setupRecyclerView(docsList);

//        binding.btnscandoc.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                scanDocument();
//            }
//        });

        binding.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AndroidUtils.showProgressDialog(ScanDocsActivity.this, "Saving....");
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            AndroidUtils.savePreferenceData(ScanDocsActivity.this, AndroidUtils.DOCREF, new Gson().toJson(docsList));

                            Intent intent = new Intent();
                            intent.putExtra("docs", true);
                            //intent.putExtra("docslist", new Gson().toJson(docsList));
                            setResult(RESULT_OK, intent);
                            finish();
                            AndroidUtils.dismissProgressDialog();
                        } catch (Exception e) {
                            Toast.makeText(getBaseContext(), "Error " + e, Toast.LENGTH_LONG)
                                    .show();
                        }
                    }
                });

            }
        });

        binding.doctype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listitems = getResources().getStringArray(R.array.documenttype);
                showOptionDialog(listitems, "Select Support Doc", "supportdoc");
            }
        });

    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        fm = getSupportFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    //method to setup recycler view
    public void setupRecyclerView(List<SupportDocs> list) {
        binding.scandocrecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.scandocrecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new ScanDocAdapter(list, this);
        binding.scandocrecycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    //method to add scanned document to recycler view
    public void addDocToRecyclerView() {

    }

    //method to scan document
    public void scanDocument() {
        Intent intent = new Intent(this, ScanActivity.class);
        intent.putExtra(ScanConstants.OPEN_INTENT_PREFERENCE, ScanConstants.OPEN_CAMERA);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, REQUEST_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                Uri uri = data.getExtras().getParcelable(ScanConstants.SCANNED_RESULT);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), AndroidUtils.compressImage(uri, ScanDocsActivity.this));
                    getContentResolver().delete(uri, null, null);
                    supportdoc = new SupportDocs();
                    supportdoc.setDocumenttype(binding.doctype.getText().toString());
                    supportdoc.setDocument(AndroidUtils.bitmapToByteArray(bitmap));
                    supportdoc.setUniqueuid(AndroidUtils.getUUID());
                    docsList.add(0, supportdoc);
                    adapter.notifyaddeddata();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == REQUEST_GALLERY) {
                if (data != null) {
                    Uri contentURI = data.getData();
                    try {

//                        Bitmap bitmap = null;
//                        if (contentURI != null) {
//                            bitmap = rotateBitmapOrientation(AndroidUtils.getRealPathFromURI(contentURI, getApplicationContext()));
//                        }
                        Bitmap bitmap = rotateBitmap(MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI), 90f);
//                        getContentResolver().delete(contentURI, null, null);
                        supportdoc = new SupportDocs();
                        supportdoc.setDocumenttype(binding.doctype.getText().toString());
                        supportdoc.setDocument(AndroidUtils.bitmapToByteArray(bitmap));
                        supportdoc.setUniqueuid(AndroidUtils.getUUID());
                        docsList.add(0, supportdoc);
                        adapter.notifyaddeddata();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(ScanDocsActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        }
    }

    private Bitmap convertByteArrayToBitmap(byte[] data) {
        return BitmapFactory.decodeByteArray(data, 0, data.length);
    }

    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select from gallery",
                "Capture with camera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                scanDocument();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("supportdoc")) {
            binding.doctype.setText(selection);
            showPictureDialog();
        }
    }
}
