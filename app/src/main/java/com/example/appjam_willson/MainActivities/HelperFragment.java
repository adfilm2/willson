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


import com.example.appjam_willson.NetworkService.RetrofitAPI;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.DataModel;
import com.example.appjam_willson.model.WillsonModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HelperFragment extends Fragment {

    private RecyclerView helper_fragment1_recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<DataModel> dataModels;
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

        myUid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RetrofitAPI.class);

        helper_fragment1_recyclerView = view.findViewById(R.id.helper_fragment1_recyclerview);
        helper_fragment1_recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        dataModels = new ArrayList<>();
        helper_fragment1_recyclerView.setLayoutManager(layoutManager);
        helperFragment1Adapter = new HelperFragment1Adapter(dataModels, getActivity());
        helper_fragment1_recyclerView.setAdapter(helperFragment1Adapter);

        int test = 2;
        callusers(test);

        return view;


    }

    private void callusers(int user) {
        Call<DataModel> callUser = retrofitAPI.getUser(user);
        callUser.enqueue(retrofitCallback);
    }

    private Callback<DataModel> retrofitCallback = new Callback<DataModel>() {

        @Override
        public void onResponse(Call<DataModel> call, Response<DataModel> response) {
            DataModel result = response.body();
            dataModels.add(result);
            helperFragment1Adapter.notifyDataSetChanged();
        }

        @Override
        public void onFailure(Call<DataModel> call, Throwable t) {
            t.printStackTrace();
        }
    };
}

