package com.example.activitycircletest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
/**
 * Created by 孙少杰 on 2017/12/25.
 */

public class NormalActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.normal_layout);
    }

}
