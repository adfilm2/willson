package com.example.appjam_willson.MainActivities;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appjam_willson.HelperProfileEdit.HelperProfileEditActivityStart;
import com.example.appjam_willson.R;

public class MainFragment4 extends Fragment {
    LinearLayout setting;

    public MainFragment4(){
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment4,null);
        setting = view.findViewById(R.id.fragment4_setting);
        setting.setOnClickListener(new setting_click());
        return view;
    }


    private class setting_click implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intentProfileEdit = new Intent(view.getContext(), HelperProfileEditActivityStart.class);
            startActivity(intentProfileEdit);
        }
    }
}
