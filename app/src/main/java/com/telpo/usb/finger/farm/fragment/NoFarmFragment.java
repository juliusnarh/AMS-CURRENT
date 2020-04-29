package com.telpo.usb.finger.farm.fragment;


import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.FarmSearchAdapter;
import com.telpo.usb.finger.databinding.FragmentNoFarmBinding;
import com.telpo.usb.finger.entities.GetSearchFarmInfo;

import java.util.List;

import es.dmoral.toasty.Toasty;
import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;

public class NoFarmFragment extends Fragment {
    static List<GetSearchFarmInfo> notemplist;
    static List<GetSearchFarmInfo> noFarmInfoList;
    static AppCompatActivity activity;
    public FarmSearchAdapter adapter;
    protected Handler handler;
    boolean isLoading = false;
    Runnable runnable = null;
    private FragmentNoFarmBinding binding;

    public NoFarmFragment() {
        // Required empty public constructor
    }

    public static NoFarmFragment newInstance(List<GetSearchFarmInfo> ntlist, List<GetSearchFarmInfo> nflist, AppCompatActivity act) {
        notemplist = ntlist;
        noFarmInfoList = nflist;
        activity = act;
        return new NoFarmFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_no_farm, container, false);
        View view = binding.getRoot();


        adapter = new FarmSearchAdapter(getContext(), noFarmInfoList, activity);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        binding.recycler.setLayoutManager(manager);
        binding.recycler.setItemAnimator(new FadeInLeftAnimator());
        binding.recycler.getItemAnimator().setAddDuration(800);
        binding.recycler.setDrawingCacheEnabled(true);
        binding.recycler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        binding.recycler.setAdapter(adapter);
        initScrollListener();


        return view;
    }

    private void initScrollListener() {
        binding.recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == noFarmInfoList.size() - 1) {
                        //bottom of list!
                        loadMore();
                        isLoading = true;
                    }
                }
            }
        });
    }

    public void loadMore() {
        noFarmInfoList.add(null);
        adapter.notifyItemInserted(noFarmInfoList.size() - 1);


        Handler handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                noFarmInfoList.remove(noFarmInfoList.size() - 1);
                int scrollPosition = noFarmInfoList.size();
                adapter.notifyItemRemoved(scrollPosition);
                int currentSize = scrollPosition;
                int temppos = currentSize;
                int nextLimit = currentSize + 10;
                boolean stop = false;
                while (currentSize - 1 < nextLimit) {

                    try {
                        if (currentSize < notemplist.size()) {
                            noFarmInfoList.add(notemplist.get(currentSize));
                            currentSize++;
                        } else break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        handler.removeCallbacks(runnable);
                        isLoading = false;
                        break;
                    }
                }


                if (temppos < noFarmInfoList.size()) {
                    runLayoutAnimation();
                } else Toasty.success(getContext(), "All farms loaded").show();
                isLoading = false;
            }
        };
        handler.postDelayed(runnable, 3000);

    }

    private void runLayoutAnimation() {
        final Context context = binding.recycler.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);

        binding.recycler.setLayoutAnimation(controller);
        binding.recycler.getAdapter().notifyDataSetChanged();
        binding.recycler.scheduleLayoutAnimation();
    }

}
