package com.telpo.usb.finger.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.github.mikephil.charting.data.Entry;
import com.telpo.usb.finger.agent.fragment.AllAgentFragment;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.ChartPojo;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.HomePojo;
import com.telpo.usb.finger.pojo.inputdistribution.pojo.ReportPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * BottomNav
 * Created by Suleiman19 on 6/12/17.
 * Copyright (c) 2017. Suleiman Ali Shakir. All rights reserved.
 */

public class BottomBarAdapter extends FragmentPagerAdapter {
    private final List<AllAgentFragment> fragments = new ArrayList<>();
    AllAgentFragment currentFragment;


    public BottomBarAdapter(FragmentManager fm, HomePojo homePojo, ReportPojo reportPojo, ChartPojo chartPojo, List<Sales> serviceList, List<Scaletran> purchaselist, List<Scaletran> recoverylist, ArrayList<Entry> linechartvalues) {
        super(fm);

        fragments.clear();
        fragments.add(AllAgentFragment.newInstance(0, homePojo, serviceList, null, null, null));
        fragments.add(AllAgentFragment.newInstance(1, reportPojo, null, purchaselist, recoverylist, null));
        fragments.add(AllAgentFragment.newInstance(2, chartPojo, null, null, null, linechartvalues));
        fragments.add(AllAgentFragment.newInstance(3, null, null, null, null, null));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((AllAgentFragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    public AllAgentFragment getCurrentFragment() {
        return currentFragment;
    }

}
