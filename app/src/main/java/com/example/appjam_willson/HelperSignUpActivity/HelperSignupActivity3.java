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

    View view;
    ImageView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up3);

        view = (View)findViewById(R.id.toolbar);
        btn =(ImageView)findViewById(R.id.cancel_btn);
        btn.setVisibility(View.INVISIBLE);

        context = this;

        REQUEST_CODE = ((HelperSignupActivity3) context).getTaskId();

        background = (LinearLayout) findViewById(R.id.signup_background);
        background.setOnClickListener(new signup_background_listener());

        signup_nextbtn = (Button) findViewById(R.id.next_btn);
        signup_nextbtn.setOnClickListener(new signup_nextbtn_listener());

        helper_info_edit = (EditText) findViewById(R.id.helper_intro);
        helper_info_edit.setOnFocusChangeListener(new info_focus());

        textCount = (TextView) findViewById(R.id.textViewCount);

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
                else signup_nextbtn.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });



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


}
