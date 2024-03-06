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

    private RecyclerView recyclerView;
    private MyAccountsAdapter adapter;
    private List<Map<String, String>> dataList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accounts_layout, container, false);
        recyclerView = view.findViewById(R.id.recycler_v);
        adapter = new MyAccountsAdapter(dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // Arguments에서 데이터를 가져와서 표시
        Bundle args = getArguments();
        if (args != null) {
            List<AccountDto> accounts = args.getParcelableArrayList("list");
            if (accounts != null) {
                for (AccountDto account : accounts) {
                    Map<String, String> map = new HashMap<>();
                    map.put("name", account.getName());
                    map.put("email",account.getEmail());

                    dataList.add(map);
                }
            }
        }
        // RecyclerView에 데이터가 변경되었음을 알림
        adapter.notifyDataSetChanged();

        return view;
    }
}