package com.example.secondapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Exercise1 extends AppCompatActivity {
    private static final String Tag="yuhang";
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";
    private static final String ON_RESTORE_INSTANCE_STATE = "onRestoreInstanceState";

    private static String content;//静态变量，在onDestroy()函数中调用

    private static TextView tv1;

    public void logAndAppend(String str){
        Log.d(Tag,str);
        tv1.append(str+"\n");
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        tv1=(TextView)findViewById(R.id.tv1);
        if(savedInstanceState!=null){
            tv1.setText(content);
        }
        logAndAppend(ON_CREATE);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        logAndAppend(ON_RESTART);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndAppend(ON_START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndAppend(ON_RESUME);
    }


    @Override
    protected void onPause() {
        super.onPause();
        logAndAppend(ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        logAndAppend(ON_STOP);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        logAndAppend(ON_DESTROY);
        content = tv1.getText().toString();//Destroy时保存当前记录
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        logAndAppend(ON_SAVE_INSTANCE_STATE);
    }
    @Override
    protected void onRestoreInstanceState(Bundle SavedInstanceState){
        super.onRestoreInstanceState(SavedInstanceState);
        logAndAppend(ON_RESTORE_INSTANCE_STATE);
    }

}
