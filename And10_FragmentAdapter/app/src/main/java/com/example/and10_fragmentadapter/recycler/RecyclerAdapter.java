package com.example.and10_fragmentadapter.recycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and10_fragmentadapter.R;
import com.example.and10_fragmentadapter.listv.ListDTO;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.KymViewHoler> {

    //onCreateViewHolder : 내가 만들어둔 ViewHolder를 직접 만들어서 return을 해줌.
    //1회성으로 생성이 완료 되면 다시 메소드를 실행 x
    // ※LayoutInflater가 필요하다.※
    LayoutInflater inflater;
    ArrayList<ListDTO> list;

    public RecyclerAdapter(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public KymViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("리사이클러뷰", "onCreateViewHolder: ");
        View v = inflater.inflate(R.layout.item_listv , parent , false );
        KymViewHoler holer = new KymViewHoler(v);
        return holer;
    }

    //onBindViewHolder : onCreateViweHolder에서 만들어둔 ViewHolder를 다시 우리한테 줌. ( 데이터 바인딩 처리 )
    @Override
    public void onBindViewHolder(@NonNull KymViewHoler h, int i) {
        Log.d("리사이클러뷰", "onBindViewHolder: ");
        h.imgv_profile.setImageResource( list.get(i).getImgRes() );
        h.tv_name.setText( list.get(i).getName() );
        h.tv_gender.setText( list.get(i).getGender() );
        h.tv_age.setText( list.get(i).getAge()+"" );
    }



    // 몇개의 칸이 필요한지를 써주는 구간. : list.size()
    @Override
    public int getItemCount() {
        return list.size();
    }

    //1.ViewHolder라는 클래스를 내부에 만들어준다. ( 뷰들을 묶어놓기 위한 DTO )
    //  extends ViewHolder를 해줌.
    //  View itemview : View v = LayoutInflater.inflate(...);
    public class KymViewHoler extends RecyclerView.ViewHolder {
        ImageView imgv_profile;
        TextView tv_name , tv_gender , tv_age;
        public KymViewHoler(@NonNull View v) {
            super(v);
            imgv_profile = v.findViewById(R.id.imgv_profile);
            tv_name = v.findViewById(R.id.tv_name);
            tv_gender = v.findViewById(R.id.tv_gender);
            tv_age = v.findViewById(R.id.tv_age);
        }
    }

}
