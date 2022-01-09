package com.stars.paint;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AccelerometerData implements SensorEventListener {

    private SensorManager sensorManager;

    /*
    +y    наклон на себя
    -y    наклон от себя
    +x    наклон влево
    -x    наклон вправо

    чем больше модуль цифры тем больше наклон
     */

    public float x;
    public float y;

    AccelerometerData(Context context) {
        sensorManager = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            // assign directions
            x = event.values[0];
            y = event.values[1];
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
