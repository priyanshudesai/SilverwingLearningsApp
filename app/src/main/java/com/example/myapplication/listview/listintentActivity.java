package com.example.myapplication.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class listintentActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listintent);
        textView=(TextView) findViewById(R.id.intent_text);

        Intent intent=getIntent();
        String val=intent.getStringExtra("name");
        textView.setText(val);
    }
}
