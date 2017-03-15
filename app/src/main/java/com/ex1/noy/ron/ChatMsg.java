package com.ex1.noy.ron;

import java.util.Date;

/**
 * Created by noy on 14/03/2017.
 */

public class ChatMsg {
    private String msgText;
    private long msgTime;

    public ChatMsg(String msgText) {
        this.msgText = msgText;
        msgTime = new Date().getTime();

    }

    public ChatMsg() {
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public long getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(long msgTime) {
        this.msgTime = msgTime;
    }

}
