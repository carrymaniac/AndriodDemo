package com.example.appfor4_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup ;
    CheckBox c1,c2,c3,c4;
    Button b1,b2;
    TextView tv1,tv2,tv3;
    int sc = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        c1 = findViewById(R.id.CB1);
        c2 = findViewById(R.id.CB2);
        c3 = findViewById(R.id.CB3);
        c4 = findViewById(R.id.CB4);
        radioGroup = findViewById(R.id.RG);
        b1 = findViewById(R.id.Btn1);//提交
        b2 = findViewById(R.id.Btn2);//清空
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer str1 = new StringBuffer("你提交的答案一:");
                StringBuffer str2 = new StringBuffer("你提交的答案二:");
                int a = str2.length();
                if(c1.isChecked()){
                    str2.append(" 法国国家队 ");
                    sc++;
                }if(c2.isChecked()){
                    str2.append(" 中国国家队 ");
                }if(c3.isChecked()){
                    str2.append(" 巴西国家队 ");
                    sc++;
                }if(c4.isChecked()){
                    str2.append(" 美国国家队 ");
                }
                if(str2.length()==a){
                    str2.append("提交的答案为空");
                }
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.RB1:
                        str1.append("巴西");
                        sc++;
                        break;
                    case R.id.RB2:
                        str1.append("德国");
                        break;
                    case R.id.RB3:
                        str1.append("美国");
                        break;
                    case R.id.RB4:
                        str1.append("法国");
                        break;
                    default:
                        str1.append("没有选择答案");
                }
                tv1.setText(str1);
                tv2.setText(str2);
                String string= "你的得分:"+""+sc;
                tv3.setText(string);
                sc = 0;

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc=0;
               radioGroup.clearCheck();
                c1.setChecked(false);
                c2.setChecked(false);
                c3.setChecked(false);
                c4.setChecked(false);
                tv1.setText("你提交的答案一:");
                tv2.setText("你提交的答案二:");
                tv3.setText("你的得分:");
            }
        });
    }
}
