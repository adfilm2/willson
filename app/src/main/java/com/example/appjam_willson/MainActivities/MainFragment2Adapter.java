package com.example.appjam_willson.MainActivities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.AskerProfileActivity;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.AcceptHelperListWatchResponseModel;

public class MainFragment2Adapter extends RecyclerView.Adapter<MainFragment2Adapter.ViewHolder> {

    private AcceptHelperListWatchResponseModel.Data dataModels;
    private Context context;

    public MainFragment2Adapter(AcceptHelperListWatchResponseModel.Data dataModels, Context context){
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

//        닉네임
        if(dataModels.getHelper().get(i).getNickname() != null) {
            viewHolder.Nickname.setText(dataModels.getHelper().get(i).getNickname());
        }
        else {
        }

        //성별
        if(dataModels.getHelper().get(i).getGender() != null) {
            viewHolder.Gender.setText("(" + dataModels.getHelper().get(i).getGender() + " / ");
        }
        else{
        }

        //나이대
        if(dataModels.getHelper().get(i).getAge() != null) {
            viewHolder.Age.setText(dataModels.getHelper().get(i).getAge() + ")");
        }
        else{

        }
        //주제
        if(dataModels.getHelper().get(i).getCategory_name() != null) {
            viewHolder.Subject.setText(dataModels.getHelper().get(i).getCategory_name());
           /* viewHolder.userSubjectStroke.setBackgroundResource(R.drawable.rounded_corner_radius15);*/
        }
        else {
        }
        //경험정보
        if(dataModels.getHelper().get(i).getContent() != null) {
            viewHolder.Information.setText('"' + dataModels.getHelper().get(i).getContent() + '"');
        }
        else {
        }
        //별점
        if(dataModels.getHelper().get(i).getStars() != null){
            viewHolder.Star.setText(dataModels.getHelper().get(i).getStars() + ".0");
        }

        //후기 개수
        if(dataModels.getHelper().get(i).getReview_count() != null){
            viewHolder.Review.setText("("+dataModels.getHelper().get(i).getReview_count()+"개의 후기)");
        }

        //경험
//        if(dataModels.getExperience() != null){
//            viewHolder.exp1.setText("#" + dataModels.getExperience().get(0).getExperience_name());
//            viewHolder.exp2.setText("#" + dataModels.getExperience().get(1).getExperience_name());
//            viewHolder.exp3.setText("#" + dataModels.getExperience().get(2).getExperience_name());
//        }

        //프로필보기
        viewHolder.goProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int helper_idx = dataModels.getHelper();*/

                int helper_idx = 1;

                Intent intent = new Intent(v.getContext(), AskerProfileActivity.class);
                intent.putExtra("helper_idx", helper_idx);
                context.startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return dataModels.getHelper().size();
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
