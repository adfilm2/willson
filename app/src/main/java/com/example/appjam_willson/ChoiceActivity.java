package com.example.appjam_willson;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Button choiceWillson = findViewById(R.id.choice_willson);
        Button choiceAsker = findViewById(R.id.choice_asker);

        choiceWillson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceActivity.this, RegisterActivity_willson.class);
                startActivity(intent);
                finish();
            }
        });
        choiceAsker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceActivity.this, RegisterActivity_asker.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
