        package com.example.appjam_willson.HelperProfileEdit;

        import android.content.Context;
        import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

import com.example.appjam_willson.R;





        public class HelperProfileEditActivityC2 extends AppCompatActivity {
        //다음버튼에 액티비티 2 와 연결 해야함

            TextView text;
            Context context;
            int REQUEST_CODE;

            public void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_helper_profile_edit_c2);

                REQUEST_CODE = ((HelperProfileEditActivityC2) context).getTaskId();

                Button button1 = findViewById(R.id.helper_editc2_1);
                Button button2 = findViewById(R.id.helper_editc2_2);
                Button button3 = findViewById(R.id.helper_editc2_3);
                Button button4 = findViewById(R.id.helper_editc2_4);
                Button nextbtn = findViewById(R.id.btn_next);

        // Button backbtn = (Button) findViewById(R.id.btn_backbtn);
        ImageView btn_back;

        btn_back = findViewById(R.id.back_btn);
        btn_back.setOnClickListener(new HelperProfileEditActivityC2.list1_love_backbtn_listener());


                text = findViewById(R.id.toolbar_text);
                text.setText("프로필 수정");

                button1.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nextbtn.setEnabled(true);
                        button1.setBackgroundResource(R.drawable.helpersignupbackground);
                        button1.setTextColor(getColor(R.color.white));
                        button2.setTextColor(getColor(R.color.lightPurple));
                        button3.setTextColor(getColor(R.color.lightPurple));
                        button4.setTextColor(getColor(R.color.lightPurple));
                        button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                        button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                        button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);


                    }



        });
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button2.setBackgroundResource(R.drawable.helpersignupbackground);
                button2.setTextColor(getColor(R.color.white));
                button1.setTextColor(getColor(R.color.lightPurple));
                button3.setTextColor(getColor(R.color.lightPurple));
                button4.setTextColor(getColor(R.color.lightPurple));
                button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);






                    }
                });

                button3.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nextbtn.setEnabled(true);
                        button3.setBackgroundResource(R.drawable.helpersignupbackground);
                        button3.setTextColor(getColor(R.color.white));
                        button2.setTextColor(getColor(R.color.lightPurple));
                        button1.setTextColor(getColor(R.color.lightPurple));
                        button4.setTextColor(getColor(R.color.lightPurple));
                        button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                        button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                        button4.setBackgroundResource(R.drawable.helpersignup_nonchecked);




                    }
                });

        button4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextbtn.setEnabled(true);
                button4.setBackgroundResource(R.drawable.helpersignupbackground);
                button4.setTextColor(getColor(R.color.white));
                button2.setTextColor(getColor(R.color.lightPurple));
                button3.setTextColor(getColor(R.color.lightPurple));
                button1.setTextColor(getColor(R.color.lightPurple));
                button1.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button2.setBackgroundResource(R.drawable.helpersignup_nonchecked);
                button3.setBackgroundResource(R.drawable.helpersignup_nonchecked);
            }
        });


        nextbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(HelperProfileEditActivityC2.this, HelperProfileEditActivityStart.class);
                startActivityForResult(intentProfileEdit,REQUEST_CODE);


            }


        });




    }


    class list1_love_backbtn_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }







}







