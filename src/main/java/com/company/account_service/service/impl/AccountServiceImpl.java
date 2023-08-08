package com.company.account_service.service.impl;

import com.company.account_service.dto.request.AccountRequestDTO;
import com.company.account_service.dto.request.UpdateAccountRequestDTO;
import com.company.account_service.dto.response.AccountResponseDTO;
import com.company.account_service.dto.response.GetAccountResponseDTO;
import com.company.account_service.dto.response.UpdateAccountResponseDTO;
import com.company.account_service.model.Account;
import com.company.account_service.respository.AccountRepository;
import com.company.account_service.service.AccountService;
import com.company.account_service.utility.AccountMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public AccountResponseDTO saveAccount(AccountRequestDTO accountRequestDTO) {
  /*      Account account = Account.builder()
                .name(accountRequestDTO.getName())
                .emailId(accountRequestDTO.getEmailId())
                .phoneNumber(accountRequestDTO.getPhoneNumber())
                .userName(accountRequestDTO.getUserName())
                .password(accountRequestDTO.getPassword())
                .build();*/
        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);
        Account account = mapper.toAccount(accountRequestDTO);

        //Map struct :  dto to entity
        Account savedAccount = accountRepository.saveAndFlush(account);
         if (savedAccount != null){
             return AccountResponseDTO.builder()
                     .userId(savedAccount.getId())
                     .build();
         }
        return null;
    }

    @Override
    public GetAccountResponseDTO getAccount(Integer accountId) {
        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);
        try {
            Account account =  accountRepository.getReferenceById(accountId);
            return mapper.toGetAccountResponseDTO(account);
        } catch (EntityNotFoundException e){
            log.error("Exception: " + e);
        }
        return null;
    }

    @Override
    public UpdateAccountResponseDTO updateAccount(UpdateAccountRequestDTO updateAccountRequestDTO) {

        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);
        //Account account = mapper.toAccount(updateAccountRequestDTO);
        Account account = accountRepository.getReferenceById(updateAccountRequestDTO.getId());
        if(null == account){
            return null;
        }
        if(StringUtils.hasText(updateAccountRequestDTO.getName())){
            account.setName(updateAccountRequestDTO.getName());
        } if (StringUtils.hasText(updateAccountRequestDTO.getEmailId())) {
            account.setEmailId(updateAccountRequestDTO.getEmailId());
        } if (null != updateAccountRequestDTO.getPhoneNumber()) {
            account.setPhoneNumber(updateAccountRequestDTO.getPhoneNumber());
        }

        Account updatedAccount = accountRepository.saveAndFlush(account);

        try {
            return mapper.toUpdateAccountResponseDTO(updatedAccount);
        } catch (EntityNotFoundException e){
            log.error("Exception: " + e);
        }
        return null;
    }



    @Override
    public boolean deleteAccount(Integer accountId) {

        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);


            Boolean accountExist = accountRepository.existsById(accountId);
            if(accountExist) {
                accountRepository.deleteById(accountId);
                return true;
            }

                return false;


    }
}
