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
import com.telpo.usb.finger.databinding.FragmentFarmsBinding;
import com.telpo.usb.finger.entities.GetSearchFarmInfo;

import java.util.List;

import es.dmoral.toasty.Toasty;
import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FarmsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FarmsFragment extends Fragment {
    static List<GetSearchFarmInfo> templist;
    static List<GetSearchFarmInfo> searchFarmInfoList;
    static AppCompatActivity activity;
    public FarmSearchAdapter adapter;
    protected Handler handler;
    boolean isLoading = false;
    int nextLimit = 0;
    private FragmentFarmsBinding binding;

    public FarmsFragment() {
        // Required empty public constructor
    }

    public static FarmsFragment newInstance(List<GetSearchFarmInfo> tlist, List<GetSearchFarmInfo> sList, AppCompatActivity act) {
        templist = tlist;
        searchFarmInfoList = sList;
        activity = act;
        return new FarmsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_farms, container, false);
        View view = binding.getRoot();

        adapter = new FarmSearchAdapter(getContext(), searchFarmInfoList, activity);

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
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == searchFarmInfoList.size() - 1) {
                        //bottom of list!
                        if (searchFarmInfoList.size() > nextLimit) {
                            loadMore();
                            isLoading = true;
                        }
                    }
                }
            }
        });
    }

    public void loadMore() {
        searchFarmInfoList.add(null);
        adapter.notifyItemInserted(searchFarmInfoList.size() - 1);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                searchFarmInfoList.remove(searchFarmInfoList.size() - 1);
                int scrollPosition = searchFarmInfoList.size();
                adapter.notifyItemRemoved(scrollPosition);
                int currentSize = scrollPosition;
                int temppos = currentSize;
                nextLimit = currentSize + 10;

                while (currentSize - 1 < nextLimit) {

                    try {
                        if (currentSize < templist.size()) {
                            searchFarmInfoList.add(templist.get(currentSize));
                            currentSize++;
                        } else break;
                    } catch (Exception e) {
                        e.printStackTrace();
//                        currentSize = nextLimit;
                        isLoading = false;
                        break;
                    }
                }

                if (temppos < searchFarmInfoList.size()) {
                    runLayoutAnimation();
                } else Toasty.success(getContext(), "All farms loaded").show();
                isLoading = false;
            }
        }, 3000);

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
