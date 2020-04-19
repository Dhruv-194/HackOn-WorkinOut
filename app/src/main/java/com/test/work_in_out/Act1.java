package com.test.work_in_out;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Act1 extends AppCompatActivity {
    ImageView icanchor;
    Animation rounding;
    TextView timeTT;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;

    private long startTime = 62000;
    private long leftTime = startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);

        icanchor = findViewById(R.id.icanchor);
        rounding = AnimationUtils.loadAnimation(this, R.anim.rounding);

        timeTT = findViewById(R.id.time);



     new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              startTime();
              play();
              icanchor.setAnimation(rounding);
              icanchor.startAnimation(rounding);
          }
      },5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //icanchor.clearAnimation();
                stop();
            }
        },62000);


        ArrayList<Class> activityList = new ArrayList<>();
        Bundle extras = /*getBaseContext().*/getIntent().getExtras();
        activityList = (ArrayList<Class>) extras.get("ACTIVITY_LIST");


        if (activityList.size() == 4) {
            // Do something when after all activities have been opened
            Intent intent = new Intent(this, Final.class);
            startActivity(intent);
        } else {
            // Now, the random number is generated between 1 and however many
            // activities we have remaining
            Random generator = new Random();
            int number = generator.nextInt(activityList.size()) + 1;

            Class activity = null;
            // Here, we are checking to see what the output of the random was
            switch (number) {
                case 1:
                    // We will open the first remaining activity of the list
                    activity = activityList.get(0);
                    // We will now remove that activity from the list
                    activityList.remove(0);
                    break;
                case 2:
                    // We will open the second remaining activity of the list
                    activity = activityList.get(1);
                    activityList.remove(1);
                    break;
                case 3:
                    // We will open the third remaining activity of the list
                    activity = activityList.get(2);
                    activityList.remove(2);
                    break;
                case 4:
                    // We will open the fourth remaining activity of the list
                    activity = activityList.get(3);
                    activityList.remove(3);
                    break;
                default:
                    // We will open the fifth remaining activity of the list
                    activity = activityList.get(4);
                    activityList.remove(4);
                    break;
            }

            // Note: in the above, we might not have 3 remaining activities, for example,
            // but it doesn't matter because that case wouldn't be called anyway,
            // as we have already decided that the number would be between 1 and the number of
            // activities left.


            // Starting the activity, and passing on the remaining number of activities
            // to the next one that is opened

            final Class finalActivity = activity;
            final ArrayList<Class> finalActivityList = activityList;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getBaseContext(), finalActivity);
                    intent.putExtra("ACTIVITY_LIST", finalActivityList);
                    startActivity(intent);
                    finish();
                  //  stop();
                }
            }, 74000);
        }

        }


        private void startTime ()
        {
            countDownTimer = new CountDownTimer(leftTime, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    leftTime = millisUntilFinished;
                    updateCountDown();

                }

                @Override
                public void onFinish() {

                }
            }.start();
        }

        private void updateCountDown ()
        {
            int minutes = (int) (leftTime / 1000) / 60;
            int seconds = (int) (leftTime / 1000) % 60;


            String timeFormat = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
            timeTT.setText(timeFormat);
        }

        private void play ()
        {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(Act1.this, R.raw.song18);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stop();
                    }
                });
            }
            mediaPlayer.start();
        }

        private void stop ()
        {
            if (mediaPlayer != null) {
                mediaPlayer.release();
                mediaPlayer = null;
                Toast.makeText(this, "Music Stop", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onStop ()
        {
            super.onStop();
            stop();
        }
    }

