package com.example.and00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView tv_name1 , tv_name2 , tv_name3 , tv_name4;
    TextView tv_cnt1 , tv_cnt2 , tv_cnt3 , tv_cnt4;
    Button btn_order1 , btn_order2 , btn_order3 , btn_order4;

    TextView tv_money;//잔액표시용
    EditText edt_money;//금액입력부
    Button btn_input , btn_output;//금액 입력 , 잔돈 반환

    int money;//사용자의 금액을 관리하기 위한 변수

    //HashMap , List , 배열
    HashMap<String , Integer> map = new HashMap<>();
    int[] counts ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_cnt1 = findViewById(R.id.tv_cnt1);
        tv_cnt2 = findViewById(R.id.tv_cnt2);
        tv_cnt3 = findViewById(R.id.tv_cnt3);
        tv_cnt4 = findViewById(R.id.tv_cnt4);
        btn_order1 = findViewById(R.id.btn_order1);
        btn_order2 = findViewById(R.id.btn_order2);
        btn_order3 = findViewById(R.id.btn_order3);
        btn_order4 = findViewById(R.id.btn_order4);
        tv_money = findViewById(R.id.tv_money);
        edt_money = findViewById(R.id.edt_money);
        btn_input = findViewById(R.id.btn_input);
        btn_output = findViewById(R.id.btn_output);



//        Drink drink1 = new Drink("콜라" , 800 , 10 , tv_name1 , tv_cnt1 , btn_order1);
//        Drink drink2 = new Drink("사이다" , 1000 , 10 , tv_name2 , tv_cnt2 , btn_order2);
//        Drink drink3 = new Drink("환타" , 1200 , 10 , tv_name3 , tv_cnt3 , btn_order3);
//        Drink drink4 = new Drink("데미소다" , 1300 , 10 , tv_name4 , tv_cnt4 , btn_order4);
        setTvMoneyText();
        ArrayList<Drink> drinkList = new ArrayList<>();
        drinkList.add( new Drink("콜라" , 800 , 10 , findViewById(R.id.tv_name1) , tv_cnt1 , btn_order1));
        drinkList.add( new Drink("사이다" , 1000 , 10 , findViewById(R.id.tv_name2) , tv_cnt2 , btn_order2));
        drinkList.add( new Drink("환타" , 1200 , 10 , findViewById(R.id.tv_name3) , tv_cnt3 , btn_order3));
        drinkList.add( new Drink("데미소다" , 1300 , 10 , findViewById(R.id.tv_name4) , tv_cnt4 , btn_order4));

        counts = new int[drinkList.size()];//0,0,0,0

        for (int i=0; i<drinkList.size(); i++){
            final int IDX = i;
            drinkList.get(i).btn_order.setOnClickListener(v-> {
                if (money < drinkList.get(IDX).getPrice()) {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (drinkList.get(IDX).getCnt() < 1) {
                    Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                counts[IDX] ++;
                drinkList.get(IDX).setCnt( drinkList.get(IDX).getCnt()-1 );
                money -= drinkList.get(IDX).getPrice();

                setTvMoneyText();
            });
        }
        btn_output.setOnClickListener(v->{
            Toast.makeText(this, Arrays.toString(counts) + "개수", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this , MainActivity.class);
//            intent.putExtra("drinks" , counts);
//            intent.putExtra("drink1", 1);
//            intent.putExtra("drink1", 1);
//            intent.putExtra("drink1", 1);
//            intent.putExtra("drink1", 1);

        });



//        btn_order1.setOnClickListener(v -> {
//            if (money < drinkPrice1){
//                Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
//                return;
//            }else if (drinkCnt1 < 1){
//                Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            drinkCnt1--;
//            money -= drinkPrice1;
//            tv_cnt1.setText(drinkCnt1+" 개 남음11111");
//            tv_money.setText("잔돈" + money+ "원");
//        });
//        btn_order2.setOnClickListener(v -> {
//            if (money < drinkPrice2){
//                Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
//                return;
//            }else if (drinkCnt1 < 1){
//                Toast.makeText(this, "재고가 부족합니다.", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            drinkCnt2--;
//            money -= drinkPrice1;
//            tv_cnt1.setText(drinkCnt1+" 개 남음11111");
//            tv_money.setText("잔돈" + money+ "원");
//        });
        btn_input.setOnClickListener(v->{
            money +=  getEditTextInt(edt_money);
            setTvMoneyText();
            edt_money.setText("");
        });

    }

    public int getEditTextInt(EditText editText){
        try{
            int rtnInt = Integer.parseInt(editText.getText().toString());
            if(rtnInt > 0 ){
                return rtnInt;
            }
            Toast.makeText(this, "0이상의 값을 입력을 해주세요!!!", Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e){
            Toast.makeText(this, "숫자로 변환이 불가능합니다.", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "오류가 발생했습니다 재시도 해주세요.", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }


    public void setTvMoneyText(){
        tv_money.setText("잔액:" + money + " 원 남았습니다 ");
    }
    
    
}