package com.example.duduxing.item3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
//使用TextView、EditText、Button、CheckBox、RadioButton等编写一个界面，
// 该界面有上述元素，要求按下Button时修改EditText内容，
// 按下CheckBox、RadioButton等修改TextView内容为用户所选择的选项
public class CommonWidgetActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private TextView textView;
    private EditText editText;
    private Button button;
    private RadioGroup radioGroup;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_widget);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("你点击了按钮");
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                    if (radioButton.isChecked()) {
                        textView.setText(radioButton.getText());
                    }
                }
            }
        });
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);

    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isCurButtonChecked) {
        if (isCurButtonChecked) {
            textView.setText(compoundButton.getText());
        }
    }
}
