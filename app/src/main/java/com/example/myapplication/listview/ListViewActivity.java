package com.example.myapplication.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.tablayout.tab_Activity;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    String[] planets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView=(ListView) findViewById(R.id.listview_list);
        textView=(TextView) findViewById(R.id.list_text);

        planets=getResources().getStringArray(R.array.planets_array);
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.listview_text,R.id.list_text,planets);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value= arrayAdapter.getItem(i);
                Toast.makeText(ListViewActivity.this, value, Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(ListViewActivity.this,listintentActivity.class);
                intent.putExtra("name",value);
                startActivity(intent);
            }
        });
    }
}
