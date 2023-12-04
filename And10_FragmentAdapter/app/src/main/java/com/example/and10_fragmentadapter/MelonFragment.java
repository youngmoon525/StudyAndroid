package com.example.and10_fragmentadapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and10_fragmentadapter.melon.MelonAdapter;
import com.example.and10_fragmentadapter.melon.MelonDTO;

import java.util.ArrayList;

public class MelonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_melon, container, false);
        RecyclerView recv_melon = v.findViewById(R.id.recv_melon);

        ArrayList<MelonDTO> list = new ArrayList<>();
        list.add(new MelonDTO("Perfect Night" , "LE SSERAFILM (르세라핌 )" ,    R.drawable.chart_img1 , 1));
        list.add(new MelonDTO("Drama" , "aespa" ,    R.drawable.chart_img2 , 2));
        list.add(new MelonDTO("Baddie" , "IVE(아이브)" ,    R.drawable.chart_img3 , 3));
        list.add(new MelonDTO("To. X" , "태연 (TAEYEON)" ,    R.drawable.chart_img4 , 4));
        list.add(new MelonDTO("사랑은 늘 도망가" , "임영웅" ,    R.drawable.chart_img5 , 5));
        list.add(new MelonDTO("Seven (feat. Latto) - Clean Ver" , "정국" ,    R.drawable.chart_img6 , 6));

        MelonAdapter adapter = new MelonAdapter(inflater , list );
        recv_melon.setLayoutManager(new LinearLayoutManager(getContext()));
        recv_melon.setAdapter(adapter);



        return v;
    }
}