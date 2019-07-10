package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.text.TextWatcher;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;

import java.util.ArrayList;

public class List6Activity extends AppCompatActivity {

    int REQUEST_CODE;

    LinearLayout linear1;
    LinearLayout linear2;
    LinearLayout linear3;

    TextView textViewCount;

    LinearLayout background;

    LinearLayout list6_cancelbtn;
    LinearLayout list6_backbtn;
    private OneTextTwoButton_CustomDialog dialog;
    Button list6_nextbtn;
    Context context;

    EditText edit1;
    EditText edit2;
    EditText edit3;



    ArrayList experience = new ArrayList();

    Bundle bundle6 = new Bundle();

    String resName;
    String packName;
    int resid;

    Typeface typebold;
    Typeface typereg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list6);

        context =this;

        REQUEST_CODE = ((List6Activity) context).getTaskId();

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        list6_nextbtn = findViewById(R.id.button1);
        list6_nextbtn.setOnClickListener(new list6_nextbtn_listener());

        list6_cancelbtn = findViewById(R.id.toolbar_list_btn_cancel);
        list6_cancelbtn.setOnClickListener(new list6_cancelbtn_listener());

        list6_backbtn = findViewById(R.id.toolbar_list_btn_backbtn);
        list6_backbtn.setOnClickListener(new list6_backbtn_listener());

        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);

        edit1 = findViewById(R.id.editText1);
        edit2 = findViewById(R.id.editText2);
        edit3 = findViewById(R.id.editText3);

        edit1.setTypeface(typereg);
        edit2.setTypeface(typereg);
        edit3.setTypeface(typereg);

        edit3.setOnKeyListener(new edit_listener());

        edit1.setOnFocusChangeListener(new edit1_focus());
        edit2.setOnFocusChangeListener(new edit2_focus());
        edit3.setOnFocusChangeListener(new edit3_focus());

        textViewCount = findViewById(R.id.textViewCount);

        background = findViewById(R.id.list_background);
        background.setOnClickListener(new list_background_listener());



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
               if(edit1.length()!=0 || edit2.length()!=0|| edit3.length()!=0){
                   list6_nextbtn.setEnabled(true);
               }
               else{
                   list6_nextbtn.setEnabled(false);
               }

            }
        };


        edit1.addTextChangedListener(textWatcher);
        edit2.addTextChangedListener(textWatcher);
        edit3.addTextChangedListener(textWatcher);

        edit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0 ) {
                    edit1.setTypeface(typereg);
                }
                else edit1.setTypeface(typebold);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        edit2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0 ) {
                    edit2.setTypeface(typereg);
                }
                else edit2.setTypeface(typebold);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        edit3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0 ) {
                    edit3.setTypeface(typereg);
                }
                else edit3.setTypeface(typebold);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:

                    bundle6 = data.getExtras();
                    bundle6.putStringArrayList("experience",experience);

                    data.putExtras(bundle6);
                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }

    class edit1_focus implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean hasFocus) {
            if(hasFocus){
                linear1.setBackgroundResource(R.drawable.rounded_corner_thick);
                edit1.setCursorVisible(true);
                showkeyboard(edit1);
                if(edit1.length() > 0) {
                    edit1.setTypeface(typebold);
                }
                else {
                    edit1.setTypeface(typereg);
                }
                edit2.setTypeface(typereg);
                edit3.setTypeface(typereg);
                linear2.setBackgroundResource(R.drawable.rounded_corner_radius5);
                linear3.setBackgroundResource(R.drawable.rounded_corner_radius5);
            }
        }
    }

    class edit2_focus implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean hasFocus) {
            if(hasFocus){
                linear1.setBackgroundResource(R.drawable.rounded_corner_radius5);
                linear2.setBackgroundResource(R.drawable.rounded_corner_thick);
                edit2.setCursorVisible(true);
                showkeyboard(edit2);
                if(edit2.length() > 0) {
                    edit2.setTypeface(typebold);
                }
                else {
                    edit2.setTypeface(typereg);
                }
                edit1.setTypeface(typereg);
                edit3.setTypeface(typereg);
                linear3.setBackgroundResource(R.drawable.rounded_corner_radius5);
            }
        }
    }

    class edit3_focus implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean hasFocus) {
            if(hasFocus){
                linear1.setBackgroundResource(R.drawable.rounded_corner_radius5);
                linear2.setBackgroundResource(R.drawable.rounded_corner_radius5);
                linear3.setBackgroundResource(R.drawable.rounded_corner_thick);
                edit3.setCursorVisible(true);
                showkeyboard(edit3);
                if(edit3.length() > 0) {
                    edit3.setTypeface(typebold);
                }
                else {
                    edit3.setTypeface(typereg);
                }
                edit1.setTypeface(typereg);
                edit2.setTypeface(typereg);
            }
        }
    }

    class edit_listener implements View.OnKeyListener {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {

            switch (i) {
                case KeyEvent.KEYCODE_ENTER :
                    hidekeyboard(edit3);
                    edit3.setCursorVisible(false);
                    edit3.setTypeface(typereg);
                    linear3.setBackgroundResource(R.drawable.rounded_corner_radius5);
                    edit3.clearFocus();
            }
            return false;
        }
    }

    class list6_cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list6_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }

    class list6_nextbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            for(int i = 1; i<4;i++){
                if(edit1.length() > 0)
                    experience.add(edit1.getText().toString());
                if(edit2.length() > 0)
                    experience.add(edit2.getText().toString());
                if(edit3.length() > 0)
                    experience.add(edit3.getText().toString());

            }

            Intent intent = new Intent(context, List7Activity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    class list_background_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            hidekeyboard(edit1);
            hidekeyboard(edit2);
            hidekeyboard(edit3);
            edit1.setTypeface(typereg);
            edit2.setTypeface(typereg);
            edit3.setTypeface(typereg);
            linear1.setBackgroundResource(R.drawable.rounded_corner_radius5);
            linear2.setBackgroundResource(R.drawable.rounded_corner_radius5);
            linear3.setBackgroundResource(R.drawable.rounded_corner_radius5);
            edit1.setCursorVisible(false);
            edit2.setCursorVisible(false);
            edit3.setCursorVisible(false);
            edit1.clearFocus();
            edit2.clearFocus();
            edit3.clearFocus();
        }
    }

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

    private void showkeyboard(EditText edit){
        InputMethodManager input = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        input.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(List6Activity.this, resid,

                "벌써 70%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

        dialog.setCanceledOnTouchOutside(false);

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
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    };

    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("result", "BACK");
        setResult(REQUEST_CODE, intent);
        finish();
    }

}