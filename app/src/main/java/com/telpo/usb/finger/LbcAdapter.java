package com.telpo.usb.finger;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.telpo.usb.finger.pojo.GetLbcs;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Rebekkah_Boamah on 11/17/2017.
 */

class LbcAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 5;
    private OnLoadMoreListener onLoadMoreListener;
    private boolean isLoading;
    private Activity activity;
    private ArrayList<GetLbcs> lbcses = new ArrayList<>();
    private int visibleThreshold = 1;
    private int lastVisibleItem, totalItemCount;


    LbcAdapter(RecyclerView recyclerView, ArrayList<GetLbcs> lbcses, final Activity activity) {
        this.lbcses = lbcses;
        this.activity = activity;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                if (e.getActionMasked() == 2) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            totalItemCount = linearLayoutManager.getItemCount();//Toast.makeText(activity,totalItemCount+"",Toast.LENGTH_LONG).show();
                            lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                            if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                                if (onLoadMoreListener != null) {
                                    onLoadMoreListener.onLoadMore();
                                }
                                isLoading = true;
                            }
                        }
                    }, 1000);
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                //
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


            }
        });
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(activity).inflate(R.layout.design_lbc, parent, false);
            return new LbcAdapter.UserViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_loading, parent, false);
            return new LbcAdapter.LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LbcAdapter.UserViewHolder) {
            final GetLbcs lbc = lbcses.get(position);
            final LbcAdapter.UserViewHolder userViewHolder = (LbcAdapter.UserViewHolder) holder;
            userViewHolder.address.setText(lbc.getAddress());
            userViewHolder.company_name.setText(lbc.getName());
            userViewHolder.initialed.setText(lbc.getIni_string());
            userViewHolder.reCove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nave(lbc.getLbcid(), lbc.getName(), lbc.getIni_string(), lbc.getEmail(), lbc.getAddress(), lbc.getDistrict(), lbc.getRegion(), lbc.getPhone(), lbc.getLocation());
                }
            });
        } else if (holder instanceof LbcAdapter.LoadingViewHolder) {
            LbcAdapter.LoadingViewHolder loadingViewHolder = (LbcAdapter.LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
            loadingViewHolder.progressBar.setVisibility(View.VISIBLE);
        }
    }

    private void nave(String lbcid, String name, String subname, String email, String address, String district, String region, String phone, String loc) {
        Intent n = new Intent(activity, ViewLbc.class);
        n.putExtra("lbcid", lbcid);
        n.putExtra("lbcnamme", name);
        n.putExtra("subname", subname);
        n.putExtra("email", email);
        n.putExtra("address", address);
        n.putExtra("district", district);
        n.putExtra("region", region);
        n.putExtra("phone", phone);
        n.putExtra("loc", loc);
        activity.startActivity(n);
    }

    @Override
    public int getItemViewType(int position) {
        return lbcses.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    public int getItemCount() {
        return lbcses == null ? 0 : lbcses.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;

        LoadingViewHolder(View view) {
            super(view);
            progressBar = view.findViewById(R.id.prog);
        }
    }

    private class UserViewHolder extends RecyclerView.ViewHolder {
        TextView name, initialed, company_name, address;
        CircleImageView img;
        ImageView image;
        LinearLayout getReact, fedcomment;
        ImageView reactImg;
        CircleImageView profileImage;
        RelativeLayout reCove;

        UserViewHolder(View view) {
            super(view);

            initialed = view.findViewById(R.id.initialed);
            company_name = view.findViewById(R.id.company_name);
            address = view.findViewById(R.id.address);
            reCove = view.findViewById(R.id.reCove);

        }
    }
}
