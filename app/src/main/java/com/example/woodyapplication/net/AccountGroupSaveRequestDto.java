package com.example.woodyapplication.net;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AccountGroupSaveRequestDto {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("state")
    private int state;
    @SerializedName("accountDtos")
    private List<AccountDto> accountDtos;
    @SerializedName("projectId")
    private Long projectId;

    public AccountGroupSaveRequestDto() {
    }

    public AccountGroupSaveRequestDto(int id, String name, int state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<AccountDto> getAccountDtos() {
        return accountDtos;
    }

    public void setAccountDtos(List<AccountDto> accountDtos) {
        this.accountDtos = accountDtos;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
