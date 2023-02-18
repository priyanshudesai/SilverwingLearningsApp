package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class animation_activity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;
    Animation a1,a2,a3,a4,a5,a6;
    ImageView i1,i2,i4,i5,i6;
    TextView t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_buttons);

        b1=(Button) findViewById(R.id.animation_button1);
        b2=(Button) findViewById(R.id.animation_button2);
        b3=(Button) findViewById(R.id.animation_button3);
        b4=(Button) findViewById(R.id.animation_button4);
        b5=(Button) findViewById(R.id.animation_button5);
        b6=(Button) findViewById(R.id.animation_button6);

        i1=(ImageView) findViewById(R.id.animation_rotateimg);
        i2=(ImageView) findViewById(R.id.animation_moveimg);
        t3=(TextView) findViewById(R.id.animation_zoomintxt);
        i4=(ImageView) findViewById(R.id.animation_slidedownimg);
        i5=(ImageView) findViewById(R.id.animation_blinkimg);
        i6=(ImageView) findViewById(R.id.animation_fadeoutimg);

        a1=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        a2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        a3=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin);
        a4=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slidedown);
        a5=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        a6=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i1.startAnimation(a1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i2.startAnimation(a2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t3.startAnimation(a3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i4.startAnimation(a4);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i5.startAnimation(a5);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i6.startAnimation(a6);
            }
        });

    }
}
