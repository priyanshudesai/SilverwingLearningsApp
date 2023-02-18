package com.example.myapplication.alertdailogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myapplication.R;

public class alertdbox_activity extends AppCompatActivity {
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdbox);
    }

    public void opendbox(View view) {
        builder=new AlertDialog.Builder(this);
        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.alertdailogboxscreen,null);
        builder.setView(v);

        builder.setCancelable(true);
        AlertDialog alert=builder.create();
        alert.show();
    }
}
