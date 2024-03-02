package com.example.woodyapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn_join;
    private Button btn_login;

    private  Button btn_find;
    private Button btn_list;
    private Button btn_group_regi;

    private Button btn_group_find;

    private Button btn_group_list;

    private Button btn_group_map;

    private Button btn_group_del;

    private Button btn_pro_regi;

    private Button btn_pro_find;

    private Button btn_pro_list;

    private Button btn_pro_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_join=findViewById(R.id.btn_join);
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,JoinActivity.class);
                startActivity(intent);
            }
        });

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_find = findViewById(R.id.btn_find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FindActivity.class);
                startActivity(intent);
            }
        });
        btn_list = findViewById(R.id.btn_list);
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        btn_group_regi = findViewById(R.id.btn_group_regi);
        btn_group_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GroupRegiActivity.class);
                startActivity(intent);
            }
        });

        btn_group_find = findViewById(R.id.btn_group_find);
        btn_group_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GroupFindActivity.class);
                startActivity(intent);
            }
        });

        btn_group_list = findViewById(R.id.btn_group_list);
        btn_group_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GroupListActivity.class);
                startActivity(intent);
            }
        });

        btn_group_map = findViewById(R.id.btn_group_map);
        btn_group_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GroupMappingActivity.class);
                startActivity(intent);
            }
        });

        btn_group_del = findViewById(R.id.btn_group_del);
        btn_group_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GroupDelActivity.class);
                startActivity(intent);
            }
        });

        btn_pro_regi = findViewById(R.id.btn_pro_regi);
        btn_pro_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProRegiActivity.class);
                startActivity(intent);
            }
        });

        btn_pro_find = findViewById(R.id.btn_pro_find);
        btn_pro_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProFindActivity.class);
                startActivity(intent);
            }
        });

        btn_pro_list = findViewById(R.id.btn_pro_list);
        btn_pro_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProListActivity.class);
                startActivity(intent);
            }
        });

        btn_pro_map = findViewById(R.id.btn_pro_map);
        btn_pro_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProMapActivity.class);
                startActivity(intent);
            }
        });






    }
}