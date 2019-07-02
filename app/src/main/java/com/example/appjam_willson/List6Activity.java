package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class List6Activity extends AppCompatActivity {

    LinearLayout linear1;
    LinearLayout linear2;
    LinearLayout linear3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list6);

        linear1 = (LinearLayout)findViewById(R.id.linear1);
        linear2 = (LinearLayout)findViewById(R.id.linear2);
        linear3 = (LinearLayout)findViewById(R.id.linear3);

    }


    public void click_1(View view) {
        linear1.setBackgroundResource(R.drawable.rounded_corner_thick);
        linear2.setBackgroundResource(R.drawable.rounded_corner_radius5);
        linear3.setBackgroundResource(R.drawable.rounded_corner_radius5);
    }
    public void click_2(View view) {
        linear1.setBackgroundResource(R.drawable.rounded_corner_radius5);
        linear2.setBackgroundResource(R.drawable.rounded_corner_thick);
        linear3.setBackgroundResource(R.drawable.rounded_corner_radius5);
    }
    public void click_3(View view) {
        linear1.setBackgroundResource(R.drawable.rounded_corner_radius5);
        linear2.setBackgroundResource(R.drawable.rounded_corner_radius5);
        linear3.setBackgroundResource(R.drawable.rounded_corner_thick);
    }
}
