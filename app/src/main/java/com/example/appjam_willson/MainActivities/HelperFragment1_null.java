package com.example.appjam_willson.MainActivities;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

        ImageView willsonImage_receive = (ImageView) getActivity().findViewById(R.id.willsonImage_receive);
        ImageView willsonImage_chat = (ImageView) getActivity().findViewById(R.id.willsonImage_chat);
        ImageView willsonImage_profile = (ImageView) getActivity().findViewById(R.id.willsonImage_profile);
        ImageView willsonImage_mypage = (ImageView) getActivity().findViewById(R.id.willsonImage_mypage);

        TextView willsonText_receive = (TextView) getActivity().findViewById(R.id.willsonText_receive);
        TextView willsonText_chat = (TextView) getActivity().findViewById(R.id.willsonText_chat);
        TextView willsonText_profile = (TextView) getActivity().findViewById(R.id.willsonText_profile);
        TextView willsonText_mypage = (TextView) getActivity().findViewById(R.id.willsonText_mypage);

/*        LayoutInflater inflater_tab;
        inflater_tab = getLayoutInflater();
        View view_tab = inflater_tab.inflate(R.layout.activity_helper, null);*/


        Button btn = view.findViewById(R.id.helper_profile_edit_btn);

   /*     final ImageView willsonImage_receive= view_tab.findViewById(R.id.willsonImage_receive);
        final ImageView willsonImage_chat= view_tab.findViewById(R.id.willsonImage_chat);
        final ImageView willsonImage_profile= view_tab.findViewById(R.id.willsonImage_profile);
        final ImageView willsonImage_mypage= view_tab.findViewById(R.id.willsonImage_mypage);
*/
/*        final TextView willsonText_receive= view_tab.findViewById(R.id.willsonText_receive);
        final TextView willsonText_chat= view_tab.findViewById(R.id.willsonText_chat);
        final TextView willsonText_profile= view_tab.findViewById(R.id.willsonText_profile);
        final TextView willsonText_mypage= view_tab.findViewById(R.id.willsonText_mypage);*/


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                willsonImage_profile.setImageResource(R.drawable.helper_tab_03_profile_active);
                willsonImage_receive.setImageResource(R.drawable.tab_02_request_nonactive);

                willsonText_profile.setTextColor(Color.parseColor("#2f2f2f"));
                willsonText_receive.setTextColor(Color.parseColor("#9e9e9e"));*/

                changeImage(willsonImage_profile,willsonImage_chat,willsonImage_receive,willsonImage_mypage);
                changeTextColor(willsonText_profile,willsonText_chat,willsonText_receive,willsonText_mypage);
                HelperFragment3 fragment = new HelperFragment3();
                getFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
                /*getActivity().finish();*////////////이게 그 액티비티를 종료 하는 건가?
                //////////밑에 노란색 색깔 바꾸기

            }
        });
        return view;
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
