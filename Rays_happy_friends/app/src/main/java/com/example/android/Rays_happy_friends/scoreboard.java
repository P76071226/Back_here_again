package com.example.android.Rays_happy_friends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class scoreboard extends AppCompatActivity {
    private TextView showcount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        showcount=(TextView)findViewById(R.id.textView);
        Intent intent=getIntent();
        int count=intent.getIntExtra("count_send",0);
        if(showcount != null)
            showcount.setText(Integer.toString(count));


    }
}
