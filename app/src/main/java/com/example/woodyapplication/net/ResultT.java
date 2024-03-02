package com.example.woodyapplication.net;

import com.google.gson.annotations.SerializedName;

public class ResultT {
    @SerializedName("token")
    String token;

    @Override
    public String toString() {
        return "ResultT{" +
                "token='" + token + '\'' +
                '}';
    }
}
