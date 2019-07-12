package com.example.appjam_willson.MainActivities;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.R;

public class MainFragment2_null extends Fragment {

    public MainFragment2_null(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment2_null,null);

        LinearLayout linearLayout = view.findViewById(R.id.fragment2_null_goHome);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplicationFields.home.setImageResource(R.drawable.tab_01_home_active);
                ApplicationFields.request.setImageResource(R.drawable.tab_02_request_nonactive);
                ApplicationFields.hometxt.setTextColor(Color.parseColor("#2f2f2f"));
                ApplicationFields.requesttxt.setTextColor(Color.parseColor("#9e9e9e"));

                MainFragment fragment = new MainFragment();
                getFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
            }
        });
        return view;
    }

}
