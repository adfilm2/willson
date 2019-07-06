package com.example.appjam_willson;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appjam_willson.model.WillsonModel;

import java.util.List;

public class Fragment2Adapter extends RecyclerView.Adapter<Fragment2Adapter.ViewHolder> {

    private List<WillsonModel> willsonModels;
    private Context context;

    public Fragment2Adapter(List<WillsonModel> willsonModels, Context context){
        this.willsonModels = willsonModels;
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

        //헬퍼의 닉네임
        viewHolder.userNickname.setText(willsonModels.get(i).getNickName());

        //헬퍼의 사진
        viewHolder.userImage.setImageResource(R.drawable.chat_img_helperprofile);

        //헬퍼의 나이
        viewHolder.userAge.setText(willsonModels.get(i).getAge());

        //헬퍼의 대화주제
        viewHolder.userSubject.setText(willsonModels.get(i).getEmail());

        //헬퍼의 정보
        viewHolder.userInformation.setText(willsonModels.get(i).getUid());

        //헬퍼의 평점
        viewHolder.userScore.setText(willsonModels.get(i).getAge());

        //헬퍼의 대화 건수
        viewHolder.userReview.setText(willsonModels.get(i).getAge());
        //프로필 보기
        //지금은 한시적으로 대화를 생성하는 것으로 대체
        viewHolder.userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ChatActivity.class);
                intent.putExtra("destinationUid",willsonModels.get(i).getUid());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return willsonModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView userAge;
        public TextView usergender;
        public TextView userNickname;
        public TextView userSubject;
        public TextView userReview;
        public TextView userScore;
        public TextView userInformation;
        public ImageView userImage;
        public Button userProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userAge = itemView.findViewById(R.id.fragment2_age);
            usergender = itemView.findViewById(R.id.fragment2_gender);
            userSubject = itemView.findViewById(R.id.fragment2_profile_subject);
            userNickname = itemView.findViewById(R.id.fragment2_nickName);
            userScore = itemView.findViewById(R.id.fragment2_score);
            userInformation = itemView.findViewById(R.id.fragment2_userInformation);
            userImage = itemView.findViewById(R.id.fragment2_userImage);
            userProfile = itemView.findViewById(R.id.fragment2_checkProfile);
            userReview = itemView.findViewById(R.id.fragment2_reviewCount);
        }
    }
}
