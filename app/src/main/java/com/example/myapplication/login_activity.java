package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {

    EditText email,password;
    Button log_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        email=(EditText) findViewById(R.id.login_email);
        password=(EditText) findViewById(R.id.login_password);
        log_in=(Button) findViewById(R.id.login_login_button);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em=email.getText().toString();
                String ps=password.getText().toString();

                Toast.makeText(login_activity.this, "Email is "+em+" Password is "+ps, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
