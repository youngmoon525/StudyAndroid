package com.example.project01_kymtalk.friend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kymtalk.R;
import com.example.project01_kymtalk.databinding.FragmentFriendBinding;

import java.util.ArrayList;

public class FriendFragment extends Fragment {
    FragmentFriendBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFriendBinding.inflate(inflater , container , false);

        binding.recvFriend.setAdapter(new FriendRecvAdapter(inflater , getFriendList() , getContext() ));
        binding.recvFriend.setLayoutManager(new LinearLayoutManager(getContext()));


        return binding.getRoot();
    }

    ArrayList<FriendDTO> getFriendList(){
        ArrayList<FriendDTO> list = new ArrayList<>();
        list.add(new FriendDTO(R.drawable.friend_profile_img1 , R.drawable.friend_back_img1 , "김이름" , "🌮허허"));
        list.add(new FriendDTO(R.drawable.friend_profile_img2 , R.drawable.friend_back_img2 , "이민준" , "삶이 있는 한 희망은 있다"));
        list.add(new FriendDTO(R.drawable.friend_profile_img3 , R.drawable.friend_back_img3 , "김서준" , ""));
        list.add(new FriendDTO(R.drawable.friend_profile_img4 , R.drawable.friend_back_img4 , "강도윤" , "😂언제나 현재에 집중할수 있다면 행복할것이다"));
        list.add(new FriendDTO(R.drawable.friend_profile_img5 , R.drawable.friend_back_img5 , "이예준" , ""));
        list.add(new FriendDTO(R.drawable.friend_profile_img6 , R.drawable.friend_back_img6 , "박지호" , "피할수 없으면 즐겨라"));
        list.add(new FriendDTO(R.drawable.friend_profile_img7 , R.drawable.friend_back_img7 , "김시우" , "내일은 내일의 태양이 뜬다"));
        list.add(new FriendDTO(R.drawable.friend_profile_img8 , R.drawable.friend_back_img8 , "장지호" , "🎃계단을 밟아야 계단 위에 올라설수 있다, -"));
        list.add(new FriendDTO(R.drawable.friend_profile_img9 , R.drawable.friend_back_img9 , "박하늘별님구름햇님보다사랑스러우리" , ""));
        list.add(new FriendDTO(R.drawable.friend_profile_img10 , R.drawable.friend_back_img10, "배준우" , "🎭행복은 습관이다,그것을 몸에 지니라"));
        list.add(new FriendDTO(R.drawable.friend_profile_img1 , R.drawable.friend_back_img1 , "김이름" , "🌮허허"));
        list.add(new FriendDTO(R.drawable.friend_profile_img2 , R.drawable.friend_back_img2 , "이민준" , "삶이 있는 한 희망은 있다"));
        list.add(new FriendDTO(R.drawable.friend_profile_img3 , R.drawable.friend_back_img3 , "김서준" , ""));
        list.add(new FriendDTO(R.drawable.friend_profile_img4 , R.drawable.friend_back_img4 , "강도윤" , "😂언제나 현재에 집중할수 있다면 행복할것이다"));
        list.add(new FriendDTO(R.drawable.friend_profile_img5 , R.drawable.friend_back_img5 , "이예준" , ""));
        list.add(new FriendDTO(R.drawable.friend_profile_img6 , R.drawable.friend_back_img6 , "박지호" , "피할수 없으면 즐겨라"));
        list.add(new FriendDTO(R.drawable.friend_profile_img7 , R.drawable.friend_back_img7 , "김시우" , "내일은 내일의 태양이 뜬다"));
        list.add(new FriendDTO(R.drawable.friend_profile_img8 , R.drawable.friend_back_img8 , "장지호" , "🎃계단을 밟아야 계단 위에 올라설수 있다, -"));
        list.add(new FriendDTO(R.drawable.friend_profile_img9 , R.drawable.friend_back_img9 , "박하늘별님구름햇님보다사랑스러우리" , ""));
        list.add(new FriendDTO(R.drawable.friend_profile_img10 , R.drawable.friend_back_img10, "배준우" , "🎭행복은 습관이다,그것을 몸에 지니라"));
        binding.tvFriendCnt.setText("친구 " + list.size());
        //window + . : 이모지 단축키
        return list;
    }


}