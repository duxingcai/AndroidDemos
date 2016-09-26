package com.example.duduxing.item17;
//.掌握SharedPreferences的使用方法,编写程序，向SharedPreferences写入学号、姓名等信息并读取、显示这些信息。

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Map;


public class SharedPreferencesActivity extends AppCompatActivity {
    private Context context;
    private SharedHelper sharedHelper;
    private EditText editText1, editText2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        context = getApplicationContext();
        sharedHelper = new SharedHelper(context);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editText1.getText().toString();
                String passwd = editText2.getText().toString();
                sharedHelper.save(username, passwd);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Map<String, String> data = sharedHelper.read();
        editText1.setText(data.get("username"));
        editText2.setText(data.get("passwd"));
    }
}
