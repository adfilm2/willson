package com.example.appjam_willson.HelperSignUpActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

import org.w3c.dom.Text;

public class HelperSignupConfirm2Activity extends AppCompatActivity {

    LinearLayout cancel_btn;

    Button next_btn;

    View view;
    ImageView btn;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up_confirm_info);

        cancel_btn = (LinearLayout)findViewById(R.id.toolbar_helper_signup_confirm_btn_cancel);
        cancel_btn.setOnClickListener(new cancel_btn_listener());

        next_btn = (Button)findViewById(R.id.signup_info_btn_next);
        next_btn.setOnClickListener(new next_btn_listener());

        view = (View)findViewById(R.id.activity_helper_signup_toolbar);
        text = (TextView) findViewById(R.id.toolbar_text);
        text.setText("신분증 확인");
        btn =(ImageView)findViewById(R.id.back_btn);
        btn.setVisibility(View.INVISIBLE);

    }

    class cancel_btn_listener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            finish();
            //이거 하나만 지우는 건지 아니면 다 지우는 건지 모름
        }
    }

    class next_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //이거 누르면 끝나는 거임 다 완료
        }
    }

}
