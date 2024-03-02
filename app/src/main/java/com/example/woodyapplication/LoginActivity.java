package com.example.woodyapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retrofitService = RetrofitClient.createService(RetrofitService.class, "");
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

                User user = new User(id, pw);

                retrofitManager.logIn(user, LoginActivity.this);

            }
        });
    }

    @Override
    public void sendObj(String msg, Object obj) {


    }
}
