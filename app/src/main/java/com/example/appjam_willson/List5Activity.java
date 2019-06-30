package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class List5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list5);

        RadioButton man = (RadioButton)findViewById(R.id.man_btn);
        RadioButton woman = (RadioButton)findViewById(R.id.woman_btn);
        RadioButton all = (RadioButton)findViewById(R.id.all_btn);



    }


}
