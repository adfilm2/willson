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
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.FillinListActivity.List2Activity;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.WorryCategoryListAddModel;
import com.example.appjam_willson.model.WorryCategoryListAddResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HelperSignUp1_R_Activity extends AppCompatActivity implements OnClickListener {

    int REQUEST_CODE;

    RadioGroup list1_relationships_radioGroup1;
    RadioGroup list1_relationships_radioGroup2;

    Button list1_relationships_nextbtn;
    LinearLayout relationships_custom_text;
    EditText relationships_custom_edit_text;
    LinearLayout relationships_usercustom_layout;

    LinearLayout list1_relationships_backbtn;
    LinearLayout list1_relationships_cancelbtn;

    LinearLayout background;

    private OneTextTwoButton_CustomDialog dialog;
    Context context;

    String resName;
    String packName;
    int resid;

    RadioButton family;
    RadioButton friend;
    RadioButton companion;
    RadioButton junior;

    Typeface typebold;
    Typeface typereg;

    Bundle bundle1= new Bundle();
    int category_listId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1_relationships);

        context = this;

        REQUEST_CODE = ((HelperSignUp1_R_Activity) context).getTaskId();

        typebold = getResources().getFont(R.font.nanum_square_b);
        typereg = getResources().getFont(R.font.nanum_square_r);

        family = findViewById(R.id.list1_relationships_btn_family);
        friend = findViewById(R.id.list1_relationships_btn_friends);
        companion = findViewById(R.id.list1_relationships_btn_companion);
        junior = findViewById(R.id.list1_relationships_btn_junior);

        family.setTypeface(typereg);
        friend.setTypeface(typereg);
        companion.setTypeface(typereg);
        junior.setTypeface(typereg);

        resName = "@drawable/list_img_alert_willson";
        packName = this.getPackageName();
        resid = getResources().getIdentifier(resName, "drawable", packName);


        list1_relationships_cancelbtn = findViewById(R.id.toolbar_list_btn_cancel);
        list1_relationships_cancelbtn.setOnClickListener(new list1_relationships_cancelbtn_listener());

        list1_relationships_backbtn = findViewById(R.id.toolbar_list_btn_backbtn);
        list1_relationships_backbtn.setOnClickListener(new list1_relationships_backbtn_listener());


        list1_relationships_radioGroup1 = findViewById(R.id.list1_relationships_radioGroup1);
        list1_relationships_radioGroup1.clearCheck();
        list1_relationships_radioGroup1.setOnCheckedChangeListener(radioGroup_relationships_listener1);
        list1_relationships_radioGroup2 = findViewById(R.id.list1_relationships_radioGroup2);
        list1_relationships_radioGroup2.clearCheck();
        list1_relationships_radioGroup2.setOnCheckedChangeListener(radioGroup_relationships_listener2);

        list1_relationships_nextbtn = findViewById(R.id.list1_relationships_btn_next);
        list1_relationships_nextbtn.setOnClickListener(this);

        relationships_custom_text = findViewById(R.id.list1_relationships_btn_usercustom);
        relationships_custom_text.setOnClickListener(new relationships_custom_btn_listener());

        relationships_custom_edit_text = findViewById(R.id.list1_relationships_usercustom_edittext);
        relationships_custom_edit_text.setOnClickListener(new relationships_custom_edit_Clicklistener());
        relationships_custom_edit_text.setOnKeyListener(new relationships_custom_edit_listener());
        relationships_custom_edit_text.setTypeface(typebold);

        relationships_usercustom_layout = findViewById(R.id.list1_relationships_btn_usercustom_layout);

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

    private OnCheckedChangeListener radioGroup_relationships_listener1 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {

                if(checkedId == R.id.list1_relationships_btn_family){
                    family.setTypeface(typebold);
                    friend.setTypeface(typereg);
                }
                else if(checkedId == R.id.list1_relationships_btn_friends){
                    friend.setTypeface(typebold);
                    family.setTypeface(typereg);
                }
                companion.setTypeface(typereg);
                junior.setTypeface(typereg);
                relationships_custom_edit_text.setTypeface(typereg);
                relationships_custom_edit_text.setCursorVisible(false);
                list1_relationships_nextbtn.setEnabled(true);
                hidekeyboard(relationships_custom_edit_text);
                list1_relationships_radioGroup2.setOnCheckedChangeListener(null);
                list1_relationships_radioGroup2.clearCheck();
                list1_relationships_radioGroup2.setOnCheckedChangeListener(radioGroup_relationships_listener2);
                relationships_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                relationships_custom_edit_text.setTextColor(backcolor);
                String title;
                title = relationships_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    relationships_custom_text.setVisibility(View.VISIBLE);
                    relationships_custom_edit_text.setVisibility(View.INVISIBLE);
                }
            }
        }
    };

    private OnCheckedChangeListener radioGroup_relationships_listener2 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId != -1) {

                if(checkedId == R.id.list1_relationships_btn_companion){
                    companion.setTypeface(typebold);
                    junior.setTypeface(typereg);
                }
                else if(checkedId == R.id.list1_relationships_btn_junior){
                    friend.setTypeface(typebold);
                    junior.setTypeface(typereg);
                }
                family.setTypeface(typereg);
                friend.setTypeface(typereg);
                relationships_custom_edit_text.setTypeface(typereg);
                relationships_custom_edit_text.setCursorVisible(false);
                list1_relationships_nextbtn.setEnabled(true);
                hidekeyboard(relationships_custom_edit_text);
                list1_relationships_radioGroup1.setOnCheckedChangeListener(null);
                list1_relationships_radioGroup1.clearCheck();
                list1_relationships_radioGroup1.setOnCheckedChangeListener(radioGroup_relationships_listener1);
                relationships_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                int backcolor = getResources().getColor(R.color.lightPurple);
                relationships_custom_edit_text.setTextColor(backcolor);
                String title;
                title = relationships_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    relationships_custom_text.setVisibility(View.VISIBLE);
                    relationships_custom_edit_text.setVisibility(View.INVISIBLE);
                }
            }
        }
    };

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        //RadioButton family;
        //    RadioButton friend;
        //    RadioButton companion;
        //    RadioButton junior;

        if(family.isChecked()){
            category_listId = 14;
        }
        else if (friend.isChecked()){
            category_listId = 15;
        }
        else if (companion.isChecked()){
            category_listId = 16;
        }
        else if (junior.isChecked()){
            category_listId = 17;
        }
        else if (relationships_custom_edit_text.isFocused()){
            WorryCategoryListAddModel worryCategoryListAddModel = new WorryCategoryListAddModel();
            worryCategoryListAddModel.category_idx = 4;
            worryCategoryListAddModel.categoryList_name = relationships_custom_edit_text.getText().toString();

            String token = ApplicationFields.userToken;

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
                    Intent intent = new Intent(context, List2Activity.class);
                    startActivityForResult(intent, REQUEST_CODE);

                }

                @Override
                public void onFailure(Call<WorryCategoryListAddResponseModel> call, Throwable t) {
                    t.printStackTrace();
                    Log.d(" 관계 액티비티 실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
                }


            });
        }
        else{}

        Intent intent = new Intent(context, List2Activity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    class list1_relationships_cancelbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            Dialog();
        }
    }

    class list1_relationships_backbtn_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("result", "BACK");
            setResult(REQUEST_CODE, intent);
            finish();
        }
    }

    class list_background_listener implements OnClickListener {
        @Override
        public void onClick(View view) {
            if(relationships_custom_edit_text.isFocused()){
                String title;
                title = relationships_custom_edit_text.getText().toString();
                if(title.getBytes().length <= 0) {
                    list1_relationships_nextbtn.setEnabled(false);
                    relationships_custom_text.setVisibility(View.VISIBLE);
                    relationships_custom_edit_text.setVisibility(View.INVISIBLE);
                    relationships_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                }
                else{
                    list1_relationships_nextbtn.setEnabled(true);
                }
                hidekeyboard(relationships_custom_edit_text);
                relationships_custom_edit_text.setCursorVisible(false);
            }
        }
    }

    class relationships_custom_btn_listener implements OnClickListener {
        @Override
        public void onClick(View v) {
            String title;
            title = relationships_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_relationships_nextbtn.setEnabled(false);
                relationships_custom_text.setVisibility(View.VISIBLE);
                relationships_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            family.setTypeface(typereg);
            friend.setTypeface(typereg);
            companion.setTypeface(typereg);
            junior.setTypeface(typereg);
            relationships_custom_edit_text.setTypeface(typebold);
            list1_relationships_radioGroup1.setOnCheckedChangeListener(null);
            list1_relationships_radioGroup1.clearCheck();
            list1_relationships_radioGroup1.setOnCheckedChangeListener(radioGroup_relationships_listener1);
            list1_relationships_radioGroup2.setOnCheckedChangeListener(null);
            list1_relationships_radioGroup2.clearCheck();
            list1_relationships_radioGroup2.setOnCheckedChangeListener(radioGroup_relationships_listener2);
            relationships_custom_text.setVisibility(View.INVISIBLE);
            relationships_custom_edit_text.setVisibility(View.VISIBLE);
            relationships_custom_edit_text.setCursorVisible(true);
            relationships_custom_edit_text.requestFocus();
            showkeyboard(relationships_custom_edit_text);
            int backcolor = getResources().getColor(R.color.white);
            relationships_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            relationships_custom_edit_text.setTextColor(backcolor);
        }
    }

    class relationships_custom_edit_Clicklistener implements OnClickListener {
        @Override
        public void onClick(View view) {
            String title;
            title = relationships_custom_edit_text.getText().toString();
            if(title.getBytes().length <= 0) {
                list1_relationships_nextbtn.setEnabled(false);
                relationships_custom_text.setVisibility(View.VISIBLE);
                relationships_custom_edit_text.setVisibility(View.INVISIBLE);
            }
            else{
                list1_relationships_nextbtn.setEnabled(true);
            }
            family.setTypeface(typereg);
            friend.setTypeface(typereg);
            companion.setTypeface(typereg);
            junior.setTypeface(typereg);
            relationships_custom_edit_text.setTypeface(typebold);

            list1_relationships_radioGroup1.setOnCheckedChangeListener(null);
            list1_relationships_radioGroup1.clearCheck();
            list1_relationships_radioGroup1.setOnCheckedChangeListener(radioGroup_relationships_listener1);
            list1_relationships_radioGroup2.setOnCheckedChangeListener(null);
            list1_relationships_radioGroup2.clearCheck();
            list1_relationships_radioGroup2.setOnCheckedChangeListener(radioGroup_relationships_listener2);
            relationships_custom_text.setVisibility(View.INVISIBLE);
            relationships_custom_edit_text.setVisibility(View.VISIBLE);
            relationships_custom_edit_text.setCursorVisible(true);
            int backcolor = getResources().getColor(R.color.white);
            relationships_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selected);
            relationships_custom_edit_text.setTextColor(backcolor);
        }
    }

    class relationships_custom_edit_listener implements View.OnKeyListener {

        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {

            switch (i) {
                case KeyEvent.KEYCODE_ENTER :
                    hidekeyboard(relationships_custom_edit_text);
                    String title;
                    title = relationships_custom_edit_text.getText().toString();
                    if(title.getBytes().length <= 0) {
                        list1_relationships_nextbtn.setEnabled(false);
                        relationships_custom_text.setVisibility(View.VISIBLE);
                        relationships_custom_edit_text.setVisibility(View.INVISIBLE);
                        relationships_usercustom_layout.setBackgroundResource(R.drawable.list_btns_selector);
                    }
                    relationships_custom_edit_text.setCursorVisible(false);
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

    public void Dialog() {
        dialog = new OneTextTwoButton_CustomDialog(HelperSignUp1_R_Activity.this, resid,
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
