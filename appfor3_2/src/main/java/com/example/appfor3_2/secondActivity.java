package com.example.appfor3_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondActivity extends Activity {
    Button button2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        TextView tv2 = (TextView) findViewById(R.id.textview02);
        Bundle bundle = this.getIntent().getExtras();

        String str = bundle.getString("text");
        tv2.setText(str);
        button2 = (Button)findViewById(R.id.button02);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setClass(secondActivity.this,MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
