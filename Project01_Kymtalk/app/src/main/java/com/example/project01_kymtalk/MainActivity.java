package com.example.project01_kymtalk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.project01_kymtalk.databinding.ActivityMainBinding;
import com.example.project01_kymtalk.friend.FriendFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0f);
        actionBar.setTitle("친구");

//        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                return false;
//            }
//        });

        getSupportFragmentManager().beginTransaction().replace(R.id.container , new FriendFragment()).commit();

        binding.bottomNav.setOnItemSelectedListener(item ->{
            if(item.getItemId() == R.id.tab1){

            }else if(item.getItemId() == R.id.tab2){

            }else if(item.getItemId() == R.id.tab3){

            }else if(item.getItemId() == R.id.tab4){

            }else if(item.getItemId() == R.id.tab5){

            }
            actionBar.setTitle(item.getTitle());

            return true;
        });

    }
}