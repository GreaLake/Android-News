package com.example.androidnewsui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidnewsui.R;

public class SigelActivity extends AppCompatActivity {

    TextView title = null;

    TextView content = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigel);
        Intent intent = getIntent();
        title = findViewById(R.id.singleTitle);
        content = findViewById(R.id.singleEssay);
        title.setText(intent.getStringExtra("title"));
        content.setText(intent.getStringExtra("content"));
    }

}