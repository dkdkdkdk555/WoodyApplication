package com.example.woodyapplication.net;

import com.google.gson.annotations.SerializedName;

public class ProjectRequestDto {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description; // 프로젝트 설명

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
