package com.example.jaewon.winter1;

import android.app.Activity;
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
import android.widget.TextView;
import android.widget.Toast;
import org.tensorflow.lite.Interpreter;


public class MainActivity extends AppCompatActivity{
    InputMethodManager imm;
    TextView headtext;
    EditText idtext,passwordtext;
    Button button;
    ConstraintLayout main_layout;
    static final int subactivity_code = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headtext = findViewById(R.id.title);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        idtext = (EditText) findViewById(R.id.editText1);
        passwordtext = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button1);
        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);
        button.setOnClickListener(mClickListener);
        main_layout.setOnClickListener(vClickListener);
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
                    startActivityForResult(intent,subactivity_code);
                    break;
            }
        }
    };
    View.OnClickListener vClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            hideKeyboard(MainActivity.this);
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1001: //subactivity
                if(resultCode ==1234)
                    headtext.setText(data.getStringExtra("result from SubActivity"));
                break;
            case 1002:
                break;
        }
    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
