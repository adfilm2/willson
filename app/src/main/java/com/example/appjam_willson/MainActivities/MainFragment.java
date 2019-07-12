package com.example.appjam_willson.MainActivities;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.FillinListActivity.List1CourseStartActivity;
import com.example.appjam_willson.FillinListActivity.List1DailyStartActivity;
import com.example.appjam_willson.FillinListActivity.List1EtcStartActivity;
import com.example.appjam_willson.FillinListActivity.List1LoveStartActivity;
import com.example.appjam_willson.FillinListActivity.List1MentalityStartActivity;
import com.example.appjam_willson.FillinListActivity.List1RelationshipsStartActivity;
import com.example.appjam_willson.HelperSignUpActivity.HelperSignUpStartActivity;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.CreateWorryModel;
import com.example.appjam_willson.model.CreateWorryResponseModel;
import com.example.appjam_willson.model.HelperCheckResponseModel;
import com.example.appjam_willson.model.HelperStoryModel;
import com.example.appjam_willson.model.MainReviewModel;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;


public class MainFragment extends Fragment {

    int REQUEST_CODE_LOVE = 1;
    int REQUEST_CODE_COURSE = 2;
    int REQUEST_CODE_MENTAL = 3;
    int REQUEST_CODE_RELATION= 4;
    int REQUEST_CODE_DAILY = 5;
    int REQUEST_CODE_ETC = 6;

    Context context;

    private StoryAdapter storyAdapter;
    private RecyclerView storyRecyclerView;
    private LinearLayoutManager storyLayoutManager;
    private List<HelperStoryModel.story> storyAdapterModels;
//    private List<MainReviewModel.ReviewData> reviewAdapterModels;

    private ReviewAdapter reviewAdapter;
    private RecyclerView reviewRecyclerView;
    private LinearLayoutManager reviewLayoutManager;
    private List<MainReviewModel.ReviewData> reviewAdapterModels;

    int question_idx;
    Bundle bundle;

    public MainFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment1,null);
        LinearLayout firstContent = view.findViewById(R.id.fragment1_firstContent);
        LinearLayout secondContent = view.findViewById(R.id.fragment1_secondContent);
        LinearLayout thirdContent = view.findViewById(R.id.fragment1_thirdContent);
        LinearLayout fourthContent = view.findViewById(R.id.fragment1_fourthContent);
        LinearLayout fifthContent = view.findViewById(R.id.fragment1_fifthContent);
        LinearLayout sixthContent = view.findViewById(R.id.fragment1_sixthContent);
        storyRecyclerView = view.findViewById(R.id.fragment1_rv);
        reviewRecyclerView = view.findViewById(R.id.fragment1_rv_second);


        LinearLayout changeMode = view.findViewById(R.id.helper_fragment1_change);

        Call<HelperStoryModel> call_helper = RetrofitService.getInstance().getService().helper_story_get(ApplicationFields.userToken);
        call_helper.enqueue(retrofitCallback);
        Call<MainReviewModel> call_review = RetrofitService.getInstance().getService().main_review_get(ApplicationFields.userToken);
        call_review.enqueue(review_retrofitCallback);

        firstContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1LoveStartActivity.class);
                startActivityForResult(intent, REQUEST_CODE_LOVE);
            }
        });

        secondContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1CourseStartActivity.class);
                startActivityForResult(intent, REQUEST_CODE_COURSE);
            }
        });

        thirdContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1MentalityStartActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MENTAL);
            }
        });

        fourthContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1RelationshipsStartActivity.class);
                startActivityForResult(intent, REQUEST_CODE_RELATION);
            }
        });

        fifthContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1DailyStartActivity.class);
                startActivityForResult(intent, REQUEST_CODE_DAILY);
            }
        });

        sixthContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), List1EtcStartActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ETC);
            }
        });

        changeMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<HelperCheckResponseModel> user_profile = RetrofitService.getInstance().getService().helper_exist_check_get(ApplicationFields.userToken);
                user_profile.enqueue(check_retrofitCallback);

                //헬퍼 가입했는지 아닌지 판단해서
                //Intent intent = new Intent(getActivity() , HelperActivity.class);
                Intent intent = new Intent(getActivity() , HelperActivity.class);
                startActivity(intent);
            }
        });

        storyAdapterModels = new ArrayList<>();
        storyRecyclerView.setHasFixedSize(true);
        storyLayoutManager = new LinearLayoutManager(getActivity());
        storyLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        storyRecyclerView.setLayoutManager(storyLayoutManager);
        storyAdapter = new StoryAdapter(storyAdapterModels,getActivity());
        storyRecyclerView.setAdapter(storyAdapter);

        // 스토리   리사이클러뷰의 아이템 번호를 읽은 뒤, 고정 시켜주는 기능
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(storyRecyclerView);

        // 스토리   밑에 동그라미 표시를 해주는 클래스
        CircleIndicator2 indicator = view.findViewById(R.id.indicator);
        indicator.attachToRecyclerView(storyRecyclerView, pagerSnapHelper);
        storyAdapter.registerAdapterDataObserver(indicator.getAdapterDataObserver());

        reviewAdapterModels = new ArrayList<MainReviewModel.ReviewData>();
        reviewRecyclerView.setHasFixedSize(true);
        reviewLayoutManager = new LinearLayoutManager(getActivity());
        reviewLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        reviewRecyclerView.setLayoutManager(reviewLayoutManager);
        reviewAdapter = new ReviewAdapter(reviewAdapterModels,getActivity());
        reviewRecyclerView.setAdapter(reviewAdapter);

