package com.example.appjam_willson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.MainActivities.MainActivity;

public class AskerProfileActivity extends AppCompatActivity {

    Button request_btn;
    Context context;

    View view;
    TextView textView;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asker_profile);
        view = (View)findViewById(R.id.toolbar_asker);
        textView = (TextView)findViewById(R.id.toolbar_text);
        textView.setText("헬퍼 프로필");
        back = (ImageView)findViewById(R.id.cancel_btn);
        back.setVisibility(View.INVISIBLE);



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
