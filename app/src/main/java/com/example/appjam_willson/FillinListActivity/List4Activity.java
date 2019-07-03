package com.example.appjam_willson.FillinListActivity;

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

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.CustomDialog;
import com.example.appjam_willson.R;

public class List4Activity extends AppCompatActivity {

    EditText editTextSMS;

    TextView textViewCount;

    private CustomDialog dialog;
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
        setContentView(R.layout.activity_list4);

        context = this;

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


        list4_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list4_cancelbtn.setOnClickListener(new list4_cancelbtn_listener());

        list4_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list4_backbtn.setOnClickListener(new list4_backbtn_listener());

        list4_nextbtn = (Button) findViewById(R.id.list4_btn1);
        list4_nextbtn.setOnClickListener(new list4_nextbtn_listener());


        textViewCount = (TextView) findViewById(R.id.textViewCount);
        editTextSMS = (EditText) findViewById(R.id.list4_edittext);

        editTextSMS.addTextChangedListener(new TextWatcher() {

            @Override

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }



            @Override

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                textViewCount.setText(Integer.toString(s.toString().length()));

            }



            @Override

            public void afterTextChanged(Editable s) {

            }

        });

    }

    class list4_cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list4_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class list4_nextbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, List5Activity.class);
            startActivity(intent);
        }
    }


    public void onButtonSendClicked(View v) {

        Toast toast = Toast.makeText(this, editTextSMS.getText(), Toast.LENGTH_LONG);

        toast.show();


    }

    public void Dialog() {
        dialog = new CustomDialog(List4Activity.this, resid,
                "벌써 37%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

        dialog.setCancelable(true);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
    }

    private View.OnClickListener keepListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

    private View.OnClickListener exitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

}





