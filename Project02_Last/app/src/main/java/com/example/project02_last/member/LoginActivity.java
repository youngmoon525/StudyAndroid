package com.example.project02_last.member;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.project02_last.R;
import com.example.project02_last.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //error..
        Glide.with(this).load("https://taehyunha.files.wordpress.com/2020/05/cdd521b0d71ce352728ffe8055434b8be509dcf819b0d184e360a2699c2ab4413df86935009322be24d8778aa5ededf8d3fbc860f2931c41261cc214d2dfdd731eb47db6d9eb84aa015c90821384078cca79f92d0af79b36726f447190.gif")
                .error(R.drawable.ic_launcher_foreground)// 에러 발생..
                .fallback(R.drawable.ic_launcher_background)// null을 넘김..
                .into(binding.imgvLogo);


    }
}