package com.example.exam00_middletoand;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exam00_middletoand.common.CommonConn;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //옵저버 패턴 순서 2번
        //양쪽은 같은 인터페이스를 참조한다.
//        new CommonConn(this , "aaa.kym").onExcute(new CommonConn.KymCallBack() {
//        //" 메소드는 정의가 되었을때 구조를 가지고,
//        //      호출이 되었을때 실행이된다.  "
//            @Override
//            public void onResult(boolean isResult, String data) {
//                Log.d("Common", "onResult: " + data);
//                Log.d("Common", "onResult: " + isResult);//<=
//            }
//        });
//        new CommonConn(this , "aaa.kym").onExcute((isResult , data)->{
//
//        });

        new CommonConn(this,"test.kym").setMethodType(CommonConn.MethodType.GET).addParamMap("param","GET").onExcute((isResult, data) -> {

        });


        new CommonConn(this,"test.kym").setMethodType(CommonConn.MethodType.POST).addParamMap("param","POST").onExcute((isResult, data) -> {

        });

        new CommonConn(this,"test.kym").addParamMap("param","Default").onExcute((isResult, data) -> {

        });




    }




}