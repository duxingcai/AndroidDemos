package com.example.duduxing.item22;
//访问“联系人”信息
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1, textView2;
    Button button1, button2;
    ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        contentResolver = getContentResolver();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            if(cursor == null) return;
            if(cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                textView1.setText(id);
                textView2.setText(name);
            }
            cursor.close();
        }
        if (view.getId() == R.id.button2) {
            textView1.setText("姓名");
            textView2.setText("号码");
        }
    }
}
