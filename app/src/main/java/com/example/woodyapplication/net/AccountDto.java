package com.example.woodyapplication.net;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.*;

public class AccountDto implements Parcelable {
    /**
     * "accountDtos": [
     *      *         {
     *      *           "id": 5,
     *      *           "createdDate": null,
     *      *           "kind": 1,
     *      *           "state": 0,
     *      *           "email": "rurikim@megabridge.co.kr",
     *      *           "name": "ruri",
     *      *           "phoneNumber": "01011113333",
     *      *           "extraPhoneNumber": "01056781234",
     *      *           "termsAgreed": null,
     *      *           "verify": false,
     *      *           "affiliation": null,
     *      *           "images": null,
     *      *           "accountGroupId": 19
     *      *         }
     *      *       ]
     */

    private int id;
    private Date createDate;
    private int kind;
    private int state;
    private String name;
    private String email;
    private String phoneNumber;
    private String extraPhoneNumber;
    private String termsAgreed;
    private boolean verify;
    private String affiliation;
    private List<Image> images;
    private int accountGroupId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTermsAgreed() {
        return termsAgreed;
    }

    public void setTermsAgreed(String termsAgreed) {
        this.termsAgreed = termsAgreed;
    }

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getAccountGroupId() {
        return accountGroupId;
    }

    public void setAccountGroupId(int accountGroupId) {
        this.accountGroupId = accountGroupId;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", kind=" + kind +
                ", state=" + state +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", extraPhoneNumber='" + extraPhoneNumber + '\'' +
                ", termsAgreed='" + termsAgreed + '\'' +
                ", verify=" + verify +
                ", affiliation='" + affiliation + '\'' +
                ", images=" + images +
                ", accountGroupId=" + accountGroupId +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

    }
}
