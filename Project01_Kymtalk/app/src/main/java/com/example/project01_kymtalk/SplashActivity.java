package com.example.project01_kymtalk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    //스플래시 액티비티 : 마케팅 효과 , 초기 데이터를 로딩 ...
    //Handler() : 작업을 지연시키거나 메세지로 보낸 후 사용을 위한 객체 (예약)
    //runOnUiThread : 백그라운드에서 메인(UI) 스레드를 전달(바꿈)할때 사용. (안정성↑)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //ProgressDiaog : 로딩중에 사용자가 어떤 동작을 하고있는지 인지를 못하는 경우 프로그램을 오류나 , 버그로 의심을 하고 기다림을 멈춤 -> 조작
        //조작(x) -> 앱은 로딩중이다(O)
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Kym Talk");
        dialog.setMessage("로딩중 대기 바랍니다..");
        dialog.setCancelable(false);//다이얼로그를 취소하지 못하게 처리.
        dialog.show();//실제보이는처리

        new Handler().postDelayed( ()->{
            dialog.dismiss();//안보이게 처리
            intentMain();
        } , 5 * 1000);

    }

    public void intentMain(){
        runOnUiThread(()->{
            Intent intent = new Intent(this , MainActivity.class);
            startActivity(intent);
            finish();
        });
    }


}