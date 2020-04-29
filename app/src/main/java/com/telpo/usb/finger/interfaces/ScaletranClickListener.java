package com.telpo.usb.finger.interfaces;

import com.telpo.usb.finger.entities.Scaletran;

import de.hdodenhof.circleimageview.CircleImageView;

public interface ScaletranClickListener {
    void onScaletranClickListener(int pos, Scaletran scaletran, CircleImageView imageView);
}