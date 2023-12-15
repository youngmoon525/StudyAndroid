package com.example.project02_last.customer;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.project02_last.R;
import com.example.project02_last.common.CommonConn;
import com.example.project02_last.databinding.FragmentCustomerBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;


public class CustomerFragment extends Fragment {

    FragmentCustomerBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCustomerBinding.inflate(inflater ,container, false );

        select("");

        binding.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // 검색 버튼을 눌렀을 때 호출이 된다.
                Log.d("검색", "onQueryTextSubmit: " + query);
                select(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //검색어가 변경될 때 호출됨 - 실시간 검색을 해야한다면 이용이 가능함. ( 서버가 빠르고 퍼포먼스가 좋은 경우 )
                //Log.d("검색", "onQueryTextChange: " + newText);
                //""
                if(newText.isEmpty()){
                    select("");
                }

                return true;
            }
        });

        binding.fabInsert.setOnClickListener(v->{
            CustomerDialog dialog = new CustomerDialog(getContext() , null);

            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
            DisplayMetrics displayMetrics = new DisplayMetrics();
            dialog.getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            layoutParams.width = (int) (displayMetrics.widthPixels * 0.9);//80 비율로 맞추기
            layoutParams.height = (int) (displayMetrics.heightPixels * 0.5);//80
            dialog.getWindow().setAttributes(layoutParams);
            dialog.show();
            dialog.setOnDismissListener(dialog1 -> {
                Log.d("다이얼로그", "setOnDismissListener: ");
                select("");
            });

        });



        return binding.getRoot();
    }

    void select(String query){
        CommonConn conn = new CommonConn(getContext(),"select.cu");
        conn.addParamMap("query" , query);
        conn.onExcute((isResult, data) -> {
            Log.d("TAG", "select: " +data);
            // new Gson().fromJson("StringJson" , Type.class);
            // new Gson().fromJson("StringJsonArr" , new TypeToken< List<CustomerVO> >(){}.getType();
            List<CustomerVO> list  = new Gson().fromJson(data , new TypeToken<List<CustomerVO>>(){}.getType() );
            CustomerAdapter adapter = new CustomerAdapter(list,getContext(),this);
            binding.recvCustomer.setAdapter(adapter);
            binding.recvCustomer.setLayoutManager(new LinearLayoutManager(getContext()));
            //list -> Adapter

            //플로팅액션버튼이 눌렸을때 insert처리를 어떻게 할건지 생각하고 구현하기.
            //1.다이얼로그를 띄우기 2.입력 받기 3.Controller를 이용하여 실제 INSERT 처리 4.새로고침
            //2.Activity를 새로 띄우기

            //전송처리 전에는 데이터를 StringJson으로 묶어서 보내는게 편함

            //DB
            //Trigger를 이용해서 customer_id는 입력을 x
            //Seq.nextval를 이용,
            //중복확인 버튼을 하나 넣고 중복되는 id가 있는지 여부를 체크


        });
    }

}