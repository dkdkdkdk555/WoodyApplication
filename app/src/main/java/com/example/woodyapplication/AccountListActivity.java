package com.example.woodyapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.woodyapplication.adapter.MyAdapter;
import com.example.woodyapplication.eventlistener.MsgSender;
import com.example.woodyapplication.net.AccountDto;
import com.example.woodyapplication.net.ResGroup;
import com.example.woodyapplication.net.RetrofitClient;
import com.example.woodyapplication.net.RetrofitManager;
import com.example.woodyapplication.net.RetrofitService;

import java.util.ArrayList;
import java.util.List;

/**
 * 회원 리스트 조회
 */
public class AccountListActivity extends AppCompatActivity implements MsgSender {

    private RetrofitService retrofitService;  // Retrofit 서비스
    private RetrofitManager retrofitManager;  // Retrofit 매니저
    private Context context;  // 액티비티 컨텍스트

    private RecyclerView recyclerView;  // RecyclerView 변수
    private MyAdapter adapter;  // RecyclerView Adapter
    private List<String> dataList = new ArrayList<>();  // RecyclerView에 표시할 데이터 리스트

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list);  // 레이아웃 설정
        context = AccountListActivity.this;  // 컨텍스트 설정

        // Adapter 초기화
        adapter = new MyAdapter(dataList);

        // RecyclerView 초기화
        recyclerView = findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // SharedPreferences를 사용하여 토큰 가져오기
        SharedPreferences sharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "default_token_value");

        // RetrofitService 및 RetrofitManager 초기화
        retrofitService = RetrofitClient.createService(RetrofitService.class, token);
        retrofitManager = new RetrofitManager(retrofitService);

        // 요청 버튼 클릭 리스너 설정
        Button btn = findViewById(R.id.requestButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // RetrofitManager를 사용하여 계정 목록 요청
                retrofitManager.getAcountList(AccountListActivity.this);
            }
        });
    }

    @Override
    public void sendObj(String msg, Object obj) {
        if (msg.equals("list")) {  // 메시지가 "list"인 경우
            // Object를 List<AccountDto>로 캐스팅
            List<AccountDto> list = (List<AccountDto>) obj;

            // RecyclerView에 표시할 데이터 리스트에 추가
            for (AccountDto accountDto : list) {
                dataList.add(accountDto.getName());
            }

            // 변경된 데이터를 알림
            adapter.notifyDataSetChanged();
        }
    }
}

