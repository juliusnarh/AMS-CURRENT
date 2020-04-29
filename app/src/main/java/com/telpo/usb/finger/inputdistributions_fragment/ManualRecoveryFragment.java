package com.telpo.usb.finger.inputdistributions_fragment;


import android.annotation.SuppressLint;
import androidx.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentManualRecoveryBinding;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.pojo.ServerTransfer;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.RecoveryPojo;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import br.com.ilhasoft.support.validation.Validator;
import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ManualRecoveryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManualRecoveryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final TextWatcher weightwatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
//            THIS BLOCK RECALLS PREVIOUS WEIGHTS AND CORRESPOND AMOUNT TO DISPLAY AMOUNT WHEN SAME WEIGHT IS ENTERED
//            if (weightprice.size() > 0) {
//                for (String wp : weightprice) {
//                    String[] parts = wp.split(":");
//                    if (parts[0].equals(pojo.weight.get())) {
//                        pojo.amount.set(parts[1]);
//                    }
//                }
//            }
        }
    };
    FragmentManualRecoveryBinding binding;
    RecoveryPojo pojo;
    private final TextWatcher countwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().isEmpty()) pojo.weight.set("0.0");
            else {
//                builder.append(s.toString());
//                pojo.count.set(s.toString());
                try {
                    pojo.weight.set(String.valueOf(Double.parseDouble(pojo.count.get()) * stdweight));
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                builder = new StringBuilder();
            }
        }
    };
    Validator validator;
    MaterialDialog prog, progs;
    Double totalweight = 0.00, prevweight = 0.00, stdweight = 50.0, amount = 0.00, moisturecontent = 0.00;
    String agentid, agentname, type, farmerid;
    double count = 0, payableamt = 0;
    List<Declaration> list;
    List<String> weightprice;
    List<Double> payableList;
    String farmerinfo[];

    public ManualRecoveryFragment() {
        // Required empty public constructor
    }

    public static ManualRecoveryFragment newInstance(String farmerid, String type) {
        ManualRecoveryFragment fragment = new ManualRecoveryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, farmerid);
        args.putString(ARG_PARAM2, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            farmerid = getArguments().getString(ARG_PARAM1);
            type = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_manual_recovery, container, false);
        View view = binding.getRoot();


        farmerinfo = AndroidUtils.loadFarmerInformation(farmerid);
        validator = new Validator(binding);
        pojo = new RecoveryPojo();
        binding.setRecov(pojo);
        pojo.farmerid.set(farmerid);
        pojo.name.set(farmerinfo[0]);
        pojo.phone.set(farmerinfo[5]);
