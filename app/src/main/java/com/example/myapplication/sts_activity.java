package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toolbar;

public class sts_activity extends AppCompatActivity {

    TextView textswitch,texttoogle,textseek;
    Switch switchbutton;
    ToggleButton toggleButton;
    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switchtoogleseek);

        textswitch=(TextView) findViewById(R.id.sts_textview_s);
        switchbutton=(Switch) findViewById(R.id.sts_switch);

        switchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchbutton.isChecked())
                {
                    textswitch.setText("Switch Status:on");
                }
                else{
                    textswitch.setText("Switch Status:off");
                }
            }
        });

        texttoogle=(TextView) findViewById(R.id.sts_textview_t);
        toggleButton=(ToggleButton) findViewById(R.id.sts_toggle);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked())
                {
                    texttoogle.setText("Toggle Status:on");
                }
                else{
                    texttoogle.setText("Toggle Status:off");
                }
            }
        });

        textseek=(TextView) findViewById(R.id.sts_textview_se);
        seekbar=(SeekBar) findViewById(R.id.sts_seek);


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textseek.setText("Seek Status:"+i);
                textseek.setTextSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
