package com.example.sample1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by 孙少杰 on 2017/10/17.
 */

public class FiveActivity  extends Activity{
    Button btn,btn1;
    String uristring;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        btn= (Button) findViewById(R.id.idbtn3);
        btn1= (Button) findViewById(R.id.idbtn4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(FiveActivity.this,"Toast:Gravity.Top",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setView(new ButtonView(FiveActivity.this));
                toast.show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharing =new Intent(Intent.ACTION_SEND);
                sharing.setType("Text/plain");
                uristring="www.baidu.com";
                sharing.putExtra(Intent.EXTRA_TEXT,uristring);
                sharing.setPackage("com.tencent.tim");
                startActivity(sharing);
            }
        });
    }
}