//          리뷰   리사이클러뷰의 아이템 번호를 읽은 뒤, 고정 시켜주는 기능
        PagerSnapHelper pagerSnapHelper_second = new PagerSnapHelper();
        pagerSnapHelper_second.attachToRecyclerView(reviewRecyclerView);

//          리뷰    밑에 동그라미 표시를 해주는 클래스
        CircleIndicator2 indicator_second = view.findViewById(R.id.indicator_second);
        indicator_second.attachToRecyclerView(reviewRecyclerView, pagerSnapHelper_second);
        reviewAdapter.registerAdapterDataObserver(indicator_second.getAdapterDataObserver());

        return view;
    }

    private Callback<HelperCheckResponseModel> check_retrofitCallback = new Callback<HelperCheckResponseModel>() {
        @Override
        public void onResponse(Call<HelperCheckResponseModel> call, Response<HelperCheckResponseModel> response) {
            HelperCheckResponseModel result = response.body();
            if(result.data.status){
                Intent intent = new Intent(getActivity(),HelperActivity.class);
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(getActivity() , HelperSignUpStartActivity.class);
                startActivity(intent);

            }

        }

        @Override
        public void onFailure(Call<HelperCheckResponseModel> call, Throwable t) {
                Log.d(">>>>>>헬퍼 등록 체크 실패>>>>>>>","실패래요~~~~");
        }
    };
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_COURSE || requestCode == REQUEST_CODE_DAILY || requestCode ==REQUEST_CODE_ETC ||requestCode == REQUEST_CODE_LOVE || requestCode ==REQUEST_CODE_MENTAL ||requestCode ==REQUEST_CODE_RELATION){
            switch (resultCode){
                case RESULT_OK:

                    CreateWorryModel createWorryModel = new CreateWorryModel();
                    createWorryModel.feeling = data.getIntArrayExtra("feeling");
                    createWorryModel.personality = data.getIntArrayExtra(("char"));
                    createWorryModel.experience = data.getStringArrayListExtra("experience");
                    createWorryModel.question.weight =data.getIntExtra("importance",0);
                    createWorryModel.question.content = data.getStringExtra("contents");
                    createWorryModel.question.emotion = data.getIntExtra("empathy",1);
                    createWorryModel.question.advise = data.getIntExtra("advice",1);
                    createWorryModel.question.experience = data.getIntExtra("experience22", 1);
                    createWorryModel.question.agreement = CreateWorryModel.Question.Agreement.agree;
                    createWorryModel.question.categoryList_idx = data.getIntExtra("category_id",0);
                    String gender = data.getStringExtra("helper_gender");
                    switch (gender){
                        case "여자":
                            createWorryModel.question.helper_gender = CreateWorryModel.Question.Helper_gender.여성;
                        case "남자":
                            createWorryModel.question.helper_gender = CreateWorryModel.Question.Helper_gender.남성;
                        case "모두":
                            createWorryModel.question.helper_gender = CreateWorryModel.Question.Helper_gender.모두;
                    }


                    Call<CreateWorryResponseModel> call_helper = RetrofitService.getInstance().getService().create_model_post(ApplicationFields.userToken, createWorryModel);
                    call_helper.enqueue(new Callback<CreateWorryResponseModel>() {
                        @Override
                        public void onResponse(Call<CreateWorryResponseModel> call, Response<CreateWorryResponseModel> response) {
                            Log.d("test", response.isSuccessful() + "");
                            CreateWorryResponseModel result = response.body();
                            Log.d(">>result>>>>>",""+result);
                            Log.d(">>response>>>>>",""+response);
                            Log.d(">> response.code", ">>>>>>>>>>>" + response.code());
                            Log.d(">> question_idx ;:::: ",">>"+result.data.question_idx);
                            ApplicationFields.myQuestion_idx = result.data.question_idx;
//                            Intent intent = new Intent(getActivity(),MainActivity.class);
//                            intent.putExtra("complete","OK");
//                            startActivity(intent);


                            ImageView willsonImage_home = getActivity().findViewById(R.id.Image_home);
                            ImageView willsonImage_chat = getActivity().findViewById(R.id.Image_chat);
                            ImageView willsonImage_request = getActivity().findViewById(R.id.Image_request);
                            ImageView willsonImage_mypage = getActivity().findViewById(R.id.Image_mypage);

                            TextView willsonText_home = getActivity().findViewById(R.id.text_home);
                            TextView willsonText_chat = getActivity().findViewById(R.id.text_chat);
                            TextView willsonText_request = getActivity().findViewById(R.id.text_request);
                            TextView willsonText_mypage = getActivity().findViewById(R.id.text_mypage);

                            changeImage(willsonImage_request,willsonImage_chat,willsonImage_mypage,willsonImage_home);
                            changeTextColor(willsonText_request,willsonText_home,willsonText_chat,willsonText_mypage);


                            MainFragment2_loading fragment = new MainFragment2_loading();
                            question_idx = result.data.question_idx;
                            bundle = new Bundle();
                            bundle.putInt("question_idx", question_idx);
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
                        }

                        @Override
                        public void onFailure(Call<CreateWorryResponseModel> call, Throwable t) {
                            t.printStackTrace();
                            Log.d("메인 실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
                        }
                    });


                case RESULT_CANCELED:

            }
        }


    }



    //text뷰의 start포인트부터 end포인트까지 색을 바꿔줌 color값으로

    private Callback<HelperStoryModel> retrofitCallback = new Callback<HelperStoryModel>() {

        @Override
        public void onResponse(Call<HelperStoryModel> call, Response<HelperStoryModel> response) {
            HelperStoryModel result = response.body();

            for (int i = 0; i < result.getData().size(); i++) {
                storyAdapterModels.add(result.getData().get(i));
//            }
                storyAdapter.notifyDataSetChanged();
            }
        }
        @Override
        public void onFailure(Call<HelperStoryModel> call, Throwable t) {
            t.printStackTrace();
            Log.d("실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
        }
    };

    private void changeImage(ImageView first, ImageView second, ImageView third, ImageView fourth) {
        first.setSelected(true);
        second.setSelected(false);
        third.setSelected(false);
        fourth.setSelected(false);
    }

    private void changeTextColor(TextView first, TextView second, TextView third, TextView fourth) {
        first.setTextColor(Color.parseColor("#2f2f2f"));
        second.setTextColor(Color.parseColor("#9e9e9e"));
        third.setTextColor(Color.parseColor("#9e9e9e"));
        fourth.setTextColor(Color.parseColor("#9e9e9e"));
    }


    private Callback<MainReviewModel> review_retrofitCallback = new Callback<MainReviewModel>() {

        @Override
        public void onResponse(Call<MainReviewModel> call, Response<MainReviewModel> response) {
            MainReviewModel result = response.body();

            for (int i = 0; i < result.getData().size(); i++) {
                reviewAdapterModels.add(result.getData().get(i));
//            }
                reviewAdapter.notifyDataSetChanged();
            }
        }
        @Override
        public void onFailure(Call<MainReviewModel> call, Throwable t) {
            t.printStackTrace();
            Log.d("실ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패", ">>>>>>>>>>>");
        }
    };
}
