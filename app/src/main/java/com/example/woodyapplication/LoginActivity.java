package com.example.woodyapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.woodyapplication.net.RetrofitClient;


public class LoginActivity extends AppCompatActivity {

    private RetrofitClient retrofitClient;
    // private initMyApi initMyApi;
    private Button btn_login;
    private EditText et_id;
    private EditText et_pass;
    private String id;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

                // hideKeyboard();

                //로그인 정보 미입력 시
//                if (id.trim().length() == 0 || pw.trim().length() == 0 || id == null || pw == null) {
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                    builder.setTitle("알림")
//                            .setMessage("로그인 정보를 입력바랍니다.")
//                            .setPositiveButton("확인", null)
//                            .create()
//                            .show();
//                    AlertDialog alertDialog = builder.create();
//                    alertDialog.show();
//
//                } else {
//                    //로그인 통신
//                 //   LoginResponse();
//                }
            }
        });
    }

}
