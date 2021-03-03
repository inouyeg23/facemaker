package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SeekBar
        SeekBar redseekbar = (SeekBar)findViewById(R.id.redSeekBar);
        TextView redText = (TextView)findViewById(R.id.progressRed);

        SeekBar greenseekbar = (SeekBar)findViewById(R.id.greenSeekBar);
        TextView greenText = (TextView)findViewById(R.id.progressGreen);

        SeekBar blueseekbar = (SeekBar)findViewById(R.id.blueSeekBar);
        TextView blueText = (TextView)findViewById(R.id.progressBlue);

        ProgressSeekListener redSeekListener = new ProgressSeekListener(redText);
        redseekbar.setOnSeekBarChangeListener(redSeekListener);

        ProgressSeekListener greenSeekListener = new ProgressSeekListener(greenText);
        greenseekbar.setOnSeekBarChangeListener(greenSeekListener);

        ProgressSeekListener blueSeekListener = new ProgressSeekListener(blueText);
        blueseekbar.setOnSeekBarChangeListener(blueSeekListener);

        //Button
        Button randomFace = (Button)findViewById(R.id.faceButton);

        randomFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}