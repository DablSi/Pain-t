package com.stars.paint;

import android.content.Context;
import android.graphics.Canvas;

import android.graphics.Paint;
import android.view.View;



public class MyView extends View {
    private String color; // хранится цвет
    private static float x; // координаты для начала
    private static float y;
    private static float sX; // координаты для остановки
    private static float sY;

    public MyView(Context context) {
        super(context);
    }


    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        this.x = 160;
        this.y = 100;
        this.sX=0;
        this.sY=0;
        color = onSensorChanged(); // функция возвращающая цвет
        paint.setColor(Integer.parseInt(color));
        while(true){
        canvas.drawLine(x,y,sX,sY,paint);
        this.x=sX;
        this.y=sY;
        this.sX=x;
        this.sY=y;

    }
    }




}
