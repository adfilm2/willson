package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class AgreementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);


    }

    public void btn_check(View view) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.check1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.check2);
        Button submit = (Button) findViewById(R.id.submit);

        if(checkBox1.isChecked() && checkBox2.isChecked()){
            submit.setEnabled(true);
        } else{
            submit.setEnabled(false);
        }
    }
}
