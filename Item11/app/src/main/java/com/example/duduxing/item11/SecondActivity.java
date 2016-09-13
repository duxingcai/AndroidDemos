package com.example.duduxing.item11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private Intent intent;
    private Button button2;
    private EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_view);
        button2 = (Button) findViewById(R.id.button2);
        editText2 = (EditText) findViewById(R.id.editText2);

        intent = getIntent();
        String name = intent.getStringExtra("name");
        editText2.setText(name);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent();
                intent.putExtra("name", editText2.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
