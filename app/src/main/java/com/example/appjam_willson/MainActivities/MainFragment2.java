package com.example.appjam_willson.MainActivities;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.ApplicationField.ApplicationFields;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.AcceptHelperListWatchResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment2 extends Fragment {

    private RecyclerView fragment2Recyclerview;
    private RecyclerView.LayoutManager layoutManager;
    private List<AcceptHelperListWatchResponseModel.Helper_list> accept_helper;
    private MainFragment2Adapter mainFragment2Adapter;
    int question_idx;
    Bundle bundle;

    public MainFragment2(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment2,null);



            question_idx = ApplicationFields.myQuestion_idx;
            String token = ApplicationFields.userToken;

            fragment2Recyclerview = view.findViewById(R.id.fragment2_recyclerview);
            fragment2Recyclerview.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(getActivity());
            accept_helper = new ArrayList<>();
            fragment2Recyclerview.setLayoutManager(layoutManager);


            Call<AcceptHelperListWatchResponseModel> accept_helper = RetrofitService.getInstance().getService().get_accept_helper(token, question_idx);
            //여기 윗줄에 question_idx값 안넣어줌
            accept_helper.enqueue(retrofitCallback);

        return view;

    }


    private Callback<AcceptHelperListWatchResponseModel> retrofitCallback = new Callback<AcceptHelperListWatchResponseModel>() {

        @Override
        public void onResponse(Call<AcceptHelperListWatchResponseModel> call, Response<AcceptHelperListWatchResponseModel> response) {
            AcceptHelperListWatchResponseModel result = response.body();

            if (response.code() == 200 && result.getCode() == 1000 && result.getData().getHelper_list().size() != 0) {
                accept_helper = result.getData().getHelper_list();
                mainFragment2Adapter = new MainFragment2Adapter(accept_helper, getActivity(), question_idx);
                fragment2Recyclerview.setAdapter(mainFragment2Adapter);
            }
            else {
                return ;
            }
        }

        @Override
        public void onFailure(Call<AcceptHelperListWatchResponseModel> call, Throwable t) {
            t.printStackTrace();
        }
    };
}
