package com.example.appjam_willson.MainActivities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.AskerProfileActivity;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.DataModel;
import com.example.appjam_willson.model.HelperReceivedWorryListWatchResponseModel;
import com.example.appjam_willson.model.WillsonModel;

import java.util.List;

public class HelperFragment1Adapter extends RecyclerView.Adapter<HelperFragment1Adapter.ViewHolder> {

    private List<HelperReceivedWorryListWatchResponseModel.Concern_Info> dataModels;
    private Context context;

    public HelperFragment1Adapter(List<HelperReceivedWorryListWatchResponseModel.Concern_Info> dataModels, Context context){
        this.dataModels = dataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.helper_fragment1_rv_item, viewGroup, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

//        닉네임
//        if(dataModels.get(i).getData().getEmail() != null) {
//            viewHolder.userNickname.setText(dataModels.get(i).getData().getEmail());
//        }
//        else{
//
//        }
//
//        //성별
//        if(dataModels.get(i).getData().getEmail() != null) {
//            viewHolder.userNickname.setText(dataModels.get(i).getData().getEmail());
//        }
//        else{
//        }

        //나이대
//        if(dataModels.get(i).getAge() != null) {
//            viewHolder.userNickname.setText(willsonModels.get(i).getAge());
//        }
//        else{
//            viewHolder.userNickname.setText(willsonModels.get(i).getUid());
//        }
//
//        //주제
//        if(dataModels.get(i).getAge() != null) {
//            viewHolder.userNickname.setText(willsonModels.get(i).getAge());
//        }
//        else{
//            viewHolder.userNickname.setText(willsonModels.get(i).getUid());
//        }
//
//        //고민정보
//        if(dataModels.get(i).getUserInformation() != null) {
//            viewHolder.userNickname.setText(willsonModels.get(i).getUserInformation());
//        }
//        else{
//            viewHolder.userNickname.setText(willsonModels.get(i).getUid());
//        }

        //프로필보기
        viewHolder.goProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AskerProfileActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
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
