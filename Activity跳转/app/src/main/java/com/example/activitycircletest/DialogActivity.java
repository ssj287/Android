package com.example.activitycircletest;

/**
 * Created by 孙少杰 on 2017/12/25.
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class DialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_layout);
    }

}
