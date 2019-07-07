package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;

public class List6Activity extends AppCompatActivity {

    int REQUEST_CODE;

    LinearLayout linear1;
    LinearLayout linear2;
    LinearLayout linear3;

    LinearLayout background;

    LinearLayout list6_cancelbtn;
    LinearLayout list6_backbtn;
    private OneTextTwoButton_CustomDialog dialog;
    Button list6_nextbtn;
    Context context;

    EditText edit1;
    EditText edit2;
    EditText edit3;

    String helper_key1;
    String helper_key2;
    String helper_key3;

    Bundle bundle6 = new Bundle();

    String resName;
    String packName;
    int resid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list6);

        context =this;

        REQUEST_CODE = ((List6Activity) context).getTaskId();

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


        list6_nextbtn = (Button) findViewById(R.id.button1);
        list6_nextbtn.setOnClickListener(new list6_nextbtn_listener());

        list6_cancelbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_cancel);
        list6_cancelbtn.setOnClickListener(new list6_cancelbtn_listener());

        list6_backbtn = (LinearLayout) findViewById(R.id.toolbar_list_btn_backbtn);
        list6_backbtn.setOnClickListener(new list6_backbtn_listener());

        linear1 = (LinearLayout)findViewById(R.id.linear1);
        linear2 = (LinearLayout)findViewById(R.id.linear2);
        linear3 = (LinearLayout)findViewById(R.id.linear3);

        edit1 = (EditText)findViewById(R.id.editText1);
        edit2 = (EditText)findViewById(R.id.editText2);
        edit3 = (EditText)findViewById(R.id.editText3);

        edit3.setFocusableInTouchMode(true);

        edit1.setOnFocusChangeListener(new edit1_focus());
        edit2.setOnFocusChangeListener(new edit2_focus());
        edit3.setOnFocusChangeListener(new edit3_focus());

        background = (LinearLayout)findViewById(R.id.list_background);
        background.setOnClickListener(new list_background_listener());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:

                    bundle6 = data.getExtras();
                    bundle6.putString("helper_keyword1",helper_key1);
                    bundle6.putString("helper_keyword2",helper_key2);
                    bundle6.putString("helper_keyword3",helper_key3);

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
            }
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
            finish();
        }
    }

    class list6_nextbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            helper_key1 = edit1.getText().toString();
            helper_key2 = edit2.getText().toString();
            helper_key3 = edit3.getText().toString();

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
            linear1.setBackgroundResource(R.drawable.rounded_corner_radius5);
            linear2.setBackgroundResource(R.drawable.rounded_corner_radius5);
            linear3.setBackgroundResource(R.drawable.rounded_corner_radius5);
            edit1.setCursorVisible(false);
            edit2.setCursorVisible(false);
            edit3.setCursorVisible(false);
        }
    }

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(List6Activity.this, resid,

                "벌써 70%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

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

}