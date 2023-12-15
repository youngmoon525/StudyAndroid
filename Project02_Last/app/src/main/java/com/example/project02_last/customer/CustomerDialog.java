package com.example.project02_last.customer;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.project02_last.R;
import com.example.project02_last.common.CommonConn;
import com.example.project02_last.databinding.DialogCustomerBinding;
import com.google.gson.Gson;

public class CustomerDialog extends Dialog {
    //Android : Dialog종류가 많음 -> 머티리얼 , 기타 모양을 찾아보고 사용하기. ( 현:Legacy )
    DialogCustomerBinding binding;
    //CustomerVO vo;
    public CustomerDialog(@NonNull Context context , CustomerVO vo) {
        super(context);
        binding = DialogCustomerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //insert 처리를 해주면 됨.
        if(vo==null){
            binding.tvCusId.setText("고객번호 : 자동으로 채번 됩니다.");

            binding.btnApply.setOnClickListener(v->{
                CustomerVO tempVo = new CustomerVO();

               tempVo.setEmail(binding.edtEmail.getText().toString());
               tempVo.setGender(binding.rdoMan.isChecked() ? "남" : "여");
               tempVo.setPhone(binding.edtPhone.getText().toString());
               tempVo.setName(binding.edtName.getText().toString());

                new CommonConn(context , "insert.cu").addParamMap("vo" , new Gson().toJson(tempVo)).onExcute((isResult, data) -> {
                    dismiss();//다이얼로그 자체가 안보이게 .. show() // dismiss()
                });
            });


        }else{

            binding.tvCusId.setText("고객번호 : " + vo.getCustomer_id());
            binding.edtName.setText(vo.getName());
            binding.edtEmail.setText(vo.getEmail());
            binding.edtPhone.setText(vo.getPhone());
            if(vo.getGender().equals("남")){
                binding.rdoMan.setChecked(true);
            }else{
                binding.rdoWoman.setChecked(true);
            }

            binding.btnApply.setOnClickListener(v->{
                vo.setEmail(binding.edtEmail.getText().toString());
                vo.setGender(binding.rdoMan.isChecked() ? "남" : "여");
                vo.setPhone(binding.edtPhone.getText().toString());
                vo.setName(binding.edtName.getText().toString());

                new CommonConn(context , "update.cu").addParamMap("vo" , new Gson().toJson(vo)).onExcute((isResult, data) -> {
                    dismiss();//다이얼로그 자체가 안보이게 .. show() // dismiss()
                });
            });

        }








    }


}
