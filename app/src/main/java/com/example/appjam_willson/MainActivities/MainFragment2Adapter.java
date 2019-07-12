package com.example.appjam_willson.MainActivities;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.HelperProfileActivity;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.AcceptHelperListWatchResponseModel;

import java.util.List;

public class MainFragment2Adapter extends RecyclerView.Adapter<MainFragment2Adapter.ViewHolder> {

    private List<AcceptHelperListWatchResponseModel.Data> dataModels;
    private Context context;

    int helper_idx;
    int question_idx;

    public MainFragment2Adapter(List<AcceptHelperListWatchResponseModel.Data> dataModels, Context context){
        this.dataModels = dataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment2_recyclerview_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        question_idx = MainFragment2.question_idx;
        Log.d("question 2어댑터임" , ">>>>>>>>>>"+question_idx);
//        닉네임
        if(dataModels.get(i).getHelper().getNickname() != null) {
            viewHolder.Nickname.setText(dataModels.get(i).getHelper().getNickname());
        }
        else {
        }

        //성별
        if(dataModels.get(i).getHelper().getGender() != null) {
            viewHolder.Gender.setText("(" + dataModels.get(i).getHelper().getGender() + " / ");
        }
        else{
        }

        //나이대
        if(dataModels.get(i).getHelper().getAge() != null) {
            viewHolder.Age.setText(dataModels.get(i).getHelper().getAge() + ")");
        }
        else{

        }
        //주제
        if(dataModels.get(i).getHelper().getCategory_name() != null) {
            viewHolder.Subject.setText(dataModels.get(i).getHelper().getCategory_name());
           /* viewHolder.userSubjectStroke.setBackgroundResource(R.drawable.rounded_corner_radius15);*/
        }
        else {
        }
        //경험정보
        if(dataModels.get(i).getHelper().getContent() != null) {
            viewHolder.Information.setText('"' + dataModels.get(i).getHelper().getContent() + '"');
        }
        else {
        }
        //별점
        if(dataModels.get(i).getHelper().getStars() != null){
            viewHolder.Star.setText(dataModels.get(i).getHelper().getStars() + ".0");
        }

        //후기 개수
        if(dataModels.get(i).getHelper().getReview_count() != null){
            viewHolder.Review.setText("("+dataModels.get(i).getHelper().getReview_count()+"개의 후기)");
        }

        //경험
        if(dataModels.get(i).getExperience().length != 0) {
            String[] exp = dataModels.get(i).getExperience();
            switch (exp.length) {
                case 1:
                    viewHolder.exp1.setText("#" + exp[0]);
                    break;
                case 2:
                    viewHolder.exp1.setText("#" + exp[0]);
                    viewHolder.exp2.setText("#" + exp[1]);
                    break;
                case 3:
                    viewHolder.exp1.setText("#" + exp[0]);
                    viewHolder.exp2.setText("#" + exp[1]);
                    viewHolder.exp3.setText("#" + exp[2]);
                    break;
                default:
                    break;
            }
        }else {
            Log.d("없음ㅁㅁㅁㅁㅁㅁㅁㅁㅁ","헬퍼가 경험이 없슴");
        }

        //프로필보기
        viewHolder.goProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int helper_idx = dataModels.getHelper();*/

                /*int helper_idx = 1;*/
                helper_idx = dataModels.get(i).getHelper().getHelper_idx();
                Intent intent = new Intent(v.getContext(), HelperProfileActivity.class);
                intent.putExtra("helper_idx", helper_idx);
                intent.putExtra("question_idx", question_idx);
                context.startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView Nickname;
        public TextView Gender;
        public TextView Age;
        public TextView Subject;
        public TextView Information;
        public Button goProfile;
        public TextView Star;
        public TextView Review;
        public TextView exp1;
        public TextView exp2;
        public TextView exp3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nickname = itemView.findViewById(R.id.fragment2_nickName);
            Gender = itemView.findViewById(R.id.fragment2_gender);
            Age = itemView.findViewById(R.id.fragment2_age);
            Subject = itemView.findViewById(R.id.fragment2_profile_subject);
            Information = itemView.findViewById(R.id.fragment2_userInformation);
            goProfile = itemView.findViewById(R.id.fragment2_checkProfile);
            Star = itemView.findViewById(R.id.fragment2_score);
            Review = itemView.findViewById(R.id.fragment2_reviewCount);
            exp1 = itemView.findViewById(R.id.main_helper_tag1);
            exp2 = itemView.findViewById(R.id.main_helper_tag2);
            exp3 = itemView.findViewById(R.id.main_helper_tag3);
        }
    }
}
