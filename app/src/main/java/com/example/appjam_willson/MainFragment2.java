package com.example.appjam_willson;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appjam_willson.model.WillsonModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainFragment2 extends Fragment {

    private RecyclerView fragment2_recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<WillsonModel> willsonModels;
    private Fragment2Adapter fragment2Adapter;
    private String myUid;

    public MainFragment2(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.main_fragment2,null);

            myUid = FirebaseAuth.getInstance().getCurrentUser().getUid();


            fragment2_recyclerView = view.findViewById(R.id.fragment2_recyclerview);
            fragment2_recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(getActivity());
            fragment2_recyclerView.setLayoutManager(layoutManager);
            willsonModels = new ArrayList<>();
            fragment2Adapter = new Fragment2Adapter(willsonModels, getActivity());
            fragment2_recyclerView.setAdapter(fragment2Adapter);

            callWillson(myUid);

            return view;
    }

    //Firebase 데이터베이스에서 willSon 유저 목록을 가져오는 부분
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
                        willsonModels.add(users);
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
    }
}
