package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;

public class Face extends SurfaceView {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    public Paint color;


    public Face(Context context) {
        super(context);

        setWillNotDraw(false);

        Paint color = new Paint();
        color.setColor(skinColor);
    }

    public void randomize(){
        skinColor = Color.rgb((int)Math.random()*255, (int)Math.random()*255, (int)Math.random()*255);
        eyeColor = Color.rgb((int)Math.random()*255, (int)Math.random()*255, (int)Math.random()*255);
        hairColor = Color.rgb((int)Math.random()*255, (int)Math.random()*255, (int)Math.random()*255);
        hairStyle = (int) Math.random()*255;
    }

    protected void onDraw(Canvas canvas){

        canvas.drawCircle(200, 200, 100, color);
        canvas.drawCircle(300, 200, 50, color);
    };

}
