package com.app.sans.usingintentapp;

import android.content.Intent;
import android.service.autofill.Validator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    EditText name_obj;
    EditText email_obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextpage_btn=(Button)findViewById(R.id.submit_button);
        name_obj=(EditText)findViewById(R.id.name);
        email_obj=(EditText)findViewById(R.id.email);
        nextpage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String val_name = name_obj.getText().toString();
                if(val_name.length()==0){
                    name_obj.setError("Field Can't Be Empty");
                    return;
                }
                else if(!val_name.matches("[a-zA-z]+")){
                    name_obj.requestFocus();
                    name_obj.setError("Enter Only Aplhabetical Character");
                    return;
                }
                final String val_email = email_obj.getText().toString();

                if (!isValidEmail(val_email)) {
                   email_obj.setError("Invalid Email");
                   email_obj.requestFocus();
                   return;
                }

                Intent intent_obj= new Intent(MainActivity.this,SecondActivity.class);
                intent_obj.putExtra("Name :",name_obj.getText().toString());
                intent_obj.putExtra("E-Mail :",email_obj.getText().toString());
                startActivity(intent_obj);

            }
        });

    }
    public boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
