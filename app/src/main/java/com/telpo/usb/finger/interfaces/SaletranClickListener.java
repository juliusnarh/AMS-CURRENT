package com.telpo.usb.finger.interfaces;

import com.telpo.usb.finger.entities.Salestran;

import de.hdodenhof.circleimageview.CircleImageView;

public interface SaletranClickListener {
    void onSaletranClickListener(int pos, Salestran salestran, CircleImageView imageView);
}