package com.stars.paint;

import android.content.Context;
import android.graphics.Canvas;

import android.graphics.Paint;
import android.view.View;



public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }


    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        Data data = new Data();
        float vX=160, vY=100;
        float sX=0,sY=0;
        paint.setColor(data.color);

        while(true){
            canvas.drawLine(vX,vY,sX,sY,paint);
            vX=sX;
            vY=sY;
            sX=data.x;
            sY=data.y;

        }
    }
}
