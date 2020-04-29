package com.telpo.usb.finger.dialogforms;


import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.AggregatorSearchAdapter;
import com.telpo.usb.finger.databinding.FragmentAssignFarmerAggregatorDialogBinding;
import com.telpo.usb.finger.entities.Aggregator;
import com.telpo.usb.finger.pojo.SuccessFarmerAssignPojo;
import com.telpo.usb.finger.utils.ApiClient;
import com.telpo.usb.finger.utils.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import es.dmoral.toasty.Toasty;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AssignFarmerToAggregatorDialog extends DialogFragment implements AggregatorSearchAdapter.AggregatorSearchAdapterListener {
    public static String TAG = "ASSIGNFARMERD";
    private FragmentAssignFarmerAggregatorDialogBinding binding;
    private String farmerid;
    public static AssignToAggClickListener listener;
    private static final String ARG_PARAM1 = "param1";
    List<Aggregator> aggregatorList = new ArrayList<>();
    AggregatorSearchAdapter mAdapter;
    private ApiService apiService;
    private CompositeDisposable disposable = new CompositeDisposable();
    private PublishSubject<String> publishSubject = PublishSubject.create();

    public static AssignFarmerToAggregatorDialog newInstance(AssignToAggClickListener listenerx, String farmerid) {
        AssignFarmerToAggregatorDialog templateDialog = new AssignFarmerToAggregatorDialog();
        listener = listenerx;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, farmerid);
        templateDialog.setArguments(args);
        return templateDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
        if (getArguments() != null) {
            farmerid = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_assign_farmer_aggregator_dialog, container, false);
        mAdapter = new AggregatorSearchAdapter(getContext(), aggregatorList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(requireContext());
        binding.recyclerView.setLayoutManager(mLayoutManager);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        binding.recyclerView.setAdapter(mAdapter);
        binding.progressBar.setVisibility(View.VISIBLE);
        createApiSerice();
        new LoadDataTask().execute();
        binding.loadMore.setOnClickListener(v -> {
            binding.loadMore.setEnabled(false);
            setupNetworkApiClient();
        });
        binding.close.setOnClickListener(v -> dismiss());
        return binding.getRoot();
    }

    private void createApiSerice() {
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    private void setupNetworkApiClient() {
        binding.progressBar.setVisibility(View.VISIBLE);
        DisposableObserver<List<Aggregator>> aggregatorObserver = getAllAggregatorObserver();
        disposable.add(
                publishSubject
                        .debounce(300, TimeUnit.MILLISECONDS)
                        .distinctUntilChanged()
                        .switchMapSingle((Function<String, Single<List<Aggregator>>>) s -> apiService.getAllAggregators(null, s)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread()))
                        .subscribeWith(aggregatorObserver));
        publishSubject.onNext("aggregator");
    }

    private DisposableObserver<List<Aggregator>> getAllAggregatorObserver() {
        return new DisposableObserver<List<Aggregator>>() {
            @Override
            public void onNext(List<Aggregator> aggregatorListServer) {
                if (aggregatorListServer.size() > 0) {
                    binding.progressBar.setVisibility(View.GONE);
//                    aggregatorList.addAll(aggregatorListServer);
                    binding.loadMoreContainer.setVisibility(View.GONE);
                    mAdapter.addAll(aggregatorListServer);
                }
            }

            @Override
            public void onError(Throwable e) {
                binding.progressBar.setVisibility(View.GONE);
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                binding.progressBar.setVisibility(View.GONE);
            }
        };
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

    @Override
    public void onAggregatorSelected(String aggregatorid) {
        binding.progressBar.setVisibility(View.VISIBLE);
        Call<SuccessFarmerAssignPojo> call = apiService.getAssignFarmerToAgg(null, aggregatorid, farmerid);

        call.enqueue(new Callback<SuccessFarmerAssignPojo>() {
            @Override
            public void onResponse(Call<SuccessFarmerAssignPojo> call, Response<SuccessFarmerAssignPojo> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
//                    Log.d(TAG, "Farmer assigned successful");
                    SuccessFarmerAssignPojo successPojo = response.body();
                    if (successPojo.getStatus().equalsIgnoreCase("successful")) {
                        Toasty.success(getContext(), successPojo.getMsg()).show();
                        dismiss();
                    } else
                        Toasty.error(getContext(), successPojo.getMsg()).show();
                } else {
                    Log.d(TAG, "Farmer assignment error");
                }
            }

            @Override
            public void onFailure(Call<SuccessFarmerAssignPojo> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                Log.d(TAG, "Farmer assignment error::: onFailure");
            }
        });
    }

    private class LoadDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... arg0) {
            aggregatorList = Aggregator.listAll(Aggregator.class);
            Log.d(TAG, "" + aggregatorList.size());
            getActivity().runOnUiThread(() -> {
                binding.progressBar.setVisibility(View.GONE);
                mAdapter.addAll(aggregatorList);
            });
            return null;
        }
    }

    public interface AssignToAggClickListener {
        void onAssignToAggClickListener(String aggregatorid);
    }
}
