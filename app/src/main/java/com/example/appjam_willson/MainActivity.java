package com.example.appjam_willson;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.ChatFeedback_CustomDialog;


public class MainActivity extends AppCompatActivity {

    Dialog dialog;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Button btn = (Button) findViewById(R.id.button);
        ImageView cancel = (ImageView) findViewById(R.id.feedback_cancel);
        ImageView commit = (ImageView) findViewById(R.id.feedback_commit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog();
            }
        });

    }



    private View.OnClickListener cancel_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

    private View.OnClickListener commit_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

    public void Dialog() {
        dialog = new ChatFeedback_CustomDialog(MainActivity.this, cancel_listener, commit_listener);

        dialog.setCancelable(true);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
    }


}

