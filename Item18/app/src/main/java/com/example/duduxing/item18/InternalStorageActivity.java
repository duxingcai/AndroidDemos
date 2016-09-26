package com.example.duduxing.item18;
//掌握向内部存储卡上写入文件和读取文件的方法。
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private EditText editText1, editText2;
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        context = getApplicationContext();

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button1) {
            FileHelper fileHelper = new FileHelper(context);
            String fileName = editText1.getText().toString();
            String fileContent = editText2.getText().toString();
            try {
                fileHelper.saveFile(fileName, fileContent);
                Toast.makeText(this, "数据写入成功", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "数据写入失败", Toast.LENGTH_SHORT).show();
            }
        }
        if(view.getId() == R.id.button2) {
            FileHelper fileHelper = new FileHelper(getApplicationContext());
            try {
                String fileName = editText1.getText().toString();
                String fileContent = fileHelper.readFile(fileName);
                editText2.setText(fileContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(view.getId() == R.id.button3) {
            editText1.setText("");
            editText2.setText("");
        }
    }
}
