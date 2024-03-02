package com.example.woodyapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.woodyapplication.dto.AccountLoginRequestDto;
import com.example.woodyapplication.dto.User;
import com.example.woodyapplication.eventlistener.MsgSender;
import com.example.woodyapplication.net.RetrofitClient;
import com.example.woodyapplication.net.RetrofitManager;
import com.example.woodyapplication.net.RetrofitService;


public class LoginActivity extends AppCompatActivity implements MsgSender {

    private RetrofitClient retrofitClient;
    // private initMyApi initMyApi;
    private Button btn_login;
    private EditText et_id;
    private EditText et_pass;
    private String id;
    private String pass;

    private RetrofitService retrofitService;
    private RetrofitManager retrofitManager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retrofitService = RetrofitClient.createService(RetrofitService.class, "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXJpa2ltQG1lZ2FicmlkZ2UuY28ua3IiLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTcwOTQ0MTcxNH0.2f-IHvmn72z4x1XBWLAYdbR8f4ZtEnYwlI1OHNWyNEVYVnBxmrxRcGv7KBUm20MbOEDe3U6mv6zzWvJ1BWFu6w");
        retrofitManager = new RetrofitManager(retrofitService);

        et_id= findViewById(R.id.et_id);
        id = et_id.getText().toString();

        et_pass = findViewById(R.id.et_pass);
        pass = et_pass.getText().toString();

        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String id = et_id.getText().toString();
                String pw = et_pass.getText().toString();

//                User user = new User(id, pw);
                AccountLoginRequestDto user = new AccountLoginRequestDto(id, pw);
                retrofitManager.logIn(user, LoginActivity.this);

            }
        });
    }

    @Override
    public void sendObj(String msg, Object obj) {

        if(msg=="login"){
            String token = obj.toString();
            Toast.makeText(this, obj.toString(), Toast.LENGTH_SHORT).show();
            // 앱에 저장
            // SharedPreferences 저장소를 사용하겠다.
            SharedPreferences sharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE);
            // SharedPreferences 를 편집하겠다. -> 에디터를 통해서
            SharedPreferences.Editor editor = sharedPreferences.edit();
            // 저장
            editor.putString("token", token);
            editor.apply();  // 변경사항을 저장


        }

    }
}
