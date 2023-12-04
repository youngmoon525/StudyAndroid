package com.example.and10_fragmentadapter.melon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and10_fragmentadapter.R;

import java.util.ArrayList;

public class MelonAdapter extends RecyclerView.Adapter<MelonAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<MelonDTO> list;

    public MelonAdapter(LayoutInflater inflater, ArrayList<MelonDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_recv_melon, parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.imgv_chart.setImageResource(list.get(i).getImgProfile());
        h.tv_rank.setText(list.get(i).getRank()+"");
        h.tv_singer.setText(list.get(i).getSinger());
        h.tv_title.setText(list.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgv_chart;
            TextView tv_rank , tv_title , tv_singer ;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_chart = v.findViewById(R.id.imgv_chart);
            tv_rank = v.findViewById(R.id.tv_rank);
            tv_title = v.findViewById(R.id.tv_title);
            tv_singer = v.findViewById(R.id.tv_singer);
        }
    }

}
