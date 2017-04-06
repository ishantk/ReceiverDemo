package com.auribises.receiverdemo;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sensorManager;
    Sensor sensor;

    void initViews(){
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        //sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void clickHandler(View view){

        //Intent i = new Intent("a.b.c.d.e");// Implicit Intent
        //sendBroadcast(i);

        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float[] values = sensorEvent.values;

        /*float x = values[0];
        float y = values[1];
        float z = values[2];

        // set the data on textView
        float calculation = ((x*x)+(y*y)+(z*z)) / (SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
        if(calculation>3){
            Toast.makeText(this,"Phone Shake Detected",Toast.LENGTH_LONG).show();
            sensorManager.unregisterListener(this);
        }*/

        float distance = values[0];
        if(distance == 0){
            Toast.makeText(this,"You are near to Phone",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
