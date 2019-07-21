package com.example.appjam_willson.HelperSignUpActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

import static com.example.appjam_willson.R.id.back_btn_layout;

public class HelperSignupConfirm1Activity extends AppCompatActivity {

    EditText phone1;
    EditText phone2;
    EditText phone3;

    LinearLayout background;
    int REQUEST_CODE;
    Context context;

    EditText email;
    EditText link;

    Button next_btn;

    LinearLayout back_btn;

    View view;
    ImageView btn;

    LinearLayout picture;

    Bundle bundle4 = new Bundle();
    String userPhone;
    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up_confirm);

        view = findViewById(R.id.activity_helper_signup_toolbar);
        btn = findViewById(R.id.cancel_btn);
        btn.setVisibility(View.INVISIBLE);
        context = this;

        REQUEST_CODE = ((HelperSignupConfirm1Activity) context).getTaskId();

        picture = findViewById(R.id.picture);

        background = findViewById(R.id.background);
        background.setOnClickListener(new back_click());

        phone1 = findViewById(R.id.phone_num_1);
        phone2 = findViewById(R.id.phone_num_2);
        phone3 = findViewById(R.id.phone_num_3);

        phone1.setOnFocusChangeListener(new phone1_focus());
        phone2.setOnFocusChangeListener(new phone2_focus());
        phone3.setOnFocusChangeListener(new phone3_focus());

        back_btn = findViewById(back_btn_layout);
        back_btn.setOnClickListener(new back_btn_listener());

        email = findViewById(R.id.email);
        link = findViewById(R.id.link);

        email.setOnFocusChangeListener(new email_focus());
        link.setOnFocusChangeListener(new link_focus());

        next_btn = findViewById(R.id.confirm_btn_next);
        next_btn.setOnClickListener(new nex_btn_listener());

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if((phone1.length() != 0 && phone2.length() != 0 && phone3.length() != 0) && email.length() != 0) {
                    next_btn.setEnabled(true);
                }
                else{
                    next_btn.setEnabled(false);
                }
            }
        };

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HelperSignupConfirm2Activity.class);
                startActivity(intent);
            }
        });

        phone1.addTextChangedListener(textWatcher);
        phone2.addTextChangedListener(textWatcher);
        phone3.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);

    }

    class back_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }

    class phone1_focus implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean b) {
            phone1.setCursorVisible(true);
        }
    }

    class phone2_focus implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean b) {
            phone2.setCursorVisible(true);
        }
    }

    class phone3_focus implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean b) {
            phone3.setCursorVisible(true);
        }
    }

    class email_focus implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean b) {
            email.setCursorVisible(true);
        }
    }

    class link_focus implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean b) {
            link.setCursorVisible(true);
        }
    }

    class back_click implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            phone1.clearFocus();
            phone2.clearFocus();
            phone3.clearFocus();
            email.clearFocus();
            link.clearFocus();
            phone1.setCursorVisible(false);
            phone2.setCursorVisible(false);
            phone3.setCursorVisible(false);
            email.setCursorVisible(false);
            link.setCursorVisible(false);
            hidekeyboard(phone1);
            hidekeyboard(phone2);
            hidekeyboard(phone3);
            hidekeyboard(email);
            hidekeyboard(link);
        }
    }

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }


    class nex_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }
    }

}
