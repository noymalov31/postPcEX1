package com.ex1.noy.ron;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ChatAddapter addapter;
    private ListView list;
    private EditText chatText;
    private ImageButton sendButton;
    private ArrayList<ChatMsg> arrayList = new ArrayList<ChatMsg>();
    static final String TEXT = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = (ImageButton) findViewById(R.id.bsend);
        list = (ListView) findViewById(R.id.list);
        addapter = new ChatAddapter(getApplicationContext(), R.layout.chat, arrayList);
        chatText = (EditText) findViewById(R.id.chat);
        if (savedInstanceState != null) {

        }

        chatText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    return sendChatMsg();
                }
                return false;
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendChatMsg();

            }
        });

        list.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        list.setAdapter(addapter);

    }

    private boolean sendChatMsg() {
        addapter.add(new ChatMsg(chatText.getText().toString()));
        chatText.setText("");
        // Hide keyboard after send.
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        chatText.setText(savedInstanceState.getString(TEXT));
        Parcelable listViewState = savedInstanceState.getParcelable("list.state");
        list.onRestoreInstanceState(listViewState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(TEXT, chatText.getText().toString());
        outState.putParcelable("list.state", list.onSaveInstanceState());


        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }
}
