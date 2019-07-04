package com.example.appjam_willson;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appjam_willson.model.WillsonModel;

import java.util.List;

public class WillsonFragment2Adapter extends RecyclerView.Adapter<WillsonFragment2Adapter.ViewHolder> {

    private List<WillsonModel> willsonModels;
    private Context context;

    public WillsonFragment2Adapter(List<WillsonModel> willsonModels, Context context){
        this.willsonModels = willsonModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.willson_fragment2_rv_item, viewGroup, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        //닉네임
        if(willsonModels.get(i).getNickName() == null) {
            viewHolder.userNickname.setText(willsonModels.get(i).getUid());
        }
        else{
            viewHolder.userNickname.setText(willsonModels.get(i).getNickName());
        }

        //사진
        if(willsonModels.get(i).getPhoto().equals("")) {
            viewHolder.userImage.setImageResource(R.drawable.chat_img_helperprofile);
        }

        //채팅시작
        viewHolder.chatStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),WillsonChatActivity.class);
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

        public TextView userNickname;
        public ImageView userImage;
        public LinearLayout chatStart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userNickname = itemView.findViewById(R.id.willson_fragment2_chatTitle);
            userImage = itemView.findViewById(R.id.willson_fragment2_chatImage);
            chatStart = itemView.findViewById(R.id.willson_fragment2_linear);

        }
    }
}
