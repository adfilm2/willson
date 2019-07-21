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

    private List<AcceptHelperListWatchResponseModel.Helper_list> dataModels;
    private Context context;

    int helper_idx;
    int question_idx;

    public MainFragment2Adapter(List<AcceptHelperListWatchResponseModel.Helper_list> dataModels, Context context, int ques_idx){
        this.dataModels = dataModels;
        this.context = context;
        this.question_idx = ques_idx;
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

        String[] category_list = {"연애","진로","자존감","인간관계","일상","기타"};

//        닉네임
        if(dataModels.get(i).getHelper().getNickname() != null) {
            viewHolder.Nickname.setText(dataModels.get(i).getHelper().getNickname());
        }
        else {
        }

        //성별
        if(dataModels.get(i).getHelper().getGender() != null) {
            viewHolder.Gender.setText("(" + dataModels.get(i).getHelper().getGender());
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
        int categoryNum = dataModels.get(i).getHelper().getCategory_idx();
        viewHolder.Subject.setText(category_list[categoryNum]);

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
        if(dataModels.get(i).getExperience().size() != 0) {
            List<String> exp = dataModels.get(i).getExperience();
            switch (exp.size()) {
                case 1:
                    viewHolder.exp1.setText("#" + exp.get(0));
                    viewHolder.exp2.setVisibility(View.GONE);
                    viewHolder.exp3.setVisibility(View.GONE);
                    break;
                case 2:
                    viewHolder.exp1.setText("#" + exp.get(0));
                    viewHolder.exp2.setText("#" + exp.get(1));
                    viewHolder.exp3.setVisibility(View.GONE);
                    break;
                case 3:
                    viewHolder.exp1.setText("#" + exp.get(0));
                    viewHolder.exp2.setText("#" + exp.get(1));
                    viewHolder.exp3.setText("#" + exp.get(2));
                    break;
                default:
                    break;
            }
        }else
            {
            Log.d("ERROR","EXEPERIENCE ERROR");
        }

        //프로필보기
        viewHolder.goProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
