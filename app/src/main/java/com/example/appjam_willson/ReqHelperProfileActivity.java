package com.example.appjam_willson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReqHelperProfileActivity extends AppCompatActivity {

    Button start_btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req_helper_profile);

        context = ReqHelperProfileActivity.this;

        start_btn = (Button) findViewById(R.id.floating_btn_start);
        start_btn.setOnClickListener(new start_conversation());

    }

    private class start_conversation implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent;
            intent = new Intent(context, AskerProfileActivity.class);
            startActivity(intent);
        }
    }
}
