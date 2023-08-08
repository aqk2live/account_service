package com.company.account_service.dto.request;

import lombok.Data;
@Data
public class UpdateAccountRequestDTO {

    private Integer Id;
    private String name;
    private String emailId;
    private Integer phoneNumber;
    private String photoUrls;

}

    /*
    "id": 10,
  "name": "Abdul",
  "emailid": "abdul@gmail.com",
  "phoneNumber": 10,
  "photoUrls": "url"
     */