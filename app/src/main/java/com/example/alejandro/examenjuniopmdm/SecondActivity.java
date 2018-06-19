package com.example.alejandro.examenjuniopmdm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.v("SecondActivity", "-----Email usuario" +  DataHolder.instance.fireBaseAdmin);

    }
}
