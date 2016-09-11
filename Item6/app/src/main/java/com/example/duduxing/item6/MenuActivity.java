package com.example.duduxing.item6;
//使用XML定义菜单项，并制作选项菜单、上下文菜单和弹出菜单
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MenuActivity extends AppCompatActivity {
    TextView textView1, textView2, textView3;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        registerForContextMenu(button1);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MenuActivity.this, view);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        textView3.setText(item.getTitle());
                        return false;
                    }
                });
            }
        });


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("红色");
        menu.add("绿色");
        menu.add("蓝色");
        SubMenu subMenu = menu.addSubMenu("水果");
        subMenu.add("苹果");
        subMenu.add("桃子");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        textView1.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }

    //文本菜单
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("编程语言");
        menu.add("Java");
        menu.add("Ruby");
        menu.add("Python");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public boolean onContextItemSelected(MenuItem item) {
        textView2.setText(item.getTitle());
        return super.onContextItemSelected(item);
    }
}
