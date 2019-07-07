package com.example.appjam_willson.MainActivities;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appjam_willson.R;
import com.example.appjam_willson.model.WillsonModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HelperFragment extends Fragment {

    private RecyclerView helper_fragment1_recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<WillsonModel> willsonModels;
    private HelperFragment1Adapter helperFragment1Adapter;
    private String myUid;

    public HelperFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.helper_fragment1,null);
        myUid = FirebaseAuth.getInstance().getCurrentUser().getUid();


        helper_fragment1_recyclerView = view.findViewById(R.id.helper_fragment1_recyclerview);
        helper_fragment1_recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        helper_fragment1_recyclerView.setLayoutManager(layoutManager);
        willsonModels = new ArrayList<>();
        helperFragment1Adapter = new HelperFragment1Adapter(willsonModels, getActivity());
        helper_fragment1_recyclerView.setAdapter(helperFragment1Adapter);


        return view;
    }
}
