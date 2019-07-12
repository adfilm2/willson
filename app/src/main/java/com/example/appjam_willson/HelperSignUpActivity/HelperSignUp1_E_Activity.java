package com.example.appjam_willson.HelperSignUpActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.FillinListActivity.List2Activity;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.WorryCategoryListAddModel;
import com.example.appjam_willson.model.WorryCategoryListAddResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HelperSignUp1_E_Activity extends AppCompatActivity implements OnClickListener {

    int REQUEST_CODE;

    RadioButton list1_etc_radiobtn;

    Button list1_etc_nextbtn;
    LinearLayout etc_custom_text;
    EditText etc_custom_edit_text;
    LinearLayout etc_usercustom_layout;

    LinearLayout list1_etc_backbtn;
    LinearLayout list1_etc_cancelbtn;

    LinearLayout background;

    private OneTextTwoButton_CustomDialog dialog;
    Context context;

    String resName;
    String packName;
    int resid;

    RadioButton visual;

    Typeface typebold;
    Typeface typereg;

    Bundle bundle1 = new Bundle();
    int category_listId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_etc);

        context = this;

        REQUEST_CODE = ((HelperSignUp1_E_Activity) context).getTaskId();

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        visual = findViewById(R.id.list1_etc_btn_visual);
        visual.setTypeface(typereg);

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


        list1_etc_cancelbtn = findViewById(R.id.toolbar_list_btn_cancel);
        list1_etc_cancelbtn.setOnClickListener(new list1_etc_cancelbtn_listener());

        list1_etc_backbtn = findViewById(R.id.toolbar_list_btn_backbtn);
        list1_etc_backbtn.setOnClickListener(new list1_etc_backbtn_listener());

        list1_etc_radiobtn = findViewById(R.id.list1_etc_btn_visual);
        list1_etc_radiobtn.setOnClickListener(new list1_etc_radiobtn_listener());

        list1_etc_nextbtn = findViewById(R.id.list1_etc_btn_next);
        list1_etc_nextbtn.setOnClickListener(this);

        etc_custom_text = findViewById(R.id.list1_etc_btn_usercustom);
        etc_custom_text.setOnClickListener(new etc_custom_btn_listener());

        etc_custom_edit_text = findViewById(R.id.list1_etc_usercustom_edittext);
        etc_custom_edit_text.setOnClickListener(new etc_custom_edit_Clicklistener());
        etc_custom_edit_text.setOnKeyListener(new etc_custom_edit_listener());
        etc_custom_edit_text.setTypeface(typebold);

        etc_usercustom_layout = findViewById(R.id.list1_etc_btn_usercustom_layout);

        background = findViewById(R.id.list_background);
        background.setOnClickListener(new list_background_listener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    bundle1 = data.getExtras();
                    bundle1.putInt("category_id",category_listId);
                    data.putExtras(bundle1);
                    setResult(RESULT_OK,data);
                    finish();

                case RESULT_CANCELED:
                    finish();
            }
        }
    }


    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        if(visual.isChecked()){
            category_listId = 22;

        }

        else if (etc_custom_edit_text.isFocused()){
            WorryCategoryListAddModel worryCategoryListAddModel = new WorryCategoryListAddModel();
            worryCategoryListAddModel.category_idx = 6;
            worryCategoryListAddModel.categoryList_name = etc_custom_edit_text.getText().toString();

            String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6Nywibmlja25hbWUiOiJhIiwiZ2VuZGVyIjoi7JesIiwiYWdlIjozNSwidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyNTkxNDE4LCJleHAiOjE1NzEyMzE0MTgsImlzcyI6IndpbGxzb24ifQ.8ZxnOA11-BUSyHqKj5piY1VMFxkua8Cy3BcZ5hCyBME";


            Call<WorryCategoryListAddResponseModel> call_helper = RetrofitService.getInstance().getService().concern_category_list_post(token,worryCategoryListAddModel);

            call_helper.enqueue(new Callback<WorryCategoryListAddResponseModel>() {
                @Override
                public void onResponse(Call<WorryCategoryListAddResponseModel> call, Response<WorryCategoryListAddResponseModel> response) {
                    Log.d("test", response.isSuccessful() + "");
                    WorryCategoryListAddResponseModel result = response.body();
                    Log.d("진로", ">>>>>>>>>>>" + response.code());
                    Log.d("이거는 서버에서 코드값", ">>>>>>>>>>>" + result.code);
                    category_listId= result.data.categoryList_idx;


                    Log.d(">>>>>ff>>> ",""+category_listId);
                    Intent intent = new Intent(context,HelperSignUpActivity2.class);
                    startActivityForResult(intent, REQUEST_CODE);

                }

                @Override
                public void onFailure(Call<WorryCategoryListAddResponseModel> call, Throwable t) {
                    t.printStackTrace();
                    Log.d(" 기타 액티비티 실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
                }


            });

        }
        else{}
        Intent intent = new Intent(context,HelperSignUpActivity2.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    class list1_etc_cancelbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list1_etc_backbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }

    class list1_etc_radiobtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            visual.setTypeface(typebold);
            etc_custom_edit_text.setTypeface(typereg);
            etc_custom_edit_text.setCursorVisible(false);
            list1_etc_radiobtn.setChecked(true);
            list1_etc_nextbtn.setEnabled(true);
            hidekeyboard(etc_custom_edit_text);
            etc_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
            int backcolor = getResources().getColor(R.color.lightPurple);
            etc_custom_edit_text.setTextColor(backcolor);
            String title;
            title = etc_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                etc_custom_text.setVisibility(View.VISIBLE);
                etc_custom_edit_text.setVisibility(View.INVISIBLE);
            }
        }
    }

    class etc_custom_btn_listener implements OnClickListener {
        @Override
        public void onClick(View v) {
            String title;
            title = etc_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_etc_nextbtn.setEnabled(false);
                etc_custom_text.setVisibility(View.VISIBLE);
                etc_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            visual.setTypeface(typereg);
            etc_custom_edit_text.setTypeface(typebold);
            list1_etc_radiobtn.setChecked(false);
            etc_custom_text.setVisibility(View.INVISIBLE);
            etc_custom_edit_text.setVisibility(View.VISIBLE);
            etc_custom_edit_text.setCursorVisible(true);
            etc_custom_edit_text.requestFocus();
            showkeyboard(etc_custom_edit_text);
            int backcolor = getResources().getColor(R.color.white);
            etc_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            etc_custom_edit_text.setTextColor(backcolor);
        }
    }

    class etc_custom_edit_Clicklistener implements OnClickListener {
        @Override
        public void onClick(View view) {
            String title;
            title = etc_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_etc_nextbtn.setEnabled(false);
                etc_custom_text.setVisibility(View.VISIBLE);
                etc_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            else{
                list1_etc_nextbtn.setEnabled(true);
            }
            visual.setTypeface(typereg);
            etc_custom_edit_text.setTypeface(typebold);
            list1_etc_radiobtn.setChecked(false);
            etc_custom_text.setVisibility(View.INVISIBLE);
            etc_custom_edit_text.setVisibility(View.VISIBLE);
            etc_custom_edit_text.setCursorVisible(true);
            int backcolor = getResources().getColor(R.color.white);
            etc_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            etc_custom_edit_text.setTextColor(backcolor);
        }
    }

    class etc_custom_edit_listener implements View.OnKeyListener {

        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {

            switch (i) {
                case KeyEvent.KEYCODE_ENTER :
                    hidekeyboard(etc_custom_edit_text);
                    String title;
                    title = etc_custom_edit_text.getText().toString();
                    if(title.getBytes().length <= 0) {
                        list1_etc_nextbtn.setEnabled(false);
                        etc_custom_text.setVisibility(View.VISIBLE);
                        etc_custom_edit_text.setVisibility(View.INVISIBLE);
                        etc_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                    }
                    etc_custom_edit_text.setCursorVisible(false);
            }
            return false;
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

    class list_background_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            if(etc_custom_edit_text.isFocused()){
                String title;
                title = etc_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    list1_etc_nextbtn.setEnabled(false);
                    etc_custom_text.setVisibility(View.VISIBLE);
                    etc_custom_edit_text.setVisibility(View.INVISIBLE);
                    etc_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                }
                else{
                    list1_etc_nextbtn.setEnabled(true);
                }
                hidekeyboard(etc_custom_edit_text);
                etc_custom_edit_text.setCursorVisible(false);
            }
        }
    }

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(HelperSignUp1_E_Activity.this, resid,
                "정말 그만두시겠어요?\n아직 하나도 작성하시지 않으셨어요!", "계속 작성하기", "그만하기", keepListener, exitListener);

        dialog.setCanceledOnTouchOutside(false);

        dialog.setCancelable(true);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
    }

    private OnClickListener keepListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    };

    private OnClickListener exitListener = new OnClickListener() {
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
