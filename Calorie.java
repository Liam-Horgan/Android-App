package com.example.david.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calorie extends AppCompatActivity {
    GestureDetectorCompat gestureObject;
    public int dailyCalories;
    public int calories;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);
        Button button;
        final EditText edit;
        final TextView text;
        button = (Button)findViewById(R.id.buttonCalories);
        edit = (EditText)findViewById(R.id.etCalories);
        text = (TextView)findViewById(R.id.dailyCalories);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isEmpty(edit)) {
                        calories = Integer.valueOf(edit.getText().toString());
                        dailyCalories += calories;
                        text.setText(Integer.toString(dailyCalories));
                    }
                }
            });


        gestureObject = new GestureDetectorCompat(this, new Calorie.LearnGesture());

    }

    public void getCalories(View v){

    }

    public boolean onTouchEvent(MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float VelocityX, float VelocityY){
            if (event2.getX() > event1.getX()){
            }
            else
            if (event2.getX() < event1.getX()){

                Intent intent = new Intent(Calorie.this, MainActivity.class);

                startActivity(intent);
            }
            return true;
        }
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

}
