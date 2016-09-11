package com.example.duduxing.item4;
//使用ListView，实现课程系统中用户列表信息，每个item显示用户名字、班级、学号等

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListViewActivity extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new SimpleAdapter(this, getData(), R.layout.list_item_view, new String[]{"itemName", "itemAge", "itemSex", "itemGrade"}, new int[] {R.id.itemName, R.id.itemAge, R.id.itemSex, R.id.itemGrade}));




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<>();
        map.put("itemName", "姓名");
        map.put("itemAge", "年龄");
        map.put("itemSex", "性别");
        map.put("itemGrade", "班级");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("itemName", "萧函");
        map.put("itemAge", 22);
        map.put("itemSex", "男");
        map.put("itemGrade", 1404);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("itemName", "林枫");
        map.put("itemAge", 21);
        map.put("itemSex", "男");
        map.put("itemGrade", 1401);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("itemName", "杜康");
        map.put("itemAge", 20);
        map.put("itemSex", "男");
        map.put("itemGrade", 1404);
        list.add(map);

        return list;
    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
