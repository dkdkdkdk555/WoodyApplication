package com.example.woodyapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.woodyapplication.adapter.MyAccountsAdapter;
import com.example.woodyapplication.adapter.MyAdapter;
import com.example.woodyapplication.net.AccountDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsFragment extends Fragment {

    private RecyclerView recyclerView;  // RecyclerView 변수 선언
    private MyAccountsAdapter adapter;  // Adapter 변수 선언
    private List<Map<String, String>> dataList = new ArrayList<>();  // 데이터를 담을 List 선언

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Fragment의 레이아웃을 inflate하여 View 객체 생성
        View view = inflater.inflate(R.layout.fragment_accounts_layout, container, false);

        // RecyclerView 초기화: fragment_accounts_layout.xml에서 정의한 RecyclerView 찾아서 연결
        recyclerView = view.findViewById(R.id.recycler_v);

        // Adapter 초기화: dataList를 가지고 있는 Adapter 생성
        adapter = new MyAccountsAdapter(dataList);

        // RecyclerView에 LayoutManager 설정: LinearLayoutManager 사용 (수직 스크롤)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);

        // RecyclerView에 Adapter 설정
        recyclerView.setAdapter(adapter);

        // Arguments에서 데이터 가져와서 표시
        Bundle args = getArguments();  // Fragment로 전달된 데이터를 담은 Bundle
        if (args != null) {
            // "list" 키로 ParcelableArrayList인 List<AccountDto>를 가져옴
            List<AccountDto> accounts = args.getParcelableArrayList("list");
            if (accounts != null) {
                for (AccountDto account : accounts) {
                    // 각 AccountDto를 Map에 이름과 이메일로 매핑하여 dataList에 추가
                    Map<String, String> map = new HashMap<>();
                    map.put("name", account.getName());
                    map.put("email", account.getEmail());
                    dataList.add(map);
                }
            }
        }

        // RecyclerView에 데이터 변경을 알림 (새로 추가된 데이터 표시)
        adapter.notifyDataSetChanged();

        // 생성된 View 반환
        return view;
    }
}
