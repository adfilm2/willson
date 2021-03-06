package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;
import com.example.appjam_willson.model.CreateWorryModel;

public class List1LoveStartActivity extends AppCompatActivity {

    int REQUEST_CODE;

    Bundle bundle = new Bundle();
    LinearLayout toolbar_backbtn;
    Button love_start_btn;
    LinearLayout love_cancel_btn;
    Context context;
    CreateWorryModel createWorryModel = new CreateWorryModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_love_start);

        context = this;

        REQUEST_CODE = ((List1LoveStartActivity) context).getTaskId();

        toolbar_backbtn = findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        love_start_btn = findViewById(R.id.list1_love_start_btn);
        love_start_btn.setOnClickListener(new love_start_btn_listener());

        love_cancel_btn = findViewById(R.id.toolbar_list_btn_cancel);
        love_cancel_btn.setOnClickListener(new love_cancel_btn_listener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    bundle = data.getExtras();
                    bundle.putInt("category_idx",1);
                    data.putExtras(bundle);
                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }
    class love_start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, List1LoveActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    class love_cancel_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();

        }
    }

}
