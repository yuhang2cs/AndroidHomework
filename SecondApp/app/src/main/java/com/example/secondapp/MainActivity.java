package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ex1=(Button)findViewById(R.id.btn_exercises1);
        Button ex2=(Button)findViewById(R.id.btn_exercises2);
        Button ex3=(Button)findViewById(R.id.btn_exercises3);
        ex1.setOnClickListener(this);
        ex2.setOnClickListener(this);
        ex3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_exercises1:
                startActivity(new Intent(this,Exercise1.class));
                break;
            case R.id.btn_exercises2:
                startActivity(new Intent(this,Exercise2.class));
                break;
            case R.id.btn_exercises3:
                startActivity(new Intent(this,Exercise3.class));
                break;
        }
    }
}
