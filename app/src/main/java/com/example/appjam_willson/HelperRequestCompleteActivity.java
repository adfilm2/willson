package com.example.appjam_willson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.MainActivities.HelperActivity;

public class HelperRequestCompleteActivity extends AppCompatActivity {

    Button start_btn;
    Intent intent;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_request_complete_loading);

        intent = getIntent();
        context = this;

        start_btn = (Button) findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new start_btn_listener());

    }

    class start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            intent = new Intent(context, HelperActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
