package com.company.account_service.dto.response;

import lombok.Data;

@Data
public class UpdateAccountResponseDTO {

    /*
   "id": 10,
  "name": "Abdul",
  "emailid": "abdul@gmail.com",
  "phoneNumber": 10,
  "photoUrls": "url"
    */
    private Integer Id;
    private String name;
    private String emailId;
    private Integer phoneNumber;
    private String photoUrls;
}
