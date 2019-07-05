package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

public class List1EtcStartActivity extends AppCompatActivity {

    int REQUEST_CODE;

    LinearLayout toolbar_backbtn;
    Button etc_start_btn;
    LinearLayout etc_cancel_btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_etc_start);

        context = this;

        REQUEST_CODE = ((List1EtcStartActivity) context).getTaskId();

        toolbar_backbtn = (LinearLayout)findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        etc_start_btn = (Button)findViewById(R.id.list1_etc_start_btn);
        etc_start_btn.setOnClickListener(new etc_start_btn_listener());

        etc_cancel_btn = (LinearLayout)findViewById(R.id.toolbar_list_btn_cancel);
        etc_cancel_btn.setOnClickListener(new etc_cancel_btn_listener());
    }

    class etc_start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, List1EtcActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    class etc_cancel_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }
}
