package com.example.woodyapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.woodyapplication.eventlistener.MsgSender;
import com.example.woodyapplication.net.AccountDto;
import com.example.woodyapplication.net.ResDt;
import com.example.woodyapplication.net.ResGroup;
import com.example.woodyapplication.net.RetrofitClient;
import com.example.woodyapplication.net.RetrofitManager;
import com.example.woodyapplication.net.RetrofitService;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * 그룹 조회 api
 */
public class GroupFindActivity extends AppCompatActivity implements MsgSender {

    private RetrofitService retrofitService;
    private RetrofitManager retrofitManager;
    private Context context;

    private TextView textViewId;
    private TextView textViewName;
    private TextView textViewState;
    private TextView textViewProjectId;
    private TextView textViewAccount;

    private List<AccountDto> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_find);
        context = GroupFindActivity.this;

        Button searchBtn = findViewById(R.id.searchBtnn);
        EditText inputId = findViewById(R.id.inputIdd);

        textViewId = findViewById(R.id.textViewId);
        textViewName = findViewById(R.id.textViewName);
        textViewState = findViewById(R.id.textViewState);
        textViewProjectId = findViewById(R.id.textViewProjectId);
        textViewAccount = findViewById(R.id.textViewAccount);

        SharedPreferences sharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXJpa2ltQG1lZ2FicmlkZ2UuY28ua3IiLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTcwOTQ0MTcxNH0.2f-IHvmn72z4x1XBWLAYdbR8f4ZtEnYwlI1OHNWyNEVYVnBxmrxRcGv7KBUm20MbOEDe3U6mv6zzWvJ1BWFu6w");

        retrofitService = RetrofitClient.createService(RetrofitService.class, token);
        retrofitManager = new RetrofitManager(retrofitService);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(String.valueOf(inputId.getText()));
                retrofitManager.getGroupInfo(id, GroupFindActivity.this);
            }
        });

        Button moreBtn = findViewById(R.id.moreBtn);
        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // AccountsFragment로 화면 전환
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                AccountsFragment fragment = new AccountsFragment();

                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("list", (ArrayList<AccountDto>) list);

                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentLayout, fragment);
                fragmentTransaction.addToBackStack(null); // 뒤로가기 동작을 위한 추가
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void sendObj(String msg, Object obj) {

        if(msg == "data"){
            ResDt<ResGroup> dt = (ResDt<ResGroup>) obj;
            ResGroup group = dt.getResult();
            textViewId.setText("ID : " + group.getId());
            textViewName.setText("Name : " + group.getName());
            textViewState.setText("State : " + group.getState());
            textViewProjectId.setText("Project ID : " + group.getProjectId());
            list =  group.getAccountDtos();
            String accounts = "";
            for (AccountDto accountDto : list) {
                accounts += accountDto.getName() + ",";
            }
            textViewAccount.setText("Account 들 : " + accounts);
        }
    }
}