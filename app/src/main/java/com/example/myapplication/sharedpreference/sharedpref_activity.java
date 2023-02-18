package com.example.myapplication.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class sharedpref_activity extends AppCompatActivity {

    EditText n,p,e;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpref);

        e=(EditText) findViewById(R.id.shared_email);
        n=(EditText) findViewById(R.id.shared_name);
        p=(EditText) findViewById(R.id.shared_phone);


    }

    public void save(View view) {

        sp=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String na= n.getText().toString();
        String ph= p.getText().toString();
        String em= e.getText().toString();
        SharedPreferences.Editor ed=sp.edit();
        if(na.length()==0)
        {
            n.setError("Please Enter Name");
        }
        else if(ph.length()==0)
        {
            p.setError("Please Enter Mobileno");
        }
        else if(em.length()==0)
        {
            e.setError("please enter email");
        }
        else {
            ed.putString(Name, na);
            ed.putString(Phone, ph);
            ed.putString(Email, em);
            ed.apply();
            Toast.makeText(sharedpref_activity.this, "Successfully Data Updated", Toast.LENGTH_LONG).show();
        }
    }

    public void next(View view) {

        Intent i=new Intent(sharedpref_activity.this,sharedload_activity.class);
        startActivity(i);
    }
}
