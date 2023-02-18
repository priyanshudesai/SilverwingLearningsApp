package com.example.myapplication.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.myapplication.R;

import java.util.Calendar;

public class datetimepicker_activity extends AppCompatActivity {
    EditText d,t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datetimepicker);

        d=(EditText) findViewById(R.id.datetime_date);
        t=(EditText) findViewById(R.id.datetime_time);

        d.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    Calendar c=Calendar.getInstance();
                    int hour=c.get(Calendar.HOUR_OF_DAY);
                    int min=c.get(Calendar.MINUTE);
                    TimePickerDialog p;
                    p=new TimePickerDialog(datetimepicker_activity.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                            d.setText(i+":"+i1);
                        }
                    },hour,min,false);
                    p.setTitle("Time");
                    p.show();
                }
            }
        });
    }
}
