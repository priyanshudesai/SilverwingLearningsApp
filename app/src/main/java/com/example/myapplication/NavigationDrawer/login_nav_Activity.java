package com.example.myapplication.NavigationDrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;


public class login_nav_Activity extends AppCompatActivity {

    EditText email,name;
    Button log_in;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_login);

        email=(EditText) findViewById(R.id.login_email);
        name=(EditText) findViewById(R.id.login_name);
        log_in=(Button) findViewById(R.id.login_login_button);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em=email.getText().toString();
                String na=name.getText().toString();


                sp=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=sp.edit();
                if(na.length()==0)
                {
                    name.setError("Please Enter Name");
                }
                else if(em.length()==0)
                {
                    email.setError("Please Enter Email");
                }
                else {
                    ed.putString(Name, na);
                    ed.putString(Email, em);
                    ed.apply();

                    Intent i=new Intent(login_nav_Activity.this, navigation_Activity.class);
                    Toast.makeText(login_nav_Activity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }
            }
        });
    }


}
