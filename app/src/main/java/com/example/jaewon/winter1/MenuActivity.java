package com.example.jaewon.winter1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onBackButtonClicked(View v)
    {
        Toast.makeText(getApplicationContext(),"돌아가기 버튼을 눌렀어요",Toast.LENGTH_SHORT).show();
        finish();
    }

    public void onButtonClick1(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }

    public void onButtonClick2(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-9484-0272"));
        startActivity(myIntent);
    }

    public void onButtonClick3(View v)
    {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(myIntent);
    }
}
