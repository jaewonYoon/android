package com.example.jaewon.winter1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView passwordText = (TextView) findViewById(R.id.password);
        TextView usernameText = (TextView) findViewById(R.id.username);

        Intent intent = getIntent(); //이 액티비티를 부른 인텐트를 받는다.
        String username = intent.getStringExtra("USERNAME_KEY"); //username 받아옴
        int password = intent.getIntExtra("PASSWORD_KEY",0); // password받아옴

        usernameText.setText(username);
        passwordText.setText(""+password);
    }
}
