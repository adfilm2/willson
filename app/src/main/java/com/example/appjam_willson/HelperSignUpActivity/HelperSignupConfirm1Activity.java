package com.example.appjam_willson.HelperSignUpActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;

public class HelperSignupConfirm1Activity extends AppCompatActivity {

    EditText phone1;
    EditText phone2;
    EditText phone3;

    LinearLayout background;

    EditText email;
    EditText link;

    Button next_btn;

    LinearLayout back_btn;

    View view;
    ImageView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_sign_up_confirm);

        view = (View)findViewById(R.id.activity_helper_signup_toolbar);
        btn =(ImageView)findViewById(R.id.cancel_btn);
        btn.setVisibility(View.INVISIBLE);

        background = (LinearLayout)findViewById(R.id.background);
        background.setOnClickListener(new back_click());

        phone1 = (EditText)findViewById(R.id.phone_num_1);
        phone2 = (EditText)findViewById(R.id.phone_num_2);
        phone3 = (EditText)findViewById(R.id.phone_num_3);

        phone1.setOnFocusChangeListener(new phone1_focus());
        phone2.setOnFocusChangeListener(new phone2_focus());
        phone3.setOnFocusChangeListener(new phone3_focus());

        back_btn = (LinearLayout)findViewById(R.id.toolbar_list_btn_backbtn);
        back_btn.setOnClickListener(new back_btn_listener());

        email = (EditText)findViewById(R.id.email);
        link = (EditText)findViewById(R.id.link);

        email.setOnFocusChangeListener(new email_focus());
        link.setOnFocusChangeListener(new link_focus());

        next_btn = (Button)findViewById(R.id.confirm_btn_next);
        next_btn.setOnClickListener(new nex_btn_listener());

        phone1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.length() == 0 || phone2.getText().toString().length() == 0 || phone1.getText().toString().length() == 0 || email.getText().toString().length() == 0) {
                    next_btn.setEnabled(false);
                }
                else next_btn.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        phone2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.length() == 0 || phone2.getText().toString().length() == 0 || phone1.getText().toString().length() == 0 || email.getText().toString().length() == 0) {
                    next_btn.setEnabled(false);
                }
                else next_btn.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        phone3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.length() == 0 || phone2.getText().toString().length() == 0 || phone1.getText().toString().length() == 0 || email.getText().toString().length() == 0) {
                    next_btn.setEnabled(false);
                }
                else next_btn.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.length() == 0 || phone2.getText().toString().length() == 0 || phone1.getText().toString().length() == 0 || phone3.getText().toString().length() == 0) {
                    next_btn.setEnabled(false);
                }
                else next_btn.setEnabled(true);

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    class back_btn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
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

        }
    }

}
