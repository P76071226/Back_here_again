/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.Rays_happy_friends;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Displays two Buttons and a TextView.
 * - Pressing the TOAST button shows a Toast.
 * - Pressing the COUNT button increases the displayed mCount.
 *
 * Note: Fixing behavior when device is rotated is a challenge exercise for the student.
 */

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private View zeroview;
    private int random_number ;
    private int old_number = 0;
    private int level = 0;
    private int sbopen=0;
    private int score_no;

    private boolean lock = true;
    private boolean pause = false;
    private boolean stop = false;
    private boolean stop_flag = false;
    private boolean left =false;
    private boolean level_change=false;
    private boolean board_lock = false;

    private long TimeSet = 15000;
    private long TimeInterval = 1000;
    private long TotalTime = TimeSet;
    private long CurrentTime = TotalTime;


    int[] score_for_scoreboard = new int[5];
    int[] score_for_main = new int[6];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        ImageButton btn = (ImageButton)findViewById(R.id.angel_1);
        // Log.d("MainActivity", "P76071226");
        for(int i=0; i<5; i++){
            score_for_scoreboard[i] = -10000;
        }
        for(int i=0; i < 6; i++){
            score_for_main[i] = -10000;
        }


        Random x = new Random();
        random_number = x.nextInt(20);


    }

    public void launchScoreBoard() {
        sbopen++;
        //if(sbopen%2==0) {
            score_for_main[0] = mCount;

            Arrays.sort(score_for_main);
           for (int i = 0; i < 5; i++) {
                score_for_scoreboard[i] = score_for_main[i+1];
           }
            mCount = 0;

            Intent intent = new Intent(this, scoreboard.class);
            intent.putExtra("count_send", score_for_scoreboard);
            startActivity(intent);
        //}

    }


    /*
    * Shows a Toast when the TOAST button is clicked.
    *
    * @param view The view that triggered this onClick handler.
    *             Since a toast always shows on the top,
    *             the passed in view is not used.
    */
    public void ShowToast(View view) {
        /*Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();*/
        board_lock = false;
        Intent intent=new Intent(this,scoreboard.class);
        intent.putExtra("count_send", score_for_scoreboard);
        startActivity(intent);
    }

    /*
    * Increments the number in the TextView when the COUNT button is clicked.
    *
    * @param view The view that triggered this onClick handler.
    *             Since the count always appears in the TextView,
    *             the passed in view is not used.
    */
    public void countUp(View view) {
        mCount++;

        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if(mCount % 2 == 0)
            view.setBackgroundColor(this.getResources().getColor(R.color.colorPrimary));

        else
            view.setBackgroundColor(Color.GREEN);

        zeroview = findViewById(R.id.button_zero);
        if(mCount != 0)
            zeroview.setBackgroundColor(Color.RED);
    }

    public void rst(View view) {
        //mCount = 0;
        lock = true;
        ImageButton btn = (ImageButton) findViewById(R.id.angel_1);
        TextView textView = findViewById(R.id.button_zero);
        if(!pause){
            pause = true;
            textView.setText("Continue");
        }
        else {
            textView.setText("pause");
            TotalTime = CurrentTime;
            left = true;
            start(view);
        }

        //view.setBackgroundColor(Color.GRAY);
        Switch_(old_number,btn, "angel");
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));

    }

    public void hit1(View view) {
        if(random_number == 1 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit2(View view) {
        if(random_number == 2 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit3(View view) {
        if(random_number == 3 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit4(View view) {
        if(random_number == 4 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit5(View view) {
        if(random_number == 5 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit6(View view) {
        if(random_number == 6 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit7(View view) {
        if(random_number == 7 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit8(View view) {
        if(random_number == 8 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit9(View view) {
        if(random_number == 9 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit10(View view) {
        if(random_number == 10 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit11(View view) {
        if(random_number == 11 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit12(View view) {
        if(random_number == 12 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit13(View view) {
        if(random_number == 13 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit14(View view) {
        if(random_number == 14 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit15(View view) {
        if(random_number == 15 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void hit16(View view) {
        if(random_number == 16 && lock == false) {
            mCount++;
        }else if(lock == false){
            mCount--;
        }
        lock = true;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void Show_Score_Toast(){
        /*Toast toast = (Toast) Toast.makeText(this, "your score is " + mCount, Toast.LENGTH_SHORT);
        toast.show();*/
        showToast(this, "your score is " + mCount,1000);
    }

    public void start(final View view) {
        final TextView start_btn = findViewById(R.id.button_start);
        level_change=true;


        if(!left) {
            if (stop) {
                stop_flag = true;
                return;
            } else stop_flag = false;
        }
        left = false;
        if(!pause){
            TotalTime = TimeSet;
            if(!stop_flag)
                mCount = 0;
            ImageButton btn = (ImageButton) findViewById(R.id.angel_1);
            Switch_(old_number,btn, "angel");
            if (mShowCount != null)
                mShowCount.setText(Integer.toString(mCount));
        }
        if(pause) pause = !pause;
        start_btn.setText("Stop");
        lock = false;
        stop = true;

        new CountDownTimer(TotalTime,TimeInterval){
            TextView time = (TextView) findViewById(R.id.timer);


            @Override
            public void onFinish() {

                time.setText("Times up!");
                Show_Score_Toast();
                start_btn.setText("Start");
                TextView textView = findViewById(R.id.button_zero);
                textView.setText("Pause");
                lock=true;
                stop = false;
                pause = false;
                Switch_(old_number,(ImageButton) findViewById(R.id.angel_1),"angel");
                level_change=false;
                launchScoreBoard();


            }

            @Override
            public void onTick(long millisUntilFinished) {

                CurrentTime = millisUntilFinished;

                time.setText(""+millisUntilFinished/1000);
                ImageButton btn = (ImageButton) findViewById(R.id.angel_1);
                Switch_(old_number, btn,"angel");


                Random x = new Random();
                random_number = x.nextInt(16) + 1;
                while(random_number == old_number){
                    x = new Random();
                    random_number = x.nextInt(16) + 1;
                }
                old_number = random_number;
                lock = false;
                Log.d("MAMAMIy", ""+random_number);
                Switch_(random_number, btn , "devil");

                if(pause) {
                    Switch_(old_number,(ImageButton) findViewById(R.id.angel_1),"angel");
                    lock = true;
                    this.cancel();
                }


                if(stop_flag){
                    this.cancel();
                    this.onFinish();
                    time.setText("Ready again?");
                }
            }

        }.start();


    }



    public  void Switch_(int number, ImageButton btn, String who){

        switch (number) {
            case 1:
                btn = (ImageButton)findViewById(R.id.angel_1);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 2:
                btn = (ImageButton)findViewById(R.id.angel_2);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 3:
                btn = (ImageButton)findViewById(R.id.angel_3);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 4:
                btn = (ImageButton)findViewById(R.id.angel_4);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 5:
                btn = (ImageButton)findViewById(R.id.angel_5);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 6:
                btn = (ImageButton)findViewById(R.id.angel_6);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 7:
                btn = (ImageButton)findViewById(R.id.angel_7);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 8:
                btn = (ImageButton)findViewById(R.id.angel_8);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 9:
                btn = (ImageButton)findViewById(R.id.angel_9);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 10:
                btn = (ImageButton)findViewById(R.id.angel_10);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 11:
                btn = (ImageButton)findViewById(R.id.angel_11);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 12:
                btn = (ImageButton)findViewById(R.id.angel_12);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 13:
                btn = (ImageButton)findViewById(R.id.angel_13);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 14:
                btn = (ImageButton)findViewById(R.id.angel_14);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 15:
                btn = (ImageButton)findViewById(R.id.angel_15);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;
            case 16:
                btn = (ImageButton)findViewById(R.id.angel_16);
                if(who =="angel")
                    btn.setImageResource(R.drawable.angel);
                else btn.setImageResource(R.drawable.devil);
                break;

        }
    }

    public static void showToast(final Activity activity, final String word, final long time){
        activity.runOnUiThread(new Runnable() {
            public void run() {
                final Toast toast = Toast.makeText(activity, word, Toast.LENGTH_LONG);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        toast.cancel();
                    }
                }, time);
            }
        });
    }


    public void ChangeLevel(View view) {
        if(!level_change) {
            level++;
            if (level % 2 == 1) {
                TimeInterval = 700;
                /*Toast toast = (Toast) Toast.makeText(this, "Hard", Toast.LENGTH_SHORT);
                toast.show();*/
                showToast(this, "Hard",700);
            } else {
                TimeInterval = 1000;
                /*Toast toast = (Toast) Toast.makeText(this, "Normal", Toast.LENGTH_SHORT);
                toast.show();*/
                showToast(this, "Normal",700);
            }
        }
    }
}
