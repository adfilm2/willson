package com.example.appjam_willson.MainActivities;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appjam_willson.HelperProfileEdit.HelperProfileEditActivityC1;
import com.example.appjam_willson.HelperProfileEdit.HelperProfileEditActivityExp;
import com.example.appjam_willson.HelperProfileEdit.HelperProfileEditActivityHash;
import com.example.appjam_willson.HelperProfileEdit.HelperProfileEditActivityIntro;
import com.example.appjam_willson.R;

public class HelperFragment3 extends Fragment {

    public HelperFragment3(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_helper_profile_edit_start,null);

        Button button1 = view.findViewById(R.id.h_edit_btn1);
        Button button2 = view.findViewById(R.id.h_edit_btn2);
        Button button3 = view.findViewById(R.id.h_edit_btn3); //helperSU_btn_life helperSU_btn_etc
        Button button4 = view.findViewById(R.id.h_edit_btn4);

        ImageView btn;
        ImageView back;
        TextView text;

        back = view.findViewById(R.id.back_btn);
        back.setVisibility(View.INVISIBLE);
        btn = view.findViewById(R.id.cancel_btn);
        btn.setVisibility(View.INVISIBLE);
        text = view.findViewById(R.id.toolbar_text);
        text.setText("프로필 수정");

        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(getActivity(), HelperProfileEditActivityC1.class);
                startActivity(intentProfileEdit);

            }
        });

        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(getActivity(), HelperProfileEditActivityExp.class);
                startActivity(intentProfileEdit);
            }
        });
        button3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(getActivity(), HelperProfileEditActivityHash.class);
                startActivity(intentProfileEdit);
            }
        });
        button4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfileEdit = new Intent(getActivity(), HelperProfileEditActivityIntro.class);
                startActivity(intentProfileEdit);
            }


        });

        return view;
    }


}
