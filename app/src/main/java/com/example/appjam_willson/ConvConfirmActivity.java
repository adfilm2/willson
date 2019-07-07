package com.example.appjam_willson;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ConvConfirmActivity extends AppCompatActivity {

    ImageView background;

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conv_confirm);

        start = (Button)findViewById(R.id.button2);
        start.setOnClickListener(new start_btn_listener());

        background = (ImageView)findViewById(R.id.back);
        Glide.with(this).load(R.drawable.match_complete).into(background);
    }

    class start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

}
