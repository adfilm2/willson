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

public class List6Activity extends AppCompatActivity {

    LinearLayout linear1;
    LinearLayout linear2;
    LinearLayout linear3;
    LinearLayout list6_cancelbtn;
    LinearLayout list6_backbtn;
    private CustomDialog dialog;
    Button list6_nextbtn;
    Context context;

    String resName;
    String packName;
    int resid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list6);

        context =this;

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


        list6_nextbtn = (Button) findViewById(R.id.button1);
        list6_nextbtn.setOnClickListener(new list6_nextbtn_listener());

        list6_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list6_cancelbtn.setOnClickListener(new list6_cancelbtn_listener());

        list6_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list6_backbtn.setOnClickListener(new list6_backbtn_listener());



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

    class list6_cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list6_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    class list6_nextbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, List7Activity.class);
            startActivity(intent);
        }
    }

    public void Dialog() {
        dialog = new CustomDialog(List6Activity.this, resid,
                "벌써 62%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

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
