package com.example.appjam_willson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.model.WillsonModel;


public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private List<WillsonModel> willsonModels;
    private Context context;

    public StoryAdapter(List<WillsonModel> willsonModels, Context context){
        this.willsonModels = willsonModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment1_profile1, viewGroup, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        //닉네임
        if (willsonModels.get(i).getNickName() == null) {
            viewHolder.story_nickName.setText(willsonModels.get(i).getUid());
        } else {
            viewHolder.story_nickName.setText(willsonModels.get(i).getNickName());
        }

        //사진
        if (willsonModels.get(i).getPhoto().equals("")) {
            viewHolder.story_image.setImageResource(R.drawable.chat_img_helperprofile);
        } else {
            viewHolder.story_image.setImageResource(R.drawable.chat_img_helperprofile);
        }

        viewHolder.story_subject.setText(willsonModels.get(i).getAge());
        viewHolder.story_information.setText(willsonModels.get(i).getUid());

    }

    @Override
    public int getItemCount() {
        return willsonModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView story_subject;
        public TextView story_information;
        public TextView story_nickName;
        public ImageView story_image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            story_subject = itemView.findViewById(R.id.fragment1_profile_1st_subject);
            story_information = itemView.findViewById(R.id.fragment1_profile_1st_property);
            story_nickName = itemView.findViewById(R.id.fragment1_profile_nickName);

            story_image = itemView.findViewById(R.id.fragment1_profile_img);

        }
    }
}
