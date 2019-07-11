package com.example.appjam_willson.PopUp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appjam_willson.NetworkService.RetrofitAPI;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.HelperRegistModel;
import com.example.appjam_willson.model.HelperRegistResponseModel;
import com.example.appjam_willson.model.ReviewWriteModel;
import com.example.appjam_willson.model.ReviewWriteResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChatFeedback_CustomDialog extends Dialog {

    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;

    private TextView star_textview;
    private TextView comment_textview;

    private EditText feedback_text;

    private ImageView cancel_btn;
    private ImageView commit_btn;

    private View.OnClickListener cancel_btn_listener;
    private View.OnClickListener commit_btn_listener;

    private Retrofit retrofit;
    private RetrofitAPI retrofitAPI;



    ReviewWriteModel reviewWriteModel;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        WindowManager.LayoutParams window = new WindowManager.LayoutParams();
        window.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.dimAmount = 0.8f;
        getWindow().setAttributes(window);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_chat_feedback_popup);

        star1 = findViewById(R.id.feedback_star1);
        star2 = findViewById(R.id.feedback_star2);
        star3 = findViewById(R.id.feedback_star3);
        star4 = findViewById(R.id.feedback_star4);
        star5 = findViewById(R.id.feedback_star5);

        star_textview = findViewById(R.id.star_num);
        comment_textview = findViewById(R.id.star_comment);

        feedback_text = findViewById(R.id.feedback_comment);

        cancel_btn = findViewById(R.id.feedback_cancel);
        commit_btn = findViewById(R.id.feedback_commit);

        star1.setOnClickListener(new star_click());
        star2.setOnClickListener(new star_click());
        star3.setOnClickListener(new star_click());
        star4.setOnClickListener(new star_click());
        star5.setOnClickListener(new star_click());



        cancel_btn.setOnClickListener(cancel_btn_listener);
        commit_btn.setOnClickListener(commit_btn_listener);


        //통신  ReviewWriteModel


        ReviewWriteModel reviewWriteModel = new ReviewWriteModel();
        reviewWriteModel.review.stars= "3";

        //        reviewWriteModel.review.stars = data.getStringExtra("intro");
        //helperRegistModel.helper.category_name = "ㅋㅋㅋ";
        reviewWriteModel.review.review_content = "아아아아아아";
        reviewWriteModel.review.helper_idx =  3;
        reviewWriteModel.review.category_idx = 6;
        reviewWriteModel.review.question_idx = 66;





        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NTAsIm5pY2tuYW1lIjoibmlja25hbWUiLCJnZW5kZXIiOiLsl6wiLCJhZ2UiOjIzLCJ1c2VyX2xldmVsIjowLCJpYXQiOjE1NjI3Njc4OTcsImV4cCI6MTU3MTQwNzg5NywiaXNzIjoid2lsbHNvbiJ9.VX9-dSw1vzLO7j94UsqOnw6kA3-PeNFp8dic_jHtUt0";

        Call<ReviewWriteResponseModel> call_helper = RetrofitService.getInstance().getService().write_review_post(token, reviewWriteModel);

        call_helper.enqueue(new Callback<ReviewWriteResponseModel>() {
            @Override
            public void onResponse(Call<ReviewWriteResponseModel> call, Response<ReviewWriteResponseModel> response) {
                Log.d("test", response.isSuccessful() + "");
                ReviewWriteResponseModel result = response.body();
                Log.d("response code", ">>>>>>>>>>>>>>>>>>>>>>" + response.code());
                // Log.d("코드값", ">>>>>>>>>>>>>>>>>>>>>>" + result.code);



            }

            @Override
            public void onFailure(Call<ReviewWriteResponseModel> call, Throwable t) {
                t.printStackTrace();
                Log.d("실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
            }
        });


    }

   class star_click implements View.OnClickListener {
       @Override
       public void onClick(View view) {
           switch (view.getId()){
               case R.id.feedback_star1 :
                   star1.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star2.setImageResource(R.drawable.chat_btn_review_star_blank);
                   star3.setImageResource(R.drawable.chat_btn_review_star_blank);
                   star4.setImageResource(R.drawable.chat_btn_review_star_blank);
                   star5.setImageResource(R.drawable.chat_btn_review_star_blank);
                   star_textview.setText("1");
                   comment_textview.setText("별로에요 ");
                   break;

               case R.id.feedback_star2 :
                   star1.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star2.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star3.setImageResource(R.drawable.chat_btn_review_star_blank);
                   star4.setImageResource(R.drawable.chat_btn_review_star_blank);
                   star5.setImageResource(R.drawable.chat_btn_review_star_blank);
                   star_textview.setText("2");
                   comment_textview.setText("조금 아쉬워요 ");
                   break;

               case R.id.feedback_star3 :
                   star1.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star2.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star3.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star4.setImageResource(R.drawable.chat_btn_review_star_blank);
                   star5.setImageResource(R.drawable.chat_btn_review_star_blank);
                   star_textview.setText("3");
                   comment_textview.setText("보통이에요 ");
                   break;

               case R.id.feedback_star4 :
                   star1.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star2.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star3.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star4.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star5.setImageResource(R.drawable.chat_btn_review_star_blank);
                   star_textview.setText("4");
                   comment_textview.setText("좋아요 ");
                   break;

               case R.id.feedback_star5 :
                   star1.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star2.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star3.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star4.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star5.setImageResource(R.drawable.chat_btn_review_star_yellow);
                   star_textview.setText("5");
                   comment_textview.setText("만족해요 ");
                   break;
           }
       }
   }

    public ChatFeedback_CustomDialog(Context context, View.OnClickListener cancel_listener, View.OnClickListener commit_listener) {
        super(context);
        this.cancel_btn_listener = cancel_listener;
        this.commit_btn_listener = commit_listener;
    }

}
