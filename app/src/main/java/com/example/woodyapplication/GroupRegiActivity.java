package com.example.woodyapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.woodyapplication.eventlistener.MsgSender;
import com.example.woodyapplication.net.AccountGroupSaveRequestDto;
import com.example.woodyapplication.net.RequestDto;
import com.example.woodyapplication.net.RetrofitClient;
import com.example.woodyapplication.net.RetrofitManager;
import com.example.woodyapplication.net.RetrofitService;

/**
 * 그룹 등록
 */
public class GroupRegiActivity extends AppCompatActivity implements MsgSender {

    private RetrofitService retrofitService;
    private RetrofitManager retrofitManager;
    private Context context;

    private EditText nameInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_regi);
        context = GroupRegiActivity.this;

        nameInput = findViewById(R.id.nameInput);

        SharedPreferences sharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXJpa2ltQG1lZ2FicmlkZ2UuY28ua3IiLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTcwOTQ0MTcxNH0.2f-IHvmn72z4x1XBWLAYdbR8f4ZtEnYwlI1OHNWyNEVYVnBxmrxRcGv7KBUm20MbOEDe3U6mv6zzWvJ1BWFu6w");

        retrofitService = RetrofitClient.createService(RetrofitService.class, token);
        retrofitManager = new RetrofitManager(retrofitService);

        Button btn = findViewById(R.id.btnPut);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = String.valueOf(nameInput.getText());
                RequestDto dto = new RequestDto();
                dto.setName(name);
                dto.setDescription("설명설명설명");
                dto.setProjectId(4);
                retrofitManager.createAccountGroup(dto, GroupRegiActivity.this);
            }
        });

    }

    @Override
    public void sendObj(String msg, Object obj) {

    }
}