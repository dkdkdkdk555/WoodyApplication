package com.example.woodyapplication.net;


import android.util.Log;

import com.example.woodyapplication.dto.AccountLoginRequestDto;
import com.example.woodyapplication.dto.User;
import com.example.woodyapplication.eventlistener.MsgSender;
import com.google.gson.Gson;

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

        Call<ResDt> call = retrofitService.requestLogin(user);

        call.enqueue( new Callback<ResDt>() {
            @Override
            public void onResponse(Call<ResDt> call, Response<ResDt> response) {
                Log.d("PUH", response.body().getResult().toString());
                msgSender.sendObj("login", response.body().getResult().token);
            }

            @Override
            public void onFailure(Call<ResDt> call, Throwable t) {
                Log.d("PUH","ffff");

            }
        } );
    }

}
