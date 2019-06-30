package com.example.appjam_willson;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class List1Activity extends AppCompatActivity implements OnClickListener {

    private RadioGroup list1_radioGroup1;
    private RadioGroup list1_radioGroup2;

    private Button list1_nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);

        list1_radioGroup1 = (RadioGroup) findViewById(R.id.list1_radioGroup1);
        list1_radioGroup1.clearCheck();
        list1_radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
        list1_radioGroup2 = (RadioGroup) findViewById(R.id.list1_radioGroup2);
        list1_radioGroup2.clearCheck();
        list1_radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);

        list1_nextbtn = (Button) findViewById(R.id.list1_btn_next);
        list1_nextbtn.setOnClickListener(this);
    }

    private OnCheckedChangeListener radioGroup_listener1 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                list1_radioGroup2.setOnCheckedChangeListener(null);
                list1_radioGroup2.clearCheck();
                list1_radioGroup2.setOnCheckedChangeListener(radioGroup_listener2);
            }
        }
    };

    private OnCheckedChangeListener radioGroup_listener2 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {
                list1_radioGroup1.setOnCheckedChangeListener(null);
                list1_radioGroup1.clearCheck();
                list1_radioGroup1.setOnCheckedChangeListener(radioGroup_listener1);
            }
        }
    };


    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        /*switch(v.getId()) {
            case R.id.list1_btn_next :
            if (list1_radioGroup1.getCheckedRadioButtonId() > 0) {
                View radioButton = list1_radioGroup1.findViewById(list1_radioGroup1.getCheckedRadioButtonId());
                int radioId = list1_radioGroup1.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) list1_radioGroup1.getChildAt(radioId);
            }
            else if(list1_radioGroup2.getCheckedRadioButtonId() > 0) {
                View radioButton = list1_radioGroup2.findViewById(list1_radioGroup2.getCheckedRadioButtonId());
                int radioId = list1_radioGroup2.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) list1_radioGroup2.getChildAt(radioId);
            }
        }*/

    }
}
