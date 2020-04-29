package com.telpo.usb.finger.registration.fragments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.pojo.CoordinateModel;
import com.telpo.usb.finger.pojo.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * Created by Junior on 12/11/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    EventBus bus = EventBus.getDefault();
    ArrayList<CoordinateModel> itemCoordinateModelList;

    public CustomAdapter(Context context, ArrayList<CoordinateModel> coordinateModelList) {
        this.context = context;
        this.itemCoordinateModelList = coordinateModelList;
    }

    @Override
    public int getCount() {
        return itemCoordinateModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemCoordinateModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = null;

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item, null);
            TextView latfarm = convertView.findViewById(R.id.latfarm);
            TextView longfarm = convertView.findViewById(R.id.longfrm);
            ImageView imgRemove = convertView.findViewById(R.id.imgRemove);
            CoordinateModel m = itemCoordinateModelList.get(position);
            latfarm.setText(m.getLat());
            longfarm.setText(m.getLongt());
            // click listiner for remove button
            imgRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String lat = itemCoordinateModelList.get(position).getLat();
                    String longt = itemCoordinateModelList.get(position).getLongt();

                    itemCoordinateModelList.remove(position);
                    bus.post(new MessageEvent("removemarker", lat + "#" + longt));
                    notifyDataSetChanged();
                }
            });
        }
        return convertView;
    }
}