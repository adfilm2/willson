

package com.example.appjam_willson.HelperProfileEdit;



        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import androidx.appcompat.app.AppCompatActivity;

        import com.example.appjam_willson.R;
// public class HelperSignUpActivity1 extends AppCompatActivity implements View.OnClickListener {

public class HelperProfileEditActivityC1 extends AppCompatActivity {



    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_profile_edit_c1);
        Button button1 = (Button) findViewById(R.id.helperSU_btn_love1) ;
        Button button2 = (Button) findViewById(R.id.helperSU_btn_love2) ;
        Button button3 = (Button) findViewById(R.id.helperSU_btn_love3) ;
        Button button4 = (Button) findViewById(R.id.helperSU_btn_love4) ;


        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
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








    }







    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            //이곳에 버튼 클릭시 일어날 일을 적습니다.
        }
    };
};






