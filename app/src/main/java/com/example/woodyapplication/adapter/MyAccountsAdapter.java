package com.example.woodyapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.woodyapplication.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;

public class MyAccountsAdapter extends RecyclerView.Adapter<MyAccountsAdapter.MyViewHolder> {

    private List<Map<String, String>> mData;

    public MyAccountsAdapter(List<Map<String, String>> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Map<String, String> item = mData.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameItem);
            email = itemView.findViewById(R.id.emailItem);

        }

        public void bind(Map<String, String> item) {
            name.setText(item.get("name"));
            email.setText(item.get("email"));
        }
    }
}

