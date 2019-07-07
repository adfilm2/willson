package com.example.appjam_willson.HelperProfileEdit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appjam_willson.FillinListActivity.List4Activity;
import com.example.appjam_willson.FillinListActivity.List5Activity;
import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;



////다음버튼 위로 올라오는 문제




public class HelperProfileEditActivityExp extends AppCompatActivity {
    int REQUEST_CODE;

    EditText editTextSMS;

    TextView textViewCount;

    private OneTextTwoButton_CustomDialog dialog;
    LinearLayout list4_cancelbtn;
    LinearLayout list4_backbtn;
    Button list4_nextbtn;

    Context context;

    String resName;
    String packName;
    int resid;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_profile_edit_exp);

        context = this;

       // REQUEST_CODE = ((com.example.appjam_willson.FillinListActivity.List4Activity) context).getTaskId();

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


        list4_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        //list4_backbtn.setOnClickListener(new com.example.appjam_willson.FillinListActivity.List4Activity.list4_backbtn_listener());

        list4_nextbtn = (Button) findViewById(R.id.helper_edit_exp_nextbtn);
        list4_nextbtn.setOnClickListener(new helper_edit_exp_nextbtn_listener());


        textViewCount = (TextView) findViewById(R.id.textViewCount);
        editTextSMS = (EditText) findViewById(R.id.list4_edittext);

        editTextSMS.addTextChangedListener(new TextWatcher() {

            @Override

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                textViewCount.setText(Integer.toString(s.toString().length()));

                if (s.length() == 0) {
                    list4_nextbtn.setEnabled(false);
                } else list4_nextbtn.setEnabled(true);

            }


            @Override

            public void afterTextChanged(Editable s) {

            }

        });

    }


    class list4_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class helper_edit_exp_nextbtn_listener  implements View.OnClickListener {
        @Override
        public void onClick(View view) {
//            Intent intent = new Intent(context, HelperProfileEditActivity0.class);
//            startActivityForResult(intent, REQUEST_CODE);
        }
    }

}


