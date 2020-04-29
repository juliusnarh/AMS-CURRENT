package com.telpo.usb.finger.utils;

import android.content.Context;
import android.util.AttributeSet;

import com.telpo.usb.finger.R;

/**
 * A white Toolbar with a Search icon as Up
 */
public class SimpleToolbar extends TransformingToolbar {

    public SimpleToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(context.getResources().getColor(android.R.color.white));
        setNavigationIcon(R.drawable.ic_action_search);
    }

}