//        pojo.count.set(String.valueOf(count));

        payableList = new ArrayList<>();
        list = new ArrayList<>();
        weightprice = new ArrayList<>();

        agentid = AndroidUtils.getPreferenceData(getActivity(), AndroidUtils.AGENTID, "");
        agentname = AndroidUtils.getPreferenceData(getActivity(), AndroidUtils.AGENTNAME, "");

        binding.totalweight.setText(getResources().getString(R.string.total_weight, totalweight));
        binding.totalamount.setText(getResources().getString(R.string.total_amount, amount));

        if (pojo.payable.get() == null) {
            binding.remainingBags.setText(getResources().getString(R.string.remaining, 0.0));
        } else
            binding.remainingBags.setText(getResources().getString(R.string.remaining, Double.parseDouble(pojo.payable.get())));

        binding.paidBags.setText(getResources().getString(R.string.recovered, 0.0));
        binding.weight.addTextChangedListener(weightwatcher);
        binding.count.addTextChangedListener(countwatcher);
        if (type.equals("0")) {
            if (checkiffarmerowes()) {
                binding.header.setText("Recovery");
                binding.forrecovery.setVisibility(View.VISIBLE);
                binding.remainingBags.setVisibility(View.VISIBLE);
                binding.paidBags.setVisibility(View.VISIBLE);
            } else {
                binding.form.setVisibility(View.GONE);
                binding.noowe.setVisibility(View.VISIBLE);
            }
        } else {
            binding.header.setText("Make Purchase");
            binding.forrecovery.setVisibility(View.GONE);
            binding.remainingBags.setVisibility(View.GONE);
            binding.paidBags.setVisibility(View.GONE);
        }


        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prog = new MaterialDialog.Builder(getActivity())
                        .content(R.string.please_wait)
                        .progress(true, 0)
                        .cancelable(false)
                        .build();
                prog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        prog.dismiss();
                        if (validator.validate()) {

                            if (type.equals("0")) {
                                double temp = Double.parseDouble(pojo.weight.get());
                                count += (temp / stdweight);

                                pojo.count.set(getResources().getString(R.string.price, count));

                                totalweight += temp;
                                binding.totalweight.setText(getResources().getString(R.string.total_weight, totalweight));

                                amount += (Double.parseDouble(pojo.amount.get().trim()) * (temp / stdweight));
                                binding.totalamount.setText(getResources().getString(R.string.total_amount, amount));

                                binding.paidBags.setText(getResources().getString(R.string.recovered, count));

                                binding.remainingBags.setText(
                                        getResources().getString(R.string.remaining, Double.parseDouble(pojo.payable.get()) - count)
                                );

                                weightprice.add(pojo.weight.get() + ":" + pojo.amount.get().trim());
                                pojo.weight.set("");

                                prevweight = temp;

                                if (count == payableamt) {
                                    Toasty.info(getContext(), "Items Recovered").show();
                                    binding.addBtn.setEnabled(false);
                                }

                            } else {

                                //dont touch here
                                double temp = Double.parseDouble(pojo.weight.get());
                                count += (temp / stdweight);
                                pojo.count.set(getResources().getString(R.string.price, count));
                                pojo.payable.set(getResources().getString(R.string.price, count));
                                totalweight += temp;
                                binding.totalweight.setText(getResources().getString(R.string.total_weight, totalweight));
                                amount += (Double.parseDouble(pojo.amount.get().trim()) * (temp / stdweight));
                                binding.totalamount.setText(getResources().getString(R.string.total_amount, amount));

                                weightprice.add(pojo.weight.get() + ":" + pojo.amount.get().trim());
                                pojo.weight.set("");
                                pojo.amount.set("");
                                prevweight = temp;
                            }
                        }
                    }
                }, 1000);

            }
        });

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prog = new MaterialDialog.Builder(getActivity())
                        .content(R.string.please_wait)
                        .progress(true, 0)
                        .cancelable(false)
                        .build();
                prog.show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        prog.dismiss();
                        if (validator.validate()) {

                            if (type.equals("0")) {

                                if (count == 0) {
                                    double temp = Double.parseDouble(pojo.weight.get());
                                    count += (temp / stdweight);
                                    pojo.count.set(getResources().getString(R.string.price, count));
                                    totalweight += temp;
                                    amount += (Double.parseDouble(pojo.amount.get().trim()) * (temp / stdweight));
                                    weightprice.add(pojo.weight.get() + ":" + pojo.amount.get().trim());
                                    saveRecovery();
                                } else {

                                    count = Double.parseDouble(pojo.count.get());

                                    totalweight = Double.parseDouble(pojo.weight.get()) * Integer.parseInt(pojo.count.get());
                                }

                                binding.paidBags.setText(getResources().getString(R.string.recovered, count));

                                if (pojo.payable.get() != null) {
                                    binding.remainingBags.setText(
                                            getResources().getString(R.string.remaining,
                                                    Double.parseDouble(pojo.payable.get()) - count)
                                    );
                                }

                            }
                            //////////////////////////////////////////////
                            else {

                                if (count == 0) {
                                    totalweight = Double.parseDouble(pojo.weight.get());
                                    count = totalweight / stdweight;
                                    pojo.payable.set(getResources().getString(R.string.price, count));
                                    pojo.count.set(getResources().getString(R.string.price, count));
                                }

                                amount += (Double.parseDouble(pojo.amount.get().trim()) * count);
                                saveRecovery();
                            }

                        } else {
                            if (count > 0) {
                                if (!binding.header.getText().toString().equalsIgnoreCase("recovery")) {
                                    pojo.payable.set(getResources().getString(R.string.price, count));

                                }
                                saveRecovery();
                            } else Toasty.error(getContext(), "Invalid form").show();
                        }
                    }
                }, 700);
            }
        });

        return view;
    }

    private boolean checkiffarmerowes() {
        list = Declaration.find(Declaration.class, "farmerid = ? and status = ?", farmerid, "owing");
        if (list.size() > 0) {
            for (Declaration declaration : list) {
                Double temp = Double.parseDouble(getResources().getString(R.string.price, declaration.getNorecoverybags()));
                payableamt += temp;
                payableList.add(temp);
            }
            pojo.payable.set(getResources().getString(R.string.price, payableamt));
            return true;
        } else return false;
    }

    private void saveRecovery() {
        if (Pattern.matches(AndroidUtils.fpRegex, pojo.moisturecontent.get())) {
            moisturecontent = Double.parseDouble(pojo.moisturecontent.get().trim());
        }
        pojo.count.set(String.valueOf(count));
        pojo.transid.set(genredemptransid());
        pojo.time.set(new Date().toString());
        pojo.date.set(new Date().toString());
        pojo.scaleid.set(agentid);
        pojo.bcid.set(agentid);
        pojo.pcid.set(agentid);
        pojo.tendered.set(String.valueOf(count));
        pojo.weight.set(String.valueOf(totalweight));
        amount = Double.parseDouble(getResources().getString(R.string.price, amount));
        AndroidUtils.insertScaletran(pojo.transid.get(),
                pojo.farmerid.get(),
                pojo.scaleid.get(),
                pojo.pcid.get(),
                pojo.bcid.get(),
                pojo.name.get().replaceFirst(",", ""),
                pojo.phone.get(),
                pojo.payable.get(),
                pojo.tendered.get(),
                Double.parseDouble(pojo.count.get()),
                totalweight,
                moisturecontent,
                amount,
                new Date(),
                new Date(),
                AndroidUtils.getUUID(),
                "0",
                new Date(),
                AndroidUtils.getMacAddress(getContext()),
                AndroidUtils.getIMEI(getContext()),
                agentname, agentid);

        uploadForm();

    }

    public String genredemptransid() {
        if (binding.header.getText().toString().equalsIgnoreCase("recovery")) {
            return AndroidUtils.RECOVERY + AndroidUtils.getIMEI(getContext()) + AndroidUtils.dateToFormattedString(new Date(), "yyyyMMddHHmmss");
        } else
            return AndroidUtils.PURCHASE + AndroidUtils.getIMEI(getContext()) + AndroidUtils.dateToFormattedString(new Date(), "yyyyMMddHHmmss");
    }

    public void resetForm() {
        pojo.weight.set("");
        pojo.count.set("0");
        pojo.payable.set("");
        pojo.moisturecontent.set("");
        binding.remainingBags.setText("0");
        binding.totalamount.setText(getResources().getString(R.string.total_amount, 0.0));
        binding.totalweight.setText(getResources().getString(R.string.total_weight, 0.0));
        count = 0.00;
        totalweight = 0.00;
        amount = 0.00;
        payableamt = 0.00;
    }

    public void uploadForm() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
                progs = new MaterialDialog.Builder(getActivity())
                        .title(R.string.please_wait)
                        .content(R.string.uploading)
                        .progress(true, 0)
                        .cancelable(false)
                        .build();
                progs.show();
                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {


                    prepareuploadfiles();

                    try {
                        AndroidUtils.uploadFileToServer(getContext());

                    } catch (Exception exc) {
                        Toasty.error(getContext(), exc.getMessage()).show();
                    }

                    outcome = true;
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {
                progs.dismiss();
                if (outcome) {
                    Toasty.success(getContext(), "Submitted Successfully").show();

                    if (type.equals("0")) {

                        double newval;
                        ServerTransfer transfer = new ServerTransfer();
                        String jsonstring, uploadId, uploadfilepath;

                        Declaration declaration = new Declaration();
                        for (int i = 0; i < list.size(); i++) {
                            Declaration original = list.get(i);
                            double orig = payableList.get(i);
                            declaration = Declaration.findById(Declaration.class, original.getId());

                            List<Salestran> salestranList = Salestran.find(Salestran.class, "transactionid = ?", declaration.getTransactionid());

                            if (salestranList.size() > 0) {
                                Salestran salestran = salestranList.get(0);
                                if (count > 0) {

                                    if (orig > count) {
                                        newval = orig - count;
                                        count = 0;
                                        declaration.norecoverybags = newval;
                                        declaration.save();
                                    } else if (orig == count) {
                                        newval = orig - count;
                                        count = count - newval;
                                        declaration.norecoverybags = newval;
                                        declaration.status = "redeemed";
                                        if (salestran != null) {
                                            salestran.synstatus = "1";
                                            salestran.save();
                                        }
                                        declaration.save();
                                    } else if (count > orig) {
                                        count = count - orig;
                                        declaration.norecoverybags = 0;
                                        declaration.status = "redeemed";
                                        declaration.save();

                                        if (salestran != null) {
                                            salestran.synstatus = "1";
                                            salestran.save();
                                        }

                                    }

                                    transfer.setDeclaration(declaration);
                                    jsonstring = new Gson().toJson(transfer);
                                    uploadId = AndroidUtils.getUUID();
                                    uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");

                                    transfer = new ServerTransfer();
                                    transfer.setSalestran(salestran);
                                    jsonstring = new Gson().toJson(transfer);
                                    uploadId = AndroidUtils.getUUID();
                                    uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
                                }
                            } else break;
                        }

                        if (declaration.getFarmerid() != null) {
                            uploaddistribution();
                        }
                    } else {
                        list.clear();
                        Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
                        binding.container.startAnimation(fadeOut);
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.detach(ManualRecoveryFragment.this).attach(ManualRecoveryFragment.this).commit();
                        resetForm();
                    }
                }
            }
        };
        asyncTask.execute();
    }

    public void uploaddistribution() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {


                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    AndroidUtils.uploadFileToServer(getContext());
                    outcome = true;
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {
                progs.dismiss();
                ServerTransfer transfer = new ServerTransfer();
                String jsonstring, uploadId, uploadfilepath;

                if (outcome) {
                    list = Declaration.find(Declaration.class, "farmerid = ? and status = ?", farmerid, "redeemed");
                    for (Declaration declaration : list) {
                        List<Sales> sales = Sales.find(Sales.class, "transactionid = ?", declaration.getTransactionid());
                        for (Sales sales1 : sales) {
                            sales1.synstatus = "1";
                            sales1.save();

                            transfer.setSales(sales1);
                            jsonstring = new Gson().toJson(transfer);
                            uploadId = AndroidUtils.getUUID();
                            uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");

                        }
                    }

                    uploadsales();
                }
            }
        };
        asyncTask.execute();
    }

    public void uploadsales() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, String, Boolean> asyncTask = new AsyncTask<Void, String, Boolean>() {
            boolean outcome = false;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    AndroidUtils.uploadFileToServer(getContext());
                    outcome = true;
                } catch (Exception e) {
                    System.out.println("Exception" + e.getMessage());
                    e.printStackTrace();
                }
                return outcome;
            }

            @Override
            protected void onPostExecute(Boolean outcome) {
                list.clear();
                Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
                binding.container.startAnimation(fadeOut);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(ManualRecoveryFragment.this).attach(ManualRecoveryFragment.this).commit();
                resetForm();
            }
        };
        asyncTask.execute();
    }

    private void prepareuploadfiles() {
        String jsonstring, uploadId, uploadfilepath;
        ServerTransfer transfer;
        List<Scaletran> scaletranList = Scaletran.find(Scaletran.class, "transid = ?", pojo.transid.get());
        if (scaletranList.size() > 0) {
            for (Scaletran scaletran : scaletranList) {
                if (scaletran != null) {
                    transfer = new ServerTransfer();
                    transfer.setScaletran(scaletran);
                    jsonstring = new Gson().toJson(transfer);
                    uploadId = AndroidUtils.getUUID();
                    uploadfilepath = AndroidUtils.writeToFile(jsonstring, uploadId + ".txt");
                }
            }
        }

    }
}
