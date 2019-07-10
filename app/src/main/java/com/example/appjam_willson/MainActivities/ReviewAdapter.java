package com.example.appjam_willson.MainActivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.R;
import com.example.appjam_willson.model.HelperStoryModel;
import com.example.appjam_willson.model.MainReviewModel;

import java.util.List;


public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private List<MainReviewModel.ReviewData> willsonModels;
    private Context context;

    public ReviewAdapter(List<MainReviewModel.ReviewData> willsonModels, Context context){
        this.willsonModels = willsonModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment1_main_review, viewGroup, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        //닉네임 및 정보
        viewHolder.review_userInfo.setText(willsonModels.get(i).getNickname());

        //대화 주제
        viewHolder.review_content.setText(willsonModels.get(i).getCategory_name());

        //리뷰 내용
        viewHolder.review_content.setText(willsonModels.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return willsonModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView review_subject;
        public TextView review_content;
        public TextView review_userInfo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            review_subject = itemView.findViewById(R.id.fragment1_review_subject);
            review_content = itemView.findViewById(R.id.fragment1_review_content);
            review_userInfo = itemView.findViewById(R.id.fragment1_review_userInfo);
        }
    }
}
