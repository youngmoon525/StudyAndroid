package com.example.project01_kymtalk.opentalk;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kymtalk.databinding.ItemOpentalkChat2Binding;
import com.example.project01_kymtalk.databinding.ItemOpentalkChatVerticalBinding;

import java.util.ArrayList;

public class OpenSubAdapter3 extends RecyclerView.Adapter<OpenSubAdapter3.ViewHolder> {
    ArrayList<OpenSubDTOs.OpenSub3DTO> list ;

    public OpenSubAdapter3(ArrayList<OpenSubDTOs.OpenSub3DTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOpentalkChatVerticalBinding binding = ItemOpentalkChatVerticalBinding.inflate(LayoutInflater.from(parent.getContext()) , parent , false );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.imgvProfile.setImageResource(list.get(i).getBackgroundImgRes());
        h.binding.tvTitle.setText(list.get(i).getRoomTitle());
        h.binding.tvRecent.setText(list.get(i).getRecentChat());
        h.binding.tvCnt.setText(list.get(i).getChatCnt()+"명");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOpentalkChatVerticalBinding binding;
        public ViewHolder(@NonNull ItemOpentalkChatVerticalBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
