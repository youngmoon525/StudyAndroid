package com.example.project01_kymtalk.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kymtalk.R;
import com.example.project01_kymtalk.databinding.FragmentChatBinding;

public class ChatFragment extends Fragment {
    FragmentChatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}