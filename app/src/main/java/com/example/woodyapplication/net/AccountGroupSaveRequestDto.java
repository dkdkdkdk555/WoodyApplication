package com.example.woodyapplication.net;

import com.google.gson.annotations.SerializedName;

public class AccountGroupSaveRequestDto {
    @SerializedName("name")
    private String name;

    public AccountGroupSaveRequestDto(String name) {
        this.name = name;
    }
}
