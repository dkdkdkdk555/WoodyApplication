package com.example.woodyapplication.dto;

import com.google.gson.annotations.SerializedName;

public class User {

    int kind;
    String email; // 로그인시 id
    String password; // 비밀번호
    String name;
    String phoneNumber;
    String extraPhoneNumber;
    int accoutGroupId;
    boolean verify;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User(int kind, String email, String password, String name, String phoneNumber, String extraPhoneNumber, int accoutGroupId, boolean verify) {
        this.kind = kind;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.extraPhoneNumber = extraPhoneNumber;
        this.accoutGroupId = accoutGroupId;
        this.verify = verify;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExtraPhoneNumber() {
        return extraPhoneNumber;
    }

    public void setExtraPhoneNumber(String extraPhoneNumber) {
        this.extraPhoneNumber = extraPhoneNumber;
    }

    public int getAccoutGroupId() {
        return accoutGroupId;
    }

    public void setAccoutGroupId(int accoutGroupId) {
        this.accoutGroupId = accoutGroupId;
    }

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }
}
