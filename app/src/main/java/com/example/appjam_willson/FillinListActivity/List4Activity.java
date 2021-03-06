package com.example.appjam_willson.FillinListActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;

public class List4Activity extends AppCompatActivity {

    int REQUEST_CODE;

    EditText editTextSMS;

    TextView textViewCount;

    private OneTextTwoButton_CustomDialog dialog;
    LinearLayout list4_cancelbtn;
    LinearLayout list4_backbtn;
    Button list4_nextbtn;

    Context context;

    Bundle bundle = new Bundle();
    LinearLayout background;

    String resName;
    String packName;
    int resid;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list4);

        context = this;

        REQUEST_CODE = ((List4Activity) context).getTaskId();

        resName = "@drawable/request_couldnt_find";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


        list4_cancelbtn = findViewById(R.id.toolbar_list_btn_cancel);
        list4_cancelbtn.setOnClickListener(new list4_cancelbtn_listener());

        list4_backbtn = findViewById(R.id.toolbar_list_btn_backbtn);
        list4_backbtn.setOnClickListener(new list4_backbtn_listener());

        list4_nextbtn = findViewById(R.id.list4_btn1);
        list4_nextbtn.setOnClickListener(new list4_nextbtn_listener());

        background = findViewById(R.id.background);
        background.setOnClickListener(new background_listener());

        textViewCount = findViewById(R.id.textViewCount);
        editTextSMS = findViewById(R.id.list4_edittext);

        editTextSMS.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textViewCount.setText(Integer.toString(s.toString().length()));
                if (s.length() == 0 ) {
                    list4_nextbtn.setEnabled(false);
                }
                else list4_nextbtn.setEnabled(true);
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

                    bundle = data.getExtras();
                    bundle.putString("contents", editTextSMS.getText().toString());
                    data.putExtras(bundle);
                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }

    class background_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            hidekeyboard(editTextSMS);
        }
    }

    private void hidekeyboard(EditText edit) {
        InputMethodManager input = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        input.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }

    class list4_cancelbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list4_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }

    class list4_nextbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, List5Activity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }


    public void onButtonSendClicked(View v) {
        Toast toast = Toast.makeText(this, editTextSMS.getText(), Toast.LENGTH_LONG);
        toast.show();

    }

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(List4Activity.this, resid,
                "벌써 40%나 진행했어요!\n그래도 그만 작성하시겠어요?", "계속 작성하기", "그만하기", keepListener, exitListener);

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





