package com.example.appjam_willson.MainActivities;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appjam_willson.R;

public class HelperFragment2_null extends Fragment {

    public HelperFragment2_null(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_helper_request_empty_received,null);
            Button btn = view.findViewById(R.id.helper_profile_edit_btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HelperFragment3 fragment = new HelperFragment3();
                    getFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
                    getActivity().finish();
                    //////////밑에 노란색 색깔 바꾸기

                }
            });
            return view;
    }
}
