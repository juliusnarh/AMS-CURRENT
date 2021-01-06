package com.telpo.usb.finger.dialogforms;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.SelectInputAdapter;
import com.telpo.usb.finger.databinding.DialogAddpackageBinding;
import com.telpo.usb.finger.entities.AggregatorInputs;
import com.telpo.usb.finger.entities.AvailablePackages;
import com.telpo.usb.finger.entities.PackageItemDetail;
import com.telpo.usb.finger.entities.Packages;
import com.telpo.usb.finger.interfaces.PackageClickListener;
import com.telpo.usb.finger.interfaces.SelectedInputClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.RecyclerTouchListener;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ilhasoft.support.validation.Validator;
import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPackageDialog extends DialogFragment implements SelectedInputClickListener {
    Packages packages;
    DialogAddpackageBinding binding;
    Validator validator;
    List<AggregatorInputs> inputsList;
    List<AggregatorInputs> inputsListTest = new ArrayList<>();
    List<PackageItemDetail> detailsList;
    HashMap<String, String> quantityMap;
    MaterialDialog loading;
    PackageDetailsAdapter detailsAdapter;
    Handler mHandler = new Handler();
    int quantity;
    private String mParam1;
    private static final String ARG_PARAM1 = "param1";
    public static String TAG = "FullScreenDialog";
    public static PackageClickListener listener;

    public static AddPackageDialog newInstance(String eventtype, PackageClickListener xlistener) {
        AddPackageDialog dialog = new AddPackageDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, eventtype);
        listener = xlistener;
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
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_addpackage, container, false);
        View view = binding.getRoot();
        validator = new Validator(binding);
        createLoadingDialog();
        initializeVariables();
        getInputListFromDatabase();
        setupRecycleViewAndAdapter();
        toggleDetailsList();
        toggleInputList();
        setupClickListeners();
        binding.recycler.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), binding.recycler, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                new MaterialDialog.Builder(requireContext())
                        .title("Quantity")
                        .content("Please enter quantity per acreage.")
                        .theme(Theme.LIGHT)
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .input("Quantity", null, false, (dialog, input) -> {
                            quantity = Integer.parseInt(input.toString());
                            if (quantity > 0) {

                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        AndroidUtils.hideKeyboard(getActivity());
                                        AggregatorInputs in = inputsList.get(position);
                                        PackageItemDetail detail = new PackageItemDetail();
                                        detail.datecrated = new Date();
                                        detail.price = in.getSalePrice();
                                        detail.inputname = in.getInputName();
                                        detail.inputid = in.getInputId();
                                        detail.quantity = quantity;

                                        if (detailsAdapter.detailList.size() > 0)
                                            detailsAdapter.addItem(detail, detailsAdapter.detailList.size());
                                        else detailsAdapter.addItem(detail, 0);

                                        inputsListTest.add(in);
                                        toggleDetailsList();

                                    }
                                }, 600);
                            } else {
                                Toasty.error(requireContext(), "Quantity can not be 0").show();
                            }
                        })
                        .show();
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        return view;
    }

    private void toggleInputList() {
        if (inputsList.size() > 0) {
            if (binding.noitem.getVisibility() == View.VISIBLE)
                binding.noitem.setVisibility(View.GONE);

        } else binding.noitem.setVisibility(View.VISIBLE);
    }

    private void setupClickListeners() {
        binding.close.setOnClickListener(v -> closeDialog());

        binding.save.setOnClickListener(v -> {
            showLoadingDialog();
            if (inputsList.size() > 0) {
                if (binding.noitem.getVisibility() == View.VISIBLE)
                    binding.noitem.setVisibility(View.GONE);

                if (validator.validate()) {
                    List<AvailablePackages> avp = AvailablePackages.listAll(AvailablePackages.class);
                    boolean packageFound = false;
                    for (AvailablePackages availablePackages : avp) {
                        if (availablePackages.packagename.toLowerCase().equals(binding.packname.getText().toString().toLowerCase())) {
                            Toasty.error(requireContext(), "Package Name Already Taken").show();
                            binding.packname.requestFocus();
                            packageFound = true;
                        } else
                            packageFound = false;
                    }

                    if (!packageFound)
                        savepackage();
                    else
                        hideLoadingDialog();
                }
            } else {
                hideLoadingDialog();
                binding.noitem.setVisibility(View.VISIBLE);
                Toasty.error(requireContext(), "No Inputs Available").show();
            }
        });
    }

    private void toggleDetailsList() {
        if (detailsList.size() == 0)
            binding.noitemdetails.setVisibility(View.VISIBLE);
        else binding.noitemdetails.setVisibility(View.VISIBLE);
    }

    private void initializeVariables() {
        inputsList = new ArrayList<>();
        quantityMap = new HashMap<>();
        detailsList = new ArrayList<>();
    }

    private void getInputListFromDatabase() {
        inputsList = AggregatorInputs.listAll(AggregatorInputs.class);
    }

    private void setupRecycleViewAndAdapter() {
        SelectInputAdapter adapter = new SelectInputAdapter(getActivity(), inputsList, this);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(adapter);
        detailsAdapter = new PackageDetailsAdapter(getContext(), detailsList);
        binding.selectedrecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.selectedrecycler.setItemAnimator(new DefaultItemAnimator());
        binding.selectedrecycler.setAdapter(detailsAdapter);
    }

    private void createLoadingDialog() {
        loading = new MaterialDialog.Builder(requireContext())
                .content("Saving Package. Please Wait...")
                .progress(true, 0)
                .autoDismiss(true)
                .cancelable(false)
                .build();
    }

    private void showLoadingDialog() {
        loading.show();
    }

    private void hideLoadingDialog() {
        if (loading != null && loading.isShowing()) {
            loading.dismiss();
        }
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

    private void closeDialog() {
        new MaterialDialog.Builder(requireContext())
                .title("Cancel")
                .cancelable(false)
                .theme(Theme.LIGHT)
                .content("Do you want to close window?")
                .positiveText("yes")
                .negativeText("no")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dismiss();
                    }
                }).show();
    }

    @Override
    public void onSelectedInputClickListener(AggregatorInputs inputs, int quantity, int action) {
        if (action == 1) {
            inputsList.add(inputs);
            quantityMap.put(inputs.getInputName(), String.valueOf(quantity));
            String temp = "";
            for (Map.Entry quantmap : quantityMap.entrySet()) {
                if (!binding.selectedInputs.getText().toString().trim().isEmpty()) {
                    temp = binding.selectedInputs.getText().toString().trim();
                }

                binding.selectedInputs.setText(getResources().getString(R.string.preview, temp, quantmap.getKey(), quantmap.getValue()));
            }
        } else {
            try {
                inputsList.remove(inputs);
                quantityMap.remove(inputs.getInputName());
                if (inputsList.size() > 0) {
                    String temp = "";
                    for (Map.Entry quantmap : quantityMap.entrySet()) {
                        if (!binding.selectedInputs.getText().toString().trim().isEmpty()) {
                            temp = binding.selectedInputs.getText().toString().trim();
                        }

                        binding.selectedInputs.setText(getResources().getString(R.string.preview, temp, quantmap.getKey(), quantmap.getValue()));
                    }
                } else {
                    binding.selectedInputs.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Toasty.success(getContext(), "" + inputsList.size()).show();
    }

    public void savepackage() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... params) {

                try {
                    packages = new Packages();
                    AvailablePackages availablePackages = new AvailablePackages();
                    String packageid = genpackageid();
                    StringBuilder packagedetailsids = new StringBuilder(), contractBuilder = new StringBuilder();

                    for (int i = 0; i < detailsAdapter.detailList.size(); i++) {
                        PackageItemDetail detail = detailsAdapter.detailList.get(i);
                        contractBuilder.append(detail.getQuantity());
                        detail.packageitemdetailid = genpackagedetailsid(String.valueOf(i + 1), packageid);
                        detail.packageid = packageid;
                        detail.save();
                        packagedetailsids.append(detail.packageitemdetailid).append(',');
                    }

                    packages.packageid = packageid;
                    String temp = packagedetailsids.toString();
                    if (packagedetailsids.charAt(packagedetailsids.length() - 1) == ',') {
                        temp = packagedetailsids.toString().substring(0, packagedetailsids.length() - 1);
                    }
                    packages.packageitemdetailsids = temp;
                    packages.packagename = binding.packname.getText().toString().toLowerCase();
                    packages.datecrated = new Date();
                    packages.numberofitems = String.valueOf(detailsList.size());
                    packages.save();

                    availablePackages.packageid = packageid;
                    availablePackages.recoverybagsperacre = binding.recoverybags.getText().toString();
                    availablePackages.packagename = packages.packagename;
                    availablePackages.contract = contractBuilder.toString() + ":" + availablePackages.recoverybagsperacre;
                    availablePackages.datecreated = packages.datecrated;
                    availablePackages.save();
                    outcome = true;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    outcome = false;
                }

                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {
                Toasty.success(getContext(), "Package Saved").show();

                if (getDialog().isShowing() && getDialog() != null) {
                    hideLoadingDialog();
                    listener.onPackageClickListener(packages);
                    dismiss();
                }
            }
        };
        asyncTask.execute();
    }

//    private void saveAggProducts(List<PackageItemDetail> detailsList) {
//        for (int i = 0; i < inputsListTest.size(); i++) {
//            String uuid = AndroidUtils.getUUID();
//            AggregatorInputs item = inputsListTest.get(i);
//            item.quantity = detailsList.get(i).quantity;
//            try {
//                item.save();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private String genpackageid() {
        String date = AndroidUtils.dateToFormattedString(new Date(), "MMdd");
        String pkgname = binding.packname.getText().toString().trim();
        String temp = pkgname.substring(0, 3);
        String padding;
        if (Packages.count(Packages.class) > 0) {

            padding = String.format("%03d", Packages.count(Packages.class));
        } else {
            padding = String.format("%03d", Packages.count(Packages.class) + 1);

        }
        return temp + "-" + padding + "-" + date;
    }

    private String genpackagedetailsid(String index, String packageid) {
        return StringUtils.leftPad(index, 3) + "-" + packageid;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView ordername, quantity, orderamount, number;
        ImageView removebtn;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.item_details_list, parent, false));
            ordername = itemView.findViewById(R.id.order_name);
            quantity = itemView.findViewById(R.id.quantity);
            orderamount = itemView.findViewById(R.id.order_amount);
            number = itemView.findViewById(R.id.number);
            removebtn = itemView.findViewById(R.id.remove);
        }

    }

    private class PackageDetailsAdapter extends RecyclerView.Adapter<ViewHolder> {

        List<PackageItemDetail> detailList;
        Context context;

        PackageDetailsAdapter(Context context, List<PackageItemDetail> itemDetails) {
            detailList = itemDetails;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            PackageItemDetail detail = detailList.get(position);
            Resources res = holder.itemView.getResources();
            String temp = String.valueOf(holder.getLayoutPosition() + 1) + ".";
            holder.number.setText(temp);
            holder.ordername.setText(detail.getInputname());
            holder.quantity.setText(res.getString(R.string.xquantity, detail.getQuantity()));
            holder.orderamount.setText(res.getString(R.string.price_item, detail.getPrice()));

            holder.removebtn.setOnClickListener(v -> {
                new MaterialDialog.Builder(context)
                        .title("Delete")
                        .cancelable(false)
                        .theme(Theme.LIGHT)
                        .content("Do you want to remove item?")
                        .positiveText("yes")
                        .negativeText("no")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                removeItem(position);
                            }
                        }).show();
            });
        }

        @Override
        public int getItemCount() {
            return detailList.size();
        }


        void removeItem(int position) {
            detailList.remove(position);
            notifyItemRemoved(position);
        }

        public void addItem(PackageItemDetail detail, int position) {
            if (detailList.size() > 0)
                detailList.add(detail);
            else detailList.add(position, detail);
            notifyItemInserted(position);
        }
    }
}
