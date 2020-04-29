package com.telpo.usb.finger.editfragments;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orm.SugarRecord;
import com.scanlibrary.ScanActivity;
import com.scanlibrary.ScanConstants;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.ScanDocAdapter;
import com.telpo.usb.finger.databinding.FragmentEditSupportdocsBinding;
import com.telpo.usb.finger.entities.SupportDocs;
import com.telpo.usb.finger.pojo.ActivityInfoPojo;
import com.telpo.usb.finger.pojo.MessageEvent;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;
import com.telpo.usb.finger.utils.AndroidUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditSupportDocs extends DialogFragment implements ListDialogFragment.OnListDialogItemSelect {

    private static final String ARG_PARAM1 = "param1";
    private static final int REQUEST_CAMERA = 99;
    private static final int REQUEST_GALLERY = 88;
    EventBus bus = EventBus.getDefault();
    FragmentManager fm;
    ListDialogFragment dialogFragment;
    String[] listitems;
    SupportDocs supportdoc;
    ScanDocAdapter adapter;
    // FragmentEditActivityProfileBinding binding;
    FragmentEditSupportdocsBinding binding;
    ActivityInfoPojo activityInfo;
    List<SupportDocs> doclist;
    private String farmerid;

    public EditSupportDocs() {
        // Required empty public constructor
    }

    public static EditSupportDocs newInstance(String param1) {
        EditSupportDocs fragment = new EditSupportDocs();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public static Bitmap rotateBitmap(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            farmerid = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_supportdocs,
                container, false);
//        activityInfo = new ActivityInfoPojo();
//        binding.setActivity(activityInfo);
        getDialog().setTitle("Edit Support Docs");
        loadSupportDocs();
        doclist = new ArrayList<>();
        doclist = loadSupportDocs();
        setupRecyclerView(doclist);
        View view = binding.getRoot();

        binding.doctype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listitems = getResources().getStringArray(R.array.documenttype);
                showOptionDialog(listitems, "Select Support Doc", "supportdoc");
            }
        });

        binding.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSupportDocs();
            }
        });

        return view;
    }

    //method to load support docs information
    public List<SupportDocs> loadSupportDocs() {
        doclist = new ArrayList<>();
        try {
            doclist = SupportDocs.find(SupportDocs.class, "farmerid = ?", farmerid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return doclist;
    }

    public void saveSupportDocs() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
                AndroidUtils.showProgressDialog(getContext(), "Saving...");
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    if (!doclist.isEmpty()) {
                        for (SupportDocs docs : doclist) {
                            docs.setFarmerid(farmerid);
                            docs.macaddress = AndroidUtils.getMacAddress(getContext());
                            docs.imei = AndroidUtils.getIMEI(getContext());
                            docs.uniqueuid = AndroidUtils.getUUID();
                            docs.datecreated = new Date();
                            docs.agentname = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTNAME, "");
                            docs.agentid = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.AGENTID, "");
                            SugarRecord.save(docs);
                        }
                    }

                    ServerTransfer transfer = new ServerTransfer();
                    transfer.setSupportdocs(doclist);
                    String jsonstring = new Gson().toJson(transfer);

                    String uploadId = AndroidUtils.getUUID();
                    String uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
                    AndroidUtils.uploadFileToServer(getContext());

                    // AndroidUtils.syncUnsentFiles(getContext());

                    outcome = true;
                } catch (Exception e) {
                    bus.post(new MessageEvent("reload", "docs"));
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {
                AndroidUtils.dismissProgressDialog();
                if (outcome) {
                    Toasty.success(getContext(), "Record was successfully saved").show();
                    dismiss();
                }
            }
        };
        asyncTask.execute();
    }

    public List<SupportDocs> saveSupportDocs(String farmerid, String agentname, String agentid) {
        String docsjson = AndroidUtils.getPreferenceData(getContext(), AndroidUtils.DOCREF, "");
        System.out.println("Doc : " + docsjson);
        List<SupportDocs> docsList = AndroidUtils.getGsonList(docsjson, SupportDocs.class);

        try {
            if (!docsList.isEmpty()) {
                for (SupportDocs docs : docsList) {
                    docs.setFarmerid(farmerid);
                    docs.macaddress = AndroidUtils.getMacAddress(getContext());
                    docs.imei = AndroidUtils.getIMEI(getContext());
                    docs.uniqueuid = AndroidUtils.getUUID();
                    docs.agentname = agentname;
                    docs.agentid = agentid;
                    SugarRecord.save(docs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docsList;
    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        fm = getChildFragmentManager();//getSupportFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    //method to setup recycler view
    public void setupRecyclerView(List<SupportDocs> list) {
        binding.scandocrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.scandocrecycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        adapter = new ScanDocAdapter(list, getContext());
        binding.scandocrecycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    //method to scan document
    public void scanDocument() {
        Intent intent = new Intent(getContext(), ScanActivity.class);
        intent.putExtra(ScanConstants.OPEN_INTENT_PREFERENCE, ScanConstants.OPEN_CAMERA);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            ContentResolver resolver = getContext().getContentResolver();
            if (requestCode == REQUEST_CAMERA) {
                Uri uri = data.getExtras().getParcelable(ScanConstants.SCANNED_RESULT);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(resolver, AndroidUtils.compressImage(uri, getContext()));
                    resolver.delete(uri, null, null);
                    supportdoc = new SupportDocs();
                    supportdoc.setDocumenttype(binding.doctype.getText().toString());
                    supportdoc.setDocument(AndroidUtils.bitmapToByteArray(bitmap));
                    supportdoc.setUniqueuid(AndroidUtils.getUUID());
                    doclist.add(0, supportdoc);
                    adapter.notifyaddeddata();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == REQUEST_GALLERY) {
                if (data != null) {
                    Uri contentURI = data.getData();
                    try {
                        Bitmap bitmap = rotateBitmap(MediaStore.Images.Media.getBitmap(resolver, contentURI), 90f);
//                        resolver.delete(contentURI, null, null);
                        supportdoc = new SupportDocs();
                        supportdoc.setDocumenttype(binding.doctype.getText().toString());
                        supportdoc.setDocument(AndroidUtils.bitmapToByteArray(bitmap));
                        supportdoc.setUniqueuid(AndroidUtils.getUUID());
                        doclist.add(0, supportdoc);
                        adapter.notifyaddeddata();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getContext(), "Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        }
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, REQUEST_GALLERY);
    }

    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(getContext());
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
