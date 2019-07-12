package com.example.appjam_willson.MainActivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.R;
import com.example.appjam_willson.model.WillsonModel;

import java.util.List;

public class ReqHelperProfileAdapter extends RecyclerView.Adapter<ReqHelperProfileAdapter.ViewHolder> {

    private List<WillsonModel> willsonModels;
    private Context context;

    public ReqHelperProfileAdapter(List<WillsonModel> willsonModels, Context context){
        this.willsonModels = willsonModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_helper_received_worries_item, viewGroup, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        //닉네임
        if(willsonModels.get(i).getNickName() != null) {
            viewHolder.userNickname.setText(willsonModels.get(i).getNickName());
        }
        else{
            viewHolder.userNickname.setText(willsonModels.get(i).getUid());
        }

        //성별
        if(willsonModels.get(i).getGender() != null) {
            viewHolder.userNickname.setText(willsonModels.get(i).getGender());
        }
        else{
            viewHolder.userNickname.setText(willsonModels.get(i).getUid());
        }

        //나이대
        if(willsonModels.get(i).getAge() != null) {
            viewHolder.userNickname.setText(willsonModels.get(i).getAge());
        }
        else{
            viewHolder.userNickname.setText(willsonModels.get(i).getUid());
        }

        //주제
        if(willsonModels.get(i).getAge() != null) {
            viewHolder.userNickname.setText(willsonModels.get(i).getAge());
        }
        else{
            viewHolder.userNickname.setText(willsonModels.get(i).getUid());
        }

        //고민정보
        if(willsonModels.get(i).getUserInformation() != null) {
            viewHolder.userNickname.setText(willsonModels.get(i).getUserInformation());
        }
        else{
            viewHolder.userNickname.setText(willsonModels.get(i).getUid());
        }

        //프로필보기
        viewHolder.goProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), HelperChatActivity.class);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return willsonModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView userNickname;
        public TextView userGender;
        public TextView userAge;
        public TextView userSubject;
        public TextView userInformation;
        public LinearLayout goProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userNickname = itemView.findViewById(R.id.helper_fragment1_nickName);
            userGender = itemView.findViewById(R.id.helper_fragment1_gender);
            userAge = itemView.findViewById(R.id.helper_fragment1_age);
            userSubject = itemView.findViewById(R.id.helper_fragment1_subject);
            userInformation = itemView.findViewById(R.id.helper_fragment1_information);
            goProfile = itemView.findViewById(R.id.helper_fragment1_profile);
        }
    }
}
