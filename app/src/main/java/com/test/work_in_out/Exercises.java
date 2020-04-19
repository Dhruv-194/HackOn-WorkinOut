package com.test.work_in_out;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import static android.widget.Toast.*;

public class Exercises extends AppCompatActivity {

Button go;
MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Exercises.this, "Starting in : 3", Toast.LENGTH_SHORT).show();
                    }
                },2000);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Exercises.this, "Starting in : 2", Toast.LENGTH_SHORT).show();
                    }
                },4000);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Exercises.this, "Starting in : 1", Toast.LENGTH_SHORT).show();
                    }
                },6000);






                /*new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        testIntent();
                    }
                }, 2000);*/

                // We are creating a list, which will store the activities that haven't been opened yet
                ArrayList<Class> activityList = new ArrayList<>();
                activityList.add(Act1.class);
                activityList.add(Act2.class);
                activityList.add(Act3.class);
                activityList.add(Act4.class);
                activityList.add(Act5.class);
                activityList.add(Act6.class);
                activityList.add(Act7.class);
                activityList.add(Act8.class);
                activityList.add(Act9.class);
                activityList.add(Act10.class);

                Random generator = new Random();
                int number = generator.nextInt(10) + 1;

                Class activity = null;
                // Here, we are checking to see what the output of the random was
                switch (number) {
                    case 1:
                        activity = Act1.class;
                        // We are adding the number of the activity to the list
                        activityList.remove(Act1.class);
                        break;
                    case 2:
                        activity = Act2.class;
                        activityList.remove(Act2.class);
                        break;
                    case 3:
                        activity = Act3.class;
                        activityList.remove(Act3.class);
                        break;
                    case 4:
                        activity = Act4.class;
                        activityList.remove(Act4.class);
                        break;
                    case 5 :
                        activity = Act5.class;
                        activityList.remove(Act5.class);
                        break;
                    case 6 :
                        activity = Act6.class;
                        activityList.remove(Act6.class);
                        break;
                    case 7 :
                        activity = Act7.class;
                        activityList.remove(Act7.class);
                        break;
                    case 8 :
                        activity = Act8.class;
                        activityList.remove(Act8.class);
                        break;
                    case 9 :
                        activity = Act9.class;
                        activityList.remove(Act9.class);
                        break;


                    default:
                        activity = Act10.class;
                        activityList.remove(Act10.class);
                        break;
                }


                final Class finalActivity = activity;
                final ArrayList<Class> finalActivityList = activityList;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // We use intents to start activities
                        Intent intent = new Intent(getBaseContext(), finalActivity);
                        // `intent.putExtra(...)` is used to pass on extra information to the next activity
                        intent.putExtra("ACTIVITY_LIST", finalActivityList);
                        startActivity(intent);
                        stop();
                    }
                },8000);
            }
        });
    }

    private void play ()
    {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(Exercises.this, R.raw.start321);
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



        //});





  /*  void testIntent()
    {
        Intent intent = new Intent(Exercises.this, Act2.class);
        startActivity(intent);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                testToast(); // ye method call hota hai intent change hone ke baad
            }
        },66000);
    }

    void testToast()
    {

        Toast.makeText(this, "it is fine", LENGTH_LONG).show();
        Intent intent = new Intent(Exercises.this, Act1.class);
        startActivity(intent);
    }*/

