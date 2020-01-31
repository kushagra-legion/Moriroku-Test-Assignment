package com.example.firebase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Facebookpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebookpage);
        Intent intent=getIntent();

        TextView t1=(TextView)findViewById(R.id.textView2);
        t1.setText("Login succesfull!!! \n"+intent.getStringExtra(MainActivity.key) );


    }
}
