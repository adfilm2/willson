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

import com.example.appjam_willson.NetworkService.RetrofitService;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.HelperReceivedWorryListWatchResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HelperFragment extends Fragment {

    private RecyclerView helper_fragment1_recyclerView;
    private RecyclerView.LayoutManager layoutManager;
   /* private List<HelperReceivedWorryListWatchResponseModel> userModel;*/
    private List<HelperReceivedWorryListWatchResponseModel.Concern_Info> adapter_send;
    private HelperFragment1Adapter helperFragment1Adapter;

    public HelperFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.helper_fragment1, null);

       String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6NTksIm5pY2tuYW1lIjoi7J2066aE7J2066aEIiwiZ2VuZGVyIjoiIiwiYWdlIjoyMywidXNlcl9sZXZlbCI6MCwiaWF0IjoxNTYyODU3MDU3LCJleHAiOjE1NzE0OTcwNTcsImlzcyI6IndpbGxzb24ifQ.j8sNiLFIXRsZ-CZORN6zuG9IZAS8rQ7m_i0FyRr6LQY";

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

            if (result.getCode() == 800 && result.getData() != null) {
                adapter_send = result.getData().getConcernInfo();
                helperFragment1Adapter = new HelperFragment1Adapter(adapter_send, getActivity());
                helper_fragment1_recyclerView.setAdapter(helperFragment1Adapter);
            }
            else {

            }

        }

        @Override
        public void onFailure(Call<HelperReceivedWorryListWatchResponseModel> call, Throwable t) {
            t.printStackTrace();
        }
    };


}

