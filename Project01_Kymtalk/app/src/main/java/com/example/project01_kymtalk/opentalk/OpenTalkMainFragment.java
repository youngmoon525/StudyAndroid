package com.example.project01_kymtalk.opentalk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kymtalk.R;
import com.example.project01_kymtalk.databinding.FragmentOpenTalkMainBinding;

public class OpenTalkMainFragment extends Fragment {

    FragmentOpenTalkMainBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOpenTalkMainBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }
}