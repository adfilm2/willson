package com.example.appjam_willson.MainActivities;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.FillinListActivity.List1CourseStartActivity;
import com.example.appjam_willson.FillinListActivity.List1DailyStartActivity;
import com.example.appjam_willson.FillinListActivity.List1EtcStartActivity;
import com.example.appjam_willson.FillinListActivity.List1LoveStartActivity;
import com.example.appjam_willson.FillinListActivity.List1MentalityStartActivity;
import com.example.appjam_willson.FillinListActivity.List1RelationshipsStartActivity;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.WillsonModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {


    private StoryAdapter storyAdapter;
    private RecyclerView storyRecyclerView;
    private List<WillsonModel> willsonModels;
    private LinearLayoutManager linearLayoutManager;
    private String myuid;

    public MainFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment1,null);
        LinearLayout firstContent = view.findViewById(R.id.fragment1_firstContent);
        LinearLayout secondContent = view.findViewById(R.id.fragment1_secondContent);
        LinearLayout thirdContent = view.findViewById(R.id.fragment1_thirdContent);
        LinearLayout fourthContent = view.findViewById(R.id.fragment1_fourthContent);
        LinearLayout fifthContent = view.findViewById(R.id.fragment1_fifthContent);
        LinearLayout sixthContent = view.findViewById(R.id.fragment1_sixthContent);
        TextView main_fragment1_text = view.findViewById(R.id.main_fragment1_text);
        TextView main_fragment1_textSecond = view.findViewById(R.id.main_fragment1_textSecond);
        TextView main_fragment1_textThird = view.findViewById(R.id.main_fragment1_textThird);
        storyRecyclerView = view.findViewById(R.id.fragment1_recyclerView);

        LinearLayout changeMode = view.findViewById(R.id.helper_fragment1_change);

       /* myuid = FirebaseAuth.getInstance().getCurrentUser().getUid();*/

        firstContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1LoveStartActivity.class);
                startActivity(intent);
            }
        });

        secondContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1CourseStartActivity.class);
                startActivity(intent);
            }
        });

        thirdContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1MentalityStartActivity.class);
                startActivity(intent);
            }
        });

        fourthContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1RelationshipsStartActivity.class);
                startActivity(intent);
            }
        });

        fifthContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1DailyStartActivity.class);
                startActivity(intent);
            }
        });

        sixthContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1EtcStartActivity.class);
                startActivity(intent);
            }
        });

        changeMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , HelperActivity.class);
                startActivity(intent);
            }
        });

        willsonModels = new ArrayList<>();
        storyRecyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        storyRecyclerView.setLayoutManager(linearLayoutManager);
        storyAdapter = new StoryAdapter(willsonModels,getActivity());
        storyRecyclerView.setAdapter(storyAdapter);

        callWillson(myuid);

        //Text들의 특정 위치 색, 타입을 바꿔주는 메소드
        changeText(main_fragment1_text,8,10,"#5252a1");
        changeText(main_fragment1_textSecond,0,2,"#ffc326");
        changeText(main_fragment1_textThird,6,8,"#5252a1");

        return view;
    }

    //text뷰의 start포인트부터 end포인트까지 색을 바꿔줌 color값으로
    void changeText(TextView text,int start,int end,String color){
        SpannableStringBuilder spannableStringBuilder_second = new SpannableStringBuilder();
        String mainText_second = text.getText().toString();
        spannableStringBuilder_second.append(mainText_second);
        spannableStringBuilder_second.setSpan(new StyleSpan(Typeface.BOLD),start,end,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder_second.setSpan(new ForegroundColorSpan(Color.parseColor(color)),start,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setText(spannableStringBuilder_second);
    }

    //추후에 맞는 값으로 변경할 예정
    public void callWillson(final String myUid){
        FirebaseDatabase.getInstance().getReference().child("testUsers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{
                    for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                        WillsonModel users = dataSnapshot2.getValue(WillsonModel.class);
                        if(users.getUid().equals(myUid)){
                            continue;
                        }
                        willsonModels.add(users);
                    }
                    storyAdapter.notifyDataSetChanged();

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
