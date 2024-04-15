package com.jpmchase.cib.customer.service;

import com.jpmchase.cib.customer.dto.*;
import com.jpmchase.cib.customer.mapper.CustomerMapper;
import com.jpmchase.cib.customer.model.Branch;
import com.jpmchase.cib.customer.model.Customer;
import com.jpmchase.cib.customer.repository.BranchRepository;
import com.jpmchase.cib.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final BranchRepository branchRepository;
    private final RestTemplate restTemplate;

    public CustomerResponseDTO getCustomerById(Long custId) {
        return CustomerMapper.INSTANCE.customerToCustomerResponseDTO(customerRepository.findById(custId).orElseThrow());
    }

    public List<CustomerResponseDTO> getAllCustomers() {
        return CustomerMapper.INSTANCE.fromListOfCustomersToCustomerResponseDTOS(customerRepository.findAll());
    }

    @Transactional
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO requestDTO) {
        Branch branch = branchRepository.findById(requestDTO.getBranchId()).orElseThrow();
        Customer customer = CustomerMapper.INSTANCE.fromCustomerRequestDtoToCustomer(requestDTO);
        customer.setBranch(branch);
        customer.setCustCreationDT(LocalDateTime.now());
        return CustomerMapper.INSTANCE.customerToCustomerResponseDTO(customerRepository.saveAndFlush(customer));
    }



    public CustomerInfoResponseDTO getCustomerAllInfo(Long custId) {
        CustomerInfoResponseDTO customerInfoResponseDTO = new CustomerInfoResponseDTO();
        if(Objects.nonNull(custId)){
            CustomerResponseDTO customerResponseDTO = CustomerMapper.INSTANCE.customerToCustomerResponseDTO(customerRepository.getReferenceById(custId));
            final String ACCOUNT_MODULE_URL = "http://ACCOUNT-MODULE/api/account/customer/"+custId;
            final String LOAN_MODULE_URL = "http://LOAN-MODULE/api/loan/customer/"+custId;
            ResponseEntity<List<AccountResponseDTO>> accountsResponseEntity =restTemplate.exchange(ACCOUNT_MODULE_URL, HttpMethod.GET,null, new ParameterizedTypeReference<>() {
            });
            ResponseEntity<List<LoanResponseDTO>> loansResponseEntity =restTemplate.exchange(LOAN_MODULE_URL, HttpMethod.GET,null, new ParameterizedTypeReference<>() {
            });
            customerInfoResponseDTO.setAccounts(accountsResponseEntity.getBody());
            customerInfoResponseDTO.setLoans(loansResponseEntity.getBody());
            customerInfoResponseDTO.setCustomer(customerResponseDTO);
        }
        return customerInfoResponseDTO;
    }
}
