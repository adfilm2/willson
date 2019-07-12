package com.example.appjam_willson.HelperProfileEdit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

import com.example.appjam_willson.R;

public class HelperProfileEditActivityHash extends AppCompatActivity {

    TextView text;
    ImageView btn;
    LinearLayout cancelbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_profile_edit_hash);

        btn = (ImageView)findViewById(R.id.back_btn);
        btn.setVisibility(View.INVISIBLE);
        text = (TextView)findViewById(R.id.toolbar_text);
        text.setText("프로필 수정");
        cancelbtn = findViewById(R.id.toolbar_list_btn_cancel);
        cancelbtn.setOnClickListener(new HelperProfileEditActivityHash.cancelbtn_listener());




        Button nextbtn = (Button) findViewById(R.id.button1);



        btn.setOnClickListener(new HelperProfileEditActivityHash.list1_love_backbtn_listener());

        nextbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(HelperProfileEditActivityHash.this, HelperProfileEditActivityStart.class);
                startActivity(intentProfileEdit);


            }


        });
    }


    class list1_love_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }




}
