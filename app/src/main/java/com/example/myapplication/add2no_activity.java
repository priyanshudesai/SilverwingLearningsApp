package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add2no_activity extends AppCompatActivity {

    EditText fnum,snum;
    Button sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add2no);
        fnum=(EditText) findViewById(R.id.add2no_firstnum);
        snum=(EditText) findViewById(R.id.add2no_secondnum);
        sum=(Button) findViewById(R.id.add2no_sum_button);
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1=Integer.parseInt(fnum.getText().toString());
                int n2=Integer.parseInt(snum.getText().toString());
                int s=n1+n2;

                Toast.makeText(add2no_activity.this, "First Num = "+n1+" Second Num ="+n2+" Sum = "+s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
