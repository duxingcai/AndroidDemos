package com.example.duduxing.item23;
//监控联系人发生改变（例如增加联系人）时情况。

import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class ContentObserverActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_observer);

        textView = (TextView) findViewById(R.id.textView);

        getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, new myContentObserver(new Handler()));
    }

    private class myContentObserver extends ContentObserver {

        public myContentObserver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);

            textView.setText("很明显联系人变化了");
        }
    }
}
