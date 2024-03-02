package com.example.woodyapplication.net;


import android.util.Log;

import com.example.woodyapplication.dto.User;
import com.example.woodyapplication.eventlistener.MsgSender;

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
}
