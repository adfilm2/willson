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

    public MainFragment2(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment2,null);
//        if(getArguments() != null){
//            question_idx = 2;
//            Log.d("question fragment2임" , ">>>>>>>>>>"+question_idx);
//        }

        

        /*myUid = FirebaseAuth.getInstance().getCurrentUser().getUid();*/

        fragment2Recyclerview = view.findViewById(R.id.fragment2_recyclerview);
        fragment2Recyclerview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        accept_helper = new ArrayList<>();
        fragment2Recyclerview.setLayoutManager(layoutManager);


/*            fragment2Recyclerview = view.findViewById(R.id.fragment2_recyclerview);
            fragment2Recyclerview.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(getActivity());
            fragment2Recyclerview.setLayoutManager(layoutManager);
            dataModels = new ArrayList<>();
            fragment2Adapter = new Fragment2Adapter(dataModels, getActivity());
            fragment2Recyclerview.setAdapter(fragment2Adapter);*/
           /* helper_fragment1_recyclerView.setLayoutManager(layoutManager);*/

            /*callWillson(myUid);*/

        /*int question_idx = 38;*/
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NDYsIm5pY2tuYW1lIjoi64uJ64S0IiwiZ2VuZGVyIjoiIiwiYWdlIjoyMywidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyNzU0NTE3LCJleHAiOjE1NzEzOTQ1MTcsImlzcyI6IndpbGxzb24ifQ.8QFtG_wNveh114Fs6NDxcsvMhRocHhKhkYTJjqCFYnc";

        int question_idx = 2;
        Call<AcceptHelperListWatchResponseModel> accept_helper = RetrofitService.getInstance().getService().get_accept_helper(token, question_idx);
        //여기 윗줄에 question_idx값 안넣어줌
        accept_helper.enqueue(retrofitCallback);


            return view;
    }


    private Callback<AcceptHelperListWatchResponseModel> retrofitCallback = new Callback<AcceptHelperListWatchResponseModel>() {

        @Override
        public void onResponse(Call<AcceptHelperListWatchResponseModel> call, Response<AcceptHelperListWatchResponseModel> response) {
            AcceptHelperListWatchResponseModel result = response.body();

            Log.d("사이즈ㅡㅡㅡ", String.valueOf(result.data.getHelper_list().size()));
            Log.d("헬퍼 닉네임",result.data.getHelper_list().get(0).getHelper().getNickname());

            if (response.code() == 200 && result.getCode() == 1000 && result.getData().getHelper_list().size() != 0) {
                accept_helper = result.getData().getHelper_list();
                mainFragment2Adapter = new MainFragment2Adapter(accept_helper, getActivity());
                fragment2Recyclerview.setAdapter(mainFragment2Adapter);
            }
            else {
            }
            mainFragment2Adapter.notifyDataSetChanged();
        }

        @Override
        public void onFailure(Call<AcceptHelperListWatchResponseModel> call, Throwable t) {
            t.printStackTrace();
        }
    };


  /*  //Firebase 데이터베이스에서 willSon 유저 목록을 가져오는 부분
    //본인의 Uid는 if문에서 걸러짐
    public void callWillson(final String myUid){
        FirebaseDatabase.getInstance().getReference().child("testUsers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{
                    for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                        WillsonModel users = dataSnapshot2.getValue(WillsonModel.class);
                        if(users.getUid().equals(myUid)){
                            continue;
                        }
                        dataModels.add(users);
                    }
                    fragment2Adapter.notifyDataSetChanged();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }*/


}
