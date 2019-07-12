package com.example.appjam_willson.MainActivities;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appjam_willson.R;

public class HelperFragment1_null extends Fragment {

    public HelperFragment1_null(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_helper_request_empty_received,null);

        ImageView willsonImage_receive = getActivity().findViewById(R.id.willsonImage_receive);
        ImageView willsonImage_chat = getActivity().findViewById(R.id.willsonImage_chat);
        ImageView willsonImage_profile = getActivity().findViewById(R.id.willsonImage_profile);
        ImageView willsonImage_mypage = getActivity().findViewById(R.id.willsonImage_mypage);

        TextView willsonText_receive = getActivity().findViewById(R.id.willsonText_receive);
        TextView willsonText_chat = getActivity().findViewById(R.id.willsonText_chat);
        TextView willsonText_profile = getActivity().findViewById(R.id.willsonText_profile);
        TextView willsonText_mypage = getActivity().findViewById(R.id.willsonText_mypage);

        LinearLayout change = view.findViewById(R.id.helper_toAsker);

        LinearLayout go_user = view.findViewById(R.id.helper_toAsker);
        go_user.setOnClickListener(new go_user_listener());

        Button btn = view.findViewById(R.id.helper_profile_edit_btn);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(willsonImage_profile,willsonImage_chat,willsonImage_receive,willsonImage_mypage);
                changeTextColor(willsonText_profile,willsonText_chat,willsonText_receive,willsonText_mypage);
                HelperFragment3 fragment = new HelperFragment3();
                getFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
            }
        });
        return view;
    }

    class go_user_listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(),MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }

    private void changeImage(ImageView first, ImageView second, ImageView third, ImageView fourth) {
        first.setSelected(true);
        second.setSelected(false);
        third.setSelected(false);
        fourth.setSelected(false);
    }

    private void changeTextColor(TextView first, TextView second, TextView third, TextView fourth) {
        first.setTextColor(Color.parseColor("#2f2f2f"));
        second.setTextColor(Color.parseColor("#9e9e9e"));
        third.setTextColor(Color.parseColor("#9e9e9e"));
        fourth.setTextColor(Color.parseColor("#9e9e9e"));
    }

}
