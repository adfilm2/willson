package com.example.appjam_willson.MainActivities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.HelperProfileEdit.HelperProfileEditActivityStart;
import com.example.appjam_willson.R;
import com.example.appjam_willson.model.WillsonModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HelperFragment4 extends Fragment {

    private RecyclerView fragment2_recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<WillsonModel> willsonModels;
    private Fragment2Adapter fragment2Adapter;
    private String myUid;


    public HelperFragment4(){
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment2,null);


        fragment2_recyclerView = view.findViewById(R.id.fragment2_recyclerview);
        fragment2_recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        fragment2_recyclerView.setLayoutManager(layoutManager);
        willsonModels = new ArrayList<>();
        fragment2Adapter = new Fragment2Adapter(willsonModels, getActivity());
        fragment2_recyclerView.setAdapter(fragment2Adapter);


        return view;
    }

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


    private class setting_click implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intentProfileEdit = new Intent(view.getContext(), HelperProfileEditActivityStart.class);
            startActivity(intentProfileEdit);
        }
    }
}
