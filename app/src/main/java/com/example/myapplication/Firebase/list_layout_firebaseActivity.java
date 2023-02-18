package com.example.myapplication.Firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class list_layout_firebaseActivity extends ArrayAdapter<data> {

    Activity f;
    List<data> dataList;
    public list_layout_firebaseActivity(@NonNull Activity context, List<data> datalist) {
        super(context, R.layout.listview_firebase,datalist);
        this.f=context;
        this.dataList=datalist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = f.getLayoutInflater();
        View v= inflater.inflate(R.layout.listview_firebase,null,true);
        TextView ffname =(TextView) v.findViewById(R.id.firstname_list_fb);
        TextView ssname=(TextView) v.findViewById(R.id.lastname_list_fb);
        data d=dataList.get(position);
        ffname.setText(d.getFname());
        ssname.setText(d.getLname());
        return v;

    }
}

