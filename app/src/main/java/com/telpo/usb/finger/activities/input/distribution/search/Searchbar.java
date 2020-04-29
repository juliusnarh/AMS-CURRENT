package com.telpo.usb.finger.activities.input.distribution.search;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.utils.TransformingToolbar;

/**
 * A Toolbar with an EditText used for searching
 * <p>In a real life application you would hook up your TextWatcher to this method to track what the user is searching for</p>
 */
public class Searchbar extends TransformingToolbar {

    public EditText searchval;

    public Searchbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(context.getResources().getColor(android.R.color.white));
        setNavigationIcon(R.drawable.ic_action_back);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        inflate(getContext(), R.layout.merge_search, this);
        searchval = findViewById(R.id.toolbar_search_edittext);
    }

    @Override
    public void showContent() {
        super.showContent();
        searchval.requestFocus();
    }

    public void clearText() {
        searchval.setText(null);
    }

}
