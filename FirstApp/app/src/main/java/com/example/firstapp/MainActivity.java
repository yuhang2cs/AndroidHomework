package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String str=new String();
    private final String Tag="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rgroup=(RadioGroup)findViewById(R.id.radioGroup);
        final EditText eText = (EditText) findViewById(R.id.edit_text);

        final TextView show=(TextView)findViewById(R.id.tv1);
        //通过setOnCheckedChangeListener( )来响应按钮的事
        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup rg,int checkedId)
            {
                switch(checkedId){
                    case R.id.btnWant:show.setText("What a wonderful world!");Log.d(Tag,"用户选择想");break;
                    case R.id.btnDont:show.setText("What a pity!");Log.d(Tag,"用户选择不想");break;
                }
            }
        });

        Button btnpost=findViewById(R.id.btnpost);
        btnpost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(Tag,"用户输入名字"+eText.getText().toString());
                show.setText("Good Bye,"+eText.getText().toString());
            }
        });
    }
}
