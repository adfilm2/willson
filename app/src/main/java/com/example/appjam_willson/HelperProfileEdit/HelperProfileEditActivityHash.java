package com.example.appjam_willson.HelperProfileEdit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appjam_willson.R;

public class HelperProfileEditActivityHash extends AppCompatActivity {

    TextView text;
    ImageView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_profile_edit_hash);

        btn = (ImageView)findViewById(R.id.back_btn);
        btn.setVisibility(View.INVISIBLE);
        text = (TextView)findViewById(R.id.toolbar_text);
        text.setText("프로필 수정");
    }
}
