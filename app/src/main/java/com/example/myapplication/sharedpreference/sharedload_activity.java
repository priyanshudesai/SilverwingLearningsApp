package com.example.myapplication.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class sharedload_activity extends AppCompatActivity {

    Button s,ne;
    TextView n,m,e;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadshared);

       n=(TextView) findViewById(R.id.load_n);
       m=(TextView) findViewById(R.id.load_m);
       e=(TextView) findViewById(R.id.load_e);

    }

    public void load(View view) {
       sp=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
       String s1=sp.getString(Name,"");
       String s2=sp.getString(Phone,"");
       String s3=sp.getString(Email,"");

       n.setText(s1);
       m.setText(s2);
       e.setText(s3);
    }

    public void pre(View view) {
        Toast.makeText(sharedload_activity.this, "Prevoious", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(sharedload_activity.this,sharedpref_activity.class);
        startActivity(i);
    }
}
