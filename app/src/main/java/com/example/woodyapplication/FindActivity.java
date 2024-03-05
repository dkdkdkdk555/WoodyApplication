package com.example.woodyapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.woodyapplication.eventlistener.MsgSender;
import com.example.woodyapplication.net.AccountDto;
import com.example.woodyapplication.net.ResDt;
import com.example.woodyapplication.net.RetrofitClient;
import com.example.woodyapplication.net.RetrofitManager;
import com.example.woodyapplication.net.RetrofitService;

/**
 * 회원 조회 api
 */
public class FindActivity extends AppCompatActivity implements MsgSender {

    private RetrofitService retrofitService;
    private RetrofitManager retrofitManager;
    private Context context;

    private TextView textViewId;
    private TextView textViewCreatedDate;
    private TextView textViewKind;
    private TextView textViewState;
    private TextView textViewEmail;
    private TextView textViewName;
    private TextView textViewPhoneNumber;
    private TextView textViewExtraPhoneNumber;
    private TextView textViewTermsAgreed;
    private TextView textViewVerify;
    private TextView textViewAffiliation;
    private TextView textViewImages;
    private TextView textViewAccountGroupId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        context = FindActivity.this;

        Button searchBtn = findViewById(R.id.searchBtn);
        EditText inputId = findViewById(R.id.inputId);
        textViewId = findViewById(R.id.textViewId);
        textViewCreatedDate = findViewById(R.id.textViewCreatedDate);
        textViewKind = findViewById(R.id.textViewKind);
        textViewState = findViewById(R.id.textViewState);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewName = findViewById(R.id.textViewName);
        textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);
        textViewExtraPhoneNumber = findViewById(R.id.textViewExtraPhoneNumber);
        textViewTermsAgreed = findViewById(R.id.textViewTermsAgreed);
        textViewVerify = findViewById(R.id.textViewVerify);
        textViewAffiliation = findViewById(R.id.textViewAffiliation);
        textViewImages = findViewById(R.id.textViewImages);
        textViewAccountGroupId = findViewById(R.id.textViewAccountGroupId);

        SharedPreferences sharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXJpa2ltQG1lZ2FicmlkZ2UuY28ua3IiLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTcwOTQ0MTcxNH0.2f-IHvmn72z4x1XBWLAYdbR8f4ZtEnYwlI1OHNWyNEVYVnBxmrxRcGv7KBUm20MbOEDe3U6mv6zzWvJ1BWFu6w");

        retrofitService = RetrofitClient.createService(RetrofitService.class, token);
        retrofitManager = new RetrofitManager(retrofitService);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(String.valueOf(inputId.getText()));
                retrofitManager.getAcountInfo(id, FindActivity.this);
            }
        });


    }

    @Override
    public void sendObj(String msg, Object obj) {

        if(msg=="data"){
            ResDt<AccountDto> dt = (ResDt<AccountDto>) obj;
            AccountDto dto = dt.getResult();
            textViewId.setText("ID: " + dto.getId());
            textViewCreatedDate.setText("Created Date: " + dto.getCreateDate());
            textViewKind.setText("Kind: " + dto.getKind());
            textViewState.setText("State: " + dto.getState());
            textViewEmail.setText("Email: " + dto.getEmail());
            textViewName.setText("Name: " + dto.getName());
            textViewPhoneNumber.setText("Phone Number: " + dto.getPhoneNumber());
            textViewExtraPhoneNumber.setText("Extra Phone Number: " + dto.getExtraPhoneNumber());
            textViewTermsAgreed.setText("Terms Agreed: " + dto.getTermsAgreed());
            textViewVerify.setText("Verify: " + dto.isVerify());
            textViewAffiliation.setText("Affiliation: " + dto.getAffiliation());
            textViewImages.setText("Images: " + dto.getImages().toString());
            textViewAccountGroupId.setText("Account Group Id: " + dto.getAccountGroupId());
        }
    }
}