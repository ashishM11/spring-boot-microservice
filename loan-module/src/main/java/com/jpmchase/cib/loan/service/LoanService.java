package com.jpmchase.cib.loan.service;

import com.jpmchase.cib.loan.dto.LoanRequestDTO;
import com.jpmchase.cib.loan.dto.LoanResponseDTO;
import com.jpmchase.cib.loan.mapper.LoanMapper;
import com.jpmchase.cib.loan.model.Loan;
import com.jpmchase.cib.loan.repository.LoanRepository;
import com.jpmchase.cib.loan.repository.LoanTypeRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanTypeRepository loanTypeRepository;

    private Long getLastLoanId(){
        List<Loan> loans = loanRepository.findAll();
        if(!loans.isEmpty()){
            return  loans.stream().sorted(Comparator.comparingLong(Loan::getLoanId).reversed()).toList().getFirst().getLoanId();
        }
        return 1L;
    }

    public String saveLoanRequest(LoanRequestDTO requestDTO){
        Loan loan = LoanMapper.INSTANCE.fromLoanRequestDTOtoLoan(requestDTO);
        loan.setLoanEndDate(requestDTO.getLoanStartDate().plusMonths(requestDTO.getLoanTenureInMonths()));
        loan.setLoanCreationDT(LocalDateTime.now());
        loan.setLoanType(loanTypeRepository.getReferenceById(requestDTO.getLoanTypeId()));
        loan.setLoanAccountNo("JPMC-LN".concat(StringUtils.leftPad(String.valueOf(getLastLoanId()),4,'0')));

        loanRepository.saveAndFlush(loan);
        return "Loan Request Submitted";
    }

    public LoanResponseDTO findLoanByLoanAccountNo(String loanAccountNo){
        return LoanMapper.INSTANCE.fromLoanToLoanResponseDto(loanRepository.findByLoanAccountNo(loanAccountNo).orElseThrow());
    }

    public List<LoanResponseDTO> getAllLoansByCustId(Long custId){
        return loanRepository
                .findByCustId(custId)
                .stream()
                .map(LoanMapper.INSTANCE::fromLoanToLoanResponseDto)
                .toList();
    }

}
