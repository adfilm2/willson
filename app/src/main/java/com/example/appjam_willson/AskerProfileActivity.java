package com.example.appjam_willson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.MainActivities.MainActivity;

public class AskerProfileActivity extends AppCompatActivity {

    Button request_btn;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asker_profile);

        context = this;
        request_btn = (Button)findViewById(R.id.floating_btn_request);

        request_btn.setOnClickListener(new request_conversation());
    }

    private class request_conversation implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent;
            intent = new Intent(context, MainActivity.class);
            startActivity(intent);
        }
    }

}
