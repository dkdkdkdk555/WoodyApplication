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
import com.example.woodyapplication.net.ProjectResponseDto;
import com.example.woodyapplication.net.ResDt;
import com.example.woodyapplication.net.ResGroup;
import com.example.woodyapplication.net.RetrofitClient;
import com.example.woodyapplication.net.RetrofitManager;
import com.example.woodyapplication.net.RetrofitService;

import org.w3c.dom.Text;

import java.util.List;

/**
 * 프로젝트 조회 api
 */
public class ProFindActivity extends AppCompatActivity implements MsgSender {

    private RetrofitService retrofitService;
    private RetrofitManager retrofitManager;
    private Context context;

    private TextView textViewId;
    private TextView textViewName;
    private TextView textViewState;
    private TextView Description;
    private TextView groups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_find);
        context = ProFindActivity.this;

        Button searchBtn = findViewById(R.id.searchPBtn);
        EditText inputId = findViewById(R.id.inputProjectId);

        textViewId = findViewById(R.id.textId);
        textViewName = findViewById(R.id.textName);
        textViewState = findViewById(R.id.textState);
        Description = findViewById(R.id.textDescription);
        groups = findViewById(R.id.textAccountGroupDtos);

        SharedPreferences sharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXJpa2ltQG1lZ2FicmlkZ2UuY28ua3IiLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTcwOTQ0MTcxNH0.2f-IHvmn72z4x1XBWLAYdbR8f4ZtEnYwlI1OHNWyNEVYVnBxmrxRcGv7KBUm20MbOEDe3U6mv6zzWvJ1BWFu6w");

        retrofitService = RetrofitClient.createService(RetrofitService.class, token);
        retrofitManager = new RetrofitManager(retrofitService);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(String.valueOf(inputId.getText()));
                retrofitManager.getProjectInfo(id, ProFindActivity.this);
            }
        });

    }

    @Override
    public void sendObj(String msg, Object obj) {

        if(msg == "data"){
            ProjectResponseDto dto = (ProjectResponseDto) obj;

            textViewId.setText("ID: " + dto.getId());
            textViewName.setText("Name: " + dto.getName());
            textViewState.setText("State: " + dto.getState());
            Description.setText("Description:" + dto.getDescription());
            List<ResGroup> list = dto.getGroup();
            String Strgroups = "";
            if(list != null) {
                for (ResGroup resGroup : list) {
                    Strgroups += resGroup.getName() + "|";
                }
            }
            groups.setText("accountGroupDtos: "+  Strgroups);
        }
    }
}