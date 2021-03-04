/**
 * @description: creates the Face object that will be drawn using paint
 * and draw methods
 * @author: Garrett Inouye
 * @date: 3/3/2021
 */
package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class FaceSurfaceView extends SurfaceView {

    //creating a new face object
    Face face = new Face();

    //creating new paint objects to set the colors
    Paint facePaint = new Paint();
    Paint irisPaint = new Paint();
    Paint hairPaint = new Paint();
    Paint eyePaint = new Paint();

    //variable to hold the hair style given by the spinner button
    public int hairStyle;

    //variables to hold the dimensions of the tablet
    private float width;
    private float height;

    public FaceSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //necessary to draw
        setWillNotDraw(false);

        setBackgroundColor(Color.WHITE);
        eyePaint.setColor(Color.WHITE);

        //starts the program off with a random face
        face.randomFace = true;

    }

    public void onDraw(Canvas canvas) {
        //gets the dimensions of the surface view
        width = this.getWidth();
        height = this.getHeight();

        //drawing a random face at the start and if the button isnt clicked
        //then face is "normal"
        if (face.randomFace) {
            drawRandomFace(canvas);
            face.randomFace = false;
        } else {
            drawNormalFace(canvas);
        }
    }

    //draw method to draw the normal face based on slider values
    private void drawNormalFace(Canvas canvas) {
        //face
        facePaint.setColor(Color.rgb(face.redSkin, face.greenSkin, face.blueSkin));
        facePaint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(width/2, height/2, 250, facePaint);

        //eyes
        irisPaint.setColor(Color.rgb(face.redEye, face.greenEye, face.blueEye));
        irisPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle((width/2)-75,(height/2)-75,50, eyePaint);
        canvas.drawCircle((width/2)+75,(height/2)-75,50, eyePaint);

        canvas.drawCircle((width/2)-75,(height/2)-50,25, irisPaint);
        canvas.drawCircle((width/2)+75,(height/2)-50,25, irisPaint);

        //hair
        hairPaint.setColor(Color.rgb(face.redHair, face.greenHair, face.blueHair));
        hairPaint.setStyle(Paint.Style.FILL);
        switch (face.hairStyle){
            case 0: //curly
                for(int i = 0; i < 9; i++) {
                    canvas.drawCircle((width / 2) - (125 - 30*i), (height / 2) - 180, 35, hairPaint);
                }
                break;
            case 1: //mohawk
                canvas.drawRect((width/2)-25,(height/2)-300,(width/2)+25,(height/2)-145, hairPaint);
                break;
            case 2: //normal
                canvas.drawOval((width/2)-75,(height/2)-300,(width/2)+75,(height/2)-175, hairPaint);
                break;
        }
    }

    //draw method to create a random face based on random integers we found earlier
    private void drawRandomFace(Canvas canvas) {
        //face
        facePaint.setColor(face.getSkinColor());
        facePaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width/2, height/2, 250, facePaint);

        //eyes
        irisPaint.setColor(face.getEyeColor());
        irisPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle((width/2)-75,(height/2)-75,50, eyePaint);
        canvas.drawCircle((width/2)+75,(height/2)-75,50, eyePaint);

        canvas.drawCircle((width/2)-75,(height/2)-50,25, irisPaint);
        canvas.drawCircle((width/2)+75,(height/2)-50,25, irisPaint);

        //hair
        hairPaint.setColor(face.getHairColor());
        hairPaint.setStyle(Paint.Style.FILL);
        switch (face.getHairStyle()){
            case 0: //curly
                for(int i = 0; i < 9; i++) {
                    canvas.drawCircle((width / 2) - (125 - 30*i), (height / 2) - 180, 35, hairPaint);
                }
                break;
            case 1: //mohawk
                canvas.drawRect((width/2)-25,(height/2)-300,(width/2)+25,(height/2)-145, hairPaint);
                break;
            case 2: //normal
                canvas.drawOval((width/2)-75,(height/2)-300,(width/2)+75,(height/2)-175, hairPaint);
                break;
        }
    }

    //getter method to return face object
    public Face getFace(){ return this.face; }
}
