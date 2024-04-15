package com.jpmchase.cib.account.service;

import com.jpmchase.cib.account.dto.AccountRequestDTO;
import com.jpmchase.cib.account.dto.AccountResponseDTO;
import com.jpmchase.cib.account.dto.BranchResponseDTO;
import com.jpmchase.cib.account.dto.CustomerResponseDTO;
import com.jpmchase.cib.account.mapper.AccountMapper;
import com.jpmchase.cib.account.mapper.BranchMapper;
import com.jpmchase.cib.account.mapper.CustomerMapper;
import com.jpmchase.cib.account.model.Account;
import com.jpmchase.cib.account.model.Branch;
import com.jpmchase.cib.account.model.Customer;
import com.jpmchase.cib.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final RestTemplate restTemplate;

    private AccountResponseDTO fromAccountEntityToResponseDTO(Account account){
        Long custId = account.getCustId();
        if(Objects.nonNull(custId)){
            AccountResponseDTO accountResponseDTO = AccountMapper.INSTANCE.fromAccountToAccountResponseDto(account);
            CustomerResponseDTO customerResponseDTO;
            BranchResponseDTO branchResponseDTO;
            Customer customer = restTemplate.getForObject("http://CUSTOMER-MODULE/api/customer/" + custId, Customer.class);
            if (Objects.nonNull(customer)) {
                customerResponseDTO = CustomerMapper.INSTANCE.fromCustomerToCustomerResponseDto(customer);
                Branch branch = restTemplate.getForObject("http://CUSTOMER-MODULE/api/branch/customer/" + custId, Branch.class);
                if (Objects.nonNull(branch)) {
                    branchResponseDTO = BranchMapper.INSTANCE.fromBranchToBranchResponseDto(branch);
                    customerResponseDTO.setBranch(branchResponseDTO);
                    accountResponseDTO.setCustomer(customerResponseDTO);
                }
            }
            return accountResponseDTO;
        }else {
            throw new RuntimeException("Customer is Not Found");
        }
    }

    private Long getLastAcctId(){
        List<Account> accounts = accountRepository.findAll(Sort.by(Sort.Direction.DESC, "accountId"));
        if(!accounts.isEmpty()){
            return  accounts.getFirst().getAccountId()+1;
        }
        return  1L;
    }

    @Transactional
    public AccountResponseDTO getAccountByAcctNo(String acctNo) {
        Account account =accountRepository.findByAccountNo(acctNo).orElseThrow();
        return fromAccountEntityToResponseDTO(account);
    }

    public List<AccountResponseDTO> getAllAccounts() {
        return accountRepository.findAll().stream().map(this::fromAccountEntityToResponseDTO).toList();
    }

    public String saveAccount(AccountRequestDTO requestDTO) {
        requestDTO.setAccountNo("JPMC".concat("11").concat(StringUtils.leftPad(String.valueOf(getLastAcctId()),4,'0')));
        requestDTO.setAccountCreationDT(LocalDateTime.now());
        accountRepository.saveAndFlush(AccountMapper.INSTANCE.fromAccountRequestDtoToAccount(requestDTO));
        return "Customer New Account Created Successfully.";
    }

    public List<AccountResponseDTO> getAccountsByCustId(Long custId) {
        return accountRepository
                .findByCustId(custId)
                .stream()
                .map(this::fromAccountEntityToResponseDTO)
                .toList();
    }
}
