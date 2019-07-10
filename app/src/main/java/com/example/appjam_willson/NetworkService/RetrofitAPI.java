package com.example.appjam_willson.NetworkService;

import com.example.appjam_willson.model.ChoiceHelperModel;
import com.example.appjam_willson.model.ChoiceHelperResponseModel;
import com.example.appjam_willson.model.CreateWorryModel;
import com.example.appjam_willson.model.ExitChatModel;
import com.example.appjam_willson.model.ExitChatResponseModel;
import com.example.appjam_willson.model.FeelingStatusListResponseModel;
import com.example.appjam_willson.model.HelperProfileEditModel;
import com.example.appjam_willson.model.HelperProfileEditResponseModel;
import com.example.appjam_willson.model.HelperProfileWatchResponseModel;
import com.example.appjam_willson.model.HelperReceivedWorryListWatchResponseModel;
import com.example.appjam_willson.model.HelperRegistModel;
import com.example.appjam_willson.model.HelperRegistResponseModel;
import com.example.appjam_willson.model.HelperStoryModel;
import com.example.appjam_willson.model.LoginModel;
import com.example.appjam_willson.model.LoginResponseModel;
import com.example.appjam_willson.model.ReviewFixModel;
import com.example.appjam_willson.model.ReviewListResponseModel;
import com.example.appjam_willson.model.ReviewWriteModel;
import com.example.appjam_willson.model.ReviewWriteResponseModel;
import com.example.appjam_willson.model.SendRequestModel;
import com.example.appjam_willson.model.SendRequestResponseModel;
import com.example.appjam_willson.model.SignupModel;
import com.example.appjam_willson.model.SignupResponseModel;
import com.example.appjam_willson.model.WorryCategoryListAddModel;
import com.example.appjam_willson.model.WorryCategoryListAddResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("helper/story")
    Call<HelperStoryModel> helper_story_get(@Header("willson-token") String token);

    @POST("helper/registration")
    Call<HelperRegistResponseModel> helper_regist_post(@Header("willson-token") String token, @Body HelperRegistModel helperRegistModel);

    @POST("user/signup")
    Call<SignupResponseModel> user_signup_post(@Body SignupModel signupModel);

    @POST("user/signin")
    Call<LoginResponseModel> user_login_post(@Body LoginModel loginModel);

    @PUT("review/{review_idx}")
    Call<ReviewWriteResponseModel> user_reviewFix_post(@Path("review_idx") int idx,
                                                       @Body ReviewFixModel reviewFixModel);
    @GET("concern/list")
    Call<HelperReceivedWorryListWatchResponseModel> helper_receiveList_get(@Header("willson-token") String token);

    @POST("concern/category")
    Call<WorryCategoryListAddResponseModel> add_category_post(@Header("willson-token") String token,
                                                         @Body WorryCategoryListAddModel worryCategoryListAddModel);

    @POST("concern/question")
    Call<WorryCategoryListAddResponseModel> create_model_post(@Header("willson-token") String token,
                                                         @Body CreateWorryModel createWorryModel);

    @GET("helper/profile/{helper_idx}")
    Call<HelperProfileWatchResponseModel> watch_helperProfile_get(@Header("willson-token") String token,
                                                                  @Path("helper_idx") int helper_idx);

    @PUT("helper/profile")
    Call<HelperProfileEditResponseModel> helper_profileFix_put(@Header("willson-token") String token,
                                                               @Body HelperProfileEditModel helperProfileEditModel);

    @POST("helper/selection")
    Call<SendRequestResponseModel> send_request_post(@Header("willson-token") String token,
                                             @Body SendRequestModel sendRequestModel);

    @GET("helper/{helper_idx}/review")
    Call<ReviewListResponseModel> show_reviewList_get(@Header("willson-token") String token,
                                                      @Path("helper_idx") int helper_idx);

    @POST("review")
    Call<ReviewWriteResponseModel> write_review_post(@Header("willson-token") String token,
                                                     @Body ReviewWriteModel reviewWriteModel);

    @POST("concern/personality")
    Call<FeelingStatusListResponseModel> feeling_statusList_post(@Header("willson-token")String token);

    @POST("user/selection")
    Call<ChoiceHelperResponseModel> choice_helper_post(@Header("willson-token") String token,
                                                       @Body ChoiceHelperModel choiceHelperModel);

    @PUT("concern/question")
    Call<ExitChatResponseModel> exit_chat_put(@Header("willson-token") String token,
                                              @Body ExitChatModel exitChatModel);

    @POST("concern/category")
    Call<WorryCategoryListAddResponseModel> concern_category_list_post(@Header("willson-token") String token, @Body WorryCategoryListAddModel worryCategoryListAddModel);

}