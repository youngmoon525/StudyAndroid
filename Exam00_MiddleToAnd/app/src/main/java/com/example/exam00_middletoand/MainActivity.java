package com.example.exam00_middletoand;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exam00_middletoand.common.CommonConn;
import com.example.exam00_middletoand.common.CommonRetClient;
import com.example.exam00_middletoand.common.CommonService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView <-

        //옵저버 패턴 순서 2번
        //양쪽은 같은 인터페이스를 참조한다.
        new CommonConn(this , "aaa.kym").onExcute(new CommonConn.KymCallBack() {
            @Override
            public void onResult(boolean isResult, String data) {

                Log.d("Common", "onResult: " + data);
                Log.d("Common", "onResult: " + isResult);//<=
            }
        });


    }
}