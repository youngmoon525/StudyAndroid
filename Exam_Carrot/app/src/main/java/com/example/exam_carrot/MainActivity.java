package com.example.exam_carrot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imgv_profile;
    TextView tv_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgv_profile = findViewById(R.id.imgv_profile);
        tv_main = findViewById(R.id.tv_main);

        tv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ffff", "onClick: ");
            }
        });

        imgv_profile.setOnClickListener(v->{

        });

        imgv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("이미지 클릭!!", "onClick: ");
            }
        });






    }
}