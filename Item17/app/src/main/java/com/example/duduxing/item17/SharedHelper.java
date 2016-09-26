package com.example.duduxing.item17;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class SharedHelper {
    private Context context;

    public SharedHelper() {

    }

    public SharedHelper(Context context) {
        this.context = context;
    }

    public void save(String username, String passwd) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("passwd", passwd);
        editor.apply();
        Toast.makeText(context, "提交成功", Toast.LENGTH_SHORT);
    }

    public Map<String, String> read() {
        Map<String, String> data = new HashMap<String, String>();
        SharedPreferences sharedPreferences = context.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        data.put("username", sharedPreferences.getString("username", ""));
        data.put("passwd", sharedPreferences.getString("passwd", ""));
        return data;
    }
}
