package com.example.and10_fragmentadapter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and10_fragmentadapter.R;

public class MyFragment2 extends Fragment {
    //Fragment만들고 나서 .
    //1. 필요없는 코드 전부 삭제 ( onCreateView 제외 )
    //2. 리턴타입에 맞는 View 객체에 담은 후 객체를 리턴하게 만듬 (-> findViewById를 활용하기 위해서임 )
    //3. 객체에 담는 부분과 return부분 사이에 어떤 로직들을 구현하면 된다.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my2, container, false);

        return view;
    }
}