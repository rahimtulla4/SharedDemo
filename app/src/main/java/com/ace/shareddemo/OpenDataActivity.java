package com.ace.shareddemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OpenDataActivity extends AppCompatActivity {
TextView name,phone,pass,email;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_data);
        name=(TextView)findViewById(R.id.textView);
        phone=(TextView)findViewById(R.id.textView2);
        pass=(TextView)findViewById(R.id.textView3);
        email=(TextView)findViewById(R.id.textView4);
        preferences=getSharedPreferences("myFile",MODE_PRIVATE);
        name.setText(preferences.getString("NAME","no values"));
        phone.setText(preferences.getString("PHONE","no values"));
        pass.setText(preferences.getString("PASS","no values"));
        email.setText(preferences.getString("Email","no values"));
    }
}
