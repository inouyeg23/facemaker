package com.example.facemaker;

import android.widget.SeekBar;
import android.widget.TextView;

public class ProgressSeekListener implements SeekBar.OnSeekBarChangeListener {

    private TextView colorProgress;


    ProgressSeekListener(TextView text){
        colorProgress = text;

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        colorProgress.setText("" + progress);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
