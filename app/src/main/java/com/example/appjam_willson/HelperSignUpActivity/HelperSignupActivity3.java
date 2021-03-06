package com.example.appjam_willson.HelperSignUpActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

public class HelperSignupActivity3 extends AppCompatActivity {

    EditText helper_info_edit;
    TextView textCount;

    Context context;
    int REQUEST_CODE;

    Button signup_nextbtn;

    LinearLayout background;
    LinearLayout back;

    ImageView btn;
    String text;

    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up3);

        btn = findViewById(R.id.cancel_btn);
        btn.setVisibility(View.INVISIBLE);

        context = this;

        REQUEST_CODE = ((HelperSignupActivity3) context).getTaskId();

        background = findViewById(R.id.signup_background);
        background.setOnClickListener(new signup_background_listener());

        back = findViewById(R.id.back_btn_layout);
        back.setOnClickListener(new signup_backbtn_listener());

        signup_nextbtn = findViewById(R.id.next_btn);
        signup_nextbtn.setOnClickListener(new signup_nextbtn_listener());

        helper_info_edit = findViewById(R.id.helper_intro);
        helper_info_edit.setOnFocusChangeListener(new info_focus());

        textCount = findViewById(R.id.textViewCount);

        helper_info_edit.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textCount.setText(Integer.toString(s.toString().length()));
                if (s.length() == 0 ) {
                    signup_nextbtn.setEnabled(false);
                }
                else {
                    signup_nextbtn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    bundle.putString("title",helper_info_edit.getText().toString());
                    data.putExtras(bundle);
                    setResult(RESULT_OK,data);
                    finish();
                case RESULT_CANCELED:
                    finish();
            }
        }
    }

    class signup_nextbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, HelperSignupConfirm1Activity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    class signup_background_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            helper_info_edit.clearFocus();
            helper_info_edit.setCursorVisible(false);
            hidekeyboard(helper_info_edit);
        }
    }

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

    class info_focus implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean b) {
            if(b) {
                helper_info_edit.setCursorVisible(true);
            }
        }
    }
    class signup_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }
}
