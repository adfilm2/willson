package com.example.appjam_willson.MainActivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.R;
import com.example.appjam_willson.model.HelperStoryModel;

import java.util.List;


public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private List<HelperStoryModel.story> willsonModels;
    private Context context;

    public StoryAdapter(List<HelperStoryModel.story> willsonModels, Context context){
        this.willsonModels = willsonModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment1_main_story, viewGroup, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        //닉네임
        viewHolder.story_nickName.setText(willsonModels.get(i).getNickname());

        //사진
        viewHolder.story_image.setImageResource(R.drawable.chat_img_helperprofile);

        //주제
        viewHolder.story_subject.setText(willsonModels.get(i).getCategory_name());

        //스토리
        viewHolder.story_information.setText(willsonModels.get(i).getContent());
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
            story_subject = itemView.findViewById(R.id.fragment1_story_subject);
            story_information = itemView.findViewById(R.id.fragment1_story_content);
            story_nickName = itemView.findViewById(R.id.fragment1_story_nickname);
            story_image = itemView.findViewById(R.id.fragment1_story_img);
        }
    }
}
