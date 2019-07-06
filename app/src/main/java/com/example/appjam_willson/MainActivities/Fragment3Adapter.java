package com.example.appjam_willson.MainActivities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.ChatActivities.ChatActivity;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.WillsonModel;

import java.util.List;

public class Fragment3Adapter extends RecyclerView.Adapter<Fragment3Adapter.ViewHolder> {

    private List<WillsonModel> willsonModels;

    private Context context;

    public Fragment3Adapter(List<WillsonModel> willsonModels, Context context){
        this.willsonModels = willsonModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment3_recyclerview_item, viewGroup, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        //닉네임
        if(willsonModels.get(i).getNickName() == null) {
            viewHolder.chatTitle.setText(willsonModels.get(i).getUid());
        }
        else{
            viewHolder.chatTitle.setText(willsonModels.get(i).getNickName());
        }

        //사진
        if(willsonModels.get(i).getPhoto().equals("")) {
            viewHolder.chatImage.setImageResource(R.drawable.chat_img_helperprofile);
        }

        viewHolder.chatStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChatActivity.class);
                intent.putExtra("destinationUid",willsonModels.get(i).getUid());
                context.startActivity(intent);
            }
        });



        //마지막 메시지
        //아직은 설정 아무것도 안했음
//        if(willsonModels.get(i).getUserInformation() != null) {
//            viewHolder.chatTitle.setText(willsonModels.get(i).getUserInformation());
//        }
//        else{
//            viewHolder.chatTitle.setVisibility(View.GONE);
//        }

        //프로필 보기
//        viewHolder.userProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(),ProfileActivity.class);
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return willsonModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView chatTitle;
        public TextView chatMessage;
        public ImageView chatImage;
        public LinearLayout chatStart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chatTitle = itemView.findViewById(R.id.fragment3_chatTitle);
            chatMessage = itemView.findViewById(R.id.fragment3_chatMessage);
            chatImage = itemView.findViewById(R.id.fragment3_chatImage);
            chatStart = itemView.findViewById(R.id.fragment3_linear);
        }
    }
}
