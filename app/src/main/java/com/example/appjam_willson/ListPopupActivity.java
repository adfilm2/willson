package com.example.appjam_willson;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017-08-07.
 */

public class ListPopupActivity extends AppCompatActivity {

    

    private Context context;

    public ListPopupActivity(Context context) {
        this.context = context;
    }

    public void callFunction() {




        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);
        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.activity_list_popup);
        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        final Button okButton = (Button)dlg.findViewById(R.id.list_pop_keepbtn);
        final Button cancelButton = (Button) dlg.findViewById(R.id.list_pop_exitbtn);
       //RatingBar rb =(RatingBar)dlg.findViewById(R.id.ratingBar1);


        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커스텀 다이얼로그를 종료한다.
                dlg.dismiss();
            }
        });



    }
}