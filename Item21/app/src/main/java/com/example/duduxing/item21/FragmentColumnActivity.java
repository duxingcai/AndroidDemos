package com.example.duduxing.item21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FragmentColumnActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tab1, tab2, tab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_column);


        tab1 = (TextView) findViewById(R.id.tab1);
        tab2 = (TextView) findViewById(R.id.tab2);
        tab3 = (TextView) findViewById(R.id.tab3);

        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();

        switch (view.getId()) {
            case R.id.tab1:
                ft.replace(R.id.content, new Fragment1());
                break;
            case R.id.tab2:
                ft.replace(R.id.content, new Fragment2());
                break;
            case R.id.tab3:
                ft.replace(R.id.content, new Fragment3());
                break;
            default:
                break;
        }

        ft.commit();
    }
}
