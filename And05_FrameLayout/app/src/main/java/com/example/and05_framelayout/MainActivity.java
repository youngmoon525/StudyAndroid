package com.example.and05_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn_change  ;             //null
    ImageView imgv1 , imgv2 , imgv3 ;//null <= 객체를 이런 이름으로 사용하겠다 ( 선언 )
    int imgFlag;//0 <- 버튼을 누를때마다 imgFlag가 증가해서 로그에 찍히게 해보기.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// activity_main.xml에 있는 내용들을 메모리에 올림.

        btn_change = findViewById(R.id.btn_change);
        imgv1 = findViewById(R.id.imgv1);
        imgv2 = findViewById(R.id.imgv2);
        imgv3 = findViewById(R.id.imgv3);
        //View를 상속받은 모든 위젯들은 (화면에 보이는 모든것들 레이아웃 포함 ) 사용자의 클릭을 감지하는 View.OnclickListner를 가지고 있다.
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //여기서 이벤트 처리
            }
        });


        btn_change.setOnClickListener(v -> {
            //imgv1.setImageResource(R.drawable.img1); <- 실제 이미지 바꾸기
            imgFlag++;
            if(imgFlag==4) imgFlag = 1;
            Log.d("버튼", "imgFlag: " + imgFlag);
            imgv3.setVisibility(View.GONE);
            imgv2.setVisibility(View.GONE);
            imgv1.setVisibility(View.GONE);
            if(imgFlag == 1){
                imgv2.setVisibility(View.VISIBLE);
            }else if(imgFlag == 2){
                imgv1.setVisibility(View.VISIBLE);
            }else if(imgFlag == 3){
                imgv3.setVisibility(View.VISIBLE);
            }

            //사용자가 버튼을 누름
            //몇번째 누른건지에 따라서 분기를 시켜야함.
            //버튼을 누르면 3번이미지 사라짐 , 2번 이미지 사라짐 , 1번 이미지 사라짐이 각각 되게 처리해보기.
            // 1 , 2 , 3 -> 1 , 2 , 3 -> 1...

            //logd , i , e , ...
            //logd를 활용!
            //Log.d("KYM LOG", "내가 쓰고 싶은거 String");
            //Log.e("KYM LOG", "Error Log", null);
            //Log.i("KYM LOG", "Info 뭔가 정보를 표기할때");
            //여기서 이벤트 처리
        });


    }
}