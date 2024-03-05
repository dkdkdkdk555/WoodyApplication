package com.example.woodyapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.woodyapplication.eventlistener.MsgSender;
import com.example.woodyapplication.net.AccountGroupSaveRequestDto;
import com.example.woodyapplication.net.RequestDto;
import com.example.woodyapplication.net.ResGroup;
import com.example.woodyapplication.net.RetrofitClient;
import com.example.woodyapplication.net.RetrofitManager;
import com.example.woodyapplication.net.RetrofitService;

public class GroupDelActivity extends AppCompatActivity implements MsgSender {

    private RetrofitService retrofitService;
    private RetrofitManager retrofitManager;
    private Context context;

    private EditText idd;
    private EditText state;
    private EditText name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_del);
        context = GroupDelActivity.this;

        idd = findViewById(R.id.getId);
        state = findViewById(R.id.getState);
        name = findViewById(R.id.getName);

        SharedPreferences sharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXJpa2ltQG1lZ2FicmlkZ2UuY28ua3IiLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTcwOTQ0MTcxNH0.2f-IHvmn72z4x1XBWLAYdbR8f4ZtEnYwlI1OHNWyNEVYVnBxmrxRcGv7KBUm20MbOEDe3U6mv6zzWvJ1BWFu6w");

        retrofitService = RetrofitClient.createService(RetrofitService.class, token);
        retrofitManager = new RetrofitManager(retrofitService);

        Button btn = findViewById(R.id.btnDelete);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(String.valueOf(idd.getText()));
                String stateV = String.valueOf(state.getText());
                String nameV = String.valueOf(name.getText());

                RequestDto requestDto = new RequestDto();
//                res.setId(id);
//                if(stateV != null || stateV != "") res.setState(Integer.parseInt(stateV));
                if(nameV != null || nameV != "") requestDto.setName(nameV);

                retrofitManager.deleteAccountGroup(id, requestDto, GroupDelActivity.this);
            }
        });


    }

    @Override
    public void sendObj(String msg, Object obj) {

    }
}
