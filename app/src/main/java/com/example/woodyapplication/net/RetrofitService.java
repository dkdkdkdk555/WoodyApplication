package com.example.woodyapplication.net;

import com.example.woodyapplication.dto.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @POST("/api/v1/account")
    Call<ResDt> requestSingUp(@Body User user); // post방식

}
