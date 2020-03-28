package com.example.secondapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Exercise2 extends AppCompatActivity {

    private TextView tv_count;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);
        View main=(View) findViewById(R.id.view1);
        int count=getAllChildViewCount(main);
        tv_count=(TextView)findViewById(R.id.tv2);
        tv_count.append(Integer.toString(count));
    }

    public int getAllChildViewCount(View v){
        int viewCount=0;
        //int Count=((ViewGroup) v).getChildCount();
        //Log.d("viewgroupTag",Integer.toString(Count));
        if(v==null){
            Log.d("yuhang","true");
            return 0;
        }
        if(v instanceof ViewGroup){
            for(int i=0;i<((ViewGroup) v).getChildCount();i++){
                View child=((ViewGroup) v).getChildAt(i);
                if(child instanceof ViewGroup)
                    viewCount+=getAllChildViewCount(((ViewGroup) v).getChildAt(i));
                else{
                    viewCount++;
                }
            }
        }
        else{
            viewCount++;
        }
        return viewCount;
    }
}
