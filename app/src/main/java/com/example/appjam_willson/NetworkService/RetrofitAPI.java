package com.example.appjam_willson.NetworkService;

import com.example.appjam_willson.model.CreateWorryModel;
import com.example.appjam_willson.model.DataModel;
import com.example.appjam_willson.model.HelperReceivedWorryListWatchResponseModel;
import com.example.appjam_willson.model.HelperRegistModel;
import com.example.appjam_willson.model.HelperRegistResponseModel;
import com.example.appjam_willson.model.LoginModel;
import com.example.appjam_willson.model.LoginResponseModel;
import com.example.appjam_willson.model.SignupModel;
import com.example.appjam_willson.model.SignupResponseModel;
import com.example.appjam_willson.model.WorryCategoryListAddModel;
import com.example.appjam_willson.model.WorryCategoryListAddResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("/users/{a}")
    Call<DataModel> getUser(@Path("a") int data);

    @POST("helper/registration")
    Call<HelperRegistResponseModel> helper_regist_post(@Header("willson-token") String token,
                                                       @Body HelperRegistModel helperRegistModel);

    @POST("user/signup")
    Call<SignupResponseModel> signup_response(@Header("user_session") String token, @Body SignupModel signupModel);

    @POST("user/signin")
    Call<LoginResponseModel> login_post(@Header("user_session") String token, @Body LoginModel loginModel);

    @POST("concern/category")
    Call<WorryCategoryListAddResponseModel> concern_category_list(@Header("user_session") String token, @Body WorryCategoryListAddModel worryCategoryListAddModel);



    @POST("concern/question")
    Call<WorryCategoryListAddResponseModel> concern_question_list(@Header("user_session") String token, @Body CreateWorryModel createWorryModel);


    //헬퍼가 받은 고민리스트 보기
    @GET("concern/list")
    Call<HelperReceivedWorryListWatchResponseModel> helper_recived_worrylist();

    //헬퍼등록
    @POST("helper/registration")
    Call<HelperRegistModel> helper_regist(@Header("willson-token") String token, @Body HelperRegistResponseModel helperRegistResponseModel);








}
