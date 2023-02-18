package com.example.myapplication.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class fragment_Activity extends AppCompatActivity {
    first_Fragment ff;
    second_Fragment sf;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        fm=getSupportFragmentManager();
    }

    public void add(View view) {
        ff=new first_Fragment();
        ft=fm.beginTransaction();
        ft.add(R.id.fragment_activity_frame,ff,"A");
        ft.addToBackStack("addA");
        ft.commit();
    }

    public void replace(View view) {
        sf=new second_Fragment();
        ft=fm.beginTransaction();
        ft.add(R.id.fragment_activity_frame,sf,"B");
        ft.addToBackStack("addA");
        ft.commit();
    }

    public void remove(View view) {
        ft=fm.beginTransaction();
        ft.remove(ff);
        ft.remove(sf);
        ft.commit();
    }
}
