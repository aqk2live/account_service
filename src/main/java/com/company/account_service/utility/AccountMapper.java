package com.company.account_service.utility;

import com.company.account_service.dto.request.AccountRequestDTO;
import com.company.account_service.dto.request.UpdateAccountRequestDTO;
import com.company.account_service.dto.response.GetAccountResponseDTO;
import com.company.account_service.dto.response.UpdateAccountResponseDTO;
import com.company.account_service.model.Account;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
    GetAccountResponseDTO toGetAccountResponseDTO(Account account);
    Account toAccount(AccountRequestDTO accountRequestDTO);

    UpdateAccountResponseDTO toUpdateAccountResponseDTO(Account account);
    Account toAccount(UpdateAccountRequestDTO updateAccountRequestDTO);


}
