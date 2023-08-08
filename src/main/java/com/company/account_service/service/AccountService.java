package com.company.account_service.service;

import com.company.account_service.dto.request.AccountRequestDTO;
import com.company.account_service.dto.request.UpdateAccountRequestDTO;
import com.company.account_service.dto.response.AccountResponseDTO;
import com.company.account_service.dto.response.GetAccountResponseDTO;
import com.company.account_service.dto.response.UpdateAccountResponseDTO;

public interface AccountService {
    AccountResponseDTO saveAccount(AccountRequestDTO accountRequestDTO);
    GetAccountResponseDTO getAccount(Integer accountId);
    UpdateAccountResponseDTO updateAccount(UpdateAccountRequestDTO accountRequestDTO);
    boolean deleteAccount(Integer accountId);
}
