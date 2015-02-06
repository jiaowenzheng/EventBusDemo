package com.android.eventbus.model;

/**
 * Created by Administrator on 2015/2/5.
 */
public class MessagesEvent {

    private String mMessage;

    public MessagesEvent(String message) {
        this.mMessage = message;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        this.mMessage = mMessage;
    }
}
