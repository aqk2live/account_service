package com.company.account_service.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetAccountResponseDTO {


    private Integer id;
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