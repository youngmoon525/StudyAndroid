package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.scrollView).setOnClickListener(v->{
            Log.d("dd", "onCreate: ");
        });


        findViewById(R.id.imgv).setOnClickListener(v->{
            Log.d("dd", "onCreate: ");
        });


    }
}