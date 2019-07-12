package com.example.appjam_willson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.appjam_willson.ChatActivities.ChatActivity;

public class ConvConfirmActivity extends AppCompatActivity {

    ImageView background;

    Button start;

    String destinationUid;
    Context context;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conv_confirm);

        context = this;

        destinationUid = getIntent().getStringExtra("destinationUid");


        start = (Button)findViewById(R.id.button2);
        start.setOnClickListener(new start_btn_listener());

        background = (ImageView)findViewById(R.id.back);
        Glide.with(this).load(R.drawable.match_complete).into(background);
    }

    class start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            intent = new Intent(context, ChatActivity.class);
            intent.putExtra("destinationUid",destinationUid);
            startActivity(intent);
            finish();
        }
    }

}
