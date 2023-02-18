package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class intentlogin_activity extends AppCompatActivity {

    Button blogin;
    EditText email,pass;
    String e,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_login);

        blogin=(Button) findViewById(R.id.intent_login_login_button);
        email=(EditText) findViewById(R.id.intent_login_email);
        pass=(EditText) findViewById(R.id.intent_login_password);

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             e=email.getText().toString();
             p=pass.getText().toString();
                Intent i=new Intent(intentlogin_activity.this,intentshowdata_activity.class);
             if(e.length()==0){
                 email.setError("Please Enter email id");
             }
             else  if (p.length()==0){
                 pass.setError("Please Enter Password");
             }
             else {
                 i.putExtra("emailk",e);
                 i.putExtra("passk",p);
                 startActivity(i);
             }

            }
        });
    }
}
