package com.example.woodyapplication.net;

import java.util.*;

public class AccountDto {
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
    private String email;
    private String phoneNumber;
    private String extraPhoneNumber;
    private String termsAgreed;
    private boolean verify;
    private String affiliation;
    private Object images;
    private int accountGroupId;

    

}
