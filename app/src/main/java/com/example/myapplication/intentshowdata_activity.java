package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class intentshowdata_activity extends AppCompatActivity {

    TextView t1,t2;
    String e,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_showdata);

        t1=(TextView) findViewById(R.id.inlogs_email);
        t2=(TextView) findViewById(R.id.inlogs_pass);

        Intent i=getIntent();
        e=i.getStringExtra("emailk");
        p=i.getStringExtra("passk");
        t1.setText(e);
        t2.setText(p);
    }
}
