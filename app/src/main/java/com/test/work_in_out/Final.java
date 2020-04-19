package com.test.work_in_out;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Final extends AppCompatActivity {
    Animation top;
    TextView txt;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        top = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        txt = findViewById(R.id.txtfi);
        txt.setAnimation(top);
        exit = findViewById(R.id.exit);

        SharedPreferences sharedPreferences = getSharedPreferences("YOUR PREF KEY", Context.MODE_PRIVATE);
        Calendar c = Calendar.getInstance();

        int thisDay = c.get(Calendar.DAY_OF_YEAR); // GET THE CURRENT DAY OF THE YEAR

        int lastDay = sharedPreferences.getInt("YOUR DATE PREF KEY", 0); //If we don't have a saved value, use 0.

        int counterOfConsecutiveDays = sharedPreferences.getInt("YOUR COUNTER PREF KEY", 0); //If we don't have a saved value, use 0.

        if(lastDay == thisDay -1){
            // CONSECUTIVE DAYS
            counterOfConsecutiveDays = counterOfConsecutiveDays + 1;

            sharedPreferences.edit().putInt("YOUR DATE PREF KEY", thisDay);

            sharedPreferences.edit().putInt("YOUR COUNTER PREF KEY", counterOfConsecutiveDays).commit();
        } else {

            sharedPreferences.edit().putInt("YOUR DATE PREF KEY", thisDay);

            sharedPreferences.edit().putInt("YOUR COUNTER PREF KEY", 1).commit();
        }


        Toast.makeText(this, "Your daily streak is: " + counterOfConsecutiveDays, Toast.LENGTH_LONG)
                .show();



       exit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              finish();
               System.exit(1);
           }
       });
    }
}
