package com.stars.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    public static ImageView cursor;
    public static RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        cursor = findViewById(R.id.cursor);
        layoutParams = new RelativeLayout.LayoutParams(100, 100);
        cursor.setLayoutParams(layoutParams);

        SensorData sensData = new SensorData(this);
        MicrophoneAndColor.startRecorder();
    }
}