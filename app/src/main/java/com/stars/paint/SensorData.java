package com.stars.paint;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorData implements SensorEventListener {

    private SensorManager sensorManagerAcce;
    private SensorManager sensorManagerProx;

    /*
    +y    наклон на себя
    -y    наклон от себя
    +x    наклон влево
    -x    наклон вправо

    чем больше модуль координаты тем больше наклон
     */

    public float x;
    public float y;

    SensorData(Context context) {
        sensorManagerAcce = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);
        sensorManagerAcce.registerListener(this,
                sensorManagerAcce.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);//скорость обновления

        sensorManagerProx = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);
        sensorManagerProx.registerListener(this,
                sensorManagerProx.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManager.SENSOR_DELAY_NORMAL);//скорость обновления
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                Data.x = event.values[0];
                Data.y = event.values[1];
//                MainActivity.one.setText(Float.toString(Data.x));
                break;
                //можно сделать ачивку при z=-10 типа переверни телефон
            case Sensor.TYPE_PROXIMITY:
                Data.proximity = event.values[0]>0?event.values[0]:1;
//                MainActivity.two.setText(Float.toString(Data.proximity));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
