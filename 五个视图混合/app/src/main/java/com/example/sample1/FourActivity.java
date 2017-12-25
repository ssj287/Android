package com.example.sample1;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by 孙少杰 on 2017/10/15.
 */

public class FourActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    ImageView imageView;
    EditText edi;
    String sNum;
    private static final int CARMERA_REQUEST=123;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_four);
        btn1= (Button) findViewById(R.id.idbtn1);
        btn2= (Button) findViewById(R.id.idbtn2);
        btn3=(Button) findViewById(R.id.btn3);
        edi= (EditText) findViewById(R.id.idtxt);
        btn4= (Button) findViewById(R.id.btn4);
        imageView= (ImageView) findViewById(R.id.imageView);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("email"));
                String []s={"1158537287@qq.com","1158537287@qq.com"};
                i.putExtra(Intent.EXTRA_EMAIL,s);
                i.putExtra(Intent.EXTRA_SUBJECT,"This is a subject");
                i.putExtra(Intent.EXTRA_TEXT,"Here are text.");
                i.setType("message/rfc822");//电子邮件标准格式rfc822
                Intent closer=Intent.createChooser(i,"Launch Email");//创建标题
                //createchooser 系统会寻找所有activity，然后把有定义的activity形成列表提供给使用者
                startActivity(closer);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:13.131,312.4656"));
                Intent chooser=Intent.createChooser(i,"Lanch App");
                startActivity(chooser);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_CALL);
                sNum=edi.getText().toString();
                if(sNum.trim().isEmpty()){
                    i.setData(Uri.parse("tel:2871220"));
                }else {
                    i.setData(Uri.parse("tel:"+sNum));
                }
                if(ActivityCompat.checkSelfPermission(FourActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(FourActivity.this,"sad",Toast.LENGTH_SHORT).show();
                    requestPermission();
                }else {
                    startActivity(i);
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,CARMERA_REQUEST);
            }
        });
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(FourActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CARMERA_REQUEST&&resultCode== Activity.RESULT_OK){
            Bitmap photo= (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);

        }
    }
}
