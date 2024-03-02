package com.example.woodyapplication.net;

import com.google.gson.annotations.SerializedName;

public class ResDt {

    @SerializedName("result")
    private ResultT result;

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

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultT getResult() {
        return result;
    }

    public void setResult(ResultT result) {
        this.result = result;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
