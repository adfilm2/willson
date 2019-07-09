package com.example.appjam_willson.HelperSignUpActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

import org.w3c.dom.Text;

public class HelperSignupConfirm2Activity extends AppCompatActivity {

    ImageView cancel_btn;

    Button next_btn;

    View view;
    ImageView btn;
    TextView text;
    Context context;
    int REQUEST_CODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up_confirm_info);

        context= this;
        REQUEST_CODE = ((HelperSignupConfirm2Activity) context).getTaskId();
        view = (View)findViewById(R.id.toolbar);
        text = (TextView) findViewById(R.id.toolbar_text);
        text.setText("신분증 확인");
        btn =(ImageView)findViewById(R.id.back_btn);
        btn.setVisibility(View.INVISIBLE);

        cancel_btn = (ImageView) view.findViewById(R.id.cancel_btn);
        cancel_btn.setOnClickListener(new cancel_btn_listener());

        next_btn = (Button)findViewById(R.id.signup_info_btn_next);
        next_btn.setOnClickListener(new next_btn_listener());

    }

    class cancel_btn_listener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }

    class next_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //이거 누르면 끝나는 거임 다 완료
        }
    }

}
