package com.example.woodyapplication.net;

import java.util.List;

public class ResGroup {
    /**
     * "id": 19,
     *       "name": "ruri_group",
     *       "state": 0,
     *       "projectId": 3,
     *       "accountDtos": [
     *         {
     *           "id": 5,
     *           "createdDate": null,
     *           "kind": 1,
     *           "state": 0,
     *           "email": "rurikim@megabridge.co.kr",
     *           "name": "ruri",
     *           "phoneNumber": "01011113333",
     *           "extraPhoneNumber": "01056781234",
     *           "termsAgreed": null,
     *           "verify": false,
     *           "affiliation": null,
     *           "images": null,
     *           "accountGroupId": 19
     *         }
     *       ]
     */

    private int id;
    private String name;
    private int projectId;
    private List<AccountDto> accountDtos;

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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public List<AccountDto> getAccountDtos() {
        return accountDtos;
    }

    public void setAccountDtos(List<AccountDto> accountDtos) {
        this.accountDtos = accountDtos;
    }
}
