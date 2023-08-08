package com.company.account_service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

// used  for create account (POST service)
@Data
public class AccountRequestDTO {


   // @JsonProperty("name")
    private String userName;
    private String password;
    private String name;
    private String emailId;
    private Integer phoneNumber;

}
/*
     "username": "Abdul123",
  "password": "Pass@123",
  "name": "Abdul",
  "emailid": "abdul@gmail.com",
  "phoneNumber": 104556
     */