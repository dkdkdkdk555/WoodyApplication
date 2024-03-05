package com.example.woodyapplication.net;

import android.accounts.Account;

import com.example.woodyapplication.dto.AccountLoginRequestDto;
import com.example.woodyapplication.dto.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @POST("/api/v1/account")
    Call<ResDt> requestSingUp(@Body User user); // post방식

    // 로그인 (jwt 토큰 발급)
    @POST("/api/v1/authenticates")
    Call<ResDt<ResultT>> requestLogin(@Body AccountLoginRequestDto accountLoginRequestDto);

    // 회원 정보 조회
    @GET("/api/v1/account/{id}")
    Call<ResDt<AccountDto>> requestAccoutInfo(@Path("id")int id);

    // 회원 list
    @GET("/api/v1/account/list")
    Call<ResDt<List<AccountDto>>> requestAccountList();

    // 그룹 등록
    @POST("/api/v1/accountgroup")
    Call<Void> createAccountGroup(@Body RequestDto requestDto);

    // 그룹 list
    @GET("/api/v1/accountgroup/list")
    Call<ResDt<List<ResGroup>>> requestGroupList();

    // 그룹 조회
    @GET("/api/v1/accountgroup/{id}")
    Call<ResDt<ResGroup>> requestGroupInfo(@Path("id")int id);

    // 그룹 삭제 (state : 0-활성화, 100-비활성화)
    @PUT("/api/v1/accountgroup/{id}")
    Call<Void> deleteGroup(@Path("id")int id, @Body RequestDto requestDto);

    // 프로젝트 등록
    @POST("/api/v1/project")
    Call<Void> createProject(@Body ProjectRequestDto requestDto);

    // 프로젝트 조회
    @GET("/api/v1/project/{id}")
    Call<ResDt<ProjectResponseDto>> requestProjectInfo(@Path("id")int id);

    // 프로젝트 list
    @GET("/api/v1/project/list")
    Call<ResDt<List<ProjectResponseDto>>> requestProjectList();
}
