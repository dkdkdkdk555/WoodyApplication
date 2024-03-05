package com.example.woodyapplication.net;

import com.google.gson.annotations.SerializedName;

public class TempDto {

    @SerializedName("result")
    private Object result;

    @SerializedName("status")
    private String status;

    @SerializedName("value")
    private String value;

    @Override
    public String toString() {
        return "TempDto{" +
                "result=" + result +
                ", status='" + status + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
