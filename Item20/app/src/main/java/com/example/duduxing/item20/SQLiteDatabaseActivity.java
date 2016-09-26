package com.example.duduxing.item20;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SQLiteDatabaseActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private StudentsDB studentsDB;
    private Cursor cursor;
    private int STUDENT_ID = 0;
    private ListView studentsList;
    private EditText editText1, editText2;
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        studentsList = (ListView) findViewById(R.id.listView);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        studentsDB = new StudentsDB(this);
        cursor = studentsDB.select();
        studentsList.setAdapter(new StudentsListAdapter(this, cursor));
        studentsList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button1) {
            add();
        }
        if(view.getId() == R.id.button2) {
            delete();
        }
        if(view.getId() == R.id.button3) {
            update();
        }
    }

    public void add() {
        String name = editText1.getText().toString();
        String age = editText2.getText().toString();
        if(name.equals("")) {
            return;
        }
        studentsDB.insert(name, age);
        studentsList.invalidateViews();
        editText1.setText("");
        editText2.setText("");
        Toast.makeText(SQLiteDatabaseActivity.this, "添加成功", Toast.LENGTH_SHORT);
    }

    public void delete() {
        if(STUDENT_ID == 0) {
            return;
        }
        studentsDB.delete(STUDENT_ID);
        studentsList.invalidateViews();
        editText1.setText("");
        editText2.setText("");
        Toast.makeText(SQLiteDatabaseActivity.this, "删除成功", Toast.LENGTH_SHORT);
    }

    public void update() {
        String name = editText1.getText().toString();
        String age = editText2.getText().toString();
        if(name.equals("")) {
            return;
        }
        studentsDB.update(STUDENT_ID, name, age);
        studentsList.invalidateViews();
        editText1.setText("");
        editText2.setText("");
        Toast.makeText(this, "更新成功", Toast.LENGTH_SHORT);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        cursor.moveToPosition(i);
        STUDENT_ID = cursor.getInt(0);
        editText1.setText(cursor.getString(1));
        editText2.setText(cursor.getString(2));
    }

    public class StudentsListAdapter extends BaseAdapter {
        private Context context;
        private Cursor cursor;

        public StudentsListAdapter(Context context, Cursor cursor) {
            this.context = context;
            this.cursor = cursor;
        }

        @Override
        public int getCount() {
            return cursor.getCount();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(context);
            cursor.moveToPosition(i);
            textView.setText(cursor.getString(1) + "---" + cursor.getString(2));
            return textView;
        }
    }
}


