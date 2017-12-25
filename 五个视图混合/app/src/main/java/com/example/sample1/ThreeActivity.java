package com.example.sample1;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


/**
 * Created by 孙少杰 on 2017/10/14.
 */

public class ThreeActivity extends AppCompatActivity{
    DatePicker datePicker;
    Chronometer chronometer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        datePicker= (DatePicker) findViewById(R.id.datapicker);
        chronometer= (Chronometer) findViewById(R.id.chronometer);
        Calendar calendar=Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),new DatePicker.OnDateChangedListener(){

                    @Override
                    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                        Toast.makeText(getApplicationContext(),datePicker.getDayOfMonth()+"-"+datePicker.getMonth()+"-"+datePicker.getYear(),Toast.LENGTH_SHORT).show();
                    }
                }
        );
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();

    }
}
