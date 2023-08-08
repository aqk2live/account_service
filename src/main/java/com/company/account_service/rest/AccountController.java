package com.company.account_service.rest;

import com.company.account_service.dto.request.AccountRequestDTO;
import com.company.account_service.dto.request.UpdateAccountRequestDTO;
import com.company.account_service.dto.response.AccountResponseDTO;
import com.company.account_service.dto.response.GetAccountResponseDTO;
import com.company.account_service.dto.response.UpdateAccountResponseDTO;
import com.company.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/accounts")
//@AllArgsConstructor
public class AccountController {

    @Autowired
    private AccountService accountService;

    //post
    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO accountRequestDTO){
        //DTO Field validation
        AccountResponseDTO responseDTO = accountService.saveAccount(accountRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    //put
    /*@PutMapping
    public ResponseEntity<UpdateAccountResponseDTO> updateAccount(@RequestBody UpdateAccountRequestDTO upadateAccountRequestDTO){

        UpdateAccountResponseDTO responseDTO = accountService.updateAccount(upadateAccountRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }*/
    //patch
    @PatchMapping
    public ResponseEntity<UpdateAccountResponseDTO> updateAccount(@RequestBody UpdateAccountRequestDTO updateAccountRequestDTO){
        UpdateAccountResponseDTO responseDTO = accountService.updateAccount(updateAccountRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //get
    @GetMapping(value = "/{accountId}")
    public ResponseEntity<GetAccountResponseDTO> getAccount(@PathVariable Integer accountId){
        GetAccountResponseDTO responseDTO = accountService.getAccount(accountId);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //delete
    @DeleteMapping(value = "/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable Integer accountId){

       // GetAccountResponseDTO responseDTO = accountService.getAccount(accountId);
        boolean accountDeleted = accountService.deleteAccount(accountId);
        if(accountDeleted){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
