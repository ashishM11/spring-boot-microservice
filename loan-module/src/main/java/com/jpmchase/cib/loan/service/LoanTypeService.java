package com.jpmchase.cib.loan.service;

import com.jpmchase.cib.loan.dto.LoanResponseDTO;
import com.jpmchase.cib.loan.dto.LoanTypeRequestResponseDTO;
import com.jpmchase.cib.loan.mapper.LoanMapper;
import com.jpmchase.cib.loan.mapper.LoanTypeMapper;
import com.jpmchase.cib.loan.model.LoanType;
import com.jpmchase.cib.loan.repository.LoanRepository;
import com.jpmchase.cib.loan.repository.LoanTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoanTypeService {

    private final LoanTypeRepository loanTypeRepository;
    private final LoanRepository loanRepository;

    public List<LoanTypeRequestResponseDTO> getAllLoanTypeList(){
        return loanTypeRepository
                .findAll()
                .stream()
                .map(LoanTypeMapper.INSTANCE::fromLoanToLoanRequestResponseDto)
                .toList();
    }

    public List<LoanResponseDTO> getAllLoanByLoanType(String loanType){
        Optional<LoanType> byLoanType = loanTypeRepository.findByLoanType(loanType);
        if(byLoanType.isPresent()){
            return loanRepository
                    .findByLoanType(byLoanType.orElseThrow())
                    .stream()
                    .map(LoanMapper.INSTANCE::fromLoanToLoanResponseDto)
                    .toList();
        }
        return null;
    }

}
