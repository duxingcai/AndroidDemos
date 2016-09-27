package com.example.duduxing.item27;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == "android.net.conn.CONNECTIVITY_CHANGE") {
            Toast.makeText(context, "网络状况变化了", Toast.LENGTH_SHORT).show();
        }
        if (intent.getAction() == "com.xiaobai.123") {
            Toast.makeText(context, "接收到的广播内容为：" + intent.getStringExtra("a"), Toast.LENGTH_SHORT).show();
        }
    }
}
