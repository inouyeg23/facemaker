/**
 * @description: Main Activity that sets all the listeners for FaceController
 * @author: Garrett Inouye
 * @date: 3/3/2021
 */
package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FaceSurfaceView newfaceview = findViewById(R.id.faceSurfaceView);


        //SeekBar
        SeekBar redseekbar = (SeekBar)findViewById(R.id.redSeekBar);

        redseekbar.setMax(255);
        redseekbar.setProgress(newfaceview.face.redCurrent);
        redseekbar.refreshDrawableState();

        SeekBar greenseekbar = (SeekBar)findViewById(R.id.greenSeekBar);

        greenseekbar.setMax(255);
        greenseekbar.setProgress(newfaceview.face.greenCurrent);
        greenseekbar.refreshDrawableState();

        SeekBar blueseekbar = (SeekBar)findViewById(R.id.blueSeekBar);

        blueseekbar.setMax(255);
        blueseekbar.setProgress(newfaceview.face.blueCurrent);
        blueseekbar.refreshDrawableState();

        //Button
        Button randomFace = (Button)findViewById(R.id.faceButton);

        //setting the seekbars to the face controller to be accessed at a later time
        FaceController newfacecontroller = new FaceController(newfaceview, redseekbar, greenseekbar, blueseekbar);
        redseekbar.setOnSeekBarChangeListener(newfacecontroller);
        greenseekbar.setOnSeekBarChangeListener(newfacecontroller);
        blueseekbar.setOnSeekBarChangeListener(newfacecontroller);
        randomFace.setOnClickListener(newfacecontroller);


        /**
         * External Citation
         * Date: 3/3/2021
         * Problem: Did not know how to use spinner
         * Resource: https://stackoverflow.com/questions/5241660/how-to-add-items-to-a-spinner-in-android
         */
        //Spinner
        Spinner hairstylespinner = (Spinner) findViewById(R.id.hairstyleSpinner);
        String [] hairStyle = new String[] {"Curly", "Mohawk", "Normal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hairStyle);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairstylespinner.setAdapter(adapter);
        hairstylespinner.setOnItemSelectedListener(newfacecontroller);

        //Radio Group
        RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        radiogroup.setOnCheckedChangeListener(newfacecontroller);




    }
}