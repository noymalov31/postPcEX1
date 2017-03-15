package com.ex1.noy.ron;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noy on 15/03/2017.
 */

class ChatAddapter extends ArrayAdapter<ChatMsg> {
    private TextView chatText;
    private List<ChatMsg> listOfMsgs;
    private LinearLayout layout;

    public ChatAddapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ChatMsg> objects) {
        super(context, resource, objects);
        listOfMsgs = objects;
    }


    public void add(ChatMsg chatMsg) {
        super.add(chatMsg);
    }


    public int getCount(){
        return this.listOfMsgs.size();
    }
    public ChatMsg getItem(int index){
        return this.listOfMsgs.get(index);
    }

    public View getView (int position, View convertView, ViewGroup parent){
        View v = convertView;
        if (v == null){
            LayoutInflater inflatter = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflatter.inflate(R.layout.chat, parent, false);
        }
        layout = (LinearLayout) v.findViewById(R.id.msg1);
        ChatMsg msgObj = getItem(position);
        chatText = (TextView) v.findViewById(R.id.singleMsg);
        chatText.setText(msgObj.getMsgText());
        layout.setGravity(Gravity.LEFT);
        return v;
    }

    public Bitmap decodeToBitmap (byte[] decodedBytes){
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

}
