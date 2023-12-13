package com.example.project01_kymtalk.opentalk;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.project01_kymtalk.R;
import com.example.project01_kymtalk.databinding.FragmentOpenTalkSubBinding;
import com.google.android.material.chip.Chip;

public class OpenTalkSubFragment extends Fragment {
    FragmentOpenTalkSubBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOpenTalkSubBinding.inflate(inflater, container, false);
        OpenSubDAO dao = new OpenSubDAO();
        binding.recvOpensub1.setAdapter(new OpenSubAdapter1(dao.getOpenSub1List()));
        binding.recvOpensub1.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.recvOpensub2.setAdapter(new OpenSubAdapter2(dao.getOpenSub2List()));
        binding.recvOpensub2.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.recvOpensub3.setAdapter(new OpenSubAdapter2(dao.getOpenSub3List()));
        binding.recvOpensub3.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.recvOpensub4.setAdapter(new OpenSubAdapter3(dao.getOpenSub4List()));
        binding.recvOpensub4.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));

        //ViewGroup에 자식요소를 넣는것은 addView
        //xml파일에서 사용이 가능한 모든 속성들은 메소드 형태로도 존재함.
        //Context가 필요함 ( 화면의 상태 정보를 꼭 알아야 하는 경우 )

        //Chip의 스타일을 지정함. ( xml에서 style= @style/...)

        //DB  , Spring , JspServlet , Android ,

       //binding.chipGrpOpensub.addView(chip);
        binding.chipGrpOpensub.setSingleSelection(false);
        String[] chipTexts = { "등산" , "니트" , "이영지" , "김태형" , "명품정보" , "김남준" , "밀덕" , "시고르자브종" , "닌텐도" , "정국" , "보드게임" , "해외축구" };
        for(int i=0; i<chipTexts.length; i++){
            Chip chip = getChip(chipTexts[i]);
            if(i%2==0) chip.setBackgroundColor(Color.parseColor("#000099"));
            binding.chipGrpOpensub.addView(chip);


        }
        return binding.getRoot();
    }

    @SuppressLint("ResourceType")
    Chip getChip(String text){
        Chip chip = new Chip(getContext() , null , com.google.android.material.R.style.Widget_MaterialComponents_Chip_Choice );
        chip.setId(View.generateViewId());
        chip.setText(text);
        chip.setBackgroundResource(R.drawable.chip_opentalk_sub_background);
        chip.setChipBackgroundColorResource(R.drawable.chip_opentalk_sub_background);
        chip.setTextColor(Color.parseColor("#000000"));
        chip.setChipIconVisible(true);
        chip.setChipIconResource(R.drawable.ic_chip_opentalk4);
        chip.setIconStartPadding(10f);
        chip.setIconEndPadding(10f);
        chip.setTextStartPadding(10f);
        chip.setTextEndPadding(10f);
        chip.setMinHeight(40);
        chip.setChipStrokeColor(ColorStateList.valueOf(Color.parseColor("#000000")));
        chip.setChipStrokeWidth(1f);
        chip.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        chip.setOnClickListener(v->{
            Toast.makeText(getContext(), "허허허크", Toast.LENGTH_SHORT).show();
        });
        return chip;
    }


}