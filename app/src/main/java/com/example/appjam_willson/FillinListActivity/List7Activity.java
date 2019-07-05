package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;

public class List7Activity extends AppCompatActivity {

    int REQUEST_CODE;

    private OneTextTwoButton_CustomDialog dialog;
    LinearLayout list7_cancelbtn;
    LinearLayout list7_backbtn;
    Button list7_nextbtn;
    Context context;

    String resName;
    String packName;
    int resid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list7);

        context = this;

        REQUEST_CODE = ((List7Activity) context).getTaskId();

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


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
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(List7Activity.this, resid,
                "벌써 80%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

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
