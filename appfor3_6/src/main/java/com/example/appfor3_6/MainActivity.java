package com.example.appfor3_6;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    TextView  txt1,txt2;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button_01);
        btn2 = findViewById(R.id.button_02);
        btn3 = findViewById(R.id.button_03);
        txt1 = findViewById(R.id.text);
        txt2 = findViewById(R.id.text2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog d = new ProgressDialog(MainActivity.this);
                d.setTitle("进度对话框");
                d.setIndeterminate(true);//设置进度条是否明确,若明确则正确显示其进度
                d.setMessage("程序正在Loading...");
                d.setCancelable(true);//点击其他区域,则可以需要dismiss该进度框
                d.setMax(10);
                d.show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            Calendar ca = Calendar.getInstance();
            int  m_year = ca.get(Calendar.YEAR);
            int  m_month = ca.get(Calendar.MONTH);
            int  m_day = ca.get(Calendar.DAY_OF_MONTH);
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        m_year = year;
                        m_month = month;
                        m_day = dayOfMonth;
                        txt1.setText("你选择的日期为:"+m_year+"年"+m_month+"月"+m_day+"日");
                    }
                } ;
                DatePickerDialog date = new DatePickerDialog(MainActivity.this,onDateSetListener,m_year,m_month,m_day);
                date.setTitle("日期对话框");
                date.show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            Calendar ca = Calendar.getInstance();
            int m_hour = ca.get(Calendar.HOUR_OF_DAY);
            int m_min = ca.get(Calendar.MINUTE);
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener timeChangedListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        m_hour = hourOfDay;
                        m_min = minute;
                        txt2.setText("你选择的时间为:"+m_hour+"时"+m_min+"分");
                    }
                };
                TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, (TimePickerDialog.OnTimeSetListener) timeChangedListener,m_hour,m_min,true);
                dialog.setTitle("时间对话框");
                dialog.show();
            }
        });
    }
}
