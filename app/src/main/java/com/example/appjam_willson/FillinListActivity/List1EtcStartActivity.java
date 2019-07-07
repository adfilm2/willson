package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

public class List1EtcStartActivity extends AppCompatActivity {

    int REQUEST_CODE;

    LinearLayout toolbar_backbtn;
    Button etc_start_btn;
    LinearLayout etc_cancel_btn;
    Context context;
    Bundle bundle_etc = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_etc_start);

        context = this;

        REQUEST_CODE = ((List1EtcStartActivity) context).getTaskId();

        toolbar_backbtn = (LinearLayout)findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        etc_start_btn = (Button)findViewById(R.id.list1_etc_start_btn);
        etc_start_btn.setOnClickListener(new etc_start_btn_listener());

        etc_cancel_btn = (LinearLayout)findViewById(R.id.toolbar_list_btn_cancel);
        etc_cancel_btn.setOnClickListener(new etc_cancel_btn_listener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    bundle_etc = data.getExtras();
                    bundle_etc.putInt("category",6);
                    data.putExtras(bundle_etc);

                    //값 확인
//                    Integer category = data.getIntExtra("category",0);
//                    String small = data.getStringExtra("small category");
//                    String feeling = data.getStringExtra("feeling2");
//                    Integer importance = data.getIntExtra("importance",0);
//                    String contents = data.getStringExtra("contents");
//                    String sex = data.getStringExtra("helper sex");
//                    String char2 = data.getStringExtra("helper_char2");
//                    String key2 = data.getStringExtra("helper_keyword2");
//                    Integer empathy = data.getIntExtra("empathy",0);
//
//                    Log.d("category",">>>>>>> "+category);
//                    Log.d("small",">>>>>>> "+small);
//                    Log.d("feeling2",">>>>>>> "+feeling);
//                    Log.d("importance",">>>>>>> "+importance);
//                    Log.d("contents",">>>>>>> "+contents);
//                    Log.d("sex",">>>>>>> "+sex);
//                    Log.d("character",">>>>>>> "+char2);
//                    Log.d("keyword",">>>>>>> "+key2);
//                    Log.d("empathy",">>>>>>> "+empathy);

                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }

    class etc_start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, List1EtcActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    class etc_cancel_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }
}
