package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class AgreementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.check1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.check2);



    }
}
