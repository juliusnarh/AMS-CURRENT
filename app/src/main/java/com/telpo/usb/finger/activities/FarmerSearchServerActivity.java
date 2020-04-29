package com.telpo.usb.finger.activities;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.FarmerServerSearchAdapter;
import com.telpo.usb.finger.databinding.ActivityFarmerSearchServerBinding;
import com.telpo.usb.finger.entities.GetServerSearchFarmerInfo;
import com.telpo.usb.finger.entities.GetSingleFarmerInfoServer;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.ApiClient;
import com.telpo.usb.finger.utils.ApiService;
import com.telpo.usb.finger.utils.Constants;

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

public class FarmerSearchServerActivity extends AppCompatActivity implements FarmerServerSearchAdapter.FarmerSearchAdapterListener{
    ActivityFarmerSearchServerBinding binding;
    Handler mHandler;
    Snackbar snackbar;
    GetServerSearchFarmerInfo searchFarmerInfo;
    ImageView imageView;
    String imageValue;
    TextView textView;
    private static final String TAG = FarmerSearchServerActivity.class.getSimpleName();
    private CompositeDisposable disposable = new CompositeDisposable();
    private CompositeDisposable disposableSingle = new CompositeDisposable();
    private PublishSubject<String> publishSubject = PublishSubject.create();
    private PublishSubject<String> publishSubjectSingle = PublishSubject.create();
    private ApiService apiService;
    private FarmerServerSearchAdapter mAdapter;
    private List<GetServerSearchFarmerInfo> serverSearchFarmerInfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_farmer_search_server);
        mHandler = new Handler();
        String initialSearch = getIntent().getStringExtra("search");
        binding.content.searchCount.setText(getString(R.string.search_count, 0));
        AndroidUtils.hideKeyboard(this);
        mHandler.postDelayed(() -> {
            if (checkInternetConnectivity()){
                snackbar = Snackbar.make(binding.parentView, "Internet connection available!", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.md_green_500));
                TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
                textView.setTextColor(getResources().getColor(R.color.white));
                snackbar.show();

            } else {
                snackbar = Snackbar.make(binding.parentView, "No internet connection!", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.md_red_500));
                TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
                textView.setTextColor(getResources().getColor(R.color.white));
                snackbar.show();
                showCloseRetryDialog();
            }
        }, 300);

        mAdapter = new FarmerServerSearchAdapter(this, serverSearchFarmerInfoList, this);
        textView = new TextView(this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.content.recyclerView.setLayoutManager(mLayoutManager);
        binding.content.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.content.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.content.recyclerView.setAdapter(mAdapter);

        binding.floatingSearchView.setOnQueryChangeListener((oldQuery, newQuery) -> textView.setText(newQuery));

        whiteNotificationBar(binding.content.recyclerView);
        setupApiClient();

        // passing empty string fetches all the contacts
        binding.floatingSearchView.setSearchText(initialSearch);
        publishSubject.onNext(initialSearch);
        binding.content.progressBar.setVisibility(View.VISIBLE);
    }

    private DisposableObserver<List<GetSingleFarmerInfoServer>> getSingleSearchObserver() {
        return new DisposableObserver<List<GetSingleFarmerInfoServer>>() {
            @Override
            public void onNext(List<GetSingleFarmerInfoServer> singleFarmerInfoServer) {
                AndroidUtils.dismissProgressDialog();
                if (singleFarmerInfoServer.get(0).getFarmerid() != null){
                    String s = new Gson().toJson(singleFarmerInfoServer.get(0));
                    Intent intent = new Intent(getApplicationContext(), FarmerSearchServerDetailsActivity.class);
                    intent.putExtra("transname", ViewCompat.getTransitionName(imageView));
                    intent.putExtra("image", imageValue);
//                    intent.putExtra(Constants.DETAILS, s);
                    AndroidUtils.savePreferenceData(FarmerSearchServerActivity.this, Constants.DETAILS, s);
                    Log.d("FARMERDETAILS:", s);
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(FarmerSearchServerActivity.this, imageView, ViewCompat.getTransitionName(imageView));

                    startActivity(intent, options.toBundle());
                }


            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }

    private DisposableObserver<List<GetServerSearchFarmerInfo>> getSearchObserver() {
        return new DisposableObserver<List<GetServerSearchFarmerInfo>>() {
            @Override
            public void onNext(List<GetServerSearchFarmerInfo> contacts) {
                binding.content.progressBar.setVisibility(View.GONE);
                serverSearchFarmerInfoList.clear();
                if (contacts.size() == 1) {
                    if (contacts.get(0).getName() != null) {
                        serverSearchFarmerInfoList.addAll(contacts);
                        binding.content.searchCount.setText(getString(R.string.search_count, contacts.size()));
                        runLayoutAnimation();
                    } else{
                        binding.content.searchCount.setText(getString(R.string.search_count, 0));
                        Toasty.error(getApplicationContext(), "No farmer found").show();
                    }
                } else {
                    serverSearchFarmerInfoList.addAll(contacts);
                    binding.content.searchCount.setText(getString(R.string.search_count, contacts.size()));
                    runLayoutAnimation();
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
                binding.content.progressBar.setVisibility(View.GONE);
                disposable.clear();
                disposableSingle.clear();
                ApiClient.resetApiClient();
                setupApiClient();
            }

            @Override
            public void onComplete() {
                binding.content.progressBar.setVisibility(View.GONE);

            }
        };
    }

    private DisposableObserver<TextViewTextChangeEvent> searchContactsTextWatcher() {
        return new DisposableObserver<TextViewTextChangeEvent>() {
            @Override
            public void onNext(TextViewTextChangeEvent textViewTextChangeEvent) {
                binding.content.progressBar.setVisibility(View.VISIBLE);
                Log.d(TAG, "Search query: " + textViewTextChangeEvent.text());

                publishSubject.onNext(textViewTextChangeEvent.text().toString().trim());
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    protected void onDestroy() {
        disposable.clear();
        disposableSingle.clear();
        super.onDestroy();
    }

    private void showCloseRetryDialog() {

    }

    public boolean checkInternetConnectivity(){
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

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }


    private void setupApiClient() {
        apiService = ApiClient.getClient().create(ApiService.class);

        DisposableObserver<List<GetServerSearchFarmerInfo>> observer = getSearchObserver();
        DisposableObserver<List<GetSingleFarmerInfoServer>> singleFarmerObserver = getSingleSearchObserver();

        disposable.add(
                publishSubject
                        .debounce(300, TimeUnit.MILLISECONDS)
                        .distinctUntilChanged()
                        .switchMapSingle((Function<String, Single<List<GetServerSearchFarmerInfo>>>) s -> apiService.getFarmers(null, s)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread()))
                        .subscribeWith(observer));

        disposableSingle.add(
                publishSubjectSingle
                        .debounce(300, TimeUnit.MILLISECONDS)
                        .distinctUntilChanged()
                        .switchMapSingle((Function<String, Single<List<GetSingleFarmerInfoServer>>>) s -> apiService.getFarmerDetails(null, s)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread()))
                        .subscribeWith(singleFarmerObserver));


        // skipInitialValue() - skip for the first time when EditText empty
        disposable.add(
                RxTextView.textChangeEvents(textView)
                        .skipInitialValue()
                        .debounce(300, TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(searchContactsTextWatcher()));

        disposable.add(observer);
        disposableSingle.add(singleFarmerObserver);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFarmerSelected(GetServerSearchFarmerInfo searchFarmerInfo , ImageView imageView, String imageValue) {
        AndroidUtils.showProgressDialog(FarmerSearchServerActivity.this, "Please wait... Fetching " + searchFarmerInfo.getFarmerid() + "'s information.");
        this.searchFarmerInfo = searchFarmerInfo;
        this.imageView = imageView;
        this.imageValue = imageValue;
        publishSubjectSingle.onNext(searchFarmerInfo.getFarmerid());
    }

    @Override
    protected void onResume() {
        super.onResume();
        publishSubjectSingle.onNext("");
    }
}
