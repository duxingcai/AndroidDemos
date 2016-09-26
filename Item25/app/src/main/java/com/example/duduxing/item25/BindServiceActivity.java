package com.example.duduxing.item25;
//.掌握bindService启动服务方法,编程实现使用bindService启动服务，并调用Service的各个方法（例如加法等）。

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BindServiceActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4;
    ServiceDemo serviceDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent1 = new Intent(BindServiceActivity.this, ServiceDemo.class);
                startService(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(BindServiceActivity.this, ServiceDemo.class);
                stopService(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(BindServiceActivity.this, ServiceDemo.class);
                bindService(intent3, serviceConnection, Service.BIND_AUTO_CREATE);
                break;
            case R.id.button4:
                unbindService(serviceConnection);
                break;
            default:
                break;
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ServiceDemo.MyBinder myBinder = (ServiceDemo.MyBinder) iBinder;
            serviceDemo = myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
