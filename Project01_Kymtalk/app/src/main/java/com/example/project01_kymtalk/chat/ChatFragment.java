package com.example.project01_kymtalk.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kymtalk.R;
import com.example.project01_kymtalk.databinding.FragmentChatBinding;
import com.example.project01_kymtalk.opentalk.OpenSubAdapter1;
import com.example.project01_kymtalk.opentalk.OpenSubDAO;

public class ChatFragment extends Fragment {
    FragmentChatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(inflater, container, false);
        OpenSubDAO dao = new OpenSubDAO();
        binding.recvChat.setAdapter(new OpenSubAdapter1(dao.getOpenSub1List()));
        binding.recvChat.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }
}