package com.example.duduxing.item8;
//熟悉Activity生命周期，使用Logcat观察各回调函数调用次序
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "Test";

    //测试回调函数执行顺序
    //onCreate()->onStart()-onResume()->onPause->onStop()->onDestroy()

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart()");

    }


    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG,"onResume()");
    }


    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG,"onPause()");
    }


    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"onStop()");
    }


    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"onRestart()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"onDestroy()");
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
