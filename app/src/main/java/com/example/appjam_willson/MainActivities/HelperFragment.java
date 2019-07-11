package com.example.appjam_willson.MainActivities;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.NetworkService.RetrofitAPI;
import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.DataModel;
import com.example.appjam_willson.model.HelperReceivedWorryListWatchResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HelperFragment extends Fragment {

    private RecyclerView helper_fragment1_recyclerView;
    private RecyclerView.LayoutManager layoutManager;
   /* private List<HelperReceivedWorryListWatchResponseModel> userModel;*/
    private List<HelperReceivedWorryListWatchResponseModel.Concern_Info> adapter_send;
    private HelperFragment1Adapter helperFragment1Adapter;
    private String myUid;

    private Retrofit retrofit;
    private RetrofitAPI retrofitAPI;
    private DataModel dataModel;

    public HelperFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.helper_fragment1, null);

/*        myUid = FirebaseAuth.getInstance().getCurrentUser().getUid();*/

       /* String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6Nywibmlja25hbWUiOiJhIiwiZ2VuZGVyIjoi7JesIiwiYWdlIjozNSwidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyNTkxNDE4LCJleHAiOjE1NzEyMzE0MTgsImlzcyI6IndpbGxzb24ifQ.8ZxnOA11-BUSyHqKj5piY1VMFxkua8Cy3BcZ5hCyBME";
*///그전에 쓴 token

       /*String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NDYsIm5pY2tuYW1lIjoi64uJ64S0IiwiZ2VuZGVyIjoiIiwiYWdlIjoyMywidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyNzU0NTE3LCJleHAiOjE1NzEzOTQ1MTcsImlzcyI6IndpbGxzb24ifQ.8QFtG_wNveh114Fs6NDxcsvMhRocHhKhkYTJjqCFYnc";
*///전에 쓴 token

        /*String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NTAsIm5pY2tuYW1lIjoibmlja25hbWUiLCJnZW5kZXIiOiLsl6wiLCJhZ2UiOjIzLCJ1c2VyX2xldmVsIjowLCJpYXQiOjE1NjI3ODEyNTQsImV4cCI6MTU3MTQyMTI1NCwiaXNzIjoid2lsbHNvbiJ9.R86ritC1vJ6gX2QVLNfaEp6aF8JDYwdtGPzPNzPqmcU";
*/// 전

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NTAsIm5pY2tuYW1lIjoibmlja25hbWUiLCJnZW5kZXIiOiLsl6wiLCJhZ2UiOjIzLCJ1c2VyX2xldmVsIjowLCJpYXQiOjE1NjI3ODEyNTQsImV4cCI6MTU3MTQyMTI1NCwiaXNzIjoid2lsbHNvbiJ9.R86ritC1vJ6gX2QVLNfaEp6aF8JDYwdtGPzPNzPqmcU";

        LinearLayout change_mode = view.findViewById(R.id.helper_fragment1_change);

        change_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        helper_fragment1_recyclerView = view.findViewById(R.id.helper_fragment1_recyclerview);
        helper_fragment1_recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter_send = new ArrayList<>();
        helper_fragment1_recyclerView.setLayoutManager(layoutManager);

        Call<HelperReceivedWorryListWatchResponseModel> call_worryList = RetrofitService.getInstance().getService().helper_receiveList_get(token);
        call_worryList.enqueue(retrofitCallback);

        return view;


    }

    private Callback<HelperReceivedWorryListWatchResponseModel> retrofitCallback = new Callback<HelperReceivedWorryListWatchResponseModel>() {

        @Override
        public void onResponse(Call<HelperReceivedWorryListWatchResponseModel> call, Response<HelperReceivedWorryListWatchResponseModel> response) {
            HelperReceivedWorryListWatchResponseModel result = response.body();

       /*     Log.d("성공ㅇㅇㅇㅇ", String.valueOf(result.getCode()));
            Log.d("메시지ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ", result.getMessage());
            Log.d("유저 닉네임", result.getData().getConcernInfo().get(0).getUserInfo().getNickname());
*/
            if (result.getCode() == 800 && result.getData() != null) {
                adapter_send = result.getData().getConcernInfo();
                helperFragment1Adapter = new HelperFragment1Adapter(adapter_send, getActivity());
                helper_fragment1_recyclerView.setAdapter(helperFragment1Adapter);
            }
            else {
               /* HelperFragment1_null fragment = new HelperFragment1_null();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
*/
            }
           /* Log.d("리ㅣㅣㅣㅣ", String.valueOf(result.getData().getSize()));
            Log.d("삽질ㄹㄹㄹㄹㄹㄹ", String.valueOf(result.getData().getConcernInfo().get(1).getUserInfo()));
        */
        }

        @Override
        public void onFailure(Call<HelperReceivedWorryListWatchResponseModel> call, Throwable t) {
            t.printStackTrace();
            Log.d("실패ㅐㅐㅐㅐㅐ","대실패");
        }
    };


}

