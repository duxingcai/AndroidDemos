package com.example.duduxing.item14;
//掌握使用Intent隐式启动的方法

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ImplicitActivity extends AppCompatActivity {
    protected Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.duduxing.item14.SecondActivity");
                startActivity(intent);
            }
        });
    }
}
