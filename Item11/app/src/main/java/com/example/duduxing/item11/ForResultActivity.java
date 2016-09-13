package com.example.duduxing.item11;
//掌握多个Activity之间来回传递数据，既能够将数据传递给指定的Activity，也能够获得Activity返回的数据。
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForResultActivity extends AppCompatActivity {
    private Intent intent;
    private Button button1;
    private EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);

        button1 = (Button) findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent();
                intent.putExtra("name", editText1.getText().toString());
                intent.setClass(ForResultActivity.this, SecondActivity.class);
                startActivityForResult(intent, 110);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 110 && resultCode == RESULT_OK) {
            editText1.setText(data.getStringExtra("name"));
        }
    }
}
