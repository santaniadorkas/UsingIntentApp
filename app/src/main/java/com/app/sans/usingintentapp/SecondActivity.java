package com.app.sans.usingintentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView name_obj=(TextView)findViewById(R.id.name_value);
        TextView email_obj=(TextView)findViewById(R.id.email_value);
        Intent intent_obj=getIntent();
        name_obj.setText("Name :"+intent_obj.getStringExtra("Name :"));
        email_obj.setText("Email :"+intent_obj.getStringExtra("E-Mail :"));

    }
}
