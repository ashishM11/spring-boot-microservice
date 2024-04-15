package com.jpmchase.cib.account.mapper;

import com.jpmchase.cib.account.dto.AccountRequestDTO;
import com.jpmchase.cib.account.dto.AccountResponseDTO;
import com.jpmchase.cib.account.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountResponseDTO fromAccountToAccountResponseDto(Account account);

    List<AccountResponseDTO> fromAccountListToAccountResponseDtos(List<Account> accounts);

    Account fromAccountRequestDtoToAccount(AccountRequestDTO accountRequestDTO);

}
