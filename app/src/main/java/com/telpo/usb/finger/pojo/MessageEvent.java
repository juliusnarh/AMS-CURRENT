package com.telpo.usb.finger.pojo;

/**
 * Created by Junior on 12/12/2017.
 */

public class MessageEvent {
    public String mMessage;
    public String action;

    public MessageEvent(String action, String message) {
        this.action = action;
        mMessage = message;
    }

    public String getAction() {
        return action;
    }

    public String getMessage() {
        return mMessage;
    }
}
