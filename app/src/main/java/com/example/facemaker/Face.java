/**
 * @description: class to hold some global variables and used to randomize
 * colors for the Face object
 * @author: Garrett Inouye
 * @date: 3/3/2021
 */
package com.example.facemaker;

import android.graphics.Color;



public class Face {

    //setting integers for the random colors
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;

    //creating a variable to hold the integers after picking the random color
    public int redHair;
    public int greenHair;
    public int blueHair;

    public int redEye;
    public int greenEye;
    public int blueEye;

    public int redSkin;
    public int greenSkin;
    public int blueSkin;

    public int redCurrent;
    public int greenCurrent;
    public int blueCurrent;

    //boolean variable to set whether face is random or not
    public boolean randomFace = false;

    //uses the randomize method to create a Face class
    public Face() {
        randomize();
    }

    //method to randomize the face colors
    public void randomize(){
        //setting the colors to the random rgb values using math.random
        skinColor = Color.rgb(redSkin = (int)(Math.random()*255), greenSkin = (int)(Math.random()*255),
                blueSkin = (int)(Math.random()*255));
        eyeColor = Color.rgb(redEye = (int)(Math.random()*255), greenEye = (int)(Math.random()*255),
                blueEye = (int)(Math.random()*255));
        hairColor = Color.rgb(redHair = (int)(Math.random()*255), greenHair =(int)(Math.random()*255),
                blueHair = (int)(Math.random()*255));
        hairStyle = (int) (Math.random()*3);


    }

    /** Specification says to implement onDraw() in this class but I'm treating this as "CakeModel" from
     *  CS371's lab4, so I created a second class that extends Surface View and the onDraw method
     *  can be found there.
     */

    //getter methods to return the random variables
    public int getSkinColor(){ return skinColor; }
    public int getHairColor(){ return hairColor; }
    public int getEyeColor(){ return eyeColor; }
    public int getHairStyle(){ return hairStyle;}
}
