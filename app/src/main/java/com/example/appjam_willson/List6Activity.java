package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class List6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list6);
    }

    public void thicker(View view) {
        EditText text = (EditText)view;
        text.setBackgroundResource(R.drawable.rounded_corner_thick);
    }
}
