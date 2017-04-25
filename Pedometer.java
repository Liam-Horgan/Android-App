package com.example.david.myapplication;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Field;

public class Pedometer extends AppCompatActivity implements SensorEventListener {

    GestureDetectorCompat gestureObject;
    SensorManager sensorManager;
    Sensor sensor;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedometer);
        getOverflowMenu();
        display = (TextView)findViewById(R.id.stepsCount);
        TextView display2 = (TextView)findViewById(R.id.stepsView);
        display2.setText("Steps Today");
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        gestureObject = new GestureDetectorCompat(this, new Pedometer.LearnGesture());
    }

    private void getOverflowMenu() {

        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if (sensor != null){
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        }
        else {
            Toast.makeText(this, "No sensor detected", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        display.setText("" + sensorEvent.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public boolean onTouchEvent(MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float VelocityX, float VelocityY){
            if (event2.getX() > event1.getX()){

                Intent intent = new Intent(Pedometer.this, MainActivity.class);

                startActivity(intent);
            }
            else
            if (event2.getX() < event1.getX()){

            }
            return true;
        }
    }
}







