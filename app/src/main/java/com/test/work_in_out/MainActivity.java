package com.test.work_in_out;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Animation top, below;
    ImageView img;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        top = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        below = AnimationUtils.loadAnimation(this, R.anim.below_anim);

        img = findViewById(R.id.styke);
        text = findViewById(R.id.spte);

        img.setAnimation(below);
        text.setAnimation(top);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Exercises.class);
                startActivity(intent);
                finish();
            }
        }, 5000);

    }
}
