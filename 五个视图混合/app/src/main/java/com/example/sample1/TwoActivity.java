package com.example.sample1;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by 孙少杰 on 2017/10/11.
 */

public class TwoActivity extends AppCompatActivity{
    ImageButton imageView;
    VideoView videoView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_two);
        imageView= (ImageButton) findViewById(R.id.idImageButton);
        videoView= (VideoView) findViewById(R.id.idVideoview);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(TwoActivity.this,"image is clicked",Toast.LENGTH_LONG).show();
            }
        });
        videoView.setVideoURI(Uri.parse("http://v.youku.com/v_show/id_XMzA1NjY3NjUzNg==.html"));
        //与mediacontroller建立关联
        videoView.setMediaController(new MediaController(this));
        //获取焦点
        videoView.requestFocus();
        videoView.start();
    }
}
