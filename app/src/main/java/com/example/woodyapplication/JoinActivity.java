package com.example.woodyapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.woodyapplication.dto.User;
import com.example.woodyapplication.eventlistener.MsgSender;
import com.example.woodyapplication.net.RetrofitClient;
import com.example.woodyapplication.net.RetrofitManager;
import com.example.woodyapplication.net.RetrofitService;


public class JoinActivity extends AppCompatActivity implements MsgSender {

    private EditText join_et_email;
    private EditText join_et_pass;
    private EditText join_et_kind;
    private EditText join_et_name;
    private EditText join_et_phone;
    private EditText join_et_extraphone;
    private Button join_btn_regi;

    private RetrofitService retrofitService;
    private RetrofitManager retrofitManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        retrofitService = RetrofitClient.createService(RetrofitService.class, "");
        retrofitManager = new RetrofitManager(retrofitService);

        join_et_email = findViewById(R.id.join_et_email);
        join_et_pass = findViewById(R.id.join_et_pass);
        join_et_kind = findViewById(R.id.join_et_kind);
        join_et_name = findViewById(R.id.join_et_name);
        join_et_phone = findViewById(R.id.join_et_phone);
        join_et_extraphone = findViewById(R.id.join_et_extraphone);
        join_btn_regi = findViewById(R.id.join_btn_regi);


        join_btn_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = join_et_email.getText().toString();
                String pass = join_et_pass.getText().toString();
                int kind = Integer.parseInt(join_et_kind.getText().toString());
                String name = join_et_name.getText().toString();
                String phone = join_et_phone.getText().toString();
                String extraphone = join_et_extraphone.getText().toString();
                int accoutGroupId = 0;
                boolean verify = false;

                MsgSender msgSender = new MsgSender() {
                    @Override
                    public void sendObj(String msg, Object obj) {
                        // 1
                        Log.d("PUH", "dddd");
                    }
                };

                User user = new User(kind, email, pass, name, phone, extraphone, accoutGroupId, verify);

                retrofitManager.signUp(user, JoinActivity.this);

            }
        });
    }

    @Override
    public void sendObj(String msg, Object obj) {
        // 2
//        "signUp", "Succeed"
        if("signUp".equals(msg)){
            if("Succeed".equals(obj)){
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

