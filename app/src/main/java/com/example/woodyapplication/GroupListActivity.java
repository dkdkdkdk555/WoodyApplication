package com.example.woodyapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.woodyapplication.eventlistener.MsgSender;
import com.example.woodyapplication.net.ResGroup;
import com.example.woodyapplication.net.RetrofitClient;
import com.example.woodyapplication.net.RetrofitManager;
import com.example.woodyapplication.net.RetrofitService;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.woodyapplication.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class GroupListActivity extends AppCompatActivity implements MsgSender {

    private RetrofitService retrofitService;
    private RetrofitManager retrofitManager;
    private Context context;

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);
        context = GroupListActivity.this;

        adapter = new MyAdapter(dataList);
        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        SharedPreferences sharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXJpa2ltQG1lZ2FicmlkZ2UuY28ua3IiLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTcwOTQ0MTcxNH0.2f-IHvmn72z4x1XBWLAYdbR8f4ZtEnYwlI1OHNWyNEVYVnBxmrxRcGv7KBUm20MbOEDe3U6mv6zzWvJ1BWFu6w");


        retrofitService = RetrofitClient.createService(RetrofitService.class, token);
        retrofitManager = new RetrofitManager(retrofitService);

        Button btn = findViewById(R.id.requestBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofitManager.getGroupList(GroupListActivity.this);
            }
        });
    }

    @Override
    public void sendObj(String msg, Object obj) {

        if(msg=="list"){
            List<ResGroup> list = (List<ResGroup>) obj;


            for (ResGroup resGroup : list) {
                dataList.add(resGroup.getName());
            }


            // 변경된 데이터를 알림
            adapter.notifyDataSetChanged();
        }
    }
}