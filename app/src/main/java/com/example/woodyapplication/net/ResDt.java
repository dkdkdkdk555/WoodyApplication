package com.example.woodyapplication.net;

import com.google.gson.annotations.SerializedName;

public class ResDt {

    @SerializedName("result")
    private String result;

    @SerializedName("status")
    private String status;

    @SerializedName("value")
    private String value;

    @Override
    public String toString() {
        return "Response{" +
                "result='" + result + '\'' +
                ", status='" + status + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }
}
