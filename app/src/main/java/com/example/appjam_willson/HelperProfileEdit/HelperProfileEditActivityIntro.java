        package com.example.appjam_willson.HelperProfileEdit;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import com.example.appjam_willson.PopUp.OneTextTwoButton_CustomDialog;
        import com.example.appjam_willson.R;





        public class HelperProfileEditActivityIntro extends AppCompatActivity {
            int REQUEST_CODE;

            EditText editTextSMS;

            TextView textViewCount;

            private OneTextTwoButton_CustomDialog dialog;
            LinearLayout list4_cancelbtn;
            LinearLayout list4_backbtn;
            Button list4_nextbtn;

            Context context;

            String resName;
            String packName;
            int resid;

            TextView text;
            ImageView btn;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_helper_profile_edit_intro);

                ImageView btn_back;
                btn_back = (ImageView) findViewById(R.id.h_pro_btn_backbtn);
                btn_back.setOnClickListener(new HelperProfileEditActivityIntro.list1_love_backbtn_listener());

                context = this;

                btn = (ImageView)findViewById(R.id.back_btn);
                btn.setVisibility(View.INVISIBLE);
                text = (TextView)findViewById(R.id.toolbar_text);
                text.setText("프로필 수정");

                // REQUEST_CODE = ((com.example.appjam_willson.FillinListActivity.List4Activity) context).getTaskId();

                resName = "@drawable/list_img_alert_willson";
                packName = this.getPackageName();
                resid = getResources().getIdentifier(resName, "drawable", packName);

                list4_nextbtn = (Button) findViewById(R.id.helper_edit_intro_nextbtn);
                list4_nextbtn.setOnClickListener(new helper_edit_exp_nextbtn_listener());


                textViewCount = (TextView) findViewById(R.id.textViewCount);
                editTextSMS = (EditText) findViewById(R.id.list4_edittext);

                editTextSMS.addTextChangedListener(new TextWatcher() {

                    @Override

                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }


                    @Override

                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        textViewCount.setText(Integer.toString(s.toString().length()));

                        if (s.length() == 0) {
                            list4_nextbtn.setEnabled(false);
                        } else list4_nextbtn.setEnabled(true);

                    }


                    @Override

                    public void afterTextChanged(Editable s) {

                    }

                });

            }


            class list1_love_backbtn_listener implements View.OnClickListener {
                @Override
                public void onClick(View view) {
                    finish();
                }
            }

            class helper_edit_exp_nextbtn_listener  implements View.OnClickListener {
                @Override
                public void onClick(View view) {
                    Intent intentProfileEdit = new Intent(HelperProfileEditActivityIntro.this, HelperProfileEditActivityStart.class);
                    startActivity(intentProfileEdit);
                }
            }

        }



