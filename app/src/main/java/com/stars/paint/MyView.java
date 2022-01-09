package com.stars.paint;

import android.content.Context;
import android.graphics.Canvas;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.View;

import java.util.LinkedList;


public class MyView extends View {
    Paint paint = new Paint();
    int vX = 160, vY = 100;
    int sX = 0, sY = 0;
    LinkedList<int[]> list = new LinkedList<int[]>();

    public MyView(Context context) {
        super(context);
        Timer t = new Timer();
        t.start();
    }

    protected void update() {
        invalidate();
    }

    class Timer extends CountDownTimer {
        public Timer() {
            super(Integer.MAX_VALUE, 10);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            update();
        }

        @Override
        public void onFinish() {
        }
    }

    protected void onDraw(Canvas canvas) {
        int color = MicrophoneAndColor.chooseColor(MicrophoneAndColor.soundDb());
        list.add(new int[]{vX, vY, vX + sX, vY + sY, (int) Data.proximity, color});
        for (int[] i : list) {
            paint.setStrokeWidth(i[4]);
            paint.setColor(i[5]);
            canvas.drawLine(i[0], i[1], i[2], i[3], paint);
        }
        vX = vX + sX;
        vY = vY + sY;
        sX = (int) (-Data.x);
        sY = (int) (Data.y);
    }
}
