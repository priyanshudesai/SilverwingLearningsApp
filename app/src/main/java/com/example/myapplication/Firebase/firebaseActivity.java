package com.example.myapplication.Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class firebaseActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b;
    ListView l;
    ArrayList<data> o;
    ArrayAdapter<data> ad;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        databaseReference= FirebaseDatabase.getInstance().getReference("DATA");
        e1=(EditText) findViewById(R.id.firebase_fname);
        l=(ListView) findViewById(R.id.firebase_listview);
        e2=(EditText) findViewById(R.id.firebase_lname);
        b=(Button) findViewById(R.id.firebase_ok_btn);
        o=new ArrayList<>();
        ad=new list_layout_firebaseActivity(this,o);
        l.setAdapter(ad);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adddata();
            }
        });
    }

    public void adddata(){
        String  name=e1.getText().toString().trim();
        String surname=e2.getText().toString().trim();
        if(!TextUtils.isEmpty(name))
        {
            String id=databaseReference.push().getKey();
            data d=new data(name,surname,id);
            databaseReference.child(id).setValue(d);
            Toast.makeText(this, "data store", Toast.LENGTH_SHORT).show();


        }
        else {
            Toast.makeText(this, "enter name", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                o.clear();
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    data oo=ds.getValue(data.class);
                    o.add(oo);
                }
                ad.notifyDataSetChanged();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(firebaseActivity.this, "The read failed: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
