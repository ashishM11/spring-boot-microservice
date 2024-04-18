package com.jpmchase.cib.customer.service;

import com.jpmchase.cib.customer.dto.CustomerInfoResponseDTO;
import com.jpmchase.cib.customer.dto.LoanResponseDTO;
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
public class LoanService {

    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "loanCircuitBreaker",fallbackMethod = "fallbackForLoanAPI")
    public List<LoanResponseDTO> getLoanResponseDTOS(Long custId){
        final String LOAN_MODULE_URL = "http://LOAN-MODULE/api/loan/customer/"+custId;
        ResponseEntity<List<LoanResponseDTO>> loanResponseEntity = restTemplate.exchange(LOAN_MODULE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return loanResponseEntity.getBody();
    }

    public List<String> fallbackForLoanAPI(Exception e){
        return Collections.singletonList("Oops.. Service not Available for Getting Loan Details.");
    }

}
