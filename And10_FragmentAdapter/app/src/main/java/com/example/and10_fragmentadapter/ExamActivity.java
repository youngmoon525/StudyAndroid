package com.example.and10_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.and10_fragmentadapter.exam.ExamAdapter;

public class ExamActivity extends AppCompatActivity {
    RecyclerView recv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        recv = findViewById(R.id.recv);// "View" : 보여주는 기능만 구현 , "Adapter" : 뷰의 모든 모양이나 개수등의 항목을 설정(ViweHolder) , "LayoutManager" : 방향성

        ExamAdapter adapter = new ExamAdapter(getLayoutInflater());
        recv.setAdapter(adapter);
        recv.setLayoutManager(new LinearLayoutManager(this));
    }
}