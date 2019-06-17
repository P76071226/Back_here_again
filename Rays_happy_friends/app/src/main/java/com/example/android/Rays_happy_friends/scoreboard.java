package com.example.android.Rays_happy_friends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class scoreboard extends AppCompatActivity {
    private TextView showcount;
    private TextView showcount2;
    private TextView showcount3;
    private TextView showcount4;
    private TextView showcount5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        showcount=(TextView)findViewById(R.id.textView);
        showcount2=(TextView)findViewById(R.id.textView2);
        showcount3=(TextView)findViewById(R.id.textView3);
        showcount4=(TextView)findViewById(R.id.textView4);
        showcount5=(TextView)findViewById(R.id.textView5);
        Intent intent = this.getIntent();
        int[] count = new int[6];
        count = intent.getIntArrayExtra("count_send");

       if(showcount != null)
            showcount.setText(Integer.toString(count[4]) );
        if(showcount2 != null)
            showcount2.setText(Integer.toString(count[3]));
        if(showcount3 != null)
            showcount3.setText(Integer.toString(count[2]) );
        if(showcount4 != null)
            showcount4.setText(Integer.toString(count[1]) );
        if(showcount5 != null)
            showcount5.setText(Integer.toString(count[0]) );

    }
}
