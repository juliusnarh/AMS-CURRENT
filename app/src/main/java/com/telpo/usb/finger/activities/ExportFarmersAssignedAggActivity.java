package com.telpo.usb.finger.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.AggregatorSearchAdapter2;
import com.telpo.usb.finger.databinding.ActivityExportFarmersAssignedAggBinding;
import com.telpo.usb.finger.entities.Aggregator;
import com.telpo.usb.finger.entities.FarmersUrl;
import com.telpo.usb.finger.entities.ServerFilesStatus;
import com.telpo.usb.finger.service.DownloadFailedFilesFromServer;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.ApiClient;
import com.telpo.usb.finger.utils.ApiService;
import com.telpo.usb.finger.utils.LoadFiles;
import com.telpo.usb.finger.utils.WriteResponseBodyToDisk;

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
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExportFarmersAssignedAggActivity extends AppCompatActivity implements AggregatorSearchAdapter2.AggregatorSearchAdapterListener {
    ActivityExportFarmersAssignedAggBinding binding;
    List<Aggregator> aggregatorList = new ArrayList<>();
    AggregatorSearchAdapter2 mAdapter;
    private ApiService apiService;
    private CompositeDisposable disposable = new CompositeDisposable();
    private PublishSubject<String> publishSubject = PublishSubject.create();
    private CompositeDisposable disposableFarmersList = new CompositeDisposable();
    private PublishSubject<String> publishSubjectFarmersList = PublishSubject.create();
    public static String TAG = "FARMERDOWNLOAD";
    private boolean retry = false;
    int count;
    Intent intentService;
    Handler mHandler = new Handler();
    Snackbar snackbar;
    String aggregatorid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_export_farmers_assigned_agg);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Farmer Export");
        mAdapter = new AggregatorSearchAdapter2(this, aggregatorList, this);
        intentService = new Intent(this, DownloadFailedFilesFromServer.class);
        setupNetworkApiClient();
        mHandler.postDelayed(() -> {
            if (checkInternetConnectivity()) {
                showSnackbar(R.color.md_green_500, R.color.white, "Internet connection available!");
                publishSubject.onNext("FBO");
            } else
                showSnackbar(R.color.md_red_500, R.color.white, "No internet connection!");
        }, 300);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        binding.content.recyclerView.setLayoutManager(mLayoutManager);
        binding.content.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.content.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.content.recyclerView.setAdapter(mAdapter);
        binding.content.progressContainer.setOnClickListener(v -> {
            if (retry) {
                binding.content.progressText.setText(R.string.please_wait_loading_aggregator_list);
                binding.content.progressBar.setVisibility(View.VISIBLE);
                if (checkInternetConnectivity())
                    publishSubject.onNext("FBO");
                else
                    showSnackbar(R.color.md_red_500, R.color.white, "");
            }
        });

    }

    private void showSnackbar(int backgroundColor, int textColor, String message) {
        snackbar = Snackbar.make(binding.parentView, message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), backgroundColor));
        TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(getResources().getColor(textColor));
        snackbar.show();
    }

    private void setupNetworkApiClient() {
        binding.content.headerText.setVisibility(View.GONE);
        binding.content.progressBar.setVisibility(View.VISIBLE);
        apiService = ApiClient.getClient().create(ApiService.class);
        DisposableObserver<List<Aggregator>> aggregatorObserver = getAllAggregatorObserver();
        DisposableObserver<List<FarmersUrl>> urlObserver = getUrlsObserver();

        disposable.add(
                publishSubject
                        .debounce(300, TimeUnit.MILLISECONDS)
                        .distinctUntilChanged()
                        .switchMapSingle((Function<String, Single<List<Aggregator>>>) s -> apiService.getAllAggregators(null, s)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread()))
                        .subscribeWith(aggregatorObserver));

        disposableFarmersList.add(
                publishSubjectFarmersList
                        .debounce(300, TimeUnit.MILLISECONDS)
                        .distinctUntilChanged()
                        .switchMapSingle((Function<String, Single<List<FarmersUrl>>>) s -> apiService.getAllFarmersAssignedToAgg(null, s, AndroidUtils.getPreferenceData(this, AndroidUtils.AGENTID, "agent"))
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread()))
                        .subscribeWith(urlObserver));
    }

    private DisposableObserver<List<Aggregator>> getAllAggregatorObserver() {
        return new DisposableObserver<List<Aggregator>>() {
            @Override
            public void onNext(List<Aggregator> aggregatorListServer) {
                if (aggregatorListServer.size() > 0) {
                    retry = false;
                    binding.content.progressContainer.setVisibility(View.GONE);
                    binding.content.headerText.setVisibility(View.VISIBLE);
                    aggregatorList.addAll(aggregatorListServer);
                    runLayoutAnimation();
                }
            }

            @Override
            public void onError(Throwable e) {
                binding.content.progressBar.setVisibility(View.GONE);
                binding.content.progressText.setText(R.string.tap_retry);
                retry = true;
                Toasty.error(getApplicationContext(), "Error, try again").show();
                Log.e("AGGREGATOR DOWNLOAD", "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private DisposableObserver<List<FarmersUrl>> getUrlsObserver() {
        return new DisposableObserver<List<FarmersUrl>>() {
            @Override
            public void onNext(List<FarmersUrl> farmersUrlsList) {
                if (farmersUrlsList.size() > 0) {
                    count = 0;
                    Log.d(TAG, "URL SIZE::: " + farmersUrlsList.get(0).getLinks().size());
                    for (int i = 0; i < farmersUrlsList.get(0).getLinks().size(); i++) {
                        String url = farmersUrlsList.get(0).getLinks().get(i);
                        Call<ResponseBody> call = apiService.downloadFarmerJsonFiles(url);
                        makeHttpCall(call, url, farmersUrlsList.get(0).getLinks().size());
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("AGGREGATOR DOWNLOAD", "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private void makeHttpCall(Call<ResponseBody> callX, String url, int size) {
        List<ServerFilesStatus> filesStatus = ServerFilesStatus.find(ServerFilesStatus.class, "url = ?", url);

        callX.enqueue(new Callback<ResponseBody>() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "server contacted and has file");

                    new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected Void doInBackground(Void... voids) {

                            WriteResponseBodyToDisk responseBodyToDisk = new WriteResponseBodyToDisk(response.body(), url);

                            boolean writtenToDisk = responseBodyToDisk.writeResponseBodyToDisk();
                            List<ServerFilesStatus> filesStatus = ServerFilesStatus.find(ServerFilesStatus.class, "url = ?", url);

                            if (!writtenToDisk) {
                                if (filesStatus.size() == 0) {
                                    ServerFilesStatus status = new ServerFilesStatus(url, writtenToDisk);
                                    status.save();
                                }
                            } else {
                                if (filesStatus.size() > 0){
                                    filesStatus.get(0).delete();
                                    Call<ResponseBody> deleteCall = apiService.deleteDownloadedFile(null, responseBodyToDisk.getFileName(url.split("/")));
                                    deleteCall.enqueue(new Callback<ResponseBody>() {
                                        @Override
                                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                            Log.d(TAG, "SERVER FILE DELETE::: Success");
                                        }

                                        @Override
                                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                                            Log.d(TAG, "SERVER FILE DELETE::: Error");
                                        }
                                    });
                                }
                            }

                            Log.d(TAG, "file download was a success? " + writtenToDisk);
                            count += 1;
                            Log.d(TAG, "CURRENT COUNT OF FILE DOWNLOAD::: " + count);

                            runOnUiThread(() -> {
                                if (count == size) {
                                    AndroidUtils.dismissProgressDialog();
                                    new LoadFiles(ExportFarmersAssignedAggActivity.this, ExportFarmersAssignedAggActivity.this, aggregatorid);
                                }
                            });
                            return null;
                        }


                    }.execute();
                } else {
                    Log.d(TAG, "server contact failed");

                    if (filesStatus.size() == 0) {
                        ServerFilesStatus status = new ServerFilesStatus(url, false);
                        status.save();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "error");
                if (filesStatus.size() == 0) {
                    ServerFilesStatus status = new ServerFilesStatus(url, false);
                    status.save();
                }
            }
        });
    }

    @Override
    public void onAggregatorSelected(String aggregatorid) {
        ServerFilesStatus.deleteAll(ServerFilesStatus.class);
        AndroidUtils.showProgressDialog(ExportFarmersAssignedAggActivity.this, "Please wait. Downloading farmers.");
        this.aggregatorid = aggregatorid;
        publishSubjectFarmersList.onNext(aggregatorid);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(intentService);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intentService);
    }

    public boolean checkInternetConnectivity() {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public void runLayoutAnimation() {
        final Context context = binding.content.recyclerView.getContext();
        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        binding.content.recyclerView.setLayoutAnimation(controller);
        binding.content.recyclerView.getAdapter().notifyDataSetChanged();
        binding.content.recyclerView.scheduleLayoutAnimation();
    }
}
