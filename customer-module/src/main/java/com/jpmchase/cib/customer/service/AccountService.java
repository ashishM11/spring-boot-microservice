package com.jpmchase.cib.customer.service;

import com.jpmchase.cib.customer.dto.AccountResponseDTO;
import com.jpmchase.cib.customer.dto.CustomerInfoResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "accountCircuitBreaker",fallbackMethod = "fallbackForAccountAPI")
    public List<AccountResponseDTO> getAccountResponseDTOS(Long custId){
        final String ACCOUNT_MODULE_URL = "http://ACCOUNT-MODULE/api/account/customer/"+custId;
        ResponseEntity<List<AccountResponseDTO>> accountResponseEntity = restTemplate.exchange(ACCOUNT_MODULE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return accountResponseEntity.getBody();
    }

    public List<String> fallbackForAccountAPI(Exception e) {
       return Collections.singletonList("Oops.. Service not Available for Getting Account Details.");
    }

}
