package com.example.and_viewapger2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 pager2 = findViewById(R.id.viewPager2);
        pager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        pager2.setClipToPadding(false);
        pager2.setClipChildren(false);
        pager2.setOffscreenPageLimit(1);
        pager2.setPadding(200, 0, 200, 0);
        pager2.setPageTransformer(new MarginPageTransformer(100));
        pager2.setAdapter(new TestAdapter());
    }


    public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 20;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}