package com.example.woodyapplication.net;

import java.util.List;

public class ProjectResponseDto {
    private int id;
    private String name;
    private String description;
    private int state;
    private List<ResGroup> accountGroupDtos;

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

    public List<ResGroup> getGroup() {
        return accountGroupDtos;
    }

    public void setGroup(List<ResGroup> group) {
        this.accountGroupDtos = group;
    }
}
