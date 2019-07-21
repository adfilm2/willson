package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

public class List1MentalityStartActivity extends AppCompatActivity {

    int REQUEST_CODE;

    LinearLayout toolbar_backbtn;
    Button mentality_start_btn;
    LinearLayout mentality_cancel_btn;
    Context context;

    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_mentality_start);

        context = this;

        REQUEST_CODE = ((List1MentalityStartActivity) context).getTaskId();

        toolbar_backbtn = findViewById(R.id.toolbar_list_btn_backbtn);
        toolbar_backbtn.setVisibility(View.INVISIBLE);

        mentality_start_btn = findViewById(R.id.list1_mentality_start_btn);
        mentality_start_btn.setOnClickListener(new mentality_start_btn_listener());

        mentality_cancel_btn = findViewById(R.id.toolbar_list_btn_cancel);
        mentality_cancel_btn.setOnClickListener(new mentality_cancel_btn_listener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:

                    bundle = data.getExtras();
                    bundle.putInt("category_idx",3);
                    data.putExtras(bundle);
                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }

    class mentality_start_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, List1MentalityActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    class mentality_cancel_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }
}
