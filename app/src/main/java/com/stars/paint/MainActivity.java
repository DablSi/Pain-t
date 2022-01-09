package com.stars.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    public TextView one, two;

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.textView);
        two = findViewById(R.id.textView2);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_FASTEST);//скорость обновления
    }


    //---------------------------------------------------------------------------
    /*
    +y    наклон на себя
    -y    наклон от себя
    +x    наклон влево
    -x    наклон вправо

    чем больше модуль цифры тем больше наклон
     */

    private float x;
    private float y;

    //эта функция обновляется
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            // assign directions
            x = event.values[0];
            y = event.values[1];

            one.setText(Float.toString(x));
            two.setText(Float.toString(y));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    //---------------------------------------------------------------------------

}