package com.example.sample1;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.*;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
public class MainActivity extends AppCompatActivity {
    TextView textview;
    EditText editText;
    RadioGroup radioGroup;
    Button btn;
    CheckBox checkBox1,checkBox2,checkBox3;
    RatingBar ratingBar;
    ProgressBar progressBar;
    SeekBar seekBar;
    Switch aSwitch;
    ToggleButton toggleButton;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    CheckedTextView checkedTextView;
    ImageSwitcher switcher;
    Button btnPreVious,btnNext;
    private int  mPosition;
    private static final int []IMAGES={android.R.drawable.alert_dark_frame,android.R.drawable.alert_light_frame,android.R.drawable.arrow_down_float};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview= (TextView) findViewById(R.id.idtxt);
        editText= (EditText) findViewById(R.id.ideTxt);
        radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        btn= (Button) findViewById(R.id.button);
        checkBox1= (CheckBox) findViewById(R.id.checkBox1);
        checkBox2= (CheckBox) findViewById(R.id.checkBox2);
        checkBox3= (CheckBox) findViewById(R.id.checkBox3);
        ratingBar= (RatingBar) findViewById(R.id.idratinggBar);
        btn= (Button) findViewById(R.id.button);
        progressBar= (ProgressBar) findViewById(R.id.idProgressBar);
        seekBar= (SeekBar) findViewById(R.id.idseekBar);
        aSwitch= (Switch) findViewById(R.id.Switch);
        toggleButton= (ToggleButton) findViewById(R.id.idToggleButton);
        spinner= (Spinner) findViewById(R.id.idSpinner);
        autoCompleteTextView= (AutoCompleteTextView) findViewById(R.id.idCompleteTextView);
        multiAutoCompleteTextView= (MultiAutoCompleteTextView) findViewById(R.id.idMultiCompleteTextView);
        checkedTextView= (CheckedTextView) findViewById(R.id.idCheckedTextView);
        btnPreVious= (Button) findViewById(R.id.idBtnPrevious);
        btnNext= (Button) findViewById(R.id.idBtnNext);
        switcher= (ImageSwitcher) findViewById(R.id.idImageSwitch);
        textview.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view) {
                                            String myvar=textview.getText().toString();
                                            Toast.makeText(MainActivity.this, myvar,Toast.LENGTH_LONG).show();
                                        }
                                    }
        );
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s=editText.getText().toString();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.radioButton1Id:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));break;
                    case R.id.radioButton2Id:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFFF00"));break;
                    case R.id.radioButton3Id:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF00FF"));break;
                    case R.id.radioButton4Id:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));break;
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(getApplicationContext(),"SeekBar Progress:"+i,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        String []countries={"US","China"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,countries);
        spinner.setAdapter(adapter);
        ArrayAdapter<String>adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
        autoCompleteTextView.setAdapter(adapter1);
        ArrayAdapter<String>adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
        multiAutoCompleteTextView.setAdapter(adapter2);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());//设置建议间分割符，默认逗号
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPosition<IMAGES.length-1){
                    mPosition=mPosition+1;
                    switcher.setBackgroundResource(IMAGES[mPosition]);
                }
            }
        });
        btnPreVious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPosition>0){
                    mPosition=mPosition-1;
                    switcher.setBackgroundResource(IMAGES[mPosition]);
                }
            }
        });
    }
    public void ClickMe(View v){
        if(checkBox1.isChecked()==true&&checkBox2.isChecked()==true&&checkBox3.isChecked()==true){
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#F0F0F0"));
        }
    }
    public void onBtnClick(View v){
        float ratingvalue=ratingBar.getRating();
        Toast.makeText(MainActivity.this,"Rating is:"+ratingvalue,Toast.LENGTH_LONG).show();
    }
    public  void onBtnClick1(View v){
        Thread thread=new Thread(){

            @Override
            public void run() {
                super.run();
                for(int i=0;i<100;){
                    try {
                        sleep(1000);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.setProgress(i);
                    i=i+10;
                }
            }
        };
        thread.start();

    }
    public void onSwitchClick(View v){
        if (aSwitch.isChecked()){
            Toast.makeText(this,"Is changed",Toast.LENGTH_SHORT).show();
        }
    }
    public void onToggleClick(View v){
        if (toggleButton.isChecked())
            Toast.makeText(this,"Toggle on",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Toggle off",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,TwoActivity.class);
                startActivity(intent);
                break;
            case R.id.menu2:
                Intent intent1=new Intent();
                intent1.setClass(MainActivity.this,ThreeActivity.class);
                startActivity(intent1);
            case R.id.menu3:
                Intent intent2=new Intent();
                intent2.setClass(MainActivity.this,FourActivity.class);
                startActivity(intent2);
            case R.id.menu4:
                Intent intent4=new Intent(MainActivity.this,FiveActivity.class);
                startActivity(intent4);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
