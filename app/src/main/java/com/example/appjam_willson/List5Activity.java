package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class List5Activity extends AppCompatActivity {

    public int check_num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list5);

    }

    public void char_check(View view){
        CheckBox checkBox = (CheckBox)view;

                if (check_num < 3) {
                    if (!checkBox.isChecked()) {
                        checkBox.setChecked(false);
                        check_num -= 1;
                        if(check_num<=0) check_num=0;

                    } else {
                        checkBox.setChecked(true);
                        check_num += 1;
                        if(check_num>3) check_num =3;

                    }
                } else {
                    if (checkBox.isChecked()) {
                        checkBox.setChecked(false);

                    }
                    else{
                        checkBox.setChecked(false);
                        check_num -= 1;

                    }
                }




    }


}




