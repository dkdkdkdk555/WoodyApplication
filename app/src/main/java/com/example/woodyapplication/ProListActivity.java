package com.example.woodyapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.woodyapplication.adapter.MyAdapter;
import com.example.woodyapplication.eventlistener.MsgSender;
import com.example.woodyapplication.net.AccountDto;
import com.example.woodyapplication.net.ProjectResponseDto;
import com.example.woodyapplication.net.RetrofitClient;
import com.example.woodyapplication.net.RetrofitManager;
import com.example.woodyapplication.net.RetrofitService;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로젝트 리스트
 */
public class ProListActivity extends AppCompatActivity implements MsgSender {

    private RetrofitService retrofitService;
    private RetrofitManager retrofitManager;
    private Context context;

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_list);
        context = ProListActivity.this;

        adapter = new MyAdapter(dataList);
        recyclerView = findViewById(R.id.recyclerr);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        SharedPreferences sharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXJpa2ltQG1lZ2FicmlkZ2UuY28ua3IiLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTcwOTQ0MTcxNH0.2f-IHvmn72z4x1XBWLAYdbR8f4ZtEnYwlI1OHNWyNEVYVnBxmrxRcGv7KBUm20MbOEDe3U6mv6zzWvJ1BWFu6w");

        retrofitService = RetrofitClient.createService(RetrofitService.class, token);
        retrofitManager = new RetrofitManager(retrofitService);

        Button btn = findViewById(R.id.requestBts);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofitManager.getProjectList(ProListActivity.this);
            }
        });
    }

    @Override
    public void sendObj(String msg, Object obj) {
        if(msg=="list"){
            List<ProjectResponseDto> list = (List<ProjectResponseDto>) obj;

            for (ProjectResponseDto dto : list) {
                dataList.add(dto.getName());
            }

            // 변경된 데이터를 알림
            adapter.notifyDataSetChanged();
        }
    }
}