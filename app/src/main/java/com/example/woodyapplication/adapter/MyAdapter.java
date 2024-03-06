package com.example.woodyapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.woodyapplication.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    // 데이터 리스트
    private List<String> mData;

    // 생성자: 데이터 리스트를 받아옴
    public MyAdapter(List<String> data) {
        this.mData = data;
    }

    // 뷰홀더 생성
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 아이템 레이아웃을 inflate하여 새로운 뷰홀더 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    // 뷰홀더의 데이터 바인딩
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // 데이터 리스트에서 해당 position의 아이템을 가져옴
        String item = mData.get(position);
        // 뷰홀더의 텍스트뷰에 아이템을 설정하여 화면에 표시
        holder.textView.setText(item);
    }

    // 데이터 리스트의 크기 반환
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 뷰홀더 클래스
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // 아이템 레이아웃의 텍스트뷰
        private TextView textView;

        // 뷰홀더 생성자: 뷰홀더 내부의 텍스트뷰를 초기화
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view); // 레이아웃에서 텍스트뷰 ID 찾아서 설정
        }

        // 아이템 바인딩: 뷰홀더 내의 텍스트뷰에 데이터 설정
        public void bind(String item) {
            textView.setText(item);
        }
    }
}


