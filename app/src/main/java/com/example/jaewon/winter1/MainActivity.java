package com.example.jaewon.winter1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.tensorflow.lite.Interpreter;


public class MainActivity extends AppCompatActivity{
    InputMethodManager imm;
    EditText idtext,passwordtext;
    Button button;
    ConstraintLayout main_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        idtext = (EditText) findViewById(R.id.editText1);
        passwordtext = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button1);
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        button.setOnClickListener(mClickListener);
    }
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    Intent intent = new Intent(MainActivity.this, SubActivity.class);
                    String id = idtext.getText().toString();
                    String pw = passwordtext.getText().toString();
                    intent.putExtra("USERNAME_KEY", id);
                    intent.putExtra("PASSWORD_KEY", pw);
                    startActivity(intent);
                    break;
            }
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1001: //menuactivity
                break;
            case 1002:
                break;
        }
    }
    private void hideKeyboard()
    {
        imm.hideSoftInputFromWindow(idtext.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(passwordtext.getWindowToken(), 0);
    }

}
