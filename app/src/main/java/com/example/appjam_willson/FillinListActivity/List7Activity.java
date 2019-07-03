package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.CustomDialog;
import com.example.appjam_willson.R;

public class List7Activity extends AppCompatActivity {

    private CustomDialog dialog;
    LinearLayout list7_cancelbtn;
    LinearLayout list7_backbtn;
    Button list7_nextbtn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list7);

        context = this;

        list7_nextbtn = (Button) findViewById(R.id.submit);
        list7_nextbtn.setOnClickListener(new list7_nextbtn_listener());

        list7_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list7_cancelbtn.setOnClickListener(new list7_cancelbtn_listener());

        list7_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list7_backbtn.setOnClickListener(new list7_backbtn_listener());

    }

    class list7_cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list7_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class list7_nextbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, ListAgreementActivity.class);
            startActivity(intent);
        }
    }

    public void Dialog() {
        dialog = new CustomDialog(List7Activity.this,
                "벌써 75%나 진행했어요!\n그래도 그만 작성하시겠어요?", keepListener, exitListener);

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
