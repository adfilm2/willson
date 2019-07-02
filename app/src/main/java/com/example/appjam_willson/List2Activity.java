package com.example.appjam_willson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class List2Activity extends AppCompatActivity {

    public int check_num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
    }
    public void char_check(View view){
        Button nextbtn = (Button)findViewById(R.id.submit);
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
                Toast.makeText(getApplicationContext(), "성격은 최대 세 개까지 고를 수 있습니다.", Toast.LENGTH_SHORT).show();

            }
            else{
                checkBox.setChecked(false);
                check_num -= 1;

            }
        }

        if(check_num == 3) nextbtn.setEnabled(true);
        else nextbtn.setEnabled(false);



    }
}
