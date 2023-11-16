package com.example.and07_resource;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "메인액티비티";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shape_layout);

        Log.d(TAG, " String res : " + R.string.version);
        Log.d(TAG, " String res(str): " + getString(R.string.server_ip));

    }
}