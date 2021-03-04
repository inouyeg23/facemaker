/**
 * @description: controller class to make sure each button/seekbar does as it's supposed to
 * @author: Garrett Inouye
 * @date: 3/3/2021
 */
package com.example.facemaker;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;

public class FaceController implements View.OnClickListener, OnSeekBarChangeListener,
        AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    //variables for the buttons and surface views used
    private FaceSurfaceView faceview;
    private Face face;

    //global variables necessary to change seekbar
    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;
    private Spinner hairSpinner;

    private boolean radioSkin;
    private boolean radioEyes;
    private boolean radioHair;

    //
    FaceController(FaceSurfaceView newfaceview, SeekBar redSeek, SeekBar greenSeek, SeekBar blueSeek) {
        faceview = newfaceview;
        face = faceview.getFace();
        this.redSeek = redSeek;
        this.greenSeek = greenSeek;
        this.blueSeek = blueSeek;
    }

    //method to set the progress of the skin color
    public void setSkinProgress(){
        redSeek.setProgress(face.redSkin);
        greenSeek.setProgress(face.greenSkin);
        blueSeek.setProgress(face.blueSkin);
    }
    //method to set the progress of the eye color
    public void setEyesProgress(){
        redSeek.setProgress(face.redEye);
        greenSeek.setProgress(face.greenEye);
        blueSeek.setProgress(face.blueEye);
    }
    //method to set the progress of the hair color
    public void setHairProgress(){
        redSeek.setProgress(face.redHair);
        greenSeek.setProgress(face.greenHair);
        blueSeek.setProgress(face.blueHair);
    }

    //listener to listen from seek bar and change colors appropriately
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //if (radioSkin) {
            switch (seekBar.getId()) {
                case R.id.redSeekBar:
                    face.redSkin = progress;

                    break;
                case R.id.greenSeekBar:
                    face.greenSkin = progress;

                    break;
                case R.id.blueSeekBar:
                    face.blueSkin = progress;

                    break;
            }
        //}
        if (radioEyes) {
            switch (seekBar.getId()) {
                case R.id.redSeekBar:
                    face.redEye = progress;
                    break;
                case R.id.greenSeekBar:
                    face.greenEye = progress;
                    break;
                case R.id.blueSeekBar:
                    face.blueEye = progress;
                    break;
            }
        }
        if (radioHair) {
            switch (seekBar.getId()) {
                case R.id.redSeekBar:
                    face.redHair = progress;

                    break;
                case R.id.greenSeekBar:
                    face.greenHair = progress;
                    break;
                case R.id.blueSeekBar:
                    face.blueHair = progress;
                    break;
            }
        }
        faceview.invalidate();

    }

    //onclick listener to re-randomize the face created by the random face button
    @Override
    public void onClick(View v) {
        face.randomFace = true;
        face.randomize();
        faceview.invalidate();
    }

    //radio group controlling the radio buttons and updating the seekbar to the correct progress
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.skinRadioButton:
                System.out.println("skin");
                setSkinProgress();
                radioSkin = true;
                radioEyes = false;
                radioHair = false;

                break;
            case R.id.eyesRadioButton:
                System.out.println("eyes");
                setEyesProgress();
                radioSkin = false;
                radioEyes = true;
                radioHair = false;

                break;
            case R.id.hairRadioButton:
                System.out.println("hair");
                setHairProgress();
                radioSkin = false;
                radioEyes = false;
                radioHair = true;

                break;

        }


    }
    //spinner listener to change the haristyle based on selected choice
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        face.hairStyle = position;
        faceview.invalidate();
    }

    //listeners that are empty but necessary
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}


