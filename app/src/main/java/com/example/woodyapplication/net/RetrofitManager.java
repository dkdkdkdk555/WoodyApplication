package com.example.woodyapplication.net;


import android.util.Log;
import android.widget.TextView;

import com.example.woodyapplication.dto.AccountLoginRequestDto;
import com.example.woodyapplication.dto.User;
import com.example.woodyapplication.eventlistener.MsgSender;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitManager {

    private RetrofitService retrofitService;

    public RetrofitManager(RetrofitService _retrofitService){
        retrofitService = _retrofitService;
    }

    public void signUp(User user, MsgSender msgSender){

        Call<ResDt> call = retrofitService.requestSingUp(user);

        call.enqueue( new Callback<ResDt>() {
            @Override
            public void onResponse(Call<ResDt> call, Response<ResDt> response) {
//                if(response.code() == 200)
                    msgSender.sendObj("signUp", "Succeed");
            }

            @Override
            public void onFailure(Call<ResDt> call, Throwable t) {
                Log.d("PUH","onFailure");
            }
        } );
    }

    public void logIn(AccountLoginRequestDto user, MsgSender msgSender){

        Call<ResDt<ResultT>> call = retrofitService.requestLogin(user);

        call.enqueue( new Callback<ResDt<ResultT>>() {
            @Override
            public void onResponse(Call<ResDt<ResultT>> call, Response<ResDt<ResultT>> response) {
                Log.d("PUH", response.body().getResult().toString());
                msgSender.sendObj("login", response.body().getResult().token);
            }

            @Override
            public void onFailure(Call<ResDt<ResultT>> call, Throwable t) {
                Log.d("PUH","ffff");

            }
        } );
    }

    // 그룹 리스트
    public void getGroupList(MsgSender msgSender){

        Call<ResDt<List<ResGroup>>> call = retrofitService.requestGroupList();

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<ResDt<List<ResGroup>>>() {
            @Override
            public void onResponse(Call<ResDt<List<ResGroup>>> call, Response<ResDt<List<ResGroup>>> response) {
                Log.d("PUH", response.body().getResult().toString());
                msgSender.sendObj("list", response.body().getResult());
            }

            @Override
            public void onFailure(Call<ResDt<List<ResGroup>>> call, Throwable t) {
                Log.d("PUH","onFailure");
            }
        } );
    }

    // 회원 정보 조회
    public void getAcountInfo(int id, MsgSender msgSender){

        Call<ResDt<AccountDto>> call = retrofitService.requestAccoutInfo(id);

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<ResDt<AccountDto>>() {
            @Override
            public void onResponse(Call<ResDt<AccountDto>> call, Response<ResDt<AccountDto>> response) {
                Log.d("PUH", response.body().toString());
                msgSender.sendObj("data", response.body());
            }

            @Override
            public void onFailure(Call<ResDt<AccountDto>> call, Throwable t) {
                Log.d("PUH","onFailure");
            }
        } );
    }

    // 회원 리스트
    public void getAcountList(MsgSender msgSender){

        Call<ResDt<List<AccountDto>>> call = retrofitService.requestAccountList();

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<ResDt<List<AccountDto>>>() {
            @Override
            public void onResponse(Call<ResDt<List<AccountDto>>> call, Response<ResDt<List<AccountDto>>> response) {
                Log.d("PUH", response.body().toString());
                msgSender.sendObj("list", response.body().getResult());
            }

            @Override
            public void onFailure(Call<ResDt<List<AccountDto>>> call, Throwable t) {
                Log.d("PUH","onFailure");
            }
        } );
    }

    // 그룹 생성
    private void createAccountGroup(AccountGroupSaveRequestDto requestDto) {

        Call<Void> call = retrofitService.createAccountGroup(requestDto);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // 성공적으로 처리됨
                    Log.d("MainActivity", "Account group created successfully");
                } else {
                    // 서버가 다른 상태 코드로 응답한 경우 처리
                    Log.e("MainActivity", "Failed to create account group, error code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // 네트워크 오류 또는 요청 실패
                Log.e("MainActivity", "Failed to create account group", t);
            }
        });
    }

    // 그룹 삭제
    public void deleteAccountGroup(int id, AccountGroupSaveRequestDto requestDto, MsgSender msgSender) {

        Call<ResDt<Object>> call = retrofitService.deleteGroup(id, requestDto);
        call.enqueue(new Callback<ResDt<Object>>() {
            @Override
            public void onResponse(Call<ResDt<Object>> call, Response<ResDt<Object>> response) {
                if (response.isSuccessful()) {
                    // 성공적으로 처리됨
                    Log.e("PUH", response.body().toString());
                } else {
                    // 서버가 다른 상태 코드로 응답한 경우 처리
                    Log.e("MainActivity", "Failed to create account group, error code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResDt<Object>> call, Throwable t) {
                // 네트워크 오류 또는 요청 실패
                Log.e("MainActivity", "Failed to create account group", t);
            }
        });
    }

    // 그룹 조회
    public void getGroupInfo(int id, MsgSender msgSender){

        Call<ResDt<ResGroup>> call = retrofitService.requestGroupInfo(id);

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<ResDt<ResGroup>>() {
            @Override
            public void onResponse(Call<ResDt<ResGroup>> call, Response<ResDt<ResGroup>> response) {
                Log.d("PUH", response.body().toString());
                msgSender.sendObj("data", response.body());
            }

            @Override
            public void onFailure(Call<ResDt<ResGroup>> call, Throwable t) {
                Log.d("PUH","onFailure");
            }
        } );
    }

    // 프로젝트 생성
    private void createProject(ProjectRequestDto projectRequestDto) {

        Call<Void> call = retrofitService.createProject(projectRequestDto);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // 성공적으로 처리됨
                    Log.d("MainActivity", "Account group created successfully");
                } else {
                    // 서버가 다른 상태 코드로 응답한 경우 처리
                    Log.e("MainActivity", "Failed to create account group, error code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // 네트워크 오류 또는 요청 실패
                Log.e("MainActivity", "Failed to create account group", t);
            }
        });
    }

    // 프로젝트 조회
    public void getProjectInfo(int id, MsgSender msgSender){

        Call<ResDt<ProjectResponseDto>> call = retrofitService.requestProjectInfo(id);

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<ResDt<ProjectResponseDto>>() {
            @Override
            public void onResponse(Call<ResDt<ProjectResponseDto>> call, Response<ResDt<ProjectResponseDto>> response) {
                Log.d("PUH", response.body().toString());
                msgSender.sendObj("data", response.body().getResult());
            }

            @Override
            public void onFailure(Call<ResDt<ProjectResponseDto>> call, Throwable t) {
                Log.d("PUH","onFailure");
            }
        } );
    }

    // 프로젝트 리스트
    public void getProjectList(MsgSender msgSender){

        Call<ResDt<List<ProjectResponseDto>>> call = retrofitService.requestProjectList();

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<ResDt<List<ProjectResponseDto>>>() {
            @Override
            public void onResponse(Call<ResDt<List<ProjectResponseDto>>> call, Response<ResDt<List<ProjectResponseDto>>> response) {
                Log.d("PUH", response.body().toString());
                msgSender.sendObj("list", response.body().getResult());
            }

            @Override
            public void onFailure(Call<ResDt<List<ProjectResponseDto>>> call, Throwable t) {
                Log.d("PUH","onFailure");
            }
        } );
    }
}
