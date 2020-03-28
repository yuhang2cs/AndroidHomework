package com.example.secondapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class showNumbers extends AppCompatActivity {
    private TextView tv;
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_number);
        tv=(TextView) findViewById(R.id.showNumber);
        Bundle bundle=this.getIntent().getBundleExtra("bundle");
        if(bundle!=null){
            tv.append(bundle.getString("position")+"th item");
        }
    }
}
