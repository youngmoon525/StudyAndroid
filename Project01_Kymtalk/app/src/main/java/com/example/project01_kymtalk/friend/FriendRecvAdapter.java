package com.example.project01_kymtalk.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kymtalk.databinding.ItemFriendRecvBinding;

public class FriendRecvAdapter extends RecyclerView.Adapter<FriendRecvAdapter.ViewHolder> {

    LayoutInflater inflater;//parent를 이용해서 초기화 하는 방법 나중에.

    public FriendRecvAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFriendRecvBinding binding = ItemFriendRecvBinding.inflate(inflater , parent , false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    //1.ViewHolder( view )-> Binding을 사용해보기
    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemFriendRecvBinding binding;//모든 위젯 종류를 씀.(사용할거)
        public ViewHolder(@NonNull ItemFriendRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
