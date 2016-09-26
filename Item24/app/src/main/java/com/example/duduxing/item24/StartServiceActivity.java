package com.example.duduxing.item24;
//掌握Service基本特点,掌握startService启动服务方法,编程实现使用startService启动服务并传递值，并且通过logcat输出该值。


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class StartServiceActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2;
    EditText editText;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        intent = new Intent(StartServiceActivity.this, ServiceDemo.class);
    }

    @Override
    public void onClick(View view) {
        intent.putExtra("str", editText.getText().toString());

        if(view.getId() == R.id.button1) {
            startService(intent);
        }
        if(view.getId() == R.id.button2) {
            stopService(intent);
        }
    }
}
