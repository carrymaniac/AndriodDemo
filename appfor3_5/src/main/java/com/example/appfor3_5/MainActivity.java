package com.example.appfor3_5;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    Button btn1,btn2;
    LinearLayout login;
    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button_01);
        btn2 = findViewById(R.id.button_02);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("警告");
                dialog.setIcon(R.drawable.dog);
                dialog.setMessage("本操作可能造成信息泄露");
                dialog.setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.create();
                dialog.show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                login = (LinearLayout) getLayoutInflater().inflate(R.layout.login,null);
                dialog.setTitle("用户登陆").setMessage("请输入用户名和密码").setView(login);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //写输入对话框的确认方法
                        txt = login.findViewById(R.id.passwordEdit);
                        if(txt.getText().toString().equals("admin")){
                            Toast.makeText(getApplicationContext(),"登陆成功",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(),"密码错误",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                dialog.setNegativeButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //写输入对话框的退出方法
                        MainActivity.this.finish();
                    }
                });
                dialog.setIcon(R.drawable.dog);
                dialog.create();
                dialog.show();
            }
        });
    }
}
